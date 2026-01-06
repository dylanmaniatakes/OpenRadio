package P;

import android.view.accessibility.AccessibilityNodeInfo;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final Object f2057a;

    public /* synthetic */ i(Object obj) {
        this.f2057a = obj;
    }

    public static i a(int i5, int i6, int i7, int i8, boolean z4) {
        return new i(AccessibilityNodeInfo.CollectionItemInfo.obtain(i5, i6, i7, i8, false, z4));
    }
}
