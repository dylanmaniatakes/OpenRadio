package K;

import java.util.Locale;

/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static final Locale[] f1487a = {new Locale("en", "XA"), new Locale("ar", "XB")};

    public static Locale a(String str) {
        return Locale.forLanguageTag(str);
    }

    public static boolean b(Locale locale, Locale locale2) {
        if (locale.equals(locale2)) {
            return true;
        }
        if (!locale.getLanguage().equals(locale2.getLanguage())) {
            return false;
        }
        Locale[] localeArr = f1487a;
        int length = localeArr.length;
        int i5 = 0;
        while (true) {
            if (i5 >= length) {
                for (Locale locale3 : localeArr) {
                    if (!locale3.equals(locale2)) {
                    }
                }
                String strC = M.c.c(M.c.a(M.c.b(locale)));
                if (!strC.isEmpty()) {
                    return strC.equals(M.c.c(M.c.a(M.c.b(locale2))));
                }
                String country = locale.getCountry();
                return country.isEmpty() || country.equals(locale2.getCountry());
            }
            if (localeArr[i5].equals(locale)) {
                break;
            }
            i5++;
        }
        return false;
    }
}
