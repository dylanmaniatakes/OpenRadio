package X0;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class j extends p {

    /* renamed from: a, reason: collision with root package name */
    public final List f2721a;

    public j(ArrayList arrayList) {
        this.f2721a = arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        return this.f2721a.equals(((j) ((p) obj)).f2721a);
    }

    public final int hashCode() {
        return this.f2721a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return "BatchedLogRequest{logRequests=" + this.f2721a + "}";
    }
}
