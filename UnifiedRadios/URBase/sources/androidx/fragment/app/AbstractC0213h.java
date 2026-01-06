package androidx.fragment.app;

import g0.AbstractC0535a;
import java.util.HashSet;

/* renamed from: androidx.fragment.app.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0213h {

    /* renamed from: a, reason: collision with root package name */
    public final p0 f3808a;

    /* renamed from: b, reason: collision with root package name */
    public final K.d f3809b;

    public AbstractC0213h(p0 p0Var, K.d dVar) {
        this.f3808a = p0Var;
        this.f3809b = dVar;
    }

    public final void a() {
        p0 p0Var = this.f3808a;
        HashSet hashSet = p0Var.f3862e;
        if (hashSet.remove(this.f3809b) && hashSet.isEmpty()) {
            p0Var.b();
        }
    }

    public final boolean b() {
        p0 p0Var = this.f3808a;
        int iC = AbstractC0535a.c(p0Var.f3860c.mView);
        int i5 = p0Var.f3858a;
        return iC == i5 || !(iC == 2 || i5 == 2);
    }
}
