package J1;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import r1.AbstractC0873a;

/* loaded from: classes.dex */
public final class P1 extends AbstractC0873a {
    public static final Parcelable.Creator<P1> CREATOR = new D1.G(17);

    /* renamed from: j, reason: collision with root package name */
    public final List f929j;

    public P1(List list) {
        this.f929j = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int I = A2.b.I(20293, parcel);
        A2.b.H(parcel, 1, this.f929j);
        A2.b.K(I, parcel);
    }
}
