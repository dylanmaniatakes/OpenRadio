package L1;

import D1.G;
import android.os.Parcel;
import android.os.Parcelable;
import n1.C0785b;
import q1.w;
import r1.AbstractC0873a;

/* loaded from: classes.dex */
public final class g extends AbstractC0873a {
    public static final Parcelable.Creator<g> CREATOR = new G(22);

    /* renamed from: j, reason: collision with root package name */
    public final int f1608j;

    /* renamed from: k, reason: collision with root package name */
    public final C0785b f1609k;

    /* renamed from: l, reason: collision with root package name */
    public final w f1610l;

    public g(int i5, C0785b c0785b, w wVar) {
        this.f1608j = i5;
        this.f1609k = c0785b;
        this.f1610l = wVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int I = A2.b.I(20293, parcel);
        A2.b.M(parcel, 1, 4);
        parcel.writeInt(this.f1608j);
        A2.b.D(parcel, 2, this.f1609k, i5);
        A2.b.D(parcel, 3, this.f1610l, i5);
        A2.b.K(I, parcel);
    }
}
