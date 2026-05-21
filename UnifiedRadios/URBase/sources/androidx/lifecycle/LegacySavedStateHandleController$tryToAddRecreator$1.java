package androidx.lifecycle;

/* loaded from: classes.dex */
public final class LegacySavedStateHandleController$tryToAddRecreator$1 implements r {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ AbstractC0245o f3922j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ o0.c f3923k;

    public LegacySavedStateHandleController$tryToAddRecreator$1(AbstractC0245o abstractC0245o, o0.c cVar) {
        this.f3922j = abstractC0245o;
        this.f3923k = cVar;
    }

    @Override // androidx.lifecycle.r
    public final void a(InterfaceC0249t interfaceC0249t, EnumC0243m enumC0243m) throws NoSuchMethodException, SecurityException {
        if (enumC0243m == EnumC0243m.ON_START) {
            this.f3922j.b(this);
            this.f3923k.d();
        }
    }
}
