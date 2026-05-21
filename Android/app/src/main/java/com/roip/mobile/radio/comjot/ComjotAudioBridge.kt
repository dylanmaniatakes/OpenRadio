package com.roip.mobile.radio.comjot

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.media.AudioAttributes
import android.media.AudioFormat
import android.media.AudioFocusRequest
import android.media.AudioManager
import android.media.AudioRecord
import android.media.AudioTrack
import android.media.MediaRecorder
import android.os.PowerManager
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
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

enum class ComjotTransmitAudioFormat(
    val frameBytes: Int,
    val intervalNanos: Long,
    val label: String
) {
    DIGITAL_10MS(frameBytes = 160, intervalNanos = 10_000_000L, label = "160B/10ms")
}

class ComjotAudioBridge(
    private val voiceSerialPath: String = DEFAULT_VOICE_SERIAL_PATH
) {
    private val configureLock = Any()
    private val receiveRunning = AtomicBoolean(false)
    private val transmitRunning = AtomicBoolean(false)
    private val receivedFrames = AtomicLong(0)
    private val transmittedFrames = AtomicLong(0)
    private val recordedMicFrames = AtomicLong(0)
    private val transmitUnderruns = AtomicLong(0)
    private val rawReceiveReads = AtomicLong(0)
    private val rawReceiveBytes = AtomicLong(0)
    private val receivePlaybackUnderruns = AtomicLong(0)
    private val receiveAudioQueue = ArrayBlockingQueue<ByteArray>(RX_QUEUE_DEPTH)
    private val receivePlaybackRunning = AtomicBoolean(false)

    @Volatile
    private var voiceSerialConfigured = false

    @Volatile
    private var receiveThread: Thread? = null

    @Volatile
    private var receivePlaybackThread: Thread? = null

    @Volatile
    private var transmitThread: Thread? = null

    @Volatile
    private var recordThread: Thread? = null

    @Volatile
    private var receiveInput: FileInputStream? = null

    @Volatile
    private var transmitOutput: FileOutputStream? = null

    @Volatile
    private var receiveSerial: ComjotNativeSerial? = null

    @Volatile
    private var transmitSerial: ComjotNativeSerial? = null

    @Volatile
    private var audioTrack: AudioTrack? = null

    @Volatile
    private var audioRecord: AudioRecord? = null

    @Volatile
    private var transmitAudioManager: AudioManager? = null

    @Volatile
    private var transmitFocusRequest: AudioFocusRequest? = null

    @Volatile
    private var transmitWakeLock: PowerManager.WakeLock? = null

    @Volatile
    private var transmitStartedAtNanos = 0L

    @Volatile
    private var activeTransmitFrameBytes = ComjotTransmitAudioFormat.DIGITAL_10MS.frameBytes

    @Volatile
    private var activeTransmitSourceLabel = "unknown"

    @Volatile
    private var activeTransmitInputGain = 1.0f

    private var transmitHighPassPreviousInput = 0f
    private var transmitHighPassPreviousOutput = 0f

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

        val nativeSerial = openVoiceSerialSession("RX")
        val input = if (nativeSerial == null) FileInputStream(voiceSerial) else null
        receiveSerial = nativeSerial
        receiveInput = input
        receivePcmSink = null
        audioTrack = createAudioTrack().also { startReceivePlayback(it) }
        receivedFrames.set(0)
        rawReceiveReads.set(0)
        rawReceiveBytes.set(0)
        receiveRunning.set(true)
        Log.i(TAG, "CJ-1 RX audio started on $voiceSerialPath")
        receiveThread = thread(
            start = true,
            isDaemon = true,
            name = "CJ1-RX-Audio"
        ) {
            runReceiveLoop(nativeSerial, input)
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
                audioTrack = createAudioTrack().also { startReceivePlayback(it) }
            } else if (!playLocalMonitor) {
                releaseAudioTrack()
            }
            return true
        }

        val nativeSerial = openVoiceSerialSession("RX bridge")
        val input = if (nativeSerial == null) FileInputStream(voiceSerial) else null
        receiveSerial = nativeSerial
        receiveInput = input
        receivePcmSink = onPcm
        audioTrack = if (playLocalMonitor) {
            createAudioTrack().also { startReceivePlayback(it) }
        } else {
            null
        }
        receivedFrames.set(0)
        rawReceiveReads.set(0)
        rawReceiveBytes.set(0)
        receiveRunning.set(true)
        Log.i(TAG, "CJ-1 RF bridge RX audio started on $voiceSerialPath")
        receiveThread = thread(
            start = true,
            isDaemon = true,
            name = "CJ1-RF-Bridge-RX"
        ) {
            runReceiveLoop(nativeSerial, input)
        }
        return true
    }

    fun startTransmit(
        context: Context,
        onPcm: ((ShortArray) -> Unit)? = null,
        audioFormat: ComjotTransmitAudioFormat = ComjotTransmitAudioFormat.DIGITAL_10MS
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

        stopReceiveForTransmit()
        val nativeSerial = openVoiceSerialSession("TX")
        val output = if (nativeSerial == null) FileOutputStream(voiceSerial) else null
        transmitSerial = nativeSerial
        transmitOutput = output
        transmitPcmSink = onPcm
        transmittedFrames.set(0)
        recordedMicFrames.set(0)
        transmitUnderruns.set(0)
        transmitStartedAtNanos = 0L
        activeTransmitFrameBytes = audioFormat.frameBytes
        activeTransmitSourceLabel = "unknown"
        activeTransmitInputGain = 1.0f
        resetTransmitConditioner()
        transmitQueue.clear()
        repeat(TX_PREFILL_FRAMES) {
            transmitQueue.offer(ByteArray(audioFormat.frameBytes))
        }
        acquireTransmitWakeLock(context)

        val record = try {
            createStartedAudioRecord(context, audioFormat.frameBytes)
        } catch (error: Exception) {
            runCatching {
                output?.close()
            }
            runCatching {
                nativeSerial?.close()
            }
            transmitSerial = null
            transmitOutput = null
            transmitPcmSink = null
            transmitQueue.clear()
            releaseTransmitWakeLock()
            throw error
        }
        audioRecord = record
        transmitStartedAtNanos = SystemClock.elapsedRealtimeNanos()
        transmitRunning.set(true)

        recordThread = thread(
            start = true,
            isDaemon = true,
            name = "CJ1-TX-Recorder"
        ) {
            runRecordLoop(record, audioFormat.frameBytes)
        }

        transmitThread = thread(
            start = true,
            isDaemon = true,
            name = "CJ1-TX-Serial"
        ) {
            runTransmitLoop(nativeSerial, output, audioFormat)
        }
        Log.i(TAG, "CJ-1 TX audio started on $voiceSerialPath using ${audioFormat.label}")
    }

    fun startExternalTransmit(
        audioFormat: ComjotTransmitAudioFormat = ComjotTransmitAudioFormat.DIGITAL_10MS
    ) {
        if (transmitRunning.get()) {
            return
        }

        val voiceSerial = File(voiceSerialPath)
        if (!voiceSerial.exists() || !voiceSerial.canWrite()) {
            throw IOException("$voiceSerialPath is not writable")
        }

        stopReceiveForTransmit()
        val nativeSerial = openVoiceSerialSession("RF bridge TX")
        val output = if (nativeSerial == null) FileOutputStream(voiceSerial) else null
        transmitSerial = nativeSerial
        transmitOutput = output
        transmittedFrames.set(0)
        transmitUnderruns.set(0)
        activeTransmitFrameBytes = audioFormat.frameBytes
        transmitQueue.clear()
        repeat(TX_PREFILL_FRAMES) {
            transmitQueue.offer(ByteArray(audioFormat.frameBytes))
        }
        transmitRunning.set(true)
        transmitThread = thread(
            start = true,
            isDaemon = true,
            name = "CJ1-RF-Bridge-TX"
        ) {
            runTransmitLoop(nativeSerial, output, audioFormat)
        }
        Log.i(TAG, "CJ-1 RF bridge TX audio started on $voiceSerialPath using ${audioFormat.label}")
    }

    fun enqueueExternalPcm(pcm: ShortArray) {
        if (!transmitRunning.get() || pcm.isEmpty()) {
            return
        }
        var offset = 0
        while (offset < pcm.size) {
            val frameBytes = activeTransmitFrameBytes
            val samples = min(frameBytes / 2, pcm.size - offset)
            val frame = ByteArray(frameBytes)
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
            transmitSerial?.close()
        }
        abandonTransmitAudioFocus()
        releaseTransmitWakeLock()
        runCatching {
            audioRecord?.release()
        }
        runCatching {
            transmitThread?.join(300)
        }

        transmitOutput = null
        transmitSerial = null
        audioRecord = null
        transmitPcmSink = null
        recordThread = null
        transmitThread = null
        transmitQueue.clear()
        val durationSeconds = ((SystemClock.elapsedRealtimeNanos() - transmitStartedAtNanos).coerceAtLeast(1L)) /
            1_000_000_000.0
        val frames = transmittedFrames.get()
        Log.i(
            TAG,
            "CJ-1 TX audio stopped after $frames frames " +
                "fps=${"%.1f".format(frames / durationSeconds)}"
        )
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
        runCatching {
            receiveSerial?.close()
        }
        releaseAudioTrack()
        runCatching {
            receiveThread?.join(300)
        }

        pendingReceiveSize = 0
        receiveInput = null
        receiveSerial = null
        receiveThread = null
        receivePcmSink = null
        audioTrack = null
        Log.i(TAG, "CJ-1 RX audio stopped after ${receivedFrames.get()} frames")
    }

    private fun stopReceiveForTransmit() {
        if (!receiveRunning.get()) {
            return
        }
        Log.i(TAG, "Pausing CJ-1 RX audio while TX owns $voiceSerialPath")
        stopReceive()
    }

    private fun releaseAudioTrack() {
        val track = audioTrack
        receivePlaybackRunning.set(false)
        receiveAudioQueue.clear()
        runCatching {
            track?.pause()
        }
        runCatching {
            track?.flush()
        }
        runCatching {
            receivePlaybackThread?.takeIf { it != Thread.currentThread() }?.join(300)
        }
        runCatching {
            track?.release()
        }
        audioTrack = null
        receivePlaybackThread = null
    }

    private fun startReceivePlayback(track: AudioTrack) {
        receiveAudioQueue.clear()
        receivePlaybackUnderruns.set(0)
        if (receivePlaybackRunning.getAndSet(true)) {
            return
        }
        receivePlaybackThread = thread(
            start = true,
            isDaemon = true,
            name = "CJ1-RX-Playback"
        ) {
            runReceivePlaybackLoop(track)
        }
    }

    private fun runReceivePlaybackLoop(track: AudioTrack) {
        Thread.currentThread().priority = Thread.MAX_PRIORITY
        Process.setThreadPriority(Process.THREAD_PRIORITY_URGENT_AUDIO)
        var started = false
        var idlePolls = 0
        try {
            while (receivePlaybackRunning.get()) {
                val audio = receiveAudioQueue.poll(RX_PLAYBACK_POLL_MS, TimeUnit.MILLISECONDS)
                if (audio == null) {
                    if (started) {
                        noteReceivePlaybackUnderrun()
                        if (idlePolls < RX_SILENCE_FILL_FRAMES) {
                            writeReceiveAudioFrame(track, ByteArray(VOICE_AUDIO_BYTES))
                            idlePolls += 1
                        } else {
                            runCatching { track.pause() }
                            runCatching { track.flush() }
                            started = false
                            idlePolls = 0
                        }
                    }
                    continue
                }

                if (!started) {
                    val prebuffer = ArrayList<ByteArray>(RX_PREFILL_FRAMES + 1)
                    prebuffer.add(audio)
                    val deadline = SystemClock.elapsedRealtime() + RX_PREFILL_TIMEOUT_MS
                    while (prebuffer.size < RX_PREFILL_FRAMES && SystemClock.elapsedRealtime() < deadline) {
                        val remainingMs = (deadline - SystemClock.elapsedRealtime()).coerceAtLeast(1L)
                        receiveAudioQueue.poll(min(remainingMs, RX_PLAYBACK_POLL_MS), TimeUnit.MILLISECONDS)
                            ?.let { prebuffer.add(it) }
                    }
                    prebuffer.forEach { writeReceiveAudioFrame(track, it) }
                    track.play()
                    started = true
                    idlePolls = 0
                } else {
                    writeReceiveAudioFrame(track, audio)
                    idlePolls = 0
                }
            }
        } catch (error: Exception) {
            if (receivePlaybackRunning.get()) {
                Log.w(TAG, "CJ-1 RX playback loop stopped", error)
            }
        } finally {
            receivePlaybackRunning.set(false)
        }
    }

    private fun runReceiveLoop(
        nativeSerial: ComjotNativeSerial?,
        fallbackInput: FileInputStream?
    ) {
        try {
            if (nativeSerial != null) {
                while (receiveRunning.get()) {
                    val data = nativeSerial.readAvailable(RECEIVE_READ_BYTES)
                    if (data.isNotEmpty()) {
                        noteRawReceive(data.size)
                        processReceiveBytes(data, data.size)
                    } else {
                        Thread.sleep(VOICE_READ_IDLE_MS)
                    }
                }
            } else {
                (fallbackInput ?: FileInputStream(voiceSerialPath)).use { input ->
                    receiveInput = input
                    val buffer = ByteArray(RECEIVE_READ_BYTES)
                    while (receiveRunning.get()) {
                        val count = input.read(buffer)
                        if (count > 0) {
                            noteRawReceive(count)
                            processReceiveBytes(buffer, count)
                        }
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

    private fun runRecordLoop(record: AudioRecord, frameBytes: Int) {
        Thread.currentThread().priority = Thread.MAX_PRIORITY
        Process.setThreadPriority(Process.THREAD_PRIORITY_URGENT_AUDIO)
        val frame = ByteArray(frameBytes)
        var offset = 0
        try {
            while (transmitRunning.get()) {
                val count = record.read(frame, offset, frame.size - offset, AudioRecord.READ_BLOCKING)
                when {
                    count > 0 -> {
                        offset += count
                        if (offset == frame.size) {
                            val rawFrame = frame.copyOf()
                            val audioFrame = conditionTransmitFrame(rawFrame)
                            noteTransmitMicFrame(rawFrame, audioFrame)
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

    private fun runTransmitLoop(
        nativeSerial: ComjotNativeSerial?,
        output: FileOutputStream?,
        audioFormat: ComjotTransmitAudioFormat
    ) {
        Thread.currentThread().priority = Thread.MAX_PRIORITY
        Process.setThreadPriority(Process.THREAD_PRIORITY_URGENT_AUDIO)
        val intervalMs = (audioFormat.intervalNanos / NANOS_PER_MILLI).coerceAtLeast(1L)
        var lastFrameAt = SystemClock.elapsedRealtime()
        var nextFrameAt = lastFrameAt
        var consecutiveEmptyFrames = 0
        try {
            while (transmitRunning.get()) {
                val now = SystemClock.elapsedRealtime()
                if (now - lastFrameAt > TX_TIMING_GAP_RESET_MS) {
                    Log.d(TAG, "CJ-1 TX large timing gap=${now - lastFrameAt}ms; resetting cadence")
                    nextFrameAt = now
                }

                val waitMs = nextFrameAt - now
                if (waitMs > 0L) {
                    if (waitMs > 1L) {
                        Thread.sleep(waitMs - 1L)
                    }
                    while (SystemClock.elapsedRealtime() < nextFrameAt && transmitRunning.get()) {
                        Thread.yield()
                    }
                }

                val targetForNextFrame = SystemClock.elapsedRealtime() + intervalMs
                val frame = transmitQueue.poll()
                if (frame != null) {
                    writeTransmitFrame(nativeSerial, output, frame)
                    noteTransmitFrame()
                    lastFrameAt = SystemClock.elapsedRealtime()
                    nextFrameAt = targetForNextFrame
                    consecutiveEmptyFrames = 0
                } else {
                    consecutiveEmptyFrames++
                    noteTransmitUnderrun()
                    if (consecutiveEmptyFrames > TX_EMPTY_SILENCE_THRESHOLD) {
                        writeTransmitFrame(nativeSerial, output, ByteArray(audioFormat.frameBytes))
                        noteTransmitFrame()
                        lastFrameAt = SystemClock.elapsedRealtime()
                        consecutiveEmptyFrames = 0
                    }
                    nextFrameAt = SystemClock.elapsedRealtime() + TX_EMPTY_RETRY_DELAY_MS
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

    private fun acquireTransmitWakeLock(context: Context) {
        val existing = transmitWakeLock
        if (existing?.isHeld == true) {
            return
        }

        val powerManager = context.applicationContext.getSystemService(Context.POWER_SERVICE) as? PowerManager
            ?: return
        transmitWakeLock = powerManager.newWakeLock(
            PowerManager.PARTIAL_WAKE_LOCK,
            "OpenRadio:CJ1Tx"
        ).apply {
            setReferenceCounted(false)
            acquire(TX_WAKE_LOCK_TIMEOUT_MS)
        }
    }

    private fun releaseTransmitWakeLock() {
        val wakeLock = transmitWakeLock
        transmitWakeLock = null
        if (wakeLock?.isHeld == true) {
            runCatching {
                wakeLock.release()
            }
        }
    }

    private fun writeTransmitFrame(
        nativeSerial: ComjotNativeSerial?,
        output: FileOutputStream?,
        frame: ByteArray
    ) {
        if (nativeSerial != null) {
            val written = nativeSerial.write(frame, drain = false)
            if (written != frame.size) {
                throw IOException("Expected to write ${frame.size} voice bytes, wrote $written")
            }
            return
        }

        val fallbackOutput = output ?: throw IOException("voice output stream is not open")
        fallbackOutput.write(frame)
        fallbackOutput.flush()
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
            Log.d(
                TAG,
                "CJ-1 TX audio frames=$frameCount underruns=${transmitUnderruns.get()} " +
                    "queue=${transmitQueue.size}"
            )
        }
    }

    private fun noteTransmitUnderrun() {
        val underruns = transmitUnderruns.incrementAndGet()
        if (underruns <= 5L || underruns % UNDERRUN_LOG_INTERVAL == 0L) {
            Log.w(TAG, "CJ-1 TX underrun; sent silence frame count=$underruns")
        }
    }

    private fun resetTransmitConditioner() {
        transmitHighPassPreviousInput = 0f
        transmitHighPassPreviousOutput = 0f
    }

    private fun conditionTransmitFrame(frame: ByteArray): ByteArray {
        val output = ByteArray(frame.size - (frame.size % 2))
        var index = 0
        while (index < output.size) {
            val sample = ((frame[index + 1].toInt() shl 8) or (frame[index].toInt() and 0xFF)).toShort().toInt()
            val scaledInput = sample * activeTransmitInputGain
            val highPassed = scaledInput -
                transmitHighPassPreviousInput +
                (TX_HIGH_PASS_COEFFICIENT * transmitHighPassPreviousOutput)
            transmitHighPassPreviousInput = scaledInput
            transmitHighPassPreviousOutput = highPassed

            val conditioned = softLimitTransmitSample(highPassed * TX_OUTPUT_GAIN)
            output[index] = (conditioned and 0xFF).toByte()
            output[index + 1] = ((conditioned ushr 8) and 0xFF).toByte()
            index += 2
        }
        return output
    }

    private fun softLimitTransmitSample(sample: Float): Int {
        val polarity = if (sample < 0f) -1 else 1
        val magnitude = abs(sample)
        val limited = if (magnitude <= TX_SOFT_LIMIT_THRESHOLD) {
            magnitude
        } else {
            TX_SOFT_LIMIT_THRESHOLD +
                ((magnitude - TX_SOFT_LIMIT_THRESHOLD) * TX_SOFT_LIMIT_RATIO)
        }
        return (min(limited, TX_SOFT_LIMIT_CEILING) * polarity)
            .toInt()
            .coerceIn(Short.MIN_VALUE.toInt(), Short.MAX_VALUE.toInt())
    }

    private fun noteTransmitMicFrame(rawFrame: ByteArray, conditionedFrame: ByteArray) {
        val rawPeak = pcmPeak(rawFrame)
        val txPeak = pcmPeak(conditionedFrame)
        val frameCount = recordedMicFrames.incrementAndGet()
        if (frameCount <= 5L || frameCount % MIC_LOG_INTERVAL == 0L) {
            Log.i(
                TAG,
                "CJ-1 TX mic frames=$frameCount rawPeak=$rawPeak txPeak=$txPeak " +
                    "source=$activeTransmitSourceLabel gain=${"%.2f".format(activeTransmitInputGain)} " +
                    "queue=${transmitQueue.size}"
            )
        }
    }

    private fun pcmPeak(frame: ByteArray, count: Int = frame.size): Int {
        var index = 0
        var peak = 0
        val limit = min(count, frame.size)
        while (index < limit - 1) {
            val sample = ((frame[index + 1].toInt() shl 8) or (frame[index].toInt() and 0xFF)).toShort().toInt()
            peak = max(peak, abs(sample))
            index += 2
        }
        return peak
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
                        enqueueReceiveAudio(amplified)
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

    private fun noteRawReceive(count: Int) {
        val reads = rawReceiveReads.incrementAndGet()
        val bytes = rawReceiveBytes.addAndGet(count.toLong())
        if (reads <= 5L || reads % RAW_LOG_INTERVAL == 0L) {
            Log.d(TAG, "CJ-1 RX raw read bytes=$count totalBytes=$bytes")
        }
    }

    private fun noteReceivePlaybackUnderrun() {
        val underruns = receivePlaybackUnderruns.incrementAndGet()
        if (underruns <= 5L || underruns % RX_UNDERRUN_LOG_INTERVAL == 0L) {
            Log.w(TAG, "CJ-1 RX playback underrun count=$underruns queued=${receiveAudioQueue.size}")
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

    private fun enqueueReceiveAudio(audio: ByteArray) {
        if (receiveAudioQueue.offer(audio.copyOf())) {
            return
        }
        receiveAudioQueue.poll()
        receiveAudioQueue.offer(audio.copyOf())
    }

    private fun writeReceiveAudioFrame(track: AudioTrack, audio: ByteArray) {
        val written = track.write(audio, 0, audio.size, AudioTrack.WRITE_BLOCKING)
        if (written < 0) {
            Log.w(TAG, "AudioTrack write returned $written")
            return
        }

        val frameCount = receivedFrames.incrementAndGet()
        if (frameCount <= 5L || frameCount % LOG_FRAME_INTERVAL == 0L) {
            Log.d(TAG, "CJ-1 RX audio frames=$frameCount queued=${receiveAudioQueue.size}")
        }
    }

    private fun amplifyPcm16Le(audio: ByteArray): ByteArray {
        val output = ByteArray(audio.size - (audio.size % 2))
        var index = 0
        while (index < output.size) {
            val sample = ((audio[index + 1].toInt() shl 8) or (audio[index].toInt() and 0xFF)).toShort()
            val amplified = softLimitReceiveSample(sample * RX_GAIN)
            output[index] = (amplified and 0xFF).toByte()
            output[index + 1] = ((amplified ushr 8) and 0xFF).toByte()
            index += 2
        }
        return output
    }

    private fun softLimitReceiveSample(sample: Float): Int {
        val polarity = if (sample < 0f) -1 else 1
        val magnitude = abs(sample)
        val limited = if (magnitude <= RX_SOFT_LIMIT_THRESHOLD) {
            magnitude
        } else {
            RX_SOFT_LIMIT_THRESHOLD +
                ((magnitude - RX_SOFT_LIMIT_THRESHOLD) * RX_SOFT_LIMIT_RATIO)
        }
        return (min(limited, RX_SOFT_LIMIT_CEILING) * polarity)
            .toInt()
            .coerceIn(Short.MIN_VALUE.toInt(), Short.MAX_VALUE.toInt())
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

    private fun createStartedAudioRecord(context: Context, frameBytes: Int): AudioRecord {
        val minBuffer = AudioRecord.getMinBufferSize(
            SAMPLE_RATE_HZ,
            AudioFormat.CHANNEL_IN_MONO,
            AudioFormat.ENCODING_PCM_16BIT
        )
        val bufferSize = max((minBuffer.takeIf { it > 0 } ?: frameBytes) * 4, max(TX_BUFFER_BYTES, frameBytes * 4))
        val audioFormat = AudioFormat.Builder()
            .setSampleRate(SAMPLE_RATE_HZ)
            .setEncoding(AudioFormat.ENCODING_PCM_16BIT)
            .setChannelMask(AudioFormat.CHANNEL_IN_MONO)
            .build()
        var lastError: Throwable? = null
        var bestLowSignalCandidate: AudioSourceCandidate? = null
        var bestLowSignalPeak = -1
        for (candidate in AUDIO_SOURCES) {
            val record = createAudioRecord(candidate, audioFormat, bufferSize)
                ?: continue

            try {
                requestTransmitAudioFocus(context)
                record.startRecording()
                if (record.recordingState == AudioRecord.RECORDSTATE_RECORDING) {
                    val probePeak = probeAudioRecordPeak(record, frameBytes)
                    Log.i(TAG, "CJ-1 TX microphone source probe: ${candidate.label} peak=$probePeak")
                    if (
                        candidate.acceptQuietSignal ||
                        probePeak >= TX_SOURCE_MIN_PEAK
                    ) {
                        activeTransmitSourceLabel = candidate.label
                        activeTransmitInputGain = candidate.inputGain
                        Log.i(TAG, "CJ-1 TX microphone source active: ${candidate.label}")
                        return record
                    }
                    if (probePeak > bestLowSignalPeak) {
                        bestLowSignalPeak = probePeak
                        bestLowSignalCandidate = candidate
                    }
                    throw IOException(
                        "AudioRecord source ${candidate.label} probe peak $probePeak below " +
                            TX_SOURCE_MIN_PEAK.toInt()
                    )
                }

                throw IOException(
                    "AudioRecord source ${candidate.label} did not enter recording state " +
                        "(${record.recordingState})"
                )
            } catch (error: Exception) {
                lastError = error
                Log.w(TAG, "CJ-1 TX microphone source ${candidate.label} failed to start", error)
                abandonTransmitAudioFocus()
                runCatching {
                    record.release()
                }
            }
        }

        bestLowSignalCandidate?.let { candidate ->
            Log.w(
                TAG,
                "CJ-1 TX microphone sources were quiet; falling back to ${candidate.label} " +
                    "with probe peak=$bestLowSignalPeak"
            )
            return createStartedFallbackAudioRecord(context, candidate, audioFormat, bufferSize)
        }

        val reason = lastError?.message ?: "unknown failure"
        throw IOException("AudioRecord could not start for any microphone source: $reason", lastError)
    }

    private fun createStartedFallbackAudioRecord(
        context: Context,
        candidate: AudioSourceCandidate,
        audioFormat: AudioFormat,
        bufferSize: Int
    ): AudioRecord {
        val record = createAudioRecord(candidate, audioFormat, bufferSize)
            ?: throw IOException("AudioRecord fallback source ${candidate.label} could not be created")
        try {
            requestTransmitAudioFocus(context)
            record.startRecording()
            if (record.recordingState == AudioRecord.RECORDSTATE_RECORDING) {
                activeTransmitSourceLabel = "${candidate.label} fallback"
                activeTransmitInputGain = candidate.inputGain
                Log.i(TAG, "CJ-1 TX microphone source active: ${candidate.label} fallback")
                return record
            }
            throw IOException("AudioRecord fallback source ${candidate.label} did not enter recording state")
        } catch (error: Exception) {
            abandonTransmitAudioFocus()
            runCatching {
                record.release()
            }
            throw IOException("AudioRecord fallback source ${candidate.label} could not start", error)
        }
    }

    private fun probeAudioRecordPeak(record: AudioRecord, frameBytes: Int): Int {
        val probeFrame = ByteArray(frameBytes)
        var peak = 0
        repeat(TX_SOURCE_PROBE_FRAMES) {
            val count = record.read(probeFrame, 0, probeFrame.size, AudioRecord.READ_BLOCKING)
            if (count > 0) {
                peak = max(peak, pcmPeak(probeFrame, count))
            }
        }
        return peak
    }

    private fun createAudioRecord(
        candidate: AudioSourceCandidate,
        audioFormat: AudioFormat,
        bufferSize: Int
    ): AudioRecord? {
        val record = runCatching {
            AudioRecord.Builder()
                .setAudioSource(candidate.source)
                .setAudioFormat(audioFormat)
                .setBufferSizeInBytes(bufferSize)
                .build()
        }.getOrElse { error ->
            Log.w(TAG, "CJ-1 TX microphone source ${candidate.label} failed to build", error)
            return null
        }

        if (record.state == AudioRecord.STATE_INITIALIZED) {
            Log.i(TAG, "CJ-1 TX microphone source initialized: ${candidate.label}")
            return record
        }

        Log.w(TAG, "CJ-1 TX microphone source ${candidate.label} was not initialized")
        runCatching {
            record.release()
        }
        return null
    }

    private fun requestTransmitAudioFocus(context: Context) {
        val audioManager = context.applicationContext.getSystemService(Context.AUDIO_SERVICE) as? AudioManager
            ?: return

        runCatching {
            val request = AudioFocusRequest.Builder(AudioManager.AUDIOFOCUS_GAIN)
                .setAudioAttributes(
                    AudioAttributes.Builder()
                        .setUsage(AudioAttributes.USAGE_VOICE_COMMUNICATION)
                        .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
                        .build()
                )
                .setWillPauseWhenDucked(false)
                .build()

            val result = audioManager.requestAudioFocus(request)
            if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                transmitAudioManager = audioManager
                transmitFocusRequest = request
            }
            Log.i(TAG, "CJ-1 TX audio focus result=$result")
        }.onFailure { error ->
            Log.w(
                TAG,
                "CJ-1 TX audio focus request failed; continuing without focus",
                error
            )
        }
    }

    private fun abandonTransmitAudioFocus() {
        val request = transmitFocusRequest
        val manager = transmitAudioManager
        if (request != null && manager != null) {
            runCatching {
                manager.abandonAudioFocusRequest(request)
            }
        }
        transmitFocusRequest = null
        transmitAudioManager = null
    }

    private fun openVoiceSerialSession(purpose: String): ComjotNativeSerial? {
        if (!ComjotNativeSerial.isAvailable) {
            configureVoiceSerial()
            return null
        }

        return runCatching {
            ComjotNativeSerial.open(voiceSerialPath, VOICE_SERIAL_BAUD).also { serial ->
                Log.i(
                    TAG,
                    "Opened CJ-1 voice serial $voiceSerialPath for $purpose with native fd " +
                        "at ${serial.configuredBaud} baud"
                )
            }
        }.getOrElse { error ->
            Log.w(
                TAG,
                "Native voice serial open failed for $voiceSerialPath; falling back to Java streams",
                error
            )
            configureVoiceSerial()
            null
        }
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
        private const val TX_QUEUE_DEPTH = 8
        private const val TX_PREFILL_FRAMES = 8
        private const val NANOS_PER_MILLI = 1_000_000L
        private const val TX_TIMING_GAP_RESET_MS = 20L
        private const val TX_EMPTY_RETRY_DELAY_MS = 5L
        private const val TX_EMPTY_SILENCE_THRESHOLD = 5
        private const val TX_WAKE_LOCK_TIMEOUT_MS = 30 * 60 * 1000L
        private const val TX_BUFFER_BYTES = 640
        private const val RX_BUFFER_BYTES = 16_384
        private const val RX_QUEUE_DEPTH = 96
        private const val RX_PREFILL_FRAMES = 6
        private const val RX_PREFILL_TIMEOUT_MS = 160L
        private const val RX_PLAYBACK_POLL_MS = 40L
        private const val RX_SILENCE_FILL_FRAMES = 4
        private const val RX_UNDERRUN_LOG_INTERVAL = 25L
        private const val RECEIVE_READ_BYTES = 640
        private const val VOICE_READ_IDLE_MS = 5L
        private const val VOICE_FRAME_HEAD = 0xBB
        private const val VOICE_FRAME_TAIL = 0x44
        private const val VOICE_HEADER_SIZE = 3
        private const val VOICE_FRAME_SIZE = 167
        private const val VOICE_AUDIO_OFFSET = 6
        private const val VOICE_AUDIO_BYTES = 160
        private const val RECEIVE_SCAN_BUFFER_BYTES = VOICE_FRAME_SIZE * 8
        private const val RX_GAIN = 1.4f
        private const val RX_SOFT_LIMIT_THRESHOLD = 16_000f
        private const val RX_SOFT_LIMIT_RATIO = 0.35f
        private const val RX_SOFT_LIMIT_CEILING = 24_000f
        private const val LOG_FRAME_INTERVAL = 250L
        private const val RAW_LOG_INTERVAL = 500L
        private const val MIC_LOG_INTERVAL = 100L
        private const val UNDERRUN_LOG_INTERVAL = 25L
        private const val TX_SOURCE_PROBE_FRAMES = 6
        private const val TX_SOURCE_MIN_PEAK = 64
        private const val TX_HIGH_PASS_COEFFICIENT = 0.995f
        private const val TX_OUTPUT_GAIN = 1.0f
        private const val TX_SOFT_LIMIT_THRESHOLD = 5_200f
        private const val TX_SOFT_LIMIT_RATIO = 0.25f
        private const val TX_SOFT_LIMIT_CEILING = 9_000f

        private data class AudioSourceCandidate(
            val source: Int,
            val label: String,
            val acceptQuietSignal: Boolean = false,
            val inputGain: Float = 1.0f
        )

        private val AUDIO_SOURCES = listOf(
            AudioSourceCandidate(
                MediaRecorder.AudioSource.UNPROCESSED,
                "unprocessed mic",
                acceptQuietSignal = true,
                inputGain = 8.0f
            ),
            AudioSourceCandidate(
                MediaRecorder.AudioSource.VOICE_RECOGNITION,
                "voice recognition mic",
                inputGain = 3.0f
            ),
            AudioSourceCandidate(
                MediaRecorder.AudioSource.MIC,
                "Android MIC",
                acceptQuietSignal = true,
                inputGain = 0.8f
            ),
            AudioSourceCandidate(
                MediaRecorder.AudioSource.CAMCORDER,
                "camcorder mic",
                acceptQuietSignal = true,
                inputGain = 0.8f
            ),
            AudioSourceCandidate(
                MediaRecorder.AudioSource.VOICE_COMMUNICATION,
                "voice communication mic",
                inputGain = 1.5f
            ),
            AudioSourceCandidate(MediaRecorder.AudioSource.DEFAULT, "default mic")
        )

        private val INTERNAL_STTY_PATHS = listOf(
            "/system/bin/stty",
            "/vendor/bin/stty"
        )
    }
}
