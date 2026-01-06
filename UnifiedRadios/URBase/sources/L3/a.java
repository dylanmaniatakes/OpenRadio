package L3;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class a implements c {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f1626a;

    public a(g gVar) {
        this.f1626a = new AtomicReference(gVar);
    }

    @Override // L3.c
    public final Iterator iterator() {
        c cVar = (c) this.f1626a.getAndSet(null);
        if (cVar != null) {
            return cVar.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
