package N0;

import h4.r;

/* loaded from: classes.dex */
public final class g extends r {
    @Override // h4.r
    public final boolean a(i iVar, d dVar, d dVar2) {
        synchronized (iVar) {
            try {
                if (iVar.f1784k != dVar) {
                    return false;
                }
                iVar.f1784k = dVar2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // h4.r
    public final boolean b(i iVar, Object obj, Object obj2) {
        synchronized (iVar) {
            try {
                if (iVar.f1783j != obj) {
                    return false;
                }
                iVar.f1783j = obj2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // h4.r
    public final boolean c(i iVar, h hVar, h hVar2) {
        synchronized (iVar) {
            try {
                if (iVar.f1785l != hVar) {
                    return false;
                }
                iVar.f1785l = hVar2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // h4.r
    public final void m(h hVar, h hVar2) {
        hVar.f1779b = hVar2;
    }

    @Override // h4.r
    public final void n(h hVar, Thread thread) {
        hVar.f1778a = thread;
    }
}
