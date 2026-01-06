package D1;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.zzs;
import com.google.android.gms.location.zzt;
import r1.AbstractC0873a;

/* loaded from: classes.dex */
public final class W extends AbstractC0873a {
    public static final Parcelable.Creator<W> CREATOR = new G(7);

    /* renamed from: j, reason: collision with root package name */
    public final int f382j;

    /* renamed from: k, reason: collision with root package name */
    public final V f383k;

    /* renamed from: l, reason: collision with root package name */
    public final zzt f384l;

    /* renamed from: m, reason: collision with root package name */
    public final Z f385m;

    public W(int i5, V v4, IBinder iBinder, IBinder iBinder2) {
        this.f382j = i5;
        this.f383k = v4;
        Z y4 = null;
        this.f384l = iBinder == null ? null : zzs.zzb(iBinder);
        if (iBinder2 != null) {
            IInterface iInterfaceQueryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            y4 = iInterfaceQueryLocalInterface instanceof Z ? (Z) iInterfaceQueryLocalInterface : new Y(iBinder2);
        }
        this.f385m = y4;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int I = A2.b.I(20293, parcel);
        A2.b.M(parcel, 1, 4);
        parcel.writeInt(this.f382j);
        A2.b.D(parcel, 2, this.f383k, i5);
        zzt zztVar = this.f384l;
        A2.b.B(parcel, 3, zztVar == null ? null : zztVar.asBinder());
        Z z4 = this.f385m;
        A2.b.B(parcel, 4, z4 != null ? z4.asBinder() : null);
        A2.b.K(I, parcel);
    }
}
