package p1;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.SparseIntArray;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.DeviceOrientationRequest;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import n1.C0785b;
import n1.C0788e;
import q1.C0863n;
import q1.C0864o;
import q1.C0865p;
import q1.P;
import s1.C0886b;
import u1.AbstractC0907b;
import w1.AbstractC0930a;

/* renamed from: p1.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0832h implements Handler.Callback {

    /* renamed from: p, reason: collision with root package name */
    public static final Status f9112p = new Status(4, "Sign-out occurred while this API call was in progress.", null, null);

    /* renamed from: q, reason: collision with root package name */
    public static final Status f9113q = new Status(4, "The user must be signed in to make this API call.", null, null);

    /* renamed from: r, reason: collision with root package name */
    public static final Object f9114r = new Object();

    /* renamed from: s, reason: collision with root package name */
    public static C0832h f9115s;

    /* renamed from: a, reason: collision with root package name */
    public long f9116a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f9117b;

    /* renamed from: c, reason: collision with root package name */
    public C0865p f9118c;

    /* renamed from: d, reason: collision with root package name */
    public C0886b f9119d;

    /* renamed from: e, reason: collision with root package name */
    public final Context f9120e;

    /* renamed from: f, reason: collision with root package name */
    public final C0788e f9121f;
    public final L0.s g;
    public final AtomicInteger h;

    /* renamed from: i, reason: collision with root package name */
    public final AtomicInteger f9122i;

    /* renamed from: j, reason: collision with root package name */
    public final ConcurrentHashMap f9123j;

    /* renamed from: k, reason: collision with root package name */
    public q f9124k;

    /* renamed from: l, reason: collision with root package name */
    public final q.c f9125l;

    /* renamed from: m, reason: collision with root package name */
    public final q.c f9126m;
    public final A1.f n;

    /* renamed from: o, reason: collision with root package name */
    public volatile boolean f9127o;

    public C0832h(Context context, Looper looper) {
        C0788e c0788e = C0788e.f8738d;
        this.f9116a = DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM;
        this.f9117b = false;
        this.h = new AtomicInteger(1);
        this.f9122i = new AtomicInteger(0);
        this.f9123j = new ConcurrentHashMap(5, 0.75f, 1);
        this.f9124k = null;
        this.f9125l = new q.c(0);
        this.f9126m = new q.c(0);
        this.f9127o = true;
        this.f9120e = context;
        A1.f fVar = new A1.f(looper, this);
        Looper.getMainLooper();
        this.n = fVar;
        this.f9121f = c0788e;
        this.g = new L0.s(23);
        PackageManager packageManager = context.getPackageManager();
        if (AbstractC0907b.f9924f == null) {
            AbstractC0907b.f9924f = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.automotive"));
        }
        if (AbstractC0907b.f9924f.booleanValue()) {
            this.f9127o = false;
        }
        fVar.sendMessage(fVar.obtainMessage(6));
    }

    public static Status d(C0826b c0826b, C0785b c0785b) {
        return new Status(17, "API: " + c0826b.f9105b.f8897b + " is not available on this device. Connection failed with: " + String.valueOf(c0785b), c0785b.f8729l, c0785b);
    }

    public static C0832h g(Context context) {
        C0832h c0832h;
        HandlerThread handlerThread;
        synchronized (f9114r) {
            if (f9115s == null) {
                synchronized (P.h) {
                    try {
                        handlerThread = P.f9336j;
                        if (handlerThread == null) {
                            HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", 9);
                            P.f9336j = handlerThread2;
                            handlerThread2.start();
                            handlerThread = P.f9336j;
                        }
                    } finally {
                    }
                }
                Looper looper = handlerThread.getLooper();
                Context applicationContext = context.getApplicationContext();
                Object obj = C0788e.f8737c;
                f9115s = new C0832h(applicationContext, looper);
            }
            c0832h = f9115s;
        }
        return c0832h;
    }

    public final void a(q qVar) {
        synchronized (f9114r) {
            try {
                if (this.f9124k != qVar) {
                    this.f9124k = qVar;
                    this.f9125l.clear();
                }
                this.f9125l.addAll(qVar.h);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean b() {
        if (this.f9117b) {
            return false;
        }
        C0864o c0864o = (C0864o) C0863n.e().f9401a;
        if (c0864o != null && !c0864o.f9403k) {
            return false;
        }
        int i5 = ((SparseIntArray) this.g.f1596d).get(203400000, -1);
        return i5 == -1 || i5 == 0;
    }

    public final boolean c(C0785b c0785b, int i5) throws Resources.NotFoundException {
        C0788e c0788e = this.f9121f;
        c0788e.getClass();
        Context context = this.f9120e;
        if (AbstractC0930a.l(context)) {
            return false;
        }
        int i6 = c0785b.f8728k;
        PendingIntent pendingIntentB = c0785b.f8729l;
        if (!((i6 == 0 || pendingIntentB == null) ? false : true)) {
            pendingIntentB = c0788e.b(i6, context, null);
        }
        if (pendingIntentB == null) {
            return false;
        }
        int i7 = GoogleApiActivity.f4633d;
        Intent intent = new Intent(context, (Class<?>) GoogleApiActivity.class);
        intent.putExtra("pending_intent", pendingIntentB);
        intent.putExtra("failing_client_id", i5);
        intent.putExtra("notify_manager", true);
        c0788e.g(context, i6, PendingIntent.getActivity(context, 0, intent, A1.e.f13a | 134217728));
        return true;
    }

    public final t e(o1.h hVar) {
        ConcurrentHashMap concurrentHashMap = this.f9123j;
        C0826b c0826b = hVar.f8905e;
        t tVar = (t) concurrentHashMap.get(c0826b);
        if (tVar == null) {
            tVar = new t(this, hVar);
            concurrentHashMap.put(c0826b, tVar);
        }
        if (tVar.f9138d.m()) {
            this.f9126m.add(c0826b);
        }
        tVar.m();
        return tVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(N1.k r9, int r10, o1.h r11) {
        /*
            r8 = this;
            if (r10 == 0) goto L77
            p1.b r3 = r11.f8905e
            boolean r11 = r8.b()
            if (r11 != 0) goto Lb
            goto L47
        Lb:
            q1.n r11 = q1.C0863n.e()
            java.lang.Object r11 = r11.f9401a
            q1.o r11 = (q1.C0864o) r11
            r0 = 1
            if (r11 == 0) goto L49
            boolean r1 = r11.f9403k
            if (r1 == 0) goto L47
            java.util.concurrent.ConcurrentHashMap r1 = r8.f9123j
            java.lang.Object r1 = r1.get(r3)
            p1.t r1 = (p1.t) r1
            if (r1 == 0) goto L44
            o1.c r2 = r1.f9138d
            boolean r4 = r2 instanceof q1.AbstractC0854e
            if (r4 == 0) goto L47
            q1.e r2 = (q1.AbstractC0854e) r2
            q1.L r4 = r2.f9364v
            if (r4 == 0) goto L44
            boolean r4 = r2.g()
            if (r4 != 0) goto L44
            q1.g r11 = p1.y.a(r1, r2, r10)
            if (r11 == 0) goto L47
            int r2 = r1.n
            int r2 = r2 + r0
            r1.n = r2
            boolean r0 = r11.f9370l
            goto L49
        L44:
            boolean r0 = r11.f9404l
            goto L49
        L47:
            r10 = 0
            goto L65
        L49:
            p1.y r11 = new p1.y
            r1 = 0
            if (r0 == 0) goto L54
            long r4 = java.lang.System.currentTimeMillis()
            goto L55
        L54:
            r4 = r1
        L55:
            if (r0 == 0) goto L5d
            long r0 = android.os.SystemClock.elapsedRealtime()
            r6 = r0
            goto L5e
        L5d:
            r6 = r1
        L5e:
            r0 = r11
            r1 = r8
            r2 = r10
            r0.<init>(r1, r2, r3, r4, r6)
            r10 = r11
        L65:
            if (r10 == 0) goto L77
            N1.r r9 = r9.f1789a
            A1.f r11 = r8.n
            r11.getClass()
            Q0.e r0 = new Q0.e
            r1 = 1
            r0.<init>(r11, r1)
            r9.h(r0, r10)
        L77:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p1.C0832h.f(N1.k, int, o1.h):void");
    }

    public final void h(C0785b c0785b, int i5) {
        if (c(c0785b, i5)) {
            return;
        }
        A1.f fVar = this.n;
        fVar.sendMessage(fVar.obtainMessage(5, i5, 0, c0785b));
    }

    /* JADX WARN: Removed duplicated region for block: B:142:0x0318  */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean handleMessage(android.os.Message r19) {
        /*
            Method dump skipped, instructions count: 1094
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p1.C0832h.handleMessage(android.os.Message):boolean");
    }
}
