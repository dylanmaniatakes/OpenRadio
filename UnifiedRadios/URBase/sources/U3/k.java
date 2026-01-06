package U3;

import S3.AbstractC0187a;
import S3.x;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public static final String f2494a;

    /* renamed from: b, reason: collision with root package name */
    public static final long f2495b;

    /* renamed from: c, reason: collision with root package name */
    public static final int f2496c;

    /* renamed from: d, reason: collision with root package name */
    public static final int f2497d;

    /* renamed from: e, reason: collision with root package name */
    public static final long f2498e;

    /* renamed from: f, reason: collision with root package name */
    public static final f f2499f;
    public static final i g;
    public static final i h;

    static {
        String property;
        int i5 = x.f2423a;
        try {
            property = System.getProperty("kotlinx.coroutines.scheduler.default.name");
        } catch (SecurityException unused) {
            property = null;
        }
        if (property == null) {
            property = "DefaultDispatcher";
        }
        f2494a = property;
        f2495b = AbstractC0187a.j("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 1L, Long.MAX_VALUE);
        int i6 = x.f2423a;
        if (i6 < 2) {
            i6 = 2;
        }
        f2496c = AbstractC0187a.k("kotlinx.coroutines.scheduler.core.pool.size", i6, 1, 0, 8);
        f2497d = AbstractC0187a.k("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4);
        f2498e = TimeUnit.SECONDS.toNanos(AbstractC0187a.j("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 1L, Long.MAX_VALUE));
        f2499f = f.f2488a;
        g = new i(0);
        h = new i(1);
    }
}
