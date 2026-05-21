package D1;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.LocationRequest;

/* loaded from: classes.dex */
public final class a0 extends AbstractC0003a {
    public a0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.internal.IGoogleLocationManagerService");
    }

    public final void a(I i5) throws RemoteException {
        Parcel parcelZza = zza();
        AbstractC0019q.b(parcelZza, i5);
        zzc(59, parcelZza);
    }

    public final void b(F f5, LocationRequest locationRequest, BinderC0026y binderC0026y) throws RemoteException {
        Parcel parcelZza = zza();
        AbstractC0019q.b(parcelZza, f5);
        AbstractC0019q.b(parcelZza, locationRequest);
        parcelZza.writeStrongBinder(binderC0026y);
        zzc(88, parcelZza);
    }
}
