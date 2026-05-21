package q1;

import android.os.Parcel;
import android.os.Parcelable;
import r1.AbstractC0873a;

/* renamed from: q1.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0862m extends AbstractC0873a {
    public static final Parcelable.Creator<C0862m> CREATOR = new android.support.v4.media.c(28);

    /* renamed from: j, reason: collision with root package name */
    public final int f9391j;

    /* renamed from: k, reason: collision with root package name */
    public final int f9392k;

    /* renamed from: l, reason: collision with root package name */
    public final int f9393l;

    /* renamed from: m, reason: collision with root package name */
    public final long f9394m;
    public final long n;

    /* renamed from: o, reason: collision with root package name */
    public final String f9395o;

    /* renamed from: p, reason: collision with root package name */
    public final String f9396p;

    /* renamed from: q, reason: collision with root package name */
    public final int f9397q;

    /* renamed from: r, reason: collision with root package name */
    public final int f9398r;

    public C0862m(int i5, int i6, int i7, long j5, long j6, String str, String str2, int i8, int i9) {
        this.f9391j = i5;
        this.f9392k = i6;
        this.f9393l = i7;
        this.f9394m = j5;
        this.n = j6;
        this.f9395o = str;
        this.f9396p = str2;
        this.f9397q = i8;
        this.f9398r = i9;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int I = A2.b.I(20293, parcel);
        A2.b.M(parcel, 1, 4);
        parcel.writeInt(this.f9391j);
        A2.b.M(parcel, 2, 4);
        parcel.writeInt(this.f9392k);
        A2.b.M(parcel, 3, 4);
        parcel.writeInt(this.f9393l);
        A2.b.M(parcel, 4, 8);
        parcel.writeLong(this.f9394m);
        A2.b.M(parcel, 5, 8);
        parcel.writeLong(this.n);
        A2.b.E(parcel, 6, this.f9395o);
        A2.b.E(parcel, 7, this.f9396p);
        A2.b.M(parcel, 8, 4);
        parcel.writeInt(this.f9397q);
        A2.b.M(parcel, 9, 4);
        parcel.writeInt(this.f9398r);
        A2.b.K(I, parcel);
    }
}
