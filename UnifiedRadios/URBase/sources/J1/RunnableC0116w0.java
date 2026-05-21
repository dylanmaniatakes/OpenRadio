package J1;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.measurement.AbstractC0409x1;
import g0.AbstractC0535a;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: J1.w0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0116w0 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f1436j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f1437k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f1438l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f1439m;
    public final /* synthetic */ Object n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Object f1440o;

    public /* synthetic */ RunnableC0116w0(E0 e02, b2 b2Var, Bundle bundle, L l5, String str) {
        this.f1436j = 0;
        this.f1439m = e02;
        this.f1438l = b2Var;
        this.n = bundle;
        this.f1440o = l5;
        this.f1437k = str;
    }

    @Override // java.lang.Runnable
    public final void run() throws JSONException, IOException {
        AtomicReference atomicReference;
        C0120x1 c0120x1;
        J j5;
        a2 a2Var;
        J j6;
        switch (this.f1436j) {
            case 0:
                L l5 = (L) this.f1440o;
                E0 e02 = (E0) this.f1439m;
                V1 v12 = e02.f728c;
                v12.j();
                try {
                    l5.u(v12.i((b2) this.f1438l, (Bundle) this.n));
                    return;
                } catch (RemoteException e5) {
                    e02.f728c.c().h.c((String) this.f1437k, e5, "Failed to return trigger URIs for app");
                    return;
                }
            case 1:
                AtomicReference atomicReference2 = (AtomicReference) this.f1439m;
                synchronized (atomicReference2) {
                    try {
                        try {
                            c0120x1 = (C0120x1) this.f1440o;
                            j5 = c0120x1.f1451f;
                        } catch (RemoteException e6) {
                            Z z4 = ((C0113v0) ((C0120x1) this.f1440o).f84c).f1417k;
                            C0113v0.k(z4);
                            z4.h.d("(legacy) Failed to get conditional properties; remote exception", null, (String) this.f1437k, e6);
                            ((AtomicReference) this.f1439m).set(Collections.emptyList());
                            atomicReference = (AtomicReference) this.f1439m;
                        }
                        if (j5 == null) {
                            Z z5 = ((C0113v0) c0120x1.f84c).f1417k;
                            C0113v0.k(z5);
                            z5.h.d("(legacy) Failed to get conditional properties; not connected to service", null, (String) this.f1437k, (String) this.n);
                            atomicReference2.set(Collections.emptyList());
                            atomicReference2.notify();
                            return;
                        }
                        if (TextUtils.isEmpty(null)) {
                            b2 b2Var = (b2) this.f1438l;
                            q1.E.i(b2Var);
                            atomicReference2.set(j5.h((String) this.f1437k, (String) this.n, b2Var));
                        } else {
                            atomicReference2.set(j5.t(null, (String) this.f1437k, (String) this.n));
                        }
                        c0120x1.z();
                        atomicReference = (AtomicReference) this.f1439m;
                        atomicReference.notify();
                        return;
                    } catch (Throwable th) {
                        ((AtomicReference) this.f1439m).notify();
                        throw th;
                    }
                }
            case 2:
                com.google.android.gms.internal.measurement.M m5 = (com.google.android.gms.internal.measurement.M) this.n;
                String str = (String) this.f1439m;
                String str2 = (String) this.f1437k;
                C0120x1 c0120x12 = (C0120x1) this.f1440o;
                ArrayList arrayList = new ArrayList();
                try {
                    try {
                        j6 = c0120x12.f1451f;
                    } catch (RemoteException e7) {
                        Z z6 = ((C0113v0) c0120x12.f84c).f1417k;
                        C0113v0.k(z6);
                        z6.h.d("Failed to get conditional properties; remote exception", str2, str, e7);
                    }
                    if (j6 == null) {
                        C0113v0 c0113v0 = (C0113v0) c0120x12.f84c;
                        Z z7 = c0113v0.f1417k;
                        C0113v0.k(z7);
                        z7.h.c(str2, str, "Failed to get conditional properties; not connected to service");
                        a2Var = c0113v0.n;
                        C0113v0.i(a2Var);
                        a2Var.G(m5, arrayList);
                        return;
                    }
                    b2 b2Var2 = (b2) this.f1438l;
                    q1.E.i(b2Var2);
                    arrayList = a2.w(j6.h(str2, str, b2Var2));
                    c0120x12.z();
                    a2Var = ((C0113v0) c0120x12.f84c).n;
                    C0113v0.i(a2Var);
                    a2Var.G(m5, arrayList);
                    return;
                } catch (Throwable th2) {
                    a2 a2Var2 = ((C0113v0) c0120x12.f84c).n;
                    C0113v0.i(a2Var2);
                    a2Var2.G(m5, arrayList);
                    throw th2;
                }
            case 3:
                try {
                    if (!(((N0.k) this.f1439m).f1783j instanceof N0.a)) {
                        String string = ((UUID) this.f1438l).toString();
                        L0.o oVarH = ((M0.r) this.f1437k).f1702c.h(string);
                        if (oVarH == null || AbstractC0535a.d(oVarH.f1562b)) {
                            throw new IllegalStateException("Calls to setForegroundAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                        }
                        ((D0.h) ((M0.r) this.f1437k).f1701b).f(string, (C0.i) this.n);
                        ((Context) this.f1440o).startService(K0.c.a((Context) this.f1440o, AbstractC0409x1.d(oVarH), (C0.i) this.n));
                    }
                    ((N0.k) this.f1439m).j(null);
                    return;
                } catch (Throwable th3) {
                    ((N0.k) this.f1439m).k(th3);
                    return;
                }
            default:
                String str3 = (String) this.f1438l;
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("callsign", (String) this.f1437k);
                    jSONObject.put("token", (String) this.f1439m);
                    jSONObject.put("platform", "android");
                    jSONObject.put("device_id", str3);
                    jSONObject.put("device_name", (String) this.n);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://ur1.unifiedradios.com/messages/fcm.php").openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                    httpURLConnection.setRequestProperty("Accept", "application/json");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setConnectTimeout(10000);
                    httpURLConnection.setReadTimeout(10000);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    outputStream.write(jSONObject.toString().getBytes("UTF-8"));
                    outputStream.flush();
                    outputStream.close();
                    int responseCode = httpURLConnection.getResponseCode();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((responseCode < 200 || responseCode >= 300) ? httpURLConnection.getErrorStream() : httpURLConnection.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            bufferedReader.close();
                            httpURLConnection.disconnect();
                            String string2 = sb.toString();
                            if (responseCode >= 200 && responseCode < 300) {
                                Log.d("Unified - Main Activity", "FCM token registered successfully on app startup");
                                ((SharedPreferences) this.f1440o).edit().putBoolean("fcm_registered", true).putString("registered_device_id", str3).putLong("registration_timestamp", System.currentTimeMillis()).apply();
                                return;
                            }
                            Log.e("Unified - Main Activity", "Failed to register FCM token on startup: " + responseCode);
                            Log.e("Unified - Main Activity", "Error response: " + string2);
                            return;
                        }
                        sb.append(line);
                    }
                } catch (Exception e8) {
                    Log.e("Unified - Main Activity", "Network error registering FCM token on startup", e8);
                    return;
                }
        }
    }

    public RunnableC0116w0(C0120x1 c0120x1, String str, String str2, b2 b2Var, com.google.android.gms.internal.measurement.M m5) {
        this.f1436j = 2;
        this.f1437k = str;
        this.f1439m = str2;
        this.f1438l = b2Var;
        this.n = m5;
        this.f1440o = c0120x1;
    }

    public RunnableC0116w0(C0120x1 c0120x1, AtomicReference atomicReference, String str, String str2, b2 b2Var) {
        this.f1436j = 1;
        this.f1439m = atomicReference;
        this.f1437k = str;
        this.n = str2;
        this.f1438l = b2Var;
        this.f1440o = c0120x1;
    }

    public /* synthetic */ RunnableC0116w0(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, int i5) {
        this.f1436j = i5;
        this.f1437k = obj;
        this.f1439m = obj2;
        this.f1438l = obj3;
        this.n = obj4;
        this.f1440o = obj5;
    }
}
