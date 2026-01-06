package V0;

import com.unified.ur1.SatelliteTracker.h;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f2511a;

    public c(String str) {
        if (str == null) {
            throw new NullPointerException("name is null");
        }
        this.f2511a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        return this.f2511a.equals(((c) obj).f2511a);
    }

    public final int hashCode() {
        return this.f2511a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return h.e(new StringBuilder("Encoding{name=\""), this.f2511a, "\"}");
    }
}
