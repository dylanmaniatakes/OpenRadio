package androidx.lifecycle;

import android.app.Activity;

/* loaded from: classes.dex */
public final class E extends AbstractC0237g {
    final /* synthetic */ G this$0;

    public E(G g) {
        this.this$0 = g;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostResumed(Activity activity) {
        F3.i.f(activity, "activity");
        this.this$0.a();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostStarted(Activity activity) {
        F3.i.f(activity, "activity");
        G g = this.this$0;
        int i5 = g.f3907c + 1;
        g.f3907c = i5;
        if (i5 == 1 && g.f3910f) {
            g.h.e(EnumC0243m.ON_START);
            g.f3910f = false;
        }
    }
}
