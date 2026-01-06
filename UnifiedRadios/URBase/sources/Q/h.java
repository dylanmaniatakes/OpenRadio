package q;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import l0.AbstractC0740p;

/* loaded from: classes.dex */
public final class h implements Set {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f9266j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ AbstractC0740p f9267k;

    public /* synthetic */ h(AbstractC0740p abstractC0740p, int i5) {
        this.f9266j = i5;
        this.f9267k = abstractC0740p;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean add(Object obj) {
        switch (this.f9266j) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean addAll(Collection collection) {
        switch (this.f9266j) {
            case 0:
                AbstractC0740p abstractC0740p = this.f9267k;
                int iE = abstractC0740p.e();
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    abstractC0740p.h(entry.getKey(), entry.getValue());
                }
                return iE != abstractC0740p.e();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final void clear() {
        switch (this.f9266j) {
            case 0:
                this.f9267k.b();
                break;
            default:
                this.f9267k.b();
                break;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean contains(Object obj) {
        switch (this.f9266j) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                AbstractC0740p abstractC0740p = this.f9267k;
                int iF = abstractC0740p.f(key);
                if (iF < 0) {
                    return false;
                }
                Object objC = abstractC0740p.c(iF, 1);
                Object value = entry.getValue();
                return objC == value || (objC != null && objC.equals(value));
            default:
                return this.f9267k.f(obj) >= 0;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean containsAll(Collection collection) {
        switch (this.f9266j) {
            case 0:
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    if (!contains(it.next())) {
                        break;
                    }
                }
                break;
            default:
                Map mapD = this.f9267k.d();
                Iterator it2 = collection.iterator();
                while (it2.hasNext()) {
                    if (!mapD.containsKey(it2.next())) {
                        break;
                    }
                }
                break;
        }
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean equals(Object obj) {
        switch (this.f9266j) {
        }
        return AbstractC0740p.m(this, obj);
    }

    @Override // java.util.Set, java.util.Collection
    public final int hashCode() {
        switch (this.f9266j) {
            case 0:
                AbstractC0740p abstractC0740p = this.f9267k;
                int iHashCode = 0;
                for (int iE = abstractC0740p.e() - 1; iE >= 0; iE--) {
                    Object objC = abstractC0740p.c(iE, 0);
                    Object objC2 = abstractC0740p.c(iE, 1);
                    iHashCode += (objC == null ? 0 : objC.hashCode()) ^ (objC2 == null ? 0 : objC2.hashCode());
                }
                return iHashCode;
            default:
                AbstractC0740p abstractC0740p2 = this.f9267k;
                int iHashCode2 = 0;
                for (int iE2 = abstractC0740p2.e() - 1; iE2 >= 0; iE2--) {
                    Object objC3 = abstractC0740p2.c(iE2, 0);
                    iHashCode2 += objC3 == null ? 0 : objC3.hashCode();
                }
                return iHashCode2;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean isEmpty() {
        switch (this.f9266j) {
            case 0:
                if (this.f9267k.e() == 0) {
                }
                break;
            default:
                if (this.f9267k.e() == 0) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        switch (this.f9266j) {
            case 0:
                return new i(this.f9267k);
            default:
                return new g(this.f9267k, 0);
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean remove(Object obj) {
        switch (this.f9266j) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                AbstractC0740p abstractC0740p = this.f9267k;
                int iF = abstractC0740p.f(obj);
                if (iF < 0) {
                    return false;
                }
                abstractC0740p.i(iF);
                return true;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean removeAll(Collection collection) {
        switch (this.f9266j) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                Map mapD = this.f9267k.d();
                int size = mapD.size();
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    mapD.remove(it.next());
                }
                return size != mapD.size();
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean retainAll(Collection collection) {
        switch (this.f9266j) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                return AbstractC0740p.o(this.f9267k.d(), collection);
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final int size() {
        switch (this.f9266j) {
        }
        return this.f9267k.e();
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        switch (this.f9266j) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                return this.f9267k.p(0, objArr);
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray() {
        switch (this.f9266j) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                AbstractC0740p abstractC0740p = this.f9267k;
                int iE = abstractC0740p.e();
                Object[] objArr = new Object[iE];
                for (int i5 = 0; i5 < iE; i5++) {
                    objArr[i5] = abstractC0740p.c(i5, 0);
                }
                return objArr;
        }
    }
}
