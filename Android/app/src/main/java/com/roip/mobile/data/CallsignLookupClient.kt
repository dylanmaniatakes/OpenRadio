package com.roip.mobile.data

import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject

class CallsignLookupClient(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend fun lookup(callsign: String): CallerLookup = withContext(dispatcher) {
        val normalized = callsign.normalizedCallsign()
            ?: throw IllegalArgumentException("No valid callsign to look up")
        val encoded = URLEncoder.encode(normalized, Charsets.UTF_8.name())
        val connection = (URL("$OPENCALLBOOK_LICENSE_URL/$encoded").openConnection() as HttpURLConnection)
        try {
            connection.requestMethod = "GET"
            connection.connectTimeout = LOOKUP_TIMEOUT_MS
            connection.readTimeout = LOOKUP_TIMEOUT_MS
            connection.useCaches = true
            connection.setRequestProperty("Accept", "application/json")
            connection.setRequestProperty("User-Agent", "OpenRadio/0.1 callsign lookup")

            val code = connection.responseCode
            val source = if (code in 200..299) connection.inputStream else connection.errorStream
            val body = source?.bufferedReader()?.use { it.readText() }.orEmpty()
            if (code == HttpURLConnection.HTTP_NOT_FOUND) {
                return@withContext CallerLookup(
                    callsign = normalized,
                    qrzUrl = normalized.qrzLookupUrl(),
                    qthUrl = normalized.qthLookupUrl(),
                    error = "No FCC/OpenCallbook record"
                )
            }
            if (code !in 200..299) {
                throw IOException("Callsign lookup failed with HTTP $code")
            }
            return@withContext JSONObject(body).toCallerLookup(normalized)
        } finally {
            connection.disconnect()
        }
    }

    private fun JSONObject.toCallerLookup(callsign: String): CallerLookup {
        val licensee = optJSONObject("licensee")
        val dmr = optJSONArray("dmr")?.optJSONObject(0)
        val allstar = optJSONArray("allstar")?.optJSONObject(0)
        val pota = optJSONObject("pota")
        val name = listOfNotNull(
            licensee?.optCleanString("name"),
            dmr?.optCleanString("name"),
            pota?.optCleanString("name")
        ).firstOrNull { it.isNotBlank() }
        val licenseeLocation = listOfNotNull(
            licensee?.optCleanString("city"),
            licensee?.optCleanString("state")
        ).joinToString(", ").takeIf { it.isNotBlank() }
        val dmrLocation = listOfNotNull(
            dmr?.optCleanString("city"),
            dmr?.optCleanString("state"),
            dmr?.optCleanString("country")
        ).joinToString(", ").takeIf { it.isNotBlank() }
        val location = listOfNotNull(
            licenseeLocation,
            pota?.optCleanString("qth"),
            allstar?.optCleanString("location"),
            dmrLocation
        ).firstOrNull { it.isNotBlank() }
        val licenseClass = listOfNotNull(
            optCleanString("operator_class"),
            optCleanString("license_class"),
            optCleanString("service_code"),
            optCleanString("service")
        ).firstOrNull { it.isNotBlank() }
        return CallerLookup(
            callsign = callsign,
            name = name,
            location = location,
            status = optCleanString("status"),
            licenseClass = licenseClass,
            expires = optCleanString("expired_date"),
            fccUrl = optCleanString("fcc_uls_url"),
            qrzUrl = callsign.qrzLookupUrl(),
            qthUrl = callsign.qthLookupUrl()
        )
    }

    private fun JSONObject.optCleanString(name: String): String? {
        return if (has(name) && !isNull(name)) {
            optString(name).trim().takeIf { it.isNotBlank() }
        } else {
            null
        }
    }

    private companion object {
        private const val OPENCALLBOOK_LICENSE_URL = "https://opencallbook.com/api/v1/licenses"
        private const val LOOKUP_TIMEOUT_MS = 4_000
    }
}

fun String.normalizedCallsign(): String? {
    val normalized = trim()
        .uppercase()
        .filter { it.isLetterOrDigit() || it == '/' }
        .trim('/')
    return normalized.takeIf { value ->
        value.length in 3..12 && value.any { it.isLetter() } && value.any { it.isDigit() }
    }
}

fun String.qrzLookupUrl(): String = "https://www.qrz.com/db/${URLEncoder.encode(this, Charsets.UTF_8.name())}"

fun String.qthLookupUrl(): String = "https://www.qth.com/callsign.php?cs=${URLEncoder.encode(this, Charsets.UTF_8.name())}"
