package q;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* loaded from: classes.dex */
public class k {

    /* renamed from: m, reason: collision with root package name */
    public static Object[] f9273m;
    public static int n;

    /* renamed from: o, reason: collision with root package name */
    public static Object[] f9274o;

    /* renamed from: p, reason: collision with root package name */
    public static int f9275p;

    /* renamed from: j, reason: collision with root package name */
    public int[] f9276j;

    /* renamed from: k, reason: collision with root package name */
    public Object[] f9277k;

    /* renamed from: l, reason: collision with root package name */
    public int f9278l;

    public k() {
        this.f9276j = d.f9251a;
        this.f9277k = d.f9252b;
        this.f9278l = 0;
    }

    public static void c(int[] iArr, Object[] objArr, int i5) {
        if (iArr.length == 8) {
            synchronized (k.class) {
                try {
                    if (f9275p < 10) {
                        objArr[0] = f9274o;
                        objArr[1] = iArr;
                        for (int i6 = (i5 << 1) - 1; i6 >= 2; i6--) {
                            objArr[i6] = null;
                        }
                        f9274o = objArr;
                        f9275p++;
                    }
                } finally {
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (k.class) {
                try {
                    if (n < 10) {
                        objArr[0] = f9273m;
                        objArr[1] = iArr;
                        for (int i7 = (i5 << 1) - 1; i7 >= 2; i7--) {
                            objArr[i7] = null;
                        }
                        f9273m = objArr;
                        n++;
                    }
                } finally {
                }
            }
        }
    }

    public final void a(int i5) {
        if (i5 == 8) {
            synchronized (k.class) {
                try {
                    Object[] objArr = f9274o;
                    if (objArr != null) {
                        this.f9277k = objArr;
                        f9274o = (Object[]) objArr[0];
                        this.f9276j = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        f9275p--;
                        return;
                    }
                } finally {
                }
            }
        } else if (i5 == 4) {
            synchronized (k.class) {
                try {
                    Object[] objArr2 = f9273m;
                    if (objArr2 != null) {
                        this.f9277k = objArr2;
                        f9273m = (Object[]) objArr2[0];
                        this.f9276j = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        n--;
                        return;
                    }
                } finally {
                }
            }
        }
        this.f9276j = new int[i5];
        this.f9277k = new Object[i5 << 1];
    }

    public final void b(int i5) {
        int i6 = this.f9278l;
        int[] iArr = this.f9276j;
        if (iArr.length < i5) {
            Object[] objArr = this.f9277k;
            a(i5);
            if (this.f9278l > 0) {
                System.arraycopy(iArr, 0, this.f9276j, 0, i6);
                System.arraycopy(objArr, 0, this.f9277k, 0, i6 << 1);
            }
            c(iArr, objArr, i6);
        }
        if (this.f9278l != i6) {
            throw new ConcurrentModificationException();
        }
    }

    public final void clear() {
        int i5 = this.f9278l;
        if (i5 > 0) {
            int[] iArr = this.f9276j;
            Object[] objArr = this.f9277k;
            this.f9276j = d.f9251a;
            this.f9277k = d.f9252b;
            this.f9278l = 0;
            c(iArr, objArr, i5);
        }
        if (this.f9278l > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public final boolean containsKey(Object obj) {
        return e(obj) >= 0;
    }

    public final boolean containsValue(Object obj) {
        return g(obj) >= 0;
    }

    public final int d(int i5, Object obj) {
        int i6 = this.f9278l;
        if (i6 == 0) {
            return -1;
        }
        try {
            int iA = d.a(i6, i5, this.f9276j);
            if (iA < 0 || obj.equals(this.f9277k[iA << 1])) {
                return iA;
            }
            int i7 = iA + 1;
            while (i7 < i6 && this.f9276j[i7] == i5) {
                if (obj.equals(this.f9277k[i7 << 1])) {
                    return i7;
                }
                i7++;
            }
            for (int i8 = iA - 1; i8 >= 0 && this.f9276j[i8] == i5; i8--) {
                if (obj.equals(this.f9277k[i8 << 1])) {
                    return i8;
                }
            }
            return ~i7;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public final int e(Object obj) {
        return obj == null ? f() : d(obj.hashCode(), obj);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof k) {
            k kVar = (k) obj;
            if (this.f9278l != kVar.f9278l) {
                return false;
            }
            for (int i5 = 0; i5 < this.f9278l; i5++) {
                try {
                    Object objH = h(i5);
                    Object objJ = j(i5);
                    Object orDefault = kVar.getOrDefault(objH, null);
                    if (objJ == null) {
                        if (orDefault != null || !kVar.containsKey(objH)) {
                            return false;
                        }
                    } else if (!objJ.equals(orDefault)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (this.f9278l != map.size()) {
                return false;
            }
            for (int i6 = 0; i6 < this.f9278l; i6++) {
                try {
                    Object objH2 = h(i6);
                    Object objJ2 = j(i6);
                    Object obj2 = map.get(objH2);
                    if (objJ2 == null) {
                        if (obj2 != null || !map.containsKey(objH2)) {
                            return false;
                        }
                    } else if (!objJ2.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public final int f() {
        int i5 = this.f9278l;
        if (i5 == 0) {
            return -1;
        }
        try {
            int iA = d.a(i5, 0, this.f9276j);
            if (iA < 0 || this.f9277k[iA << 1] == null) {
                return iA;
            }
            int i6 = iA + 1;
            while (i6 < i5 && this.f9276j[i6] == 0) {
                if (this.f9277k[i6 << 1] == null) {
                    return i6;
                }
                i6++;
            }
            for (int i7 = iA - 1; i7 >= 0 && this.f9276j[i7] == 0; i7--) {
                if (this.f9277k[i7 << 1] == null) {
                    return i7;
                }
            }
            return ~i6;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public final int g(Object obj) {
        int i5 = this.f9278l * 2;
        Object[] objArr = this.f9277k;
        if (obj == null) {
            for (int i6 = 1; i6 < i5; i6 += 2) {
                if (objArr[i6] == null) {
                    return i6 >> 1;
                }
            }
            return -1;
        }
        for (int i7 = 1; i7 < i5; i7 += 2) {
            if (obj.equals(objArr[i7])) {
                return i7 >> 1;
            }
        }
        return -1;
    }

    public final Object get(Object obj) {
        return getOrDefault(obj, null);
    }

    public final Object getOrDefault(Object obj, Object obj2) {
        int iE = e(obj);
        return iE >= 0 ? this.f9277k[(iE << 1) + 1] : obj2;
    }

    public final Object h(int i5) {
        return this.f9277k[i5 << 1];
    }

    public final int hashCode() {
        int[] iArr = this.f9276j;
        Object[] objArr = this.f9277k;
        int i5 = this.f9278l;
        int i6 = 1;
        int i7 = 0;
        int iHashCode = 0;
        while (i7 < i5) {
            Object obj = objArr[i6];
            iHashCode += (obj == null ? 0 : obj.hashCode()) ^ iArr[i7];
            i7++;
            i6 += 2;
        }
        return iHashCode;
    }

    public final Object i(int i5) {
        Object[] objArr = this.f9277k;
        int i6 = i5 << 1;
        Object obj = objArr[i6 + 1];
        int i7 = this.f9278l;
        int i8 = 0;
        if (i7 <= 1) {
            c(this.f9276j, objArr, i7);
            this.f9276j = d.f9251a;
            this.f9277k = d.f9252b;
        } else {
            int i9 = i7 - 1;
            int[] iArr = this.f9276j;
            if (iArr.length <= 8 || i7 >= iArr.length / 3) {
                if (i5 < i9) {
                    int i10 = i5 + 1;
                    int i11 = i9 - i5;
                    System.arraycopy(iArr, i10, iArr, i5, i11);
                    Object[] objArr2 = this.f9277k;
                    System.arraycopy(objArr2, i10 << 1, objArr2, i6, i11 << 1);
                }
                Object[] objArr3 = this.f9277k;
                int i12 = i9 << 1;
                objArr3[i12] = null;
                objArr3[i12 + 1] = null;
            } else {
                a(i7 > 8 ? i7 + (i7 >> 1) : 8);
                if (i7 != this.f9278l) {
                    throw new ConcurrentModificationException();
                }
                if (i5 > 0) {
                    System.arraycopy(iArr, 0, this.f9276j, 0, i5);
                    System.arraycopy(objArr, 0, this.f9277k, 0, i6);
                }
                if (i5 < i9) {
                    int i13 = i5 + 1;
                    int i14 = i9 - i5;
                    System.arraycopy(iArr, i13, this.f9276j, i5, i14);
                    System.arraycopy(objArr, i13 << 1, this.f9277k, i6, i14 << 1);
                }
            }
            i8 = i9;
        }
        if (i7 != this.f9278l) {
            throw new ConcurrentModificationException();
        }
        this.f9278l = i8;
        return obj;
    }

    public final boolean isEmpty() {
        return this.f9278l <= 0;
    }

    public final Object j(int i5) {
        return this.f9277k[(i5 << 1) + 1];
    }

    public final Object put(Object obj, Object obj2) {
        int i5;
        int iD;
        int i6 = this.f9278l;
        if (obj == null) {
            iD = f();
            i5 = 0;
        } else {
            int iHashCode = obj.hashCode();
            i5 = iHashCode;
            iD = d(iHashCode, obj);
        }
        if (iD >= 0) {
            int i7 = (iD << 1) + 1;
            Object[] objArr = this.f9277k;
            Object obj3 = objArr[i7];
            objArr[i7] = obj2;
            return obj3;
        }
        int i8 = ~iD;
        int[] iArr = this.f9276j;
        if (i6 >= iArr.length) {
            int i9 = 8;
            if (i6 >= 8) {
                i9 = (i6 >> 1) + i6;
            } else if (i6 < 4) {
                i9 = 4;
            }
            Object[] objArr2 = this.f9277k;
            a(i9);
            if (i6 != this.f9278l) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.f9276j;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.f9277k, 0, objArr2.length);
            }
            c(iArr, objArr2, i6);
        }
        if (i8 < i6) {
            int[] iArr3 = this.f9276j;
            int i10 = i8 + 1;
            System.arraycopy(iArr3, i8, iArr3, i10, i6 - i8);
            Object[] objArr3 = this.f9277k;
            System.arraycopy(objArr3, i8 << 1, objArr3, i10 << 1, (this.f9278l - i8) << 1);
        }
        int i11 = this.f9278l;
        if (i6 == i11) {
            int[] iArr4 = this.f9276j;
            if (i8 < iArr4.length) {
                iArr4[i8] = i5;
                Object[] objArr4 = this.f9277k;
                int i12 = i8 << 1;
                objArr4[i12] = obj;
                objArr4[i12 + 1] = obj2;
                this.f9278l = i11 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public final Object putIfAbsent(Object obj, Object obj2) {
        Object orDefault = getOrDefault(obj, null);
        return orDefault == null ? put(obj, obj2) : orDefault;
    }

    public final Object remove(Object obj) {
        int iE = e(obj);
        if (iE >= 0) {
            return i(iE);
        }
        return null;
    }

    public final Object replace(Object obj, Object obj2) {
        int iE = e(obj);
        if (iE < 0) {
            return null;
        }
        int i5 = (iE << 1) + 1;
        Object[] objArr = this.f9277k;
        Object obj3 = objArr[i5];
        objArr[i5] = obj2;
        return obj3;
    }

    public final int size() {
        return this.f9278l;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f9278l * 28);
        sb.append('{');
        for (int i5 = 0; i5 < this.f9278l; i5++) {
            if (i5 > 0) {
                sb.append(", ");
            }
            Object objH = h(i5);
            if (objH != this) {
                sb.append(objH);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object objJ = j(i5);
            if (objJ != this) {
                sb.append(objJ);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public final boolean remove(Object obj, Object obj2) {
        int iE = e(obj);
        if (iE < 0) {
            return false;
        }
        Object objJ = j(iE);
        if (obj2 != objJ && (obj2 == null || !obj2.equals(objJ))) {
            return false;
        }
        i(iE);
        return true;
    }

    public final boolean replace(Object obj, Object obj2, Object obj3) {
        int iE = e(obj);
        if (iE < 0) {
            return false;
        }
        Object objJ = j(iE);
        if (objJ != obj2 && (obj2 == null || !obj2.equals(objJ))) {
            return false;
        }
        int i5 = (iE << 1) + 1;
        Object[] objArr = this.f9277k;
        Object obj4 = objArr[i5];
        objArr[i5] = obj3;
        return true;
    }

    public k(int i5) {
        if (i5 == 0) {
            this.f9276j = d.f9251a;
            this.f9277k = d.f9252b;
        } else {
            a(i5);
        }
        this.f9278l = 0;
    }
}
