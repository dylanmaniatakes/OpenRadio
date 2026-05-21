package D0;

import C0.C0001a;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.BroadcastReceiver;
import android.content.Context;
import androidx.work.impl.WorkDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import l0.AbstractC0737m;
import q0.C0847j;

/* loaded from: classes.dex */
public final class v extends android.support.v4.media.session.b {

    /* renamed from: k, reason: collision with root package name */
    public static v f297k;

    /* renamed from: l, reason: collision with root package name */
    public static v f298l;

    /* renamed from: m, reason: collision with root package name */
    public static final Object f299m;

    /* renamed from: a, reason: collision with root package name */
    public final Context f300a;

    /* renamed from: b, reason: collision with root package name */
    public final C0001a f301b;

    /* renamed from: c, reason: collision with root package name */
    public final WorkDatabase f302c;

    /* renamed from: d, reason: collision with root package name */
    public final L0.i f303d;

    /* renamed from: e, reason: collision with root package name */
    public final List f304e;

    /* renamed from: f, reason: collision with root package name */
    public final h f305f;
    public final Z2.c g;
    public boolean h = false;

    /* renamed from: i, reason: collision with root package name */
    public BroadcastReceiver.PendingResult f306i;

    /* renamed from: j, reason: collision with root package name */
    public final L0.i f307j;

    static {
        C0.t.f("WorkManagerImpl");
        f297k = null;
        f298l = null;
        f299m = new Object();
    }

    public v(Context context, final C0001a c0001a, L0.i iVar, final WorkDatabase workDatabase, final List list, h hVar, L0.i iVar2) {
        Context applicationContext = context.getApplicationContext();
        if (u.a(applicationContext)) {
            throw new IllegalStateException("Cannot initialize WorkManager in direct boot mode");
        }
        C0.t tVar = new C0.t(c0001a.g);
        synchronized (C0.t.f172b) {
            C0.t.f173c = tVar;
        }
        this.f300a = applicationContext;
        this.f303d = iVar;
        this.f302c = workDatabase;
        this.f305f = hVar;
        this.f307j = iVar2;
        this.f301b = c0001a;
        this.f304e = list;
        this.g = new Z2.c(10, workDatabase);
        final M0.m mVar = (M0.m) iVar.f1547c;
        String str = m.f280a;
        hVar.a(new c() { // from class: D0.k
            @Override // D0.c
            public final void e(L0.j jVar, boolean z4) {
                mVar.execute(new l(list, jVar, c0001a, workDatabase, 0));
            }
        });
        iVar.c(new M0.f(applicationContext, this));
    }

    public static v y(Context context) {
        v vVar;
        Object obj = f299m;
        synchronized (obj) {
            try {
                synchronized (obj) {
                    vVar = f297k;
                    if (vVar == null) {
                        vVar = f298l;
                    }
                }
                return vVar;
            } catch (Throwable th) {
                throw th;
            } finally {
            }
        }
        if (vVar != null) {
            return vVar;
        }
        context.getApplicationContext();
        throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
    }

    public final void A() {
        ArrayList arrayListE;
        String str = G0.b.h;
        Context context = this.f300a;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler != null && (arrayListE = G0.b.e(context, jobScheduler)) != null && !arrayListE.isEmpty()) {
            Iterator it = arrayListE.iterator();
            while (it.hasNext()) {
                G0.b.c(jobScheduler, ((JobInfo) it.next()).getId());
            }
        }
        WorkDatabase workDatabase = this.f302c;
        L0.q qVarV = workDatabase.v();
        AbstractC0737m abstractC0737m = qVarV.f1582a;
        abstractC0737m.b();
        L0.h hVar = qVarV.f1592m;
        C0847j c0847jA = hVar.a();
        abstractC0737m.c();
        try {
            c0847jA.c();
            abstractC0737m.o();
            abstractC0737m.k();
            hVar.n(c0847jA);
            m.b(this.f301b, workDatabase, this.f304e);
        } catch (Throwable th) {
            abstractC0737m.k();
            hVar.n(c0847jA);
            throw th;
        }
    }

    public final void z() {
        synchronized (f299m) {
            try {
                this.h = true;
                BroadcastReceiver.PendingResult pendingResult = this.f306i;
                if (pendingResult != null) {
                    pendingResult.finish();
                    this.f306i = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
