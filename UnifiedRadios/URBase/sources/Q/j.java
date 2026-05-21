package q;

import java.util.Collection;
import java.util.Iterator;
import l0.AbstractC0740p;

/* loaded from: classes.dex */
public final class j implements Collection {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ AbstractC0740p f9272j;

    public j(AbstractC0740p abstractC0740p) {
        this.f9272j = abstractC0740p;
    }

    @Override // java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final void clear() {
        this.f9272j.b();
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        return this.f9272j.g(obj) >= 0;
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.f9272j.e() == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new g(this.f9272j, 1);
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        AbstractC0740p abstractC0740p = this.f9272j;
        int iG = abstractC0740p.g(obj);
        if (iG < 0) {
            return false;
        }
        abstractC0740p.i(iG);
        return true;
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        AbstractC0740p abstractC0740p = this.f9272j;
        int iE = abstractC0740p.e();
        int i5 = 0;
        boolean z4 = false;
        while (i5 < iE) {
            if (collection.contains(abstractC0740p.c(i5, 1))) {
                abstractC0740p.i(i5);
                i5--;
                iE--;
                z4 = true;
            }
            i5++;
        }
        return z4;
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        AbstractC0740p abstractC0740p = this.f9272j;
        int iE = abstractC0740p.e();
        int i5 = 0;
        boolean z4 = false;
        while (i5 < iE) {
            if (!collection.contains(abstractC0740p.c(i5, 1))) {
                abstractC0740p.i(i5);
                i5--;
                iE--;
                z4 = true;
            }
            i5++;
        }
        return z4;
    }

    @Override // java.util.Collection
    public final int size() {
        return this.f9272j.e();
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        return this.f9272j.p(1, objArr);
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        AbstractC0740p abstractC0740p = this.f9272j;
        int iE = abstractC0740p.e();
        Object[] objArr = new Object[iE];
        for (int i5 = 0; i5 < iE; i5++) {
            objArr[i5] = abstractC0740p.c(i5, 1);
        }
        return objArr;
    }
}
