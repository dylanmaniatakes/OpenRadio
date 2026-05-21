package J1;

import android.os.Bundle;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import r1.AbstractC0873a;

/* loaded from: classes.dex */
public final /* synthetic */ class O0 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f922j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ C0058c1 f923k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f924l;

    public /* synthetic */ O0(C0058c1 c0058c1, AtomicReference atomicReference, int i5) {
        this.f922j = i5;
        this.f923k = c0058c1;
        this.f924l = atomicReference;
    }

    private final void a() {
        AtomicReference atomicReference = this.f924l;
        synchronized (atomicReference) {
            try {
                try {
                    C0113v0 c0113v0 = (C0113v0) this.f923k.f84c;
                    atomicReference.set(Integer.valueOf(c0113v0.f1415i.p(c0113v0.n().q(), H.f803c0)));
                } finally {
                    this.f924l.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() throws JSONException {
        switch (this.f922j) {
            case 0:
                C0058c1 c0058c1 = this.f923k;
                C0072h0 c0072h0 = ((C0113v0) c0058c1.f84c).f1416j;
                C0113v0.i(c0072h0);
                Bundle bundleQ = c0072h0.f1243q.q();
                C0120x1 c0120x1R = ((C0113v0) c0058c1.f84c).r();
                c0120x1R.j();
                c0120x1R.k();
                c0120x1R.A(new RunnableC0122y0((Object) c0120x1R, (Serializable) this.f924l, (AbstractC0873a) c0120x1R.x(false), (Object) bundleQ, 4));
                return;
            case 1:
                C0120x1 c0120x1R2 = ((C0113v0) this.f923k.f84c).r();
                EnumC0079j1[] enumC0079j1Arr = {EnumC0079j1.SGTM_CLIENT};
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(Integer.valueOf(enumC0079j1Arr[0].f1277j));
                O1 o12 = new O1(arrayList);
                c0120x1R2.j();
                c0120x1R2.k();
                c0120x1R2.A(new RunnableC0122y0(c0120x1R2, this.f924l, c0120x1R2.x(false), o12));
                return;
            case 2:
                AtomicReference atomicReference = this.f924l;
                synchronized (atomicReference) {
                    try {
                        try {
                            C0113v0 c0113v0 = (C0113v0) this.f923k.f84c;
                            atomicReference.set(Boolean.valueOf(c0113v0.f1415i.w(c0113v0.n().q(), H.f794Z)));
                        } finally {
                        }
                    } finally {
                    }
                }
                return;
            case 3:
                AtomicReference atomicReference2 = this.f924l;
                synchronized (atomicReference2) {
                    try {
                        try {
                            C0113v0 c0113v02 = (C0113v0) this.f923k.f84c;
                            atomicReference2.set(c0113v02.f1415i.v(c0113v02.n().q(), H.f797a0));
                        } finally {
                        }
                    } finally {
                    }
                }
                return;
            case 4:
                AtomicReference atomicReference3 = this.f924l;
                synchronized (atomicReference3) {
                    try {
                        try {
                            C0113v0 c0113v03 = (C0113v0) this.f923k.f84c;
                            atomicReference3.set(Long.valueOf(c0113v03.f1415i.r(c0113v03.n().q(), H.f800b0)));
                        } finally {
                        }
                    } finally {
                    }
                }
                return;
            case 5:
                a();
                return;
            default:
                AtomicReference atomicReference4 = this.f924l;
                synchronized (atomicReference4) {
                    try {
                        try {
                            C0113v0 c0113v04 = (C0113v0) this.f923k.f84c;
                            atomicReference4.set(Double.valueOf(c0113v04.f1415i.o(c0113v04.n().q(), H.f805d0)));
                        } finally {
                        }
                    } finally {
                    }
                }
                return;
        }
    }
}
