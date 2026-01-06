package q1;

import android.app.PendingIntent;
import android.os.Bundle;
import n1.C0785b;

/* loaded from: classes.dex */
public abstract class y {

    /* renamed from: a, reason: collision with root package name */
    public Object f9426a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f9427b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AbstractC0854e f9428c;

    /* renamed from: d, reason: collision with root package name */
    public final int f9429d;

    /* renamed from: e, reason: collision with root package name */
    public final Bundle f9430e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ AbstractC0854e f9431f;

    public y(AbstractC0854e abstractC0854e, int i5, Bundle bundle) {
        this.f9431f = abstractC0854e;
        Boolean bool = Boolean.TRUE;
        this.f9428c = abstractC0854e;
        this.f9426a = bool;
        this.f9427b = false;
        this.f9429d = i5;
        this.f9430e = bundle;
    }

    public final /* bridge */ void a(Boolean bool) {
        AbstractC0854e abstractC0854e = this.f9431f;
        int i5 = this.f9429d;
        if (i5 != 0) {
            abstractC0854e.A(1, null);
            Bundle bundle = this.f9430e;
            b(new C0785b(i5, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null));
        } else {
            if (c()) {
                return;
            }
            abstractC0854e.A(1, null);
            b(new C0785b(8, null));
        }
    }

    public abstract void b(C0785b c0785b);

    public abstract boolean c();

    public final void d() {
        synchronized (this) {
            this.f9426a = null;
        }
        synchronized (this.f9428c.f9355l) {
            this.f9428c.f9355l.remove(this);
        }
    }
}
