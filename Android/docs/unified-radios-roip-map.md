# Unified Radios ROIP Map

This map tracks what Unified Radios did for DMR ROIP and how OpenRadio is replacing it with open code.

## Current Unified Radios Surface

Source path:

- `openradio/UnifiedRadios/URBase/sources/com/unified/ur1/rfmodule/ROIP/DMRBridge.java`
- Native libraries under `openradio/UnifiedRadios/URBase/resources/lib/arm64-v8a/`

The Java class is primarily a JNI wrapper around `libdmr_native_lib.so`, with DroidStar-related symbols in the native library. The important public/native surface is:

- Connection: `connectWithSockets(host, port, dmrId, rptId, callsign, password)`, `disconnectSockets()`, `isSocketConnected()`, `waitForConnection(ms)`.
- Homebrew control: `sendRPTLPacket(...)`, `setNetworkType(...)`, `sendFreeDMRTalkgroupOptions(...)`, `subscribeTalkgroup(...)`, `resubscribeTalkgroup(...)`.
- DMR setup: `setTalkgroup(tg)`, `setTimeSlot(slot)`, `setColorCode(cc)`, `setAutoKeyupTalkgroup(tg)`.
- Audio/runtime: `initializeDMR()`, `initializeAudio(48000, 1)`, `processQtEvents()`, `writeAudioData(...)`.
- PTT: `startTransmission()`, `startTransmissionToTalkgroup(tg)`, `stopTransmission()`, `stopCurrentCall()`.
- Callbacks: `onConnectionStatusChanged`, `onTransmissionStatusChanged`, `onCallStarted`, `onCallEnded`, `onDMRPacketReceived`, buffer underrun callbacks.

Strings in the native library show MMDVM/Homebrew handling for `RPTL`, `RPTACK`, `RPTA`, `MSTNAK`, `MSTCL`, `RPTPING`, and `MSTPONG`, plus DroidStar vocoder/audio integration.

## OpenRadio Replacement

OpenRadio should not depend on the closed `libdmr_native_lib.so` if the goal is a clean open-source CJ-1 stack.

Implemented open pieces:

- `DirectDmrRoipController.kt`: Android-side Homebrew/MMDVM control link.
- `ComjotAudioBridge.kt`: CJ-1 serial audio path for RF audio.
- `ComjotRadioController.kt`: CJ-1 RF module programming/control path.

Still needed:

- DMR media worker that converts microphone/CJ-1 audio into network DMR voice frames and decodes inbound DMR frames.
- AMBE/vocoder strategy. This must be open-source-compatible; the Unified binary can be used as behavior reference only, not as the long-term OpenRadio implementation.
- Callback bridge from DMR network events into Compose UI state.
- Talkgroup subscription/options support matching BrandMeister/TGIF/FreeDMR behavior.

## Migration Plan

1. Keep the relay as an optional debug tool only.
2. Make app ROIP connect direct for DMR providers.
3. Port Homebrew control packets in Kotlin first: login, auth, config, ping, close.
4. Add a DMR media abstraction in Android:
   - `connect(config)`
   - `startTransmit(target)`
   - `writePcm/audioFrame`
   - `stopTransmit()`
   - `onInboundAudio`
   - `disconnect()`
5. Replace Unified native behavior with open protocol/media modules piece by piece.

The current pivot completes step 2 and the control portion of step 3.
