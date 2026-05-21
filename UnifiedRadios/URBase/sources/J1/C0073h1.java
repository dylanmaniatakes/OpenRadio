package J1;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.PersistableBundle;
import g0.AbstractC0535a;

/* renamed from: J1.h1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0073h1 extends E {

    /* renamed from: e, reason: collision with root package name */
    public JobScheduler f1253e;

    @Override // J1.E
    public final boolean m() {
        return true;
    }

    public final void n() {
        this.f1253e = (JobScheduler) ((C0113v0) this.f84c).f1411c.getSystemService("jobscheduler");
    }

    public final int o() {
        k();
        j();
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        if (!c0113v0.f1415i.w(null, H.f780R0)) {
            return 9;
        }
        if (this.f1253e == null) {
            return 7;
        }
        Boolean boolU = c0113v0.f1415i.u("google_analytics_sgtm_upload_enabled");
        if (!(boolU == null ? false : boolU.booleanValue())) {
            return 8;
        }
        if (c0113v0.n().f914l < 119000) {
            return 6;
        }
        if (a2.h0(c0113v0.f1411c)) {
            return !c0113v0.r().w() ? 5 : 2;
        }
        return 3;
    }

    public final void p(long j5) {
        k();
        j();
        JobScheduler jobScheduler = this.f1253e;
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        if (jobScheduler != null && jobScheduler.getPendingJob("measurement-client".concat(String.valueOf(c0113v0.f1411c.getPackageName())).hashCode()) != null) {
            Z z4 = c0113v0.f1417k;
            C0113v0.k(z4);
            z4.f1084p.a("[sgtm] There's an existing pending job, skip this schedule.");
            return;
        }
        int iO = o();
        if (iO != 2) {
            Z z5 = c0113v0.f1417k;
            C0113v0.k(z5);
            z5.f1084p.b(AbstractC0535a.w(iO), "[sgtm] Not eligible for Scion upload");
            return;
        }
        Z z6 = c0113v0.f1417k;
        C0113v0.k(z6);
        z6.f1084p.b(Long.valueOf(j5), "[sgtm] Scheduling Scion upload, millis");
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("action", "com.google.android.gms.measurement.SCION_UPLOAD");
        JobInfo jobInfoBuild = new JobInfo.Builder("measurement-client".concat(String.valueOf(c0113v0.f1411c.getPackageName())).hashCode(), new ComponentName(c0113v0.f1411c, "com.google.android.gms.measurement.AppMeasurementJobService")).setRequiredNetworkType(1).setMinimumLatency(j5).setOverrideDeadline(j5 + j5).setExtras(persistableBundle).build();
        JobScheduler jobScheduler2 = this.f1253e;
        q1.E.i(jobScheduler2);
        int iSchedule = jobScheduler2.schedule(jobInfoBuild);
        Z z7 = c0113v0.f1417k;
        C0113v0.k(z7);
        z7.f1084p.b(iSchedule == 1 ? "SUCCESS" : "FAILURE", "[sgtm] Scion upload job scheduled with result");
    }
}
