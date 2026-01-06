package l0;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.MultiInstanceInvalidationService;

/* renamed from: l0.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class BinderC0734j extends Binder implements InterfaceC0731g {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MultiInstanceInvalidationService f8350c;

    public BinderC0734j(MultiInstanceInvalidationService multiInstanceInvalidationService) {
        this.f8350c = multiInstanceInvalidationService;
        attachInterface(this, InterfaceC0731g.f8338b);
    }

    public final void a(String[] strArr, int i5) {
        F3.i.f(strArr, "tables");
        MultiInstanceInvalidationService multiInstanceInvalidationService = this.f8350c;
        synchronized (multiInstanceInvalidationService.f4404e) {
            String str = (String) multiInstanceInvalidationService.f4403d.get(Integer.valueOf(i5));
            if (str == null) {
                Log.w("ROOM", "Remote invalidation client ID not registered");
                return;
            }
            int iBeginBroadcast = multiInstanceInvalidationService.f4404e.beginBroadcast();
            for (int i6 = 0; i6 < iBeginBroadcast; i6++) {
                try {
                    Object broadcastCookie = multiInstanceInvalidationService.f4404e.getBroadcastCookie(i6);
                    F3.i.d(broadcastCookie, "null cannot be cast to non-null type kotlin.Int");
                    Integer num = (Integer) broadcastCookie;
                    int iIntValue = num.intValue();
                    String str2 = (String) multiInstanceInvalidationService.f4403d.get(num);
                    if (i5 != iIntValue && str.equals(str2)) {
                        try {
                            ((InterfaceC0730f) multiInstanceInvalidationService.f4404e.getBroadcastItem(i6)).j(strArr);
                        } catch (RemoteException e5) {
                            Log.w("ROOM", "Error invoking a remote callback", e5);
                        }
                    }
                } finally {
                    multiInstanceInvalidationService.f4404e.finishBroadcast();
                }
            }
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    public final int b(InterfaceC0730f interfaceC0730f, String str) {
        F3.i.f(interfaceC0730f, "callback");
        int i5 = 0;
        if (str == null) {
            return 0;
        }
        MultiInstanceInvalidationService multiInstanceInvalidationService = this.f8350c;
        synchronized (multiInstanceInvalidationService.f4404e) {
            try {
                int i6 = multiInstanceInvalidationService.f4402c + 1;
                multiInstanceInvalidationService.f4402c = i6;
                if (multiInstanceInvalidationService.f4404e.register(interfaceC0730f, Integer.valueOf(i6))) {
                    multiInstanceInvalidationService.f4403d.put(Integer.valueOf(i6), str);
                    i5 = i6;
                } else {
                    multiInstanceInvalidationService.f4402c--;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return i5;
    }

    @Override // l0.InterfaceC0731g
    public final void f(InterfaceC0730f interfaceC0730f, int i5) {
        F3.i.f(interfaceC0730f, "callback");
        MultiInstanceInvalidationService multiInstanceInvalidationService = this.f8350c;
        synchronized (multiInstanceInvalidationService.f4404e) {
            multiInstanceInvalidationService.f4404e.unregister(interfaceC0730f);
        }
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i5, Parcel parcel, Parcel parcel2, int i6) {
        String str = InterfaceC0731g.f8338b;
        if (i5 >= 1 && i5 <= 16777215) {
            parcel.enforceInterface(str);
        }
        if (i5 == 1598968902) {
            parcel2.writeString(str);
            return true;
        }
        InterfaceC0730f interfaceC0730f = null;
        InterfaceC0730f interfaceC0730f2 = null;
        if (i5 == 1) {
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder != null) {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface(InterfaceC0730f.f8337a);
                if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC0730f)) {
                    C0729e c0729e = new C0729e();
                    c0729e.f8336c = strongBinder;
                    interfaceC0730f = c0729e;
                } else {
                    interfaceC0730f = (InterfaceC0730f) iInterfaceQueryLocalInterface;
                }
            }
            int iB = b(interfaceC0730f, parcel.readString());
            parcel2.writeNoException();
            parcel2.writeInt(iB);
        } else if (i5 == 2) {
            IBinder strongBinder2 = parcel.readStrongBinder();
            if (strongBinder2 != null) {
                IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface(InterfaceC0730f.f8337a);
                if (iInterfaceQueryLocalInterface2 == null || !(iInterfaceQueryLocalInterface2 instanceof InterfaceC0730f)) {
                    C0729e c0729e2 = new C0729e();
                    c0729e2.f8336c = strongBinder2;
                    interfaceC0730f2 = c0729e2;
                } else {
                    interfaceC0730f2 = (InterfaceC0730f) iInterfaceQueryLocalInterface2;
                }
            }
            f(interfaceC0730f2, parcel.readInt());
            parcel2.writeNoException();
        } else {
            if (i5 != 3) {
                return super.onTransact(i5, parcel, parcel2, i6);
            }
            a(parcel.createStringArray(), parcel.readInt());
        }
        return true;
    }
}
