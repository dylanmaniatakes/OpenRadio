package p1;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import i3.C0573b;
import n1.C0787d;

/* renamed from: p1.E, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0824E extends x {

    /* renamed from: b, reason: collision with root package name */
    public final N1.k f9092b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f9093c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f9094d;

    public C0824E(int i5, N1.k kVar) {
        super(i5);
        this.f9092b = kVar;
    }

    private final /* bridge */ /* synthetic */ void i(L0.c cVar, boolean z4) {
    }

    private final /* bridge */ /* synthetic */ void j(L0.c cVar, boolean z4) {
    }

    @Override // p1.x
    public final boolean a(t tVar) {
        switch (this.f9093c) {
            case 0:
                ((C0821B) this.f9094d).f9082a.getClass();
                break;
            default:
                C0821B c0821b = (C0821B) tVar.h.get((l) this.f9094d);
                if (c0821b != null) {
                    c0821b.f9082a.getClass();
                    break;
                }
                break;
        }
        return true;
    }

    @Override // p1.x
    public final C0787d[] b(t tVar) {
        switch (this.f9093c) {
            case 0:
                ((C0821B) this.f9094d).f9082a.getClass();
                break;
            default:
                C0821B c0821b = (C0821B) tVar.h.get((l) this.f9094d);
                if (c0821b != null) {
                    c0821b.f9082a.getClass();
                    break;
                }
                break;
        }
        return null;
    }

    @Override // p1.x
    public final void c(Status status) {
        this.f9092b.b(new o1.e(status));
    }

    @Override // p1.x
    public final void d(RuntimeException runtimeException) {
        this.f9092b.b(runtimeException);
    }

    @Override // p1.x
    public final void e(t tVar) throws DeadObjectException {
        try {
            h(tVar);
        } catch (DeadObjectException e5) {
            c(x.g(e5));
            throw e5;
        } catch (RemoteException e6) {
            c(x.g(e6));
        } catch (RuntimeException e7) {
            this.f9092b.b(e7);
        }
    }

    @Override // p1.x
    public final /* bridge */ /* synthetic */ void f(L0.c cVar, boolean z4) {
        int i5 = this.f9093c;
    }

    public final void h(t tVar) {
        switch (this.f9093c) {
            case 0:
                C0573b c0573b = ((C0821B) this.f9094d).f9082a;
                ((o) ((m1.m) c0573b.f7297e).f8545d).p(tVar.f9138d, this.f9092b);
                l lVar = (l) ((androidx.emoji2.text.e) ((C0821B) this.f9094d).f9082a.f7296d).f3602c;
                if (lVar != null) {
                    tVar.h.put(lVar, (C0821B) this.f9094d);
                    break;
                }
                break;
            default:
                C0821B c0821b = (C0821B) tVar.h.remove((l) this.f9094d);
                N1.k kVar = this.f9092b;
                if (c0821b == null) {
                    kVar.c(Boolean.FALSE);
                    break;
                } else {
                    ((o) ((m1.m) c0821b.f9083b.f1542e).f8546e).p(tVar.f9138d, kVar);
                    ((androidx.emoji2.text.e) c0821b.f9082a.f7296d).a();
                    break;
                }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C0824E(l lVar, N1.k kVar) {
        this(4, kVar);
        this.f9093c = 1;
        this.f9094d = lVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C0824E(C0821B c0821b, N1.k kVar) {
        this(3, kVar);
        this.f9093c = 0;
        this.f9094d = c0821b;
    }
}
