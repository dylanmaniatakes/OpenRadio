package g2;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.HashMap;
import w0.v;

/* renamed from: g2.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0547k extends w0.p {
    @Override // w0.p
    public final void d(v vVar) {
        View view = vVar.f10114b;
        if (view instanceof TextView) {
            vVar.f10113a.put("android:textscale:scale", Float.valueOf(((TextView) view).getScaleX()));
        }
    }

    @Override // w0.p
    public final void g(v vVar) {
        View view = vVar.f10114b;
        if (view instanceof TextView) {
            vVar.f10113a.put("android:textscale:scale", Float.valueOf(((TextView) view).getScaleX()));
        }
    }

    @Override // w0.p
    public final Animator k(ViewGroup viewGroup, v vVar, v vVar2) {
        if (vVar != null && vVar2 != null && (vVar.f10114b instanceof TextView)) {
            View view = vVar2.f10114b;
            if (view instanceof TextView) {
                TextView textView = (TextView) view;
                HashMap map = vVar.f10113a;
                HashMap map2 = vVar2.f10113a;
                float fFloatValue = map.get("android:textscale:scale") != null ? ((Float) map.get("android:textscale:scale")).floatValue() : 1.0f;
                float fFloatValue2 = map2.get("android:textscale:scale") != null ? ((Float) map2.get("android:textscale:scale")).floatValue() : 1.0f;
                if (fFloatValue == fFloatValue2) {
                    return null;
                }
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fFloatValue, fFloatValue2);
                valueAnimatorOfFloat.addUpdateListener(new V1.a(1, textView));
                return valueAnimatorOfFloat;
            }
        }
        return null;
    }
}
