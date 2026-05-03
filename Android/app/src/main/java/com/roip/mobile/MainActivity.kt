package com.roip.mobile

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.KeyEvent
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.roip.mobile.ui.RoipApp

class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()
    private var hardwarePttDown = false
    private var lastKnobEventAt = 0L
    private var lastKnobSignature = ""

    private val hardwareControlReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val action = intent.action ?: return
            when (action) {
                ACTION_PTT_DOWN,
                ACTION_PTT_KEY_DOWN,
                ACTION_INTERPHONE_PTT_DOWN,
                ACTION_VIDEO_DOWN -> handleHardwarePtt(pressed = true, source = action)

                ACTION_PTT_UP,
                ACTION_PTT_KEY_UP,
                ACTION_INTERPHONE_PTT_UP,
                ACTION_VIDEO_UP -> handleHardwarePtt(pressed = false, source = action)

                ACTION_KNOB_TIMER,
                ACTION_KNOB_CHANNEL -> handleKnobRotation(intent, action)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerHardwarePttReceiver()
        setContent {
            RoipApp(viewModel)
        }
    }

    override fun dispatchKeyEvent(event: KeyEvent): Boolean {
        if (event.isKnobVolumeKey()) {
            if (event.action == KeyEvent.ACTION_DOWN && event.repeatCount == 0) {
                val direction = if (event.keyCode == KeyEvent.KEYCODE_VOLUME_UP) 1 else -1
                viewModel.handleKnobRotation(
                    context = this,
                    direction = direction,
                    steps = 1,
                    source = KeyEvent.keyCodeToString(event.keyCode)
                )
            }
            return true
        }

        if (event.isHardwarePttKey()) {
            when (event.action) {
                KeyEvent.ACTION_DOWN -> {
                    if (event.repeatCount == 0) {
                        handleHardwarePtt(
                            pressed = true,
                            source = KeyEvent.keyCodeToString(event.keyCode)
                        )
                    }
                    return true
                }

                KeyEvent.ACTION_UP -> {
                    handleHardwarePtt(
                        pressed = false,
                        source = KeyEvent.keyCodeToString(event.keyCode)
                    )
                    return true
                }
            }
        }
        return super.dispatchKeyEvent(event)
    }

    override fun onDestroy() {
        runCatching {
            unregisterReceiver(hardwareControlReceiver)
        }
        if (hardwarePttDown) {
            viewModel.handleHardwarePtt(this, pressed = false, source = "activity-destroy")
            hardwarePttDown = false
        }
        super.onDestroy()
    }

    private fun registerHardwarePttReceiver() {
        val filter = IntentFilter().apply {
            addAction(ACTION_PTT_DOWN)
            addAction(ACTION_PTT_UP)
            addAction(ACTION_PTT_KEY_DOWN)
            addAction(ACTION_PTT_KEY_UP)
            addAction(ACTION_INTERPHONE_PTT_DOWN)
            addAction(ACTION_INTERPHONE_PTT_UP)
            addAction(ACTION_VIDEO_DOWN)
            addAction(ACTION_VIDEO_UP)
            addAction(ACTION_KNOB_TIMER)
            addAction(ACTION_KNOB_CHANNEL)
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            registerReceiver(hardwareControlReceiver, filter, RECEIVER_EXPORTED)
        } else {
            @Suppress("DEPRECATION")
            registerReceiver(hardwareControlReceiver, filter)
        }
    }

    private fun handleHardwarePtt(pressed: Boolean, source: String) {
        if (hardwarePttDown == pressed) {
            return
        }

        hardwarePttDown = pressed
        Log.i(TAG, "Hardware PTT ${if (pressed) "down" else "up"} from $source")
        viewModel.handleHardwarePtt(this, pressed, source)
    }

    private fun handleKnobRotation(intent: Intent, source: String) {
        val directionFromExtra = readFirstKnobExtra(intent, KNOB_DIRECTION_KEYS)
        val direction = directionFromExtra ?: 1
        val steps = readFirstKnobExtra(intent, KNOB_STEP_KEYS)?.takeIf { it != 0 } ?: 1
        val signature = "$source:$direction:$steps"
        val now = SystemClock.elapsedRealtime()
        if (signature == lastKnobSignature && now - lastKnobEventAt < KNOB_DUPLICATE_WINDOW_MS) {
            return
        }
        lastKnobSignature = signature
        lastKnobEventAt = now

        Log.i(KNOB_TAG, "Knob rotation source=$source direction=$direction steps=$steps extras=${intent.describeExtras()}")
        viewModel.handleKnobRotation(
            context = this,
            direction = direction,
            steps = steps,
            source = source
        )
    }

    private fun readFirstKnobExtra(intent: Intent, keys: List<String>): Int? {
        val extras = intent.extras ?: return null
        for (key in keys) {
            if (!extras.containsKey(key)) {
                continue
            }
            val value = extras.knobValue(key).toKnobIntOrNull()
            if (key == "timer" && value == 0) {
                continue
            }
            return value
        }
        return null
    }

    private fun Intent.describeExtras(): String {
        val extras = extras ?: return "none"
        return extras.keySet().joinToString(prefix = "{", postfix = "}") { key ->
            "$key=${extras.knobValue(key)}"
        }
    }

    @Suppress("DEPRECATION")
    private fun Bundle.knobValue(key: String): Any? {
        return get(key)
    }

    private fun Any?.toKnobIntOrNull(): Int? {
        return when (this) {
            is Int -> this
            is Long -> this.toInt()
            is Short -> this.toInt()
            is Byte -> this.toInt()
            is Float -> this.toInt()
            is Double -> this.toInt()
            is Boolean -> if (this) 1 else -1
            is String -> when (lowercase()) {
                "up", "right", "cw", "clockwise", "+", "plus", "raise", "higher" -> 1
                "down", "left", "ccw", "counterclockwise", "counter-clockwise", "-", "minus", "lower" -> -1
                else -> toIntOrNull()
            }
            else -> null
        }
    }

    private fun KeyEvent.isHardwarePttKey(): Boolean {
        return keyCode in HARDWARE_PTT_KEY_CODES
    }

    private fun KeyEvent.isKnobVolumeKey(): Boolean {
        return keyCode == KeyEvent.KEYCODE_VOLUME_UP || keyCode == KeyEvent.KEYCODE_VOLUME_DOWN
    }

    private companion object {
        private const val TAG = "OpenRadioPtt"
        private const val ACTION_PTT_DOWN = "android.intent.action.PTT.down"
        private const val ACTION_PTT_UP = "android.intent.action.PTT.up"
        private const val ACTION_PTT_KEY_DOWN = "com.android.ptt.key.down"
        private const val ACTION_PTT_KEY_UP = "com.android.ptt.key.up"
        private const val ACTION_INTERPHONE_PTT_DOWN = "com.interphone.ptt.down"
        private const val ACTION_INTERPHONE_PTT_UP = "com.interphone.ptt.up"
        private const val ACTION_VIDEO_DOWN = "android.intent.action.ACTION_VIDEO_DOWN"
        private const val ACTION_VIDEO_UP = "android.intent.action.ACTION_VIDEO_UP"
        private const val ACTION_KNOB_TIMER = "dmr.knob.TIMER"
        private const val ACTION_KNOB_CHANNEL = "com.android.knobkey.channel"
        private const val KEYCODE_PTT_COMPAT = 130
        private const val KNOB_TAG = "OpenRadioKnob"
        private const val KNOB_DUPLICATE_WINDOW_MS = 10L

        private val KNOB_DIRECTION_KEYS = listOf("direction", "rotation", "delta", "value", "step", "change", "timer")
        private val KNOB_STEP_KEYS = listOf("steps", "count", "amount")

        private val HARDWARE_PTT_KEY_CODES = setOf(
            KEYCODE_PTT_COMPAT,
            KeyEvent.KEYCODE_HEADSETHOOK,
            KeyEvent.KEYCODE_CAMERA,
            KeyEvent.KEYCODE_F1,
            KeyEvent.KEYCODE_F2,
            KeyEvent.KEYCODE_F3,
            KeyEvent.KEYCODE_F4,
            KeyEvent.KEYCODE_STEM_PRIMARY,
            KeyEvent.KEYCODE_BUTTON_L1,
            KeyEvent.KEYCODE_BUTTON_R1
        )
    }
}
