package l4;

import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import k4.o;
import k4.t;
import org.osmdroid.views.MapView;

/* loaded from: classes.dex */
public final class l implements d4.c {

    /* renamed from: a, reason: collision with root package name */
    public long f8477a;

    /* renamed from: b, reason: collision with root package name */
    public long f8478b;

    /* renamed from: c, reason: collision with root package name */
    public long f8479c;

    /* renamed from: d, reason: collision with root package name */
    public long f8480d;

    /* renamed from: e, reason: collision with root package name */
    public final Matrix f8481e;

    /* renamed from: f, reason: collision with root package name */
    public final Matrix f8482f;
    public final float[] g;
    public final k4.a h;

    /* renamed from: i, reason: collision with root package name */
    public final double f8483i;

    /* renamed from: j, reason: collision with root package name */
    public final Rect f8484j;

    /* renamed from: k, reason: collision with root package name */
    public final Rect f8485k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f8486l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f8487m;
    public final double n;

    /* renamed from: o, reason: collision with root package name */
    public final double f8488o;

    /* renamed from: p, reason: collision with root package name */
    public final float f8489p;

    /* renamed from: q, reason: collision with root package name */
    public final k4.d f8490q;

    /* renamed from: r, reason: collision with root package name */
    public final t f8491r;

    /* renamed from: s, reason: collision with root package name */
    public final int f8492s;

    /* renamed from: t, reason: collision with root package name */
    public final int f8493t;

    public l(double d5, Rect rect, k4.d dVar, long j5, long j6, float f5, boolean z4, boolean z5, t tVar, int i5, int i6) {
        Matrix matrix = new Matrix();
        this.f8481e = matrix;
        Matrix matrix2 = new Matrix();
        this.f8482f = matrix2;
        this.g = new float[2];
        this.h = new k4.a();
        this.f8484j = new Rect();
        this.f8490q = new k4.d(0.0d, 0.0d);
        this.f8492s = i5;
        this.f8493t = i6;
        this.f8483i = d5;
        this.f8486l = z4;
        this.f8487m = z5;
        this.f8491r = tVar;
        double dPow = t.f8314a * Math.pow(2.0d, d5);
        this.n = dPow;
        this.f8488o = Math.pow(2.0d, d5 - k4.l.b(d5)) * t.f8314a;
        this.f8485k = rect;
        k4.d dVar2 = dVar != null ? dVar : new k4.d(0.0d, 0.0d);
        this.f8479c = j5;
        this.f8480d = j6;
        long j7 = j() - this.f8479c;
        double d6 = dVar2.f8264j;
        tVar.getClass();
        this.f8477a = j7 - t.e(d6, dPow, z4);
        this.f8478b = (k() - this.f8480d) - t.f(dVar2.f8265k, dPow, z5);
        this.f8489p = f5;
        matrix.preRotate(f5, j(), k());
        matrix.invert(matrix2);
        m();
    }

    public static long l(long j5, long j6, double d5, int i5) {
        long j7;
        while (true) {
            j7 = j6 - j5;
            if (j7 >= 0) {
                break;
            }
            j6 = (long) (j6 + d5);
        }
        if (j7 >= i5) {
            long j8 = 0 - j5;
            if (j8 < 0) {
                return j8;
            }
            long j9 = i5 - j6;
            if (j9 > 0) {
                return j9;
            }
            return 0L;
        }
        long j10 = j7 / 2;
        long j11 = i5 / 2;
        long j12 = (j11 - j10) - j5;
        if (j12 > 0) {
            return j12;
        }
        long j13 = (j11 + j10) - j6;
        if (j13 < 0) {
            return j13;
        }
        return 0L;
    }

    public final void a(double d5, double d6, boolean z4) {
        long jL;
        double d7 = this.n;
        t tVar = this.f8491r;
        Rect rect = this.f8485k;
        long jL2 = 0;
        if (z4) {
            tVar.getClass();
            long jH = h(t.f(d5, d7, false), false);
            tVar.getClass();
            jL = l(jH, h(t.f(d6, d7, false), false), this.n, rect.height());
        } else {
            tVar.getClass();
            long jG = g(t.e(d5, d7, false), false);
            tVar.getClass();
            jL = 0;
            jL2 = l(jG, g(t.e(d6, d7, false), false), this.n, rect.width());
        }
        b(jL2, jL);
    }

    public final void b(long j5, long j6) {
        if (j5 == 0 && j6 == 0) {
            return;
        }
        this.f8477a += j5;
        this.f8478b += j6;
        this.f8479c -= j5;
        this.f8480d -= j6;
        m();
    }

    public final Point c(int i5, int i6, Point point, Matrix matrix, boolean z4) {
        if (point == null) {
            point = new Point();
        }
        if (z4) {
            float[] fArr = this.g;
            fArr[0] = i5;
            fArr[1] = i6;
            matrix.mapPoints(fArr);
            point.x = (int) fArr[0];
            point.y = (int) fArr[1];
        } else {
            point.x = i5;
            point.y = i6;
        }
        return point;
    }

    public final k4.d d(int i5, int i6, k4.d dVar, boolean z4) {
        long j5 = i5 - this.f8477a;
        boolean z5 = this.f8486l;
        long jE = e(j5, z5);
        long j6 = i6 - this.f8478b;
        boolean z6 = this.f8487m;
        long jE2 = e(j6, z6);
        boolean z7 = z5 || z4;
        boolean z8 = z6 || z4;
        this.f8491r.getClass();
        return t.d(jE, jE2, this.n, dVar, z7, z8);
    }

    public final long e(long j5, boolean z4) {
        this.f8491r.getClass();
        double d5 = this.n;
        double d6 = j5;
        if (z4) {
            if (0.0d > d5) {
                throw new IllegalArgumentException("minValue must be smaller than maxValue: 0.0>" + d5);
            }
            if (d5 > (d5 - 0.0d) + 1.0d) {
                throw new IllegalArgumentException("interval must be equal or smaller than maxValue-minValue: min: 0.0 max:" + d5 + " int:" + d5);
            }
            while (d6 < 0.0d) {
                d6 += d5;
            }
            while (d6 > d5) {
                d6 -= d5;
            }
        }
        return t.b(d6, d5, z4);
    }

    public final long f(long j5, boolean z4, long j6, int i5, int i6) {
        long j7 = j5 + j6;
        if (!z4) {
            return j7;
        }
        long j8 = (i5 + i6) / 2;
        long j9 = i5;
        double d5 = this.n;
        long j10 = 0;
        if (j7 < j9) {
            while (j7 < j9) {
                long j11 = j7;
                j7 = (long) (j7 + d5);
                j10 = j11;
            }
            if (j7 < i6 || Math.abs(j8 - j7) < Math.abs(j8 - j10)) {
                return j7;
            }
        } else {
            while (j7 >= j9) {
                long j12 = j7;
                j7 = (long) (j7 - d5);
                j10 = j12;
            }
            if (j10 >= i6 && Math.abs(j8 - j7) < Math.abs(j8 - j10)) {
                return j7;
            }
        }
        return j10;
    }

    public final long g(long j5, boolean z4) {
        long j6 = this.f8477a;
        Rect rect = this.f8485k;
        return f(j5, z4, j6, rect.left, rect.right);
    }

    public final long h(long j5, boolean z4) {
        long j6 = this.f8478b;
        Rect rect = this.f8485k;
        return f(j5, z4, j6, rect.top, rect.bottom);
    }

    public final o i(o oVar, double d5, boolean z4, o oVar2) {
        if (oVar2 == null) {
            oVar2 = new o();
        }
        oVar2.f8285a = g((long) (oVar.f8285a / d5), z4);
        oVar2.f8286b = h((long) (oVar.f8286b / d5), z4);
        return oVar2;
    }

    public final int j() {
        Rect rect = this.f8485k;
        return ((rect.right + rect.left) / 2) + this.f8492s;
    }

    public final int k() {
        Rect rect = this.f8485k;
        return ((rect.bottom + rect.top) / 2) + this.f8493t;
    }

    public final void m() {
        d(j(), k(), this.f8490q, false);
        float f5 = this.f8489p;
        Rect rect = this.f8485k;
        Rect rect2 = this.f8484j;
        if (f5 == BitmapDescriptorFactory.HUE_RED || f5 == 180.0f) {
            rect2.left = rect.left;
            rect2.top = rect.top;
            rect2.right = rect.right;
            rect2.bottom = rect.bottom;
        } else {
            k4.l.c(rect, j(), k(), f5, rect2);
        }
        k4.d dVarD = d(rect2.right, rect2.top, null, true);
        t tileSystem = MapView.getTileSystem();
        double d5 = dVarD.f8265k;
        tileSystem.getClass();
        if (d5 > 85.05112877980658d) {
            dVarD = new k4.d(85.05112877980658d, dVarD.f8264j);
        }
        if (dVarD.f8265k < -85.05112877980658d) {
            dVarD = new k4.d(-85.05112877980658d, dVarD.f8264j);
        }
        k4.d dVarD2 = d(rect2.left, rect2.bottom, null, true);
        if (dVarD2.f8265k > 85.05112877980658d) {
            dVarD2 = new k4.d(85.05112877980658d, dVarD2.f8264j);
        }
        if (dVarD2.f8265k < -85.05112877980658d) {
            dVarD2 = new k4.d(-85.05112877980658d, dVarD2.f8264j);
        }
        double d6 = dVarD.f8265k;
        double d7 = dVarD.f8264j;
        double d8 = dVarD2.f8265k;
        double d9 = dVarD2.f8264j;
        k4.a aVar = this.h;
        aVar.f8257j = d6;
        aVar.f8259l = d7;
        aVar.f8258k = d8;
        aVar.f8260m = d9;
        e4.a.g().getClass();
    }

    public final o n(int i5, int i6) {
        o oVar = new o();
        oVar.f8285a = e(i5 - this.f8477a, this.f8486l);
        oVar.f8286b = e(i6 - this.f8478b, this.f8487m);
        return oVar;
    }

    public final Point o(d4.a aVar, Point point) {
        if (point == null) {
            point = new Point();
        }
        k4.d dVar = (k4.d) aVar;
        double d5 = dVar.f8264j;
        boolean z4 = this.f8486l;
        t tVar = this.f8491r;
        tVar.getClass();
        double d6 = this.n;
        point.x = t.j(g(t.e(d5, d6, z4), z4));
        double d7 = dVar.f8265k;
        boolean z5 = this.f8487m;
        tVar.getClass();
        point.y = t.j(h(t.f(d7, d6, z5), z5));
        return point;
    }
}
