package Y0;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final String f2906a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f2907b;

    /* renamed from: c, reason: collision with root package name */
    public final m f2908c;

    /* renamed from: d, reason: collision with root package name */
    public final long f2909d;

    /* renamed from: e, reason: collision with root package name */
    public final long f2910e;

    /* renamed from: f, reason: collision with root package name */
    public final Map f2911f;

    public h(String str, Integer num, m mVar, long j5, long j6, Map map) {
        this.f2906a = str;
        this.f2907b = num;
        this.f2908c = mVar;
        this.f2909d = j5;
        this.f2910e = j6;
        this.f2911f = map;
    }

    public final String a(String str) {
        String str2 = (String) this.f2911f.get(str);
        return str2 == null ? "" : str2;
    }

    public final int b(String str) {
        String str2 = (String) this.f2911f.get(str);
        if (str2 == null) {
            return 0;
        }
        return Integer.valueOf(str2).intValue();
    }

    public final X2.n c() {
        X2.n nVar = new X2.n();
        String str = this.f2906a;
        if (str == null) {
            throw new NullPointerException("Null transportName");
        }
        nVar.f2818a = str;
        nVar.f2819b = this.f2907b;
        m mVar = this.f2908c;
        if (mVar == null) {
            throw new NullPointerException("Null encodedPayload");
        }
        nVar.f2820c = mVar;
        nVar.f2821d = Long.valueOf(this.f2909d);
        nVar.f2822e = Long.valueOf(this.f2910e);
        nVar.f2823f = new HashMap(this.f2911f);
        return nVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (this.f2906a.equals(hVar.f2906a)) {
            Integer num = hVar.f2907b;
            Integer num2 = this.f2907b;
            if (num2 != null ? num2.equals(num) : num == null) {
                if (this.f2908c.equals(hVar.f2908c) && this.f2909d == hVar.f2909d && this.f2910e == hVar.f2910e && this.f2911f.equals(hVar.f2911f)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.f2906a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f2907b;
        int iHashCode2 = (((iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003) ^ this.f2908c.hashCode()) * 1000003;
        long j5 = this.f2909d;
        int i5 = (iHashCode2 ^ ((int) (j5 ^ (j5 >>> 32)))) * 1000003;
        long j6 = this.f2910e;
        return ((i5 ^ ((int) (j6 ^ (j6 >>> 32)))) * 1000003) ^ this.f2911f.hashCode();
    }

    public final String toString() {
        return "EventInternal{transportName=" + this.f2906a + ", code=" + this.f2907b + ", encodedPayload=" + this.f2908c + ", eventMillis=" + this.f2909d + ", uptimeMillis=" + this.f2910e + ", autoMetadata=" + this.f2911f + "}";
    }
}
