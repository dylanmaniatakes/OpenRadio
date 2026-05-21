package androidx.fragment.app;

import android.app.Dialog;
import android.view.View;

/* renamed from: androidx.fragment.app.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0218m extends D {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ D f3831c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ DialogInterfaceOnCancelListenerC0219n f3832d;

    public C0218m(DialogInterfaceOnCancelListenerC0219n dialogInterfaceOnCancelListenerC0219n, D d5) {
        this.f3832d = dialogInterfaceOnCancelListenerC0219n;
        this.f3831c = d5;
    }

    @Override // androidx.fragment.app.D
    public final View b(int i5) {
        D d5 = this.f3831c;
        if (d5.c()) {
            return d5.b(i5);
        }
        Dialog dialog = this.f3832d.n;
        if (dialog != null) {
            return dialog.findViewById(i5);
        }
        return null;
    }

    @Override // androidx.fragment.app.D
    public final boolean c() {
        return this.f3831c.c() || this.f3832d.f3849r;
    }
}
