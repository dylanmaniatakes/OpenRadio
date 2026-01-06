package O;

import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: O.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0177p {

    /* renamed from: a, reason: collision with root package name */
    public final Runnable f1948a;

    /* renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f1949b = new CopyOnWriteArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f1950c = new HashMap();

    public C0177p(Runnable runnable) {
        this.f1948a = runnable;
    }

    public final void a() {
        this.f1949b.remove((Object) null);
        C0176o c0176o = (C0176o) this.f1950c.remove(null);
        if (c0176o != null) {
            c0176o.f1946a.b(c0176o.f1947b);
            c0176o.f1947b = null;
        }
        this.f1948a.run();
    }
}
