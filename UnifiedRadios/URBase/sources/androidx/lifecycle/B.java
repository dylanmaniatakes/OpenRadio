package androidx.lifecycle;

import l.C0722a;

/* loaded from: classes.dex */
public class B extends A {
    @Override // androidx.lifecycle.A
    public final void e(Object obj) {
        A.a("setValue");
        this.g++;
        this.f3899e = obj;
        c(null);
    }

    public final void f(Object obj) {
        boolean z4;
        synchronized (this.f3895a) {
            z4 = this.f3900f == A.f3894k;
            this.f3900f = obj;
        }
        if (z4) {
            C0722a.o().p(this.f3902j);
        }
    }
}
