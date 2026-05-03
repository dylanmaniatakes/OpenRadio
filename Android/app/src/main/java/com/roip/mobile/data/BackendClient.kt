package com.roip.mobile.data

import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONObject

class BackendClient(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend fun healthCheck(baseUrl: String): JSONObject {
        return request(
            baseUrl = baseUrl,
            path = "/health"
        )
    }

    suspend fun createSession(baseUrl: String, profile: ProviderProfile, radioProfile: ComjotProfile): SessionSnapshot {
        val payload = JSONObject()
            .put("providerId", profile.type.providerId)
            .put("callsign", profile.callsign.trim())
            .put("stationId", profile.stationId.trim())
            .put("target", profile.target.trim())
            .put("serverHost", profile.serverHost.trim())
            .put("serverPort", profile.serverPort.trim().toIntOrNull() ?: 0)
            .put("password", profile.password)
            .put("rxFrequency", radioProfile.rxFrequency.toFrequencyHzOrNull() ?: DEFAULT_DMR_FREQUENCY_HZ)
            .put("txFrequency", radioProfile.txFrequency.toFrequencyHzOrNull() ?: DEFAULT_DMR_FREQUENCY_HZ)
            .put("colorCode", radioProfile.colorCode.trim().toIntOrNull() ?: DEFAULT_COLOR_CODE)
            .put("timeSlot", profile.timeSlot.trim().toIntOrNull() ?: DEFAULT_TIME_SLOT)
            .put("power", if (radioProfile.rfPower.highPower) HIGH_POWER_WATTS else LOW_POWER_WATTS)
            .put("location", "OpenRadio CJ1")
            .put("description", "CJ-1 OpenRadio")

        val response = request(
            baseUrl = baseUrl,
            path = "/api/v1/sessions",
            method = "POST",
            payload = payload
        )

        return parseSession(response.getJSONObject("session"))
    }

    suspend fun fetchSession(baseUrl: String, sessionId: String): SessionSnapshot {
        val response = request(
            baseUrl = baseUrl,
            path = "/api/v1/sessions/$sessionId"
        )

        return parseSession(response.getJSONObject("session"))
    }

    suspend fun setPtt(baseUrl: String, sessionId: String, pressed: Boolean): SessionSnapshot {
        val response = request(
            baseUrl = baseUrl,
            path = "/api/v1/sessions/$sessionId/ptt",
            method = "POST",
            payload = JSONObject().put("pressed", pressed)
        )

        return parseSession(response.getJSONObject("session"))
    }

    suspend fun deleteSession(baseUrl: String, sessionId: String) {
        request(
            baseUrl = baseUrl,
            path = "/api/v1/sessions/$sessionId",
            method = "DELETE"
        )
    }

    private suspend fun request(
        baseUrl: String,
        path: String,
        method: String = "GET",
        payload: JSONObject? = null
    ): JSONObject = withContext(dispatcher) {
        val endpoint = URL("${normalizeBaseUrl(baseUrl)}$path")
        val connection = endpoint.openConnection() as HttpURLConnection
        try {
            connection.requestMethod = method
            connection.connectTimeout = 5_000
            connection.readTimeout = 5_000
            connection.useCaches = false
            connection.setRequestProperty("Accept", "application/json")
            connection.setRequestProperty("Content-Type", "application/json")

            if (payload != null) {
                connection.doOutput = true
                connection.outputStream.use { stream ->
                    stream.write(payload.toString().toByteArray())
                }
            }

            val code = connection.responseCode
            val source = if (code in 200..299) connection.inputStream else connection.errorStream
            val body = source?.bufferedReader()?.use { it.readText() }.orEmpty()

            if (code !in 200..299) {
                val message = runCatching {
                    JSONObject(body).optString("error")
                }.getOrNull().takeUnless { it.isNullOrBlank() } ?: "Request failed with HTTP $code"
                throw IOException(message)
            }

            if (body.isBlank()) {
                return@withContext JSONObject()
            }

            return@withContext JSONObject(body)
        } finally {
            connection.disconnect()
        }
    }

    fun normalizeBaseUrl(baseUrl: String): String {
        val trimmed = baseUrl.trim().trimEnd('/').ifBlank { "http://10.0.2.2:$DEFAULT_RELAY_PORT" }
        val withScheme = if ("://" in trimmed) trimmed else "http://$trimmed"
        val parsed = URL(withScheme)
        val resolvedPort = if (parsed.protocol.equals("http", ignoreCase = true) && parsed.port == -1) {
            DEFAULT_RELAY_PORT
        } else {
            parsed.port
        }
        val file = parsed.file.takeIf { it.isNotBlank() && it != "/" } ?: ""
        return URL(parsed.protocol, parsed.host, resolvedPort, file).toString().trimEnd('/')
    }

    private fun parseSession(json: JSONObject): SessionSnapshot {
        return SessionSnapshot(
            id = json.optString("id"),
            providerId = json.optString("providerId"),
            providerName = json.optString("providerName"),
            phase = json.optString("phase"),
            statusMessage = json.optString("statusMessage"),
            target = json.optString("target"),
            serverHost = json.optString("serverHost"),
            transport = json.optString("transport"),
            warnings = parseStrings(json.optJSONArray("warnings")),
            pttActive = json.optBoolean("pttActive"),
            requiresMediaBridge = json.optBoolean("requiresMediaBridge"),
            inboundDmrFrames = json.optInt("inboundDmrFrames"),
            inboundDmrVoiceFrames = json.optInt("inboundDmrVoiceFrames"),
            inboundDmrDataFrames = json.optInt("inboundDmrDataFrames"),
            inboundAmbeFrames = json.optInt("inboundAmbeFrames"),
            lastInboundDmrAtMillis = json.optLongOrNull("lastInboundDmrAtMillis"),
            lastInboundSourceId = json.optIntOrNull("lastInboundSourceId"),
            lastInboundCallsign = json.optStringOrNull("lastInboundCallsign"),
            lastInboundName = json.optStringOrNull("lastInboundName"),
            lastInboundLocation = json.optStringOrNull("lastInboundLocation"),
            lastInboundTargetId = json.optIntOrNull("lastInboundTargetId"),
            lastInboundStreamId = json.optLongOrNull("lastInboundStreamId"),
            lastInboundSlot = json.optIntOrNull("lastInboundSlot"),
            lastInboundFrameType = json.optStringOrNull("lastInboundFrameType"),
            audioDecoderState = json.optStringOrNull("audioDecoderState")
        )
    }

    private fun JSONObject.optIntOrNull(name: String): Int? {
        return if (has(name) && !isNull(name)) optInt(name) else null
    }

    private fun JSONObject.optLongOrNull(name: String): Long? {
        return if (has(name) && !isNull(name)) optLong(name) else null
    }

    private fun JSONObject.optStringOrNull(name: String): String? {
        return if (has(name) && !isNull(name)) optString(name).takeIf { it.isNotBlank() } else null
    }

    private fun parseStrings(array: JSONArray?): List<String> {
        if (array == null) {
            return emptyList()
        }

        return buildList {
            for (index in 0 until array.length()) {
                add(array.optString(index))
            }
        }
    }

    private fun String.toFrequencyHzOrNull(): Long? {
        val mhz = trim().toDoubleOrNull() ?: return null
        if (mhz <= 0.0) {
            return null
        }

        return (mhz * 1_000_000.0).toLong()
    }

    private companion object {
        private const val DEFAULT_RELAY_PORT = 8787
        private const val DEFAULT_DMR_FREQUENCY_HZ = 446_500_000L
        private const val DEFAULT_COLOR_CODE = 1
        private const val DEFAULT_TIME_SLOT = 2
        private const val LOW_POWER_WATTS = 1
        private const val HIGH_POWER_WATTS = 5
    }
}
