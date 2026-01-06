package l4;

import android.widget.ZoomButtonsController;
import org.osmdroid.views.MapView;

/* loaded from: classes.dex */
public final class j implements ZoomButtonsController.OnZoomListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MapView f8472a;

    public j(MapView mapView) {
        this.f8472a = mapView;
    }

    @Override // android.widget.ZoomButtonsController.OnZoomListener
    public final void onVisibilityChanged(boolean z4) {
    }

    @Override // android.widget.ZoomButtonsController.OnZoomListener
    public final void onZoom(boolean z4) {
        MapView mapView = this.f8472a;
        if (z4) {
            f fVar = (f) mapView.getController();
            double zoomLevelDouble = fVar.f8463a.getZoomLevelDouble() + 1.0d;
            MapView mapView2 = fVar.f8463a;
            fVar.e(zoomLevelDouble, mapView2.getWidth() / 2, mapView2.getHeight() / 2);
            return;
        }
        f fVar2 = (f) mapView.getController();
        double zoomLevelDouble2 = fVar2.f8463a.getZoomLevelDouble() - 1.0d;
        MapView mapView3 = fVar2.f8463a;
        fVar2.e(zoomLevelDouble2, mapView3.getWidth() / 2, mapView3.getHeight() / 2);
    }
}
