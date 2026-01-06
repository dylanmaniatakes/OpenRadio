package N1;

import q1.E;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final r f1789a = new r();

    public final void a(Object obj) {
        this.f1789a.m(obj);
    }

    public final boolean b(Exception exc) {
        r rVar = this.f1789a;
        rVar.getClass();
        E.j(exc, "Exception must not be null");
        synchronized (rVar.f1804a) {
            try {
                if (rVar.f1806c) {
                    return false;
                }
                rVar.f1806c = true;
                rVar.f1809f = exc;
                rVar.f1805b.h(rVar);
                return true;
            } finally {
            }
        }
    }

    public final void c(Object obj) {
        r rVar = this.f1789a;
        synchronized (rVar.f1804a) {
            try {
                if (rVar.f1806c) {
                    return;
                }
                rVar.f1806c = true;
                rVar.f1808e = obj;
                rVar.f1805b.h(rVar);
            } finally {
            }
        }
    }
}
