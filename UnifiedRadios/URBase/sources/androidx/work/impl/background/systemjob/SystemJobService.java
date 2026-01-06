package androidx.work.impl.background.systemjob;

import C0.t;
import C0.u;
import D0.c;
import D0.h;
import D0.n;
import D0.v;
import G0.d;
import L0.e;
import L0.i;
import L0.j;
import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Build;
import android.os.PersistableBundle;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes.dex */
public class SystemJobService extends JobService implements c {
    public static final String g = t.f("SystemJobService");

    /* renamed from: c, reason: collision with root package name */
    public v f4495c;

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f4496d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public final L0.c f4497e = new L0.c(2);

    /* renamed from: f, reason: collision with root package name */
    public e f4498f;

    public static j a(JobParameters jobParameters) {
        try {
            PersistableBundle extras = jobParameters.getExtras();
            if (extras == null || !extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return null;
            }
            return new j(extras.getString("EXTRA_WORK_SPEC_ID"), extras.getInt("EXTRA_WORK_SPEC_GENERATION"));
        } catch (NullPointerException unused) {
            return null;
        }
    }

    @Override // D0.c
    public final void e(j jVar, boolean z4) {
        JobParameters jobParameters;
        t.d().a(g, jVar.f1551a + " executed on JobScheduler");
        synchronized (this.f4496d) {
            jobParameters = (JobParameters) this.f4496d.remove(jVar);
        }
        this.f4497e.j(jVar);
        if (jobParameters != null) {
            jobFinished(jobParameters, z4);
        }
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        try {
            v vVarY = v.y(getApplicationContext());
            this.f4495c = vVarY;
            h hVar = vVarY.f305f;
            this.f4498f = new e(hVar, vVarY.f303d);
            hVar.a(this);
        } catch (IllegalStateException e5) {
            if (!Application.class.equals(getApplication().getClass())) {
                throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", e5);
            }
            t.d().g(g, "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.");
        }
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        v vVar = this.f4495c;
        if (vVar != null) {
            vVar.f305f.e(this);
        }
    }

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        if (this.f4495c == null) {
            t.d().a(g, "WorkManager is not initialized; requesting retry.");
            jobFinished(jobParameters, true);
            return false;
        }
        j jVarA = a(jobParameters);
        if (jVarA == null) {
            t.d().b(g, "WorkSpec id not found!");
            return false;
        }
        synchronized (this.f4496d) {
            try {
                if (this.f4496d.containsKey(jVarA)) {
                    t.d().a(g, "Job is already being executed by SystemJobService: " + jVarA);
                    return false;
                }
                t.d().a(g, "onStartJob for " + jVarA);
                this.f4496d.put(jVarA, jobParameters);
                u uVar = new u();
                if (G0.c.b(jobParameters) != null) {
                    Arrays.asList(G0.c.b(jobParameters));
                }
                if (G0.c.a(jobParameters) != null) {
                    Arrays.asList(G0.c.a(jobParameters));
                }
                d.a(jobParameters);
                e eVar = this.f4498f;
                ((i) eVar.f1542e).c(new F0.e((h) eVar.f1541d, this.f4497e.n(jVarA), uVar));
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        boolean zContains;
        if (this.f4495c == null) {
            t.d().a(g, "WorkManager is not initialized; requesting retry.");
            return true;
        }
        j jVarA = a(jobParameters);
        if (jVarA == null) {
            t.d().b(g, "WorkSpec id not found!");
            return false;
        }
        t.d().a(g, "onStopJob for " + jVarA);
        synchronized (this.f4496d) {
            this.f4496d.remove(jVarA);
        }
        n nVarJ = this.f4497e.j(jVarA);
        if (nVarJ != null) {
            int iA = Build.VERSION.SDK_INT >= 31 ? G0.e.a(jobParameters) : -512;
            e eVar = this.f4498f;
            eVar.getClass();
            eVar.u(nVarJ, iA);
        }
        h hVar = this.f4495c.f305f;
        String str = jVarA.f1551a;
        synchronized (hVar.f269k) {
            zContains = hVar.f267i.contains(str);
        }
        return !zContains;
    }
}
