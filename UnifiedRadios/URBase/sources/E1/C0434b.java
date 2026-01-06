package e1;

import java.util.HashMap;
import java.util.Map;

/* renamed from: e1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0434b {

    /* renamed from: a, reason: collision with root package name */
    public final h1.d f6151a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f6152b;

    public C0434b(h1.d dVar, HashMap map) {
        this.f6151a = dVar;
        this.f6152b = map;
    }

    public final long a(V0.d dVar, long j5, int i5) {
        long jA = j5 - this.f6151a.a();
        C0435c c0435c = (C0435c) this.f6152b.get(dVar);
        long j6 = c0435c.f6153a;
        return Math.min(Math.max((long) (Math.pow(3.0d, i5 - 1) * j6 * Math.max(1.0d, Math.log(10000.0d) / Math.log((j6 > 1 ? j6 : 2L) * r12))), jA), c0435c.f6154b);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0434b)) {
            return false;
        }
        C0434b c0434b = (C0434b) obj;
        return this.f6151a.equals(c0434b.f6151a) && this.f6152b.equals(c0434b.f6152b);
    }

    public final int hashCode() {
        return ((this.f6151a.hashCode() ^ 1000003) * 1000003) ^ this.f6152b.hashCode();
    }

    public final String toString() {
        return "SchedulerConfig{clock=" + this.f6151a + ", values=" + this.f6152b + "}";
    }
}
