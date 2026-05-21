package l4;

import J1.C0106t;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Scroller;
import java.util.Iterator;
import org.osmdroid.views.MapView;

/* loaded from: classes.dex */
public final class i implements GestureDetector.OnGestureListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MapView f8471a;

    public i(MapView mapView) {
        this.f8471a = mapView;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent motionEvent) {
        MapView mapView = this.f8471a;
        if (mapView.f9047i) {
            Scroller scroller = mapView.h;
            if (scroller != null) {
                scroller.abortAnimation();
            }
            mapView.f9047i = false;
        }
        m4.b bVar = (m4.b) mapView.getOverlayManager();
        bVar.getClass();
        Iterator it = new m4.a(bVar).iterator();
        while (true) {
            C0106t c0106t = (C0106t) it;
            if (!c0106t.hasNext()) {
                break;
            }
            ((m4.e) c0106t.next()).getClass();
        }
        b bVar2 = mapView.f9052o;
        if (bVar2 == null) {
            return true;
        }
        bVar2.a();
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f5, float f6) {
        MapView mapView = this.f8471a;
        if (!mapView.f9041T || mapView.f9042U) {
            mapView.f9042U = false;
            return false;
        }
        m4.b bVar = (m4.b) mapView.getOverlayManager();
        bVar.getClass();
        Iterator it = new m4.a(bVar).iterator();
        while (true) {
            C0106t c0106t = (C0106t) it;
            if (!c0106t.hasNext()) {
                break;
            }
            ((m4.e) c0106t.next()).getClass();
        }
        if (mapView.f9048j) {
            mapView.f9048j = false;
            return false;
        }
        mapView.f9047i = true;
        Scroller scroller = mapView.h;
        if (scroller != null) {
            scroller.fling((int) mapView.getMapScrollX(), (int) mapView.getMapScrollY(), -((int) f5), -((int) f6), Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent motionEvent) {
        C0106t c0106t;
        MapView mapView = this.f8471a;
        c4.d dVar = mapView.f9053p;
        if (dVar == null || dVar.f4617t != 2) {
            m4.b bVar = (m4.b) mapView.getOverlayManager();
            bVar.getClass();
            Iterator it = new m4.a(bVar).iterator();
            do {
                c0106t = (C0106t) it;
                if (!c0106t.hasNext()) {
                    return;
                }
            } while (!((m4.e) c0106t.next()).c(motionEvent, mapView));
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f5, float f6) {
        MapView mapView = this.f8471a;
        m4.b bVar = (m4.b) mapView.getOverlayManager();
        bVar.getClass();
        Iterator it = new m4.a(bVar).iterator();
        while (true) {
            C0106t c0106t = (C0106t) it;
            if (!c0106t.hasNext()) {
                mapView.scrollBy((int) f5, (int) f6);
                return true;
            }
            ((m4.e) c0106t.next()).getClass();
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onShowPress(MotionEvent motionEvent) {
        m4.b bVar = (m4.b) this.f8471a.getOverlayManager();
        bVar.getClass();
        Iterator it = new m4.a(bVar).iterator();
        while (it.hasNext()) {
            ((m4.e) it.next()).getClass();
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        m4.b bVar = (m4.b) this.f8471a.getOverlayManager();
        bVar.getClass();
        Iterator it = new m4.a(bVar).iterator();
        while (it.hasNext()) {
            ((m4.e) it.next()).getClass();
        }
        return false;
    }
}
