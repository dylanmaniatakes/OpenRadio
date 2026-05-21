package G2;

import android.os.Process;
import h4.r;

/* loaded from: classes.dex */
public final class i implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f634j;

    /* renamed from: k, reason: collision with root package name */
    public final Runnable f635k;

    public /* synthetic */ i(Runnable runnable, int i5) {
        this.f634j = i5;
        this.f635k = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() throws SecurityException, IllegalArgumentException {
        switch (this.f634j) {
            case 0:
                this.f635k.run();
                break;
            case 1:
                try {
                    this.f635k.run();
                    break;
                } catch (Exception e5) {
                    r.h("Executor", "Background execution failure.", e5);
                    return;
                }
            default:
                Process.setThreadPriority(0);
                this.f635k.run();
                break;
        }
    }

    public String toString() {
        switch (this.f634j) {
            case 0:
                return this.f635k.toString();
            default:
                return super.toString();
        }
    }
}
