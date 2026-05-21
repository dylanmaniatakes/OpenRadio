package com.roip.mobile.radio.roip

import android.media.AudioAttributes
import android.media.AudioFormat
import android.media.AudioTrack
import android.os.Process
import android.util.Log
import java.io.IOException
import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicLong
import kotlin.concurrent.thread
import kotlin.math.abs
import kotlin.math.max

internal class DmrNetworkAudioPlayer(
    private val decoder: DmrAmbeDecoder = NativeDmrAmbeDecoder()
) {
    private val running = AtomicBoolean(false)
    private val receivedAmbeFrames = AtomicLong(0)
    private val decodedPcmFrames = AtomicLong(0)
    private val droppedAmbeFrames = AtomicLong(0)
    private val queue = ArrayBlockingQueue<ByteArray>(QUEUE_DEPTH)

    @Volatile
    private var workerThread: Thread? = null

    @Volatile
    private var audioTrack: AudioTrack? = null

    @Volatile
    private var lastError: String? = null

    fun reset() {
        queue.clear()
        receivedAmbeFrames.set(0)
        decodedPcmFrames.set(0)
        droppedAmbeFrames.set(0)
        lastError = null
        decoder.reset()
    }

    fun stop() {
        if (!running.getAndSet(false)) {
            return
        }

        queue.clear()
        runCatching {
            workerThread?.join(400)
        }
        runCatching {
            audioTrack?.pause()
        }
        runCatching {
            audioTrack?.flush()
        }
        runCatching {
            audioTrack?.release()
        }
        workerThread = null
        audioTrack = null
    }

    fun enqueue(ambeFrames: List<ByteArray>) {
        if (ambeFrames.isEmpty()) {
            return
        }

        receivedAmbeFrames.addAndGet(ambeFrames.size.toLong())
        if (!decoder.isAvailable) {
            lastError = "${decoder.name} is not packaged"
            return
        }

        start()
        ambeFrames.forEach { frame ->
            if (frame.size != AMBE_FRAME_BYTES) {
                droppedAmbeFrames.incrementAndGet()
                return@forEach
            }
            if (!queue.offer(frame.copyOf())) {
                queue.poll()
                droppedAmbeFrames.incrementAndGet()
                queue.offer(frame.copyOf())
            }
        }
    }

    fun snapshot(): DmrAudioSnapshot {
        return DmrAudioSnapshot(
            decoderName = decoder.name,
            decoderAvailable = decoder.isAvailable,
            receivedAmbeFrames = receivedAmbeFrames.get(),
            decodedPcmFrames = decodedPcmFrames.get(),
            droppedAmbeFrames = droppedAmbeFrames.get(),
            queuedAmbeFrames = queue.size,
            playing = running.get(),
            lastError = lastError
        )
    }

    private fun start() {
        if (running.getAndSet(true)) {
            return
        }

        workerThread = thread(
            start = true,
            isDaemon = true,
            name = "DMR-Network-Audio"
        ) {
            runPlaybackLoop()
        }
    }

    private fun runPlaybackLoop() {
        Process.setThreadPriority(Process.THREAD_PRIORITY_URGENT_AUDIO)
        val track = runCatching { createAudioTrack() }.getOrElse { error ->
            lastError = error.message ?: "AudioTrack initialization failed"
            Log.w(TAG, "DMR network audio could not start", error)
            running.set(false)
            return
        }
        audioTrack = track

        var primedFrames = 0
        try {
            while (running.get()) {
                val ambe = queue.poll(RX_IDLE_TIMEOUT_MS, TimeUnit.MILLISECONDS)
                if (ambe == null) {
                    if (track.playState == AudioTrack.PLAYSTATE_PLAYING) {
                        runCatching { track.pause() }
                        runCatching { track.flush() }
                        primedFrames = 0
                    }
                    continue
                }
                val pcm = decoder.decode2450x1150(ambe)
                if (pcm == null || pcm.isEmpty()) {
                    droppedAmbeFrames.incrementAndGet()
                    continue
                }

                val written = track.write(pcm, 0, pcm.size, AudioTrack.WRITE_BLOCKING)
                if (written < 0) {
                    lastError = "AudioTrack write returned $written"
                    Log.w(TAG, "AudioTrack write returned $written")
                    continue
                }
                if (track.playState != AudioTrack.PLAYSTATE_PLAYING) {
                    primedFrames += 1
                    if (primedFrames >= RX_PREFILL_PCM_FRAMES) {
                        track.play()
                    }
                }

                val decoded = decodedPcmFrames.incrementAndGet()
                if (decoded <= 5L || decoded % LOG_FRAME_INTERVAL == 0L) {
                    Log.i(TAG, "DMR network PCM frames=$decoded peak=${pcm.peak()} queued=${queue.size}")
                }
            }
        } catch (error: Exception) {
            if (running.get()) {
                lastError = error.message ?: error.javaClass.simpleName
                Log.w(TAG, "DMR network playback loop stopped", error)
            }
        } finally {
            running.set(false)
            runCatching {
                track.pause()
            }
            runCatching {
                track.flush()
            }
            runCatching {
                track.release()
            }
            audioTrack = null
        }
    }

    private fun createAudioTrack(): AudioTrack {
        val minBuffer = AudioTrack.getMinBufferSize(
            SAMPLE_RATE_HZ,
            AudioFormat.CHANNEL_OUT_MONO,
            AudioFormat.ENCODING_PCM_16BIT
        )
        val bufferSize = max(minBuffer.takeIf { it > 0 } ?: 0, RX_BUFFER_BYTES)
        val track = AudioTrack.Builder()
            .setAudioAttributes(
                AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
                    .build()
            )
            .setAudioFormat(
                AudioFormat.Builder()
                    .setSampleRate(SAMPLE_RATE_HZ)
                    .setEncoding(AudioFormat.ENCODING_PCM_16BIT)
                    .setChannelMask(AudioFormat.CHANNEL_OUT_MONO)
                    .build()
            )
            .setBufferSizeInBytes(bufferSize)
            .setTransferMode(AudioTrack.MODE_STREAM)
            .build()

        if (track.state != AudioTrack.STATE_INITIALIZED) {
            runCatching {
                track.release()
            }
            throw IOException("AudioTrack initialization failed")
        }
        return track
    }

    private fun ShortArray.peak(): Int {
        var peak = 0
        forEach { sample ->
            peak = max(peak, abs(sample.toInt()))
        }
        return peak
    }

    private companion object {
        private const val TAG = "DmrAudio"
        private const val SAMPLE_RATE_HZ = 8_000
        private const val AMBE_FRAME_BYTES = 9
        private const val QUEUE_DEPTH = 180
        private const val RX_BUFFER_BYTES = 24_000
        private const val RX_PREFILL_PCM_FRAMES = 4
        private const val RX_IDLE_TIMEOUT_MS = 180L
        private const val LOG_FRAME_INTERVAL = 100L
    }
}

internal data class DmrAudioSnapshot(
    val decoderName: String,
    val decoderAvailable: Boolean,
    val receivedAmbeFrames: Long,
    val decodedPcmFrames: Long,
    val droppedAmbeFrames: Long,
    val queuedAmbeFrames: Int,
    val playing: Boolean,
    val lastError: String?
) {
    fun status(lastBurstAmbeFrames: Int): String {
        return when {
            decoderAvailable && decodedPcmFrames > 0L -> {
                "Playing DMR audio: $decodedPcmFrames PCM frames decoded, $queuedAmbeFrames AMBE queued"
            }

            decoderAvailable -> {
                "AMBE decoder ready; queued $queuedAmbeFrames blocks from last $lastBurstAmbeFrames-block burst"
            }

            receivedAmbeFrames > 0L -> {
                "AMBE $lastBurstAmbeFrames blocks received; ${decoderName} native library is not packaged yet"
            }

            else -> "Waiting for AMBE voice payload"
        }
    }
}

internal interface DmrAmbeDecoder {
    val name: String
    val isAvailable: Boolean
    fun decode2450x1150(ambe: ByteArray): ShortArray?
    fun reset()
}

internal class NativeDmrAmbeDecoder : DmrAmbeDecoder {
    override val name: String = "OpenRadio mbelib AMBE"
    override val isAvailable: Boolean
        get() = nativeAvailable

    override fun decode2450x1150(ambe: ByteArray): ShortArray? {
        if (!nativeAvailable || ambe.size != AMBE_FRAME_BYTES) {
            return null
        }
        return runCatching { nativeDecode2450x1150(ambe) }
            .onFailure { error -> Log.w(TAG, "Native AMBE decode failed", error) }
            .getOrNull()
    }

    override fun reset() {
        if (nativeAvailable) {
            runCatching { nativeReset() }
        }
    }

    private external fun nativeDecode2450x1150(ambe: ByteArray): ShortArray
    private external fun nativeReset()

    private companion object {
        private const val TAG = "DmrAudio"
        private const val AMBE_FRAME_BYTES = 9

        private val nativeAvailable = runCatching {
            System.loadLibrary("openradio_mbe")
            Log.i(TAG, "Native AMBE vocoder loaded")
        }.onFailure { error ->
            Log.i(TAG, "Native AMBE vocoder unavailable: ${error.message}")
        }.isSuccess
    }
}
