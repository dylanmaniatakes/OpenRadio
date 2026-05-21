package L1;

import D1.G;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import o1.o;
import r1.AbstractC0873a;

/* loaded from: classes.dex */
public final class b extends AbstractC0873a implements o {
    public static final Parcelable.Creator<b> CREATOR = new G(20);

    /* renamed from: j, reason: collision with root package name */
    public final int f1603j;

    /* renamed from: k, reason: collision with root package name */
    public final int f1604k;

    /* renamed from: l, reason: collision with root package name */
    public final Intent f1605l;

    public b(int i5, int i6, Intent intent) {
        this.f1603j = i5;
        this.f1604k = i6;
        this.f1605l = intent;
    }

    @Override // o1.o
    public final Status getStatus() {
        return this.f1604k == 0 ? Status.n : Status.f4638p;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int I = A2.b.I(20293, parcel);
        A2.b.M(parcel, 1, 4);
        parcel.writeInt(this.f1603j);
        A2.b.M(parcel, 2, 4);
        parcel.writeInt(this.f1604k);
        A2.b.D(parcel, 3, this.f1605l, i5);
        A2.b.K(I, parcel);
    }
}
