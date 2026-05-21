package o1;

import n1.C0787d;

/* loaded from: classes.dex */
public final class p extends UnsupportedOperationException {

    /* renamed from: j, reason: collision with root package name */
    public final C0787d f8907j;

    public p(C0787d c0787d) {
        this.f8907j = c0787d;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return "Missing ".concat(String.valueOf(this.f8907j));
    }
}
