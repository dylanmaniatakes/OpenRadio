package androidx.work.impl.workers;

import C0.q;
import C0.r;
import F3.i;
import android.content.Context;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

/* loaded from: classes.dex */
public final class CombineContinuationsWorker extends Worker {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CombineContinuationsWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        i.f(context, "context");
        i.f(workerParameters, "workerParams");
    }

    @Override // androidx.work.Worker
    public final r f() {
        return new q(this.f169d.f4480b);
    }
}
