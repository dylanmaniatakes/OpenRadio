package U3;

import N3.H;
import w3.InterfaceC0941i;

/* loaded from: classes.dex */
public abstract class g extends H {

    /* renamed from: l, reason: collision with root package name */
    public final b f2489l;

    public g(String str, long j5, int i5, int i6) {
        this.f2489l = new b(str, j5, i5, i6);
    }

    @Override // N3.AbstractC0143q
    public final void W(InterfaceC0941i interfaceC0941i, Runnable runnable) {
        b.o(this.f2489l, runnable, false, 6);
    }

    @Override // N3.AbstractC0143q
    public final void X(InterfaceC0941i interfaceC0941i, Runnable runnable) {
        b.o(this.f2489l, runnable, true, 2);
    }
}
