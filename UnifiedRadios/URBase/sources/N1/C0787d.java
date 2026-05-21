package n1;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import r1.AbstractC0873a;

/* renamed from: n1.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0787d extends AbstractC0873a {
    public static final Parcelable.Creator<C0787d> CREATOR = new android.support.v4.media.c(21);

    /* renamed from: j, reason: collision with root package name */
    public final String f8734j;

    /* renamed from: k, reason: collision with root package name */
    public final int f8735k;

    /* renamed from: l, reason: collision with root package name */
    public final long f8736l;

    public C0787d(int i5, String str, long j5) {
        this.f8734j = str;
        this.f8735k = i5;
        this.f8736l = j5;
    }

    public final long a() {
        long j5 = this.f8736l;
        return j5 == -1 ? this.f8735k : j5;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C0787d) {
            C0787d c0787d = (C0787d) obj;
            String str = this.f8734j;
            if (((str != null && str.equals(c0787d.f8734j)) || (str == null && c0787d.f8734j == null)) && a() == c0787d.a()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f8734j, Long.valueOf(a())});
    }

    public final String toString() {
        L0.c cVar = new L0.c(this);
        cVar.b(this.f8734j, "name");
        cVar.b(Long.valueOf(a()), "version");
        return cVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int I = A2.b.I(20293, parcel);
        A2.b.E(parcel, 1, this.f8734j);
        A2.b.M(parcel, 2, 4);
        parcel.writeInt(this.f8735k);
        long jA = a();
        A2.b.M(parcel, 3, 8);
        parcel.writeLong(jA);
        A2.b.K(I, parcel);
    }

    public C0787d(long j5, String str) {
        this.f8734j = str;
        this.f8736l = j5;
        this.f8735k = -1;
    }
}
