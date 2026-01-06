package k4;

import android.graphics.Rect;

/* loaded from: classes.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public static final int f8282a = 1 << 29;

    public static boolean a(double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, o oVar, double d13, double d14) {
        if (d13 < Math.min(d5, d7) || d13 > Math.max(d5, d7) || d13 < Math.min(d9, d11) || d13 > Math.max(d9, d11) || d14 < Math.min(d6, d8) || d14 > Math.max(d6, d8) || d14 < Math.min(d10, d12) || d14 > Math.max(d10, d12)) {
            return false;
        }
        if (oVar == null) {
            return true;
        }
        oVar.f8285a = Math.round(d13);
        oVar.f8286b = Math.round(d14);
        return true;
    }

    public static int b(double d5) {
        int i5 = (int) d5;
        return ((double) i5) <= d5 ? i5 : i5 - 1;
    }

    public static final void c(Rect rect, int i5, int i6, float f5, Rect rect2) {
        float f6;
        Rect rect3;
        if (rect2 == null) {
            rect3 = new Rect();
            f6 = f5;
        } else {
            f6 = f5;
            rect3 = rect2;
        }
        double d5 = f6 * 0.017453292519943295d;
        double dSin = Math.sin(d5);
        double dCos = Math.cos(d5);
        double d6 = rect.left - i5;
        double d7 = rect.top - i6;
        double d8 = i5;
        double d9 = d8 - (d6 * dCos);
        double d10 = d7 * dSin;
        double d11 = d10 + d9;
        double d12 = i6;
        double d13 = d12 - (d6 * dSin);
        double d14 = d7 * dCos;
        double d15 = d13 - d14;
        double d16 = rect.right - i5;
        double d17 = d8 - (d16 * dCos);
        double d18 = d10 + d17;
        double d19 = d12 - (d16 * dSin);
        double d20 = d19 - d14;
        double d21 = rect.bottom - i6;
        double d22 = dSin * d21;
        double d23 = d22 + d9;
        double d24 = d21 * dCos;
        double d25 = d13 - d24;
        double d26 = d22 + d17;
        double d27 = d19 - d24;
        rect3.left = b(Math.floor(Math.min(Math.min(d11, d18), Math.min(d23, d26))));
        rect3.top = b(Math.floor(Math.min(Math.min(d15, d20), Math.min(d25, d27))));
        rect3.right = b(Math.ceil(Math.max(Math.max(d11, d18), Math.max(d23, d26))));
        rect3.bottom = b(Math.ceil(Math.max(Math.max(d15, d20), Math.max(d25, d27))));
    }

    public static double d(double d5, double d6, double d7, double d8, double d9, double d10) {
        double dE;
        if (d7 == d9 && d8 == d10) {
            dE = 0.0d;
        } else {
            dE = (((d6 - d8) * (d10 - d8)) + ((d5 - d7) * (d9 - d7))) / e(d7, d8, d9, d10);
        }
        if (dE < 0.0d) {
            return 0.0d;
        }
        if (dE > 1.0d) {
            return 1.0d;
        }
        return dE;
    }

    public static double e(double d5, double d6, double d7, double d8) {
        double d9 = d5 - d7;
        double d10 = d6 - d8;
        return (d10 * d10) + (d9 * d9);
    }

    public static long f(int i5, int i6, int i7) {
        if (i5 < 0 || i5 > 29) {
            j(i5, i5, "Zoom");
            throw null;
        }
        long j5 = 1 << i5;
        if (i6 >= 0) {
            long j6 = i6;
            if (j6 < j5) {
                if (i7 >= 0) {
                    long j7 = i7;
                    if (j7 < j5) {
                        return (i5 << 58) + (j6 << 29) + j7;
                    }
                }
                j(i5, i7, "Y");
                throw null;
            }
        }
        j(i5, i6, "X");
        throw null;
    }

    public static int g(long j5) {
        return (int) ((j5 >> 29) % f8282a);
    }

    public static int h(long j5) {
        return (int) (j5 % f8282a);
    }

    public static double i(double d5, double d6, double d7, double d8) {
        return (Math.max(Math.min(d5, d6), Math.min(d7, d8)) + Math.min(Math.max(d5, d6), Math.max(d7, d8))) / 2.0d;
    }

    public static void j(int i5, int i6, String str) {
        StringBuilder sb = new StringBuilder("MapTileIndex: ");
        sb.append(str);
        sb.append(" (");
        sb.append(i6);
        sb.append(") is too big (zoom=");
        throw new IllegalArgumentException(com.unified.ur1.SatelliteTracker.h.d(sb, i5, ")"));
    }

    public static String k(long j5) {
        return "/" + ((int) (j5 >> 58)) + "/" + g(j5) + "/" + h(j5);
    }
}
