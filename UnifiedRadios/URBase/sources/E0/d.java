package E0;

import D.m;
import D0.n;
import F3.i;
import J1.C0072h0;
import J1.C0113v0;
import J1.H;
import J1.V1;
import L0.e;
import L0.l;
import android.content.SharedPreferences;
import android.os.Handler;
import com.google.android.gms.internal.measurement.X0;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;
import q1.E;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public long f456a;

    /* renamed from: b, reason: collision with root package name */
    public Object f457b;

    /* renamed from: c, reason: collision with root package name */
    public Object f458c;

    /* renamed from: d, reason: collision with root package name */
    public Object f459d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f460e;

    public /* synthetic */ d(V1 v12) {
        this.f460e = v12;
    }

    public void a(n nVar) {
        Runnable runnable;
        i.f(nVar, "token");
        synchronized (this.f459d) {
            runnable = (Runnable) ((LinkedHashMap) this.f460e).remove(nVar);
        }
        if (runnable != null) {
            ((Handler) ((l) this.f457b).f1554d).removeCallbacks(runnable);
        }
    }

    public void b(n nVar) {
        m mVar = new m(this, 2, nVar);
        synchronized (this.f459d) {
        }
        l lVar = (l) this.f457b;
        ((Handler) lVar.f1554d).postDelayed(mVar, this.f456a);
    }

    public boolean c(long j5, X0 x02) {
        if (((ArrayList) this.f459d) == null) {
            this.f459d = new ArrayList();
        }
        if (((ArrayList) this.f458c) == null) {
            this.f458c = new ArrayList();
        }
        if (!((ArrayList) this.f459d).isEmpty() && ((((X0) ((ArrayList) this.f459d).get(0)).s() / 1000) / 60) / 60 != ((x02.s() / 1000) / 60) / 60) {
            return false;
        }
        long jE = this.f456a + x02.e();
        V1 v12 = (V1) this.f460e;
        if (!v12.d0().w(null, H.f841q1)) {
            v12.d0();
            if (jE >= Math.max(0, ((Integer) H.f820j.a(null)).intValue())) {
                return false;
            }
        } else if (!((ArrayList) this.f459d).isEmpty()) {
            v12.d0();
            if (jE >= Math.max(0, ((Integer) H.f820j.a(null)).intValue())) {
                return false;
            }
        }
        this.f456a = jE;
        ((ArrayList) this.f459d).add(x02);
        ((ArrayList) this.f458c).add(Long.valueOf(j5));
        int size = ((ArrayList) this.f459d).size();
        v12.d0();
        return size < Math.max(1, ((Integer) H.f823k.a(null)).intValue());
    }

    public void d() {
        C0072h0 c0072h0 = (C0072h0) this.f460e;
        c0072h0.j();
        ((C0113v0) c0072h0.f84c).f1421p.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor editorEdit = c0072h0.p().edit();
        editorEdit.remove((String) this.f458c);
        editorEdit.remove((String) this.f459d);
        editorEdit.putLong((String) this.f457b, jCurrentTimeMillis);
        editorEdit.apply();
    }

    public d(l lVar, e eVar) {
        i.f(lVar, "runnableScheduler");
        long millis = TimeUnit.MINUTES.toMillis(90L);
        this.f457b = lVar;
        this.f458c = eVar;
        this.f456a = millis;
        this.f459d = new Object();
        this.f460e = new LinkedHashMap();
    }

    public /* synthetic */ d(C0072h0 c0072h0, long j5) {
        this.f460e = c0072h0;
        E.f("health_monitor");
        E.a(j5 > 0);
        this.f457b = "health_monitor:start";
        this.f458c = "health_monitor:count";
        this.f459d = "health_monitor:value";
        this.f456a = j5;
    }
}
