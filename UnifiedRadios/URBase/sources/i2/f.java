package i2;

import android.os.Parcel;
import android.os.Parcelable;
import g2.C0542f;

/* loaded from: classes.dex */
public final class f implements Parcelable {
    public static final Parcelable.Creator<f> CREATOR = new android.support.v4.media.c(14);

    /* renamed from: j, reason: collision with root package name */
    public int f7257j;

    /* renamed from: k, reason: collision with root package name */
    public C0542f f7258k;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        parcel.writeInt(this.f7257j);
        parcel.writeParcelable(this.f7258k, 0);
    }
}
