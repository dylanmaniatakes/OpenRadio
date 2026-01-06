package k;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class Q0 extends V.b {
    public static final Parcelable.Creator<Q0> CREATOR = new B0.p(9);

    /* renamed from: l, reason: collision with root package name */
    public boolean f7686l;

    public Q0(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f7686l = ((Boolean) parcel.readValue(null)).booleanValue();
    }

    public final String toString() {
        return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f7686l + "}";
    }

    @Override // V.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        super.writeToParcel(parcel, i5);
        parcel.writeValue(Boolean.valueOf(this.f7686l));
    }
}
