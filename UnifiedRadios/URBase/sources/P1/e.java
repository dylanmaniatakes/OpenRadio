package P1;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import com.unified.ur1.SatelliteTracker.h;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public long f2074a;

    /* renamed from: c, reason: collision with root package name */
    public TimeInterpolator f2076c = null;

    /* renamed from: d, reason: collision with root package name */
    public int f2077d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f2078e = 1;

    /* renamed from: b, reason: collision with root package name */
    public long f2075b = 150;

    public e(long j5) {
        this.f2074a = j5;
    }

    public final void a(ObjectAnimator objectAnimator) {
        objectAnimator.setStartDelay(this.f2074a);
        objectAnimator.setDuration(this.f2075b);
        objectAnimator.setInterpolator(b());
        objectAnimator.setRepeatCount(this.f2077d);
        objectAnimator.setRepeatMode(this.f2078e);
    }

    public final TimeInterpolator b() {
        TimeInterpolator timeInterpolator = this.f2076c;
        return timeInterpolator != null ? timeInterpolator : a.f2065b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (this.f2074a == eVar.f2074a && this.f2075b == eVar.f2075b && this.f2077d == eVar.f2077d && this.f2078e == eVar.f2078e) {
            return b().getClass().equals(eVar.b().getClass());
        }
        return false;
    }

    public final int hashCode() {
        long j5 = this.f2074a;
        long j6 = this.f2075b;
        return ((((b().getClass().hashCode() + (((((int) (j5 ^ (j5 >>> 32))) * 31) + ((int) ((j6 >>> 32) ^ j6))) * 31)) * 31) + this.f2077d) * 31) + this.f2078e;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("\n");
        sb.append(e.class.getName());
        sb.append('{');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" delay: ");
        sb.append(this.f2074a);
        sb.append(" duration: ");
        sb.append(this.f2075b);
        sb.append(" interpolator: ");
        sb.append(b().getClass());
        sb.append(" repeatCount: ");
        sb.append(this.f2077d);
        sb.append(" repeatMode: ");
        return h.d(sb, this.f2078e, "}\n");
    }
}
