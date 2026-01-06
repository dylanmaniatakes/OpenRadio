package D1;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import r1.AbstractC0873a;

/* loaded from: classes.dex */
public final class K extends AbstractC0873a {
    public static final Parcelable.Creator<K> CREATOR = new G(4);

    /* renamed from: j, reason: collision with root package name */
    public final P f361j;

    /* renamed from: k, reason: collision with root package name */
    public final PendingIntent f362k;

    /* renamed from: l, reason: collision with root package name */
    public final String f363l;

    public K(List list, PendingIntent pendingIntent, String str) {
        P pH;
        if (list == null) {
            N n = P.f372k;
            pH = Q.n;
        } else {
            pH = P.h(list);
        }
        this.f361j = pH;
        this.f362k = pendingIntent;
        this.f363l = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int I = A2.b.I(20293, parcel);
        A2.b.F(parcel, 1, this.f361j);
        A2.b.D(parcel, 2, this.f362k, i5);
        A2.b.E(parcel, 3, this.f363l);
        A2.b.K(I, parcel);
    }
}
