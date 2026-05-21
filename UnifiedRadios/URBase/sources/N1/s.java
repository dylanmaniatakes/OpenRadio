package n1;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class s extends t {

    /* renamed from: e, reason: collision with root package name */
    public final Callable f8772e;

    public /* synthetic */ s(CallableC0795l callableC0795l) {
        super(false, null, null);
        this.f8772e = callableC0795l;
    }

    @Override // n1.t
    public final String a() {
        try {
            return (String) this.f8772e.call();
        } catch (Exception e5) {
            throw new RuntimeException(e5);
        }
    }
}
