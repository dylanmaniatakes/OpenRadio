package e1;

import java.util.Set;

/* renamed from: e1.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0435c {

    /* renamed from: a, reason: collision with root package name */
    public final long f6153a;

    /* renamed from: b, reason: collision with root package name */
    public final long f6154b;

    /* renamed from: c, reason: collision with root package name */
    public final Set f6155c;

    public C0435c(long j5, long j6, Set set) {
        this.f6153a = j5;
        this.f6154b = j6;
        this.f6155c = set;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0435c)) {
            return false;
        }
        C0435c c0435c = (C0435c) obj;
        return this.f6153a == c0435c.f6153a && this.f6154b == c0435c.f6154b && this.f6155c.equals(c0435c.f6155c);
    }

    public final int hashCode() {
        long j5 = this.f6153a;
        int i5 = (((int) (j5 ^ (j5 >>> 32))) ^ 1000003) * 1000003;
        long j6 = this.f6154b;
        return ((i5 ^ ((int) ((j6 >>> 32) ^ j6))) * 1000003) ^ this.f6155c.hashCode();
    }

    public final String toString() {
        return "ConfigValue{delta=" + this.f6153a + ", maxAllowedDelay=" + this.f6154b + ", flags=" + this.f6155c + "}";
    }
}
