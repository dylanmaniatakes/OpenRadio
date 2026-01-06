package Z0;

import s.AbstractC0882e;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f3063a;

    /* renamed from: b, reason: collision with root package name */
    public final long f3064b;

    public a(int i5, long j5) {
        if (i5 == 0) {
            throw new NullPointerException("Null status");
        }
        this.f3063a = i5;
        this.f3064b = j5;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return AbstractC0882e.a(this.f3063a, aVar.f3063a) && this.f3064b == aVar.f3064b;
    }

    public final int hashCode() {
        int iC = (AbstractC0882e.c(this.f3063a) ^ 1000003) * 1000003;
        long j5 = this.f3064b;
        return iC ^ ((int) (j5 ^ (j5 >>> 32)));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BackendResponse{status=");
        int i5 = this.f3063a;
        sb.append(i5 != 1 ? i5 != 2 ? i5 != 3 ? i5 != 4 ? "null" : "INVALID_PAYLOAD" : "FATAL_ERROR" : "TRANSIENT_ERROR" : "OK");
        sb.append(", nextRequestWaitMillis=");
        sb.append(this.f3064b);
        sb.append("}");
        return sb.toString();
    }
}
