package G2;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Logger;
import q1.E;
import z2.RunnableC0999a;

/* loaded from: classes.dex */
public final class j implements Executor {

    /* renamed from: o, reason: collision with root package name */
    public static final Logger f636o = Logger.getLogger(j.class.getName());

    /* renamed from: j, reason: collision with root package name */
    public final Executor f637j;

    /* renamed from: k, reason: collision with root package name */
    public final ArrayDeque f638k = new ArrayDeque();

    /* renamed from: l, reason: collision with root package name */
    public int f639l = 1;

    /* renamed from: m, reason: collision with root package name */
    public long f640m = 0;
    public final RunnableC0999a n = new RunnableC0999a(this);

    public j(Executor executor) {
        E.i(executor);
        this.f637j = executor;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        E.i(runnable);
        synchronized (this.f638k) {
            int i5 = this.f639l;
            if (i5 != 4 && i5 != 3) {
                long j5 = this.f640m;
                i iVar = new i(runnable, 0);
                this.f638k.add(iVar);
                this.f639l = 2;
                try {
                    this.f637j.execute(this.n);
                    if (this.f639l != 2) {
                        return;
                    }
                    synchronized (this.f638k) {
                        try {
                            if (this.f640m == j5 && this.f639l == 2) {
                                this.f639l = 3;
                            }
                        } finally {
                        }
                    }
                    return;
                } catch (Error | RuntimeException e5) {
                    synchronized (this.f638k) {
                        try {
                            int i6 = this.f639l;
                            boolean z4 = true;
                            if ((i6 != 1 && i6 != 2) || !this.f638k.removeLastOccurrence(iVar)) {
                                z4 = false;
                            }
                            if (!(e5 instanceof RejectedExecutionException) || z4) {
                                throw e5;
                            }
                        } finally {
                        }
                    }
                    return;
                }
            }
            this.f638k.add(runnable);
        }
    }

    public final String toString() {
        return "SequentialExecutor@" + System.identityHashCode(this) + "{" + this.f637j + "}";
    }
}
