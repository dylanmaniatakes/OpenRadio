package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class F implements Parcelable {
    public static final Parcelable.Creator<F> CREATOR = new android.support.v4.media.c(7);

    /* renamed from: j, reason: collision with root package name */
    public int f4018j;

    /* renamed from: k, reason: collision with root package name */
    public int f4019k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f4020l;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        parcel.writeInt(this.f4018j);
        parcel.writeInt(this.f4019k);
        parcel.writeInt(this.f4020l ? 1 : 0);
    }
}
