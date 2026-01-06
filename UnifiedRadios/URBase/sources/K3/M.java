package k3;

import android.util.Log;

/* loaded from: classes.dex */
public final class M implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f7989j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ int f7990k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ O f7991l;

    public /* synthetic */ M(O o5, int i5, int i6) {
        this.f7989j = i6;
        this.f7991l = o5;
        this.f7990k = i5;
    }

    @Override // java.lang.Runnable
    public final void run() throws InterruptedException {
        switch (this.f7989j) {
            case 0:
                try {
                    Thread.sleep(100L);
                    Log.d("Bridge", "Sound finished, starting transmission");
                    if (this.f7991l.f8001b.f5885L0) {
                        Log.d("Bridge", "Starting Transmission with " + this.f7991l.f8001b.f5915b1);
                        this.f7991l.f8001b.f5915b1.A(this.f7990k);
                        return;
                    }
                    return;
                } catch (InterruptedException e5) {
                    throw new RuntimeException(e5);
                }
            default:
                try {
                    Thread.sleep(100L);
                    Log.d("Bridge", "Sound finished, starting transmission");
                    if (this.f7991l.f8001b.f5885L0) {
                        Log.d("Bridge", "Starting Transmission with " + this.f7991l.f8001b.f5915b1);
                        this.f7991l.f8001b.f5915b1.A(this.f7990k);
                        return;
                    }
                    return;
                } catch (InterruptedException e6) {
                    throw new RuntimeException(e6);
                }
        }
    }
}
