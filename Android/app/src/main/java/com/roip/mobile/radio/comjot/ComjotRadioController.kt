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
import android.util.Log
import com.roip.mobile.radio.comjot.ComjotPacket.toHexString
import java.io.File
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

    fun programDigital(
        context: Context,
        profile: ComjotDigitalProfile,
        baudRate: Int
    ): ComjotWriteResult {
        return writePacket(
            context = context,
            packet = ComjotPacket.setDigitalGroup(profile),
            baudRate = baudRate
        ).startReceiveAudioIfAvailable()
    }

    fun programAnalog(
        context: Context,
        profile: ComjotAnalogProfile,
        baudRate: Int
    ): ComjotWriteResult {
        return writePacket(
            context = context,
            packet = ComjotPacket.setAnalogGroup(profile),
            baudRate = baudRate
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
            audioBridge.startExternalTransmit()
            setHardwarePtt(active = true)
            firstWrite.copy(
                deviceName = "${firstWrite.deviceName} + RF bridge audio"
            )
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
                onPcm = onTransmitPcm
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
            prepareInternalControlPath(serialPath)
            FileOutputStream(serialPath).use { output ->
                output.write(packet)
                output.flush()
            }
            ComjotWriteResult.Sent(
                packetHex = packetHex,
                deviceName = "CJ-1 internal UART $serialPath",
                bytesWritten = packet.size
            )
        } catch (error: Exception) {
            ComjotWriteResult.Failed(
                packetHex = packetHex,
                message = "CJ-1 internal UART write failed on $serialPath: ${error.message ?: "unknown error"}"
            )
        }
    }

    private fun prepareInternalControlPath(serialPath: String) {
        synchronized(internalSerialLock) {
            if (!rfModulePrepared) {
                prepareRfModuleIfPresent()
                rfModulePrepared = true
            }

            if (configuredControlSerialPath != serialPath) {
                configureInternalSerial(serialPath)
                configuredControlSerialPath = serialPath
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

    private fun prepareRfModuleIfPresent() {
        if (!File(AUCTUS_CONTROL_PATH).exists() && !File(DMR_POWER_PATH).exists()) {
            return
        }

        writeSysfs(AUCTUS_CONTROL_PATH, "0")
        writeSysfs(DMR_POWER_PATH, "1")
        writeSysfs(AUCTUS_CONTROL_PATH, "1")
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
