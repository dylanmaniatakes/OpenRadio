package androidx.recyclerview.widget;

import android.animation.ValueAnimator;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: androidx.recyclerview.widget.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0272t implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f4330j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f4331k;

    public /* synthetic */ RunnableC0272t(int i5, Object obj) {
        this.f4330j = i5;
        this.f4331k = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj = this.f4331k;
        switch (this.f4330j) {
            case 0:
                C0276x c0276x = (C0276x) obj;
                int i5 = c0276x.f4363A;
                ValueAnimator valueAnimator = c0276x.f4387z;
                if (i5 == 1) {
                    valueAnimator.cancel();
                } else if (i5 != 2) {
                }
                c0276x.f4363A = 3;
                valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), BitmapDescriptorFactory.HUE_RED);
                valueAnimator.setDuration(500);
                valueAnimator.start();
                break;
            default:
                ((StaggeredGridLayoutManager) obj).D0();
                break;
        }
    }
}
