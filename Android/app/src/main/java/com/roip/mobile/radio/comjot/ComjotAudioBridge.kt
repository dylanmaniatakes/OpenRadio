package com.roip.mobile.radio.comjot

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.media.AudioAttributes
import android.media.AudioFormat
import android.media.AudioRecord
import android.media.AudioTrack
import android.media.MediaRecorder
import android.os.Process
import android.os.SystemClock
import android.util.Log
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicLong
import kotlin.concurrent.thread
import kotlin.math.max
import kotlin.math.min

class ComjotAudioBridge(
    private val voiceSerialPath: String = DEFAULT_VOICE_SERIAL_PATH
) {
    private val configureLock = Any()
    private val receiveRunning = AtomicBoolean(false)
    private val transmitRunning = AtomicBoolean(false)
    private val receivedFrames = AtomicLong(0)
    private val transmittedFrames = AtomicLong(0)

    @Volatile
    private var voiceSerialConfigured = false

    @Volatile
    private var receiveThread: Thread? = null

    @Volatile
    private var transmitThread: Thread? = null

    @Volatile
    private var recordThread: Thread? = null

    @Volatile
    private var receiveInput: FileInputStream? = null

    @Volatile
    private var transmitOutput: FileOutputStream? = null

    @Volatile
    private var audioTrack: AudioTrack? = null

    @Volatile
    private var audioRecord: AudioRecord? = null

    @Volatile
    private var receivePcmSink: ((ShortArray) -> Unit)? = null

    @Volatile
    private var transmitPcmSink: ((ShortArray) -> Unit)? = null

    private val transmitQueue = ArrayBlockingQueue<ByteArray>(TX_QUEUE_DEPTH)
    private val pendingReceiveBytes = ByteArray(RECEIVE_SCAN_BUFFER_BYTES)
    private var pendingReceiveSize = 0

    fun startReceiveIfAvailable(): Boolean {
        val voiceSerial = File(voiceSerialPath)
        if (!voiceSerial.exists() || !voiceSerial.canRead()) {
            return false
        }
        if (receiveRunning.get()) {
            return true
        }

        configureVoiceSerial()
        receivePcmSink = null
        audioTrack = createAudioTrack()
        receivedFrames.set(0)
        receiveRunning.set(true)
        Log.i(TAG, "CJ-1 RX audio started on $voiceSerialPath")
        receiveThread = thread(
            start = true,
            isDaemon = true,
            name = "CJ1-RX-Audio"
        ) {
            runReceiveLoop()
        }
        return true
    }

    fun startReceiveBridge(
        onPcm: (ShortArray) -> Unit,
        playLocalMonitor: Boolean = true
    ): Boolean {
        val voiceSerial = File(voiceSerialPath)
        if (!voiceSerial.exists() || !voiceSerial.canRead()) {
            return false
        }
        if (receiveRunning.get()) {
            receivePcmSink = onPcm
            if (playLocalMonitor && audioTrack == null) {
                audioTrack = createAudioTrack()
            } else if (!playLocalMonitor) {
                releaseAudioTrack()
            }
            return true
        }

        configureVoiceSerial()
        receivePcmSink = onPcm
        audioTrack = if (playLocalMonitor) createAudioTrack() else null
        receivedFrames.set(0)
        receiveRunning.set(true)
        Log.i(TAG, "CJ-1 RF bridge RX audio started on $voiceSerialPath")
        receiveThread = thread(
            start = true,
            isDaemon = true,
            name = "CJ1-RF-Bridge-RX"
        ) {
            runReceiveLoop()
        }
        return true
    }

    fun startTransmit(
        context: Context,
        onPcm: ((ShortArray) -> Unit)? = null
    ) {
        if (transmitRunning.get()) {
            transmitPcmSink = onPcm
            return
        }
        if (context.checkSelfPermission(Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            throw IOException("microphone permission is required for CJ-1 transmit audio")
        }

        val voiceSerial = File(voiceSerialPath)
        if (!voiceSerial.exists() || !voiceSerial.canWrite()) {
            throw IOException("$voiceSerialPath is not writable")
        }

        configureVoiceSerial()
        val record = createAudioRecord()
        val output = FileOutputStream(voiceSerial)
        audioRecord = record
        transmitOutput = output
        transmitPcmSink = onPcm
        transmittedFrames.set(0)
        transmitQueue.clear()
        repeat(TX_PREFILL_FRAMES) {
            transmitQueue.offer(ByteArray(TX_FRAME_SIZE))
        }
        transmitRunning.set(true)

        try {
            record.startRecording()
        } catch (error: Exception) {
            transmitRunning.set(false)
            runCatching {
                record.release()
            }
            runCatching {
                output.close()
            }
            audioRecord = null
            transmitOutput = null
            throw IOException("AudioRecord could not start", error)
        }

        recordThread = thread(
            start = true,
            isDaemon = true,
            name = "CJ1-TX-Record"
        ) {
            runRecordLoop(record)
        }
        transmitThread = thread(
            start = true,
            isDaemon = true,
            name = "CJ1-TX-Audio"
        ) {
            runTransmitLoop(output)
        }
        Log.i(TAG, "CJ-1 TX audio started on $voiceSerialPath")
    }

    fun startExternalTransmit() {
        if (transmitRunning.get()) {
            return
        }

        val voiceSerial = File(voiceSerialPath)
        if (!voiceSerial.exists() || !voiceSerial.canWrite()) {
            throw IOException("$voiceSerialPath is not writable")
        }

        configureVoiceSerial()
        val output = FileOutputStream(voiceSerial)
        transmitOutput = output
        transmittedFrames.set(0)
        transmitQueue.clear()
        repeat(TX_PREFILL_FRAMES) {
            transmitQueue.offer(ByteArray(TX_FRAME_SIZE))
        }
        transmitRunning.set(true)
        transmitThread = thread(
            start = true,
            isDaemon = true,
            name = "CJ1-RF-Bridge-TX"
        ) {
            runTransmitLoop(output)
        }
        Log.i(TAG, "CJ-1 RF bridge TX audio started on $voiceSerialPath")
    }

    fun enqueueExternalPcm(pcm: ShortArray) {
        if (!transmitRunning.get() || pcm.isEmpty()) {
            return
        }
        var offset = 0
        while (offset < pcm.size) {
            val samples = min(TX_FRAME_SIZE / 2, pcm.size - offset)
            val frame = ByteArray(TX_FRAME_SIZE)
            for (index in 0 until samples) {
                val sample = pcm[offset + index].toInt()
                val byteOffset = index * 2
                frame[byteOffset] = (sample and 0xff).toByte()
                frame[byteOffset + 1] = ((sample ushr 8) and 0xff).toByte()
            }
            offerTransmitFrame(frame)
            offset += samples
        }
    }

    fun stopTransmit() {
        val wasRunning = transmitRunning.getAndSet(false)
        if (!wasRunning && audioRecord == null && transmitOutput == null) {
            return
        }

        runCatching {
            audioRecord?.stop()
        }
        runCatching {
            recordThread?.join(300)
        }
        runCatching {
            transmitOutput?.flush()
        }
        runCatching {
            transmitOutput?.close()
        }
        runCatching {
            audioRecord?.release()
        }
        runCatching {
            transmitThread?.join(300)
        }

        transmitOutput = null
        audioRecord = null
        transmitPcmSink = null
        recordThread = null
        transmitThread = null
        transmitQueue.clear()
        Log.i(TAG, "CJ-1 TX audio stopped after ${transmittedFrames.get()} frames")
    }

    fun shutdown() {
        stopTransmit()
        stopReceive()
    }

    private fun stopReceive() {
        if (!receiveRunning.getAndSet(false)) {
            return
        }

        runCatching {
            receiveInput?.close()
        }
        releaseAudioTrack()
        runCatching {
            receiveThread?.join(300)
        }

        pendingReceiveSize = 0
        receiveInput = null
        audioTrack = null
        receiveThread = null
        receivePcmSink = null
        Log.i(TAG, "CJ-1 RX audio stopped after ${receivedFrames.get()} frames")
    }

    private fun releaseAudioTrack() {
        runCatching {
            audioTrack?.pause()
        }
        runCatching {
            audioTrack?.flush()
        }
        runCatching {
            audioTrack?.release()
        }
        audioTrack = null
    }

    private fun runReceiveLoop() {
        try {
            FileInputStream(voiceSerialPath).use { input ->
                receiveInput = input
                val buffer = ByteArray(640)
                while (receiveRunning.get()) {
                    val count = input.read(buffer)
                    if (count > 0) {
                        processReceiveBytes(buffer, count)
                    }
                }
            }
        } catch (error: Exception) {
            if (receiveRunning.get()) {
                Log.w(TAG, "CJ-1 RX audio loop stopped", error)
            }
        } finally {
            receiveRunning.set(false)
            receiveInput = null
        }
    }

    private fun runRecordLoop(record: AudioRecord) {
        Process.setThreadPriority(Process.THREAD_PRIORITY_URGENT_AUDIO)
        val frame = ByteArray(TX_FRAME_SIZE)
        var offset = 0
        try {
            while (transmitRunning.get()) {
                val count = record.read(frame, offset, frame.size - offset, AudioRecord.READ_BLOCKING)
                when {
                    count > 0 -> {
                        offset += count
                        if (offset == frame.size) {
                            val audioFrame = frame.copyOf()
                            offerTransmitFrame(audioFrame)
                            transmitPcmSink?.invoke(audioFrame.toShortArrayLe())
                            offset = 0
                        }
                    }

                    count < 0 -> {
                        Log.w(TAG, "AudioRecord read returned $count")
                    }
                }
            }
        } catch (error: Exception) {
            if (transmitRunning.get()) {
                Log.w(TAG, "CJ-1 TX recorder loop stopped", error)
            }
        }
    }

    private fun runTransmitLoop(output: FileOutputStream) {
        Process.setThreadPriority(Process.THREAD_PRIORITY_URGENT_AUDIO)
        var nextFrameAt = SystemClock.elapsedRealtimeNanos()
        try {
            while (transmitRunning.get()) {
                val now = SystemClock.elapsedRealtimeNanos()
                if (now < nextFrameAt) {
                    val sleepMs = (nextFrameAt - now) / NANOS_PER_MILLI
                    if (sleepMs > 0) {
                        Thread.sleep(sleepMs)
                    } else {
                        Thread.yield()
                    }
                    continue
                }

                val frame = transmitQueue.poll() ?: ByteArray(TX_FRAME_SIZE)
                output.write(frame)
                output.flush()
                noteTransmitFrame()
                nextFrameAt += TX_FRAME_INTERVAL_NANOS

                val lateBy = SystemClock.elapsedRealtimeNanos() - nextFrameAt
                if (lateBy > TX_FRAME_INTERVAL_NANOS) {
                    nextFrameAt = SystemClock.elapsedRealtimeNanos() + TX_FRAME_INTERVAL_NANOS
                }
            }
        } catch (error: Exception) {
            if (transmitRunning.get()) {
                Log.w(TAG, "CJ-1 TX serial loop stopped", error)
            }
        } finally {
            transmitRunning.set(false)
        }
    }

    private fun offerTransmitFrame(frame: ByteArray) {
        if (transmitQueue.offer(frame)) {
            return
        }
        transmitQueue.poll()
        transmitQueue.offer(frame)
    }

    private fun noteTransmitFrame() {
        val frameCount = transmittedFrames.incrementAndGet()
        if (frameCount % LOG_FRAME_INTERVAL == 0L) {
            Log.d(TAG, "CJ-1 TX audio frames=$frameCount")
        }
    }

    private fun processReceiveBytes(buffer: ByteArray, count: Int) {
        appendReceiveBytes(buffer, count)

        while (pendingReceiveSize >= VOICE_HEADER_SIZE) {
            val headerOffset = findVoiceHeaderOffset()
            if (headerOffset < 0) {
                keepPossibleHeaderSuffix()
                return
            }

            if (headerOffset > 0) {
                dropReceiveBytes(headerOffset)
            }

            if (pendingReceiveSize < VOICE_FRAME_SIZE) {
                return
            }

            if (isValidVoiceFrame(pendingReceiveBytes)) {
                extractAudio(pendingReceiveBytes)?.let { audio ->
                    val amplified = amplifyPcm16Le(audio)
                    receivePcmSink?.invoke(amplified.toShortArrayLe())
                    val track = audioTrack
                    if (track != null) {
                        writeReceiveAudio(track, amplified)
                    } else {
                        noteReceiveFrame()
                    }
                }
                dropReceiveBytes(VOICE_FRAME_SIZE)
            } else {
                dropReceiveBytes(1)
            }
        }
    }

    private fun noteReceiveFrame() {
        val frameCount = receivedFrames.incrementAndGet()
        if (frameCount <= 5L || frameCount % LOG_FRAME_INTERVAL == 0L) {
            Log.d(TAG, "CJ-1 RX bridge audio frames=$frameCount")
        }
    }

    private fun extractAudio(frame: ByteArray): ByteArray? {
        if (
            (frame[0].toInt() and 0xFF) != VOICE_FRAME_HEAD ||
            frame[1] != 0.toByte() ||
            frame[2] != 0.toByte() ||
            frame[VOICE_FRAME_SIZE - 1] != VOICE_FRAME_TAIL.toByte()
        ) {
            return null
        }

        val declaredLength = frame[3].toInt() and 0xFF
        if (declaredLength <= 0) {
            return null
        }

        val audioLength = min(declaredLength, VOICE_AUDIO_BYTES)
        val audio = frame.copyOfRange(VOICE_AUDIO_OFFSET, VOICE_AUDIO_OFFSET + audioLength)
        return audio.takeUnless { bytes -> bytes.all { it == 0.toByte() } }
    }

    private fun appendReceiveBytes(buffer: ByteArray, count: Int) {
        var incomingOffset = 0
        var incomingCount = count
        if (incomingCount >= pendingReceiveBytes.size) {
            incomingOffset = incomingCount - (pendingReceiveBytes.size - VOICE_HEADER_SIZE)
            incomingCount -= incomingOffset
            pendingReceiveSize = 0
        } else if (pendingReceiveSize + incomingCount > pendingReceiveBytes.size) {
            val overflow = pendingReceiveSize + incomingCount - pendingReceiveBytes.size
            dropReceiveBytes(overflow)
        }

        buffer.copyInto(
            destination = pendingReceiveBytes,
            destinationOffset = pendingReceiveSize,
            startIndex = incomingOffset,
            endIndex = incomingOffset + incomingCount
        )
        pendingReceiveSize += incomingCount
    }

    private fun findVoiceHeaderOffset(): Int {
        var offset = 0
        while (offset <= pendingReceiveSize - VOICE_HEADER_SIZE) {
            if (
                (pendingReceiveBytes[offset].toInt() and 0xFF) == VOICE_FRAME_HEAD &&
                pendingReceiveBytes[offset + 1] == 0.toByte() &&
                pendingReceiveBytes[offset + 2] == 0.toByte()
            ) {
                return offset
            }
            offset++
        }
        return -1
    }

    private fun keepPossibleHeaderSuffix() {
        val keep = when {
            pendingReceiveSize >= 2 &&
                (pendingReceiveBytes[pendingReceiveSize - 2].toInt() and 0xFF) == VOICE_FRAME_HEAD &&
                pendingReceiveBytes[pendingReceiveSize - 1] == 0.toByte() -> 2

            pendingReceiveSize >= 1 &&
                (pendingReceiveBytes[pendingReceiveSize - 1].toInt() and 0xFF) == VOICE_FRAME_HEAD -> 1

            else -> 0
        }

        if (keep > 0) {
            pendingReceiveBytes.copyInto(
                destination = pendingReceiveBytes,
                startIndex = pendingReceiveSize - keep,
                endIndex = pendingReceiveSize
            )
        }
        pendingReceiveSize = keep
    }

    private fun dropReceiveBytes(count: Int) {
        if (count <= 0) {
            return
        }
        if (count >= pendingReceiveSize) {
            pendingReceiveSize = 0
            return
        }

        pendingReceiveBytes.copyInto(
            destination = pendingReceiveBytes,
            startIndex = count,
            endIndex = pendingReceiveSize
        )
        pendingReceiveSize -= count
    }

    private fun isValidVoiceFrame(frame: ByteArray): Boolean {
        val declaredLength = frame[3].toInt() and 0xFF
        return (frame[0].toInt() and 0xFF) == VOICE_FRAME_HEAD &&
            frame[1] == 0.toByte() &&
            frame[2] == 0.toByte() &&
            declaredLength in 1..VOICE_AUDIO_BYTES &&
            frame[VOICE_FRAME_SIZE - 1] == VOICE_FRAME_TAIL.toByte()
    }

    private fun writeReceiveAudio(track: AudioTrack, audio: ByteArray) {
        if (track.playState != AudioTrack.PLAYSTATE_PLAYING) {
            track.play()
        }

        val written = track.write(audio, 0, audio.size, AudioTrack.WRITE_BLOCKING)
        if (written < 0) {
            Log.w(TAG, "AudioTrack write returned $written")
            return
        }

        val frameCount = receivedFrames.incrementAndGet()
        if (frameCount <= 5L || frameCount % LOG_FRAME_INTERVAL == 0L) {
            Log.d(TAG, "CJ-1 RX audio frames=$frameCount")
        }
    }

    private fun amplifyPcm16Le(audio: ByteArray): ByteArray {
        val output = ByteArray(audio.size - (audio.size % 2))
        var index = 0
        while (index < output.size) {
            val sample = ((audio[index + 1].toInt() shl 8) or (audio[index].toInt() and 0xFF)).toShort()
            val amplified = (sample * RX_GAIN).toInt().coerceIn(Short.MIN_VALUE.toInt(), Short.MAX_VALUE.toInt())
            output[index] = (amplified and 0xFF).toByte()
            output[index + 1] = ((amplified ushr 8) and 0xFF).toByte()
            index += 2
        }
        return output
    }

    private fun ByteArray.toShortArrayLe(): ShortArray {
        val samples = ShortArray(size / 2)
        var index = 0
        while (index < samples.size) {
            val byteOffset = index * 2
            samples[index] = (((this[byteOffset + 1].toInt() shl 8) or (this[byteOffset].toInt() and 0xff))).toShort()
            index += 1
        }
        return samples
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

    private fun createAudioRecord(): AudioRecord {
        val minBuffer = AudioRecord.getMinBufferSize(
            SAMPLE_RATE_HZ,
            AudioFormat.CHANNEL_IN_MONO,
            AudioFormat.ENCODING_PCM_16BIT
        )
        val bufferSize = max((minBuffer.takeIf { it > 0 } ?: TX_FRAME_SIZE) * 4, TX_BUFFER_BYTES)
        val audioFormat = AudioFormat.Builder()
            .setSampleRate(SAMPLE_RATE_HZ)
            .setEncoding(AudioFormat.ENCODING_PCM_16BIT)
            .setChannelMask(AudioFormat.CHANNEL_IN_MONO)
            .build()
        val record = runCatching {
            AudioRecord.Builder()
                .setAudioSource(MediaRecorder.AudioSource.UNPROCESSED)
                .setAudioFormat(audioFormat)
                .setBufferSizeInBytes(bufferSize)
                .build()
        }.getOrElse { error ->
            Log.w(TAG, "UNPROCESSED microphone source failed, falling back to MIC", error)
            AudioRecord.Builder()
                .setAudioSource(MediaRecorder.AudioSource.MIC)
                .setAudioFormat(audioFormat)
                .setBufferSizeInBytes(bufferSize)
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

    private fun configureVoiceSerial() {
        synchronized(configureLock) {
            if (voiceSerialConfigured) {
                return
            }

            val sttyPath = INTERNAL_STTY_PATHS.firstOrNull { File(it).canExecute() } ?: "stty"
            val process = ProcessBuilder(
                sttyPath,
                "-F",
                voiceSerialPath,
                VOICE_SERIAL_BAUD.toString(),
                "cs8",
                "-cstopb",
                "-parenb",
                "-ixon",
                "-ixoff",
                "raw",
                "-echo"
            )
                .redirectErrorStream(true)
                .start()

            if (!process.waitFor(800, TimeUnit.MILLISECONDS)) {
                process.destroy()
                throw IOException("stty timed out for $voiceSerialPath")
            }

            val output = process.inputStream.bufferedReader().use { it.readText() }.trim()
            if (process.exitValue() != 0) {
                val details = output.ifBlank { "exit ${process.exitValue()}" }
                throw IOException("stty failed for $voiceSerialPath: $details")
            }
            voiceSerialConfigured = true
            Log.i(TAG, "Configured CJ-1 voice serial $voiceSerialPath at $VOICE_SERIAL_BAUD")
        }
    }

    companion object {
        private const val TAG = "ComjotAudio"
        private const val DEFAULT_VOICE_SERIAL_PATH = "/dev/ttyS0"
        private const val VOICE_SERIAL_BAUD = 230_400
        private const val SAMPLE_RATE_HZ = 8_000
        private const val TX_FRAME_SIZE = 160
        private const val TX_QUEUE_DEPTH = 8
        private const val TX_PREFILL_FRAMES = 3
        private const val TX_FRAME_INTERVAL_NANOS = 10_000_000L
        private const val NANOS_PER_MILLI = 1_000_000L
        private const val TX_BUFFER_BYTES = 640
        private const val RX_BUFFER_BYTES = 5_120
        private const val VOICE_FRAME_HEAD = 0xBB
        private const val VOICE_FRAME_TAIL = 0x44
        private const val VOICE_HEADER_SIZE = 3
        private const val VOICE_FRAME_SIZE = 167
        private const val VOICE_AUDIO_OFFSET = 6
        private const val VOICE_AUDIO_BYTES = 160
        private const val RECEIVE_SCAN_BUFFER_BYTES = VOICE_FRAME_SIZE * 8
        private const val RX_GAIN = 2.5f
        private const val LOG_FRAME_INTERVAL = 100L

        private val INTERNAL_STTY_PATHS = listOf(
            "/system/bin/stty",
            "/vendor/bin/stty"
        )
    }
}
