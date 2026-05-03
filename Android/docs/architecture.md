# Architecture Notes

## Overview

This repository is structured around a split between:

- Android client: ComJoT CJ-1 serial control, RF mode selection, operator setup, provider presets, session lifecycle, and PTT controls.
- Bridge API: provider validation, session orchestration, and future media bridge execution.

The project title going forward is OpenRadio. Its core goal is to make the CJ-1 radio module understandable and open-source friendly, while keeping network-specific bridge logic in a clean place to run protocol workers in Docker behind a reverse proxy.

## Supported Provider Families

### DMR talkgroup providers

Current presets:

- BrandMeister
- TGIF
- FreeDMR

Shared behavior:

- Callsign identifies the operator.
- A hotspot or station ID identifies the client instance.
- A talkgroup identifies the destination.
- A password or security secret authenticates the session.
- A master host and port identify the server entry point.

The backend models these as `dmr` family providers because the control flow is similar even when the individual network policy differs.

### AllStar

AllStar is modeled separately because it behaves more like a node-linking system than a talkgroup switch.

Inputs we keep in the MVP:

- Callsign
- Local station or node identifier
- Remote node target
- IAX host and port
- Password or login secret

### ComJoT CJ-1 local RF module

The `OpenRadio` research folder shows two related but separate systems:

- UnifiedRadios' ROIP screen wraps a native DMR bridge (`libdmr_native_lib`) that opens DMR master sockets, subscribes talkgroups, handles audio callbacks, and maps PTT to native `startTransmission` / `stopTransmission` calls.
- The CJ-1 RF module itself is controlled by a serial packet protocol. Commands start with `0x68`, end with `0x10`, and include command IDs such as `0x22` for DMR channel programming, `0x23` for analog FM channel programming, `0x26` for PTT start/stop, and `0x36` for unsolicited RX/TX events.

This app keeps those concerns separate. The existing provider cards still describe internet ROIP sessions through the backend bridge API. The ComJoT card is a local USB serial control surface that can program DMR, VHF/UHF FM, and scanner RX profiles. Scanner mode uses the analog command path, mirrors TX to RX for the packet shape, disables app-level PTT, opens monitor audio, and intentionally skips the app-side VHF/UHF transmit band guard.

Implementation details captured from OpenRadio / UnifiedRadios:

- USB device IDs declared by UnifiedRadios are mirrored in `res/xml/device_filter.xml`: CP210x `4292:60000` and `9114:33041`.
- UnifiedRadios opens the CJ-1 control serial path at 57600 baud on-device, while the OpenRadio cheat sheet mentions USB-UART at 115200 baud. The app exposes baud as a field and defaults to 115200 for USB use.
- On a CJ-1 handset, the RF module control path is `/dev/ttyS1` at 57600 baud. The Android controller now tries USB serial first for bench adapters, then falls back to this internal UART path.
- UnifiedRadios packet parsing treats length as two big-endian bytes and verifies a 16-bit internet checksum over the full frame with checksum bytes zeroed. The app's packet builder follows that observed behavior.
- Analog FM supports bandwidth, squelch, RX/TX PL, and RX/TX DCS/R-DCS using the `0x23` payload fields `rx_type`, `rx_subcode`, `tx_type`, and `tx_subcode`.

## Control Plane vs Media Plane

### Control plane that exists now

- Provider presets and validation.
- Session creation and teardown.
- PTT state changes.
- Pollable session state for Android.
- Local CJ-1 DMR and analog FM profile packet generation, scanner RX tuning, and USB serial write path.

### Media plane that still needs implementation

DMR worker responsibilities:

- Connect to the chosen master server using the selected DMR protocol variant.
- Encode and decode voice frames.
- Manage jitter buffering and packet timing.
- Route transmit audio only while PTT is active.
- Track talkgroup attachment and timeout behavior.

AllStar worker responsibilities:

- Register or authenticate as an IAX endpoint.
- Establish the audio path to the selected remote node.
- Drive link, unlink, and state updates.
- Map PTT semantics to the media session.

## Suggested Production Direction

### Backend

- Keep the session API as the stable contract.
- Replace the simulated adapters with worker processes or child containers.
- Store credentials in environment-backed secrets or a vault.
- Add websocket or server-sent event streaming once we introduce live media state and meters.

### Android

- Persist profiles with DataStore or encrypted storage.
- Add audio routing and microphone permission handling.
- Switch the PTT button from tap-to-toggle to press-and-hold.
- Add a persistent CJ-1 read loop for `0x36` RX/TX events and visible RSSI/version telemetry.
- Add talkgroup history and last-heard telemetry once the backend exposes it.

## Reverse Proxy

The backend is intentionally HTTP-first so you can place it behind Nginx, Caddy, Traefik, or another reverse proxy. Once media workers are real, the reverse proxy will likely only front the control API while UDP-heavy provider traffic stays internal to the Docker network or host networking layer.
