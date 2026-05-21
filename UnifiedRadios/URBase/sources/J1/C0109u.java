package J1;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Iterator;
import r1.AbstractC0873a;

/* renamed from: J1.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0109u extends AbstractC0873a implements Iterable {
    public static final Parcelable.Creator<C0109u> CREATOR = new D1.G(12);

    /* renamed from: j, reason: collision with root package name */
    public final Bundle f1395j;

    public C0109u(Bundle bundle) {
        this.f1395j = bundle;
    }

    public final Bundle a() {
        return new Bundle(this.f1395j);
    }

    public final Double b() {
        return Double.valueOf(this.f1395j.getDouble("value"));
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new C0106t(this);
    }

    public final String toString() {
        return this.f1395j.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int I = A2.b.I(20293, parcel);
        A2.b.z(parcel, 2, a());
        A2.b.K(I, parcel);
    }
}
