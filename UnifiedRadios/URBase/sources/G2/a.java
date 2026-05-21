package G2;

import D.m;
import android.os.StrictMode;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public final class a implements ThreadFactory {

    /* renamed from: e, reason: collision with root package name */
    public static final ThreadFactory f611e = Executors.defaultThreadFactory();

    /* renamed from: a, reason: collision with root package name */
    public final AtomicLong f612a = new AtomicLong();

    /* renamed from: b, reason: collision with root package name */
    public final String f613b;

    /* renamed from: c, reason: collision with root package name */
    public final int f614c;

    /* renamed from: d, reason: collision with root package name */
    public final StrictMode.ThreadPolicy f615d;

    public a(String str, int i5, StrictMode.ThreadPolicy threadPolicy) {
        this.f613b = str;
        this.f614c = i5;
        this.f615d = threadPolicy;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread threadNewThread = f611e.newThread(new m(this, 5, runnable));
        Locale locale = Locale.ROOT;
        threadNewThread.setName(this.f613b + " Thread #" + this.f612a.getAndIncrement());
        return threadNewThread;
    }
}
