package androidx.activity;

import android.os.Build;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.fragment.app.K;
import androidx.fragment.app.T;
import androidx.lifecycle.AbstractC0245o;
import androidx.lifecycle.C0251v;
import androidx.lifecycle.EnumC0244n;
import androidx.lifecycle.InterfaceC0249t;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

/* loaded from: classes.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public final Runnable f3278a;

    /* renamed from: b, reason: collision with root package name */
    public final t3.g f3279b = new t3.g();

    /* renamed from: c, reason: collision with root package name */
    public K f3280c;

    /* renamed from: d, reason: collision with root package name */
    public final OnBackInvokedCallback f3281d;

    /* renamed from: e, reason: collision with root package name */
    public OnBackInvokedDispatcher f3282e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f3283f;
    public boolean g;

    public u(Runnable runnable) {
        this.f3278a = runnable;
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 33) {
            this.f3281d = i5 >= 34 ? r.f3250a.a(new m(this, 0), new m(this, 1), new n(this, 0), new n(this, 1)) : p.f3245a.a(new n(this, 2));
        }
    }

    public final void a(InterfaceC0249t interfaceC0249t, K k5) {
        F3.i.f(k5, "onBackPressedCallback");
        AbstractC0245o lifecycle = interfaceC0249t.getLifecycle();
        if (((C0251v) lifecycle).f3971c == EnumC0244n.f3961j) {
            return;
        }
        k5.f3672b.add(new OnBackPressedDispatcher$LifecycleOnBackPressedCancellable(this, lifecycle, k5));
        d();
        k5.f3673c = new t(0, this, u.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0, 0);
    }

    public final void b() {
        Object objPrevious;
        t3.g gVar = this.f3279b;
        ListIterator listIterator = gVar.listIterator(gVar.a());
        while (true) {
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            } else {
                objPrevious = listIterator.previous();
                if (((K) objPrevious).f3671a) {
                    break;
                }
            }
        }
        K k5 = (K) objPrevious;
        this.f3280c = null;
        if (k5 == null) {
            Runnable runnable = this.f3278a;
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        T t4 = k5.f3674d;
        t4.s(true);
        if (t4.h.f3671a) {
            t4.H();
        } else {
            t4.g.b();
        }
    }

    public final void c(boolean z4) {
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.f3282e;
        OnBackInvokedCallback onBackInvokedCallback = this.f3281d;
        if (onBackInvokedDispatcher == null || onBackInvokedCallback == null) {
            return;
        }
        p pVar = p.f3245a;
        if (z4 && !this.f3283f) {
            pVar.b(onBackInvokedDispatcher, 0, onBackInvokedCallback);
            this.f3283f = true;
        } else {
            if (z4 || !this.f3283f) {
                return;
            }
            pVar.c(onBackInvokedDispatcher, onBackInvokedCallback);
            this.f3283f = false;
        }
    }

    public final void d() {
        boolean z4 = this.g;
        t3.g gVar = this.f3279b;
        boolean z5 = false;
        if (!(gVar instanceof Collection) || !gVar.isEmpty()) {
            Iterator it = gVar.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (((K) it.next()).f3671a) {
                    z5 = true;
                    break;
                }
            }
        }
        this.g = z5;
        if (z5 == z4 || Build.VERSION.SDK_INT < 33) {
            return;
        }
        c(z5);
    }
}
