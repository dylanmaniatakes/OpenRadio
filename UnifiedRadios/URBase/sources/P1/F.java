package p1;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import java.util.Map;
import n1.C0787d;

/* loaded from: classes.dex */
public final class F extends x {

    /* renamed from: b, reason: collision with root package name */
    public final V1.d f9095b;

    /* renamed from: c, reason: collision with root package name */
    public final N1.k f9096c;

    /* renamed from: d, reason: collision with root package name */
    public final C0825a f9097d;

    public F(int i5, V1.d dVar, N1.k kVar, C0825a c0825a) {
        super(i5);
        this.f9096c = kVar;
        this.f9095b = dVar;
        this.f9097d = c0825a;
        if (i5 == 2 && dVar.f2526c) {
            throw new IllegalArgumentException("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
        }
    }

    @Override // p1.x
    public final boolean a(t tVar) {
        return this.f9095b.f2526c;
    }

    @Override // p1.x
    public final C0787d[] b(t tVar) {
        return (C0787d[]) this.f9095b.f2527d;
    }

    @Override // p1.x
    public final void c(Status status) {
        this.f9097d.getClass();
        this.f9096c.b(status.f4641l != null ? new o1.m(status) : new o1.e(status));
    }

    @Override // p1.x
    public final void d(RuntimeException runtimeException) {
        this.f9096c.b(runtimeException);
    }

    @Override // p1.x
    public final void e(t tVar) throws DeadObjectException {
        N1.k kVar = this.f9096c;
        try {
            V1.d dVar = this.f9095b;
            ((o) ((V1.d) dVar.f2528e).f2527d).p(tVar.f9138d, kVar);
        } catch (DeadObjectException e5) {
            throw e5;
        } catch (RemoteException e6) {
            c(x.g(e6));
        } catch (RuntimeException e7) {
            kVar.b(e7);
        }
    }

    @Override // p1.x
    public final void f(L0.c cVar, boolean z4) {
        Boolean boolValueOf = Boolean.valueOf(z4);
        Map map = (Map) cVar.f1537e;
        N1.k kVar = this.f9096c;
        map.put(kVar, boolValueOf);
        kVar.f1789a.g(new L0.s(21, cVar, kVar, false));
    }
}
