package O;

import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.unified.ur1.R;
import java.util.List;

/* loaded from: classes.dex */
public final class o0 extends r0 {
    public static void e(View view) {
        V1.e eVarJ = j(view);
        if (eVarJ != null) {
            ((View) eVarJ.f2532d).setTranslationY(BitmapDescriptorFactory.HUE_RED);
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i5 = 0; i5 < viewGroup.getChildCount(); i5++) {
                e(viewGroup.getChildAt(i5));
            }
        }
    }

    public static void f(View view, WindowInsets windowInsets, boolean z4) {
        V1.e eVarJ = j(view);
        if (eVarJ != null) {
            eVarJ.f2531c = windowInsets;
            if (!z4) {
                View view2 = (View) eVarJ.f2532d;
                int[] iArr = (int[]) eVarJ.f2533e;
                view2.getLocationOnScreen(iArr);
                z4 = true;
                eVarJ.f2529a = iArr[1];
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i5 = 0; i5 < viewGroup.getChildCount(); i5++) {
                f(viewGroup.getChildAt(i5), windowInsets, z4);
            }
        }
    }

    public static void g(View view, F0 f02, List list) {
        V1.e eVarJ = j(view);
        if (eVarJ != null) {
            eVarJ.e(f02, list);
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i5 = 0; i5 < viewGroup.getChildCount(); i5++) {
                g(viewGroup.getChildAt(i5), f02, list);
            }
        }
    }

    public static void h(View view, L0.c cVar) {
        V1.e eVarJ = j(view);
        if (eVarJ != null) {
            View view2 = (View) eVarJ.f2532d;
            int[] iArr = (int[]) eVarJ.f2533e;
            view2.getLocationOnScreen(iArr);
            int i5 = eVarJ.f2529a - iArr[1];
            eVarJ.f2530b = i5;
            view2.setTranslationY(i5);
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i6 = 0; i6 < viewGroup.getChildCount(); i6++) {
                h(viewGroup.getChildAt(i6), cVar);
            }
        }
    }

    public static WindowInsets i(View view, WindowInsets windowInsets) {
        return view.getTag(R.id.tag_on_apply_window_listener) != null ? windowInsets : view.onApplyWindowInsets(windowInsets);
    }

    public static V1.e j(View view) {
        Object tag = view.getTag(R.id.tag_window_insets_animation_callback);
        if (tag instanceof n0) {
            return ((n0) tag).f1944a;
        }
        return null;
    }
}
