package androidx.fragment.app;

import android.view.View;
import android.view.Window;
import androidx.lifecycle.AbstractC0245o;
import f.AbstractActivityC0472i;

/* renamed from: androidx.fragment.app.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0229y extends F implements androidx.lifecycle.X, androidx.activity.v, androidx.activity.result.h, X {
    public final /* synthetic */ AbstractActivityC0230z g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0229y(AbstractActivityC0472i abstractActivityC0472i) {
        super(abstractActivityC0472i);
        this.g = abstractActivityC0472i;
    }

    @Override // androidx.fragment.app.X
    public final void a(Fragment fragment) {
        this.g.onAttachFragment(fragment);
    }

    @Override // androidx.fragment.app.D
    public final View b(int i5) {
        return this.g.findViewById(i5);
    }

    @Override // androidx.fragment.app.D
    public final boolean c() {
        Window window = this.g.getWindow();
        return (window == null || window.peekDecorView() == null) ? false : true;
    }

    @Override // androidx.activity.result.h
    public final androidx.activity.result.g getActivityResultRegistry() {
        return this.g.getActivityResultRegistry();
    }

    @Override // androidx.lifecycle.InterfaceC0249t
    public final AbstractC0245o getLifecycle() {
        return this.g.mFragmentLifecycleRegistry;
    }

    @Override // androidx.activity.v
    public final androidx.activity.u getOnBackPressedDispatcher() {
        return this.g.getOnBackPressedDispatcher();
    }

    @Override // androidx.lifecycle.X
    public final androidx.lifecycle.W getViewModelStore() {
        return this.g.getViewModelStore();
    }
}
