package N1;

import com.google.android.gms.internal.measurement.C1;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import q1.E;

/* loaded from: classes.dex */
public final class r extends j {

    /* renamed from: a, reason: collision with root package name */
    public final Object f1804a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final C1 f1805b = new C1(1);

    /* renamed from: c, reason: collision with root package name */
    public boolean f1806c;

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f1807d;

    /* renamed from: e, reason: collision with root package name */
    public Object f1808e;

    /* renamed from: f, reason: collision with root package name */
    public Exception f1809f;

    @Override // N1.j
    public final r a(Executor executor, f fVar) {
        this.f1805b.g(new o(executor, fVar));
        p();
        return this;
    }

    @Override // N1.j
    public final r b(Executor executor, g gVar) {
        this.f1805b.g(new o(executor, gVar));
        p();
        return this;
    }

    @Override // N1.j
    public final Exception c() {
        Exception exc;
        synchronized (this.f1804a) {
            exc = this.f1809f;
        }
        return exc;
    }

    @Override // N1.j
    public final Object d() {
        Object obj;
        synchronized (this.f1804a) {
            try {
                E.k("Task is not yet complete", this.f1806c);
                if (this.f1807d) {
                    throw new CancellationException("Task is already canceled.");
                }
                Exception exc = this.f1809f;
                if (exc != null) {
                    throw new h(exc);
                }
                obj = this.f1808e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    @Override // N1.j
    public final boolean e() {
        boolean z4;
        synchronized (this.f1804a) {
            z4 = this.f1806c;
        }
        return z4;
    }

    @Override // N1.j
    public final boolean f() {
        boolean z4;
        synchronized (this.f1804a) {
            try {
                z4 = false;
                if (this.f1806c && !this.f1807d && this.f1809f == null) {
                    z4 = true;
                }
            } finally {
            }
        }
        return z4;
    }

    public final r g(e eVar) {
        this.f1805b.g(new o(l.f1790a, eVar));
        p();
        return this;
    }

    public final r h(Executor executor, e eVar) {
        this.f1805b.g(new o(executor, eVar));
        p();
        return this;
    }

    public final r i(Executor executor, b bVar) {
        r rVar = new r();
        this.f1805b.g(new n(executor, bVar, rVar, 0));
        p();
        return rVar;
    }

    public final r j(Executor executor, b bVar) {
        r rVar = new r();
        this.f1805b.g(new n(executor, bVar, rVar, 1));
        p();
        return rVar;
    }

    public final r k(Executor executor, i iVar) {
        r rVar = new r();
        this.f1805b.g(new o(executor, iVar, rVar));
        p();
        return rVar;
    }

    public final void l(Exception exc) {
        E.j(exc, "Exception must not be null");
        synchronized (this.f1804a) {
            o();
            this.f1806c = true;
            this.f1809f = exc;
        }
        this.f1805b.h(this);
    }

    public final void m(Object obj) {
        synchronized (this.f1804a) {
            o();
            this.f1806c = true;
            this.f1808e = obj;
        }
        this.f1805b.h(this);
    }

    public final void n() {
        synchronized (this.f1804a) {
            try {
                if (this.f1806c) {
                    return;
                }
                this.f1806c = true;
                this.f1807d = true;
                this.f1805b.h(this);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void o() {
        if (this.f1806c) {
            int i5 = c.f1788j;
            if (!e()) {
                throw new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
            }
            Exception excC = c();
        }
    }

    public final void p() {
        synchronized (this.f1804a) {
            try {
                if (this.f1806c) {
                    this.f1805b.h(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
