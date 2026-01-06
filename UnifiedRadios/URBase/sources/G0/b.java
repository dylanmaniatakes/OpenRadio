package G0;

import C0.C0001a;
import C0.t;
import D0.j;
import L0.g;
import L0.h;
import L0.i;
import L0.l;
import L0.o;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemjob.SystemJobService;
import com.google.android.gms.internal.measurement.AbstractC0409x1;
import g0.AbstractC0535a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Callable;
import l0.AbstractC0737m;
import q0.C0847j;
import s.AbstractC0882e;

/* loaded from: classes.dex */
public final class b implements j {
    public static final String h = t.f("SystemJobScheduler");

    /* renamed from: c, reason: collision with root package name */
    public final Context f607c;

    /* renamed from: d, reason: collision with root package name */
    public final JobScheduler f608d;

    /* renamed from: e, reason: collision with root package name */
    public final a f609e;

    /* renamed from: f, reason: collision with root package name */
    public final WorkDatabase f610f;
    public final C0001a g;

    public b(Context context, WorkDatabase workDatabase, C0001a c0001a) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        a aVar = new a(context, c0001a.f132c);
        this.f607c = context;
        this.f608d = jobScheduler;
        this.f609e = aVar;
        this.f610f = workDatabase;
        this.g = c0001a;
    }

    public static void c(JobScheduler jobScheduler, int i5) {
        try {
            jobScheduler.cancel(i5);
        } catch (Throwable th) {
            t.d().c(h, String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", Integer.valueOf(i5)), th);
        }
    }

    public static ArrayList e(Context context, JobScheduler jobScheduler) {
        List<JobInfo> allPendingJobs;
        try {
            allPendingJobs = jobScheduler.getAllPendingJobs();
        } catch (Throwable th) {
            t.d().c(h, "getAllPendingJobs() is not reliable on this device.", th);
            allPendingJobs = null;
        }
        if (allPendingJobs == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(allPendingJobs.size());
        ComponentName componentName = new ComponentName(context, (Class<?>) SystemJobService.class);
        for (JobInfo jobInfo : allPendingJobs) {
            if (componentName.equals(jobInfo.getService())) {
                arrayList.add(jobInfo);
            }
        }
        return arrayList;
    }

    public static L0.j f(JobInfo jobInfo) {
        PersistableBundle extras = jobInfo.getExtras();
        if (extras == null) {
            return null;
        }
        try {
            if (!extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return null;
            }
            return new L0.j(extras.getString("EXTRA_WORK_SPEC_ID"), extras.getInt("EXTRA_WORK_SPEC_GENERATION", 0));
        } catch (NullPointerException unused) {
            return null;
        }
    }

    @Override // D0.j
    public final void a(String str) {
        ArrayList arrayList;
        Context context = this.f607c;
        JobScheduler jobScheduler = this.f608d;
        ArrayList arrayListE = e(context, jobScheduler);
        if (arrayListE == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList(2);
            Iterator it = arrayListE.iterator();
            while (it.hasNext()) {
                JobInfo jobInfo = (JobInfo) it.next();
                L0.j jVarF = f(jobInfo);
                if (jVarF != null && str.equals(jVarF.f1551a)) {
                    arrayList2.add(Integer.valueOf(jobInfo.getId()));
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            c(jobScheduler, ((Integer) it2.next()).intValue());
        }
        i iVarS = this.f610f.s();
        AbstractC0737m abstractC0737m = (AbstractC0737m) iVarS.f1547c;
        abstractC0737m.b();
        h hVar = (h) iVarS.f1550f;
        C0847j c0847jA = hVar.a();
        if (str == null) {
            c0847jA.t(1);
        } else {
            c0847jA.h(1, str);
        }
        abstractC0737m.c();
        try {
            c0847jA.c();
            abstractC0737m.o();
        } finally {
            abstractC0737m.k();
            hVar.n(c0847jA);
        }
    }

    @Override // D0.j
    public final boolean b() {
        return true;
    }

    @Override // D0.j
    public final void d(o... oVarArr) {
        int iIntValue;
        C0001a c0001a = this.g;
        WorkDatabase workDatabase = this.f610f;
        final l lVar = new l(workDatabase);
        for (o oVar : oVarArr) {
            workDatabase.c();
            try {
                o oVarH = workDatabase.v().h(oVar.f1561a);
                String str = h;
                String str2 = oVar.f1561a;
                if (oVarH == null) {
                    t.d().g(str, "Skipping scheduling " + str2 + " because it's no longer in the DB");
                    workDatabase.o();
                } else if (oVarH.f1562b != 1) {
                    t.d().g(str, "Skipping scheduling " + str2 + " because it is no longer enqueued");
                    workDatabase.o();
                } else {
                    L0.j jVarD = AbstractC0409x1.d(oVar);
                    g gVarG = workDatabase.s().g(jVarD);
                    if (gVarG != null) {
                        iIntValue = gVarG.f1545c;
                    } else {
                        c0001a.getClass();
                        final int i5 = c0001a.h;
                        Object objN = ((WorkDatabase) lVar.f1554d).n(new Callable() { // from class: M0.g

                            /* renamed from: b, reason: collision with root package name */
                            public final /* synthetic */ int f1679b = 0;

                            @Override // java.util.concurrent.Callable
                            public final Object call() {
                                L0.l lVar2 = lVar;
                                F3.i.f(lVar2, "this$0");
                                WorkDatabase workDatabase2 = (WorkDatabase) lVar2.f1554d;
                                Long lJ = workDatabase2.r().j("next_job_scheduler_id");
                                int iLongValue = lJ != null ? (int) lJ.longValue() : 0;
                                workDatabase2.r().m(new L0.d("next_job_scheduler_id", Long.valueOf(iLongValue != Integer.MAX_VALUE ? iLongValue + 1 : 0)));
                                int i6 = this.f1679b;
                                if (i6 > iLongValue || iLongValue > i5) {
                                    workDatabase2.r().m(new L0.d("next_job_scheduler_id", Long.valueOf(i6 + 1)));
                                    iLongValue = i6;
                                }
                                return Integer.valueOf(iLongValue);
                            }
                        });
                        F3.i.e(objN, "workDatabase.runInTransa…            id\n        })");
                        iIntValue = ((Number) objN).intValue();
                    }
                    if (gVarG == null) {
                        workDatabase.s().h(new g(jVarD.f1551a, jVarD.f1552b, iIntValue));
                    }
                    g(oVar, iIntValue);
                    workDatabase.o();
                }
            } finally {
                workDatabase.k();
            }
        }
    }

    public final void g(o oVar, int i5) {
        int i6;
        JobScheduler jobScheduler = this.f608d;
        a aVar = this.f609e;
        aVar.getClass();
        C0.d dVar = oVar.f1568j;
        PersistableBundle persistableBundle = new PersistableBundle();
        String str = oVar.f1561a;
        persistableBundle.putString("EXTRA_WORK_SPEC_ID", str);
        persistableBundle.putInt("EXTRA_WORK_SPEC_GENERATION", oVar.f1577t);
        persistableBundle.putBoolean("EXTRA_IS_PERIODIC", oVar.c());
        JobInfo.Builder requiresCharging = new JobInfo.Builder(i5, aVar.f605a).setRequiresCharging(dVar.f144b);
        boolean z4 = dVar.f145c;
        JobInfo.Builder extras = requiresCharging.setRequiresDeviceIdle(z4).setExtras(persistableBundle);
        int i7 = Build.VERSION.SDK_INT;
        int i8 = dVar.f143a;
        if (i7 < 30 || i8 != 6) {
            int iC = AbstractC0882e.c(i8);
            if (iC == 0) {
                i6 = 0;
            } else if (iC == 1) {
                i6 = 1;
            } else if (iC != 2) {
                i6 = 3;
                if (iC != 3) {
                    i6 = 4;
                    if (iC != 4) {
                        t.d().a(a.f604c, "API version too low. Cannot convert network type value ".concat(AbstractC0535a.x(i8)));
                        i6 = 1;
                    }
                }
            } else {
                i6 = 2;
            }
            extras.setRequiredNetworkType(i6);
        } else {
            extras.setRequiredNetwork(new NetworkRequest.Builder().addCapability(25).build());
        }
        if (!z4) {
            extras.setBackoffCriteria(oVar.f1571m, oVar.f1570l == 2 ? 0 : 1);
        }
        long jA = oVar.a();
        aVar.f606b.getClass();
        long jMax = Math.max(jA - System.currentTimeMillis(), 0L);
        if (i7 <= 28 || jMax > 0) {
            extras.setMinimumLatency(jMax);
        } else if (!oVar.f1574q) {
            extras.setImportantWhileForeground(true);
        }
        Set<C0.c> set = dVar.h;
        if (!set.isEmpty()) {
            for (C0.c cVar : set) {
                extras.addTriggerContentUri(new JobInfo.TriggerContentUri(cVar.f140a, cVar.f141b ? 1 : 0));
            }
            extras.setTriggerContentUpdateDelay(dVar.f148f);
            extras.setTriggerContentMaxDelay(dVar.g);
        }
        extras.setPersisted(false);
        int i9 = Build.VERSION.SDK_INT;
        extras.setRequiresBatteryNotLow(dVar.f146d);
        extras.setRequiresStorageNotLow(dVar.f147e);
        boolean z5 = oVar.f1569k > 0;
        boolean z6 = jMax > 0;
        if (i9 >= 31 && oVar.f1574q && !z5 && !z6) {
            extras.setExpedited(true);
        }
        JobInfo jobInfoBuild = extras.build();
        String str2 = h;
        t.d().a(str2, "Scheduling work ID " + str + "Job ID " + i5);
        try {
            if (jobScheduler.schedule(jobInfoBuild) == 0) {
                t.d().g(str2, "Unable to schedule work ID " + str);
                if (oVar.f1574q && oVar.f1575r == 1) {
                    oVar.f1574q = false;
                    t.d().a(str2, "Scheduling a non-expedited job (work ID " + str + ")");
                    g(oVar, i5);
                }
            }
        } catch (IllegalStateException e5) {
            ArrayList arrayListE = e(this.f607c, jobScheduler);
            String str3 = String.format(Locale.getDefault(), "JobScheduler 100 job limit exceeded.  We count %d WorkManager jobs in JobScheduler; we have %d tracked jobs in our DB; our Configuration limit is %d.", Integer.valueOf(arrayListE != null ? arrayListE.size() : 0), Integer.valueOf(this.f610f.v().e().size()), Integer.valueOf(this.g.f137j));
            t.d().b(str2, str3);
            throw new IllegalStateException(str3, e5);
        } catch (Throwable th) {
            t.d().c(str2, "Unable to schedule " + oVar, th);
        }
    }
}
