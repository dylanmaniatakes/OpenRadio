package androidx.fragment.app;

import android.graphics.Rect;
import android.view.View;
import g0.AbstractC0535a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: androidx.fragment.app.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0208c implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f3776j = 0;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f3777k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f3778l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f3779m;

    public RunnableC0208c(C0215j c0215j, ArrayList arrayList, p0 p0Var) {
        this.f3779m = c0215j;
        this.f3777k = arrayList;
        this.f3778l = p0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3776j) {
            case 0:
                List list = (List) this.f3777k;
                p0 p0Var = (p0) this.f3778l;
                if (list.contains(p0Var)) {
                    list.remove(p0Var);
                    ((C0215j) this.f3779m).getClass();
                    AbstractC0535a.a(p0Var.f3860c.mView, p0Var.f3858a);
                    break;
                }
                break;
            default:
                ((l0) this.f3777k).getClass();
                l0.g((View) this.f3778l, (Rect) this.f3779m);
                break;
        }
    }

    public RunnableC0208c(l0 l0Var, View view, Rect rect) {
        this.f3777k = l0Var;
        this.f3778l = view;
        this.f3779m = rect;
    }
}
