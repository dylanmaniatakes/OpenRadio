package u3;

import F3.i;
import com.google.android.gms.internal.measurement.AbstractC0409x1;
import com.google.android.gms.internal.measurement.D1;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* renamed from: u3.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0911b extends t3.d implements RandomAccess, Serializable {

    /* renamed from: p, reason: collision with root package name */
    public static final C0911b f9936p;

    /* renamed from: j, reason: collision with root package name */
    public Object[] f9937j;

    /* renamed from: k, reason: collision with root package name */
    public final int f9938k;

    /* renamed from: l, reason: collision with root package name */
    public int f9939l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f9940m;
    public final C0911b n;

    /* renamed from: o, reason: collision with root package name */
    public final C0911b f9941o;

    static {
        C0911b c0911b = new C0911b(0);
        c0911b.f9940m = true;
        f9936p = c0911b;
    }

    public C0911b(Object[] objArr, int i5, int i6, boolean z4, C0911b c0911b, C0911b c0911b2) {
        this.f9937j = objArr;
        this.f9938k = i5;
        this.f9939l = i6;
        this.f9940m = z4;
        this.n = c0911b;
        this.f9941o = c0911b2;
    }

    @Override // t3.d
    public final int a() {
        return this.f9939l;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        f();
        e(this.f9938k + this.f9939l, obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        i.f(collection, "elements");
        f();
        int size = collection.size();
        d(this.f9938k + this.f9939l, collection, size);
        return size > 0;
    }

    @Override // t3.d
    public final Object b(int i5) {
        f();
        int i6 = this.f9939l;
        if (i5 < 0 || i5 >= i6) {
            throw new IndexOutOfBoundsException(com.unified.ur1.SatelliteTracker.h.c("index: ", ", size: ", i5, i6));
        }
        return h(this.f9938k + i5);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        f();
        i(this.f9938k, this.f9939l);
    }

    public final void d(int i5, Collection collection, int i6) {
        C0911b c0911b = this.n;
        if (c0911b != null) {
            c0911b.d(i5, collection, i6);
            this.f9937j = c0911b.f9937j;
            this.f9939l += i6;
        } else {
            g(i5, i6);
            Iterator it = collection.iterator();
            for (int i7 = 0; i7 < i6; i7++) {
                this.f9937j[i5 + i7] = it.next();
            }
        }
    }

    public final void e(int i5, Object obj) {
        C0911b c0911b = this.n;
        if (c0911b == null) {
            g(i5, 1);
            this.f9937j[i5] = obj;
        } else {
            c0911b.e(i5, obj);
            this.f9937j = c0911b.f9937j;
            this.f9939l++;
        }
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof List)) {
                return false;
            }
            List list = (List) obj;
            Object[] objArr = this.f9937j;
            int i5 = this.f9939l;
            if (i5 != list.size()) {
                return false;
            }
            for (int i6 = 0; i6 < i5; i6++) {
                if (!i.a(objArr[this.f9938k + i6], list.get(i6))) {
                    return false;
                }
            }
        }
        return true;
    }

    public final void f() {
        C0911b c0911b;
        if (this.f9940m || ((c0911b = this.f9941o) != null && c0911b.f9940m)) {
            throw new UnsupportedOperationException();
        }
    }

    public final void g(int i5, int i6) {
        int i7 = this.f9939l + i6;
        if (this.n != null) {
            throw new IllegalStateException();
        }
        if (i7 < 0) {
            throw new OutOfMemoryError();
        }
        Object[] objArr = this.f9937j;
        if (i7 > objArr.length) {
            int length = objArr.length;
            int i8 = length + (length >> 1);
            if (i8 - i7 < 0) {
                i8 = i7;
            }
            if (i8 - 2147483639 > 0) {
                i8 = i7 > 2147483639 ? Integer.MAX_VALUE : 2147483639;
            }
            Object[] objArrCopyOf = Arrays.copyOf(objArr, i8);
            i.e(objArrCopyOf, "copyOf(this, newSize)");
            this.f9937j = objArrCopyOf;
        }
        Object[] objArr2 = this.f9937j;
        t3.h.s(i5 + i6, i5, this.f9938k + this.f9939l, objArr2, objArr2);
        this.f9939l += i6;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i5) {
        int i6 = this.f9939l;
        if (i5 < 0 || i5 >= i6) {
            throw new IndexOutOfBoundsException(com.unified.ur1.SatelliteTracker.h.c("index: ", ", size: ", i5, i6));
        }
        return this.f9937j[this.f9938k + i5];
    }

    public final Object h(int i5) {
        C0911b c0911b = this.n;
        if (c0911b != null) {
            this.f9939l--;
            return c0911b.h(i5);
        }
        Object[] objArr = this.f9937j;
        Object obj = objArr[i5];
        int i6 = this.f9939l;
        int i7 = this.f9938k;
        t3.h.s(i5, i5 + 1, i6 + i7, objArr, objArr);
        Object[] objArr2 = this.f9937j;
        int i8 = (i7 + this.f9939l) - 1;
        i.f(objArr2, "<this>");
        objArr2[i8] = null;
        this.f9939l--;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        Object[] objArr = this.f9937j;
        int i5 = this.f9939l;
        int iHashCode = 1;
        for (int i6 = 0; i6 < i5; i6++) {
            Object obj = objArr[this.f9938k + i6];
            iHashCode = (iHashCode * 31) + (obj != null ? obj.hashCode() : 0);
        }
        return iHashCode;
    }

    public final void i(int i5, int i6) {
        C0911b c0911b = this.n;
        if (c0911b != null) {
            c0911b.i(i5, i6);
        } else {
            Object[] objArr = this.f9937j;
            t3.h.s(i5, i5 + i6, this.f9939l, objArr, objArr);
            Object[] objArr2 = this.f9937j;
            int i7 = this.f9939l;
            h4.d.n(objArr2, i7 - i6, i7);
        }
        this.f9939l -= i6;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        for (int i5 = 0; i5 < this.f9939l; i5++) {
            if (i.a(this.f9937j[this.f9938k + i5], obj)) {
                return i5;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.f9939l == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new C0910a(this, 0);
    }

    public final int j(int i5, int i6, Collection collection, boolean z4) {
        C0911b c0911b = this.n;
        if (c0911b != null) {
            int iJ = c0911b.j(i5, i6, collection, z4);
            this.f9939l -= iJ;
            return iJ;
        }
        int i7 = 0;
        int i8 = 0;
        while (i7 < i6) {
            int i9 = i5 + i7;
            if (collection.contains(this.f9937j[i9]) == z4) {
                Object[] objArr = this.f9937j;
                i7++;
                objArr[i8 + i5] = objArr[i9];
                i8++;
            } else {
                i7++;
            }
        }
        int i10 = i6 - i8;
        Object[] objArr2 = this.f9937j;
        t3.h.s(i5 + i8, i6 + i5, this.f9939l, objArr2, objArr2);
        Object[] objArr3 = this.f9937j;
        int i11 = this.f9939l;
        h4.d.n(objArr3, i11 - i10, i11);
        this.f9939l -= i10;
        return i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        for (int i5 = this.f9939l - 1; i5 >= 0; i5--) {
            if (i.a(this.f9937j[this.f9938k + i5], obj)) {
                return i5;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator() {
        return new C0910a(this, 0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        f();
        int iIndexOf = indexOf(obj);
        if (iIndexOf >= 0) {
            b(iIndexOf);
        }
        return iIndexOf >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        i.f(collection, "elements");
        f();
        return j(this.f9938k, this.f9939l, collection, false) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        i.f(collection, "elements");
        f();
        return j(this.f9938k, this.f9939l, collection, true) > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i5, Object obj) {
        f();
        int i6 = this.f9939l;
        if (i5 < 0 || i5 >= i6) {
            throw new IndexOutOfBoundsException(com.unified.ur1.SatelliteTracker.h.c("index: ", ", size: ", i5, i6));
        }
        Object[] objArr = this.f9937j;
        int i7 = this.f9938k;
        Object obj2 = objArr[i7 + i5];
        objArr[i7 + i5] = obj;
        return obj2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i5, int i6) {
        AbstractC0409x1.a(i5, i6, this.f9939l);
        Object[] objArr = this.f9937j;
        int i7 = this.f9938k + i5;
        int i8 = i6 - i5;
        boolean z4 = this.f9940m;
        C0911b c0911b = this.f9941o;
        return new C0911b(objArr, i7, i8, z4, this, c0911b == null ? this : c0911b);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        i.f(objArr, "destination");
        int length = objArr.length;
        int i5 = this.f9939l;
        int i6 = this.f9938k;
        if (length < i5) {
            Object[] objArrCopyOfRange = Arrays.copyOfRange(this.f9937j, i6, i5 + i6, objArr.getClass());
            i.e(objArrCopyOfRange, "copyOfRange(array, offse…h, destination.javaClass)");
            return objArrCopyOfRange;
        }
        t3.h.s(0, i6, i5 + i6, this.f9937j, objArr);
        int length2 = objArr.length;
        int i7 = this.f9939l;
        if (length2 > i7) {
            objArr[i7] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        Object[] objArr = this.f9937j;
        int i5 = this.f9939l;
        StringBuilder sb = new StringBuilder((i5 * 3) + 2);
        sb.append("[");
        for (int i6 = 0; i6 < i5; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            sb.append(objArr[this.f9938k + i6]);
        }
        sb.append("]");
        String string = sb.toString();
        i.e(string, "sb.toString()");
        return string;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i5) {
        int i6 = this.f9939l;
        if (i5 < 0 || i5 > i6) {
            throw new IndexOutOfBoundsException(com.unified.ur1.SatelliteTracker.h.c("index: ", ", size: ", i5, i6));
        }
        return new C0910a(this, i5);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i5, Object obj) {
        f();
        int i6 = this.f9939l;
        if (i5 >= 0 && i5 <= i6) {
            e(this.f9938k + i5, obj);
            return;
        }
        throw new IndexOutOfBoundsException(com.unified.ur1.SatelliteTracker.h.c("index: ", ", size: ", i5, i6));
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i5, Collection collection) {
        i.f(collection, "elements");
        f();
        int i6 = this.f9939l;
        if (i5 >= 0 && i5 <= i6) {
            int size = collection.size();
            d(this.f9938k + i5, collection, size);
            return size > 0;
        }
        throw new IndexOutOfBoundsException(com.unified.ur1.SatelliteTracker.h.c("index: ", ", size: ", i5, i6));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        Object[] objArr = this.f9937j;
        int i5 = this.f9939l;
        int i6 = this.f9938k;
        int i7 = i5 + i6;
        i.f(objArr, "<this>");
        D1.c(i7, objArr.length);
        Object[] objArrCopyOfRange = Arrays.copyOfRange(objArr, i6, i7);
        i.e(objArrCopyOfRange, "copyOfRange(this, fromIndex, toIndex)");
        return objArrCopyOfRange;
    }

    public C0911b() {
        this(10);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C0911b(int i5) {
        this(new Object[i5], 0, 0, false, null, null);
        if (i5 >= 0) {
            return;
        }
        throw new IllegalArgumentException("capacity must be non-negative.".toString());
    }
}
