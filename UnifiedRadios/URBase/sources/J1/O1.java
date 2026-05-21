package J1;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import r1.AbstractC0873a;

/* loaded from: classes.dex */
public final class O1 extends AbstractC0873a {
    public static final Parcelable.Creator<O1> CREATOR = new D1.G(16);

    /* renamed from: j, reason: collision with root package name */
    public final List f925j;

    public O1(ArrayList arrayList) {
        this.f925j = arrayList;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int I = A2.b.I(20293, parcel);
        List list = this.f925j;
        if (list != null) {
            int I2 = A2.b.I(1, parcel);
            int size = list.size();
            parcel.writeInt(size);
            for (int i6 = 0; i6 < size; i6++) {
                parcel.writeInt(((Integer) list.get(i6)).intValue());
            }
            A2.b.K(I2, parcel);
        }
        A2.b.K(I, parcel);
    }
}
