package L;

import android.os.Process;

/* loaded from: classes.dex */
public final class j extends Thread {

    /* renamed from: j, reason: collision with root package name */
    public final int f1528j;

    public j(Runnable runnable, String str, int i5) {
        super(runnable, str);
        this.f1528j = i5;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws SecurityException, IllegalArgumentException {
        Process.setThreadPriority(this.f1528j);
        super.run();
    }
}
