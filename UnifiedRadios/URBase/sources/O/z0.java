package O;

import android.view.WindowInsets;

/* loaded from: classes.dex */
public abstract class z0 extends y0 {

    /* renamed from: m, reason: collision with root package name */
    public E.c f1990m;

    public z0(F0 f02, WindowInsets windowInsets) {
        super(f02, windowInsets);
        this.f1990m = null;
    }

    @Override // O.D0
    public F0 b() {
        return F0.g(null, this.f1983c.consumeStableInsets());
    }

    @Override // O.D0
    public F0 c() {
        return F0.g(null, this.f1983c.consumeSystemWindowInsets());
    }

    @Override // O.D0
    public final E.c h() {
        if (this.f1990m == null) {
            WindowInsets windowInsets = this.f1983c;
            this.f1990m = E.c.b(windowInsets.getStableInsetLeft(), windowInsets.getStableInsetTop(), windowInsets.getStableInsetRight(), windowInsets.getStableInsetBottom());
        }
        return this.f1990m;
    }

    @Override // O.D0
    public boolean m() {
        return this.f1983c.isConsumed();
    }

    @Override // O.D0
    public void q(E.c cVar) {
        this.f1990m = cVar;
    }
}
