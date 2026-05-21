package V;

import B0.p;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public abstract class b implements Parcelable {

    /* renamed from: j, reason: collision with root package name */
    public final Parcelable f2507j;

    /* renamed from: k, reason: collision with root package name */
    public static final a f2506k = new a();
    public static final Parcelable.Creator<b> CREATOR = new p(1);

    public b() {
        this.f2507j = null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeParcelable(this.f2507j, i5);
    }

    public b(Parcelable parcelable) {
        if (parcelable != null) {
            this.f2507j = parcelable == f2506k ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    public b(Parcel parcel, ClassLoader classLoader) {
        Parcelable parcelable = parcel.readParcelable(classLoader);
        this.f2507j = parcelable == null ? f2506k : parcelable;
    }
}
