package com.roip.mobile.radio.comjot

import java.io.Closeable
import kotlin.math.min

internal class ComjotNativeSerial private constructor(
    private var fd: Int,
    val path: String,
    val configuredBaud: Int
) : Closeable {
    fun write(packet: ByteArray, drain: Boolean = true): Int {
        val activeFd = fd
        check(activeFd >= 0) { "native serial is closed" }
        return nativeWrite(activeFd, packet, drain)
    }

    fun readAvailable(maxBytes: Int): ByteArray {
        val activeFd = fd
        if (activeFd < 0) {
            return ByteArray(0)
        }

        val available = nativeAvailable(activeFd)
        if (available <= 0) {
            return ByteArray(0)
        }
        return nativeRead(activeFd, min(maxBytes, available))
    }

    fun available(): Int {
        val activeFd = fd
        return if (activeFd >= 0) {
            nativeAvailable(activeFd)
        } else {
            0
        }
    }

    override fun close() {
        val activeFd = fd
        if (activeFd >= 0) {
            fd = -1
            nativeClose(activeFd)
        }
    }

    companion object {
        val isAvailable: Boolean = runCatching {
            System.loadLibrary("openradio_mbe")
        }.isSuccess

        fun open(path: String, baud: Int): ComjotNativeSerial {
            check(isAvailable) { "openradio native library is unavailable" }
            val fd = nativeOpen(path, baud)
            return ComjotNativeSerial(
                fd = fd,
                path = path,
                configuredBaud = nativeConfiguredBaud(fd)
            )
        }

        private external fun nativeOpen(path: String, baud: Int): Int
        private external fun nativeConfiguredBaud(fd: Int): Int
        private external fun nativeAvailable(fd: Int): Int
        private external fun nativeRead(fd: Int, maxBytes: Int): ByteArray
        private external fun nativeWrite(fd: Int, packet: ByteArray, drain: Boolean): Int
        private external fun nativeClose(fd: Int)
    }
}
