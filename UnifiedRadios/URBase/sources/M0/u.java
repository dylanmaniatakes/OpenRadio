package M0;

/* loaded from: classes.dex */
public final class u implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final v f1703j;

    /* renamed from: k, reason: collision with root package name */
    public final L0.j f1704k;

    public u(v vVar, L0.j jVar) {
        this.f1703j = vVar;
        this.f1704k = jVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f1703j.f1709d) {
            try {
                if (((u) this.f1703j.f1707b.remove(this.f1704k)) != null) {
                    t tVar = (t) this.f1703j.f1708c.remove(this.f1704k);
                    if (tVar != null) {
                        L0.j jVar = this.f1704k;
                        F0.h hVar = (F0.h) tVar;
                        C0.t.d().a(F0.h.f509q, "Exceeded time limits on execution for " + jVar);
                        hVar.f515j.execute(new F0.g(hVar, 0));
                    }
                } else {
                    C0.t.d().a("WrkTimerRunnable", "Timer with " + this.f1704k + " is already marked as complete.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
