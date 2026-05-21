package androidx.recyclerview.widget;

import O.C0156c;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class o0 extends C0156c {

    /* renamed from: d, reason: collision with root package name */
    public final p0 f4304d;

    /* renamed from: e, reason: collision with root package name */
    public final WeakHashMap f4305e = new WeakHashMap();

    public o0(p0 p0Var) {
        this.f4304d = p0Var;
    }

    @Override // O.C0156c
    public final boolean a(View view, AccessibilityEvent accessibilityEvent) {
        C0156c c0156c = (C0156c) this.f4305e.get(view);
        return c0156c != null ? c0156c.a(view, accessibilityEvent) : this.f1912a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    @Override // O.C0156c
    public final Z3.g b(View view) {
        C0156c c0156c = (C0156c) this.f4305e.get(view);
        return c0156c != null ? c0156c.b(view) : super.b(view);
    }

    @Override // O.C0156c
    public final void c(View view, AccessibilityEvent accessibilityEvent) {
        C0156c c0156c = (C0156c) this.f4305e.get(view);
        if (c0156c != null) {
            c0156c.c(view, accessibilityEvent);
        } else {
            super.c(view, accessibilityEvent);
        }
    }

    @Override // O.C0156c
    public final void d(View view, P.j jVar) {
        p0 p0Var = this.f4304d;
        boolean zO = p0Var.f4309d.O();
        View.AccessibilityDelegate accessibilityDelegate = this.f1912a;
        AccessibilityNodeInfo accessibilityNodeInfo = jVar.f2058a;
        if (!zO) {
            RecyclerView recyclerView = p0Var.f4309d;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().U(view, jVar);
                C0156c c0156c = (C0156c) this.f4305e.get(view);
                if (c0156c != null) {
                    c0156c.d(view, jVar);
                    return;
                } else {
                    accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                    return;
                }
            }
        }
        accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
    }

    @Override // O.C0156c
    public final void e(View view, AccessibilityEvent accessibilityEvent) {
        C0156c c0156c = (C0156c) this.f4305e.get(view);
        if (c0156c != null) {
            c0156c.e(view, accessibilityEvent);
        } else {
            super.e(view, accessibilityEvent);
        }
    }

    @Override // O.C0156c
    public final boolean f(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        C0156c c0156c = (C0156c) this.f4305e.get(viewGroup);
        return c0156c != null ? c0156c.f(viewGroup, view, accessibilityEvent) : this.f1912a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    @Override // O.C0156c
    public final boolean g(View view, int i5, Bundle bundle) {
        p0 p0Var = this.f4304d;
        if (!p0Var.f4309d.O()) {
            RecyclerView recyclerView = p0Var.f4309d;
            if (recyclerView.getLayoutManager() != null) {
                C0156c c0156c = (C0156c) this.f4305e.get(view);
                if (c0156c != null) {
                    if (c0156c.g(view, i5, bundle)) {
                        return true;
                    }
                } else if (super.g(view, i5, bundle)) {
                    return true;
                }
                d0 d0Var = recyclerView.getLayoutManager().f4179b.f4106e;
                return false;
            }
        }
        return super.g(view, i5, bundle);
    }

    @Override // O.C0156c
    public final void h(View view, int i5) {
        C0156c c0156c = (C0156c) this.f4305e.get(view);
        if (c0156c != null) {
            c0156c.h(view, i5);
        } else {
            super.h(view, i5);
        }
    }

    @Override // O.C0156c
    public final void i(View view, AccessibilityEvent accessibilityEvent) {
        C0156c c0156c = (C0156c) this.f4305e.get(view);
        if (c0156c != null) {
            c0156c.i(view, accessibilityEvent);
        } else {
            super.i(view, accessibilityEvent);
        }
    }
}
