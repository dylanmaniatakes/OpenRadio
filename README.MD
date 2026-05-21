# OpenRadio

OpenRadio is a friendly, open radio app for Android.

The project started with one simple goal: crack open the ComJot CJ1 and make it truly open source, the way many of us felt it should have been from the beginning. The CJ1 is an Android handheld with real RF and DMR hardware inside, and OpenRadio began as a way to understand that radio module, document it, and give operators control without a locked-down subscription app.

The project has grown into something bigger: a Swiss Army knife for turning Android devices into bridges for amateur radio.

On any Android phone or tablet, OpenRadio can work as a ROIP client for network radio. On the CJ1, it can also control the built-in VHF/UHF FM and DMR radio hardware. As more radio hardware is mapped and tested, the goal is to support more Android radio devices too.

## What It Does

OpenRadio is meant to be useful to normal radio operators, not just developers.

- Runs on ordinary Android phones for ROIP use.
- Supports the ComJot CJ1 radio module for RF and DMR operation.
- Connects to AllStarLink directly from the app, with no separate hardware bridge required for normal phone-side operation.
- Supports BrandMeister/DMR ROIP operation.
- Can bridge Android audio to radio networks.
- Can use CJ1 radio hardware as an AllStar or DMR hotspot when radio hardware is present.
- Supports FM, DMR, ROIP, scanner/SDR-style workflows, memories, PTT, DTMF, and hardware button mapping.
- Keeps settings on-device so a configured phone can behave more like a dedicated smart radio.

## Device Support

### Any Android Device

Any supported Android device can use OpenRadio for network radio features:

- AllStarLink ROIP
- DMR ROIP
- Phone microphone and speaker audio
- PTT from the touchscreen or mapped hardware buttons
- Memories for common nodes, talkgroups, and favorites

This is the best mode for a normal phone that does not have built-in RF hardware, Or people who cant put antennas and radios up where they live.
### ComJot CJ1

On the CJ1, OpenRadio can also use the internal radio hardware:

- VHF/UHF FM
- DMR
- RF power settings
- Frequency and memory control
- Scanner/SDR-style receive workflows
- Hotspot-style bridging between RF and ROIP

The CJ1 is the first target because it is the device that started the project.

### More Radios

More Android radio models are planned as their hardware interfaces are documented and tested.

## ROIP And Hotspot Modes

OpenRadio is designed to reduce the pile of boxes normally needed for digital and linked radio.

For AllStar, the app includes its own phone-side AllStar/ROIP backend logic. That means you do not need a separate ASL server or hardware bridge just to connect out from the phone. Put in your node information, connect, and use the Android device as the radio interface.

When radio hardware is available, OpenRadio can also act like a hotspot:

- AllStar hotspot mode can bridge RF audio to and from AllStar.
- DMR hotspot mode is intended to bridge a local DMR radio to DMR networks.
- The CJ1 can be used as the RF side of that bridge.

Hotspot features are actively being developed and tested, so expect rapid improvement.

## Installing A Release APK

Most users do not need Android Studio or developer tools.

If someone shares a release APK with you:

1. Download the APK to your Android device.
2. Open it from your Downloads app or file manager.
3. If Android asks, allow installs from that source.
4. Install OpenRadio.
5. Open the app and grant microphone permission when asked.
6. For ROIP use, enter your provider settings and connect.
7. For CJ1 RF/DMR use, connect the CJ1 radio module and program the radio profile from the app.

If Android warns you that the app was not installed from the Play Store, that is normal for a shared test APK.

## Basic Setup

### AllStar

You will generally need:

- Callsign
- Local node number
- Node password
- Remote node number

OpenRadio can connect directly from the Android device, so a separate AllStar server is not required for normal outgoing use.

### DMR ROIP

You will generally need:

- Callsign
- DMR ID or hotspot ID
- Talkgroup
- Server/master
- Hotspot security password
- BrandMeister API key if you want the app to manage static talkgroup setup

### CJ1 RF Or DMR

You will generally set:

- RX frequency
- TX frequency
- FM tone settings or DMR color code/slot
- RF power
- Mic gain
- Radio volume

The app keeps these settings and lets you save common configurations as memories.

## Safety And Radio Rules

OpenRadio is amateur radio software. You are responsible for using it legally:

- Transmit only where you are licensed.
- Use correct frequencies, tones, color codes, slots, and power levels.
- Follow your local band plan and repeater rules.
- Be careful with hotspot and gateway modes so you do not accidentally bridge audio somewhere unintended.

## Project Status

OpenRadio is moving fast. Some parts are usable now, while others are experimental.

Working or in active testing:

- Android ROIP interface
- AllStar direct connection
- DMR/BrandMeister ROIP
- CJ1 RF and DMR control
- PTT and audio routing
- Memories
- Hardware button mapping
- Scanner/SDR-style UI work
- AllStar and DMR hotspot experiments with radio hardware

Expect rough edges, especially around new hardware, hotspot behavior, and radio-specific quirks.

## Building From Source

Most end users should install a release APK. Developers can build the app from source:

```bash
git clone https://github.com/DylanManiatakes/OpenRadio.git
cd OpenRadio/Android
./gradlew :app:assembleDebug
```

The debug APK will be created under:

```text
Android/app/build/outputs/apk/debug/
```

You can also open the `Android` folder in Android Studio and run the `app` module.

## Documentation

- RF serial notes: [RF_Cheat Sheet.MD](RF_Cheat%20Sheet.MD)
- ComJot CJ1 API document: [CJ1_API.pdf](CJ1_API.pdf)
- Android architecture notes: [Android/docs/architecture.md](Android/docs/architecture.md)
- Unified Radios mapping notes: [Android/docs/unified-radios-roip-map.md](Android/docs/unified-radios-roip-map.md)

## Contributing

Help is welcome.

Useful contributions include:

- Testing on different Android phones
- Testing on CJ1 hardware
- Testing AllStar and DMR networks
- Mapping other Android radio devices
- Improving the UI for real operators
- Writing plain-language documentation
- Fixing bugs

If you find something that does not work, include the device model, Android version, mode used, and what you were trying to do.

## Name

Going forward, the project is titled **OpenRadio**.

The name reflects the goal: open tools, open documentation, and operator-owned control for Android-based amateur radio.

## License

This project is licensed under the [MIT License](LICENSE).

[Support the project on Ko-fi](https://ko-fi.com/W7W41QWZNC)
