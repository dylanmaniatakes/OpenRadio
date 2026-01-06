package a0;

import android.view.animation.Interpolator;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* loaded from: classes.dex */
public abstract class b implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    public final float[] f3169a;

    /* renamed from: b, reason: collision with root package name */
    public final float f3170b;

    public b(float[] fArr) {
        this.f3169a = fArr;
        this.f3170b = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f5) {
        if (f5 >= 1.0f) {
            return 1.0f;
        }
        if (f5 <= BitmapDescriptorFactory.HUE_RED) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        float[] fArr = this.f3169a;
        int iMin = Math.min((int) ((fArr.length - 1) * f5), fArr.length - 2);
        float f6 = this.f3170b;
        float f7 = (f5 - (iMin * f6)) / f6;
        float f8 = fArr[iMin];
        return ((fArr[iMin + 1] - f8) * f7) + f8;
    }
}
