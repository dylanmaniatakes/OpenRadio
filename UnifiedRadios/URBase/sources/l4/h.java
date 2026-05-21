package l4;

import J1.C0106t;
import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.osmdroid.views.MapView;

/* loaded from: classes.dex */
public final class h implements GestureDetector.OnDoubleTapListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MapView f8470a;

    public h(MapView mapView) {
        this.f8470a = mapView;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent motionEvent) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        MapView mapView = this.f8470a;
        m4.b bVar = (m4.b) mapView.getOverlayManager();
        bVar.getClass();
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
        l projection = mapView.getProjection();
        int x4 = (int) motionEvent.getX();
        int y4 = (int) motionEvent.getY();
        Point point = mapView.f9027E;
        projection.c(x4, y4, point, projection.f8481e, projection.f8489p != BitmapDescriptorFactory.HUE_RED);
        f fVar = (f) mapView.getController();
        return fVar.e(fVar.f8463a.getZoomLevelDouble() + 1.0d, point.x, point.y);
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTapEvent(MotionEvent motionEvent) {
        m4.b bVar = (m4.b) this.f8470a.getOverlayManager();
        bVar.getClass();
        Iterator it = new m4.a(bVar).iterator();
        while (it.hasNext()) {
            ((m4.e) it.next()).getClass();
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        C0106t c0106t;
        MapView mapView = this.f8470a;
        m4.b bVar = (m4.b) mapView.getOverlayManager();
        bVar.getClass();
        Iterator it = new m4.a(bVar).iterator();
        do {
            c0106t = (C0106t) it;
            if (!c0106t.hasNext()) {
                return false;
            }
        } while (!((m4.e) c0106t.next()).d(motionEvent, mapView));
        return true;
    }
}
