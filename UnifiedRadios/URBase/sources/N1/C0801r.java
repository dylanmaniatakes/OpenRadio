package n1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.measurement.AbstractC0399v1;
import r1.AbstractC0873a;

/* renamed from: n1.r, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0801r extends AbstractC0873a {
    public static final Parcelable.Creator<C0801r> CREATOR = new android.support.v4.media.c(22);

    /* renamed from: j, reason: collision with root package name */
    public final boolean f8768j;

    /* renamed from: k, reason: collision with root package name */
    public final String f8769k;

    /* renamed from: l, reason: collision with root package name */
    public final int f8770l;

    /* renamed from: m, reason: collision with root package name */
    public final int f8771m;

    public C0801r(String str, int i5, int i6, boolean z4) {
        this.f8768j = z4;
        this.f8769k = str;
        this.f8770l = AbstractC0399v1.k(i5) - 1;
        this.f8771m = android.support.v4.media.session.b.k(i6) - 1;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int I = A2.b.I(20293, parcel);
        A2.b.M(parcel, 1, 4);
        parcel.writeInt(this.f8768j ? 1 : 0);
        A2.b.E(parcel, 2, this.f8769k);
        A2.b.M(parcel, 3, 4);
        parcel.writeInt(this.f8770l);
        A2.b.M(parcel, 4, 4);
        parcel.writeInt(this.f8771m);
        A2.b.K(I, parcel);
    }
}
