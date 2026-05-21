package V1;

import O.G;
import O.Y;
import android.animation.ValueAnimator;
import android.widget.TextView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Iterator;
import java.util.WeakHashMap;
import n2.g;
import n2.h;
import v2.C0921a;

/* loaded from: classes.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2516a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2517b;

    public /* synthetic */ a(int i5, Object obj) {
        this.f2516a = i5;
        this.f2517b = obj;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        Object obj = this.f2517b;
        switch (this.f2516a) {
            case 0:
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                h hVar = ((BottomSheetBehavior) obj).f5216i;
                if (hVar != null) {
                    g gVar = hVar.f8806c;
                    if (gVar.f8794j != fFloatValue) {
                        gVar.f8794j = fFloatValue;
                        hVar.g = true;
                        hVar.invalidateSelf();
                        break;
                    }
                }
                break;
            case 1:
                float fFloatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                TextView textView = (TextView) obj;
                textView.setScaleX(fFloatValue2);
                textView.setScaleY(fFloatValue2);
                break;
            case 2:
                l4.b bVar = (l4.b) obj;
                if (!bVar.f8435i) {
                    bVar.h = 1.0f - ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (!bVar.f8435i) {
                        bVar.f8430b.postInvalidate();
                        break;
                    }
                } else {
                    bVar.f8431c.cancel();
                    break;
                }
                break;
            case 3:
                float fFloatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                p2.c cVar = (p2.c) obj;
                Iterator it = cVar.f9210m.iterator();
                while (it.hasNext()) {
                    C0921a c0921a = (C0921a) it.next();
                    c0921a.f10026N = 1.2f;
                    c0921a.f10024L = fFloatValue3;
                    c0921a.f10025M = fFloatValue3;
                    c0921a.f10027O = P1.a.b(BitmapDescriptorFactory.HUE_RED, 1.0f, 0.19f, 1.0f, fFloatValue3);
                    c0921a.invalidateSelf();
                }
                WeakHashMap weakHashMap = Y.f1904a;
                G.k(cVar);
                break;
            default:
                ((TextInputLayout) obj).f5478w0.k(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
        }
    }
}
