package i0;

import java.util.concurrent.Executor;
import l.C0722a;

/* renamed from: i0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class ExecutorC0566c implements Executor {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f7187j;

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f7187j) {
            case 0:
                runnable.run();
                break;
            default:
                C0722a.o().f8320a.f8323b.execute(runnable);
                break;
        }
    }
}
