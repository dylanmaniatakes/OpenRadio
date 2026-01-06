package androidx.lifecycle;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import java.util.List;
import s0.C0884a;

/* loaded from: classes.dex */
public final class ProcessLifecycleInitializer implements s0.b {
    @Override // s0.b
    public final List a() {
        return t3.q.f9711j;
    }

    @Override // s0.b
    public final Object b(Context context) {
        F3.i.f(context, "context");
        C0884a c0884aC = C0884a.c(context);
        F3.i.e(c0884aC, "getInstance(context)");
        if (!c0884aC.f9573b.contains(ProcessLifecycleInitializer.class)) {
            throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml".toString());
        }
        if (!AbstractC0247q.f3966a.getAndSet(true)) {
            Context applicationContext = context.getApplicationContext();
            F3.i.d(applicationContext, "null cannot be cast to non-null type android.app.Application");
            ((Application) applicationContext).registerActivityLifecycleCallbacks(new C0246p());
        }
        G g = G.f3906k;
        g.getClass();
        g.g = new Handler();
        g.h.e(EnumC0243m.ON_CREATE);
        Context applicationContext2 = context.getApplicationContext();
        F3.i.d(applicationContext2, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext2).registerActivityLifecycleCallbacks(new F(g));
        return g;
    }
}
