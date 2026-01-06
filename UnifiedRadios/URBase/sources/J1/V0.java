package J1;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class V0 implements Executor {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f1003j;

    /* renamed from: k, reason: collision with root package name */
    public final Object f1004k;

    public /* synthetic */ V0(int i5, Object obj) {
        this.f1003j = i5;
        this.f1004k = obj;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f1003j) {
            case 0:
                C0104s0 c0104s0 = ((C0113v0) ((C0058c1) this.f1004k).f84c).f1418l;
                C0113v0.k(c0104s0);
                c0104s0.t(runnable);
                break;
            case 1:
                ((A1.f) this.f1004k).post(runnable);
                break;
            case 2:
                ((Handler) ((L0.i) this.f1004k).f1549e).post(runnable);
                break;
            case 3:
                ((Executor) this.f1004k).execute(new G2.i(runnable, 1));
                break;
            default:
                ((A1.f) this.f1004k).post(runnable);
                break;
        }
    }

    public V0() {
        this.f1003j = 1;
        A1.f fVar = new A1.f(Looper.getMainLooper());
        Looper.getMainLooper();
        this.f1004k = fVar;
    }

    public V0(Looper looper) {
        this.f1003j = 4;
        this.f1004k = new A1.f(looper, 2);
    }
}
