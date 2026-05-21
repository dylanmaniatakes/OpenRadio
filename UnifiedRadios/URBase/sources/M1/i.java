package m1;

import N1.p;
import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final /* synthetic */ class i implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f8529j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ k f8530k;

    public /* synthetic */ i(k kVar, int i5) {
        this.f8529j = i5;
        this.f8530k = kVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws RemoteException {
        switch (this.f8529j) {
            case 0:
                break;
            case 1:
                k kVar = this.f8530k;
                synchronized (kVar) {
                    if (kVar.f8533a == 1) {
                        kVar.a(1, "Timed out while binding");
                    }
                }
                return;
            default:
                this.f8530k.a(2, "Service disconnected");
                return;
        }
        while (true) {
            k kVar2 = this.f8530k;
            synchronized (kVar2) {
                try {
                    if (kVar2.f8533a != 2) {
                        return;
                    }
                    if (kVar2.f8536d.isEmpty()) {
                        kVar2.c();
                        return;
                    }
                    l lVar = (l) kVar2.f8536d.poll();
                    kVar2.f8537e.put(lVar.f8539a, lVar);
                    ((ScheduledExecutorService) kVar2.f8538f.f8546e).schedule(new p(8, kVar2, lVar, false), 30L, TimeUnit.SECONDS);
                    if (Log.isLoggable("MessengerIpcClient", 3)) {
                        Log.d("MessengerIpcClient", "Sending ".concat(String.valueOf(lVar)));
                    }
                    m mVar = kVar2.f8538f;
                    Messenger messenger = kVar2.f8534b;
                    int i5 = lVar.f8541c;
                    Context context = (Context) mVar.f8545d;
                    Message messageObtain = Message.obtain();
                    messageObtain.what = i5;
                    messageObtain.arg1 = lVar.f8539a;
                    messageObtain.replyTo = messenger;
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("oneWay", lVar.b());
                    bundle.putString("pkg", context.getPackageName());
                    bundle.putBundle("data", lVar.f8542d);
                    messageObtain.setData(bundle);
                    try {
                        L0.c cVar = kVar2.f8535c;
                        Messenger messenger2 = (Messenger) cVar.f1536d;
                        if (messenger2 != null) {
                            messenger2.send(messageObtain);
                        } else {
                            g gVar = (g) cVar.f1537e;
                            if (gVar == null) {
                                throw new IllegalStateException("Both messengers are null");
                            }
                            Messenger messenger3 = gVar.f8525j;
                            messenger3.getClass();
                            messenger3.send(messageObtain);
                        }
                    } catch (RemoteException e5) {
                        kVar2.a(2, e5.getMessage());
                    }
                } finally {
                }
            }
        }
    }
}
