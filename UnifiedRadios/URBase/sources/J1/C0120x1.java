package J1;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Looper;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;
import n1.C0789f;
import t1.C0902a;
import u1.C0906a;

/* renamed from: J1.x1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0120x1 extends E {

    /* renamed from: e, reason: collision with root package name */
    public final ServiceConnectionC0117w1 f1450e;

    /* renamed from: f, reason: collision with root package name */
    public J f1451f;
    public volatile Boolean g;
    public final C0111u1 h;

    /* renamed from: i, reason: collision with root package name */
    public ScheduledExecutorService f1452i;

    /* renamed from: j, reason: collision with root package name */
    public final U f1453j;

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f1454k;

    /* renamed from: l, reason: collision with root package name */
    public final C0111u1 f1455l;

    public C0120x1(C0113v0 c0113v0) {
        super(c0113v0);
        this.f1454k = new ArrayList();
        this.f1453j = new U(c0113v0.f1421p);
        this.f1450e = new ServiceConnectionC0117w1(this);
        this.h = new C0111u1(this, c0113v0, 0);
        this.f1455l = new C0111u1(this, c0113v0, 1);
    }

    public static void C(C0120x1 c0120x1, ComponentName componentName) {
        c0120x1.j();
        if (c0120x1.f1451f != null) {
            c0120x1.f1451f = null;
            Z z4 = ((C0113v0) c0120x1.f84c).f1417k;
            C0113v0.k(z4);
            z4.f1084p.b(componentName, "Disconnected from device MeasurementService");
            c0120x1.j();
            c0120x1.n();
        }
    }

    public final void A(Runnable runnable) {
        j();
        if (t()) {
            runnable.run();
            return;
        }
        ArrayList arrayList = this.f1454k;
        long size = arrayList.size();
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        c0113v0.getClass();
        if (size >= 1000) {
            Z z4 = c0113v0.f1417k;
            C0113v0.k(z4);
            z4.h.a("Discarding data. Max runnable queue size reached");
        } else {
            arrayList.add(runnable);
            this.f1455l.c(60000L);
            n();
        }
    }

    public final void B() {
        ((C0113v0) this.f84c).getClass();
    }

    @Override // J1.E
    public final boolean m() {
        return false;
    }

    public final void n() {
        j();
        k();
        if (t()) {
            return;
        }
        if (w()) {
            ServiceConnectionC0117w1 serviceConnectionC0117w1 = this.f1450e;
            C0120x1 c0120x1 = serviceConnectionC0117w1.f1443c;
            c0120x1.j();
            Context context = ((C0113v0) c0120x1.f84c).f1411c;
            synchronized (serviceConnectionC0117w1) {
                try {
                    if (serviceConnectionC0117w1.f1441a) {
                        Z z4 = ((C0113v0) serviceConnectionC0117w1.f1443c.f84c).f1417k;
                        C0113v0.k(z4);
                        z4.f1084p.a("Connection attempt already in progress");
                        return;
                    } else {
                        if (serviceConnectionC0117w1.f1442b != null && (serviceConnectionC0117w1.f1442b.g() || serviceConnectionC0117w1.f1442b.a())) {
                            Z z5 = ((C0113v0) serviceConnectionC0117w1.f1443c.f84c).f1417k;
                            C0113v0.k(z5);
                            z5.f1084p.a("Already awaiting connection attempt");
                            return;
                        }
                        serviceConnectionC0117w1.f1442b = new T(context, Looper.getMainLooper(), q1.P.a(context), C0789f.f8740b, 93, serviceConnectionC0117w1, serviceConnectionC0117w1, null);
                        Z z6 = ((C0113v0) serviceConnectionC0117w1.f1443c.f84c).f1417k;
                        C0113v0.k(z6);
                        z6.f1084p.a("Connecting to remote service");
                        serviceConnectionC0117w1.f1441a = true;
                        q1.E.i(serviceConnectionC0117w1.f1442b);
                        serviceConnectionC0117w1.f1442b.n();
                        return;
                    }
                } finally {
                }
            }
        }
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        if (c0113v0.f1415i.m()) {
            return;
        }
        List<ResolveInfo> listQueryIntentServices = c0113v0.f1411c.getPackageManager().queryIntentServices(new Intent().setClassName(c0113v0.f1411c, "com.google.android.gms.measurement.AppMeasurementService"), 65536);
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
            Z z7 = c0113v0.f1417k;
            C0113v0.k(z7);
            z7.h.a("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            return;
        }
        Intent intent = new Intent("com.google.android.gms.measurement.START");
        intent.setComponent(new ComponentName(c0113v0.f1411c, "com.google.android.gms.measurement.AppMeasurementService"));
        ServiceConnectionC0117w1 serviceConnectionC0117w12 = this.f1450e;
        C0120x1 c0120x12 = serviceConnectionC0117w12.f1443c;
        c0120x12.j();
        Context context2 = ((C0113v0) c0120x12.f84c).f1411c;
        C0902a c0902aB = C0902a.b();
        synchronized (serviceConnectionC0117w12) {
            try {
                if (serviceConnectionC0117w12.f1441a) {
                    Z z8 = ((C0113v0) serviceConnectionC0117w12.f1443c.f84c).f1417k;
                    C0113v0.k(z8);
                    z8.f1084p.a("Connection attempt already in progress");
                } else {
                    C0120x1 c0120x13 = serviceConnectionC0117w12.f1443c;
                    Z z9 = ((C0113v0) c0120x13.f84c).f1417k;
                    C0113v0.k(z9);
                    z9.f1084p.a("Using local app measurement service");
                    serviceConnectionC0117w12.f1441a = true;
                    c0902aB.a(context2, intent, c0120x13.f1450e, 129);
                }
            } finally {
            }
        }
    }

    public final void o() {
        j();
        k();
        ServiceConnectionC0117w1 serviceConnectionC0117w1 = this.f1450e;
        if (serviceConnectionC0117w1.f1442b != null && (serviceConnectionC0117w1.f1442b.a() || serviceConnectionC0117w1.f1442b.g())) {
            serviceConnectionC0117w1.f1442b.l();
        }
        serviceConnectionC0117w1.f1442b = null;
        try {
            C0902a.b().c(((C0113v0) this.f84c).f1411c, serviceConnectionC0117w1);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.f1451f = null;
    }

    public final void p(AtomicReference atomicReference) {
        j();
        k();
        A(new F0.e(this, atomicReference, x(false), 7, false));
    }

    /* JADX WARN: Removed duplicated region for block: B:176:0x02f3 A[Catch: all -> 0x01df, SQLiteException -> 0x02d7, SQLiteFullException -> 0x02da, SQLiteDatabaseLockedException -> 0x03c9, TryCatch #32 {all -> 0x01df, blocks: (B:258:0x046b, B:260:0x0471, B:261:0x0474, B:268:0x049b, B:276:0x04bd, B:72:0x01a9, B:76:0x01b2, B:78:0x01b7, B:80:0x01be, B:82:0x01c6, B:84:0x01cb, B:86:0x01d1, B:103:0x01fc, B:107:0x0212, B:109:0x0217, B:122:0x023d, B:123:0x0240, B:121:0x0239, B:130:0x024a, B:132:0x025e, B:139:0x0274, B:140:0x027d, B:141:0x0280, B:137:0x026e, B:144:0x0284, B:146:0x0298, B:153:0x02ae, B:154:0x02b8, B:155:0x02bb, B:151:0x02a8, B:158:0x02bf, B:162:0x02d3, B:176:0x02f3, B:178:0x02fd, B:179:0x0300, B:174:0x02ed, B:182:0x0305, B:183:0x0310, B:211:0x038b, B:213:0x03ab, B:214:0x03b5), top: B:383:0x046b }] */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0483  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x04a2  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x04a7 A[PHI: r2 r4 r5 r8 r23 r25 r26 r27 r34 r35
      0x04a7: PHI (r2v8 int) = (r2v4 int), (r2v5 int), (r2v9 int) binds: [B:264:0x0486, B:279:0x04cf, B:272:0x04a5] A[DONT_GENERATE, DONT_INLINE]
      0x04a7: PHI (r4v11 int) = (r4v7 int), (r4v8 int), (r4v12 int) binds: [B:264:0x0486, B:279:0x04cf, B:272:0x04a5] A[DONT_GENERATE, DONT_INLINE]
      0x04a7: PHI (r5v10 android.database.sqlite.SQLiteDatabase) = 
      (r5v7 android.database.sqlite.SQLiteDatabase)
      (r5v8 android.database.sqlite.SQLiteDatabase)
      (r5v11 android.database.sqlite.SQLiteDatabase)
     binds: [B:264:0x0486, B:279:0x04cf, B:272:0x04a5] A[DONT_GENERATE, DONT_INLINE]
      0x04a7: PHI (r8v5 int) = (r8v3 int), (r8v3 int), (r8v6 int) binds: [B:264:0x0486, B:279:0x04cf, B:272:0x04a5] A[DONT_GENERATE, DONT_INLINE]
      0x04a7: PHI (r23v6 java.lang.String) = (r23v3 java.lang.String), (r23v4 java.lang.String), (r23v7 java.lang.String) binds: [B:264:0x0486, B:279:0x04cf, B:272:0x04a5] A[DONT_GENERATE, DONT_INLINE]
      0x04a7: PHI (r25v6 java.lang.String) = (r25v3 java.lang.String), (r25v4 java.lang.String), (r25v7 java.lang.String) binds: [B:264:0x0486, B:279:0x04cf, B:272:0x04a5] A[DONT_GENERATE, DONT_INLINE]
      0x04a7: PHI (r26v6 java.lang.String) = (r26v3 java.lang.String), (r26v4 java.lang.String), (r26v7 java.lang.String) binds: [B:264:0x0486, B:279:0x04cf, B:272:0x04a5] A[DONT_GENERATE, DONT_INLINE]
      0x04a7: PHI (r27v8 java.util.ArrayList) = (r27v5 java.util.ArrayList), (r27v6 java.util.ArrayList), (r27v9 java.util.ArrayList) binds: [B:264:0x0486, B:279:0x04cf, B:272:0x04a5] A[DONT_GENERATE, DONT_INLINE]
      0x04a7: PHI (r34v8 J1.v0) = (r34v5 J1.v0), (r34v6 J1.v0), (r34v9 J1.v0) binds: [B:264:0x0486, B:279:0x04cf, B:272:0x04a5] A[DONT_GENERATE, DONT_INLINE]
      0x04a7: PHI (r35v8 J1.b2) = (r35v5 J1.b2), (r35v6 J1.b2), (r35v9 J1.b2) binds: [B:264:0x0486, B:279:0x04cf, B:272:0x04a5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:278:0x04cc  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x04e9  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x04ee  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x0513  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x0520  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x0527  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x053a  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x0551  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x05f5  */
    /* JADX WARN: Removed duplicated region for block: B:337:0x0683  */
    /* JADX WARN: Removed duplicated region for block: B:383:0x046b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:448:0x04d2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:449:0x04d2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:451:0x04d2 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void q(J1.J r64, r1.AbstractC0873a r65, J1.b2 r66) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1815
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.C0120x1.q(J1.J, r1.a, J1.b2):void");
    }

    public final void r(C0062e c0062e) throws Throwable {
        boolean zQ;
        j();
        k();
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        c0113v0.getClass();
        Q qO = c0113v0.o();
        C0113v0 c0113v02 = (C0113v0) qO.f84c;
        C0113v0.i(c0113v02.n);
        byte[] bArrK0 = a2.k0(c0062e);
        if (bArrK0.length > 131072) {
            Z z4 = c0113v02.f1417k;
            C0113v0.k(z4);
            z4.f1078i.a("Conditional user property too long for local database. Sending directly to service");
            zQ = false;
        } else {
            zQ = qO.q(2, bArrK0);
        }
        boolean z5 = zQ;
        A(new RunnableC0105s1(this, x(true), z5, new C0062e(c0062e), 2));
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void s(android.os.Bundle r8) {
        /*
            r7 = this;
            r7.j()
            r7.k()
            J1.u r4 = new J1.u
            r4.<init>(r8)
            r7.B()
            java.lang.Object r0 = r7.f84c
            J1.v0 r0 = (J1.C0113v0) r0
            J1.g r1 = r0.f1415i
            r2 = 0
            J1.G r3 = J1.H.f827l1
            boolean r1 = r1.w(r2, r3)
            r2 = 0
            if (r1 == 0) goto L59
            J1.Q r0 = r0.o()
            java.lang.Object r1 = r0.f84c
            J1.v0 r1 = (J1.C0113v0) r1
            J1.a2 r3 = r1.n
            J1.C0113v0.i(r3)
            byte[] r3 = J1.a2.k0(r4)
            J1.Z r1 = r1.f1417k
            if (r3 != 0) goto L3f
            J1.C0113v0.k(r1)
            java.lang.String r0 = "Null default event parameters; not writing to database"
            J1.X r1 = r1.f1078i
            r1.a(r0)
        L3d:
            r0 = r2
            goto L54
        L3f:
            int r5 = r3.length
            r6 = 131072(0x20000, float:1.83671E-40)
            if (r5 <= r6) goto L4f
            J1.C0113v0.k(r1)
            java.lang.String r0 = "Default event parameters too long for local database. Sending directly to service"
            J1.X r1 = r1.f1078i
            r1.a(r0)
            goto L3d
        L4f:
            r1 = 4
            boolean r0 = r0.q(r1, r3)
        L54:
            if (r0 == 0) goto L59
            r0 = 1
            r3 = r0
            goto L5a
        L59:
            r3 = r2
        L5a:
            J1.b2 r2 = r7.x(r2)
            J1.Z0 r6 = new J1.Z0
            r0 = r6
            r1 = r7
            r5 = r8
            r0.<init>(r1, r2, r3, r4, r5)
            r7.A(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.C0120x1.s(android.os.Bundle):void");
    }

    public final boolean t() {
        j();
        k();
        return this.f1451f != null;
    }

    public final boolean u() {
        j();
        k();
        if (!w()) {
            return true;
        }
        a2 a2Var = ((C0113v0) this.f84c).n;
        C0113v0.i(a2Var);
        return a2Var.r0() >= ((Integer) H.f763I0.a(null)).intValue();
    }

    public final boolean v() {
        j();
        k();
        if (!w()) {
            return true;
        }
        a2 a2Var = ((C0113v0) this.f84c).n;
        C0113v0.i(a2Var);
        return a2Var.r0() >= 241200;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0116  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean w() {
        /*
            Method dump skipped, instructions count: 314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.C0120x1.w():boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final J1.b2 x(boolean r11) {
        /*
            r10 = this;
            java.lang.Object r0 = r10.f84c
            J1.v0 r0 = (J1.C0113v0) r0
            r0.getClass()
            J1.O r1 = r0.n()
            r2 = 0
            if (r11 == 0) goto Lc4
            J1.Z r11 = r0.f1417k
            J1.C0113v0.k(r11)
            java.lang.Object r11 = r11.f84c
            J1.v0 r11 = (J1.C0113v0) r11
            J1.h0 r0 = r11.f1416j
            J1.C0113v0.i(r0)
            E0.d r0 = r0.h
            if (r0 != 0) goto L22
            goto Lc4
        L22:
            J1.h0 r11 = r11.f1416j
            J1.C0113v0.i(r11)
            E0.d r11 = r11.h
            java.lang.Object r0 = r11.f460e
            J1.h0 r0 = (J1.C0072h0) r0
            r0.j()
            r0.j()
            java.lang.Object r3 = r11.f460e
            J1.h0 r3 = (J1.C0072h0) r3
            android.content.SharedPreferences r3 = r3.p()
            java.lang.Object r4 = r11.f457b
            java.lang.String r4 = (java.lang.String) r4
            r5 = 0
            long r3 = r3.getLong(r4, r5)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L4e
            r11.d()
            r3 = r5
            goto L60
        L4e:
            java.lang.Object r7 = r0.f84c
            J1.v0 r7 = (J1.C0113v0) r7
            u1.a r7 = r7.f1421p
            r7.getClass()
            long r7 = java.lang.System.currentTimeMillis()
            long r3 = r3 - r7
            long r3 = java.lang.Math.abs(r3)
        L60:
            long r7 = r11.f456a
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r9 >= 0) goto L68
        L66:
            r11 = r2
            goto L9f
        L68:
            long r7 = r7 + r7
            int r3 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r3 <= 0) goto L71
            r11.d()
            goto L66
        L71:
            java.lang.Object r3 = r11.f459d
            java.lang.String r3 = (java.lang.String) r3
            android.content.SharedPreferences r4 = r0.p()
            java.lang.String r3 = r4.getString(r3, r2)
            java.lang.Object r4 = r11.f458c
            java.lang.String r4 = (java.lang.String) r4
            android.content.SharedPreferences r0 = r0.p()
            long r7 = r0.getLong(r4, r5)
            r11.d()
            if (r3 == 0) goto L9d
            int r11 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r11 > 0) goto L93
            goto L9d
        L93:
            android.util.Pair r11 = new android.util.Pair
            java.lang.Long r0 = java.lang.Long.valueOf(r7)
            r11.<init>(r3, r0)
            goto L9f
        L9d:
            android.util.Pair r11 = J1.C0072h0.f1231C
        L9f:
            if (r11 == 0) goto Lc4
            android.util.Pair r0 = J1.C0072h0.f1231C
            if (r11 != r0) goto La6
            goto Lc4
        La6:
            java.lang.Object r0 = r11.second
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.Object r11 = r11.first
            java.lang.String r11 = (java.lang.String) r11
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r0 = ":"
            r2.append(r0)
            r2.append(r11)
            java.lang.String r2 = r2.toString()
        Lc4:
            J1.b2 r11 = r1.o(r2)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.C0120x1.x(boolean):J1.b2");
    }

    public final void y() {
        j();
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        Z z4 = c0113v0.f1417k;
        C0113v0.k(z4);
        ArrayList arrayList = this.f1454k;
        z4.f1084p.b(Integer.valueOf(arrayList.size()), "Processing queued up service tasks");
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            try {
                ((Runnable) it.next()).run();
            } catch (RuntimeException e5) {
                Z z5 = c0113v0.f1417k;
                C0113v0.k(z5);
                z5.h.b(e5, "Task exception while flushing queue");
            }
        }
        arrayList.clear();
        this.f1455l.a();
    }

    public final void z() {
        j();
        U u4 = this.f1453j;
        ((C0906a) u4.f955e).getClass();
        u4.f954d = SystemClock.elapsedRealtime();
        ((C0113v0) this.f84c).getClass();
        this.h.c(((Long) H.f790X.a(null)).longValue());
    }
}
