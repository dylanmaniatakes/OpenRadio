package androidx.activity;

import android.window.OnBackInvokedCallback;

/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public static final r f3250a = new r();

    public final OnBackInvokedCallback a(E3.l lVar, E3.l lVar2, E3.a aVar, E3.a aVar2) {
        F3.i.f(lVar, "onBackStarted");
        F3.i.f(lVar2, "onBackProgressed");
        F3.i.f(aVar, "onBackInvoked");
        F3.i.f(aVar2, "onBackCancelled");
        return new q(lVar, lVar2, aVar, aVar2);
    }
}
