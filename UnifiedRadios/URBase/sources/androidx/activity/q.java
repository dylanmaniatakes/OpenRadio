package androidx.activity;

import android.window.BackEvent;
import android.window.OnBackAnimationCallback;

/* loaded from: classes.dex */
public final class q implements OnBackAnimationCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ E3.l f3246a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ E3.l f3247b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ E3.a f3248c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ E3.a f3249d;

    public q(E3.l lVar, E3.l lVar2, E3.a aVar, E3.a aVar2) {
        this.f3246a = lVar;
        this.f3247b = lVar2;
        this.f3248c = aVar;
        this.f3249d = aVar2;
    }

    public final void onBackCancelled() {
        this.f3249d.invoke();
    }

    public final void onBackInvoked() {
        this.f3248c.invoke();
    }

    public final void onBackProgressed(BackEvent backEvent) {
        F3.i.f(backEvent, "backEvent");
        this.f3247b.invoke(new b(backEvent));
    }

    public final void onBackStarted(BackEvent backEvent) {
        F3.i.f(backEvent, "backEvent");
        this.f3246a.invoke(new b(backEvent));
    }
}
