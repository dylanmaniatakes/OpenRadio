package J1;

import android.os.Handler;
import z2.RunnableC0999a;

/* renamed from: J1.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0092o {

    /* renamed from: d, reason: collision with root package name */
    public static volatile A1.f f1322d;

    /* renamed from: a, reason: collision with root package name */
    public final G0 f1323a;

    /* renamed from: b, reason: collision with root package name */
    public final RunnableC0999a f1324b;

    /* renamed from: c, reason: collision with root package name */
    public volatile long f1325c;

    public AbstractC0092o(G0 g02) {
        q1.E.i(g02);
        this.f1323a = g02;
        this.f1324b = new RunnableC0999a(6, this, g02, false);
    }

    public final void a() {
        this.f1325c = 0L;
        d().removeCallbacks(this.f1324b);
    }

    public abstract void b();

    public final void c(long j5) {
        a();
        if (j5 >= 0) {
            G0 g02 = this.f1323a;
            g02.f().getClass();
            this.f1325c = System.currentTimeMillis();
            if (d().postDelayed(this.f1324b, j5)) {
                return;
            }
            g02.c().h.b(Long.valueOf(j5), "Failed to schedule delayed post. time");
        }
    }

    public final Handler d() {
        A1.f fVar;
        if (f1322d != null) {
            return f1322d;
        }
        synchronized (AbstractC0092o.class) {
            try {
                if (f1322d == null) {
                    f1322d = new A1.f(this.f1323a.d().getMainLooper(), 4);
                }
                fVar = f1322d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return fVar;
    }
}
