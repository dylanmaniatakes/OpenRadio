package J1;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobScheduler;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes.dex */
public final class L1 extends Q1 {

    /* renamed from: f, reason: collision with root package name */
    public final AlarmManager f893f;
    public E1 g;
    public Integer h;

    public L1(V1 v12) {
        super(v12);
        this.f893f = (AlarmManager) ((C0113v0) this.f84c).f1411c.getSystemService("alarm");
    }

    @Override // J1.Q1
    public final void m() {
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        AlarmManager alarmManager = this.f893f;
        if (alarmManager != null) {
            Context context = c0113v0.f1411c;
            alarmManager.cancel(PendingIntent.getBroadcast(context, 0, new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), com.google.android.gms.internal.measurement.F.f4684a));
        }
        JobScheduler jobScheduler = (JobScheduler) c0113v0.f1411c.getSystemService("jobscheduler");
        if (jobScheduler != null) {
            jobScheduler.cancel(o());
        }
    }

    public final void n() {
        k();
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        Z z4 = c0113v0.f1417k;
        C0113v0.k(z4);
        z4.f1084p.a("Unscheduling upload");
        AlarmManager alarmManager = this.f893f;
        if (alarmManager != null) {
            Context context = c0113v0.f1411c;
            alarmManager.cancel(PendingIntent.getBroadcast(context, 0, new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), com.google.android.gms.internal.measurement.F.f4684a));
        }
        p().a();
        JobScheduler jobScheduler = (JobScheduler) c0113v0.f1411c.getSystemService("jobscheduler");
        if (jobScheduler != null) {
            jobScheduler.cancel(o());
        }
    }

    public final int o() {
        if (this.h == null) {
            this.h = Integer.valueOf("measurement".concat(String.valueOf(((C0113v0) this.f84c).f1411c.getPackageName())).hashCode());
        }
        return this.h.intValue();
    }

    public final AbstractC0092o p() {
        if (this.g == null) {
            this.g = new E1(this, this.f902d.n, 1);
        }
        return this.g;
    }
}
