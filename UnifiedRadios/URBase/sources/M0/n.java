package M0;

import D0.x;
import java.util.Set;

/* loaded from: classes.dex */
public final class n implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final D0.h f1687j;

    /* renamed from: k, reason: collision with root package name */
    public final D0.n f1688k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f1689l;

    /* renamed from: m, reason: collision with root package name */
    public final int f1690m;

    public n(D0.h hVar, D0.n nVar, boolean z4, int i5) {
        F3.i.f(hVar, "processor");
        F3.i.f(nVar, "token");
        this.f1687j = hVar;
        this.f1688k = nVar;
        this.f1689l = z4;
        this.f1690m = i5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zD;
        x xVarB;
        if (this.f1689l) {
            D0.h hVar = this.f1687j;
            D0.n nVar = this.f1688k;
            int i5 = this.f1690m;
            hVar.getClass();
            String str = nVar.f281a.f1551a;
            synchronized (hVar.f269k) {
                xVarB = hVar.b(str);
            }
            zD = D0.h.d(str, xVarB, i5);
        } else {
            D0.h hVar2 = this.f1687j;
            D0.n nVar2 = this.f1688k;
            int i6 = this.f1690m;
            hVar2.getClass();
            String str2 = nVar2.f281a.f1551a;
            synchronized (hVar2.f269k) {
                try {
                    if (hVar2.f266f.get(str2) != null) {
                        C0.t.d().a(D0.h.f260l, "Ignored stopWork. WorkerWrapper " + str2 + " is in foreground");
                    } else {
                        Set set = (Set) hVar2.h.get(str2);
                        if (set != null && set.contains(nVar2)) {
                            zD = D0.h.d(str2, hVar2.b(str2), i6);
                        }
                    }
                    zD = false;
                } finally {
                }
            }
        }
        C0.t.d().a(C0.t.f("StopWorkRunnable"), "StopWorkRunnable for " + this.f1688k.f281a.f1551a + "; Processor.stopWork = " + zD);
    }
}
