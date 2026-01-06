package N3;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* renamed from: N3.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0138l {

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f1859b = AtomicIntegerFieldUpdater.newUpdater(C0138l.class, "_handled");
    private volatile int _handled;

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f1860a;

    public C0138l(Throwable th, boolean z4) {
        this.f1860a = th;
        this._handled = z4 ? 1 : 0;
    }

    public final String toString() {
        return getClass().getSimpleName() + '[' + this.f1860a + ']';
    }
}
