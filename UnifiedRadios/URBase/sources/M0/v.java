package M0;

import java.util.HashMap;

/* loaded from: classes.dex */
public final class v {

    /* renamed from: e, reason: collision with root package name */
    public static final String f1705e = C0.t.f("WorkTimer");

    /* renamed from: a, reason: collision with root package name */
    public final L0.l f1706a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f1707b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f1708c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final Object f1709d = new Object();

    public v(L0.l lVar) {
        this.f1706a = lVar;
    }

    public final void a(L0.j jVar) {
        synchronized (this.f1709d) {
            try {
                if (((u) this.f1707b.remove(jVar)) != null) {
                    C0.t.d().a(f1705e, "Stopping timer for " + jVar);
                    this.f1708c.remove(jVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
