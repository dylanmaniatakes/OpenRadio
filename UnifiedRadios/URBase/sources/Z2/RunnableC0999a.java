package z2;

import C0.A;
import C0.i;
import C0.j;
import C0.t;
import D0.h;
import D0.x;
import H0.k;
import J1.A1;
import J1.B1;
import J1.C0058c1;
import J1.C0072h0;
import J1.C0082k1;
import J1.C0095p;
import J1.C0113v0;
import J1.C0120x1;
import J1.H;
import J1.J;
import J1.K0;
import J1.K1;
import J1.O;
import J1.RunnableC0094o1;
import J1.RunnableC0108t1;
import J1.RunnableC0116w0;
import J1.ServiceConnectionC0075i0;
import J1.ServiceConnectionC0117w1;
import J1.V1;
import J1.Z;
import K0.c;
import L0.e;
import L0.o;
import L0.s;
import M0.m;
import M0.q;
import M0.r;
import N1.d;
import N1.l;
import N1.n;
import N3.I;
import android.app.job.JobParameters;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Build;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.internal.measurement.AbstractC0409x1;
import com.google.android.gms.internal.measurement.B;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import n1.C0785b;
import q1.E;

/* renamed from: z2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0999a implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f10549j;

    /* renamed from: k, reason: collision with root package name */
    public Object f10550k;

    /* renamed from: l, reason: collision with root package name */
    public final Object f10551l;

    public /* synthetic */ RunnableC0999a(int i5, Object obj, Object obj2, boolean z4) {
        this.f10549j = i5;
        this.f10551l = obj;
        this.f10550k = obj2;
    }

    private final void a() {
        C0113v0 c0113v0 = (C0113v0) ((C0058c1) this.f10550k).f84c;
        O oN = c0113v0.n();
        String str = oN.f921t;
        String str2 = (String) this.f10551l;
        boolean z4 = false;
        if (str != null && !str.equals(str2)) {
            z4 = true;
        }
        oN.f921t = str2;
        if (z4) {
            c0113v0.n().s();
        }
    }

    private final void b() {
        C0058c1 c0058c1 = (C0058c1) this.f10550k;
        c0058c1.j();
        if (Build.VERSION.SDK_INT < 30) {
            return;
        }
        C0072h0 c0072h0 = ((C0113v0) c0058c1.f84c).f1416j;
        C0113v0.i(c0072h0);
        SparseArray sparseArrayQ = c0072h0.q();
        for (K1 k1 : (List) this.f10551l) {
            int i5 = k1.f883l;
            if (!sparseArrayQ.contains(i5) || ((Long) sparseArrayQ.get(i5)).longValue() < k1.f882k) {
                c0058c1.H().add(k1);
            }
        }
        c0058c1.x();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0071 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void c() {
        /*
            r8 = this;
            java.lang.Object r0 = r8.f10551l
            J1.c1 r0 = (J1.C0058c1) r0
            java.lang.Object r1 = r0.f84c
            J1.v0 r1 = (J1.C0113v0) r1
            J1.G1 r1 = r1.f1419m
            J1.C0113v0.j(r1)
            java.lang.Object r1 = r1.f84c
            J1.v0 r1 = (J1.C0113v0) r1
            J1.h0 r2 = r1.f1416j
            J1.C0113v0.i(r2)
            J1.K0 r2 = r2.r()
            J1.J0 r3 = J1.J0.ANALYTICS_STORAGE
            boolean r2 = r2.k(r3)
            r3 = 0
            if (r2 != 0) goto L31
            J1.Z r1 = r1.f1417k
            J1.C0113v0.k(r1)
            java.lang.String r2 = "Analytics storage consent denied; will not get session id"
            J1.X r1 = r1.f1082m
            r1.a(r2)
        L2f:
            r1 = r3
            goto L5a
        L31:
            J1.h0 r2 = r1.f1416j
            J1.C0113v0.i(r2)
            u1.a r1 = r1.f1421p
            r1.getClass()
            long r4 = java.lang.System.currentTimeMillis()
            boolean r1 = r2.t(r4)
            if (r1 != 0) goto L2f
            J1.g0 r1 = r2.f1246t
            long r4 = r1.a()
            r6 = 0
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 != 0) goto L52
            goto L2f
        L52:
            long r1 = r1.a()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
        L5a:
            java.lang.Object r0 = r0.f84c
            J1.v0 r0 = (J1.C0113v0) r0
            java.lang.Object r2 = r8.f10550k
            com.google.android.gms.internal.measurement.M r2 = (com.google.android.gms.internal.measurement.M) r2
            if (r1 == 0) goto L71
            J1.a2 r0 = r0.n
            J1.C0113v0.i(r0)
            long r3 = r1.longValue()
            r0.K(r2, r3)
            return
        L71:
            r2.q(r3)     // Catch: android.os.RemoteException -> L75
            return
        L75:
            r1 = move-exception
            J1.Z r0 = r0.f1417k
            J1.C0113v0.k(r0)
            java.lang.String r2 = "getSessionId failed with exception"
            J1.X r0 = r0.h
            r0.b(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: z2.RunnableC0999a.c():void");
    }

    private final void d() {
        ((C0058c1) this.f10551l).F((Boolean) this.f10550k, true);
    }

    private final void e() throws NumberFormatException {
        C0058c1 c0058c1 = (C0058c1) this.f10551l;
        C0113v0 c0113v0 = (C0113v0) c0058c1.f84c;
        C0072h0 c0072h0 = c0113v0.f1416j;
        C0113v0.i(c0072h0);
        c0072h0.j();
        c0072h0.j();
        C0095p c0095pB = C0095p.b(c0072h0.p().getString("dma_consent_settings", null));
        C0095p c0095p = (C0095p) this.f10550k;
        boolean zL = K0.l(c0095p.f1337a, c0095pB.f1337a);
        Z z4 = c0113v0.f1417k;
        if (!zL) {
            C0113v0.k(z4);
            z4.n.b(Integer.valueOf(c0095p.f1337a), "Lower precedence consent source ignored, proposed source");
            return;
        }
        SharedPreferences.Editor editorEdit = c0072h0.p().edit();
        editorEdit.putString("dma_consent_settings", c0095p.f1338b);
        editorEdit.apply();
        C0113v0.k(z4);
        z4.f1084p.b(c0095p, "Setting DMA consent(FE)");
        C0113v0 c0113v02 = (C0113v0) c0058c1.f84c;
        if (c0113v02.r().v()) {
            C0120x1 c0120x1R = c0113v02.r();
            c0120x1R.j();
            c0120x1R.k();
            c0120x1R.A(new RunnableC0094o1(c0120x1R, 1));
            return;
        }
        C0120x1 c0120x1R2 = c0113v02.r();
        c0120x1R2.j();
        c0120x1R2.k();
        if (c0120x1R2.u()) {
            c0120x1R2.A(new RunnableC0108t1(c0120x1R2, c0120x1R2.x(false), 4));
        }
    }

    private final void f() {
        C0058c1 c0058c1 = ((AppMeasurementDynamiteService) this.f10551l).f5155c.f1423r;
        C0113v0.j(c0058c1);
        c0058c1.j();
        c0058c1.k();
        e eVar = c0058c1.f1164f;
        e eVar2 = (e) this.f10550k;
        if (eVar2 != eVar) {
            E.k("EventInterceptor already set.", eVar == null);
        }
        c0058c1.f1164f = eVar2;
    }

    private final void g() {
        C0120x1 c0120x1 = (C0120x1) this.f10551l;
        J j5 = c0120x1.f1451f;
        C0113v0 c0113v0 = (C0113v0) c0120x1.f84c;
        if (j5 == null) {
            Z z4 = c0113v0.f1417k;
            C0113v0.k(z4);
            z4.h.a("Failed to send current screen to service");
            return;
        }
        try {
            C0082k1 c0082k1 = (C0082k1) this.f10550k;
            if (c0082k1 == null) {
                j5.F(0L, null, null, c0113v0.f1411c.getPackageName());
            } else {
                j5.F(c0082k1.f1284c, c0082k1.f1282a, c0082k1.f1283b, c0113v0.f1411c.getPackageName());
            }
            c0120x1.z();
        } catch (RemoteException e5) {
            Z z5 = ((C0113v0) c0120x1.f84c).f1417k;
            C0113v0.k(z5);
            z5.h.b(e5, "Failed to send current screen to the service");
        }
    }

    private final void h() {
        C0120x1.C(((ServiceConnectionC0117w1) this.f10551l).f1443c, (ComponentName) this.f10550k);
    }

    private final void i() {
        C0120x1 c0120x1 = ((ServiceConnectionC0117w1) this.f10551l).f1443c;
        c0120x1.f1451f = null;
        if (!((C0113v0) c0120x1.f84c).f1415i.w(null, H.f835o1) || ((C0785b) this.f10550k).f8728k != 7777) {
            c0120x1.y();
            return;
        }
        if (c0120x1.f1452i == null) {
            c0120x1.f1452i = Executors.newScheduledThreadPool(1);
        }
        c0120x1.f1452i.schedule(new A(3, this), ((Long) H.f792Y.a(null)).longValue(), TimeUnit.MILLISECONDS);
    }

    private final void j() {
        Log.v("FA", "[sgtm] AppMeasurementJobService processed last Scion upload request.");
        ((A1) ((B1) this.f10550k).f707a).c((JobParameters) this.f10551l);
    }

    private final void k() {
        V1 v12 = (V1) this.f10550k;
        v12.j();
        v12.e().j();
        if (v12.f1029r == null) {
            v12.f1029r = new ArrayList();
        }
        v12.f1029r.add((Runnable) this.f10551l);
        v12.U();
    }

    private final void l() {
        o oVar;
        h hVar = ((c) this.f10551l).f1493c.f305f;
        String str = (String) this.f10550k;
        synchronized (hVar.f269k) {
            try {
                x xVarC = hVar.c(str);
                oVar = xVarC != null ? xVarC.f317l : null;
            } finally {
            }
        }
        if (oVar == null || !oVar.b()) {
            return;
        }
        synchronized (((c) this.f10551l).f1495e) {
            ((c) this.f10551l).h.put(AbstractC0409x1.d(oVar), oVar);
            c cVar = (c) this.f10551l;
            ((c) this.f10551l).f1497i.put(AbstractC0409x1.d(oVar), k.a(cVar.f1498j, oVar, (I) cVar.f1494d.f1548d, cVar));
        }
    }

    private final void m() {
        D.b bVar = (D.b) ((Z2.c) this.f10550k).f3147d;
        if (bVar != null) {
            bVar.h((Typeface) this.f10551l);
        }
    }

    private final void n() {
        ((N.a) this.f10550k).a(this.f10551l);
    }

    private final void o() {
        try {
            ((Runnable) this.f10551l).run();
            synchronized (((m) this.f10550k).f1684k) {
                ((m) this.f10550k).a();
            }
        } catch (Throwable th) {
            synchronized (((m) this.f10550k).f1684k) {
                ((m) this.f10550k).a();
                throw th;
            }
        }
    }

    private final void p() {
        if (((q) this.f10551l).f1695j.f1783j instanceof N0.a) {
            return;
        }
        try {
            i iVar = (i) ((N0.k) this.f10550k).get();
            if (iVar == null) {
                throw new IllegalStateException("Worker was marked important (" + ((q) this.f10551l).f1697l.f1563c + ") but did not provide ForegroundInfo");
            }
            t.d().a(q.f1694p, "Updating notification for " + ((q) this.f10551l).f1697l.f1563c);
            q qVar = (q) this.f10551l;
            N0.k kVar = qVar.f1695j;
            j jVar = qVar.n;
            Context context = qVar.f1696k;
            UUID uuid = qVar.f1698m.f169d.f4479a;
            r rVar = (r) jVar;
            rVar.getClass();
            N0.k kVar2 = new N0.k();
            rVar.f1700a.c(new RunnableC0116w0(rVar, kVar2, uuid, iVar, context, 3));
            kVar.l(kVar2);
        } catch (Throwable th) {
            ((q) this.f10551l).f1695j.k(th);
        }
    }

    private final void q() {
        if (((N1.r) ((N1.j) this.f10550k)).f1807d) {
            ((n) this.f10551l).f1796f.n();
            return;
        }
        try {
            ((n) this.f10551l).f1796f.m(((n) this.f10551l).f1795e.c((N1.j) this.f10550k));
        } catch (N1.h e5) {
            if (e5.getCause() instanceof Exception) {
                ((n) this.f10551l).f1796f.l((Exception) e5.getCause());
            } else {
                ((n) this.f10551l).f1796f.l(e5);
            }
        } catch (Exception e6) {
            ((n) this.f10551l).f1796f.l(e6);
        }
    }

    private final void r() {
        n nVar = (n) this.f10551l;
        try {
            N1.j jVar = (N1.j) nVar.f1795e.c((N1.j) this.f10550k);
            if (jVar == null) {
                nVar.d(new NullPointerException("Continuation returned null"));
                return;
            }
            C2.c cVar = l.f1791b;
            jVar.b(cVar, nVar);
            jVar.a(cVar, nVar);
            N1.r rVar = (N1.r) jVar;
            rVar.f1805b.g(new N1.o(cVar, (d) nVar));
            rVar.p();
        } catch (N1.h e5) {
            if (e5.getCause() instanceof Exception) {
                nVar.f1796f.l((Exception) e5.getCause());
            } else {
                nVar.f1796f.l(e5);
            }
        } catch (Exception e6) {
            nVar.f1796f.l(e6);
        }
    }

    private final void s() {
        synchronized (((N1.o) this.f10551l).f1799e) {
            try {
                N1.e eVar = (N1.e) ((N1.o) this.f10551l).f1800f;
                if (eVar != null) {
                    eVar.k((N1.j) this.f10550k);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:224|(10:226|(1:231)|258|(1:260)|261|402|262|263|267|(5:273|(1:275)(1:276)|(1:280)|(1:282)|283))(1:232)|233|(2:235|(2:241|242)(3:238|(1:240)(0)|242))(1:243)|(5:245|(1:247)(1:248)|249|(1:251)|252)(1:253)|254|(1:256)(1:257)|258|(0)|261|402|262|263|267|(7:269|271|273|(0)(0)|(2:278|280)|(0)|283)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:264:0x06ea, code lost:
    
        r2 = r6.f1251y;
     */
    /* JADX WARN: Code restructure failed: missing block: B:265:0x06f4, code lost:
    
        if (android.text.TextUtils.isEmpty(r2.g()) == false) goto L266;
     */
    /* JADX WARN: Code restructure failed: missing block: B:266:0x06f6, code lost:
    
        J1.C0113v0.k(r4);
        r4.f1080k.a("Remote config removed with active feature rollouts");
        r7 = null;
        r2.h(null);
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0392  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x03d8  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0408  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0460  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0466  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0484  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x04b5  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x04cf  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x04e8  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0556  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x05c9  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x06c9  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0728  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x0730  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0732  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x0747  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x077c  */
    /* JADX WARN: Removed duplicated region for block: B:408:0x0417 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x022b  */
    /* JADX WARN: Type inference failed for: r2v90, types: [J1.T0] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() throws org.json.JSONException, java.lang.NumberFormatException, java.lang.ClassNotFoundException {
        /*
            Method dump skipped, instructions count: 2678
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z2.RunnableC0999a.run():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x004c, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0052, code lost:
    
        r1 = r1 | java.lang.Thread.interrupted();
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0054, code lost:
    
        ((java.lang.Runnable) r10.f10550k).run();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0060, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0062, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0063, code lost:
    
        G2.j.f636o.log(java.util.logging.Level.SEVERE, "Exception while executing runnable " + ((java.lang.Runnable) r10.f10550k), (java.lang.Throwable) r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0080, code lost:
    
        r10.f10550k = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0082, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void t() {
        /*
            r10 = this;
            r0 = 0
            r1 = r0
        L2:
            java.lang.Object r2 = r10.f10551l     // Catch: java.lang.Throwable -> L5e
            G2.j r2 = (G2.j) r2     // Catch: java.lang.Throwable -> L5e
            java.util.ArrayDeque r2 = r2.f638k     // Catch: java.lang.Throwable -> L5e
            monitor-enter(r2)     // Catch: java.lang.Throwable -> L5e
            r3 = 1
            if (r0 != 0) goto L2c
            java.lang.Object r0 = r10.f10551l     // Catch: java.lang.Throwable -> L20
            G2.j r0 = (G2.j) r0     // Catch: java.lang.Throwable -> L20
            int r4 = r0.f639l     // Catch: java.lang.Throwable -> L20
            r5 = 4
            if (r4 != r5) goto L22
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
            if (r1 == 0) goto L1f
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L1f:
            return
        L20:
            r0 = move-exception
            goto L83
        L22:
            long r6 = r0.f640m     // Catch: java.lang.Throwable -> L20
            r8 = 1
            long r6 = r6 + r8
            r0.f640m = r6     // Catch: java.lang.Throwable -> L20
            r0.f639l = r5     // Catch: java.lang.Throwable -> L20
            r0 = r3
        L2c:
            java.lang.Object r4 = r10.f10551l     // Catch: java.lang.Throwable -> L20
            G2.j r4 = (G2.j) r4     // Catch: java.lang.Throwable -> L20
            java.util.ArrayDeque r4 = r4.f638k     // Catch: java.lang.Throwable -> L20
            java.lang.Object r4 = r4.poll()     // Catch: java.lang.Throwable -> L20
            java.lang.Runnable r4 = (java.lang.Runnable) r4     // Catch: java.lang.Throwable -> L20
            r10.f10550k = r4     // Catch: java.lang.Throwable -> L20
            if (r4 != 0) goto L4d
            java.lang.Object r0 = r10.f10551l     // Catch: java.lang.Throwable -> L20
            G2.j r0 = (G2.j) r0     // Catch: java.lang.Throwable -> L20
            r0.f639l = r3     // Catch: java.lang.Throwable -> L20
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
            if (r1 == 0) goto L4c
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L4c:
            return
        L4d:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
            boolean r2 = java.lang.Thread.interrupted()     // Catch: java.lang.Throwable -> L5e
            r1 = r1 | r2
            r2 = 0
            java.lang.Object r3 = r10.f10550k     // Catch: java.lang.Throwable -> L60 java.lang.RuntimeException -> L62
            java.lang.Runnable r3 = (java.lang.Runnable) r3     // Catch: java.lang.Throwable -> L60 java.lang.RuntimeException -> L62
            r3.run()     // Catch: java.lang.Throwable -> L60 java.lang.RuntimeException -> L62
        L5b:
            r10.f10550k = r2     // Catch: java.lang.Throwable -> L5e
            goto L2
        L5e:
            r0 = move-exception
            goto L85
        L60:
            r0 = move-exception
            goto L80
        L62:
            r3 = move-exception
            java.util.logging.Logger r4 = G2.j.f636o     // Catch: java.lang.Throwable -> L60
            java.util.logging.Level r5 = java.util.logging.Level.SEVERE     // Catch: java.lang.Throwable -> L60
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L60
            r6.<init>()     // Catch: java.lang.Throwable -> L60
            java.lang.String r7 = "Exception while executing runnable "
            r6.append(r7)     // Catch: java.lang.Throwable -> L60
            java.lang.Object r7 = r10.f10550k     // Catch: java.lang.Throwable -> L60
            java.lang.Runnable r7 = (java.lang.Runnable) r7     // Catch: java.lang.Throwable -> L60
            r6.append(r7)     // Catch: java.lang.Throwable -> L60
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L60
            r4.log(r5, r6, r3)     // Catch: java.lang.Throwable -> L60
            goto L5b
        L80:
            r10.f10550k = r2     // Catch: java.lang.Throwable -> L5e
            throw r0     // Catch: java.lang.Throwable -> L5e
        L83:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
            throw r0     // Catch: java.lang.Throwable -> L5e
        L85:
            if (r1 == 0) goto L8e
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            r1.interrupt()
        L8e:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: z2.RunnableC0999a.t():void");
    }

    public String toString() {
        switch (this.f10549j) {
            case 0:
                L0.m mVar = new L0.m(RunnableC0999a.class.getSimpleName());
                L0.c cVar = new L0.c(25);
                ((L0.c) mVar.f1558f).f1537e = cVar;
                mVar.f1558f = cVar;
                cVar.f1536d = (s) this.f10551l;
                return mVar.toString();
            case 5:
                Runnable runnable = (Runnable) this.f10550k;
                if (runnable != null) {
                    return "SequentialExecutorWorker{running=" + runnable + "}";
                }
                StringBuilder sb = new StringBuilder("SequentialExecutorWorker{state=");
                int i5 = ((G2.j) this.f10551l).f639l;
                sb.append(i5 != 1 ? i5 != 2 ? i5 != 3 ? i5 != 4 ? "null" : "RUNNING" : "QUEUED" : "QUEUING" : "IDLE");
                sb.append("}");
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public RunnableC0999a(ServiceConnectionC0075i0 serviceConnectionC0075i0, B b5, ServiceConnection serviceConnection) {
        this.f10549j = 7;
        this.f10550k = b5;
        this.f10551l = serviceConnectionC0075i0;
    }

    public /* synthetic */ RunnableC0999a(Object obj, int i5, Object obj2) {
        this.f10549j = i5;
        this.f10550k = obj;
        this.f10551l = obj2;
    }

    public RunnableC0999a(G2.j jVar) {
        this.f10549j = 5;
        this.f10551l = jVar;
    }
}
