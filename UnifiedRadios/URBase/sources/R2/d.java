package R2;

import F2.n;
import J1.D;
import L0.s;
import N1.r;
import android.net.TrafficStats;
import android.util.Log;
import i3.C0573b;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
import q1.E;
import s.AbstractC0882e;
import w1.AbstractC0930a;

/* loaded from: classes.dex */
public final class d implements e {

    /* renamed from: m, reason: collision with root package name */
    public static final Object f2284m = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final A2.g f2285a;

    /* renamed from: b, reason: collision with root package name */
    public final T2.c f2286b;

    /* renamed from: c, reason: collision with root package name */
    public final s f2287c;

    /* renamed from: d, reason: collision with root package name */
    public final k f2288d;

    /* renamed from: e, reason: collision with root package name */
    public final n f2289e;

    /* renamed from: f, reason: collision with root package name */
    public final i f2290f;
    public final Object g;
    public final ExecutorService h;

    /* renamed from: i, reason: collision with root package name */
    public final Executor f2291i;

    /* renamed from: j, reason: collision with root package name */
    public String f2292j;

    /* renamed from: k, reason: collision with root package name */
    public final HashSet f2293k;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f2294l;

    static {
        new AtomicInteger(1);
    }

    public d(A2.g gVar, Q2.a aVar, ExecutorService executorService, G2.j jVar) {
        gVar.a();
        T2.c cVar = new T2.c(gVar.f26a, aVar);
        s sVar = new s(gVar);
        if (D.f717d == null) {
            D.f717d = new D(16);
        }
        D d5 = D.f717d;
        if (k.f2302d == null) {
            k.f2302d = new k(d5);
        }
        k kVar = k.f2302d;
        n nVar = new n(new F2.d(2, gVar));
        i iVar = new i();
        this.g = new Object();
        this.f2293k = new HashSet();
        this.f2294l = new ArrayList();
        this.f2285a = gVar;
        this.f2286b = cVar;
        this.f2287c = sVar;
        this.f2288d = kVar;
        this.f2289e = nVar;
        this.f2290f = iVar;
        this.h = executorService;
        this.f2291i = jVar;
    }

    /* JADX WARN: Finally extract failed */
    public final void a() {
        S2.b bVarW;
        synchronized (f2284m) {
            try {
                A2.g gVar = this.f2285a;
                gVar.a();
                L0.e eVarG = L0.e.g(gVar.f26a);
                try {
                    bVarW = this.f2287c.w();
                    int i5 = bVarW.f2369b;
                    if (i5 == 2 || i5 == 1) {
                        String strF = f(bVarW);
                        s sVar = this.f2287c;
                        S2.a aVarA = bVarW.a();
                        aVarA.f2362a = strF;
                        aVarA.f2363b = 3;
                        bVarW = aVarA.a();
                        sVar.j(bVarW);
                    }
                    if (eVarG != null) {
                        eVarG.r();
                    }
                } catch (Throwable th) {
                    if (eVarG != null) {
                        eVarG.r();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        i(bVarW);
        this.f2291i.execute(new c(0, this));
    }

    public final S2.b b(S2.b bVar) {
        int responseCode;
        T2.b bVarF;
        A2.g gVar = this.f2285a;
        gVar.a();
        String str = gVar.f28c.f38a;
        String str2 = bVar.f2368a;
        A2.g gVar2 = this.f2285a;
        gVar2.a();
        String str3 = gVar2.f28c.g;
        String str4 = bVar.f2371d;
        T2.c cVar = this.f2286b;
        T2.d dVar = cVar.f2453c;
        if (!dVar.a()) {
            throw new f("Firebase Installations Service is unavailable. Please try again later.");
        }
        URL urlA = T2.c.a("projects/" + str3 + "/installations/" + str2 + "/authTokens:generate");
        for (int i5 = 0; i5 <= 1; i5++) {
            TrafficStats.setThreadStatsTag(32771);
            HttpURLConnection httpURLConnectionC = cVar.c(urlA, str);
            try {
                try {
                    httpURLConnectionC.setRequestMethod("POST");
                    httpURLConnectionC.addRequestProperty("Authorization", "FIS_v2 " + str4);
                    httpURLConnectionC.setDoOutput(true);
                    T2.c.h(httpURLConnectionC);
                    responseCode = httpURLConnectionC.getResponseCode();
                    dVar.b(responseCode);
                } catch (Throwable th) {
                    httpURLConnectionC.disconnect();
                    TrafficStats.clearThreadStatsTag();
                    throw th;
                }
            } catch (IOException | AssertionError unused) {
            }
            if (responseCode >= 200 && responseCode < 300) {
                bVarF = T2.c.f(httpURLConnectionC);
            } else {
                T2.c.b(httpURLConnectionC, null, str, str3);
                if (responseCode == 401 || responseCode == 404) {
                    C0573b c0573bA = T2.b.a();
                    c0573bA.f7295c = 3;
                    bVarF = c0573bA.c();
                } else {
                    if (responseCode == 429) {
                        throw new f("Firebase servers have received too many requests from this client in a short period of time. Please try again later.");
                    }
                    if (responseCode < 500 || responseCode >= 600) {
                        Log.e("Firebase-Installations", "Firebase Installations can not communicate with Firebase server APIs due to invalid configuration. Please update your Firebase initialization process and set valid Firebase options (API key, Project ID, Application ID) when initializing Firebase.");
                        C0573b c0573bA2 = T2.b.a();
                        c0573bA2.f7295c = 2;
                        bVarF = c0573bA2.c();
                    }
                    httpURLConnectionC.disconnect();
                    TrafficStats.clearThreadStatsTag();
                }
            }
            httpURLConnectionC.disconnect();
            TrafficStats.clearThreadStatsTag();
            int iC = AbstractC0882e.c(bVarF.f2448c);
            if (iC == 0) {
                k kVar = this.f2288d;
                kVar.getClass();
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                kVar.f2303a.getClass();
                long seconds = timeUnit.toSeconds(System.currentTimeMillis());
                S2.a aVarA = bVar.a();
                aVarA.f2364c = bVarF.f2446a;
                aVarA.f2366e = Long.valueOf(bVarF.f2447b);
                aVarA.f2367f = Long.valueOf(seconds);
                return aVarA.a();
            }
            if (iC == 1) {
                S2.a aVarA2 = bVar.a();
                aVarA2.g = "BAD CONFIG";
                aVarA2.f2363b = 5;
                return aVarA2.a();
            }
            if (iC != 2) {
                throw new f("Firebase Installations Service is unavailable. Please try again later.");
            }
            synchronized (this) {
                this.f2292j = null;
            }
            S2.a aVarA3 = bVar.a();
            aVarA3.f2363b = 2;
            return aVarA3.a();
        }
        throw new f("Firebase Installations Service is unavailable. Please try again later.");
    }

    public final r c() {
        String str;
        e();
        synchronized (this) {
            str = this.f2292j;
        }
        if (str != null) {
            return AbstractC0930a.i(str);
        }
        N1.k kVar = new N1.k();
        h hVar = new h(kVar);
        synchronized (this.g) {
            this.f2294l.add(hVar);
        }
        r rVar = kVar.f1789a;
        this.h.execute(new b(this, 0));
        return rVar;
    }

    public final r d() {
        e();
        N1.k kVar = new N1.k();
        g gVar = new g(this.f2288d, kVar);
        synchronized (this.g) {
            this.f2294l.add(gVar);
        }
        this.h.execute(new b(this, 1));
        return kVar.f1789a;
    }

    public final void e() {
        A2.g gVar = this.f2285a;
        gVar.a();
        E.g(gVar.f28c.f39b, "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        gVar.a();
        E.g(gVar.f28c.g, "Please set your Project ID. A valid Firebase Project ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        gVar.a();
        E.g(gVar.f28c.f38a, "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
        gVar.a();
        String str = gVar.f28c.f39b;
        Pattern pattern = k.f2301c;
        E.b(str.contains(":"), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        gVar.a();
        E.b(k.f2301c.matcher(gVar.f28c.f38a).matches(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String f(S2.b r6) {
        /*
            r5 = this;
            A2.g r0 = r5.f2285a
            r0.a()
            java.lang.String r0 = r0.f27b
            java.lang.String r1 = "CHIME_ANDROID_SDK"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L1e
            A2.g r0 = r5.f2285a
            r0.a()
            java.lang.String r1 = "[DEFAULT]"
            java.lang.String r0 = r0.f27b
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L5b
        L1e:
            r0 = 1
            int r6 = r6.f2369b
            if (r6 != r0) goto L5b
            F2.n r6 = r5.f2289e
            java.lang.Object r6 = r6.get()
            S2.c r6 = (S2.c) r6
            android.content.SharedPreferences r0 = r6.f2375a
            monitor-enter(r0)
            android.content.SharedPreferences r1 = r6.f2375a     // Catch: java.lang.Throwable -> L3f
            monitor-enter(r1)     // Catch: java.lang.Throwable -> L3f
            android.content.SharedPreferences r2 = r6.f2375a     // Catch: java.lang.Throwable -> L56
            java.lang.String r3 = "|S|id"
            r4 = 0
            java.lang.String r2 = r2.getString(r3, r4)     // Catch: java.lang.Throwable -> L56
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L56
            if (r2 == 0) goto L41
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3f
            goto L46
        L3f:
            r6 = move-exception
            goto L59
        L41:
            java.lang.String r2 = r6.a()     // Catch: java.lang.Throwable -> L3f
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3f
        L46:
            boolean r6 = android.text.TextUtils.isEmpty(r2)
            if (r6 == 0) goto L55
            R2.i r6 = r5.f2290f
            r6.getClass()
            java.lang.String r2 = R2.i.a()
        L55:
            return r2
        L56:
            r6 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L56
            throw r6     // Catch: java.lang.Throwable -> L3f
        L59:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3f
            throw r6
        L5b:
            R2.i r6 = r5.f2290f
            r6.getClass()
            java.lang.String r6 = R2.i.a()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: R2.d.f(S2.b):java.lang.String");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [T2.c] */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [T2.a] */
    public final S2.b g(S2.b bVar) {
        int responseCode;
        String str = bVar.f2368a;
        int i5 = 0;
        String string = null;
        if (str != null && str.length() == 11) {
            S2.c cVar = (S2.c) this.f2289e.get();
            synchronized (cVar.f2375a) {
                try {
                    String[] strArr = S2.c.f2374c;
                    int i6 = 0;
                    while (true) {
                        if (i6 < 4) {
                            String str2 = strArr[i6];
                            String string2 = cVar.f2375a.getString("|T|" + cVar.f2376b + "|" + str2, null);
                            if (string2 == null || string2.isEmpty()) {
                                i6++;
                            } else if (string2.startsWith("{")) {
                                try {
                                    string = new JSONObject(string2).getString("token");
                                } catch (JSONException unused) {
                                }
                            } else {
                                string = string2;
                            }
                        }
                    }
                } finally {
                }
            }
        }
        T2.c cVar2 = this.f2286b;
        A2.g gVar = this.f2285a;
        gVar.a();
        String str3 = gVar.f28c.f38a;
        String str4 = bVar.f2368a;
        A2.g gVar2 = this.f2285a;
        gVar2.a();
        String str5 = gVar2.f28c.g;
        A2.g gVar3 = this.f2285a;
        gVar3.a();
        String str6 = gVar3.f28c.f39b;
        T2.d dVar = cVar2.f2453c;
        if (!dVar.a()) {
            throw new f("Firebase Installations Service is unavailable. Please try again later.");
        }
        URL urlA = T2.c.a("projects/" + str5 + "/installations");
        T2.a aVar = cVar2;
        while (i5 <= 1) {
            TrafficStats.setThreadStatsTag(32769);
            HttpURLConnection httpURLConnectionC = aVar.c(urlA, str3);
            try {
                try {
                    httpURLConnectionC.setRequestMethod("POST");
                    httpURLConnectionC.setDoOutput(true);
                    if (string != null) {
                        httpURLConnectionC.addRequestProperty("x-goog-fis-android-iid-migration-auth", string);
                    }
                    T2.c.g(httpURLConnectionC, str4, str6);
                    responseCode = httpURLConnectionC.getResponseCode();
                    dVar.b(responseCode);
                } finally {
                    httpURLConnectionC.disconnect();
                    TrafficStats.clearThreadStatsTag();
                }
            } catch (IOException | AssertionError unused2) {
            }
            if (responseCode < 200 || responseCode >= 300) {
                try {
                    T2.c.b(httpURLConnectionC, str6, str3, str5);
                } catch (IOException | AssertionError unused3) {
                    httpURLConnectionC.disconnect();
                    TrafficStats.clearThreadStatsTag();
                    i5++;
                    aVar = aVar;
                }
                if (responseCode == 429) {
                    throw new f("Firebase servers have received too many requests from this client in a short period of time. Please try again later.");
                }
                if (responseCode < 500 || responseCode >= 600) {
                    Log.e("Firebase-Installations", "Firebase Installations can not communicate with Firebase server APIs due to invalid configuration. Please update your Firebase initialization process and set valid Firebase options (API key, Project ID, Application ID) when initializing Firebase.");
                    T2.a aVar2 = new T2.a(null, null, null, null, 2);
                    httpURLConnectionC.disconnect();
                    TrafficStats.clearThreadStatsTag();
                    aVar = aVar2;
                } else {
                    httpURLConnectionC.disconnect();
                    TrafficStats.clearThreadStatsTag();
                    i5++;
                    aVar = aVar;
                }
            } else {
                T2.a aVarE = T2.c.e(httpURLConnectionC);
                httpURLConnectionC.disconnect();
                TrafficStats.clearThreadStatsTag();
                aVar = aVarE;
            }
            int iC = AbstractC0882e.c(aVar.f2445e);
            if (iC != 0) {
                if (iC != 1) {
                    throw new f("Firebase Installations Service is unavailable. Please try again later.");
                }
                S2.a aVarA = bVar.a();
                aVarA.g = "BAD CONFIG";
                aVarA.f2363b = 5;
                return aVarA.a();
            }
            String str7 = aVar.f2442b;
            String str8 = aVar.f2443c;
            k kVar = this.f2288d;
            kVar.getClass();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            kVar.f2303a.getClass();
            long seconds = timeUnit.toSeconds(System.currentTimeMillis());
            T2.b bVar2 = aVar.f2444d;
            String str9 = bVar2.f2446a;
            long j5 = bVar2.f2447b;
            S2.a aVarA2 = bVar.a();
            aVarA2.f2362a = str7;
            aVarA2.f2363b = 4;
            aVarA2.f2364c = str9;
            aVarA2.f2365d = str8;
            aVarA2.f2366e = Long.valueOf(j5);
            aVarA2.f2367f = Long.valueOf(seconds);
            return aVarA2.a();
        }
        throw new f("Firebase Installations Service is unavailable. Please try again later.");
    }

    public final void h(Exception exc) {
        synchronized (this.g) {
            try {
                Iterator it = this.f2294l.iterator();
                while (it.hasNext()) {
                    if (((j) it.next()).b(exc)) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void i(S2.b bVar) {
        synchronized (this.g) {
            try {
                Iterator it = this.f2294l.iterator();
                while (it.hasNext()) {
                    if (((j) it.next()).a(bVar)) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
