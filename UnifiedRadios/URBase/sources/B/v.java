package B;

import android.graphics.drawable.ColorStateListDrawable;
import android.view.WindowInsets;

/* loaded from: classes.dex */
public abstract /* synthetic */ class v {
    public static /* bridge */ /* synthetic */ ColorStateListDrawable d(Object obj) {
        return (ColorStateListDrawable) obj;
    }

    public static /* synthetic */ WindowInsets.Builder e() {
        return new WindowInsets.Builder();
    }

    public static /* synthetic */ WindowInsets.Builder f(WindowInsets windowInsets) {
        return new WindowInsets.Builder(windowInsets);
    }

    public static /* bridge */ /* synthetic */ boolean q(Object obj) {
        return obj instanceof ColorStateListDrawable;
    }
}
