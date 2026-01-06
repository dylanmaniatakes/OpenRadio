package l2;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.Color;

/* renamed from: l2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0742a {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f8389a = {R.attr.state_pressed};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f8390b = {R.attr.state_focused};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f8391c = {R.attr.state_selected, R.attr.state_pressed};

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f8392d = {R.attr.state_selected};

    public static int a(ColorStateList colorStateList, int[] iArr) {
        int colorForState = colorStateList != null ? colorStateList.getColorForState(iArr, colorStateList.getDefaultColor()) : 0;
        return E.a.d(colorForState, Math.min(Color.alpha(colorForState) * 2, 255));
    }

    public static ColorStateList b(ColorStateList colorStateList) {
        return colorStateList != null ? colorStateList : ColorStateList.valueOf(0);
    }
}
