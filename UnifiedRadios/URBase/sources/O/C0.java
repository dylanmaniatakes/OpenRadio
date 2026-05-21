package O;

import android.view.View;
import android.view.WindowInsets;

/* loaded from: classes.dex */
public final class C0 extends B0 {

    /* renamed from: q, reason: collision with root package name */
    public static final F0 f1885q = F0.g(null, WindowInsets.CONSUMED);

    public C0(F0 f02, WindowInsets windowInsets) {
        super(f02, windowInsets);
    }

    @Override // O.y0, O.D0
    public final void d(View view) {
    }

    @Override // O.y0, O.D0
    public E.c f(int i5) {
        return E.c.c(this.f1983c.getInsets(E0.a(i5)));
    }
}
