package q1;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import n1.C0787d;
import r1.AbstractC0873a;

/* loaded from: classes.dex */
public final class L extends AbstractC0873a {
    public static final Parcelable.Creator<L> CREATOR = new x(2);

    /* renamed from: j, reason: collision with root package name */
    public Bundle f9320j;

    /* renamed from: k, reason: collision with root package name */
    public C0787d[] f9321k;

    /* renamed from: l, reason: collision with root package name */
    public int f9322l;

    /* renamed from: m, reason: collision with root package name */
    public C0856g f9323m;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int I = A2.b.I(20293, parcel);
        A2.b.z(parcel, 1, this.f9320j);
        A2.b.G(parcel, 2, this.f9321k, i5);
        A2.b.M(parcel, 3, 4);
        parcel.writeInt(this.f9322l);
        A2.b.D(parcel, 4, this.f9323m, i5);
        A2.b.K(I, parcel);
    }
}
