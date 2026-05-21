package org.osmdroid.views;

import J1.C0106t;
import L0.s;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;
import c4.a;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import g4.d;
import h4.m;
import i4.c;
import i4.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import k4.o;
import k4.p;
import k4.t;
import k4.u;
import l4.b;
import l4.g;
import l4.h;
import l4.i;
import l4.j;
import l4.k;
import l4.l;
import m4.f;
import s.AbstractC0882e;

/* loaded from: classes.dex */
public class MapView extends ViewGroup implements a {

    /* renamed from: V, reason: collision with root package name */
    public static t f9022V = new u();

    /* renamed from: A, reason: collision with root package name */
    public d f9023A;

    /* renamed from: B, reason: collision with root package name */
    public Handler f9024B;

    /* renamed from: C, reason: collision with root package name */
    public boolean f9025C;

    /* renamed from: D, reason: collision with root package name */
    public float f9026D;

    /* renamed from: E, reason: collision with root package name */
    public final Point f9027E;

    /* renamed from: F, reason: collision with root package name */
    public final Point f9028F;

    /* renamed from: G, reason: collision with root package name */
    public final LinkedList f9029G;

    /* renamed from: H, reason: collision with root package name */
    public boolean f9030H;
    public boolean I;

    /* renamed from: J, reason: collision with root package name */
    public boolean f9031J;

    /* renamed from: K, reason: collision with root package name */
    public k4.d f9032K;

    /* renamed from: L, reason: collision with root package name */
    public long f9033L;

    /* renamed from: M, reason: collision with root package name */
    public long f9034M;

    /* renamed from: N, reason: collision with root package name */
    public final ArrayList f9035N;

    /* renamed from: O, reason: collision with root package name */
    public double f9036O;

    /* renamed from: P, reason: collision with root package name */
    public boolean f9037P;

    /* renamed from: Q, reason: collision with root package name */
    public final k f9038Q;

    /* renamed from: R, reason: collision with root package name */
    public final Rect f9039R;

    /* renamed from: S, reason: collision with root package name */
    public boolean f9040S;

    /* renamed from: T, reason: collision with root package name */
    public boolean f9041T;

    /* renamed from: U, reason: collision with root package name */
    public boolean f9042U;

    /* renamed from: c, reason: collision with root package name */
    public double f9043c;

    /* renamed from: d, reason: collision with root package name */
    public f f9044d;

    /* renamed from: e, reason: collision with root package name */
    public l f9045e;

    /* renamed from: f, reason: collision with root package name */
    public m4.l f9046f;
    public final GestureDetector g;
    public final Scroller h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f9047i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f9048j;

    /* renamed from: k, reason: collision with root package name */
    public final AtomicBoolean f9049k;

    /* renamed from: l, reason: collision with root package name */
    public Double f9050l;

    /* renamed from: m, reason: collision with root package name */
    public Double f9051m;
    public final l4.f n;

    /* renamed from: o, reason: collision with root package name */
    public final b f9052o;

    /* renamed from: p, reason: collision with root package name */
    public c4.d f9053p;

    /* renamed from: q, reason: collision with root package name */
    public final PointF f9054q;

    /* renamed from: r, reason: collision with root package name */
    public final k4.d f9055r;

    /* renamed from: s, reason: collision with root package name */
    public PointF f9056s;

    /* renamed from: t, reason: collision with root package name */
    public float f9057t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f9058u;

    /* renamed from: v, reason: collision with root package name */
    public double f9059v;

    /* renamed from: w, reason: collision with root package name */
    public double f9060w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f9061x;

    /* renamed from: y, reason: collision with root package name */
    public double f9062y;

    /* renamed from: z, reason: collision with root package name */
    public double f9063z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r8v2, types: [i4.c, java.lang.Object] */
    public MapView(Context context, AttributeSet attributeSet) throws NumberFormatException {
        String attributeValue;
        super(context, attributeSet);
        e4.a.g().getClass();
        this.f9043c = 0.0d;
        this.f9049k = new AtomicBoolean(false);
        this.f9054q = new PointF();
        this.f9055r = new k4.d(0.0d, 0.0d);
        this.f9057t = BitmapDescriptorFactory.HUE_RED;
        new Rect();
        this.f9025C = false;
        this.f9026D = 1.0f;
        this.f9027E = new Point();
        this.f9028F = new Point();
        this.f9029G = new LinkedList();
        this.f9030H = false;
        this.I = true;
        this.f9031J = true;
        this.f9035N = new ArrayList();
        this.f9038Q = new k(this);
        this.f9039R = new Rect();
        this.f9040S = true;
        this.f9041T = true;
        this.f9042U = false;
        e4.a.g().b(context);
        if (isInEditMode()) {
            this.f9024B = null;
            this.n = null;
            this.f9052o = null;
            this.h = null;
            this.g = null;
            return;
        }
        this.n = new l4.f(this);
        this.h = new Scroller(context);
        e eVar = i4.f.f7376b;
        if (attributeSet != null && (attributeValue = attributeSet.getAttributeValue(null, "tilesource")) != null) {
            try {
                Iterator it = i4.f.f7377c.iterator();
                while (it.hasNext()) {
                    ?? r8 = (c) it.next();
                    if (((i4.d) r8).f7369c.equals(attributeValue)) {
                        Log.i("OsmDroid", "Using tile source specified in layout attributes: " + r8);
                        eVar = r8;
                    }
                }
                throw new IllegalArgumentException("No such tile source: ".concat(attributeValue));
            } catch (IllegalArgumentException unused) {
                Log.w("OsmDroid", "Invalid tile source specified in layout attributes: " + eVar);
            }
        }
        if (attributeSet != null && (eVar instanceof i4.b)) {
            String attributeValue2 = attributeSet.getAttributeValue(null, "style");
            if (attributeValue2 == null) {
                Log.i("OsmDroid", "Using default style: 1");
            } else {
                Log.i("OsmDroid", "Using style specified in layout attributes: ".concat(attributeValue2));
                i4.b bVar = (i4.b) eVar;
                bVar.getClass();
                try {
                    Integer.parseInt(attributeValue2);
                    bVar.getClass();
                } catch (NumberFormatException unused2) {
                    Log.e("OsmDroid", "Error setting integer style: ".concat(attributeValue2));
                }
            }
        }
        Log.i("OsmDroid", "Using tile source: " + eVar.f7369c);
        g4.e eVar2 = new g4.e(context.getApplicationContext(), eVar);
        j4.b bVar2 = new j4.b();
        bVar2.f7623a = this;
        this.f9024B = bVar2;
        this.f9023A = eVar2;
        eVar2.f7054k.add(bVar2);
        h(this.f9023A.f7056m);
        this.f9046f = new m4.l(this.f9023A, this.I, this.f9031J);
        this.f9044d = new m4.b(this.f9046f);
        b bVar3 = new b(this);
        this.f9052o = bVar3;
        bVar3.f8433e = new j(this);
        bVar3.f8434f = this.f9043c < getMaxZoomLevel();
        bVar3.g = this.f9043c > getMinZoomLevel();
        GestureDetector gestureDetector = new GestureDetector(context, new i(this));
        this.g = gestureDetector;
        gestureDetector.setOnDoubleTapListener(new h(this));
        if (e4.a.g().f6234o) {
            setHasTransientState(true);
        }
        bVar3.c(3);
    }

    public static t getTileSystem() {
        return f9022V;
    }

    public static void setTileSystem(t tVar) {
        f9022V = tVar;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:15:0x0069. Please report as an issue. */
    public final void a() {
        l lVar;
        LinkedList linkedList;
        int paddingTop;
        long paddingTop2;
        int i5;
        long j5;
        int paddingTop3;
        d4.a aVar = null;
        this.f9045e = null;
        int childCount = getChildCount();
        int i6 = 0;
        while (true) {
            int i7 = 1;
            if (i6 >= childCount) {
                if (this.f9030H) {
                    lVar = null;
                } else {
                    this.f9030H = true;
                    LinkedList linkedList2 = this.f9029G;
                    Iterator it = linkedList2.iterator();
                    while (it.hasNext()) {
                        s sVar = ((l4.f) it.next()).f8465c;
                        LinkedList linkedList3 = (LinkedList) sVar.f1596d;
                        Iterator it2 = linkedList3.iterator();
                        while (it2.hasNext()) {
                            l4.e eVar = (l4.e) it2.next();
                            int iC = AbstractC0882e.c(eVar.f8459a);
                            Point point = eVar.f8460b;
                            l4.f fVar = (l4.f) sVar.f1597e;
                            if (iC == 0) {
                                if (point != null) {
                                    int i8 = point.x;
                                    int i9 = point.y;
                                    fVar.getClass();
                                    double d5 = i8 * 1.0E-6d;
                                    double d6 = i9 * 1.0E-6d;
                                    if (d5 > 0.0d && d6 > 0.0d) {
                                        MapView mapView = fVar.f8463a;
                                        if (mapView.f9030H) {
                                            k4.a aVar2 = mapView.getProjection().h;
                                            linkedList = linkedList2;
                                            double d7 = mapView.getProjection().f8483i;
                                            double dMax = Math.max(d5 / Math.abs(aVar2.f8257j - aVar2.f8258k), d6 / Math.abs(aVar2.f8259l - aVar2.f8260m));
                                            if (dMax > 1.0d) {
                                                float f5 = (float) dMax;
                                                int i10 = 1;
                                                int i11 = 1;
                                                int i12 = 0;
                                                while (i10 <= f5) {
                                                    i10 *= 2;
                                                    i12 = i11;
                                                    i11++;
                                                }
                                                mapView.g(d7 - i12);
                                            } else if (dMax < 0.5d) {
                                                float f6 = 1.0f / ((float) dMax);
                                                int i13 = 1;
                                                int i14 = 1;
                                                int i15 = 0;
                                                while (i13 <= f6) {
                                                    i13 *= 2;
                                                    i15 = i14;
                                                    i14++;
                                                }
                                                mapView.g((d7 + i15) - 1.0d);
                                            }
                                        } else {
                                            ((LinkedList) fVar.f8465c.f1596d).add(new l4.e(i7, new Point((int) (d5 * 1000000.0d), (int) (d6 * 1000000.0d)), aVar, null));
                                        }
                                    }
                                }
                                linkedList2 = linkedList;
                                i7 = 1;
                                aVar = null;
                            } else if (iC != i7) {
                                d4.a aVar3 = eVar.f8461c;
                                if (iC != 2) {
                                    if (iC == 3 && aVar3 != null) {
                                        fVar.c(aVar3);
                                    }
                                } else if (aVar3 != null) {
                                    fVar.a(aVar3, eVar.f8462d);
                                }
                            } else if (point != null) {
                                int i16 = point.x;
                                int i17 = point.y;
                                MapView mapView2 = fVar.f8463a;
                                if (!mapView2.f9030H) {
                                    ((LinkedList) fVar.f8465c.f1596d).add(new l4.e(2, new Point(i16, i17), null, null));
                                } else if (!mapView2.f9049k.get()) {
                                    mapView2.f9047i = false;
                                    int mapScrollX = (int) mapView2.getMapScrollX();
                                    int mapScrollY = (int) mapView2.getMapScrollY();
                                    int width = i16 - (mapView2.getWidth() / 2);
                                    int height = i17 - (mapView2.getHeight() / 2);
                                    if (width != mapScrollX || height != mapScrollY) {
                                        mapView2.getScroller().startScroll(mapScrollX, mapScrollY, width, height, e4.a.g().f6233m);
                                        mapView2.postInvalidate();
                                    }
                                }
                            }
                            linkedList = linkedList2;
                            linkedList2 = linkedList;
                            i7 = 1;
                            aVar = null;
                        }
                        linkedList3.clear();
                        linkedList2 = linkedList2;
                        i7 = 1;
                        aVar = null;
                    }
                    linkedList2.clear();
                    lVar = null;
                }
                this.f9045e = lVar;
                return;
            }
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                g gVar = (g) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int measuredWidth = childAt.getMeasuredWidth();
                l projection = getProjection();
                d4.a aVar4 = gVar.f8466a;
                Point point2 = this.f9028F;
                projection.o(aVar4, point2);
                if (getMapOrientation() != BitmapDescriptorFactory.HUE_RED) {
                    l projection2 = getProjection();
                    Point pointC = projection2.c(point2.x, point2.y, null, projection2.f8481e, projection2.f8489p != BitmapDescriptorFactory.HUE_RED);
                    point2.x = pointC.x;
                    point2.y = pointC.y;
                }
                long paddingLeft = point2.x;
                long j6 = point2.y;
                switch (gVar.f8467b) {
                    case 1:
                        paddingLeft += getPaddingLeft();
                        paddingTop = getPaddingTop();
                        j6 += paddingTop;
                        break;
                    case 2:
                        paddingLeft = (getPaddingLeft() + paddingLeft) - (measuredWidth / 2);
                        paddingTop = getPaddingTop();
                        j6 += paddingTop;
                        break;
                    case 3:
                        paddingLeft = (getPaddingLeft() + paddingLeft) - measuredWidth;
                        paddingTop = getPaddingTop();
                        j6 += paddingTop;
                        break;
                    case 4:
                        paddingLeft += getPaddingLeft();
                        paddingTop2 = getPaddingTop() + j6;
                        i5 = measuredHeight / 2;
                        j5 = i5;
                        j6 = paddingTop2 - j5;
                        break;
                    case 5:
                        paddingLeft = (getPaddingLeft() + paddingLeft) - (measuredWidth / 2);
                        paddingTop2 = getPaddingTop() + j6;
                        i5 = measuredHeight / 2;
                        j5 = i5;
                        j6 = paddingTop2 - j5;
                        break;
                    case 6:
                        paddingLeft = (getPaddingLeft() + paddingLeft) - measuredWidth;
                        paddingTop2 = getPaddingTop() + j6;
                        i5 = measuredHeight / 2;
                        j5 = i5;
                        j6 = paddingTop2 - j5;
                        break;
                    case 7:
                        paddingLeft += getPaddingLeft();
                        paddingTop3 = getPaddingTop();
                        paddingTop2 = paddingTop3 + j6;
                        j5 = measuredHeight;
                        j6 = paddingTop2 - j5;
                        break;
                    case 8:
                        paddingLeft = (getPaddingLeft() + paddingLeft) - (measuredWidth / 2);
                        paddingTop3 = getPaddingTop();
                        paddingTop2 = paddingTop3 + j6;
                        j5 = measuredHeight;
                        j6 = paddingTop2 - j5;
                        break;
                    case 9:
                        paddingLeft = (getPaddingLeft() + paddingLeft) - measuredWidth;
                        paddingTop3 = getPaddingTop();
                        paddingTop2 = paddingTop3 + j6;
                        j5 = measuredHeight;
                        j6 = paddingTop2 - j5;
                        break;
                }
                long j7 = paddingLeft + gVar.f8468c;
                long j8 = j6 + gVar.f8469d;
                childAt.layout(t.j(j7), t.j(j8), t.j(j7 + measuredWidth), t.j(j8 + measuredHeight));
            }
            i6++;
        }
    }

    public final void b() {
        CopyOnWriteArrayList copyOnWriteArrayList;
        m4.b bVar = (m4.b) getOverlayManager();
        m4.l lVar = bVar.f8650j;
        if (lVar != null) {
            lVar.b(this);
        }
        while (true) {
            try {
                copyOnWriteArrayList = bVar.f8651k;
                break;
            } catch (IndexOutOfBoundsException unused) {
            }
        }
        C0106t c0106t = new C0106t(copyOnWriteArrayList.listIterator(copyOnWriteArrayList.size()));
        while (((ListIterator) c0106t.f1390k).hasPrevious()) {
            ((m4.e) c0106t.next()).b(this);
        }
        bVar.clear();
        this.f9023A.c();
        b bVar2 = this.f9052o;
        if (bVar2 != null) {
            bVar2.f8435i = true;
            bVar2.f8431c.cancel();
        }
        Handler handler = this.f9024B;
        if (handler instanceof j4.b) {
            ((j4.b) handler).f7623a = null;
        }
        this.f9024B = null;
        this.f9045e = null;
        k kVar = this.f9038Q;
        synchronized (kVar.f8476d) {
            try {
                Iterator it = kVar.f8476d.iterator();
                while (it.hasNext()) {
                    o4.a aVar = (o4.a) it.next();
                    aVar.a();
                    View view = aVar.f9012a;
                    if (view != null) {
                        view.setTag(null);
                    }
                    aVar.f9012a = null;
                    aVar.f9014c = null;
                    e4.a.g().getClass();
                }
                kVar.f8476d.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        kVar.f8473a = null;
        kVar.f8474b = null;
        kVar.getClass();
        kVar.f8475c = null;
        this.f9035N.clear();
    }

    public final void c() {
        CopyOnWriteArrayList copyOnWriteArrayList;
        m4.b bVar = (m4.b) getOverlayManager();
        m4.l lVar = bVar.f8650j;
        while (true) {
            try {
                copyOnWriteArrayList = bVar.f8651k;
                break;
            } catch (IndexOutOfBoundsException unused) {
            }
        }
        C0106t c0106t = new C0106t(copyOnWriteArrayList.listIterator(copyOnWriteArrayList.size()));
        while (((ListIterator) c0106t.f1390k).hasPrevious()) {
            ((m4.e) c0106t.next()).getClass();
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof g;
    }

    @Override // android.view.View
    public final void computeScroll() {
        Scroller scroller = this.h;
        if (scroller != null && this.f9047i && scroller.computeScrollOffset()) {
            if (scroller.isFinished()) {
                this.f9047i = false;
            } else {
                scrollTo(scroller.getCurrX(), scroller.getCurrY());
                postInvalidate();
            }
        }
    }

    public final void d() {
        CopyOnWriteArrayList copyOnWriteArrayList;
        m4.b bVar = (m4.b) getOverlayManager();
        m4.l lVar = bVar.f8650j;
        while (true) {
            try {
                copyOnWriteArrayList = bVar.f8651k;
                break;
            } catch (IndexOutOfBoundsException unused) {
            }
        }
        C0106t c0106t = new C0106t(copyOnWriteArrayList.listIterator(copyOnWriteArrayList.size()));
        while (((ListIterator) c0106t.f1390k).hasPrevious()) {
            ((m4.e) c0106t.next()).getClass();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        System.currentTimeMillis();
        this.f9045e = null;
        l projection = getProjection();
        if (projection.f8489p != BitmapDescriptorFactory.HUE_RED) {
            canvas.save();
            canvas.concat(projection.f8481e);
        }
        try {
            ((m4.b) getOverlayManager()).a(canvas, this);
            if (getProjection().f8489p != BitmapDescriptorFactory.HUE_RED) {
                canvas.restore();
            }
            b bVar = this.f9052o;
            if (bVar != null) {
                bVar.b(canvas);
            }
            super.dispatchDraw(canvas);
        } catch (Exception e5) {
            Log.e("OsmDroid", "error dispatchDraw, probably in edit mode", e5);
        }
        e4.a.g().getClass();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEventObtain;
        CopyOnWriteArrayList copyOnWriteArrayList;
        boolean z4;
        j jVar;
        j jVar2;
        e4.a.g().getClass();
        b bVar = this.f9052o;
        if (bVar.h != BitmapDescriptorFactory.HUE_RED) {
            if (!bVar.f8437k) {
                l4.c cVar = bVar.f8432d;
                if (cVar.d(motionEvent, true)) {
                    if (bVar.f8434f && (jVar2 = bVar.f8433e) != null) {
                        jVar2.onZoom(true);
                    }
                } else if (cVar.d(motionEvent, false)) {
                    if (bVar.g && (jVar = bVar.f8433e) != null) {
                        jVar.onZoom(false);
                    }
                }
                bVar.a();
                return true;
            }
            bVar.f8437k = false;
        }
        if (getMapOrientation() == BitmapDescriptorFactory.HUE_RED) {
            motionEventObtain = motionEvent;
        } else {
            motionEventObtain = MotionEvent.obtain(motionEvent);
            motionEventObtain.transform(getProjection().f8482f);
        }
        try {
            if (super.dispatchTouchEvent(motionEvent)) {
                e4.a.g().getClass();
                return true;
            }
            m4.b bVar2 = (m4.b) getOverlayManager();
            bVar2.getClass();
            while (true) {
                try {
                    copyOnWriteArrayList = bVar2.f8651k;
                    break;
                } catch (IndexOutOfBoundsException unused) {
                }
            }
            C0106t c0106t = new C0106t(copyOnWriteArrayList.listIterator(copyOnWriteArrayList.size()));
            while (((ListIterator) c0106t.f1390k).hasPrevious()) {
                ((m4.e) c0106t.next()).getClass();
            }
            c4.d dVar = this.f9053p;
            if (dVar == null || !dVar.d(motionEvent)) {
                z4 = false;
            } else {
                e4.a.g().getClass();
                z4 = true;
            }
            if (this.g.onTouchEvent(motionEventObtain)) {
                e4.a.g().getClass();
                z4 = true;
            }
            if (z4) {
                if (motionEventObtain != motionEvent) {
                    motionEventObtain.recycle();
                }
                return true;
            }
            if (motionEventObtain != motionEvent) {
                motionEventObtain.recycle();
            }
            e4.a.g().getClass();
            return false;
        } finally {
            if (motionEventObtain != motionEvent) {
                motionEventObtain.recycle();
            }
        }
    }

    public final void e() {
        if (this.f9037P) {
            this.f9043c = Math.round(this.f9043c);
            invalidate();
        }
        this.f9056s = null;
    }

    public final void f(float f5, float f6) {
        this.f9054q.set(f5, f6);
        l projection = getProjection();
        Point pointC = projection.c((int) f5, (int) f6, null, projection.f8482f, projection.f8489p != BitmapDescriptorFactory.HUE_RED);
        getProjection().d(pointC.x, pointC.y, this.f9055r, false);
        this.f9056s = new PointF(f5, f6);
    }

    public final double g(double d5) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        boolean z4;
        MapView mapView = this;
        double dMax = Math.max(getMinZoomLevel(), Math.min(getMaxZoomLevel(), d5));
        double d6 = mapView.f9043c;
        boolean z5 = true;
        if (dMax != d6) {
            Scroller scroller = mapView.h;
            if (scroller != null) {
                scroller.forceFinished(true);
            }
            mapView.f9047i = false;
        }
        k4.d dVar = getProjection().f8490q;
        mapView.f9043c = dMax;
        mapView.setExpectedCenter(dVar);
        boolean z6 = mapView.f9043c < getMaxZoomLevel();
        b bVar = mapView.f9052o;
        bVar.f8434f = z6;
        bVar.g = mapView.f9043c > getMinZoomLevel();
        if (mapView.f9030H) {
            ((l4.f) getController()).c(dVar);
            new Point();
            l projection = getProjection();
            f overlayManager = getOverlayManager();
            float f5 = mapView.f9054q.x;
            m4.b bVar2 = (m4.b) overlayManager;
            bVar2.getClass();
            while (true) {
                try {
                    copyOnWriteArrayList = bVar2.f8651k;
                    break;
                } catch (IndexOutOfBoundsException unused) {
                    z5 = z5;
                    dMax = dMax;
                }
            }
            C0106t c0106t = new C0106t(copyOnWriteArrayList.listIterator(copyOnWriteArrayList.size()));
            while (((ListIterator) c0106t.f1390k).hasPrevious()) {
                c0106t.next();
            }
            d dVar2 = mapView.f9023A;
            Rect rect = mapView.f9039R;
            if (rect == null) {
                rect = new Rect();
            }
            rect.set(0, 0, getWidth(), getHeight());
            if (getMapOrientation() != BitmapDescriptorFactory.HUE_RED && getMapOrientation() != 180.0f) {
                k4.l.c(rect, rect.centerX(), rect.centerY(), getMapOrientation(), rect);
            }
            dVar2.getClass();
            if (k4.l.b(dMax) == k4.l.b(d6)) {
                z4 = z5;
            } else {
                System.currentTimeMillis();
                e4.a.g().getClass();
                o oVarN = projection.n(rect.left, rect.top);
                o oVarN2 = projection.n(rect.right, rect.bottom);
                double d7 = dMax;
                p pVar = new p(oVarN.f8285a, oVarN.f8286b, oVarN2.f8285a, oVarN2.f8286b);
                g4.c cVar = dMax > d6 ? new g4.c(dVar2, 0) : new g4.c(dVar2, 1);
                int i5 = ((i4.d) dVar2.f7056m).f7372f;
                new Rect();
                cVar.f7049j = new Rect();
                new Paint();
                cVar.f7047f = k4.l.b(d6);
                cVar.g = i5;
                cVar.d(d7, pVar);
                System.currentTimeMillis();
                e4.a.g().getClass();
                z4 = true;
                mapView = this;
            }
            mapView.f9042U = z4;
        }
        if (dMax != d6) {
            Iterator it = mapView.f9035N.iterator();
            if (it.hasNext()) {
                com.unified.ur1.SatelliteTracker.h.p(it.next());
                throw null;
            }
        }
        requestLayout();
        invalidate();
        return mapView.f9043c;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new g(null, 0, 0);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        g gVar = new g(getContext(), attributeSet);
        gVar.f8466a = new k4.d(0.0d, 0.0d);
        gVar.f8467b = 8;
        return gVar;
    }

    public k4.a getBoundingBox() {
        return getProjection().h;
    }

    public d4.b getController() {
        return this.n;
    }

    public k4.d getExpectedCenter() {
        return this.f9032K;
    }

    public double getLatitudeSpanDouble() {
        k4.a boundingBox = getBoundingBox();
        return Math.abs(boundingBox.f8257j - boundingBox.f8258k);
    }

    public double getLongitudeSpanDouble() {
        k4.a boundingBox = getBoundingBox();
        return Math.abs(boundingBox.f8259l - boundingBox.f8260m);
    }

    public d4.a getMapCenter() {
        return getProjection().d(getWidth() / 2, getHeight() / 2, null, false);
    }

    public int getMapCenterOffsetX() {
        return 0;
    }

    public int getMapCenterOffsetY() {
        return 0;
    }

    public float getMapOrientation() {
        return this.f9057t;
    }

    public m4.l getMapOverlay() {
        return this.f9046f;
    }

    @Deprecated
    public float getMapScale() {
        return 1.0f;
    }

    public long getMapScrollX() {
        return this.f9033L;
    }

    public long getMapScrollY() {
        return this.f9034M;
    }

    public double getMaxZoomLevel() {
        int iC;
        Double d5 = this.f9051m;
        if (d5 != null) {
            return d5.doubleValue();
        }
        g4.e eVar = (g4.e) this.f9046f.f8694b;
        synchronized (eVar.f7058p) {
            try {
                Iterator it = eVar.f7058p.iterator();
                iC = 0;
                while (it.hasNext()) {
                    m mVar = (m) it.next();
                    if (mVar.c() > iC) {
                        iC = mVar.c();
                    }
                }
            } finally {
            }
        }
        return iC;
    }

    public double getMinZoomLevel() {
        Double d5 = this.f9050l;
        if (d5 != null) {
            return d5.doubleValue();
        }
        g4.e eVar = (g4.e) this.f9046f.f8694b;
        int iD = t.f8315b;
        synchronized (eVar.f7058p) {
            try {
                Iterator it = eVar.f7058p.iterator();
                while (it.hasNext()) {
                    m mVar = (m) it.next();
                    if (mVar.d() < iD) {
                        iD = mVar.d();
                    }
                }
            } finally {
            }
        }
        return iD;
    }

    public f getOverlayManager() {
        return this.f9044d;
    }

    public List<m4.e> getOverlays() {
        return ((m4.b) getOverlayManager()).f8651k;
    }

    public k getRepository() {
        return this.f9038Q;
    }

    public Scroller getScroller() {
        return this.h;
    }

    public d getTileProvider() {
        return this.f9023A;
    }

    public Handler getTileRequestCompleteHandler() {
        return this.f9024B;
    }

    public float getTilesScaleFactor() {
        return this.f9026D;
    }

    public b getZoomController() {
        return this.f9052o;
    }

    @Deprecated
    public int getZoomLevel() {
        return (int) getZoomLevelDouble();
    }

    public double getZoomLevelDouble() {
        return this.f9043c;
    }

    public final void h(c cVar) {
        float f5 = ((i4.d) cVar).f7372f;
        int i5 = (int) (f5 * (this.f9025C ? ((getResources().getDisplayMetrics().density * 256.0f) / f5) * this.f9026D : this.f9026D));
        e4.a.g().getClass();
        t.f8315b = Math.min(29, 62 - ((int) ((Math.log(i5) / Math.log(2.0d)) + 0.5d)));
        t.f8314a = i5;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        if (this.f9040S) {
            b();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i5, KeyEvent keyEvent) {
        m4.b bVar = (m4.b) getOverlayManager();
        bVar.getClass();
        Iterator it = new m4.a(bVar).iterator();
        while (it.hasNext()) {
            ((m4.e) it.next()).getClass();
        }
        return super.onKeyDown(i5, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i5, KeyEvent keyEvent) {
        m4.b bVar = (m4.b) getOverlayManager();
        bVar.getClass();
        Iterator it = new m4.a(bVar).iterator();
        while (it.hasNext()) {
            ((m4.e) it.next()).getClass();
        }
        return super.onKeyUp(i5, keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        a();
    }

    @Override // android.view.View
    public final void onMeasure(int i5, int i6) {
        measureChildren(i5, i6);
        super.onMeasure(i5, i6);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.View
    public final boolean onTrackballEvent(MotionEvent motionEvent) {
        m4.b bVar = (m4.b) getOverlayManager();
        bVar.getClass();
        Iterator it = new m4.a(bVar).iterator();
        while (true) {
            C0106t c0106t = (C0106t) it;
            if (!c0106t.hasNext()) {
                scrollBy((int) (motionEvent.getX() * 25.0f), (int) (motionEvent.getY() * 25.0f));
                return super.onTrackballEvent(motionEvent);
            }
            ((m4.e) c0106t.next()).getClass();
        }
    }

    @Override // android.view.View
    public final void scrollBy(int i5, int i6) {
        scrollTo((int) (getMapScrollX() + i5), (int) (getMapScrollY() + i6));
    }

    @Override // android.view.View
    public final void scrollTo(int i5, int i6) {
        this.f9033L = i5;
        this.f9034M = i6;
        requestLayout();
        this.f9045e = null;
        invalidate();
        if (getMapOrientation() != BitmapDescriptorFactory.HUE_RED) {
            getLeft();
            getTop();
            getRight();
            getBottom();
            a();
        }
        Iterator it = this.f9035N.iterator();
        if (it.hasNext()) {
            com.unified.ur1.SatelliteTracker.h.p(it.next());
            throw null;
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i5) {
        m4.l lVar = this.f9046f;
        if (lVar.g != i5) {
            lVar.g = i5;
            BitmapDrawable bitmapDrawable = lVar.f8698f;
            lVar.f8698f = null;
            g4.a.f7035c.a(bitmapDrawable);
        }
        invalidate();
    }

    @Deprecated
    public void setBuiltInZoomControls(boolean z4) {
        this.f9052o.c(z4 ? 3 : 2);
    }

    public void setDestroyMode(boolean z4) {
        this.f9040S = z4;
    }

    public void setExpectedCenter(d4.a aVar) {
        k4.d dVar = getProjection().f8490q;
        this.f9032K = (k4.d) aVar;
        this.f9033L = 0L;
        this.f9034M = 0L;
        requestLayout();
        this.f9045e = null;
        if (!getProjection().f8490q.equals(dVar)) {
            Iterator it = this.f9035N.iterator();
            if (it.hasNext()) {
                com.unified.ur1.SatelliteTracker.h.p(it.next());
                throw null;
            }
        }
        invalidate();
    }

    public void setFlingEnabled(boolean z4) {
        this.f9041T = z4;
    }

    public void setHorizontalMapRepetitionEnabled(boolean z4) {
        this.I = z4;
        this.f9046f.f8701k.f8312c = z4;
        this.f9045e = null;
        invalidate();
    }

    @Deprecated
    public void setInitCenter(d4.a aVar) {
        setExpectedCenter(aVar);
    }

    @Deprecated
    public void setMapCenter(d4.a aVar) {
        ((l4.f) getController()).a(aVar, null);
    }

    @Deprecated
    public void setMapListener(f4.a aVar) {
        this.f9035N.add(aVar);
    }

    public void setMapOrientation(float f5) {
        this.f9057t = f5 % 360.0f;
        requestLayout();
        invalidate();
    }

    public void setMaxZoomLevel(Double d5) {
        this.f9051m = d5;
    }

    public void setMinZoomLevel(Double d5) {
        this.f9050l = d5;
    }

    public void setMultiTouchControls(boolean z4) {
        c4.d dVar = null;
        if (z4) {
            c4.d dVar2 = new c4.d();
            dVar2.f4609k = null;
            dVar2.f4610l = new c4.c();
            dVar2.f4617t = 0;
            dVar2.f4602b = new c4.b();
            dVar2.f4603c = new c4.b();
            dVar2.f4608j = false;
            dVar2.f4601a = this;
            dVar = dVar2;
        }
        this.f9053p = dVar;
    }

    public void setMultiTouchScale(float f5) {
        g((Math.log(f5) / Math.log(2.0d)) + this.f9036O);
    }

    public void setOverlayManager(f fVar) {
        this.f9044d = fVar;
    }

    @Deprecated
    public void setProjection(l lVar) {
        this.f9045e = lVar;
    }

    public void setScrollableAreaLimitDouble(k4.a aVar) {
        if (aVar == null) {
            this.f9058u = false;
            this.f9061x = false;
            return;
        }
        double dMax = Math.max(aVar.f8257j, aVar.f8258k);
        double dMin = Math.min(aVar.f8257j, aVar.f8258k);
        this.f9058u = true;
        this.f9059v = dMax;
        this.f9060w = dMin;
        double d5 = aVar.f8260m;
        double d6 = aVar.f8259l;
        this.f9061x = true;
        this.f9062y = d5;
        this.f9063z = d6;
    }

    public void setTileProvider(d dVar) {
        this.f9023A.c();
        this.f9023A.b();
        this.f9023A = dVar;
        dVar.f7054k.add(this.f9024B);
        h(this.f9023A.f7056m);
        d dVar2 = this.f9023A;
        getContext();
        m4.l lVar = new m4.l(dVar2, this.I, this.f9031J);
        this.f9046f = lVar;
        ((m4.b) this.f9044d).f8650j = lVar;
        invalidate();
    }

    public void setTileSource(c cVar) {
        this.f9023A.g(cVar);
        h(cVar);
        boolean z4 = this.f9043c < getMaxZoomLevel();
        b bVar = this.f9052o;
        bVar.f8434f = z4;
        bVar.g = this.f9043c > getMinZoomLevel();
        g(this.f9043c);
        postInvalidate();
    }

    public void setTilesScaleFactor(float f5) {
        this.f9026D = f5;
        h(getTileProvider().f7056m);
    }

    public void setTilesScaledToDpi(boolean z4) {
        this.f9025C = z4;
        h(getTileProvider().f7056m);
    }

    public void setUseDataConnection(boolean z4) {
        this.f9046f.f8694b.f7055l = z4;
    }

    public void setVerticalMapRepetitionEnabled(boolean z4) {
        this.f9031J = z4;
        this.f9046f.f8701k.f8313d = z4;
        this.f9045e = null;
        invalidate();
    }

    public void setZoomRounding(boolean z4) {
        this.f9037P = z4;
    }

    public l getProjection() {
        k4.d dVar;
        if (this.f9045e == null) {
            double zoomLevelDouble = getZoomLevelDouble();
            Rect rect = new Rect();
            rect.set(0, 0, getWidth(), getHeight());
            l lVar = new l(zoomLevelDouble, rect, getExpectedCenter(), getMapScrollX(), getMapScrollY(), getMapOrientation(), this.I, this.f9031J, getTileSystem(), getMapCenterOffsetX(), getMapCenterOffsetY());
            this.f9045e = lVar;
            PointF pointF = this.f9056s;
            boolean z4 = true;
            if (pointF != null && (dVar = this.f9055r) != null) {
                Point pointC = lVar.c((int) pointF.x, (int) pointF.y, null, lVar.f8482f, lVar.f8489p != BitmapDescriptorFactory.HUE_RED);
                Point pointO = lVar.o(dVar, null);
                lVar.b(pointC.x - pointO.x, pointC.y - pointO.y);
            }
            if (this.f9058u) {
                lVar.a(this.f9059v, this.f9060w, true);
            }
            if (this.f9061x) {
                lVar.a(this.f9062y, this.f9063z, false);
            }
            if (getMapScrollX() == lVar.f8479c && getMapScrollY() == lVar.f8480d) {
                z4 = false;
            } else {
                long j5 = lVar.f8479c;
                long j6 = lVar.f8480d;
                this.f9033L = j5;
                this.f9034M = j6;
                requestLayout();
            }
            this.f9048j = z4;
        }
        return this.f9045e;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new g(layoutParams);
    }
}
