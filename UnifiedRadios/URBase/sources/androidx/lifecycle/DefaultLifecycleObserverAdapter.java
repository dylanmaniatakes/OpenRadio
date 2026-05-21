package androidx.lifecycle;

/* loaded from: classes.dex */
public final class DefaultLifecycleObserverAdapter implements r {

    /* renamed from: j, reason: collision with root package name */
    public final InterfaceC0235e f3904j;

    /* renamed from: k, reason: collision with root package name */
    public final r f3905k;

    public DefaultLifecycleObserverAdapter(InterfaceC0235e interfaceC0235e, r rVar) {
        F3.i.f(interfaceC0235e, "defaultLifecycleObserver");
        this.f3904j = interfaceC0235e;
        this.f3905k = rVar;
    }

    @Override // androidx.lifecycle.r
    public final void a(InterfaceC0249t interfaceC0249t, EnumC0243m enumC0243m) {
        int i5 = AbstractC0236f.f3959a[enumC0243m.ordinal()];
        InterfaceC0235e interfaceC0235e = this.f3904j;
        switch (i5) {
            case 1:
                interfaceC0235e.getClass();
                break;
            case 2:
                interfaceC0235e.getClass();
                break;
            case 3:
                interfaceC0235e.onResume();
                break;
            case 4:
                interfaceC0235e.getClass();
                break;
            case 5:
                interfaceC0235e.getClass();
                break;
            case 6:
                interfaceC0235e.getClass();
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        r rVar = this.f3905k;
        if (rVar != null) {
            rVar.a(interfaceC0249t, enumC0243m);
        }
    }
}
