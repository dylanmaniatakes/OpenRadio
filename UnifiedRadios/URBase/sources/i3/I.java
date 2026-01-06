package i3;

/* loaded from: classes.dex */
public final class I {

    /* renamed from: a, reason: collision with root package name */
    public final String f7291a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7292b;

    /* renamed from: c, reason: collision with root package name */
    public final String f7293c;

    public I(String str, String str2, String str3) {
        this.f7291a = str == null ? "" : str;
        this.f7292b = str2 == null ? "" : str2;
        this.f7293c = str3 == null ? "" : str3;
    }

    public final String a() {
        String strB = b();
        boolean zIsEmpty = strB.isEmpty();
        String str = this.f7291a;
        if (zIsEmpty) {
            return str;
        }
        return str + " (" + strB + ")";
    }

    public final String b() {
        StringBuilder sb = new StringBuilder();
        String str = this.f7292b;
        if (str != null && !str.trim().isEmpty()) {
            sb.append(str.trim());
        }
        String str2 = this.f7293c;
        if (str2 != null && !str2.trim().isEmpty()) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(str2.trim());
        }
        return sb.toString();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("User{callsign='");
        sb.append(this.f7291a);
        sb.append("', firstName='");
        sb.append(this.f7292b);
        sb.append("', lastName='");
        return com.unified.ur1.SatelliteTracker.h.e(sb, this.f7293c, "'}");
    }
}
