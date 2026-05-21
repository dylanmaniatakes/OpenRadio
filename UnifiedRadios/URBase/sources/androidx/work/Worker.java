package androidx.work;

import C0.A;
import C0.r;
import C0.s;
import N0.k;
import android.content.Context;
import z2.InterfaceFutureC1000b;
import z2.RunnableC0999a;

/* loaded from: classes.dex */
public abstract class Worker extends s {
    public k g;

    public Worker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    @Override // C0.s
    public final InterfaceFutureC1000b a() {
        k kVar = new k();
        this.f169d.f4481c.execute(new RunnableC0999a(1, this, kVar, false));
        return kVar;
    }

    @Override // C0.s
    public final k d() {
        this.g = new k();
        this.f169d.f4481c.execute(new A(0, this));
        return this.g;
    }

    public abstract r f();
}
