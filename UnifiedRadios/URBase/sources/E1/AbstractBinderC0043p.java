package E1;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.Tile;

/* renamed from: E1.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractBinderC0043p extends AbstractBinderC0048v implements InterfaceC0044q {
    public static InterfaceC0044q zzc(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
        return iInterfaceQueryLocalInterface instanceof InterfaceC0044q ? (InterfaceC0044q) iInterfaceQueryLocalInterface : new C0042o(iBinder, "com.google.android.gms.maps.model.internal.ITileProviderDelegate");
    }

    @Override // E1.AbstractBinderC0048v
    public final boolean zza(int i5, Parcel parcel, Parcel parcel2, int i6) throws RemoteException {
        if (i5 != 1) {
            return false;
        }
        int i7 = parcel.readInt();
        int i8 = parcel.readInt();
        int i9 = parcel.readInt();
        B.b(parcel);
        Tile tileZzb = zzb(i7, i8, i9);
        parcel2.writeNoException();
        if (tileZzb == null) {
            parcel2.writeInt(0);
        } else {
            parcel2.writeInt(1);
            tileZzb.writeToParcel(parcel2, 1);
        }
        return true;
    }
}
