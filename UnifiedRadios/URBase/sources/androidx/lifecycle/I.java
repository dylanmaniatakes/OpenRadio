package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* loaded from: classes.dex */
public final class I implements Application.ActivityLifecycleCallbacks {
    public static final H Companion = new H();

    public static final void registerIn(Activity activity) {
        Companion.getClass();
        F3.i.f(activity, "activity");
        activity.registerActivityLifecycleCallbacks(new I());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        F3.i.f(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        F3.i.f(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        F3.i.f(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostCreated(Activity activity, Bundle bundle) {
        F3.i.f(activity, "activity");
        int i5 = J.f3913d;
        M.d(activity, EnumC0243m.ON_CREATE);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostResumed(Activity activity) {
        F3.i.f(activity, "activity");
        int i5 = J.f3913d;
        M.d(activity, EnumC0243m.ON_RESUME);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostStarted(Activity activity) {
        F3.i.f(activity, "activity");
        int i5 = J.f3913d;
        M.d(activity, EnumC0243m.ON_START);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreDestroyed(Activity activity) {
        F3.i.f(activity, "activity");
        int i5 = J.f3913d;
        M.d(activity, EnumC0243m.ON_DESTROY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPrePaused(Activity activity) {
        F3.i.f(activity, "activity");
        int i5 = J.f3913d;
        M.d(activity, EnumC0243m.ON_PAUSE);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreStopped(Activity activity) {
        F3.i.f(activity, "activity");
        int i5 = J.f3913d;
        M.d(activity, EnumC0243m.ON_STOP);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        F3.i.f(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        F3.i.f(activity, "activity");
        F3.i.f(bundle, "bundle");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        F3.i.f(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        F3.i.f(activity, "activity");
    }
}
