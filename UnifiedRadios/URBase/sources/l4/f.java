package l4;

import L0.s;
import android.animation.ValueAnimator;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.Iterator;
import java.util.LinkedList;
import org.osmdroid.views.MapView;

/* loaded from: classes.dex */
public final class f implements d4.b {

    /* renamed from: a, reason: collision with root package name */
    public final MapView f8463a;

    /* renamed from: b, reason: collision with root package name */
    public ValueAnimator f8464b;

    /* renamed from: c, reason: collision with root package name */
    public final s f8465c = new s(this);

    public f(MapView mapView) {
        this.f8463a = mapView;
        boolean z4 = mapView.f9030H;
        if (z4 || z4) {
            return;
        }
        mapView.f9029G.add(this);
    }

    public final void a(d4.a aVar, Double d5) {
        MapView mapView = this.f8463a;
        if (!mapView.f9030H) {
            ((LinkedList) this.f8465c.f1596d).add(new e(3, null, aVar, d5));
            return;
        }
        k4.d dVar = mapView.getProjection().f8490q;
        k4.d dVar2 = new k4.d();
        dVar2.f8265k = dVar.f8265k;
        dVar2.f8264j = dVar.f8264j;
        dVar2.f8266l = dVar.f8266l;
        d dVar3 = new d(this, Double.valueOf(mapView.getZoomLevelDouble()), d5, dVar2, aVar, Float.valueOf(mapView.getMapOrientation()));
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(BitmapDescriptorFactory.HUE_RED, 1.0f);
        valueAnimatorOfFloat.addListener(dVar3);
        valueAnimatorOfFloat.addUpdateListener(dVar3);
        valueAnimatorOfFloat.setDuration(e4.a.g().f6233m);
        ValueAnimator valueAnimator = this.f8464b;
        if (valueAnimator != null) {
            dVar3.onAnimationCancel(valueAnimator);
        }
        this.f8464b = valueAnimatorOfFloat;
        valueAnimatorOfFloat.start();
    }

    public final void b() {
        MapView mapView = this.f8463a;
        mapView.f9049k.set(false);
        mapView.f9056s = null;
        this.f8464b = null;
        mapView.invalidate();
    }

    public final void c(d4.a aVar) {
        MapView mapView = this.f8463a;
        if (mapView.f9030H) {
            mapView.setExpectedCenter(aVar);
        } else {
            ((LinkedList) this.f8465c.f1596d).add(new e(4, null, aVar, null));
        }
    }

    public final double d(double d5) {
        return this.f8463a.g(d5);
    }

    public final boolean e(double d5, int i5, int i6) {
        MapView mapView = this.f8463a;
        double maxZoomLevel = d5 > mapView.getMaxZoomLevel() ? mapView.getMaxZoomLevel() : d5;
        if (maxZoomLevel < mapView.getMinZoomLevel()) {
            maxZoomLevel = mapView.getMinZoomLevel();
        }
        double zoomLevelDouble = mapView.getZoomLevelDouble();
        if (((maxZoomLevel >= zoomLevelDouble || mapView.f9043c <= mapView.getMinZoomLevel()) && (maxZoomLevel <= zoomLevelDouble || mapView.f9043c >= mapView.getMaxZoomLevel())) || mapView.f9049k.getAndSet(true)) {
            return false;
        }
        Iterator it = mapView.f9035N.iterator();
        if (it.hasNext()) {
            com.unified.ur1.SatelliteTracker.h.p(it.next());
            throw null;
        }
        mapView.f(i5, i6);
        mapView.f9036O = mapView.getZoomLevelDouble();
        Math.pow(2.0d, maxZoomLevel - zoomLevelDouble);
        d dVar = new d(this, Double.valueOf(zoomLevelDouble), Double.valueOf(maxZoomLevel), null, null, null);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(BitmapDescriptorFactory.HUE_RED, 1.0f);
        valueAnimatorOfFloat.addListener(dVar);
        valueAnimatorOfFloat.addUpdateListener(dVar);
        valueAnimatorOfFloat.setDuration(e4.a.g().n);
        this.f8464b = valueAnimatorOfFloat;
        valueAnimatorOfFloat.start();
        return true;
    }
}
