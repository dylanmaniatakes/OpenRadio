package B;

import android.app.job.JobParameters;
import android.app.job.JobServiceEngine;
import android.os.AsyncTask;

/* loaded from: classes.dex */
public final class k extends JobServiceEngine {

    /* renamed from: a, reason: collision with root package name */
    public final l f49a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f50b;

    /* renamed from: c, reason: collision with root package name */
    public JobParameters f51c;

    public k(l lVar) {
        super(lVar);
        this.f50b = new Object();
        this.f49a = lVar;
    }

    @Override // android.app.job.JobServiceEngine
    public final boolean onStartJob(JobParameters jobParameters) {
        this.f51c = jobParameters;
        l lVar = this.f49a;
        if (lVar.f53d != null) {
            return true;
        }
        j jVar = new j(lVar, 0);
        lVar.f53d = jVar;
        jVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return true;
    }

    @Override // android.app.job.JobServiceEngine
    public final boolean onStopJob(JobParameters jobParameters) {
        j jVar = this.f49a.f53d;
        if (jVar != null) {
            jVar.cancel(false);
        }
        synchronized (this.f50b) {
            this.f51c = null;
        }
        return true;
    }
}
