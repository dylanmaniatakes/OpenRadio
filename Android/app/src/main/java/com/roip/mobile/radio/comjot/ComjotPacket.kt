package com.roip.mobile.radio.comjot

data class ComjotDigitalProfile(
    val rxHz: Long,
    val txHz: Long,
    val localId: Int,
    val talkgroup: Int,
    val colorCode: Int = 1,
    val timeSlot: Int = 1,
    val highPower: Boolean = true,
    val volume: Int = 6,
    val micGain: Int = 3
)

data class ComjotAnalogProfile(
    val rxHz: Long,
    val txHz: Long,
    val wideBandwidth: Boolean = false,
    val highPower: Boolean = true,
    val squelch: Int = 5,
    val rxToneMode: Int = 0,
    val rxSubcode: Int = 0,
    val txToneMode: Int = 0,
    val txSubcode: Int = 0,
    val powerSave: Boolean = false,
    val volume: Int = 6,
    val micGain: Int = 3,
    val monitorOpen: Boolean = false,
    val repeaterDecoupling: Boolean = false
)

data class ComjotFrame(
    val command: Int,
    val mode: Int,
    val status: Int,
    val payload: ByteArray
) {
    val isEvent: Boolean = mode == ComjotPacket.MODE_EVENT

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ComjotFrame) return false
        return command == other.command &&
            mode == other.mode &&
            status == other.status &&
            payload.contentEquals(other.payload)
    }

    override fun hashCode(): Int {
        var result = command
        result = 31 * result + mode
        result = 31 * result + status
        result = 31 * result + payload.contentHashCode()
        return result
    }
}

enum class ComjotEvent(val code: Int, val label: String) {
    RX_START(0x01, "RX start"),
    RX_END(0x02, "RX end"),
    TX_START(0x03, "TX start"),
    TX_END(0x04, "TX end"),
    SMS_RECEIVED(0x05, "SMS received"),
    REPEATER_TIMEOUT(0x06, "Repeater timeout"),
    CHANNEL_BUSY(0x07, "Channel busy"),
    SMS_SENT(0x08, "Confirmed SMS sent"),
    SMS_FAILED(0x09, "Confirmed SMS failed"),
    DIGITAL_SYNC_START(0x0A, "Digital sync RX start"),
    DIGITAL_SYNC_END(0x0B, "Digital sync RX end"),
    ANALOG_SYNC_START(0x0C, "Analog sync RX start"),
    ANALOG_SYNC_END(0x0D, "Analog sync RX end");

    companion object {
        fun fromCode(code: Int): ComjotEvent? = entries.firstOrNull { it.code == code }
    }
}

object ComjotPacket {
    const val HEAD = 0x68
    const val TAIL = 0x10

    const val MODE_READ = 0x00
    const val MODE_WRITE = 0x01
    const val MODE_EVENT = 0x02

    const val STATUS_SET = 0x01

    const val CMD_SET_DIGITAL_GROUP = 0x22
    const val CMD_SET_ANALOG_GROUP = 0x23
    const val CMD_SET_TRANSMISSION = 0x26
    const val CMD_INIT_STATUS = 0x27
    const val CMD_SET_MIC_GAIN = 0x2A
    const val CMD_GET_RSSI = 0x32
    const val CMD_GET_VERSION = 0x34
    const val CMD_EVENTS = 0x36
    const val CMD_SET_VOLUME = 0x2E
    const val CMD_SET_POWER_SAVE = 0x31

    fun setDigitalGroup(profile: ComjotDigitalProfile): ByteArray {
        val payload = ByteArray(0xA3)
        payload.putIntLe(0, profile.rxHz)
        payload.putIntLe(4, profile.txHz)
        payload.putIntLe(8, profile.localId.toLong())

        repeat(DIGITAL_CONTACT_REPEAT_COUNT) { index ->
            payload.putIntLe(12 + (index * 4), profile.talkgroup.toLong())
        }

        payload.putIntLe(140, profile.talkgroup.toLong())
        payload[144] = 0x01.toByte() // group call
        payload[145] = (if (profile.highPower) 0x01 else 0x00).toByte()
        payload[146] = profile.colorCode.coerceIn(0, 15).toByte()

        val zeroBasedSlot = (profile.timeSlot.coerceIn(1, 2) - 1).toByte()
        payload[147] = zeroBasedSlot
        payload[148] = zeroBasedSlot
        payload[149] = 0x00.toByte() // simplex
        payload[150] = 0x02.toByte() // encryption disabled
        "00000000".encodeToByteArray().copyInto(payload, destinationOffset = 151)
        payload[159] = 0x02.toByte() // power save disabled for active RF use
        payload[160] = profile.volume.coerceIn(1, 9).toByte()
        payload[161] = profile.micGain.coerceIn(0, 5).toByte()
        payload[162] = 0x02.toByte() // repeater decoupling disabled

        return command(CMD_SET_DIGITAL_GROUP, payload)
    }

    fun setAnalogGroup(profile: ComjotAnalogProfile): ByteArray {
        val payload = ByteArray(19)
        payload.putIntLe(0, profile.rxHz)
        payload.putIntLe(4, profile.txHz)
        payload[8] = (if (profile.wideBandwidth) 0x01 else 0x00).toByte()
        payload[9] = (if (profile.highPower) 0x01 else 0x00).toByte()
        payload[10] = profile.squelch.coerceIn(0, 9).toByte()
        payload[11] = profile.rxToneMode.coerceIn(0, 3).toByte()
        payload[12] = profile.rxSubcode.coerceIn(0, 255).toByte()
        payload[13] = profile.txToneMode.coerceIn(0, 3).toByte()
        payload[14] = profile.txSubcode.coerceIn(0, 255).toByte()
        payload[15] = (if (profile.powerSave) 0x01 else 0x02).toByte()
        payload[16] = profile.volume.coerceIn(1, 9).toByte()
        payload[17] = (if (profile.monitorOpen) 0x01 else 0x02).toByte()
        payload[18] = (if (profile.repeaterDecoupling) 0x01 else 0x02).toByte()

        return command(CMD_SET_ANALOG_GROUP, payload)
    }

    fun setTransmission(active: Boolean): ByteArray {
        return command(CMD_SET_TRANSMISSION, byteArrayOf(if (active) 0x01 else 0x02))
    }

    fun setVolume(level: Int): ByteArray {
        return command(CMD_SET_VOLUME, byteArrayOf(level.coerceIn(1, 9).toByte()))
    }

    fun setMicGain(level: Int): ByteArray {
        return command(CMD_SET_MIC_GAIN, byteArrayOf(level.coerceIn(0, 5).toByte()))
    }

    fun setPowerSave(enabled: Boolean): ByteArray {
        return command(CMD_SET_POWER_SAVE, byteArrayOf(if (enabled) 0x01 else 0x02))
    }

    fun getVersion(): ByteArray {
        return command(CMD_GET_VERSION, payload = byteArrayOf(0x01))
    }

    fun getInitStatus(): ByteArray {
        return command(CMD_INIT_STATUS, mode = MODE_READ, payload = byteArrayOf())
    }

    fun command(
        command: Int,
        payload: ByteArray,
        mode: Int = MODE_WRITE,
        status: Int = STATUS_SET
    ): ByteArray {
        val packet = ByteArray(9 + payload.size)
        packet[0] = HEAD.toByte()
        packet[1] = command.toByte()
        packet[2] = mode.toByte()
        packet[3] = status.toByte()
        packet[4] = 0x00
        packet[5] = 0x00
        packet[6] = ((payload.size ushr 8) and 0xFF).toByte()
        packet[7] = (payload.size and 0xFF).toByte()
        payload.copyInto(packet, destinationOffset = 8)
        packet[packet.lastIndex] = TAIL.toByte()

        val checksum = internetChecksum(packet)
        packet[4] = ((checksum ushr 8) and 0xFF).toByte()
        packet[5] = (checksum and 0xFF).toByte()
        return packet
    }

    fun parseFrames(bytes: ByteArray): List<ComjotFrame> {
        val frames = mutableListOf<ComjotFrame>()
        var index = 0
        while (index <= bytes.size - 9) {
            if ((bytes[index].toInt() and 0xFF) != HEAD) {
                index++
                continue
            }

            val length = ((bytes[index + 6].toInt() and 0xFF) shl 8) or
                (bytes[index + 7].toInt() and 0xFF)
            val total = 9 + length
            if (index + total > bytes.size) {
                break
            }

            val packet = bytes.copyOfRange(index, index + total)
            if ((packet.last().toInt() and 0xFF) == TAIL && hasValidChecksum(packet)) {
                frames += ComjotFrame(
                    command = packet[1].toInt() and 0xFF,
                    mode = packet[2].toInt() and 0xFF,
                    status = packet[3].toInt() and 0xFF,
                    payload = packet.copyOfRange(8, 8 + length)
                )
                index += total
            } else {
                index++
            }
        }
        return frames
    }

    fun eventFrom(frame: ComjotFrame): ComjotEvent? {
        if (frame.command != CMD_EVENTS || frame.payload.isEmpty()) {
            return null
        }
        return ComjotEvent.fromCode(frame.payload[0].toInt() and 0xFF)
    }

    fun ByteArray.toHexString(): String {
        return joinToString(separator = "") { byte -> "%02X".format(byte.toInt() and 0xFF) }
    }

    private fun hasValidChecksum(packet: ByteArray): Boolean {
        val expected = ((packet[4].toInt() and 0xFF) shl 8) or (packet[5].toInt() and 0xFF)
        val copy = packet.copyOf()
        copy[4] = 0x00
        copy[5] = 0x00
        return internetChecksum(copy) == expected
    }

    private fun internetChecksum(bytes: ByteArray): Int {
        var sum = 0
        bytes.forEachIndexed { index, byte ->
            val value = byte.toInt() and 0xFF
            sum += if (index % 2 == 0) value shl 8 else value
            sum = (sum and 0xFFFF) + (sum ushr 16)
        }

        while ((sum ushr 16) > 0) {
            sum = (sum and 0xFFFF) + (sum ushr 16)
        }

        return sum xor 0xFFFF
    }

    private fun ByteArray.putIntLe(offset: Int, value: Long) {
        this[offset] = (value and 0xFF).toByte()
        this[offset + 1] = ((value ushr 8) and 0xFF).toByte()
        this[offset + 2] = ((value ushr 16) and 0xFF).toByte()
        this[offset + 3] = ((value ushr 24) and 0xFF).toByte()
    }

    private const val DIGITAL_CONTACT_REPEAT_COUNT = 5
}
