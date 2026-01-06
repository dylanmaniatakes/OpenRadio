package p1;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: p1.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ComponentCallbacks2C0828d implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {
    public static final ComponentCallbacks2C0828d g = new ComponentCallbacks2C0828d();

    /* renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f9108c = new AtomicBoolean();

    /* renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f9109d = new AtomicBoolean();

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f9110e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public boolean f9111f = false;

    public static void a(Application application) {
        ComponentCallbacks2C0828d componentCallbacks2C0828d = g;
        synchronized (componentCallbacks2C0828d) {
            try {
                if (!componentCallbacks2C0828d.f9111f) {
                    application.registerActivityLifecycleCallbacks(componentCallbacks2C0828d);
                    application.registerComponentCallbacks(componentCallbacks2C0828d);
                    componentCallbacks2C0828d.f9111f = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(boolean z4) {
        synchronized (g) {
            try {
                Iterator it = this.f9110e.iterator();
                while (it.hasNext()) {
                    ((InterfaceC0827c) it.next()).a(z4);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        AtomicBoolean atomicBoolean = this.f9109d;
        boolean zCompareAndSet = this.f9108c.compareAndSet(true, false);
        atomicBoolean.set(true);
        if (zCompareAndSet) {
            b(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        AtomicBoolean atomicBoolean = this.f9109d;
        boolean zCompareAndSet = this.f9108c.compareAndSet(true, false);
        atomicBoolean.set(true);
        if (zCompareAndSet) {
            b(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i5) {
        if (i5 == 20 && this.f9108c.compareAndSet(false, true)) {
            this.f9109d.set(true);
            b(true);
        }
    }
}
