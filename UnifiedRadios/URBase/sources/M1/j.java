package m1;

import X2.s;
import X2.t;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import g0.AbstractC0535a;

/* loaded from: classes.dex */
public final /* synthetic */ class j implements Handler.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8531a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f8532b;

    public /* synthetic */ j(int i5, Object obj) {
        this.f8531a = i5;
        this.f8532b = obj;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        switch (this.f8531a) {
            case 0:
                int i5 = message.arg1;
                if (Log.isLoggable("MessengerIpcClient", 3)) {
                    AbstractC0535a.u("Received response to request: ", i5, "MessengerIpcClient");
                }
                k kVar = (k) this.f8532b;
                synchronized (kVar) {
                    try {
                        l lVar = (l) kVar.f8537e.get(i5);
                        if (lVar == null) {
                            Log.w("MessengerIpcClient", "Received response for unknown request: " + i5);
                            return true;
                        }
                        kVar.f8537e.remove(i5);
                        kVar.c();
                        Bundle data = message.getData();
                        if (data.getBoolean("unsupported", false)) {
                            lVar.c(new s("Not supported by GmsCore", null));
                            return true;
                        }
                        lVar.a(data);
                        return true;
                    } finally {
                    }
                }
            default:
                if (message.what != 0) {
                    return false;
                }
                t tVar = (t) this.f8532b;
                q2.l lVar2 = (q2.l) message.obj;
                synchronized (tVar.f2833c) {
                    if (((q2.l) tVar.f2835e) == lVar2 || ((q2.l) tVar.f2836f) == lVar2) {
                        tVar.a(lVar2, 2);
                    }
                }
                return true;
        }
    }
}
