package Q0;

import android.text.TextUtils;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final String f2143a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2144b;

    public f(String str, String str2) {
        this.f2143a = str;
        this.f2144b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f.class != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        return TextUtils.equals(this.f2143a, fVar.f2143a) && TextUtils.equals(this.f2144b, fVar.f2144b);
    }

    public final int hashCode() {
        return this.f2144b.hashCode() + (this.f2143a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Header[name=");
        sb.append(this.f2143a);
        sb.append(",value=");
        return com.unified.ur1.SatelliteTracker.h.e(sb, this.f2144b, "]");
    }
}
