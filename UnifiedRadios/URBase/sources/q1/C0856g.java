package q1;

import android.os.Parcel;
import android.os.Parcelable;
import r1.AbstractC0873a;

/* renamed from: q1.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0856g extends AbstractC0873a {
    public static final Parcelable.Creator<C0856g> CREATOR = new x(3);

    /* renamed from: j, reason: collision with root package name */
    public final C0864o f9368j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f9369k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f9370l;

    /* renamed from: m, reason: collision with root package name */
    public final int[] f9371m;
    public final int n;

    /* renamed from: o, reason: collision with root package name */
    public final int[] f9372o;

    public C0856g(C0864o c0864o, boolean z4, boolean z5, int[] iArr, int i5, int[] iArr2) {
        this.f9368j = c0864o;
        this.f9369k = z4;
        this.f9370l = z5;
        this.f9371m = iArr;
        this.n = i5;
        this.f9372o = iArr2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int I = A2.b.I(20293, parcel);
        A2.b.D(parcel, 1, this.f9368j, i5);
        A2.b.M(parcel, 2, 4);
        parcel.writeInt(this.f9369k ? 1 : 0);
        A2.b.M(parcel, 3, 4);
        parcel.writeInt(this.f9370l ? 1 : 0);
        A2.b.C(parcel, 4, this.f9371m);
        A2.b.M(parcel, 5, 4);
        parcel.writeInt(this.n);
        A2.b.C(parcel, 6, this.f9372o);
        A2.b.K(I, parcel);
    }
}
