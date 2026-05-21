package com.roip.mobile.radio.roip

import android.annotation.SuppressLint
import android.media.AudioAttributes
import android.media.AudioFormat
import android.media.AudioRecord
import android.media.AudioTrack
import android.media.MediaRecorder
import android.os.Process
import android.os.SystemClock
import android.util.Log
import com.roip.mobile.data.ProviderProfile
import com.roip.mobile.data.SessionSnapshot
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.Inet4Address
import java.net.InetAddress
import java.net.InetSocketAddress
import java.net.SocketTimeoutException
import java.net.URL
import java.security.MessageDigest
import java.util.UUID
import java.util.concurrent.atomic.AtomicBoolean
import javax.net.ssl.HttpsURLConnection
import kotlin.concurrent.thread
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min
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

class AllStarIaxRoipController(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    private val scope = CoroutineScope(SupervisorJob() + dispatcher)
    private val lock = Any()
    private val sendLock = Any()
    private val externalTxLock = Any()
    private val txRunning = AtomicBoolean(false)

    @Volatile
    private var socket: DatagramSocket? = null

    @Volatile
    private var remoteAddress: InetAddress? = null

    @Volatile
    private var remotePort: Int = 0

    @Volatile
    private var localCallNumber: Int = 0

    @Volatile
    private var remoteCallNumber: Int = 0

    @Volatile
    private var callStartMillis: Long = 0L

    @Volatile
    private var outboundSeq: Int = 0

    @Volatile
    private var inboundSeq: Int = 0

    @Volatile
    private var inboundVoiceFormat: Int = FORMAT_ULAW

    @Volatile
    private var activeConfig: AllStarIaxConfig? = null

    @Volatile
    private var session: SessionSnapshot? = null

    @Volatile
    private var audioTrack: AudioTrack? = null

    @Volatile
    private var audioTrackPrimedFrames = 0

    @Volatile
    private var audioTrackLastWriteMillis = 0L

    @Volatile
    private var audioRecord: AudioRecord? = null

    @Volatile
    private var networkAudioSink: ((ShortArray) -> Unit)? = null

    @Volatile
    private var externalTxActive = false

    @Volatile
    private var externalTxFrameIndex = 0

    private val externalTxFrameBuffer = ShortArray(ULAW_FRAME_SAMPLES)
    private var externalTxFrameSamples = 0

    @Volatile
    private var txThread: Thread? = null

    private var receiveJob: Job? = null
    private var autoLinkJob: Job? = null
    private var keepAliveJob: Job? = null
    private var registrationRefreshJob: Job? = null

    suspend fun connect(provider: ProviderProfile): SessionSnapshot = withContext(dispatcher) {
        val config = AllStarIaxConfig.from(provider)
        disconnect()

        val nextSocket = createIaxSocket(config)
        nextSocket.soTimeout = SOCKET_TIMEOUT_MS
        val nextLocalCallNumber = ((System.nanoTime().toInt() and 0x7fff).takeIf { it > 0 } ?: 1)

        synchronized(lock) {
            socket = nextSocket
            remoteAddress = null
            remotePort = 0
            localCallNumber = nextLocalCallNumber
            remoteCallNumber = 0
            callStartMillis = SystemClock.elapsedRealtime()
            outboundSeq = 0
            inboundSeq = 0
            inboundVoiceFormat = FORMAT_ULAW
            activeConfig = config
            session = baseSession(config).copy(
                phase = "authorizing",
                statusMessage = if (config.directNodeLookup) {
                    "Registering AllStar node ${config.localNode}"
                } else {
                    "Calling AllStar node ${config.calledNode} on ${config.host}:${config.port}"
                }
            )
        }

        var initialRegistration: AllStarHttpRegistrationResult? = null
        try {
            if (config.directNodeLookup) {
                initialRegistration = registerAllStarNode(nextSocket, config)
                updateSession(
                    phase = "authorizing",
                    message = "Calling AllStar node ${config.calledNode} on ${config.host}:${config.port}"
                )
            }

            val address = resolveIaxAddress(config.host)
            Log.i(TAG, "Calling AllStar node ${config.calledNode} via ${config.host}/${address.hostAddress}:${config.port}")
            synchronized(lock) {
                remoteAddress = address
                remotePort = config.port
                callStartMillis = SystemClock.elapsedRealtime()
                outboundSeq = 0
                inboundSeq = 0
                remoteCallNumber = 0
            }

            sendNew(config, callToken = ByteArray(0), resetSequence = true)
            while (socket === nextSocket && !nextSocket.isClosed) {
                val frame = receiveFullFrame(nextSocket)
                if (frame.sourceCallNumber > 0 && remoteCallNumber == 0) {
                    remoteCallNumber = frame.sourceCallNumber
                }
                if (!isIaxAck(frame)) {
                    inboundSeq = (frame.oSeqNo + 1) and 0xff
                }

                Log.i(
                    TAG,
                    "AllStar setup frame type=${frame.frameType} subclass=${frame.subclass} " +
                        "src=${frame.sourceCallNumber} dst=${frame.destinationCallNumber} " +
                        "oseq=${frame.oSeqNo} iseq=${frame.iSeqNo}"
                )

                if (frame.frameType == FRAME_IAX && frame.subclass == IAX_CALLTOKEN) {
                    val token = frame.ies[IE_CALLTOKEN] ?: ByteArray(0)
                    acknowledge(frame)
                    updateSession("authorizing", "AllStar call token received")
                    sendNew(config, callToken = token, resetSequence = true)
                    continue
                }

                when {
                    frame.frameType == FRAME_IAX && frame.subclass == IAX_AUTHREQ -> {
                        acknowledge(frame)
                        updateSession("authorizing", "Authorizing AllStar IAX user ${config.username}")
                        sendAuthReply(config, frame)
                    }

                    frame.frameType == FRAME_IAX && frame.subclass == IAX_ACCEPT -> {
                        acknowledge(frame)
                        val selectedFormat = frame.ies[IE_FORMAT]?.toIntValue() ?: FORMAT_ULAW
                        inboundVoiceFormat = selectedFormat
                        val connected = updateSession(
                            phase = "connected",
                            message = "AllStar IAX link accepted. Waiting for node ${config.calledNode} audio."
                        )
                        startReceiveLoop()
                        startKeepAlive()
                        initialRegistration?.let { registration ->
                            startRegistrationRefresh(nextSocket, config, registration)
                        }
                        startAutoLinkIfNeeded(config)
                        return@withContext snapshot() ?: connected
                    }

                    frame.frameType == FRAME_CONTROL && frame.subclass == CONTROL_ANSWER -> {
                        acknowledge(frame)
                        val connected = updateSession(
                            phase = "connected",
                            message = "AllStar node ${config.calledNode} answered"
                        )
                        startReceiveLoop()
                        startKeepAlive()
                        initialRegistration?.let { registration ->
                            startRegistrationRefresh(nextSocket, config, registration)
                        }
                        startAutoLinkIfNeeded(config)
                        return@withContext snapshot() ?: connected
                    }

                    frame.frameType == FRAME_IAX && frame.subclass == IAX_REJECT -> {
                        acknowledge(frame)
                        val reject = frame.rejectMessage()
                        Log.w(TAG, "AllStar setup rejected: $reject")
                        throw IllegalStateException(reject)
                    }

                    frame.frameType == FRAME_CONTROL && frame.subclass == CONTROL_HANGUP -> {
                        acknowledge(frame)
                        throw IllegalStateException("AllStar server hung up during call setup")
                    }

                    else -> {
                        acknowledge(frame)
                        Log.i(TAG, "Ignored setup frame type=${frame.frameType} subclass=${frame.subclass}")
                    }
                }
            }
            throw IllegalStateException("AllStar setup ended unexpectedly")
        } catch (error: Exception) {
            registrationRefreshJob?.cancel()
            registrationRefreshJob = null
            closeSocket(nextSocket)
            synchronized(lock) {
                socket = null
                remoteAddress = null
                remotePort = 0
                session = session?.copy(
                    phase = "disconnected",
                    statusMessage = error.message ?: "AllStar IAX connection failed",
                    pttActive = false
                )
            }
            throw error
        }
    }

    private fun createIaxSocket(config: AllStarIaxConfig): DatagramSocket {
        if (!config.directNodeLookup) {
            return DatagramSocket().also { socket ->
                Log.i(TAG, "Using ephemeral local UDP port ${socket.localPort} for AllStar client mode")
            }
        }
        return runCatching {
            DatagramSocket(null).also { socket ->
                socket.reuseAddress = true
                socket.bind(InetSocketAddress(config.port))
                Log.i(TAG, "Bound local AllStar IAX UDP port ${socket.localPort} for node registration")
            }
        }.getOrElse { error ->
            Log.w(TAG, "Unable to bind local IAX port ${config.port}", error)
            throw IllegalStateException(
                "AllStar UDP port ${config.port} is already in use. Disconnect the existing session or restart OpenRadio."
            )
        }
    }

    private fun registerAllStarNode(socket: DatagramSocket, config: AllStarIaxConfig): AllStarHttpRegistrationResult {
        val result = registerAllStarNodeHttp(socket, config)
        updateSession(
            phase = "registering",
            message = "AllStar node ${config.localNode} registered as ${result.ipAddress}:${result.port}"
        )
        return result
    }

    private fun startRegistrationRefresh(
        socket: DatagramSocket,
        config: AllStarIaxConfig,
        registration: AllStarHttpRegistrationResult
    ) {
        registrationRefreshJob?.cancel()
        registrationRefreshJob = scope.launch {
            var delaySeconds = registration.nextRefreshSeconds()
            while (isActive && socket === this@AllStarIaxRoipController.socket && !socket.isClosed) {
                delay(delaySeconds * 1_000L)
                if (!isActive || socket !== this@AllStarIaxRoipController.socket || socket.isClosed) {
                    break
                }
                val refreshed = runCatching {
                    registerAllStarNodeHttp(socket, config)
                }.onSuccess { result ->
                    Log.i(
                        TAG,
                        "AllStar HTTP registration refreshed for node ${config.localNode}; " +
                            "next=${result.nextRefreshSeconds()}s"
                    )
                }.onFailure { error ->
                    Log.w(TAG, "AllStar HTTP registration refresh failed", error)
                }.getOrNull()
                delaySeconds = refreshed?.nextRefreshSeconds() ?: HTTP_REGISTRATION_RETRY_SECONDS
            }
        }
    }

    private fun registerAllStarNodeHttp(socket: DatagramSocket, config: AllStarIaxConfig): AllStarHttpRegistrationResult {
        val request = JSONObject().apply {
            put("port", socket.localPort.takeIf { it > 0 } ?: config.port)
            put(
                "data",
                JSONObject().apply {
                    put(
                        "nodes",
                        JSONObject().apply {
                            put(
                                config.localNode,
                                JSONObject().apply {
                                    put("node", config.localNode)
                                    put("passwd", config.password)
                                    put("remote", 0)
                                }
                            )
                        }
                    )
                }
            )
        }.toString()
        val requestBytes = request.toByteArray(Charsets.UTF_8)
        val url = URL("https://$ALLSTAR_REGISTRATION_HOST/")
        Log.i(TAG, "Starting AllStar HTTP registration for node ${config.localNode} from local UDP ${socket.localPort}")

        val connection = (url.openConnection() as HttpsURLConnection).apply {
            requestMethod = "POST"
            connectTimeout = HTTP_REGISTRATION_TIMEOUT_MS
            readTimeout = HTTP_REGISTRATION_TIMEOUT_MS
            doOutput = true
            setRequestProperty("Content-Type", "application/json")
            setRequestProperty("User-Agent", HTTP_REGISTRATION_USER_AGENT)
            setFixedLengthStreamingMode(requestBytes.size)
        }

        try {
            connection.outputStream.use { output ->
                output.write(requestBytes)
            }
            val code = connection.responseCode
            val body = runCatching {
                val stream = if (code in 200..299) connection.inputStream else connection.errorStream
                stream?.bufferedReader(Charsets.UTF_8)?.use { it.readText() }.orEmpty()
            }.getOrElse { "" }

            if (code !in 200..299) {
                Log.w(TAG, "AllStar HTTP registration failed with HTTP $code")
                throw IOException("AllStar HTTP registration failed with HTTP $code")
            }

            val response = JSONObject(body)
            val responseData = response.opt("data")?.toString().orEmpty()
            val success = responseData.contains("successfully registered", ignoreCase = true)
            if (!success) {
                Log.w(TAG, "AllStar HTTP registration rejected: ${responseData.take(180)}")
                throw IllegalStateException("AllStar HTTP registration rejected")
            }

            val result = AllStarHttpRegistrationResult(
                ipAddress = response.optString("ipaddr", ""),
                port = response.optInt("port", socket.localPort.takeIf { it > 0 } ?: config.port),
                refresh = response.optInt("refresh", REGISTRATION_REFRESH_SECONDS)
            )
            Log.i(
                TAG,
                "AllStar HTTP registration accepted for node ${config.localNode}; " +
                    "perceived=${result.ipAddress}:${result.port} refresh=${result.refresh}s"
            )
            return result
        } finally {
            connection.disconnect()
        }
    }

    private fun registerAllStarNodeIax(
        socket: DatagramSocket,
        config: AllStarIaxConfig,
        registrationCallNumber: Int
    ) {
        val registrationAddress = resolveIaxAddress(ALLSTAR_REGISTRATION_HOST)
        var remoteRegistrationCallNumber = 0
        var registrationOutboundSeq = 0
        var registrationInboundSeq = 0
        val registrationStartMillis = SystemClock.elapsedRealtime()

        Log.i(
            TAG,
            "Starting AllStar IAX registration for node ${config.localNode} via " +
                "$ALLSTAR_REGISTRATION_HOST/${registrationAddress.hostAddress}:$ALLSTAR_REGISTRATION_PORT " +
                "from local UDP ${socket.localPort}"
        )

        fun registrationTimestamp(): Int {
            return ((SystemClock.elapsedRealtime() - registrationStartMillis) and 0xffffffffL).toInt()
        }

        fun sendRegistrationFrame(
            subclass: Int,
            payload: ByteArray = ByteArray(0),
            destinationCallNumber: Int = remoteRegistrationCallNumber,
            timestamp: Int = registrationTimestamp(),
            advanceSequence: Boolean = true
        ) {
            sendFullFrameRaw(
                socket = socket,
                address = registrationAddress,
                port = ALLSTAR_REGISTRATION_PORT,
                sourceCallNumber = registrationCallNumber,
                destinationCallNumber = destinationCallNumber,
                timestamp = timestamp,
                outboundSeq = registrationOutboundSeq,
                inboundSeq = registrationInboundSeq,
                frameType = FRAME_IAX,
                subclass = subclass,
                payload = payload
            )
            if (advanceSequence) {
                registrationOutboundSeq = (registrationOutboundSeq + 1) and 0xff
            }
            Log.i(
                TAG,
                "Sent AllStar registration frame subclass=$subclass dst=$destinationCallNumber " +
                    "oseq=${if (advanceSequence) (registrationOutboundSeq - 1) and 0xff else registrationOutboundSeq} " +
                    "iseq=$registrationInboundSeq bytes=${payload.size}"
            )
        }

        fun sendRegistrationAck(frame: IaxFrame) {
            if (frame.sourceCallNumber == 0 || frame.subclass == IAX_ACK) {
                return
            }
            sendRegistrationFrame(
                subclass = IAX_ACK,
                destinationCallNumber = frame.sourceCallNumber,
                timestamp = frame.timestamp,
                advanceSequence = false
            )
        }

        fun registrationRequestPayload(frame: IaxFrame? = null): ByteArray {
            val methods = frame?.ies?.get(IE_AUTHMETHODS)?.toShortValue() ?: AUTH_MD5
            val challenge = frame?.ies?.get(IE_CHALLENGE)?.toStringValue().orEmpty()
            return buildIes {
                string(IE_USERNAME, config.localNode)
                short(IE_REFRESH, REGISTRATION_REFRESH_SECONDS)
                if (frame != null) {
                    if ((methods and AUTH_MD5) != 0 && challenge.isNotBlank()) {
                        string(IE_MD5_RESULT, md5Hex(challenge + config.password))
                    } else {
                        string(IE_PASSWORD, config.password)
                    }
                }
                bytes(IE_CALLTOKEN, ByteArray(0))
            }
        }

        Log.i(TAG, "Sending AllStar REGREQ for node ${config.localNode}")
        sendRegistrationFrame(
            subclass = IAX_REGREQ,
            destinationCallNumber = 0,
            payload = registrationRequestPayload()
        )

        val deadline = SystemClock.elapsedRealtime() + REGISTRATION_TIMEOUT_MS
        while (SystemClock.elapsedRealtime() < deadline && !socket.isClosed) {
            val frame = try {
                receiveFullFrame(socket)
            } catch (error: SocketTimeoutException) {
                continue
            }
            if (frame.sourceCallNumber > 0 && remoteRegistrationCallNumber == 0) {
                remoteRegistrationCallNumber = frame.sourceCallNumber
            }
            if (frame.subclass != IAX_ACK) {
                registrationInboundSeq = (frame.oSeqNo + 1) and 0xff
            }

            Log.i(
                TAG,
                "AllStar registration frame type=${frame.frameType} subclass=${frame.subclass} " +
                    "src=${frame.sourceCallNumber} dst=${frame.destinationCallNumber} " +
                    "oseq=${frame.oSeqNo} iseq=${frame.iSeqNo}"
            )

            if (frame.frameType != FRAME_IAX) {
                sendRegistrationAck(frame)
                continue
            }

            when (frame.subclass) {
                IAX_REGAUTH -> {
                    Log.i(TAG, "AllStar registration auth challenge received")
                    sendRegistrationAck(frame)
                    updateSession("registering", "Authorizing AllStar node ${config.localNode}")
                    sendRegistrationFrame(
                        subclass = IAX_REGREQ,
                        payload = registrationRequestPayload(frame)
                    )
                }

                IAX_REGACK -> {
                    sendRegistrationAck(frame)
                    val refresh = frame.ies[IE_REFRESH]?.toShortValue() ?: REGISTRATION_REFRESH_SECONDS
                    Log.i(TAG, "AllStar registration accepted for node ${config.localNode}; refresh=${refresh}s")
                    updateSession("registering", "AllStar node ${config.localNode} registered for ${refresh}s")
                    return
                }

                IAX_REGREJ -> {
                    sendRegistrationAck(frame)
                    val reject = frame.rejectMessage(fallback = "AllStar registration rejected")
                    Log.w(TAG, "AllStar registration rejected: $reject")
                    throw IllegalStateException(reject)
                }

                IAX_ACK -> Unit
                else -> sendRegistrationAck(frame)
            }
        }

        Log.w(TAG, "AllStar registration timed out waiting for $ALLSTAR_REGISTRATION_HOST")
        throw SocketTimeoutException("AllStar registration timed out")
    }

    suspend fun disconnect(): SessionSnapshot? = withContext(dispatcher) {
        receiveJob?.cancel()
        receiveJob = null
        autoLinkJob?.cancel()
        autoLinkJob = null
        keepAliveJob?.cancel()
        keepAliveJob = null
        registrationRefreshJob?.cancel()
        registrationRefreshJob = null
        stopTransmit(sendUnkey = true)
        networkAudioSink = null
        resetExternalTxState()

        val config = activeConfig
        if (config?.remoteNode?.isNotBlank() == true && config.autoLinked && !config.directNodeLookup) {
            runCatching {
                sendDtmfSequence("*1${config.remoteNode}")
                Thread.sleep(250)
            }
        }
        runCatching {
            sendFullFrame(
                frameType = FRAME_IAX,
                subclass = IAX_HANGUP,
                payload = buildIes {
                    string(IE_CAUSE, "OpenRadio disconnect")
                    byte(IE_CAUSECODE, 16)
                }
            )
        }

        closeSocket(socket)
        runCatching {
            audioTrack?.pause()
            audioTrack?.flush()
            audioTrack?.release()
        }
        audioTrack = null
        audioTrackPrimedFrames = 0
        audioTrackLastWriteMillis = 0L

        synchronized(lock) {
            socket = null
            remoteAddress = null
            remotePort = 0
            localCallNumber = 0
            remoteCallNumber = 0
            activeConfig = null
            session = session?.copy(
                phase = "disconnected",
                statusMessage = "AllStar IAX session stopped",
                pttActive = false
            )
            session
        }
    }

    fun shutdown() {
        receiveJob?.cancel()
        autoLinkJob?.cancel()
        keepAliveJob?.cancel()
        registrationRefreshJob?.cancel()
        networkAudioSink = null
        resetExternalTxState()
        stopTransmit(sendUnkey = false)
        closeSocket(socket)
        runCatching {
            audioTrack?.release()
        }
        audioTrack = null
        audioTrackPrimedFrames = 0
        audioTrackLastWriteMillis = 0L
        synchronized(lock) {
            socket = null
            remoteAddress = null
            remotePort = 0
            session = session?.copy(
                phase = "disconnected",
                statusMessage = "AllStar IAX controller stopped",
                pttActive = false
            )
            activeConfig = null
        }
    }

    fun snapshot(): SessionSnapshot? = synchronized(lock) {
        session
    }

    fun setNetworkAudioSink(sink: ((ShortArray) -> Unit)?) {
        networkAudioSink = sink
    }

    suspend fun sendDtmf(sequence: String): SessionSnapshot = withContext(dispatcher) {
        if (session?.phase != "connected" && session?.phase != "transmitting") {
            throw IllegalStateException("AllStar IAX is not connected")
        }
        val normalized = sequence.filter { it.isDigit() || it in "*#ABCDabcd" }.uppercase()
        if (normalized.isBlank()) {
            throw IllegalArgumentException("DTMF command cannot be empty")
        }
        sendDtmfSequence(normalized)
        updateSession(
            phase = session?.phase ?: "connected",
            message = "Sent DTMF $normalized"
        )
    }

    suspend fun setPtt(pressed: Boolean): SessionSnapshot = withContext(dispatcher) {
        if (session?.phase != "connected" && session?.phase != "transmitting") {
            throw IllegalStateException("AllStar IAX is not connected")
        }
        if (pressed) {
            startTransmit()
        } else {
            stopTransmit(sendUnkey = true)
        }
        snapshot() ?: updateSession("connected", "AllStar IAX connected", pttActive = false)
    }

    suspend fun setExternalPtt(pressed: Boolean): SessionSnapshot = withContext(dispatcher) {
        if (session?.phase != "connected" && session?.phase != "transmitting") {
            throw IllegalStateException("AllStar IAX is not connected")
        }
        if (pressed && !externalTxActive) {
            synchronized(externalTxLock) {
                externalTxActive = true
                externalTxFrameIndex = 0
                externalTxFrameSamples = 0
            }
            sendFullFrame(FRAME_CONTROL, CONTROL_KEY_RADIO)
            return@withContext updateSession("transmitting", "AllStar RF hotspot uplink active", pttActive = true)
        }
        if (!pressed && externalTxActive) {
            synchronized(externalTxLock) {
                flushExternalVoiceFrameLocked()
                externalTxActive = false
                externalTxFrameSamples = 0
            }
            sendFullFrame(FRAME_CONTROL, CONTROL_UNKEY_RADIO)
            return@withContext updateSession("connected", "AllStar RF hotspot uplink idle", pttActive = false)
        }
        snapshot() ?: updateSession("connected", "AllStar IAX connected")
    }

    fun sendExternalPcm(pcm: ShortArray) {
        if (pcm.isEmpty()) {
            return
        }
        synchronized(externalTxLock) {
            if (!externalTxActive) {
                return
            }
            var offset = 0
            while (offset < pcm.size) {
                val copyCount = min(ULAW_FRAME_SAMPLES - externalTxFrameSamples, pcm.size - offset)
                pcm.copyInto(
                    destination = externalTxFrameBuffer,
                    destinationOffset = externalTxFrameSamples,
                    startIndex = offset,
                    endIndex = offset + copyCount
                )
                externalTxFrameSamples += copyCount
                offset += copyCount

                if (externalTxFrameSamples == ULAW_FRAME_SAMPLES) {
                    sendExternalVoiceFrameLocked(externalTxFrameBuffer)
                    externalTxFrameSamples = 0
                }
            }
        }
    }

    private fun resetExternalTxState() {
        synchronized(externalTxLock) {
            externalTxActive = false
            externalTxFrameIndex = 0
            externalTxFrameSamples = 0
        }
    }

    private fun flushExternalVoiceFrameLocked() {
        if (externalTxFrameSamples <= 0) {
            return
        }
        for (index in externalTxFrameSamples until ULAW_FRAME_SAMPLES) {
            externalTxFrameBuffer[index] = 0
        }
        sendExternalVoiceFrameLocked(externalTxFrameBuffer)
        externalTxFrameSamples = 0
    }

    private fun sendExternalVoiceFrameLocked(pcm: ShortArray) {
        val ulaw = ByteArray(ULAW_FRAME_SAMPLES)
        for (index in 0 until ULAW_FRAME_SAMPLES) {
            ulaw[index] = G711.linearToUlaw(pcm[index])
        }
        runCatching {
            val frameIndex = externalTxFrameIndex
            if (frameIndex == 0 || frameIndex % FULL_VOICE_INTERVAL == 0) {
                sendFullFrame(FRAME_VOICE, FORMAT_ULAW, payload = ulaw)
            } else {
                sendMiniVoiceFrame(ulaw)
            }
            externalTxFrameIndex = frameIndex + 1
        }.onFailure { error ->
            Log.w(TAG, "AllStar external PCM send failed", error)
        }
    }

    private fun sendNew(config: AllStarIaxConfig, callToken: ByteArray, resetSequence: Boolean) {
        if (resetSequence) {
            outboundSeq = 0
            inboundSeq = 0
            remoteCallNumber = 0
        }
        Log.i(
            TAG,
            "Sending AllStar NEW username=${config.username} called=${config.calledNode} " +
                "calling=${config.localNode} context=${config.context.ifBlank { "<remote default>" }} " +
                "callTokenBytes=${callToken.size}"
        )
        sendFullFrame(
            frameType = FRAME_IAX,
            subclass = IAX_NEW,
            destinationCallNumber = 0,
            payload = buildIes {
                short(IE_VERSION, IAX_VERSION)
                string(IE_CALLED_NUMBER, config.calledNode)
                string(IE_CALLING_NUMBER, config.localNode)
                string(IE_CALLING_NAME, config.callerName)
                if (config.context.isNotBlank()) {
                    string(IE_CALLED_CONTEXT, config.context)
                }
                string(IE_USERNAME, config.username)
                int(IE_FORMAT, FORMAT_ULAW)
                int(IE_CAPABILITY, FORMAT_ULAW)
                short(IE_ADSICPE, 0)
                bytes(IE_CALLTOKEN, callToken)
            }
        )
    }

    private fun sendAuthReply(config: AllStarIaxConfig, frame: IaxFrame) {
        val methods = frame.ies[IE_AUTHMETHODS]?.toShortValue() ?: AUTH_MD5
        val challenge = frame.ies[IE_CHALLENGE]?.toStringValue().orEmpty()
        val payload = buildIes {
            string(IE_USERNAME, config.username)
            if ((methods and AUTH_MD5) != 0 && challenge.isNotBlank()) {
                string(IE_MD5_RESULT, md5Hex(challenge + config.password))
            } else {
                string(IE_PASSWORD, config.password)
            }
        }
        sendFullFrame(
            frameType = FRAME_IAX,
            subclass = IAX_AUTHREP,
            payload = payload
        )
    }

    private fun startReceiveLoop() {
        if (receiveJob?.isActive == true) {
            return
        }
        socket?.soTimeout = RECEIVE_TIMEOUT_MS
        receiveJob = scope.launch {
            while (isActive) {
                val currentSocket = socket ?: break
                val packet = try {
                    receivePacket(currentSocket)
                } catch (error: SocketTimeoutException) {
                    continue
                } catch (error: Exception) {
                    if (currentSocket.isClosed) {
                        break
                    }
                    endSessionFromRemote(error.message ?: "AllStar IAX receive failed")
                    break
                }
                handleIncomingPacket(packet)
            }
        }
    }

    private fun startKeepAlive() {
        keepAliveJob?.cancel()
        keepAliveJob = scope.launch {
            while (isActive) {
                delay(PING_INTERVAL_MS)
                runCatching {
                    sendFullFrame(FRAME_IAX, IAX_PING)
                    Log.i(TAG, "Sent AllStar IAX keepalive ping")
                }.onFailure { error ->
                    Log.w(TAG, "AllStar IAX keepalive ping failed", error)
                }
            }
        }
    }

    private fun startAutoLinkIfNeeded(config: AllStarIaxConfig) {
        if (config.directNodeLookup || config.remoteNode.isBlank() || config.remoteNode == config.localNode || config.autoLinked) {
            return
        }
        autoLinkJob?.cancel()
        autoLinkJob = scope.launch {
            delay(AUTOLINK_DELAY_MS)
            runCatching {
                sendDtmfSequence("*3${config.remoteNode}")
                config.autoLinked = true
                updateSession(
                    phase = session?.phase ?: "connected",
                    message = "AllStar linked local ${config.localNode} to remote ${config.remoteNode}"
                )
            }.onFailure { error ->
                updateSession(
                    phase = session?.phase ?: "connected",
                    message = error.message ?: "AllStar remote node link command failed"
                )
            }
        }
    }

    private fun handleIncomingPacket(packet: ByteArray) {
        if (packet.size < 2) {
            return
        }
        val firstWord = packet.u16(0)
        when {
            (firstWord and FULL_FRAME_BIT) != 0 -> handleFullFrame(parseFullFrame(packet))
            firstWord != 0 -> handleMiniFrame(packet)
            else -> Unit
        }
    }

    private fun handleFullFrame(frame: IaxFrame) {
        if (frame.sourceCallNumber > 0 && remoteCallNumber == 0) {
            remoteCallNumber = frame.sourceCallNumber
        }
        if (!isIaxAck(frame)) {
            inboundSeq = (frame.oSeqNo + 1) and 0xff
        }

        if (frame.frameType != FRAME_VOICE) {
            Log.i(
                TAG,
                "AllStar RX full frame type=${frame.frameType} subclass=${frame.subclass} " +
                    "src=${frame.sourceCallNumber} dst=${frame.destinationCallNumber} " +
                    "oseq=${frame.oSeqNo} iseq=${frame.iSeqNo}"
            )
        }

        when (frame.frameType) {
            FRAME_IAX -> handleIaxFrame(frame)
            FRAME_CONTROL -> handleControlFrame(frame)
            FRAME_VOICE -> {
                acknowledge(frame)
                inboundVoiceFormat = frame.subclass
                handleVoicePayload(frame.payload, frame.subclass)
            }
            FRAME_DTMF -> acknowledge(frame)
            else -> acknowledge(frame)
        }
    }

    private fun handleIaxFrame(frame: IaxFrame) {
        when (frame.subclass) {
            IAX_ACK -> Unit
            IAX_PING -> {
                acknowledge(frame)
                sendFullFrame(FRAME_IAX, IAX_PONG, timestamp = frame.timestamp)
            }
            IAX_LAGRQ -> {
                acknowledge(frame)
                sendFullFrame(FRAME_IAX, IAX_LAGRP, timestamp = frame.timestamp)
            }
            IAX_PONG, IAX_LAGRP -> acknowledge(frame)
            IAX_REJECT -> {
                acknowledge(frame)
                val reject = frame.rejectMessage()
                Log.w(TAG, "AllStar IAX rejected active call: $reject")
                endSessionFromRemote(reject)
            }
            IAX_HANGUP -> {
                acknowledge(frame)
                val hangup = frame.hangupMessage(activeConfig)
                Log.w(TAG, "AllStar IAX hangup: $hangup")
                endSessionFromRemote(hangup)
            }
            else -> acknowledge(frame)
        }
    }

    private fun handleControlFrame(frame: IaxFrame) {
        acknowledge(frame)
        when (frame.subclass) {
            CONTROL_ANSWER -> updateSession("connected", "AllStar node answered")
            CONTROL_RINGING -> updateSession("linking", "AllStar node is ringing")
            CONTROL_KEY_RADIO -> updateInbound("AllStar RX keyed")
            CONTROL_UNKEY_RADIO -> updateInbound("AllStar RX idle")
            CONTROL_HANGUP -> {
                Log.w(TAG, "AllStar control hangup")
                endSessionFromRemote("AllStar server hung up")
            }
            CONTROL_BUSY -> {
                Log.w(TAG, "AllStar control busy")
                endSessionFromRemote("AllStar node is busy")
            }
            CONTROL_CONGESTION -> {
                Log.w(TAG, "AllStar control congestion")
                endSessionFromRemote("AllStar node is congested")
            }
        }
    }

    private fun endSessionFromRemote(message: String) {
        keepAliveJob?.cancel()
        keepAliveJob = null
        registrationRefreshJob?.cancel()
        registrationRefreshJob = null
        autoLinkJob?.cancel()
        autoLinkJob = null
        stopTransmit(sendUnkey = false)
        networkAudioSink = null
        resetExternalTxState()
        closeSocket(socket)
        runCatching {
            audioTrack?.pause()
            audioTrack?.flush()
            audioTrack?.release()
        }
        audioTrack = null
        audioTrackPrimedFrames = 0
        audioTrackLastWriteMillis = 0L
        synchronized(lock) {
            socket = null
            remoteAddress = null
            remotePort = 0
            localCallNumber = 0
            remoteCallNumber = 0
            activeConfig = null
            session = session?.copy(
                phase = "disconnected",
                statusMessage = message,
                pttActive = false
            )
        }
    }

    private fun IaxFrame.hangupMessage(config: AllStarIaxConfig?): String {
        val rawMessage = rejectMessage(fallback = "AllStar server hung up")
        if (rawMessage == "code 0" && config?.directNodeLookup == true) {
            return "Remote node dropped the link after setup. Check for a stale link, busy node, or allow/deny rule."
        }
        return rawMessage
    }

    private fun handleMiniFrame(packet: ByteArray) {
        val sourceCall = packet.u16(0) and 0x7fff
        if (sourceCall != remoteCallNumber || packet.size <= MINI_HEADER_BYTES) {
            return
        }
        handleVoicePayload(packet.copyOfRange(MINI_HEADER_BYTES, packet.size), inboundVoiceFormat)
    }

    private fun handleVoicePayload(payload: ByteArray, format: Int) {
        if (payload.isEmpty()) {
            return
        }
        if (format != FORMAT_ULAW) {
            updateSession(
                phase = session?.phase ?: "connected",
                message = "AllStar audio codec 0x${format.toString(16)} is not supported yet; use ulaw on the server"
            )
            return
        }
        val pcm = ShortArray(payload.size)
        payload.forEachIndexed { index, value ->
            pcm[index] = G711.ulawToLinear(value)
        }
        networkAudioSink?.let { sink ->
            sink(pcm)
            updateInbound("AllStar RX audio to RF")
            return
        }
        val now = SystemClock.elapsedRealtime()
        val track = audioTrack ?: createAudioTrack().also {
            audioTrack = it
            audioTrackPrimedFrames = 0
            audioTrackLastWriteMillis = 0L
        }
        if (
            audioTrackLastWriteMillis > 0L &&
            now - audioTrackLastWriteMillis > AUDIO_GAP_RESET_MS
        ) {
            runCatching { track.pause() }
            runCatching { track.flush() }
            audioTrackPrimedFrames = 0
        }
        val written = track.write(pcm, 0, pcm.size, AudioTrack.WRITE_BLOCKING)
        if (written > 0) {
            audioTrackLastWriteMillis = now
            if (track.playState != AudioTrack.PLAYSTATE_PLAYING) {
                audioTrackPrimedFrames += 1
                if (audioTrackPrimedFrames >= AUDIO_PREFILL_FRAMES) {
                    track.play()
                }
            }
            updateInbound("AllStar RX audio")
        }
    }

    private fun startTransmit() {
        if (txRunning.getAndSet(true)) {
            updateSession("transmitting", "AllStar PTT active", pttActive = true)
            return
        }
        val config = activeConfig ?: throw IllegalStateException("AllStar profile is not available")
        sendFullFrame(FRAME_CONTROL, CONTROL_KEY_RADIO)
        updateSession("transmitting", "AllStar PTT active", pttActive = true)

        txThread = thread(start = true, isDaemon = true, name = "AllStar-IAX-TX-Audio") {
            Process.setThreadPriority(Process.THREAD_PRIORITY_URGENT_AUDIO)
            val capture = runCatching { createAudioRecord() }.getOrElse { error ->
                txRunning.set(false)
                updateSession("connected", error.message ?: "AllStar microphone failed", pttActive = false)
                return@thread
            }
            val record = capture.record
            audioRecord = record
            try {
                record.startRecording()
                if (record.recordingState != AudioRecord.RECORDSTATE_RECORDING) {
                    throw IOException("AudioRecord could not start")
                }
                Log.i(TAG, "AllStar TX audio capture started with ${capture.sourceLabel}")
                val pcm = ShortArray(ULAW_FRAME_SAMPLES)
                var frameIndex = 0
                while (txRunning.get()) {
                    fillAudioFrame(record, pcm)
                    val peak = pcm.peak()
                    val ulaw = ByteArray(pcm.size)
                    pcm.forEachIndexed { index, sample ->
                        ulaw[index] = G711.linearToUlaw(sample)
                    }
                    if (frameIndex == 0 || frameIndex % FULL_VOICE_INTERVAL == 0) {
                        sendFullFrame(FRAME_VOICE, FORMAT_ULAW, payload = ulaw)
                    } else {
                        sendMiniVoiceFrame(ulaw)
                    }
                    frameIndex += 1
                    if (frameIndex % TX_STATUS_INTERVAL == 0) {
                        Log.i(TAG, "AllStar TX audio $frameIndex frames peak $peak source=${capture.sourceLabel}")
                        updateSession(
                            phase = "transmitting",
                            message = "AllStar TX audio ${frameIndex} frames peak $peak",
                            pttActive = true
                        )
                    }
                }
            } catch (error: Exception) {
                if (txRunning.get()) {
                    updateSession("connected", error.message ?: "AllStar TX audio stopped", pttActive = false)
                }
            } finally {
                txRunning.set(false)
                runCatching { record.stop() }
                runCatching { record.release() }
                audioRecord = null
                if (config == activeConfig) {
                    runCatching { sendFullFrame(FRAME_CONTROL, CONTROL_UNKEY_RADIO) }
                }
            }
        }
    }

    private fun stopTransmit(sendUnkey: Boolean) {
        val wasRunning = txRunning.getAndSet(false)
        runCatching {
            audioRecord?.stop()
        }
        runCatching {
            txThread?.takeIf { it != Thread.currentThread() }?.join(650)
        }
        runCatching {
            audioRecord?.release()
        }
        audioRecord = null
        txThread = null
        if (sendUnkey && !wasRunning) {
            runCatching { sendFullFrame(FRAME_CONTROL, CONTROL_UNKEY_RADIO) }
        }
        if (session != null) {
            updateSession(session?.phase?.takeIf { it != "disconnected" } ?: "connected", "AllStar PTT released", pttActive = false)
        }
    }

    private fun fillAudioFrame(record: AudioRecord, pcm: ShortArray) {
        var offset = 0
        while (txRunning.get() && offset < pcm.size) {
            val count = record.read(pcm, offset, pcm.size - offset, AudioRecord.READ_BLOCKING)
            if (count > 0) {
                offset += count
            } else {
                throw IOException("AudioRecord read returned $count")
            }
        }
    }

    private fun sendDtmfSequence(sequence: String) {
        sequence.filter { it.isDigit() || it in "*#ABCDabcd" }.uppercase().forEach { digit ->
            sendFullFrame(FRAME_DTMF, digit.code)
            Thread.sleep(DTMF_GAP_MS)
        }
    }

    private fun acknowledge(frame: IaxFrame) {
        if (isIaxAck(frame) || frame.sourceCallNumber == 0) {
            return
        }
        sendFullFrame(
            frameType = FRAME_IAX,
            subclass = IAX_ACK,
            destinationCallNumber = frame.sourceCallNumber,
            timestamp = frame.timestamp,
            advanceSequence = false
        )
    }

    private fun sendFullFrame(
        frameType: Int,
        subclass: Int,
        payload: ByteArray = ByteArray(0),
        destinationCallNumber: Int = remoteCallNumber,
        timestamp: Int = elapsedTimestamp(),
        advanceSequence: Boolean = true
    ) {
        val currentSocket = socket ?: throw IllegalStateException("AllStar IAX socket is not active")
        val currentAddress = remoteAddress ?: throw IllegalStateException("AllStar IAX server address is not active")
        val currentPort = remotePort.takeIf { it > 0 } ?: throw IllegalStateException("AllStar IAX server port is not active")
        sendFullFrameRaw(
            socket = currentSocket,
            address = currentAddress,
            port = currentPort,
            sourceCallNumber = localCallNumber,
            destinationCallNumber = destinationCallNumber,
            timestamp = timestamp,
            outboundSeq = outboundSeq,
            inboundSeq = inboundSeq,
            frameType = frameType,
            subclass = subclass,
            payload = payload
        )
        if (advanceSequence) {
            outboundSeq = (outboundSeq + 1) and 0xff
        }
    }

    private fun isIaxAck(frame: IaxFrame): Boolean {
        return frame.frameType == FRAME_IAX && frame.subclass == IAX_ACK
    }

    private fun sendFullFrameRaw(
        socket: DatagramSocket,
        address: InetAddress,
        port: Int,
        sourceCallNumber: Int,
        destinationCallNumber: Int,
        timestamp: Int,
        outboundSeq: Int,
        inboundSeq: Int,
        frameType: Int,
        subclass: Int,
        payload: ByteArray = ByteArray(0)
    ) {
        val bytes = ByteArray(FULL_HEADER_BYTES + payload.size)
        val src = FULL_FRAME_BIT or (sourceCallNumber and 0x7fff)
        bytes.putU16(0, src)
        bytes.putU16(2, destinationCallNumber and 0x7fff)
        bytes.putU32(4, timestamp)
        bytes[8] = outboundSeq.toByte()
        bytes[9] = inboundSeq.toByte()
        bytes[10] = frameType.toByte()
        bytes[11] = encodeSubclass(subclass)
        payload.copyInto(bytes, FULL_HEADER_BYTES)
        synchronized(sendLock) {
            socket.send(DatagramPacket(bytes, bytes.size, address, port))
        }
    }

    private fun sendMiniVoiceFrame(payload: ByteArray) {
        val currentSocket = socket ?: return
        val currentAddress = remoteAddress ?: return
        val currentPort = remotePort.takeIf { it > 0 } ?: return
        val bytes = ByteArray(MINI_HEADER_BYTES + payload.size)
        bytes.putU16(0, localCallNumber and 0x7fff)
        bytes.putU16(2, elapsedTimestamp() and 0xffff)
        payload.copyInto(bytes, MINI_HEADER_BYTES)
        synchronized(sendLock) {
            currentSocket.send(DatagramPacket(bytes, bytes.size, currentAddress, currentPort))
        }
    }

    private fun receiveFullFrame(socket: DatagramSocket): IaxFrame {
        while (true) {
            val packet = receivePacket(socket)
            if (packet.size >= FULL_HEADER_BYTES && (packet.u16(0) and FULL_FRAME_BIT) != 0) {
                return parseFullFrame(packet)
            }
        }
    }

    private fun parseFullFrame(packet: ByteArray): IaxFrame {
        val sourceCall = packet.u16(0) and 0x7fff
        val destinationCall = packet.u16(2) and 0x7fff
        val timestamp = packet.u32(4)
        val oSeq = packet[8].toInt() and 0xff
        val iSeq = packet[9].toInt() and 0xff
        val frameType = packet[10].toInt() and 0xff
        val subclass = decodeSubclass(packet[11].toInt() and 0xff)
        val payload = packet.copyOfRange(FULL_HEADER_BYTES, packet.size)
        return IaxFrame(
            sourceCallNumber = sourceCall,
            destinationCallNumber = destinationCall,
            timestamp = timestamp,
            oSeqNo = oSeq,
            iSeqNo = iSeq,
            frameType = frameType,
            subclass = subclass,
            payload = payload,
            ies = if (frameType == FRAME_IAX) parseIes(payload) else emptyMap()
        )
    }

    private fun receivePacket(socket: DatagramSocket): ByteArray {
        val buffer = ByteArray(RECEIVE_BYTES)
        val packet = DatagramPacket(buffer, buffer.size)
        socket.receive(packet)
        return buffer.copyOf(packet.length)
    }

    private fun baseSession(config: AllStarIaxConfig): SessionSnapshot {
        return SessionSnapshot(
            id = UUID.randomUUID().toString(),
            providerId = ALLSTAR_PROVIDER_ID,
            providerName = "AllStar",
            phase = "configuring",
            statusMessage = "Preparing AllStar IAX session",
            target = listOf(config.localNode, config.remoteNode)
                .filter { it.isNotBlank() }
                .joinToString(" -> ")
                .ifBlank { config.localNode },
            serverHost = config.serverLabel,
            transport = IAX_TRANSPORT,
            warnings = emptyList(),
            pttActive = false,
            requiresMediaBridge = false
        )
    }

    private fun updateSession(
        phase: String,
        message: String,
        pttActive: Boolean = session?.pttActive ?: false
    ): SessionSnapshot {
        synchronized(lock) {
            val current = session ?: error("AllStar IAX session is not active")
            val updated = current.copy(
                phase = phase,
                statusMessage = message,
                pttActive = pttActive,
                audioDecoderState = "G.711 ulaw"
            )
            session = updated
            return updated
        }
    }

    private fun updateInbound(message: String) {
        synchronized(lock) {
            val current = session ?: return
            session = current.copy(
                statusMessage = message,
                inboundDmrFrames = current.inboundDmrFrames + 1,
                inboundDmrVoiceFrames = current.inboundDmrVoiceFrames + 1,
                lastInboundFrameType = "AllStar",
                audioDecoderState = "G.711 ulaw"
            )
        }
    }

    private fun closeSocket(socket: DatagramSocket?) {
        runCatching {
            socket?.close()
        }
    }

    private fun resolveIaxAddress(host: String): InetAddress {
        val addresses = InetAddress.getAllByName(host).toList()
        val selected = addresses.firstOrNull { it is Inet4Address } ?: addresses.first()
        Log.i(
            TAG,
            "Resolved $host to ${addresses.joinToString { it.hostAddress ?: it.hostName }}; " +
                "using ${selected.hostAddress}"
        )
        return selected
    }

    private fun elapsedTimestamp(): Int {
        val start = callStartMillis.takeIf { it > 0L } ?: SystemClock.elapsedRealtime()
        return ((SystemClock.elapsedRealtime() - start) and 0xffffffffL).toInt()
    }

    @SuppressLint("MissingPermission")
    private fun createAudioRecord(): AudioRecordCapture {
        val minBuffer = AudioRecord.getMinBufferSize(
            SAMPLE_RATE_HZ,
            AudioFormat.CHANNEL_IN_MONO,
            AudioFormat.ENCODING_PCM_16BIT
        )
        val audioFormat = AudioFormat.Builder()
            .setSampleRate(SAMPLE_RATE_HZ)
            .setEncoding(AudioFormat.ENCODING_PCM_16BIT)
            .setChannelMask(AudioFormat.CHANNEL_IN_MONO)
            .build()
        val bufferSize = max(minBuffer.takeIf { it > 0 } ?: 0, AUDIO_BUFFER_BYTES)
        val sources = listOf(
            MediaRecorder.AudioSource.MIC to "Android mic",
            MediaRecorder.AudioSource.VOICE_COMMUNICATION to "voice communication mic",
            MediaRecorder.AudioSource.UNPROCESSED to "unprocessed mic"
        )
        var lastError: Throwable? = null
        for ((source, label) in sources) {
            val record = try {
                AudioRecord.Builder()
                    .setAudioSource(source)
                    .setAudioFormat(audioFormat)
                    .setBufferSizeInBytes(bufferSize)
                    .build()
            } catch (error: Throwable) {
                lastError = error
                Log.w(TAG, "AllStar AudioRecord source $label failed to build", error)
                null
            } ?: continue
            if (record.state == AudioRecord.STATE_INITIALIZED) {
                return AudioRecordCapture(record, label)
            }
            runCatching { record.release() }
            lastError = IOException("AudioRecord source $label was not initialized")
            Log.w(TAG, "AllStar AudioRecord source $label was not initialized")
        }
        throw IOException("AudioRecord initialization failed", lastError)
    }

    private fun createAudioTrack(): AudioTrack {
        val minBuffer = AudioTrack.getMinBufferSize(
            SAMPLE_RATE_HZ,
            AudioFormat.CHANNEL_OUT_MONO,
            AudioFormat.ENCODING_PCM_16BIT
        )
        val track = AudioTrack.Builder()
            .setAudioAttributes(
                AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
                    .build()
            )
            .setAudioFormat(
                AudioFormat.Builder()
                    .setSampleRate(SAMPLE_RATE_HZ)
                    .setEncoding(AudioFormat.ENCODING_PCM_16BIT)
                    .setChannelMask(AudioFormat.CHANNEL_OUT_MONO)
                    .build()
            )
            .setBufferSizeInBytes(max(minBuffer.takeIf { it > 0 } ?: 0, AUDIO_BUFFER_BYTES))
            .setTransferMode(AudioTrack.MODE_STREAM)
            .build()
        if (track.state != AudioTrack.STATE_INITIALIZED) {
            runCatching { track.release() }
            throw IOException("AudioTrack initialization failed")
        }
        return track
    }

    private fun ShortArray.peak(): Int {
        var peak = 0
        forEach { sample ->
            peak = max(peak, abs(sample.toInt()))
        }
        return peak
    }

    companion object {
        const val IAX_TRANSPORT = "android-allstar-iax"

        private const val TAG = "AllStarIax"
        private const val ALLSTAR_PROVIDER_ID = "allstar"
        private const val ALLSTAR_REGISTRATION_HOST = "register.allstarlink.org"
        private const val ALLSTAR_REGISTRATION_PORT = 4569
        private const val IAX_VERSION = 2
        private const val FULL_FRAME_BIT = 0x8000
        private const val FULL_HEADER_BYTES = 12
        private const val MINI_HEADER_BYTES = 4
        private const val RECEIVE_BYTES = 2048
        private const val SOCKET_TIMEOUT_MS = 12_000
        private const val RECEIVE_TIMEOUT_MS = 600
        private const val HTTP_REGISTRATION_TIMEOUT_MS = 15_000
        private const val HTTP_REGISTRATION_USER_AGENT = "OpenRadio/0.1.0"
        private const val HTTP_REGISTRATION_RETRY_SECONDS = 30
        private const val PING_INTERVAL_MS = 30_000L
        private const val AUTOLINK_DELAY_MS = 1_200L
        private const val DTMF_GAP_MS = 140L
        private const val REGISTRATION_TIMEOUT_MS = 12_000L
        private const val REGISTRATION_REFRESH_SECONDS = 60
        private const val SAMPLE_RATE_HZ = 8_000
        private const val AUDIO_BUFFER_BYTES = 24_000
        private const val AUDIO_PREFILL_FRAMES = 4
        private const val AUDIO_GAP_RESET_MS = 180L
        private const val ULAW_FRAME_SAMPLES = 160
        private const val FULL_VOICE_INTERVAL = 150
        private const val TX_STATUS_INTERVAL = 50

        private const val FRAME_DTMF = 1
        private const val FRAME_VOICE = 2
        private const val FRAME_CONTROL = 4
        private const val FRAME_IAX = 6

        private const val CONTROL_HANGUP = 1
        private const val CONTROL_RINGING = 3
        private const val CONTROL_ANSWER = 4
        private const val CONTROL_BUSY = 5
        private const val CONTROL_CONGESTION = 8
        private const val CONTROL_KEY_RADIO = 12
        private const val CONTROL_UNKEY_RADIO = 13

        private const val IAX_NEW = 1
        private const val IAX_PING = 2
        private const val IAX_PONG = 3
        private const val IAX_ACK = 4
        private const val IAX_HANGUP = 5
        private const val IAX_REJECT = 6
        private const val IAX_ACCEPT = 7
        private const val IAX_AUTHREQ = 8
        private const val IAX_AUTHREP = 9
        private const val IAX_LAGRQ = 11
        private const val IAX_LAGRP = 12
        private const val IAX_REGREQ = 13
        private const val IAX_REGAUTH = 14
        private const val IAX_REGACK = 15
        private const val IAX_REGREJ = 16
        private const val IAX_CALLTOKEN = 40

        private const val IE_CALLED_NUMBER = 0x01
        private const val IE_CALLING_NUMBER = 0x02
        private const val IE_CALLING_NAME = 0x04
        private const val IE_CALLED_CONTEXT = 0x05
        private const val IE_USERNAME = 0x06
        private const val IE_PASSWORD = 0x07
        private const val IE_CAPABILITY = 0x08
        private const val IE_FORMAT = 0x09
        private const val IE_VERSION = 0x0b
        private const val IE_ADSICPE = 0x0c
        private const val IE_AUTHMETHODS = 0x0e
        private const val IE_CHALLENGE = 0x0f
        private const val IE_MD5_RESULT = 0x10
        private const val IE_REFRESH = 0x13
        private const val IE_CAUSE = 0x16
        private const val IE_CAUSECODE = 0x2a
        private const val IE_CALLTOKEN = 0x36

        private const val AUTH_MD5 = 0x0002
        private const val FORMAT_ULAW = 0x00000004
    }
}

private data class AllStarIaxConfig(
    val username: String,
    val password: String,
    val callerName: String,
    val localNode: String,
    val remoteNode: String,
    val calledNode: String,
    val host: String,
    val port: Int,
    val context: String,
    val serverLabel: String,
    val directNodeLookup: Boolean,
    var autoLinked: Boolean = false
) {
    companion object {
        fun from(provider: ProviderProfile): AllStarIaxConfig {
            require(provider.type.providerId == "allstar") {
                "AllStar IAX controller can only connect AllStar profiles"
            }
            val port = provider.serverPort.toIntOrNull()?.takeIf { it in 1..65535 }
                ?: throw IllegalArgumentException("AllStar IAX port must be 1-65535")
            val localNode = provider.stationId.onlyDigits()
                .ifBlank { throw IllegalArgumentException("AllStar Local Node is required") }
            val password = provider.password.ifBlank {
                throw IllegalArgumentException("AllStar Node password is required")
            }
            val remoteNode = provider.target.onlyDigits()
            val hostOverride = provider.serverHost.trim().removePrefix("iax://").removePrefix("iax:")
            val directNodeLookup = hostOverride.isAutoAllStarHost()
            val host = if (directNodeLookup) {
                remoteNode.ifBlank {
                    throw IllegalArgumentException("AllStar Remote Node is required when server is blank or Auto")
                }.let { "$it.$ALLSTAR_NODE_DNS_DOMAIN" }
            } else {
                hostOverride
            }
            val calledNode = if (directNodeLookup) remoteNode else localNode
            val contextSetting = provider.timeSlot.trim()
            val context = if (directNodeLookup) {
                if (contextSetting == DEFAULT_CLIENT_CONTEXT || contextSetting == DEFAULT_NODE_CONTEXT) {
                    ""
                } else {
                    contextSetting
                }
            } else {
                contextSetting.ifBlank { DEFAULT_CLIENT_CONTEXT }
            }
            val username = if (directNodeLookup) {
                NODE_TO_NODE_USERNAME
            } else {
                provider.username.trim().ifBlank { localNode }
            }
            return AllStarIaxConfig(
                username = username,
                password = password,
                callerName = provider.callsign.trim().ifBlank { username },
                localNode = localNode,
                remoteNode = remoteNode,
                calledNode = calledNode,
                host = host,
                port = port,
                context = context,
                serverLabel = if (directNodeLookup) {
                    "Auto ${remoteNode}.$ALLSTAR_NODE_DNS_DOMAIN"
                } else {
                    "$host:$port"
                },
                directNodeLookup = directNodeLookup
            )
        }

        private const val ALLSTAR_NODE_DNS_DOMAIN = "nodes.allstarlink.org"
        private const val DEFAULT_CLIENT_CONTEXT = "iaxrpt"
        private const val DEFAULT_NODE_CONTEXT = "radio-secure"
        private const val NODE_TO_NODE_USERNAME = "radio"
    }
}

private data class AllStarHttpRegistrationResult(
    val ipAddress: String,
    val port: Int,
    val refresh: Int
) {
    fun nextRefreshSeconds(): Int {
        return (refresh - 30).coerceIn(HTTP_REGISTRATION_MIN_REFRESH_SECONDS, HTTP_REGISTRATION_MAX_REFRESH_SECONDS)
    }

    companion object {
        private const val HTTP_REGISTRATION_MIN_REFRESH_SECONDS = 30
        private const val HTTP_REGISTRATION_MAX_REFRESH_SECONDS = 45
    }
}

private data class AudioRecordCapture(
    val record: AudioRecord,
    val sourceLabel: String
)

private data class IaxFrame(
    val sourceCallNumber: Int,
    val destinationCallNumber: Int,
    val timestamp: Int,
    val oSeqNo: Int,
    val iSeqNo: Int,
    val frameType: Int,
    val subclass: Int,
    val payload: ByteArray,
    val ies: Map<Int, ByteArray>
) {
    fun rejectMessage(fallback: String = "AllStar IAX rejected the call"): String {
        val cause = ies[0x16]?.toStringValue()
        val code = ies[0x2a]?.firstOrNull()?.toInt()?.and(0xff)
        return listOfNotNull(cause, code?.let { "code $it" })
            .joinToString(" ")
            .ifBlank { fallback }
    }
}

private class IaxIeBuilder {
    private val output = ByteArrayOutputStream()

    fun string(id: Int, value: String) {
        bytes(id, value.toByteArray(Charsets.UTF_8))
    }

    fun byte(id: Int, value: Int) {
        bytes(id, byteArrayOf(value.toByte()))
    }

    fun short(id: Int, value: Int) {
        bytes(id, byteArrayOf(((value ushr 8) and 0xff).toByte(), (value and 0xff).toByte()))
    }

    fun int(id: Int, value: Int) {
        bytes(
            id,
            byteArrayOf(
                ((value ushr 24) and 0xff).toByte(),
                ((value ushr 16) and 0xff).toByte(),
                ((value ushr 8) and 0xff).toByte(),
                (value and 0xff).toByte()
            )
        )
    }

    fun bytes(id: Int, value: ByteArray) {
        output.write(id and 0xff)
        output.write(value.size and 0xff)
        output.write(value)
    }

    fun build(): ByteArray = output.toByteArray()
}

private fun buildIes(block: IaxIeBuilder.() -> Unit): ByteArray {
    return IaxIeBuilder().apply(block).build()
}

private fun parseIes(payload: ByteArray): Map<Int, ByteArray> {
    val ies = linkedMapOf<Int, ByteArray>()
    var offset = 0
    while (offset + 2 <= payload.size) {
        val id = payload[offset].toInt() and 0xff
        val length = payload[offset + 1].toInt() and 0xff
        offset += 2
        if (offset + length > payload.size) {
            break
        }
        ies[id] = payload.copyOfRange(offset, offset + length)
        offset += length
    }
    return ies
}

private fun encodeSubclass(subclass: Int): Byte {
    if (subclass > 0 && (subclass and (subclass - 1)) == 0 && subclass > 0x7f) {
        return (0x80 or Integer.numberOfTrailingZeros(subclass)).toByte()
    }
    return (subclass and 0x7f).toByte()
}

private fun decodeSubclass(encoded: Int): Int {
    return if ((encoded and 0x80) != 0) {
        1 shl (encoded and 0x7f)
    } else {
        encoded and 0x7f
    }
}

private fun ByteArray.u16(offset: Int): Int {
    return ((this[offset].toInt() and 0xff) shl 8) or (this[offset + 1].toInt() and 0xff)
}

private fun ByteArray.u32(offset: Int): Int {
    return ((this[offset].toInt() and 0xff) shl 24) or
        ((this[offset + 1].toInt() and 0xff) shl 16) or
        ((this[offset + 2].toInt() and 0xff) shl 8) or
        (this[offset + 3].toInt() and 0xff)
}

private fun ByteArray.putU16(offset: Int, value: Int) {
    this[offset] = ((value ushr 8) and 0xff).toByte()
    this[offset + 1] = (value and 0xff).toByte()
}

private fun ByteArray.putU32(offset: Int, value: Int) {
    this[offset] = ((value ushr 24) and 0xff).toByte()
    this[offset + 1] = ((value ushr 16) and 0xff).toByte()
    this[offset + 2] = ((value ushr 8) and 0xff).toByte()
    this[offset + 3] = (value and 0xff).toByte()
}

private fun ByteArray.toStringValue(): String {
    return toString(Charsets.UTF_8).trim()
}

private fun ByteArray.toShortValue(): Int {
    return when (size) {
        0 -> 0
        1 -> this[0].toInt() and 0xff
        else -> u16(0)
    }
}

private fun ByteArray.toIntValue(): Int {
    return when (size) {
        0 -> 0
        1 -> this[0].toInt() and 0xff
        2 -> u16(0)
        3 -> ((this[0].toInt() and 0xff) shl 16) or ((this[1].toInt() and 0xff) shl 8) or (this[2].toInt() and 0xff)
        else -> u32(0)
    }
}

private fun String.onlyDigits(): String {
    return filter { it.isDigit() }
}

private fun String.isAutoAllStarHost(): Boolean {
    val normalized = trim().lowercase()
    return normalized.isBlank() ||
        normalized == "auto" ||
        normalized == "allstar.example.net" ||
        normalized == "nodes.allstarlink.org"
}

private fun md5Hex(value: String): String {
    return MessageDigest.getInstance("MD5")
        .digest(value.toByteArray(Charsets.UTF_8))
        .joinToString("") { byte -> "%02x".format(byte.toInt() and 0xff) }
}

private object G711 {
    private const val BIAS = 0x84
    private const val CLIP = 32635

    fun ulawToLinear(value: Byte): Short {
        val ulaw = value.toInt().inv() and 0xff
        var sample = ((ulaw and 0x0f) shl 3) + BIAS
        sample = sample shl ((ulaw and 0x70) shr 4)
        sample = if ((ulaw and 0x80) != 0) {
            BIAS - sample
        } else {
            sample - BIAS
        }
        return sample.coerceIn(Short.MIN_VALUE.toInt(), Short.MAX_VALUE.toInt()).toShort()
    }

    fun linearToUlaw(value: Short): Byte {
        var sample = value.toInt()
        val sign = if (sample < 0) {
            sample = -sample
            0x80
        } else {
            0
        }
        sample = sample.coerceAtMost(CLIP) + BIAS
        var exponent = 7
        var mask = 0x4000
        while ((sample and mask) == 0 && exponent > 0) {
            exponent -= 1
            mask = mask shr 1
        }
        val mantissa = (sample shr (exponent + 3)) and 0x0f
        return (sign or (exponent shl 4) or mantissa).inv().toByte()
    }
}
