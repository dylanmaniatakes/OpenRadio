package n0;

import F3.i;
import a.AbstractC0203a;
import com.unified.ur1.SatelliteTracker.h;
import java.util.Locale;

/* renamed from: n0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0779a {

    /* renamed from: a, reason: collision with root package name */
    public final String f8702a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8703b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f8704c;

    /* renamed from: d, reason: collision with root package name */
    public final int f8705d;

    /* renamed from: e, reason: collision with root package name */
    public final String f8706e;

    /* renamed from: f, reason: collision with root package name */
    public final int f8707f;
    public final int g;

    public C0779a(String str, String str2, boolean z4, int i5, String str3, int i6) {
        this.f8702a = str;
        this.f8703b = str2;
        this.f8704c = z4;
        this.f8705d = i5;
        this.f8706e = str3;
        this.f8707f = i6;
        Locale locale = Locale.US;
        i.e(locale, "US");
        String upperCase = str2.toUpperCase(locale);
        i.e(upperCase, "this as java.lang.String).toUpperCase(locale)");
        this.g = M3.e.z(upperCase, "INT") ? 3 : (M3.e.z(upperCase, "CHAR") || M3.e.z(upperCase, "CLOB") || M3.e.z(upperCase, "TEXT")) ? 2 : M3.e.z(upperCase, "BLOB") ? 5 : (M3.e.z(upperCase, "REAL") || M3.e.z(upperCase, "FLOA") || M3.e.z(upperCase, "DOUB")) ? 4 : 1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0779a)) {
            return false;
        }
        C0779a c0779a = (C0779a) obj;
        if (this.f8705d != c0779a.f8705d) {
            return false;
        }
        if (!i.a(this.f8702a, c0779a.f8702a) || this.f8704c != c0779a.f8704c) {
            return false;
        }
        int i5 = c0779a.f8707f;
        String str = c0779a.f8706e;
        String str2 = this.f8706e;
        int i6 = this.f8707f;
        if (i6 == 1 && i5 == 2 && str2 != null && !AbstractC0203a.f(str2, str)) {
            return false;
        }
        if (i6 != 2 || i5 != 1 || str == null || AbstractC0203a.f(str, str2)) {
            return (i6 == 0 || i6 != i5 || (str2 == null ? str == null : AbstractC0203a.f(str2, str))) && this.g == c0779a.g;
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.f8702a.hashCode() * 31) + this.g) * 31) + (this.f8704c ? 1231 : 1237)) * 31) + this.f8705d;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Column{name='");
        sb.append(this.f8702a);
        sb.append("', type='");
        sb.append(this.f8703b);
        sb.append("', affinity='");
        sb.append(this.g);
        sb.append("', notNull=");
        sb.append(this.f8704c);
        sb.append(", primaryKeyPosition=");
        sb.append(this.f8705d);
        sb.append(", defaultValue='");
        String str = this.f8706e;
        if (str == null) {
            str = "undefined";
        }
        return h.e(sb, str, "'}");
    }
}
