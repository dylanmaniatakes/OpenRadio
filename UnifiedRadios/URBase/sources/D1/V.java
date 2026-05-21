package D1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.DeviceOrientationRequest;
import java.util.Collections;
import java.util.List;
import r1.AbstractC0873a;

/* loaded from: classes.dex */
public final class V extends AbstractC0873a {

    /* renamed from: j, reason: collision with root package name */
    public final DeviceOrientationRequest f379j;

    /* renamed from: k, reason: collision with root package name */
    public final List f380k;

    /* renamed from: l, reason: collision with root package name */
    public final String f381l;

    /* renamed from: m, reason: collision with root package name */
    public static final List f378m = Collections.emptyList();
    public static final DeviceOrientationRequest n = new DeviceOrientationRequest.Builder(DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT).build();
    public static final Parcelable.Creator<V> CREATOR = new G(6);

    public V(DeviceOrientationRequest deviceOrientationRequest, List list, String str) {
        this.f379j = deviceOrientationRequest;
        this.f380k = list;
        this.f381l = str;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof V)) {
            return false;
        }
        V v4 = (V) obj;
        return q1.E.l(this.f379j, v4.f379j) && q1.E.l(this.f380k, v4.f380k) && q1.E.l(this.f381l, v4.f381l);
    }

    public final int hashCode() {
        return this.f379j.hashCode();
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f379j);
        String strValueOf2 = String.valueOf(this.f380k);
        int length = strValueOf.length();
        int length2 = strValueOf2.length();
        String str = this.f381l;
        StringBuilder sb = new StringBuilder(length + 68 + length2 + 7 + String.valueOf(str).length() + 2);
        sb.append("DeviceOrientationRequestInternal[deviceOrientationRequest=");
        sb.append(strValueOf);
        sb.append(", clients=");
        sb.append(strValueOf2);
        sb.append(", tag='");
        sb.append(str);
        sb.append("']");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int I = A2.b.I(20293, parcel);
        A2.b.D(parcel, 1, this.f379j, i5);
        A2.b.H(parcel, 2, this.f380k);
        A2.b.E(parcel, 3, this.f381l);
        A2.b.K(I, parcel);
    }
}
