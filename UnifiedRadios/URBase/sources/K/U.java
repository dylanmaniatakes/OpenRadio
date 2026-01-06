package k;

import android.os.LocaleList;
import android.widget.TextView;

/* loaded from: classes.dex */
public abstract class U {
    public static LocaleList a(String str) {
        return LocaleList.forLanguageTags(str);
    }

    public static void b(TextView textView, LocaleList localeList) {
        textView.setTextLocales(localeList);
    }
}
