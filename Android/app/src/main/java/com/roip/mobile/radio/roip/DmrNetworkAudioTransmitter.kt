package com.roip.mobile.radio.roip

import android.annotation.SuppressLint
import android.media.AudioFormat
import android.media.AudioRecord
import android.media.MediaRecorder
import android.os.Process
import android.util.Log
import java.io.IOException
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicLong
import kotlin.concurrent.thread
import kotlin.math.abs
import kotlin.math.max

internal class DmrNetworkAudioTransmitter(
    private val encoder: DmrAmbeEncoder = NativeDmrAmbeEncoder()
) {
    private val running = AtomicBoolean(false)
    private val recordedPcmFrames = AtomicLong(0)
    private val encodedAmbeFrames = AtomicLong(0)
    private val sentVoiceFrames = AtomicLong(0)

    @Volatile
    private var workerThread: Thread? = null

    @Volatile
    private var audioRecord: AudioRecord? = null

    @Volatile
    private var lastError: String? = null

    @Volatile
    private var lastPeak: Int = 0

    fun reset() {
        recordedPcmFrames.set(0)
        encodedAmbeFrames.set(0)
        sentVoiceFrames.set(0)
        lastPeak = 0
        lastError = null
        encoder.reset()
    }

    fun start(
        onVoiceFrame: (voiceFrameIndex: Int, ambeFrames: List<ByteArray>, snapshot: DmrTransmitAudioSnapshot) -> Unit,
        onStopped: (DmrTransmitAudioSnapshot) -> Unit
    ) {
        if (!encoder.isAvailable) {
            lastError = "${encoder.name} encoder is not packaged"
            throw IllegalStateException(lastError)
        }
        if (running.getAndSet(true)) {
            return
        }

        workerThread = thread(
            start = true,
            isDaemon = true,
            name = "DMR-Network-TX-Audio"
        ) {
            runTransmitLoop(onVoiceFrame, onStopped)
        }
    }

    fun stop() {
        if (!running.getAndSet(false)) {
            return
        }
        runCatching {
            audioRecord?.stop()
        }
        runCatching {
            workerThread
                ?.takeIf { it != Thread.currentThread() }
                ?.join(650)
        }
        runCatching {
            audioRecord?.release()
        }
        audioRecord = null
        workerThread = null
    }

    fun snapshot(): DmrTransmitAudioSnapshot {
        return DmrTransmitAudioSnapshot(
            encoderName = encoder.name,
            encoderAvailable = encoder.isAvailable,
            running = running.get(),
            recordedPcmFrames = recordedPcmFrames.get(),
            encodedAmbeFrames = encodedAmbeFrames.get(),
            sentVoiceFrames = sentVoiceFrames.get(),
            lastPeak = lastPeak,
            lastError = lastError
        )
    }

    fun markVoiceFrameSent(): DmrTransmitAudioSnapshot {
        sentVoiceFrames.incrementAndGet()
        return snapshot()
    }

    private fun runTransmitLoop(
        onVoiceFrame: (voiceFrameIndex: Int, ambeFrames: List<ByteArray>, snapshot: DmrTransmitAudioSnapshot) -> Unit,
        onStopped: (DmrTransmitAudioSnapshot) -> Unit
    ) {
        Process.setThreadPriority(Process.THREAD_PRIORITY_URGENT_AUDIO)
        val record = runCatching { createAudioRecord() }.getOrElse { error ->
            lastError = error.message ?: "AudioRecord initialization failed"
            Log.w(TAG, "DMR network transmit audio could not start", error)
            running.set(false)
            onStopped(snapshot())
            return
        }
        audioRecord = record

        try {
            val pcmFrame = ShortArray(PCM_SAMPLES_PER_AMBE)
            val ambeFrames = ArrayList<ByteArray>(AMBE_PER_DMR_VOICE_FRAME)
            var voiceFrameIndex = 0

            record.startRecording()
            if (record.recordingState != AudioRecord.RECORDSTATE_RECORDING) {
                throw IOException("AudioRecord could not start")
            }

            while (running.get()) {
                fillPcmFrame(record, pcmFrame)
                lastPeak = pcmFrame.peak()
                recordedPcmFrames.incrementAndGet()
                val ambe = encoder.encode2450x1150(pcmFrame)
                if (ambe == null || ambe.size != AMBE_FRAME_BYTES) {
                    lastError = "AMBE encode returned ${ambe?.size ?: 0} bytes"
                    continue
                }

                encodedAmbeFrames.incrementAndGet()
                ambeFrames.add(ambe)
                if (ambeFrames.size == AMBE_PER_DMR_VOICE_FRAME) {
                    onVoiceFrame(voiceFrameIndex, ambeFrames.map { it.copyOf() }, snapshot())
                    ambeFrames.clear()
                    voiceFrameIndex += 1
                }
            }
        } catch (error: Exception) {
            if (running.get()) {
                lastError = error.message ?: error.javaClass.simpleName
                Log.w(TAG, "DMR network transmit audio stopped", error)
            }
        } finally {
            running.set(false)
            runCatching {
                record.stop()
            }
            runCatching {
                record.release()
            }
            audioRecord = null
            onStopped(snapshot())
        }
    }

    private fun fillPcmFrame(record: AudioRecord, pcmFrame: ShortArray) {
        var offset = 0
        while (running.get() && offset < pcmFrame.size) {
            val count = record.read(
                pcmFrame,
                offset,
                pcmFrame.size - offset,
                AudioRecord.READ_BLOCKING
            )
            if (count > 0) {
                offset += count
            } else {
                throw IOException("AudioRecord read returned $count")
            }
        }
    }

    @SuppressLint("MissingPermission")
    private fun createAudioRecord(): AudioRecord {
        val minBuffer = AudioRecord.getMinBufferSize(
            SAMPLE_RATE_HZ,
            AudioFormat.CHANNEL_IN_MONO,
            AudioFormat.ENCODING_PCM_16BIT
        )
        val bufferBytes = max(minBuffer.takeIf { it > 0 } ?: 0, TX_BUFFER_BYTES)
        val audioFormat = AudioFormat.Builder()
            .setSampleRate(SAMPLE_RATE_HZ)
            .setEncoding(AudioFormat.ENCODING_PCM_16BIT)
            .setChannelMask(AudioFormat.CHANNEL_IN_MONO)
            .build()

        val record = runCatching {
            AudioRecord.Builder()
                .setAudioSource(MediaRecorder.AudioSource.UNPROCESSED)
                .setAudioFormat(audioFormat)
                .setBufferSizeInBytes(bufferBytes)
                .build()
        }.getOrElse {
            AudioRecord.Builder()
                .setAudioSource(MediaRecorder.AudioSource.MIC)
                .setAudioFormat(audioFormat)
                .setBufferSizeInBytes(bufferBytes)
                .build()
        }

        if (record.state != AudioRecord.STATE_INITIALIZED) {
            runCatching {
                record.release()
            }
            throw IOException("AudioRecord initialization failed")
        }
        return record
    }

    private fun ShortArray.peak(): Int {
        var peak = 0
        forEach { sample ->
            peak = max(peak, abs(sample.toInt()))
        }
        return peak
    }

    private companion object {
        private const val TAG = "DmrTxAudio"
        private const val SAMPLE_RATE_HZ = 8_000
        private const val PCM_SAMPLES_PER_AMBE = 160
        private const val AMBE_FRAME_BYTES = 9
        private const val AMBE_PER_DMR_VOICE_FRAME = 3
        private const val TX_BUFFER_BYTES = PCM_SAMPLES_PER_AMBE * 2 * 12
    }
}

internal data class DmrTransmitAudioSnapshot(
    val encoderName: String,
    val encoderAvailable: Boolean,
    val running: Boolean,
    val recordedPcmFrames: Long,
    val encodedAmbeFrames: Long,
    val sentVoiceFrames: Long,
    val lastPeak: Int,
    val lastError: String?
) {
    fun status(): String {
        return when {
            running -> "TX audio: $sentVoiceFrames DMR voice frames, peak $lastPeak"
            encoderAvailable -> "AMBE TX encoder ready"
            else -> "$encoderName encoder is not packaged"
        }
    }
}

internal interface DmrAmbeEncoder {
    val name: String
    val isAvailable: Boolean
    fun encode2450x1150(pcm: ShortArray): ByteArray?
    fun reset()
}

internal class NativeDmrAmbeEncoder : DmrAmbeEncoder {
    override val name: String = "OpenRadio mbelib AMBE"
    override val isAvailable: Boolean
        get() = nativeAvailable

    override fun encode2450x1150(pcm: ShortArray): ByteArray? {
        if (!nativeAvailable || pcm.size != PCM_SAMPLES_PER_AMBE) {
            return null
        }
        return runCatching { nativeEncode2450x1150(pcm) }
            .onFailure { error -> Log.w(TAG, "Native AMBE encode failed", error) }
            .getOrNull()
    }

    override fun reset() {
        if (nativeAvailable) {
            runCatching { nativeResetEncoder() }
        }
    }

    private external fun nativeEncode2450x1150(pcm: ShortArray): ByteArray
    private external fun nativeResetEncoder()

    private companion object {
        private const val TAG = "DmrTxAudio"
        private const val PCM_SAMPLES_PER_AMBE = 160

        private val nativeAvailable = runCatching {
            System.loadLibrary("openradio_mbe")
            Log.i(TAG, "Native AMBE encoder loaded")
        }.onFailure { error ->
            Log.i(TAG, "Native AMBE encoder unavailable: ${error.message}")
        }.isSuccess
    }
}
