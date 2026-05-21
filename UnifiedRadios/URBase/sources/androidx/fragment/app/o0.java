package androidx.fragment.app;

import g0.AbstractC0535a;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class o0 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f3854j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ p0 f3855k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ C0215j f3856l;

    public /* synthetic */ o0(C0215j c0215j, p0 p0Var, int i5) {
        this.f3854j = i5;
        this.f3856l = c0215j;
        this.f3855k = p0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3854j) {
            case 0:
                ArrayList arrayList = this.f3856l.f3821b;
                p0 p0Var = this.f3855k;
                if (arrayList.contains(p0Var)) {
                    AbstractC0535a.a(p0Var.f3860c.mView, p0Var.f3858a);
                    break;
                }
                break;
            default:
                C0215j c0215j = this.f3856l;
                ArrayList arrayList2 = c0215j.f3821b;
                p0 p0Var2 = this.f3855k;
                arrayList2.remove(p0Var2);
                c0215j.f3822c.remove(p0Var2);
                break;
        }
    }
}
