package J1;

import android.app.BroadcastOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;

/* loaded from: classes.dex */
public final class E1 extends AbstractC0092o {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f731e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f732f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ E1(Object obj, G0 g02, int i5) {
        super(g02);
        this.f731e = i5;
        this.f732f = obj;
    }

    @Override // J1.AbstractC0092o
    public final void b() {
        switch (this.f731e) {
            case 0:
                F1 f12 = (F1) this.f732f;
                G1 g12 = f12.f737d;
                g12.j();
                C0113v0 c0113v0 = (C0113v0) g12.f84c;
                c0113v0.f1421p.getClass();
                f12.a(SystemClock.elapsedRealtime(), false, false);
                A a2 = c0113v0.f1424s;
                C0113v0.h(a2);
                c0113v0.f1421p.getClass();
                a2.m(SystemClock.elapsedRealtime());
                break;
            case 1:
                L1 l12 = (L1) this.f732f;
                l12.n();
                Z z4 = ((C0113v0) l12.f84c).f1417k;
                C0113v0.k(z4);
                z4.f1084p.a("Starting upload from DelayedRunnable");
                l12.f902d.U();
                break;
            default:
                V1 v12 = (V1) this.f732f;
                v12.e().j();
                String str = (String) v12.f1030s.pollFirst();
                if (str != null) {
                    v12.f().getClass();
                    v12.f1015K = SystemClock.elapsedRealtime();
                    v12.c().f1084p.b(str, "Sending trigger URI notification to app");
                    Intent intent = new Intent();
                    intent.setAction("com.google.android.gms.measurement.TRIGGERS_AVAILABLE");
                    intent.setPackage(str);
                    Context context = v12.n.f1411c;
                    if (Build.VERSION.SDK_INT < 34) {
                        context.sendBroadcast(intent);
                    } else {
                        context.sendBroadcast(intent, null, BroadcastOptions.makeBasic().setShareIdentityEnabled(true).toBundle());
                    }
                }
                v12.C();
                break;
        }
    }
}
