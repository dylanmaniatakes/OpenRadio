package u3;

import F3.i;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* renamed from: u3.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0915f extends t3.e {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f9960j;

    /* renamed from: k, reason: collision with root package name */
    public final C0914e f9961k;

    public C0915f(C0914e c0914e, int i5) {
        this.f9960j = i5;
        switch (i5) {
            case 1:
                i.f(c0914e, "backing");
                this.f9961k = c0914e;
                break;
            default:
                i.f(c0914e, "backing");
                this.f9961k = c0914e;
                break;
        }
    }

    @Override // t3.e
    public final int a() {
        switch (this.f9960j) {
        }
        return this.f9961k.f9955q;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        switch (this.f9960j) {
            case 0:
                i.f((Map.Entry) obj, "element");
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        switch (this.f9960j) {
            case 0:
                i.f(collection, "elements");
                throw new UnsupportedOperationException();
            default:
                i.f(collection, "elements");
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        switch (this.f9960j) {
            case 0:
                this.f9961k.clear();
                break;
            default:
                this.f9961k.clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        switch (this.f9960j) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                i.f(entry, "element");
                return this.f9961k.e(entry);
            default:
                return this.f9961k.containsKey(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection collection) {
        switch (this.f9960j) {
            case 0:
                i.f(collection, "elements");
                return this.f9961k.d(collection);
            default:
                return super.containsAll(collection);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        switch (this.f9960j) {
        }
        return this.f9961k.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.f9960j) {
            case 0:
                C0914e c0914e = this.f9961k;
                c0914e.getClass();
                return new C0912c(c0914e, 0);
            default:
                C0914e c0914e2 = this.f9961k;
                c0914e2.getClass();
                return new C0912c(c0914e2, 1);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        switch (this.f9960j) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                i.f(entry, "element");
                C0914e c0914e = this.f9961k;
                c0914e.getClass();
                c0914e.c();
                int iG = c0914e.g(entry.getKey());
                if (iG < 0) {
                    return false;
                }
                Object[] objArr = c0914e.f9950k;
                i.c(objArr);
                if (!i.a(objArr[iG], entry.getValue())) {
                    return false;
                }
                c0914e.k(iG);
                return true;
            default:
                C0914e c0914e2 = this.f9961k;
                c0914e2.c();
                int iG2 = c0914e2.g(obj);
                if (iG2 < 0) {
                    iG2 = -1;
                } else {
                    c0914e2.k(iG2);
                }
                return iG2 >= 0;
        }
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        switch (this.f9960j) {
            case 0:
                i.f(collection, "elements");
                this.f9961k.c();
                break;
            default:
                i.f(collection, "elements");
                this.f9961k.c();
                break;
        }
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        switch (this.f9960j) {
            case 0:
                i.f(collection, "elements");
                this.f9961k.c();
                break;
            default:
                i.f(collection, "elements");
                this.f9961k.c();
                break;
        }
        return super.retainAll(collection);
    }
}
