package J1;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import r1.AbstractC0873a;

/* renamed from: J1.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0074i extends AbstractC0873a {
    public static final Parcelable.Creator<C0074i> CREATOR = new D1.G(11);

    /* renamed from: j, reason: collision with root package name */
    public final Bundle f1254j;

    public C0074i(Bundle bundle) {
        this.f1254j = bundle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int I = A2.b.I(20293, parcel);
        A2.b.z(parcel, 1, this.f1254j);
        A2.b.K(I, parcel);
    }
}
