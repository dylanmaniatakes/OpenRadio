package J1;

import java.lang.Thread;

/* renamed from: J1.p0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0096p0 implements Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    public final String f1342a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0104s0 f1343b;

    public C0096p0(C0104s0 c0104s0, String str) {
        this.f1343b = c0104s0;
        this.f1342a = str;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        Z z4 = ((C0113v0) this.f1343b.f84c).f1417k;
        C0113v0.k(z4);
        z4.h.b(th, this.f1342a);
    }
}
