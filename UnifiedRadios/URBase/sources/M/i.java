package M;

import android.text.TextUtils;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class i {
    public static int a(Locale locale) {
        return TextUtils.getLayoutDirectionFromLocale(locale);
    }
}
