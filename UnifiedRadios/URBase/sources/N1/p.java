package N1;

import X2.s;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes.dex */
public final class p implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f1801j;

    /* renamed from: k, reason: collision with root package name */
    public Object f1802k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f1803l;

    public /* synthetic */ p(int i5, Object obj, Object obj2, boolean z4) {
        this.f1801j = i5;
        this.f1802k = obj;
        this.f1803l = obj2;
    }

    private final void a() {
        m1.k kVar = (m1.k) this.f1802k;
        IBinder iBinder = (IBinder) this.f1803l;
        synchronized (kVar) {
            if (iBinder == null) {
                kVar.a(0, "Null service connection");
                return;
            }
            try {
                kVar.f8535c = new L0.c(iBinder);
                kVar.f8533a = 2;
                ((ScheduledExecutorService) kVar.f8538f.f8546e).execute(new m1.i(kVar, 0));
            } catch (RemoteException e5) {
                kVar.a(0, e5.getMessage());
            }
        }
    }

    private final void b() {
        m1.k kVar = (m1.k) this.f1802k;
        int i5 = ((m1.l) this.f1803l).f8539a;
        synchronized (kVar) {
            m1.l lVar = (m1.l) kVar.f8537e.get(i5);
            if (lVar != null) {
                Log.w("MessengerIpcClient", "Timing out request: " + i5);
                kVar.f8537e.remove(i5);
                lVar.c(new s("Timed out waiting for response", null));
                kVar.c();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:137:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0435  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x045a A[Catch: Exception -> 0x04a4, TryCatch #12 {Exception -> 0x04a4, blocks: (B:161:0x044e, B:163:0x045a, B:166:0x04a6), top: B:283:0x044e }] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x04a6 A[Catch: Exception -> 0x04a4, TRY_LEAVE, TryCatch #12 {Exception -> 0x04a4, blocks: (B:161:0x044e, B:163:0x045a, B:166:0x04a6), top: B:283:0x044e }] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0518  */
    /* JADX WARN: Type inference failed for: r3v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() throws java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 1688
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: N1.p.run():void");
    }

    public /* synthetic */ p(Object obj, int i5, Object obj2) {
        this.f1801j = i5;
        this.f1803l = obj;
        this.f1802k = obj2;
    }
}
