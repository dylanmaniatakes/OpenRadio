package U3;

import N3.AbstractC0143q;
import N3.H;
import S3.AbstractC0187a;
import S3.x;
import java.util.concurrent.Executor;
import w3.C0942j;
import w3.InterfaceC0941i;

/* loaded from: classes.dex */
public final class c extends H implements Executor {

    /* renamed from: l, reason: collision with root package name */
    public static final c f2485l = new c();

    /* renamed from: m, reason: collision with root package name */
    public static final AbstractC0143q f2486m;

    static {
        AbstractC0143q iVar = l.f2500l;
        int i5 = x.f2423a;
        if (64 >= i5) {
            i5 = 64;
        }
        int iK = AbstractC0187a.k("kotlinx.coroutines.io.parallelism", i5, 0, 0, 12);
        iVar.getClass();
        if (iK < 1) {
            throw new IllegalArgumentException(com.unified.ur1.SatelliteTracker.h.a(iK, "Expected positive parallelism level, but got ").toString());
        }
        if (iK < k.f2497d) {
            if (iK < 1) {
                throw new IllegalArgumentException(com.unified.ur1.SatelliteTracker.h.a(iK, "Expected positive parallelism level, but got ").toString());
            }
            iVar = new S3.i(iVar, iK);
        }
        f2486m = iVar;
    }

    @Override // N3.AbstractC0143q
    public final void W(InterfaceC0941i interfaceC0941i, Runnable runnable) {
        f2486m.W(interfaceC0941i, runnable);
    }

    @Override // N3.AbstractC0143q
    public final void X(InterfaceC0941i interfaceC0941i, Runnable runnable) {
        f2486m.X(interfaceC0941i, runnable);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO".toString());
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        W(C0942j.f10143j, runnable);
    }

    @Override // N3.AbstractC0143q
    public final String toString() {
        return "Dispatchers.IO";
    }
}
