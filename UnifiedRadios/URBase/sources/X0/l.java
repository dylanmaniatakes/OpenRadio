package X0;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class l extends s {

    /* renamed from: a, reason: collision with root package name */
    public final long f2724a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f2725b;

    /* renamed from: c, reason: collision with root package name */
    public final long f2726c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f2727d;

    /* renamed from: e, reason: collision with root package name */
    public final String f2728e;

    /* renamed from: f, reason: collision with root package name */
    public final long f2729f;
    public final w g;

    public l(long j5, Integer num, long j6, byte[] bArr, String str, long j7, o oVar) {
        this.f2724a = j5;
        this.f2725b = num;
        this.f2726c = j6;
        this.f2727d = bArr;
        this.f2728e = str;
        this.f2729f = j7;
        this.g = oVar;
    }

    public final boolean equals(Object obj) {
        Integer num;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        if (this.f2724a == ((l) sVar).f2724a && ((num = this.f2725b) != null ? num.equals(((l) sVar).f2725b) : ((l) sVar).f2725b == null)) {
            l lVar = (l) sVar;
            if (this.f2726c == lVar.f2726c) {
                if (Arrays.equals(this.f2727d, sVar instanceof l ? ((l) sVar).f2727d : lVar.f2727d)) {
                    String str = lVar.f2728e;
                    String str2 = this.f2728e;
                    if (str2 != null ? str2.equals(str) : str == null) {
                        if (this.f2729f == lVar.f2729f) {
                            w wVar = lVar.g;
                            w wVar2 = this.g;
                            if (wVar2 == null) {
                                if (wVar == null) {
                                    return true;
                                }
                            } else if (wVar2.equals(wVar)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        long j5 = this.f2724a;
        int i5 = (((int) (j5 ^ (j5 >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.f2725b;
        int iHashCode = (i5 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        long j6 = this.f2726c;
        int iHashCode2 = (((iHashCode ^ ((int) (j6 ^ (j6 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.f2727d)) * 1000003;
        String str = this.f2728e;
        int iHashCode3 = (iHashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        long j7 = this.f2729f;
        int i6 = (iHashCode3 ^ ((int) (j7 ^ (j7 >>> 32)))) * 1000003;
        w wVar = this.g;
        return i6 ^ (wVar != null ? wVar.hashCode() : 0);
    }

    public final String toString() {
        return "LogEvent{eventTimeMs=" + this.f2724a + ", eventCode=" + this.f2725b + ", eventUptimeMs=" + this.f2726c + ", sourceExtension=" + Arrays.toString(this.f2727d) + ", sourceExtensionJsonProto3=" + this.f2728e + ", timezoneOffsetSeconds=" + this.f2729f + ", networkConnectionInfo=" + this.g + "}";
    }
}
