package j1;

import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* renamed from: j1.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0601c extends Thread {

    /* renamed from: j, reason: collision with root package name */
    public final WeakReference f7571j;

    /* renamed from: k, reason: collision with root package name */
    public final long f7572k;

    /* renamed from: l, reason: collision with root package name */
    public final CountDownLatch f7573l = new CountDownLatch(1);

    /* renamed from: m, reason: collision with root package name */
    public boolean f7574m = false;

    public C0601c(C0600b c0600b, long j5) {
        this.f7571j = new WeakReference(c0600b);
        this.f7572k = j5;
        start();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        C0600b c0600b;
        WeakReference weakReference = this.f7571j;
        try {
            if (this.f7573l.await(this.f7572k, TimeUnit.MILLISECONDS) || (c0600b = (C0600b) weakReference.get()) == null) {
                return;
            }
            c0600b.b();
            this.f7574m = true;
        } catch (InterruptedException unused) {
            C0600b c0600b2 = (C0600b) weakReference.get();
            if (c0600b2 != null) {
                c0600b2.b();
                this.f7574m = true;
            }
        }
    }
}
