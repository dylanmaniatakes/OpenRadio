package m4;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;
import java.util.concurrent.atomic.AtomicInteger;
import org.osmdroid.views.MapView;

/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f8674a = new AtomicInteger();

    static {
        new Rect();
    }

    public e() {
        MapView.getTileSystem().getClass();
        e4.a.g().getClass();
    }

    public abstract void a(Canvas canvas, l4.l lVar);

    public abstract void b(MapView mapView);

    public boolean c(MotionEvent motionEvent, MapView mapView) {
        return false;
    }

    public boolean d(MotionEvent motionEvent, MapView mapView) {
        return false;
    }
}
