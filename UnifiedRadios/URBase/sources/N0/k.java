package N0;

import z2.InterfaceFutureC1000b;

/* loaded from: classes.dex */
public final class k extends i {
    public final boolean j(Object obj) {
        if (obj == null) {
            obj = i.f1782p;
        }
        if (!i.f1781o.b(this, null, obj)) {
            return false;
        }
        i.c(this);
        return true;
    }

    public final boolean k(Throwable th) {
        if (!i.f1781o.b(this, null, new c(th))) {
            return false;
        }
        i.c(this);
        return true;
    }

    public final boolean l(InterfaceFutureC1000b interfaceFutureC1000b) {
        c cVar;
        interfaceFutureC1000b.getClass();
        Object obj = this.f1783j;
        if (obj == null) {
            if (interfaceFutureC1000b.isDone()) {
                if (!i.f1781o.b(this, null, i.f(interfaceFutureC1000b))) {
                    return false;
                }
                i.c(this);
            } else {
                f fVar = new f(this, interfaceFutureC1000b);
                if (i.f1781o.b(this, null, fVar)) {
                    try {
                        interfaceFutureC1000b.a(fVar, j.f1786j);
                    } catch (Throwable th) {
                        try {
                            cVar = new c(th);
                        } catch (Throwable unused) {
                            cVar = c.f1764b;
                        }
                        i.f1781o.b(this, fVar, cVar);
                    }
                } else {
                    obj = this.f1783j;
                }
            }
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        interfaceFutureC1000b.cancel(((a) obj).f1761a);
        return false;
    }
}
