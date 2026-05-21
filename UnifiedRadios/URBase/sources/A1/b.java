package A1;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class b extends Binder implements IInterface {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f9c;

    public b(String str, int i5) {
        this.f9c = i5;
        switch (i5) {
            case 1:
                attachInterface(this, str);
                break;
            default:
                attachInterface(this, str);
                break;
        }
    }

    public abstract boolean H(int i5, Parcel parcel, Parcel parcel2);

    public boolean I(int i5, Parcel parcel, Parcel parcel2) {
        return false;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        int i5 = this.f9c;
        return this;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i5, Parcel parcel, Parcel parcel2, int i6) {
        switch (this.f9c) {
            case 0:
                if (i5 <= 16777215) {
                    parcel.enforceInterface(getInterfaceDescriptor());
                } else if (super.onTransact(i5, parcel, parcel2, i6)) {
                    return true;
                }
                return H(i5, parcel, parcel2);
            default:
                if (i5 <= 16777215) {
                    parcel.enforceInterface(getInterfaceDescriptor());
                } else if (super.onTransact(i5, parcel, parcel2, i6)) {
                    return true;
                }
                return I(i5, parcel, parcel2);
        }
    }
}
