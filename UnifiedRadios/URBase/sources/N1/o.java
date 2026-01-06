package N1;

import C0.A;
import java.util.concurrent.Executor;
import z2.RunnableC0999a;

/* loaded from: classes.dex */
public final class o implements q, g, f, d {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1797c;

    /* renamed from: d, reason: collision with root package name */
    public final Executor f1798d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f1799e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f1800f;

    public o(C2.c cVar, d dVar) {
        this.f1797c = 0;
        this.f1799e = new Object();
        this.f1798d = cVar;
        this.f1800f = dVar;
    }

    @Override // N1.q
    public final void a(j jVar) {
        switch (this.f1797c) {
            case 0:
                if (((r) jVar).f1807d) {
                    synchronized (this.f1799e) {
                        try {
                            if (((d) this.f1800f) != null) {
                                this.f1798d.execute(new A(9, this));
                            }
                        } finally {
                        }
                    }
                    return;
                }
                return;
            case 1:
                synchronized (this.f1799e) {
                    try {
                        if (((e) this.f1800f) == null) {
                            return;
                        }
                        this.f1798d.execute(new RunnableC0999a(28, this, jVar, false));
                        return;
                    } finally {
                    }
                }
            case 2:
                if (jVar.f() || ((r) jVar).f1807d) {
                    return;
                }
                synchronized (this.f1799e) {
                    try {
                        if (((f) this.f1800f) != null) {
                            this.f1798d.execute(new RunnableC0999a(29, this, jVar, false));
                        }
                    } finally {
                    }
                }
                return;
            case 3:
                if (jVar.f()) {
                    synchronized (this.f1799e) {
                        try {
                            if (((g) this.f1800f) != null) {
                                this.f1798d.execute(new p(this, 0, jVar));
                            }
                        } finally {
                        }
                    }
                    return;
                }
                return;
            default:
                this.f1798d.execute(new p(this, 1, jVar));
                return;
        }
    }

    @Override // N1.d
    public void b() {
        ((r) this.f1800f).n();
    }

    @Override // N1.f
    public void d(Exception exc) {
        ((r) this.f1800f).l(exc);
    }

    @Override // N1.g
    public void h(Object obj) {
        ((r) this.f1800f).m(obj);
    }

    public o(Executor executor, e eVar) {
        this.f1797c = 1;
        this.f1799e = new Object();
        this.f1798d = executor;
        this.f1800f = eVar;
    }

    public o(Executor executor, f fVar) {
        this.f1797c = 2;
        this.f1799e = new Object();
        this.f1798d = executor;
        this.f1800f = fVar;
    }

    public o(Executor executor, g gVar) {
        this.f1797c = 3;
        this.f1799e = new Object();
        this.f1798d = executor;
        this.f1800f = gVar;
    }

    public o(Executor executor, i iVar, r rVar) {
        this.f1797c = 4;
        this.f1798d = executor;
        this.f1799e = iVar;
        this.f1800f = rVar;
    }
}
