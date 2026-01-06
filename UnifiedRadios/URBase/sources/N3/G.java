package N3;

import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public abstract class G extends AbstractC0143q {

    /* renamed from: l, reason: collision with root package name */
    public long f1817l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f1818m;
    public t3.g n;

    public final void Z() {
        long j5 = this.f1817l - 4294967296L;
        this.f1817l = j5;
        if (j5 <= 0 && this.f1818m) {
            shutdown();
        }
    }

    public final void a0(A a2) {
        t3.g gVar = this.n;
        if (gVar == null) {
            gVar = new t3.g();
            this.n = gVar;
        }
        gVar.d(a2);
    }

    public abstract Thread b0();

    public final void c0(boolean z4) {
        this.f1817l = (z4 ? 4294967296L : 1L) + this.f1817l;
        if (z4) {
            return;
        }
        this.f1818m = true;
    }

    public final boolean d0() {
        return this.f1817l >= 4294967296L;
    }

    public final boolean e0() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        t3.g gVar = this.n;
        if (gVar == null) {
            return false;
        }
        A a2 = (A) (gVar.isEmpty() ? null : gVar.i());
        if (a2 == null) {
            return false;
        }
        a2.run();
        return true;
    }

    public abstract void shutdown();
}
