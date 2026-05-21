package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class Z implements Parcelable {
    public static final Parcelable.Creator<Z> CREATOR = new android.support.v4.media.c(6);

    /* renamed from: j, reason: collision with root package name */
    public final String f3730j;

    /* renamed from: k, reason: collision with root package name */
    public final String f3731k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f3732l;

    /* renamed from: m, reason: collision with root package name */
    public final int f3733m;
    public final int n;

    /* renamed from: o, reason: collision with root package name */
    public final String f3734o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f3735p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f3736q;

    /* renamed from: r, reason: collision with root package name */
    public final boolean f3737r;

    /* renamed from: s, reason: collision with root package name */
    public final Bundle f3738s;

    /* renamed from: t, reason: collision with root package name */
    public final boolean f3739t;

    /* renamed from: u, reason: collision with root package name */
    public final int f3740u;

    /* renamed from: v, reason: collision with root package name */
    public Bundle f3741v;

    public Z(Fragment fragment) {
        this.f3730j = fragment.getClass().getName();
        this.f3731k = fragment.mWho;
        this.f3732l = fragment.mFromLayout;
        this.f3733m = fragment.mFragmentId;
        this.n = fragment.mContainerId;
        this.f3734o = fragment.mTag;
        this.f3735p = fragment.mRetainInstance;
        this.f3736q = fragment.mRemoving;
        this.f3737r = fragment.mDetached;
        this.f3738s = fragment.mArguments;
        this.f3739t = fragment.mHidden;
        this.f3740u = fragment.mMaxState.ordinal();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f3730j);
        sb.append(" (");
        sb.append(this.f3731k);
        sb.append(")}:");
        if (this.f3732l) {
            sb.append(" fromLayout");
        }
        int i5 = this.n;
        if (i5 != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(i5));
        }
        String str = this.f3734o;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(str);
        }
        if (this.f3735p) {
            sb.append(" retainInstance");
        }
        if (this.f3736q) {
            sb.append(" removing");
        }
        if (this.f3737r) {
            sb.append(" detached");
        }
        if (this.f3739t) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        parcel.writeString(this.f3730j);
        parcel.writeString(this.f3731k);
        parcel.writeInt(this.f3732l ? 1 : 0);
        parcel.writeInt(this.f3733m);
        parcel.writeInt(this.n);
        parcel.writeString(this.f3734o);
        parcel.writeInt(this.f3735p ? 1 : 0);
        parcel.writeInt(this.f3736q ? 1 : 0);
        parcel.writeInt(this.f3737r ? 1 : 0);
        parcel.writeBundle(this.f3738s);
        parcel.writeInt(this.f3739t ? 1 : 0);
        parcel.writeBundle(this.f3741v);
        parcel.writeInt(this.f3740u);
    }

    public Z(Parcel parcel) {
        this.f3730j = parcel.readString();
        this.f3731k = parcel.readString();
        this.f3732l = parcel.readInt() != 0;
        this.f3733m = parcel.readInt();
        this.n = parcel.readInt();
        this.f3734o = parcel.readString();
        this.f3735p = parcel.readInt() != 0;
        this.f3736q = parcel.readInt() != 0;
        this.f3737r = parcel.readInt() != 0;
        this.f3738s = parcel.readBundle();
        this.f3739t = parcel.readInt() != 0;
        this.f3741v = parcel.readBundle();
        this.f3740u = parcel.readInt();
    }
}
