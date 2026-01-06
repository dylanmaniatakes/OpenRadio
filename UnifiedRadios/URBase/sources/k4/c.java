package k4;

import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class c implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ L0.e f8263j;

    public c(L0.e eVar) {
        this.f8263j = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        L0.e eVar = this.f8263j;
        try {
            ((Runnable) eVar.f1542e).run();
        } finally {
            ((AtomicBoolean) eVar.f1541d).set(false);
        }
    }
}
