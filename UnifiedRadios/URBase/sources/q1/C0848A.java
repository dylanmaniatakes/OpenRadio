package q1;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: q1.A, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0848A implements IInterface {

    /* renamed from: c, reason: collision with root package name */
    public final IBinder f9309c;

    public C0848A(IBinder iBinder) {
        this.f9309c = iBinder;
    }

    public final void a(H h, C0857h c0857h) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            parcelObtain.writeStrongBinder(h);
            parcelObtain.writeInt(1);
            x.a(c0857h, parcelObtain, 0);
            this.f9309c.transact(46, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f9309c;
    }
}
