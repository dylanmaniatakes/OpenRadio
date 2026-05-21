package androidx.emoji2.text;

import J1.V0;
import android.os.Looper;
import java.util.concurrent.Executor;
import q1.E;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final Object f3600a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Object f3601b;

    /* renamed from: c, reason: collision with root package name */
    public volatile Object f3602c;

    public e(Looper looper, Object obj, String str) {
        this.f3600a = new V0(looper);
        E.j(obj, "Listener must not be null");
        this.f3601b = obj;
        E.f(str);
        this.f3602c = new p1.l(obj, str);
    }

    public void a() {
        this.f3601b = null;
        this.f3602c = null;
    }

    public void b(p1.m mVar) {
        ((Executor) this.f3600a).execute(new N1.p(10, this, mVar, false));
    }

    public e(Object obj, String str, Executor executor) {
        E.j(executor, "Executor must not be null");
        this.f3600a = executor;
        E.j(obj, "Listener must not be null");
        this.f3601b = obj;
        E.f(str);
        this.f3602c = new p1.l(obj, str);
    }

    public e(j jVar) {
        this.f3600a = jVar;
    }
}
