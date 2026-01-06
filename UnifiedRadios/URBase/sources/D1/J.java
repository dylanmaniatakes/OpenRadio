package D1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.Locale;
import r1.AbstractC0873a;

/* loaded from: classes.dex */
public final class J extends AbstractC0873a implements Geofence {
    public static final Parcelable.Creator<J> CREATOR = new G(3);

    /* renamed from: j, reason: collision with root package name */
    public final String f353j;

    /* renamed from: k, reason: collision with root package name */
    public final long f354k;

    /* renamed from: l, reason: collision with root package name */
    public final short f355l;

    /* renamed from: m, reason: collision with root package name */
    public final double f356m;
    public final double n;

    /* renamed from: o, reason: collision with root package name */
    public final float f357o;

    /* renamed from: p, reason: collision with root package name */
    public final int f358p;

    /* renamed from: q, reason: collision with root package name */
    public final int f359q;

    /* renamed from: r, reason: collision with root package name */
    public final int f360r;

    public J(String str, int i5, short s4, double d5, double d6, float f5, long j5, int i6, int i7) {
        if (str == null || str.length() > 100) {
            throw new IllegalArgumentException("requestId is null or too long: ".concat(String.valueOf(str)));
        }
        if (f5 <= BitmapDescriptorFactory.HUE_RED) {
            StringBuilder sb = new StringBuilder(String.valueOf(f5).length() + 16);
            sb.append("invalid radius: ");
            sb.append(f5);
            throw new IllegalArgumentException(sb.toString());
        }
        if (d5 > 90.0d || d5 < -90.0d) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(d5).length() + 18);
            sb2.append("invalid latitude: ");
            sb2.append(d5);
            throw new IllegalArgumentException(sb2.toString());
        }
        if (d6 > 180.0d || d6 < -180.0d) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(d6).length() + 19);
            sb3.append("invalid longitude: ");
            sb3.append(d6);
            throw new IllegalArgumentException(sb3.toString());
        }
        int i8 = i5 & 7;
        if (i8 == 0) {
            StringBuilder sb4 = new StringBuilder(String.valueOf(i5).length() + 35);
            sb4.append("No supported transition specified: ");
            sb4.append(i5);
            throw new IllegalArgumentException(sb4.toString());
        }
        this.f355l = s4;
        this.f353j = str;
        this.f356m = d5;
        this.n = d6;
        this.f357o = f5;
        this.f354k = j5;
        this.f358p = i8;
        this.f359q = i6;
        this.f360r = i7;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof J) {
            J j5 = (J) obj;
            if (this.f357o == j5.f357o && this.f356m == j5.f356m && this.n == j5.n && this.f355l == j5.f355l && this.f358p == j5.f358p) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.location.Geofence
    public final long getExpirationTime() {
        return this.f354k;
    }

    @Override // com.google.android.gms.location.Geofence
    public final double getLatitude() {
        return this.f356m;
    }

    @Override // com.google.android.gms.location.Geofence
    public final int getLoiteringDelay() {
        return this.f360r;
    }

    @Override // com.google.android.gms.location.Geofence
    public final double getLongitude() {
        return this.n;
    }

    @Override // com.google.android.gms.location.Geofence
    public final int getNotificationResponsiveness() {
        return this.f359q;
    }

    @Override // com.google.android.gms.location.Geofence
    public final float getRadius() {
        return this.f357o;
    }

    @Override // com.google.android.gms.location.Geofence
    public final String getRequestId() {
        return this.f353j;
    }

    @Override // com.google.android.gms.location.Geofence
    public final int getTransitionTypes() {
        return this.f358p;
    }

    public final int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.f356m);
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.n);
        return ((((Float.floatToIntBits(this.f357o) + ((((((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32))) + 31) * 31) + ((int) (jDoubleToLongBits2 ^ (jDoubleToLongBits2 >>> 32)))) * 31)) * 31) + this.f355l) * 31) + this.f358p;
    }

    public final String toString() {
        Locale locale = Locale.US;
        short s4 = this.f355l;
        return String.format(locale, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", s4 != -1 ? s4 != 1 ? "UNKNOWN" : "CIRCLE" : "INVALID", this.f353j.replaceAll("\\p{C}", "?"), Integer.valueOf(this.f358p), Double.valueOf(this.f356m), Double.valueOf(this.n), Float.valueOf(this.f357o), Integer.valueOf(this.f359q / 1000), Integer.valueOf(this.f360r), Long.valueOf(this.f354k));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int I = A2.b.I(20293, parcel);
        A2.b.E(parcel, 1, this.f353j);
        A2.b.M(parcel, 2, 8);
        parcel.writeLong(this.f354k);
        A2.b.M(parcel, 3, 4);
        parcel.writeInt(this.f355l);
        A2.b.M(parcel, 4, 8);
        parcel.writeDouble(this.f356m);
        A2.b.M(parcel, 5, 8);
        parcel.writeDouble(this.n);
        A2.b.M(parcel, 6, 4);
        parcel.writeFloat(this.f357o);
        A2.b.M(parcel, 7, 4);
        parcel.writeInt(this.f358p);
        A2.b.M(parcel, 8, 4);
        parcel.writeInt(this.f359q);
        A2.b.M(parcel, 9, 4);
        parcel.writeInt(this.f360r);
        A2.b.K(I, parcel);
    }
}
