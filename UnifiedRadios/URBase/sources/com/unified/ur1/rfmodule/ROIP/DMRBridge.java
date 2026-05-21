package com.unified.ur1.rfmodule.ROIP;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.util.Log;
import com.unified.ur1.SatelliteTracker.h;
import com.unified.ur1.primary.LaunchActivity;
import com.unified.ur1.rfmodule.ROIP.DMRBridge;
import e0.C0432c;
import f3.RunnableC0491B;
import g0.AbstractC0535a;
import h4.c;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import o3.g;
import o3.i;
import o3.k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class DMRBridge {

    /* renamed from: o, reason: collision with root package name */
    public static final boolean f6068o;

    /* renamed from: p, reason: collision with root package name */
    public static DMRBridge f6069p;

    /* renamed from: a, reason: collision with root package name */
    public final Context f6070a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f6071b;

    /* renamed from: d, reason: collision with root package name */
    public PowerManager.WakeLock f6073d;

    /* renamed from: e, reason: collision with root package name */
    public k f6074e;
    public Thread n;

    /* renamed from: c, reason: collision with root package name */
    public boolean f6072c = false;

    /* renamed from: f, reason: collision with root package name */
    public int f6075f = 0;
    public long g = 0;
    public long h = 0;

    /* renamed from: i, reason: collision with root package name */
    public int f6076i = 0;

    /* renamed from: j, reason: collision with root package name */
    public int f6077j = -1;

    /* renamed from: k, reason: collision with root package name */
    public long f6078k = 0;

    /* renamed from: l, reason: collision with root package name */
    public boolean f6079l = false;

    /* renamed from: m, reason: collision with root package name */
    public volatile boolean f6080m = false;

    public final class DMRConnectionParams {
    }

    static {
        try {
            System.loadLibrary("dmr_native_lib");
            f6068o = true;
            Log.i("DMRBridge", "Successfully loaded dmr_native_lib");
        } catch (UnsatisfiedLinkError e5) {
            Log.e("DMRBridge", "Failed to load native library: " + e5.getMessage());
            f6068o = false;
        }
    }

    public DMRBridge(Context context) {
        Log.d("DMRBridge", "DMRBridge constructor called");
        this.f6070a = context.getApplicationContext();
        this.f6071b = new Handler(Looper.getMainLooper());
        if (f6068o) {
            registerJavaCallbacks(this);
            m();
        }
    }

    private native void initializeDMR();

    public static synchronized DMRBridge j(Context context) {
        try {
            if (f6069p == null) {
                f6069p = new DMRBridge(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f6069p;
    }

    public static void k(JSONObject jSONObject, ArrayList arrayList, boolean z4) throws JSONException {
        try {
            StringBuilder sb = new StringBuilder();
            int i5 = 0;
            if (z4) {
                sb.append("Multi-RX activated for ");
                for (int i6 = 0; i6 < arrayList.size(); i6++) {
                    if (i6 > 0) {
                        if (i6 == arrayList.size() - 1) {
                            sb.append(" and ");
                        } else {
                            sb.append(", ");
                        }
                    }
                    sb.append("TG");
                    sb.append(arrayList.get(i6));
                }
                if (jSONObject.has("message")) {
                    String string = jSONObject.getString("message");
                    sb.append("\n");
                    sb.append(string);
                }
                if (jSONObject.has("status")) {
                    String string2 = jSONObject.getString("status");
                    if (!"success".equalsIgnoreCase(string2)) {
                        sb.append("\nStatus: ");
                        sb.append(string2);
                    }
                }
                if (jSONObject.has("talkgroups")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("talkgroups");
                    sb.append("\n\nTalkgroup Status:");
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        int iIntValue = ((Integer) it.next()).intValue();
                        String strValueOf = String.valueOf(iIntValue);
                        if (jSONObject2.has(strValueOf)) {
                            JSONObject jSONObject3 = jSONObject2.getJSONObject(strValueOf);
                            String strOptString = jSONObject3.optString("status", "unknown");
                            String strOptString2 = jSONObject3.optString("description", "");
                            sb.append("\nTG");
                            sb.append(iIntValue);
                            sb.append(": ");
                            sb.append(strOptString);
                            if (!strOptString2.isEmpty()) {
                                sb.append(" (");
                                sb.append(strOptString2);
                                sb.append(")");
                            }
                        }
                    }
                }
                if (jSONObject.has("warnings")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("warnings");
                    if (jSONArray.length() > 0) {
                        sb.append("\n\nWarnings:");
                        while (i5 < jSONArray.length()) {
                            sb.append("\n• ");
                            sb.append(jSONArray.getString(i5));
                            i5++;
                        }
                    }
                }
            } else {
                sb.append("Multi-RX activation failed for ");
                while (i5 < arrayList.size()) {
                    if (i5 > 0) {
                        sb.append(", ");
                    }
                    sb.append("TG");
                    sb.append(arrayList.get(i5));
                    i5++;
                }
                if (jSONObject.has("error")) {
                    String string3 = jSONObject.getString("error");
                    sb.append("\nError: ");
                    sb.append(string3);
                } else if (jSONObject.has("message")) {
                    String string4 = jSONObject.getString("message");
                    sb.append("\nMessage: ");
                    sb.append(string4);
                }
                if (jSONObject.has("details")) {
                    String string5 = jSONObject.getString("details");
                    sb.append("\nDetails: ");
                    sb.append(string5);
                }
            }
            Log.i("DMRBridge", "Multi-RX API Response: " + sb.toString());
        } catch (JSONException e5) {
            Log.e("DMRBridge", "Error parsing JSON response", e5);
            l(jSONObject.toString(), arrayList, z4);
        }
    }

    public static void l(String str, ArrayList arrayList, boolean z4) {
        try {
            StringBuilder sb = new StringBuilder();
            int i5 = 0;
            if (z4) {
                sb.append("Multi-RX activated for ");
                while (i5 < arrayList.size()) {
                    if (i5 > 0) {
                        if (i5 == arrayList.size() - 1) {
                            sb.append(" and ");
                        } else {
                            sb.append(", ");
                        }
                    }
                    sb.append("TG");
                    sb.append(arrayList.get(i5));
                    i5++;
                }
                if (str.length() > 0 && str.length() < 200) {
                    sb.append("\nServer: ");
                    sb.append(str);
                }
            } else {
                sb.append("Multi-RX activation failed for ");
                while (i5 < arrayList.size()) {
                    if (i5 > 0) {
                        sb.append(", ");
                    }
                    sb.append("TG");
                    sb.append(arrayList.get(i5));
                    i5++;
                }
                if (str.length() > 0 && str.length() < 300) {
                    sb.append("\nError: ");
                    sb.append(str);
                }
            }
            Log.i("DMRBridge", "Multi-RX Text Response: " + sb.toString());
        } catch (Exception e5) {
            Log.e("DMRBridge", "Error handling text response", e5);
        }
    }

    public static boolean n(String str) {
        return str != null && (str.contains("Access denied") || str.contains("Portal account not found") || str.contains("No BrandMeister API key configured") || str.contains("API access forbidden"));
    }

    public static boolean o(String str) {
        if (str == null) {
            return false;
        }
        return str.contains("API rate limit exceeded") || str.contains("Server error - service temporarily unavailable") || str.contains("Internal system error occurred") || str.contains("Failed to retrieve current talkgroups") || str.contains("Failed to verify");
    }

    public final void A(int i5) {
        if (!isSocketConnected()) {
            Log.e("DMRBridge", "Cannot transmit - not connected");
            return;
        }
        Log.d("DMRBridge", "Starting transmission to talkgroup " + i5);
        setTalkgroup(i5);
        startTransmissionToTalkgroup(i5);
        k kVar = this.f6074e;
        if (kVar != null) {
            kVar.e(true);
        }
    }

    public final void B() {
        Log.i("DMRBridge", "=== STOPPING CURRENT CALL GENTLY ===");
        try {
            int i5 = this.f6077j;
            boolean z4 = i5 != -1;
            if (f6068o && z4) {
                Log.d("DMRBridge", "Calling native stopCurrentCall()");
                stopCurrentCall();
            }
            this.f6077j = -1;
            this.f6078k = 0L;
            if (z4) {
                Log.d("DMRBridge", "Sending call ended notification for srcId: " + i5);
                if (this.f6074e != null) {
                    this.f6071b.post(new g(this, i5, 2));
                }
                try {
                    Intent intent = new Intent("com.unified.ur1.DMR_AUDIO_TRACK_STOPPED");
                    intent.putExtra("srcId", i5);
                    intent.putExtra("timestamp", System.currentTimeMillis());
                    intent.putExtra("reason", "channel_switch");
                    C0432c.a(this.f6070a).c(intent);
                } catch (Exception e5) {
                    Log.e("DMRBridge", "Error sending broadcast", e5);
                }
            }
            Log.i("DMRBridge", "Current call stopped successfully");
        } catch (Exception e6) {
            Log.e("DMRBridge", "Exception stopping current call", e6);
        }
    }

    public final void C() throws InterruptedException {
        if (this.f6080m) {
            Log.d("DMRBridge", "Stopping Qt event processor");
            this.f6080m = false;
            Thread thread = this.n;
            if (thread != null) {
                try {
                    thread.interrupt();
                    this.n.join(1000L);
                    if (this.n.isAlive()) {
                        Log.w("DMRBridge", "Qt event processor thread did not stop gracefully");
                    }
                } catch (InterruptedException unused) {
                    Log.w("DMRBridge", "Interrupted while waiting for Qt event processor to stop");
                }
                this.n = null;
            }
            Log.d("DMRBridge", "Qt event processor stopped");
        }
    }

    public final void D() {
        if (isSocketConnected()) {
            Log.d("DMRBridge", "Stopping transmission");
            stopTransmission();
            k kVar = this.f6074e;
            if (kVar != null) {
                kVar.e(false);
            }
        }
    }

    /* JADX WARN: Finally extract failed */
    public final boolean a(String str, ArrayList arrayList) throws IOException {
        HttpURLConnection httpURLConnection;
        int responseCode;
        BufferedReader bufferedReader;
        try {
            Log.i("DMRBridge", "Calling upon Brandmeister gods to allow access to their divine network via Multi-RX for talkgroups=" + arrayList);
            long jCurrentTimeMillis = System.currentTimeMillis();
            StringBuilder sb = new StringBuilder();
            sb.append("https://ur1.unifiedradios.com/bm_tg.php?cloud_auth=");
            sb.append(str);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) it.next()).intValue();
                if (iIntValue != 0) {
                    sb.append("&tg[]=");
                    sb.append(iIntValue);
                }
            }
            sb.append("&_t=");
            sb.append(jCurrentTimeMillis);
            httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setRequestProperty("User-Agent", "DMRBridge/1.0");
            httpURLConnection.setRequestProperty("Accept", "application/json, text/plain, */*");
            responseCode = httpURLConnection.getResponseCode();
            Log.d("DMRBridge", "UR1 Multi-RX API response code: " + responseCode);
        } catch (Exception e5) {
            Log.e("DMRBridge", "Exception calling UR1 Multi-RX API", e5);
        }
        if (responseCode != 200) {
            Log.e("DMRBridge", "UR1 Multi-RX API call failed with response code: " + responseCode);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream(), "utf-8"));
            } catch (Exception e6) {
                Log.e("DMRBridge", "Failed to read error response", e6);
                y("Failed to set TGs " + arrayList + " (HTTP " + responseCode + ")", true);
            }
            try {
                StringBuilder sb2 = new StringBuilder();
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    sb2.append(line);
                }
                String string = sb2.toString();
                Log.e("DMRBridge", "UR1 Multi-RX API error response: " + string);
                p(string, arrayList, false);
                bufferedReader.close();
                httpURLConnection.disconnect();
                return false;
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "utf-8"));
        try {
            StringBuilder sb3 = new StringBuilder();
            while (true) {
                String line2 = bufferedReader2.readLine();
                if (line2 == null) {
                    String string2 = sb3.toString();
                    Log.i("DMRBridge", "UR1 Multi-RX API response: " + string2);
                    p(string2, arrayList, true);
                    Log.i("DMRBridge", "Successfully called UR1 Multi-RX API for TGs " + arrayList);
                    LaunchActivity.f5854E1 = true;
                    setMultiTalkgroupMode(true);
                    bufferedReader2.close();
                    return true;
                }
                sb3.append(line2.trim());
            }
        } catch (Throwable th3) {
            try {
                bufferedReader2.close();
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
            }
            throw th3;
        }
        Log.e("DMRBridge", "Exception calling UR1 Multi-RX API", e5);
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:141:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x03be  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x028f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:203:0x03b5 A[ADDED_TO_REGION, EDGE_INSN: B:203:0x03b5->B:154:0x03b5 BREAK  A[LOOP:0: B:3:0x0018->B:151:0x03a2], REMOVE, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0249 A[Catch: all -> 0x028a, TRY_LEAVE, TryCatch #4 {all -> 0x028a, blocks: (B:77:0x0240, B:79:0x0249), top: B:165:0x0240 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(int r19, java.lang.String r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 967
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unified.ur1.rfmodule.ROIP.DMRBridge.b(int, java.lang.String):boolean");
    }

    public final void c() {
        try {
            disconnectSockets();
            Log.d("DMRBridge", "DMRBridge cleaned up");
        } catch (Exception e5) {
            h.o(e5, new StringBuilder("Error during cleanup: "), "DMRBridge");
        }
    }

    public native boolean connect(DMRConnectionParams dMRConnectionParams);

    public native boolean connectWithSockets(String str, int i5, int i6, int i7, String str2, String str3);

    /* JADX WARN: Type inference failed for: r22v19 */
    /* JADX WARN: Type inference failed for: r22v21 */
    /* JADX WARN: Type inference failed for: r22v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r22v8 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public final boolean d() throws Throwable {
        Throwable th;
        String str;
        boolean z4;
        boolean z5;
        Exception exc;
        InterruptedException interruptedException;
        ?? r22;
        String str2;
        String strJ;
        String strY;
        boolean zContains;
        int i5;
        int iQ;
        int iIntValue;
        String strH;
        String string;
        int iL;
        boolean z6;
        String str3;
        String str4;
        String str5 = "Sleep completed, dmrInitialized=";
        try {
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            try {
                if (!this.f6080m) {
                    try {
                        Log.w("ROIP", "Qt event processor not running - restarting for audio support");
                        z();
                    } catch (InterruptedException e5) {
                        interruptedException = e5;
                        str = "=== Exiting connectWithSocketsHardcoded() ===";
                        r22 = 0;
                        Log.e("ROIP", "InterruptedException in socket-based connection", interruptedException);
                        Log.d("ROIP", "Thread was interrupted at: " + interruptedException.getStackTrace()[r22]);
                        Log.d("ROIP", str);
                        return r22;
                    } catch (Exception e6) {
                        exc = e6;
                        str = "=== Exiting connectWithSocketsHardcoded() ===";
                        z4 = false;
                        Log.e("ROIP", "Exception in socket-based connection: ".concat(exc.getClass().getName()), exc);
                        Log.e("ROIP", "Exception message: " + exc.getMessage());
                        Log.e("ROIP", "Stack trace:", exc);
                        Log.d("ROIP", str);
                        return z4;
                    } catch (Throwable th3) {
                        th = th3;
                        str5 = "=== Exiting connectWithSocketsHardcoded() ===";
                        Log.d("ROIP", str5);
                        throw th;
                    }
                }
                Log.d("ROIP", "=== ENHANCED AUDIO INITIALIZATION ===");
                r();
                Log.i("ROIP", "Audio system initialization completed");
                if (!this.f6072c) {
                    Log.w("ROIP", "DMR not initialized, initializing now...");
                    m();
                    Thread.sleep(1000L);
                    if (!this.f6072c) {
                        Log.e("ROIP", "DMR initialization failed");
                    }
                    Log.d("ROIP", "=== Exiting connectWithSocketsHardcoded() ===");
                    return false;
                }
                Thread.sleep(500L);
                if (isSocketConnected()) {
                    Log.i("ROIP", "Existing connection detected - disconnecting first");
                    str2 = "  - Callsign: ";
                    Log.d("ROIP", "Current connection status: " + getDetailedConnectionStatus());
                    disconnectSockets();
                    Log.i("ROIP", "Disconnected from previous network");
                    Thread.sleep(1000L);
                    if (isSocketConnected()) {
                        Log.e("ROIP", "Failed to disconnect from previous network");
                        Log.d("ROIP", "=== Exiting connectWithSocketsHardcoded() ===");
                        return false;
                    }
                    Log.i("ROIP", "Successfully disconnected from previous network");
                } else {
                    str2 = "  - Callsign: ";
                }
                if (this.f6072c) {
                    Log.d("ROIP", "DMR already initialized (dmrInitialized=true)");
                } else {
                    Log.w("ROIP", "DMR not initialized (dmrInitialized=" + this.f6072c + "), initializing now...");
                    Log.d("ROIP", "Calling initialize()...");
                    m();
                    Log.d("ROIP", "initialize() completed, sleeping for 2000ms");
                    Thread.sleep(1000L);
                    Log.d("ROIP", "Sleep completed, dmrInitialized=" + this.f6072c);
                }
                Log.d("ROIP", "Initializing audio system with sampleRate=48000, channels=1");
                initializeAudio(48000, 1);
                Log.i("ROIP", "Audio system initialized successfully");
                Log.d("ROIP", "Retrieving configuration from SharedSettings...");
                strJ = c.j(this.f6070a);
                strY = c.y(this.f6070a);
                zContains = strY.toLowerCase().contains("xlx");
                if (zContains) {
                    setNetworkType("XLX");
                    Log.i("ROIP", "XLX reflector detected: " + strJ);
                } else {
                    setNetworkType(strY);
                }
            } catch (Throwable th4) {
                th = th4;
                str5 = "=== Exiting connectWithSocketsHardcoded() ===";
            }
            try {
                i5 = c.C(this.f6070a).getInt("dmr_port", 62031);
                iQ = c.q(this.f6070a);
                iIntValue = c.n(this.f6070a).intValue();
                try {
                    strH = c.h(this.f6070a);
                } catch (InterruptedException e7) {
                    e = e7;
                    str = "=== Exiting connectWithSocketsHardcoded() ===";
                } catch (Exception e8) {
                    e = e8;
                    str = "=== Exiting connectWithSocketsHardcoded() ===";
                } catch (Throwable th5) {
                    th = th5;
                    str5 = "=== Exiting connectWithSocketsHardcoded() ===";
                    th = th;
                    Log.d("ROIP", str5);
                    throw th;
                }
            } catch (InterruptedException e9) {
                e = e9;
                str = "=== Exiting connectWithSocketsHardcoded() ===";
            } catch (Exception e10) {
                e = e10;
                str = "=== Exiting connectWithSocketsHardcoded() ===";
            }
        } catch (InterruptedException e11) {
            e = e11;
            str = "=== Exiting connectWithSocketsHardcoded() ===";
        } catch (Exception e12) {
            e = e12;
            str = "=== Exiting connectWithSocketsHardcoded() ===";
        }
        try {
            string = c.C(this.f6070a).getString("dmr_password", "CALL");
            iL = c.l(this.f6070a);
        } catch (InterruptedException e13) {
            e = e13;
            str = "=== Exiting connectWithSocketsHardcoded() ===";
            z5 = false;
            interruptedException = e;
            r22 = z5;
            Log.e("ROIP", "InterruptedException in socket-based connection", interruptedException);
            Log.d("ROIP", "Thread was interrupted at: " + interruptedException.getStackTrace()[r22]);
            Log.d("ROIP", str);
            return r22;
        } catch (Exception e14) {
            e = e14;
            str = "=== Exiting connectWithSocketsHardcoded() ===";
            z4 = false;
            exc = e;
            Log.e("ROIP", "Exception in socket-based connection: ".concat(exc.getClass().getName()), exc);
            Log.e("ROIP", "Exception message: " + exc.getMessage());
            Log.e("ROIP", "Stack trace:", exc);
            Log.d("ROIP", str);
            return z4;
        } catch (Throwable th6) {
            th = th6;
            str5 = "=== Exiting connectWithSocketsHardcoded() ===";
            th = th;
            Log.d("ROIP", str5);
            throw th;
        }
        try {
        } catch (InterruptedException e15) {
            e = e15;
        } catch (Exception e16) {
            e = e16;
        } catch (Throwable th7) {
            th = th7;
            str5 = "=== Exiting connectWithSocketsHardcoded() ===";
            th = th;
            Log.d("ROIP", str5);
            throw th;
        }
        try {
            boolean z7 = this.f6070a.getSharedPreferences("app_settings", 0).getBoolean("multi_rx_enabled", false);
            Log.d("ROIP", "Configuration retrieved:");
            Log.d("ROIP", "  - Hostname: " + strJ);
            Log.d("ROIP", "  - Network: ".concat(strY));
            Log.d("ROIP", "  - Is XLX: " + zContains);
            Log.d("ROIP", "  - Port: " + i5);
            Log.d("ROIP", "  - DMR ID: " + iQ);
            Log.d("ROIP", "  - RPT ID: " + iIntValue);
            Log.d("ROIP", str2 + strH);
            Log.d("ROIP", "  - Password: " + string);
            Log.d("ROIP", "  - Talkgroup from settings: " + iL);
            Log.d("ROIP", "Setting auto key-up talkgroup to: " + iL);
            try {
                try {
                    setAutoKeyupTalkgroup(iL);
                    Log.i("ROIP", "Auto key-up talkgroup set to " + iL);
                    Log.d("ROIP", "Connecting to new network: " + strJ + ":" + i5);
                    Log.d("ROIP", "Calling connectWithSockets()...");
                    String lastConnectionError = "";
                    int iQ2 = strY.toLowerCase().contains("brandmeister") ? iIntValue : c.q(this.f6070a);
                    if (zContains) {
                        str4 = "XLX reflector connected - subscribing to talkgroup: ";
                        str3 = "";
                    } else {
                        str3 = string;
                        str4 = "XLX reflector connected - subscribing to talkgroup: ";
                    }
                    String str6 = str4;
                    z4 = false;
                    z4 = false;
                    r22 = 0;
                    z5 = false;
                    z4 = false;
                    z6 = false;
                    try {
                        boolean zConnectWithSockets = connectWithSockets(strJ, i5, iQ2, iIntValue, strH, str3);
                        Log.d("ROIP", "connectWithSockets() returned: " + zConnectWithSockets);
                        if (!zConnectWithSockets) {
                            str = "=== Exiting connectWithSocketsHardcoded() ===";
                            try {
                                if (zConnectWithSockets) {
                                    Log.e("ROIP", "Failed to initiate socket-based connection");
                                    Log.e("ROIP", "=== DMR connection FAILED - connectWithSockets returned false ===");
                                    Log.d("ROIP", str);
                                    return false;
                                }
                                try {
                                    if (f6068o) {
                                        lastConnectionError = getLastConnectionError();
                                    }
                                } catch (Exception e17) {
                                    Log.w("ROIP", "Could not get connection error details: " + e17.getMessage());
                                }
                                String str7 = lastConnectionError;
                                if (str7 == null || !(str7.toLowerCase().contains("auth") || str7.toLowerCase().contains("password") || str7.toLowerCase().contains("invalid") || str7.toLowerCase().contains("denied") || str7.toLowerCase().contains("unauthorized"))) {
                                    if (str7 == null) {
                                        str7 = "Unknown error";
                                    }
                                    Log.e("ROIP", "Connection failed: ".concat(str7));
                                    y("Connection failed to connect!", true);
                                } else {
                                    Log.e("ROIP", "=== AUTHENTICATION FAILURE DETECTED ===");
                                    Log.e("ROIP", "Connection failed with error: ".concat(str7));
                                    Log.e("ROIP", "DMR ID: " + iQ2 + ", Callsign: " + strH);
                                    Log.e("ROIP", "Server: " + strJ + ":" + i5);
                                    Log.e("ROIP", "Check your credentials and try again");
                                    y("✗ Authentication failed - check credentials", true);
                                }
                                Log.e("ROIP", "=== DMR connection FAILED ===");
                                Log.d("ROIP", str);
                                return false;
                            } catch (InterruptedException e18) {
                                e = e18;
                                interruptedException = e;
                                r22 = z5;
                                Log.e("ROIP", "InterruptedException in socket-based connection", interruptedException);
                                Log.d("ROIP", "Thread was interrupted at: " + interruptedException.getStackTrace()[r22]);
                                Log.d("ROIP", str);
                                return r22;
                            } catch (Exception e19) {
                                e = e19;
                                exc = e;
                                Log.e("ROIP", "Exception in socket-based connection: ".concat(exc.getClass().getName()), exc);
                                Log.e("ROIP", "Exception message: " + exc.getMessage());
                                Log.e("ROIP", "Stack trace:", exc);
                                Log.d("ROIP", str);
                                return z4;
                            }
                        }
                        Log.i("ROIP", "Socket-based connection initiated successfully");
                        Log.d("ROIP", "Sleeping for 3000ms to allow connection and auto key-up...");
                        Thread.sleep(1000L);
                        Log.d("ROIP", "Sleep completed");
                        Log.d("ROIP", "Checking final connection status...");
                        boolean zIsSocketConnected = isSocketConnected();
                        String detailedConnectionStatus = getDetailedConnectionStatus();
                        Log.i("ROIP", "Final connection status: " + zIsSocketConnected);
                        Log.i("ROIP", "Detailed status: " + detailedConnectionStatus);
                        if (zIsSocketConnected) {
                            try {
                                try {
                                    try {
                                        Log.i("ROIP", "=== DMR connection SUCCESSFUL ===");
                                        Log.d("ROIP", "Restarting AudioTrack after connection cleanup");
                                        try {
                                            if (this.f6079l) {
                                                Log.i("ROIP", "Performing post-connection audio recovery");
                                                initializeAudio(48000, 1);
                                                Thread.sleep(1000L);
                                                Log.i("ROIP", "Post-connection audio recovery completed");
                                            } else {
                                                initializeAudio(48000, 1);
                                                Thread.sleep(200L);
                                            }
                                        } catch (Exception e20) {
                                            Log.e("ROIP", "Failed to restart AudioTrack", e20);
                                        }
                                        if (zContains) {
                                            Log.i("ROIP", str6 + iL);
                                            subscribeTalkgroup(iL);
                                        } else if (strY.toLowerCase().contains("brandmeister")) {
                                            Log.i("ROIP", "Detected Brandmeister server - clearing existing TGs and setting new talkgroup via API");
                                            if (z7) {
                                                Log.i("ROIP", "Detected Multi-RX - Activing Multi RX Subscription");
                                                w();
                                            } else {
                                                Log.i("ROIP", "Detected Single Talkgroup - Activing Regular Subscription");
                                                x(iL);
                                            }
                                        } else {
                                            if (strY.toLowerCase().contains("tgif")) {
                                                subscribeTalkgroup(3161);
                                                try {
                                                    Thread.sleep(1000L);
                                                } catch (InterruptedException e21) {
                                                    throw new RuntimeException(e21);
                                                }
                                            }
                                            subscribeTalkgroup(iL);
                                        }
                                        Log.i("ROIP", "Subscribed to talkgroup: " + iL);
                                    } catch (Exception e22) {
                                        exc = e22;
                                        str = "=== Exiting connectWithSocketsHardcoded() ===";
                                        Log.e("ROIP", "Exception in socket-based connection: ".concat(exc.getClass().getName()), exc);
                                        Log.e("ROIP", "Exception message: " + exc.getMessage());
                                        Log.e("ROIP", "Stack trace:", exc);
                                        Log.d("ROIP", str);
                                        return z4;
                                    }
                                } catch (Throwable th8) {
                                    th = th8;
                                    str5 = "=== Exiting connectWithSocketsHardcoded() ===";
                                    Log.d("ROIP", str5);
                                    throw th;
                                }
                            } catch (InterruptedException e23) {
                                interruptedException = e23;
                                str = "=== Exiting connectWithSocketsHardcoded() ===";
                                Log.e("ROIP", "InterruptedException in socket-based connection", interruptedException);
                                Log.d("ROIP", "Thread was interrupted at: " + interruptedException.getStackTrace()[r22]);
                                Log.d("ROIP", str);
                                return r22;
                            }
                        } else {
                            Log.w("ROIP", "=== DMR connection FAILED - socket not connected ===");
                        }
                        Log.d("ROIP", "=== Exiting connectWithSocketsHardcoded() ===");
                        return zIsSocketConnected;
                    } catch (InterruptedException e24) {
                        e = e24;
                        str = "=== Exiting connectWithSocketsHardcoded() ===";
                        z5 = z6;
                        interruptedException = e;
                        r22 = z5;
                        Log.e("ROIP", "InterruptedException in socket-based connection", interruptedException);
                        Log.d("ROIP", "Thread was interrupted at: " + interruptedException.getStackTrace()[r22]);
                        Log.d("ROIP", str);
                        return r22;
                    } catch (Exception e25) {
                        e = e25;
                        str = "=== Exiting connectWithSocketsHardcoded() ===";
                        exc = e;
                        Log.e("ROIP", "Exception in socket-based connection: ".concat(exc.getClass().getName()), exc);
                        Log.e("ROIP", "Exception message: " + exc.getMessage());
                        Log.e("ROIP", "Stack trace:", exc);
                        Log.d("ROIP", str);
                        return z4;
                    }
                } catch (Throwable th9) {
                    th = th9;
                    str5 = "=== Exiting connectWithSocketsHardcoded() ===";
                    th = th;
                    Log.d("ROIP", str5);
                    throw th;
                }
            } catch (InterruptedException e26) {
                e = e26;
                z6 = false;
                str = "=== Exiting connectWithSocketsHardcoded() ===";
                z5 = z6;
                interruptedException = e;
                r22 = z5;
                Log.e("ROIP", "InterruptedException in socket-based connection", interruptedException);
                Log.d("ROIP", "Thread was interrupted at: " + interruptedException.getStackTrace()[r22]);
                Log.d("ROIP", str);
                return r22;
            } catch (Exception e27) {
                e = e27;
                z4 = false;
                str = "=== Exiting connectWithSocketsHardcoded() ===";
                exc = e;
                Log.e("ROIP", "Exception in socket-based connection: ".concat(exc.getClass().getName()), exc);
                Log.e("ROIP", "Exception message: " + exc.getMessage());
                Log.e("ROIP", "Stack trace:", exc);
                Log.d("ROIP", str);
                return z4;
            }
        } catch (InterruptedException e28) {
            e = e28;
            z6 = false;
        } catch (Exception e29) {
            e = e29;
            z4 = false;
        } catch (Throwable th10) {
            th = th10;
            str5 = "=== Exiting connectWithSocketsHardcoded() ===";
            th = th;
            Log.d("ROIP", str5);
            throw th;
        }
    }

    public native void disconnect();

    public native void disconnectSockets();

    public final void e(int i5) {
        new Thread(new g(this, i5, 0)).start();
    }

    public native void enableTalkerAlias(boolean z4);

    public final void f() {
        Log.d("DMRBridge", "Starting DMR disconnection process");
        new Thread(new RunnableC0491B(this, 2)).start();
    }

    public native void forceStopAllAudio();

    public final void g() {
        Log.d("DMRBridge", "=== Starting enhanced ROIP disconnection with audio cleanup ===");
        new Thread(new RunnableC0491B(this, 4)).start();
    }

    public native String getAGCStatus();

    public native int[] getActiveTalkgroups();

    public Context getContext() {
        return this.f6070a;
    }

    public native String getDetailedConnectionStatus();

    public native float getInputVolume();

    public native String getLastConnectionError();

    public native String getMyTalkerAlias();

    public native String getTalkerAlias(int i5);

    public final void h() {
        Log.w("DMRBridge", "=== FORCE CLEANUP INITIATED ===");
        try {
            this.f6080m = false;
            if (f6068o) {
                disconnectSockets();
            }
            this.f6074e = null;
            this.f6072c = false;
            this.f6077j = -1;
            this.f6078k = 0L;
            f6069p = null;
            Context context = this.f6070a;
            if (context != null) {
                c.q0(context, 0);
            }
            Log.w("DMRBridge", "Force cleanup completed");
        } catch (Exception e5) {
            Log.e("DMRBridge", "Exception during force cleanup", e5);
        }
    }

    public final void i() {
        boolean zIsAudioCurrentlyActive;
        Log.i("DMRBridge", "=== FORCE STOPPING ALL AUDIO SYSTEMS ===");
        try {
            int i5 = this.f6077j;
            boolean z4 = f6068o;
            if (z4) {
                zIsAudioCurrentlyActive = isAudioCurrentlyActive();
                Log.d("DMRBridge", "Audio was active: " + zIsAudioCurrentlyActive + ", srcId: " + i5);
            } else {
                zIsAudioCurrentlyActive = false;
            }
            if (z4) {
                forceStopAllAudio();
                Log.d("DMRBridge", "Native audio force stopped");
            }
            this.f6079l = true;
            Log.i("DMRBridge", "Audio recovery flag set - next connection will use enhanced recovery");
            this.f6077j = -1;
            this.f6078k = 0L;
            if (zIsAudioCurrentlyActive && i5 != -1) {
                if (this.f6074e != null) {
                    this.f6071b.post(new g(this, i5, 3));
                }
                try {
                    Intent intent = new Intent("com.unified.ur1.DMR_AUDIO_TRACK_STOPPED");
                    intent.putExtra("srcId", i5);
                    intent.putExtra("timestamp", System.currentTimeMillis());
                    intent.putExtra("reason", "channel_switch");
                    C0432c.a(this.f6070a).c(intent);
                } catch (Exception e5) {
                    Log.e("DMRBridge", "Error sending broadcast", e5);
                }
            }
            Log.i("DMRBridge", "Audio force stop completed with recovery flag set");
        } catch (Exception e6) {
            Log.e("DMRBridge", "Exception during force stop", e6);
        }
    }

    public native void initializeAudio(int i5, int i6);

    public native void initializeQt();

    public native void inputvolume(float f5);

    public native boolean isAGCEnabled();

    public native boolean isAudioCurrentlyActive();

    public native boolean isConnected();

    public native boolean isMultiTalkgroupEnabled();

    public native boolean isSocketConnected();

    public final void m() {
        try {
            Log.d("ROIP", "DMRBridge.initialize() called");
            if (!f6068o) {
                Log.e("ROIP", "Cannot initialize - native library not loaded");
                return;
            }
            registerJavaCallbacks(this);
            Log.d("ROIP", "Java callbacks registered successfully");
            if (!this.f6072c) {
                Log.d("ROIP", "Initializing DMR system...");
                initializeDMR();
                this.f6072c = true;
                z();
            }
            Log.d("ROIP", "DMR Bridge initialization complete");
        } catch (Exception e5) {
            Log.e("ROIP", "Error initializing DMRBridge: " + e5.getMessage(), e5);
        }
    }

    public native boolean nativeConnectWithHardcodedParams();

    public void onAudioStopped(int i5) {
        Log.i("DMRBridge", "Audio stopped for srcId: " + i5);
        try {
            Intent intent = new Intent("com.unified.ur1.DMR_AUDIO_TRACK_STOPPED");
            intent.putExtra("srcId", i5);
            intent.putExtra("timestamp", System.currentTimeMillis());
            C0432c.a(this.f6070a).c(intent);
            Log.i("DMRBridge", "Audio stopped broadcast sent for srcId: " + i5);
        } catch (Exception e5) {
            Log.e("DMRBridge", "Failed to send audio stopped broadcast", e5);
        }
    }

    public void onBufferUnderrun(int i5, int i6) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
        if (jCurrentTimeMillis - this.h < 2000) {
            return;
        }
        this.f6076i++;
        this.h = jCurrentTimeMillis;
        Log.w("DMRBridge", "Buffer underrun #" + this.f6076i + " - Frames: " + i5 + "/" + i6);
        Context context = this.f6070a;
        if (i5 >= 3000 || this.f6076i >= 30) {
            Log.e("DMRBridge", "Severe underrun detected - restarting audio system");
            y("Stream just got Wonky!!!  Using A.I. to resolve the issue at " + str, false);
            final int i7 = this.f6077j;
            final int iL = c.l(context);
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: o3.f
                @Override // java.lang.Runnable
                public final void run() {
                    int i8 = i7;
                    int i9 = iL;
                    boolean z4 = DMRBridge.f6068o;
                    DMRBridge dMRBridge = this.f8923j;
                    dMRBridge.getClass();
                    try {
                        Log.i("DMRBridge", "Restarting call for srcId: " + i8 + ", talkgroup: " + i9);
                        dMRBridge.B();
                        new Handler(Looper.getMainLooper()).postDelayed(new g(dMRBridge, i9, 1), 200L);
                    } catch (Exception e5) {
                        Log.e("DMRBridge", "Error in restartCurrentCall", e5);
                    }
                }
            });
            this.f6076i = 0;
        }
        try {
            Intent intent = new Intent("com.unified.ur1.DMR_BUFFERUNDERRUN");
            intent.putExtra("severity", i5 >= 2000 ? "high" : "medium");
            intent.putExtra("count", this.f6076i);
            intent.putExtra("timestamp", jCurrentTimeMillis);
            C0432c.a(context).c(intent);
        } catch (Exception e5) {
            Log.e("DMRBridge", "Error sending underrun broadcast", e5);
        }
    }

    public void onCallEnded(int i5) {
        String str;
        Log.d("DMRBridge", "=== onCallEnded ENTERED ===");
        Log.d("DMRBridge", "onCallEnded: srcId=" + i5);
        Log.d("DMRBridge", "Current call srcId: " + this.f6077j);
        Log.d("DMRBridge", "Thread: " + Thread.currentThread().getName());
        StringBuilder sb = new StringBuilder("mCallbackListener is: ");
        if (this.f6074e != null) {
            str = "SET (" + this.f6074e.getClass().getName() + ")";
        } else {
            str = "NULL";
        }
        h.q(sb, str, "DMRBridge");
        Handler handler = this.f6071b;
        Log.d("DMRBridge", "mainHandler is: ".concat(handler != null ? "SET" : "NULL"));
        int i6 = this.f6077j;
        if (i6 != -1 && i5 != i6) {
            StringBuilder sbF = h.f("Call end for different srcId: ", i5, " (current: ");
            sbF.append(this.f6077j);
            sbF.append(")");
            Log.w("DMRBridge", sbF.toString());
        }
        int i7 = this.f6077j;
        if (i5 == i7 || i7 == -1) {
            Log.d("DMRBridge", "Clearing currentCallSrcId (was: " + this.f6077j + ")");
            this.f6077j = -1;
        }
        Log.d("DMRBridge", "About to post to mainHandler");
        try {
            handler.post(new g(this, i5, 4));
            Log.d("DMRBridge", "Posted to mainHandler successfully");
        } catch (Exception e5) {
            Log.e("DMRBridge", "Exception posting to mainHandler: " + e5.getMessage(), e5);
            e5.printStackTrace();
        }
        Log.d("DMRBridge", "=== onCallEnded EXITING ===");
    }

    public void onCallStarted(final int i5, final String str, final int i6) {
        Log.d("ROIP", "=== DMRBridge.onCallStarted CALLED FROM C++ ===");
        Log.d("ROIP", "Bridge Source ID: " + i5);
        Log.d("ROIP", "Bridge Callsign: " + str);
        Log.d("ROIP", "Call started: srcId=" + i5 + ", callsign=" + str + ", talkgroup=" + i6);
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z4 = i5 == this.f6077j && jCurrentTimeMillis - this.f6078k < 500;
        this.f6077j = i5;
        this.f6078k = jCurrentTimeMillis;
        if (z4) {
            Log.w("ROIP", "Duplicate call from " + i5 + " within debounce period - updating tracking but not forwarding");
            return;
        }
        Log.d("ROIP", "mCallbackListener is: ".concat(this.f6074e != null ? "SET" : "NULL"));
        Handler handler = this.f6071b;
        Log.d("ROIP", "mainHandler is: ".concat(handler != null ? "SET" : "NULL"));
        if (this.f6074e == null) {
            Log.e("ROIP", "WARNING: mCallbackListener is NULL in onCallStarted!");
            Log.e("ROIP", "Stack trace:", new Exception("Null callback listener stack trace"));
        }
        handler.post(new Runnable() { // from class: o3.h
            @Override // java.lang.Runnable
            public final void run() {
                String str2 = str;
                int i7 = i6;
                boolean z5 = DMRBridge.f6068o;
                DMRBridge dMRBridge = this.f8929j;
                dMRBridge.getClass();
                Log.d("ROIP", "In mainHandler.post - forwarding onCallStarted to listener");
                Log.d("ROIP", "mCallbackListener is still: ".concat(dMRBridge.f6074e != null ? "SET" : "NULL"));
                if (dMRBridge.f6074e != null) {
                    StringBuilder sb = new StringBuilder("Calling listener.onCallStarted with srcId: ");
                    int i8 = i5;
                    sb.append(i8);
                    Log.d("ROIP", sb.toString());
                    Log.d("ROIP", "Listener class: ".concat(dMRBridge.f6074e.getClass().getName()));
                    try {
                        dMRBridge.f6074e.c(i8, str2, i7);
                        Log.d("ROIP", "listener.onCallStarted called successfully");
                    } catch (Exception e5) {
                        Log.e("ROIP", "Exception calling listener.onCallStarted: " + e5.getMessage(), e5);
                    }
                }
            }
        });
    }

    public void onConnectionStatusChanged(boolean z4) {
        Log.d("DMRBridge", "onConnectionStatusChanged: " + z4);
        Context context = this.f6070a;
        if (z4) {
            c.q0(context, 1);
            if (this.f6073d == null) {
                PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "DMR:KeepAlive");
                this.f6073d = wakeLockNewWakeLock;
                wakeLockNewWakeLock.acquire();
                Log.i("DMR", "Wake lock acquired");
            }
        } else {
            c.q0(context, 0);
            PowerManager.WakeLock wakeLock = this.f6073d;
            if (wakeLock != null && wakeLock.isHeld()) {
                this.f6073d.release();
                this.f6073d = null;
                Log.i("DMR", "Wake lock released");
            }
        }
        this.f6071b.post(new i(this, z4, 1));
    }

    public void onDMRPacketReceived(final int i5, final int i6, final byte[] bArr, final int i7) {
        Log.d("DMRBridge", "onDMRPacketReceived from " + i5 + " to " + i6);
        this.f6071b.post(new Runnable(i5, i6, bArr, i7) { // from class: o3.j

            /* renamed from: k, reason: collision with root package name */
            public final /* synthetic */ int f8937k;

            /* renamed from: l, reason: collision with root package name */
            public final /* synthetic */ int f8938l;

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ int f8939m;

            {
                this.f8939m = i7;
            }

            @Override // java.lang.Runnable
            public final void run() {
                k kVar = this.f8936j.f6074e;
                if (kVar != null) {
                    kVar.a(this.f8937k, this.f8938l, this.f8939m);
                }
            }
        });
    }

    public void onDestroy() throws InterruptedException {
        Context context = this.f6070a;
        Log.d("DMRBridge", "=== DMRBridge onDestroy() starting ===");
        try {
            C();
            if (isSocketConnected()) {
                try {
                    Log.d("DMRBridge", "Stopping active transmission");
                    stopTransmission();
                    Thread.sleep(100L);
                } catch (Exception e5) {
                    Log.e("DMRBridge", "Error stopping transmission during destroy", e5);
                }
            }
            String strJ = c.j(context);
            if (strJ != null && strJ.toLowerCase().contains("brandmeister")) {
                try {
                    int i5 = c.C(context).getInt("dmr_id", 1);
                    Log.d("DMRBridge", "Disconnecting from all Brandmeister talkgroups");
                    e(i5);
                    Thread.sleep(500L);
                } catch (Exception e6) {
                    Log.e("DMRBridge", "Error disconnecting from Brandmeister talkgroups", e6);
                }
            }
            try {
                Log.d("DMRBridge", "Closing socket connections");
                disconnectSockets();
                Thread.sleep(200L);
            } catch (Exception e7) {
                Log.e("DMRBridge", "Error closing socket connections", e7);
            }
            try {
                Log.d("DMRBridge", "Cleaning up native resources");
                c();
            } catch (Exception e8) {
                Log.e("DMRBridge", "Error during native cleanup", e8);
            }
            Log.d("DMRBridge", "Clearing callback listener");
            this.f6074e = null;
            this.f6072c = false;
            this.f6077j = -1;
            this.f6078k = 0L;
            c.q0(context, 0);
            f6069p = null;
            Log.i("DMRBridge", "=== DMRBridge onDestroy() completed successfully ===");
        } catch (Exception e9) {
            Log.e("DMRBridge", "Exception during DMRBridge onDestroy()", e9);
        }
    }

    public void onMaxPingFailures() {
        Log.w("DMRBridge", "=== MAX PING FAILURES REACHED ===");
        Log.w("DMRBridge", "Connection lost due to ping timeouts - attempting network roaming");
        try {
            Intent intent = new Intent("com.unified.ur1.ROIP_NETROAM");
            intent.putExtra("reason", "ping_timeout");
            intent.putExtra("timestamp", System.currentTimeMillis());
            intent.putExtra("max_failures", 5);
            C0432c.a(this.f6070a).c(intent);
            Log.d("DMRBridge", "ROIP_NETROAM broadcast sent due to ping failures");
        } catch (Exception e5) {
            Log.e("DMRBridge", "Error sending ROIP_NETROAM broadcast", e5);
        }
    }

    public void onNakReceived(String str) {
        Log.w("ROIP", "=== NAK RECEIVED FROM SERVER ===");
        Log.w("ROIP", "NAK reason: " + str);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.g > 30000) {
            this.f6075f = 0;
        }
        this.f6075f++;
        this.g = jCurrentTimeMillis;
        Log.w("ROIP", "NAK count: " + this.f6075f + "/3");
        if (this.f6075f >= 3) {
            Log.e("ROIP", "=== AUTHENTICATION FAILURE DETECTED ===");
            Log.e("ROIP", "Received " + this.f6075f + " consecutive NAK packets");
            Log.e("ROIP", "This typically indicates invalid credentials");
            StringBuilder sb = new StringBuilder("Server: ");
            Context context = this.f6070a;
            sb.append(c.j(context));
            Log.e("ROIP", sb.toString());
            Log.e("ROIP", "DMR ID: " + c.q(context));
            Log.e("ROIP", "Callsign: " + c.h(context));
            Log.e("ROIP", "Check your password and try again");
            y("Authentication failed - " + this.f6075f + " attempts with current logins failed!", true);
            this.f6071b.post(new RunnableC0491B(this, 6));
            this.f6075f = 0;
        }
    }

    public void onTransmissionStatusChanged(boolean z4) {
        Log.d("DMRBridge", "onTransmissionStatusChanged: " + z4);
        this.f6071b.post(new i(this, z4, 0));
    }

    public final void p(String str, ArrayList arrayList, boolean z4) {
        if (str != null) {
            try {
                if (!str.trim().isEmpty()) {
                    if (str.trim().startsWith("{") || str.trim().startsWith("[")) {
                        try {
                            k(new JSONObject(str), arrayList, z4);
                            return;
                        } catch (JSONException unused) {
                            Log.d("DMRBridge", "Response is not JSON object, trying as plain text");
                        }
                    }
                    l(str, arrayList, z4);
                    return;
                }
            } catch (Exception e5) {
                Log.e("DMRBridge", "Error parsing Multi-RX API response", e5);
                return;
            }
        }
        Log.w("DMRBridge", "Empty response body from Multi-RX API");
        y("Empty response from Multi-RX API", true);
    }

    public native void processQtEvents();

    public final void q(int i5, String str, boolean z4) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("success") || !jSONObject.getBoolean("success")) {
                y("✗ " + jSONObject.optString("error", "Unknown error"), true);
                return;
            }
            Log.i("DMRBridge", "ROIP parsedisplay response: " + str);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject == null) {
                y("✓ TG " + i5 + " set successfully", false);
                return;
            }
            String strOptString = jSONObjectOptJSONObject.optString("callsign", "");
            jSONObjectOptJSONObject.optString("device_id", "");
            if ("disconnect".equals(jSONObjectOptJSONObject.optString("mode", ""))) {
                y("✓ Disconnected from all talkgroups (" + strOptString + ")", false);
                return;
            }
            if (!jSONObjectOptJSONObject.has("talkgroups_configured")) {
                y("✓ TG " + i5 + " configured (" + strOptString + ")", false);
                return;
            }
            JSONArray jSONArray = jSONObjectOptJSONObject.getJSONArray("talkgroups_configured");
            if (jSONArray.length() <= 0) {
                y("✓ TG " + i5 + " configured (" + strOptString + ")", false);
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i6);
                if (i6 > 0) {
                    sb.append(", ");
                }
                sb.append(jSONObject2.optString("talkgroup", ""));
            }
            y("✓ TG " + sb.toString() + " subscribed (" + strOptString + ")", false);
        } catch (Exception e5) {
            Log.e("DMRBridge", "Failed to parse UR1 API response", e5);
            if (str.length() < 100) {
                y(z4 ? AbstractC0535a.j("✓ TG ", i5, " set") : "✗ ".concat(str), !z4);
            } else {
                y(z4 ? AbstractC0535a.j("✓ TG ", i5, " configured") : "✗ Server error occurred", !z4);
            }
        }
    }

    public final void r() throws InterruptedException {
        if (!f6068o) {
            Log.e("DMRBridge", "Native library not loaded");
            return;
        }
        try {
            if (!this.f6079l) {
                Log.d("DMRBridge", "Normal audio initialization (no recovery needed)");
                initializeAudio(48000, 1);
                Thread.sleep(200L);
                return;
            }
            Log.i("DMRBridge", "=== AUDIO RECOVERY MODE ACTIVATED ===");
            Log.i("DMRBridge", "Audio was previously force stopped - using enhanced recovery");
            for (int i5 = 1; i5 <= 4; i5++) {
                Log.d("DMRBridge", "Audio recovery attempt " + i5 + "/4");
                try {
                    initializeAudio(48000, 1);
                    int i6 = i5 * 400;
                    Log.d("DMRBridge", "Recovery delay: " + i6 + "ms");
                    Thread.sleep((long) i6);
                    Log.i("DMRBridge", "Audio recovery attempt " + i5 + " completed successfully");
                    this.f6079l = false;
                    Log.i("DMRBridge", "=== AUDIO RECOVERY SUCCESSFUL - FLAG CLEARED ===");
                    return;
                } catch (Exception e5) {
                    Log.w("DMRBridge", "Recovery attempt " + i5 + " failed: " + e5.getMessage());
                    if (i5 < 4) {
                        Thread.sleep(300L);
                    }
                }
            }
            Log.e("DMRBridge", "=== AUDIO RECOVERY FAILED AFTER ALL ATTEMPTS ===");
        } catch (Exception e6) {
            Log.e("DMRBridge", "Exception during audio initialization", e6);
        }
    }

    public native void registerJavaCallbacks(Object obj);

    public native void resubscribeTalkgroup(int i5);

    public final void s() throws InterruptedException {
        Log.d("DMRBridge", "=== Preparing for channel switch ===");
        try {
            int i5 = this.f6077j;
            boolean z4 = i5 != -1;
            if (!z4) {
                Log.d("DMRBridge", "No active call - safe to proceed with channel switch");
                return;
            }
            Log.w("DMRBridge", "Active call detected during channel switch (srcId: " + i5 + ") - forcing cleanup");
            B();
            try {
                Thread.sleep(300L);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
            if (f6068o && isAudioCurrentlyActive()) {
                Log.e("DMRBridge", "WARNING: Audio still active after cleanup attempt!");
                B();
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException unused2) {
                    Thread.currentThread().interrupt();
                }
            }
            Log.d("DMRBridge", "Channel switch preparation completed - had active call: " + z4);
        } catch (Exception e5) {
            Log.e("DMRBridge", "Exception preparing for channel switch", e5);
        }
    }

    public native void sendFreeDMRTalkgroupOptions(int i5);

    public native boolean sendRPTLPacket(String str, int i5, int i6);

    public native void setAGCEnabled(boolean z4);

    public native void setAutoKeyupTalkgroup(int i5);

    public native void setColorCode(int i5);

    public native void setMultiTalkgroupMode(boolean z4);

    public native void setMyTalkerAlias(String str);

    public native void setNetworkType(String str);

    public native void setTalkgroup(int i5);

    public native void setTimeSlot(int i5);

    public native void startTransmission();

    public native void startTransmissionToTalkgroup(int i5);

    public native void stopCurrentCall();

    public native void stopTransmission();

    public native void subscribeTalkgroup(int i5);

    public final void t(String str, String str2, boolean z4) {
        try {
            Intent intent = new Intent("com.unified.ur1.PROGRESS_UPDATE");
            intent.putExtra("title", str);
            intent.putExtra("message", str2);
            intent.putExtra("show", z4);
            intent.putExtra("timestamp", System.currentTimeMillis());
            C0432c.a(this.f6070a).c(intent);
            Log.d("DMRBridge", "Progress broadcast sent: " + str + " - " + str2 + " (show: " + z4 + ")");
        } catch (Exception e5) {
            Log.e("DMRBridge", "Error sending progress broadcast", e5);
        }
    }

    /* JADX WARN: Finally extract failed */
    public final void u(int i5, int i6, int i7) throws JSONException, IOException {
        try {
            Log.i("ROIP", "Setting Brandmeister talkgroup via API: DMR ID=" + i5 + ", TG=" + i6 + ", Slot=" + i7);
            StringBuilder sb = new StringBuilder("https://api.brandmeister.network/v2/device/");
            sb.append(i5);
            sb.append("/talkgroup");
            URL url = new URL(sb.toString());
            Log.d("ROIP", "URL Request: " + url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.setRequestProperty("accept", "application/json");
            StringBuilder sb2 = new StringBuilder("Bearer ");
            String string = c.C(this.f6070a).getString("bm_api_key", "");
            Log.d("DMRBridge", string);
            sb2.append(string);
            httpURLConnection.setRequestProperty("Authorization", sb2.toString());
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setRequestProperty("X-CSRF-TOKEN", "JlG3NiIZGNJMWXz511lPhjvHY8A0ONLRG806iAMH");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("slot", i7);
            jSONObject.put("group", i6);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                byte[] bytes = jSONObject.toString().getBytes("utf-8");
                outputStream.write(bytes, 0, bytes.length);
                outputStream.close();
                int responseCode = httpURLConnection.getResponseCode();
                Log.d("ROIP", "Brandmeister API response code: " + responseCode);
                if (responseCode == 200) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "utf-8"));
                    try {
                        StringBuilder sb3 = new StringBuilder();
                        while (true) {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            } else {
                                sb3.append(line.trim());
                            }
                        }
                        Log.i("ROIP", "Brandmeister API response: " + sb3.toString());
                        JSONObject jSONObject2 = new JSONObject(sb3.toString());
                        int i8 = jSONObject2.getInt("talkgroup");
                        int i9 = jSONObject2.getInt("slot");
                        if (i8 == i6 && i9 == i7) {
                            Log.i("ROIP", "Successfully set Brandmeister talkgroup " + i6 + " on slot " + i7);
                            bufferedReader.close();
                            return;
                        }
                        bufferedReader.close();
                    } finally {
                    }
                } else {
                    Log.e("ROIP", "Brandmeister API call failed with response code: " + responseCode);
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream(), "utf-8"));
                        try {
                            StringBuilder sb4 = new StringBuilder();
                            while (true) {
                                String line2 = bufferedReader2.readLine();
                                if (line2 == null) {
                                    break;
                                } else {
                                    sb4.append(line2);
                                }
                            }
                            Log.e("ROIP", "Error response: " + sb4.toString());
                            bufferedReader2.close();
                        } catch (Throwable th) {
                            try {
                                bufferedReader2.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    } catch (Exception e5) {
                        Log.e("ROIP", "Failed to read error response", e5);
                    }
                }
                httpURLConnection.disconnect();
            } finally {
            }
        } catch (Exception e6) {
            Log.e("ROIP", "Exception calling Brandmeister API", e6);
        }
    }

    public final void v(k kVar) {
        Log.d("ROIP", "=== setCallbackListener called ===");
        k kVar2 = this.f6074e;
        Log.d("ROIP", "Previous listener: ".concat(kVar2 != null ? kVar2.getClass().getName() : "null"));
        Log.d("ROIP", "New listener: ".concat(kVar != null ? kVar.getClass().getName() : "null"));
        this.f6074e = kVar;
        Log.d("ROIP", "setCallbackListener called from: ", new Exception("Stack trace"));
    }

    public final void w() {
        new Thread(new RunnableC0491B(this, 1)).start();
    }

    public native boolean waitForConnection(int i5);

    public native int writeAudioData(byte[] bArr, int i5, int i6);

    public final void x(int i5) {
        new Thread(new g(this, i5, 5)).start();
    }

    public final void y(String str, boolean z4) {
        this.f6071b.post(new D0.g(4, this, str, z4));
    }

    public final void z() {
        if (this.f6080m) {
            Log.w("DMRBridge", "Qt event processor already running");
            return;
        }
        this.f6080m = true;
        Thread thread = new Thread(new RunnableC0491B(this, 7));
        this.n = thread;
        thread.setName("QtEventProcessor");
        this.n.setDaemon(true);
        this.n.start();
        Log.d("DMRBridge", "Qt event processor thread started");
    }
}
