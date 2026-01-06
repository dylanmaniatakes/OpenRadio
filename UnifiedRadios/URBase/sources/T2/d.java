package T2;

import J1.D;
import R2.k;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: d, reason: collision with root package name */
    public static final long f2454d = TimeUnit.HOURS.toMillis(24);

    /* renamed from: e, reason: collision with root package name */
    public static final long f2455e = TimeUnit.MINUTES.toMillis(30);

    /* renamed from: a, reason: collision with root package name */
    public final k f2456a;

    /* renamed from: b, reason: collision with root package name */
    public long f2457b;

    /* renamed from: c, reason: collision with root package name */
    public int f2458c;

    public d() {
        if (D.f717d == null) {
            Pattern pattern = k.f2301c;
            D.f717d = new D(16);
        }
        D d5 = D.f717d;
        if (k.f2302d == null) {
            k.f2302d = new k(d5);
        }
        this.f2456a = k.f2302d;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized boolean a() {
        /*
            r4 = this;
            monitor-enter(r4)
            int r0 = r4.f2458c     // Catch: java.lang.Throwable -> L19
            if (r0 == 0) goto L1b
            R2.k r0 = r4.f2456a     // Catch: java.lang.Throwable -> L19
            J1.D r0 = r0.f2303a     // Catch: java.lang.Throwable -> L19
            r0.getClass()     // Catch: java.lang.Throwable -> L19
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L19
            long r2 = r4.f2457b     // Catch: java.lang.Throwable -> L19
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L17
            goto L1b
        L17:
            r0 = 0
            goto L1c
        L19:
            r0 = move-exception
            goto L1e
        L1b:
            r0 = 1
        L1c:
            monitor-exit(r4)
            return r0
        L1e:
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: T2.d.a():boolean");
    }

    public final synchronized void b(int i5) {
        long jMin;
        if ((i5 >= 200 && i5 < 300) || i5 == 401 || i5 == 404) {
            synchronized (this) {
                this.f2458c = 0;
            }
            return;
        }
        this.f2458c++;
        synchronized (this) {
            if (i5 == 429 || (i5 >= 500 && i5 < 600)) {
                double dPow = Math.pow(2.0d, this.f2458c);
                this.f2456a.getClass();
                jMin = (long) Math.min(dPow + ((long) (Math.random() * 1000.0d)), f2455e);
            } else {
                jMin = f2454d;
            }
            this.f2456a.f2303a.getClass();
            this.f2457b = System.currentTimeMillis() + jMin;
        }
        return;
    }
}
