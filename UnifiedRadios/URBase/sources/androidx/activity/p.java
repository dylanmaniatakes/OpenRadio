package androidx.activity;

import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public static final p f3245a = new p();

    public final OnBackInvokedCallback a(E3.a aVar) {
        F3.i.f(aVar, "onBackInvoked");
        return new o(0, aVar);
    }

    public final void b(Object obj, int i5, Object obj2) {
        F3.i.f(obj, "dispatcher");
        F3.i.f(obj2, "callback");
        ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(i5, (OnBackInvokedCallback) obj2);
    }

    public final void c(Object obj, Object obj2) {
        F3.i.f(obj, "dispatcher");
        F3.i.f(obj2, "callback");
        ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
    }
}
