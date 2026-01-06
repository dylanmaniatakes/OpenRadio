package H1;

import J1.A;
import J1.C0058c1;
import J1.C0082k1;
import J1.C0091n1;
import J1.C0104s0;
import J1.C0113v0;
import J1.RunnableC0122y0;
import J1.Y1;
import J1.Z;
import J1.Z0;
import J1.a2;
import O2.e;
import android.os.Bundle;
import android.os.SystemClock;
import com.google.android.gms.location.DeviceOrientationRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import q1.E;

/* loaded from: classes.dex */
public final class a extends c {

    /* renamed from: a, reason: collision with root package name */
    public final C0113v0 f661a;

    /* renamed from: b, reason: collision with root package name */
    public final C0058c1 f662b;

    public a(C0113v0 c0113v0) {
        E.i(c0113v0);
        this.f661a = c0113v0;
        C0058c1 c0058c1 = c0113v0.f1423r;
        C0113v0.j(c0058c1);
        this.f662b = c0058c1;
    }

    @Override // J1.InterfaceC0061d1
    public final String a() {
        return (String) this.f662b.f1165i.get();
    }

    @Override // J1.InterfaceC0061d1
    public final String b() {
        C0091n1 c0091n1 = ((C0113v0) this.f662b.f84c).f1422q;
        C0113v0.j(c0091n1);
        C0082k1 c0082k1 = c0091n1.f1315e;
        if (c0082k1 != null) {
            return c0082k1.f1283b;
        }
        return null;
    }

    @Override // J1.InterfaceC0061d1
    public final void c(String str) {
        C0113v0 c0113v0 = this.f661a;
        A a2 = c0113v0.f1424s;
        C0113v0.h(a2);
        c0113v0.f1421p.getClass();
        a2.k(SystemClock.elapsedRealtime(), str);
    }

    @Override // J1.InterfaceC0061d1
    public final void d(String str, String str2, Bundle bundle) {
        C0058c1 c0058c1 = this.f661a.f1423r;
        C0113v0.j(c0058c1);
        c0058c1.p(str, str2, bundle);
    }

    @Override // J1.InterfaceC0061d1
    public final List e(String str, String str2) {
        C0058c1 c0058c1 = this.f662b;
        C0113v0 c0113v0 = (C0113v0) c0058c1.f84c;
        C0104s0 c0104s0 = c0113v0.f1418l;
        C0113v0.k(c0104s0);
        boolean zV = c0104s0.v();
        Z z4 = c0113v0.f1417k;
        if (zV) {
            C0113v0.k(z4);
            z4.h.a("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList(0);
        }
        if (e.e()) {
            C0113v0.k(z4);
            z4.h.a("Cannot get conditional user properties from main thread");
            return new ArrayList(0);
        }
        AtomicReference atomicReference = new AtomicReference();
        C0104s0 c0104s02 = c0113v0.f1418l;
        C0113v0.k(c0104s02);
        c0104s02.o(atomicReference, DeviceOrientationRequest.OUTPUT_PERIOD_FAST, "get conditional user properties", new RunnableC0122y0(c0058c1, atomicReference, str, str2, 3));
        List list = (List) atomicReference.get();
        if (list != null) {
            return a2.w(list);
        }
        C0113v0.k(z4);
        z4.h.b(null, "Timed out waiting for get conditional user properties");
        return new ArrayList();
    }

    @Override // J1.InterfaceC0061d1
    public final Map f(String str, String str2, boolean z4) {
        C0058c1 c0058c1 = this.f662b;
        C0113v0 c0113v0 = (C0113v0) c0058c1.f84c;
        C0104s0 c0104s0 = c0113v0.f1418l;
        C0113v0.k(c0104s0);
        boolean zV = c0104s0.v();
        Z z5 = c0113v0.f1417k;
        if (zV) {
            C0113v0.k(z5);
            z5.h.a("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        }
        if (e.e()) {
            C0113v0.k(z5);
            z5.h.a("Cannot get user properties from main thread");
            return Collections.emptyMap();
        }
        AtomicReference atomicReference = new AtomicReference();
        C0104s0 c0104s02 = c0113v0.f1418l;
        C0113v0.k(c0104s02);
        c0104s02.o(atomicReference, DeviceOrientationRequest.OUTPUT_PERIOD_FAST, "get user properties", new Z0(c0058c1, atomicReference, str, str2, z4, 1));
        List<Y1> list = (List) atomicReference.get();
        if (list == null) {
            C0113v0.k(z5);
            z5.h.b(Boolean.valueOf(z4), "Timed out waiting for handle get user properties, includeInternal");
            return Collections.emptyMap();
        }
        q.b bVar = new q.b(list.size());
        for (Y1 y12 : list) {
            Object objA = y12.a();
            if (objA != null) {
                bVar.put(y12.f1071k, objA);
            }
        }
        return bVar;
    }

    @Override // J1.InterfaceC0061d1
    public final void g(String str) {
        C0113v0 c0113v0 = this.f661a;
        A a2 = c0113v0.f1424s;
        C0113v0.h(a2);
        c0113v0.f1421p.getClass();
        a2.l(SystemClock.elapsedRealtime(), str);
    }

    @Override // J1.InterfaceC0061d1
    public final int h(String str) {
        C0058c1 c0058c1 = this.f662b;
        c0058c1.getClass();
        E.f(str);
        ((C0113v0) c0058c1.f84c).getClass();
        return 25;
    }

    @Override // J1.InterfaceC0061d1
    public final void i(Bundle bundle) {
        C0058c1 c0058c1 = this.f662b;
        ((C0113v0) c0058c1.f84c).f1421p.getClass();
        c0058c1.y(bundle, System.currentTimeMillis());
    }

    @Override // J1.InterfaceC0061d1
    public final void j(String str, String str2, Bundle bundle) {
        C0058c1 c0058c1 = this.f662b;
        ((C0113v0) c0058c1.f84c).f1421p.getClass();
        c0058c1.t(str, str2, bundle, true, true, System.currentTimeMillis());
    }

    @Override // J1.InterfaceC0061d1
    public final String k() {
        return (String) this.f662b.f1165i.get();
    }

    @Override // J1.InterfaceC0061d1
    public final long zzb() {
        a2 a2Var = this.f661a.n;
        C0113v0.i(a2Var);
        return a2Var.u0();
    }

    @Override // J1.InterfaceC0061d1
    public final String zzj() {
        C0091n1 c0091n1 = ((C0113v0) this.f662b.f84c).f1422q;
        C0113v0.j(c0091n1);
        C0082k1 c0082k1 = c0091n1.f1315e;
        if (c0082k1 != null) {
            return c0082k1.f1282a;
        }
        return null;
    }
}
