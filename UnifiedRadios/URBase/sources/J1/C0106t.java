package J1;

import java.util.Iterator;
import java.util.ListIterator;

/* renamed from: J1.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0106t implements Iterator {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f1389j = 0;

    /* renamed from: k, reason: collision with root package name */
    public final Iterator f1390k;

    public C0106t(C0109u c0109u) {
        this.f1390k = c0109u.f1395j.keySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f1389j) {
            case 0:
                return this.f1390k.hasNext();
            default:
                return ((ListIterator) this.f1390k).hasPrevious();
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f1389j) {
            case 0:
                return (String) this.f1390k.next();
            default:
                return (m4.e) ((ListIterator) this.f1390k).previous();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f1389j) {
            case 0:
                throw new UnsupportedOperationException("Remove not supported");
            default:
                ((ListIterator) this.f1390k).remove();
                return;
        }
    }

    public C0106t(ListIterator listIterator) {
        this.f1390k = listIterator;
    }
}
