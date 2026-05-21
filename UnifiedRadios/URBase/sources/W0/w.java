package w0;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;

/* loaded from: classes.dex */
public abstract class w {

    /* renamed from: a, reason: collision with root package name */
    public static final x f10116a;

    /* renamed from: b, reason: collision with root package name */
    public static final C0928b f10117b;

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            f10116a = new y();
        } else {
            f10116a = new x();
        }
        f10117b = new C0928b(Float.class, "translationAlpha", 5);
        new C0928b(Rect.class, "clipBounds", 6);
    }

    public static void a(View view, int i5, int i6, int i7, int i8) {
        f10116a.O(view, i5, i6, i7, i8);
    }
}
