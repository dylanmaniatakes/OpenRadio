package androidx.lifecycle;

/* loaded from: classes.dex */
public final class SavedStateHandleAttacher implements r {

    /* renamed from: j, reason: collision with root package name */
    public final N f3943j;

    public SavedStateHandleAttacher(N n) {
        this.f3943j = n;
    }

    @Override // androidx.lifecycle.r
    public final void a(InterfaceC0249t interfaceC0249t, EnumC0243m enumC0243m) {
        if (enumC0243m != EnumC0243m.ON_CREATE) {
            throw new IllegalStateException(("Next event must be ON_CREATE, it was " + enumC0243m).toString());
        }
        interfaceC0249t.getLifecycle().b(this);
        N n = this.f3943j;
        if (n.f3928b) {
            return;
        }
        n.f3929c = n.f3927a.a("androidx.lifecycle.internal.SavedStateHandlesProvider");
        n.f3928b = true;
    }
}
