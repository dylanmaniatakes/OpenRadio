package b;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* renamed from: b.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class BinderC0281c extends Binder implements InterfaceC0280b {

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f4508d = 0;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0282d f4509c;

    public BinderC0281c(C0282d c0282d) {
        this.f4509c = c0282d;
        attachInterface(this, "android.support.v4.os.IResultReceiver");
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i5, Parcel parcel, Parcel parcel2, int i6) {
        if (i5 >= 1 && i5 <= 16777215) {
            parcel.enforceInterface("android.support.v4.os.IResultReceiver");
        }
        if (i5 == 1598968902) {
            parcel2.writeString("android.support.v4.os.IResultReceiver");
            return true;
        }
        if (i5 != 1) {
            return super.onTransact(i5, parcel, parcel2, i6);
        }
        int i7 = parcel.readInt();
        Object objCreateFromParcel = parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null;
        C0282d c0282d = this.f4509c;
        c0282d.getClass();
        c0282d.a(i7, (Bundle) objCreateFromParcel);
        return true;
    }
}
