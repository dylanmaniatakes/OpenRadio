package androidx.work.impl.workers;

import C0.s;
import C0.t;
import F3.i;
import H0.b;
import H0.c;
import H0.e;
import L0.o;
import N0.k;
import P0.a;
import android.content.Context;
import android.os.Build;
import androidx.work.WorkerParameters;

/* loaded from: classes.dex */
public final class ConstraintTrackingWorker extends s implements e {
    public final WorkerParameters g;
    public final Object h;

    /* renamed from: i, reason: collision with root package name */
    public volatile boolean f4504i;

    /* renamed from: j, reason: collision with root package name */
    public final k f4505j;

    /* renamed from: k, reason: collision with root package name */
    public s f4506k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstraintTrackingWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        i.f(context, "appContext");
        i.f(workerParameters, "workerParameters");
        this.g = workerParameters;
        this.h = new Object();
        this.f4505j = new k();
    }

    @Override // C0.s
    public final void b() {
        s sVar = this.f4506k;
        if (sVar == null || sVar.f170e != -256) {
            return;
        }
        sVar.e(Build.VERSION.SDK_INT >= 31 ? this.f170e : 0);
    }

    @Override // H0.e
    public final void c(o oVar, c cVar) {
        i.f(oVar, "workSpec");
        i.f(cVar, "state");
        t.d().a(a.f2062a, "Constraints changed for " + oVar);
        if (cVar instanceof b) {
            synchronized (this.h) {
                this.f4504i = true;
            }
        }
    }

    @Override // C0.s
    public final k d() {
        this.f169d.f4481c.execute(new C0.e(2, this));
        k kVar = this.f4505j;
        i.e(kVar, "future");
        return kVar;
    }
}
