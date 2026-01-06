package k;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: k.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0635i implements Parcelable {
    public static final Parcelable.Creator<C0635i> CREATOR = new android.support.v4.media.c(15);

    /* renamed from: j, reason: collision with root package name */
    public int f7785j;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        parcel.writeInt(this.f7785j);
    }
}
