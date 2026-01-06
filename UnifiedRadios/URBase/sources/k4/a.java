package k4;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import org.osmdroid.views.MapView;

/* loaded from: classes.dex */
public final class a implements Parcelable, Serializable {
    public static final Parcelable.Creator<a> CREATOR = new android.support.v4.media.c(18);

    /* renamed from: j, reason: collision with root package name */
    public double f8257j;

    /* renamed from: k, reason: collision with root package name */
    public double f8258k;

    /* renamed from: l, reason: collision with root package name */
    public double f8259l;

    /* renamed from: m, reason: collision with root package name */
    public double f8260m;

    public a(double d5, double d6, double d7, double d8) {
        this.f8257j = d5;
        this.f8259l = d6;
        this.f8258k = d7;
        this.f8260m = d8;
        e4.a.g().getClass();
    }

    public final double a() {
        double d5 = this.f8260m;
        double d6 = this.f8259l;
        double d7 = (d6 + d5) / 2.0d;
        if (d6 < d5) {
            d7 += 180.0d;
        }
        MapView.getTileSystem().getClass();
        return t.c(d7);
    }

    public final Object clone() {
        return new a(this.f8257j, this.f8259l, this.f8258k, this.f8260m);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer("N:");
        stringBuffer.append(this.f8257j);
        stringBuffer.append("; E:");
        stringBuffer.append(this.f8259l);
        stringBuffer.append("; S:");
        stringBuffer.append(this.f8258k);
        stringBuffer.append("; W:");
        stringBuffer.append(this.f8260m);
        return stringBuffer.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        parcel.writeDouble(this.f8257j);
        parcel.writeDouble(this.f8259l);
        parcel.writeDouble(this.f8258k);
        parcel.writeDouble(this.f8260m);
    }
}
