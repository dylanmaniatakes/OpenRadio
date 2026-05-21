package J1;

import android.os.Parcel;
import android.os.Parcelable;
import r1.AbstractC0873a;

/* loaded from: classes.dex */
public final class K1 extends AbstractC0873a {
    public static final Parcelable.Creator<K1> CREATOR = new D1.G(14);

    /* renamed from: j, reason: collision with root package name */
    public final String f881j;

    /* renamed from: k, reason: collision with root package name */
    public final long f882k;

    /* renamed from: l, reason: collision with root package name */
    public final int f883l;

    public K1(int i5, String str, long j5) {
        this.f881j = str;
        this.f882k = j5;
        this.f883l = i5;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int I = A2.b.I(20293, parcel);
        A2.b.E(parcel, 1, this.f881j);
        A2.b.M(parcel, 2, 8);
        parcel.writeLong(this.f882k);
        A2.b.M(parcel, 3, 4);
        parcel.writeInt(this.f883l);
        A2.b.K(I, parcel);
    }
}
