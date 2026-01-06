package androidx.recyclerview.widget;

import O.C0156c;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

/* loaded from: classes.dex */
public final class p0 extends C0156c {

    /* renamed from: d, reason: collision with root package name */
    public final RecyclerView f4309d;

    /* renamed from: e, reason: collision with root package name */
    public final o0 f4310e;

    public p0(RecyclerView recyclerView) {
        this.f4309d = recyclerView;
        o0 o0Var = this.f4310e;
        if (o0Var != null) {
            this.f4310e = o0Var;
        } else {
            this.f4310e = new o0(this);
        }
    }

    @Override // O.C0156c
    public final void c(View view, AccessibilityEvent accessibilityEvent) {
        super.c(view, accessibilityEvent);
        if (!(view instanceof RecyclerView) || this.f4309d.O()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().S(accessibilityEvent);
        }
    }

    @Override // O.C0156c
    public final void d(View view, P.j jVar) {
        this.f1912a.onInitializeAccessibilityNodeInfo(view, jVar.f2058a);
        RecyclerView recyclerView = this.f4309d;
        if (recyclerView.O() || recyclerView.getLayoutManager() == null) {
            return;
        }
        X layoutManager = recyclerView.getLayoutManager();
        RecyclerView recyclerView2 = layoutManager.f4179b;
        layoutManager.T(recyclerView2.f4106e, recyclerView2.f4115j0, jVar);
    }

    @Override // O.C0156c
    public final boolean g(View view, int i5, Bundle bundle) {
        if (super.g(view, i5, bundle)) {
            return true;
        }
        RecyclerView recyclerView = this.f4309d;
        if (recyclerView.O() || recyclerView.getLayoutManager() == null) {
            return false;
        }
        X layoutManager = recyclerView.getLayoutManager();
        RecyclerView recyclerView2 = layoutManager.f4179b;
        return layoutManager.g0(recyclerView2.f4106e, recyclerView2.f4115j0, i5, bundle);
    }
}
