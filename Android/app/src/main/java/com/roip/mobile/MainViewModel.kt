package com.roip.mobile

import android.Manifest
import android.content.Context
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.media.AudioManager
import android.net.Uri
import android.os.Bundle
import android.os.Looper
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.codescanner.GmsBarcodeScannerOptions
import com.google.mlkit.vision.codescanner.GmsBarcodeScanning
import com.roip.mobile.data.AppUiState
import com.roip.mobile.data.AccentColor
import com.roip.mobile.data.COMJOT_CTCSS_CODES
import com.roip.mobile.data.COMJOT_DCS_CODES
import com.roip.mobile.data.BackendClient
import com.roip.mobile.data.ComjotBandwidth
import com.roip.mobile.data.ComjotField
import com.roip.mobile.data.ComjotMode
import com.roip.mobile.data.ComjotProfile
import com.roip.mobile.data.ComjotRfPower
import com.roip.mobile.data.ComjotToneMode
import com.roip.mobile.data.HotspotField
import com.roip.mobile.data.HotspotProfile
import com.roip.mobile.data.KnobControlMode
import com.roip.mobile.data.MemoryType
import com.roip.mobile.data.ProviderField
import com.roip.mobile.data.ProviderProfile
import com.roip.mobile.data.RadioMemory
import com.roip.mobile.data.RoipOperationMode
import com.roip.mobile.radio.roip.AllStarIaxRoipController
import com.roip.mobile.radio.comjot.ComjotAnalogProfile
import com.roip.mobile.radio.comjot.ComjotDigitalProfile
import com.roip.mobile.radio.comjot.ComjotRadioController
import com.roip.mobile.radio.comjot.ComjotWriteResult
import com.roip.mobile.radio.roip.DirectDmrRoipController
import kotlinx.coroutines.Job
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout
import org.json.JSONArray
import org.json.JSONObject
import java.io.File
import java.util.Locale
import java.net.URLDecoder
import kotlin.coroutines.resume
import kotlin.math.abs
import kotlinx.coroutines.suspendCancellableCoroutine

class MainViewModel(
    private val backendClient: BackendClient = BackendClient(),
    private val comjotController: ComjotRadioController = ComjotRadioController(),
    private val directRoipController: DirectDmrRoipController = DirectDmrRoipController(),
    private val allStarIaxController: AllStarIaxRoipController = AllStarIaxRoipController()
) : ViewModel() {
    private val _uiState = MutableStateFlow(AppUiState())
    val uiState: StateFlow<AppUiState> = _uiState.asStateFlow()

    private var pollJob: Job? = null
    private var comjotPttJob: Job? = null
    private var relayPttJob: Job? = null
    private var hotspotPttJob: Job? = null
    private var hotspotRfReleaseJob: Job? = null
    private var hotspotNetworkReleaseJob: Job? = null
    private var persistJob: Job? = null
    private var desiredComjotPttActive = false
    private var desiredRelayPttActive = false
    private var desiredHotspotPttActive = false
    private var hotspotRfTxActive = false
    private var hotspotNetworkTxActive = false
    private var versionTapCount = 0
    private var appContext: Context? = null

    fun loadPersistedState(context: Context) {
        val applicationContext = context.applicationContext
        appContext = applicationContext
        val prefs = applicationContext.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val savedVolume = prefs.getString(KEY_VOLUME, null)
        val shouldMigrateRadioVolumeDefault = !prefs.getBoolean(KEY_RADIO_VOLUME_DEFAULT_MIGRATED, false)
        val savedHotspotSoftware = prefs.getString(KEY_HOTSPOT_SOFTWARE, null)
        val savedHotspotPackageId = prefs.getString(KEY_HOTSPOT_PACKAGE_ID, null)
        val savedHotspotSlotFlags = prefs.getString(KEY_HOTSPOT_SLOT_FLAGS, null)
        val shouldMigrateHotspotSoftwareIdDefault = !prefs.getBoolean(KEY_HOTSPOT_SOFTWARE_ID_DEFAULT_MIGRATED, false)
        val shouldMigrateHotspotPackageIdDefault = !prefs.getBoolean(KEY_HOTSPOT_PACKAGE_ID_DEFAULT_MIGRATED, false)
        val shouldMigrateHotspotSlotFlagsDefault = !prefs.getBoolean(KEY_HOTSPOT_SLOT_FLAGS_DEFAULT_MIGRATED, false)
        val radioHardwareAvailable = detectRadioHardwareAvailable()
        val loadedRadioVolume = when {
            shouldMigrateRadioVolumeDefault && (savedVolume == null || savedVolume == LEGACY_RADIO_VOLUME_DEFAULT) -> {
                DEFAULT_RADIO_VOLUME
            }
            savedVolume != null -> savedVolume
            else -> DEFAULT_RADIO_VOLUME
        }

        _uiState.update { current ->
            val currentProfile = current.comjot.profile
            val loadedProfile = currentProfile.copy(
                mode = prefs.getEnum(KEY_COMJOT_MODE, ComjotMode.entries, currentProfile.mode),
                rxFrequency = prefs.getString(KEY_RX_FREQUENCY, currentProfile.rxFrequency) ?: currentProfile.rxFrequency,
                txFrequency = prefs.getString(KEY_TX_FREQUENCY, currentProfile.txFrequency) ?: currentProfile.txFrequency,
                localId = prefs.getString(KEY_LOCAL_ID, currentProfile.localId) ?: currentProfile.localId,
                talkgroup = prefs.getString(KEY_TALKGROUP, currentProfile.talkgroup) ?: currentProfile.talkgroup,
                colorCode = prefs.getString(KEY_COLOR_CODE, currentProfile.colorCode) ?: currentProfile.colorCode,
                timeSlot = prefs.getString(KEY_TIME_SLOT, currentProfile.timeSlot) ?: currentProfile.timeSlot,
                bandwidth = prefs.getEnum(KEY_BANDWIDTH, ComjotBandwidth.entries, currentProfile.bandwidth),
                squelch = prefs.getString(KEY_SQUELCH, currentProfile.squelch) ?: currentProfile.squelch,
                rxToneMode = prefs.getEnum(KEY_RX_TONE_MODE, ComjotToneMode.entries, currentProfile.rxToneMode),
                rxToneCode = prefs.getString(KEY_RX_TONE_CODE, currentProfile.rxToneCode) ?: currentProfile.rxToneCode,
                txToneMode = prefs.getEnum(KEY_TX_TONE_MODE, ComjotToneMode.entries, currentProfile.txToneMode),
                txToneCode = prefs.getString(KEY_TX_TONE_CODE, currentProfile.txToneCode) ?: currentProfile.txToneCode,
                rfPower = prefs.getEnum(KEY_RF_POWER, ComjotRfPower.entries, currentProfile.rfPower),
                volume = loadedRadioVolume,
                micGain = prefs.getString(KEY_MIC_GAIN, currentProfile.micGain) ?: currentProfile.micGain,
                repeaterDecoupling = prefs.getBoolean(KEY_REPEATER_DECOUPLING, currentProfile.repeaterDecoupling),
                baudRate = prefs.getString(KEY_BAUD_RATE, currentProfile.baudRate) ?: currentProfile.baudRate
            ).let { profile ->
                if (radioHardwareAvailable) profile else profile.copy(mode = ComjotMode.ROIP)
            }

            val loadedHotspot = current.hotspot.loadFromPrefs(prefs).let { hotspot ->
                var migrated = hotspot
                if (shouldMigrateHotspotSoftwareIdDefault && savedHotspotSoftware.shouldUseDefaultHotspotSoftwareId()) {
                    migrated = migrated.copy(software = DEFAULT_HOTSPOT_SOFTWARE_ID)
                }
                if (shouldMigrateHotspotPackageIdDefault && (savedHotspotPackageId == null || savedHotspotPackageId == LEGACY_HOTSPOT_PACKAGE_DEFAULT)) {
                    migrated = migrated.copy(packageId = DEFAULT_HOTSPOT_PACKAGE_ID)
                }
                if (shouldMigrateHotspotSlotFlagsDefault && (savedHotspotSlotFlags == null || savedHotspotSlotFlags == LEGACY_HOTSPOT_SLOT_FLAGS_DEFAULT)) {
                    migrated = migrated.copy(slotFlags = DEFAULT_HOTSPOT_SLOT_FLAGS)
                }
                migrated
            }

            current.copy(
                baseUrl = prefs.getString(KEY_BASE_URL, current.baseUrl) ?: current.baseUrl,
                providers = current.providers.map { it.loadFromPrefs(prefs) },
                hotspot = loadedHotspot,
                memories = loadMemories(prefs),
                selectedMemoryId = prefs.getString(KEY_SELECTED_MEMORY_ID, current.selectedMemoryId),
                knobControlMode = prefs.getEnum(KEY_KNOB_CONTROL_MODE, KnobControlMode.entries, current.knobControlMode),
                accentColor = prefs.getEnum(KEY_ACCENT_COLOR, AccentColor.entries, current.accentColor),
                roipOperationMode = if (radioHardwareAvailable) {
                    prefs.getEnum(KEY_ROIP_OPERATION_MODE, RoipOperationMode.entries, current.roipOperationMode)
                } else {
                    RoipOperationMode.DIRECT
                },
                selectedRoipProviderId = prefs.getString(KEY_SELECTED_ROIP_PROVIDER_ID, current.selectedRoipProviderId),
                radioHardwareAvailable = radioHardwareAvailable,
                comjot = current.comjot.copy(
                    profile = loadedProfile,
                    developerMode = prefs.getBoolean(KEY_DEVELOPER_MODE, current.comjot.developerMode),
                    isProgrammed = false,
                    pttActive = false,
                    statusMessage = if (radioHardwareAvailable) {
                        current.comjot.statusMessage
                    } else {
                        "ROIP-only phone mode"
                    }
                )
            )
        }

        if (
            shouldMigrateRadioVolumeDefault ||
            shouldMigrateHotspotSoftwareIdDefault ||
            shouldMigrateHotspotPackageIdDefault ||
            shouldMigrateHotspotSlotFlagsDefault
        ) {
            val editor = prefs.edit()
            if (shouldMigrateRadioVolumeDefault) {
                editor
                    .putString(KEY_VOLUME, loadedRadioVolume)
                    .putBoolean(KEY_RADIO_VOLUME_DEFAULT_MIGRATED, true)
            }
            if (shouldMigrateHotspotSoftwareIdDefault) {
                val softwareId = if (savedHotspotSoftware.shouldUseDefaultHotspotSoftwareId()) {
                    DEFAULT_HOTSPOT_SOFTWARE_ID
                } else {
                    savedHotspotSoftware
                }
                editor
                    .putString(KEY_HOTSPOT_SOFTWARE, softwareId)
                    .putBoolean(KEY_HOTSPOT_SOFTWARE_ID_DEFAULT_MIGRATED, true)
            }
            if (shouldMigrateHotspotPackageIdDefault) {
                val packageId = if (savedHotspotPackageId == null || savedHotspotPackageId == LEGACY_HOTSPOT_PACKAGE_DEFAULT) {
                    DEFAULT_HOTSPOT_PACKAGE_ID
                } else {
                    savedHotspotPackageId
                }
                editor
                    .putString(KEY_HOTSPOT_PACKAGE_ID, packageId)
                    .putBoolean(KEY_HOTSPOT_PACKAGE_ID_DEFAULT_MIGRATED, true)
            }
            if (shouldMigrateHotspotSlotFlagsDefault) {
                val slotFlags = if (savedHotspotSlotFlags == null || savedHotspotSlotFlags == LEGACY_HOTSPOT_SLOT_FLAGS_DEFAULT) {
                    DEFAULT_HOTSPOT_SLOT_FLAGS
                } else {
                    savedHotspotSlotFlags
                }
                editor
                    .putString(KEY_HOTSPOT_SLOT_FLAGS, slotFlags)
                    .putBoolean(KEY_HOTSPOT_SLOT_FLAGS_DEFAULT_MIGRATED, true)
            }
            editor.apply()
        }
    }

    fun updateBaseUrl(value: String) {
        _uiState.update { current ->
            current.copy(baseUrl = value)
        }
        persistNow()
    }

    fun updateProvider(providerId: String, field: ProviderField, value: String) {
        _uiState.update { current ->
            current.copy(
                providers = current.providers.map { profile ->
                    if (profile.type.providerId == providerId) {
                        profile.withField(field, value)
                    } else {
                        profile
                    }
                }
            )
        }
        persistNow()
    }

    fun scanBrandmeisterQr(context: Context, providerId: String) {
        val provider = _uiState.value.providers.firstOrNull { it.type.providerId == providerId } ?: return
        if (provider.type.providerId != BRANDMEISTER_PROVIDER_ID) {
            _uiState.update { current ->
                current.copy(
                    errorMessage = "QR setup is only available for BrandMeister right now",
                    lastSyncLabel = "QR scanner unavailable"
                )
            }
            return
        }

        _uiState.update { current ->
            current.copy(
                errorMessage = null,
                lastSyncLabel = "Opening QR scanner"
            )
        }

        val options = GmsBarcodeScannerOptions.Builder()
            .setBarcodeFormats(Barcode.FORMAT_QR_CODE)
            .enableAutoZoom()
            .build()
        val scanner = GmsBarcodeScanning.getClient(context.applicationContext, options)

        scanner.startScan()
            .addOnSuccessListener { barcode ->
                val rawValue = barcode.rawValue.orEmpty()
                importBrandmeisterQr(providerId, rawValue)
            }
            .addOnCanceledListener {
                _uiState.update { current ->
                    current.copy(lastSyncLabel = "QR scan canceled")
                }
            }
            .addOnFailureListener { error ->
                _uiState.update { current ->
                    current.copy(
                        errorMessage = error.message ?: "Unable to scan QR code",
                        lastSyncLabel = "QR scan failed"
                    )
                }
            }
    }

    private fun importBrandmeisterQr(providerId: String, rawValue: String) {
        val qrConfig = BrandmeisterQrConfig.parse(rawValue)
        if (qrConfig == null || !qrConfig.hasAnyField) {
            _uiState.update { current ->
                current.copy(
                    errorMessage = "QR code did not contain a BrandMeister key or node settings",
                    lastSyncLabel = "QR import failed"
                )
            }
            return
        }

        _uiState.update { current ->
            current.copy(
                providers = current.providers.map { provider ->
                    if (provider.type.providerId == providerId) {
                        provider.withBrandmeisterQr(qrConfig)
                    } else {
                        provider
                    }
                },
                errorMessage = null,
                lastSyncLabel = "BrandMeister QR imported"
            )
        }
        persistNow()
    }

    fun updateHotspot(field: HotspotField, value: String) {
        _uiState.update { current ->
            current.copy(hotspot = current.hotspot.withField(field, value))
        }
        persistNow()
    }

    fun rejectDeviceLocationPermission() {
        _uiState.update { current ->
            current.copy(
                errorMessage = "Location permission is required to fill hotspot coordinates from GPS",
                lastSyncLabel = "GPS location permission denied"
            )
        }
    }

    fun updateHotspotFromDeviceLocation(context: Context) {
        val applicationContext = context.applicationContext
        if (!applicationContext.hasLocationPermission()) {
            rejectDeviceLocationPermission()
            return
        }

        _uiState.update { current ->
            current.copy(
                errorMessage = null,
                lastSyncLabel = "Reading device location"
            )
        }

        viewModelScope.launch {
            runCatching {
                withTimeout(LOCATION_TIMEOUT_MS) {
                    applicationContext.bestDeviceLocation()
                } ?: throw IllegalStateException("No device location is available yet")
            }.onSuccess { location ->
                val latitude = String.format(Locale.US, "%.6f", location.latitude)
                val longitude = String.format(Locale.US, "%.6f", location.longitude)
                val accuracy = if (location.hasAccuracy()) {
                    " +/-${location.accuracy.toInt()}m"
                } else {
                    ""
                }

                _uiState.update { current ->
                    current.copy(
                        hotspot = current.hotspot.copy(
                            latitude = latitude,
                            longitude = longitude
                        ),
                        errorMessage = null,
                        lastSyncLabel = "GPS set $latitude, $longitude$accuracy"
                    )
                }
                persistNow()
            }.onFailure { error ->
                _uiState.update { current ->
                    current.copy(
                        errorMessage = error.message ?: "Unable to read device location",
                        lastSyncLabel = "GPS location unavailable"
                    )
                }
            }
        }
    }

    fun updateComjot(field: ComjotField, value: String) {
        val previousMode = _uiState.value.comjot.profile.mode
        _uiState.update { current ->
            val requestedProfile = current.comjot.profile.withField(field, value)
            val updatedProfile = if (!current.radioHardwareAvailable && requestedProfile.mode != ComjotMode.ROIP) {
                requestedProfile.copy(mode = ComjotMode.ROIP)
            } else {
                requestedProfile
            }
            val txEnabled = updatedProfile.mode.isTxEnabled(current.comjot.developerMode)
            current.copy(
                comjot = current.comjot.copy(
                    profile = updatedProfile,
                    isProgrammed = false,
                    pttActive = if (txEnabled) current.comjot.pttActive else false,
                    usbPermissionPending = false
                )
            )
        }
        val nextMode = _uiState.value.comjot.profile.mode
        if (field == ComjotField.MODE && previousMode == ComjotMode.ROIP && nextMode != ComjotMode.ROIP) {
            disconnect()
        }
        persistNow()
    }

    fun updateKnobControlMode(value: String) {
        _uiState.update { current ->
            current.copy(
                knobControlMode = enumByName(
                    entries = KnobControlMode.entries,
                    name = value,
                    fallback = current.knobControlMode
                ),
                lastSyncLabel = "Knob controls ${enumByName(KnobControlMode.entries, value, current.knobControlMode).title.lowercase()}"
            )
        }
        persistNow()
    }

    fun updateAccentColor(value: String) {
        _uiState.update { current ->
            current.copy(
                accentColor = enumByName(
                    entries = AccentColor.entries,
                    name = value,
                    fallback = current.accentColor
                ),
                lastSyncLabel = "Accent color updated"
            )
        }
        persistNow()
    }

    fun updateRoipOperationMode(value: String) {
        val requestedMode = enumByName(
            entries = RoipOperationMode.entries,
            name = value,
            fallback = _uiState.value.roipOperationMode
        )
        val nextMode = if (_uiState.value.radioHardwareAvailable) requestedMode else RoipOperationMode.DIRECT
        if (nextMode == RoipOperationMode.HOTSPOT && _uiState.value.activeSession != null) {
            disconnect()
        }
        _uiState.update { current ->
            current.copy(
                roipOperationMode = nextMode,
                lastSyncLabel = when (nextMode) {
                    RoipOperationMode.DIRECT -> "ROIP direct network mode"
                    RoipOperationMode.HOTSPOT -> "ROIP hotspot hardware mode"
                }
            )
        }
        persistNow()
    }

    fun updateSelectedRoipProvider(providerId: String) {
        val provider = _uiState.value.providers.firstOrNull {
            it.type.providerId == providerId && it.type.providerId in ROIP_PROVIDER_IDS
        } ?: return
        val activeSession = _uiState.value.activeSession
        if (activeSession != null && activeSession.providerId != providerId) {
            desiredRelayPttActive = false
            disconnect()
        }

        _uiState.update { current ->
            current.copy(
                selectedRoipProviderId = provider.type.providerId,
                lastSyncLabel = "ROIP provider ${provider.type.title}"
            )
        }
        persistNow()
    }

    fun shouldInterceptVolumeKeysForKnob(): Boolean {
        return _uiState.value.knobControlMode != KnobControlMode.VOLUME
    }

    fun programComjot(context: Context) {
        val comjot = _uiState.value.comjot
        val profile = comjot.profile
        val developerMode = comjot.developerMode

        _uiState.update { current ->
            current.copy(
                comjot = current.comjot.copy(
                    isBusy = true,
                    statusMessage = when (profile.mode) {
                        ComjotMode.DMR -> "Programming CJ-1 DMR profile"
                        ComjotMode.FM -> "Programming CJ-1 FM profile"
                        ComjotMode.ROIP -> "ROIP mode uses network PTT"
                        ComjotMode.SCANNER -> if (developerMode) {
                            "Programming CJ-1 SDR profile"
                        } else {
                            "Programming CJ-1 scanner RX profile"
                        }
                    },
                    usbPermissionPending = false
                ),
                errorMessage = null
            )
        }

        viewModelScope.launch {
            runCatching {
                val baudRate = profile.baudRate.toIntOrNull()?.takeIf { it > 0 }
                    ?: throw IllegalArgumentException("CJ-1 baud rate must be a positive number")
                withContext(Dispatchers.IO) {
                    when (profile.mode) {
                        ComjotMode.DMR -> comjotController.programDigital(
                            context = context.applicationContext,
                            profile = profile.toDigitalProfile(),
                            baudRate = baudRate
                        )

                        ComjotMode.FM -> comjotController.programAnalog(
                            context = context.applicationContext,
                            profile = profile.toAnalogProfile(scanner = false, developerSdr = false),
                            baudRate = baudRate
                        )

                        ComjotMode.ROIP -> throw IllegalStateException("Select a ROIP provider and connect instead of programming the CJ-1")

                        ComjotMode.SCANNER -> comjotController.programAnalog(
                            context = context.applicationContext,
                            profile = profile.toAnalogProfile(
                                scanner = !developerMode,
                                developerSdr = developerMode
                            ),
                            baudRate = baudRate
                        )
                    }
                }
            }.onSuccess { result ->
                applyComjotResult(
                    result = result,
                    sentMessage = { sent -> "${profile.mode.titleFor(developerMode)} profile sent to ${sent.deviceName} (${sent.bytesWritten} bytes)" },
                    pttActiveOnSent = if (profile.mode.isTxEnabled(developerMode)) null else false,
                    programmedOnSent = true
                )
            }.onFailure { error ->
                _uiState.update { current ->
                    current.copy(
                        comjot = current.comjot.copy(
                            isBusy = false,
                            statusMessage = error.message ?: "CJ-1 profile validation failed"
                        ),
                        errorMessage = error.message ?: "CJ-1 profile validation failed"
                    )
                }
            }
        }
    }

    fun prepareRoipHotspot(context: Context) {
        val snapshot = _uiState.value
        val profile = snapshot.comjot.profile
        val provider = snapshot.selectedRoipProvider()

        _uiState.update { current ->
            current.copy(
                comjot = current.comjot.copy(
                    isBusy = true,
                    statusMessage = when (provider?.type?.providerId) {
                        ALLSTAR_PROVIDER_ID -> "Starting AllStar RF hotspot"
                        in DMR_PROVIDER_IDS -> "Staging CJ-1 DMR RF profile for hotspot mode"
                        else -> "Preparing hotspot hardware"
                    },
                    usbPermissionPending = false
                ),
                errorMessage = null,
                lastSyncLabel = "Preparing hotspot hardware"
            )
        }

        viewModelScope.launch {
            runCatching {
                val baudRate = profile.baudRate.toIntOrNull()?.takeIf { it > 0 }
                    ?: throw IllegalArgumentException("CJ-1 baud rate must be a positive number")
                val selectedProvider = provider ?: throw IllegalStateException("Select a ROIP provider first")
                if (selectedProvider.type.providerId == ALLSTAR_PROVIDER_ID) {
                    val analogResult = withContext(Dispatchers.IO) {
                        comjotController.programAnalog(
                            context = context.applicationContext,
                            profile = profile.toAnalogProfile(scanner = false, developerSdr = false),
                            baudRate = baudRate
                        )
                    }
                    if (analogResult !is ComjotWriteResult.Sent) {
                        throw IllegalStateException(analogResult.hotspotMessage())
                    }
                    val session = _uiState.value.activeSession?.takeIf {
                        it.transport == AllStarIaxRoipController.IAX_TRANSPORT
                    } ?: withTimeout(ROIP_CONNECT_TIMEOUT_MS) {
                        allStarIaxController.connect(provider = selectedProvider)
                    }.also { connected ->
                        _uiState.update { current ->
                            current.copy(activeSession = connected)
                        }
                        startDirectRoipPolling()
                    }
                    startAllStarHotspotBridge(context.applicationContext, baudRate)
                    session.copy(statusMessage = "AllStar RF hotspot active on ${profile.rxFrequency} MHz")
                } else if (selectedProvider.type.providerId in DMR_PROVIDER_IDS) {
                    val hotspotProfile = profile.copy(
                        mode = ComjotMode.DMR,
                        talkgroup = selectedProvider.target.takeIf { it.isNotBlank() } ?: profile.talkgroup,
                        timeSlot = selectedProvider.timeSlot.takeIf { it.isNotBlank() } ?: profile.timeSlot
                    )
                    val result = withContext(Dispatchers.IO) {
                        comjotController.programDigital(
                            context = context.applicationContext,
                            profile = hotspotProfile.toDigitalProfile(),
                            baudRate = baudRate
                        )
                    }
                    if (result !is ComjotWriteResult.Sent) {
                        throw IllegalStateException(result.hotspotMessage())
                    }
                    null
                } else {
                    throw IllegalStateException("Unsupported hotspot provider ${selectedProvider.type.title}")
                }
            }.onSuccess { result ->
                _uiState.update { current ->
                    current.copy(
                        isBusy = false,
                        activeSession = result ?: current.activeSession,
                        comjot = current.comjot.copy(
                            isBusy = false,
                            isProgrammed = true,
                            pttActive = false,
                            statusMessage = result?.statusMessage
                                ?: "DMR RF hotspot staged. Raw DMR RF frame bridge is still pending CJ-1 frame access."
                        ),
                        errorMessage = null,
                        lastSyncLabel = if (result != null) "AllStar hotspot active" else "DMR hotspot staged"
                    )
                }
            }.onFailure { error ->
                _uiState.update { current ->
                    current.copy(
                        comjot = current.comjot.copy(
                            isBusy = false,
                            statusMessage = error.message ?: "Hotspot hardware staging failed"
                        ),
                        errorMessage = error.message ?: "Hotspot hardware staging failed",
                        lastSyncLabel = "Hotspot hardware failed"
                    )
                }
            }
        }
    }

    fun sendAllStarDtmf(sequence: String) {
        viewModelScope.launch {
            runCatching {
                allStarIaxController.sendDtmf(sequence)
            }.onSuccess { session ->
                _uiState.update { current ->
                    current.copy(
                        activeSession = session,
                        errorMessage = null,
                        lastSyncLabel = "DTMF sent"
                    )
                }
            }.onFailure { error ->
                _uiState.update { current ->
                    current.copy(
                        errorMessage = error.message ?: "DTMF send failed",
                        lastSyncLabel = "DTMF failed"
                    )
                }
            }
        }
    }

    fun toggleComjotPtt(context: Context) {
        setComjotPtt(context, !_uiState.value.comjot.pttActive)
    }

    fun handleHardwarePtt(context: Context, pressed: Boolean, source: String) {
        val snapshot = _uiState.value
        if (snapshot.comjot.profile.mode == ComjotMode.ROIP) {
            if (snapshot.roipOperationMode == RoipOperationMode.HOTSPOT) {
                setHotspotPtt(pressed)
                return
            }
            if (snapshot.activeSession == null) {
                if (pressed) {
                    _uiState.update { current ->
                        current.copy(
                            errorMessage = null,
                            lastSyncLabel = "Hardware PTT from $source: connect ROIP first"
                        )
                    }
                }
            } else {
                setRelayPtt(pressed)
            }
            return
        }

        setComjotPtt(context, pressed)
    }

    fun setHotspotPtt(active: Boolean) {
        val snapshot = _uiState.value
        val session = snapshot.activeSession
        if (
            snapshot.comjot.profile.mode != ComjotMode.ROIP ||
            snapshot.roipOperationMode != RoipOperationMode.HOTSPOT ||
            session?.transport != AllStarIaxRoipController.IAX_TRANSPORT
        ) {
            if (active) {
                _uiState.update { current ->
                    current.copy(lastSyncLabel = "Start AllStar hotspot first")
                }
            }
            return
        }

        if (active && !snapshot.comjot.isProgrammed) {
            _uiState.update { current ->
                current.copy(
                    comjot = current.comjot.copy(statusMessage = "Start hotspot hardware before PTT"),
                    lastSyncLabel = "Start hotspot first"
                )
            }
            return
        }

        desiredHotspotPttActive = active
        if (hotspotPttJob?.isActive == true) {
            _uiState.update { current ->
                current.copy(lastSyncLabel = if (active) "Hotspot PTT queued" else "Hotspot release queued")
            }
            return
        }

        hotspotPttJob = viewModelScope.launch {
            while (isActive) {
                val targetPttState = desiredHotspotPttActive

                _uiState.update { state ->
                    state.copy(
                        comjot = state.comjot.copy(
                            isBusy = true,
                            statusMessage = if (targetPttState) "Hotspot PTT to AllStar" else "Releasing hotspot PTT",
                            usbPermissionPending = false
                        ),
                        errorMessage = null,
                        lastSyncLabel = if (targetPttState) "Hotspot PTT starting" else "Hotspot PTT releasing"
                    )
                }

                val result = if (targetPttState) {
                    runCatching {
                        allStarIaxController.setPtt(true)
                    }
                } else {
                    runCatching {
                        allStarIaxController.setPtt(false)
                    }
                }

                var stopLoop = false
                result.fold(
                    onSuccess = { updatedSession ->
                        _uiState.update { state ->
                            state.copy(
                                activeSession = updatedSession,
                                comjot = state.comjot.copy(
                                    isBusy = false,
                                    pttActive = targetPttState,
                                    statusMessage = if (targetPttState) "Hotspot PTT held on AllStar" else "Hotspot PTT released",
                                    usbPermissionPending = false
                                ),
                                errorMessage = null,
                                lastSyncLabel = if (targetPttState) "CJ-1 mic -> AllStar" else "Hotspot PTT released"
                            )
                        }
                    },
                    onFailure = { error ->
                        if (targetPttState) {
                            desiredHotspotPttActive = false
                        }
                        _uiState.update { state ->
                            state.copy(
                                comjot = state.comjot.copy(
                                    isBusy = false,
                                    pttActive = false,
                                    statusMessage = error.message ?: "Hotspot PTT failed"
                                ),
                                errorMessage = error.message ?: "Hotspot PTT failed",
                                lastSyncLabel = if (targetPttState) "Hotspot PTT failed" else "Hotspot release failed"
                            )
                        }
                        stopLoop = true
                    }
                )

                if (stopLoop || desiredHotspotPttActive == targetPttState) {
                    break
                }
            }
        }
    }

    fun handleKnobRotation(context: Context, direction: Int, steps: Int, source: String) {
        val tick = if (direction > 0) 1 else -1
        val boundedSteps = abs(steps).coerceIn(1, 12)
        val delta = tick * boundedSteps

        when (_uiState.value.knobControlMode) {
            KnobControlMode.VOLUME -> adjustKnobVolume(context, delta, source)
            KnobControlMode.FREQUENCY -> adjustKnobFrequency(delta, source)
            KnobControlMode.MEMORIES -> stepKnobMemory(delta, source)
        }
    }

    fun setComjotPtt(context: Context, active: Boolean) {
        val snapshot = _uiState.value.comjot
        val hotspotStandalone = _uiState.value.roipOperationMode == RoipOperationMode.HOTSPOT &&
            snapshot.profile.mode == ComjotMode.ROIP
        if (!snapshot.profile.mode.isTxEnabled(snapshot.developerMode) && !hotspotStandalone) {
            val message = if (snapshot.profile.mode == ComjotMode.ROIP) {
                "ROIP mode uses network PTT"
            } else {
                "${snapshot.profile.mode.titleFor(snapshot.developerMode)} mode is RX only"
            }
            _uiState.update { current ->
                current.copy(
                    comjot = current.comjot.copy(statusMessage = message),
                    errorMessage = null
                )
            }
            return
        }

        if (active && !snapshot.isProgrammed) {
            _uiState.update { current ->
                current.copy(
                    comjot = current.comjot.copy(statusMessage = "Program the CJ-1 profile before hardware PTT"),
                    errorMessage = null
                )
            }
            return
        }

        desiredComjotPttActive = active
        if (comjotPttJob?.isActive == true) {
            _uiState.update { current ->
                current.copy(
                    comjot = current.comjot.copy(
                        statusMessage = if (active) "PTT start queued" else "PTT release queued"
                    ),
                    errorMessage = null
                )
            }
            return
        }

        comjotPttJob = viewModelScope.launch {
            while (isActive) {
                val currentComjot = _uiState.value.comjot
                val targetPttState = desiredComjotPttActive
                if (currentComjot.pttActive == targetPttState) {
                    _uiState.update { current ->
                        current.copy(comjot = current.comjot.copy(isBusy = false))
                    }
                    break
                }

                val baudRate = currentComjot.profile.baudRate.toIntOrNull()?.takeIf { it > 0 }
                if (baudRate == null) {
                    desiredComjotPttActive = false
                    _uiState.update { current ->
                        current.copy(
                            comjot = current.comjot.copy(
                                isBusy = false,
                                pttActive = false,
                                statusMessage = "CJ-1 baud rate must be a positive number"
                            ),
                            errorMessage = "CJ-1 baud rate must be a positive number"
                        )
                    }
                    break
                }

                _uiState.update { current ->
                    current.copy(
                        comjot = current.comjot.copy(
                            isBusy = true,
                            statusMessage = if (targetPttState) "Holding CJ-1 PTT" else "Releasing CJ-1 PTT",
                            usbPermissionPending = false
                        ),
                        errorMessage = null
                    )
                }

                val writeResult = runCatching {
                    withContext(Dispatchers.IO) {
                        comjotController.setTransmission(
                            context = context.applicationContext,
                            active = targetPttState,
                            baudRate = baudRate
                        )
                    }
                }

                val result = writeResult.getOrNull()
                if (result != null) {
                    applyComjotResult(
                        result = result,
                        sentMessage = { sent ->
                            if (targetPttState) {
                                "CJ-1 PTT held on ${sent.deviceName}"
                            } else {
                                "CJ-1 PTT released on ${sent.deviceName}"
                            }
                        },
                        pttActiveOnSent = targetPttState,
                        programmedOnSent = null
                    )
                    if (result !is ComjotWriteResult.Sent) {
                        desiredComjotPttActive = false
                        break
                    }
                } else {
                    val error = writeResult.exceptionOrNull()
                    desiredComjotPttActive = false
                    _uiState.update { current ->
                        current.copy(
                            comjot = current.comjot.copy(
                                isBusy = false,
                                pttActive = false,
                                statusMessage = error?.message ?: "CJ-1 PTT update failed"
                            ),
                            errorMessage = error?.message ?: "CJ-1 PTT update failed"
                        )
                    }
                    break
                }

                if (desiredComjotPttActive == targetPttState) {
                    break
                }
            }
        }
    }

    fun rejectComjotAudioPermission() {
        _uiState.update { current ->
            current.copy(
                comjot = current.comjot.copy(
                    isBusy = false,
                    pttActive = false,
                    statusMessage = "Microphone permission is required for CJ-1 transmit audio"
                ),
                errorMessage = "Microphone permission is required for CJ-1 transmit audio"
            )
        }
    }

    fun onVersionTapped() {
        if (_uiState.value.comjot.developerMode) {
            _uiState.update { current ->
                current.copy(
                    comjot = current.comjot.copy(statusMessage = "Developer mode is already enabled"),
                    errorMessage = null
                )
            }
            return
        }

        versionTapCount += 1
        val remaining = 5 - versionTapCount
        if (remaining <= 0) {
            _uiState.update { current ->
                current.copy(
                    comjot = current.comjot.copy(
                        developerMode = true,
                        statusMessage = "Developer mode enabled. Scanner is now SDR with TX controls."
                    ),
                    errorMessage = null
                )
            }
            persistNow()
        } else {
            _uiState.update { current ->
                current.copy(
                    comjot = current.comjot.copy(
                        statusMessage = "$remaining more version taps to enable developer mode"
                    ),
                    errorMessage = null
                )
            }
        }
    }

    fun saveCurrentMemory(name: String, type: MemoryType) {
        val trimmedName = name.trim()
        val snapshot = _uiState.value
        val fallbackName = when (type) {
            MemoryType.REPEATER -> "Repeater ${snapshot.comjot.profile.rxFrequency}"
            MemoryType.DMR_NODE -> "DMR TG ${snapshot.comjot.profile.talkgroup}"
            MemoryType.ROIP_FAVORITE -> "ROIP ${snapshot.selectedRoipProvider()?.target.orEmpty()}"
        }
        val memoryName = trimmedName.ifBlank { fallbackName.trim() }
        val existingId = snapshot.memories.firstOrNull {
            it.type == type && it.name.equals(memoryName, ignoreCase = true)
        }?.id
        val memory = snapshot.toRadioMemory(
            id = existingId ?: System.currentTimeMillis().toString(),
            name = memoryName,
            type = type
        )

        _uiState.update { current ->
            current.copy(
                memories = (current.memories.filterNot { it.id == memory.id } + memory)
                    .sortedWith(compareBy<RadioMemory> { it.type.ordinal }.thenBy { it.name.lowercase() }),
                selectedMemoryId = memory.id,
                comjot = current.comjot.copy(statusMessage = "Saved ${memory.name}"),
                errorMessage = null,
                lastSyncLabel = "Memory saved"
            )
        }
        persistNow()
    }

    fun recallMemory(memoryId: String) {
        _uiState.update { current ->
            val memory = current.memories.firstOrNull { it.id == memoryId } ?: return@update current
            val loadedMode = when (memory.type) {
                MemoryType.REPEATER -> ComjotMode.FM
                MemoryType.DMR_NODE -> ComjotMode.DMR
                MemoryType.ROIP_FAVORITE -> ComjotMode.ROIP
            }
            val loadedProfile = current.comjot.profile.copy(
                mode = loadedMode,
                rxFrequency = memory.rxFrequency,
                txFrequency = memory.txFrequency,
                localId = memory.localId,
                talkgroup = memory.talkgroup,
                colorCode = memory.colorCode,
                timeSlot = memory.timeSlot,
                bandwidth = memory.bandwidth,
                squelch = memory.squelch,
                rxToneMode = memory.rxToneMode,
                rxToneCode = memory.rxToneCode,
                txToneMode = memory.txToneMode,
                txToneCode = memory.txToneCode,
                rfPower = memory.rfPower,
                volume = memory.volume,
                micGain = memory.micGain,
                repeaterDecoupling = memory.repeaterDecoupling
            )
            val loadedProviders = current.providers.map { provider ->
                if (memory.type == MemoryType.ROIP_FAVORITE && provider.type.providerId == memory.providerId) {
                    provider.copy(
                        target = memory.providerTarget ?: provider.target,
                        serverHost = memory.providerHost ?: provider.serverHost
                    )
                } else {
                    provider
                }
            }

            current.copy(
                providers = loadedProviders,
                selectedRoipProviderId = if (memory.type == MemoryType.ROIP_FAVORITE) {
                    memory.providerId ?: current.selectedRoipProviderId
                } else {
                    current.selectedRoipProviderId
                },
                selectedMemoryId = memory.id,
                comjot = current.comjot.copy(
                    profile = loadedProfile,
                    isProgrammed = false,
                    pttActive = false,
                    statusMessage = "Loaded ${memory.name}"
                ),
                errorMessage = null,
                lastSyncLabel = "Memory loaded"
            )
        }
        persistNow()
    }

    fun deleteMemory(memoryId: String) {
        _uiState.update { current ->
            val removed = current.memories.firstOrNull { it.id == memoryId }
            current.copy(
                memories = current.memories.filterNot { it.id == memoryId },
                selectedMemoryId = if (current.selectedMemoryId == memoryId) null else current.selectedMemoryId,
                comjot = if (removed != null) {
                    current.comjot.copy(statusMessage = "Deleted ${removed.name}")
                } else {
                    current.comjot
                },
                lastSyncLabel = if (removed != null) "Memory deleted" else current.lastSyncLabel
            )
        }
        persistNow()
    }

    fun connect(providerId: String) {
        val snapshot = _uiState.value
        if (snapshot.activeSession != null) {
            _uiState.update { current ->
                current.copy(lastSyncLabel = "Disconnect current ROIP session first")
            }
            return
        }

        val profile = snapshot.providers.firstOrNull { it.type.providerId == providerId } ?: return

        _uiState.update { current ->
            current.copy(
                isBusy = true,
                selectedRoipProviderId = profile.type.providerId,
                errorMessage = null,
                lastSyncLabel = "Connecting direct to ${profile.serverHost}"
            )
        }
        persistNow()

        viewModelScope.launch {
            runCatching {
                withTimeout(ROIP_CONNECT_TIMEOUT_MS) {
                    if (profile.type.providerId == ALLSTAR_PROVIDER_ID) {
                        allStarIaxController.connect(provider = profile)
                    } else {
                        directRoipController.connect(
                            provider = profile,
                            radioProfile = _uiState.value.comjot.profile,
                            hotspotProfile = _uiState.value.hotspot
                        )
                    }
                }
            }.onSuccess { session ->
                _uiState.update { current ->
                    current.copy(
                        isBusy = false,
                        activeSession = session,
                        errorMessage = null,
                        lastSyncLabel = "${session.providerName} connected"
                    )
                }
                startDirectRoipPolling()
            }.onFailure { error ->
                val message = error.message ?: "${profile.type.title} connect timed out"
                _uiState.update { current ->
                    current.copy(
                        isBusy = false,
                        errorMessage = message,
                        lastSyncLabel = "${profile.type.title} failed: $message"
                    )
                }
            }
        }
    }

    fun disconnect() {
        val session = _uiState.value.activeSession ?: return
        pollJob?.cancel()
        pollJob = null
        hotspotPttJob?.cancel()
        hotspotPttJob = null
        desiredHotspotPttActive = false
        hotspotRfReleaseJob?.cancel()
        hotspotRfReleaseJob = null
        hotspotNetworkReleaseJob?.cancel()
        hotspotNetworkReleaseJob = null
        if (hotspotRfTxActive) {
            val context = appContext
            val baudRate = _uiState.value.comjot.profile.baudRate.toIntOrNull()
            if (context != null && baudRate != null) {
                viewModelScope.launch(Dispatchers.IO) {
                    runCatching {
                        comjotController.stopHotspotTransmitAudio(context, baudRate)
                    }
                }
            }
            hotspotRfTxActive = false
        }
        hotspotNetworkTxActive = false
        allStarIaxController.setNetworkAudioSink(null)

        _uiState.update { current ->
            current.copy(isBusy = true, errorMessage = null)
        }

        viewModelScope.launch {
            if (session.transport == DirectDmrRoipController.DIRECT_TRANSPORT) {
                directRoipController.disconnect()
                _uiState.update { current ->
                    current.copy(
                        isBusy = false,
                        activeSession = null,
                        errorMessage = null,
                        lastSyncLabel = "Direct ROIP disconnected"
                    )
                }
                return@launch
            }
            if (session.transport == AllStarIaxRoipController.IAX_TRANSPORT) {
                allStarIaxController.disconnect()
                _uiState.update { current ->
                    current.copy(
                        isBusy = false,
                        activeSession = null,
                        errorMessage = null,
                        lastSyncLabel = "AllStar disconnected"
                    )
                }
                return@launch
            }

            runCatching {
                backendClient.deleteSession(_uiState.value.baseUrl, session.id)
            }.onSuccess {
                _uiState.update { current ->
                    current.copy(
                        isBusy = false,
                        activeSession = null,
                        errorMessage = null,
                        lastSyncLabel = "Session disconnected"
                    )
                }
            }.onFailure { error ->
                _uiState.update { current ->
                    current.copy(
                        isBusy = false,
                        errorMessage = error.message ?: "Unable to disconnect session"
                    )
                }
            }
        }
    }

    fun togglePtt() {
        val session = _uiState.value.activeSession ?: return
        setRelayPtt(!session.pttActive)
    }

    fun setRelayPtt(pressed: Boolean) {
        val session = _uiState.value.activeSession
        if (session == null) {
            if (pressed) {
                _uiState.update { current ->
                    current.copy(
                        errorMessage = null,
                        lastSyncLabel = "Connect a ROIP session before PTT"
                    )
                }
            }
            return
        }

        desiredRelayPttActive = pressed
        if (relayPttJob?.isActive == true) {
            _uiState.update { current ->
                current.copy(
                    errorMessage = null,
                    lastSyncLabel = if (pressed) "ROIP PTT start queued" else "ROIP PTT release queued"
                )
            }
            return
        }

        relayPttJob = viewModelScope.launch {
            while (isActive) {
                val currentSession = _uiState.value.activeSession ?: break
                val targetPttState = desiredRelayPttActive
                if (currentSession.transport == DirectDmrRoipController.DIRECT_TRANSPORT) {
                    val directResult = runCatching {
                        directRoipController.setPtt(targetPttState)
                    }
                    val updated = directResult.getOrNull()
                    if (updated != null) {
                        _uiState.update { current ->
                            current.copy(
                                activeSession = updated,
                                errorMessage = null,
                                lastSyncLabel = if (updated.pttActive) "ROIP PTT active" else "ROIP PTT released"
                            )
                        }
                    } else {
                        if (targetPttState) {
                            desiredRelayPttActive = false
                        }
                        val error = directResult.exceptionOrNull()
                        _uiState.update { current ->
                            current.copy(
                                errorMessage = error?.message ?: "ROIP PTT failed",
                                lastSyncLabel = if (targetPttState) "ROIP PTT blocked" else "ROIP PTT release failed"
                            )
                        }
                    }
                    break
                }
                if (currentSession.transport == AllStarIaxRoipController.IAX_TRANSPORT) {
                    val allStarResult = runCatching {
                        allStarIaxController.setPtt(targetPttState)
                    }
                    val updated = allStarResult.getOrNull()
                    if (updated != null) {
                        _uiState.update { current ->
                            current.copy(
                                activeSession = updated,
                                errorMessage = null,
                                lastSyncLabel = if (updated.pttActive) "AllStar PTT active" else "AllStar PTT released"
                            )
                        }
                    } else {
                        if (targetPttState) {
                            desiredRelayPttActive = false
                        }
                        val error = allStarResult.exceptionOrNull()
                        _uiState.update { current ->
                            current.copy(
                                errorMessage = error?.message ?: "AllStar PTT failed",
                                lastSyncLabel = if (targetPttState) "AllStar PTT blocked" else "AllStar PTT release failed"
                            )
                        }
                    }
                    break
                }

                if (currentSession.pttActive == targetPttState) {
                    _uiState.update { current ->
                        current.copy(
                            errorMessage = null,
                            lastSyncLabel = if (targetPttState) "ROIP PTT active" else "ROIP PTT released"
                        )
                    }
                    break
                }

                val relayResult = runCatching {
                    backendClient.setPtt(
                        baseUrl = _uiState.value.baseUrl,
                        sessionId = currentSession.id,
                        pressed = targetPttState
                    )
                }
                val updated = relayResult.getOrNull()
                if (updated != null) {
                    _uiState.update { current ->
                        current.copy(
                            activeSession = updated,
                            errorMessage = null,
                            lastSyncLabel = if (updated.pttActive) "ROIP PTT active" else "ROIP PTT released"
                        )
                    }
                } else {
                    val error = relayResult.exceptionOrNull()
                    if (targetPttState) {
                        desiredRelayPttActive = false
                    }
                    _uiState.update { current ->
                        current.copy(
                            errorMessage = error?.message ?: "PTT update failed",
                            lastSyncLabel = if (targetPttState) "ROIP PTT failed" else "ROIP PTT release failed"
                        )
                    }
                    break
                }

                if (desiredRelayPttActive == targetPttState) {
                    break
                }
            }
        }
    }

    private fun adjustKnobVolume(context: Context, delta: Int, source: String) {
        val audioManager = context.applicationContext.getSystemService(Context.AUDIO_SERVICE) as AudioManager
        val currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC)
        val maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC).coerceAtLeast(1)
        val nextVolume = (currentVolume + delta).coerceIn(0, maxVolume)
        audioManager.setStreamVolume(
            AudioManager.STREAM_MUSIC,
            nextVolume,
            AudioManager.FLAG_SHOW_UI
        )

        _uiState.update { current ->
            current.copy(
                comjot = current.comjot.copy(
                    statusMessage = "Android volume $nextVolume/$maxVolume"
                ),
                errorMessage = null,
                lastSyncLabel = "Android volume from $source"
            )
        }
    }

    private fun adjustKnobFrequency(delta: Int, source: String) {
        _uiState.update { current ->
            val profile = current.comjot.profile
            val rx = profile.rxFrequency.toDoubleOrNull()
                ?: return@update current.copy(
                    comjot = current.comjot.copy(statusMessage = "RX frequency must be numeric before knob tuning")
                )
            val tx = profile.txFrequency.toDoubleOrNull()
            val step = FREQUENCY_STEP_MHZ * delta
            val nextRx = (rx + step).coerceAtLeast(FREQUENCY_STEP_MHZ)
            val nextTx = when {
                profile.mode == ComjotMode.SCANNER -> nextRx
                tx != null -> (tx + step).coerceAtLeast(FREQUENCY_STEP_MHZ)
                else -> nextRx
            }
            val rxText = formatFrequency(nextRx)
            val txText = formatFrequency(nextTx)

            current.copy(
                comjot = current.comjot.copy(
                    profile = profile.copy(
                        rxFrequency = rxText,
                        txFrequency = txText
                    ),
                    isProgrammed = false,
                    pttActive = false,
                    statusMessage = "Knob tuned $rxText MHz"
                ),
                errorMessage = null,
                lastSyncLabel = "Knob frequency from $source"
            )
        }
        persistNow()
    }

    private fun stepKnobMemory(delta: Int, source: String) {
        val memories = _uiState.value.memories.sortedWith(
            compareBy<RadioMemory> { it.type.ordinal }.thenBy { it.name.lowercase() }
        )
        if (memories.isEmpty()) {
            _uiState.update { current ->
                current.copy(
                    comjot = current.comjot.copy(statusMessage = "No memories saved"),
                    errorMessage = null,
                    lastSyncLabel = "Knob memory from $source"
                )
            }
            return
        }

        val selectedId = _uiState.value.selectedMemoryId
        val currentIndex = memories.indexOfFirst { it.id == selectedId }.takeIf { it >= 0 } ?: 0
        val nextIndex = Math.floorMod(currentIndex + delta, memories.size)
        val nextMemory = memories[nextIndex]
        recallMemory(nextMemory.id)
        _uiState.update { current ->
            current.copy(lastSyncLabel = "Knob memory: ${nextMemory.name}")
        }
    }

    private fun startPolling(sessionId: String) {
        pollJob?.cancel()
        pollJob = viewModelScope.launch {
            while (isActive) {
                runCatching {
                    backendClient.fetchSession(_uiState.value.baseUrl, sessionId)
                }.onSuccess { updated ->
                    _uiState.update { current ->
                        current.copy(
                            activeSession = updated,
                            errorMessage = null,
                            lastSyncLabel = "Last sync just now"
                        )
                    }
                }.onFailure { error ->
                    _uiState.update { current ->
                        current.copy(
                            errorMessage = error.message ?: "Session refresh failed"
                        )
                    }
                }

                delay(2_000)
            }
        }
    }

    private fun startDirectRoipPolling() {
        pollJob?.cancel()
        pollJob = viewModelScope.launch {
            while (isActive) {
                val updated = when (_uiState.value.activeSession?.transport) {
                    DirectDmrRoipController.DIRECT_TRANSPORT -> directRoipController.snapshot()
                    AllStarIaxRoipController.IAX_TRANSPORT -> allStarIaxController.snapshot()
                    else -> null
                }
                if (updated != null) {
                    _uiState.update { current ->
                        current.copy(
                            activeSession = updated,
                            errorMessage = if (updated.phase == "disconnected") updated.statusMessage else null,
                            lastSyncLabel = if (updated.phase == "disconnected") {
                                "${updated.providerName} disconnected"
                            } else {
                                "${updated.providerName} active"
                            }
                        )
                    }
                }

                delay(2_000)
            }
        }
    }

    private fun startAllStarHotspotBridge(context: Context, baudRate: Int) {
        allStarIaxController.setNetworkAudioSink { pcm ->
            viewModelScope.launch {
                forwardNetworkAudioToRf(context, baudRate, pcm)
            }
        }

        val rxStarted = comjotController.startHotspotReceiveAudio(
            onPcm = { pcm ->
                viewModelScope.launch(Dispatchers.IO) {
                    forwardRfAudioToAllStar(pcm)
                }
            },
            playLocalMonitor = false
        )
        if (!rxStarted) {
            throw IllegalStateException("CJ-1 RF audio bridge is not available on this device")
        }
    }

    private suspend fun forwardNetworkAudioToRf(context: Context, baudRate: Int, pcm: ShortArray) {
        if (!hotspotRfTxActive) {
            val result = withContext(Dispatchers.IO) {
                comjotController.startHotspotTransmitAudio(context, baudRate)
            }
            if (result !is ComjotWriteResult.Sent) {
                throw IllegalStateException(result.hotspotMessage())
            }
            hotspotRfTxActive = true
            _uiState.update { current ->
                current.copy(lastSyncLabel = "AllStar network audio -> RF")
            }
        }
        comjotController.enqueueHotspotTransmitPcm(pcm)
        hotspotRfReleaseJob?.cancel()
        hotspotRfReleaseJob = viewModelScope.launch {
            delay(HOTSPOT_RF_HANG_MS)
            if (hotspotRfTxActive) {
                withContext(Dispatchers.IO) {
                    comjotController.stopHotspotTransmitAudio(context, baudRate)
                }
                hotspotRfTxActive = false
                _uiState.update { current ->
                    current.copy(lastSyncLabel = "AllStar RF downlink idle")
                }
            }
        }
    }

    private suspend fun forwardRfAudioToAllStar(pcm: ShortArray) {
        val peak = pcm.maxOfOrNull { abs(it.toInt()) } ?: 0
        if (peak < HOTSPOT_AUDIO_GATE) {
            scheduleAllStarNetworkUnkey()
            return
        }
        if (!hotspotNetworkTxActive) {
            val session = allStarIaxController.setExternalPtt(true)
            hotspotNetworkTxActive = true
            _uiState.update { current ->
                current.copy(
                    activeSession = session,
                    lastSyncLabel = "RF radio -> AllStar"
                )
            }
        }
        withContext(Dispatchers.IO) {
            allStarIaxController.sendExternalPcm(pcm)
        }
        scheduleAllStarNetworkUnkey()
    }

    private fun scheduleAllStarNetworkUnkey() {
        hotspotNetworkReleaseJob?.cancel()
        hotspotNetworkReleaseJob = viewModelScope.launch {
            delay(HOTSPOT_NETWORK_HANG_MS)
            if (hotspotNetworkTxActive) {
                val session = allStarIaxController.setExternalPtt(false)
                hotspotNetworkTxActive = false
                _uiState.update { current ->
                    current.copy(
                        activeSession = session,
                        lastSyncLabel = "AllStar uplink idle"
                    )
                }
            }
        }
    }

    private fun AppUiState.toRadioMemory(
        id: String,
        name: String,
        type: MemoryType
    ): RadioMemory {
        val profile = comjot.profile
        val provider = selectedRoipProvider()
        val memoryMode = when (type) {
            MemoryType.REPEATER -> ComjotMode.FM
            MemoryType.DMR_NODE -> ComjotMode.DMR
            MemoryType.ROIP_FAVORITE -> ComjotMode.ROIP
        }

        return RadioMemory(
            id = id,
            name = name,
            type = type,
            mode = memoryMode,
            rxFrequency = profile.rxFrequency,
            txFrequency = profile.txFrequency,
            localId = profile.localId,
            talkgroup = profile.talkgroup,
            colorCode = profile.colorCode,
            timeSlot = profile.timeSlot,
            bandwidth = profile.bandwidth,
            squelch = profile.squelch,
            rxToneMode = profile.rxToneMode,
            rxToneCode = profile.rxToneCode,
            txToneMode = profile.txToneMode,
            txToneCode = profile.txToneCode,
            rfPower = profile.rfPower,
            volume = profile.volume,
            micGain = profile.micGain,
            repeaterDecoupling = profile.repeaterDecoupling,
            providerId = if (type == MemoryType.ROIP_FAVORITE) provider?.type?.providerId else null,
            providerTitle = if (type == MemoryType.ROIP_FAVORITE) provider?.type?.title else null,
            providerTarget = if (type == MemoryType.ROIP_FAVORITE) provider?.target else null,
            providerHost = if (type == MemoryType.ROIP_FAVORITE) provider?.serverHost else null
        )
    }

    private fun AppUiState.selectedRoipProvider(): ProviderProfile? {
        return providers.firstOrNull {
            it.type.providerId == selectedRoipProviderId && it.type.providerId in ROIP_PROVIDER_IDS
        } ?: selectedDmrRoipProvider()
            ?: providers.firstOrNull { it.type.providerId == ALLSTAR_PROVIDER_ID }
    }

    private fun AppUiState.selectedDmrRoipProvider(): ProviderProfile? {
        return providers.firstOrNull {
            it.type.providerId == selectedRoipProviderId && it.type.providerId in DMR_PROVIDER_IDS
        } ?: providers.firstOrNull { it.type.providerId in DMR_PROVIDER_IDS }
    }

    private fun detectRadioHardwareAvailable(): Boolean {
        return RADIO_HARDWARE_PATHS.any { path ->
            File(path).exists()
        }
    }

    private fun persistNow() {
        persistJob?.cancel()
        persistJob = viewModelScope.launch {
            delay(PERSIST_DEBOUNCE_MS)
            val context = appContext ?: return@launch
            persistState(context, _uiState.value, commit = false)
        }
    }

    private suspend fun persistState(context: Context, state: AppUiState, commit: Boolean) {
        withContext(Dispatchers.IO) {
            persistStateBlocking(context, state, commit)
        }
    }

    private fun persistStateBlocking(context: Context, state: AppUiState, commit: Boolean) {
        val profile = state.comjot.profile
        val hotspot = state.hotspot
        val editor = context
            .getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            .edit()

        editor
            .putString(KEY_BASE_URL, state.baseUrl)
            .putString(KEY_COMJOT_MODE, profile.mode.name)
            .putString(KEY_RX_FREQUENCY, profile.rxFrequency)
            .putString(KEY_TX_FREQUENCY, profile.txFrequency)
            .putString(KEY_LOCAL_ID, profile.localId)
            .putString(KEY_TALKGROUP, profile.talkgroup)
            .putString(KEY_COLOR_CODE, profile.colorCode)
            .putString(KEY_TIME_SLOT, profile.timeSlot)
            .putString(KEY_BANDWIDTH, profile.bandwidth.name)
            .putString(KEY_SQUELCH, profile.squelch)
            .putString(KEY_RX_TONE_MODE, profile.rxToneMode.name)
            .putString(KEY_RX_TONE_CODE, profile.rxToneCode)
            .putString(KEY_TX_TONE_MODE, profile.txToneMode.name)
            .putString(KEY_TX_TONE_CODE, profile.txToneCode)
            .putString(KEY_RF_POWER, profile.rfPower.name)
            .putString(KEY_VOLUME, profile.volume)
            .putString(KEY_MIC_GAIN, profile.micGain)
            .putBoolean(KEY_REPEATER_DECOUPLING, profile.repeaterDecoupling)
            .putString(KEY_BAUD_RATE, profile.baudRate)
            .putBoolean(KEY_DEVELOPER_MODE, state.comjot.developerMode)
            .putString(KEY_MEMORIES, serializeMemories(state.memories))
            .putString(KEY_SELECTED_MEMORY_ID, state.selectedMemoryId)
            .putString(KEY_KNOB_CONTROL_MODE, state.knobControlMode.name)
            .putString(KEY_ACCENT_COLOR, state.accentColor.name)
            .putString(KEY_ROIP_OPERATION_MODE, state.roipOperationMode.name)
            .putString(KEY_SELECTED_ROIP_PROVIDER_ID, state.selectedRoipProviderId)
            .putString(KEY_HOTSPOT_LATITUDE, hotspot.latitude)
            .putString(KEY_HOTSPOT_LONGITUDE, hotspot.longitude)
            .putString(KEY_HOTSPOT_HEIGHT, hotspot.height)
            .putString(KEY_HOTSPOT_LOCATION, hotspot.location)
            .putString(KEY_HOTSPOT_DESCRIPTION, hotspot.description)
            .putString(KEY_HOTSPOT_URL, hotspot.url)
            .putString(KEY_HOTSPOT_SOFTWARE, hotspot.software)
            .putString(KEY_HOTSPOT_PACKAGE_ID, hotspot.packageId)
            .putString(KEY_HOTSPOT_SLOT_FLAGS, hotspot.slotFlags)

        state.providers.forEach { provider ->
            editor
                .putString(providerKey(provider.type.providerId, KEY_PROVIDER_USERNAME), provider.username)
                .putString(providerKey(provider.type.providerId, KEY_PROVIDER_CALLSIGN), provider.callsign)
                .putString(providerKey(provider.type.providerId, KEY_PROVIDER_STATION_ID), provider.stationId)
                .putString(providerKey(provider.type.providerId, KEY_PROVIDER_TARGET), provider.target)
                .putString(providerKey(provider.type.providerId, KEY_PROVIDER_HOST), provider.serverHost)
                .putString(providerKey(provider.type.providerId, KEY_PROVIDER_PORT), provider.serverPort)
                .putString(providerKey(provider.type.providerId, KEY_PROVIDER_TIME_SLOT), provider.timeSlot)
                .putString(providerKey(provider.type.providerId, KEY_PROVIDER_PASSWORD), provider.password)
                .putString(providerKey(provider.type.providerId, KEY_PROVIDER_API_KEY), provider.apiKey)
        }

        if (commit) {
            editor.commit()
        } else {
            editor.apply()
        }
    }

    override fun onCleared() {
        persistJob?.cancel()
        appContext?.let { context ->
            persistStateBlocking(context, _uiState.value, commit = true)
        }
        pollJob?.cancel()
        comjotPttJob?.cancel()
        relayPttJob?.cancel()
        hotspotPttJob?.cancel()
        hotspotRfReleaseJob?.cancel()
        hotspotNetworkReleaseJob?.cancel()
        directRoipController.shutdown()
        allStarIaxController.shutdown()
        comjotController.shutdown()
        super.onCleared()
    }

    private fun applyComjotResult(
        result: ComjotWriteResult,
        sentMessage: (ComjotWriteResult.Sent) -> String,
        pttActiveOnSent: Boolean?,
        programmedOnSent: Boolean?
    ) {
        _uiState.update { current ->
            val currentComjot = current.comjot
            when (result) {
                is ComjotWriteResult.Sent -> current.copy(
                    comjot = currentComjot.copy(
                        isBusy = false,
                        isProgrammed = programmedOnSent ?: currentComjot.isProgrammed,
                        pttActive = pttActiveOnSent ?: currentComjot.pttActive,
                        statusMessage = sentMessage(result),
                        lastPacketHex = result.packetHex,
                        usbPermissionPending = false
                    ),
                    errorMessage = null,
                    lastSyncLabel = "CJ-1 command sent"
                )

                is ComjotWriteResult.PermissionRequired -> current.copy(
                    comjot = currentComjot.copy(
                        isBusy = false,
                        statusMessage = "USB permission requested for ${result.deviceName}. Approve it, then send the command again.",
                        lastPacketHex = result.packetHex,
                        usbPermissionPending = true
                    ),
                    errorMessage = null
                )

                is ComjotWriteResult.NoDevice -> current.copy(
                    comjot = currentComjot.copy(
                        isBusy = false,
                        statusMessage = result.message,
                        lastPacketHex = result.packetHex,
                        usbPermissionPending = false
                    ),
                    errorMessage = result.message
                )

                is ComjotWriteResult.Failed -> current.copy(
                    comjot = currentComjot.copy(
                        isBusy = false,
                        statusMessage = result.message,
                        lastPacketHex = result.packetHex,
                        usbPermissionPending = false
                    ),
                    errorMessage = result.message
                )
            }
        }
    }

    private fun ComjotWriteResult.hotspotMessage(): String {
        return when (this) {
            is ComjotWriteResult.Sent -> "CJ-1 hotspot command sent"
            is ComjotWriteResult.PermissionRequired -> "USB permission required for ${deviceName}"
            is ComjotWriteResult.NoDevice -> message
            is ComjotWriteResult.Failed -> message
        }
    }

    private fun ProviderProfile.loadFromPrefs(prefs: SharedPreferences): ProviderProfile {
        val providerId = type.providerId
        val loadedUsername = prefs.getString(providerKey(providerId, KEY_PROVIDER_USERNAME), username) ?: username
        val loadedTarget = prefs.getString(providerKey(providerId, KEY_PROVIDER_TARGET), target) ?: target
        val migratedTarget = if (providerId == ALLSTAR_PROVIDER_ID && loadedUsername.isBlank() && loadedTarget == LEGACY_ALLSTAR_REMOTE_DEFAULT) {
            ""
        } else {
            loadedTarget
        }
        return copy(
            username = loadedUsername,
            callsign = prefs.getString(providerKey(providerId, KEY_PROVIDER_CALLSIGN), callsign) ?: callsign,
            stationId = prefs.getString(providerKey(providerId, KEY_PROVIDER_STATION_ID), stationId) ?: stationId,
            target = migratedTarget,
            serverHost = prefs.getString(providerKey(providerId, KEY_PROVIDER_HOST), serverHost) ?: serverHost,
            serverPort = prefs.getString(providerKey(providerId, KEY_PROVIDER_PORT), serverPort) ?: serverPort,
            timeSlot = prefs.getString(providerKey(providerId, KEY_PROVIDER_TIME_SLOT), timeSlot) ?: timeSlot,
            password = prefs.getString(providerKey(providerId, KEY_PROVIDER_PASSWORD), password) ?: password,
            apiKey = prefs.getString(providerKey(providerId, KEY_PROVIDER_API_KEY), apiKey) ?: apiKey
        )
    }

    private fun Context.hasLocationPermission(): Boolean {
        return checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED ||
            checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
    }

    private suspend fun Context.bestDeviceLocation(): Location? {
        val locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val providers = locationManager.getProviders(true).filter { provider ->
            provider == LocationManager.GPS_PROVIDER || provider == LocationManager.NETWORK_PROVIDER
        }
        if (providers.isEmpty()) {
            return null
        }

        val lastKnown = providers
            .mapNotNull { provider ->
                runCatching { locationManager.getLastKnownLocation(provider) }.getOrNull()
            }
            .maxByOrNull { it.time }

        if (lastKnown != null && System.currentTimeMillis() - lastKnown.time <= MAX_LAST_LOCATION_AGE_MS) {
            return lastKnown
        }

        return locationManager.awaitSingleLocation(providers, fallback = lastKnown)
    }

    private suspend fun LocationManager.awaitSingleLocation(
        providers: List<String>,
        fallback: Location?
    ): Location? = suspendCancellableCoroutine { continuation ->
        val provider = when {
            LocationManager.GPS_PROVIDER in providers -> LocationManager.GPS_PROVIDER
            else -> providers.first()
        }
        val listener = object : LocationListener {
            override fun onLocationChanged(location: Location) {
                removeUpdates(this)
                if (continuation.isActive) {
                    continuation.resume(location)
                }
            }

            @Deprecated("Deprecated Android callback")
            override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) = Unit

            override fun onProviderEnabled(provider: String) = Unit

            override fun onProviderDisabled(provider: String) = Unit
        }

        continuation.invokeOnCancellation {
            runCatching { removeUpdates(listener) }
        }

        runCatching {
            requestSingleUpdate(provider, listener, Looper.getMainLooper())
        }.onFailure {
            removeUpdates(listener)
            if (continuation.isActive) {
                continuation.resume(fallback)
            }
        }
    }

    private fun HotspotProfile.loadFromPrefs(prefs: SharedPreferences): HotspotProfile {
        val savedSoftware = prefs.getString(KEY_HOTSPOT_SOFTWARE, null)
        val savedPackageId = prefs.getString(KEY_HOTSPOT_PACKAGE_ID, null)
        val oldSingleSoftwareWasPackageId = savedPackageId == null && savedSoftware?.startsWith("MMDVM_") == true

        return copy(
            latitude = prefs.getString(KEY_HOTSPOT_LATITUDE, latitude) ?: latitude,
            longitude = prefs.getString(KEY_HOTSPOT_LONGITUDE, longitude) ?: longitude,
            height = prefs.getString(KEY_HOTSPOT_HEIGHT, height) ?: height,
            location = prefs.getString(KEY_HOTSPOT_LOCATION, location) ?: location,
            description = prefs.getString(KEY_HOTSPOT_DESCRIPTION, description) ?: description,
            url = prefs.getString(KEY_HOTSPOT_URL, url) ?: url,
            software = if (oldSingleSoftwareWasPackageId) software else savedSoftware ?: software,
            packageId = savedPackageId ?: if (oldSingleSoftwareWasPackageId) savedSoftware ?: packageId else packageId,
            slotFlags = prefs.getString(KEY_HOTSPOT_SLOT_FLAGS, slotFlags) ?: slotFlags
        )
    }

    private fun loadMemories(prefs: SharedPreferences): List<RadioMemory> {
        val raw = prefs.getString(KEY_MEMORIES, null).orEmpty()
        if (raw.isBlank()) {
            return emptyList()
        }

        return runCatching {
            val array = JSONArray(raw)
            buildList {
                for (index in 0 until array.length()) {
                    val obj = array.optJSONObject(index) ?: continue
                    add(
                        RadioMemory(
                            id = obj.optString("id", System.currentTimeMillis().toString()),
                            name = obj.optString("name", "Memory"),
                            type = enumByName(MemoryType.entries, obj.optString("type"), MemoryType.REPEATER),
                            mode = enumByName(ComjotMode.entries, obj.optString("mode"), ComjotMode.FM),
                            rxFrequency = obj.optString("rxFrequency", "446.5000"),
                            txFrequency = obj.optString("txFrequency", "446.5000"),
                            localId = obj.optString("localId", ""),
                            talkgroup = obj.optString("talkgroup", "91"),
                            colorCode = obj.optString("colorCode", "1"),
                            timeSlot = obj.optString("timeSlot", "1"),
                            bandwidth = enumByName(ComjotBandwidth.entries, obj.optString("bandwidth"), ComjotBandwidth.NARROW),
                            squelch = obj.optString("squelch", "5"),
                            rxToneMode = enumByName(ComjotToneMode.entries, obj.optString("rxToneMode"), ComjotToneMode.OFF),
                            rxToneCode = obj.optString("rxToneCode", "None"),
                            txToneMode = enumByName(ComjotToneMode.entries, obj.optString("txToneMode"), ComjotToneMode.OFF),
                            txToneCode = obj.optString("txToneCode", "None"),
                            rfPower = enumByName(ComjotRfPower.entries, obj.optString("rfPower"), ComjotRfPower.HIGH),
                            volume = obj.optString("volume", DEFAULT_RADIO_VOLUME),
                            micGain = obj.optString("micGain", "0"),
                            repeaterDecoupling = obj.optBoolean("repeaterDecoupling", false),
                            providerId = obj.optionalString("providerId"),
                            providerTitle = obj.optionalString("providerTitle"),
                            providerTarget = obj.optionalString("providerTarget"),
                            providerHost = obj.optionalString("providerHost")
                        )
                    )
                }
            }.sortedWith(compareBy<RadioMemory> { it.type.ordinal }.thenBy { it.name.lowercase() })
        }.getOrDefault(emptyList())
    }

    private fun serializeMemories(memories: List<RadioMemory>): String {
        val array = JSONArray()
        memories.forEach { memory ->
            val obj = JSONObject()
                .put("id", memory.id)
                .put("name", memory.name)
                .put("type", memory.type.name)
                .put("mode", memory.mode.name)
                .put("rxFrequency", memory.rxFrequency)
                .put("txFrequency", memory.txFrequency)
                .put("localId", memory.localId)
                .put("talkgroup", memory.talkgroup)
                .put("colorCode", memory.colorCode)
                .put("timeSlot", memory.timeSlot)
                .put("bandwidth", memory.bandwidth.name)
                .put("squelch", memory.squelch)
                .put("rxToneMode", memory.rxToneMode.name)
                .put("rxToneCode", memory.rxToneCode)
                .put("txToneMode", memory.txToneMode.name)
                .put("txToneCode", memory.txToneCode)
                .put("rfPower", memory.rfPower.name)
                .put("volume", memory.volume)
                .put("micGain", memory.micGain)
                .put("repeaterDecoupling", memory.repeaterDecoupling)

            memory.providerId?.let { obj.put("providerId", it) }
            memory.providerTitle?.let { obj.put("providerTitle", it) }
            memory.providerTarget?.let { obj.put("providerTarget", it) }
            memory.providerHost?.let { obj.put("providerHost", it) }
            array.put(obj)
        }
        return array.toString()
    }

    private fun JSONObject.optionalString(key: String): String? {
        return optString(key).takeIf { it.isNotBlank() }
    }

    private fun <T> SharedPreferences.getEnum(
        key: String,
        entries: Iterable<T>,
        fallback: T
    ): T where T : Enum<T> {
        return enumByName(entries, getString(key, null), fallback)
    }

    private fun <T> enumByName(
        entries: Iterable<T>,
        name: String?,
        fallback: T
    ): T where T : Enum<T> {
        return entries.firstOrNull { it.name == name } ?: fallback
    }

    private fun com.roip.mobile.data.ComjotProfile.toDigitalProfile(): ComjotDigitalProfile {
        return ComjotDigitalProfile(
            rxHz = parseFrequencyHz(rxFrequency, "RX frequency"),
            txHz = parseFrequencyHz(txFrequency, "TX frequency"),
            localId = parseBoundedInt(localId, "Local DMR ID", 1, 16_777_215),
            talkgroup = parseBoundedInt(talkgroup, "Talkgroup", 1, 16_777_215),
            colorCode = parseBoundedInt(colorCode, "Color code", 0, 15),
            timeSlot = parseBoundedInt(timeSlot, "Time slot", 1, 2),
            highPower = rfPower.highPower,
            volume = parseBoundedInt(volume, "Radio volume", 1, 9),
            micGain = parseBoundedInt(micGain, "Mic gain", 0, 5)
        )
    }

    private fun com.roip.mobile.data.ComjotProfile.toAnalogProfile(
        scanner: Boolean,
        developerSdr: Boolean
    ): ComjotAnalogProfile {
        val txCapable = !scanner
        val rx = parseFrequencyHz(
            value = rxFrequency,
            label = if (scanner) "Scanner RX frequency" else "RX frequency",
            enforceVhfUhf = !(scanner || developerSdr)
        )
        val tx = if (scanner) {
            rx
        } else {
            parseFrequencyHz(
                value = txFrequency,
                label = "TX frequency",
                enforceVhfUhf = !developerSdr
            )
        }

        return ComjotAnalogProfile(
            rxHz = rx,
            txHz = tx,
            wideBandwidth = bandwidth.protocolValue == 1,
            highPower = txCapable && rfPower.highPower,
            squelch = parseBoundedInt(squelch, "Squelch", 0, 9),
            rxToneMode = rxToneMode.protocolValue,
            rxSubcode = parseToneSubcode(rxToneMode, rxToneCode, "RX tone"),
            txToneMode = if (scanner) ComjotToneMode.OFF.protocolValue else txToneMode.protocolValue,
            txSubcode = if (scanner) 0 else parseToneSubcode(txToneMode, txToneCode, "TX tone"),
            powerSave = true,
            volume = parseBoundedInt(volume, "Radio volume", 1, 9),
            monitorOpen = scanner,
            repeaterDecoupling = repeaterDecoupling
        )
    }

    private fun parseFrequencyHz(
        value: String,
        label: String,
        enforceVhfUhf: Boolean = true
    ): Long {
        val trimmed = value.trim()
        val parsed = if (trimmed.contains(".")) {
            trimmed.toDoubleOrNull()?.let { (it * 1_000_000).toLong() }
        } else {
            trimmed.toLongOrNull()
        } ?: throw IllegalArgumentException("$label must be a MHz value or raw Hz")

        if (parsed <= 0L || parsed > UInt.MAX_VALUE.toLong()) {
            throw IllegalArgumentException("$label must fit in the CJ-1 32-bit frequency field")
        }

        if (enforceVhfUhf && !parsed.isVhfUhf()) {
            throw IllegalArgumentException("$label must be in VHF or UHF for transmit-capable CJ-1 profiles")
        }

        return parsed
    }

    private fun parseBoundedInt(value: String, label: String, min: Int, max: Int): Int {
        val parsed = value.trim().toIntOrNull()
            ?: throw IllegalArgumentException("$label must be a number")

        if (parsed !in min..max) {
            throw IllegalArgumentException("$label must be between $min and $max")
        }

        return parsed
    }

    private fun parseToneSubcode(mode: ComjotToneMode, code: String, label: String): Int {
        if (!mode.needsCode) {
            return 0
        }

        val normalized = code.trim()
        val index = when (mode) {
            ComjotToneMode.CTCSS -> COMJOT_CTCSS_CODES.indexOf(normalized)
            ComjotToneMode.DCS,
            ComjotToneMode.REVERSE_DCS -> COMJOT_DCS_CODES.indexOf(normalized.padStart(3, '0'))
            ComjotToneMode.OFF -> 0
        }

        if (index < 0) {
            val expected = if (mode == ComjotToneMode.CTCSS) {
                "a listed PL tone such as 67.0"
            } else {
                "a listed DCS code such as 023"
            }
            throw IllegalArgumentException("$label must be $expected")
        }

        return index
    }

    private fun Long.isVhfUhf(): Boolean {
        return this in 136_000_000L..174_000_000L || this in 400_000_000L..480_000_000L
    }

    private fun ComjotMode.isTxEnabled(developerMode: Boolean): Boolean {
        return txEnabled || (developerMode && this == ComjotMode.SCANNER)
    }

    private fun ComjotMode.titleFor(developerMode: Boolean): String {
        return if (developerMode && this == ComjotMode.SCANNER) "SDR" else title
    }

    private fun String?.shouldUseDefaultHotspotSoftwareId(): Boolean {
        return this == null || startsWith("MMDVM_") || this == LEGACY_HOTSPOT_SOFTWARE_ID_DEFAULT
    }

    private fun formatFrequency(value: Double): String {
        return String.format(Locale.US, "%.4f", value)
    }

    private fun providerKey(providerId: String, field: String): String {
        return "provider.$providerId.$field"
    }

    private fun ProviderProfile.withBrandmeisterQr(config: BrandmeisterQrConfig): ProviderProfile {
        return copy(
            callsign = config.callsign ?: callsign,
            stationId = config.stationId ?: stationId,
            target = config.target ?: target,
            serverHost = config.serverHost ?: serverHost,
            serverPort = config.serverPort ?: serverPort,
            timeSlot = config.timeSlot ?: timeSlot,
            password = config.password ?: password,
            apiKey = config.apiKey ?: apiKey
        )
    }

    private data class BrandmeisterQrConfig(
        val apiKey: String? = null,
        val callsign: String? = null,
        val stationId: String? = null,
        val target: String? = null,
        val serverHost: String? = null,
        val serverPort: String? = null,
        val timeSlot: String? = null,
        val password: String? = null
    ) {
        val hasAnyField: Boolean
            get() = listOf(apiKey, callsign, stationId, target, serverHost, serverPort, timeSlot, password)
                .any { !it.isNullOrBlank() }

        companion object {
            fun parse(rawValue: String): BrandmeisterQrConfig? {
                val trimmed = rawValue.trim()
                if (trimmed.isBlank()) {
                    return null
                }

                return parseJson(trimmed)
                    ?: parseUri(trimmed)
                    ?: parseKeyValueText(trimmed)
                    ?: parseRawKey(trimmed)
            }

            private fun parseJson(raw: String): BrandmeisterQrConfig? {
                if (!raw.startsWith("{")) {
                    return null
                }

                return runCatching {
                    val root = JSONObject(raw)
                    val objects = listOfNotNull(
                        root,
                        root.optJSONObject("brandmeister"),
                        root.optJSONObject("provider"),
                        root.optJSONObject("roip"),
                        root.optJSONObject("node")
                    )

                    BrandmeisterQrConfig(
                        apiKey = objects.findValue("bm_api_key", "bmApiKey", "brandmeisterApiKey", "api_key", "apiKey", "key", "token"),
                        callsign = objects.findValue("callsign", "call", "radioCallsign"),
                        stationId = objects.findValue("station_id", "stationId", "hotspot_id", "hotspotId", "node_id", "nodeId", "dmr_id", "dmrId"),
                        target = objects.findValue("target", "talkgroup", "tg"),
                        serverHost = objects.findValue("host", "server", "serverHost", "master"),
                        serverPort = objects.findValue("port", "serverPort"),
                        timeSlot = objects.findValue("slot", "timeSlot", "timeslot", "roipSlot", "roip_slot"),
                        password = objects.findValue("password", "hotspotPassword", "hotspot_security", "hotspotSecurity")
                    ).takeIf { it.hasAnyField }
                }.getOrNull()
            }

            private fun parseUri(raw: String): BrandmeisterQrConfig? {
                val uri = runCatching { Uri.parse(raw) }.getOrNull() ?: return null
                if (uri.scheme.isNullOrBlank() || uri.query.isNullOrBlank()) {
                    return null
                }

                fun param(vararg names: String): String? {
                    return names.firstNotNullOfOrNull { name ->
                        uri.getQueryParameter(name)?.cleanQrValue()
                    }
                }

                return BrandmeisterQrConfig(
                    apiKey = param("bm_api_key", "bmApiKey", "brandmeisterApiKey", "api_key", "apiKey", "key", "token"),
                    callsign = param("callsign", "call", "radioCallsign"),
                    stationId = param("station_id", "stationId", "hotspot_id", "hotspotId", "node_id", "nodeId", "dmr_id", "dmrId"),
                    target = param("target", "talkgroup", "tg"),
                    serverHost = param("host", "server", "serverHost", "master"),
                    serverPort = param("port", "serverPort"),
                    timeSlot = param("slot", "timeSlot", "timeslot", "roipSlot", "roip_slot"),
                    password = param("password", "hotspotPassword", "hotspot_security", "hotspotSecurity")
                ).takeIf { it.hasAnyField }
            }

            private fun parseKeyValueText(raw: String): BrandmeisterQrConfig? {
                val values = KEY_VALUE_REGEX.findAll(raw).associate { match ->
                    match.groupValues[1].lowercase(Locale.US) to match.groupValues[2].urlDecode().cleanQrValue()
                }
                if (values.isEmpty()) {
                    return null
                }

                fun value(vararg names: String): String? {
                    return names.firstNotNullOfOrNull { name ->
                        values[name.lowercase(Locale.US)]
                    }
                }

                return BrandmeisterQrConfig(
                    apiKey = value("bm_api_key", "bmapikey", "brandmeisterapikey", "api_key", "apikey", "key", "token"),
                    callsign = value("callsign", "call", "radiocallsign"),
                    stationId = value("station_id", "stationid", "hotspot_id", "hotspotid", "node_id", "nodeid", "dmr_id", "dmrid"),
                    target = value("target", "talkgroup", "tg"),
                    serverHost = value("host", "server", "serverhost", "master"),
                    serverPort = value("port", "serverport"),
                    timeSlot = value("slot", "timeslot", "time_slot", "roipslot", "roip_slot"),
                    password = value("password", "hotspotpassword", "hotspot_security", "hotspotsecurity")
                ).takeIf { it.hasAnyField }
            }

            private fun parseRawKey(raw: String): BrandmeisterQrConfig? {
                val key = when {
                    raw.startsWith("bmapi:", ignoreCase = true) -> raw.substringAfter(':')
                    raw.startsWith("brandmeister-api-key:", ignoreCase = true) -> raw.substringAfter(':')
                    raw.length >= 12 && raw.none(Char::isWhitespace) && !raw.contains("://") -> raw
                    else -> null
                }?.cleanQrValue()

                return key?.let { BrandmeisterQrConfig(apiKey = it) }
            }

            private fun List<JSONObject>.findValue(vararg keys: String): String? {
                return firstNotNullOfOrNull { obj ->
                    keys.firstNotNullOfOrNull { key ->
                        obj.optString(key, "").cleanQrValue()
                    }
                }
            }

            private fun String.urlDecode(): String {
                return runCatching { URLDecoder.decode(this, "UTF-8") }.getOrDefault(this)
            }

            private fun String.cleanQrValue(): String? {
                val cleaned = trim()
                    .removePrefix("Bearer ")
                    .removePrefix("bearer ")
                    .trim()
                    .takeIf { it.isNotBlank() }
                return cleaned
            }

            private val KEY_VALUE_REGEX = Regex("""(?i)(?:^|[?&\s])([a-z0-9_.-]+)=([^&\s]+)""")
        }
    }

    private companion object {
        private const val PREFS_NAME = "openradio_state"
        private const val BRANDMEISTER_PROVIDER_ID = "brandmeister"
        private const val ALLSTAR_PROVIDER_ID = "allstar"
        private const val LEGACY_ALLSTAR_REMOTE_DEFAULT = "51000"
        private val DMR_PROVIDER_IDS = setOf("brandmeister", "tgif", "freedmr")
        private val ROIP_PROVIDER_IDS = DMR_PROVIDER_IDS + ALLSTAR_PROVIDER_ID
        private const val KEY_BASE_URL = "base_url"
        private const val KEY_COMJOT_MODE = "comjot.mode"
        private const val KEY_RX_FREQUENCY = "comjot.rx_frequency"
        private const val KEY_TX_FREQUENCY = "comjot.tx_frequency"
        private const val KEY_LOCAL_ID = "comjot.local_id"
        private const val KEY_TALKGROUP = "comjot.talkgroup"
        private const val KEY_COLOR_CODE = "comjot.color_code"
        private const val KEY_TIME_SLOT = "comjot.time_slot"
        private const val KEY_BANDWIDTH = "comjot.bandwidth"
        private const val KEY_SQUELCH = "comjot.squelch"
        private const val KEY_RX_TONE_MODE = "comjot.rx_tone_mode"
        private const val KEY_RX_TONE_CODE = "comjot.rx_tone_code"
        private const val KEY_TX_TONE_MODE = "comjot.tx_tone_mode"
        private const val KEY_TX_TONE_CODE = "comjot.tx_tone_code"
        private const val KEY_RF_POWER = "comjot.rf_power"
        private const val KEY_VOLUME = "comjot.volume"
        private const val KEY_RADIO_VOLUME_DEFAULT_MIGRATED = "comjot.volume_default_migrated_v2"
        private const val KEY_MIC_GAIN = "comjot.mic_gain"
        private const val KEY_REPEATER_DECOUPLING = "comjot.repeater_decoupling"
        private const val KEY_BAUD_RATE = "comjot.baud_rate"
        private const val KEY_DEVELOPER_MODE = "developer_mode"
        private const val KEY_MEMORIES = "memories"
        private const val KEY_SELECTED_MEMORY_ID = "selected_memory_id"
        private const val KEY_KNOB_CONTROL_MODE = "knob_control_mode"
        private const val KEY_ACCENT_COLOR = "accent_color"
        private const val KEY_ROIP_OPERATION_MODE = "roip_operation_mode"
        private const val KEY_SELECTED_ROIP_PROVIDER_ID = "selected_roip_provider_id"
        private const val KEY_PROVIDER_USERNAME = "username"
        private const val KEY_PROVIDER_CALLSIGN = "callsign"
        private const val KEY_PROVIDER_STATION_ID = "station_id"
        private const val KEY_PROVIDER_TARGET = "target"
        private const val KEY_PROVIDER_HOST = "host"
        private const val KEY_PROVIDER_PORT = "port"
        private const val KEY_PROVIDER_TIME_SLOT = "time_slot"
        private const val KEY_PROVIDER_PASSWORD = "password"
        private const val KEY_PROVIDER_API_KEY = "api_key"
        private const val KEY_HOTSPOT_LATITUDE = "hotspot.latitude"
        private const val KEY_HOTSPOT_LONGITUDE = "hotspot.longitude"
        private const val KEY_HOTSPOT_HEIGHT = "hotspot.height"
        private const val KEY_HOTSPOT_LOCATION = "hotspot.location"
        private const val KEY_HOTSPOT_DESCRIPTION = "hotspot.description"
        private const val KEY_HOTSPOT_URL = "hotspot.url"
        private const val KEY_HOTSPOT_SOFTWARE = "hotspot.software"
        private const val KEY_HOTSPOT_SOFTWARE_ID_DEFAULT_MIGRATED = "hotspot.software_id_default_migrated_v2"
        private const val KEY_HOTSPOT_PACKAGE_ID = "hotspot.package_id"
        private const val KEY_HOTSPOT_PACKAGE_ID_DEFAULT_MIGRATED = "hotspot.package_id_default_migrated"
        private const val KEY_HOTSPOT_SLOT_FLAGS = "hotspot.slot_flags"
        private const val KEY_HOTSPOT_SLOT_FLAGS_DEFAULT_MIGRATED = "hotspot.slot_flags_default_migrated"
        private const val DEFAULT_RADIO_VOLUME = "6"
        private const val LEGACY_RADIO_VOLUME_DEFAULT = "8"
        private const val DEFAULT_HOTSPOT_SOFTWARE_ID = "20200922"
        private const val LEGACY_HOTSPOT_SOFTWARE_ID_DEFAULT = "MMDVMHost-20200615"
        private const val DEFAULT_HOTSPOT_PACKAGE_ID = "MMDVM_MMDVM_HS_Hat"
        private const val LEGACY_HOTSPOT_PACKAGE_DEFAULT = "MMDVM_DMO"
        private const val DEFAULT_HOTSPOT_SLOT_FLAGS = "4"
        private const val LEGACY_HOTSPOT_SLOT_FLAGS_DEFAULT = "1"
        private const val FREQUENCY_STEP_MHZ = 0.0125
        private const val ROIP_CONNECT_TIMEOUT_MS = 15_000L
        private const val HOTSPOT_RF_HANG_MS = 850L
        private const val HOTSPOT_NETWORK_HANG_MS = 850L
        private const val HOTSPOT_AUDIO_GATE = 1
        private const val LOCATION_TIMEOUT_MS = 10_000L
        private const val MAX_LAST_LOCATION_AGE_MS = 5 * 60 * 1_000L
        private const val PERSIST_DEBOUNCE_MS = 250L
        private val RADIO_HARDWARE_PATHS = listOf(
            "/sys/bus/platform/drivers/dmr_gpio/auctusctl",
            "/sys/bus/platform/drivers/dmr_gpio/dmr_pwr",
            "/sys/devices/platform/dmr_gpio/dmrptt"
        )
    }
}
