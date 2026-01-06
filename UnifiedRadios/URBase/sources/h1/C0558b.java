package h1;

import L0.m;
import O.C0182v;
import a.AbstractC0203a;
import android.content.Context;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import androidx.cardview.widget.CardView;
import com.unified.ur1.SatelliteTracker.h;
import com.unified.ur1.primary.LaunchActivity;
import h4.e;
import j0.InterfaceC0591d;
import j3.g;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Map;
import k4.l;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p.AbstractC0817b;
import p.C0816a;
import r3.InterfaceC0877a;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import y1.C0981c;
import y1.InterfaceC0980b;

/* renamed from: h1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0558b implements InterfaceC0877a, InterfaceC0591d, Callback, y1.d {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f7082c;

    public /* synthetic */ C0558b(int i5) {
        this.f7082c = i5;
    }

    public static void a(g gVar) {
        double d5 = gVar.f7616a;
        gVar.f7621f = d5 > 1020.0d;
        double d6 = d5 > 1030.0d ? 0.4d : d5 > 1025.0d ? 0.3d : d5 > 1020.0d ? 0.2d : d5 > 1015.0d ? 0.1d : 0.0d;
        double d7 = gVar.f7618c;
        if (d7 > 80.0d) {
            d6 += 0.3d;
        } else if (d7 > 70.0d) {
            d6 += 0.2d;
        } else if (d7 > 60.0d) {
            d6 += 0.1d;
        }
        double d8 = gVar.f7619d;
        if (d8 < 5.0d) {
            d6 += 0.2d;
        } else if (d8 < 10.0d) {
            d6 += 0.1d;
        }
        if (gVar.f7620e.toLowerCase().contains("clear") || gVar.f7620e.toLowerCase().contains("sunny")) {
            d6 += 0.1d;
        }
        double dMin = Math.min(1.0d, d6);
        gVar.h = dMin;
        gVar.g = dMin > 0.5d;
        Log.d("WeatherDataManager", String.format("Tropo analysis: Score=%.2f, Ducting=%s, HighP=%s", Double.valueOf(dMin), Boolean.valueOf(gVar.g), Boolean.valueOf(gVar.f7621f)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v28, types: [java.io.Closeable, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r14v15, types: [java.io.ByteArrayOutputStream, java.io.Closeable, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r15v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r15v10, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v13 */
    /* JADX WARN: Type inference failed for: r15v14 */
    /* JADX WARN: Type inference failed for: r15v15 */
    /* JADX WARN: Type inference failed for: r15v16 */
    /* JADX WARN: Type inference failed for: r15v17 */
    /* JADX WARN: Type inference failed for: r15v18 */
    /* JADX WARN: Type inference failed for: r15v19 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v20, types: [java.io.BufferedOutputStream, java.io.Closeable, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2 */
    public static Drawable b(long j5, int i5, String str, e eVar, i4.d dVar) throws Throwable {
        Throwable th;
        ?? bufferedOutputStream;
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayInputStream byteArrayInputStream2;
        ByteArrayInputStream byteArrayInputStream3;
        HttpURLConnection httpURLConnection;
        Throwable th2;
        ByteArrayInputStream byteArrayInputStream4;
        IOException iOException;
        ByteArrayInputStream byteArrayInputStream5;
        UnknownHostException unknownHostException;
        ByteArrayInputStream byteArrayInputStream6;
        FileNotFoundException fileNotFoundException;
        ByteArrayInputStream byteArrayInputStream7;
        i4.a aVar;
        ByteArrayInputStream byteArrayInputStream8;
        ByteArrayInputStream byteArrayInputStream9;
        ByteArrayInputStream byteArrayInputStream10;
        ByteArrayInputStream byteArrayInputStream11;
        ByteArrayInputStream byteArrayInputStream12;
        ByteArrayInputStream byteArrayInputStream13;
        ByteArrayInputStream byteArrayInputStream14;
        ByteArrayInputStream byteArrayInputStream15;
        ByteArrayInputStream byteArrayInputStream16;
        ByteArrayInputStream byteArrayInputStream17;
        ByteArrayInputStream byteArrayInputStream18;
        ByteArrayInputStream byteArrayInputStream19;
        ByteArrayInputStream byteArrayInputStream20;
        ByteArrayInputStream byteArrayInputStream21;
        ByteArrayInputStream byteArrayInputStream22;
        ?? inputStream;
        ByteArrayInputStream byteArrayInputStream23;
        String string;
        String str2 = "https://";
        ?? r9 = null;
        if (i5 > 3) {
            return null;
        }
        C0182v c0182v = dVar.f7373i;
        if (c0182v.c()) {
            e4.a.g().getClass();
        }
        String str3 = e4.a.g().f6223a;
        try {
            if (!c0182v.a(str3)) {
                Log.e("OsmDroid", "Please configure a relevant user agent; current value is: " + str3);
                return null;
            }
            try {
                e4.a.g().getClass();
                if (TextUtils.isEmpty(str)) {
                    try {
                        throw null;
                    } catch (Exception unused) {
                        return null;
                    }
                }
                e4.a.g().getClass();
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                try {
                    httpURLConnection.setUseCaches(true);
                    try {
                        e4.a.g().getClass();
                        httpURLConnection.setRequestProperty("User-Agent", str3);
                        for (Map.Entry entry : e4.a.g().f6224b.entrySet()) {
                            httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                        }
                        httpURLConnection.connect();
                        if (httpURLConnection.getResponseCode() != 200) {
                            int responseCode = httpURLConnection.getResponseCode();
                            if ((responseCode != 301 && responseCode != 302 && responseCode != 307 && responseCode != 308) || !e4.a.g().c()) {
                                Log.w("OsmDroid", "Problem downloading MapTile: " + l.k(j5) + " HTTP response: " + httpURLConnection.getResponseMessage());
                                e4.a.g().getClass();
                                int i6 = j4.a.f7622a;
                                AbstractC0203a.c(httpURLConnection.getErrorStream());
                                try {
                                    httpURLConnection.disconnect();
                                } catch (Exception unused2) {
                                }
                                return null;
                            }
                            String headerField = httpURLConnection.getHeaderField("Location");
                            if (headerField != null) {
                                if (headerField.startsWith("/")) {
                                    URL url = new URL(str);
                                    int port = url.getPort();
                                    boolean zStartsWith = str.toLowerCase().startsWith("https://");
                                    if (port == -1) {
                                        port = str.toLowerCase().startsWith("http://") ? 80 : 443;
                                    }
                                    StringBuilder sb = new StringBuilder();
                                    if (!zStartsWith) {
                                        str2 = "http";
                                    }
                                    sb.append(str2);
                                    sb.append(url.getHost());
                                    sb.append(":");
                                    sb.append(port);
                                    sb.append(headerField);
                                    string = sb.toString();
                                } else {
                                    string = headerField;
                                }
                                Log.i("OsmDroid", "Http redirect for MapTile: " + l.k(j5) + " HTTP response: " + httpURLConnection.getResponseMessage() + " to url " + string);
                                Drawable drawableB = b(j5, i5 + 1, string, eVar, dVar);
                                try {
                                    httpURLConnection.disconnect();
                                } catch (Exception unused3) {
                                }
                                return drawableB;
                            }
                        }
                        String headerField2 = httpURLConnection.getHeaderField("Content-Type");
                        e4.a.g().getClass();
                        if (headerField2 != null && !headerField2.toLowerCase().contains("image")) {
                            Log.w("OsmDroid", str + " success, however the mime type does not appear to be an image " + headerField2);
                        }
                        inputStream = httpURLConnection.getInputStream();
                    } catch (i4.a e5) {
                        e = e5;
                        aVar = e;
                        byteArrayInputStream2 = null;
                        ByteArrayInputStream byteArrayInputStream24 = byteArrayInputStream2;
                        bufferedOutputStream = byteArrayInputStream24;
                        byteArrayInputStream22 = byteArrayInputStream24;
                        try {
                            int i7 = j4.a.f7622a;
                            Log.w("OsmDroid", "LowMemoryException downloading MapTile: " + l.k(j5) + " : " + aVar);
                            throw new h4.b(aVar);
                        } catch (Throwable th3) {
                            th = th3;
                            byteArrayInputStream3 = r9;
                            byteArrayInputStream = byteArrayInputStream22;
                            AbstractC0203a.c(byteArrayInputStream3);
                            AbstractC0203a.c(bufferedOutputStream);
                            AbstractC0203a.c(byteArrayInputStream2);
                            AbstractC0203a.c(byteArrayInputStream);
                            try {
                                httpURLConnection.disconnect();
                                throw th;
                            } catch (Exception unused4) {
                                throw th;
                            }
                        }
                    } catch (FileNotFoundException e6) {
                        e = e6;
                        fileNotFoundException = e;
                        byteArrayInputStream7 = null;
                        byteArrayInputStream2 = byteArrayInputStream7;
                        byteArrayInputStream11 = byteArrayInputStream7;
                        ByteArrayInputStream byteArrayInputStream25 = byteArrayInputStream2;
                        bufferedOutputStream = byteArrayInputStream25;
                        byteArrayInputStream21 = byteArrayInputStream11;
                        byteArrayInputStream20 = byteArrayInputStream25;
                        int i8 = j4.a.f7622a;
                        Log.w("OsmDroid", "Tile not found: " + l.k(j5) + " : " + fileNotFoundException);
                        byteArrayInputStream19 = byteArrayInputStream21;
                        byteArrayInputStream18 = byteArrayInputStream20;
                        AbstractC0203a.c(byteArrayInputStream19);
                        AbstractC0203a.c(bufferedOutputStream);
                        AbstractC0203a.c(byteArrayInputStream2);
                        AbstractC0203a.c(byteArrayInputStream18);
                        try {
                            httpURLConnection.disconnect();
                        } catch (Exception unused5) {
                        }
                        return null;
                    } catch (UnknownHostException e7) {
                        e = e7;
                        unknownHostException = e;
                        byteArrayInputStream6 = null;
                        byteArrayInputStream2 = byteArrayInputStream6;
                        byteArrayInputStream10 = byteArrayInputStream6;
                        ByteArrayInputStream byteArrayInputStream26 = byteArrayInputStream2;
                        bufferedOutputStream = byteArrayInputStream26;
                        byteArrayInputStream17 = byteArrayInputStream10;
                        byteArrayInputStream16 = byteArrayInputStream26;
                        Log.w("OsmDroid", "UnknownHostException downloading MapTile: " + l.k(j5) + " : " + unknownHostException);
                        int i9 = j4.a.f7622a;
                        byteArrayInputStream19 = byteArrayInputStream17;
                        byteArrayInputStream18 = byteArrayInputStream16;
                        AbstractC0203a.c(byteArrayInputStream19);
                        AbstractC0203a.c(bufferedOutputStream);
                        AbstractC0203a.c(byteArrayInputStream2);
                        AbstractC0203a.c(byteArrayInputStream18);
                        httpURLConnection.disconnect();
                        return null;
                    } catch (IOException e8) {
                        e = e8;
                        iOException = e;
                        byteArrayInputStream5 = null;
                        byteArrayInputStream2 = byteArrayInputStream5;
                        byteArrayInputStream9 = byteArrayInputStream5;
                        ByteArrayInputStream byteArrayInputStream27 = byteArrayInputStream2;
                        bufferedOutputStream = byteArrayInputStream27;
                        byteArrayInputStream15 = byteArrayInputStream9;
                        byteArrayInputStream14 = byteArrayInputStream27;
                        int i10 = j4.a.f7622a;
                        Log.w("OsmDroid", "IOException downloading MapTile: " + l.k(j5) + " : " + iOException);
                        byteArrayInputStream19 = byteArrayInputStream15;
                        byteArrayInputStream18 = byteArrayInputStream14;
                        AbstractC0203a.c(byteArrayInputStream19);
                        AbstractC0203a.c(bufferedOutputStream);
                        AbstractC0203a.c(byteArrayInputStream2);
                        AbstractC0203a.c(byteArrayInputStream18);
                        httpURLConnection.disconnect();
                        return null;
                    } catch (Throwable th4) {
                        th = th4;
                        th2 = th;
                        byteArrayInputStream4 = null;
                        byteArrayInputStream2 = byteArrayInputStream4;
                        byteArrayInputStream8 = byteArrayInputStream4;
                        ByteArrayInputStream byteArrayInputStream28 = byteArrayInputStream2;
                        bufferedOutputStream = byteArrayInputStream28;
                        byteArrayInputStream13 = byteArrayInputStream8;
                        byteArrayInputStream12 = byteArrayInputStream28;
                        int i11 = j4.a.f7622a;
                        Log.e("OsmDroid", "Error downloading MapTile: " + l.k(j5), th2);
                        byteArrayInputStream19 = byteArrayInputStream13;
                        byteArrayInputStream18 = byteArrayInputStream12;
                        AbstractC0203a.c(byteArrayInputStream19);
                        AbstractC0203a.c(bufferedOutputStream);
                        AbstractC0203a.c(byteArrayInputStream2);
                        AbstractC0203a.c(byteArrayInputStream18);
                        httpURLConnection.disconnect();
                        return null;
                    }
                    try {
                        ?? byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            bufferedOutputStream = new BufferedOutputStream(byteArrayOutputStream, 8192);
                            try {
                                long jCurrentTimeMillis = System.currentTimeMillis();
                                c0182v.getClass();
                                long jB = C0182v.b(httpURLConnection, jCurrentTimeMillis);
                                try {
                                    byte[] bArr = new byte[8192];
                                    while (true) {
                                        int i12 = inputStream.read(bArr);
                                        if (i12 == -1) {
                                            break;
                                        }
                                        bufferedOutputStream.write(bArr, 0, i12);
                                    }
                                    bufferedOutputStream.flush();
                                    byteArrayInputStream2 = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                                    if (eVar != null) {
                                        try {
                                            eVar.a(dVar, j5, byteArrayInputStream2, Long.valueOf(jB));
                                            byteArrayInputStream2.reset();
                                        } catch (i4.a e9) {
                                            aVar = e9;
                                            byteArrayInputStream23 = byteArrayOutputStream;
                                            r9 = inputStream;
                                            byteArrayInputStream22 = byteArrayInputStream23;
                                            int i72 = j4.a.f7622a;
                                            Log.w("OsmDroid", "LowMemoryException downloading MapTile: " + l.k(j5) + " : " + aVar);
                                            throw new h4.b(aVar);
                                        } catch (FileNotFoundException e10) {
                                            fileNotFoundException = e10;
                                            byteArrayInputStream21 = inputStream;
                                            byteArrayInputStream20 = byteArrayOutputStream;
                                            int i82 = j4.a.f7622a;
                                            Log.w("OsmDroid", "Tile not found: " + l.k(j5) + " : " + fileNotFoundException);
                                            byteArrayInputStream19 = byteArrayInputStream21;
                                            byteArrayInputStream18 = byteArrayInputStream20;
                                            AbstractC0203a.c(byteArrayInputStream19);
                                            AbstractC0203a.c(bufferedOutputStream);
                                            AbstractC0203a.c(byteArrayInputStream2);
                                            AbstractC0203a.c(byteArrayInputStream18);
                                            httpURLConnection.disconnect();
                                            return null;
                                        } catch (UnknownHostException e11) {
                                            unknownHostException = e11;
                                            byteArrayInputStream17 = inputStream;
                                            byteArrayInputStream16 = byteArrayOutputStream;
                                            Log.w("OsmDroid", "UnknownHostException downloading MapTile: " + l.k(j5) + " : " + unknownHostException);
                                            int i92 = j4.a.f7622a;
                                            byteArrayInputStream19 = byteArrayInputStream17;
                                            byteArrayInputStream18 = byteArrayInputStream16;
                                            AbstractC0203a.c(byteArrayInputStream19);
                                            AbstractC0203a.c(bufferedOutputStream);
                                            AbstractC0203a.c(byteArrayInputStream2);
                                            AbstractC0203a.c(byteArrayInputStream18);
                                            httpURLConnection.disconnect();
                                            return null;
                                        } catch (IOException e12) {
                                            iOException = e12;
                                            byteArrayInputStream15 = inputStream;
                                            byteArrayInputStream14 = byteArrayOutputStream;
                                            int i102 = j4.a.f7622a;
                                            Log.w("OsmDroid", "IOException downloading MapTile: " + l.k(j5) + " : " + iOException);
                                            byteArrayInputStream19 = byteArrayInputStream15;
                                            byteArrayInputStream18 = byteArrayInputStream14;
                                            AbstractC0203a.c(byteArrayInputStream19);
                                            AbstractC0203a.c(bufferedOutputStream);
                                            AbstractC0203a.c(byteArrayInputStream2);
                                            AbstractC0203a.c(byteArrayInputStream18);
                                            httpURLConnection.disconnect();
                                            return null;
                                        } catch (Throwable th5) {
                                            th2 = th5;
                                            byteArrayInputStream13 = inputStream;
                                            byteArrayInputStream12 = byteArrayOutputStream;
                                            int i112 = j4.a.f7622a;
                                            Log.e("OsmDroid", "Error downloading MapTile: " + l.k(j5), th2);
                                            byteArrayInputStream19 = byteArrayInputStream13;
                                            byteArrayInputStream18 = byteArrayInputStream12;
                                            AbstractC0203a.c(byteArrayInputStream19);
                                            AbstractC0203a.c(bufferedOutputStream);
                                            AbstractC0203a.c(byteArrayInputStream2);
                                            AbstractC0203a.c(byteArrayInputStream18);
                                            httpURLConnection.disconnect();
                                            return null;
                                        }
                                    }
                                    g4.g gVarB = dVar.b(byteArrayInputStream2);
                                    AbstractC0203a.c(inputStream);
                                    AbstractC0203a.c(bufferedOutputStream);
                                    AbstractC0203a.c(byteArrayInputStream2);
                                    AbstractC0203a.c(byteArrayOutputStream);
                                    try {
                                        httpURLConnection.disconnect();
                                    } catch (Exception unused6) {
                                    }
                                    return gVarB;
                                } catch (i4.a e13) {
                                    e = e13;
                                    aVar = e;
                                    byteArrayInputStream2 = null;
                                    byteArrayInputStream23 = byteArrayOutputStream;
                                    r9 = inputStream;
                                    byteArrayInputStream22 = byteArrayInputStream23;
                                    int i722 = j4.a.f7622a;
                                    Log.w("OsmDroid", "LowMemoryException downloading MapTile: " + l.k(j5) + " : " + aVar);
                                    throw new h4.b(aVar);
                                } catch (FileNotFoundException e14) {
                                    e = e14;
                                    fileNotFoundException = e;
                                    byteArrayInputStream2 = null;
                                    byteArrayInputStream21 = inputStream;
                                    byteArrayInputStream20 = byteArrayOutputStream;
                                    int i822 = j4.a.f7622a;
                                    Log.w("OsmDroid", "Tile not found: " + l.k(j5) + " : " + fileNotFoundException);
                                    byteArrayInputStream19 = byteArrayInputStream21;
                                    byteArrayInputStream18 = byteArrayInputStream20;
                                    AbstractC0203a.c(byteArrayInputStream19);
                                    AbstractC0203a.c(bufferedOutputStream);
                                    AbstractC0203a.c(byteArrayInputStream2);
                                    AbstractC0203a.c(byteArrayInputStream18);
                                    httpURLConnection.disconnect();
                                    return null;
                                } catch (UnknownHostException e15) {
                                    e = e15;
                                    unknownHostException = e;
                                    byteArrayInputStream2 = null;
                                    byteArrayInputStream17 = inputStream;
                                    byteArrayInputStream16 = byteArrayOutputStream;
                                    Log.w("OsmDroid", "UnknownHostException downloading MapTile: " + l.k(j5) + " : " + unknownHostException);
                                    int i922 = j4.a.f7622a;
                                    byteArrayInputStream19 = byteArrayInputStream17;
                                    byteArrayInputStream18 = byteArrayInputStream16;
                                    AbstractC0203a.c(byteArrayInputStream19);
                                    AbstractC0203a.c(bufferedOutputStream);
                                    AbstractC0203a.c(byteArrayInputStream2);
                                    AbstractC0203a.c(byteArrayInputStream18);
                                    httpURLConnection.disconnect();
                                    return null;
                                } catch (IOException e16) {
                                    e = e16;
                                    iOException = e;
                                    byteArrayInputStream2 = null;
                                    byteArrayInputStream15 = inputStream;
                                    byteArrayInputStream14 = byteArrayOutputStream;
                                    int i1022 = j4.a.f7622a;
                                    Log.w("OsmDroid", "IOException downloading MapTile: " + l.k(j5) + " : " + iOException);
                                    byteArrayInputStream19 = byteArrayInputStream15;
                                    byteArrayInputStream18 = byteArrayInputStream14;
                                    AbstractC0203a.c(byteArrayInputStream19);
                                    AbstractC0203a.c(bufferedOutputStream);
                                    AbstractC0203a.c(byteArrayInputStream2);
                                    AbstractC0203a.c(byteArrayInputStream18);
                                    httpURLConnection.disconnect();
                                    return null;
                                } catch (Throwable th6) {
                                    th = th6;
                                    th2 = th;
                                    byteArrayInputStream2 = null;
                                    byteArrayInputStream13 = inputStream;
                                    byteArrayInputStream12 = byteArrayOutputStream;
                                    int i1122 = j4.a.f7622a;
                                    Log.e("OsmDroid", "Error downloading MapTile: " + l.k(j5), th2);
                                    byteArrayInputStream19 = byteArrayInputStream13;
                                    byteArrayInputStream18 = byteArrayInputStream12;
                                    AbstractC0203a.c(byteArrayInputStream19);
                                    AbstractC0203a.c(bufferedOutputStream);
                                    AbstractC0203a.c(byteArrayInputStream2);
                                    AbstractC0203a.c(byteArrayInputStream18);
                                    httpURLConnection.disconnect();
                                    return null;
                                }
                            } catch (i4.a e17) {
                                e = e17;
                            } catch (FileNotFoundException e18) {
                                e = e18;
                            } catch (UnknownHostException e19) {
                                e = e19;
                            } catch (IOException e20) {
                                e = e20;
                            } catch (Throwable th7) {
                                th = th7;
                            }
                        } catch (i4.a e21) {
                            aVar = e21;
                            byteArrayInputStream2 = null;
                            bufferedOutputStream = null;
                            byteArrayInputStream23 = byteArrayOutputStream;
                        } catch (FileNotFoundException e22) {
                            fileNotFoundException = e22;
                            byteArrayInputStream2 = null;
                            bufferedOutputStream = null;
                            byteArrayInputStream21 = inputStream;
                            byteArrayInputStream20 = byteArrayOutputStream;
                        } catch (UnknownHostException e23) {
                            unknownHostException = e23;
                            byteArrayInputStream2 = null;
                            bufferedOutputStream = null;
                            byteArrayInputStream17 = inputStream;
                            byteArrayInputStream16 = byteArrayOutputStream;
                        } catch (IOException e24) {
                            iOException = e24;
                            byteArrayInputStream2 = null;
                            bufferedOutputStream = null;
                            byteArrayInputStream15 = inputStream;
                            byteArrayInputStream14 = byteArrayOutputStream;
                        } catch (Throwable th8) {
                            th2 = th8;
                            byteArrayInputStream2 = null;
                            bufferedOutputStream = null;
                            byteArrayInputStream13 = inputStream;
                            byteArrayInputStream12 = byteArrayOutputStream;
                        }
                    } catch (i4.a e25) {
                        aVar = e25;
                        byteArrayInputStream2 = null;
                        byteArrayInputStream23 = null;
                        bufferedOutputStream = null;
                    } catch (FileNotFoundException e26) {
                        fileNotFoundException = e26;
                        byteArrayInputStream2 = null;
                        byteArrayInputStream11 = inputStream;
                        ByteArrayInputStream byteArrayInputStream252 = byteArrayInputStream2;
                        bufferedOutputStream = byteArrayInputStream252;
                        byteArrayInputStream21 = byteArrayInputStream11;
                        byteArrayInputStream20 = byteArrayInputStream252;
                        int i8222 = j4.a.f7622a;
                        Log.w("OsmDroid", "Tile not found: " + l.k(j5) + " : " + fileNotFoundException);
                        byteArrayInputStream19 = byteArrayInputStream21;
                        byteArrayInputStream18 = byteArrayInputStream20;
                        AbstractC0203a.c(byteArrayInputStream19);
                        AbstractC0203a.c(bufferedOutputStream);
                        AbstractC0203a.c(byteArrayInputStream2);
                        AbstractC0203a.c(byteArrayInputStream18);
                        httpURLConnection.disconnect();
                        return null;
                    } catch (UnknownHostException e27) {
                        unknownHostException = e27;
                        byteArrayInputStream2 = null;
                        byteArrayInputStream10 = inputStream;
                        ByteArrayInputStream byteArrayInputStream262 = byteArrayInputStream2;
                        bufferedOutputStream = byteArrayInputStream262;
                        byteArrayInputStream17 = byteArrayInputStream10;
                        byteArrayInputStream16 = byteArrayInputStream262;
                        Log.w("OsmDroid", "UnknownHostException downloading MapTile: " + l.k(j5) + " : " + unknownHostException);
                        int i9222 = j4.a.f7622a;
                        byteArrayInputStream19 = byteArrayInputStream17;
                        byteArrayInputStream18 = byteArrayInputStream16;
                        AbstractC0203a.c(byteArrayInputStream19);
                        AbstractC0203a.c(bufferedOutputStream);
                        AbstractC0203a.c(byteArrayInputStream2);
                        AbstractC0203a.c(byteArrayInputStream18);
                        httpURLConnection.disconnect();
                        return null;
                    } catch (IOException e28) {
                        iOException = e28;
                        byteArrayInputStream2 = null;
                        byteArrayInputStream9 = inputStream;
                        ByteArrayInputStream byteArrayInputStream272 = byteArrayInputStream2;
                        bufferedOutputStream = byteArrayInputStream272;
                        byteArrayInputStream15 = byteArrayInputStream9;
                        byteArrayInputStream14 = byteArrayInputStream272;
                        int i10222 = j4.a.f7622a;
                        Log.w("OsmDroid", "IOException downloading MapTile: " + l.k(j5) + " : " + iOException);
                        byteArrayInputStream19 = byteArrayInputStream15;
                        byteArrayInputStream18 = byteArrayInputStream14;
                        AbstractC0203a.c(byteArrayInputStream19);
                        AbstractC0203a.c(bufferedOutputStream);
                        AbstractC0203a.c(byteArrayInputStream2);
                        AbstractC0203a.c(byteArrayInputStream18);
                        httpURLConnection.disconnect();
                        return null;
                    } catch (Throwable th9) {
                        th2 = th9;
                        byteArrayInputStream2 = null;
                        byteArrayInputStream8 = inputStream;
                        ByteArrayInputStream byteArrayInputStream282 = byteArrayInputStream2;
                        bufferedOutputStream = byteArrayInputStream282;
                        byteArrayInputStream13 = byteArrayInputStream8;
                        byteArrayInputStream12 = byteArrayInputStream282;
                        int i11222 = j4.a.f7622a;
                        Log.e("OsmDroid", "Error downloading MapTile: " + l.k(j5), th2);
                        byteArrayInputStream19 = byteArrayInputStream13;
                        byteArrayInputStream18 = byteArrayInputStream12;
                        AbstractC0203a.c(byteArrayInputStream19);
                        AbstractC0203a.c(bufferedOutputStream);
                        AbstractC0203a.c(byteArrayInputStream2);
                        AbstractC0203a.c(byteArrayInputStream18);
                        httpURLConnection.disconnect();
                        return null;
                    }
                } catch (i4.a e29) {
                    e = e29;
                } catch (FileNotFoundException e30) {
                    e = e30;
                } catch (UnknownHostException e31) {
                    e = e31;
                } catch (IOException e32) {
                    e = e32;
                } catch (Throwable th10) {
                    th = th10;
                }
            } catch (i4.a e33) {
                aVar = e33;
                httpURLConnection = null;
                byteArrayInputStream2 = null;
            } catch (FileNotFoundException e34) {
                fileNotFoundException = e34;
                httpURLConnection = null;
                byteArrayInputStream7 = null;
            } catch (UnknownHostException e35) {
                unknownHostException = e35;
                httpURLConnection = null;
                byteArrayInputStream6 = null;
            } catch (IOException e36) {
                iOException = e36;
                httpURLConnection = null;
                byteArrayInputStream5 = null;
            } catch (Throwable th11) {
                th2 = th11;
                httpURLConnection = null;
                byteArrayInputStream4 = null;
            }
        } catch (Throwable th12) {
            th = th12;
            byteArrayInputStream3 = byteArrayInputStream19;
            byteArrayInputStream = byteArrayInputStream18;
        }
    }

    public static short[] f(int i5, int i6) {
        short[] sArr;
        double d5;
        int i7 = 2000;
        short[] sArr2 = new short[2000];
        double d6 = 8000;
        double d7 = (i5 * 6.283185307179586d) / d6;
        double d8 = (i6 * 6.283185307179586d) / d6;
        double d9 = 0.0d;
        double d10 = 0.0d;
        int i8 = 0;
        while (i8 < i7) {
            double dSin = (Math.sin(d10) + Math.sin(d9)) * 0.5d * 0.8d;
            int iMin = Math.min(40, 40);
            if (i8 < iMin) {
                sArr = sArr2;
                d5 = i8 / iMin;
            } else {
                sArr = sArr2;
                d5 = i8 > 2000 - iMin ? (2000 - i8) / iMin : 1.0d;
            }
            int i9 = (int) (32767.0d * dSin * d5);
            if (i9 > 32767) {
                i9 = 32767;
            }
            if (i9 < -32767) {
                i9 = -32767;
            }
            sArr[i8] = (short) i9;
            d9 += d7;
            d10 += d8;
            if (d9 > 6.283185307179586d) {
                d9 -= 6.283185307179586d;
            }
            if (d10 > 6.283185307179586d) {
                d10 -= 6.283185307179586d;
            }
            i8++;
            sArr2 = sArr;
            i7 = 2000;
        }
        short[] sArr3 = sArr2;
        short s4 = 0;
        int i10 = 0;
        for (int i11 = i7; i10 < i11; i11 = 2000) {
            short s5 = sArr3[i10];
            if (Math.abs((int) s5) > Math.abs((int) s4)) {
                s4 = s5;
            }
            i10++;
        }
        Log.d("DTMFToneGenerator", "Generated 2000 samples for " + i5 + "Hz + " + i6 + "Hz, duration: 250ms, peak: " + ((int) s4));
        return sArr3;
    }

    public static Path g(float f5, float f6, float f7, float f8) {
        Path path = new Path();
        path.moveTo(f5, f6);
        path.lineTo(f7, f8);
        return path;
    }

    public static String h(String str) throws Exception {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(15000);
        httpURLConnection.setRequestProperty("User-Agent", "UnifiedRadios Weather Client");
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode != 200) {
            throw new Exception(h.a(responseCode, "HTTP error: "));
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                bufferedReader.close();
                httpURLConnection.disconnect();
                return sb.toString();
            }
            sb.append(line);
        }
    }

    public static String j(int i5) {
        if (i5 == 0) {
            return "Clear";
        }
        if (i5 == 1) {
            return "Mainly Clear";
        }
        if (i5 == 2) {
            return "Partly Cloudy";
        }
        if (i5 == 3) {
            return "Overcast";
        }
        if (i5 == 85 || i5 == 86) {
            return "Snow Showers";
        }
        if (i5 == 95) {
            return "Thunderstorm";
        }
        if (i5 == 96) {
            return "Thunderstorm with Hail";
        }
        switch (i5) {
            case 45:
            case 48:
                return "Fog";
            case 51:
            case 53:
                return "Drizzle";
            case 61:
            case 63:
                return "Rain";
            case 71:
            case 73:
            case 75:
                return "Snow";
            case 77:
                return "Snow Grains";
            case 99:
                return "Thunderstorm with Hail";
            default:
                switch (i5) {
                    case 55:
                        return "Drizzle";
                    case 56:
                    case 57:
                        return "Freezing Drizzle";
                    default:
                        switch (i5) {
                            case 65:
                                return "Rain";
                            case 66:
                            case 67:
                                return "Freezing Rain";
                            default:
                                switch (i5) {
                                    case 80:
                                    case 81:
                                    case 82:
                                        return "Rain Showers";
                                    default:
                                        return "Unknown";
                                }
                        }
                }
        }
    }

    @Override // y1.d
    public C0981c c(Context context, String str, InterfaceC0980b interfaceC0980b) {
        int iE;
        switch (this.f7082c) {
            case 10:
                C0981c c0981c = new C0981c();
                int iE2 = interfaceC0980b.e(context, str, true);
                c0981c.f10468b = iE2;
                if (iE2 != 0) {
                    c0981c.f10469c = 1;
                } else {
                    int iB = interfaceC0980b.b(context, str);
                    c0981c.f10467a = iB;
                    if (iB != 0) {
                        c0981c.f10469c = -1;
                    }
                }
                return c0981c;
            default:
                C0981c c0981c2 = new C0981c();
                int iB2 = interfaceC0980b.b(context, str);
                c0981c2.f10467a = iB2;
                int i5 = 1;
                int i6 = 0;
                if (iB2 != 0) {
                    iE = interfaceC0980b.e(context, str, false);
                    c0981c2.f10468b = iE;
                } else {
                    iE = interfaceC0980b.e(context, str, true);
                    c0981c2.f10468b = iE;
                }
                int i7 = c0981c2.f10467a;
                if (i7 == 0) {
                    if (iE == 0) {
                        i5 = 0;
                    }
                    c0981c2.f10469c = i5;
                    return c0981c2;
                }
                i6 = i7;
                if (i6 >= iE) {
                    i5 = -1;
                }
                c0981c2.f10469c = i5;
                return c0981c2;
        }
    }

    @Override // j0.InterfaceC0591d
    public void d(int i5, Serializable serializable) {
    }

    public void e(double d5, double d6, m mVar) throws JSONException {
        j3.e eVar = new j3.e(this, mVar, d5, d6);
        try {
            JSONObject jSONObject = new JSONObject(h(String.format("%s?latitude=%.6f&longitude=%.6f&current_weather=true&hourly=surface_pressure,relativehumidity_2m&timezone=auto", "https://api.open-meteo.com/v1/forecast", Double.valueOf(d5), Double.valueOf(d6))));
            g gVar = new g();
            if (jSONObject.has("current_weather")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("current_weather");
                if (jSONObject2.has("temperature")) {
                    gVar.f7617b = jSONObject2.getDouble("temperature");
                }
                if (jSONObject2.has("windspeed")) {
                    gVar.f7619d = jSONObject2.getDouble("windspeed");
                }
                if (jSONObject2.has("weathercode")) {
                    gVar.f7620e = j(jSONObject2.getInt("weathercode"));
                }
            }
            if (jSONObject.has("hourly")) {
                JSONObject jSONObject3 = jSONObject.getJSONObject("hourly");
                if (jSONObject3.has("surface_pressure")) {
                    JSONArray jSONArray = jSONObject3.getJSONArray("surface_pressure");
                    if (jSONArray.length() > 0 && !jSONArray.isNull(0)) {
                        gVar.f7616a = jSONArray.getDouble(0);
                    }
                }
                if (jSONObject3.has("relativehumidity_2m")) {
                    JSONArray jSONArray2 = jSONObject3.getJSONArray("relativehumidity_2m");
                    if (jSONArray2.length() > 0 && !jSONArray2.isNull(0)) {
                        gVar.f7618c = jSONArray2.getDouble(0);
                    }
                }
            }
            DateFormat.getDateTimeInstance().format(new Date());
            Log.d("WeatherDataManager", String.format("Open-Meteo: Pressure=%.1f hPa, Temp=%.1f°C, Humidity=%.1f%%, Wind=%.1f km/h", Double.valueOf(gVar.f7616a), Double.valueOf(gVar.f7617b), Double.valueOf(gVar.f7618c), Double.valueOf(gVar.f7619d)));
            eVar.c(gVar);
        } catch (Exception e5) {
            StringBuilder sbG = h.g("WeatherDataManager", "Error fetching Open-Meteo data", e5, "Open-Meteo: ");
            sbG.append(e5.getMessage());
            eVar.b(sbG.toString());
        }
    }

    @Override // r3.InterfaceC0877a
    public Object get() {
        return new d(1);
    }

    public void i(L0.c cVar, float f5) {
        C0816a c0816a = (C0816a) ((Drawable) cVar.f1536d);
        CardView cardView = (CardView) cVar.f1537e;
        boolean useCompatPadding = cardView.getUseCompatPadding();
        boolean preventCornerOverlap = cardView.getPreventCornerOverlap();
        if (f5 != c0816a.f9068e || c0816a.f9069f != useCompatPadding || c0816a.g != preventCornerOverlap) {
            c0816a.f9068e = f5;
            c0816a.f9069f = useCompatPadding;
            c0816a.g = preventCornerOverlap;
            c0816a.b(null);
            c0816a.invalidateSelf();
        }
        if (!cardView.getUseCompatPadding()) {
            cVar.m(0, 0, 0, 0);
            return;
        }
        C0816a c0816a2 = (C0816a) ((Drawable) cVar.f1536d);
        float f6 = c0816a2.f9068e;
        float f7 = c0816a2.f9064a;
        int iCeil = (int) Math.ceil(AbstractC0817b.a(f6, f7, cardView.getPreventCornerOverlap()));
        int iCeil2 = (int) Math.ceil(AbstractC0817b.b(f6, f7, cardView.getPreventCornerOverlap()));
        cVar.m(iCeil, iCeil2, iCeil, iCeil2);
    }

    @Override // j0.InterfaceC0591d
    public void m() {
    }

    @Override // retrofit2.Callback
    public void onFailure(Call call, Throwable th) {
        Log.d("MainActivity", "Failed to check messages: " + th.getMessage());
    }

    @Override // retrofit2.Callback
    public void onResponse(Call call, Response response) {
        if (!response.isSuccessful() || response.body() == null) {
            return;
        }
        h.p(response.body());
        throw null;
    }

    public C0558b(LaunchActivity launchActivity) {
        this.f7082c = 6;
    }
}
