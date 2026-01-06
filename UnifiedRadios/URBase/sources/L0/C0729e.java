package l0;

import android.os.IBinder;
import android.os.Parcel;

/* renamed from: l0.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0729e implements InterfaceC0730f {

    /* renamed from: c, reason: collision with root package name */
    public IBinder f8336c;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f8336c;
    }

    @Override // l0.InterfaceC0730f
    public final void j(String[] strArr) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(InterfaceC0730f.f8337a);
            parcelObtain.writeStringArray(strArr);
            this.f8336c.transact(1, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }
}
