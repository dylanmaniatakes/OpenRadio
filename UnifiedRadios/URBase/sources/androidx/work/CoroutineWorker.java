package androidx.work;

import A2.b;
import C0.e;
import C0.f;
import C0.g;
import C0.n;
import C0.s;
import F3.i;
import M0.m;
import N0.k;
import N3.AbstractC0146u;
import N3.B;
import N3.T;
import U3.d;
import android.content.Context;
import z2.InterfaceFutureC1000b;

/* loaded from: classes.dex */
public abstract class CoroutineWorker extends s {
    public final T g;
    public final k h;

    /* renamed from: i, reason: collision with root package name */
    public final d f4477i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        i.f(context, "appContext");
        i.f(workerParameters, "params");
        this.g = AbstractC0146u.b();
        k kVar = new k();
        this.h = kVar;
        kVar.a(new e(0, this), (m) workerParameters.f4482d.f1547c);
        this.f4477i = B.f1811a;
    }

    @Override // C0.s
    public final InterfaceFutureC1000b a() {
        T tB = AbstractC0146u.b();
        d dVar = this.f4477i;
        dVar.getClass();
        S3.e eVarA = AbstractC0146u.a(b.u(dVar, tB));
        n nVar = new n(tB);
        AbstractC0146u.j(eVarA, new f(nVar, this, null));
        return nVar;
    }

    @Override // C0.s
    public final void b() {
        this.h.cancel(false);
    }

    @Override // C0.s
    public final k d() {
        d dVar = this.f4477i;
        dVar.getClass();
        AbstractC0146u.j(AbstractC0146u.a(b.u(dVar, this.g)), new g(this, null));
        return this.h;
    }

    public abstract Object f();
}
