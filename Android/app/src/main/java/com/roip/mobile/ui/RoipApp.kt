package com.roip.mobile.ui

import android.Manifest
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.roip.mobile.BuildConfig
import com.roip.mobile.MainViewModel
import com.roip.mobile.data.AccentColor
import com.roip.mobile.data.AppUiState
import com.roip.mobile.data.COMJOT_CTCSS_CODES
import com.roip.mobile.data.COMJOT_DCS_CODES
import com.roip.mobile.data.ComjotBandwidth
import com.roip.mobile.data.ComjotField
import com.roip.mobile.data.ComjotMode
import com.roip.mobile.data.ComjotRfPower
import com.roip.mobile.data.ComjotToneMode
import com.roip.mobile.data.ComjotUiState
import com.roip.mobile.data.HotspotField
import com.roip.mobile.data.KnobControlMode
import com.roip.mobile.data.MemoryType
import com.roip.mobile.data.ProviderField
import com.roip.mobile.data.ProviderProfile
import com.roip.mobile.data.RadioMemory
import com.roip.mobile.data.RoipOperationMode
import com.roip.mobile.data.SessionSnapshot
import kotlin.math.PI
import kotlin.math.abs
import kotlin.math.cos
import kotlin.math.exp
import kotlin.math.sin

@Composable
fun RoipApp(viewModel: MainViewModel = viewModel()) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    val context = LocalContext.current
    var settingsOpen by remember { mutableStateOf(false) }
    val locationPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions()
    ) { grants ->
        if (grants.values.any { it }) {
            viewModel.updateHotspotFromDeviceLocation(context)
        } else {
            viewModel.rejectDeviceLocationPermission()
        }
    }
    val useDeviceLocation = {
        val hasFineLocation = context.checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
        val hasCoarseLocation = context.checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
        if (hasFineLocation || hasCoarseLocation) {
            viewModel.updateHotspotFromDeviceLocation(context)
        } else {
            locationPermissionLauncher.launch(
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )
            )
        }
    }

    LaunchedEffect(Unit) {
        viewModel.loadPersistedState(context)
    }

    RoipTheme(accentColor = state.accentColor) {
        Surface(modifier = Modifier.fillMaxSize()) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background),
                contentPadding = PaddingValues(12.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                item {
                    if (settingsOpen) {
                        SettingsHeader(onBack = { settingsOpen = false })
                    } else {
                        OperatorHeader(
                            state = state,
                            onModeSelected = { mode -> viewModel.updateComjot(ComjotField.MODE, mode.name) },
                            onRecallMemory = viewModel::recallMemory,
                            onSaveMemory = viewModel::saveCurrentMemory,
                            onSettingsClicked = { settingsOpen = true }
                        )
                    }
                }

                if (settingsOpen) {
                    item {
                        SettingsPanel(
                            state = state,
                            onComjotFieldChanged = viewModel::updateComjot,
                            onHotspotFieldChanged = viewModel::updateHotspot,
                            onUseDeviceLocation = useDeviceLocation,
                            onKnobControlChanged = viewModel::updateKnobControlMode,
                            onAccentColorChanged = viewModel::updateAccentColor,
                            onProviderFieldChanged = viewModel::updateProvider,
                            onScanBrandmeisterQr = { providerId -> viewModel.scanBrandmeisterQr(context, providerId) },
                            onVersionTapped = viewModel::onVersionTapped
                        )
                    }

                    state.errorMessage?.let { message ->
                        item {
                            ErrorCard(message = message)
                        }
                    }
                } else {
                    item {
                        RadioPanel(
                            state = state,
                            onFieldChanged = viewModel::updateComjot,
                            onProviderFieldChanged = viewModel::updateProvider,
                            onProgram = { viewModel.programComjot(context) },
                            onConnect = viewModel::connect,
                            onRoipOperationModeChanged = viewModel::updateRoipOperationMode,
                            onRoipProviderSelected = viewModel::updateSelectedRoipProvider,
                            onSendAllStarDtmf = viewModel::sendAllStarDtmf,
                            onPrepareHotspot = { viewModel.prepareRoipHotspot(context) },
                            onRoipPttStart = { viewModel.setRelayPtt(true) },
                            onRoipPttEnd = { viewModel.setRelayPtt(false) },
                            onDisconnect = viewModel::disconnect,
                            onPttStart = {
                                if (state.comjot.profile.mode == ComjotMode.ROIP && state.roipOperationMode == RoipOperationMode.HOTSPOT) {
                                    viewModel.setHotspotPtt(true)
                                } else {
                                    viewModel.setComjotPtt(context, true)
                                }
                            },
                            onPttEnd = {
                                if (state.comjot.profile.mode == ComjotMode.ROIP && state.roipOperationMode == RoipOperationMode.HOTSPOT) {
                                    viewModel.setHotspotPtt(false)
                                } else {
                                    viewModel.setComjotPtt(context, false)
                                }
                            },
                            onAudioPermissionDenied = viewModel::rejectComjotAudioPermission
                        )
                    }

                    state.errorMessage?.let { message ->
                        item {
                            ErrorCard(message = message)
                        }
                    }

                    state.activeSession?.let { session ->
                        if (state.comjot.profile.mode != ComjotMode.ROIP) {
                            item {
                                SessionPanel(
                                    session = session,
                                    isBusy = state.isBusy,
                                    onTogglePtt = viewModel::togglePtt,
                                    onDisconnect = viewModel::disconnect
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun OperatorHeader(
    state: AppUiState,
    onModeSelected: (ComjotMode) -> Unit,
    onRecallMemory: (String) -> Unit,
    onSaveMemory: (String, MemoryType) -> Unit,
    onSettingsClicked: () -> Unit
) {
    var modeMenuOpen by remember { mutableStateOf(false) }
    var memoryMenuOpen by remember { mutableStateOf(false) }
    val mode = state.comjot.profile.mode
    val memoriesForMode = state.memories
        .filter { it.mode == mode || it.type == defaultMemoryType(mode) }
        .sortedWith(compareBy<RadioMemory> { it.type.ordinal }.thenBy { it.name.lowercase() })

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Box(modifier = Modifier.weight(1f)) {
            RadioTopButton(
                text = modeTitle(mode, state.comjot.developerMode),
                modifier = Modifier.fillMaxWidth(),
                onClick = { modeMenuOpen = true }
            )
            DropdownMenu(expanded = modeMenuOpen, onDismissRequest = { modeMenuOpen = false }) {
                ComjotMode.entries.forEach { nextMode ->
                    DropdownMenuItem(
                        text = { Text(modeTitle(nextMode, state.comjot.developerMode)) },
                        onClick = {
                            onModeSelected(nextMode)
                            modeMenuOpen = false
                        }
                    )
                }
            }
        }
        Box(modifier = Modifier.weight(0.9f)) {
            RadioTopButton(
                text = "MEM",
                modifier = Modifier.fillMaxWidth(),
                onClick = { memoryMenuOpen = true }
            )
            DropdownMenu(expanded = memoryMenuOpen, onDismissRequest = { memoryMenuOpen = false }) {
                DropdownMenuItem(
                    text = {
                        Column {
                            Text("Save current", fontWeight = FontWeight.SemiBold)
                            Text(
                                defaultMemoryType(mode).title,
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    },
                    onClick = {
                        onSaveMemory("", defaultMemoryType(mode))
                        memoryMenuOpen = false
                    }
                )
                HorizontalDivider()
                if (memoriesForMode.isEmpty()) {
                    DropdownMenuItem(
                        text = { Text("No ${modeTitle(mode, state.comjot.developerMode)} memories") },
                        onClick = { memoryMenuOpen = false }
                    )
                } else {
                    memoriesForMode.forEach { memory ->
                        DropdownMenuItem(
                            text = {
                                Column {
                                    Text(memory.name, fontWeight = FontWeight.SemiBold)
                                    Text(
                                        memory.subtitle(),
                                        style = MaterialTheme.typography.bodySmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }
                            },
                            onClick = {
                                onRecallMemory(memory.id)
                                memoryMenuOpen = false
                            }
                        )
                    }
                }
            }
        }
        RadioTopButton(
            text = "☰",
            modifier = Modifier.width(54.dp),
            onClick = onSettingsClicked
        )
    }
}

@Composable
private fun RadioTopButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier.height(52.dp),
        shape = RoundedCornerShape(8.dp),
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
private fun SettingsHeader(
    onBack: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Settings",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "OpenRadio",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            OutlinedButton(onClick = onBack) {
                Text("Back")
            }
        }
    }
}

@Composable
private fun RadioPanel(
    state: AppUiState,
    onFieldChanged: (ComjotField, String) -> Unit,
    onProviderFieldChanged: (String, ProviderField, String) -> Unit,
    onProgram: () -> Unit,
    onConnect: (String) -> Unit,
    onRoipOperationModeChanged: (String) -> Unit,
    onRoipProviderSelected: (String) -> Unit,
    onSendAllStarDtmf: (String) -> Unit,
    onPrepareHotspot: () -> Unit,
    onRoipPttStart: () -> Unit,
    onRoipPttEnd: () -> Unit,
    onDisconnect: () -> Unit,
    onPttStart: () -> Unit,
    onPttEnd: () -> Unit,
    onAudioPermissionDenied: () -> Unit
) {
    val comjot = state.comjot
    val profile = comjot.profile
    val activeSession = state.activeSession
    val isRoip = profile.mode == ComjotMode.ROIP
    val isHotspotMode = state.roipOperationMode == RoipOperationMode.HOTSPOT
    val useStandalonePtt = isRoip && isHotspotMode
    val txEnabled = profile.mode.isTxEnabled(comjot.developerMode)
    val roipProvider = state.selectedRoipProvider()
    val pttActive = if (useStandalonePtt) {
        comjot.pttActive
    } else if (isRoip) {
        activeSession?.pttActive == true
    } else {
        comjot.pttActive
    }
    val pttEnabled = if (useStandalonePtt) {
        comjot.isProgrammed && activeSession?.providerId == ALLSTAR_PROVIDER_ID
    } else if (isRoip) {
        !isHotspotMode && (activeSession?.phase in listOf("connected", "transmitting"))
    } else {
        txEnabled && comjot.isProgrammed
    }
    val actionLabel = when {
        isRoip && isHotspotMode && activeSession != null && comjot.isProgrammed -> "Re-arm Hotspot"
        isRoip && isHotspotMode -> "Start Hotspot"
        isRoip && activeSession != null -> "Disconnect"
        isRoip -> "Connect ${roipProvider?.type?.title ?: "ROIP"}"
        profile.mode == ComjotMode.DMR -> "Program DMR"
        profile.mode == ComjotMode.FM -> "Program FM"
        profile.mode == ComjotMode.SCANNER && comjot.developerMode -> "Program SDR"
        else -> "Tune Scanner"
    }

    Card(
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            RadioFaceDisplay(
                state = state,
                provider = roipProvider,
                onFieldChanged = onFieldChanged
            )

            RadioQuickControls(
                state = state,
                provider = roipProvider,
                onFieldChanged = onFieldChanged,
                onProviderFieldChanged = onProviderFieldChanged,
                onRoipOperationModeChanged = onRoipOperationModeChanged,
                onRoipProviderSelected = onRoipProviderSelected,
                onSendAllStarDtmf = onSendAllStarDtmf
            )

            if (profile.mode == ComjotMode.SCANNER) {
                ScannerWaveform(
                    active = comjot.isProgrammed,
                    developerMode = comjot.developerMode,
                    centerFrequency = profile.rxFrequency,
                    onTune = { frequency ->
                        onFieldChanged(ComjotField.RX_FREQUENCY, frequency)
                        if (!state.isBusy && !comjot.isBusy) {
                            onProgram()
                        }
                    }
                )
            }

            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Button(
                    onClick = {
                        if (isRoip) {
                            if (isHotspotMode) {
                                onPrepareHotspot()
                            } else if (activeSession != null) {
                                onDisconnect()
                            } else {
                                roipProvider?.let { onConnect(it.type.providerId) }
                            }
                        } else {
                            onProgram()
                        }
                    },
                    enabled = !state.isBusy && !comjot.isBusy && (!isRoip || roipProvider != null),
                    modifier = Modifier.weight(1f)
                ) {
                    Text(actionLabel, maxLines = 1, overflow = TextOverflow.Ellipsis)
                }
                if (!isRoip && !txEnabled) {
                    OutlinedButton(
                        onClick = {},
                        enabled = false,
                        modifier = Modifier.weight(0.7f)
                    ) {
                        Text("RX Only")
                    }
                }
            }

            HoldToTalkButton(
                enabled = pttEnabled,
                active = pttActive,
                busy = state.isBusy || comjot.isBusy,
                disabledText = when {
                    isRoip && isHotspotMode -> "Start hotspot first"
                    isRoip -> "Connect first"
                    else -> "Program first"
                },
                onStart = if (isRoip && !useStandalonePtt) onRoipPttStart else onPttStart,
                onEnd = if (isRoip && !useStandalonePtt) onRoipPttEnd else onPttEnd,
                onAudioPermissionDenied = onAudioPermissionDenied
            )

            Text(
                text = if (isRoip) {
                    when {
                        activeSession != null -> activeSession.statusMessage
                        isHotspotMode -> "Hotspot gateway standby"
                        else -> "Ready to connect ${roipProvider?.type?.title ?: "ROIP"}"
                    }
                } else {
                    comjot.statusMessage
                },
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            state.lastSyncLabel?.let { label ->
                Text(
                    text = label,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Composable
private fun RadioFaceDisplay(
    state: AppUiState,
    provider: ProviderProfile?,
    onFieldChanged: (ComjotField, String) -> Unit
) {
    val profile = state.comjot.profile
    val session = state.activeSession
    val isRoip = profile.mode == ComjotMode.ROIP
    val isAllStar = isRoip && provider?.type?.providerId == ALLSTAR_PROVIDER_ID
    val displayTitle = if (isRoip) {
        session?.providerName ?: provider?.type?.title ?: "ROIP"
    } else {
        "RX:"
    }
    val primaryValue = if (isRoip) {
        session?.serverHost ?: provider?.serverHost ?: "No server"
    } else {
        profile.rxFrequency
    }
    val secondaryTitle = if (isRoip) "LINK:" else "TX:"
    val secondaryValue = if (isRoip) {
        if (isAllStar) {
            val nodePath = provider?.let {
                listOf(it.stationId, it.target)
                    .filter { node -> node.isNotBlank() }
                    .joinToString(" -> ")
            }.orEmpty()
            session?.let { "${it.target} ${it.phase.sessionPhaseLabel()}" }
                ?: nodePath.ifBlank { "Node not configured" }
        } else {
            session?.let { "TG ${it.target} ${it.phase.sessionPhaseLabel()}" }
                ?: provider?.let { "TG ${it.target} Slot ${it.timeSlot}" }
                ?: "Not configured"
        }
    } else {
        profile.txFrequency
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.46f),
                shape = RoundedCornerShape(18.dp)
            )
            .border(
                width = 2.dp,
                color = MaterialTheme.colorScheme.outline.copy(alpha = 0.48f),
                shape = RoundedCornerShape(18.dp)
            )
            .padding(horizontal = 16.dp, vertical = 14.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        IndicatorStrip(state)
        RadioReadoutBlock(
            label = displayTitle,
            value = primaryValue,
            editable = !isRoip,
            onValueChange = { onFieldChanged(ComjotField.RX_FREQUENCY, it) }
        )
        RadioReadoutBlock(
            label = secondaryTitle,
            value = secondaryValue,
            editable = !isRoip && profile.mode != ComjotMode.SCANNER,
            onValueChange = { onFieldChanged(ComjotField.TX_FREQUENCY, it) }
        )
        if (isAllStar) {
            AllStarInfoBox(state, provider)
        } else if (profile.mode == ComjotMode.DMR || isRoip) {
            DmrInfoBox(state, provider)
        }
    }
}

@Composable
private fun IndicatorStrip(state: AppUiState) {
    val profile = state.comjot.profile
    val session = state.activeSession
    val analogMode = profile.mode == ComjotMode.FM || profile.mode == ComjotMode.SCANNER
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IndicatorLight(
            label = if (state.comjot.developerMode && profile.mode == ComjotMode.SCANNER) "SDR" else profile.mode.title.uppercase(),
            active = true
        )
        if (profile.mode != ComjotMode.ROIP) {
            IndicatorLight(
                label = if (profile.rfPower == ComjotRfPower.HIGH) "HI" else "LO",
                active = true
            )
        }
        if (analogMode) {
            IndicatorLight(
                label = "RX TONE",
                active = profile.rxToneMode != ComjotToneMode.OFF
            )
            IndicatorLight(
                label = "TX TONE",
                active = profile.txToneMode != ComjotToneMode.OFF && profile.mode != ComjotMode.SCANNER
            )
        }
        if (profile.mode == ComjotMode.ROIP && state.roipOperationMode == RoipOperationMode.HOTSPOT) {
            IndicatorLight(
                label = "HOTSPOT",
                active = true
            )
        }
        IndicatorLight(
            label = "NET",
            active = session?.phase in listOf("connected", "transmitting")
        )
    }
}

@Composable
private fun IndicatorLight(
    label: String,
    active: Boolean
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Box(
            modifier = Modifier
                .size(8.dp)
                .background(
                    color = if (active) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline.copy(alpha = 0.35f),
                    shape = CircleShape
                )
        )
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            maxLines = 1
        )
    }
}

@Composable
private fun RadioReadoutBlock(
    label: String,
    value: String,
    editable: Boolean,
    onValueChange: (String) -> Unit
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = label,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        if (editable) {
            OutlinedTextField(
                value = value,
                onValueChange = onValueChange,
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                textStyle = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Bold
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
            )
        } else {
            Text(
                text = value,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
private fun DmrInfoBox(
    state: AppUiState,
    provider: ProviderProfile?
) {
    val profile = state.comjot.profile
    val session = state.activeSession
    val target = session?.lastInboundTargetId?.let { "TG $it" }
        ?: session?.target?.let { "TG $it" }
        ?: provider?.target?.let { "TG $it" }
        ?: "TG ${profile.talkgroup}"
    val source = session?.lastInboundCallsign
        ?: session?.lastInboundSourceId?.let { "ID $it" }
        ?: profile.localId.ifBlank { "No caller" }
    val slot = session?.lastInboundSlot?.toString()
        ?: provider?.timeSlot
        ?: profile.timeSlot
    val colorCode = profile.colorCode
    val frameLabel = session?.lastInboundFrameType ?: "Idle"
    val sourceDetail = listOfNotNull(
        session?.lastInboundName,
        session?.lastInboundLocation
    ).filter { it.isNotBlank() }.joinToString(" / ")

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                MaterialTheme.colorScheme.background.copy(alpha = 0.55f),
                RoundedCornerShape(10.dp)
            )
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "DMR",
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            StatusPill(frameLabel)
        }
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            DmrMetric(label = "Target", value = target, modifier = Modifier.weight(1f))
            DmrMetric(label = "Color", value = "CC $colorCode", modifier = Modifier.weight(1f))
            DmrMetric(label = "Slot", value = "S$slot", modifier = Modifier.weight(1f))
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.10f),
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(horizontal = 10.dp, vertical = 9.dp),
            verticalArrangement = Arrangement.spacedBy(3.dp)
        ) {
            Text(
                text = "CALLER",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = source,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            if (sourceDetail.isNotBlank()) {
                Text(
                    text = sourceDetail,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
private fun AllStarInfoBox(
    state: AppUiState,
    provider: ProviderProfile?
) {
    val session = state.activeSession
    val localNode = provider?.stationId?.ifBlank { "Local node" } ?: "Local node"
    val remoteNode = provider?.target?.ifBlank { "No auto-link" } ?: "No auto-link"
    val frameLabel = session?.phase?.sessionPhaseLabel() ?: "Idle"
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                MaterialTheme.colorScheme.background.copy(alpha = 0.55f),
                RoundedCornerShape(10.dp)
            )
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "ALLSTAR",
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            StatusPill(frameLabel)
        }
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            DmrMetric(label = "Local", value = localNode, modifier = Modifier.weight(1f))
            DmrMetric(label = "Remote", value = remoteNode, modifier = Modifier.weight(1f))
            DmrMetric(label = "Codec", value = "uLaw", modifier = Modifier.weight(1f))
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.10f),
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(horizontal = 10.dp, vertical = 9.dp),
            verticalArrangement = Arrangement.spacedBy(3.dp)
        ) {
            Text(
                text = "CALLER",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = provider?.callsign?.ifBlank { provider.username.ifBlank { "OpenRadio" } } ?: "OpenRadio",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
private fun DmrMetric(
    label: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(
                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.36f),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(horizontal = 8.dp, vertical = 7.dp),
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            maxLines = 1
        )
        Text(
            text = value,
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
private fun RadioQuickControls(
    state: AppUiState,
    provider: ProviderProfile?,
    onFieldChanged: (ComjotField, String) -> Unit,
    onProviderFieldChanged: (String, ProviderField, String) -> Unit,
    onRoipOperationModeChanged: (String) -> Unit,
    onRoipProviderSelected: (String) -> Unit,
    onSendAllStarDtmf: (String) -> Unit
) {
    val profile = state.comjot.profile
    val isAllStar = provider?.type?.providerId == ALLSTAR_PROVIDER_ID
    if (profile.mode == ComjotMode.ROIP) {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                RoipProviderButton(
                    providers = state.roipProviderProfiles(),
                    selectedProvider = provider,
                    onSelected = { onRoipProviderSelected(it.type.providerId) },
                    modifier = Modifier.weight(1f)
                )
                DmrMenuButton(
                    state = state,
                    provider = provider,
                    onFieldChanged = onFieldChanged,
                    onProviderFieldChanged = onProviderFieldChanged,
                    modifier = Modifier.weight(1f)
                )
                RoipOperationModeButton(
                    selected = state.roipOperationMode,
                    onSelected = { onRoipOperationModeChanged(it.name) },
                    modifier = Modifier.weight(1f)
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                if (isAllStar) {
                    DtmfMenuButton(
                        onSend = onSendAllStarDtmf,
                        modifier = Modifier.weight(1f)
                    )
                }
                HotspotRfMenuButton(
                    state = state,
                    provider = provider,
                    onFieldChanged = onFieldChanged,
                    onProviderFieldChanged = onProviderFieldChanged,
                    modifier = Modifier.weight(1f)
                )
            }
        }
        return
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        when (profile.mode) {
            ComjotMode.FM,
            ComjotMode.SCANNER -> {
                ToneMenuButton(
                    profile = profile,
                    txEnabled = profile.mode.isTxEnabled(state.comjot.developerMode),
                    onFieldChanged = onFieldChanged,
                    modifier = Modifier.weight(1f)
                )
                BandwidthMenuButton(
                    selected = profile.bandwidth,
                    onSelected = { onFieldChanged(ComjotField.BANDWIDTH, it.name) },
                    modifier = Modifier.weight(1f)
                )
                PowerMenuButton(
                    selected = profile.rfPower,
                    onSelected = { onFieldChanged(ComjotField.RF_POWER, it.name) },
                    modifier = Modifier.weight(1f)
                )
            }

            ComjotMode.DMR -> {
                DmrMenuButton(
                    state = state,
                    provider = provider,
                    onFieldChanged = onFieldChanged,
                    onProviderFieldChanged = onProviderFieldChanged,
                    modifier = Modifier.weight(1f)
                )
                BandwidthMenuButton(
                    selected = profile.bandwidth,
                    onSelected = { onFieldChanged(ComjotField.BANDWIDTH, it.name) },
                    modifier = Modifier.weight(1f)
                )
                PowerMenuButton(
                    selected = profile.rfPower,
                    onSelected = { onFieldChanged(ComjotField.RF_POWER, it.name) },
                    modifier = Modifier.weight(1f)
                )
            }

            ComjotMode.ROIP -> Unit
        }
    }
}

@Composable
private fun DtmfMenuButton(
    onSend: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    var command by remember { mutableStateOf("") }
    Box(modifier = modifier) {
        OutlinedButton(
            onClick = { expanded = true },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text("DTMF")
        }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            Column(
                modifier = Modifier
                    .widthIn(min = 280.dp, max = 340.dp)
                    .padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                LabeledInput(
                    label = "Command",
                    value = command,
                    onValueChange = { value ->
                        command = value.filter { it.isDigit() || it in "*#ABCDabcd" }.uppercase()
                    }
                )
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    listOf("*3", "*1", "*70").forEach { preset ->
                        OutlinedButton(
                            onClick = { command = preset },
                            modifier = Modifier.weight(1f),
                            contentPadding = PaddingValues(horizontal = 6.dp, vertical = 8.dp)
                        ) {
                            Text(preset)
                        }
                    }
                }
                Button(
                    onClick = {
                        onSend(command)
                        expanded = false
                    },
                    enabled = command.isNotBlank(),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Send")
                }
            }
        }
    }
}

@Composable
private fun HotspotRfMenuButton(
    state: AppUiState,
    provider: ProviderProfile?,
    onFieldChanged: (ComjotField, String) -> Unit,
    onProviderFieldChanged: (String, ProviderField, String) -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    val profile = state.comjot.profile
    val isAllStar = provider?.type?.providerId == ALLSTAR_PROVIDER_ID
    Box(modifier = modifier) {
        OutlinedButton(
            onClick = { expanded = true },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text("RF Setup", maxLines = 1, overflow = TextOverflow.Ellipsis)
        }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            Column(
                modifier = Modifier
                    .widthIn(min = 300.dp, max = 360.dp)
                    .padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    Box(modifier = Modifier.weight(1f)) {
                        LabeledInput(
                            label = "RX MHz",
                            value = profile.rxFrequency,
                            onValueChange = { onFieldChanged(ComjotField.RX_FREQUENCY, it) },
                            keyboardType = KeyboardType.Decimal
                        )
                    }
                    Box(modifier = Modifier.weight(1f)) {
                        LabeledInput(
                            label = "TX MHz",
                            value = profile.txFrequency,
                            onValueChange = { onFieldChanged(ComjotField.TX_FREQUENCY, it) },
                            keyboardType = KeyboardType.Decimal
                        )
                    }
                }

                if (isAllStar) {
                    ToneSettings(
                        rxToneMode = profile.rxToneMode,
                        rxToneCode = profile.rxToneCode,
                        txToneMode = profile.txToneMode,
                        txToneCode = profile.txToneCode,
                        txEnabled = true,
                        onFieldChanged = onFieldChanged
                    )
                } else {
                    Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        Box(modifier = Modifier.weight(1f)) {
                            LabeledInput(
                                label = "Color",
                                value = profile.colorCode,
                                onValueChange = { onFieldChanged(ComjotField.COLOR_CODE, it) },
                                keyboardType = KeyboardType.Number
                            )
                        }
                        Box(modifier = Modifier.weight(1f)) {
                            LabeledInput(
                                label = "Slot",
                                value = provider?.timeSlot ?: profile.timeSlot,
                                onValueChange = {
                                    if (provider != null) {
                                        onProviderFieldChanged(provider.type.providerId, ProviderField.TIME_SLOT, it)
                                    } else {
                                        onFieldChanged(ComjotField.TIME_SLOT, it)
                                    }
                                },
                                keyboardType = KeyboardType.Number
                            )
                        }
                    }
                }
                PowerMenuButton(
                    selected = profile.rfPower,
                    onSelected = { onFieldChanged(ComjotField.RF_POWER, it.name) }
                )
            }
        }
    }
}

@Composable
private fun RoipProviderButton(
    providers: List<ProviderProfile>,
    selectedProvider: ProviderProfile?,
    onSelected: (ProviderProfile) -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    Box(modifier = modifier) {
        OutlinedButton(
            onClick = { expanded = true },
            enabled = providers.isNotEmpty(),
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp)
        ) {
            Text(
                text = selectedProvider?.type?.title ?: "Provider",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            providers.forEach { profile ->
                DropdownMenuItem(
                    text = {
                        Column {
                            Text(profile.type.title, fontWeight = FontWeight.SemiBold)
                            Text(
                                text = profile.providerSubtitle(),
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    },
                    onClick = {
                        onSelected(profile)
                        expanded = false
                    }
                )
            }
        }
    }
}

@Composable
private fun ToneMenuButton(
    profile: com.roip.mobile.data.ComjotProfile,
    txEnabled: Boolean,
    onFieldChanged: (ComjotField, String) -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    Box(modifier = modifier) {
        OutlinedButton(
            onClick = { expanded = true },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text("Tone")
        }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            Column(
                modifier = Modifier
                    .widthIn(min = 280.dp, max = 340.dp)
                    .padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                ToneSettings(
                    rxToneMode = profile.rxToneMode,
                    rxToneCode = profile.rxToneCode,
                    txToneMode = profile.txToneMode,
                    txToneCode = profile.txToneCode,
                    txEnabled = txEnabled,
                    onFieldChanged = onFieldChanged
                )
            }
        }
    }
}

@Composable
private fun DmrMenuButton(
    state: AppUiState,
    provider: ProviderProfile?,
    onFieldChanged: (ComjotField, String) -> Unit,
    onProviderFieldChanged: (String, ProviderField, String) -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    val profile = state.comjot.profile
    val roipMode = profile.mode == ComjotMode.ROIP
    val allStarMode = roipMode && provider?.type?.providerId == ALLSTAR_PROVIDER_ID
    Box(modifier = modifier) {
        OutlinedButton(
            onClick = { expanded = true },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = when {
                    allStarMode -> "Nodes"
                    roipMode -> "Talkgroup"
                    else -> "CC / Slot"
                },
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            Column(
                modifier = Modifier
                    .widthIn(min = 280.dp, max = 340.dp)
                    .padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                LabeledInput(
                    label = if (allStarMode) "Local Node" else "Talkgroup",
                    value = when {
                        allStarMode -> provider?.stationId.orEmpty()
                        roipMode -> provider?.target ?: profile.talkgroup
                        else -> profile.talkgroup
                    },
                    onValueChange = {
                        if (allStarMode && provider != null) {
                            onProviderFieldChanged(provider.type.providerId, ProviderField.STATION_ID, it)
                        } else if (roipMode && provider != null) {
                            onProviderFieldChanged(provider.type.providerId, ProviderField.TARGET, it)
                        } else {
                            onFieldChanged(ComjotField.TALKGROUP, it)
                        }
                    },
                    keyboardType = KeyboardType.Number
                )
                if (allStarMode && provider != null) {
                    LabeledInput(
                        label = "Remote Node",
                        value = provider.target,
                        onValueChange = {
                            onProviderFieldChanged(provider.type.providerId, ProviderField.TARGET, it)
                        },
                        keyboardType = KeyboardType.Number
                    )
                } else if (!roipMode) {
                    Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        Box(modifier = Modifier.weight(1f)) {
                            LabeledInput(
                                label = "Color",
                                value = profile.colorCode,
                                onValueChange = { onFieldChanged(ComjotField.COLOR_CODE, it) },
                                keyboardType = KeyboardType.Number
                            )
                        }
                        Box(modifier = Modifier.weight(1f)) {
                            LabeledInput(
                                label = "Slot",
                                value = profile.timeSlot,
                                onValueChange = { onFieldChanged(ComjotField.TIME_SLOT, it) },
                                keyboardType = KeyboardType.Number
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun BandwidthMenuButton(
    selected: ComjotBandwidth,
    onSelected: (ComjotBandwidth) -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    Box(modifier = modifier) {
        OutlinedButton(
            onClick = { expanded = true },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(selected.title)
        }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            ComjotBandwidth.entries.forEach { bandwidth ->
                DropdownMenuItem(
                    text = { Text(bandwidth.title) },
                    onClick = {
                        onSelected(bandwidth)
                        expanded = false
                    }
                )
            }
        }
    }
}

@Composable
private fun PowerMenuButton(
    selected: ComjotRfPower,
    onSelected: (ComjotRfPower) -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    Box(modifier = modifier) {
        OutlinedButton(
            onClick = { expanded = true },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text("Power ${selected.title}")
        }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            ComjotRfPower.entries.forEach { power ->
                DropdownMenuItem(
                    text = { Text(power.title) },
                    onClick = {
                        onSelected(power)
                        expanded = false
                    }
                )
            }
        }
    }
}

@Composable
private fun RoipOperationModeButton(
    selected: RoipOperationMode,
    onSelected: (RoipOperationMode) -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    Box(modifier = modifier) {
        OutlinedButton(
            onClick = { expanded = true },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = when (selected) {
                    RoipOperationMode.DIRECT -> "Direct"
                    RoipOperationMode.HOTSPOT -> "Hotspot"
                },
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            RoipOperationMode.entries.forEach { mode ->
                DropdownMenuItem(
                    text = { Text(mode.title) },
                    onClick = {
                        onSelected(mode)
                        expanded = false
                    }
                )
            }
        }
    }
}

@Composable
private fun FrequencySection(
    state: ComjotUiState,
    txEnabled: Boolean,
    onFieldChanged: (ComjotField, String) -> Unit
) {
    val profile = state.profile
    if (txEnabled) {
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            Box(modifier = Modifier.weight(1f)) {
                LabeledInput(
                    label = "RX MHz",
                    value = profile.rxFrequency,
                    onValueChange = { onFieldChanged(ComjotField.RX_FREQUENCY, it) },
                    keyboardType = KeyboardType.Decimal
                )
            }
            Box(modifier = Modifier.weight(1f)) {
                LabeledInput(
                    label = "TX MHz",
                    value = profile.txFrequency,
                    onValueChange = { onFieldChanged(ComjotField.TX_FREQUENCY, it) },
                    keyboardType = KeyboardType.Decimal
                )
            }
        }
    } else {
        LabeledInput(
            label = "RX MHz",
            value = profile.rxFrequency,
            onValueChange = { onFieldChanged(ComjotField.RX_FREQUENCY, it) },
            keyboardType = KeyboardType.Decimal
        )
    }
}

@Composable
private fun DmrSection(
    state: ComjotUiState,
    onFieldChanged: (ComjotField, String) -> Unit
) {
    val profile = state.profile
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            Box(modifier = Modifier.weight(1f)) {
                LabeledInput(
                    label = "DMR ID",
                    value = profile.localId,
                    onValueChange = { onFieldChanged(ComjotField.LOCAL_ID, it) },
                    keyboardType = KeyboardType.Number
                )
            }
            Box(modifier = Modifier.weight(1f)) {
                LabeledInput(
                    label = "Talkgroup",
                    value = profile.talkgroup,
                    onValueChange = { onFieldChanged(ComjotField.TALKGROUP, it) },
                    keyboardType = KeyboardType.Number
                )
            }
        }
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            Box(modifier = Modifier.weight(1f)) {
                LabeledInput(
                    label = "Color",
                    value = profile.colorCode,
                    onValueChange = { onFieldChanged(ComjotField.COLOR_CODE, it) },
                    keyboardType = KeyboardType.Number
                )
            }
            Box(modifier = Modifier.weight(1f)) {
                LabeledInput(
                    label = "Slot",
                    value = profile.timeSlot,
                    onValueChange = { onFieldChanged(ComjotField.TIME_SLOT, it) },
                    keyboardType = KeyboardType.Number
                )
            }
        }
        PowerSelector(
            selectedPower = profile.rfPower,
            onPowerSelected = { onFieldChanged(ComjotField.RF_POWER, it.name) }
        )
    }
}

@Composable
private fun AnalogSection(
    state: ComjotUiState,
    txEnabled: Boolean,
    onFieldChanged: (ComjotField, String) -> Unit
) {
    val profile = state.profile
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        if (profile.mode == ComjotMode.SCANNER) {
            ScannerWaveform(
                active = state.isProgrammed,
                developerMode = state.developerMode,
                centerFrequency = profile.rxFrequency,
                onTune = { onFieldChanged(ComjotField.RX_FREQUENCY, it) }
            )
        }
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            Box(modifier = Modifier.weight(1f)) {
                SelectorRow(
                    label = "Bandwidth",
                    options = ComjotBandwidth.entries,
                    selected = profile.bandwidth,
                    title = { it.title },
                    onSelected = { onFieldChanged(ComjotField.BANDWIDTH, it.name) }
                )
            }
            Box(modifier = Modifier.weight(1f)) {
                LabeledInput(
                    label = "Squelch",
                    value = profile.squelch,
                    onValueChange = { onFieldChanged(ComjotField.SQUELCH, it) },
                    keyboardType = KeyboardType.Number
                )
            }
        }
        if (txEnabled) {
            PowerSelector(
                selectedPower = profile.rfPower,
                onPowerSelected = { onFieldChanged(ComjotField.RF_POWER, it.name) }
            )
        }
        ToneSettings(
            rxToneMode = profile.rxToneMode,
            rxToneCode = profile.rxToneCode,
            txToneMode = profile.txToneMode,
            txToneCode = profile.txToneCode,
            txEnabled = txEnabled,
            onFieldChanged = onFieldChanged
        )
    }
}

@Composable
private fun ScannerWaveform(
    active: Boolean,
    developerMode: Boolean,
    centerFrequency: String,
    onTune: (String) -> Unit
) {
    val transition = rememberInfiniteTransition(label = "scannerWaveform")
    val phase by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 620, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "scannerWaveformPhase"
    )
    val centerMhz = centerFrequency.toDoubleOrNull() ?: 146.5200
    val spanMhz = if (developerMode) 2.4 else 1.0
    val startMhz = centerMhz - spanMhz / 2.0
    val endMhz = centerMhz + spanMhz / 2.0
    val signals = remember(centerMhz, developerMode) {
        scannerSignals(centerMhz, spanMhz, developerMode)
    }
    val strongest = signals.maxByOrNull { it.strength }
    val waveColor = if (developerMode) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.primary
    val gridColor = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.18f)
    val centerColor = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.34f)
    val hotColor = MaterialTheme.colorScheme.secondary
    val floorColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.12f)

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = if (developerMode) "Pocket SDR" else "Scanner Spectrum",
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = "${formatScannerFrequency(startMhz)} - ${formatScannerFrequency(endMhz)} MHz",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            StatusPill(if (active) "RX" else "Standby")
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(148.dp)
                .background(
                    color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.42f),
                    shape = RoundedCornerShape(10.dp)
                )
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.outline.copy(alpha = 0.35f),
                    shape = RoundedCornerShape(10.dp)
                )
                .pointerInput(centerMhz, spanMhz) {
                    detectTapGestures { offset ->
                        val width = size.width.coerceAtLeast(1)
                        val tuned = startMhz + spanMhz * (offset.x / width.toDouble())
                        onTune(formatScannerFrequency(tuned))
                    }
                }
                .padding(10.dp)
        ) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                val spectrumHeight = size.height * 0.70f
                val waterfallTop = spectrumHeight + 8.dp.toPx()
                val waterfallHeight = size.height - waterfallTop
                val bins = 96
                val binWidth = size.width / bins

                for (line in 1..3) {
                    val y = spectrumHeight * line / 4f
                    drawLine(
                        color = gridColor,
                        start = Offset(0f, y),
                        end = Offset(size.width, y),
                        strokeWidth = 1.dp.toPx()
                    )
                }

                drawLine(
                    color = centerColor,
                    start = Offset(size.width / 2f, 0f),
                    end = Offset(size.width / 2f, spectrumHeight),
                    strokeWidth = 1.5.dp.toPx()
                )

                val path = Path()
                for (sample in 0..bins) {
                    val progress = sample / bins.toFloat()
                    val x = size.width * progress
                    val mhz = startMhz + spanMhz * progress
                    val strength = scannerPowerAt(
                        mhz = mhz,
                        startMhz = startMhz,
                        spanMhz = spanMhz,
                        phase = phase,
                        active = active,
                        signals = signals
                    )
                    val y = spectrumHeight - (spectrumHeight * strength.coerceIn(0f, 1f))
                    if (sample == 0) {
                        path.moveTo(x, y)
                    } else {
                        path.lineTo(x, y)
                    }
                }

                drawRect(
                    color = floorColor,
                    topLeft = Offset(0f, 0f),
                    size = androidx.compose.ui.geometry.Size(size.width, spectrumHeight)
                )

                drawPath(
                    path = path,
                    color = waveColor,
                    style = Stroke(
                        width = 2.5.dp.toPx(),
                        cap = StrokeCap.Round
                    )
                )

                signals.forEach { signal ->
                    val x = ((signal.frequencyMhz - startMhz) / spanMhz).toFloat() * size.width
                    val peakHeight = spectrumHeight * signal.strength.coerceIn(0.18f, 0.95f)
                    drawLine(
                        color = hotColor.copy(alpha = 0.72f),
                        start = Offset(x, spectrumHeight),
                        end = Offset(x, spectrumHeight - peakHeight),
                        strokeWidth = 1.5.dp.toPx()
                    )
                    drawCircle(
                        color = hotColor,
                        radius = 4.dp.toPx(),
                        center = Offset(x, spectrumHeight - peakHeight)
                    )
                }

                val rows = 9
                val rowHeight = waterfallHeight / rows.coerceAtLeast(1)
                for (row in 0 until rows) {
                    val rowPhase = (phase + row * 0.085f) % 1f
                    for (bin in 0 until bins) {
                        val progress = (bin + 0.5f) / bins
                        val mhz = startMhz + spanMhz * progress
                        val strength = scannerPowerAt(
                            mhz = mhz,
                            startMhz = startMhz,
                            spanMhz = spanMhz,
                            phase = rowPhase,
                            active = active,
                            signals = signals
                        )
                        val color = if (strength > 0.55f) {
                            hotColor.copy(alpha = 0.22f + strength * 0.58f)
                        } else {
                            waveColor.copy(alpha = 0.05f + strength * 0.20f)
                        }
                        drawRect(
                            color = color,
                            topLeft = Offset(bin * binWidth, waterfallTop + row * rowHeight),
                            size = androidx.compose.ui.geometry.Size(binWidth + 1f, rowHeight + 1f)
                        )
                    }
                }
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Tap a peak to tune",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Text(
                text = strongest?.let { "Hot ${formatScannerFrequency(it.frequencyMhz)}" } ?: "No peaks",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
private fun RoipModeSection(
    providers: List<ProviderProfile>,
    activeSession: SessionSnapshot?,
    isBusy: Boolean,
    onProviderFieldChanged: (String, ProviderField, String) -> Unit,
    onConnect: (String) -> Unit,
    onScanBrandmeisterQr: (String) -> Unit,
    onRelayPtt: () -> Unit,
    onDisconnect: () -> Unit
) {
    if (activeSession != null) {
        SessionPanel(
            session = activeSession,
            isBusy = isBusy,
            onTogglePtt = onRelayPtt,
            onDisconnect = onDisconnect
        )
        return
    }

    if (providers.isEmpty()) {
        Text(
            text = "No ROIP providers configured",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        return
    }

    val providerIds = providers.map { it.type.providerId }
    var selectedProviderId by remember(providerIds) {
        mutableStateOf(providerIds.first())
    }
    val effectiveProviderId = if (selectedProviderId in providerIds) {
        selectedProviderId
    } else {
        providerIds.first()
    }
    val selectedProvider = providers.first { it.type.providerId == effectiveProviderId }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        SelectorRow(
            label = "ROIP provider",
            options = providerIds,
            selected = effectiveProviderId,
            title = { providerId -> providers.first { it.type.providerId == providerId }.type.title },
            onSelected = { selectedProviderId = it }
        )

        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            Box(modifier = Modifier.weight(1f)) {
                LabeledInput(
                    label = "Callsign",
                    value = selectedProvider.callsign,
                    onValueChange = {
                        onProviderFieldChanged(effectiveProviderId, ProviderField.CALLSIGN, it)
                    }
                )
            }
            Box(modifier = Modifier.weight(1f)) {
                LabeledInput(
                    label = selectedProvider.type.stationIdLabel,
                    value = selectedProvider.stationId,
                    onValueChange = {
                        onProviderFieldChanged(effectiveProviderId, ProviderField.STATION_ID, it)
                    },
                    keyboardType = KeyboardType.Number
                )
            }
        }

        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            Box(modifier = Modifier.weight(0.7f)) {
                LabeledInput(
                    label = selectedProvider.type.targetLabel,
                    value = selectedProvider.target,
                    onValueChange = {
                        onProviderFieldChanged(effectiveProviderId, ProviderField.TARGET, it)
                    },
                    keyboardType = KeyboardType.Number
                )
            }
            Box(modifier = Modifier.weight(0.3f)) {
                LabeledInput(
                    label = "ROIP Slot",
                    value = selectedProvider.timeSlot,
                    onValueChange = {
                        onProviderFieldChanged(effectiveProviderId, ProviderField.TIME_SLOT, it)
                    },
                    keyboardType = KeyboardType.Number
                )
            }
        }

        LabeledInput(
            label = "Server",
            value = selectedProvider.serverHost,
            onValueChange = {
                onProviderFieldChanged(effectiveProviderId, ProviderField.SERVER_HOST, it)
            }
        )

        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            Box(modifier = Modifier.weight(0.35f)) {
                LabeledInput(
                    label = "Port",
                    value = selectedProvider.serverPort,
                    onValueChange = {
                        onProviderFieldChanged(effectiveProviderId, ProviderField.SERVER_PORT, it)
                    },
                    keyboardType = KeyboardType.Number
                )
            }
            Box(modifier = Modifier.weight(0.65f)) {
                LabeledInput(
                    label = "Password",
                    value = selectedProvider.password,
                    onValueChange = {
                        onProviderFieldChanged(effectiveProviderId, ProviderField.PASSWORD, it)
                    },
                    password = true
                )
            }
        }

        if (selectedProvider.type.providerId == "brandmeister") {
            BrandmeisterApiKeyInput(
                value = selectedProvider.apiKey,
                onValueChange = {
                    onProviderFieldChanged(effectiveProviderId, ProviderField.API_KEY, it)
                },
                onScanQr = { onScanBrandmeisterQr(effectiveProviderId) }
            )
        }

        Button(
            onClick = { onConnect(effectiveProviderId) },
            enabled = !isBusy,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(if (isBusy) "Connecting" else "Connect ${selectedProvider.type.title}")
        }
    }
}

@Composable
private fun MemoryPanel(
    state: AppUiState,
    onSaveMemory: (String, MemoryType) -> Unit,
    onRecallMemory: (String) -> Unit,
    onDeleteMemory: (String) -> Unit
) {
    var memoryName by remember { mutableStateOf("") }
    var selectedType by remember(state.comjot.profile.mode) {
        mutableStateOf(defaultMemoryType(state.comjot.profile.mode))
    }
    val sortedMemories = remember(state.memories) {
        state.memories.sortedWith(compareBy<RadioMemory> { it.type.ordinal }.thenBy { it.name.lowercase() })
    }

    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Memories",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = "${state.memories.size} saved",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                StatusPill(modeTitle(state.comjot.profile.mode, state.comjot.developerMode))
            }

            SelectorRow(
                label = "Store",
                options = MemoryType.entries,
                selected = selectedType,
                title = { it.title },
                onSelected = { selectedType = it }
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(modifier = Modifier.weight(1f)) {
                    LabeledInput(
                        label = "Memory name",
                        value = memoryName,
                        onValueChange = { memoryName = it }
                    )
                }
                Button(
                    onClick = {
                        onSaveMemory(memoryName, selectedType)
                        memoryName = ""
                    },
                    modifier = Modifier.height(56.dp)
                ) {
                    Text("Save")
                }
            }

            if (sortedMemories.isEmpty()) {
                Text(
                    text = "No saved memories",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            } else {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    sortedMemories.forEach { memory ->
                        MemoryRow(
                            memory = memory,
                            onRecall = { onRecallMemory(memory.id) },
                            onDelete = { onDeleteMemory(memory.id) }
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun MemoryRow(
    memory: RadioMemory,
    onRecall: () -> Unit,
    onDelete: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.34f),
                shape = RoundedCornerShape(10.dp)
            )
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.outline.copy(alpha = 0.28f),
                shape = RoundedCornerShape(10.dp)
            )
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        StatusPill(memory.type.title)
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = memory.name,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.SemiBold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = memory.subtitle(),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        TextButton(onClick = onRecall) {
            Text("Call")
        }
        TextButton(onClick = onDelete) {
            Text("Delete")
        }
    }
}

@Composable
private fun HoldToTalkButton(
    enabled: Boolean,
    active: Boolean,
    busy: Boolean,
    disabledText: String = "Program first",
    onStart: () -> Unit,
    onEnd: () -> Unit,
    onAudioPermissionDenied: () -> Unit
) {
    val context = LocalContext.current
    val currentOnStart by rememberUpdatedState(onStart)
    val currentOnEnd by rememberUpdatedState(onEnd)
    val currentOnAudioPermissionDenied by rememberUpdatedState(onAudioPermissionDenied)
    val audioPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { granted ->
        if (!granted) {
            currentOnAudioPermissionDenied()
        }
    }
    val buttonColor = when {
        active -> MaterialTheme.colorScheme.error
        enabled -> MaterialTheme.colorScheme.primary
        else -> MaterialTheme.colorScheme.surfaceVariant
    }
    val textColor = when {
        active -> MaterialTheme.colorScheme.onError
        enabled -> MaterialTheme.colorScheme.onPrimary
        else -> MaterialTheme.colorScheme.onSurfaceVariant
    }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(92.dp)
            .pointerInput(enabled) {
                awaitEachGesture {
                    awaitFirstDown()
                    if (!enabled) {
                        waitForUpOrCancellation()
                        return@awaitEachGesture
                    }
                    if (context.checkSelfPermission(Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
                        audioPermissionLauncher.launch(Manifest.permission.RECORD_AUDIO)
                        waitForUpOrCancellation()
                        return@awaitEachGesture
                    }
                    var started = false
                    try {
                        currentOnStart()
                        started = true
                        waitForUpOrCancellation()
                    } finally {
                        if (started) {
                            currentOnEnd()
                        }
                    }
                }
            },
        color = buttonColor,
        contentColor = textColor,
        shape = RoundedCornerShape(12.dp)
    ) {
        Box(contentAlignment = Alignment.Center) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = when {
                        active -> "ON AIR"
                        busy -> "COMMANDING"
                        else -> "HOLD TO TALK"
                    },
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = if (enabled) "Press and hold" else disabledText,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Composable
private fun SettingsPanel(
    state: AppUiState,
    onComjotFieldChanged: (ComjotField, String) -> Unit,
    onHotspotFieldChanged: (HotspotField, String) -> Unit,
    onUseDeviceLocation: () -> Unit,
    onKnobControlChanged: (String) -> Unit,
    onAccentColorChanged: (String) -> Unit,
    onProviderFieldChanged: (String, ProviderField, String) -> Unit,
    onScanBrandmeisterQr: (String) -> Unit,
    onVersionTapped: () -> Unit
) {
    val comjot = state.comjot
    val profile = comjot.profile
    val hotspot = state.hotspot

    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.45f))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(text = "Radio", style = MaterialTheme.typography.titleMedium)
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Box(modifier = Modifier.weight(1f)) {
                    LabeledInput(
                        label = "Serial baud",
                        value = profile.baudRate,
                        onValueChange = { onComjotFieldChanged(ComjotField.BAUD_RATE, it) },
                        keyboardType = KeyboardType.Number
                    )
                }
                Box(modifier = Modifier.weight(1f)) {
                    LabeledInput(
                        label = "DMR ID",
                        value = profile.localId,
                        onValueChange = { onComjotFieldChanged(ComjotField.LOCAL_ID, it) },
                        keyboardType = KeyboardType.Number
                    )
                }
            }
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Box(modifier = Modifier.weight(1f)) {
                    LabeledInput(
                        label = "Mic gain",
                        value = profile.micGain,
                        onValueChange = { onComjotFieldChanged(ComjotField.MIC_GAIN, it) },
                        keyboardType = KeyboardType.Number
                    )
                }
                Box(modifier = Modifier.weight(1f)) {
                    LabeledInput(
                        label = "Radio volume",
                        value = profile.volume,
                        onValueChange = { onComjotFieldChanged(ComjotField.VOLUME, it) },
                        keyboardType = KeyboardType.Number
                    )
                }
            }
            ToggleRow(
                label = "Repeater decoupling",
                checked = profile.repeaterDecoupling,
                onCheckedChanged = { onComjotFieldChanged(ComjotField.REPEATER_DECOUPLING, it.toString()) }
            )
            SelectorRow(
                label = "Knob",
                options = KnobControlMode.entries,
                selected = state.knobControlMode,
                title = { it.title },
                onSelected = { onKnobControlChanged(it.name) }
            )
            AccentColorPicker(
                selected = state.accentColor,
                onSelected = { onAccentColorChanged(it.name) }
            )
            comjot.lastPacketHex?.let { packet ->
                DetailRow("Packet", if (packet.length > 28) "${packet.take(28)}..." else packet)
            }

            HorizontalDivider()
            Text(text = "ROIP Providers", style = MaterialTheme.typography.titleMedium)
            state.providers.forEach { profileState ->
                ProviderSettings(
                    profile = profileState,
                    onFieldChanged = { field, value ->
                        onProviderFieldChanged(profileState.type.providerId, field, value)
                    },
                    onScanQr = { onScanBrandmeisterQr(profileState.type.providerId) }
                )
            }

            HorizontalDivider()
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Hotspot Profile", style = MaterialTheme.typography.titleMedium)
                OutlinedButton(onClick = onUseDeviceLocation) {
                    Text("Use GPS")
                }
            }
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Box(modifier = Modifier.weight(1f)) {
                    LabeledInput(
                        label = "Latitude",
                        value = hotspot.latitude,
                        onValueChange = { onHotspotFieldChanged(HotspotField.LATITUDE, it) },
                        keyboardType = KeyboardType.Decimal
                    )
                }
                Box(modifier = Modifier.weight(1f)) {
                    LabeledInput(
                        label = "Longitude",
                        value = hotspot.longitude,
                        onValueChange = { onHotspotFieldChanged(HotspotField.LONGITUDE, it) },
                        keyboardType = KeyboardType.Decimal
                    )
                }
            }
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Box(modifier = Modifier.weight(1f)) {
                    LabeledInput(
                        label = "Height",
                        value = hotspot.height,
                        onValueChange = { onHotspotFieldChanged(HotspotField.HEIGHT, it) },
                        keyboardType = KeyboardType.Number
                    )
                }
                Box(modifier = Modifier.weight(1f)) {
                    LabeledInput(
                        label = "Slot flags",
                        value = hotspot.slotFlags,
                        onValueChange = { onHotspotFieldChanged(HotspotField.SLOT_FLAGS, it) },
                        keyboardType = KeyboardType.Number
                    )
                }
            }
            LabeledInput(
                label = "Location",
                value = hotspot.location,
                onValueChange = { onHotspotFieldChanged(HotspotField.LOCATION, it) }
            )
            LabeledInput(
                label = "Description",
                value = hotspot.description,
                onValueChange = { onHotspotFieldChanged(HotspotField.DESCRIPTION, it) }
            )
            LabeledInput(
                label = "URL",
                value = hotspot.url,
                onValueChange = { onHotspotFieldChanged(HotspotField.URL, it) }
            )
            LabeledInput(
                label = "Software ID",
                value = hotspot.software,
                onValueChange = { onHotspotFieldChanged(HotspotField.SOFTWARE, it) }
            )
            LabeledInput(
                label = "Package ID",
                value = hotspot.packageId,
                onValueChange = { onHotspotFieldChanged(HotspotField.PACKAGE_ID, it) }
            )

            HorizontalDivider()
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(text = "Developer mode", style = MaterialTheme.typography.titleMedium)
                    Text(
                        text = if (comjot.developerMode) "Enabled" else "Disabled",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                VersionBadge(onVersionTapped)
            }
        }
    }
}

@Composable
private fun ProviderSettings(
    profile: ProviderProfile,
    onFieldChanged: (ProviderField, String) -> Unit,
    onScanQr: () -> Unit
) {
    var expanded by remember(profile.type.providerId) { mutableStateOf(false) }
    val isAllStar = profile.type.providerId == ALLSTAR_PROVIDER_ID
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = !expanded }
                .padding(vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(text = profile.type.title, style = MaterialTheme.typography.titleSmall)
                Text(
                    text = profile.serverHost,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            TextButton(onClick = { expanded = !expanded }) {
                Text(if (expanded) "Hide" else "Edit")
            }
        }
        if (expanded) {
            if (isAllStar) {
                LabeledInput(
                    label = "IAX username",
                    value = profile.username,
                    onValueChange = { onFieldChanged(ProviderField.USERNAME, it) }
                )
            }
            LabeledInput(
                label = "Callsign",
                value = profile.callsign,
                onValueChange = { onFieldChanged(ProviderField.CALLSIGN, it) }
            )
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Box(modifier = Modifier.weight(1f)) {
                    LabeledInput(
                        label = profile.type.stationIdLabel,
                        value = profile.stationId,
                        onValueChange = { onFieldChanged(ProviderField.STATION_ID, it) },
                        keyboardType = KeyboardType.Number
                    )
                }
                Box(modifier = Modifier.weight(1f)) {
                    LabeledInput(
                        label = profile.type.targetLabel,
                        value = profile.target,
                        onValueChange = { onFieldChanged(ProviderField.TARGET, it) },
                        keyboardType = KeyboardType.Number
                    )
                }
            }
            LabeledInput(
                label = if (isAllStar) "IAX context" else "ROIP Slot",
                value = profile.timeSlot,
                onValueChange = { onFieldChanged(ProviderField.TIME_SLOT, it) },
                keyboardType = if (isAllStar) KeyboardType.Text else KeyboardType.Number
            )
            LabeledInput(
                label = "Server",
                value = profile.serverHost,
                onValueChange = { onFieldChanged(ProviderField.SERVER_HOST, it) }
            )
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Box(modifier = Modifier.weight(0.35f)) {
                    LabeledInput(
                        label = "Port",
                        value = profile.serverPort,
                        onValueChange = { onFieldChanged(ProviderField.SERVER_PORT, it) },
                        keyboardType = KeyboardType.Number
                    )
                }
                Box(modifier = Modifier.weight(0.65f)) {
                    LabeledInput(
                        label = "Password",
                        value = profile.password,
                        onValueChange = { onFieldChanged(ProviderField.PASSWORD, it) },
                        password = true
                    )
                }
            }
            if (profile.type.providerId == "brandmeister") {
                BrandmeisterApiKeyInput(
                    value = profile.apiKey,
                    onValueChange = { onFieldChanged(ProviderField.API_KEY, it) },
                    onScanQr = onScanQr
                )
            }
        }
    }
}

@Composable
private fun AccentColorPicker(
    selected: AccentColor,
    onSelected: (AccentColor) -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(
            text = "Accent color",
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        AccentColor.entries.chunked(3).forEach { accentRow ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                accentRow.forEach { accent ->
                    val selectedColor = Color(accent.lightPrimary)
                    OutlinedButton(
                        onClick = { onSelected(accent) },
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(8.dp),
                        contentPadding = PaddingValues(horizontal = 6.dp, vertical = 8.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(14.dp)
                                    .background(selectedColor, CircleShape)
                                    .border(
                                        width = if (selected == accent) 2.dp else 1.dp,
                                        color = if (selected == accent) MaterialTheme.colorScheme.onSurface else MaterialTheme.colorScheme.outline,
                                        shape = CircleShape
                                    )
                            )
                            Text(
                                text = accent.title,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }
                }
                repeat(3 - accentRow.size) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}

@Composable
private fun BrandmeisterApiKeyInput(
    value: String,
    onValueChange: (String) -> Unit,
    onScanQr: () -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        LabeledInput(
            label = "BM API Key",
            value = value,
            onValueChange = onValueChange,
            password = true
        )
        OutlinedButton(
            onClick = onScanQr,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Scan QR")
        }
    }
}

@Composable
private fun VersionBadge(onVersionTapped: () -> Unit) {
    Box(
        modifier = Modifier
            .border(1.dp, MaterialTheme.colorScheme.outline, CircleShape)
            .clickable(onClick = onVersionTapped)
            .padding(horizontal = 12.dp, vertical = 8.dp)
    ) {
        Text(
            text = "v${BuildConfig.VERSION_NAME}",
            style = MaterialTheme.typography.labelLarge
        )
    }
}

@Composable
private fun ModeSelector(
    selectedMode: ComjotMode,
    developerMode: Boolean,
    onModeSelected: (ComjotMode) -> Unit
) {
    SelectorRow(
        label = "Mode",
        options = ComjotMode.entries,
        selected = selectedMode,
        title = { modeTitle(it, developerMode) },
        onSelected = onModeSelected
    )
}

@Composable
private fun PowerSelector(
    selectedPower: ComjotRfPower,
    onPowerSelected: (ComjotRfPower) -> Unit
) {
    SelectorRow(
        label = "RF power",
        options = ComjotRfPower.entries,
        selected = selectedPower,
        title = { it.title },
        onSelected = onPowerSelected
    )
}

@Composable
private fun ToneSettings(
    rxToneMode: ComjotToneMode,
    rxToneCode: String,
    txToneMode: ComjotToneMode,
    txToneCode: String,
    txEnabled: Boolean,
    onFieldChanged: (ComjotField, String) -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(
            text = "PL / DCS",
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        ToneRow(
            label = "RX",
            selectedMode = rxToneMode,
            selectedCode = rxToneCode,
            onModeSelected = { mode -> onFieldChanged(ComjotField.RX_TONE_MODE, mode.name) },
            onCodeSelected = { code -> onFieldChanged(ComjotField.RX_TONE_CODE, code) }
        )
        if (txEnabled) {
            ToneRow(
                label = "TX",
                selectedMode = txToneMode,
                selectedCode = txToneCode,
                onModeSelected = { mode -> onFieldChanged(ComjotField.TX_TONE_MODE, mode.name) },
                onCodeSelected = { code -> onFieldChanged(ComjotField.TX_TONE_CODE, code) }
            )
        }
    }
}

@Composable
private fun ToneRow(
    label: String,
    selectedMode: ComjotToneMode,
    selectedCode: String,
    onModeSelected: (ComjotToneMode) -> Unit,
    onCodeSelected: (String) -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
        SelectorRow(
            label = "$label tone",
            options = ComjotToneMode.entries,
            selected = selectedMode,
            title = { it.title },
            onSelected = onModeSelected
        )
        ToneCodeSelector(
            label = when (selectedMode) {
                ComjotToneMode.CTCSS -> "$label PL"
                ComjotToneMode.DCS,
                ComjotToneMode.REVERSE_DCS -> "$label DCS"
                ComjotToneMode.OFF -> "$label tone"
            },
            selectedMode = selectedMode,
            selectedCode = selectedCode,
            onCodeSelected = onCodeSelected
        )
    }
}

@Composable
private fun ToneCodeSelector(
    label: String,
    selectedMode: ComjotToneMode,
    selectedCode: String,
    onCodeSelected: (String) -> Unit
) {
    var expanded by remember(selectedMode) { mutableStateOf(false) }
    val options = when (selectedMode) {
        ComjotToneMode.OFF -> listOf("None")
        ComjotToneMode.CTCSS -> COMJOT_CTCSS_CODES.drop(1)
        ComjotToneMode.DCS,
        ComjotToneMode.REVERSE_DCS -> COMJOT_DCS_CODES
    }
    val displayCode = if (selectedMode.needsCode) selectedCode else "None"

    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Box {
            OutlinedButton(
                onClick = { expanded = true },
                enabled = selectedMode.needsCode
            ) {
                Text(displayCode)
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                options.forEach { code ->
                    DropdownMenuItem(
                        text = { Text(code) },
                        onClick = {
                            onCodeSelected(code)
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun <T> SelectorRow(
    label: String,
    options: List<T>,
    selected: T,
    title: (T) -> String,
    onSelected: (T) -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            options.forEach { option ->
                if (option == selected) {
                    Button(
                        onClick = { onSelected(option) },
                        modifier = Modifier.weight(1f),
                        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp)
                    ) {
                        Text(title(option))
                    }
                } else {
                    OutlinedButton(
                        onClick = { onSelected(option) },
                        modifier = Modifier.weight(1f),
                        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp)
                    ) {
                        Text(title(option))
                    }
                }
            }
        }
    }
}

@Composable
private fun ToggleRow(
    label: String,
    checked: Boolean,
    onCheckedChanged: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label, style = MaterialTheme.typography.bodyLarge)
        Switch(checked = checked, onCheckedChange = onCheckedChanged)
    }
}

@Composable
private fun ErrorCard(message: String) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.error.copy(alpha = 0.12f)
        ),
        shape = RoundedCornerShape(12.dp)
    ) {
        Text(
            text = message,
            modifier = Modifier.padding(14.dp),
            color = MaterialTheme.colorScheme.error,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
private fun SessionPanel(
    session: SessionSnapshot,
    isBusy: Boolean,
    onTogglePtt: () -> Unit,
    onDisconnect: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondary.copy(alpha = 0.12f))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "ROIP Session", style = MaterialTheme.typography.titleMedium)
                StatusPill(session.phase.sessionPhaseLabel())
            }
            DetailRow("Provider", session.providerName)
            DetailRow("Target", session.target)
            DetailRow("Server", session.serverHost)
            if (session.inboundDmrFrames > 0) {
                DetailRow("RX Frames", session.inboundDmrFrames.toString())
                DetailRow(
                    "DMR Media",
                    "${session.inboundDmrVoiceFrames} voice / ${session.inboundDmrDataFrames} data / ${session.inboundAmbeFrames} AMBE"
                )
                DetailRow(
                    label = "Last RX",
                    value = listOfNotNull(
                        session.lastInboundCallsign ?: session.lastInboundSourceId?.let { "ID $it" },
                        session.lastInboundTargetId?.let { "TG $it" },
                        session.lastInboundSlot?.let { "slot $it" },
                        session.lastInboundFrameType
                    ).joinToString(" -> ")
                )
                if (!session.lastInboundName.isNullOrBlank() || !session.lastInboundLocation.isNullOrBlank()) {
                    DetailRow(
                        label = "Caller",
                        value = listOfNotNull(
                            session.lastInboundName,
                            session.lastInboundLocation
                        ).joinToString(" / ")
                    )
                }
                session.audioDecoderState?.let { decoder ->
                    DetailRow("Decoder", decoder)
                }
            }
            Text(
                text = session.statusMessage,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            if (session.requiresMediaBridge) {
                Text(
                    text = "AMBE voice blocks are being extracted. Speaker playback will start when the native OpenRadio AMBE vocoder is packaged.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Button(
                    onClick = onTogglePtt,
                    enabled = !isBusy && session.phase in listOf("connected", "transmitting")
                ) {
                    Text(if (session.pttActive) "Release" else "PTT")
                }
                OutlinedButton(
                    onClick = onDisconnect,
                    enabled = !isBusy
                ) {
                    Text("Disconnect")
                }
            }
        }
    }
}

@Composable
private fun LabeledInput(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    keyboardType: KeyboardType = KeyboardType.Text,
    password: Boolean = false
) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(label)
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        visualTransformation = if (password) PasswordVisualTransformation() else androidx.compose.ui.text.input.VisualTransformation.None
    )
}

@Composable
private fun StatusPill(text: String) {
    Box(
        modifier = Modifier
            .background(
                color = MaterialTheme.colorScheme.secondary.copy(alpha = 0.18f),
                shape = RoundedCornerShape(999.dp)
            )
            .padding(horizontal = 10.dp, vertical = 6.dp)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}

@Composable
private fun DetailRow(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            modifier = Modifier.width(88.dp),
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

private fun defaultMemoryType(mode: ComjotMode): MemoryType {
    return when (mode) {
        ComjotMode.DMR -> MemoryType.DMR_NODE
        ComjotMode.FM -> MemoryType.REPEATER
        ComjotMode.ROIP -> MemoryType.ROIP_FAVORITE
        ComjotMode.SCANNER -> MemoryType.REPEATER
    }
}

private fun RadioMemory.subtitle(): String {
    return when (type) {
        MemoryType.REPEATER -> "${rxFrequency} -> ${txFrequency} MHz  ${bandwidth.title}  ${rfPower.title}"
        MemoryType.DMR_NODE -> "${rxFrequency} MHz  TG $talkgroup  CC $colorCode  TS $timeSlot"
        MemoryType.ROIP_FAVORITE -> listOfNotNull(providerTitle, providerTarget, providerHost)
            .filter { it.isNotBlank() }
            .joinToString("  ")
            .ifBlank { "${rxFrequency} MHz" }
    }
}

private fun AppUiState.roipProviderProfiles(): List<ProviderProfile> {
    return providers.filter { it.type.providerId in ROIP_PROVIDER_IDS }
}

private fun AppUiState.selectedRoipProvider(): ProviderProfile? {
    return providers.firstOrNull {
        it.type.providerId == selectedRoipProviderId && it.type.providerId in ROIP_PROVIDER_IDS
    } ?: roipProviderProfiles().firstOrNull()
}

private fun ProviderProfile.providerSubtitle(): String {
    return if (type.providerId == ALLSTAR_PROVIDER_ID) {
        listOf(
            stationId.takeIf { it.isNotBlank() }?.let { local -> "Node $local" },
            target.takeIf { it.isNotBlank() }?.let { remote -> "to $remote" },
            serverHost
        )
            .filterNotNull()
            .filter { it.isNotBlank() }
            .joinToString("  ")
    } else {
        listOf("TG $target", serverHost)
            .filter { it.isNotBlank() }
            .joinToString("  ")
    }
}

private data class ScannerSignal(
    val frequencyMhz: Double,
    val strength: Float,
    val widthMhz: Double
)

private fun scannerSignals(
    centerMhz: Double,
    spanMhz: Double,
    developerMode: Boolean
): List<ScannerSignal> {
    val channelStep = if (centerMhz < 300.0) 0.005 else 0.0125
    val roundedCenter = (centerMhz / channelStep).toInt() * channelStep
    val offsets = if (developerMode) {
        listOf(-0.43, -0.215, -0.055, 0.132, 0.318, 0.49)
    } else {
        listOf(-0.34, -0.145, 0.075, 0.265)
    }
    return offsets.mapIndexedNotNull { index, offset ->
        val frequency = roundedCenter + offset * spanMhz
        if (abs(frequency - centerMhz) > spanMhz / 2.0) {
            null
        } else {
            ScannerSignal(
                frequencyMhz = frequency,
                strength = (0.42f + (index % 3) * 0.17f + if (developerMode) 0.06f else 0f).coerceAtMost(0.92f),
                widthMhz = spanMhz * (0.010 + (index % 2) * 0.006)
            )
        }
    }
}

private fun scannerPowerAt(
    mhz: Double,
    startMhz: Double,
    spanMhz: Double,
    phase: Float,
    active: Boolean,
    signals: List<ScannerSignal>
): Float {
    val progress = ((mhz - startMhz) / spanMhz).toFloat()
    val noise = 0.12f +
        sin(progress * PI.toFloat() * 14f + phase * PI.toFloat() * 2f) * 0.025f +
        cos(progress * PI.toFloat() * 31f - phase * PI.toFloat() * 5f) * 0.018f
    val sweep = sin((progress + phase) * PI.toFloat() * 2f).coerceAtLeast(0f) * 0.06f
    val peaks = signals.sumOf { signal ->
        val distance = (mhz - signal.frequencyMhz) / signal.widthMhz.coerceAtLeast(0.0001)
        (exp(-(distance * distance) * 0.5) * signal.strength).toDouble()
    }.toFloat()
    val scale = if (active) 1f else 0.64f
    return ((noise + sweep + peaks) * scale).coerceIn(0.04f, 0.98f)
}

private fun formatScannerFrequency(value: Double): String {
    return String.format(java.util.Locale.US, "%.4f", value)
}

private fun modeTitle(mode: ComjotMode, developerMode: Boolean): String {
    return if (developerMode && mode == ComjotMode.SCANNER) "SDR" else mode.title
}

private fun String.sessionPhaseLabel(): String {
    return when (this) {
        "bridge_required" -> "Bridge Needed"
        "configuring" -> "Configuring"
        "authorizing" -> "Authorizing"
        "registering" -> "Registering"
        "linking" -> "Linking"
        "connected" -> "Connected"
        "transmitting" -> "TX"
        "disconnected" -> "Disconnected"
        else -> replace('_', ' ').replaceFirstChar { it.uppercase() }
    }
}

private fun ComjotMode.isTxEnabled(developerMode: Boolean): Boolean {
    return txEnabled || (developerMode && this == ComjotMode.SCANNER)
}

private const val ALLSTAR_PROVIDER_ID = "allstar"
private val ROIP_PROVIDER_IDS = setOf("brandmeister", "tgif", "freedmr", ALLSTAR_PROVIDER_ID)
