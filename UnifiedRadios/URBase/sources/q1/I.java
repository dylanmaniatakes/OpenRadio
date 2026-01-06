package q1;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes.dex */
public final class I implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final int f9318a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AbstractC0854e f9319b;

    public I(AbstractC0854e abstractC0854e, int i5) {
        this.f9319b = abstractC0854e;
        this.f9318a = i5;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        int i5;
        int i6;
        AbstractC0854e abstractC0854e = this.f9319b;
        if (iBinder == null) {
            synchronized (abstractC0854e.g) {
                i5 = abstractC0854e.n;
            }
            if (i5 == 3) {
                abstractC0854e.f9363u = true;
                i6 = 5;
            } else {
                i6 = 4;
            }
            G g = abstractC0854e.f9351f;
            g.sendMessage(g.obtainMessage(i6, abstractC0854e.f9365w.get(), 16));
            return;
        }
        synchronized (abstractC0854e.h) {
            try {
                AbstractC0854e abstractC0854e2 = this.f9319b;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                abstractC0854e2.f9352i = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof C0848A)) ? new C0848A(iBinder) : (C0848A) iInterfaceQueryLocalInterface;
            } catch (Throwable th) {
                throw th;
            }
        }
        AbstractC0854e abstractC0854e3 = this.f9319b;
        int i7 = this.f9318a;
        abstractC0854e3.getClass();
        K k5 = new K(abstractC0854e3, 0, null);
        G g5 = abstractC0854e3.f9351f;
        g5.sendMessage(g5.obtainMessage(7, i7, -1, k5));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        AbstractC0854e abstractC0854e;
        synchronized (this.f9319b.h) {
            abstractC0854e = this.f9319b;
            abstractC0854e.f9352i = null;
        }
        int i5 = this.f9318a;
        G g = abstractC0854e.f9351f;
        g.sendMessage(g.obtainMessage(6, i5, 1));
    }
}
