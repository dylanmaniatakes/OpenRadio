package A1;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class a implements IInterface {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6c;

    /* renamed from: d, reason: collision with root package name */
    public final IBinder f7d;

    /* renamed from: e, reason: collision with root package name */
    public final String f8e;

    public /* synthetic */ a(IBinder iBinder, String str, int i5) {
        this.f6c = i5;
        this.f7d = iBinder;
        this.f8e = str;
    }

    public void H(int i5, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            this.f7d.transact(i5, parcel, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            parcel.recycle();
            parcelObtain.recycle();
        }
    }

    public void I(Parcel parcel) {
        try {
            this.f7d.transact(2, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }

    public Parcel a(int i5, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.f7d.transact(i5, parcel, parcelObtain, 0);
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
        switch (this.f6c) {
        }
        return this.f7d;
    }

    public Parcel b() {
        switch (this.f6c) {
            case 1:
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.writeInterfaceToken(this.f8e);
                return parcelObtain;
            default:
                Parcel parcelObtain2 = Parcel.obtain();
                parcelObtain2.writeInterfaceToken(this.f8e);
                return parcelObtain2;
        }
    }

    public Parcel c(int i5, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.f7d.transact(i5, parcel, parcelObtain, 0);
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
}
