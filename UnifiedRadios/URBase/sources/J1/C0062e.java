package J1;

import android.os.Parcel;
import android.os.Parcelable;
import r1.AbstractC0873a;

/* renamed from: J1.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0062e extends AbstractC0873a {
    public static final Parcelable.Creator<C0062e> CREATOR = new D1.G(10);

    /* renamed from: j, reason: collision with root package name */
    public String f1191j;

    /* renamed from: k, reason: collision with root package name */
    public String f1192k;

    /* renamed from: l, reason: collision with root package name */
    public Y1 f1193l;

    /* renamed from: m, reason: collision with root package name */
    public long f1194m;
    public boolean n;

    /* renamed from: o, reason: collision with root package name */
    public String f1195o;

    /* renamed from: p, reason: collision with root package name */
    public final C0112v f1196p;

    /* renamed from: q, reason: collision with root package name */
    public long f1197q;

    /* renamed from: r, reason: collision with root package name */
    public C0112v f1198r;

    /* renamed from: s, reason: collision with root package name */
    public final long f1199s;

    /* renamed from: t, reason: collision with root package name */
    public final C0112v f1200t;

    public C0062e(C0062e c0062e) {
        q1.E.i(c0062e);
        this.f1191j = c0062e.f1191j;
        this.f1192k = c0062e.f1192k;
        this.f1193l = c0062e.f1193l;
        this.f1194m = c0062e.f1194m;
        this.n = c0062e.n;
        this.f1195o = c0062e.f1195o;
        this.f1196p = c0062e.f1196p;
        this.f1197q = c0062e.f1197q;
        this.f1198r = c0062e.f1198r;
        this.f1199s = c0062e.f1199s;
        this.f1200t = c0062e.f1200t;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int I = A2.b.I(20293, parcel);
        A2.b.E(parcel, 2, this.f1191j);
        A2.b.E(parcel, 3, this.f1192k);
        A2.b.D(parcel, 4, this.f1193l, i5);
        long j5 = this.f1194m;
        A2.b.M(parcel, 5, 8);
        parcel.writeLong(j5);
        boolean z4 = this.n;
        A2.b.M(parcel, 6, 4);
        parcel.writeInt(z4 ? 1 : 0);
        A2.b.E(parcel, 7, this.f1195o);
        A2.b.D(parcel, 8, this.f1196p, i5);
        long j6 = this.f1197q;
        A2.b.M(parcel, 9, 8);
        parcel.writeLong(j6);
        A2.b.D(parcel, 10, this.f1198r, i5);
        A2.b.M(parcel, 11, 8);
        parcel.writeLong(this.f1199s);
        A2.b.D(parcel, 12, this.f1200t, i5);
        A2.b.K(I, parcel);
    }

    public C0062e(String str, String str2, Y1 y12, long j5, boolean z4, String str3, C0112v c0112v, long j6, C0112v c0112v2, long j7, C0112v c0112v3) {
        this.f1191j = str;
        this.f1192k = str2;
        this.f1193l = y12;
        this.f1194m = j5;
        this.n = z4;
        this.f1195o = str3;
        this.f1196p = c0112v;
        this.f1197q = j6;
        this.f1198r = c0112v2;
        this.f1199s = j7;
        this.f1200t = c0112v3;
    }
}
