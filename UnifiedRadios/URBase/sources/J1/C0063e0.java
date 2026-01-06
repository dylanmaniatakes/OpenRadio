package J1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* renamed from: J1.e0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0063e0 extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public final V1 f1201a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1202b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f1203c;

    public C0063e0(V1 v12) {
        q1.E.i(v12);
        this.f1201a = v12;
    }

    public final void a() {
        V1 v12 = this.f1201a;
        v12.k();
        v12.e().j();
        v12.e().j();
        if (this.f1202b) {
            v12.c().f1084p.a("Unregistering connectivity change receiver");
            this.f1202b = false;
            this.f1203c = false;
            try {
                v12.n.f1411c.unregisterReceiver(this);
            } catch (IllegalArgumentException e5) {
                v12.c().h.b(e5, "Failed to unregister the network broadcast receiver");
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        V1 v12 = this.f1201a;
        v12.k();
        String action = intent.getAction();
        v12.c().f1084p.b(action, "NetworkBroadcastReceiver received action");
        if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            v12.c().f1080k.b(action, "NetworkBroadcastReceiver received unknown action");
            return;
        }
        C0060d0 c0060d0 = v12.f1018d;
        V1.J(c0060d0);
        boolean zI = c0060d0.I();
        if (this.f1203c != zI) {
            this.f1203c = zI;
            v12.e().t(new C0.A(this, zI));
        }
    }
}
