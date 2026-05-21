package Y0;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final V0.c f2921a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f2922b;

    public m(V0.c cVar, byte[] bArr) {
        if (cVar == null) {
            throw new NullPointerException("encoding is null");
        }
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        this.f2921a = cVar;
        this.f2922b = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        if (this.f2921a.equals(mVar.f2921a)) {
            return Arrays.equals(this.f2922b, mVar.f2922b);
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f2921a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f2922b);
    }

    public final String toString() {
        return "EncodedPayload{encoding=" + this.f2921a + ", bytes=[...]}";
    }
}
