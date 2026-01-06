package O;

import android.graphics.Rect;
import android.view.Gravity;

/* renamed from: O.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0170j {
    public static void a(int i5, int i6, int i7, Rect rect, int i8, int i9, Rect rect2, int i10) {
        Gravity.apply(i5, i6, i7, rect, i8, i9, rect2, i10);
    }

    public static void b(int i5, int i6, int i7, Rect rect, Rect rect2, int i8) {
        Gravity.apply(i5, i6, i7, rect, rect2, i8);
    }

    public static void c(int i5, Rect rect, Rect rect2, int i6) {
        Gravity.applyDisplay(i5, rect, rect2, i6);
    }
}
