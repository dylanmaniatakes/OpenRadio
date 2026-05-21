package Q0;

import android.os.Handler;
import android.os.Looper;
import f3.C0519j;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicInteger f2149a;

    /* renamed from: b, reason: collision with root package name */
    public final HashSet f2150b;

    /* renamed from: c, reason: collision with root package name */
    public final PriorityBlockingQueue f2151c;

    /* renamed from: d, reason: collision with root package name */
    public final PriorityBlockingQueue f2152d;

    /* renamed from: e, reason: collision with root package name */
    public final R0.d f2153e;

    /* renamed from: f, reason: collision with root package name */
    public final L0.e f2154f;
    public final C0519j g;
    public final g[] h;

    /* renamed from: i, reason: collision with root package name */
    public c f2155i;

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f2156j;

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f2157k;

    public i(R0.d dVar, L0.e eVar) {
        C0519j c0519j = new C0519j(new Handler(Looper.getMainLooper()));
        this.f2149a = new AtomicInteger();
        this.f2150b = new HashSet();
        this.f2151c = new PriorityBlockingQueue();
        this.f2152d = new PriorityBlockingQueue();
        this.f2156j = new ArrayList();
        this.f2157k = new ArrayList();
        this.f2153e = dVar;
        this.f2154f = eVar;
        this.h = new g[4];
        this.g = c0519j;
    }

    public final void a(R0.f fVar) {
        fVar.f2219q = this;
        synchronized (this.f2150b) {
            this.f2150b.add(fVar);
        }
        fVar.f2218p = Integer.valueOf(this.f2149a.incrementAndGet());
        fVar.a("add-to-queue");
        b();
        if (fVar.f2220r) {
            this.f2151c.add(fVar);
        } else {
            this.f2152d.add(fVar);
        }
    }

    public final void b() {
        synchronized (this.f2157k) {
            try {
                Iterator it = this.f2157k.iterator();
                if (it.hasNext()) {
                    com.unified.ur1.SatelliteTracker.h.p(it.next());
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
