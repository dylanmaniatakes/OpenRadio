package m4;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.C0258e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k4.o;
import k4.t;
import org.osmdroid.views.MapView;

/* loaded from: classes.dex */
public abstract class h extends g {

    /* renamed from: e, reason: collision with root package name */
    public c f8678e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f8679f = new ArrayList();
    public final Paint g;
    public Paint h;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f8680i;

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f8681j;

    /* renamed from: k, reason: collision with root package name */
    public k4.d f8682k;

    /* renamed from: l, reason: collision with root package name */
    public final C0258e f8683l;

    /* renamed from: m, reason: collision with root package name */
    public final Path f8684m;
    public final float n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f8685o;

    /* renamed from: p, reason: collision with root package name */
    public final o f8686p;

    /* renamed from: q, reason: collision with root package name */
    public final o f8687q;

    /* renamed from: r, reason: collision with root package name */
    public final o f8688r;

    /* renamed from: s, reason: collision with root package name */
    public final o f8689s;

    /* renamed from: t, reason: collision with root package name */
    public final float f8690t;

    /* renamed from: u, reason: collision with root package name */
    public final boolean f8691u;

    public h(boolean z4, boolean z5) {
        Paint paint = new Paint();
        this.g = paint;
        this.f8680i = new ArrayList();
        this.f8681j = new ArrayList();
        this.n = 1.0f;
        this.f8685o = true;
        this.f8686p = new o();
        this.f8687q = new o();
        this.f8688r = new o();
        this.f8689s = new o();
        new Point();
        new Point();
        this.f8690t = 1.0f;
        this.f8691u = z5;
        c cVar = this.f8678e;
        ArrayList arrayList = cVar == null ? null : cVar.f8652a;
        if (z4) {
            Path path = new Path();
            this.f8684m = path;
            this.f8683l = null;
            this.f8678e = new c(path, z5);
        } else {
            this.f8684m = null;
            C0258e c0258e = new C0258e();
            this.f8683l = c0258e;
            this.f8678e = new c(c0258e, z5);
            C0258e c0258e2 = this.f8683l;
            c0258e2.getClass();
            c0258e2.f4228f = new n4.a(paint);
        }
        if (arrayList != null) {
            f(arrayList);
        }
    }

    @Override // m4.e
    public final void a(Canvas canvas, l4.l lVar) {
        c cVar = this.f8678e;
        if (!cVar.h) {
            cVar.e();
        }
        k4.a aVar = cVar.g;
        double d5 = (aVar.f8257j + aVar.f8258k) / 2.0d;
        double dA = aVar.a();
        lVar.f8491r.getClass();
        o oVar = this.f8686p;
        if (oVar == null) {
            oVar = new o();
        }
        oVar.f8285a = t.e(dA, 1.152921504606847E18d, true);
        oVar.f8286b = t.f(d5, 1.152921504606847E18d, true);
        double d6 = aVar.f8257j;
        double d7 = aVar.f8259l;
        lVar.f8491r.getClass();
        o oVar2 = this.f8687q;
        if (oVar2 == null) {
            oVar2 = new o();
        }
        oVar2.f8285a = t.e(d7, 1.152921504606847E18d, true);
        oVar2.f8286b = t.f(d6, 1.152921504606847E18d, true);
        double d8 = lVar.n;
        lVar.i(this.f8686p, 1.152921504606847E18d / d8, true, this.f8688r);
        lVar.i(this.f8687q, 1.152921504606847E18d / d8, true, this.f8689s);
        Rect rect = lVar.f8485k;
        int iWidth = rect.width() / 2;
        int iHeight = rect.height() / 2;
        o oVar3 = this.f8688r;
        double d9 = oVar3.f8285a;
        double d10 = oVar3.f8286b;
        o oVar4 = this.f8689s;
        double d11 = iWidth;
        double d12 = iHeight;
        if (Math.sqrt(k4.l.e(oVar3.f8285a, oVar3.f8286b, d11, d12)) <= Math.sqrt(k4.l.e(0.0d, 0.0d, d11, d12)) + Math.sqrt(k4.l.e(d9, d10, oVar4.f8285a, oVar4.f8286b))) {
            Path path = this.f8684m;
            Paint paint = this.g;
            ArrayList arrayList = this.f8681j;
            if (path == null) {
                this.f8683l.f4227e = canvas;
                this.f8678e.h(lVar);
                boolean z4 = arrayList.size() > 0;
                if (this.f8685o) {
                    this.f8685o = true;
                    C0258e c0258e = this.f8683l;
                    c0258e.getClass();
                    c0258e.f4228f = new n4.a(paint);
                    this.f8678e.a(lVar, z4);
                } else {
                    this.f8685o = false;
                    Iterator it = this.f8680i.iterator();
                    while (it.hasNext()) {
                        this.f8683l.f4228f = (n4.a) it.next();
                        this.f8678e.a(lVar, z4);
                        z4 = false;
                    }
                }
                Iterator it2 = arrayList.iterator();
                if (it2.hasNext()) {
                    com.unified.ur1.SatelliteTracker.h.p(it2.next());
                    throw null;
                }
                Iterator it3 = arrayList.iterator();
                if (it3.hasNext()) {
                    com.unified.ur1.SatelliteTracker.h.p(it3.next());
                    throw null;
                }
                o4.a aVar2 = this.f8677d;
                if (aVar2 == null || !aVar2.f9013b || aVar2 == null || aVar2.f9015d != this) {
                    return;
                }
                aVar2.b();
                return;
            }
            path.rewind();
            this.f8678e.h(lVar);
            o oVarB = this.f8678e.b(lVar, null, arrayList.size() > 0);
            Iterator it4 = arrayList.iterator();
            if (it4.hasNext()) {
                com.unified.ur1.SatelliteTracker.h.p(it4.next());
                throw null;
            }
            ArrayList arrayList2 = this.f8679f;
            if (arrayList2 != null) {
                Iterator it5 = arrayList2.iterator();
                while (it5.hasNext()) {
                    c cVar2 = (c) it5.next();
                    cVar2.h(lVar);
                    cVar2.b(lVar, oVarB, arrayList.size() > 0);
                }
                this.f8684m.setFillType(Path.FillType.EVEN_ODD);
            }
            Paint paint2 = this.h;
            if (paint2 != null && paint2.getColor() != 0) {
                canvas.drawPath(this.f8684m, this.h);
            }
            if (paint != null && paint.getColor() != 0) {
                canvas.drawPath(this.f8684m, paint);
            }
            Iterator it6 = arrayList.iterator();
            if (it6.hasNext()) {
                com.unified.ur1.SatelliteTracker.h.p(it6.next());
                throw null;
            }
            o4.a aVar3 = this.f8677d;
            if (aVar3 == null || !aVar3.f9013b || aVar3 == null || aVar3.f9015d != this) {
                return;
            }
            aVar3.b();
        }
    }

    @Override // m4.e
    public void b(MapView mapView) {
        c cVar = this.f8678e;
        if (cVar != null) {
            cVar.f8652a.clear();
            Path path = cVar.f8657f;
            if (path != null) {
                path.reset();
            }
            cVar.f8661l.f8271k = 0;
            this.f8678e = null;
        }
        this.f8679f.clear();
        this.f8681j.clear();
        o4.a aVar = this.f8677d;
        if (aVar != null) {
            aVar.a();
            o4.a aVar2 = this.f8677d;
            aVar2.a();
            View view = aVar2.f9012a;
            if (view != null) {
                view.setTag(null);
            }
            aVar2.f9012a = null;
            aVar2.f9014c = null;
            e4.a.g().getClass();
            this.f8677d = null;
        }
    }

    @Override // m4.e
    public final boolean d(MotionEvent motionEvent, MapView mapView) {
        int iF;
        int i5;
        int iF2;
        int i6;
        double d5;
        c cVar;
        int i7;
        int i8;
        k4.f fVar;
        long j5;
        boolean zContains;
        k4.d dVarD = null;
        k4.d dVarD2 = mapView.getProjection().d((int) motionEvent.getX(), (int) motionEvent.getY(), null, false);
        Path path = this.f8684m;
        if (path == null) {
            double strokeWidth = this.g.getStrokeWidth() * this.n * this.f8690t;
            c cVar2 = this.f8678e;
            l4.l projection = mapView.getProjection();
            cVar2.e();
            Point pointO = projection.o(dVarD2, null);
            o oVar = new o();
            double d6 = projection.n;
            o oVarI = projection.i(cVar2.f8655d, 1.152921504606847E18d / d6, false, null);
            Rect rect = projection.f8485k;
            double d7 = (rect.left + rect.right) / 2.0d;
            double d8 = (rect.top + rect.bottom) / 2.0d;
            double d9 = oVarI.f8285a;
            double d10 = oVarI.f8286b;
            long jRound = Math.round(d6);
            if (cVar2.f8660k) {
                int iF3 = c.f(d9, d10, d7, d8, 0L, jRound);
                iF = c.f(d9, d10, d7, d8, 0L, -jRound);
                i5 = iF3;
            } else {
                i5 = 0;
                iF = 0;
            }
            if (i5 <= iF) {
                i5 = -iF;
            }
            oVar.f8286b = i5 * jRound;
            if (cVar2.f8659j) {
                int iF4 = c.f(d9, d10, d7, d8, jRound, 0L);
                iF2 = c.f(d9, d10, d7, d8, -jRound, 0L);
                i6 = iF4;
            } else {
                iF2 = 0;
                i6 = 0;
            }
            if (i6 <= iF2) {
                i6 = -iF2;
            }
            oVar.f8285a = jRound * i6;
            cVar2.c(projection, oVar, this.f8691u, true, null);
            int iWidth = rect.width();
            int iHeight = rect.height();
            double d11 = pointO.x;
            while (true) {
                double d12 = d11 - d6;
                if (d12 < 0.0d) {
                    break;
                }
                d11 = d12;
            }
            double d13 = pointO.y;
            while (true) {
                double d14 = d13 - d6;
                if (d14 < 0.0d) {
                    break;
                }
                d13 = d14;
            }
            double d15 = strokeWidth * strokeWidth;
            k4.f fVar2 = cVar2.f8661l;
            fVar2.getClass();
            long j6 = 0;
            double d16 = d11;
            long j7 = 0;
            int i9 = 0;
            boolean z4 = true;
            int i10 = 0;
            loop2: while (true) {
                if (i9 >= fVar2.f8271k) {
                    dVarD = null;
                    break;
                }
                int i11 = i9 + 1;
                o oVar2 = (o) fVar2.f8270j.get(i9);
                double d17 = d13;
                long j8 = oVar2.f8285a;
                k4.f fVar3 = fVar2;
                long j9 = oVar2.f8286b;
                if (!z4) {
                    double d18 = d16;
                    k4.f fVar4 = fVar3;
                    d5 = d15;
                    while (true) {
                        cVar = cVar2;
                        i7 = iWidth;
                        if (d18 >= iWidth) {
                            i8 = iHeight;
                            fVar = fVar4;
                            j5 = j8;
                            break;
                        }
                        double d19 = d17;
                        while (d19 < iHeight) {
                            double d20 = j6;
                            int i12 = iHeight;
                            k4.f fVar5 = fVar4;
                            double d21 = j7;
                            long j10 = j6;
                            double d22 = j8;
                            long j11 = j8;
                            double d23 = j9;
                            double d24 = k4.l.d(d18, d19, d20, d21, d22, d23);
                            if (d5 > k4.l.e(d18, d19, ((d22 - d20) * d24) + d20, ((d23 - d21) * d24) + d21)) {
                                long[] jArr = cVar.f8654c;
                                int i13 = (i10 - 1) * 2;
                                long j12 = jArr[i13];
                                int i14 = i10 * 2;
                                long j13 = (long) (((jArr[i14] - j12) * d24) + j12);
                                long j14 = (long) (((jArr[i14 + 1] - r5) * d24) + jArr[i13 + 1]);
                                MapView.getTileSystem().getClass();
                                dVarD = t.d(j13, j14, 1.152921504606847E18d, null, false, false);
                                break loop2;
                            }
                            d19 += d6;
                            iHeight = i12;
                            fVar4 = fVar5;
                            j6 = j10;
                            j8 = j11;
                        }
                        d18 += d6;
                        cVar2 = cVar;
                        iWidth = i7;
                    }
                } else {
                    i7 = iWidth;
                    i8 = iHeight;
                    j5 = j8;
                    fVar = fVar3;
                    d5 = d15;
                    z4 = false;
                    cVar = cVar2;
                }
                i10++;
                j7 = j9;
                cVar2 = cVar;
                i9 = i11;
                d13 = d17;
                d15 = d5;
                iWidth = i7;
                iHeight = i8;
                fVar2 = fVar;
                j6 = j5;
            }
        } else {
            if (path.isEmpty()) {
                zContains = false;
            } else {
                RectF rectF = new RectF();
                this.f8684m.computeBounds(rectF, true);
                Region region = new Region();
                region.setPath(this.f8684m, new Region((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom));
                zContains = region.contains((int) motionEvent.getX(), (int) motionEvent.getY());
            }
            if (zContains) {
                dVarD = dVarD2;
            }
        }
        if (dVarD == null) {
            return false;
        }
        e(dVarD);
        return true;
    }

    public abstract void e(k4.d dVar);

    public final void f(List list) {
        c cVar = this.f8678e;
        ArrayList arrayList = cVar.f8652a;
        arrayList.clear();
        cVar.f8654c = null;
        cVar.f8653b = null;
        cVar.h = false;
        cVar.f8658i = false;
        cVar.f8662m.a();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((k4.d) it.next());
            cVar.h = false;
            cVar.f8658i = false;
        }
        if (this.f8678e.f8652a.size() == 0) {
            this.f8682k = new k4.d(0.0d, 0.0d);
            return;
        }
        if (this.f8682k == null) {
            this.f8682k = new k4.d(0.0d, 0.0d);
        }
        c cVar2 = this.f8678e;
        k4.d dVar = this.f8682k;
        if (dVar == null) {
            cVar2.getClass();
            dVar = new k4.d(0.0d, 0.0d);
        }
        if (!cVar2.h) {
            cVar2.e();
        }
        k4.a aVar = cVar2.g;
        dVar.f8265k = (aVar.f8257j + aVar.f8258k) / 2.0d;
        dVar.f8264j = aVar.a();
    }
}
