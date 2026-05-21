package k4;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class d implements d4.a, Parcelable, Serializable, Cloneable {
    public static final Parcelable.Creator<d> CREATOR = new android.support.v4.media.c(19);

    /* renamed from: j, reason: collision with root package name */
    public double f8264j;

    /* renamed from: k, reason: collision with root package name */
    public double f8265k;

    /* renamed from: l, reason: collision with root package name */
    public double f8266l;

    public d(double d5, double d6) {
        this.f8265k = d5;
        this.f8264j = d6;
    }

    public final Object clone() {
        double d5 = this.f8265k;
        double d6 = this.f8264j;
        d dVar = new d();
        dVar.f8265k = d5;
        dVar.f8264j = d6;
        dVar.f8266l = this.f8266l;
        return dVar;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != d.class) {
            return false;
        }
        d dVar = (d) obj;
        return dVar.f8265k == this.f8265k && dVar.f8264j == this.f8264j && dVar.f8266l == this.f8266l;
    }

    public final int hashCode() {
        return (((((int) (this.f8265k * 1.0E-6d)) * 17) + ((int) (this.f8264j * 1.0E-6d))) * 37) + ((int) this.f8266l);
    }

    public final String toString() {
        return this.f8265k + "," + this.f8264j + "," + this.f8266l;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        parcel.writeDouble(this.f8265k);
        parcel.writeDouble(this.f8264j);
        parcel.writeDouble(this.f8266l);
    }
}
