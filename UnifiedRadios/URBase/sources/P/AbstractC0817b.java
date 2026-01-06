package p;

import android.graphics.drawable.Drawable;

/* renamed from: p.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0817b extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    public static final double f9073a = Math.cos(Math.toRadians(45.0d));

    public static float a(float f5, float f6, boolean z4) {
        if (!z4) {
            return f5;
        }
        return (float) (((1.0d - f9073a) * f6) + f5);
    }

    public static float b(float f5, float f6, boolean z4) {
        if (!z4) {
            return f5 * 1.5f;
        }
        return (float) (((1.0d - f9073a) * f6) + (f5 * 1.5f));
    }
}
