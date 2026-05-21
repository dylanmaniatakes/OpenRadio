package q1;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.util.Log;

/* loaded from: classes.dex */
public final class H extends A1.b {

    /* renamed from: d, reason: collision with root package name */
    public AbstractC0854e f9316d;

    /* renamed from: e, reason: collision with root package name */
    public final int f9317e;

    public H(AbstractC0854e abstractC0854e, int i5) {
        super("com.google.android.gms.common.internal.IGmsCallbacks", 1);
        this.f9316d = abstractC0854e;
        this.f9317e = i5;
    }

    @Override // A1.b
    public final boolean I(int i5, Parcel parcel, Parcel parcel2) {
        if (i5 == 1) {
            int i6 = parcel.readInt();
            IBinder strongBinder = parcel.readStrongBinder();
            Bundle bundle = (Bundle) C1.a.a(parcel, Bundle.CREATOR);
            C1.a.b(parcel);
            E.j(this.f9316d, "onPostInitComplete can be called only once per call to getRemoteService");
            AbstractC0854e abstractC0854e = this.f9316d;
            abstractC0854e.getClass();
            J j5 = new J(abstractC0854e, i6, strongBinder, bundle);
            G g = abstractC0854e.f9351f;
            g.sendMessage(g.obtainMessage(1, this.f9317e, -1, j5));
            this.f9316d = null;
        } else if (i5 == 2) {
            parcel.readInt();
            C1.a.b(parcel);
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        } else {
            if (i5 != 3) {
                return false;
            }
            int i7 = parcel.readInt();
            IBinder strongBinder2 = parcel.readStrongBinder();
            L l5 = (L) C1.a.a(parcel, L.CREATOR);
            C1.a.b(parcel);
            AbstractC0854e abstractC0854e2 = this.f9316d;
            E.j(abstractC0854e2, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
            E.i(l5);
            abstractC0854e2.f9364v = l5;
            if (abstractC0854e2.y()) {
                C0856g c0856g = l5.f9323m;
                C0863n c0863nE = C0863n.e();
                C0864o c0864o = c0856g == null ? null : c0856g.f9368j;
                synchronized (c0863nE) {
                    if (c0864o == null) {
                        c0864o = C0863n.f9400c;
                    } else {
                        C0864o c0864o2 = (C0864o) c0863nE.f9401a;
                        if (c0864o2 == null || c0864o2.f9402j < c0864o.f9402j) {
                        }
                    }
                    c0863nE.f9401a = c0864o;
                }
            }
            Bundle bundle2 = l5.f9320j;
            E.j(this.f9316d, "onPostInitComplete can be called only once per call to getRemoteService");
            AbstractC0854e abstractC0854e3 = this.f9316d;
            abstractC0854e3.getClass();
            J j6 = new J(abstractC0854e3, i7, strongBinder2, bundle2);
            G g5 = abstractC0854e3.f9351f;
            g5.sendMessage(g5.obtainMessage(1, this.f9317e, -1, j6));
            this.f9316d = null;
        }
        parcel2.writeNoException();
        return true;
    }
}
