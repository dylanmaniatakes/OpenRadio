package P1;

import android.util.Property;
import android.view.ViewGroup;
import com.unified.ur1.R;

/* loaded from: classes.dex */
public final class b extends Property {

    /* renamed from: a, reason: collision with root package name */
    public static final b f2069a = new b(Float.class, "childrenAlpha");

    @Override // android.util.Property
    public final Object get(Object obj) {
        Float f5 = (Float) ((ViewGroup) obj).getTag(R.id.mtrl_internal_children_alpha_tag);
        return f5 != null ? f5 : Float.valueOf(1.0f);
    }

    @Override // android.util.Property
    public final void set(Object obj, Object obj2) {
        ViewGroup viewGroup = (ViewGroup) obj;
        Float f5 = (Float) obj2;
        float fFloatValue = f5.floatValue();
        viewGroup.setTag(R.id.mtrl_internal_children_alpha_tag, f5);
        int childCount = viewGroup.getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            viewGroup.getChildAt(i5).setAlpha(fFloatValue);
        }
    }
}
