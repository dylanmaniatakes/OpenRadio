package J1;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;
import com.google.android.gms.internal.measurement.C0417z;
import com.unified.ur1.rfmodule.DmrAudioService;
import m3.BinderC0772h;
import p3.C0836b;
import z2.RunnableC0999a;

/* renamed from: J1.i0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ServiceConnectionC0075i0 implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1255a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f1256b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1257c;

    public /* synthetic */ ServiceConnectionC0075i0(Object obj, int i5, Object obj2) {
        this.f1255a = i5;
        this.f1257c = obj;
        this.f1256b = obj2;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Object obj = this.f1257c;
        switch (this.f1255a) {
            case 0:
                C0078j0 c0078j0 = (C0078j0) obj;
                if (iBinder == null) {
                    Z z4 = c0078j0.f1270b.f1417k;
                    C0113v0.k(z4);
                    z4.f1080k.a("Install Referrer connection returned with null binder");
                    break;
                } else {
                    try {
                        int i5 = com.google.android.gms.internal.measurement.A.f4647c;
                        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
                        com.google.android.gms.internal.measurement.B c0417z = iInterfaceQueryLocalInterface instanceof com.google.android.gms.internal.measurement.B ? (com.google.android.gms.internal.measurement.B) iInterfaceQueryLocalInterface : new C0417z(iBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService", 2);
                        if (c0417z != null) {
                            C0113v0 c0113v0 = c0078j0.f1270b;
                            Z z5 = c0113v0.f1417k;
                            C0113v0.k(z5);
                            z5.f1084p.a("Install Referrer Service connected");
                            C0104s0 c0104s0 = c0113v0.f1418l;
                            C0113v0.k(c0104s0);
                            c0104s0.t(new RunnableC0999a(this, c0417z, this));
                            break;
                        } else {
                            Z z6 = c0078j0.f1270b.f1417k;
                            C0113v0.k(z6);
                            z6.f1080k.a("Install Referrer Service implementation was not found");
                            break;
                        }
                    } catch (RuntimeException e5) {
                        Z z7 = c0078j0.f1270b.f1417k;
                        C0113v0.k(z7);
                        z7.f1080k.b(e5, "Exception occurred while calling Install Referrer API");
                        return;
                    }
                }
            default:
                DmrAudioService dmrAudioService = ((BinderC0772h) iBinder).f8606c;
                C0836b c0836b = (C0836b) obj;
                c0836b.f9232k = dmrAudioService;
                dmrAudioService.f6036d.post(new g3.k(dmrAudioService, 22, c0836b));
                c0836b.f9233l = true;
                c0836b.getClass();
                Log.d("DMR_TX", "Audio service bound successfully");
                Runnable runnable = (Runnable) this.f1256b;
                if (runnable != null) {
                    c0836b.f9225b.post(runnable);
                    break;
                }
                break;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        switch (this.f1255a) {
            case 0:
                Z z4 = ((C0078j0) this.f1257c).f1270b.f1417k;
                C0113v0.k(z4);
                z4.f1084p.a("Install Referrer Service disconnected");
                break;
            default:
                C0836b c0836b = (C0836b) this.f1257c;
                c0836b.f9232k = null;
                c0836b.f9233l = false;
                c0836b.getClass();
                Log.d("DMR_TX", "Audio service disconnected");
                if (c0836b.g.get()) {
                    c0836b.f9225b.postDelayed(new m3.o(5, this), 1000L);
                    break;
                }
                break;
        }
    }
}
