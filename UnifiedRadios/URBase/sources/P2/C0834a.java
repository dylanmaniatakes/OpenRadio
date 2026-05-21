package p2;

import P.h;
import P.j;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.SeekBar;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.material.slider.Slider;
import com.unified.ur1.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* renamed from: p2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0834a extends W.b {

    /* renamed from: q, reason: collision with root package name */
    public final c f9164q;

    /* renamed from: r, reason: collision with root package name */
    public final Rect f9165r;

    public C0834a(Slider slider) {
        super(slider);
        this.f9165r = new Rect();
        this.f9164q = slider;
    }

    @Override // W.b
    public final int n(float f5, float f6) {
        int i5 = 0;
        while (true) {
            c cVar = this.f9164q;
            if (i5 >= cVar.getValues().size()) {
                return -1;
            }
            Rect rect = this.f9165r;
            cVar.s(i5, rect);
            if (rect.contains((int) f5, (int) f6)) {
                return i5;
            }
            i5++;
        }
    }

    @Override // W.b
    public final void o(ArrayList arrayList) {
        for (int i5 = 0; i5 < this.f9164q.getValues().size(); i5++) {
            arrayList.add(Integer.valueOf(i5));
        }
    }

    @Override // W.b
    public final boolean s(int i5, int i6, Bundle bundle) {
        c cVar = this.f9164q;
        if (!cVar.isEnabled()) {
            return false;
        }
        if (i6 != 4096 && i6 != 8192) {
            if (i6 != 16908349 || bundle == null || !bundle.containsKey("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE") || !cVar.q(i5, bundle.getFloat("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE"))) {
                return false;
            }
            cVar.t();
            cVar.postInvalidate();
            p(i5);
            return true;
        }
        float fRound = cVar.f9184P;
        if (fRound == BitmapDescriptorFactory.HUE_RED) {
            fRound = 1.0f;
        }
        if ((cVar.f9180L - cVar.f9179K) / fRound > 20) {
            fRound *= Math.round(r1 / r5);
        }
        if (i6 == 8192) {
            fRound = -fRound;
        }
        if (cVar.i()) {
            fRound = -fRound;
        }
        float fFloatValue = cVar.getValues().get(i5).floatValue() + fRound;
        float valueFrom = cVar.getValueFrom();
        float valueTo = cVar.getValueTo();
        if (fFloatValue < valueFrom) {
            fFloatValue = valueFrom;
        } else if (fFloatValue > valueTo) {
            fFloatValue = valueTo;
        }
        if (!cVar.q(i5, fFloatValue)) {
            return false;
        }
        cVar.t();
        cVar.postInvalidate();
        p(i5);
        return true;
    }

    @Override // W.b
    public final void u(int i5, j jVar) {
        jVar.b(h.f2052m);
        c cVar = this.f9164q;
        List<Float> values = cVar.getValues();
        Float f5 = values.get(i5);
        float fFloatValue = f5.floatValue();
        float valueFrom = cVar.getValueFrom();
        float valueTo = cVar.getValueTo();
        if (cVar.isEnabled()) {
            if (fFloatValue > valueFrom) {
                jVar.a(8192);
            }
            if (fFloatValue < valueTo) {
                jVar.a(4096);
            }
        }
        AccessibilityNodeInfo.RangeInfo rangeInfoObtain = AccessibilityNodeInfo.RangeInfo.obtain(1, valueFrom, valueTo, fFloatValue);
        AccessibilityNodeInfo accessibilityNodeInfo = jVar.f2058a;
        accessibilityNodeInfo.setRangeInfo(rangeInfoObtain);
        jVar.f(SeekBar.class.getName());
        StringBuilder sb = new StringBuilder();
        if (cVar.getContentDescription() != null) {
            sb.append(cVar.getContentDescription());
            sb.append(",");
        }
        String str = String.format(((float) ((int) fFloatValue)) == fFloatValue ? "%.0f" : "%.2f", f5);
        String string = cVar.getContext().getString(R.string.material_slider_value);
        if (values.size() > 1) {
            string = i5 == cVar.getValues().size() - 1 ? cVar.getContext().getString(R.string.material_slider_range_end) : i5 == 0 ? cVar.getContext().getString(R.string.material_slider_range_start) : "";
        }
        Locale locale = Locale.US;
        sb.append(string + ", " + str);
        accessibilityNodeInfo.setContentDescription(sb.toString());
        Rect rect = this.f9165r;
        cVar.s(i5, rect);
        accessibilityNodeInfo.setBoundsInParent(rect);
    }
}
