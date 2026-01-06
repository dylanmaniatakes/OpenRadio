package D1;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import r1.AbstractC0873a;

/* loaded from: classes.dex */
public final class E extends AbstractC0873a {
    public static final Parcelable.Creator<E> CREATOR = new G(5);

    /* renamed from: j, reason: collision with root package name */
    public final int f336j;

    /* renamed from: k, reason: collision with root package name */
    public final String f337k;

    /* renamed from: l, reason: collision with root package name */
    public final String f338l;

    /* renamed from: m, reason: collision with root package name */
    public final String f339m;
    public final P n;

    /* renamed from: o, reason: collision with root package name */
    public final E f340o;

    static {
        Process.myUid();
        Process.myPid();
    }

    public E(int i5, String str, String str2, String str3, ArrayList arrayList, E e5) {
        F3.i.f(str, "packageName");
        if (e5 != null && e5.f340o != null) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        this.f336j = i5;
        this.f337k = str;
        this.f338l = str2;
        this.f339m = str3 == null ? e5 != null ? e5.f339m : null : str3;
        AbstractCollection abstractCollection = arrayList;
        if (arrayList == null) {
            AbstractCollection abstractCollection2 = e5 != null ? e5.n : null;
            abstractCollection = abstractCollection2;
            if (abstractCollection2 == null) {
                N n = P.f372k;
                AbstractCollection abstractCollection3 = Q.n;
                F3.i.e(abstractCollection3, "of(...)");
                abstractCollection = abstractCollection3;
            }
        }
        P pH = P.h(abstractCollection);
        F3.i.e(pH, "copyOf(...)");
        this.n = pH;
        this.f340o = e5;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof E) {
            E e5 = (E) obj;
            if (this.f336j == e5.f336j && F3.i.a(this.f337k, e5.f337k) && F3.i.a(this.f338l, e5.f338l) && F3.i.a(this.f339m, e5.f339m) && F3.i.a(this.f340o, e5.f340o) && F3.i.a(this.n, e5.n)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f336j), this.f337k, this.f338l, this.f339m, this.f340o});
    }

    public final String toString() {
        String str = this.f337k;
        int length = str.length() + 18;
        String str2 = this.f338l;
        StringBuilder sb = new StringBuilder(length + (str2 != null ? str2.length() : 0));
        sb.append(this.f336j);
        sb.append("/");
        sb.append(str);
        if (str2 != null) {
            sb.append("[");
            if (M3.m.x(str2, str, false)) {
                sb.append((CharSequence) str2, str.length(), str2.length());
            } else {
                sb.append(str2);
            }
            sb.append("]");
        }
        String str3 = this.f339m;
        if (str3 != null) {
            sb.append("/");
            sb.append(Integer.toHexString(str3.hashCode()));
        }
        String string = sb.toString();
        F3.i.e(string, "toString(...)");
        return string;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        F3.i.f(parcel, "dest");
        int I = A2.b.I(20293, parcel);
        A2.b.M(parcel, 1, 4);
        parcel.writeInt(this.f336j);
        A2.b.E(parcel, 3, this.f337k);
        A2.b.E(parcel, 4, this.f338l);
        A2.b.E(parcel, 6, this.f339m);
        A2.b.D(parcel, 7, this.f340o, i5);
        A2.b.H(parcel, 8, this.n);
        A2.b.K(I, parcel);
    }
}
