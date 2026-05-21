package W1;

import B0.p;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class b extends V.b {
    public static final Parcelable.Creator<b> CREATOR = new p(3);

    /* renamed from: l, reason: collision with root package name */
    public boolean f2587l;

    public b(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        if (classLoader == null) {
            b.class.getClassLoader();
        }
        this.f2587l = parcel.readInt() == 1;
    }

    @Override // V.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        super.writeToParcel(parcel, i5);
        parcel.writeInt(this.f2587l ? 1 : 0);
    }
}
