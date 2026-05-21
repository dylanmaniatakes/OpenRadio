package androidx.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

/* loaded from: classes.dex */
public final class F extends AbstractC0237g {
    final /* synthetic */ G this$0;

    public F(G g) {
        this.this$0 = g;
    }

    @Override // androidx.lifecycle.AbstractC0237g, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        F3.i.f(activity, "activity");
        if (Build.VERSION.SDK_INT < 29) {
            int i5 = J.f3913d;
            Fragment fragmentFindFragmentByTag = activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
            F3.i.d(fragmentFindFragmentByTag, "null cannot be cast to non-null type androidx.lifecycle.ReportFragment");
            ((J) fragmentFindFragmentByTag).f3914c = this.this$0.f3912j;
        }
    }

    @Override // androidx.lifecycle.AbstractC0237g, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        F3.i.f(activity, "activity");
        G g = this.this$0;
        int i5 = g.f3908d - 1;
        g.f3908d = i5;
        if (i5 == 0) {
            Handler handler = g.g;
            F3.i.c(handler);
            handler.postDelayed(g.f3911i, 700L);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreCreated(Activity activity, Bundle bundle) {
        F3.i.f(activity, "activity");
        D.a(activity, new E(this.this$0));
    }

    @Override // androidx.lifecycle.AbstractC0237g, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        F3.i.f(activity, "activity");
        G g = this.this$0;
        int i5 = g.f3907c - 1;
        g.f3907c = i5;
        if (i5 == 0 && g.f3909e) {
            g.h.e(EnumC0243m.ON_STOP);
            g.f3910f = true;
        }
    }
}
