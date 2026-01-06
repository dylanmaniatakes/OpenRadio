package J1;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import r1.AbstractC0873a;

/* loaded from: classes.dex */
public final class N1 extends AbstractC0873a {
    public static final Parcelable.Creator<N1> CREATOR = new D1.G(15);

    /* renamed from: j, reason: collision with root package name */
    public final long f903j;

    /* renamed from: k, reason: collision with root package name */
    public byte[] f904k;

    /* renamed from: l, reason: collision with root package name */
    public final String f905l;

    /* renamed from: m, reason: collision with root package name */
    public final Bundle f906m;
    public final int n;

    /* renamed from: o, reason: collision with root package name */
    public final long f907o;

    /* renamed from: p, reason: collision with root package name */
    public String f908p;

    public N1(long j5, byte[] bArr, String str, Bundle bundle, int i5, long j6, String str2) {
        this.f903j = j5;
        this.f904k = bArr;
        this.f905l = str;
        this.f906m = bundle;
        this.n = i5;
        this.f907o = j6;
        this.f908p = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int I = A2.b.I(20293, parcel);
        A2.b.M(parcel, 1, 8);
        parcel.writeLong(this.f903j);
        byte[] bArr = this.f904k;
        if (bArr != null) {
            int I2 = A2.b.I(2, parcel);
            parcel.writeByteArray(bArr);
            A2.b.K(I2, parcel);
        }
        A2.b.E(parcel, 3, this.f905l);
        A2.b.z(parcel, 4, this.f906m);
        A2.b.M(parcel, 5, 4);
        parcel.writeInt(this.n);
        A2.b.M(parcel, 6, 8);
        parcel.writeLong(this.f907o);
        A2.b.E(parcel, 7, this.f908p);
        A2.b.K(I, parcel);
    }
}
