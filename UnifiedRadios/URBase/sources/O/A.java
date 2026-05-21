package O;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.PointerIcon;

/* loaded from: classes.dex */
public abstract class A {
    public static PointerIcon a(Bitmap bitmap, float f5, float f6) {
        return PointerIcon.create(bitmap, f5, f6);
    }

    public static PointerIcon b(Context context, int i5) {
        return PointerIcon.getSystemIcon(context, i5);
    }

    public static PointerIcon c(Resources resources, int i5) {
        return PointerIcon.load(resources, i5);
    }
}
