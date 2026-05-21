package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: classes.dex */
public final class u0 implements Parcelable {
    public static final Parcelable.Creator<u0> CREATOR = new android.support.v4.media.c(9);

    /* renamed from: j, reason: collision with root package name */
    public int f4337j;

    /* renamed from: k, reason: collision with root package name */
    public int f4338k;

    /* renamed from: l, reason: collision with root package name */
    public int f4339l;

    /* renamed from: m, reason: collision with root package name */
    public int[] f4340m;
    public int n;

    /* renamed from: o, reason: collision with root package name */
    public int[] f4341o;

    /* renamed from: p, reason: collision with root package name */
    public List f4342p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f4343q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f4344r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f4345s;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        parcel.writeInt(this.f4337j);
        parcel.writeInt(this.f4338k);
        parcel.writeInt(this.f4339l);
        if (this.f4339l > 0) {
            parcel.writeIntArray(this.f4340m);
        }
        parcel.writeInt(this.n);
        if (this.n > 0) {
            parcel.writeIntArray(this.f4341o);
        }
        parcel.writeInt(this.f4343q ? 1 : 0);
        parcel.writeInt(this.f4344r ? 1 : 0);
        parcel.writeInt(this.f4345s ? 1 : 0);
        parcel.writeList(this.f4342p);
    }
}
