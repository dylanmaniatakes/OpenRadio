package X2;

import android.content.Intent;
import android.os.Binder;
import android.os.Process;
import android.util.Log;
import i0.ExecutorC0566c;

/* loaded from: classes.dex */
public final class D extends Binder {

    /* renamed from: c, reason: collision with root package name */
    public final Z2.c f2767c;

    public D(Z2.c cVar) {
        this.f2767c = cVar;
    }

    public final void a(E e5) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException("Binding only allowed within app");
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "service received new intent via bind strategy");
        }
        Intent intent = e5.f2768a;
        g gVar = (g) this.f2767c.f3147d;
        gVar.getClass();
        N1.k kVar = new N1.k();
        gVar.f2797c.execute(new D0.f(gVar, intent, kVar, 1));
        kVar.f1789a.h(new ExecutorC0566c(0), new D0.p(6, e5));
    }
}
