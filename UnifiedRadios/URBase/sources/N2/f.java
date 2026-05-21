package n2;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* loaded from: classes.dex */
public final class f extends e {

    /* renamed from: k, reason: collision with root package name */
    public final float f8786k;

    public f(float f5) {
        super(0);
        this.f8786k = f5 - 0.001f;
    }

    @Override // n2.e
    public final void e(float f5, float f6, float f7, w wVar) {
        double d5 = this.f8786k;
        float fSqrt = (float) ((Math.sqrt(2.0d) * d5) / 2.0d);
        float fSqrt2 = (float) Math.sqrt(Math.pow(d5, 2.0d) - Math.pow(fSqrt, 2.0d));
        wVar.d(f6 - fSqrt, ((float) (-((Math.sqrt(2.0d) * d5) - d5))) + fSqrt2, 270.0f, BitmapDescriptorFactory.HUE_RED);
        wVar.c(f6, (float) (-((Math.sqrt(2.0d) * d5) - d5)));
        wVar.c(f6 + fSqrt, ((float) (-((Math.sqrt(2.0d) * d5) - d5))) + fSqrt2);
    }
}
