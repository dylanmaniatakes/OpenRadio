package com.roip.mobile.radio.roip

import android.util.Log
import com.roip.mobile.data.ComjotProfile
import com.roip.mobile.data.HotspotProfile
import com.roip.mobile.data.ProviderProfile
import com.roip.mobile.data.SessionSnapshot
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.HttpURLConnection
import java.net.InetAddress
import java.net.SocketException
import java.net.SocketTimeoutException
import java.net.URL
import java.net.URLEncoder
import java.security.MessageDigest
import java.util.UUID
import java.util.concurrent.atomic.AtomicInteger
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject

class DirectDmrRoipController(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    private val scope = CoroutineScope(SupervisorJob() + dispatcher)
    private val lock = Any()

    @Volatile
    private var socket: DatagramSocket? = null

    @Volatile
    private var remoteAddress: InetAddress? = null

    @Volatile
    private var remotePort: Int = 0

    @Volatile
    private var session: SessionSnapshot? = null

    @Volatile
    private var repeaterId: String = ""

    private var keepAliveJob: Job? = null
    private var mediaReceiveJob: Job? = null
    private var noTrafficWatchdogJob: Job? = null
    private var transmitContext: DmrTransmitContext? = null
    private val identityCache = mutableMapOf<Int, DmrIdentity?>()
    private val identityLookupsInFlight = mutableSetOf<Int>()
    private val audioPlayer = DmrNetworkAudioPlayer()
    private val audioTransmitter = DmrNetworkAudioTransmitter()

    @Volatile
    private var activeConfig: DirectDmrConfig? = null

    suspend fun connect(
        provider: ProviderProfile,
        radioProfile: ComjotProfile,
        hotspotProfile: HotspotProfile
    ): SessionSnapshot = withContext(dispatcher) {
        if (provider.type.providerId !in DMR_PROVIDER_IDS) {
            throw IllegalArgumentException("Direct Android ROIP currently supports DMR providers only")
        }

        disconnect()

        val config = DirectDmrConfig.from(provider, radioProfile, hotspotProfile)
        audioPlayer.reset()
        val nextSocket = DatagramSocket()
        nextSocket.soTimeout = SOCKET_TIMEOUT_MS
        val address = InetAddress.getByName(config.host)
        Log.i(TAG, "Opening direct DMR link host=${config.host}:${config.port} id=${config.repeaterId} target=${config.target} slot=${config.timeSlot}")

        synchronized(lock) {
            socket = nextSocket
            remoteAddress = address
            remotePort = config.port
            repeaterId = config.repeaterId
            activeConfig = config
            session = baseSession(config).copy(
                phase = "authorizing",
                statusMessage = "Opening direct DMR link to ${config.host}:${config.port}"
            )
        }

        runCatching {
            send(nextSocket, address, config.port, buildLoginPacket(config.repeaterId))
            val salt = readAuthChallenge(nextSocket, "authentication")

            updateSession("authorizing", "Authorizing DMR hotspot ${config.repeaterId}")
            send(nextSocket, address, config.port, buildAuthorizationPacket(config.repeaterId, salt, config.password))
            readAck(nextSocket, "authentication")
            Log.i(TAG, "BrandMeister authentication accepted for hotspot ${config.repeaterId}")

            updateSession("registering", "Sending CJ-1 hotspot profile")
            val configPacket = buildConfigPacket(config)
            Log.i(TAG, config.safeSummary(configPacket.size))
            send(nextSocket, address, config.port, configPacket)
            readAck(nextSocket, "hotspot profile")
            Log.i(TAG, "BrandMeister hotspot profile accepted for ${config.repeaterId}")
            runCatching {
                val versionPacket = buildProtocolVersionPacket(config.repeaterId)
                send(nextSocket, address, config.port, versionPacket)
                Log.i(TAG, "Sent Homebrew DMR protocol version len=${versionPacket.size} id=${config.repeaterId}")
            }.onFailure { error ->
                Log.w(TAG, "Could not send Homebrew DMR protocol version: ${error.message}")
            }

            val connected = updateSession(
                phase = "connected",
                message = "Connected directly to ${config.host} as hotspot ${config.repeaterId}. Activating TG ${config.target}."
            )
            startKeepAlive(config.repeaterId)
            startMediaReceiveLoop()
            startBrandmeisterTalkgroupActivation(config)
            snapshot() ?: connected
        }.getOrElse { error ->
            closeSocket(nextSocket)
            synchronized(lock) {
                socket = null
                remoteAddress = null
                remotePort = 0
                session = session?.copy(
                    phase = "disconnected",
                    statusMessage = error.message ?: "Direct ROIP connection failed",
                    pttActive = false
                )
            }
            throw error
        }
    }

    suspend fun disconnect(): SessionSnapshot? = withContext(dispatcher) {
        keepAliveJob?.cancel()
        keepAliveJob = null
        mediaReceiveJob?.cancel()
        mediaReceiveJob = null
        noTrafficWatchdogJob?.cancel()
        noTrafficWatchdogJob = null
        audioPlayer.stop()
        audioTransmitter.stop()
        transmitContext = null

        val currentSocket = socket
        val currentAddress = remoteAddress
        val currentPort = remotePort
        val currentRepeaterId = repeaterId

        if (currentSocket != null && currentAddress != null && currentPort > 0 && currentRepeaterId.isNotBlank()) {
            runCatching {
                send(currentSocket, currentAddress, currentPort, buildClosePacket(currentRepeaterId))
            }
        }

        currentSocket?.let(::closeSocket)

        synchronized(lock) {
            socket = null
            remoteAddress = null
            remotePort = 0
            repeaterId = ""
            activeConfig = null
            session = session?.copy(
                phase = "disconnected",
                statusMessage = "Direct ROIP session stopped",
                pttActive = false
            )
            session
        }
    }

    fun shutdown() {
        keepAliveJob?.cancel()
        keepAliveJob = null
        mediaReceiveJob?.cancel()
        mediaReceiveJob = null
        noTrafficWatchdogJob?.cancel()
        noTrafficWatchdogJob = null
        audioPlayer.stop()
        audioTransmitter.stop()
        transmitContext = null
        socket?.let(::closeSocket)
        synchronized(lock) {
            socket = null
            remoteAddress = null
            remotePort = 0
            repeaterId = ""
            activeConfig = null
            session = session?.copy(
                phase = "disconnected",
                statusMessage = "Direct ROIP controller stopped",
                pttActive = false
            )
        }
    }

    fun snapshot(): SessionSnapshot? = synchronized(lock) {
        session
    }

    suspend fun setPtt(pressed: Boolean): SessionSnapshot = withContext(dispatcher) {
        if (session?.phase != "connected" && session?.phase != "transmitting") {
            throw IllegalStateException("Direct ROIP is not connected")
        }

        if (pressed) {
            startTransmit()
        } else {
            stopTransmit()
        }

        snapshot() ?: updateSession("connected", "Direct ROIP connected", pttActive = false)
    }

    private fun startTransmit() {
        if (audioTransmitter.snapshot().running) {
            updateSession("transmitting", "ROIP PTT active: ${audioTransmitter.snapshot().status()}", pttActive = true)
            return
        }

        val config = activeConfig ?: throw IllegalStateException("Direct ROIP session profile is not available")
        val currentSocket = socket ?: throw IllegalStateException("Direct ROIP socket is not active")
        val currentAddress = remoteAddress ?: throw IllegalStateException("Direct ROIP server address is not active")
        val currentPort = remotePort.takeIf { it > 0 } ?: throw IllegalStateException("Direct ROIP server port is not active")
        val talkgroup = config.target.toIntOrNull()?.takeIf { it > 0 }
            ?: throw IllegalStateException("${config.providerName} target must be a numeric talkgroup before PTT")
        val sourceId = config.keyupSourceId()
        val streamId = ((System.nanoTime() xor talkgroup.toLong()) and 0xffffffffL)
            .takeIf { it != 0L }
            ?: 1L
        val context = DmrTransmitContext(
            config = config,
            talkgroup = talkgroup,
            sourceId = sourceId,
            streamId = streamId
        )
        transmitContext = context
        audioTransmitter.reset()
        audioPlayer.stop()

        Log.i(TAG, "Starting ROIP DMR TX target=$talkgroup source=$sourceId repeater=${config.repeaterId} slot=${config.timeSlot} stream=$streamId")
        send(
            currentSocket,
            currentAddress,
            currentPort,
            buildDmrKeyUpFrame(
                config = config,
                talkgroup = talkgroup,
                sourceId = sourceId,
                streamId = streamId,
                sequence = 0,
                flags = config.dmrDataFlags(0x01),
                payload = DmrLinkControlEncoder.voiceHeaderPayload(sourceId, talkgroup, config.colorCode)
            )
        )

        audioTransmitter.start(
            onVoiceFrame = { voiceFrameIndex, ambeFrames, _ ->
                val currentContext = transmitContext ?: return@start
                val sequence = currentContext.sequence.incrementAndGet() and 0xff
                val flags = if (voiceFrameIndex % DMR_VOICE_SYNC_INTERVAL == 0) {
                    config.dmrVoiceSyncFlags()
                } else {
                    config.dmrVoiceFlags(voiceFrameIndex)
                }
                runCatching {
                    send(
                        currentSocket,
                        currentAddress,
                        currentPort,
                        buildDmrKeyUpFrame(
                            config = config,
                            talkgroup = talkgroup,
                            sourceId = sourceId,
                            streamId = streamId,
                            sequence = sequence,
                            flags = flags,
                            payload = DmrLinkControlEncoder.voicePayload(voiceFrameIndex, ambeFrames)
                        )
                    )
                    val txAudio = audioTransmitter.markVoiceFrameSent()
                    if (txAudio.sentVoiceFrames <= 3L || txAudio.sentVoiceFrames % TX_LOG_INTERVAL == 0L) {
                        updateSession(
                            phase = "transmitting",
                            message = "ROIP PTT active to TG $talkgroup on slot ${config.timeSlot}. ${txAudio.status()}",
                            pttActive = true
                        )
                        Log.i(TAG, "Sent ROIP DMR TX frame target=$talkgroup slot=${config.timeSlot} stream=$streamId sequence=$sequence ${txAudio.status()}")
                    }
                }.onFailure { error ->
                    val message = error.message ?: "ROIP TX packet send failed"
                    Log.w(TAG, message, error)
                    updateSession("connected", message, pttActive = false)
                    audioTransmitter.stop()
                }
            },
            onStopped = { txAudio ->
                if (transmitContext != null && session?.pttActive == true) {
                    updateSession(
                        phase = "connected",
                        message = txAudio.lastError?.let { "ROIP TX stopped: $it" }
                            ?: "ROIP PTT released after ${txAudio.sentVoiceFrames} DMR voice frames",
                        pttActive = false
                    )
                }
            }
        )

        updateSession("transmitting", "ROIP PTT active: sending microphone audio to TG $talkgroup", pttActive = true)
    }

    private fun stopTransmit() {
        val context = transmitContext
        audioTransmitter.stop()
        transmitContext = null

        if (context != null) {
            val currentSocket = socket
            val currentAddress = remoteAddress
            val currentPort = remotePort
            if (currentSocket != null && currentAddress != null && currentPort > 0) {
                val sequence = context.sequence.incrementAndGet() and 0xff
                runCatching {
                    send(
                        currentSocket,
                        currentAddress,
                        currentPort,
                        buildDmrKeyUpFrame(
                            config = context.config,
                            talkgroup = context.talkgroup,
                            sourceId = context.sourceId,
                            streamId = context.streamId,
                            sequence = sequence,
                            flags = context.config.dmrDataFlags(0x02),
                            payload = DmrLinkControlEncoder.terminatorPayload(
                                context.sourceId,
                                context.talkgroup,
                                context.config.colorCode
                            )
                        )
                    )
                }.onFailure { error ->
                    Log.w(TAG, "Failed to send DMR TX terminator: ${error.message}", error)
                }
            }
            Log.i(TAG, "ROIP DMR TX released target=${context.talkgroup} stream=${context.streamId} frames=${audioTransmitter.snapshot().sentVoiceFrames}")
        }

        updateSession(
            phase = "connected",
            message = "ROIP PTT released. ${audioTransmitter.snapshot().status()}",
            pttActive = false
        )
    }

    private fun startKeepAlive(currentRepeaterId: String) {
        keepAliveJob?.cancel()
        keepAliveJob = scope.launch {
            while (isActive) {
                delay(KEEPALIVE_MS)
                val currentSocket = socket ?: break
                val currentAddress = remoteAddress ?: break
                val currentPort = remotePort
                if (currentPort <= 0) {
                    break
                }

                val keepAliveResult = runCatching {
                    send(currentSocket, currentAddress, currentPort, buildPingPacket(currentRepeaterId))
                }
                if (keepAliveResult.isFailure) {
                    val error = keepAliveResult.exceptionOrNull()
                    updateSession("disconnected", error?.message ?: "Direct DMR keepalive failed", pttActive = false)
                    closeSocket(currentSocket)
                    break
                }
            }
        }
    }

    private fun startMediaReceiveLoop() {
        mediaReceiveJob?.cancel()
        mediaReceiveJob = scope.launch {
            while (isActive) {
                val currentSocket = socket ?: break
                val packet = try {
                    receive(currentSocket)
                } catch (_: SocketTimeoutException) {
                    continue
                } catch (_: SocketException) {
                    break
                } catch (error: Exception) {
                    updateSession("disconnected", error.message ?: "Direct DMR receive worker failed", pttActive = false)
                    closeSocket(currentSocket)
                    break
                }

                handleMediaPacket(packet)
            }
        }
    }

    private fun handleMediaPacket(packet: ByteArray) {
        when {
            packet.startsWith("DMRD") -> handleDmrDataPacket(packet)
            packet.startsWith("MSTPONG") -> Log.d(TAG, "Received keepalive pong hex=${packet.hexSummary()}")
            packet.startsWith("MSTCL") -> {
                updateSession("disconnected", "BrandMeister closed the direct DMR session: ${packet.asciiPrefix()}", pttActive = false)
                socket?.let(::closeSocket)
            }
            packet.startsWith("MSTNAK") -> {
                updateSession("disconnected", "BrandMeister rejected the active DMR session: ${packet.asciiPrefix()} hex=${packet.hexSummary()}", pttActive = false)
                socket?.let(::closeSocket)
            }
            packet.startsWith("RPTACK") || packet.startsWith("MSTACK") || packet.startsWith("RPTA") -> {
                Log.d(TAG, "Received runtime ack len=${packet.size} prefix=${packet.asciiPrefix()} hex=${packet.hexSummary()}")
            }
            else -> Log.d(TAG, "Received runtime packet len=${packet.size} prefix=${packet.asciiPrefix()} hex=${packet.hexSummary()}")
        }
    }

    private fun handleDmrDataPacket(packet: ByteArray) {
        if (packet.size < DMRD_PACKET_BYTES) {
            Log.w(TAG, "Ignoring short DMRD packet len=${packet.size} hex=${packet.hexSummary()}")
            return
        }

        val frame = DmrFrameSummary.from(packet)
        val ambeFrames = if (frame.isVoicePayload) packet.extractDmrAmbeFrames() else emptyList()
        val isTransmitting = session?.pttActive == true
        if (ambeFrames.isNotEmpty() && !isTransmitting) {
            audioPlayer.enqueue(ambeFrames)
        }
        val audioState = audioPlayer.snapshot()
        val identity = synchronized(lock) { identityCache[frame.sourceId] }
        if (identity == null) {
            startIdentityLookup(frame.sourceId)
        }
        synchronized(lock) {
            val current = session ?: return
            val nextFrames = current.inboundDmrFrames + 1
            val newWarning = if (frame.isVoicePayload && !audioState.decoderAvailable) {
                "Inbound DMR audio is arriving, but the native AMBE vocoder is not packaged yet."
            } else {
                null
            }
            session = current.copy(
                statusMessage = frame.statusMessage(nextFrames, identity),
                warnings = if (newWarning == null || newWarning in current.warnings) current.warnings else current.warnings + newWarning,
                inboundDmrFrames = nextFrames,
                inboundDmrVoiceFrames = current.inboundDmrVoiceFrames + if (frame.isVoicePayload) 1 else 0,
                inboundDmrDataFrames = current.inboundDmrDataFrames + if (frame.isVoicePayload) 0 else 1,
                inboundAmbeFrames = current.inboundAmbeFrames + frame.ambeFrameCount,
                lastInboundDmrAtMillis = System.currentTimeMillis(),
                lastInboundSourceId = frame.sourceId,
                lastInboundCallsign = identity?.callsign,
                lastInboundName = identity?.displayName,
                lastInboundLocation = identity?.location,
                lastInboundTargetId = frame.targetId,
                lastInboundStreamId = frame.streamId,
                lastInboundSlot = frame.slot,
                lastInboundFrameType = frame.frameType,
                audioDecoderState = audioState.status(frame.ambeFrameCount)
            )
        }

        Log.i(TAG, "Received DMRD frame src=${frame.sourceId} dst=${frame.targetId} slot=${frame.slot} stream=${frame.streamId} frame=${frame.frameNumber} type=${frame.frameType} ambe=${frame.ambeFrameCount} flags=${frame.flags} count=${session?.inboundDmrFrames ?: 0}")
    }

    private fun startIdentityLookup(sourceId: Int) {
        if (sourceId <= 0) {
            return
        }
        synchronized(lock) {
            if (identityCache.containsKey(sourceId) || !identityLookupsInFlight.add(sourceId)) {
                return
            }
        }

        scope.launch {
            val identity = lookupDmrIdentity(sourceId)
            synchronized(lock) {
                identityCache[sourceId] = identity
                identityLookupsInFlight.remove(sourceId)
                val current = session ?: return@synchronized
                if (current.lastInboundSourceId == sourceId && identity != null) {
                    session = current.copy(
                        statusMessage = current.statusMessage.replace("ID $sourceId", identity.displayLabel),
                        lastInboundCallsign = identity.callsign,
                        lastInboundName = identity.displayName,
                        lastInboundLocation = identity.location
                    )
                }
            }
        }
    }

    private fun lookupDmrIdentity(sourceId: Int): DmrIdentity? {
        return runCatching {
            val encodedId = URLEncoder.encode(sourceId.toString(), "UTF-8")
            val connection = (URL("$RADIOID_USER_LOOKUP?id=$encodedId").openConnection() as HttpURLConnection)
            connection.requestMethod = "GET"
            connection.connectTimeout = API_TIMEOUT_MS
            connection.readTimeout = API_TIMEOUT_MS
            connection.setRequestProperty("accept", "application/json")
            connection.setRequestProperty("User-Agent", "OpenRadio-CJ1/0.1 radioid lookup")

            val code = connection.responseCode
            val response = connection.readResponseBody(code)
            connection.disconnect()
            if (code !in 200..299) {
                Log.w(TAG, "RadioID lookup failed id=$sourceId http=$code response=${response.compactLogLine()}")
                return@runCatching null
            }

            val first = JSONObject(response).optJSONArray("results")?.optJSONObject(0)
                ?: return@runCatching null
            DmrIdentity.from(sourceId, first).also { identity ->
                Log.i(TAG, "RadioID resolved id=$sourceId callsign=${identity.callsign}")
            }
        }.getOrElse { error ->
            Log.w(TAG, "RadioID lookup failed id=$sourceId: ${error.message}")
            null
        }
    }

    private fun startBrandmeisterTalkgroupActivation(config: DirectDmrConfig) {
        val talkgroup = config.target.toIntOrNull()
        if (talkgroup == null || talkgroup <= 0) {
            addSessionWarning("${config.providerName} target must be a numeric talkgroup before OpenRadio can activate RX traffic.")
            return
        }

        if (config.providerId != BRANDMEISTER_PROVIDER_ID) {
            addSessionWarning("${config.providerName} login is connected. OpenRadio is sending the Homebrew talkgroup subscription, but API activation is only mapped for BrandMeister right now.")
            startHomebrewTalkgroupSubscription(config, talkgroup)
            return
        }

        if (config.apiKey.isBlank()) {
            val warning = "TG $talkgroup is not API-activated. Add a BrandMeister API key here, set TG $talkgroup static in BrandMeister SelfCare, or briefly PTT from OpenRadio to link it."
            updateConnectedMessage("Connected to ${config.host}. Sending Homebrew TG $talkgroup subscription without BM API activation.")
            addSessionWarning(warning)
            Log.i(TAG, "BrandMeister API key missing; TG $talkgroup was not activated")
            startHomebrewTalkgroupSubscription(config, talkgroup)
            return
        }

        scope.launch {
            updateConnectedMessage("Connected to ${config.host}. Requesting BrandMeister TG $talkgroup on slot ${config.timeSlot}.")
            val result = activateBrandmeisterTalkgroup(config, talkgroup)
            if (result.success) {
                updateConnectedMessage("BrandMeister TG $talkgroup is active on slot ${config.timeSlot}. Sending Homebrew subscription.")
                sendHomebrewTalkgroupSubscription(config, talkgroup)
                startNoTrafficWatchdog(config, talkgroup)
                Log.i(TAG, result.message)
            } else {
                updateConnectedMessage("Connected to ${config.host}, but BrandMeister TG $talkgroup activation failed. Trying Homebrew subscription fallback.")
                addSessionWarning(result.message)
                Log.w(TAG, result.message)
                if (sendHomebrewTalkgroupSubscription(config, talkgroup)) {
                    startNoTrafficWatchdog(config, talkgroup)
                }
            }
        }
    }

    private fun startHomebrewTalkgroupSubscription(config: DirectDmrConfig, talkgroup: Int) {
        scope.launch {
            if (sendHomebrewTalkgroupSubscription(config, talkgroup)) {
                startNoTrafficWatchdog(config, talkgroup)
            }
        }
    }

    private suspend fun sendHomebrewTalkgroupSubscription(config: DirectDmrConfig, talkgroup: Int): Boolean {
        val currentSocket = socket
        val currentAddress = remoteAddress
        val currentPort = remotePort
        if (currentSocket == null || currentAddress == null || currentPort <= 0) {
            addSessionWarning("Cannot send Homebrew TG $talkgroup subscription because the direct DMR socket is not active.")
            return false
        }

        val options = homebrewTalkgroupOptions(config, talkgroup)
        return runCatching {
            val subscriptionPacket = buildTalkgroupSubscriptionPacket(config.repeaterId, talkgroup)
            Log.i(TAG, "Sending Homebrew TG subscription target=$talkgroup slot=${config.timeSlot} options=$options len=${subscriptionPacket.size}")
            send(currentSocket, currentAddress, currentPort, subscriptionPacket)
            delay(TALKGROUP_OPTIONS_DELAY_MS)

            val optionsPacket = buildTalkgroupOptionsPacket(config, talkgroup)
            send(currentSocket, currentAddress, currentPort, optionsPacket)
            sendDmrLinkKeyUp(currentSocket, currentAddress, currentPort, config, talkgroup)
            updateConnectedMessage("Homebrew TG $talkgroup subscription sent on slot ${config.timeSlot}. Waiting for DMR frames.")
            Log.i(TAG, "Homebrew TG subscription complete target=$talkgroup slot=${config.timeSlot} options=$options optionsLen=${optionsPacket.size}")
            true
        }.getOrElse { error ->
            val warning = "Homebrew TG $talkgroup subscription failed: ${error.message ?: error.javaClass.simpleName}"
            addSessionWarning(warning)
            Log.w(TAG, warning)
            false
        }
    }

    private suspend fun sendDmrLinkKeyUp(
        currentSocket: DatagramSocket,
        currentAddress: InetAddress,
        currentPort: Int,
        config: DirectDmrConfig,
        talkgroup: Int
    ) {
        val sourceId = config.keyupSourceId()
        val streamId = ((System.nanoTime() xor talkgroup.toLong()) and 0xffffffffL)
            .takeIf { it != 0L }
            ?: 1L
        val voiceFrames = (DMR_KEY_UP_DURATION_MS / DMR_VOICE_FRAME_MS).coerceAtLeast(1).toInt()
        val headerPayload = DmrLinkControlEncoder.voiceHeaderPayload(sourceId, talkgroup, config.colorCode)
        val terminatorPayload = DmrLinkControlEncoder.terminatorPayload(sourceId, talkgroup, config.colorCode)
        Log.i(TAG, "Sending DMR link key-up target=$talkgroup source=$sourceId repeater=${config.repeaterId} slot=${config.timeSlot} stream=$streamId frames=$voiceFrames")

        send(
            currentSocket,
            currentAddress,
            currentPort,
            buildDmrKeyUpFrame(config, talkgroup, sourceId, streamId, sequence = 0, flags = config.dmrDataFlags(0x01), payload = headerPayload)
        )

        repeat(voiceFrames) { index ->
            val sequence = (index + 1) and 0xff
            val flags = if (index % DMR_VOICE_SYNC_INTERVAL == 0) {
                config.dmrVoiceSyncFlags()
            } else {
                config.dmrVoiceFlags(index)
            }
            send(
                currentSocket,
                currentAddress,
                currentPort,
                buildDmrKeyUpFrame(config, talkgroup, sourceId, streamId, sequence, flags, DmrLinkControlEncoder.silenceVoicePayload(index))
            )
            delay(DMR_VOICE_FRAME_MS)
        }

        send(
            currentSocket,
            currentAddress,
            currentPort,
            buildDmrKeyUpFrame(config, talkgroup, sourceId, streamId, sequence = (voiceFrames + 1) and 0xff, flags = config.dmrDataFlags(0x02), payload = terminatorPayload)
        )
        Log.i(TAG, "DMR link key-up complete target=$talkgroup source=$sourceId stream=$streamId")
    }

    private fun startNoTrafficWatchdog(config: DirectDmrConfig, talkgroup: Int) {
        noTrafficWatchdogJob?.cancel()
        noTrafficWatchdogJob = scope.launch {
            delay(NO_TRAFFIC_WARNING_MS)
            val warning = "No DMRD frames received after activating TG $talkgroup on ROIP slot ${config.timeSlot}. If BrandMeister shows traffic, try the other ROIP slot or set TG $talkgroup static for hotspot ${config.repeaterId}."
            val warned = synchronized(lock) {
                val current = session ?: return@synchronized false
                val isConnected = current.phase == "connected" || current.phase == "transmitting"
                if (!isConnected || current.inboundDmrFrames > 0) {
                    false
                } else {
                    session = current.copy(
                        statusMessage = "Connected and TG $talkgroup is active on slot ${config.timeSlot}, but no DMR frames have arrived yet.",
                        warnings = if (warning in current.warnings) current.warnings else current.warnings + warning
                    )
                    true
                }
            }
            if (warned) {
                Log.w(TAG, "No DMRD frames after TG activation target=$talkgroup slot=${config.timeSlot} id=${config.repeaterId} host=${config.host}")
            }
        }
    }

    private fun updateConnectedMessage(message: String) {
        synchronized(lock) {
            val current = session ?: return
            if (current.phase == "connected" || current.phase == "transmitting") {
                session = current.copy(statusMessage = message)
            }
        }
    }

    private fun addSessionWarning(warning: String) {
        synchronized(lock) {
            val current = session ?: return
            if (warning !in current.warnings) {
                session = current.copy(warnings = current.warnings + warning)
            }
        }
    }

    private fun activateBrandmeisterTalkgroup(config: DirectDmrConfig, talkgroup: Int): BrandmeisterActivationResult {
        val attempts = config.brandmeisterApiDeviceIds.map { deviceId ->
            callBrandmeisterTalkgroupApi(config, deviceId, talkgroup)
        }
        val success = attempts.firstOrNull { it.success }
        if (success != null) {
            return BrandmeisterActivationResult(
                success = true,
                message = "BrandMeister API activated TG $talkgroup on slot ${config.timeSlot} using device ${success.deviceId}"
            )
        }

        val details = attempts.joinToString("; ") { attempt ->
            "${attempt.deviceId}: ${attempt.message}"
        }
        return BrandmeisterActivationResult(
            success = false,
            message = "BrandMeister API could not activate TG $talkgroup on slot ${config.timeSlot}. $details"
        )
    }

    private fun callBrandmeisterTalkgroupApi(
        config: DirectDmrConfig,
        deviceId: String,
        talkgroup: Int
    ): BrandmeisterActivationAttempt {
        return runCatching {
            val connection = (URL("$BRANDMEISTER_API_BASE/device/$deviceId/talkgroup").openConnection() as HttpURLConnection)
            connection.requestMethod = "POST"
            connection.doOutput = true
            connection.connectTimeout = API_TIMEOUT_MS
            connection.readTimeout = API_TIMEOUT_MS
            connection.setRequestProperty("accept", "application/json")
            connection.setRequestProperty("Authorization", "Bearer ${config.apiKey}")
            connection.setRequestProperty("Content-Type", "application/json")
            connection.setRequestProperty("X-CSRF-TOKEN", BRANDMEISTER_CSRF_TOKEN)

            val body = JSONObject()
                .put("slot", config.timeSlot)
                .put("group", talkgroup)
                .toString()

            connection.outputStream.use { output ->
                output.write(body.toByteArray(Charsets.UTF_8))
            }

            val code = connection.responseCode
            val response = connection.readResponseBody(code)
            connection.disconnect()
            Log.i(TAG, "BrandMeister API device=$deviceId tg=$talkgroup slot=${config.timeSlot} http=$code response=${response.compactLogLine()}")

            if (code == HTTP_OK) {
                val json = runCatching { JSONObject(response) }.getOrNull()
                val responseTalkgroup = json?.optInt("talkgroup", -1) ?: -1
                val responseSlot = json?.optInt("slot", -1) ?: -1
                val accepted = (responseTalkgroup == talkgroup && responseSlot == config.timeSlot) ||
                    response.isBlank()
                BrandmeisterActivationAttempt(
                    deviceId = deviceId,
                    success = accepted,
                    message = if (accepted) {
                        "HTTP 200"
                    } else {
                        "HTTP 200 but response did not confirm TG/slot: ${response.compactLogLine()}"
                    }
                )
            } else {
                BrandmeisterActivationAttempt(
                    deviceId = deviceId,
                    success = false,
                    message = "HTTP $code ${response.compactLogLine()}"
                )
            }
        }.getOrElse { error ->
            BrandmeisterActivationAttempt(
                deviceId = deviceId,
                success = false,
                message = error.message ?: error.javaClass.simpleName
            )
        }
    }

    private fun baseSession(config: DirectDmrConfig): SessionSnapshot {
        return SessionSnapshot(
            id = UUID.randomUUID().toString(),
            providerId = config.providerId,
            providerName = config.providerName,
            phase = "configuring",
            statusMessage = "Preparing direct DMR session",
            target = config.target,
            serverHost = config.host,
            transport = DIRECT_TRANSPORT,
            warnings = emptyList(),
            pttActive = false,
            requiresMediaBridge = !audioPlayer.snapshot().decoderAvailable
        )
    }

    private fun updateSession(
        phase: String,
        message: String,
        pttActive: Boolean = session?.pttActive ?: false
    ): SessionSnapshot {
        synchronized(lock) {
            val current = session ?: error("Direct ROIP session is not active")
            val updated = current.copy(
                phase = phase,
                statusMessage = message,
                pttActive = pttActive
            )
            session = updated
            return updated
        }
    }

    private fun readAuthChallenge(socket: DatagramSocket, stage: String): ByteArray {
        val packet = receive(socket)
        logPacket(stage, packet)
        if (packet.startsWith("MSTNAK")) {
            val message = "BrandMeister rejected direct DMR $stage. Check hotspot ID, callsign, and hotspot security password. Response: ${packet.asciiPrefix()} hex=${packet.hexSummary()}"
            Log.w(TAG, message)
            throw IllegalStateException(message)
        }
        if (!packet.startsWith("RPTACK") && !packet.startsWith("MSTACK") && !packet.startsWith("RPTA")) {
            throw IllegalStateException("Unexpected DMR $stage response: ${packet.asciiPrefix()}")
        }
        if (packet.size < 10) {
            throw IllegalStateException("BrandMeister sent an incomplete DMR auth challenge")
        }

        return packet.copyOfRange(packet.size - 4, packet.size)
    }

    private fun readAck(socket: DatagramSocket, stage: String) {
        val packet = receive(socket)
        logPacket(stage, packet)
        if (packet.startsWith("MSTNAK")) {
            val message = rejectionMessage(stage, packet)
            Log.w(TAG, message)
            throw IllegalStateException(message)
        }
        if (packet.startsWith("MSTCL")) {
            throw IllegalStateException("BrandMeister closed the direct DMR session during $stage: ${packet.asciiPrefix()}")
        }
        if (!packet.startsWith("RPTACK") && !packet.startsWith("MSTACK") && !packet.startsWith("RPTA")) {
            throw IllegalStateException("Unexpected DMR $stage response: ${packet.asciiPrefix()}")
        }
    }

    private fun logPacket(stage: String, packet: ByteArray) {
        Log.i(TAG, "Received $stage len=${packet.size} prefix=${packet.asciiPrefix()} hex=${packet.hexSummary()}")
    }

    private fun rejectionMessage(stage: String, packet: ByteArray): String {
        return if (stage == "hotspot profile") {
            "BrandMeister accepted the password, then rejected the hotspot profile. Check that callsign matches the Radio ID, the hotspot ID/ESSID exists in SelfCare, RX/TX are valid Hz or MHz, and Software ID/Package ID match an MMDVM-style hotspot. Response: ${packet.asciiPrefix()} hex=${packet.hexSummary()}"
        } else {
            "BrandMeister rejected direct DMR $stage. Response: ${packet.asciiPrefix()} hex=${packet.hexSummary()}"
        }
    }

    private fun receive(socket: DatagramSocket): ByteArray {
        val buffer = ByteArray(RECEIVE_BYTES)
        val packet = DatagramPacket(buffer, buffer.size)
        socket.receive(packet)
        return buffer.copyOf(packet.length)
    }

    private fun send(socket: DatagramSocket, address: InetAddress, port: Int, bytes: ByteArray) {
        socket.send(DatagramPacket(bytes, bytes.size, address, port))
    }

    private fun closeSocket(socket: DatagramSocket) {
        runCatching {
            socket.close()
        }
    }

    companion object {
        const val DIRECT_TRANSPORT = "android-dmr-direct"

        private val DMR_PROVIDER_IDS = setOf("brandmeister", "tgif", "freedmr")
        private const val BRANDMEISTER_PROVIDER_ID = "brandmeister"
        private const val BRANDMEISTER_API_BASE = "https://api.brandmeister.network/v2"
        private const val BRANDMEISTER_CSRF_TOKEN = "JlG3NiIZGNJMWXz511lPhjvHY8A0ONLRG806iAMH"
        private const val RADIOID_USER_LOOKUP = "https://radioid.net/api/dmr/user/"
        private const val HTTP_OK = 200
        private const val API_TIMEOUT_MS = 3_500
        private const val RECEIVE_BYTES = 512
        private const val SOCKET_TIMEOUT_MS = 12_000
        private const val KEEPALIVE_MS = 10_000L
        private const val NO_TRAFFIC_WARNING_MS = 45_000L
        private const val TALKGROUP_OPTIONS_DELAY_MS = 200L
        private const val DMR_KEY_UP_DURATION_MS = 1_000L
        private const val DMR_VOICE_FRAME_MS = 60L
        private const val DMR_VOICE_SYNC_INTERVAL = 6
        private const val TX_LOG_INTERVAL = 20L
        private const val DMRD_PACKET_BYTES = 55
        private const val TAG = "DirectDmr"
    }
}

private data class DmrTransmitContext(
    val config: DirectDmrConfig,
    val talkgroup: Int,
    val sourceId: Int,
    val streamId: Long,
    val sequence: AtomicInteger = AtomicInteger(0)
)

private data class DmrFrameSummary(
    val frameNumber: Int,
    val sourceId: Int,
    val targetId: Int,
    val slot: Int,
    val streamId: Long,
    val flags: Int,
    val frameType: String,
    val ambeFrameCount: Int
) {
    val isVoicePayload: Boolean
        get() = ambeFrameCount > 0

    fun statusMessage(frameCount: Int, identity: DmrIdentity?): String {
        val source = identity?.displayLabel ?: "ID $sourceId"
        return if (isVoicePayload) {
            "RX DMR voice: $source to TG $targetId on slot $slot. Frames $frameCount."
        } else {
            "RX DMR $frameType: $source to TG $targetId on slot $slot. Frames $frameCount."
        }
    }

    companion object {
        fun from(packet: ByteArray): DmrFrameSummary {
            val flags = packet[15].unsigned()
            val frameType = frameType(flags)
            return DmrFrameSummary(
                frameNumber = packet[4].unsigned(),
                sourceId = packet.uint24At(5),
                targetId = packet.uint24At(8),
                slot = if ((flags and 0x80) != 0) 2 else 1,
                streamId = packet.uint32At(16),
                flags = flags,
                frameType = frameType,
                ambeFrameCount = if (frameType == FRAME_TYPE_VOICE || frameType == FRAME_TYPE_VOICE_SYNC) {
                    packet.extractDmrAmbeFrames().size
                } else {
                    0
                }
            )
        }

        private fun frameType(flags: Int): String {
            return when {
                (flags and 0x20) != 0 -> when (flags and 0x0f) {
                    0x01 -> "Voice Header"
                    0x02 -> "End"
                    0x03 -> "CSBK"
                    0x06 -> "Data Header"
                    0x07 -> "Rate 1/2 Data"
                    0x08 -> "Rate 3/4 Data"
                    0x09 -> "Idle"
                    0x0a -> "Rate 1 Data"
                    else -> "Data"
                }
                (flags and 0x10) != 0 -> FRAME_TYPE_VOICE_SYNC
                else -> FRAME_TYPE_VOICE
            }
        }

        private const val FRAME_TYPE_VOICE = "Voice"
        private const val FRAME_TYPE_VOICE_SYNC = "Voice Sync"
    }
}

private data class DmrIdentity(
    val sourceId: Int,
    val callsign: String,
    val displayName: String?,
    val location: String?
) {
    val displayLabel: String
        get() = buildString {
            append(callsign.ifBlank { "ID $sourceId" })
            if (!displayName.isNullOrBlank()) {
                append(" ")
                append(displayName)
            }
        }

    companion object {
        fun from(sourceId: Int, json: JSONObject): DmrIdentity {
            val firstName = json.optString("fname").takeIf { it.isNotBlank() }
            val surname = json.optString("surname").takeIf { it.isNotBlank() }
            val name = json.optString("name").takeIf { it.isNotBlank() }
                ?: listOfNotNull(firstName, surname).joinToString(" ").takeIf { it.isNotBlank() }
            val location = listOf(
                json.optString("city"),
                json.optString("state"),
                json.optString("country")
            ).filter { it.isNotBlank() }.joinToString(", ").takeIf { it.isNotBlank() }

            return DmrIdentity(
                sourceId = sourceId,
                callsign = json.optString("callsign").takeIf { it.isNotBlank() } ?: "ID $sourceId",
                displayName = name,
                location = location
            )
        }
    }
}

private data class BrandmeisterActivationResult(
    val success: Boolean,
    val message: String
)

private data class BrandmeisterActivationAttempt(
    val deviceId: String,
    val success: Boolean,
    val message: String
)

private data class DirectDmrConfig(
    val providerId: String,
    val providerName: String,
    val callsign: String,
    val repeaterId: String,
    val target: String,
    val host: String,
    val port: Int,
    val password: String,
    val apiKey: String,
    val rxFrequency: Long,
    val txFrequency: Long,
    val colorCode: Int,
    val power: Int,
    val timeSlot: Int,
    val latitude: Double = 0.0,
    val longitude: Double = 0.0,
    val height: Int = 0,
    val location: String = "OpenRadio CJ1",
    val description: String = "CJ-1 OpenRadio",
    val slots: Char = '4',
    val url: String = "www.mmdvm.net",
    val softwareId: String = "20200922",
    val packageId: String = "MMDVM_MMDVM_HS_Hat"
) {
    val brandmeisterApiDeviceIds: List<String>
        get() = buildList {
            add(repeaterId)
            if (repeaterId.length > 7) {
                add(repeaterId.take(7))
            }
        }.distinct()

    fun safeSummary(packetSize: Int): String {
        return "Sending RPTC len=$packetSize id=$repeaterId call=$callsign rx=$rxFrequency tx=$txFrequency cc=$colorCode slot=$timeSlot slots=$slots softwareId=$softwareId packageId=$packageId"
    }

    companion object {
        fun from(
            provider: ProviderProfile,
            radioProfile: ComjotProfile,
            hotspotProfile: HotspotProfile
        ): DirectDmrConfig {
            val callsign = provider.callsign.trim().uppercase()
            val repeaterId = provider.stationId.trim()
            val slots = hotspotProfile.slotFlags.trim().firstOrNull()
                ?.takeIf { it in setOf('1', '2', '3', '4') }
                ?: '4'
            val rxFrequency = radioProfile.rxFrequency.toFrequencyHzOrNull()
                ?.takeIf { it.isSupportedDmrRfFrequency() }
                ?: DEFAULT_FREQUENCY_HZ
            val txFrequency = if (slots == '4') {
                rxFrequency
            } else {
                radioProfile.txFrequency.toFrequencyHzOrNull()
                    ?.takeIf { it.isSupportedDmrRfFrequency() }
                    ?: rxFrequency
            }

            require(callsign.isNotBlank()) {
                "ROIP callsign is required for the DMR hotspot profile"
            }
            require(repeaterId.all(Char::isDigit) && repeaterId.length in 6..9) {
                "DMR hotspot ID must be a 6-9 digit numeric ID. BrandMeister hotspots usually use your 7-digit Radio ID plus a 2-digit ESSID."
            }

            return DirectDmrConfig(
                providerId = provider.type.providerId,
                providerName = provider.type.title,
                callsign = callsign,
                repeaterId = repeaterId,
                target = provider.target.trim(),
                host = provider.serverHost.trim(),
                port = provider.serverPort.trim().toIntOrNull() ?: provider.type.defaultPort,
                password = provider.password,
                apiKey = provider.apiKey.trim(),
                rxFrequency = rxFrequency,
                txFrequency = txFrequency,
                colorCode = radioProfile.colorCode.toIntOrNull()?.coerceIn(0, 15) ?: 1,
                power = 1,
                timeSlot = provider.timeSlot.toIntOrNull()?.coerceIn(1, 2) ?: 2,
                latitude = hotspotProfile.latitude.trim().toDoubleOrNull() ?: 0.0,
                longitude = hotspotProfile.longitude.trim().toDoubleOrNull() ?: 0.0,
                height = 0,
                location = hotspotProfile.location.ifBlank { "OpenRadio CJ1" },
                description = hotspotProfile.description.ifBlank { "CJ-1 OpenRadio" },
                slots = slots,
                url = hotspotProfile.url.ifBlank { "www.mmdvm.net" },
                softwareId = hotspotProfile.software.ifBlank { "20200922" },
                packageId = hotspotProfile.packageId.ifBlank { "MMDVM_MMDVM_HS_Hat" }
            )
        }

        private const val DEFAULT_FREQUENCY_HZ = 438_800_000L
    }
}

private fun buildLoginPacket(repeaterId: String): ByteArray {
    return "RPTL".asciiBytes() + encodeRepeaterId(repeaterId)
}

private fun buildAuthorizationPacket(repeaterId: String, salt: ByteArray, password: String): ByteArray {
    val digest = MessageDigest.getInstance("SHA-256").digest(salt + password.toByteArray(Charsets.UTF_8))
    return "RPTK".asciiBytes() + encodeRepeaterId(repeaterId) + digest
}

private fun buildConfigPacket(config: DirectDmrConfig): ByteArray {
    val payload = buildString {
        append(config.callsign.fixed(8))
        append(config.rxFrequency.unsignedFixed(9))
        append(config.txFrequency.unsignedFixed(9))
        append(config.power.coerceIn(0, 99).unsignedFixed(2))
        append(config.colorCode.coerceIn(0, 15).unsignedFixed(2))
        append(String.format(java.util.Locale.US, "%.6f", config.latitude).zeroFixed(8))
        append(String.format(java.util.Locale.US, "%.6f", config.longitude).zeroFixed(9))
        append(config.height.coerceIn(0, 999).unsignedFixed(3))
        append(config.location.fixed(20))
        append(config.description.fixed(19))
        append(config.slots)
        append(config.url.fixed(124))
        append(config.softwareId.fixed(40))
        append(config.packageId.fixed(40))
    }

    return "RPTC".asciiBytes() + encodeRepeaterId(config.repeaterId) + payload.asciiBytes()
}

private fun buildProtocolVersionPacket(repeaterId: String): ByteArray {
    return "RPTV".asciiBytes() + encodeRepeaterId(repeaterId) + encodeUnsigned32(HOMEBREW_PROTOCOL_VERSION.toLong(), "Homebrew protocol version")
}

private fun buildTalkgroupSubscriptionPacket(repeaterId: String, talkgroup: Int): ByteArray {
    return "RPTS".asciiBytes() + encodeRepeaterId(repeaterId) + encodeUnsigned32(talkgroup.toLong(), "DMR talkgroup")
}

private fun buildTalkgroupOptionsPacket(config: DirectDmrConfig, talkgroup: Int): ByteArray {
    return "RPTO".asciiBytes() + encodeRepeaterId(config.repeaterId) + homebrewTalkgroupOptions(config, talkgroup).asciiBytes()
}

private fun buildDmrKeyUpFrame(
    config: DirectDmrConfig,
    talkgroup: Int,
    sourceId: Int,
    streamId: Long,
    sequence: Int,
    flags: Int,
    payload: ByteArray
): ByteArray {
    val bytes = ByteArray(55)
    "DMRD".asciiBytes().copyInto(bytes, 0)
    bytes[4] = sequence.toByte()
    encodeUInt24(sourceId.toLong(), "DMR source ID").copyInto(bytes, 5)
    encodeUInt24(talkgroup.toLong(), "DMR talkgroup").copyInto(bytes, 8)
    encodeRepeaterId(config.repeaterId).copyInto(bytes, 11)
    bytes[15] = flags.toByte()
    encodeUnsigned32(streamId, "DMR stream ID").copyInto(bytes, 16)
    payload.copyInto(bytes, 20, 0, payload.size.coerceAtMost(33))
    return bytes
}

private fun buildPingPacket(repeaterId: String): ByteArray {
    return "RPTPING".asciiBytes() + encodeRepeaterId(repeaterId)
}

private fun buildClosePacket(repeaterId: String): ByteArray {
    return "RPTCL".asciiBytes() + encodeRepeaterId(repeaterId)
}

private fun encodeRepeaterId(repeaterId: String): ByteArray {
    val numeric = repeaterId.toLongOrNull()
        ?: throw IllegalArgumentException("DMR hotspot ID must be numeric")
    return encodeUnsigned32(numeric, "DMR hotspot ID")
}

private fun encodeUnsigned32(value: Long, label: String): ByteArray {
    require(value in 0..0xffffffffL) {
        "$label must fit in an unsigned 32-bit value"
    }
    return byteArrayOf(
        ((value shr 24) and 0xff).toByte(),
        ((value shr 16) and 0xff).toByte(),
        ((value shr 8) and 0xff).toByte(),
        (value and 0xff).toByte()
    )
}

private fun encodeUInt24(value: Long, label: String): ByteArray {
    require(value in 0..0xffffffL) {
        "$label must fit in an unsigned 24-bit value"
    }
    return byteArrayOf(
        ((value shr 16) and 0xff).toByte(),
        ((value shr 8) and 0xff).toByte(),
        (value and 0xff).toByte()
    )
}

private fun homebrewTalkgroupOptions(config: DirectDmrConfig, talkgroup: Int): String {
    return if (config.providerId == "brandmeister") {
        talkgroup.toString()
    } else {
        "TS2=$talkgroup;"
    }
}

private fun DirectDmrConfig.keyupSourceId(): Int {
    val baseId = if (repeaterId.length > 7) repeaterId.take(7) else repeaterId
    val parsedBase = baseId.toIntOrNull()
    if (parsedBase != null && parsedBase in 1..0xffffff) {
        return parsedBase
    }

    val parsedRepeater = repeaterId.toLongOrNull() ?: 1L
    return (parsedRepeater and 0xffffffL).toInt().coerceAtLeast(1)
}

private fun DirectDmrConfig.dmrDataFlags(dataType: Int): Int {
    return dmrSlotFlag() or 0x20 or (dataType and 0x0f)
}

private fun DirectDmrConfig.dmrVoiceFlags(index: Int): Int {
    return dmrSlotFlag() or (index % 6)
}

private fun DirectDmrConfig.dmrVoiceSyncFlags(): Int {
    return dmrSlotFlag() or 0x10
}

private fun DirectDmrConfig.dmrSlotFlag(): Int {
    return if (timeSlot == 2) 0x80 else 0x00
}

private const val HOMEBREW_PROTOCOL_VERSION = 2

private fun String.toFrequencyHzOrNull(): Long? {
    val trimmed = trim()
    val parsed = if (trimmed.contains(".")) {
        trimmed.toDoubleOrNull()?.let { (it * 1_000_000.0).toLong() }
    } else {
        trimmed.toLongOrNull()?.let { value ->
            if (value < 1_000_000L) value * 1_000_000L else value
        }
    } ?: return null

    if (parsed <= 0L) {
        return null
    }

    return parsed
}

private fun Long.isSupportedDmrRfFrequency(): Boolean {
    return this in 136_000_000L..174_000_000L || this in 400_000_000L..480_000_000L
}

private fun String.fixed(width: Int): String {
    return filter { it.code in 0x20..0x7e }
        .take(width)
        .padEnd(width, ' ')
}

private fun String.zeroFixed(width: Int): String {
    return filter { it.code in 0x20..0x7e }
        .take(width)
        .padStart(width, '0')
}

private fun Number.unsignedFixed(width: Int): String {
    return toLong().coerceAtLeast(0L).toString().padStart(width, '0').takeLast(width)
}

private fun String.asciiBytes(): ByteArray = toByteArray(Charsets.US_ASCII)

private fun ByteArray.startsWith(prefix: String): Boolean {
    val prefixBytes = prefix.asciiBytes()
    return size >= prefixBytes.size && copyOfRange(0, prefixBytes.size).contentEquals(prefixBytes)
}

private fun ByteArray.asciiPrefix(): String {
    return take(12)
        .map { byte -> if (byte.toInt() in 0x20..0x7e) byte.toInt().toChar() else '.' }
        .joinToString("")
}

private fun ByteArray.hexSummary(): String {
    return take(16).joinToString(" ") { byte -> "%02x".format(byte.toInt() and 0xff) }
}

private fun ByteArray.extractDmrAmbeFrames(): List<ByteArray> {
    if (size < 53) {
        return emptyList()
    }

    val dmrPayload = copyOfRange(20, 53)
    val packedAmbe = ByteArray(27)
    System.arraycopy(dmrPayload, 0, packedAmbe, 0, 14)
    packedAmbe[13] = ((packedAmbe[13].toInt() and 0xf0) or (dmrPayload[19].toInt() and 0x0f)).toByte()
    System.arraycopy(dmrPayload, 20, packedAmbe, 14, 13)

    return listOf(
        packedAmbe.copyOfRange(0, 9),
        packedAmbe.copyOfRange(9, 18),
        packedAmbe.copyOfRange(18, 27)
    )
}

private fun HttpURLConnection.readResponseBody(code: Int): String {
    val stream = if (code in 200..299) {
        runCatching { inputStream }.getOrNull()
    } else {
        errorStream ?: runCatching { inputStream }.getOrNull()
    } ?: return ""

    return stream.use { input ->
        BufferedReader(InputStreamReader(input, Charsets.UTF_8)).use { reader ->
            reader.readText()
        }
    }
}

private fun String.compactLogLine(): String {
    return trim()
        .replace(Regex("\\s+"), " ")
        .take(240)
}

private fun Byte.unsigned(): Int = toInt() and 0xff

private fun ByteArray.uint24At(offset: Int): Int {
    return (this[offset].unsigned() shl 16) or
        (this[offset + 1].unsigned() shl 8) or
        this[offset + 2].unsigned()
}

private fun ByteArray.uint32At(offset: Int): Long {
    return ((this[offset].unsigned().toLong() shl 24) or
        (this[offset + 1].unsigned().toLong() shl 16) or
        (this[offset + 2].unsigned().toLong() shl 8) or
        this[offset + 3].unsigned().toLong()) and 0xffffffffL
}
