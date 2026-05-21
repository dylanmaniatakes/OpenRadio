package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class V implements Parcelable {
    public static final Parcelable.Creator<V> CREATOR = new android.support.v4.media.c(5);

    /* renamed from: j, reason: collision with root package name */
    public ArrayList f3718j;

    /* renamed from: k, reason: collision with root package name */
    public ArrayList f3719k;

    /* renamed from: l, reason: collision with root package name */
    public C0207b[] f3720l;

    /* renamed from: m, reason: collision with root package name */
    public int f3721m;
    public String n;

    /* renamed from: o, reason: collision with root package name */
    public ArrayList f3722o;

    /* renamed from: p, reason: collision with root package name */
    public ArrayList f3723p;

    /* renamed from: q, reason: collision with root package name */
    public ArrayList f3724q;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        parcel.writeTypedList(this.f3718j);
        parcel.writeStringList(this.f3719k);
        parcel.writeTypedArray(this.f3720l, i5);
        parcel.writeInt(this.f3721m);
        parcel.writeString(this.n);
        parcel.writeStringList(this.f3722o);
        parcel.writeTypedList(this.f3723p);
        parcel.writeTypedList(this.f3724q);
    }
}
