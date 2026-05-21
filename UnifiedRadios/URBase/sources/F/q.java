package f;

import android.content.res.Configuration;
import android.os.LocaleList;

/* loaded from: classes.dex */
public abstract class q {
    public static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
        LocaleList locales = configuration.getLocales();
        LocaleList locales2 = configuration2.getLocales();
        if (locales.equals(locales2)) {
            return;
        }
        configuration3.setLocales(locales2);
        configuration3.locale = configuration2.locale;
    }

    public static K.i b(Configuration configuration) {
        return K.i.a(configuration.getLocales().toLanguageTags());
    }

    public static void c(K.i iVar) {
        LocaleList.setDefault(LocaleList.forLanguageTags(iVar.f1489a.f1490a.toLanguageTags()));
    }

    public static void d(Configuration configuration, K.i iVar) {
        configuration.setLocales(LocaleList.forLanguageTags(iVar.f1489a.f1490a.toLanguageTags()));
    }
}
