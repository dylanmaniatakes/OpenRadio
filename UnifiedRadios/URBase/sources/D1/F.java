package D1;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import r1.AbstractC0873a;

/* loaded from: classes.dex */
public final class F extends AbstractC0873a {
    public static final Parcelable.Creator<F> CREATOR = new G(0);

    /* renamed from: j, reason: collision with root package name */
    public final int f341j;

    /* renamed from: k, reason: collision with root package name */
    public final IBinder f342k;

    /* renamed from: l, reason: collision with root package name */
    public final IBinder f343l;

    /* renamed from: m, reason: collision with root package name */
    public final PendingIntent f344m;
    public final String n;

    public F(int i5, IBinder iBinder, IBinder iBinder2, PendingIntent pendingIntent, String str) {
        this.f341j = i5;
        this.f342k = iBinder;
        this.f343l = iBinder2;
        this.f344m = pendingIntent;
        this.n = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int I = A2.b.I(20293, parcel);
        A2.b.M(parcel, 1, 4);
        parcel.writeInt(this.f341j);
        A2.b.B(parcel, 2, this.f342k);
        A2.b.B(parcel, 3, this.f343l);
        A2.b.D(parcel, 4, this.f344m, i5);
        A2.b.E(parcel, 6, this.n);
        A2.b.K(I, parcel);
    }
}
