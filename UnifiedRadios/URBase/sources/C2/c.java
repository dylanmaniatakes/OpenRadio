package C2;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements Executor {

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ c f185k = new c(1);

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ c f186l = new c(2);

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ c f187m = new c(3);
    public static final /* synthetic */ c n = new c(4);

    /* renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ c f188o = new c(5);

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f189j;

    public /* synthetic */ c(int i5) {
        this.f189j = i5;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f189j) {
            case 0:
                runnable.run();
                break;
            case 1:
                runnable.run();
                break;
            case 2:
                runnable.run();
                break;
            case 3:
                runnable.run();
                break;
            case 4:
                runnable.run();
                break;
            case 5:
                runnable.run();
                break;
            case 6:
                runnable.run();
                break;
            case 7:
                runnable.run();
                break;
            default:
                new Thread(runnable).start();
                break;
        }
    }
}
