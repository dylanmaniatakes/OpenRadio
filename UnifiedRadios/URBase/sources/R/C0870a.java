package r;

import java.util.concurrent.CancellationException;

/* renamed from: r.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0870a {

    /* renamed from: c, reason: collision with root package name */
    public static final C0870a f9482c;

    /* renamed from: d, reason: collision with root package name */
    public static final C0870a f9483d;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f9484a;

    /* renamed from: b, reason: collision with root package name */
    public final Throwable f9485b;

    static {
        if (g.f9497m) {
            f9483d = null;
            f9482c = null;
        } else {
            f9483d = new C0870a(false, null);
            f9482c = new C0870a(true, null);
        }
    }

    public C0870a(boolean z4, CancellationException cancellationException) {
        this.f9484a = z4;
        this.f9485b = cancellationException;
    }
}
