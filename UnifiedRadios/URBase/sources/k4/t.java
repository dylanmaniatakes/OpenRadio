package k4;

import android.graphics.Rect;

/* loaded from: classes.dex */
public abstract class t {

    /* renamed from: a, reason: collision with root package name */
    public static int f8314a = 256;

    /* renamed from: b, reason: collision with root package name */
    public static int f8315b = 29;

    public static double a(double d5, double d6, double d7) {
        return Math.min(Math.max(d5, d6), d7);
    }

    public static long b(double d5, double d6, boolean z4) {
        long j5 = (long) d5;
        if (j5 > d5) {
            j5--;
        }
        if (!z4) {
            return j5;
        }
        if (j5 <= 0) {
            return 0L;
        }
        double d7 = d6 - 1.0d;
        long j6 = (long) d7;
        if (j6 > d7) {
            j6--;
        }
        return ((double) j5) >= d6 ? j6 : j5;
    }

    public static double c(double d5) {
        while (d5 < -180.0d) {
            d5 += 360.0d;
        }
        while (d5 > 180.0d) {
            d5 -= 360.0d;
        }
        return a(d5, -180.0d, 180.0d);
    }

    public static d d(long j5, long j6, double d5, d dVar, boolean z4, boolean z5) {
        d dVar2 = dVar == null ? new d(0.0d, 0.0d) : dVar;
        double d6 = j6;
        double dA = z5 ? a(d6 / d5, 0.0d, 1.0d) : d6 / d5;
        if (z5) {
            dA = a(dA, 0.0d, 1.0d);
        }
        double dAtan = 90.0d - ((Math.atan(Math.exp(((dA - 0.5d) * 2.0d) * 3.141592653589793d)) * 360.0d) / 3.141592653589793d);
        if (z5) {
            dAtan = a(dAtan, -85.05112877980658d, 85.05112877980658d);
        }
        dVar2.f8265k = dAtan;
        double dA2 = j5 / d5;
        if (z4) {
            dA2 = a(dA2, 0.0d, 1.0d);
        }
        if (z4) {
            dA2 = a(dA2, 0.0d, 1.0d);
        }
        double dA3 = (-180.0d) + (360.0d * dA2);
        if (z4) {
            dA3 = a(dA3, -180.0d, 180.0d);
        }
        dVar2.f8264j = dA3;
        return dVar2;
    }

    public static long e(double d5, double d6, boolean z4) {
        return b(h(d5, z4) * d6, d6, z4);
    }

    public static long f(double d5, double d6, boolean z4) {
        return b(i(d5, z4) * d6, d6, z4);
    }

    public static void g(p pVar, double d5, Rect rect) {
        if (rect == null) {
            rect = new Rect();
        }
        rect.left = l.b(pVar.f8287a / d5);
        rect.top = l.b(pVar.f8288b / d5);
        rect.right = l.b(pVar.f8289c / d5);
        rect.bottom = l.b(pVar.f8290d / d5);
    }

    public static double h(double d5, boolean z4) {
        if (z4) {
            d5 = a(d5, -180.0d, 180.0d);
        }
        double d6 = (d5 - (-180.0d)) / 360.0d;
        return z4 ? a(d6, 0.0d, 1.0d) : d6;
    }

    public static double i(double d5, boolean z4) {
        if (z4) {
            d5 = a(d5, -85.05112877980658d, 85.05112877980658d);
        }
        double dSin = Math.sin((d5 * 3.141592653589793d) / 180.0d);
        double dLog = 0.5d - (Math.log((dSin + 1.0d) / (1.0d - dSin)) / 12.566370614359172d);
        return z4 ? a(dLog, 0.0d, 1.0d) : dLog;
    }

    public static int j(long j5) {
        return (int) Math.max(Math.min(j5, 2147483647L), -2147483648L);
    }
}
