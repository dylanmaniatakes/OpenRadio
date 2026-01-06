package q1;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

/* loaded from: classes.dex */
public final class O implements Handler.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ P f9334a;

    public /* synthetic */ O(P p4) {
        this.f9334a = p4;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i5 = message.what;
        if (i5 == 0) {
            synchronized (this.f9334a.f9337a) {
                try {
                    M m5 = (M) message.obj;
                    N n = (N) this.f9334a.f9337a.get(m5);
                    if (n != null && n.f9328a.isEmpty()) {
                        if (n.f9330c) {
                            n.g.f9339c.removeMessages(1, n.f9332e);
                            P p4 = n.g;
                            p4.f9340d.c(p4.f9338b, n);
                            n.f9330c = false;
                            n.f9329b = 2;
                        }
                        this.f9334a.f9337a.remove(m5);
                    }
                } finally {
                }
            }
            return true;
        }
        if (i5 != 1) {
            return false;
        }
        synchronized (this.f9334a.f9337a) {
            try {
                M m6 = (M) message.obj;
                N n5 = (N) this.f9334a.f9337a.get(m6);
                if (n5 != null && n5.f9329b == 3) {
                    Log.e("GmsClientSupervisor", "Timeout waiting for ServiceConnection callback ".concat(String.valueOf(m6)), new Exception());
                    ComponentName componentName = n5.f9333f;
                    if (componentName == null) {
                        m6.getClass();
                        componentName = null;
                    }
                    if (componentName == null) {
                        String str = m6.f9326b;
                        E.i(str);
                        componentName = new ComponentName(str, "unknown");
                    }
                    n5.onServiceDisconnected(componentName);
                }
            } finally {
            }
        }
        return true;
    }
}
