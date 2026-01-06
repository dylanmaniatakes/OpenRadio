package Z3;

import J1.C;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* loaded from: classes.dex */
public final class e extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final C f3161a;

    /* renamed from: b, reason: collision with root package name */
    public final c f3162b;

    public e(c cVar, Looper looper) {
        super(looper);
        this.f3162b = cVar;
        this.f3161a = new C(22);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        SystemClock.uptimeMillis();
        this.f3161a.m();
        synchronized (this) {
            this.f3161a.m();
        }
    }
}
