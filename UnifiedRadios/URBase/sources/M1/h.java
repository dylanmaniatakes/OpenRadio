package m1;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final /* synthetic */ class h implements Executor {

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ h f8526k = new h(0);

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ h f8527l = new h(1);

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f8528j;

    public /* synthetic */ h(int i5) {
        this.f8528j = i5;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f8528j) {
            case 0:
                runnable.run();
                break;
            default:
                runnable.run();
                break;
        }
    }
}
