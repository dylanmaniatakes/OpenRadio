package A2;

import F2.n;
import G2.k;
import J1.D;
import K.m;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.Trace;
import android.util.Base64;
import android.util.Log;
import com.google.firebase.FirebaseCommonRegistrar;
import com.google.firebase.components.ComponentDiscoveryService;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.provider.FirebaseInitProvider;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p1.ComponentCallbacks2C0828d;
import q1.E;
import u1.AbstractC0907b;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: j, reason: collision with root package name */
    public static final Object f24j = new Object();

    /* renamed from: k, reason: collision with root package name */
    public static final q.b f25k = new q.b();

    /* renamed from: a, reason: collision with root package name */
    public final Context f26a;

    /* renamed from: b, reason: collision with root package name */
    public final String f27b;

    /* renamed from: c, reason: collision with root package name */
    public final j f28c;

    /* renamed from: d, reason: collision with root package name */
    public final F2.g f29d;
    public final n g;
    public final Q2.a h;

    /* renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f30e = new AtomicBoolean(false);

    /* renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f31f = new AtomicBoolean();

    /* renamed from: i, reason: collision with root package name */
    public final CopyOnWriteArrayList f32i = new CopyOnWriteArrayList();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.util.List] */
    public g(Context context, String str, j jVar) throws PackageManager.NameNotFoundException {
        ?? arrayList;
        int i5 = 1;
        int i6 = 0;
        new CopyOnWriteArrayList();
        this.f26a = context;
        E.f(str);
        this.f27b = str;
        this.f28c = jVar;
        a aVar = FirebaseInitProvider.f5551c;
        Trace.beginSection("Firebase");
        Trace.beginSection("ComponentDiscovery");
        ArrayList arrayList2 = new ArrayList();
        Bundle bundle = null;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                Log.w("ComponentDiscovery", "Context has no PackageManager.");
            } else {
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, (Class<?>) ComponentDiscoveryService.class), 128);
                if (serviceInfo == null) {
                    Log.w("ComponentDiscovery", ComponentDiscoveryService.class + " has no service info.");
                } else {
                    bundle = serviceInfo.metaData;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
            Log.w("ComponentDiscovery", "Application info not found.");
        }
        if (bundle == null) {
            Log.w("ComponentDiscovery", "Could not retrieve metadata, returning empty list of registrars.");
            arrayList = Collections.emptyList();
        } else {
            arrayList = new ArrayList();
            for (String str2 : bundle.keySet()) {
                if ("com.google.firebase.components.ComponentRegistrar".equals(bundle.get(str2)) && str2.startsWith("com.google.firebase.components:")) {
                    arrayList.add(str2.substring(31));
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new F2.d(i6, (String) it.next()));
        }
        Trace.endSection();
        Trace.beginSection("Runtime");
        k kVar = k.f641j;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        arrayList3.addAll(arrayList2);
        arrayList3.add(new F2.d(i5, new FirebaseCommonRegistrar()));
        arrayList3.add(new F2.d(i5, new ExecutorsRegistrar()));
        arrayList4.add(F2.b.c(context, Context.class, new Class[0]));
        arrayList4.add(F2.b.c(this, g.class, new Class[0]));
        arrayList4.add(F2.b.c(jVar, j.class, new Class[0]));
        D d5 = new D(22);
        if (m.a(context) && FirebaseInitProvider.f5552d.get()) {
            arrayList4.add(F2.b.c(aVar, a.class, new Class[0]));
        }
        F2.g gVar = new F2.g(arrayList3, arrayList4, d5);
        this.f29d = gVar;
        Trace.endSection();
        this.g = new n(new c(this, i6, context));
        this.h = gVar.e(O2.d.class);
        d dVar = new d(this);
        a();
        if (this.f30e.get()) {
            ComponentCallbacks2C0828d.g.f9108c.get();
        }
        this.f32i.add(dVar);
        Trace.endSection();
    }

    public static g b() {
        g gVar;
        synchronized (f24j) {
            try {
                gVar = (g) f25k.getOrDefault("[DEFAULT]", null);
                if (gVar == null) {
                    StringBuilder sb = new StringBuilder("Default FirebaseApp is not initialized in this process ");
                    if (AbstractC0907b.g == null) {
                        AbstractC0907b.g = Application.getProcessName();
                    }
                    sb.append(AbstractC0907b.g);
                    sb.append(". Make sure to call FirebaseApp.initializeApp(Context) first.");
                    throw new IllegalStateException(sb.toString());
                }
                ((O2.d) gVar.h.get()).b();
            } catch (Throwable th) {
                throw th;
            }
        }
        return gVar;
    }

    public static g e(Context context) {
        synchronized (f24j) {
            try {
                if (f25k.containsKey("[DEFAULT]")) {
                    return b();
                }
                j jVarA = j.a(context);
                if (jVarA == null) {
                    Log.w("FirebaseApp", "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
                    return null;
                }
                return f(context, jVarA);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static g f(Context context, j jVar) {
        g gVar;
        AtomicReference atomicReference = e.f21a;
        if (context.getApplicationContext() instanceof Application) {
            Application application = (Application) context.getApplicationContext();
            AtomicReference atomicReference2 = e.f21a;
            if (atomicReference2.get() == null) {
                e eVar = new e();
                while (true) {
                    if (atomicReference2.compareAndSet(null, eVar)) {
                        ComponentCallbacks2C0828d.a(application);
                        ComponentCallbacks2C0828d componentCallbacks2C0828d = ComponentCallbacks2C0828d.g;
                        componentCallbacks2C0828d.getClass();
                        synchronized (componentCallbacks2C0828d) {
                            componentCallbacks2C0828d.f9110e.add(eVar);
                        }
                        break;
                    }
                    if (atomicReference2.get() != null) {
                        break;
                    }
                }
            }
        }
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (f24j) {
            q.b bVar = f25k;
            E.k("FirebaseApp name [DEFAULT] already exists!", !bVar.containsKey("[DEFAULT]"));
            E.j(context, "Application context cannot be null.");
            gVar = new g(context, "[DEFAULT]", jVar);
            bVar.put("[DEFAULT]", gVar);
        }
        gVar.d();
        return gVar;
    }

    public final void a() {
        E.k("FirebaseApp was deleted", !this.f31f.get());
    }

    public final String c() {
        StringBuilder sb = new StringBuilder();
        a();
        byte[] bytes = this.f27b.getBytes(Charset.defaultCharset());
        sb.append(bytes == null ? null : Base64.encodeToString(bytes, 11));
        sb.append("+");
        a();
        byte[] bytes2 = this.f28c.f39b.getBytes(Charset.defaultCharset());
        sb.append(bytes2 != null ? Base64.encodeToString(bytes2, 11) : null);
        return sb.toString();
    }

    public final void d() {
        HashMap map;
        if (!m.a(this.f26a)) {
            StringBuilder sb = new StringBuilder("Device in Direct Boot Mode: postponing initialization of Firebase APIs for app ");
            a();
            sb.append(this.f27b);
            Log.i("FirebaseApp", sb.toString());
            Context context = this.f26a;
            AtomicReference atomicReference = f.f22b;
            if (atomicReference.get() == null) {
                f fVar = new f(context);
                while (!atomicReference.compareAndSet(null, fVar)) {
                    if (atomicReference.get() != null) {
                        return;
                    }
                }
                context.registerReceiver(fVar, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                return;
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder("Device unlocked: initializing all Firebase APIs for app ");
        a();
        sb2.append(this.f27b);
        Log.i("FirebaseApp", sb2.toString());
        F2.g gVar = this.f29d;
        a();
        boolean zEquals = "[DEFAULT]".equals(this.f27b);
        AtomicReference atomicReference2 = gVar.f557f;
        Boolean boolValueOf = Boolean.valueOf(zEquals);
        while (true) {
            if (atomicReference2.compareAndSet(null, boolValueOf)) {
                synchronized (gVar) {
                    map = new HashMap(gVar.f552a);
                }
                gVar.g(map, zEquals);
                break;
            } else if (atomicReference2.get() != null) {
                break;
            }
        }
        ((O2.d) this.h.get()).b();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        gVar.a();
        return this.f27b.equals(gVar.f27b);
    }

    public final int hashCode() {
        return this.f27b.hashCode();
    }

    public final String toString() {
        L0.c cVar = new L0.c(this);
        cVar.b(this.f27b, "name");
        cVar.b(this.f28c, "options");
        return cVar.toString();
    }
}
