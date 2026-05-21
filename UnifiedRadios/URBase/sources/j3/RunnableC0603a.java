package j3;

import X2.n;
import java.util.concurrent.atomic.AtomicBoolean;
import k3.U;

/* renamed from: j3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0603a implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f7576j = 0;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ n f7577k;

    public /* synthetic */ RunnableC0603a(n nVar) {
        this.f7577k = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7576j) {
            case 0:
                n nVar = this.f7577k;
                AtomicBoolean atomicBoolean = (AtomicBoolean) nVar.f2822e;
                try {
                    n.n(200L);
                    nVar.l();
                    return;
                } finally {
                    atomicBoolean.set(false);
                }
            default:
                U u4 = (U) this.f7577k.f2818a;
                if (u4 != null) {
                    u4.f8056c.runOnUiThread(new C0.e(22, u4));
                    return;
                }
                return;
        }
    }

    public /* synthetic */ RunnableC0603a(n nVar, String str) {
        this.f7577k = nVar;
    }
}
