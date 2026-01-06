package J1;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: J1.p1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0097p1 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f1344j = 0;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ String f1345k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ String f1346l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ b2 f1347m;
    public final /* synthetic */ boolean n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ C0120x1 f1348o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Object f1349p;

    public RunnableC0097p1(C0120x1 c0120x1, String str, String str2, b2 b2Var, boolean z4, com.google.android.gms.internal.measurement.M m5) {
        this.f1345k = str;
        this.f1346l = str2;
        this.f1347m = b2Var;
        this.n = z4;
        this.f1349p = m5;
        this.f1348o = c0120x1;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        Bundle bundle;
        RemoteException e5;
        a2 a2Var;
        J j5;
        String str;
        C0113v0 c0113v0;
        AtomicReference atomicReference;
        C0120x1 c0120x1;
        J j6;
        switch (this.f1344j) {
            case 0:
                String str2 = this.f1345k;
                com.google.android.gms.internal.measurement.M m5 = (com.google.android.gms.internal.measurement.M) this.f1349p;
                C0120x1 c0120x12 = this.f1348o;
                Bundle bundle2 = new Bundle();
                try {
                    j5 = c0120x12.f1451f;
                    str = this.f1346l;
                    c0113v0 = (C0113v0) c0120x12.f84c;
                } catch (RemoteException e6) {
                    bundle = bundle2;
                    e5 = e6;
                } catch (Throwable th) {
                    th = th;
                    a2 a2Var2 = ((C0113v0) c0120x12.f84c).n;
                    C0113v0.i(a2Var2);
                    a2Var2.H(m5, bundle2);
                    throw th;
                }
                if (j5 == null) {
                    Z z4 = c0113v0.f1417k;
                    C0113v0.k(z4);
                    z4.h.c(str2, str, "Failed to get user properties; not connected to service");
                    a2 a2Var3 = c0113v0.n;
                    C0113v0.i(a2Var3);
                    a2Var3.H(m5, bundle2);
                    return;
                }
                b2 b2Var = this.f1347m;
                q1.E.i(b2Var);
                List<Y1> listY = j5.y(str2, str, this.n, b2Var);
                bundle = new Bundle();
                if (listY != null) {
                    for (Y1 y12 : listY) {
                        String str3 = y12.n;
                        String str4 = y12.f1071k;
                        if (str3 != null) {
                            bundle.putString(str4, str3);
                        } else {
                            Long l5 = y12.f1073m;
                            if (l5 != null) {
                                bundle.putLong(str4, l5.longValue());
                            } else {
                                Double d5 = y12.f1075p;
                                if (d5 != null) {
                                    bundle.putDouble(str4, d5.doubleValue());
                                }
                            }
                        }
                    }
                }
                try {
                    try {
                        c0120x12.z();
                        a2Var = c0113v0.n;
                    } catch (RemoteException e7) {
                        e5 = e7;
                        Z z5 = ((C0113v0) c0120x12.f84c).f1417k;
                        C0113v0.k(z5);
                        z5.h.c(str2, e5, "Failed to get user properties; remote exception");
                        a2Var = ((C0113v0) c0120x12.f84c).n;
                        C0113v0.i(a2Var);
                        a2Var.H(m5, bundle);
                        return;
                    }
                    C0113v0.i(a2Var);
                    a2Var.H(m5, bundle);
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    bundle2 = bundle;
                    a2 a2Var22 = ((C0113v0) c0120x12.f84c).n;
                    C0113v0.i(a2Var22);
                    a2Var22.H(m5, bundle2);
                    throw th;
                }
            default:
                AtomicReference atomicReference2 = (AtomicReference) this.f1349p;
                synchronized (atomicReference2) {
                    try {
                        try {
                            c0120x1 = this.f1348o;
                            j6 = c0120x1.f1451f;
                        } catch (RemoteException e8) {
                            Z z6 = ((C0113v0) this.f1348o.f84c).f1417k;
                            C0113v0.k(z6);
                            z6.h.d("(legacy) Failed to get user properties; remote exception", null, this.f1345k, e8);
                            ((AtomicReference) this.f1349p).set(Collections.emptyList());
                            atomicReference = (AtomicReference) this.f1349p;
                        }
                        if (j6 == null) {
                            Z z7 = ((C0113v0) c0120x1.f84c).f1417k;
                            C0113v0.k(z7);
                            z7.h.d("(legacy) Failed to get user properties; not connected to service", null, this.f1345k, this.f1346l);
                            atomicReference2.set(Collections.emptyList());
                            atomicReference2.notify();
                            return;
                        }
                        if (TextUtils.isEmpty(null)) {
                            b2 b2Var2 = this.f1347m;
                            q1.E.i(b2Var2);
                            atomicReference2.set(j6.y(this.f1345k, this.f1346l, this.n, b2Var2));
                        } else {
                            atomicReference2.set(j6.G(null, this.f1345k, this.f1346l, this.n));
                        }
                        c0120x1.z();
                        atomicReference = (AtomicReference) this.f1349p;
                        atomicReference.notify();
                        return;
                    } catch (Throwable th3) {
                        ((AtomicReference) this.f1349p).notify();
                        throw th3;
                    }
                }
        }
    }

    public RunnableC0097p1(C0120x1 c0120x1, AtomicReference atomicReference, String str, String str2, b2 b2Var, boolean z4) {
        this.f1349p = atomicReference;
        this.f1345k = str;
        this.f1346l = str2;
        this.f1347m = b2Var;
        this.n = z4;
        this.f1348o = c0120x1;
    }
}
