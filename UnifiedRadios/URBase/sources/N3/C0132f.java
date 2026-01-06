package N3;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import w3.InterfaceC0936d;

/* renamed from: N3.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0132f extends C0138l {

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f1848c = AtomicIntegerFieldUpdater.newUpdater(C0132f.class, "_resumed");
    private volatile int _resumed;

    public C0132f(InterfaceC0936d interfaceC0936d, Throwable th, boolean z4) {
        super(th, z4);
        this._resumed = 0;
    }
}
