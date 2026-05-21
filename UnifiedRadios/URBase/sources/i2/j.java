package i2;

import B0.p;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class j extends V.b {
    public static final Parcelable.Creator<j> CREATOR = new p(8);

    /* renamed from: l, reason: collision with root package name */
    public Bundle f7262l;

    public j(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f7262l = parcel.readBundle(classLoader == null ? j.class.getClassLoader() : classLoader);
    }

    @Override // V.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        super.writeToParcel(parcel, i5);
        parcel.writeBundle(this.f7262l);
    }
}
