package androidx.fragment.app;

import android.view.View;

/* renamed from: androidx.fragment.app.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0221p extends D {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Fragment f3857c;

    public C0221p(Fragment fragment) {
        this.f3857c = fragment;
    }

    @Override // androidx.fragment.app.D
    public final View b(int i5) {
        Fragment fragment = this.f3857c;
        View view = fragment.mView;
        if (view != null) {
            return view.findViewById(i5);
        }
        throw new IllegalStateException("Fragment " + fragment + " does not have a view");
    }

    @Override // androidx.fragment.app.D
    public final boolean c() {
        return this.f3857c.mView != null;
    }
}
