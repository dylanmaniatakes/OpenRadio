package R1;

import D1.G;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Locale;

/* loaded from: classes.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new G(23);

    /* renamed from: A, reason: collision with root package name */
    public int f2239A;

    /* renamed from: B, reason: collision with root package name */
    public Integer f2240B;

    /* renamed from: C, reason: collision with root package name */
    public Boolean f2241C;

    /* renamed from: D, reason: collision with root package name */
    public Integer f2242D;

    /* renamed from: E, reason: collision with root package name */
    public Integer f2243E;

    /* renamed from: F, reason: collision with root package name */
    public Integer f2244F;

    /* renamed from: G, reason: collision with root package name */
    public Integer f2245G;

    /* renamed from: H, reason: collision with root package name */
    public Integer f2246H;
    public Integer I;

    /* renamed from: J, reason: collision with root package name */
    public Integer f2247J;

    /* renamed from: K, reason: collision with root package name */
    public Integer f2248K;

    /* renamed from: L, reason: collision with root package name */
    public Integer f2249L;

    /* renamed from: M, reason: collision with root package name */
    public Boolean f2250M;

    /* renamed from: j, reason: collision with root package name */
    public int f2251j;

    /* renamed from: k, reason: collision with root package name */
    public Integer f2252k;

    /* renamed from: l, reason: collision with root package name */
    public Integer f2253l;

    /* renamed from: m, reason: collision with root package name */
    public Integer f2254m;
    public Integer n;

    /* renamed from: o, reason: collision with root package name */
    public Integer f2255o;

    /* renamed from: p, reason: collision with root package name */
    public Integer f2256p;

    /* renamed from: q, reason: collision with root package name */
    public Integer f2257q;

    /* renamed from: r, reason: collision with root package name */
    public int f2258r;

    /* renamed from: s, reason: collision with root package name */
    public String f2259s;

    /* renamed from: t, reason: collision with root package name */
    public int f2260t;

    /* renamed from: u, reason: collision with root package name */
    public int f2261u;

    /* renamed from: v, reason: collision with root package name */
    public int f2262v;

    /* renamed from: w, reason: collision with root package name */
    public Locale f2263w;

    /* renamed from: x, reason: collision with root package name */
    public CharSequence f2264x;

    /* renamed from: y, reason: collision with root package name */
    public CharSequence f2265y;

    /* renamed from: z, reason: collision with root package name */
    public int f2266z;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        parcel.writeInt(this.f2251j);
        parcel.writeSerializable(this.f2252k);
        parcel.writeSerializable(this.f2253l);
        parcel.writeSerializable(this.f2254m);
        parcel.writeSerializable(this.n);
        parcel.writeSerializable(this.f2255o);
        parcel.writeSerializable(this.f2256p);
        parcel.writeSerializable(this.f2257q);
        parcel.writeInt(this.f2258r);
        parcel.writeString(this.f2259s);
        parcel.writeInt(this.f2260t);
        parcel.writeInt(this.f2261u);
        parcel.writeInt(this.f2262v);
        CharSequence charSequence = this.f2264x;
        parcel.writeString(charSequence != null ? charSequence.toString() : null);
        CharSequence charSequence2 = this.f2265y;
        parcel.writeString(charSequence2 != null ? charSequence2.toString() : null);
        parcel.writeInt(this.f2266z);
        parcel.writeSerializable(this.f2240B);
        parcel.writeSerializable(this.f2242D);
        parcel.writeSerializable(this.f2243E);
        parcel.writeSerializable(this.f2244F);
        parcel.writeSerializable(this.f2245G);
        parcel.writeSerializable(this.f2246H);
        parcel.writeSerializable(this.I);
        parcel.writeSerializable(this.f2249L);
        parcel.writeSerializable(this.f2247J);
        parcel.writeSerializable(this.f2248K);
        parcel.writeSerializable(this.f2241C);
        parcel.writeSerializable(this.f2263w);
        parcel.writeSerializable(this.f2250M);
    }
}
