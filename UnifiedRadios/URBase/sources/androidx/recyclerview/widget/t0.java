package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class t0 implements Parcelable {
    public static final Parcelable.Creator<t0> CREATOR = new android.support.v4.media.c(8);

    /* renamed from: j, reason: collision with root package name */
    public int f4332j;

    /* renamed from: k, reason: collision with root package name */
    public int f4333k;

    /* renamed from: l, reason: collision with root package name */
    public int[] f4334l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f4335m;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "FullSpanItem{mPosition=" + this.f4332j + ", mGapDir=" + this.f4333k + ", mHasUnwantedGapAfter=" + this.f4335m + ", mGapPerSpan=" + Arrays.toString(this.f4334l) + '}';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        parcel.writeInt(this.f4332j);
        parcel.writeInt(this.f4333k);
        parcel.writeInt(this.f4335m ? 1 : 0);
        int[] iArr = this.f4334l;
        if (iArr == null || iArr.length <= 0) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(iArr.length);
            parcel.writeIntArray(this.f4334l);
        }
    }
}
