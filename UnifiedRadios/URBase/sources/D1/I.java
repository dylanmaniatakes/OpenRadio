package D1;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.zzv;
import com.google.android.gms.location.zzw;
import com.google.android.gms.location.zzy;
import com.google.android.gms.location.zzz;
import r1.AbstractC0873a;

/* loaded from: classes.dex */
public final class I extends AbstractC0873a {
    public static final Parcelable.Creator<I> CREATOR = new G(2);

    /* renamed from: j, reason: collision with root package name */
    public final int f347j;

    /* renamed from: k, reason: collision with root package name */
    public final H f348k;

    /* renamed from: l, reason: collision with root package name */
    public final zzz f349l;

    /* renamed from: m, reason: collision with root package name */
    public final zzw f350m;
    public final PendingIntent n;

    /* renamed from: o, reason: collision with root package name */
    public final Z f351o;

    /* renamed from: p, reason: collision with root package name */
    public final String f352p;

    public I(int i5, H h, IBinder iBinder, IBinder iBinder2, PendingIntent pendingIntent, IBinder iBinder3, String str) {
        this.f347j = i5;
        this.f348k = h;
        Z y4 = null;
        this.f349l = iBinder != null ? zzy.zzb(iBinder) : null;
        this.n = pendingIntent;
        this.f350m = iBinder2 != null ? zzv.zzb(iBinder2) : null;
        if (iBinder3 != null) {
            IInterface iInterfaceQueryLocalInterface = iBinder3.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            y4 = iInterfaceQueryLocalInterface instanceof Z ? (Z) iInterfaceQueryLocalInterface : new Y(iBinder3);
        }
        this.f351o = y4;
        this.f352p = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int I = A2.b.I(20293, parcel);
        A2.b.M(parcel, 1, 4);
        parcel.writeInt(this.f347j);
        A2.b.D(parcel, 2, this.f348k, i5);
        zzz zzzVar = this.f349l;
        A2.b.B(parcel, 3, zzzVar == null ? null : zzzVar.asBinder());
        A2.b.D(parcel, 4, this.n, i5);
        zzw zzwVar = this.f350m;
        A2.b.B(parcel, 5, zzwVar == null ? null : zzwVar.asBinder());
        Z z4 = this.f351o;
        A2.b.B(parcel, 6, z4 != null ? z4.asBinder() : null);
        A2.b.E(parcel, 8, this.f352p);
        A2.b.K(I, parcel);
    }
}
