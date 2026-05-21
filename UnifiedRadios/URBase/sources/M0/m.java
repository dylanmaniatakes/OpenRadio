package M0;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import z2.RunnableC0999a;

/* loaded from: classes.dex */
public final class m implements Executor {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f1683j;

    /* renamed from: k, reason: collision with root package name */
    public final Object f1684k;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayDeque f1685l;

    /* renamed from: m, reason: collision with root package name */
    public final Executor f1686m;
    public Runnable n;

    public m(ExecutorService executorService) {
        this.f1683j = 0;
        this.f1686m = executorService;
        this.f1685l = new ArrayDeque();
        this.f1684k = new Object();
    }

    public final void a() {
        switch (this.f1683j) {
            case 0:
                Runnable runnable = (Runnable) this.f1685l.poll();
                this.n = runnable;
                if (runnable != null) {
                    this.f1686m.execute(runnable);
                    return;
                }
                return;
            default:
                synchronized (this.f1684k) {
                    try {
                        Runnable runnable2 = (Runnable) this.f1685l.poll();
                        this.n = runnable2;
                        if (runnable2 != null) {
                            this.f1686m.execute(runnable2);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f1683j) {
            case 0:
                synchronized (this.f1684k) {
                    try {
                        this.f1685l.add(new RunnableC0999a(this, 24, runnable));
                        if (this.n == null) {
                            a();
                        }
                    } finally {
                    }
                }
                return;
            default:
                synchronized (this.f1684k) {
                    try {
                        this.f1685l.add(new D.m(this, 15, runnable));
                        if (this.n == null) {
                            a();
                        }
                    } finally {
                    }
                }
                return;
        }
    }

    public m(C2.c cVar) {
        this.f1683j = 1;
        this.f1684k = new Object();
        this.f1685l = new ArrayDeque();
        this.f1686m = cVar;
    }
}
