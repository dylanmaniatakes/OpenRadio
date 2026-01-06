package W3;

import android.os.Process;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: W3.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0191d extends Thread {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f2630j = 0;

    public /* synthetic */ C0191d(String str) {
        super(str);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws SecurityException, IllegalArgumentException {
        ReentrantLock reentrantLock;
        C0194g c0194gA;
        switch (this.f2630j) {
            case 0:
                break;
            default:
                Process.setThreadPriority(19);
                synchronized (this) {
                    while (true) {
                        try {
                            wait();
                        } catch (InterruptedException unused) {
                            return;
                        }
                    }
                }
        }
        while (true) {
            try {
                C0194g.Companion.getClass();
                reentrantLock = C0194g.lock;
                reentrantLock.lock();
                try {
                    c0194gA = C0190c.a();
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    throw th;
                }
            } catch (InterruptedException unused2) {
            }
            if (c0194gA == C0194g.head) {
                C0194g.head = null;
                reentrantLock.unlock();
                return;
            } else {
                reentrantLock.unlock();
                if (c0194gA != null) {
                    c0194gA.timedOut();
                }
            }
        }
    }

    public /* synthetic */ C0191d(ThreadGroup threadGroup, String str) {
        super(threadGroup, str);
    }
}
