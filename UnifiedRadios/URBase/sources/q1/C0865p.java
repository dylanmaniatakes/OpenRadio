package q1;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import r1.AbstractC0873a;

/* renamed from: q1.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0865p extends AbstractC0873a {
    public static final Parcelable.Creator<C0865p> CREATOR = new android.support.v4.media.c(27);

    /* renamed from: j, reason: collision with root package name */
    public final int f9406j;

    /* renamed from: k, reason: collision with root package name */
    public List f9407k;

    public C0865p(int i5, List list) {
        this.f9406j = i5;
        this.f9407k = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int I = A2.b.I(20293, parcel);
        A2.b.M(parcel, 1, 4);
        parcel.writeInt(this.f9406j);
        A2.b.H(parcel, 2, this.f9407k);
        A2.b.K(I, parcel);
    }
}
