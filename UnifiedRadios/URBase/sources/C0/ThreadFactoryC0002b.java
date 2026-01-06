package C0;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import s.AbstractC0882e;

/* renamed from: C0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ThreadFactoryC0002b implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicInteger f138a = new AtomicInteger(0);

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f139b;

    public ThreadFactoryC0002b(boolean z4) {
        this.f139b = z4;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        F3.i.f(runnable, "runnable");
        StringBuilder sbB = AbstractC0882e.b(this.f139b ? "WM.task-" : "androidx.work-");
        sbB.append(this.f138a.incrementAndGet());
        return new Thread(runnable, sbB.toString());
    }
}
