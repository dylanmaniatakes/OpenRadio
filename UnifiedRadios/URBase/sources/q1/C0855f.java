package q1;

import android.os.Parcel;
import android.os.Parcelable;
import r1.AbstractC0873a;

/* renamed from: q1.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0855f extends AbstractC0873a {
    public static final Parcelable.Creator<C0855f> CREATOR = new android.support.v4.media.c(26);

    /* renamed from: j, reason: collision with root package name */
    public final int f9366j;

    /* renamed from: k, reason: collision with root package name */
    public final String f9367k;

    public C0855f(int i5, String str) {
        this.f9366j = i5;
        this.f9367k = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0855f)) {
            return false;
        }
        C0855f c0855f = (C0855f) obj;
        return c0855f.f9366j == this.f9366j && E.l(c0855f.f9367k, this.f9367k);
    }

    public final int hashCode() {
        return this.f9366j;
    }

    public final String toString() {
        return this.f9366j + ":" + this.f9367k;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int I = A2.b.I(20293, parcel);
        A2.b.M(parcel, 1, 4);
        parcel.writeInt(this.f9366j);
        A2.b.E(parcel, 2, this.f9367k);
        A2.b.K(I, parcel);
    }
}
