package J1;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import r1.AbstractC0873a;

/* loaded from: classes.dex */
public final class b2 extends AbstractC0873a {
    public static final Parcelable.Creator<b2> CREATOR = new D1.G(19);

    /* renamed from: A, reason: collision with root package name */
    public final long f1123A;

    /* renamed from: B, reason: collision with root package name */
    public final List f1124B;

    /* renamed from: C, reason: collision with root package name */
    public final String f1125C;

    /* renamed from: D, reason: collision with root package name */
    public final String f1126D;

    /* renamed from: E, reason: collision with root package name */
    public final String f1127E;

    /* renamed from: F, reason: collision with root package name */
    public final String f1128F;

    /* renamed from: G, reason: collision with root package name */
    public final boolean f1129G;

    /* renamed from: H, reason: collision with root package name */
    public final long f1130H;
    public final int I;

    /* renamed from: J, reason: collision with root package name */
    public final String f1131J;

    /* renamed from: K, reason: collision with root package name */
    public final int f1132K;

    /* renamed from: L, reason: collision with root package name */
    public final long f1133L;

    /* renamed from: M, reason: collision with root package name */
    public final String f1134M;

    /* renamed from: N, reason: collision with root package name */
    public final String f1135N;

    /* renamed from: O, reason: collision with root package name */
    public final long f1136O;

    /* renamed from: P, reason: collision with root package name */
    public final int f1137P;

    /* renamed from: j, reason: collision with root package name */
    public final String f1138j;

    /* renamed from: k, reason: collision with root package name */
    public final String f1139k;

    /* renamed from: l, reason: collision with root package name */
    public final String f1140l;

    /* renamed from: m, reason: collision with root package name */
    public final String f1141m;
    public final long n;

    /* renamed from: o, reason: collision with root package name */
    public final long f1142o;

    /* renamed from: p, reason: collision with root package name */
    public final String f1143p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f1144q;

    /* renamed from: r, reason: collision with root package name */
    public final boolean f1145r;

    /* renamed from: s, reason: collision with root package name */
    public final long f1146s;

    /* renamed from: t, reason: collision with root package name */
    public final String f1147t;

    /* renamed from: u, reason: collision with root package name */
    public final long f1148u;

    /* renamed from: v, reason: collision with root package name */
    public final int f1149v;

    /* renamed from: w, reason: collision with root package name */
    public final boolean f1150w;

    /* renamed from: x, reason: collision with root package name */
    public final boolean f1151x;

    /* renamed from: y, reason: collision with root package name */
    public final String f1152y;

    /* renamed from: z, reason: collision with root package name */
    public final Boolean f1153z;

    public b2(String str, String str2, String str3, long j5, String str4, long j6, long j7, String str5, boolean z4, boolean z5, String str6, long j8, int i5, boolean z6, boolean z7, String str7, Boolean bool, long j9, List list, String str8, String str9, String str10, String str11, boolean z8, long j10, int i6, String str12, int i7, long j11, String str13, String str14, long j12, int i8) {
        q1.E.f(str);
        this.f1138j = str;
        this.f1139k = true == TextUtils.isEmpty(str2) ? null : str2;
        this.f1140l = str3;
        this.f1146s = j5;
        this.f1141m = str4;
        this.n = j6;
        this.f1142o = j7;
        this.f1143p = str5;
        this.f1144q = z4;
        this.f1145r = z5;
        this.f1147t = str6;
        this.f1148u = j8;
        this.f1149v = i5;
        this.f1150w = z6;
        this.f1151x = z7;
        this.f1152y = str7;
        this.f1153z = bool;
        this.f1123A = j9;
        this.f1124B = list;
        this.f1125C = str8;
        this.f1126D = str9;
        this.f1127E = str10;
        this.f1128F = str11;
        this.f1129G = z8;
        this.f1130H = j10;
        this.I = i6;
        this.f1131J = str12;
        this.f1132K = i7;
        this.f1133L = j11;
        this.f1134M = str13;
        this.f1135N = str14;
        this.f1136O = j12;
        this.f1137P = i8;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int I = A2.b.I(20293, parcel);
        A2.b.E(parcel, 2, this.f1138j);
        A2.b.E(parcel, 3, this.f1139k);
        A2.b.E(parcel, 4, this.f1140l);
        A2.b.E(parcel, 5, this.f1141m);
        A2.b.M(parcel, 6, 8);
        parcel.writeLong(this.n);
        A2.b.M(parcel, 7, 8);
        parcel.writeLong(this.f1142o);
        A2.b.E(parcel, 8, this.f1143p);
        A2.b.M(parcel, 9, 4);
        parcel.writeInt(this.f1144q ? 1 : 0);
        A2.b.M(parcel, 10, 4);
        parcel.writeInt(this.f1145r ? 1 : 0);
        A2.b.M(parcel, 11, 8);
        parcel.writeLong(this.f1146s);
        A2.b.E(parcel, 12, this.f1147t);
        A2.b.M(parcel, 14, 8);
        parcel.writeLong(this.f1148u);
        A2.b.M(parcel, 15, 4);
        parcel.writeInt(this.f1149v);
        A2.b.M(parcel, 16, 4);
        parcel.writeInt(this.f1150w ? 1 : 0);
        A2.b.M(parcel, 18, 4);
        parcel.writeInt(this.f1151x ? 1 : 0);
        A2.b.E(parcel, 19, this.f1152y);
        Boolean bool = this.f1153z;
        if (bool != null) {
            A2.b.M(parcel, 21, 4);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        A2.b.M(parcel, 22, 8);
        parcel.writeLong(this.f1123A);
        A2.b.F(parcel, 23, this.f1124B);
        A2.b.E(parcel, 24, this.f1125C);
        A2.b.E(parcel, 25, this.f1126D);
        A2.b.E(parcel, 26, this.f1127E);
        A2.b.E(parcel, 27, this.f1128F);
        A2.b.M(parcel, 28, 4);
        parcel.writeInt(this.f1129G ? 1 : 0);
        A2.b.M(parcel, 29, 8);
        parcel.writeLong(this.f1130H);
        A2.b.M(parcel, 30, 4);
        parcel.writeInt(this.I);
        A2.b.E(parcel, 31, this.f1131J);
        A2.b.M(parcel, 32, 4);
        parcel.writeInt(this.f1132K);
        A2.b.M(parcel, 34, 8);
        parcel.writeLong(this.f1133L);
        A2.b.E(parcel, 35, this.f1134M);
        A2.b.E(parcel, 36, this.f1135N);
        A2.b.M(parcel, 37, 8);
        parcel.writeLong(this.f1136O);
        A2.b.M(parcel, 38, 4);
        parcel.writeInt(this.f1137P);
        A2.b.K(I, parcel);
    }

    public b2(String str, String str2, String str3, String str4, long j5, long j6, String str5, boolean z4, boolean z5, long j7, String str6, long j8, int i5, boolean z6, boolean z7, String str7, Boolean bool, long j9, ArrayList arrayList, String str8, String str9, String str10, String str11, boolean z8, long j10, int i6, String str12, int i7, long j11, String str13, String str14, long j12, int i8) {
        this.f1138j = str;
        this.f1139k = str2;
        this.f1140l = str3;
        this.f1146s = j7;
        this.f1141m = str4;
        this.n = j5;
        this.f1142o = j6;
        this.f1143p = str5;
        this.f1144q = z4;
        this.f1145r = z5;
        this.f1147t = str6;
        this.f1148u = j8;
        this.f1149v = i5;
        this.f1150w = z6;
        this.f1151x = z7;
        this.f1152y = str7;
        this.f1153z = bool;
        this.f1123A = j9;
        this.f1124B = arrayList;
        this.f1125C = str8;
        this.f1126D = str9;
        this.f1127E = str10;
        this.f1128F = str11;
        this.f1129G = z8;
        this.f1130H = j10;
        this.I = i6;
        this.f1131J = str12;
        this.f1132K = i7;
        this.f1133L = j11;
        this.f1134M = str13;
        this.f1135N = str14;
        this.f1136O = j12;
        this.f1137P = i8;
    }
}
