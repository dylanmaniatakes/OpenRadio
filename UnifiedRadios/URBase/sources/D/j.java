package D;

import android.content.res.ColorStateList;
import android.content.res.Resources;

/* loaded from: classes.dex */
public abstract class j {
    public static int a(Resources resources, int i5, Resources.Theme theme) {
        return resources.getColor(i5, theme);
    }

    public static ColorStateList b(Resources resources, int i5, Resources.Theme theme) {
        return resources.getColorStateList(i5, theme);
    }
}
