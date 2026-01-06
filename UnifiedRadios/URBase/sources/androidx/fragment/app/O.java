package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class O implements Parcelable {
    public static final Parcelable.Creator<O> CREATOR = new android.support.v4.media.c(4);

    /* renamed from: j, reason: collision with root package name */
    public String f3679j;

    /* renamed from: k, reason: collision with root package name */
    public int f3680k;

    public O(String str, int i5) {
        this.f3679j = str;
        this.f3680k = i5;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        parcel.writeString(this.f3679j);
        parcel.writeInt(this.f3680k);
    }
}
