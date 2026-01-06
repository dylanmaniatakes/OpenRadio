package F2;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class l implements N2.c, N2.b {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f566a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayDeque f567b;

    /* renamed from: c, reason: collision with root package name */
    public final Executor f568c;

    public l() {
        G2.k kVar = G2.k.f641j;
        this.f566a = new HashMap();
        this.f567b = new ArrayDeque();
        this.f568c = kVar;
    }

    public final synchronized void a(Executor executor, N2.a aVar) {
        try {
            executor.getClass();
            if (!this.f566a.containsKey(A2.b.class)) {
                this.f566a.put(A2.b.class, new ConcurrentHashMap());
            }
            ((ConcurrentHashMap) this.f566a.get(A2.b.class)).put(aVar, executor);
        } catch (Throwable th) {
            throw th;
        }
    }
}
