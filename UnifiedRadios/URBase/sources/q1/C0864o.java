package q1;

import android.os.Parcel;
import android.os.Parcelable;
import r1.AbstractC0873a;

/* renamed from: q1.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0864o extends AbstractC0873a {
    public static final Parcelable.Creator<C0864o> CREATOR = new x(1);

    /* renamed from: j, reason: collision with root package name */
    public final int f9402j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f9403k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f9404l;

    /* renamed from: m, reason: collision with root package name */
    public final int f9405m;
    public final int n;

    public C0864o(int i5, boolean z4, boolean z5, int i6, int i7) {
        this.f9402j = i5;
        this.f9403k = z4;
        this.f9404l = z5;
        this.f9405m = i6;
        this.n = i7;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int I = A2.b.I(20293, parcel);
        A2.b.M(parcel, 1, 4);
        parcel.writeInt(this.f9402j);
        A2.b.M(parcel, 2, 4);
        parcel.writeInt(this.f9403k ? 1 : 0);
        A2.b.M(parcel, 3, 4);
        parcel.writeInt(this.f9404l ? 1 : 0);
        A2.b.M(parcel, 4, 4);
        parcel.writeInt(this.f9405m);
        A2.b.M(parcel, 5, 4);
        parcel.writeInt(this.n);
        A2.b.K(I, parcel);
    }
}
