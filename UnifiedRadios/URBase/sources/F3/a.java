package F3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public class a implements Iterator, G3.a {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f586j = 1;

    /* renamed from: k, reason: collision with root package name */
    public int f587k;

    /* renamed from: l, reason: collision with root package name */
    public final Object f588l;

    public a(Object[] objArr) {
        i.f(objArr, "array");
        this.f588l = objArr;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        Iterator it;
        switch (this.f586j) {
            case 0:
                return this.f587k < ((Object[]) this.f588l).length;
            case 1:
                break;
            default:
                return this.f587k < ((t3.c) this.f588l).a();
        }
        while (true) {
            int i5 = this.f587k;
            it = (Iterator) this.f588l;
            if (i5 > 0 && it.hasNext()) {
                it.next();
                this.f587k--;
            }
        }
        return it.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        Iterator it;
        switch (this.f586j) {
            case 0:
                try {
                    Object[] objArr = (Object[]) this.f588l;
                    int i5 = this.f587k;
                    this.f587k = i5 + 1;
                    return objArr[i5];
                } catch (ArrayIndexOutOfBoundsException e5) {
                    this.f587k--;
                    throw new NoSuchElementException(e5.getMessage());
                }
            case 1:
                break;
            default:
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                int i6 = this.f587k;
                this.f587k = i6 + 1;
                return ((t3.c) this.f588l).get(i6);
        }
        while (true) {
            int i7 = this.f587k;
            it = (Iterator) this.f588l;
            if (i7 > 0 && it.hasNext()) {
                it.next();
                this.f587k--;
            }
        }
        return it.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f586j) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 1:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public a(t3.c cVar) {
        this.f588l = cVar;
    }

    public a(L3.b bVar) {
        this.f588l = bVar.f1627a.iterator();
        this.f587k = bVar.f1628b;
    }
}
