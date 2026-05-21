package androidx.fragment.app;

import android.view.View;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class e0 {

    /* renamed from: a, reason: collision with root package name */
    public static final j0 f3796a = new j0();

    /* renamed from: b, reason: collision with root package name */
    public static final l0 f3797b;

    static {
        l0 l0Var = null;
        try {
            l0Var = (l0) w0.m.class.getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        f3797b = l0Var;
    }

    public static void a(Fragment fragment, Fragment fragment2, boolean z4) {
        if (z4) {
            fragment2.getEnterTransitionCallback();
        } else {
            fragment.getEnterTransitionCallback();
        }
    }

    public static void b(ArrayList arrayList, int i5) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((View) arrayList.get(size)).setVisibility(i5);
        }
    }
}
