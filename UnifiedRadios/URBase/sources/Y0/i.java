package Y0;

import android.util.Base64;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final String f2912a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f2913b;

    /* renamed from: c, reason: collision with root package name */
    public final V0.d f2914c;

    public i(String str, byte[] bArr, V0.d dVar) {
        this.f2912a = str;
        this.f2913b = bArr;
        this.f2914c = dVar;
    }

    public static L0.m a() {
        L0.m mVar = new L0.m();
        mVar.f1558f = V0.d.f2512j;
        return mVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.f2912a.equals(iVar.f2912a) && Arrays.equals(this.f2913b, iVar.f2913b) && this.f2914c.equals(iVar.f2914c);
    }

    public final int hashCode() {
        return ((((this.f2912a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f2913b)) * 1000003) ^ this.f2914c.hashCode();
    }

    public final String toString() {
        byte[] bArr = this.f2913b;
        return "TransportContext(" + this.f2912a + ", " + this.f2914c + ", " + (bArr == null ? "" : Base64.encodeToString(bArr, 2)) + ")";
    }
}
