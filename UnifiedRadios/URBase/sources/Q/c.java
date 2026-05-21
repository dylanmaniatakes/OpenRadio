package q;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public final class c implements Collection, Set {
    public static final int[] n = new int[0];

    /* renamed from: o, reason: collision with root package name */
    public static final Object[] f9242o = new Object[0];

    /* renamed from: p, reason: collision with root package name */
    public static Object[] f9243p;

    /* renamed from: q, reason: collision with root package name */
    public static int f9244q;

    /* renamed from: r, reason: collision with root package name */
    public static Object[] f9245r;

    /* renamed from: s, reason: collision with root package name */
    public static int f9246s;

    /* renamed from: j, reason: collision with root package name */
    public int[] f9247j;

    /* renamed from: k, reason: collision with root package name */
    public Object[] f9248k;

    /* renamed from: l, reason: collision with root package name */
    public int f9249l;

    /* renamed from: m, reason: collision with root package name */
    public C0837a f9250m;

    public c(int i5) {
        if (i5 == 0) {
            this.f9247j = n;
            this.f9248k = f9242o;
        } else {
            a(i5);
        }
        this.f9249l = 0;
    }

    public static void b(int[] iArr, Object[] objArr, int i5) {
        if (iArr.length == 8) {
            synchronized (c.class) {
                try {
                    if (f9246s < 10) {
                        objArr[0] = f9245r;
                        objArr[1] = iArr;
                        for (int i6 = i5 - 1; i6 >= 2; i6--) {
                            objArr[i6] = null;
                        }
                        f9245r = objArr;
                        f9246s++;
                    }
                } finally {
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (c.class) {
                try {
                    if (f9244q < 10) {
                        objArr[0] = f9243p;
                        objArr[1] = iArr;
                        for (int i7 = i5 - 1; i7 >= 2; i7--) {
                            objArr[i7] = null;
                        }
                        f9243p = objArr;
                        f9244q++;
                    }
                } finally {
                }
            }
        }
    }

    public final void a(int i5) {
        if (i5 == 8) {
            synchronized (c.class) {
                try {
                    Object[] objArr = f9245r;
                    if (objArr != null) {
                        this.f9248k = objArr;
                        f9245r = (Object[]) objArr[0];
                        this.f9247j = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        f9246s--;
                        return;
                    }
                } finally {
                }
            }
        } else if (i5 == 4) {
            synchronized (c.class) {
                try {
                    Object[] objArr2 = f9243p;
                    if (objArr2 != null) {
                        this.f9248k = objArr2;
                        f9243p = (Object[]) objArr2[0];
                        this.f9247j = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        f9244q--;
                        return;
                    }
                } finally {
                }
            }
        }
        this.f9247j = new int[i5];
        this.f9248k = new Object[i5];
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        int i5;
        int iD;
        if (obj == null) {
            iD = e();
            i5 = 0;
        } else {
            int iHashCode = obj.hashCode();
            i5 = iHashCode;
            iD = d(iHashCode, obj);
        }
        if (iD >= 0) {
            return false;
        }
        int i6 = ~iD;
        int i7 = this.f9249l;
        int[] iArr = this.f9247j;
        if (i7 >= iArr.length) {
            int i8 = 8;
            if (i7 >= 8) {
                i8 = (i7 >> 1) + i7;
            } else if (i7 < 4) {
                i8 = 4;
            }
            Object[] objArr = this.f9248k;
            a(i8);
            int[] iArr2 = this.f9247j;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f9248k, 0, objArr.length);
            }
            b(iArr, objArr, this.f9249l);
        }
        int i9 = this.f9249l;
        if (i6 < i9) {
            int[] iArr3 = this.f9247j;
            int i10 = i6 + 1;
            System.arraycopy(iArr3, i6, iArr3, i10, i9 - i6);
            Object[] objArr2 = this.f9248k;
            System.arraycopy(objArr2, i6, objArr2, i10, this.f9249l - i6);
        }
        this.f9247j[i6] = i5;
        this.f9248k[i6] = obj;
        this.f9249l++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        int size = collection.size() + this.f9249l;
        int[] iArr = this.f9247j;
        boolean zAdd = false;
        if (iArr.length < size) {
            Object[] objArr = this.f9248k;
            a(size);
            int i5 = this.f9249l;
            if (i5 > 0) {
                System.arraycopy(iArr, 0, this.f9247j, 0, i5);
                System.arraycopy(objArr, 0, this.f9248k, 0, this.f9249l);
            }
            b(iArr, objArr, this.f9249l);
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    @Override // java.util.Collection, java.util.Set
    public final void clear() {
        int i5 = this.f9249l;
        if (i5 != 0) {
            b(this.f9247j, this.f9248k, i5);
            this.f9247j = n;
            this.f9248k = f9242o;
            this.f9249l = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final int d(int i5, Object obj) {
        int i6 = this.f9249l;
        if (i6 == 0) {
            return -1;
        }
        int iA = d.a(i6, i5, this.f9247j);
        if (iA < 0 || obj.equals(this.f9248k[iA])) {
            return iA;
        }
        int i7 = iA + 1;
        while (i7 < i6 && this.f9247j[i7] == i5) {
            if (obj.equals(this.f9248k[i7])) {
                return i7;
            }
            i7++;
        }
        for (int i8 = iA - 1; i8 >= 0 && this.f9247j[i8] == i5; i8--) {
            if (obj.equals(this.f9248k[i8])) {
                return i8;
            }
        }
        return ~i7;
    }

    public final int e() {
        int i5 = this.f9249l;
        if (i5 == 0) {
            return -1;
        }
        int iA = d.a(i5, 0, this.f9247j);
        if (iA < 0 || this.f9248k[iA] == null) {
            return iA;
        }
        int i6 = iA + 1;
        while (i6 < i5 && this.f9247j[i6] == 0) {
            if (this.f9248k[i6] == null) {
                return i6;
            }
            i6++;
        }
        for (int i7 = iA - 1; i7 >= 0 && this.f9247j[i7] == 0; i7--) {
            if (this.f9248k[i7] == null) {
                return i7;
            }
        }
        return ~i6;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (this.f9249l != set.size()) {
                return false;
            }
            for (int i5 = 0; i5 < this.f9249l; i5++) {
                try {
                    if (!set.contains(this.f9248k[i5])) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public final void f(int i5) {
        Object[] objArr = this.f9248k;
        Object obj = objArr[i5];
        int i6 = this.f9249l;
        if (i6 <= 1) {
            b(this.f9247j, objArr, i6);
            this.f9247j = n;
            this.f9248k = f9242o;
            this.f9249l = 0;
            return;
        }
        int[] iArr = this.f9247j;
        if (iArr.length <= 8 || i6 >= iArr.length / 3) {
            int i7 = i6 - 1;
            this.f9249l = i7;
            if (i5 < i7) {
                int i8 = i5 + 1;
                System.arraycopy(iArr, i8, iArr, i5, i7 - i5);
                Object[] objArr2 = this.f9248k;
                System.arraycopy(objArr2, i8, objArr2, i5, this.f9249l - i5);
            }
            this.f9248k[this.f9249l] = null;
            return;
        }
        a(i6 > 8 ? i6 + (i6 >> 1) : 8);
        this.f9249l--;
        if (i5 > 0) {
            System.arraycopy(iArr, 0, this.f9247j, 0, i5);
            System.arraycopy(objArr, 0, this.f9248k, 0, i5);
        }
        int i9 = this.f9249l;
        if (i5 < i9) {
            int i10 = i5 + 1;
            System.arraycopy(iArr, i10, this.f9247j, i5, i9 - i5);
            System.arraycopy(objArr, i10, this.f9248k, i5, this.f9249l - i5);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        int[] iArr = this.f9247j;
        int i5 = this.f9249l;
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            i6 += iArr[i7];
        }
        return i6;
    }

    public final int indexOf(Object obj) {
        return obj == null ? e() : d(obj.hashCode(), obj);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.f9249l <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        if (this.f9250m == null) {
            this.f9250m = new C0837a(1, this);
        }
        C0837a c0837a = this.f9250m;
        if (((h) c0837a.f8383b) == null) {
            c0837a.f8383b = new h(c0837a, 1);
        }
        return ((h) c0837a.f8383b).iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf < 0) {
            return false;
        }
        f(iIndexOf);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        Iterator it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        boolean z4 = false;
        for (int i5 = this.f9249l - 1; i5 >= 0; i5--) {
            if (!collection.contains(this.f9248k[i5])) {
                f(i5);
                z4 = true;
            }
        }
        return z4;
    }

    @Override // java.util.Collection, java.util.Set
    public final int size() {
        return this.f9249l;
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        int i5 = this.f9249l;
        Object[] objArr = new Object[i5];
        System.arraycopy(this.f9248k, 0, objArr, 0, i5);
        return objArr;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f9249l * 14);
        sb.append('{');
        for (int i5 = 0; i5 < this.f9249l; i5++) {
            if (i5 > 0) {
                sb.append(", ");
            }
            Object obj = this.f9248k[i5];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] objArr) {
        if (objArr.length < this.f9249l) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), this.f9249l);
        }
        System.arraycopy(this.f9248k, 0, objArr, 0, this.f9249l);
        int length = objArr.length;
        int i5 = this.f9249l;
        if (length > i5) {
            objArr[i5] = null;
        }
        return objArr;
    }
}
