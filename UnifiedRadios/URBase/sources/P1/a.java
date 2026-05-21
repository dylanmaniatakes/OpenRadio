package P1;

import a0.C0204a;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final LinearInterpolator f2064a = new LinearInterpolator();

    /* renamed from: b, reason: collision with root package name */
    public static final C0204a f2065b = new C0204a(1);

    /* renamed from: c, reason: collision with root package name */
    public static final C0204a f2066c = new C0204a(0);

    /* renamed from: d, reason: collision with root package name */
    public static final C0204a f2067d = new C0204a(2);

    /* renamed from: e, reason: collision with root package name */
    public static final DecelerateInterpolator f2068e = new DecelerateInterpolator();

    public static float a(float f5, float f6, float f7) {
        return ((f6 - f5) * f7) + f5;
    }

    public static float b(float f5, float f6, float f7, float f8, float f9) {
        return f9 <= f7 ? f5 : f9 >= f8 ? f6 : a(f5, f6, (f9 - f7) / (f8 - f7));
    }

    public static int c(float f5, int i5, int i6) {
        return Math.round(f5 * (i6 - i5)) + i5;
    }
}
