package androidx.fragment.app;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class S implements Q {

    /* renamed from: a, reason: collision with root package name */
    public final int f3684a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3685b = 1;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ T f3686c;

    public S(T t4, int i5) {
        this.f3686c = t4;
        this.f3684a = i5;
    }

    @Override // androidx.fragment.app.Q
    public final boolean a(ArrayList arrayList, ArrayList arrayList2) {
        T t4 = this.f3686c;
        Fragment fragment = t4.f3709r;
        int i5 = this.f3684a;
        if (fragment == null || i5 >= 0 || !fragment.getChildFragmentManager().H()) {
            return t4.I(arrayList, arrayList2, i5, this.f3685b);
        }
        return false;
    }
}
