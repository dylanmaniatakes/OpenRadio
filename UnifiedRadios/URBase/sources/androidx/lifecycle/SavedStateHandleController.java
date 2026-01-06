package androidx.lifecycle;

/* loaded from: classes.dex */
public final class SavedStateHandleController implements r {

    /* renamed from: j, reason: collision with root package name */
    public final String f3944j;

    /* renamed from: k, reason: collision with root package name */
    public final K f3945k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f3946l;

    public SavedStateHandleController(String str, K k5) {
        this.f3944j = str;
        this.f3945k = k5;
    }

    @Override // androidx.lifecycle.r
    public final void a(InterfaceC0249t interfaceC0249t, EnumC0243m enumC0243m) {
        if (enumC0243m == EnumC0243m.ON_DESTROY) {
            this.f3946l = false;
            interfaceC0249t.getLifecycle().b(this);
        }
    }

    public final void b(AbstractC0245o abstractC0245o, o0.c cVar) {
        F3.i.f(cVar, "registry");
        F3.i.f(abstractC0245o, "lifecycle");
        if (!(!this.f3946l)) {
            throw new IllegalStateException("Already attached to lifecycleOwner".toString());
        }
        this.f3946l = true;
        abstractC0245o.a(this);
        cVar.c(this.f3944j, this.f3945k.f3920e);
    }
}
