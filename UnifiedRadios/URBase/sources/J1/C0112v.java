package J1;

import android.os.Parcel;
import android.os.Parcelable;
import r1.AbstractC0873a;

/* renamed from: J1.v, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0112v extends AbstractC0873a {
    public static final Parcelable.Creator<C0112v> CREATOR = new D1.G(13);

    /* renamed from: j, reason: collision with root package name */
    public final String f1398j;

    /* renamed from: k, reason: collision with root package name */
    public final C0109u f1399k;

    /* renamed from: l, reason: collision with root package name */
    public final String f1400l;

    /* renamed from: m, reason: collision with root package name */
    public final long f1401m;

    public C0112v(C0112v c0112v, long j5) {
        q1.E.i(c0112v);
        this.f1398j = c0112v.f1398j;
        this.f1399k = c0112v.f1399k;
        this.f1400l = c0112v.f1400l;
        this.f1401m = j5;
    }

    public final String toString() {
        return "origin=" + this.f1400l + ",name=" + this.f1398j + ",params=" + String.valueOf(this.f1399k);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        D1.G.a(this, parcel, i5);
    }

    public C0112v(String str, C0109u c0109u, String str2, long j5) {
        this.f1398j = str;
        this.f1399k = c0109u;
        this.f1400l = str2;
        this.f1401m = j5;
    }
}
