package com.google.firebase.messaging;

import A2.g;
import D1.C0016n;
import F2.f;
import J1.C0055b1;
import J1.R0;
import N1.r;
import N2.c;
import Q2.a;
import V1.e;
import X2.C0202f;
import X2.j;
import X2.l;
import X2.m;
import X2.n;
import X2.u;
import X2.z;
import a.AbstractC0203a;
import android.app.Application;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Keep;
import com.google.android.gms.internal.measurement.AbstractC0399v1;
import com.google.firebase.messaging.FirebaseMessaging;
import f3.C0519j;
import i0.ExecutorC0566c;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import m1.C0761b;
import m1.d;
import m1.h;
import q.b;
import q1.E;
import v1.ThreadFactoryC0920a;
import w1.AbstractC0930a;

/* loaded from: classes.dex */
public class FirebaseMessaging {

    /* renamed from: k, reason: collision with root package name */
    public static C0519j f5540k;

    /* renamed from: m, reason: collision with root package name */
    public static ScheduledThreadPoolExecutor f5542m;

    /* renamed from: a, reason: collision with root package name */
    public final g f5543a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f5544b;

    /* renamed from: c, reason: collision with root package name */
    public final n f5545c;

    /* renamed from: d, reason: collision with root package name */
    public final j f5546d;

    /* renamed from: e, reason: collision with root package name */
    public final C0016n f5547e;

    /* renamed from: f, reason: collision with root package name */
    public final Executor f5548f;
    public final Executor g;
    public final e h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f5549i;

    /* renamed from: j, reason: collision with root package name */
    public static final long f5539j = TimeUnit.HOURS.toSeconds(8);

    /* renamed from: l, reason: collision with root package name */
    public static a f5541l = new f(6);

    public FirebaseMessaging(g gVar, a aVar, a aVar2, R2.e eVar, a aVar3, c cVar) {
        final int i5 = 1;
        final int i6 = 0;
        gVar.a();
        Context context = gVar.f26a;
        final e eVar2 = new e();
        eVar2.f2530b = 0;
        eVar2.f2531c = context;
        gVar.a();
        C0761b c0761b = new C0761b(gVar.f26a);
        final n nVar = new n();
        nVar.f2818a = gVar;
        nVar.f2819b = eVar2;
        nVar.f2820c = c0761b;
        nVar.f2821d = aVar;
        nVar.f2822e = aVar2;
        nVar.f2823f = eVar;
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new ThreadFactoryC0920a("Firebase-Messaging-Task"));
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new ThreadFactoryC0920a("Firebase-Messaging-Init"));
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC0920a("Firebase-Messaging-File-Io"));
        this.f5549i = false;
        f5541l = aVar3;
        this.f5543a = gVar;
        this.f5547e = new C0016n(this, cVar);
        gVar.a();
        final Context context2 = gVar.f26a;
        this.f5544b = context2;
        C0055b1 c0055b1 = new C0055b1();
        this.h = eVar2;
        this.f5545c = nVar;
        this.f5546d = new j(executorServiceNewSingleThreadExecutor);
        this.f5548f = scheduledThreadPoolExecutor;
        this.g = threadPoolExecutor;
        gVar.a();
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(c0055b1);
        } else {
            Log.w("FirebaseMessaging", "Context " + context + " was not an application, can't register for lifecycle callbacks. Some notification events may be dropped as a result.");
        }
        scheduledThreadPoolExecutor.execute(new Runnable(this) { // from class: X2.k

            /* renamed from: k, reason: collision with root package name */
            public final /* synthetic */ FirebaseMessaging f2811k;

            {
                this.f2811k = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                N1.r rVarC;
                int i7;
                switch (i6) {
                    case 0:
                        FirebaseMessaging firebaseMessaging = this.f2811k;
                        if (firebaseMessaging.f5547e.e() && firebaseMessaging.h(firebaseMessaging.d())) {
                            synchronized (firebaseMessaging) {
                                if (!firebaseMessaging.f5549i) {
                                    firebaseMessaging.g(0L);
                                }
                            }
                            return;
                        }
                        return;
                    default:
                        FirebaseMessaging firebaseMessaging2 = this.f2811k;
                        final Context context3 = firebaseMessaging2.f5544b;
                        android.support.v4.media.session.b.f(context3);
                        final boolean zF = firebaseMessaging2.f();
                        if (Build.VERSION.SDK_INT >= 29) {
                            SharedPreferences sharedPreferencesD = AbstractC0399v1.d(context3);
                            if (!sharedPreferencesD.contains("proxy_retention") || sharedPreferencesD.getBoolean("proxy_retention", false) != zF) {
                                C0761b c0761b2 = (C0761b) firebaseMessaging2.f5545c.f2820c;
                                if (c0761b2.f8515c.a() >= 241100000) {
                                    Bundle bundle = new Bundle();
                                    bundle.putBoolean("proxy_retention", zF);
                                    m1.m mVarB = m1.m.b(c0761b2.f8514b);
                                    synchronized (mVarB) {
                                        i7 = mVarB.f8544c;
                                        mVarB.f8544c = i7 + 1;
                                    }
                                    rVarC = mVarB.c(new m1.l(i7, 4, bundle, 0));
                                } else {
                                    IOException iOException = new IOException("SERVICE_NOT_AVAILABLE");
                                    N1.r rVar = new N1.r();
                                    rVar.l(iOException);
                                    rVarC = rVar;
                                }
                                rVarC.b(new ExecutorC0566c(0), new N1.g() { // from class: X2.q
                                    @Override // N1.g
                                    public final void h(Object obj) {
                                        SharedPreferences.Editor editorEdit = AbstractC0399v1.d(context3).edit();
                                        editorEdit.putBoolean("proxy_retention", zF);
                                        editorEdit.apply();
                                    }
                                });
                            }
                        }
                        if (firebaseMessaging2.f()) {
                            firebaseMessaging2.e();
                            return;
                        }
                        return;
                }
            }
        });
        final ScheduledThreadPoolExecutor scheduledThreadPoolExecutor2 = new ScheduledThreadPoolExecutor(1, new ThreadFactoryC0920a("Firebase-Messaging-Topics-Io"));
        int i7 = z.f2856j;
        AbstractC0930a.c(scheduledThreadPoolExecutor2, new Callable() { // from class: X2.y
            @Override // java.util.concurrent.Callable
            public final Object call() {
                x xVar;
                Context context3 = context2;
                ScheduledExecutorService scheduledExecutorService = scheduledThreadPoolExecutor2;
                FirebaseMessaging firebaseMessaging = this;
                V1.e eVar3 = eVar2;
                n nVar2 = nVar;
                synchronized (x.class) {
                    try {
                        WeakReference weakReference = x.f2848b;
                        xVar = weakReference != null ? (x) weakReference.get() : null;
                        if (xVar == null) {
                            SharedPreferences sharedPreferences = context3.getSharedPreferences("com.google.android.gms.appid", 0);
                            x xVar2 = new x();
                            synchronized (xVar2) {
                                xVar2.f2849a = F2.t.g(sharedPreferences, (ScheduledThreadPoolExecutor) scheduledExecutorService);
                            }
                            x.f2848b = new WeakReference(xVar2);
                            xVar = xVar2;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return new z(firebaseMessaging, eVar3, xVar, nVar2, context3, (ScheduledThreadPoolExecutor) scheduledExecutorService);
            }
        }).b(scheduledThreadPoolExecutor, new l(this, i6));
        scheduledThreadPoolExecutor.execute(new Runnable(this) { // from class: X2.k

            /* renamed from: k, reason: collision with root package name */
            public final /* synthetic */ FirebaseMessaging f2811k;

            {
                this.f2811k = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                N1.r rVarC;
                int i72;
                switch (i5) {
                    case 0:
                        FirebaseMessaging firebaseMessaging = this.f2811k;
                        if (firebaseMessaging.f5547e.e() && firebaseMessaging.h(firebaseMessaging.d())) {
                            synchronized (firebaseMessaging) {
                                if (!firebaseMessaging.f5549i) {
                                    firebaseMessaging.g(0L);
                                }
                            }
                            return;
                        }
                        return;
                    default:
                        FirebaseMessaging firebaseMessaging2 = this.f2811k;
                        final Context context3 = firebaseMessaging2.f5544b;
                        android.support.v4.media.session.b.f(context3);
                        final boolean zF = firebaseMessaging2.f();
                        if (Build.VERSION.SDK_INT >= 29) {
                            SharedPreferences sharedPreferencesD = AbstractC0399v1.d(context3);
                            if (!sharedPreferencesD.contains("proxy_retention") || sharedPreferencesD.getBoolean("proxy_retention", false) != zF) {
                                C0761b c0761b2 = (C0761b) firebaseMessaging2.f5545c.f2820c;
                                if (c0761b2.f8515c.a() >= 241100000) {
                                    Bundle bundle = new Bundle();
                                    bundle.putBoolean("proxy_retention", zF);
                                    m1.m mVarB = m1.m.b(c0761b2.f8514b);
                                    synchronized (mVarB) {
                                        i72 = mVarB.f8544c;
                                        mVarB.f8544c = i72 + 1;
                                    }
                                    rVarC = mVarB.c(new m1.l(i72, 4, bundle, 0));
                                } else {
                                    IOException iOException = new IOException("SERVICE_NOT_AVAILABLE");
                                    N1.r rVar = new N1.r();
                                    rVar.l(iOException);
                                    rVarC = rVar;
                                }
                                rVarC.b(new ExecutorC0566c(0), new N1.g() { // from class: X2.q
                                    @Override // N1.g
                                    public final void h(Object obj) {
                                        SharedPreferences.Editor editorEdit = AbstractC0399v1.d(context3).edit();
                                        editorEdit.putBoolean("proxy_retention", zF);
                                        editorEdit.apply();
                                    }
                                });
                            }
                        }
                        if (firebaseMessaging2.f()) {
                            firebaseMessaging2.e();
                            return;
                        }
                        return;
                }
            }
        });
    }

    public static void b(Runnable runnable, long j5) {
        synchronized (FirebaseMessaging.class) {
            try {
                if (f5542m == null) {
                    f5542m = new ScheduledThreadPoolExecutor(1, new ThreadFactoryC0920a("TAG"));
                }
                f5542m.schedule(runnable, j5, TimeUnit.SECONDS);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static synchronized C0519j c(Context context) {
        try {
            if (f5540k == null) {
                f5540k = new C0519j(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f5540k;
    }

    @Keep
    public static synchronized FirebaseMessaging getInstance(g gVar) {
        FirebaseMessaging firebaseMessaging;
        gVar.a();
        firebaseMessaging = (FirebaseMessaging) gVar.f29d.a(FirebaseMessaging.class);
        E.j(firebaseMessaging, "Firebase Messaging component is not present");
        return firebaseMessaging;
    }

    public final String a() {
        N1.j jVarJ;
        u uVarD = d();
        if (!h(uVarD)) {
            return uVarD.f2838a;
        }
        String strB = e.b(this.f5543a);
        j jVar = this.f5546d;
        synchronized (jVar) {
            jVarJ = (N1.j) ((b) jVar.f2809b).getOrDefault(strB, null);
            if (jVarJ == null) {
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "Making new request for: " + strB);
                }
                n nVar = this.f5545c;
                jVarJ = nVar.g(nVar.q(e.b((g) nVar.f2818a), "*", new Bundle())).k(this.g, new m(this, strB, uVarD, 0)).j((Executor) jVar.f2808a, new C0202f(jVar, 1, strB));
                ((b) jVar.f2809b).put(strB, jVarJ);
            } else if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Joining ongoing request for: " + strB);
            }
        }
        try {
            return (String) AbstractC0930a.a(jVarJ);
        } catch (InterruptedException | ExecutionException e5) {
            throw new IOException(e5);
        }
    }

    public final u d() {
        u uVarB;
        C0519j c0519jC = c(this.f5544b);
        g gVar = this.f5543a;
        gVar.a();
        String strC = "[DEFAULT]".equals(gVar.f27b) ? "" : gVar.c();
        String strB = e.b(this.f5543a);
        synchronized (c0519jC) {
            uVarB = u.b(((SharedPreferences) c0519jC.f6730d).getString(strC + "|T|" + strB + "|*", null));
        }
        return uVarB;
    }

    public final void e() {
        r rVarI;
        int i5;
        C0761b c0761b = (C0761b) this.f5545c.f2820c;
        if (c0761b.f8515c.a() >= 241100000) {
            m1.m mVarB = m1.m.b(c0761b.f8514b);
            Bundle bundle = Bundle.EMPTY;
            synchronized (mVarB) {
                i5 = mVarB.f8544c;
                mVarB.f8544c = i5 + 1;
            }
            rVarI = mVarB.c(new m1.l(i5, 5, bundle, 1)).i(h.f8527l, d.f8521e);
        } else {
            IOException iOException = new IOException("SERVICE_NOT_AVAILABLE");
            r rVar = new r();
            rVar.l(iOException);
            rVarI = rVar;
        }
        rVarI.b(this.f5548f, new l(this, 1));
    }

    public final boolean f() {
        Context context = this.f5544b;
        android.support.v4.media.session.b.f(context);
        if (!(Build.VERSION.SDK_INT >= 29)) {
            if (!Log.isLoggable("FirebaseMessaging", 3)) {
                return false;
            }
            Log.d("FirebaseMessaging", "Platform doesn't support proxying.");
            return false;
        }
        if (!(Binder.getCallingUid() == context.getApplicationInfo().uid)) {
            Log.e("FirebaseMessaging", "error retrieving notification delegate for package " + context.getPackageName());
            return false;
        }
        if (!"com.google.android.gms".equals(((NotificationManager) context.getSystemService(NotificationManager.class)).getNotificationDelegate())) {
            return false;
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "GMS core is set for proxying");
        }
        g gVar = this.f5543a;
        gVar.a();
        if (gVar.f29d.a(C2.a.class) != null) {
            return true;
        }
        return AbstractC0203a.g() && f5541l != null;
    }

    public final synchronized void g(long j5) {
        b(new R0(this, Math.min(Math.max(30L, 2 * j5), f5539j)), j5);
        this.f5549i = true;
    }

    public final boolean h(u uVar) {
        if (uVar != null) {
            String strA = this.h.a();
            if (System.currentTimeMillis() <= uVar.f2840c + u.f2837d && strA.equals(uVar.f2839b)) {
                return false;
            }
        }
        return true;
    }
}
