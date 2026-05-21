package q0;

import g0.AbstractC0535a;

/* renamed from: q0.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0843f extends RuntimeException {

    /* renamed from: j, reason: collision with root package name */
    public final int f9292j;

    /* renamed from: k, reason: collision with root package name */
    public final Throwable f9293k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0843f(int i5, Throwable th) {
        super(th);
        AbstractC0535a.p(i5, "callbackName");
        this.f9292j = i5;
        this.f9293k = th;
    }

    @Override // java.lang.Throwable
    public final Throwable getCause() {
        return this.f9293k;
    }
}
