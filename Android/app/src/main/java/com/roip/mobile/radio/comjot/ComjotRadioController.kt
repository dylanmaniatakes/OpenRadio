package com.roip.mobile.radio.comjot

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.hardware.usb.UsbConstants
import android.hardware.usb.UsbDevice
import android.hardware.usb.UsbDeviceConnection
import android.hardware.usb.UsbEndpoint
import android.hardware.usb.UsbInterface
import android.hardware.usb.UsbManager
import android.os.ParcelFileDescriptor
import android.util.Log
import com.roip.mobile.radio.comjot.ComjotPacket.toHexString
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.util.concurrent.TimeUnit

sealed class ComjotWriteResult(open val packetHex: String) {
    data class Sent(
        override val packetHex: String,
        val deviceName: String,
        val bytesWritten: Int
    ) : ComjotWriteResult(packetHex)

    data class PermissionRequired(
        override val packetHex: String,
        val deviceName: String
    ) : ComjotWriteResult(packetHex)

    data class NoDevice(
        override val packetHex: String,
        val message: String = "No CJ-1 USB serial adapter or internal UART found"
    ) : ComjotWriteResult(packetHex)

    data class Failed(
        override val packetHex: String,
        val message: String
    ) : ComjotWriteResult(packetHex)
}

class ComjotRadioController(
    private val audioBridge: ComjotAudioBridge = ComjotAudioBridge()
) {
    private val internalSerialLock = Any()

    @Volatile
    private var rfModulePrepared = false

    @Volatile
    private var configuredControlSerialPath: String? = null

    @Volatile
    private var nativeControlSerial: ComjotNativeSerial? = null

    @Volatile
    private var controlSerialDescriptor: ParcelFileDescriptor? = null

    @Volatile
    private var controlInput: FileInputStream? = null

    @Volatile
    private var controlOutput: FileOutputStream? = null

    @Volatile
    private var transmitAudioFormat: ComjotTransmitAudioFormat = ComjotTransmitAudioFormat.DIGITAL_10MS

    fun programDigital(
        context: Context,
        profile: ComjotDigitalProfile,
        baudRate: Int
    ): ComjotWriteResult {
        transmitAudioFormat = ComjotTransmitAudioFormat.DIGITAL_10MS
        prepareRfModuleForProgramming()
        val versionResult = writePacket(
            context = context,
            packet = ComjotPacket.getVersion(),
            baudRate = baudRate
        )
        if (versionResult !is ComjotWriteResult.Sent) {
            return versionResult
        }

        Thread.sleep(PROFILE_AFTER_VERSION_DELAY_MS)
        val groupResult = writePacket(
            context = context,
            packet = ComjotPacket.setDigitalGroup(profile),
            baudRate = baudRate
        )
        if (groupResult !is ComjotWriteResult.Sent) {
            return groupResult
        }

        Thread.sleep(PROFILE_AFTER_GROUP_DELAY_MS)
        val volumeResult = writePacket(
            context = context,
            packet = ComjotPacket.setVolume(profile.volume),
            baudRate = baudRate
        )
        if (volumeResult !is ComjotWriteResult.Sent) {
            return volumeResult
        }

        val micGainResult = writePacket(
            context = context,
            packet = ComjotPacket.setMicGain(profile.micGain),
            baudRate = baudRate
        )
        if (micGainResult !is ComjotWriteResult.Sent) {
            return micGainResult
        }

        return groupResult.copy(
            bytesWritten = versionResult.bytesWritten +
                groupResult.bytesWritten +
                volumeResult.bytesWritten +
                micGainResult.bytesWritten
        ).startReceiveAudioIfAvailable()
    }

    fun programAnalog(
        context: Context,
        profile: ComjotAnalogProfile,
        baudRate: Int
    ): ComjotWriteResult {
        transmitAudioFormat = ComjotTransmitAudioFormat.DIGITAL_10MS
        prepareRfModuleForProgramming()
        val versionResult = writePacket(
            context = context,
            packet = ComjotPacket.getVersion(),
            baudRate = baudRate
        )
        if (versionResult !is ComjotWriteResult.Sent) {
            return versionResult
        }

        Thread.sleep(PROFILE_AFTER_VERSION_DELAY_MS)
        val groupResult = writePacket(
            context = context,
            packet = ComjotPacket.setAnalogGroup(profile),
            baudRate = baudRate
        )
        if (groupResult !is ComjotWriteResult.Sent) {
            return groupResult
        }

        Thread.sleep(PROFILE_AFTER_GROUP_DELAY_MS)
        val powerSaveResult = writePacket(
            context = context,
            packet = ComjotPacket.setPowerSave(enabled = false),
            baudRate = baudRate
        )
        if (powerSaveResult !is ComjotWriteResult.Sent) {
            return powerSaveResult
        }

        val micGainResult = writePacket(
            context = context,
            packet = ComjotPacket.setMicGain(profile.micGain),
            baudRate = baudRate
        )
        if (micGainResult !is ComjotWriteResult.Sent) {
            return micGainResult
        }

        val volumeResult = writePacket(
            context = context,
            packet = ComjotPacket.setVolume(profile.volume),
            baudRate = baudRate
        )
        if (volumeResult !is ComjotWriteResult.Sent) {
            return volumeResult
        }

        return groupResult.copy(
            bytesWritten = versionResult.bytesWritten +
                groupResult.bytesWritten +
                powerSaveResult.bytesWritten +
                micGainResult.bytesWritten +
                volumeResult.bytesWritten
        ).startReceiveAudioIfAvailable()
    }

    fun setTransmission(
        context: Context,
        active: Boolean,
        baudRate: Int,
        onTransmitPcm: ((ShortArray) -> Unit)? = null
    ): ComjotWriteResult {
        val packet = ComjotPacket.setTransmission(active)
        return if (active) {
            startTransmission(context, packet, baudRate, onTransmitPcm)
        } else {
            stopTransmission(context, packet, baudRate)
        }
    }

    fun setVolume(
        context: Context,
        level: Int,
        baudRate: Int
    ): ComjotWriteResult {
        return writePacket(
            context = context,
            packet = ComjotPacket.setVolume(level),
            baudRate = baudRate
        )
    }

    fun startHotspotReceiveAudio(
        onPcm: (ShortArray) -> Unit,
        playLocalMonitor: Boolean = true
    ): Boolean {
        return audioBridge.startReceiveBridge(
            onPcm = onPcm,
            playLocalMonitor = playLocalMonitor
        )
    }

    fun startHotspotTransmitAudio(
        context: Context,
        baudRate: Int
    ): ComjotWriteResult {
        val packet = ComjotPacket.setTransmission(true)
        val packetHex = packet.toHexString()
        val firstWrite = writePacket(
            context = context,
            packet = packet,
            baudRate = baudRate
        )
        if (firstWrite !is ComjotWriteResult.Sent) {
            return firstWrite
        }

        return try {
            audioBridge.startExternalTransmit(audioFormat = transmitAudioFormat)
            setHardwarePtt(active = true)

            when (
                val secondWrite = writePacket(
                    context = context,
                    packet = packet,
                    baudRate = baudRate
                )
            ) {
                is ComjotWriteResult.Sent -> secondWrite.copy(
                    deviceName = "${secondWrite.deviceName} + RF bridge audio",
                    bytesWritten = firstWrite.bytesWritten + secondWrite.bytesWritten
                )

                else -> {
                    writePacket(
                        context = context,
                        packet = ComjotPacket.setTransmission(false),
                        baudRate = baudRate
                    )
                    setHardwarePtt(active = false)
                    audioBridge.stopTransmit()
                    secondWrite
                }
            }
        } catch (error: Exception) {
            runCatching {
                writePacket(
                    context = context,
                    packet = ComjotPacket.setTransmission(false),
                    baudRate = baudRate
                )
            }
            runCatching {
                setHardwarePtt(active = false)
            }
            audioBridge.stopTransmit()
            ComjotWriteResult.Failed(
                packetHex = packetHex,
                message = "CJ-1 hotspot TX audio failed: ${error.message ?: "unknown error"}"
            )
        }
    }

    fun enqueueHotspotTransmitPcm(pcm: ShortArray) {
        audioBridge.enqueueExternalPcm(pcm)
    }

    fun stopHotspotTransmitAudio(
        context: Context,
        baudRate: Int
    ): ComjotWriteResult {
        val packet = ComjotPacket.setTransmission(false)
        val result = writePacket(
            context = context,
            packet = packet,
            baudRate = baudRate
        )
        val releaseError = runCatching {
            setHardwarePtt(active = false)
        }.exceptionOrNull()
        audioBridge.stopTransmit()
        return if (result is ComjotWriteResult.Sent && releaseError != null) {
            ComjotWriteResult.Failed(
                packetHex = packet.toHexString(),
                message = "CJ-1 hotspot PTT release failed: ${releaseError.message ?: "unknown error"}"
            )
        } else {
            result
        }
    }

    fun shutdown() {
        runCatching {
            setHardwarePtt(active = false)
        }.onFailure { error ->
            Log.w(TAG, "Failed to release CJ-1 hardware PTT during shutdown", error)
        }
        synchronized(internalSerialLock) {
            closeInternalControlSessionLocked()
            rfModulePrepared = false
        }
        audioBridge.shutdown()
    }

    private fun startTransmission(
        context: Context,
        packet: ByteArray,
        baudRate: Int,
        onTransmitPcm: ((ShortArray) -> Unit)?
    ): ComjotWriteResult {
        val packetHex = packet.toHexString()
        val firstWrite = writePacket(
            context = context,
            packet = packet,
            baudRate = baudRate
        )

        if (firstWrite !is ComjotWriteResult.Sent) {
            return firstWrite
        }

        return try {
            audioBridge.startTransmit(
                context = context.applicationContext,
                onPcm = onTransmitPcm,
                audioFormat = transmitAudioFormat
            )
            setHardwarePtt(active = true)

            when (
                val secondWrite = writePacket(
                    context = context,
                    packet = packet,
                    baudRate = baudRate
                )
            ) {
                is ComjotWriteResult.Sent -> secondWrite.copy(
                    deviceName = "${secondWrite.deviceName} + /dev/ttyS0 audio",
                    bytesWritten = firstWrite.bytesWritten + secondWrite.bytesWritten
                )

                else -> {
                    writePacket(
                        context = context,
                        packet = ComjotPacket.setTransmission(false),
                        baudRate = baudRate
                    )
                    setHardwarePtt(active = false)
                    audioBridge.stopTransmit()
                    secondWrite
                }
            }
        } catch (error: Exception) {
            runCatching {
                writePacket(
                    context = context,
                    packet = ComjotPacket.setTransmission(false),
                    baudRate = baudRate
                )
            }
            runCatching {
                setHardwarePtt(active = false)
            }
            audioBridge.stopTransmit()
            ComjotWriteResult.Failed(
                packetHex = packetHex,
                message = "CJ-1 PTT/audio start failed: ${error.message ?: "unknown error"}"
            )
        }
    }

    private fun stopTransmission(
        context: Context,
        packet: ByteArray,
        baudRate: Int
    ): ComjotWriteResult {
        val result = writePacket(
            context = context,
            packet = packet,
            baudRate = baudRate
        )
        val releaseError = runCatching {
            setHardwarePtt(active = false)
        }.exceptionOrNull()

        audioBridge.stopTransmit()
        runCatching {
            audioBridge.startReceiveIfAvailable()
        }.onFailure { error ->
            Log.w(TAG, "Failed to restart CJ-1 RX audio after PTT release", error)
        }

        return if (result is ComjotWriteResult.Sent && releaseError != null) {
            ComjotWriteResult.Failed(
                packetHex = packet.toHexString(),
                message = "CJ-1 PTT release failed: ${releaseError.message ?: "unknown error"}"
            )
        } else {
            result
        }
    }

    private fun writePacket(
        context: Context,
        packet: ByteArray,
        baudRate: Int
    ): ComjotWriteResult {
        val appContext = context.applicationContext
        val packetHex = packet.toHexString()
        val usbManager = appContext.getSystemService(Context.USB_SERVICE) as UsbManager
        val candidate = findCandidate(usbManager) ?: return writeInternalSerial(packet, packetHex)

        if (!usbManager.hasPermission(candidate.device)) {
            usbManager.requestPermission(candidate.device, permissionIntent(appContext))
            return ComjotWriteResult.PermissionRequired(packetHex, candidate.device.productNameOrDeviceName())
        }

        return try {
            UsbSerialSession.open(usbManager, candidate, baudRate).use { session ->
                val written = session.write(packet)
                ComjotWriteResult.Sent(
                    packetHex = packetHex,
                    deviceName = candidate.device.productNameOrDeviceName(),
                    bytesWritten = written
                )
            }
        } catch (error: Exception) {
            ComjotWriteResult.Failed(
                packetHex = packetHex,
                message = error.message ?: "USB write failed"
            )
        }
    }

    private fun writeInternalSerial(packet: ByteArray, packetHex: String): ComjotWriteResult {
        val serialPath = INTERNAL_CONTROL_PATHS.firstOrNull { path ->
            File(path).let { it.exists() && it.canWrite() }
        } ?: return ComjotWriteResult.NoDevice(packetHex)

        return try {
            synchronized(internalSerialLock) {
                prepareInternalControlPathLocked(serialPath)
                drainInternalControlInputLocked(waitForBytesMs = 0L)
                val nativeSerial = nativeControlSerial
                val output = controlOutput
                if (nativeSerial == null && output == null) {
                    throw IOException("control output stream is not open")
                }
                Log.i(TAG, "CJ-1 control TX ${packet.size} bytes: ${packetHex.take(MAX_PACKET_LOG_HEX)}")
                if (nativeSerial != null) {
                    nativeSerial.write(packet)
                } else {
                    output?.write(packet)
                    output?.flush()
                }
                Thread.sleep(INTERNAL_COMMAND_REPEAT_DELAY_MS)
                if (nativeSerial != null) {
                    nativeSerial.write(packet)
                } else {
                    output?.write(packet)
                    output?.flush()
                }
                drainInternalControlInputLocked(waitForBytesMs = INTERNAL_RESPONSE_WAIT_MS)
            }
            ComjotWriteResult.Sent(
                packetHex = packetHex,
                deviceName = "CJ-1 internal UART $serialPath",
                bytesWritten = packet.size * 2
            )
        } catch (error: Exception) {
            synchronized(internalSerialLock) {
                closeInternalControlSessionLocked()
                rfModulePrepared = false
            }
            ComjotWriteResult.Failed(
                packetHex = packetHex,
                message = "CJ-1 internal UART write failed on $serialPath: ${error.message ?: "unknown error"}"
            )
        }
    }

    private fun prepareInternalControlPathLocked(serialPath: String) {
        if (!rfModulePrepared) {
            prepareRfModuleIfPresent(force = false)
            rfModulePrepared = true
        }

        ensureInternalControlSessionLocked(serialPath)
    }

    private fun prepareRfModuleForProgramming() {
        synchronized(internalSerialLock) {
            val serialPath = INTERNAL_CONTROL_PATHS.firstOrNull { path ->
                File(path).let { it.exists() && it.canRead() && it.canWrite() }
            }
            if (serialPath != null) {
                ensureInternalControlSessionLocked(serialPath)
                drainInternalControlInputLocked(waitForBytesMs = 0L)
            }
            prepareRfModuleIfPresent(force = true)
            rfModulePrepared = true
            if (serialPath != null) {
                drainInternalControlInputLocked(waitForBytesMs = RF_POWER_RESPONSE_WAIT_MS)
            }
        }
    }

    private fun ComjotWriteResult.startReceiveAudioIfAvailable(): ComjotWriteResult {
        if (this !is ComjotWriteResult.Sent) {
            return this
        }

        return try {
            if (audioBridge.startReceiveIfAvailable()) {
                copy(deviceName = "$deviceName + /dev/ttyS0 RX audio")
            } else {
                this
            }
        } catch (error: Exception) {
            ComjotWriteResult.Failed(
                packetHex = packetHex,
                message = "CJ-1 profile sent, but RX audio could not start: ${error.message ?: "unknown error"}"
            )
        }
    }

    private fun prepareRfModuleIfPresent(force: Boolean) {
        if (!File(AUCTUS_CONTROL_PATH).exists() && !File(DMR_POWER_PATH).exists()) {
            return
        }

        if (force) {
            runCatching {
                setHardwarePtt(active = false)
            }
            writeSysfs(AUCTUS_CONTROL_PATH, "4")
            writeSysfs(AUCTUS_CONTROL_PATH, "0")
            writeSysfs(DMR_POWER_PATH, "0")
            Thread.sleep(RF_POWER_RESET_SETTLE_MS)
        }

        writeSysfs(AUCTUS_CONTROL_PATH, "0")
        writeSysfs(DMR_POWER_PATH, "1")
        writeSysfs(AUCTUS_CONTROL_PATH, "1")
        Log.i(TAG, "CJ-1 RF module power sequence applied${if (force) " for profile programming" else ""}")
        Thread.sleep(RF_POWER_SETTLE_MS)
    }

    private fun setHardwarePtt(active: Boolean) {
        if (!File(DMR_PTT_PATH).exists()) {
            return
        }

        writeSysfs(DMR_PTT_PATH, if (active) "0" else "1")
    }

    private fun writeSysfs(path: String, value: String) {
        FileOutputStream(path).use { output ->
            output.write(value.toByteArray(Charsets.US_ASCII))
            output.flush()
        }
    }

    private fun configureInternalSerial(serialPath: String) {
        val sttyPath = INTERNAL_STTY_PATHS.firstOrNull { File(it).canExecute() } ?: "stty"
        val process = ProcessBuilder(
            sttyPath,
            "-F",
            serialPath,
            INTERNAL_CONTROL_BAUD.toString(),
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
            throw IOException("stty timed out")
        }

        val output = process.inputStream.bufferedReader().use { it.readText() }.trim()
        if (process.exitValue() != 0) {
            val details = output.ifBlank { "exit ${process.exitValue()}" }
            throw IOException("stty failed: $details")
        }
    }

    private fun ensureInternalControlSessionLocked(serialPath: String) {
        if (
            configuredControlSerialPath == serialPath &&
            (
                nativeControlSerial != null ||
                    (controlInput != null && controlOutput != null)
                )
        ) {
            return
        }

        closeInternalControlSessionLocked()

        if (ComjotNativeSerial.isAvailable) {
            runCatching {
                val nativeSerial = ComjotNativeSerial.open(serialPath, INTERNAL_CONTROL_BAUD)
                nativeControlSerial = nativeSerial
                configuredControlSerialPath = serialPath
                Log.i(
                    TAG,
                    "CJ-1 control serial session opened on $serialPath with native fd " +
                        "at ${nativeSerial.configuredBaud} baud"
                )
                return
            }.onFailure { nativeError ->
                Log.w(TAG, "Native serial open failed for $serialPath; falling back to Java streams", nativeError)
            }
        }

        configureInternalSerial(serialPath)

        val serialFile = File(serialPath)
        runCatching {
            val descriptor = ParcelFileDescriptor.open(
                serialFile,
                ParcelFileDescriptor.MODE_READ_WRITE
            )
            controlSerialDescriptor = descriptor
            controlInput = FileInputStream(descriptor.fileDescriptor)
            controlOutput = FileOutputStream(descriptor.fileDescriptor)
            configuredControlSerialPath = serialPath
            Log.i(TAG, "CJ-1 control serial session opened on $serialPath with shared descriptor")
        }.onFailure { descriptorError ->
            Log.w(
                TAG,
                "Shared descriptor open failed for $serialPath; falling back to persistent split streams",
                descriptorError
            )
            controlInput = FileInputStream(serialFile)
            controlOutput = FileOutputStream(serialFile)
            configuredControlSerialPath = serialPath
            Log.i(TAG, "CJ-1 control serial session opened on $serialPath with split streams")
        }
    }

    private fun closeInternalControlSessionLocked() {
        val oldPath = configuredControlSerialPath
        runCatching {
            nativeControlSerial?.close()
        }
        runCatching {
            controlOutput?.flush()
        }
        runCatching {
            controlInput?.close()
        }
        runCatching {
            controlOutput?.close()
        }
        runCatching {
            controlSerialDescriptor?.close()
        }
        nativeControlSerial = null
        controlInput = null
        controlOutput = null
        controlSerialDescriptor = null
        configuredControlSerialPath = null
        if (oldPath != null) {
            Log.i(TAG, "CJ-1 control serial session closed on $oldPath")
        }
    }

    private fun drainInternalControlInputLocked(waitForBytesMs: Long) {
        runCatching {
            val buffer = ByteArray(INTERNAL_CONTROL_DRAIN_BYTES)
            val captured = ByteArray(INTERNAL_CONTROL_DRAIN_BYTES)
            var total = 0
            val deadline = System.nanoTime() + TimeUnit.MILLISECONDS.toNanos(waitForBytesMs)

            do {
                val nativeSerial = nativeControlSerial
                val input = controlInput
                if (nativeSerial == null && input == null) {
                    break
                }

                val nativeBytes = nativeSerial?.readAvailable(buffer.size)
                val available = nativeBytes?.size ?: input?.available() ?: 0
                if (available <= 0) {
                    if (waitForBytesMs <= 0L || System.nanoTime() >= deadline) {
                        break
                    }
                    Thread.sleep(INTERNAL_RESPONSE_POLL_DELAY_MS)
                    continue
                }

                val count = if (nativeBytes != null) {
                    nativeBytes.copyInto(buffer, endIndex = nativeBytes.size)
                    nativeBytes.size
                } else {
                    input?.read(buffer, 0, minOf(available, buffer.size)) ?: 0
                }
                if (count <= 0) {
                    break
                }
                val copyCount = minOf(count, captured.size - total)
                if (copyCount > 0) {
                    buffer.copyInto(
                        destination = captured,
                        destinationOffset = total,
                        startIndex = 0,
                        endIndex = copyCount
                    )
                }
                total += count
            } while (hasInternalControlBytesLocked() || (waitForBytesMs > 0L && System.nanoTime() < deadline))

            if (total > 0) {
                val received = captured.copyOf(minOf(total, captured.size))
                Log.i(TAG, "CJ-1 control RX $total bytes: ${received.toHexString()}")
                ComjotPacket.parseFrames(received).forEach { frame ->
                    Log.i(
                        TAG,
                        "CJ-1 control frame cmd=0x${frame.command.toString(16)} " +
                            "mode=0x${frame.mode.toString(16)} status=0x${frame.status.toString(16)} " +
                            "payload=${frame.payload.toHexString()}"
                    )
                }
            }
        }.onFailure { error ->
            Log.d(TAG, "Unable to drain CJ-1 control UART", error)
            closeInternalControlSessionLocked()
        }
    }

    private fun hasInternalControlBytesLocked(): Boolean {
        return runCatching {
            val nativeSerial = nativeControlSerial
            if (nativeSerial != null) {
                nativeSerial.available() > 0
            } else {
                (controlInput?.available() ?: 0) > 0
            }
        }.getOrDefault(false)
    }

    private fun permissionIntent(context: Context): PendingIntent {
        val flags = PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        val intent = Intent(ACTION_USB_PERMISSION).setPackage(context.packageName)
        return PendingIntent.getBroadcast(context, 0, intent, flags)
    }

    private fun findCandidate(usbManager: UsbManager): UsbSerialCandidate? {
        val devices = usbManager.deviceList.values.toList()
        val supported = devices.firstNotNullOfOrNull { device ->
            if (device.vendorId to device.productId in SUPPORTED_DEVICE_IDS) {
                device.toCandidate()
            } else {
                null
            }
        }

        return supported ?: devices.firstNotNullOfOrNull { it.toCandidate() }
    }

    private fun UsbDevice.toCandidate(): UsbSerialCandidate? {
        for (interfaceIndex in 0 until interfaceCount) {
            val usbInterface = getInterface(interfaceIndex)
            var bulkIn: UsbEndpoint? = null
            var bulkOut: UsbEndpoint? = null

            for (endpointIndex in 0 until usbInterface.endpointCount) {
                val endpoint = usbInterface.getEndpoint(endpointIndex)
                if (endpoint.type != UsbConstants.USB_ENDPOINT_XFER_BULK) {
                    continue
                }

                if (endpoint.direction == UsbConstants.USB_DIR_IN) {
                    bulkIn = endpoint
                } else if (endpoint.direction == UsbConstants.USB_DIR_OUT) {
                    bulkOut = endpoint
                }
            }

            val out = bulkOut
            if (out != null) {
                return UsbSerialCandidate(
                    device = this,
                    usbInterface = usbInterface,
                    bulkIn = bulkIn,
                    bulkOut = out
                )
            }
        }

        return null
    }

    private data class UsbSerialCandidate(
        val device: UsbDevice,
        val usbInterface: UsbInterface,
        val bulkIn: UsbEndpoint?,
        val bulkOut: UsbEndpoint
    )

    private class UsbSerialSession private constructor(
        private val connection: UsbDeviceConnection,
        private val usbInterface: UsbInterface,
        private val bulkOut: UsbEndpoint
    ) : AutoCloseable {
        fun write(packet: ByteArray): Int {
            val written = connection.bulkTransfer(bulkOut, packet, packet.size, USB_TIMEOUT_MS)
            if (written != packet.size) {
                throw IOException("Expected to write ${packet.size} bytes, wrote $written")
            }
            return written
        }

        override fun close() {
            runCatching {
                connection.releaseInterface(usbInterface)
            }
            connection.close()
        }

        companion object {
            fun open(
                usbManager: UsbManager,
                candidate: UsbSerialCandidate,
                baudRate: Int
            ): UsbSerialSession {
                val connection = usbManager.openDevice(candidate.device)
                    ?: throw IOException("Unable to open USB device")

                if (!connection.claimInterface(candidate.usbInterface, true)) {
                    connection.close()
                    throw IOException("Unable to claim USB serial interface")
                }

                try {
                    if (candidate.device.vendorId == CP210X_VENDOR_ID) {
                        connection.configureCp210x(candidate.usbInterface.id, baudRate)
                    }
                } catch (error: Exception) {
                    connection.releaseInterface(candidate.usbInterface)
                    connection.close()
                    throw error
                }

                return UsbSerialSession(
                    connection = connection,
                    usbInterface = candidate.usbInterface,
                    bulkOut = candidate.bulkOut
                )
            }

            private fun UsbDeviceConnection.configureCp210x(interfaceId: Int, baudRate: Int) {
                controlOut(CP210X_IFC_ENABLE, UART_ENABLE, interfaceId)
                controlOut(CP210X_SET_LINE_CTL, UART_8N1, interfaceId)
                controlOut(CP210X_SET_MHS, MHS_DTR or MHS_RTS or MHS_WRITE_DTR or MHS_WRITE_RTS, interfaceId)

                val baud = byteArrayOf(
                    (baudRate and 0xFF).toByte(),
                    ((baudRate ushr 8) and 0xFF).toByte(),
                    ((baudRate ushr 16) and 0xFF).toByte(),
                    ((baudRate ushr 24) and 0xFF).toByte()
                )
                val result = controlTransfer(
                    USB_WRITE_REQUEST_TYPE,
                    CP210X_SET_BAUDRATE,
                    0,
                    interfaceId,
                    baud,
                    baud.size,
                    USB_TIMEOUT_MS
                )
                if (result < 0) {
                    throw IOException("Unable to set CP210x baud rate")
                }
            }

            private fun UsbDeviceConnection.controlOut(request: Int, value: Int, index: Int) {
                val result = controlTransfer(
                    USB_WRITE_REQUEST_TYPE,
                    request,
                    value,
                    index,
                    null,
                    0,
                    USB_TIMEOUT_MS
                )
                if (result < 0) {
                    throw IOException("USB control request $request failed")
                }
            }
        }
    }

    companion object {
        const val ACTION_USB_PERMISSION = "com.roip.mobile.USB_PERMISSION"

        private const val TAG = "ComjotRadio"
        private const val USB_TIMEOUT_MS = 1_000
        private const val INTERNAL_CONTROL_BAUD = 57_600
        private const val INTERNAL_COMMAND_REPEAT_DELAY_MS = 10L
        private const val INTERNAL_RESPONSE_WAIT_MS = 120L
        private const val RF_POWER_RESPONSE_WAIT_MS = 800L
        private const val INTERNAL_RESPONSE_POLL_DELAY_MS = 10L
        private const val INTERNAL_CONTROL_DRAIN_BYTES = 1_024
        private const val PROFILE_AFTER_VERSION_DELAY_MS = 300L
        private const val PROFILE_AFTER_GROUP_DELAY_MS = 100L
        private const val RF_POWER_RESET_SETTLE_MS = 150L
        private const val RF_POWER_SETTLE_MS = 5_000L
        private const val MAX_PACKET_LOG_HEX = 180
        private const val AUCTUS_CONTROL_PATH = "/sys/bus/platform/drivers/dmr_gpio/auctusctl"
        private const val DMR_POWER_PATH = "/sys/bus/platform/drivers/dmr_gpio/dmr_pwr"
        private const val DMR_PTT_PATH = "/sys/devices/platform/dmr_gpio/dmrptt"
        private const val CP210X_VENDOR_ID = 0x10C4
        private const val USB_WRITE_REQUEST_TYPE = 0x41
        private const val CP210X_IFC_ENABLE = 0x00
        private const val CP210X_SET_LINE_CTL = 0x03
        private const val CP210X_SET_MHS = 0x07
        private const val CP210X_SET_BAUDRATE = 0x1E
        private const val UART_ENABLE = 0x0001
        private const val UART_8N1 = 0x0800
        private const val MHS_DTR = 0x0001
        private const val MHS_RTS = 0x0002
        private const val MHS_WRITE_DTR = 0x0100
        private const val MHS_WRITE_RTS = 0x0200

        private val SUPPORTED_DEVICE_IDS = setOf(
            0x10C4 to 0xEA60,
            0x239A to 0x8111
        )

        private val INTERNAL_CONTROL_PATHS = listOf(
            "/dev/ttyS1",
            "/dev/ttyMT1",
            "/dev/ttyUSB0",
            "/dev/ttyACM0"
        )

        private val INTERNAL_STTY_PATHS = listOf(
            "/system/bin/stty",
            "/vendor/bin/stty"
        )
    }
}

private fun UsbDevice.productNameOrDeviceName(): String {
    return productName ?: deviceName
}
