package J1;

import android.os.Parcel;
import android.os.Parcelable;
import r1.AbstractC0873a;

/* renamed from: J1.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0059d extends AbstractC0873a {
    public static final Parcelable.Creator<C0059d> CREATOR = new D1.G(9);

    /* renamed from: j, reason: collision with root package name */
    public final long f1187j;

    /* renamed from: k, reason: collision with root package name */
    public final int f1188k;

    /* renamed from: l, reason: collision with root package name */
    public final long f1189l;

    public C0059d(long j5, int i5, long j6) {
        this.f1187j = j5;
        this.f1188k = i5;
        this.f1189l = j6;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int I = A2.b.I(20293, parcel);
        A2.b.M(parcel, 1, 8);
        parcel.writeLong(this.f1187j);
        A2.b.M(parcel, 2, 4);
        parcel.writeInt(this.f1188k);
        A2.b.M(parcel, 3, 8);
        parcel.writeLong(this.f1189l);
        A2.b.K(I, parcel);
    }
}
