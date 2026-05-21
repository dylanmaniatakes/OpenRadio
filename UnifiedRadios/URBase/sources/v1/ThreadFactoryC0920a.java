package v1;

import G2.i;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* renamed from: v1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ThreadFactoryC0920a implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final String f10012a;

    /* renamed from: b, reason: collision with root package name */
    public final ThreadFactory f10013b = Executors.defaultThreadFactory();

    public ThreadFactoryC0920a(String str) {
        this.f10012a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread threadNewThread = this.f10013b.newThread(new i(runnable, 2));
        threadNewThread.setName(this.f10012a);
        return threadNewThread;
    }
}
