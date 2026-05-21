package androidx.activity;

import androidx.fragment.app.K;

/* loaded from: classes.dex */
public final class s implements c {

    /* renamed from: j, reason: collision with root package name */
    public final K f3275j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ u f3276k;

    public s(u uVar, K k5) {
        F3.i.f(k5, "onBackPressedCallback");
        this.f3276k = uVar;
        this.f3275j = k5;
    }

    @Override // androidx.activity.c
    public final void cancel() {
        u uVar = this.f3276k;
        t3.g gVar = uVar.f3279b;
        K k5 = this.f3275j;
        gVar.remove(k5);
        if (F3.i.a(uVar.f3280c, k5)) {
            k5.getClass();
            uVar.f3280c = null;
        }
        k5.getClass();
        k5.f3672b.remove(this);
        E3.a aVar = k5.f3673c;
        if (aVar != null) {
            aVar.invoke();
        }
        k5.f3673c = null;
    }
}
