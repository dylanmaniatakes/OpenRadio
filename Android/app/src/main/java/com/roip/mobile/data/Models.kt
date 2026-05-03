package com.roip.mobile.data

enum class ProviderField {
    USERNAME,
    CALLSIGN,
    STATION_ID,
    TARGET,
    SERVER_HOST,
    SERVER_PORT,
    TIME_SLOT,
    PASSWORD,
    API_KEY
}

enum class HotspotField {
    LATITUDE,
    LONGITUDE,
    HEIGHT,
    LOCATION,
    DESCRIPTION,
    URL,
    SOFTWARE,
    PACKAGE_ID,
    SLOT_FLAGS
}

enum class ComjotField {
    MODE,
    RX_FREQUENCY,
    TX_FREQUENCY,
    LOCAL_ID,
    TALKGROUP,
    COLOR_CODE,
    TIME_SLOT,
    BANDWIDTH,
    SQUELCH,
    RX_TONE_MODE,
    RX_TONE_CODE,
    TX_TONE_MODE,
    TX_TONE_CODE,
    RF_POWER,
    VOLUME,
    MIC_GAIN,
    REPEATER_DECOUPLING,
    BAUD_RATE
}

enum class KnobControlMode(val title: String) {
    VOLUME("Android Vol"),
    FREQUENCY("Frequency"),
    MEMORIES("Memories")
}

enum class ComjotMode(
    val title: String,
    val subtitle: String,
    val txEnabled: Boolean
) {
    DMR(
        title = "DMR",
        subtitle = "Digital group call",
        txEnabled = true
    ),
    FM(
        title = "FM",
        subtitle = "Analog VHF/UHF",
        txEnabled = true
    ),
    ROIP(
        title = "ROIP",
        subtitle = "Network radio",
        txEnabled = false
    ),
    SCANNER(
        title = "Scanner",
        subtitle = "RX only",
        txEnabled = false
    )
}

enum class ComjotBandwidth(val title: String, val protocolValue: Int) {
    NARROW("Narrow", 0),
    WIDE("Wide", 1)
}

enum class ComjotRfPower(val title: String, val highPower: Boolean) {
    LOW("Low", false),
    HIGH("High", true)
}

enum class ComjotToneMode(
    val title: String,
    val protocolValue: Int,
    val defaultCode: String
) {
    OFF("Off", 0, "None"),
    CTCSS("PL", 1, "67.0"),
    DCS("DCS", 2, "023"),
    REVERSE_DCS("R-DCS", 3, "023");

    val needsCode: Boolean
        get() = this != OFF
}

enum class MemoryType(val title: String) {
    REPEATER("Repeater"),
    DMR_NODE("DMR Node"),
    ROIP_FAVORITE("ROIP")
}

enum class RoipOperationMode(val title: String) {
    DIRECT("Direct ROIP"),
    HOTSPOT("Hotspot")
}

enum class AccentColor(
    val title: String,
    val lightPrimary: Long,
    val darkPrimary: Long
) {
    GREEN("Green", 0xFF0E6B57, 0xFF66D3B2),
    BLUE("Blue", 0xFF1F5FA8, 0xFF8BBEFF),
    CYAN("Cyan", 0xFF006B76, 0xFF67DDEB),
    TEAL("Teal", 0xFF006A60, 0xFF72D8C9),
    LIME("Lime", 0xFF4B6400, 0xFFC4E96B),
    AMBER("Amber", 0xFF7A5C00, 0xFFE2C36B),
    ORANGE("Orange", 0xFF9B4E00, 0xFFFFB77A),
    RED("Red", 0xFFB3261E, 0xFFFFB4AB),
    MAGENTA("Magenta", 0xFF9B3F72, 0xFFFFA6CE),
    VIOLET("Violet", 0xFF6D4BB0, 0xFFD1BCFF)
}

enum class ProviderType(
    val providerId: String,
    val title: String,
    val subtitle: String,
    val stationIdLabel: String,
    val targetLabel: String,
    val defaultHost: String,
    val defaultPort: Int,
    val defaultTarget: String,
    val helperText: String
) {
    BRANDMEISTER(
        providerId = "brandmeister",
        title = "BrandMeister",
        subtitle = "DMR talkgroups over hotspot-style login",
        stationIdLabel = "Hotspot ID",
        targetLabel = "Talkgroup",
        defaultHost = "3102.master.brandmeister.network",
        defaultPort = 62031,
        defaultTarget = "91",
        helperText = "Use your callsign, a hotspot ID, preferred master host, and your hotspot security password."
    ),
    TGIF(
        providerId = "tgif",
        title = "TGIF",
        subtitle = "DMR talkgroup switching",
        stationIdLabel = "Hotspot ID",
        targetLabel = "Talkgroup",
        defaultHost = "tgif.network",
        defaultPort = 62031,
        defaultTarget = "31665",
        helperText = "Fits the same DMR hotspot flow, so the app can treat it like another talkgroup provider."
    ),
    FREEDMR(
        providerId = "freedmr",
        title = "FreeDMR",
        subtitle = "Alternative DMR network preset",
        stationIdLabel = "Hotspot ID",
        targetLabel = "Talkgroup",
        defaultHost = "master.freedmr.uk",
        defaultPort = 62031,
        defaultTarget = "91",
        helperText = "Use a numeric station ID, talkgroup, and the network master you want to enter through."
    ),
    ALLSTAR(
        providerId = "allstar",
        title = "AllStar",
        subtitle = "Node-to-node style linking over data",
        stationIdLabel = "Local Node",
        targetLabel = "Remote Node",
        defaultHost = "allstar.example.net",
        defaultPort = 4569,
        defaultTarget = "",
        helperText = "Use your IAX username/secret, call the local node on your server, and optionally auto-link a remote node."
    )
}

data class ProviderProfile(
    val type: ProviderType,
    val username: String = "",
    val callsign: String,
    val stationId: String,
    val target: String,
    val serverHost: String,
    val serverPort: String,
    val timeSlot: String = "2",
    val password: String,
    val apiKey: String = ""
) {
    companion object {
        fun defaults(type: ProviderType): ProviderProfile {
            return ProviderProfile(
                type = type,
                username = "",
                callsign = "",
                stationId = "",
                target = type.defaultTarget,
                serverHost = type.defaultHost,
                serverPort = type.defaultPort.toString(),
                timeSlot = if (type == ProviderType.ALLSTAR) "iaxrpt" else "2",
                password = "",
                apiKey = ""
            )
        }
    }

    fun withField(field: ProviderField, value: String): ProviderProfile {
        return when (field) {
            ProviderField.USERNAME -> copy(username = value)
            ProviderField.CALLSIGN -> copy(callsign = value)
            ProviderField.STATION_ID -> copy(stationId = value)
            ProviderField.TARGET -> copy(target = value)
            ProviderField.SERVER_HOST -> copy(serverHost = value)
            ProviderField.SERVER_PORT -> copy(serverPort = value)
            ProviderField.TIME_SLOT -> copy(timeSlot = value)
            ProviderField.PASSWORD -> copy(password = value)
            ProviderField.API_KEY -> copy(apiKey = value)
        }
    }
}

data class SessionSnapshot(
    val id: String,
    val providerId: String,
    val providerName: String,
    val phase: String,
    val statusMessage: String,
    val target: String,
    val serverHost: String,
    val transport: String,
    val warnings: List<String>,
    val pttActive: Boolean,
    val requiresMediaBridge: Boolean,
    val inboundDmrFrames: Int = 0,
    val inboundDmrVoiceFrames: Int = 0,
    val inboundDmrDataFrames: Int = 0,
    val inboundAmbeFrames: Int = 0,
    val lastInboundDmrAtMillis: Long? = null,
    val lastInboundSourceId: Int? = null,
    val lastInboundCallsign: String? = null,
    val lastInboundName: String? = null,
    val lastInboundLocation: String? = null,
    val lastInboundTargetId: Int? = null,
    val lastInboundStreamId: Long? = null,
    val lastInboundSlot: Int? = null,
    val lastInboundFrameType: String? = null,
    val audioDecoderState: String? = null
)

data class HotspotProfile(
    val latitude: String = "0.000000",
    val longitude: String = "0.000000",
    val height: String = "0",
    val location: String = "OpenRadio CJ1",
    val description: String = "CJ-1 OpenRadio",
    val url: String = "www.mmdvm.net",
    val software: String = "20200922",
    val packageId: String = "MMDVM_MMDVM_HS_Hat",
    val slotFlags: String = "4"
) {
    fun withField(field: HotspotField, value: String): HotspotProfile {
        return when (field) {
            HotspotField.LATITUDE -> copy(latitude = value)
            HotspotField.LONGITUDE -> copy(longitude = value)
            HotspotField.HEIGHT -> copy(height = value)
            HotspotField.LOCATION -> copy(location = value)
            HotspotField.DESCRIPTION -> copy(description = value)
            HotspotField.URL -> copy(url = value)
            HotspotField.SOFTWARE -> copy(software = value)
            HotspotField.PACKAGE_ID -> copy(packageId = value)
            HotspotField.SLOT_FLAGS -> copy(slotFlags = value)
        }
    }
}

data class ComjotProfile(
    val mode: ComjotMode = ComjotMode.DMR,
    val rxFrequency: String = "446.5000",
    val txFrequency: String = "446.5000",
    val localId: String = "",
    val talkgroup: String = "91",
    val colorCode: String = "1",
    val timeSlot: String = "1",
    val bandwidth: ComjotBandwidth = ComjotBandwidth.NARROW,
    val squelch: String = "5",
    val rxToneMode: ComjotToneMode = ComjotToneMode.OFF,
    val rxToneCode: String = "None",
    val txToneMode: ComjotToneMode = ComjotToneMode.OFF,
    val txToneCode: String = "None",
    val rfPower: ComjotRfPower = ComjotRfPower.HIGH,
    val volume: String = "6",
    val micGain: String = "0",
    val repeaterDecoupling: Boolean = false,
    val baudRate: String = "57600"
) {
    fun withField(field: ComjotField, value: String): ComjotProfile {
        return when (field) {
            ComjotField.MODE -> {
                val nextMode = ComjotMode.entries.firstOrNull { it.name == value } ?: mode
                if (nextMode == ComjotMode.SCANNER) {
                    copy(mode = nextMode, txFrequency = rxFrequency)
                } else {
                    copy(mode = nextMode)
                }
            }
            ComjotField.RX_FREQUENCY -> if (mode == ComjotMode.SCANNER) {
                copy(rxFrequency = value, txFrequency = value)
            } else {
                copy(rxFrequency = value)
            }
            ComjotField.TX_FREQUENCY -> copy(txFrequency = value)
            ComjotField.LOCAL_ID -> copy(localId = value)
            ComjotField.TALKGROUP -> copy(talkgroup = value)
            ComjotField.COLOR_CODE -> copy(colorCode = value)
            ComjotField.TIME_SLOT -> copy(timeSlot = value)
            ComjotField.BANDWIDTH -> copy(
                bandwidth = ComjotBandwidth.entries.firstOrNull { it.name == value } ?: bandwidth
            )
            ComjotField.SQUELCH -> copy(squelch = value)
            ComjotField.RX_TONE_MODE -> {
                val toneMode = ComjotToneMode.entries.firstOrNull { it.name == value } ?: rxToneMode
                copy(rxToneMode = toneMode, rxToneCode = toneMode.defaultCodeFor(rxToneCode))
            }
            ComjotField.RX_TONE_CODE -> copy(rxToneCode = value)
            ComjotField.TX_TONE_MODE -> {
                val toneMode = ComjotToneMode.entries.firstOrNull { it.name == value } ?: txToneMode
                copy(txToneMode = toneMode, txToneCode = toneMode.defaultCodeFor(txToneCode))
            }
            ComjotField.TX_TONE_CODE -> copy(txToneCode = value)
            ComjotField.RF_POWER -> copy(
                rfPower = ComjotRfPower.entries.firstOrNull { it.name == value } ?: rfPower
            )
            ComjotField.VOLUME -> copy(volume = value)
            ComjotField.MIC_GAIN -> copy(micGain = value)
            ComjotField.REPEATER_DECOUPLING -> copy(repeaterDecoupling = value.toBooleanStrictOrNull() ?: repeaterDecoupling)
            ComjotField.BAUD_RATE -> copy(baudRate = value)
        }
    }

    private fun ComjotToneMode.defaultCodeFor(currentCode: String): String {
        if (!needsCode) {
            return defaultCode
        }
        val availableCodes = if (this == ComjotToneMode.CTCSS) {
            COMJOT_CTCSS_CODES
        } else {
            COMJOT_DCS_CODES
        }
        return currentCode.takeIf { it in availableCodes } ?: defaultCode
    }
}

data class RadioMemory(
    val id: String,
    val name: String,
    val type: MemoryType,
    val mode: ComjotMode,
    val rxFrequency: String,
    val txFrequency: String,
    val localId: String,
    val talkgroup: String,
    val colorCode: String,
    val timeSlot: String,
    val bandwidth: ComjotBandwidth,
    val squelch: String,
    val rxToneMode: ComjotToneMode,
    val rxToneCode: String,
    val txToneMode: ComjotToneMode,
    val txToneCode: String,
    val rfPower: ComjotRfPower,
    val volume: String,
    val micGain: String,
    val repeaterDecoupling: Boolean,
    val providerId: String? = null,
    val providerTitle: String? = null,
    val providerTarget: String? = null,
    val providerHost: String? = null
)

val COMJOT_CTCSS_CODES = listOf(
    "None",
    "67.0",
    "69.3",
    "71.9",
    "74.4",
    "77.0",
    "79.7",
    "82.5",
    "85.4",
    "88.5",
    "91.5",
    "94.8",
    "97.4",
    "100.0",
    "103.5",
    "107.2",
    "110.9",
    "114.8",
    "118.8",
    "123.0",
    "127.3",
    "131.8",
    "136.5",
    "141.3",
    "146.2",
    "151.4",
    "156.7",
    "159.8",
    "162.2",
    "165.5",
    "167.9",
    "171.3",
    "173.8",
    "177.3",
    "179.9",
    "183.5",
    "186.2",
    "189.9",
    "192.8",
    "196.6",
    "199.5",
    "203.5",
    "206.5",
    "210.7",
    "218.1",
    "225.7",
    "229.1",
    "233.6",
    "241.8",
    "250.3",
    "254.1"
)

val COMJOT_DCS_CODES = listOf(
    "023",
    "025",
    "026",
    "031",
    "032",
    "043",
    "047",
    "051",
    "054",
    "065",
    "071",
    "072",
    "073",
    "074",
    "114",
    "115",
    "116",
    "125",
    "131",
    "132",
    "134",
    "143",
    "152",
    "155",
    "156",
    "162",
    "165",
    "172",
    "174",
    "205",
    "223",
    "226",
    "243",
    "244",
    "245",
    "251",
    "261",
    "263",
    "265",
    "271",
    "306",
    "311",
    "315",
    "331",
    "343",
    "346",
    "351",
    "364",
    "365",
    "371",
    "411",
    "412",
    "413",
    "423",
    "431",
    "432",
    "445",
    "464",
    "465",
    "466",
    "503",
    "506",
    "516",
    "532",
    "546",
    "565",
    "606",
    "612",
    "624",
    "627",
    "631",
    "632",
    "654",
    "662",
    "664",
    "703",
    "712",
    "723",
    "731",
    "732",
    "734",
    "743",
    "754"
)

data class ComjotUiState(
    val profile: ComjotProfile = ComjotProfile(),
    val isBusy: Boolean = false,
    val isProgrammed: Boolean = false,
    val pttActive: Boolean = false,
    val statusMessage: String = "CJ-1 module idle",
    val lastPacketHex: String? = null,
    val usbPermissionPending: Boolean = false,
    val developerMode: Boolean = false
)

data class AppUiState(
    val baseUrl: String = "http://10.0.2.2:8787",
    val providers: List<ProviderProfile> = ProviderType.entries.map(ProviderProfile::defaults),
    val hotspot: HotspotProfile = HotspotProfile(),
    val memories: List<RadioMemory> = emptyList(),
    val selectedMemoryId: String? = null,
    val knobControlMode: KnobControlMode = KnobControlMode.VOLUME,
    val accentColor: AccentColor = AccentColor.GREEN,
    val roipOperationMode: RoipOperationMode = RoipOperationMode.DIRECT,
    val selectedRoipProviderId: String? = null,
    val comjot: ComjotUiState = ComjotUiState(),
    val activeSession: SessionSnapshot? = null,
    val isBusy: Boolean = false,
    val errorMessage: String? = null,
    val lastSyncLabel: String? = null
)
