package D1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import r1.AbstractC0873a;

/* loaded from: classes.dex */
public final class X extends AbstractC0873a implements o1.o {
    public static final Parcelable.Creator<X> CREATOR = new G(8);

    /* renamed from: j, reason: collision with root package name */
    public final Status f386j;

    public X(Status status) {
        this.f386j = status;
    }

    @Override // o1.o
    public final Status getStatus() {
        return this.f386j;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int I = A2.b.I(20293, parcel);
        A2.b.D(parcel, 1, this.f386j, i5);
        A2.b.K(I, parcel);
    }
}
