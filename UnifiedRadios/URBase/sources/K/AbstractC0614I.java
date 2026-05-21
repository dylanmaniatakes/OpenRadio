package k;

import android.content.res.Resources;
import android.widget.ThemedSpinnerAdapter;

/* renamed from: k.I, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0614I {
    public static void a(ThemedSpinnerAdapter themedSpinnerAdapter, Resources.Theme theme) {
        if (N.b.a(themedSpinnerAdapter.getDropDownViewTheme(), theme)) {
            return;
        }
        themedSpinnerAdapter.setDropDownViewTheme(theme);
    }
}
