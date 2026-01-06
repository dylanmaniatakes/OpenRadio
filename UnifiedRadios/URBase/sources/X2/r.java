package X2;

import D1.G;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import r1.AbstractC0873a;

/* loaded from: classes.dex */
public final class r extends AbstractC0873a {
    public static final Parcelable.Creator<r> CREATOR = new G(25);

    /* renamed from: j, reason: collision with root package name */
    public final Bundle f2830j;

    /* renamed from: k, reason: collision with root package name */
    public q.b f2831k;

    /* renamed from: l, reason: collision with root package name */
    public j f2832l;

    public r(Bundle bundle) {
        this.f2830j = bundle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int I = A2.b.I(20293, parcel);
        A2.b.z(parcel, 2, this.f2830j);
        A2.b.K(I, parcel);
    }
}
