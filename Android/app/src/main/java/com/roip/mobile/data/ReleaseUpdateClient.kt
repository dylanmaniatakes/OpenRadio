package com.roip.mobile.data

import android.content.Context
import java.io.File
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONObject

class ReleaseUpdateClient(
    private val owner: String,
    private val repo: String,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend fun findNewerRelease(currentVersionName: String): GitHubApkRelease? = withContext(dispatcher) {
        val currentParts = currentVersionName.versionParts()
        val releases = fetchJsonArray("https://api.github.com/repos/$owner/$repo/releases")
        (0 until releases.length())
            .asSequence()
            .mapNotNull { index -> releases.optJSONObject(index)?.toApkRelease() }
            .filter { release -> compareVersionParts(release.versionParts, currentParts) > 0 }
            .maxWithOrNull { first, second -> compareVersionParts(first.versionParts, second.versionParts) }
    }

    suspend fun downloadApk(context: Context, release: GitHubApkRelease): File = withContext(dispatcher) {
        val updateDir = File(context.cacheDir, UPDATE_DIR_NAME).apply { mkdirs() }
        updateDir.listFiles()?.forEach { file ->
            if (file.extension.equals("apk", ignoreCase = true)) {
                file.delete()
            }
        }

        val target = File(updateDir, release.assetName.safeFileName())
        val connection = openConnection(release.downloadUrl, accept = "application/octet-stream")
        try {
            val code = connection.responseCode
            if (code !in 200..299) {
                throw IOException("APK download failed with HTTP $code")
            }
            connection.inputStream.use { input ->
                target.outputStream().use { output ->
                    input.copyTo(output)
                }
            }
        } finally {
            connection.disconnect()
        }
        target
    }

    private fun fetchJsonArray(url: String): JSONArray {
        val connection = openConnection(url, accept = "application/vnd.github+json")
        try {
            val code = connection.responseCode
            val body = (if (code in 200..299) connection.inputStream else connection.errorStream)
                ?.bufferedReader()
                ?.use { it.readText() }
                .orEmpty()
            if (code !in 200..299) {
                throw IOException("GitHub releases check failed with HTTP $code")
            }
            return JSONArray(body)
        } finally {
            connection.disconnect()
        }
    }

    private fun openConnection(url: String, accept: String): HttpURLConnection {
        return (URL(url).openConnection() as HttpURLConnection).apply {
            requestMethod = "GET"
            instanceFollowRedirects = true
            connectTimeout = NETWORK_TIMEOUT_MS
            readTimeout = NETWORK_TIMEOUT_MS
            useCaches = false
            setRequestProperty("Accept", accept)
            setRequestProperty("User-Agent", "OpenRadio update checker")
            setRequestProperty("X-GitHub-Api-Version", "2022-11-28")
        }
    }

    private fun JSONObject.toApkRelease(): GitHubApkRelease? {
        if (optBoolean("draft", false)) {
            return null
        }
        val tag = optString("tag_name").trim()
        val name = optString("name").trim()
        val versionSource = listOf(tag, name).firstOrNull { it.versionParts().isNotEmpty() }
            ?: return null
        val asset = optJSONArray("assets")?.apkAsset() ?: return null
        return GitHubApkRelease(
            title = name.ifBlank { tag },
            tagName = tag,
            versionLabel = versionSource,
            versionParts = versionSource.versionParts(),
            htmlUrl = optString("html_url").trim(),
            assetName = asset.optString("name").trim().ifBlank { "OpenRadio-$versionSource.apk" },
            downloadUrl = asset.optString("browser_download_url").trim()
        ).takeIf { it.downloadUrl.isNotBlank() }
    }

    private fun JSONArray.apkAsset(): JSONObject? {
        return (0 until length())
            .asSequence()
            .mapNotNull { index -> optJSONObject(index) }
            .filter { asset ->
                val name = asset.optString("name")
                val contentType = asset.optString("content_type")
                name.endsWith(".apk", ignoreCase = true) ||
                    contentType.equals("application/vnd.android.package-archive", ignoreCase = true)
            }
            .sortedByDescending { asset ->
                val name = asset.optString("name").lowercase()
                when {
                    "openradio" in name && "release" in name && "signed" in name -> 4
                    "openradio" in name && "release" in name -> 3
                    "release" in name -> 2
                    "openradio" in name -> 1
                    else -> 0
                }
            }
            .firstOrNull()
    }

    private fun String.safeFileName(): String {
        val cleaned = replace(Regex("""[^A-Za-z0-9._-]+"""), "-").trim('-', '.')
        return cleaned.takeIf { it.endsWith(".apk", ignoreCase = true) } ?: "$cleaned.apk"
    }

    private companion object {
        private const val NETWORK_TIMEOUT_MS = 15_000
        private const val UPDATE_DIR_NAME = "github-updates"
    }
}

data class GitHubApkRelease(
    val title: String,
    val tagName: String,
    val versionLabel: String,
    val versionParts: List<Int>,
    val htmlUrl: String,
    val assetName: String,
    val downloadUrl: String
)

fun String.versionParts(): List<Int> {
    return Regex("""\d+""").findAll(this).mapNotNull { it.value.toIntOrNull() }.toList()
}

fun compareVersionParts(first: List<Int>, second: List<Int>): Int {
    val width = maxOf(first.size, second.size)
    for (index in 0 until width) {
        val left = first.getOrElse(index) { 0 }
        val right = second.getOrElse(index) { 0 }
        if (left != right) {
            return left.compareTo(right)
        }
    }
    return 0
}
