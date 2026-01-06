package L3;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class i implements Iterator, G3.a {

    /* renamed from: j, reason: collision with root package name */
    public final Iterator f1636j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ j f1637k;

    public i(j jVar) {
        this.f1637k = jVar;
        this.f1636j = jVar.f1638a.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f1636j.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return this.f1637k.f1639b.invoke(this.f1636j.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
