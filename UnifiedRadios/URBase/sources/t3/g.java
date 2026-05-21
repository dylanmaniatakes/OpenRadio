package t3;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class g extends d {

    /* renamed from: m, reason: collision with root package name */
    public static final Object[] f9706m = new Object[0];

    /* renamed from: j, reason: collision with root package name */
    public int f9707j;

    /* renamed from: k, reason: collision with root package name */
    public Object[] f9708k = f9706m;

    /* renamed from: l, reason: collision with root package name */
    public int f9709l;

    @Override // t3.d
    public final int a() {
        return this.f9709l;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i5, Object obj) {
        int length;
        int i6 = this.f9709l;
        if (i5 < 0 || i5 > i6) {
            throw new IndexOutOfBoundsException(com.unified.ur1.SatelliteTracker.h.c("index: ", ", size: ", i5, i6));
        }
        if (i5 == i6) {
            d(obj);
            return;
        }
        if (i5 == 0) {
            f(i6 + 1);
            int length2 = this.f9707j;
            if (length2 == 0) {
                Object[] objArr = this.f9708k;
                F3.i.f(objArr, "<this>");
                length2 = objArr.length;
            }
            int i7 = length2 - 1;
            this.f9707j = i7;
            this.f9708k[i7] = obj;
            this.f9709l++;
            return;
        }
        f(i6 + 1);
        int iH = h(this.f9707j + i5);
        int i8 = this.f9709l;
        if (i5 < ((i8 + 1) >> 1)) {
            if (iH == 0) {
                Object[] objArr2 = this.f9708k;
                F3.i.f(objArr2, "<this>");
                length = objArr2.length - 1;
            } else {
                length = iH - 1;
            }
            int length3 = this.f9707j;
            if (length3 == 0) {
                Object[] objArr3 = this.f9708k;
                F3.i.f(objArr3, "<this>");
                length3 = objArr3.length;
            }
            int i9 = length3 - 1;
            int i10 = this.f9707j;
            if (length >= i10) {
                Object[] objArr4 = this.f9708k;
                objArr4[i9] = objArr4[i10];
                h.s(i10, i10 + 1, length + 1, objArr4, objArr4);
            } else {
                Object[] objArr5 = this.f9708k;
                h.s(i10 - 1, i10, objArr5.length, objArr5, objArr5);
                Object[] objArr6 = this.f9708k;
                objArr6[objArr6.length - 1] = objArr6[0];
                h.s(0, 1, length + 1, objArr6, objArr6);
            }
            this.f9708k[length] = obj;
            this.f9707j = i9;
        } else {
            int iH2 = h(i8 + this.f9707j);
            if (iH < iH2) {
                Object[] objArr7 = this.f9708k;
                h.s(iH + 1, iH, iH2, objArr7, objArr7);
            } else {
                Object[] objArr8 = this.f9708k;
                h.s(1, 0, iH2, objArr8, objArr8);
                Object[] objArr9 = this.f9708k;
                objArr9[0] = objArr9[objArr9.length - 1];
                h.s(iH + 1, iH, objArr9.length - 1, objArr9, objArr9);
            }
            this.f9708k[iH] = obj;
        }
        this.f9709l++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i5, Collection collection) {
        F3.i.f(collection, "elements");
        int i6 = this.f9709l;
        if (i5 < 0 || i5 > i6) {
            throw new IndexOutOfBoundsException(com.unified.ur1.SatelliteTracker.h.c("index: ", ", size: ", i5, i6));
        }
        if (collection.isEmpty()) {
            return false;
        }
        int i7 = this.f9709l;
        if (i5 == i7) {
            return addAll(collection);
        }
        f(collection.size() + i7);
        int iH = h(this.f9709l + this.f9707j);
        int iH2 = h(this.f9707j + i5);
        int size = collection.size();
        if (i5 < ((this.f9709l + 1) >> 1)) {
            int i8 = this.f9707j;
            int length = i8 - size;
            if (iH2 < i8) {
                Object[] objArr = this.f9708k;
                h.s(length, i8, objArr.length, objArr, objArr);
                if (size >= iH2) {
                    Object[] objArr2 = this.f9708k;
                    h.s(objArr2.length - size, 0, iH2, objArr2, objArr2);
                } else {
                    Object[] objArr3 = this.f9708k;
                    h.s(objArr3.length - size, 0, size, objArr3, objArr3);
                    Object[] objArr4 = this.f9708k;
                    h.s(0, size, iH2, objArr4, objArr4);
                }
            } else if (length >= 0) {
                Object[] objArr5 = this.f9708k;
                h.s(length, i8, iH2, objArr5, objArr5);
            } else {
                Object[] objArr6 = this.f9708k;
                length += objArr6.length;
                int i9 = iH2 - i8;
                int length2 = objArr6.length - length;
                if (length2 >= i9) {
                    h.s(length, i8, iH2, objArr6, objArr6);
                } else {
                    h.s(length, i8, i8 + length2, objArr6, objArr6);
                    Object[] objArr7 = this.f9708k;
                    h.s(0, this.f9707j + length2, iH2, objArr7, objArr7);
                }
            }
            this.f9707j = length;
            int length3 = iH2 - size;
            if (length3 < 0) {
                length3 += this.f9708k.length;
            }
            e(length3, collection);
        } else {
            int i10 = iH2 + size;
            if (iH2 < iH) {
                int i11 = size + iH;
                Object[] objArr8 = this.f9708k;
                if (i11 <= objArr8.length) {
                    h.s(i10, iH2, iH, objArr8, objArr8);
                } else if (i10 >= objArr8.length) {
                    h.s(i10 - objArr8.length, iH2, iH, objArr8, objArr8);
                } else {
                    int length4 = iH - (i11 - objArr8.length);
                    h.s(0, length4, iH, objArr8, objArr8);
                    Object[] objArr9 = this.f9708k;
                    h.s(i10, iH2, length4, objArr9, objArr9);
                }
            } else {
                Object[] objArr10 = this.f9708k;
                h.s(size, 0, iH, objArr10, objArr10);
                Object[] objArr11 = this.f9708k;
                if (i10 >= objArr11.length) {
                    h.s(i10 - objArr11.length, iH2, objArr11.length, objArr11, objArr11);
                } else {
                    h.s(0, objArr11.length - size, objArr11.length, objArr11, objArr11);
                    Object[] objArr12 = this.f9708k;
                    h.s(i10, iH2, objArr12.length - size, objArr12, objArr12);
                }
            }
            e(iH2, collection);
        }
        return true;
    }

    @Override // t3.d
    public final Object b(int i5) {
        int i6 = this.f9709l;
        if (i5 < 0 || i5 >= i6) {
            throw new IndexOutOfBoundsException(com.unified.ur1.SatelliteTracker.h.c("index: ", ", size: ", i5, i6));
        }
        if (i5 == j.x(this)) {
            if (isEmpty()) {
                throw new NoSuchElementException("ArrayDeque is empty.");
            }
            int iH = h(j.x(this) + this.f9707j);
            Object[] objArr = this.f9708k;
            Object obj = objArr[iH];
            objArr[iH] = null;
            this.f9709l--;
            return obj;
        }
        if (i5 == 0) {
            return i();
        }
        int iH2 = h(this.f9707j + i5);
        Object[] objArr2 = this.f9708k;
        Object obj2 = objArr2[iH2];
        if (i5 < (this.f9709l >> 1)) {
            int i7 = this.f9707j;
            if (iH2 >= i7) {
                h.s(i7 + 1, i7, iH2, objArr2, objArr2);
            } else {
                h.s(1, 0, iH2, objArr2, objArr2);
                Object[] objArr3 = this.f9708k;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i8 = this.f9707j;
                h.s(i8 + 1, i8, objArr3.length - 1, objArr3, objArr3);
            }
            Object[] objArr4 = this.f9708k;
            int i9 = this.f9707j;
            objArr4[i9] = null;
            this.f9707j = g(i9);
        } else {
            int iH3 = h(j.x(this) + this.f9707j);
            if (iH2 <= iH3) {
                Object[] objArr5 = this.f9708k;
                h.s(iH2, iH2 + 1, iH3 + 1, objArr5, objArr5);
            } else {
                Object[] objArr6 = this.f9708k;
                h.s(iH2, iH2 + 1, objArr6.length, objArr6, objArr6);
                Object[] objArr7 = this.f9708k;
                objArr7[objArr7.length - 1] = objArr7[0];
                h.s(0, 1, iH3 + 1, objArr7, objArr7);
            }
            this.f9708k[iH3] = null;
        }
        this.f9709l--;
        return obj2;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        int iH = h(a() + this.f9707j);
        int i5 = this.f9707j;
        if (i5 < iH) {
            h.u(this.f9708k, null, i5, iH);
        } else if (!isEmpty()) {
            Object[] objArr = this.f9708k;
            h.u(objArr, null, this.f9707j, objArr.length);
            h.u(this.f9708k, null, 0, iH);
        }
        this.f9707j = 0;
        this.f9709l = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(Object obj) {
        f(a() + 1);
        this.f9708k[h(a() + this.f9707j)] = obj;
        this.f9709l = a() + 1;
    }

    public final void e(int i5, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.f9708k.length;
        while (i5 < length && it.hasNext()) {
            this.f9708k[i5] = it.next();
            i5++;
        }
        int i6 = this.f9707j;
        for (int i7 = 0; i7 < i6 && it.hasNext(); i7++) {
            this.f9708k[i7] = it.next();
        }
        this.f9709l = collection.size() + a();
    }

    public final void f(int i5) {
        if (i5 < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.f9708k;
        if (i5 <= objArr.length) {
            return;
        }
        if (objArr == f9706m) {
            if (i5 < 10) {
                i5 = 10;
            }
            this.f9708k = new Object[i5];
            return;
        }
        int length = objArr.length;
        int i6 = length + (length >> 1);
        if (i6 - i5 < 0) {
            i6 = i5;
        }
        if (i6 - 2147483639 > 0) {
            i6 = i5 > 2147483639 ? Integer.MAX_VALUE : 2147483639;
        }
        Object[] objArr2 = new Object[i6];
        h.s(0, this.f9707j, objArr.length, objArr, objArr2);
        Object[] objArr3 = this.f9708k;
        int length2 = objArr3.length;
        int i7 = this.f9707j;
        h.s(length2 - i7, 0, i7, objArr3, objArr2);
        this.f9707j = 0;
        this.f9708k = objArr2;
    }

    public final int g(int i5) {
        F3.i.f(this.f9708k, "<this>");
        if (i5 == r0.length - 1) {
            return 0;
        }
        return i5 + 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i5) {
        int iA = a();
        if (i5 < 0 || i5 >= iA) {
            throw new IndexOutOfBoundsException(com.unified.ur1.SatelliteTracker.h.c("index: ", ", size: ", i5, iA));
        }
        return this.f9708k[h(this.f9707j + i5)];
    }

    public final int h(int i5) {
        Object[] objArr = this.f9708k;
        return i5 >= objArr.length ? i5 - objArr.length : i5;
    }

    public final Object i() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        Object[] objArr = this.f9708k;
        int i5 = this.f9707j;
        Object obj = objArr[i5];
        objArr[i5] = null;
        this.f9707j = g(i5);
        this.f9709l = a() - 1;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        int i5;
        int iH = h(a() + this.f9707j);
        int length = this.f9707j;
        if (length < iH) {
            while (length < iH) {
                if (F3.i.a(obj, this.f9708k[length])) {
                    i5 = this.f9707j;
                } else {
                    length++;
                }
            }
            return -1;
        }
        if (length < iH) {
            return -1;
        }
        int length2 = this.f9708k.length;
        while (true) {
            if (length >= length2) {
                for (int i6 = 0; i6 < iH; i6++) {
                    if (F3.i.a(obj, this.f9708k[i6])) {
                        length = i6 + this.f9708k.length;
                        i5 = this.f9707j;
                    }
                }
                return -1;
            }
            if (F3.i.a(obj, this.f9708k[length])) {
                i5 = this.f9707j;
                break;
            }
            length++;
        }
        return length - i5;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return a() == 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        int length;
        int i5;
        int iH = h(this.f9709l + this.f9707j);
        int i6 = this.f9707j;
        if (i6 < iH) {
            length = iH - 1;
            if (i6 <= length) {
                while (!F3.i.a(obj, this.f9708k[length])) {
                    if (length != i6) {
                        length--;
                    }
                }
                i5 = this.f9707j;
                return length - i5;
            }
            return -1;
        }
        if (i6 > iH) {
            int i7 = iH - 1;
            while (true) {
                if (-1 >= i7) {
                    Object[] objArr = this.f9708k;
                    F3.i.f(objArr, "<this>");
                    length = objArr.length - 1;
                    int i8 = this.f9707j;
                    if (i8 <= length) {
                        while (!F3.i.a(obj, this.f9708k[length])) {
                            if (length != i8) {
                                length--;
                            }
                        }
                        i5 = this.f9707j;
                    }
                } else {
                    if (F3.i.a(obj, this.f9708k[i7])) {
                        length = i7 + this.f9708k.length;
                        i5 = this.f9707j;
                        break;
                    }
                    i7--;
                }
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        b(iIndexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        int iH;
        F3.i.f(collection, "elements");
        boolean z4 = false;
        z4 = false;
        z4 = false;
        if (!isEmpty() && this.f9708k.length != 0) {
            int iH2 = h(this.f9709l + this.f9707j);
            int i5 = this.f9707j;
            if (i5 < iH2) {
                iH = i5;
                while (i5 < iH2) {
                    Object obj = this.f9708k[i5];
                    if (!collection.contains(obj)) {
                        this.f9708k[iH] = obj;
                        iH++;
                    } else {
                        z4 = true;
                    }
                    i5++;
                }
                h.u(this.f9708k, null, iH, iH2);
            } else {
                int length = this.f9708k.length;
                boolean z5 = false;
                int i6 = i5;
                while (i5 < length) {
                    Object[] objArr = this.f9708k;
                    Object obj2 = objArr[i5];
                    objArr[i5] = null;
                    if (!collection.contains(obj2)) {
                        this.f9708k[i6] = obj2;
                        i6++;
                    } else {
                        z5 = true;
                    }
                    i5++;
                }
                iH = h(i6);
                for (int i7 = 0; i7 < iH2; i7++) {
                    Object[] objArr2 = this.f9708k;
                    Object obj3 = objArr2[i7];
                    objArr2[i7] = null;
                    if (!collection.contains(obj3)) {
                        this.f9708k[iH] = obj3;
                        iH = g(iH);
                    } else {
                        z5 = true;
                    }
                }
                z4 = z5;
            }
            if (z4) {
                int length2 = iH - this.f9707j;
                if (length2 < 0) {
                    length2 += this.f9708k.length;
                }
                this.f9709l = length2;
            }
        }
        return z4;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        int iH;
        F3.i.f(collection, "elements");
        boolean z4 = false;
        z4 = false;
        z4 = false;
        if (!isEmpty() && this.f9708k.length != 0) {
            int iH2 = h(this.f9709l + this.f9707j);
            int i5 = this.f9707j;
            if (i5 < iH2) {
                iH = i5;
                while (i5 < iH2) {
                    Object obj = this.f9708k[i5];
                    if (collection.contains(obj)) {
                        this.f9708k[iH] = obj;
                        iH++;
                    } else {
                        z4 = true;
                    }
                    i5++;
                }
                h.u(this.f9708k, null, iH, iH2);
            } else {
                int length = this.f9708k.length;
                boolean z5 = false;
                int i6 = i5;
                while (i5 < length) {
                    Object[] objArr = this.f9708k;
                    Object obj2 = objArr[i5];
                    objArr[i5] = null;
                    if (collection.contains(obj2)) {
                        this.f9708k[i6] = obj2;
                        i6++;
                    } else {
                        z5 = true;
                    }
                    i5++;
                }
                iH = h(i6);
                for (int i7 = 0; i7 < iH2; i7++) {
                    Object[] objArr2 = this.f9708k;
                    Object obj3 = objArr2[i7];
                    objArr2[i7] = null;
                    if (collection.contains(obj3)) {
                        this.f9708k[iH] = obj3;
                        iH = g(iH);
                    } else {
                        z5 = true;
                    }
                }
                z4 = z5;
            }
            if (z4) {
                int length2 = iH - this.f9707j;
                if (length2 < 0) {
                    length2 += this.f9708k.length;
                }
                this.f9709l = length2;
            }
        }
        return z4;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i5, Object obj) {
        int iA = a();
        if (i5 < 0 || i5 >= iA) {
            throw new IndexOutOfBoundsException(com.unified.ur1.SatelliteTracker.h.c("index: ", ", size: ", i5, iA));
        }
        int iH = h(this.f9707j + i5);
        Object[] objArr = this.f9708k;
        Object obj2 = objArr[iH];
        objArr[iH] = obj;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return toArray(new Object[a()]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) throws NegativeArraySizeException {
        F3.i.f(objArr, "array");
        int length = objArr.length;
        int i5 = this.f9709l;
        if (length < i5) {
            Object objNewInstance = Array.newInstance(objArr.getClass().getComponentType(), i5);
            F3.i.d(objNewInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
            objArr = (Object[]) objNewInstance;
        }
        int iH = h(this.f9709l + this.f9707j);
        int i6 = this.f9707j;
        if (i6 < iH) {
            h.s(0, i6, iH, this.f9708k, objArr);
        } else if (!isEmpty()) {
            Object[] objArr2 = this.f9708k;
            h.s(0, this.f9707j, objArr2.length, objArr2, objArr);
            Object[] objArr3 = this.f9708k;
            h.s(objArr3.length - this.f9707j, 0, iH, objArr3, objArr);
        }
        int length2 = objArr.length;
        int i7 = this.f9709l;
        if (length2 > i7) {
            objArr[i7] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        d(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        F3.i.f(collection, "elements");
        if (collection.isEmpty()) {
            return false;
        }
        f(collection.size() + a());
        e(h(a() + this.f9707j), collection);
        return true;
    }
}
