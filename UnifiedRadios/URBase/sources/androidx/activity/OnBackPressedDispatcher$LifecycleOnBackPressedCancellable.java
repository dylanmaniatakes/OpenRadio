package androidx.activity;

import androidx.fragment.app.K;
import androidx.lifecycle.AbstractC0245o;
import androidx.lifecycle.EnumC0243m;
import androidx.lifecycle.InterfaceC0249t;

/* loaded from: classes.dex */
final class OnBackPressedDispatcher$LifecycleOnBackPressedCancellable implements androidx.lifecycle.r, c {

    /* renamed from: j, reason: collision with root package name */
    public final AbstractC0245o f3217j;

    /* renamed from: k, reason: collision with root package name */
    public final K f3218k;

    /* renamed from: l, reason: collision with root package name */
    public s f3219l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ u f3220m;

    public OnBackPressedDispatcher$LifecycleOnBackPressedCancellable(u uVar, AbstractC0245o abstractC0245o, K k5) {
        F3.i.f(k5, "onBackPressedCallback");
        this.f3220m = uVar;
        this.f3217j = abstractC0245o;
        this.f3218k = k5;
        abstractC0245o.a(this);
    }

    @Override // androidx.lifecycle.r
    public final void a(InterfaceC0249t interfaceC0249t, EnumC0243m enumC0243m) {
        if (enumC0243m != EnumC0243m.ON_START) {
            if (enumC0243m != EnumC0243m.ON_STOP) {
                if (enumC0243m == EnumC0243m.ON_DESTROY) {
                    cancel();
                    return;
                }
                return;
            } else {
                s sVar = this.f3219l;
                if (sVar != null) {
                    sVar.cancel();
                    return;
                }
                return;
            }
        }
        u uVar = this.f3220m;
        uVar.getClass();
        K k5 = this.f3218k;
        F3.i.f(k5, "onBackPressedCallback");
        uVar.f3279b.d(k5);
        s sVar2 = new s(uVar, k5);
        k5.f3672b.add(sVar2);
        uVar.d();
        k5.f3673c = new t(0, uVar, u.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0, 1);
        this.f3219l = sVar2;
    }

    @Override // androidx.activity.c
    public final void cancel() {
        this.f3217j.b(this);
        K k5 = this.f3218k;
        k5.getClass();
        k5.f3672b.remove(this);
        s sVar = this.f3219l;
        if (sVar != null) {
            sVar.cancel();
        }
        this.f3219l = null;
    }
}
