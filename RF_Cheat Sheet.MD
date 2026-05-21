# ComJot DMR Radio Module – Android API Cheat‑Sheet

A condensed, developer‑friendly reference for the serial protocol that drives the ComJot CJ‑1 radio board. 
*(Firmware revision 2025‑04‑18; verified over USB‑UART @ 115 200 bps.)*

---

## 1  Packet Grammar (applies to every command)

| Byte(s) | Field     | Notes                                                                         |
|---------|-----------|-------------------------------------------------------------------------------|
| 0       | **HEAD**  | Always `0x68`                                                                 |
| 1       | **CMD**   | Command ID (see tables below)                                                 |
| 2       | **R/W**   | `0x00` = read, `0x01` = write, `0x02` = unsolicited report                    |
| 3       | **S/R**   | **When you send:** `0x01`.<br>**Module replies:** `0x00` = OK, `0x01` = fail, `0x02` = checksum error |
| 4‑5     | **CKSUM** | 16‑bit Internet checksum over **HEAD…LEN** (little‑endian)                    |
| 6‑7     | **LEN**   | Byte‑count of **DATA** (little‑endian)                                        |
| 8…n‑1   | **DATA**  | Payload (structure varies per command)                                        |
| n       | **TAIL**  | Always `0x10`                                                                 |

> **Android tip:** build the packet in a `ByteBuffer`, calculate the checksum *just before* calling `UsbSerialPort.write()`.

---

## 2  Quick‑Start Workflow

1. **Power‑on wait:** give the RF board **5 s** to boot.  
2. **Program a channel:** send **`0x22 Set Digital Group`** (DMR) *or* **`0x23 Set Analog Group`** (FM).  
3. **Transmit:** pull PTT low **or** send **`0x26 Set Transmission`** with `DATA = 0x01`.  
4. **Hang up:** send **`0x26`** again with `DATA = 0x02`.  
5. **Monitor events:** listen for unsolicited **`0x36`** packets (RX/TX state, SMS arrival, channel busy, …).

---

## 3  Command Reference

### 3.1 Channel & Audio Setup

| CMD | Name                 | Purpose / Key Fields                                               |
|-----|----------------------|--------------------------------------------------------------------|
| `0x22` | **Set Digital Group** | Full DMR profile: Rx/Tx freq, Local ID, Group list, slots, power, encryption key, … |
| `0x23` | **Set Analog Group**  | FM equivalent (wide/narrow, CTCSS/DCS, squelch, …)              |
| `0x2A` | **Set MIC Gain**      | `0 – 5` → 0 dB … +20 dB                                          |
| `0x2E` | **Set Volume**        | Levels `1 – 9`                                                  |
| `0x2F` | **Set Monitor**       | `1` = open squelch, `2` = close                                  |
| `0x30` | **Set Squelch**       | SQL level `0 – 9`                                               |
| `0x31` | **Set Power‑Save**    | `1` = enable, `2` = disable                                     |
| `0x3B` | **Set TOT**           | Time‑out timer in seconds (`0` = off)                           |
| `0x3C` | **Set SPK_EN Delay**  | Speaker tail in ms (`0` = off)                                  |

### 3.2 On‑Air Control

| CMD | Name                | Notes                                                                 |
|-----|---------------------|-----------------------------------------------------------------------|
| `0x26` | **Set Transmission** | `0x01` = start PTT, `0x02` = stop PTT                              |
| `0x28` | **Enhanced Function**| Remote **kill / stun / revive / monitor / call‑alert**; `FUN` selects feature |
| `0x29` | **Encryption**       | Toggle & load 8‑byte key; both ends must match                    |
| `0x33` | **Repeater Decoupling** | Enables “talk‑around” (simplex on repeater pair)               |
| `0x37` | **Strategy**         | `0` = **impolite** (TX regardless), `1` = **polite** (carrier‑sense) |

### 3.3 Analog DTMF Control

| CMD   | Name             | Notes                                                                                   |
|-------|------------------|-----------------------------------------------------------------------------------------|
| `0x3D`| **Send DTMF**    | Transmit a DTMF digit string in analog mode:<br>`DATA` = [digits in ASCII] padded to N bytes.<br>Module will generate standard 697–1633 Hz tones on the RF output. |
| `0x3E`| **DTMF Config**  | Configure DTMF parameters:<br>`DATA[0]` = tone duration (20–1000 ms)<br>`DATA[1]` = inter-digit gap (20–1000 ms).           |

> **Android tip:** build the ASCII digit string into your `DATA` payload, then call `UsbSerialPort.write()` to send DTMF over the air. Ensure you respect CFR part 90 timing for compliant operation.

### 3.4 Telemetry & Queries

| CMD | Name              | Return Data                                                 |
|-----|-------------------|-------------------------------------------------------------|
| `0x27` | **Init Status**     | OK when analog IC boot‑up complete                      |
| `0x2B` | **Get Digital RX**  | Call type + caller ID of last voice burst               |
| `0x32` | **Get RSSI**        | Instantaneous dBm                                       |
| `0x34` | **Get Version**     | Firmware string                                         |
| `0x35` | **Keypad Test**     | Engineering volume‑up/down, etc.                        |
| `0x36` | **Power‑On / Events** | Unsolicited: RX/TX start/end, SMS status, channel busy… |
| `0x38` | **Mixed‑Mode Check** | Load combined digital + analog profile for auto‑detect |

### 3.5 Short‑Message Service (DMR SDS)

| CMD | Purpose            | Key Fields                                                              |
|-----|--------------------|-------------------------------------------------------------------------|
| `0x2C` | **Send SMS**        | `MsgType`: `0x01` = confirmed, `0x02` = unconfirmed, `0x03` = group; then **CallNum** + UTF‑16 text |
| `0x2D` | **Get SMS**         | Poll for pending; reply has sender type + ID + UTF‑16 message        |
| `0x3A` | **Set SMS Format**  | `0x00` = IP‑style (default), `0x01` = user‑defined, `0x02` = compressed IP |

---

## 4  Struct Definitions

### DB_DIGITAL_INFO (CMD 0x22 Payload)

| Field            | Type    | Range / Default        | Description                                        |
|------------------|---------|------------------------|----------------------------------------------------|
| `rx_freq`        | uint32  | 400 000 000–480 000 000 Hz (401.0250 MHz) | Receive frequency                             |
| `tx_freq`        | uint32  | 400 000 000–480 000 000 Hz (401.0250 MHz) | Transmit frequency                            |
| `localID`        | uint32  | 1–16 776 415 (888)     | Local radio ID (default 888)                      |
| `GroupList[32]`  | uint32  | 1 (all slots)          | Receive group list (max 32 entries)               |
| `tx_contact`     | uint32  | 1–16 776 415 (all-call 0xFFFFF0–0xFFFFFF) | Transmission target ID        |
| `ContactType`    | uint8   | 0=private,1=group,2=all (default 1) | Call type                             |
| `power`          | uint8   | 0=low,1=high (default 1) | TX power                                  |
| `cc`             | uint8   | 0–15 (default 1)       | Color code                                        |
| `InboundSlot`    | uint8   | 0–1 (default 0)        | Time-slot inbound                                  |
| `OutboundSlot`   | uint8   | 0–1 (default 0)        | Time-slot outbound                                 |
| `ChannelMode`    | uint8   | 0=simplex,4=TDMA (default 0) | Channel mode                       |
| `EncryptSw`      | uint8   | 1=enable,2=disable (default 2) | Encryption switch                    |
| `EncryptKey[8]`  | uint8   | 8 bytes                | AES key                                            |
| `pwrsave`        | uint8   | 1=enable,2=disable (default 1) | Power-save mode                     |
| `volume`         | uint8   | 1–9 (default 8)        | Speaker volume                                     |
| `mic`            | uint8   | 0–5 (default 0)        | Microphone gain                                    |
| `relay`          | uint8   | 1=enable,2=disable (default 2) | Repeater decoupling                   |

### DB_ANALOG_INFO (CMD 0x23 Payload)

| Field            | Type    | Range / Default        | Description                                        |
|------------------|---------|------------------------|----------------------------------------------------|
| `rx_freq`        | uint32  | 400 000 000–480 000 000 Hz | Receive frequency                                |
| `tx_freq`        | uint32  | 400 000 000–480 000 000 Hz | Transmit frequency                               |
| `band`           | uint8   | 0=narrow,1=wide (default 0) | Channel bandwidth                       |
| `power`          | uint8   | 0=low,1=high (default 1) | TX power                                  |
| `sq`             | uint8   | 0–9 (default 5)        | Squelch level                                      |
| `rx_type`        | uint8   | 0=off,1=CTCSS,2=DCS-F,3=DCS-R | Receive tone mode                    |
| `rx_subcode`     | uint8   | depends on `rx_type`   | CTCSS/DCS subcode                                 |
| `tx_type`        | uint8   | 0=off,1=CTCSS,2=DCS-F,3=DCS-R | Transmit tone mode                   |
| `tx_subcode`     | uint8   | depends on `tx_type`   | CTCSS/DCS subcode                                 |
| `pwrsave`        | uint8   | 1=enable,2=disable (default 1) | Power-save mode                     |
| `volume`         | uint8   | 1–9 (default 8)        | Speaker volume                                     |
| `monitor`        | uint8   | 1=enable,2=disable (default 1) | Monitor (open squelch)                |
| `relay`          | uint8   | 1=enable,2=disable (default 2) | Repeater decoupling                   |

## 6  Usage Examples

### Digital Intercom Sequence fileciteturn2file8

1. Send `Set Digital Group` (0x22) with matching RX/TX and contact settings.
2. Lower PTT (hardware) or send `Set Transmission` (0x26 DATA=0x01).
3. Upon `0x36 DATA=0x01` play audio; on `0x36 DATA=0x02` stop.
4. End TX via `0x26 DATA=0x02`.

### Analog Intercom Sequence fileciteturn2file8

1. Send `Set Analog Group` (0x23) with desired tone, power, squelch.
2. Lower PTT or send `Set Transmission` (0x26 DATA=0x01).
3. Handle `0x36` events for RX/TX as above.

### Contact Parameter Examples fileciteturn2file10

- **Private call A→B:** A.localID=8, B.localID=1, both GroupList empty.
- **Group call on ID 6:** both localID set, GroupList includes 6.
- **All call broadcast:** tx_contact=0xFFFFFF (16777215).

## 7  Kotlin Helper Snippets

```kotlin
/** 16‑bit Internet checksum (little‑endian) */
fun calcCksum(buf: ByteArray, len: Int): Short {
    var sum = 0u
    var i = 0
    var remain = len
    while (remain > 1) {
        sum += (((buf[i].toInt() and 0xFF) shl 8) or (buf[i + 1].toInt() and 0xFF)).toUInt()
        i += 2; remain -= 2
    }
    if (remain == 1) sum += ((buf[i].toInt() and 0xFF) shl 8).toUInt()
    while ((sum shr 16) != 0u) sum = (sum and 0xFFFFu) + (sum shr 16)
    return (sum xor 0xFFFFu).toShort()
}

/** Build a minimal “Set Digital Group” packet */
fun setDigital(
    rxHz: Long,
    txHz: Long,
    localId: Long,
    groupId: Long,
    slot: Int = 0
): ByteArray {
    val payload = ByteBuffer.allocate(0xA3).order(ByteOrder.LITTLE_ENDIAN).apply {
        putInt(rxHz.toInt()); putInt(txHz.toInt())
        putInt(localId.toInt())
        putInt(groupId.toInt())          // GroupList[0]
        position(0x24); putInt(groupId.toInt()) // tx_contact
        position(0x28); put(1)           // ContactType = group
        position(0x2B); put(1)           // Colour code = 1
        position(0x2C); put(slot.toByte()) // InboundSlot
        position(0x2D); put(slot.toByte()) // OutboundSlot
    }.array()

    val len = payload.size
    val pkt = ByteBuffer.allocate(9 + len).order(ByteOrder.LITTLE_ENDIAN)
    pkt.put(0x68)
    pkt.put(0x22)          // CMD
    pkt.put(0x01)          // write
    pkt.put(0x01)          // set
    pkt.putShort(0)        // CKSUM placeholder
    pkt.putShort(len.toShort())
    pkt.put(payload)
    pkt.put(0x10)
    val arr = pkt.array()
    val cksum = calcCksum(arr, arr.size - 4)
    arr[4] = cksum.toByte(); arr[5] = (cksum.toInt() ushr 8).toByte()
    return arr
}
```

*Add `Log.d(TAG, "TX → ${arr.toHexString()}")` and matching RX prints around every serial call for easy debugging.*

---

## 8  Field‑Value Crib Sheet

| Field             | Typical Range / Options              | Comment                                   |
|-------------------|--------------------------------------|-------------------------------------------|
| **rx_freq / tx_freq** | 400 000 000 – 480 000 000 Hz        | 32‑bit little‑endian (Hz)                 |
| **localID**          | 1 – 16 777 215                     | Your radio’s DMR ID                       |
| **GroupList[32]**    | up to 32 IDs                       | IDs to monitor in standby                 |
| **tx_contact**       | Single ID                          | Private, group, or all‑call               |
| **cc**               | 0 – 15                            | DMR Colour Code                           |
| **InboundSlot / OutboundSlot** | `0` or `1`              | Time slot numbers                         |
| **ChannelMode**      | 0 = simplex, 4 = real‑time (TDMA)  |                                           |
| **EncryptKey[8]**    | 8 bytes                            | Proprietary stream cipher                 |

---

## 9  Troubleshooting

| Symptom                                   | Likely Cause / Fix                                                         |
|-------------------------------------------|----------------------------------------------------------------------------|
| **No RX audio**                           | Ensure `SPK_EN` pin high and AUDIO_OUT routed through codec/amp            |
| **Reply with `0x02` (checksum error)**    | Verify checksum covers **HEAD…LEN** only (stop before DATA)               |
| **Silence after power‑on**                | Keep polling `0x27 Init Status` until it returns OK                        |
| **Frequent “Channel busy” events**        | You are in *polite* mode; either wait or switch to *impolite* via `0x37`   |

---

## 10  Serial-Port & USB Setup

- **UART parameters:** 115200 bps, 8 data bits, no parity, 1 stop bit.
- **Android USB-host:**  
  1. Add `<uses-feature android:name="android.hardware.usb.host" />` to `AndroidManifest.xml`.  
  2. Declare the USB device filter in `res/xml/device_filter.xml`.  
  3. Request permission at runtime via `UsbManager.requestPermission()`.  
  4. On grant, `UsbSerialPort.open()` and configure with the UART params.

## 11  Common Enumerations

| Name            | Value(s)                                        | Meaning                         |
|-----------------|-------------------------------------------------|---------------------------------|
| **ContactType** | `0`=private, `1`=group, `2`=all-call            | DMR call type selector          |
| **ChannelMode** | `0`=simplex, `4`=real-time (TDMA)               | Digital channel mode            |
| **MsgType**     | `1`=confirmed, `2`=unconfirmed, `3`=group       | SDS message type                |
| **FUN codes**   | `0`=kill, `1`=stun, `2`=revive, `3`=monitor, `4`=alert` | Enhanced-function sub-commands |

## 12  Unsolicited Events (CMD 0x36)

| Event Code | Meaning                                                      | Action Required        |
|------------|--------------------------------------------------------------|------------------------|
| `0x01`     | RX start                                                     | Play audio             |
| `0x02`     | RX end                                                       | Stop audio             |
| `0x03`     | TX start                                                     | Indicate PTT active    |
| `0x04`     | TX end                                                       | Indicate PTT released  |
| `0x05`     | SMS received                                                 | Poll SMS with 0x2D     |
| `0x06`     | Repeater activation timeout                                  | Handle repeater error  |
| `0x07`     | Channel busy (transmission prohibited)                       | Back off / retry       |
| `0x08`     | Confirmed SMS transmission successful                        | Notify success         |
| `0x09`     | Confirmed SMS transmission failed                            | Notify failure         |
| `0x0A`     | Digital-analog sync digital RX start                         | Log sync event         |
| `0x0B`     | Digital-analog sync digital RX end                           | Log sync event         |
| `0x0C`     | Digital-analog sync analog RX start                          | Log sync event         |
| `0x0D`     | Digital-analog sync analog RX end                            | Log sync event         |

**ACK format**  
```
68 36 01 01 XX XX 00 00 10
```  
where `XX XX` is the checksum over bytes 0–7 (HEAD…LEN).

## 13  Checksum Algorithm Details

A simplified pseudocode for the Internet checksum (§1.1.4):

```text
sum = 0
for each 16-bit word w in HEAD..LEN:
    sum += w
if there's a leftover byte b:
    sum += b << 8
while sum > 0xFFFF:
    sum = (sum & 0xFFFF) + (sum >> 16)
checksum = ~sum & 0xFFFF
```

## 14  Example RX Parser Snippet

```kotlin
val buffer = ByteArray(256)
var index = 0
while (true) {
  val len = serialPort.read(buffer, 1000)
  // find HEAD (0x68) and TAIL (0x10)
  for (i in 0 until len) {
    if (buffer[i] == 0x68.toByte()) {
      val cmd = buffer[i+1]
      val dataLen = ByteBuffer.wrap(buffer, i+6, 2).order(ByteOrder.LITTLE_ENDIAN).short.toInt()
      val packet = buffer.copyOfRange(i, i + 8 + dataLen)
      val checksum = calcCksum(packet, packet.size - 4)
      if (checksum == ByteBuffer.wrap(packet, 4, 2).order(ByteOrder.LITTLE_ENDIAN).short) {
        handlePacket(cmd, packet.sliceArray(8 until 8+dataLen))
      }
    }
  }
}
```

## 15  SMS Encoding Notes

- **Text format:** UTF-16LE without BOM.
- **Building payload:**
  ```kotlin
  val textBytes = message.toByteArray(Charsets.UTF_16LE)
  val payload = ByteArray(2 + textBytes.size)
  payload[0] = msgType
  payload[1] = targetId.toByte()
  System.arraycopy(textBytes, 0, payload, 2, textBytes.size)
  ```

## 16  Version & Capabilities Query

If the module supports feature flags, use `Get Version` (CMD `0x34`) to retrieve a string like:
```
CJ1 v2.3 CRC|AES|DTMF
```
- **CRC**: checksum validation supported  
- **AES**: encryption available  
- **DTMF**: analog DTMF Tx supported  

---