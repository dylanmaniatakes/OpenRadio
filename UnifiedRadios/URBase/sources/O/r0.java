package O;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

/* loaded from: classes.dex */
public abstract class r0 {

    /* renamed from: a, reason: collision with root package name */
    public final int f1956a;

    /* renamed from: b, reason: collision with root package name */
    public float f1957b;

    /* renamed from: c, reason: collision with root package name */
    public final Interpolator f1958c;

    /* renamed from: d, reason: collision with root package name */
    public final long f1959d;

    public r0(int i5, DecelerateInterpolator decelerateInterpolator, long j5) {
        this.f1956a = i5;
        this.f1958c = decelerateInterpolator;
        this.f1959d = j5;
    }

    public long a() {
        return this.f1959d;
    }

    public float b() {
        Interpolator interpolator = this.f1958c;
        return interpolator != null ? interpolator.getInterpolation(this.f1957b) : this.f1957b;
    }

    public int c() {
        return this.f1956a;
    }

    public void d(float f5) {
        this.f1957b = f5;
    }
}
