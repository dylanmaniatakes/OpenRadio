package h4;

import android.util.Log;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public abstract class m {

    /* renamed from: a, reason: collision with root package name */
    public final ExecutorService f7107a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f7108b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f7109c;

    /* renamed from: d, reason: collision with root package name */
    public final l f7110d;

    public m(int i5, int i6) {
        if (i6 < i5) {
            Log.w("OsmDroid", "The pending queue size is smaller than the thread pool size. Automatically reducing the thread pool size.");
            i5 = i6;
        }
        this.f7107a = Executors.newFixedThreadPool(i5, new L.k(5, e()));
        this.f7109c = new HashMap();
        this.f7110d = new l(this, i6 + 2, i6);
    }

    public final void a() {
        synchronized (this.f7108b) {
            this.f7110d.clear();
            this.f7109c.clear();
        }
    }

    public abstract void b();

    public abstract int c();

    public abstract int d();

    public abstract String e();

    public abstract M0.d f();

    public abstract boolean g();

    public final void h(long j5) {
        synchronized (this.f7108b) {
            e4.a.g().getClass();
            this.f7110d.remove(Long.valueOf(j5));
            this.f7109c.remove(Long.valueOf(j5));
        }
    }

    public abstract void i(i4.c cVar);
}
