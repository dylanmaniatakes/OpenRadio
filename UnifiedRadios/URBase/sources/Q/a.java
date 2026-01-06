package Q;

import android.graphics.Path;
import android.view.animation.PathInterpolator;

/* loaded from: classes.dex */
public abstract class a {
    public static PathInterpolator a(float f5, float f6) {
        return new PathInterpolator(f5, f6);
    }

    public static PathInterpolator b(float f5, float f6, float f7, float f8) {
        return new PathInterpolator(f5, f6, f7, f8);
    }

    public static PathInterpolator c(Path path) {
        return new PathInterpolator(path);
    }
}
