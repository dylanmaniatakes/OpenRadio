package Z2;

import com.unified.ur1.SatelliteTracker.h;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f3141a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3142b;

    public a(String str, String str2) {
        this.f3141a = str;
        if (str2 == null) {
            throw new NullPointerException("Null version");
        }
        this.f3142b = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f3141a.equals(aVar.f3141a) && this.f3142b.equals(aVar.f3142b);
    }

    public final int hashCode() {
        return ((this.f3141a.hashCode() ^ 1000003) * 1000003) ^ this.f3142b.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("LibraryVersion{libraryName=");
        sb.append(this.f3141a);
        sb.append(", version=");
        return h.e(sb, this.f3142b, "}");
    }
}
