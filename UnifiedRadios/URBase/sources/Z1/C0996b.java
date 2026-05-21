package z1;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: z1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0996b implements InterfaceC0998d, IInterface {

    /* renamed from: c, reason: collision with root package name */
    public final IBinder f10547c;

    public C0996b(IBinder iBinder) {
        this.f10547c = iBinder;
    }

    public final Parcel a(int i5, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.f10547c.transact(i5, parcel, parcelObtain, 0);
                parcelObtain.readException();
                return parcelObtain;
            } catch (RuntimeException e5) {
                parcelObtain.recycle();
                throw e5;
            }
        } finally {
            parcel.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f10547c;
    }
}
