package J1;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* renamed from: J1.q0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0099q0 extends FutureTask implements Comparable {

    /* renamed from: j, reason: collision with root package name */
    public final long f1352j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f1353k;

    /* renamed from: l, reason: collision with root package name */
    public final String f1354l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ C0104s0 f1355m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0099q0(C0104s0 c0104s0, Runnable runnable, boolean z4, String str) {
        super(runnable, null);
        this.f1355m = c0104s0;
        long andIncrement = C0104s0.f1378m.getAndIncrement();
        this.f1352j = andIncrement;
        this.f1354l = str;
        this.f1353k = z4;
        if (andIncrement == Long.MAX_VALUE) {
            Z z5 = ((C0113v0) c0104s0.f84c).f1417k;
            C0113v0.k(z5);
            z5.h.a("Tasks index overflow");
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        C0099q0 c0099q0 = (C0099q0) obj;
        boolean z4 = c0099q0.f1353k;
        boolean z5 = this.f1353k;
        if (z5 == z4) {
            long j5 = c0099q0.f1352j;
            long j6 = this.f1352j;
            if (j6 < j5) {
                return -1;
            }
            if (j6 <= j5) {
                Z z6 = ((C0113v0) this.f1355m.f84c).f1417k;
                C0113v0.k(z6);
                z6.f1078i.b(Long.valueOf(j6), "Two tasks share the same index. index");
                return 0;
            }
        } else if (z5) {
            return -1;
        }
        return 1;
    }

    @Override // java.util.concurrent.FutureTask
    public final void setException(Throwable th) {
        Z z4 = ((C0113v0) this.f1355m.f84c).f1417k;
        C0113v0.k(z4);
        z4.h.b(th, this.f1354l);
        super.setException(th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0099q0(C0104s0 c0104s0, Callable callable, boolean z4) {
        super(callable);
        this.f1355m = c0104s0;
        long andIncrement = C0104s0.f1378m.getAndIncrement();
        this.f1352j = andIncrement;
        this.f1354l = "Task exception on worker thread";
        this.f1353k = z4;
        if (andIncrement == Long.MAX_VALUE) {
            Z z5 = ((C0113v0) c0104s0.f84c).f1417k;
            C0113v0.k(z5);
            z5.h.a("Tasks index overflow");
        }
    }
}
