package m1;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import r1.AbstractC0873a;

/* renamed from: m1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0760a extends AbstractC0873a {
    public static final Parcelable.Creator<C0760a> CREATOR = new c(0);

    /* renamed from: j, reason: collision with root package name */
    public final Intent f8510j;

    public C0760a(Intent intent) {
        this.f8510j = intent;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int I = A2.b.I(20293, parcel);
        A2.b.D(parcel, 1, this.f8510j, i5);
        A2.b.K(I, parcel);
    }
}
