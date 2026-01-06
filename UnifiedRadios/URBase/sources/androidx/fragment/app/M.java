package androidx.fragment.app;

/* loaded from: classes.dex */
public final class M implements X {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Fragment f3677c;

    public M(Fragment fragment) {
        this.f3677c = fragment;
    }

    @Override // androidx.fragment.app.X
    public final void a(Fragment fragment) {
        this.f3677c.onAttachFragment(fragment);
    }
}
