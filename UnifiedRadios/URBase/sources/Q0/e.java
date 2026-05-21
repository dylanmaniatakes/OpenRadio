package Q0;

import android.os.Handler;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class e implements Executor {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f2141j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Handler f2142k;

    public /* synthetic */ e(Handler handler, int i5) {
        this.f2141j = i5;
        this.f2142k = handler;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f2141j) {
            case 0:
                this.f2142k.post(runnable);
                break;
            default:
                this.f2142k.post(runnable);
                break;
        }
    }
}
