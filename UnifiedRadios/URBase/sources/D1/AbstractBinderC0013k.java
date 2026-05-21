package D1;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: D1.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractBinderC0013k extends Binder implements IInterface {
    public AbstractBinderC0013k(String str) {
        attachInterface(this, str);
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i5, Parcel parcel, Parcel parcel2, int i6) throws RemoteException {
        if (i5 <= 16777215) {
            parcel.enforceInterface(getInterfaceDescriptor());
        } else if (super.onTransact(i5, parcel, parcel2, i6)) {
            return true;
        }
        return zza(i5, parcel, parcel2, i6);
    }

    public abstract boolean zza(int i5, Parcel parcel, Parcel parcel2, int i6);
}
