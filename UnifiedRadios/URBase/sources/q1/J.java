package q1;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import n1.C0785b;

/* loaded from: classes.dex */
public final class J extends y {
    public final IBinder g;
    public final /* synthetic */ AbstractC0854e h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public J(AbstractC0854e abstractC0854e, int i5, IBinder iBinder, Bundle bundle) {
        super(abstractC0854e, i5, bundle);
        this.h = abstractC0854e;
        this.g = iBinder;
    }

    @Override // q1.y
    public final void b(C0785b c0785b) {
        InterfaceC0852c interfaceC0852c = this.h.f9358p;
        if (interfaceC0852c != null) {
            interfaceC0852c.b(c0785b);
        }
        System.currentTimeMillis();
    }

    @Override // q1.y
    public final boolean c() throws RemoteException {
        IBinder iBinder = this.g;
        try {
            E.i(iBinder);
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            AbstractC0854e abstractC0854e = this.h;
            if (!abstractC0854e.u().equals(interfaceDescriptor)) {
                Log.w("GmsClient", "service descriptor mismatch: " + abstractC0854e.u() + " vs. " + interfaceDescriptor);
                return false;
            }
            IInterface iInterfaceO = abstractC0854e.o(iBinder);
            if (iInterfaceO == null || !(AbstractC0854e.z(abstractC0854e, 2, 4, iInterfaceO) || AbstractC0854e.z(abstractC0854e, 3, 4, iInterfaceO))) {
                return false;
            }
            abstractC0854e.f9362t = null;
            InterfaceC0851b interfaceC0851b = abstractC0854e.f9357o;
            if (interfaceC0851b == null) {
                return true;
            }
            interfaceC0851b.c();
            return true;
        } catch (RemoteException unused) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }
}
