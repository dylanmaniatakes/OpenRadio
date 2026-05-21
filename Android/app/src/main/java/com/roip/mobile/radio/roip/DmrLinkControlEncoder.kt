package com.roip.mobile.radio.roip

// Minimal MMDVM/Homebrew DMR transmit-side encoding needed to key a linked talkgroup.
internal object DmrLinkControlEncoder {
    private const val DT_VOICE_LC_HEADER = 0x01
    private const val DT_TERMINATOR_WITH_LC = 0x02

    private val VOICE_LC_HEADER_CRC_MASK = intArrayOf(0x96, 0x96, 0x96)
    private val TERMINATOR_WITH_LC_CRC_MASK = intArrayOf(0x99, 0x99, 0x99)
    private val MS_SOURCED_AUDIO_SYNC = intArrayOf(0x07, 0xf7, 0xd5, 0xdd, 0x57, 0xdf, 0xd0)
    private val MS_SOURCED_DATA_SYNC = intArrayOf(0x0d, 0x5d, 0x7f, 0x77, 0xfd, 0x75, 0x70)
    private val SYNC_MASK = intArrayOf(0x0f, 0xff, 0xff, 0xff, 0xff, 0xff, 0xf0)

    private val DMR_SILENCE_DATA = byteArrayOf(
        0xb9.toByte(), 0xe8.toByte(), 0x81.toByte(), 0x52, 0x61, 0x73, 0x00, 0x2a, 0x6b,
        0xb9.toByte(), 0xe8.toByte(), 0x81.toByte(), 0x52, 0x60, 0x00, 0x00, 0x00, 0x00,
        0x00, 0x01, 0x73, 0x00, 0x2a, 0x6b, 0xb9.toByte(), 0xe8.toByte(), 0x81.toByte(),
        0x52, 0x61, 0x73, 0x00, 0x2a, 0x6b
    )

    fun voiceHeaderPayload(sourceId: Int, talkgroup: Int, colorCode: Int): ByteArray {
        return linkControlPayload(sourceId, talkgroup, colorCode, DT_VOICE_LC_HEADER, VOICE_LC_HEADER_CRC_MASK)
    }

    fun terminatorPayload(sourceId: Int, talkgroup: Int, colorCode: Int): ByteArray {
        return linkControlPayload(sourceId, talkgroup, colorCode, DT_TERMINATOR_WITH_LC, TERMINATOR_WITH_LC_CRC_MASK)
    }

    fun silenceVoicePayload(voiceFrameIndex: Int): ByteArray {
        val payload = DMR_SILENCE_DATA.copyOf()
        if (voiceFrameIndex % 6 == 0) {
            addSync(payload, MS_SOURCED_AUDIO_SYNC)
        }
        return payload
    }

    fun voicePayload(voiceFrameIndex: Int, ambeFrames: List<ByteArray>): ByteArray {
        require(ambeFrames.size == 3 && ambeFrames.all { it.size == 9 }) {
            "DMR voice payload requires three 9-byte AMBE frames"
        }

        val packedAmbe = ByteArray(27)
        ambeFrames[0].copyInto(packedAmbe, 0)
        ambeFrames[1].copyInto(packedAmbe, 9)
        ambeFrames[2].copyInto(packedAmbe, 18)

        val payload = ByteArray(33)
        System.arraycopy(packedAmbe, 0, payload, 0, 14)
        payload[19] = ((payload[19].unsigned() and 0xf0) or (packedAmbe[13].unsigned() and 0x0f)).toByte()
        System.arraycopy(packedAmbe, 14, payload, 20, 13)

        if (voiceFrameIndex % 6 == 0) {
            addSync(payload, MS_SOURCED_AUDIO_SYNC)
        }
        return payload
    }

    private fun linkControlPayload(
        sourceId: Int,
        talkgroup: Int,
        colorCode: Int,
        dataType: Int,
        crcMask: IntArray
    ): ByteArray {
        val linkControl = ByteArray(12)
        linkControl[0] = 0x00 // FLCO group voice channel user.
        linkControl[1] = 0x00 // ETSI feature set ID.
        linkControl[2] = 0x00
        writeUInt24(linkControl, 3, talkgroup)
        writeUInt24(linkControl, 6, sourceId)

        val parity = reedSolomon129(linkControl, 9)
        linkControl[9] = (parity[2] xor crcMask[0]).toByte()
        linkControl[10] = (parity[1] xor crcMask[1]).toByte()
        linkControl[11] = (parity[0] xor crcMask[2]).toByte()

        val payload = ByteArray(33)
        addSync(payload, MS_SOURCED_DATA_SYNC)
        addSlotType(payload, colorCode.coerceIn(0, 15), dataType)
        bptc19696Encode(linkControl, payload)
        return payload
    }

    private fun addSync(payload: ByteArray, sync: IntArray) {
        sync.forEachIndexed { index, value ->
            val payloadIndex = index + 13
            val existing = payload[payloadIndex].unsigned()
            payload[payloadIndex] = ((existing and SYNC_MASK[index].inv()) or value).toByte()
        }
    }

    private fun addSlotType(payload: ByteArray, colorCode: Int, dataType: Int) {
        val slotType0 = ((colorCode and 0x0f) shl 4) or (dataType and 0x0f)
        val checksum = golay2087Checksum(slotType0)
        val slotType1 = checksum and 0xff
        val slotType2 = (checksum ushr 8) and 0xff

        payload[12] = ((payload[12].unsigned() and 0xc0) or ((slotType0 ushr 2) and 0x3f)).toByte()
        payload[13] = (
            (payload[13].unsigned() and 0x0f) or
                ((slotType0 shl 6) and 0xc0) or
                ((slotType1 ushr 2) and 0x30)
            ).toByte()
        payload[19] = ((payload[19].unsigned() and 0xf0) or ((slotType1 ushr 2) and 0x0f)).toByte()
        payload[20] = (
            (payload[20].unsigned() and 0x03) or
                ((slotType1 shl 6) and 0xc0) or
                ((slotType2 ushr 2) and 0x3c)
            ).toByte()
    }

    private fun bptc19696Encode(input: ByteArray, output: ByteArray) {
        val dataBits = BooleanArray(96)
        input.take(12).forEachIndexed { index, value ->
            byteToBitsBe(value.unsigned(), dataBits, index * 8)
        }

        val deInterData = BooleanArray(196)
        var pos = 0
        BPTC_PAYLOAD_RANGES.forEach { range ->
            for (index in range) {
                deInterData[index] = dataBits[pos++]
            }
        }

        for (row in 0 until 9) {
            encodeHamming15113(deInterData, row * 15 + 1)
        }

        val column = BooleanArray(13)
        for (columnIndex in 0 until 15) {
            pos = columnIndex + 1
            for (row in 0 until 13) {
                column[row] = deInterData[pos]
                pos += 15
            }

            encodeHamming1393(column)

            pos = columnIndex + 1
            for (row in 0 until 13) {
                deInterData[pos] = column[row]
                pos += 15
            }
        }

        val rawData = BooleanArray(196)
        for (index in 0 until 196) {
            rawData[(index * 181) % 196] = deInterData[index]
        }

        for (index in 0..11) {
            output[index] = bitsToByteBe(rawData, index * 8).toByte()
        }

        val splitByte = bitsToByteBe(rawData, 96)
        output[12] = ((output[12].unsigned() and 0x3f) or (splitByte and 0xc0)).toByte()
        output[20] = ((output[20].unsigned() and 0xfc) or ((splitByte ushr 4) and 0x03)).toByte()

        for (index in 21..32) {
            output[index] = bitsToByteBe(rawData, 100 + ((index - 21) * 8)).toByte()
        }
    }

    private fun encodeHamming15113(bits: BooleanArray, offset: Int) {
        bits[offset + 11] = bits[offset + 0] xor bits[offset + 1] xor bits[offset + 2] xor
            bits[offset + 3] xor bits[offset + 5] xor bits[offset + 7] xor bits[offset + 8]
        bits[offset + 12] = bits[offset + 1] xor bits[offset + 2] xor bits[offset + 3] xor
            bits[offset + 4] xor bits[offset + 6] xor bits[offset + 8] xor bits[offset + 9]
        bits[offset + 13] = bits[offset + 2] xor bits[offset + 3] xor bits[offset + 4] xor
            bits[offset + 5] xor bits[offset + 7] xor bits[offset + 9] xor bits[offset + 10]
        bits[offset + 14] = bits[offset + 0] xor bits[offset + 1] xor bits[offset + 2] xor
            bits[offset + 4] xor bits[offset + 6] xor bits[offset + 7] xor bits[offset + 10]
    }

    private fun encodeHamming1393(bits: BooleanArray) {
        bits[9] = bits[0] xor bits[1] xor bits[3] xor bits[5] xor bits[6]
        bits[10] = bits[0] xor bits[1] xor bits[2] xor bits[4] xor bits[6] xor bits[7]
        bits[11] = bits[0] xor bits[1] xor bits[2] xor bits[3] xor bits[5] xor bits[7] xor bits[8]
        bits[12] = bits[0] xor bits[2] xor bits[4] xor bits[5] xor bits[8]
    }

    private fun reedSolomon129(message: ByteArray, length: Int): IntArray {
        val parity = IntArray(3)
        repeat(length) { index ->
            val dbyte = message[index].unsigned() xor parity[2]
            parity[2] = parity[1] xor gf256Multiply(14, dbyte)
            parity[1] = parity[0] xor gf256Multiply(56, dbyte)
            parity[0] = gf256Multiply(64, dbyte)
        }
        return parity
    }

    private fun gf256Multiply(a: Int, b: Int): Int {
        var left = a and 0xff
        var right = b and 0xff
        var product = 0
        while (right > 0) {
            if ((right and 0x01) != 0) {
                product = product xor left
            }
            left = left shl 1
            if ((left and 0x100) != 0) {
                left = left xor 0x11d
            }
            right = right ushr 1
        }
        return product and 0xff
    }

    private fun golay2087Checksum(value: Int): Int {
        return when (value and 0xff) {
            0x01 -> 0xb08e
            0x02 -> 0xe093
            0x11 -> 0xc0b8
            0x12 -> 0x90a5
            0x21 -> 0x60e2
            0x22 -> 0x30ff
            0x31 -> 0x10d4
            0x32 -> 0x40c9
            0x41 -> 0x2057
            0x42 -> 0x704a
            0x51 -> 0x5061
            0x52 -> 0x007c
            0x61 -> 0xf03b
            0x62 -> 0xa026
            0x71 -> 0x800d
            0x72 -> 0xd010
            0x81 -> 0x10b3
            0x82 -> 0x40ae
            0x91 -> 0x6085
            0x92 -> 0x3098
            0xa1 -> 0xc0df
            0xa2 -> 0x90c2
            0xb1 -> 0xb0e9
            0xb2 -> 0xe0f4
            0xc1 -> 0x806a
            0xc2 -> 0xd077
            0xd1 -> 0xf05c
            0xd2 -> 0xa041
            0xe1 -> 0x5006
            0xe2 -> 0x001b
            0xf1 -> 0x2030
            0xf2 -> 0x702d
            else -> error("Unsupported DMR slot type value $value")
        }
    }

    private fun writeUInt24(target: ByteArray, offset: Int, value: Int) {
        target[offset] = ((value ushr 16) and 0xff).toByte()
        target[offset + 1] = ((value ushr 8) and 0xff).toByte()
        target[offset + 2] = (value and 0xff).toByte()
    }

    private fun byteToBitsBe(value: Int, target: BooleanArray, offset: Int) {
        repeat(8) { bit ->
            target[offset + bit] = (value and (0x80 ushr bit)) != 0
        }
    }

    private fun bitsToByteBe(bits: BooleanArray, offset: Int): Int {
        var value = 0
        repeat(8) { bit ->
            if (bits[offset + bit]) {
                value = value or (0x80 ushr bit)
            }
        }
        return value
    }

    private fun Byte.unsigned(): Int = toInt() and 0xff

    private val BPTC_PAYLOAD_RANGES = listOf(
        4..11,
        16..26,
        31..41,
        46..56,
        61..71,
        76..86,
        91..101,
        106..116,
        121..131
    )
}
