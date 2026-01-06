package J1;

import java.util.concurrent.Callable;

/* renamed from: J1.m0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class CallableC0087m0 implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1300a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1301b;

    public /* synthetic */ CallableC0087m0(C0093o0 c0093o0) {
        this.f1301b = c0093o0;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f1300a) {
            case 0:
                return new com.google.android.gms.internal.measurement.I1(((C0093o0) this.f1301b).f1331m);
            default:
                E0 e02 = (E0) this.f1301b;
                e02.f728c.j();
                C0060d0 c0060d0 = e02.f728c.f1022j;
                V1.J(c0060d0);
                c0060d0.j();
                throw new IllegalStateException("Unexpected call on client side");
        }
    }

    public CallableC0087m0(E0 e02, C0112v c0112v, String str) {
        this.f1301b = e02;
    }
}
