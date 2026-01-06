package l0;

import android.database.Cursor;
import android.os.CancellationSignal;
import android.os.Looper;
import android.util.Log;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import q0.C0840c;
import t3.q;
import t3.r;
import t3.s;

/* renamed from: l0.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0737m {

    /* renamed from: a, reason: collision with root package name */
    public volatile C0840c f8366a;

    /* renamed from: b, reason: collision with root package name */
    public Executor f8367b;

    /* renamed from: c, reason: collision with root package name */
    public p0.c f8368c;

    /* renamed from: e, reason: collision with root package name */
    public boolean f8370e;

    /* renamed from: f, reason: collision with root package name */
    public List f8371f;

    /* renamed from: j, reason: collision with root package name */
    public final LinkedHashMap f8373j;

    /* renamed from: d, reason: collision with root package name */
    public final C0733i f8369d = e();
    public final LinkedHashMap g = new LinkedHashMap();
    public final ReentrantReadWriteLock h = new ReentrantReadWriteLock();

    /* renamed from: i, reason: collision with root package name */
    public final ThreadLocal f8372i = new ThreadLocal();

    public AbstractC0737m() {
        F3.i.e(Collections.synchronizedMap(new LinkedHashMap()), "synchronizedMap(mutableMapOf())");
        this.f8373j = new LinkedHashMap();
    }

    public static Object p(Class cls, p0.c cVar) {
        if (cls.isInstance(cVar)) {
            return cVar;
        }
        if (cVar instanceof InterfaceC0727c) {
            return p(cls, ((InterfaceC0727c) cVar).a());
        }
        return null;
    }

    public final void a() {
        if (this.f8370e) {
            return;
        }
        if (!(!(Looper.getMainLooper().getThread() == Thread.currentThread()))) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.".toString());
        }
    }

    public final void b() {
        if (!h().Q().V() && this.f8372i.get() != null) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.".toString());
        }
    }

    public final void c() {
        a();
        a();
        C0840c c0840cQ = h().Q();
        this.f8369d.e(c0840cQ);
        if (c0840cQ.W()) {
            c0840cQ.c();
        } else {
            c0840cQ.a();
        }
    }

    public final void d() {
        C0840c c0840c = this.f8366a;
        if (F3.i.a(c0840c != null ? Boolean.valueOf(c0840c.isOpen()) : null, Boolean.TRUE)) {
            ReentrantReadWriteLock.WriteLock writeLock = this.h.writeLock();
            F3.i.e(writeLock, "readWriteLock.writeLock()");
            writeLock.lock();
            try {
                this.f8369d.d();
                h().close();
            } finally {
                writeLock.unlock();
            }
        }
    }

    public abstract C0733i e();

    public abstract p0.c f(C0726b c0726b);

    public List g(LinkedHashMap linkedHashMap) {
        F3.i.f(linkedHashMap, "autoMigrationSpecs");
        return q.f9711j;
    }

    public final p0.c h() {
        p0.c cVar = this.f8368c;
        if (cVar != null) {
            return cVar;
        }
        F3.i.k("internalOpenHelper");
        throw null;
    }

    public Set i() {
        return s.f9713j;
    }

    public Map j() {
        return r.f9712j;
    }

    public final void k() {
        h().Q().s();
        if (h().Q().V()) {
            return;
        }
        C0733i c0733i = this.f8369d;
        if (c0733i.f8344e.compareAndSet(false, true)) {
            Executor executor = c0733i.f8340a.f8367b;
            if (executor != null) {
                executor.execute(c0733i.f8349l);
            } else {
                F3.i.k("internalQueryExecutor");
                throw null;
            }
        }
    }

    public final void l(C0840c c0840c) {
        C0733i c0733i = this.f8369d;
        c0733i.getClass();
        synchronized (c0733i.f8348k) {
            if (c0733i.f8345f) {
                Log.e("ROOM", "Invalidation tracker is initialized twice :/.");
                return;
            }
            c0840c.x("PRAGMA temp_store = MEMORY;");
            c0840c.x("PRAGMA recursive_triggers='ON';");
            c0840c.x("CREATE TEMP TABLE room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
            c0733i.e(c0840c);
            c0733i.g = c0840c.o("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1");
            c0733i.f8345f = true;
        }
    }

    public final Cursor m(p0.e eVar, CancellationSignal cancellationSignal) {
        a();
        b();
        return cancellationSignal != null ? h().Q().Z(eVar, cancellationSignal) : h().Q().Y(eVar);
    }

    public final Object n(Callable callable) {
        c();
        try {
            Object objCall = callable.call();
            o();
            return objCall;
        } finally {
            k();
        }
    }

    public final void o() {
        h().Q().a0();
    }
}
