package G2;

import B0.l;
import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import r.C0870a;

/* loaded from: classes.dex */
public final class h extends r.g implements ScheduledFuture {

    /* renamed from: q, reason: collision with root package name */
    public final ScheduledFuture f633q;

    public h(g gVar) {
        this.f633q = gVar.a(new l(4, this));
    }

    @Override // r.g
    public final void c() {
        ScheduledFuture scheduledFuture = this.f633q;
        Object obj = this.f9500j;
        scheduledFuture.cancel((obj instanceof C0870a) && ((C0870a) obj).f9484a);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Delayed delayed) {
        return this.f633q.compareTo(delayed);
    }

    @Override // java.util.concurrent.Delayed
    public final long getDelay(TimeUnit timeUnit) {
        return this.f633q.getDelay(timeUnit);
    }
}
