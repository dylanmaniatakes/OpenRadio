package r;

import w1.AbstractC0930a;

/* loaded from: classes.dex */
public final class e extends AbstractC0930a {
    @Override // w1.AbstractC0930a
    public final boolean e(g gVar, c cVar, c cVar2) {
        synchronized (gVar) {
            try {
                if (gVar.f9501k != cVar) {
                    return false;
                }
                gVar.f9501k = cVar2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // w1.AbstractC0930a
    public final boolean f(g gVar, Object obj, Object obj2) {
        synchronized (gVar) {
            try {
                if (gVar.f9500j != obj) {
                    return false;
                }
                gVar.f9500j = obj2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // w1.AbstractC0930a
    public final boolean g(g gVar, f fVar, f fVar2) {
        synchronized (gVar) {
            try {
                if (gVar.f9502l != fVar) {
                    return false;
                }
                gVar.f9502l = fVar2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // w1.AbstractC0930a
    public final void m(f fVar, f fVar2) {
        fVar.f9496b = fVar2;
    }

    @Override // w1.AbstractC0930a
    public final void n(f fVar, Thread thread) {
        fVar.f9495a = thread;
    }
}
