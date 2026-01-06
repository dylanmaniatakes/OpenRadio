package k;

import android.view.View;

/* renamed from: k.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0631g implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final C0627e f7781j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ C0637j f7782k;

    public RunnableC0631g(C0637j c0637j, C0627e c0627e) {
        this.f7782k = c0637j;
        this.f7781j = c0627e;
    }

    @Override // java.lang.Runnable
    public final void run() {
        j.k kVar;
        C0637j c0637j = this.f7782k;
        j.m mVar = c0637j.f7791e;
        if (mVar != null && (kVar = mVar.f7458e) != null) {
            kVar.e(mVar);
        }
        View view = (View) c0637j.f7794j;
        if (view != null && view.getWindowToken() != null) {
            C0627e c0627e = this.f7781j;
            if (c0627e.b()) {
                c0637j.f7805v = c0627e;
            } else if (c0627e.f7521f != null) {
                c0627e.d(0, 0, false, false);
                c0637j.f7805v = c0627e;
            }
        }
        c0637j.f7807x = null;
    }
}
