package m4;

import android.graphics.Path;
import android.graphics.Rect;
import androidx.recyclerview.widget.C0258e;
import com.google.android.gms.internal.measurement.C1;
import java.util.ArrayList;
import java.util.Iterator;
import k4.n;
import k4.o;
import k4.q;
import k4.r;
import k4.t;
import org.osmdroid.views.MapView;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f8652a;

    /* renamed from: b, reason: collision with root package name */
    public double[] f8653b;

    /* renamed from: c, reason: collision with root package name */
    public long[] f8654c;

    /* renamed from: d, reason: collision with root package name */
    public final o f8655d;

    /* renamed from: e, reason: collision with root package name */
    public final q f8656e;

    /* renamed from: f, reason: collision with root package name */
    public final Path f8657f;
    public final k4.a g;
    public boolean h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f8658i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f8659j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f8660k;

    /* renamed from: l, reason: collision with root package name */
    public final k4.f f8661l;

    /* renamed from: m, reason: collision with root package name */
    public final n f8662m;
    public final L.h n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f8663o;

    public c(C0258e c0258e, boolean z4) {
        this.f8652a = new ArrayList();
        this.f8655d = new o();
        this.f8656e = new q();
        this.g = new k4.a();
        this.f8659j = true;
        this.f8660k = true;
        this.f8661l = new k4.f();
        this.f8657f = null;
        this.f8662m = c0258e;
        L.h hVar = new L.h(((float[]) c0258e.f4225c).length / 2);
        this.n = hVar;
        c0258e.f4226d = hVar;
        this.f8663o = z4;
    }

    public static int f(double d5, double d6, double d7, double d8, long j5, long j6) {
        double d9 = 0.0d;
        int i5 = 0;
        while (true) {
            long j7 = i5;
            double dE = k4.l.e(d5 + (j7 * j5), d6 + (j7 * j6), d7, d8);
            if (i5 != 0 && d9 <= dE) {
                return i5 - 1;
            }
            i5++;
            d9 = dE;
        }
    }

    public static double g(double d5, double d6, double d7) {
        while (true) {
            double d8 = d6 - d7;
            if (Math.abs(d8 - d5) >= Math.abs(d6 - d5)) {
                break;
            }
            d6 = d8;
        }
        while (true) {
            double d9 = d6 + d7;
            if (Math.abs(d9 - d5) >= Math.abs(d6 - d5)) {
                return d6;
            }
            d6 = d9;
        }
    }

    public final void a(l4.l lVar, boolean z4) {
        double d5;
        double d6;
        long j5;
        int iF;
        int i5;
        int iF2;
        int i6;
        if (this.f8652a.size() < 2) {
            return;
        }
        e();
        d();
        o oVar = new o();
        o oVarI = lVar.i(this.f8655d, 1.152921504606847E18d / lVar.n, false, null);
        Rect rect = lVar.f8485k;
        double d7 = (rect.left + rect.right) / 2.0d;
        double d8 = (rect.top + rect.bottom) / 2.0d;
        double d9 = oVarI.f8285a;
        double d10 = oVarI.f8286b;
        long jRound = Math.round(lVar.n);
        if (this.f8660k) {
            d5 = d9;
            int iF3 = f(d9, d10, d7, d8, 0L, jRound);
            d6 = d10;
            j5 = jRound;
            iF = f(d5, d10, d7, d8, 0L, -jRound);
            i5 = iF3;
        } else {
            d6 = d10;
            j5 = jRound;
            d5 = d9;
            iF = 0;
            i5 = 0;
        }
        if (i5 <= iF) {
            i5 = -iF;
        }
        oVar.f8286b = j5 * i5;
        if (this.f8659j) {
            double d11 = d5;
            double d12 = d6;
            int iF4 = f(d11, d12, d7, d8, j5, 0L);
            iF2 = f(d11, d12, d7, d8, -j5, 0L);
            i6 = iF4;
        } else {
            i6 = 0;
            iF2 = 0;
        }
        if (i6 <= iF2) {
            i6 = -iF2;
        }
        oVar.f8285a = j5 * i6;
        q qVar = this.f8656e;
        qVar.a();
        c(lVar, oVar, this.f8663o, z4, this.f8656e);
        qVar.c();
    }

    public final o b(l4.l lVar, o oVar, boolean z4) {
        o oVar2;
        double d5;
        double d6;
        long j5;
        int iF;
        int i5;
        int iF2;
        int i6;
        if (this.f8652a.size() < 2) {
            return oVar;
        }
        e();
        d();
        if (oVar != null) {
            oVar2 = oVar;
        } else {
            oVar2 = new o();
            o oVarI = lVar.i(this.f8655d, 1.152921504606847E18d / lVar.n, false, null);
            Rect rect = lVar.f8485k;
            double d7 = (rect.left + rect.right) / 2.0d;
            double d8 = (rect.top + rect.bottom) / 2.0d;
            double d9 = oVarI.f8285a;
            double d10 = oVarI.f8286b;
            long jRound = Math.round(lVar.n);
            if (this.f8660k) {
                d5 = d9;
                int iF3 = f(d9, d10, d7, d8, 0L, jRound);
                d6 = d10;
                j5 = jRound;
                iF = f(d5, d10, d7, d8, 0L, -jRound);
                i5 = iF3;
            } else {
                d6 = d10;
                j5 = jRound;
                d5 = d9;
                iF = 0;
                i5 = 0;
            }
            if (i5 <= iF) {
                i5 = -iF;
            }
            oVar2.f8286b = j5 * i5;
            if (this.f8659j) {
                double d11 = d5;
                double d12 = d6;
                int iF4 = f(d11, d12, d7, d8, j5, 0L);
                iF2 = f(d11, d12, d7, d8, -j5, 0L);
                i6 = iF4;
            } else {
                i6 = 0;
                iF2 = 0;
            }
            if (i6 <= iF2) {
                i6 = -iF2;
            }
            oVar2.f8285a = j5 * i6;
        }
        q qVar = this.f8656e;
        qVar.a();
        c(lVar, oVar2, this.f8663o, z4, this.f8656e);
        qVar.c();
        if (this.f8663o) {
            this.f8657f.close();
        }
        return oVar2;
    }

    public final void c(l4.l lVar, o oVar, boolean z4, boolean z5, q qVar) {
        k4.f fVar = this.f8661l;
        fVar.f8271k = 0;
        double d5 = 1.152921504606847E18d / lVar.n;
        long j5 = 0;
        int i5 = 0;
        long j6 = 0;
        while (true) {
            long[] jArr = this.f8654c;
            if (i5 >= jArr.length) {
                break;
            }
            long j7 = jArr[i5];
            long j8 = j5;
            long j9 = jArr[i5 + 1];
            long jG = lVar.g((long) (j7 / d5), false);
            long jH = lVar.h((long) (j9 / d5), false);
            double d6 = d5;
            long j10 = jG + oVar.f8285a;
            long j11 = jH + oVar.f8286b;
            if (z5) {
                fVar.a(j10, j11);
            }
            if (qVar != null) {
                qVar.b(j10, j11);
            }
            if (i5 == 0) {
                j6 = j11;
                j5 = j10;
            } else {
                j5 = j8;
            }
            i5 += 2;
            d5 = d6;
        }
        long j12 = j5;
        if (z4) {
            if (qVar != null) {
                qVar.b(j12, j6);
            }
            if (z5) {
                fVar.a(j12, j6);
            }
        }
    }

    public final void d() {
        Iterator it;
        c cVar = this;
        if (cVar.f8658i) {
            return;
        }
        cVar.f8658i = true;
        double[] dArr = cVar.f8653b;
        ArrayList arrayList = cVar.f8652a;
        if (dArr == null || dArr.length != arrayList.size()) {
            cVar.f8653b = new double[arrayList.size()];
        }
        Iterator it2 = arrayList.iterator();
        double d5 = 0.0d;
        int i5 = 0;
        double d6 = 0.0d;
        double d7 = 0.0d;
        while (it2.hasNext()) {
            k4.d dVar = (k4.d) it2.next();
            if (i5 == 0) {
                cVar.f8653b[i5] = d5;
                it = it2;
            } else {
                double[] dArr2 = cVar.f8653b;
                double d8 = dVar.f8265k * 0.017453292519943295d;
                double d9 = d6 * 0.017453292519943295d;
                it = it2;
                dArr2[i5] = Math.asin(Math.min(1.0d, Math.sqrt((Math.pow(Math.sin(((d7 * 0.017453292519943295d) - (dVar.f8264j * 0.017453292519943295d)) / 2.0d), 2.0d) * Math.cos(d9) * Math.cos(d8)) + Math.pow(Math.sin((d9 - d8) / 2.0d), 2.0d)))) * 1.2756274E7d;
            }
            d6 = dVar.f8265k;
            d7 = dVar.f8264j;
            i5++;
            d5 = 0.0d;
            cVar = this;
            it2 = it;
        }
    }

    public final void e() {
        if (this.h) {
            return;
        }
        this.h = true;
        long[] jArr = this.f8654c;
        ArrayList arrayList = this.f8652a;
        if (jArr == null || jArr.length != arrayList.size() * 2) {
            this.f8654c = new long[arrayList.size() * 2];
        }
        t tileSystem = MapView.getTileSystem();
        Iterator it = arrayList.iterator();
        double d5 = 0.0d;
        double d6 = 0.0d;
        double d7 = 0.0d;
        long j5 = 0;
        long j6 = 0;
        long j7 = 0;
        long j8 = 0;
        long j9 = 0;
        long j10 = 0;
        int i5 = 0;
        double d8 = 0.0d;
        while (it.hasNext()) {
            k4.d dVar = (k4.d) it.next();
            double d9 = d5;
            double d10 = dVar.f8265k;
            double d11 = d7;
            d7 = dVar.f8264j;
            tileSystem.getClass();
            t tVar = tileSystem;
            Iterator it2 = it;
            double d12 = d6;
            long jE = t.e(d7, 1.152921504606847E18d, false);
            long jF = t.f(d10, 1.152921504606847E18d, false);
            if (i5 == 0) {
                j7 = jF;
                j8 = j7;
                j10 = j8;
                d9 = d10;
                j5 = jE;
                j6 = j5;
                j9 = j6;
                d8 = d7;
                d6 = d9;
            } else {
                if (this.f8659j) {
                    jE = Math.round(g(j9, jE, 1.152921504606847E18d));
                }
                if (this.f8660k) {
                    jF = Math.round(g(j10, jF, 1.152921504606847E18d));
                }
                if (j6 > jE) {
                    j6 = jE;
                    d11 = d7;
                }
                if (j5 < jE) {
                    j5 = jE;
                    d8 = d7;
                }
                if (j8 > jF) {
                    j8 = jF;
                    d9 = d10;
                }
                if (j7 < jF) {
                    j7 = jF;
                    j10 = j7;
                    j9 = jE;
                    d7 = d11;
                    d6 = d10;
                } else {
                    j10 = jF;
                    j9 = jE;
                    d7 = d11;
                    d6 = d12;
                }
            }
            long[] jArr2 = this.f8654c;
            int i6 = i5 * 2;
            jArr2[i6] = j9;
            jArr2[i6 + 1] = j10;
            i5++;
            tileSystem = tVar;
            d5 = d9;
            it = it2;
        }
        double d13 = d5;
        o oVar = this.f8655d;
        oVar.f8285a = (j6 + j5) / 2;
        oVar.f8286b = (j8 + j7) / 2;
        k4.a aVar = this.g;
        aVar.f8257j = d13;
        aVar.f8259l = d8;
        aVar.f8258k = d6;
        aVar.f8260m = d7;
        e4.a.g().getClass();
    }

    public final void h(l4.l lVar) {
        Rect rect = lVar.f8485k;
        int iWidth = rect.width() / 2;
        int iHeight = rect.height() / 2;
        int iSqrt = (int) (Math.sqrt((iHeight * iHeight) + (iWidth * iWidth)) * 2.0d * 1.1d);
        long j5 = iWidth - iSqrt;
        long j6 = iHeight - iSqrt;
        long j7 = iWidth + iSqrt;
        long j8 = iHeight + iSqrt;
        boolean z4 = this.f8657f != null;
        q qVar = this.f8656e;
        qVar.f8294d = j5;
        qVar.f8295e = j6;
        qVar.f8296f = j7;
        qVar.g = j8;
        long[] jArr = qVar.f8298j;
        jArr[1] = j5;
        jArr[0] = j5;
        jArr[3] = j7;
        jArr[2] = j7;
        long[] jArr2 = qVar.f8299k;
        jArr2[2] = j6;
        jArr2[0] = j6;
        jArr2[3] = j8;
        jArr2[1] = j8;
        qVar.h = this.f8662m;
        qVar.f8297i = this.n;
        qVar.f8302o = z4;
        this.f8659j = lVar.f8486l;
        this.f8660k = lVar.f8487m;
    }

    public c(Path path, boolean z4) {
        this.f8652a = new ArrayList();
        this.f8655d = new o();
        this.f8656e = new q();
        this.g = new k4.a();
        this.f8659j = true;
        this.f8660k = true;
        this.f8661l = new k4.f();
        this.f8657f = path;
        this.f8662m = new r(new C1(path));
        this.n = null;
        this.f8663o = z4;
    }
}
