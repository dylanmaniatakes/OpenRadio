package p1;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Looper;
import java.util.concurrent.atomic.AtomicReference;
import n1.C0785b;
import n1.C0788e;

/* loaded from: classes.dex */
public final class q implements DialogInterface.OnCancelListener {

    /* renamed from: c, reason: collision with root package name */
    public final k f9130c;

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f9131d;

    /* renamed from: e, reason: collision with root package name */
    public final AtomicReference f9132e;

    /* renamed from: f, reason: collision with root package name */
    public final A1.f f9133f;
    public final C0788e g;
    public final q.c h;

    /* renamed from: i, reason: collision with root package name */
    public final C0832h f9134i;

    public q(k kVar, C0832h c0832h) {
        C0788e c0788e = C0788e.f8738d;
        this.f9130c = kVar;
        this.f9132e = new AtomicReference(null);
        this.f9133f = new A1.f(Looper.getMainLooper(), 0);
        this.g = c0788e;
        this.h = new q.c(0);
        this.f9134i = c0832h;
        kVar.a(this);
    }

    public final Activity a() {
        Activity activityC = this.f9130c.c();
        q1.E.i(activityC);
        return activityC;
    }

    public final void b(Bundle bundle) {
        if (bundle != null) {
            this.f9132e.set(bundle.getBoolean("resolving_error", false) ? new G(new C0785b(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    public final void c() {
        this.f9131d = false;
        C0832h c0832h = this.f9134i;
        c0832h.getClass();
        synchronized (C0832h.f9114r) {
            try {
                if (c0832h.f9124k == this) {
                    c0832h.f9124k = null;
                    c0832h.f9125l.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d() {
        if (this.h.isEmpty()) {
            return;
        }
        this.f9134i.a(this);
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        C0785b c0785b = new C0785b(13, null);
        AtomicReference atomicReference = this.f9132e;
        G g = (G) atomicReference.get();
        int i5 = g == null ? -1 : g.f9098a;
        atomicReference.set(null);
        this.f9134i.h(c0785b, i5);
    }
}
