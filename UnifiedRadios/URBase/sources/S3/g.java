package S3;

import w3.InterfaceC0941i;

/* loaded from: classes.dex */
public final class g extends RuntimeException {

    /* renamed from: j, reason: collision with root package name */
    public final transient InterfaceC0941i f2391j;

    public g(InterfaceC0941i interfaceC0941i) {
        this.f2391j = interfaceC0941i;
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override // java.lang.Throwable
    public final String getLocalizedMessage() {
        return this.f2391j.toString();
    }
}
