package O;

import android.view.WindowInsetsAnimation;

/* loaded from: classes.dex */
public final class q0 extends r0 {

    /* renamed from: e, reason: collision with root package name */
    public final WindowInsetsAnimation f1955e;

    public q0(WindowInsetsAnimation windowInsetsAnimation) {
        super(0, null, 0L);
        this.f1955e = windowInsetsAnimation;
    }

    @Override // O.r0
    public final long a() {
        return this.f1955e.getDurationMillis();
    }

    @Override // O.r0
    public final float b() {
        return this.f1955e.getInterpolatedFraction();
    }

    @Override // O.r0
    public final int c() {
        return this.f1955e.getTypeMask();
    }

    @Override // O.r0
    public final void d(float f5) {
        this.f1955e.setFraction(f5);
    }
}
