package O;

import android.view.WindowInsets;

/* loaded from: classes.dex */
public class B0 extends A0 {
    public E.c n;

    /* renamed from: o, reason: collision with root package name */
    public E.c f1882o;

    /* renamed from: p, reason: collision with root package name */
    public E.c f1883p;

    public B0(F0 f02, WindowInsets windowInsets) {
        super(f02, windowInsets);
        this.n = null;
        this.f1882o = null;
        this.f1883p = null;
    }

    @Override // O.D0
    public E.c g() {
        if (this.f1882o == null) {
            this.f1882o = E.c.c(this.f1983c.getMandatorySystemGestureInsets());
        }
        return this.f1882o;
    }

    @Override // O.D0
    public E.c i() {
        if (this.n == null) {
            this.n = E.c.c(this.f1983c.getSystemGestureInsets());
        }
        return this.n;
    }

    @Override // O.D0
    public E.c k() {
        if (this.f1883p == null) {
            this.f1883p = E.c.c(this.f1983c.getTappableElementInsets());
        }
        return this.f1883p;
    }

    @Override // O.y0, O.D0
    public F0 l(int i5, int i6, int i7, int i8) {
        return F0.g(null, this.f1983c.inset(i5, i6, i7, i8));
    }

    @Override // O.z0, O.D0
    public void q(E.c cVar) {
    }
}
