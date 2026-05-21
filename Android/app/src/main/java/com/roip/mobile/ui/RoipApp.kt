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
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.roip.mobile.BuildConfig
import com.roip.mobile.MainViewModel
import com.roip.mobile.data.AccentColor
import com.roip.mobile.data.AppUiState
import com.roip.mobile.data.COMJOT_CTCSS_CODES
import com.roip.mobile.data.COMJOT_DCS_CODES
import com.roip.mobile.data.CallerLookup
import com.roip.mobile.data.ComjotBandwidth
import com.roip.mobile.data.ComjotField
import com.roip.mobile.data.ComjotMode
import com.roip.mobile.data.ComjotRfPower
import com.roip.mobile.data.ComjotToneMode
import com.roip.mobile.data.ComjotUiState
import com.roip.mobile.data.HardwareButtonAction
import com.roip.mobile.data.HardwareButtonInput
import com.roip.mobile.data.HotspotField
import com.roip.mobile.data.KnobControlMode
import com.roip.mobile.data.MemoryType
import com.roip.mobile.data.ProviderField
import com.roip.mobile.data.ProviderProfile
import com.roip.mobile.data.RadioMemory
import com.roip.mobile.data.RoipOperationMode
import com.roip.mobile.data.SessionSnapshot
import com.roip.mobile.data.normalizedCallsign
import com.roip.mobile.data.qrzLookupUrl
import com.roip.mobile.data.qthLookupUrl
import kotlin.math.PI
import kotlin.math.abs
import kotlin.math.cos
import kotlin.math.exp
import kotlin.math.sin

@Composable
fun RoipApp(viewModel: MainViewModel = viewModel()) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    val context = LocalContext.current
    val layout = rememberAppLayoutMetrics(state)
    val topSystemPadding = if (layout.compact) 2.dp else 8.dp
    val bottomSystemPadding = if (layout.compact) 4.dp else 10.dp
    var settingsOpen by remember { mutableStateOf(false) }
    var memoriesOpen by remember { mutableStateOf(false) }
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
    LaunchedEffect(state.activeSession?.lastInboundCallsign) {
        viewModel.lookupCallerDetails(state.activeSession?.lastInboundCallsign)
    }

    RoipTheme(accentColor = state.accentColor) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.onSurface
        ) {
            RadioOsBackdrop(lowPower = layout.lowPowerUi) {
                if (settingsOpen || memoriesOpen) {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(bottom = bottomSystemPadding),
                        contentPadding = PaddingValues(
                            start = layout.outerPadding,
                            top = topSystemPadding + layout.outerPadding,
                            end = layout.outerPadding,
                            bottom = layout.outerPadding
                        ),
                        verticalArrangement = Arrangement.spacedBy(layout.itemSpacing)
                    ) {
                        item {
                            if (settingsOpen) {
                                PageHeader(
                                    layout = layout,
                                    title = "Settings",
                                    subtitle = "OpenRadio",
                                    onBack = { settingsOpen = false }
                                )
                            } else {
                                PageHeader(
                                    layout = layout,
                                    title = "Memories",
                                    subtitle = modeTitle(state.comjot.profile.mode, state.comjot.developerMode),
                                    onBack = { memoriesOpen = false }
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
                                    onHardwareButtonMappingChanged = viewModel::updateHardwareButtonMapping,
                                    onProviderFieldChanged = viewModel::updateProvider,
                                    onScanBrandmeisterQr = { providerId -> viewModel.scanBrandmeisterQr(context, providerId) },
                                    onCheckForUpdates = { viewModel.checkForGithubUpdate(context) },
                                    onVersionTapped = viewModel::onVersionTapped
                                )
                            }
                        } else {
                            item {
                                MemoryPanel(
                                    state = state,
                                    onSaveMemory = viewModel::saveCurrentMemory,
                                    onRecallMemory = viewModel::recallMemory,
                                    onDeleteMemory = viewModel::deleteMemory
                                )
                            }
                        }
                        state.errorMessage?.let { message ->
                            item { ErrorCard(message = message) }
                        }
                    }
                } else {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(
                                start = layout.outerPadding,
                                top = topSystemPadding + layout.outerPadding,
                                end = layout.outerPadding,
                                bottom = bottomSystemPadding + layout.outerPadding
                            ),
                        verticalArrangement = Arrangement.spacedBy(layout.itemSpacing)
                    ) {
                        OperatorHeader(
                            state = state,
                            layout = layout,
                            onModeSelected = { mode -> viewModel.updateComjot(ComjotField.MODE, mode.name) },
                            onRecallMemory = viewModel::recallMemory,
                            onSaveMemory = viewModel::saveCurrentMemory,
                            onMemoryClicked = {
                                settingsOpen = false
                                memoriesOpen = true
                            },
                            onSettingsClicked = { settingsOpen = true }
                        )
                        RadioPanel(
                            state = state,
                            layout = layout,
                            modifier = Modifier.weight(1f),
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
                }
            }
        }
    }
}

@Immutable
private data class AppLayoutMetrics(
    val outerPadding: androidx.compose.ui.unit.Dp,
    val cardPadding: androidx.compose.ui.unit.Dp,
    val itemSpacing: androidx.compose.ui.unit.Dp,
    val buttonHeight: androidx.compose.ui.unit.Dp,
    val pttHeight: androidx.compose.ui.unit.Dp,
    val displayPadding: androidx.compose.ui.unit.Dp,
    val readoutTextSp: Int,
    val compactSoftKeyHeight: androidx.compose.ui.unit.Dp,
    val tiny: Boolean,
    val compact: Boolean,
    val phoneRoip: Boolean,
    val lowPowerUi: Boolean
)

@Immutable
private data class RadioIndicator(
    val label: String,
    val active: Boolean
)

@Composable
private fun rememberAppLayoutMetrics(state: AppUiState): AppLayoutMetrics {
    val configuration = LocalConfiguration.current
    val widthDp = configuration.screenWidthDp
    val heightDp = configuration.screenHeightDp
    val phoneRoip = !state.radioHardwareAvailable && state.comjot.profile.mode == ComjotMode.ROIP
    val tiny = widthDp < 390 || heightDp <= 640
    val compact = phoneRoip || widthDp < 430 || heightDp < 760
    return remember(widthDp, heightDp, phoneRoip, state.radioHardwareAvailable) {
        AppLayoutMetrics(
            outerPadding = when {
                tiny -> 5.dp
                compact -> 6.dp
                else -> 12.dp
            },
            cardPadding = when {
                tiny -> 7.dp
                compact -> 8.dp
                else -> 14.dp
            },
            itemSpacing = when {
                tiny -> 5.dp
                compact -> 6.dp
                else -> 10.dp
            },
            buttonHeight = when {
                tiny -> 40.dp
                compact -> 46.dp
                else -> 56.dp
            },
            pttHeight = when {
                tiny -> 68.dp
                compact -> 76.dp
                else -> 108.dp
            },
            displayPadding = when {
                tiny -> 7.dp
                compact -> 9.dp
                else -> 18.dp
            },
            readoutTextSp = when {
                tiny -> 34
                compact -> 42
                else -> 54
            },
            compactSoftKeyHeight = when {
                tiny -> 38.dp
                compact -> 40.dp
                else -> 50.dp
            },
            tiny = tiny,
            compact = compact,
            phoneRoip = phoneRoip,
            lowPowerUi = state.radioHardwareAvailable && compact
        )
    }
}

@Composable
private fun Modifier.radioClickable(
    enabled: Boolean = true,
    onClick: () -> Unit
): Modifier {
    val interactionSource = remember { MutableInteractionSource() }
    return clickable(
        enabled = enabled,
        interactionSource = interactionSource,
        indication = null,
        onClick = onClick
    )
}

@Composable
private fun RadioOsBackdrop(
    lowPower: Boolean,
    content: @Composable () -> Unit
) {
    val background = MaterialTheme.colorScheme.background
    val primary = MaterialTheme.colorScheme.primary
    val surface = MaterialTheme.colorScheme.surface
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(background)
    ) {
        if (!lowPower) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                drawRect(color = background)
                val grid = 32.dp.toPx()
                var x = 0f
                while (x < size.width) {
                    drawLine(
                        color = primary.copy(alpha = 0.045f),
                        start = Offset(x, 0f),
                        end = Offset(x, size.height),
                        strokeWidth = 1f
                    )
                    x += grid
                }
                var y = 0f
                while (y < size.height) {
                    drawLine(
                        color = primary.copy(alpha = 0.035f),
                        start = Offset(0f, y),
                        end = Offset(size.width, y),
                        strokeWidth = 1f
                    )
                    y += grid
                }
                drawRect(
                    color = surface.copy(alpha = 0.42f),
                    topLeft = Offset.Zero,
                    size = androidx.compose.ui.geometry.Size(size.width, size.height)
                )
            }
        }
        content()
    }
}

@Composable
private fun RadioGlassPanel(
    modifier: Modifier = Modifier,
    shape: RoundedCornerShape = RoundedCornerShape(18.dp),
    padding: PaddingValues = PaddingValues(12.dp),
    borderAlpha: Float = 0.44f,
    itemSpacing: androidx.compose.ui.unit.Dp = 10.dp,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.surface.copy(alpha = 0.86f),
                shape = shape
            )
            .border(
                width = 1.5.dp,
                color = MaterialTheme.colorScheme.primary.copy(alpha = borderAlpha),
                shape = shape
            )
            .padding(padding),
        verticalArrangement = Arrangement.spacedBy(itemSpacing),
        content = content
    )
}

@Composable
private fun RadioDisplayPanel(
    layout: AppLayoutMetrics,
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    val shape = RoundedCornerShape(if (layout.compact) 20.dp else 26.dp)
    Box(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 0.dp)
            .background(
                color = Color.Black.copy(alpha = 0.34f),
                shape = shape
            )
            .border(
                width = 2.dp,
                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.62f),
                shape = shape
            )
            .padding(layout.displayPadding)
    ) {
        if (!layout.lowPowerUi) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                val scanline = 9.dp.toPx()
                var y = 0f
                while (y < size.height) {
                    drawLine(
                        color = Color.White.copy(alpha = 0.018f),
                        start = Offset(0f, y),
                        end = Offset(size.width, y),
                        strokeWidth = 1f
                    )
                    y += scanline
                }
            }
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(if (layout.compact) 8.dp else 12.dp),
            content = content
        )
    }
}

@Composable
private fun OperatorHeader(
    state: AppUiState,
    layout: AppLayoutMetrics,
    onModeSelected: (ComjotMode) -> Unit,
    onRecallMemory: (String) -> Unit,
    onSaveMemory: (String, MemoryType) -> Unit,
    onMemoryClicked: () -> Unit,
    onSettingsClicked: () -> Unit
) {
    var modeMenuOpen by remember { mutableStateOf(false) }
    var memoryMenuOpen by remember { mutableStateOf(false) }
    val mode = state.comjot.profile.mode
    val modeOptions = if (state.radioHardwareAvailable) ComjotMode.entries else listOf(ComjotMode.ROIP)
    val memoriesForMode = remember(state.memories, mode) {
        state.memories
            .filter { it.mode == mode || it.type == defaultMemoryType(mode) }
            .sortedWith(compareBy<RadioMemory> { it.type.ordinal }.thenBy { it.name.lowercase() })
    }

    val modeLabel = if (layout.phoneRoip) "ROIP" else modeTitle(mode, state.comjot.developerMode)

    Column(verticalArrangement = Arrangement.spacedBy(if (layout.compact) 5.dp else 7.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(if (layout.compact) 6.dp else 10.dp)
        ) {
            Box(modifier = Modifier.weight(1f)) {
                RadioTopButton(
                    text = modeLabel,
                    height = layout.buttonHeight,
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { modeMenuOpen = true }
                )
                DropdownMenu(expanded = modeMenuOpen, onDismissRequest = { modeMenuOpen = false }) {
                    modeOptions.forEach { nextMode ->
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
                    height = layout.buttonHeight,
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
                    HorizontalDivider()
                    DropdownMenuItem(
                        text = { Text("Manage memories") },
                        onClick = {
                            memoryMenuOpen = false
                            onMemoryClicked()
                        }
                    )
                }
            }
            RadioTopButton(
                text = "☰",
                height = layout.buttonHeight,
                modifier = Modifier.width(if (layout.compact) 48.dp else 54.dp),
                onClick = onSettingsClicked
            )
        }
        if (!layout.compact) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.42f),
                        shape = RoundedCornerShape(999.dp)
                    )
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.primary.copy(alpha = 0.22f),
                        shape = RoundedCornerShape(999.dp)
                    )
                    .padding(horizontal = 10.dp, vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "OPENRADIO OS",
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Black,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = if (state.radioHardwareAvailable) "CJ1 RADIO CORE" else "ROIP SOFT RADIO",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
private fun RadioTopButton(
    text: String,
    height: androidx.compose.ui.unit.Dp,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .height(height)
            .background(
                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.62f),
                shape = RoundedCornerShape(12.dp)
            )
            .border(
                width = 1.5.dp,
                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.45f),
                shape = RoundedCornerShape(12.dp)
            )
            .radioClickable(onClick = onClick)
            .padding(horizontal = 8.dp, vertical = 4.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Black,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
private fun RadioMenuButton(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    height: androidx.compose.ui.unit.Dp = 44.dp,
    onClick: () -> Unit
) {
    val borderColor = if (enabled) {
        MaterialTheme.colorScheme.primary.copy(alpha = 0.38f)
    } else {
        MaterialTheme.colorScheme.outline.copy(alpha = 0.18f)
    }
    val textColor = if (enabled) {
        MaterialTheme.colorScheme.primary
    } else {
        MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.55f)
    }
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(height)
            .background(
                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = if (enabled) 0.50f else 0.24f),
                shape = RoundedCornerShape(12.dp)
            )
            .border(
                width = 1.2.dp,
                color = borderColor,
                shape = RoundedCornerShape(12.dp)
            )
            .radioClickable(enabled = enabled, onClick = onClick)
            .padding(horizontal = 10.dp, vertical = 6.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelLarge,
            color = textColor,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
private fun RadioActionButton(
    label: String,
    enabled: Boolean,
    filled: Boolean,
    modifier: Modifier = Modifier,
    height: androidx.compose.ui.unit.Dp = 50.dp,
    onClick: () -> Unit
) {
    val color = when {
        !enabled -> MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.30f)
        filled -> MaterialTheme.colorScheme.primary
        else -> MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.58f)
    }
    val contentColor = when {
        !enabled -> MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.58f)
        filled -> MaterialTheme.colorScheme.onPrimary
        else -> MaterialTheme.colorScheme.primary
    }
    Box(
        modifier = modifier
            .height(height)
            .background(
                color = color,
                shape = RoundedCornerShape(16.dp)
            )
            .border(
                width = 1.5.dp,
                color = if (enabled) MaterialTheme.colorScheme.primary.copy(alpha = 0.55f) else MaterialTheme.colorScheme.outline.copy(alpha = 0.2f),
                shape = RoundedCornerShape(16.dp)
            )
            .radioClickable(enabled = enabled, onClick = onClick)
            .padding(horizontal = 12.dp, vertical = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.titleMedium,
            color = contentColor,
            fontWeight = FontWeight.Black,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
private fun PageHeader(
    layout: AppLayoutMetrics,
    title: String,
    subtitle: String,
    onBack: () -> Unit
) {
    RadioGlassPanel(
        shape = RoundedCornerShape(14.dp),
        padding = PaddingValues(horizontal = layout.cardPadding, vertical = 10.dp),
        borderAlpha = 0.36f
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title.uppercase(),
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Black,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            RadioMenuButton(
                text = "BACK",
                modifier = Modifier.width(if (layout.compact) 82.dp else 96.dp),
                onClick = onBack
            )
        }
    }
}

@Composable
private fun RadioPanel(
    state: AppUiState,
    layout: AppLayoutMetrics,
    modifier: Modifier = Modifier,
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

    RadioGlassPanel(
        modifier = modifier,
        shape = RoundedCornerShape(22.dp),
        padding = PaddingValues(layout.cardPadding),
        borderAlpha = 0.34f,
        itemSpacing = layout.itemSpacing
    ) {
        val actionEnabled = !state.isBusy && !comjot.isBusy && (!isRoip || roipProvider != null)
        val onPrimaryAction: () -> Unit = {
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
        }

        RadioFaceDisplay(
            state = state,
            provider = roipProvider,
            layout = layout,
            modifier = Modifier.weight(1f),
            compactControls = if (layout.compact) {
                {
                    PrimaryActionButton(
                        label = actionLabel,
                        enabled = actionEnabled,
                        secondaryLabel = if (!isRoip && !txEnabled) "RX Only" else null,
                        height = layout.compactSoftKeyHeight,
                        onClick = onPrimaryAction
                    )

                    RadioQuickControls(
                        state = state,
                        provider = roipProvider,
                        layout = layout,
                        onFieldChanged = onFieldChanged,
                        onProviderFieldChanged = onProviderFieldChanged,
                        onRoipOperationModeChanged = onRoipOperationModeChanged,
                        onRoipProviderSelected = onRoipProviderSelected,
                        onSendAllStarDtmf = onSendAllStarDtmf
                    )
                }
            } else {
                null
            },
            onFieldChanged = onFieldChanged
        )

        if (!layout.compact) {
            PrimaryActionButton(
                label = actionLabel,
                enabled = actionEnabled,
                secondaryLabel = if (!isRoip && !txEnabled) "RX Only" else null,
                onClick = onPrimaryAction
            )
        }

        HoldToTalkButton(
            enabled = pttEnabled,
            active = pttActive,
            busy = state.isBusy || comjot.isBusy,
            height = layout.pttHeight,
            disabledText = when {
                isRoip && isHotspotMode -> "Start hotspot first"
                isRoip -> "Connect first"
                else -> "Program first"
            },
            onStart = if (isRoip && !useStandalonePtt) onRoipPttStart else onPttStart,
            onEnd = if (isRoip && !useStandalonePtt) onRoipPttEnd else onPttEnd,
            onAudioPermissionDenied = onAudioPermissionDenied
        )

        if (!layout.compact) {
            RadioQuickControls(
                state = state,
                provider = roipProvider,
                layout = layout,
                onFieldChanged = onFieldChanged,
                onProviderFieldChanged = onProviderFieldChanged,
                onRoipOperationModeChanged = onRoipOperationModeChanged,
                onRoipProviderSelected = onRoipProviderSelected,
                onSendAllStarDtmf = onSendAllStarDtmf
            )
        }

        if (!layout.compact) {
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
    layout: AppLayoutMetrics,
    modifier: Modifier = Modifier,
    compactControls: (@Composable ColumnScope.() -> Unit)? = null,
    onFieldChanged: (ComjotField, String) -> Unit
) {
    val profile = state.comjot.profile
    val isRoip = profile.mode == ComjotMode.ROIP
    val isAllStar = isRoip && provider?.type?.providerId == ALLSTAR_PROVIDER_ID
    if (isRoip) {
        RoipFaceDisplay(
            state = state,
            provider = provider,
            isAllStar = isAllStar,
            layout = layout,
            modifier = modifier,
            compactControls = compactControls
        )
        return
    }

    if (layout.compact) {
        CompactRfFace(
            state = state,
            provider = provider,
            layout = layout,
            modifier = modifier,
            compactControls = compactControls
        )
        return
    }

    RadioDisplayPanel(layout = layout, modifier = modifier) {
        IndicatorStrip(state, compact = layout.lowPowerUi)
        RadioReadoutBlock(
            label = "RX",
            value = profile.rxFrequency,
            editable = !isRoip,
            layout = layout,
            onValueChange = { onFieldChanged(ComjotField.RX_FREQUENCY, it) }
        )
        RadioReadoutBlock(
            label = if (profile.mode == ComjotMode.SCANNER) "MONITOR" else "TX",
            value = if (profile.mode == ComjotMode.SCANNER) "RX ONLY" else profile.txFrequency,
            editable = !isRoip && profile.mode != ComjotMode.SCANNER,
            layout = layout,
            onValueChange = { onFieldChanged(ComjotField.TX_FREQUENCY, it) }
        )
        if (profile.mode == ComjotMode.DMR) {
            DmrInfoBox(state, provider, compact = layout.compact)
        }
    }
}

@Composable
private fun CompactRfFace(
    state: AppUiState,
    provider: ProviderProfile?,
    layout: AppLayoutMetrics,
    modifier: Modifier = Modifier,
    compactControls: (@Composable ColumnScope.() -> Unit)? = null
) {
    val profile = state.comjot.profile
    RadioDisplayPanel(layout = layout, modifier = modifier) {
        IndicatorStrip(state, compact = layout.lowPowerUi)
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(if (layout.tiny) 2.dp else 4.dp)
        ) {
            Text(
                text = "RX",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Black
            )
            Text(
                text = profile.rxFrequency,
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Black,
                    fontSize = layout.readoutTextSp.sp,
                    lineHeight = (layout.readoutTextSp + 4).sp
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                MiniMetric(
                    label = if (profile.mode == ComjotMode.SCANNER) "MON" else "TX",
                    value = if (profile.mode == ComjotMode.SCANNER) "RX ONLY" else profile.txFrequency,
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(6.dp))
                MiniMetric(
                    label = "BW",
                    value = profile.bandwidth.title,
                    modifier = Modifier.weight(0.78f)
                )
                Spacer(modifier = Modifier.width(6.dp))
                MiniMetric(
                    label = "PWR",
                    value = profile.rfPower.title,
                    modifier = Modifier.weight(0.78f)
                )
            }
        }
        if (profile.mode == ComjotMode.DMR) {
            CompactDmrSummary(state = state, provider = provider)
        }
        CompactRfStatusRail(
            state = state,
            modifier = Modifier.weight(1f)
        )
        compactControls?.invoke(this)
    }
}

@Composable
private fun RoipFaceDisplay(
    state: AppUiState,
    provider: ProviderProfile?,
    isAllStar: Boolean,
    layout: AppLayoutMetrics,
    modifier: Modifier = Modifier,
    compactControls: (@Composable ColumnScope.() -> Unit)? = null
) {
    val session = state.activeSession
    val providerName = session?.providerName ?: provider?.type?.title ?: "ROIP"
    val server = session?.serverHost ?: provider?.roipServerLabel() ?: "No server"
    val port = if (session == null && provider?.usesAutoAllStarLookup() != true) {
        provider?.serverPort?.takeIf { it.isNotBlank() }
    } else {
        null
    }
    val target = when {
        isAllStar && provider != null -> listOf(provider.stationId, provider.target)
            .filter { it.isNotBlank() }
            .joinToString(" -> ")
            .ifBlank { "Nodes not set" }

        session != null -> session.target
        provider != null -> provider.target.ifBlank { "No target" }
        else -> "No target"
    }
    val sessionLabel = session?.phase?.sessionPhaseLabel() ?: "Standby"
    val operation = if (state.radioHardwareAvailable) {
        state.roipOperationMode.title
    } else {
        "Phone ROIP"
    }

    if (layout.compact) {
        CompactRoipFace(
            state = state,
            provider = provider,
            providerName = providerName,
            server = server,
            target = target,
            sessionLabel = sessionLabel,
            operation = operation,
            isAllStar = isAllStar,
            layout = layout,
            modifier = modifier,
            compactControls = compactControls
        )
        return
    }

    RadioDisplayPanel(layout = layout, modifier = modifier) {
        IndicatorStrip(state, compact = layout.lowPowerUi)
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            StatusPill(sessionLabel)
            Text(
                text = providerName,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = listOfNotNull(server, port?.let { ":$it" }).joinToString(""),
                style = MaterialTheme.typography.titleMedium.copy(
                    fontSize = if (layout.compact) 17.sp else 20.sp,
                    fontWeight = FontWeight.Bold
                ),
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = target,
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontSize = if (layout.compact) 29.sp else 38.sp,
                    fontWeight = FontWeight.Black
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = operation,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

        if (isAllStar) {
            AllStarInfoBox(state, provider, compact = layout.compact)
        } else {
            DmrInfoBox(state, provider, compact = layout.compact)
        }

        if (!state.radioHardwareAvailable) {
            Text(
                text = "ROIP-only phone mode",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun CompactRoipFace(
    state: AppUiState,
    provider: ProviderProfile?,
    providerName: String,
    server: String,
    target: String,
    sessionLabel: String,
    operation: String,
    isAllStar: Boolean,
    layout: AppLayoutMetrics,
    modifier: Modifier = Modifier,
    compactControls: (@Composable ColumnScope.() -> Unit)? = null
) {
    RadioDisplayPanel(layout = layout, modifier = modifier) {
        IndicatorStrip(state, compact = layout.lowPowerUi)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = providerName,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Black,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = if (layout.tiny) operation else server,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            StatusPill(sessionLabel)
        }
        Text(
            text = target,
            style = MaterialTheme.typography.headlineMedium.copy(
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Black,
                fontSize = if (layout.tiny) 30.sp else 34.sp,
                lineHeight = if (layout.tiny) 34.sp else 38.sp
            ),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        if (isAllStar) {
            CompactAllStarSummary(provider = provider)
        } else {
            CompactDmrSummary(state = state, provider = provider)
        }
        CompactRoipStatusRail(
            state = state,
            server = server,
            operation = operation,
            modifier = Modifier.weight(1f)
        )
        compactControls?.invoke(this)
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun IndicatorStrip(
    state: AppUiState,
    compact: Boolean
) {
    val profile = state.comjot.profile
    val session = state.activeSession
    val analogMode = profile.mode == ComjotMode.FM || profile.mode == ComjotMode.SCANNER
    val indicators = remember(
        profile.mode,
        profile.rfPower,
        profile.rxToneMode,
        profile.txToneMode,
        state.comjot.developerMode,
        state.roipOperationMode,
        session?.phase,
        compact
    ) {
        val netActive = session?.phase == "connected" || session?.phase == "transmitting"
        mutableListOf<RadioIndicator>().apply {
            add(
                RadioIndicator(
                    label = if (state.comjot.developerMode && profile.mode == ComjotMode.SCANNER) {
                        "SDR"
                    } else if (compact) {
                        profile.mode.title.uppercase().take(4)
                    } else {
                        profile.mode.title.uppercase()
                    },
                    active = true
                )
            )
            if (profile.mode != ComjotMode.ROIP) {
                add(RadioIndicator(label = if (profile.rfPower == ComjotRfPower.HIGH) "HI" else "LO", active = true))
            }
            if (analogMode) {
                add(RadioIndicator(label = if (compact) "RXT" else "RX TONE", active = profile.rxToneMode != ComjotToneMode.OFF))
                add(
                    RadioIndicator(
                        label = if (compact) "TXT" else "TX TONE",
                        active = profile.txToneMode != ComjotToneMode.OFF && profile.mode != ComjotMode.SCANNER
                    )
                )
            }
            if (profile.mode == ComjotMode.ROIP && state.roipOperationMode == RoipOperationMode.HOTSPOT) {
                add(RadioIndicator(label = if (compact) "HOT" else "HOTSPOT", active = true))
            }
            add(RadioIndicator(label = "NET", active = netActive))
        }
    }

    if (compact) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            indicators.forEach { indicator ->
                IndicatorLight(
                    label = indicator.label,
                    active = indicator.active,
                    compact = true
                )
            }
        }
    } else {
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            indicators.forEach { indicator ->
                IndicatorLight(
                    label = indicator.label,
                    active = indicator.active,
                    compact = false
                )
            }
        }
    }
}

@Composable
private fun IndicatorLight(
    label: String,
    active: Boolean,
    compact: Boolean
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(if (compact) 3.dp else 4.dp)
    ) {
        Box(
            modifier = Modifier
                .size(if (compact) 6.dp else 8.dp)
                .background(
                    color = if (active) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline.copy(alpha = 0.35f),
                    shape = CircleShape
                )
        )
        Text(
            text = label,
            style = if (compact) MaterialTheme.typography.labelSmall else MaterialTheme.typography.bodySmall,
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
    layout: AppLayoutMetrics,
    onValueChange: (String) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        if (editable) {
            OutlinedTextField(
                value = value,
                onValueChange = onValueChange,
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                textStyle = MaterialTheme.typography.headlineMedium.copy(
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Black,
                    fontSize = layout.readoutTextSp.sp,
                    lineHeight = (layout.readoutTextSp + 5).sp
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
            )
        } else {
            Text(
                text = value,
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Black,
                    fontSize = layout.readoutTextSp.sp,
                    lineHeight = (layout.readoutTextSp + 5).sp
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
private fun DmrInfoBox(
    state: AppUiState,
    provider: ProviderProfile?,
    compact: Boolean
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
        if (compact) {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                DmrMetric(label = "Target", value = target)
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    DmrMetric(label = "Color", value = "CC $colorCode", modifier = Modifier.weight(1f))
                    DmrMetric(label = "Slot", value = "S$slot", modifier = Modifier.weight(1f))
                }
            }
        } else {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                DmrMetric(label = "Target", value = target, modifier = Modifier.weight(1f))
                DmrMetric(label = "Color", value = "CC $colorCode", modifier = Modifier.weight(1f))
                DmrMetric(label = "Slot", value = "S$slot", modifier = Modifier.weight(1f))
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.10f),
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(horizontal = 10.dp, vertical = if (compact) 7.dp else 9.dp),
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
                style = if (compact) MaterialTheme.typography.titleMedium else MaterialTheme.typography.titleLarge,
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
    provider: ProviderProfile?,
    compact: Boolean
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
        if (compact) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                DmrMetric(label = "Local", value = localNode, modifier = Modifier.weight(1f))
                DmrMetric(label = "Remote", value = remoteNode, modifier = Modifier.weight(1f))
            }
        } else {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                DmrMetric(label = "Local", value = localNode, modifier = Modifier.weight(1f))
                DmrMetric(label = "Remote", value = remoteNode, modifier = Modifier.weight(1f))
                DmrMetric(label = "Codec", value = "uLaw", modifier = Modifier.weight(1f))
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.10f),
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(horizontal = 10.dp, vertical = if (compact) 7.dp else 9.dp),
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
                style = if (compact) MaterialTheme.typography.titleMedium else MaterialTheme.typography.titleLarge,
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
            .padding(horizontal = 8.dp, vertical = 6.dp),
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
private fun MiniMetric(
    label: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(
                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.34f),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(horizontal = 7.dp, vertical = 5.dp),
        verticalArrangement = Arrangement.spacedBy(1.dp)
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
            fontWeight = FontWeight.Black,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
private fun CompactDmrSummary(
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
        ?: "No caller"
    val slot = session?.lastInboundSlot?.toString()
        ?: provider?.timeSlot
        ?: profile.timeSlot
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.08f),
                shape = RoundedCornerShape(10.dp)
            )
            .padding(7.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        MiniMetric(label = "TG", value = target.removePrefix("TG "), modifier = Modifier.weight(0.9f))
        MiniMetric(label = "CC", value = profile.colorCode, modifier = Modifier.weight(0.58f))
        MiniMetric(label = "SLOT", value = slot, modifier = Modifier.weight(0.58f))
        Column(modifier = Modifier.weight(1.25f)) {
            Text(
                text = "CALLER",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = source,
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Black,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
private fun CompactAllStarSummary(provider: ProviderProfile?) {
    val localNode = provider?.stationId?.ifBlank { "Local" } ?: "Local"
    val remoteNode = provider?.target?.ifBlank { "Remote" } ?: "Remote"
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.08f),
                shape = RoundedCornerShape(10.dp)
            )
            .padding(7.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        MiniMetric(label = "LOCAL", value = localNode, modifier = Modifier.weight(1f))
        MiniMetric(label = "REMOTE", value = remoteNode, modifier = Modifier.weight(1f))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = "CALLER",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = provider?.callsign?.ifBlank { provider.username.ifBlank { "OpenRadio" } } ?: "OpenRadio",
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Black,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
private fun CompactRfStatusRail(
    state: AppUiState,
    modifier: Modifier = Modifier
) {
    val profile = state.comjot.profile
    val comjot = state.comjot
    val liveLabel = when {
        comjot.pttActive -> "TX"
        comjot.isProgrammed -> "RX"
        else -> "IDLE"
    }
    val liveLevel = when {
        comjot.pttActive -> 7
        comjot.isProgrammed -> 4
        else -> 2
    }
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.24f),
                shape = RoundedCornerShape(12.dp)
            )
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.14f),
                shape = RoundedCornerShape(12.dp)
            )
            .padding(horizontal = 9.dp, vertical = 7.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            MiniMetric(
                label = "SQL",
                value = profile.squelch.ifBlank { "-" },
                modifier = Modifier.weight(0.6f)
            )
            MiniMetric(
                label = "VOL",
                value = profile.volume.ifBlank { "-" },
                modifier = Modifier.weight(0.6f)
            )
            MiniMetric(
                label = "MIC",
                value = profile.micGain.ifBlank { "-" },
                modifier = Modifier.weight(0.6f)
            )
            MiniMetric(
                label = "CORE",
                value = if (state.radioHardwareAvailable) "CJ-1" else "NET",
                modifier = Modifier.weight(0.8f)
            )
        }
        CompactSignalMeter(
            label = "RF METER",
            value = liveLabel,
            bars = liveLevel,
            active = comjot.pttActive || comjot.isProgrammed,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = comjot.statusMessage.ifBlank { "Radio ready" },
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
private fun CompactRoipStatusRail(
    state: AppUiState,
    server: String,
    operation: String,
    modifier: Modifier = Modifier
) {
    val session = state.activeSession
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.24f),
                shape = RoundedCornerShape(12.dp)
            )
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.14f),
                shape = RoundedCornerShape(12.dp)
            )
            .padding(horizontal = 9.dp, vertical = 7.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            MiniMetric(
                label = "MODE",
                value = operation,
                modifier = Modifier.weight(1f)
            )
            MiniMetric(
                label = "RX",
                value = (session?.inboundDmrFrames ?: 0).toString(),
                modifier = Modifier.weight(0.6f)
            )
            MiniMetric(
                label = "VOICE",
                value = (session?.inboundDmrVoiceFrames ?: 0).toString(),
                modifier = Modifier.weight(0.7f)
            )
        }
        CompactCallerDetails(
            session = session,
            lookup = state.callerLookup,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = session?.statusMessage ?: server,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
private fun CompactCallerDetails(
    session: SessionSnapshot?,
    lookup: CallerLookup?,
    modifier: Modifier = Modifier
) {
    val uriHandler = LocalUriHandler.current
    val callsign = session?.lastInboundCallsign?.normalizedCallsign()
    val sourceId = session?.lastInboundSourceId?.let { "ID $it" }
    val callerLabel = callsign ?: sourceId ?: "No caller"
    val matchingLookup = lookup?.takeIf { it.callsign == callsign }
    val callerName = matchingLookup?.name ?: session?.lastInboundName
    val callerLocation = matchingLookup?.location ?: session?.lastInboundLocation
    val lookupStatus = when {
        matchingLookup?.loading == true -> "Looking up callsign"
        matchingLookup?.error != null -> matchingLookup.error
        matchingLookup != null -> listOfNotNull(
            matchingLookup.status?.replaceFirstChar { it.uppercase() },
            matchingLookup.licenseClass?.let { "Class $it" },
            matchingLookup.expires?.let { "Exp $it" }
        ).joinToString(" / ")

        callsign != null -> "Lookup queued"
        else -> session?.lastInboundFrameType ?: "Waiting for metadata"
    }.orEmpty()
    val qrzUrl = callsign?.qrzLookupUrl()
    val qthUrl = callsign?.qthLookupUrl()
    val fccUrl = matchingLookup?.fccUrl ?: callsign?.let { FCC_AMATEUR_SEARCH_URL }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.background.copy(alpha = 0.30f),
                shape = RoundedCornerShape(10.dp)
            )
            .padding(horizontal = 9.dp, vertical = 7.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "CALLER",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = matchingLookup?.source ?: if (callsign != null) "Lookup" else "Standby",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        Text(
            text = callerLabel,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Black,
            color = if (callsign != null) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = listOfNotNull(callerName, callerLocation)
                .joinToString(" / ")
                .ifBlank { lookupStatus },
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        if (lookupStatus.isNotBlank() && (callerName != null || callerLocation != null)) {
            Text(
                text = lookupStatus,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            CallerLookupButton(
                label = "QRZ",
                enabled = qrzUrl != null,
                modifier = Modifier.weight(1f),
                onClick = { qrzUrl?.let(uriHandler::openUri) }
            )
            CallerLookupButton(
                label = "QTH",
                enabled = qthUrl != null,
                modifier = Modifier.weight(1f),
                onClick = { qthUrl?.let(uriHandler::openUri) }
            )
            CallerLookupButton(
                label = "FCC",
                enabled = fccUrl != null,
                modifier = Modifier.weight(1f),
                onClick = { fccUrl?.let(uriHandler::openUri) }
            )
        }
    }
}

@Composable
private fun CallerLookupButton(
    label: String,
    enabled: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .height(30.dp)
            .background(
                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = if (enabled) 0.44f else 0.18f),
                shape = RoundedCornerShape(8.dp)
            )
            .border(
                width = 1.dp,
                color = if (enabled) {
                    MaterialTheme.colorScheme.primary.copy(alpha = 0.34f)
                } else {
                    MaterialTheme.colorScheme.outline.copy(alpha = 0.16f)
                },
                shape = RoundedCornerShape(8.dp)
            )
            .radioClickable(enabled = enabled, onClick = onClick)
            .padding(horizontal = 6.dp, vertical = 4.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            color = if (enabled) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.55f),
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
private fun CompactSignalMeter(
    label: String,
    value: String,
    bars: Int,
    active: Boolean,
    modifier: Modifier = Modifier
) {
    val activeBars = bars.coerceIn(0, 8)
    Column(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 28.dp)
            .background(
                color = MaterialTheme.colorScheme.background.copy(alpha = 0.30f),
                shape = RoundedCornerShape(10.dp)
            )
            .padding(horizontal = 8.dp, vertical = 6.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = label,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = value,
                style = MaterialTheme.typography.labelLarge,
                color = if (active) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant,
                fontWeight = FontWeight.Black,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        val litColor = MaterialTheme.colorScheme.primary.copy(alpha = if (active) 0.92f else 0.46f)
        val unlitColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.20f)
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(24.dp)
                .padding(top = 4.dp)
        ) {
            val gap = 4.dp.toPx()
            val barWidth = ((size.width - gap * 7f) / 8f).coerceAtLeast(1f)
            val minBarHeight = 7.dp.toPx()
            val barStep = 2.dp.toPx()
            val radius = CornerRadius(4.dp.toPx(), 4.dp.toPx())
            repeat(8) { index ->
                val height = (minBarHeight + index * barStep).coerceAtMost(size.height)
                val left = index * (barWidth + gap)
                drawRoundRect(
                    color = if (index < activeBars) litColor else unlitColor,
                    topLeft = Offset(left, size.height - height),
                    size = androidx.compose.ui.geometry.Size(barWidth, height),
                    cornerRadius = radius
                )
            }
        }
    }
}

private const val FCC_AMATEUR_SEARCH_URL = "https://wireless2.fcc.gov/UlsApp/UlsSearch/searchAmateur.jsp"

@Composable
private fun PrimaryActionButton(
    label: String,
    enabled: Boolean,
    secondaryLabel: String?,
    height: androidx.compose.ui.unit.Dp = 50.dp,
    onClick: () -> Unit
) {
    if (secondaryLabel == null) {
        RadioActionButton(
            label = label,
            enabled = enabled,
            filled = false,
            height = height,
            modifier = Modifier.fillMaxWidth(),
            onClick = onClick
        )
    } else {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            RadioActionButton(
                label = label,
                enabled = enabled,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                filled = false,
                height = height,
                onClick = onClick
            )
            RadioActionButton(
                label = secondaryLabel,
                enabled = false,
                modifier = Modifier
                    .weight(0.55f)
                    .fillMaxWidth(),
                filled = false,
                height = height,
                onClick = {}
            )
        }
    }
}

@Composable
private fun RadioQuickControls(
    state: AppUiState,
    provider: ProviderProfile?,
    layout: AppLayoutMetrics,
    onFieldChanged: (ComjotField, String) -> Unit,
    onProviderFieldChanged: (String, ProviderField, String) -> Unit,
    onRoipOperationModeChanged: (String) -> Unit,
    onRoipProviderSelected: (String) -> Unit,
    onSendAllStarDtmf: (String) -> Unit
) {
    val profile = state.comjot.profile
    val isAllStar = provider?.type?.providerId == ALLSTAR_PROVIDER_ID
    if (profile.mode == ComjotMode.ROIP) {
        val compact = layout.compact
        val showHotspotControls = state.radioHardwareAvailable
        val showRfSetup = showHotspotControls && state.roipOperationMode == RoipOperationMode.HOTSPOT
        Column(verticalArrangement = Arrangement.spacedBy(if (compact) 6.dp else 8.dp)) {
            if (compact) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    RoipProviderButton(
                        providers = state.roipProviderProfiles(),
                        selectedProvider = provider,
                        height = layout.compactSoftKeyHeight,
                        onSelected = { onRoipProviderSelected(it.type.providerId) },
                        modifier = Modifier.weight(1f)
                    )
                    DmrMenuButton(
                        state = state,
                        provider = provider,
                        height = layout.compactSoftKeyHeight,
                        onFieldChanged = onFieldChanged,
                        onProviderFieldChanged = onProviderFieldChanged,
                        modifier = Modifier.weight(1f)
                    )
                    if (showHotspotControls) {
                        RoipOperationModeButton(
                            selected = state.roipOperationMode,
                            height = layout.compactSoftKeyHeight,
                            onSelected = { onRoipOperationModeChanged(it.name) },
                            modifier = Modifier.weight(1f)
                        )
                    }
                    if (isAllStar) {
                        DtmfMenuButton(
                            height = layout.compactSoftKeyHeight,
                            onSend = onSendAllStarDtmf,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            } else {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    RoipProviderButton(
                        providers = state.roipProviderProfiles(),
                        selectedProvider = provider,
                        onSelected = { onRoipProviderSelected(it.type.providerId) },
                        modifier = Modifier.weight(1.1f)
                    )
                    DmrMenuButton(
                        state = state,
                        provider = provider,
                        onFieldChanged = onFieldChanged,
                        onProviderFieldChanged = onProviderFieldChanged,
                        modifier = Modifier.weight(1f)
                    )
                    if (showHotspotControls) {
                        RoipOperationModeButton(
                            selected = state.roipOperationMode,
                            onSelected = { onRoipOperationModeChanged(it.name) },
                            modifier = Modifier.weight(0.9f)
                        )
                    }
                }
            }

            if ((!compact && isAllStar) || showRfSetup) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    if (isAllStar && !compact) {
                        DtmfMenuButton(
                            height = layout.compactSoftKeyHeight,
                            onSend = onSendAllStarDtmf,
                            modifier = Modifier.weight(1f)
                        )
                    }
                    if (showRfSetup) {
                        HotspotRfMenuButton(
                            state = state,
                            provider = provider,
                            height = layout.compactSoftKeyHeight,
                            onFieldChanged = onFieldChanged,
                            onProviderFieldChanged = onProviderFieldChanged,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }
        }
        return
    }

    val compact = layout.compact
    when (profile.mode) {
        ComjotMode.FM,
        ComjotMode.SCANNER -> {
            if (compact) {
                Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                    FrequencyMenuButton(
                        profile = profile,
                        txEnabled = profile.mode.isTxEnabled(state.comjot.developerMode),
                        height = layout.compactSoftKeyHeight,
                        onFieldChanged = onFieldChanged,
                        modifier = Modifier.weight(1f)
                    )
                    ToneMenuButton(
                        profile = profile,
                        txEnabled = profile.mode.isTxEnabled(state.comjot.developerMode),
                        height = layout.compactSoftKeyHeight,
                        onFieldChanged = onFieldChanged,
                        modifier = Modifier.weight(1f)
                    )
                    RfCompactMenuButton(
                        profile = profile,
                        height = layout.compactSoftKeyHeight,
                        onFieldChanged = onFieldChanged,
                        modifier = Modifier.weight(1f)
                    )
                }
            } else {
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
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
            }
        }

        ComjotMode.DMR -> {
            if (compact) {
                Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                    FrequencyMenuButton(
                        profile = profile,
                        txEnabled = true,
                        height = layout.compactSoftKeyHeight,
                        onFieldChanged = onFieldChanged,
                        modifier = Modifier.weight(1f)
                    )
                    DmrMenuButton(
                        state = state,
                        provider = provider,
                        height = layout.compactSoftKeyHeight,
                        onFieldChanged = onFieldChanged,
                        onProviderFieldChanged = onProviderFieldChanged,
                        modifier = Modifier.weight(1f)
                    )
                    RfCompactMenuButton(
                        profile = profile,
                        height = layout.compactSoftKeyHeight,
                        onFieldChanged = onFieldChanged,
                        modifier = Modifier.weight(1f)
                    )
                }
            } else {
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
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
            }
        }

        ComjotMode.ROIP -> Unit
    }
}

@Composable
private fun FrequencyMenuButton(
    profile: com.roip.mobile.data.ComjotProfile,
    txEnabled: Boolean,
    onFieldChanged: (ComjotField, String) -> Unit,
    modifier: Modifier = Modifier,
    height: androidx.compose.ui.unit.Dp = 44.dp
) {
    var expanded by remember { mutableStateOf(false) }
    Box(modifier = modifier) {
        RadioMenuButton(
            text = "FREQ",
            onClick = { expanded = true },
            height = height,
            modifier = Modifier.fillMaxWidth()
        )
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            Column(
                modifier = Modifier
                    .widthIn(min = 290.dp, max = 360.dp)
                    .padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                LabeledInput(
                    label = "RX MHz",
                    value = profile.rxFrequency,
                    onValueChange = { onFieldChanged(ComjotField.RX_FREQUENCY, it) },
                    keyboardType = KeyboardType.Decimal
                )
                if (txEnabled && profile.mode != ComjotMode.SCANNER) {
                    LabeledInput(
                        label = "TX MHz",
                        value = profile.txFrequency,
                        onValueChange = { onFieldChanged(ComjotField.TX_FREQUENCY, it) },
                        keyboardType = KeyboardType.Decimal
                    )
                }
            }
        }
    }
}

@Composable
private fun RfCompactMenuButton(
    profile: com.roip.mobile.data.ComjotProfile,
    onFieldChanged: (ComjotField, String) -> Unit,
    modifier: Modifier = Modifier,
    height: androidx.compose.ui.unit.Dp = 44.dp
) {
    var expanded by remember { mutableStateOf(false) }
    Box(modifier = modifier) {
        RadioMenuButton(
            text = "RF",
            onClick = { expanded = true },
            height = height,
            modifier = Modifier.fillMaxWidth()
        )
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            Column(
                modifier = Modifier
                    .widthIn(min = 290.dp, max = 360.dp)
                    .padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                SelectorRow(
                    label = "Bandwidth",
                    options = ComjotBandwidth.entries,
                    selected = profile.bandwidth,
                    title = { it.title },
                    onSelected = { onFieldChanged(ComjotField.BANDWIDTH, it.name) }
                )
                SelectorRow(
                    label = "Power",
                    options = ComjotRfPower.entries,
                    selected = profile.rfPower,
                    title = { it.title },
                    onSelected = { onFieldChanged(ComjotField.RF_POWER, it.name) }
                )
            }
        }
    }
}

@Composable
private fun DtmfMenuButton(
    onSend: (String) -> Unit,
    modifier: Modifier = Modifier,
    height: androidx.compose.ui.unit.Dp = 44.dp
) {
    var expanded by remember { mutableStateOf(false) }
    var command by remember { mutableStateOf("") }
    Box(modifier = modifier) {
        RadioMenuButton(
            text = "DTMF",
            onClick = { expanded = true },
            height = height,
            modifier = Modifier.fillMaxWidth()
        )
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
    modifier: Modifier = Modifier,
    height: androidx.compose.ui.unit.Dp = 44.dp
) {
    var expanded by remember { mutableStateOf(false) }
    val profile = state.comjot.profile
    val isAllStar = provider?.type?.providerId == ALLSTAR_PROVIDER_ID
    Box(modifier = modifier) {
        RadioMenuButton(
            text = "RF Setup",
            onClick = { expanded = true },
            height = height,
            modifier = Modifier.fillMaxWidth()
        )
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
    modifier: Modifier = Modifier,
    height: androidx.compose.ui.unit.Dp = 44.dp
) {
    var expanded by remember { mutableStateOf(false) }
    Box(modifier = modifier) {
        RadioMenuButton(
            text = selectedProvider?.type?.title ?: "Provider",
            onClick = { expanded = true },
            enabled = providers.isNotEmpty(),
            height = height,
            modifier = Modifier.fillMaxWidth()
        )
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
    modifier: Modifier = Modifier,
    height: androidx.compose.ui.unit.Dp = 44.dp
) {
    var expanded by remember { mutableStateOf(false) }
    Box(modifier = modifier) {
        RadioMenuButton(
            text = "Tone",
            onClick = { expanded = true },
            height = height,
            modifier = Modifier.fillMaxWidth()
        )
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
    modifier: Modifier = Modifier,
    height: androidx.compose.ui.unit.Dp = 44.dp
) {
    var expanded by remember { mutableStateOf(false) }
    val profile = state.comjot.profile
    val roipMode = profile.mode == ComjotMode.ROIP
    val allStarMode = roipMode && provider?.type?.providerId == ALLSTAR_PROVIDER_ID
    Box(modifier = modifier) {
        RadioMenuButton(
            text = when {
                allStarMode -> "Nodes"
                roipMode -> "Talkgroup"
                else -> "CC / Slot"
            },
            onClick = { expanded = true },
            height = height,
            modifier = Modifier.fillMaxWidth()
        )
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
    modifier: Modifier = Modifier,
    height: androidx.compose.ui.unit.Dp = 44.dp
) {
    var expanded by remember { mutableStateOf(false) }
    Box(modifier = modifier) {
        RadioMenuButton(
            text = selected.title,
            onClick = { expanded = true },
            height = height,
            modifier = Modifier.fillMaxWidth()
        )
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
    modifier: Modifier = Modifier,
    height: androidx.compose.ui.unit.Dp = 44.dp
) {
    var expanded by remember { mutableStateOf(false) }
    Box(modifier = modifier) {
        RadioMenuButton(
            text = "Power ${selected.title}",
            onClick = { expanded = true },
            height = height,
            modifier = Modifier.fillMaxWidth()
        )
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
    modifier: Modifier = Modifier,
    height: androidx.compose.ui.unit.Dp = 44.dp
) {
    var expanded by remember { mutableStateOf(false) }
    Box(modifier = modifier) {
        RadioMenuButton(
            text = when (selected) {
                RoipOperationMode.DIRECT -> "Direct"
                RoipOperationMode.HOTSPOT -> "Hotspot"
            },
            onClick = { expanded = true },
            height = height,
            modifier = Modifier.fillMaxWidth()
        )
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
    val selectedProviderIsAllStar = selectedProvider.type.providerId == ALLSTAR_PROVIDER_ID

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
            label = if (selectedProviderIsAllStar) "Server override (blank = node lookup)" else "Server",
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
                    label = if (selectedProviderIsAllStar) "Node password" else "Password",
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

    RadioGlassPanel(
        shape = RoundedCornerShape(18.dp),
        padding = PaddingValues(14.dp),
        borderAlpha = 0.34f
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "MEMORY BANK",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Black
                )
                Text(
                    text = "${state.memories.size} saved channels",
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
            RadioActionButton(
                label = "SAVE",
                enabled = true,
                filled = false,
                modifier = Modifier.width(86.dp),
                onClick = {
                    onSaveMemory(memoryName, selectedType)
                    memoryName = ""
                }
            )
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
        RadioMenuButton(
            text = "CALL",
            modifier = Modifier.width(62.dp),
            onClick = onRecall
        )
        RadioMenuButton(
            text = "DEL",
            modifier = Modifier.width(56.dp),
            onClick = onDelete
        )
    }
}

@Composable
private fun HoldToTalkButton(
    enabled: Boolean,
    active: Boolean,
    busy: Boolean,
    height: androidx.compose.ui.unit.Dp,
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

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
            .background(
                color = buttonColor,
                shape = RoundedCornerShape(18.dp)
            )
            .border(
                width = 2.dp,
                color = when {
                    active -> MaterialTheme.colorScheme.error.copy(alpha = 0.75f)
                    enabled -> MaterialTheme.colorScheme.primary.copy(alpha = 0.66f)
                    else -> MaterialTheme.colorScheme.outline.copy(alpha = 0.24f)
                },
                shape = RoundedCornerShape(18.dp)
            )
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
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = when {
                    active -> "TRANSMITTING"
                    busy -> "COMMANDING"
                    else -> "HOLD TO TALK"
                },
                style = MaterialTheme.typography.titleLarge.copy(
                    fontSize = 22.sp,
                    letterSpacing = 0.sp
                ),
                color = textColor,
                fontWeight = FontWeight.Black
            )
            Text(
                text = if (enabled) "Press and hold" else disabledText,
                style = MaterialTheme.typography.bodyMedium,
                color = textColor
            )
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
    onHardwareButtonMappingChanged: (String, String) -> Unit,
    onProviderFieldChanged: (String, ProviderField, String) -> Unit,
    onScanBrandmeisterQr: (String) -> Unit,
    onCheckForUpdates: () -> Unit,
    onVersionTapped: () -> Unit
) {
    val comjot = state.comjot
    val profile = comjot.profile
    val hotspot = state.hotspot

    RadioGlassPanel(
        shape = RoundedCornerShape(18.dp),
        padding = PaddingValues(14.dp),
        borderAlpha = 0.34f
    ) {
            Text(
                text = "RADIO CORE",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Black
            )
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
            HardwareButtonMapper(
                knobControlMode = state.knobControlMode,
                mappings = state.hardwareButtonMappings,
                onKnobControlChanged = { onKnobControlChanged(it.name) },
                onMappingChanged = { input, action ->
                    onHardwareButtonMappingChanged(input.name, action.name)
                }
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
                RadioMenuButton(
                    text = "GPS",
                    modifier = Modifier.width(86.dp),
                    onClick = onUseDeviceLocation
                )
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
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioMenuButton(
                    text = if (state.updateInProgress) "CHECKING..." else "CHECK UPDATES",
                    enabled = !state.updateInProgress,
                    modifier = Modifier.weight(0.62f),
                    onClick = onCheckForUpdates
                )
                Text(
                    text = state.updateStatus ?: "GitHub releases: ${BuildConfig.GITHUB_OWNER}/${BuildConfig.GITHUB_REPO}",
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
    }
}

@Composable
private fun HardwareButtonMapper(
    knobControlMode: KnobControlMode,
    mappings: Map<HardwareButtonInput, HardwareButtonAction>,
    onKnobControlChanged: (KnobControlMode) -> Unit,
    onMappingChanged: (HardwareButtonInput, HardwareButtonAction) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    val mappedCount = mappings.count { it.value != HardwareButtonAction.DEFAULT }
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .radioClickable { expanded = !expanded }
                .padding(vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "Button mapper", style = MaterialTheme.typography.titleSmall)
                Text(
                    text = if (mappedCount == 0) "Default hardware controls" else "$mappedCount custom mapping${if (mappedCount == 1) "" else "s"}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            RadioMenuButton(
                text = if (expanded) "HIDE" else "EDIT",
                modifier = Modifier.width(72.dp),
                onClick = { expanded = !expanded }
            )
        }
        if (expanded) {
            SelectorRow(
                label = "Knob",
                options = KnobControlMode.entries,
                selected = knobControlMode,
                title = { it.title },
                onSelected = onKnobControlChanged
            )
            HardwareButtonInput.entries.forEach { input ->
                val selectedAction = mappings[input] ?: HardwareButtonAction.DEFAULT
                HardwareButtonMappingRow(
                    input = input,
                    selectedAction = selectedAction,
                    onSelected = { action -> onMappingChanged(input, action) }
                )
            }
        }
    }
}

@Composable
private fun HardwareButtonMappingRow(
    input: HardwareButtonInput,
    selectedAction: HardwareButtonAction,
    onSelected: (HardwareButtonAction) -> Unit
) {
    var expanded by remember(input) { mutableStateOf(false) }
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Column(modifier = Modifier.weight(0.42f)) {
            Text(
                text = input.title,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = selectedAction.description,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        Box(modifier = Modifier.weight(0.58f)) {
            RadioMenuButton(
                text = selectedAction.title,
                onClick = { expanded = true },
                modifier = Modifier.fillMaxWidth()
            )
            DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                HardwareButtonAction.entries.forEach { action ->
                    DropdownMenuItem(
                        text = {
                            Column {
                                Text(action.title, fontWeight = FontWeight.SemiBold)
                                Text(
                                    text = action.description,
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                                    maxLines = 2,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        },
                        onClick = {
                            onSelected(action)
                            expanded = false
                        }
                    )
                }
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
                .radioClickable { expanded = !expanded }
                .padding(vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(text = profile.type.title, style = MaterialTheme.typography.titleSmall)
                Text(
                    text = profile.roipServerLabel(),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            RadioMenuButton(
                text = if (expanded) "HIDE" else "EDIT",
                modifier = Modifier.width(72.dp),
                onClick = { expanded = !expanded }
            )
        }
        if (expanded) {
            val usingAutoNodeLookup = isAllStar && profile.usesAutoAllStarLookup()
            if (isAllStar && !usingAutoNodeLookup) {
                LabeledInput(
                    label = "IAX username override",
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
                label = if (isAllStar) "IAX context override" else "ROIP Slot",
                value = profile.timeSlot,
                onValueChange = { onFieldChanged(ProviderField.TIME_SLOT, it) },
                keyboardType = if (isAllStar) KeyboardType.Text else KeyboardType.Number
            )
            LabeledInput(
                label = if (isAllStar) "Server override (blank = node lookup)" else "Server",
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
                        label = if (isAllStar) "Node password" else "Password",
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
        RadioMenuButton(
            text = "SCAN QR",
            onClick = onScanQr,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
private fun VersionBadge(onVersionTapped: () -> Unit) {
    Box(
        modifier = Modifier
            .border(1.dp, MaterialTheme.colorScheme.outline, CircleShape)
            .radioClickable(onClick = onVersionTapped)
            .padding(horizontal = 12.dp, vertical = 8.dp)
    ) {
        Text(
            text = BuildConfig.VERSION_NAME,
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
            RadioMenuButton(
                text = displayCode,
                onClick = { expanded = true },
                enabled = selectedMode.needsCode,
                modifier = Modifier.width(120.dp)
            )
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
                RadioActionButton(
                    label = title(option),
                    enabled = true,
                    filled = option == selected,
                    modifier = Modifier.weight(1f),
                    onClick = { onSelected(option) }
                )
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
    RadioGlassPanel(
        shape = RoundedCornerShape(14.dp),
        padding = PaddingValues(14.dp),
        borderAlpha = 0.28f
    ) {
        Text(
            text = message,
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
    RadioGlassPanel(
        shape = RoundedCornerShape(18.dp),
        padding = PaddingValues(14.dp),
        borderAlpha = 0.30f
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
                RadioActionButton(
                    label = if (session.pttActive) "RELEASE" else "PTT",
                    enabled = !isBusy && session.phase in listOf("connected", "transmitting"),
                    filled = true,
                    modifier = Modifier.weight(1f),
                    onClick = onTogglePtt
                )
                RadioActionButton(
                    label = "DISCONNECT",
                    enabled = !isBusy,
                    filled = false,
                    modifier = Modifier.weight(1f),
                    onClick = onDisconnect
                )
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
                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.16f),
                shape = RoundedCornerShape(999.dp)
            )
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.28f),
                shape = RoundedCornerShape(999.dp)
            )
            .padding(horizontal = 10.dp, vertical = 6.dp)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold
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

private fun ProviderProfile.roipServerLabel(): String {
    if (type.providerId == ALLSTAR_PROVIDER_ID && usesAutoAllStarLookup()) {
        val remoteNode = target.filter { it.isDigit() }
        return if (remoteNode.isBlank()) {
            "Auto node lookup"
        } else {
            "Auto lookup node $remoteNode"
        }
    }
    return serverHost.ifBlank { "No server" }
}

private fun ProviderProfile.usesAutoAllStarLookup(): Boolean {
    if (type.providerId != ALLSTAR_PROVIDER_ID) {
        return false
    }
    return serverHost.isAutoAllStarHost()
}

private fun String.isAutoAllStarHost(): Boolean {
    val normalized = trim().lowercase()
    return normalized.isBlank() ||
        normalized == "auto" ||
        normalized == "allstar.example.net" ||
        normalized == "nodes.allstarlink.org"
}

private const val ALLSTAR_PROVIDER_ID = "allstar"
private val ROIP_PROVIDER_IDS = setOf("brandmeister", "tgif", "freedmr", ALLSTAR_PROVIDER_ID)
