package N0;

import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    public static final a f1759c;

    /* renamed from: d, reason: collision with root package name */
    public static final a f1760d;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f1761a;

    /* renamed from: b, reason: collision with root package name */
    public final Throwable f1762b;

    static {
        if (i.f1780m) {
            f1760d = null;
            f1759c = null;
        } else {
            f1760d = new a(false, null);
            f1759c = new a(true, null);
        }
    }

    public a(boolean z4, CancellationException cancellationException) {
        this.f1761a = z4;
        this.f1762b = cancellationException;
    }
}
