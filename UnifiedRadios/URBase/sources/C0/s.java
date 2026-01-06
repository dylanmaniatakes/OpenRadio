package C0;

import android.content.Context;
import androidx.work.WorkerParameters;
import z2.InterfaceFutureC1000b;

/* loaded from: classes.dex */
public abstract class s {

    /* renamed from: c, reason: collision with root package name */
    public final Context f168c;

    /* renamed from: d, reason: collision with root package name */
    public final WorkerParameters f169d;

    /* renamed from: e, reason: collision with root package name */
    public volatile int f170e = -256;

    /* renamed from: f, reason: collision with root package name */
    public boolean f171f;

    public s(Context context, WorkerParameters workerParameters) {
        if (context == null) {
            throw new IllegalArgumentException("Application Context is null");
        }
        if (workerParameters == null) {
            throw new IllegalArgumentException("WorkerParameters is null");
        }
        this.f168c = context;
        this.f169d = workerParameters;
    }

    public InterfaceFutureC1000b a() {
        N0.k kVar = new N0.k();
        kVar.k(new IllegalStateException("Expedited WorkRequests require a ListenableWorker to provide an implementation for `getForegroundInfoAsync()`"));
        return kVar;
    }

    public void b() {
    }

    public abstract N0.k d();

    public final void e(int i5) {
        this.f170e = i5;
        b();
    }
}
