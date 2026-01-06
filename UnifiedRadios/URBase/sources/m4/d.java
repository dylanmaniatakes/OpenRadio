package m4;

import X2.C0202f;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.unified.ur1.R;
import g3.ViewOnTouchListenerC0549B;
import k4.p;
import org.osmdroid.views.MapView;

/* loaded from: classes.dex */
public final class d extends g {

    /* renamed from: e, reason: collision with root package name */
    public Drawable f8664e;

    /* renamed from: f, reason: collision with root package name */
    public k4.d f8665f;
    public float g;
    public float h;

    /* renamed from: i, reason: collision with root package name */
    public final float f8666i;

    /* renamed from: j, reason: collision with root package name */
    public final float f8667j;

    /* renamed from: k, reason: collision with root package name */
    public C0202f f8668k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f8669l;

    /* renamed from: m, reason: collision with root package name */
    public final Point f8670m;
    public l4.k n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f8671o;

    /* renamed from: p, reason: collision with root package name */
    public final Rect f8672p;

    /* renamed from: q, reason: collision with root package name */
    public final Rect f8673q;

    public d(MapView mapView) {
        mapView.getContext();
        this.f8672p = new Rect();
        this.f8673q = new Rect();
        this.n = mapView.getRepository();
        mapView.getContext().getResources();
        this.f8667j = 1.0f;
        this.f8665f = new k4.d(0.0d, 0.0d);
        this.g = 0.5f;
        this.h = 0.5f;
        this.f8666i = 0.5f;
        this.f8670m = new Point();
        this.f8669l = true;
        this.f8668k = null;
        g();
        l4.k kVar = this.n;
        if (kVar.f8474b == null) {
            MapView mapView2 = kVar.f8473a;
            o4.a aVar = new o4.a();
            aVar.f9014c = mapView2;
            mapView2.getRepository().f8476d.add(aVar);
            aVar.f9013b = false;
            View viewInflate = ((LayoutInflater) mapView2.getContext().getSystemService("layout_inflater")).inflate(R.layout.bonuspack_bubble, (ViewGroup) mapView2.getParent(), false);
            aVar.f9012a = viewInflate;
            viewInflate.setTag(aVar);
            if (o4.a.f9008i == 0) {
                Context context = mapView2.getContext();
                String packageName = context.getPackageName();
                o4.a.f9008i = context.getResources().getIdentifier("id/bubble_title", null, packageName);
                o4.a.f9009j = context.getResources().getIdentifier("id/bubble_description", null, packageName);
                o4.a.f9010k = context.getResources().getIdentifier("id/bubble_subdescription", null, packageName);
                int identifier = context.getResources().getIdentifier("id/bubble_image", null, packageName);
                o4.a.f9011l = identifier;
                if (o4.a.f9008i == 0 || o4.a.f9009j == 0 || o4.a.f9010k == 0 || identifier == 0) {
                    Log.e("OsmDroid", "BasicInfoWindow: unable to get res ids in " + packageName);
                }
            }
            aVar.f9012a.setOnTouchListener(new ViewOnTouchListenerC0549B(4, aVar));
            kVar.f8474b = aVar;
        }
        this.f8677d = kVar.f8474b;
    }

    @Override // m4.e
    public final void a(Canvas canvas, l4.l lVar) {
        float f5;
        Rect rect;
        int i5;
        Canvas canvas2;
        if (this.f8664e == null) {
            return;
        }
        k4.d dVar = this.f8665f;
        Point point = this.f8670m;
        lVar.o(dVar, point);
        float f6 = (-lVar.f8489p) - BitmapDescriptorFactory.HUE_RED;
        int i6 = point.x;
        int i7 = point.y;
        int intrinsicWidth = this.f8664e.getIntrinsicWidth();
        int intrinsicHeight = this.f8664e.getIntrinsicHeight();
        int iRound = i6 - Math.round(intrinsicWidth * this.g);
        int iRound2 = i7 - Math.round(intrinsicHeight * this.h);
        Rect rect2 = this.f8672p;
        rect2.set(iRound, iRound2, intrinsicWidth + iRound, intrinsicHeight + iRound2);
        double d5 = f6;
        Rect rect3 = this.f8673q;
        Rect rect4 = rect3 != null ? rect3 : new Rect();
        if (d5 == 0.0d) {
            rect4.top = rect2.top;
            rect4.left = rect2.left;
            rect4.bottom = rect2.bottom;
            rect4.right = rect2.right;
            f5 = f6;
            i5 = i7;
            rect = rect3;
        } else {
            double d6 = (d5 * 3.141592653589793d) / 180.0d;
            double dCos = Math.cos(d6);
            double dSin = Math.sin(d6);
            long j5 = rect2.left;
            long j6 = rect2.top;
            f5 = f6;
            long j7 = i6;
            rect = rect3;
            Rect rect5 = rect4;
            long j8 = i7;
            int iA = (int) p.a(j5, j6, j7, j8, dCos, dSin);
            int iB = (int) p.b(j5, j6, j7, j8, dCos, dSin);
            rect5.bottom = iB;
            rect5.top = iB;
            rect5.right = iA;
            rect5.left = iA;
            long j9 = rect2.right;
            long j10 = rect2.top;
            int iA2 = (int) p.a(j9, j10, j7, j8, dCos, dSin);
            i5 = i7;
            int iB2 = (int) p.b(j9, j10, j7, j8, dCos, dSin);
            if (rect5.top > iB2) {
                rect5.top = iB2;
            }
            if (rect5.bottom < iB2) {
                rect5.bottom = iB2;
            }
            if (rect5.left > iA2) {
                rect5.left = iA2;
            }
            if (rect5.right < iA2) {
                rect5.right = iA2;
            }
            long j11 = rect2.right;
            long j12 = rect2.bottom;
            int iA3 = (int) p.a(j11, j12, j7, j8, dCos, dSin);
            int iB3 = (int) p.b(j11, j12, j7, j8, dCos, dSin);
            if (rect5.top > iB3) {
                rect5.top = iB3;
            }
            if (rect5.bottom < iB3) {
                rect5.bottom = iB3;
            }
            if (rect5.left > iA3) {
                rect5.left = iA3;
            }
            if (rect5.right < iA3) {
                rect5.right = iA3;
            }
            long j13 = rect2.left;
            long j14 = rect2.bottom;
            int iA4 = (int) p.a(j13, j14, j7, j8, dCos, dSin);
            int iB4 = (int) p.b(j13, j14, j7, j8, dCos, dSin);
            if (rect5.top > iB4) {
                rect5.top = iB4;
            }
            if (rect5.bottom < iB4) {
                rect5.bottom = iB4;
            }
            if (rect5.left > iA4) {
                rect5.left = iA4;
            }
            if (rect5.right < iA4) {
                rect5.right = iA4;
            }
        }
        boolean zIntersects = Rect.intersects(rect, canvas.getClipBounds());
        this.f8671o = zIntersects;
        if (zIntersects) {
            float f7 = this.f8667j;
            if (f7 != BitmapDescriptorFactory.HUE_RED) {
                if (f5 != BitmapDescriptorFactory.HUE_RED) {
                    canvas.save();
                    canvas2 = canvas;
                    canvas2.rotate(f5, i6, i5);
                } else {
                    canvas2 = canvas;
                }
                this.f8664e.setAlpha((int) (f7 * 255.0f));
                this.f8664e.setBounds(rect2);
                this.f8664e.draw(canvas2);
                if (f5 != BitmapDescriptorFactory.HUE_RED) {
                    canvas.restore();
                }
            }
        }
        if (f()) {
            this.f8677d.b();
        }
    }

    @Override // m4.e
    public final void b(MapView mapView) {
        o4.a aVar;
        g4.a.f7035c.a(this.f8664e);
        this.f8664e = null;
        this.f8668k = null;
        if (f() && (aVar = this.f8677d) != null) {
            aVar.a();
        }
        this.n = null;
        this.f8677d = null;
    }

    @Override // m4.e
    public final boolean c(MotionEvent motionEvent, MapView mapView) {
        return e(motionEvent);
    }

    @Override // m4.e
    public final boolean d(MotionEvent motionEvent, MapView mapView) {
        boolean zE = e(motionEvent);
        if (!zE) {
            return zE;
        }
        C0202f c0202f = this.f8668k;
        if (c0202f != null) {
            c0202f.d();
            return true;
        }
        j();
        if (this.f8669l) {
            ((l4.f) mapView.getController()).a(this.f8665f, null);
        }
        return true;
    }

    public final boolean e(MotionEvent motionEvent) {
        if (this.f8664e != null && this.f8671o) {
            if (this.f8673q.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return true;
            }
        }
        return false;
    }

    public final boolean f() {
        o4.a aVar = this.f8677d;
        return aVar instanceof o4.a ? aVar != null && aVar.f9013b && aVar.h == this : aVar != null && aVar.f9013b;
    }

    public final void g() {
        MapView mapView;
        Context context;
        l4.k kVar = this.n;
        if (kVar.f8475c == null && (mapView = kVar.f8473a) != null && (context = mapView.getContext()) != null) {
            kVar.f8475c = context.getResources().getDrawable(R.drawable.marker_default);
        }
        this.f8664e = kVar.f8475c;
        this.g = 0.5f;
        this.h = 1.0f;
    }

    public final void h(Drawable drawable) {
        if (drawable != null) {
            this.f8664e = drawable;
        } else {
            g();
        }
    }

    public final void i(k4.d dVar) {
        double d5 = dVar.f8265k;
        double d6 = dVar.f8264j;
        k4.d dVar2 = new k4.d();
        dVar2.f8265k = d5;
        dVar2.f8264j = d6;
        dVar2.f8266l = dVar.f8266l;
        this.f8665f = dVar2;
        if (f()) {
            o4.a aVar = this.f8677d;
            if (aVar != null) {
                aVar.a();
            }
            j();
        }
        e4.a.g().getClass();
    }

    public final void j() {
        if (this.f8677d == null) {
            return;
        }
        this.f8677d.f(this, this.f8665f, (int) ((this.f8666i - this.g) * this.f8664e.getIntrinsicWidth()), (int) ((BitmapDescriptorFactory.HUE_RED - this.h) * this.f8664e.getIntrinsicHeight()));
    }
}
