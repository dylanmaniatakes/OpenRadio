package K;

import java.util.Locale;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: b, reason: collision with root package name */
    public static final i f1488b = new i(new j(h.a(new Locale[0])));

    /* renamed from: a, reason: collision with root package name */
    public final j f1489a;

    public i(j jVar) {
        this.f1489a = jVar;
    }

    public static i a(String str) {
        if (str == null || str.isEmpty()) {
            return f1488b;
        }
        String[] strArrSplit = str.split(",", -1);
        int length = strArrSplit.length;
        Locale[] localeArr = new Locale[length];
        for (int i5 = 0; i5 < length; i5++) {
            localeArr[i5] = g.a(strArrSplit[i5]);
        }
        return new i(new j(h.a(localeArr)));
    }

    public final boolean equals(Object obj) {
        if (obj instanceof i) {
            if (this.f1489a.equals(((i) obj).f1489a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f1489a.hashCode();
    }

    public final String toString() {
        return this.f1489a.toString();
    }
}
