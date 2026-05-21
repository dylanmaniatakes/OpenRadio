package X1;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.U;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.material.carousel.CarouselLayoutManager;
import com.unified.ur1.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class c extends U {

    /* renamed from: a, reason: collision with root package name */
    public final Paint f2750a;

    /* renamed from: b, reason: collision with root package name */
    public final List f2751b;

    public c() {
        Paint paint = new Paint();
        this.f2750a = paint;
        this.f2751b = Collections.unmodifiableList(new ArrayList());
        paint.setStrokeWidth(5.0f);
        paint.setColor(-65281);
    }

    @Override // androidx.recyclerview.widget.U
    public final void b(Canvas canvas, RecyclerView recyclerView) {
        Paint paint = this.f2750a;
        paint.setStrokeWidth(recyclerView.getResources().getDimension(R.dimen.m3_carousel_debug_keyline_width));
        for (f fVar : this.f2751b) {
            fVar.getClass();
            ThreadLocal threadLocal = E.a.f417a;
            float f5 = 1.0f - BitmapDescriptorFactory.HUE_RED;
            paint.setColor(Color.argb((int) ((Color.alpha(-16776961) * BitmapDescriptorFactory.HUE_RED) + (Color.alpha(-65281) * f5)), (int) ((Color.red(-16776961) * BitmapDescriptorFactory.HUE_RED) + (Color.red(-65281) * f5)), (int) ((Color.green(-16776961) * BitmapDescriptorFactory.HUE_RED) + (Color.green(-65281) * f5)), (int) ((Color.blue(-16776961) * BitmapDescriptorFactory.HUE_RED) + (Color.blue(-65281) * f5))));
            if (((CarouselLayoutManager) recyclerView.getLayoutManager()).F0()) {
                float fG = ((CarouselLayoutManager) recyclerView.getLayoutManager()).f5255p.g();
                float fC = ((CarouselLayoutManager) recyclerView.getLayoutManager()).f5255p.c();
                fVar.getClass();
                canvas.drawLine(BitmapDescriptorFactory.HUE_RED, fG, BitmapDescriptorFactory.HUE_RED, fC, paint);
            } else {
                float fD = ((CarouselLayoutManager) recyclerView.getLayoutManager()).f5255p.d();
                float fE = ((CarouselLayoutManager) recyclerView.getLayoutManager()).f5255p.e();
                fVar.getClass();
                canvas.drawLine(fD, BitmapDescriptorFactory.HUE_RED, fE, BitmapDescriptorFactory.HUE_RED, paint);
            }
        }
    }
}
