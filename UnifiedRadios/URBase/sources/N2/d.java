package n2;

import com.google.android.gms.internal.measurement.AbstractC0409x1;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* loaded from: classes.dex */
public final class d extends AbstractC0409x1 {
    @Override // com.google.android.gms.internal.measurement.AbstractC0409x1
    public final void g(w wVar, float f5, float f6) {
        wVar.d(BitmapDescriptorFactory.HUE_RED, f6 * f5, 180.0f, 90.0f);
        double d5 = f6;
        double d6 = f5;
        wVar.c((float) (Math.sin(Math.toRadians(90.0f)) * d5 * d6), (float) (Math.sin(Math.toRadians(BitmapDescriptorFactory.HUE_RED)) * d5 * d6));
    }
}
