package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;

/* renamed from: androidx.fragment.app.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0207b implements Parcelable {
    public static final Parcelable.Creator<C0207b> CREATOR = new android.support.v4.media.c(3);

    /* renamed from: j, reason: collision with root package name */
    public final int[] f3758j;

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f3759k;

    /* renamed from: l, reason: collision with root package name */
    public final int[] f3760l;

    /* renamed from: m, reason: collision with root package name */
    public final int[] f3761m;
    public final int n;

    /* renamed from: o, reason: collision with root package name */
    public final String f3762o;

    /* renamed from: p, reason: collision with root package name */
    public final int f3763p;

    /* renamed from: q, reason: collision with root package name */
    public final int f3764q;

    /* renamed from: r, reason: collision with root package name */
    public final CharSequence f3765r;

    /* renamed from: s, reason: collision with root package name */
    public final int f3766s;

    /* renamed from: t, reason: collision with root package name */
    public final CharSequence f3767t;

    /* renamed from: u, reason: collision with root package name */
    public final ArrayList f3768u;

    /* renamed from: v, reason: collision with root package name */
    public final ArrayList f3769v;

    /* renamed from: w, reason: collision with root package name */
    public final boolean f3770w;

    public C0207b(C0206a c0206a) {
        int size = c0206a.f3742a.size();
        this.f3758j = new int[size * 5];
        if (!c0206a.g) {
            throw new IllegalStateException("Not on back stack");
        }
        this.f3759k = new ArrayList(size);
        this.f3760l = new int[size];
        this.f3761m = new int[size];
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            d0 d0Var = (d0) c0206a.f3742a.get(i6);
            int i7 = i5 + 1;
            this.f3758j[i5] = d0Var.f3788a;
            ArrayList arrayList = this.f3759k;
            Fragment fragment = d0Var.f3789b;
            arrayList.add(fragment != null ? fragment.mWho : null);
            int[] iArr = this.f3758j;
            iArr[i7] = d0Var.f3790c;
            iArr[i5 + 2] = d0Var.f3791d;
            int i8 = i5 + 4;
            iArr[i5 + 3] = d0Var.f3792e;
            i5 += 5;
            iArr[i8] = d0Var.f3793f;
            this.f3760l[i6] = d0Var.g.ordinal();
            this.f3761m[i6] = d0Var.h.ordinal();
        }
        this.n = c0206a.f3747f;
        this.f3762o = c0206a.h;
        this.f3763p = c0206a.f3756r;
        this.f3764q = c0206a.f3748i;
        this.f3765r = c0206a.f3749j;
        this.f3766s = c0206a.f3750k;
        this.f3767t = c0206a.f3751l;
        this.f3768u = c0206a.f3752m;
        this.f3769v = c0206a.n;
        this.f3770w = c0206a.f3753o;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        parcel.writeIntArray(this.f3758j);
        parcel.writeStringList(this.f3759k);
        parcel.writeIntArray(this.f3760l);
        parcel.writeIntArray(this.f3761m);
        parcel.writeInt(this.n);
        parcel.writeString(this.f3762o);
        parcel.writeInt(this.f3763p);
        parcel.writeInt(this.f3764q);
        TextUtils.writeToParcel(this.f3765r, parcel, 0);
        parcel.writeInt(this.f3766s);
        TextUtils.writeToParcel(this.f3767t, parcel, 0);
        parcel.writeStringList(this.f3768u);
        parcel.writeStringList(this.f3769v);
        parcel.writeInt(this.f3770w ? 1 : 0);
    }

    public C0207b(Parcel parcel) {
        this.f3758j = parcel.createIntArray();
        this.f3759k = parcel.createStringArrayList();
        this.f3760l = parcel.createIntArray();
        this.f3761m = parcel.createIntArray();
        this.n = parcel.readInt();
        this.f3762o = parcel.readString();
        this.f3763p = parcel.readInt();
        this.f3764q = parcel.readInt();
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.f3765r = (CharSequence) creator.createFromParcel(parcel);
        this.f3766s = parcel.readInt();
        this.f3767t = (CharSequence) creator.createFromParcel(parcel);
        this.f3768u = parcel.createStringArrayList();
        this.f3769v = parcel.createStringArrayList();
        this.f3770w = parcel.readInt() != 0;
    }
}
