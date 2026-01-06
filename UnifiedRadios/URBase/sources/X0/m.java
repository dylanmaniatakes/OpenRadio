package X0;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class m extends t {

    /* renamed from: a, reason: collision with root package name */
    public final long f2730a;

    /* renamed from: b, reason: collision with root package name */
    public final long f2731b;

    /* renamed from: c, reason: collision with root package name */
    public final r f2732c;

    /* renamed from: d, reason: collision with root package name */
    public final Integer f2733d;

    /* renamed from: e, reason: collision with root package name */
    public final String f2734e;

    /* renamed from: f, reason: collision with root package name */
    public final List f2735f;
    public final x g;

    public m(long j5, long j6, k kVar, Integer num, String str, ArrayList arrayList) {
        x xVar = x.f2745j;
        this.f2730a = j5;
        this.f2731b = j6;
        this.f2732c = kVar;
        this.f2733d = num;
        this.f2734e = str;
        this.f2735f = arrayList;
        this.g = xVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        if (this.f2730a == ((m) tVar).f2730a) {
            m mVar = (m) tVar;
            if (this.f2731b == mVar.f2731b) {
                r rVar = mVar.f2732c;
                r rVar2 = this.f2732c;
                if (rVar2 != null ? rVar2.equals(rVar) : rVar == null) {
                    Integer num = mVar.f2733d;
                    Integer num2 = this.f2733d;
                    if (num2 != null ? num2.equals(num) : num == null) {
                        String str = mVar.f2734e;
                        String str2 = this.f2734e;
                        if (str2 != null ? str2.equals(str) : str == null) {
                            List list = mVar.f2735f;
                            List list2 = this.f2735f;
                            if (list2 != null ? list2.equals(list) : list == null) {
                                x xVar = mVar.g;
                                x xVar2 = this.g;
                                if (xVar2 == null) {
                                    if (xVar == null) {
                                        return true;
                                    }
                                } else if (xVar2.equals(xVar)) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        long j5 = this.f2730a;
        long j6 = this.f2731b;
        int i5 = (((((int) (j5 ^ (j5 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j6 >>> 32) ^ j6))) * 1000003;
        r rVar = this.f2732c;
        int iHashCode = (i5 ^ (rVar == null ? 0 : rVar.hashCode())) * 1000003;
        Integer num = this.f2733d;
        int iHashCode2 = (iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.f2734e;
        int iHashCode3 = (iHashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List list = this.f2735f;
        int iHashCode4 = (iHashCode3 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        x xVar = this.g;
        return iHashCode4 ^ (xVar != null ? xVar.hashCode() : 0);
    }

    public final String toString() {
        return "LogRequest{requestTimeMs=" + this.f2730a + ", requestUptimeMs=" + this.f2731b + ", clientInfo=" + this.f2732c + ", logSource=" + this.f2733d + ", logSourceName=" + this.f2734e + ", logEvents=" + this.f2735f + ", qosTier=" + this.g + "}";
    }
}
