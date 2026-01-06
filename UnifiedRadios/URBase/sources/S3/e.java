package S3;

import N3.InterfaceC0144s;
import w3.InterfaceC0941i;

/* loaded from: classes.dex */
public final class e implements InterfaceC0144s {

    /* renamed from: j, reason: collision with root package name */
    public final InterfaceC0941i f2389j;

    public e(InterfaceC0941i interfaceC0941i) {
        this.f2389j = interfaceC0941i;
    }

    @Override // N3.InterfaceC0144s
    public final InterfaceC0941i d() {
        return this.f2389j;
    }

    public final String toString() {
        return "CoroutineScope(coroutineContext=" + this.f2389j + ')';
    }
}
