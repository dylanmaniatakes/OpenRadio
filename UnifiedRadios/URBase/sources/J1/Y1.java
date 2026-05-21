package J1;

import android.os.Parcel;
import android.os.Parcelable;
import r1.AbstractC0873a;

/* loaded from: classes.dex */
public final class Y1 extends AbstractC0873a {
    public static final Parcelable.Creator<Y1> CREATOR = new D1.G(18);

    /* renamed from: j, reason: collision with root package name */
    public final int f1070j;

    /* renamed from: k, reason: collision with root package name */
    public final String f1071k;

    /* renamed from: l, reason: collision with root package name */
    public final long f1072l;

    /* renamed from: m, reason: collision with root package name */
    public final Long f1073m;
    public final String n;

    /* renamed from: o, reason: collision with root package name */
    public final String f1074o;

    /* renamed from: p, reason: collision with root package name */
    public final Double f1075p;

    public Y1(int i5, String str, long j5, Long l5, Float f5, String str2, String str3, Double d5) {
        this.f1070j = i5;
        this.f1071k = str;
        this.f1072l = j5;
        this.f1073m = l5;
        this.f1075p = i5 == 1 ? f5 != null ? Double.valueOf(f5.doubleValue()) : null : d5;
        this.n = str2;
        this.f1074o = str3;
    }

    public final Object a() {
        Long l5 = this.f1073m;
        if (l5 != null) {
            return l5;
        }
        Double d5 = this.f1075p;
        if (d5 != null) {
            return d5;
        }
        String str = this.n;
        if (str != null) {
            return str;
        }
        return null;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        D1.G.b(this, parcel);
    }

    public Y1(long j5, Object obj, String str, String str2) {
        q1.E.f(str);
        this.f1070j = 2;
        this.f1071k = str;
        this.f1072l = j5;
        this.f1074o = str2;
        if (obj == null) {
            this.f1073m = null;
            this.f1075p = null;
            this.n = null;
            return;
        }
        if (obj instanceof Long) {
            this.f1073m = (Long) obj;
            this.f1075p = null;
            this.n = null;
        } else if (obj instanceof String) {
            this.f1073m = null;
            this.f1075p = null;
            this.n = (String) obj;
        } else {
            if (obj instanceof Double) {
                this.f1073m = null;
                this.f1075p = (Double) obj;
                this.n = null;
                return;
            }
            throw new IllegalArgumentException("User attribute given of un-supported type");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Y1(Z1 z12) {
        String str = z12.f1092c;
        this(z12.f1093d, z12.f1094e, str, z12.f1091b);
    }
}
