package n2;

import com.google.android.gms.internal.measurement.AbstractC0409x1;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* loaded from: classes.dex */
public final class k extends AbstractC0409x1 {
    @Override // com.google.android.gms.internal.measurement.AbstractC0409x1
    public final void g(w wVar, float f5, float f6) {
        wVar.d(BitmapDescriptorFactory.HUE_RED, f6 * f5, 180.0f, 90.0f);
        float f7 = f6 * 2.0f * f5;
        s sVar = new s(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, f7, f7);
        sVar.f8870f = 180.0f;
        sVar.g = 90.0f;
        wVar.g.add(sVar);
        q qVar = new q(sVar);
        wVar.a(180.0f);
        wVar.h.add(qVar);
        wVar.f8880e = 270.0f;
        float f8 = (BitmapDescriptorFactory.HUE_RED + f7) * 0.5f;
        float f9 = (f7 - BitmapDescriptorFactory.HUE_RED) / 2.0f;
        double d5 = 270.0f;
        wVar.f8878c = (((float) Math.cos(Math.toRadians(d5))) * f9) + f8;
        wVar.f8879d = (f9 * ((float) Math.sin(Math.toRadians(d5)))) + f8;
    }
}
