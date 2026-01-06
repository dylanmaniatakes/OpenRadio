package u3;

import F3.i;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* renamed from: u3.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0914e implements Map, Serializable, G3.a {

    /* renamed from: v, reason: collision with root package name */
    public static final C0914e f9948v;

    /* renamed from: j, reason: collision with root package name */
    public Object[] f9949j;

    /* renamed from: k, reason: collision with root package name */
    public Object[] f9950k;

    /* renamed from: l, reason: collision with root package name */
    public int[] f9951l;

    /* renamed from: m, reason: collision with root package name */
    public int[] f9952m;
    public int n;

    /* renamed from: o, reason: collision with root package name */
    public int f9953o;

    /* renamed from: p, reason: collision with root package name */
    public int f9954p;

    /* renamed from: q, reason: collision with root package name */
    public int f9955q;

    /* renamed from: r, reason: collision with root package name */
    public C0915f f9956r;

    /* renamed from: s, reason: collision with root package name */
    public C0916g f9957s;

    /* renamed from: t, reason: collision with root package name */
    public C0915f f9958t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f9959u;

    static {
        C0914e c0914e = new C0914e(0);
        c0914e.f9959u = true;
        f9948v = c0914e;
    }

    public C0914e() {
        this(8);
    }

    public final int a(Object obj) {
        c();
        while (true) {
            int i5 = i(obj);
            int i6 = this.n * 2;
            int length = this.f9952m.length / 2;
            if (i6 > length) {
                i6 = length;
            }
            int i7 = 0;
            while (true) {
                int[] iArr = this.f9952m;
                int i8 = iArr[i5];
                if (i8 <= 0) {
                    int i9 = this.f9953o;
                    Object[] objArr = this.f9949j;
                    if (i9 < objArr.length) {
                        int i10 = i9 + 1;
                        this.f9953o = i10;
                        objArr[i9] = obj;
                        this.f9951l[i9] = i5;
                        iArr[i5] = i10;
                        this.f9955q++;
                        if (i7 > this.n) {
                            this.n = i7;
                        }
                        return i9;
                    }
                    f(1);
                } else {
                    if (i.a(this.f9949j[i8 - 1], obj)) {
                        return -i8;
                    }
                    i7++;
                    if (i7 > i6) {
                        j(this.f9952m.length * 2);
                        break;
                    }
                    i5 = i5 == 0 ? this.f9952m.length - 1 : i5 - 1;
                }
            }
        }
    }

    public final C0914e b() {
        c();
        this.f9959u = true;
        if (this.f9955q > 0) {
            return this;
        }
        C0914e c0914e = f9948v;
        i.d(c0914e, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.builders.MapBuilder, V of kotlin.collections.builders.MapBuilder>");
        return c0914e;
    }

    public final void c() {
        if (this.f9959u) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Map
    public final void clear() {
        int i5;
        c();
        boolean z4 = true;
        J3.c cVar = new J3.c(0, this.f9953o - 1, 1);
        int i6 = cVar.f1476k;
        int i7 = cVar.f1477l;
        if (i7 <= 0 ? i6 > 0 : i6 < 0) {
            z4 = false;
        }
        int i8 = z4 ? 0 : i6;
        while (z4) {
            if (i8 != i6) {
                i5 = i8 + i7;
            } else {
                if (!z4) {
                    throw new NoSuchElementException();
                }
                z4 = false;
                i5 = i8;
            }
            int[] iArr = this.f9951l;
            int i9 = iArr[i8];
            if (i9 >= 0) {
                this.f9952m[i9] = 0;
                iArr[i8] = -1;
            }
            i8 = i5;
        }
        h4.d.n(this.f9949j, 0, this.f9953o);
        Object[] objArr = this.f9950k;
        if (objArr != null) {
            h4.d.n(objArr, 0, this.f9953o);
        }
        this.f9955q = 0;
        this.f9953o = 0;
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return g(obj) >= 0;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return h(obj) >= 0;
    }

    public final boolean d(Collection collection) {
        i.f(collection, "m");
        for (Object obj : collection) {
            if (obj != null) {
                try {
                    if (!e((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    public final boolean e(Map.Entry entry) {
        i.f(entry, "entry");
        int iG = g(entry.getKey());
        if (iG < 0) {
            return false;
        }
        Object[] objArr = this.f9950k;
        i.c(objArr);
        return i.a(objArr[iG], entry.getValue());
    }

    @Override // java.util.Map
    public final Set entrySet() {
        C0915f c0915f = this.f9958t;
        if (c0915f != null) {
            return c0915f;
        }
        C0915f c0915f2 = new C0915f(this, 0);
        this.f9958t = c0915f2;
        return c0915f2;
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof Map) {
                Map map = (Map) obj;
                if (this.f9955q != map.size() || !d(map.entrySet())) {
                }
            }
            return false;
        }
        return true;
    }

    public final void f(int i5) {
        Object[] objArrCopyOf;
        Object[] objArr = this.f9949j;
        int length = objArr.length;
        int i6 = this.f9953o;
        int i7 = length - i6;
        int i8 = i6 - this.f9955q;
        if (i7 < i5 && i7 + i8 >= i5 && i8 >= objArr.length / 4) {
            j(this.f9952m.length);
            return;
        }
        int i9 = i6 + i5;
        if (i9 < 0) {
            throw new OutOfMemoryError();
        }
        if (i9 > objArr.length) {
            int length2 = (objArr.length * 3) / 2;
            if (i9 <= length2) {
                i9 = length2;
            }
            Object[] objArrCopyOf2 = Arrays.copyOf(objArr, i9);
            i.e(objArrCopyOf2, "copyOf(this, newSize)");
            this.f9949j = objArrCopyOf2;
            Object[] objArr2 = this.f9950k;
            if (objArr2 != null) {
                objArrCopyOf = Arrays.copyOf(objArr2, i9);
                i.e(objArrCopyOf, "copyOf(this, newSize)");
            } else {
                objArrCopyOf = null;
            }
            this.f9950k = objArrCopyOf;
            int[] iArrCopyOf = Arrays.copyOf(this.f9951l, i9);
            i.e(iArrCopyOf, "copyOf(this, newSize)");
            this.f9951l = iArrCopyOf;
            if (i9 < 1) {
                i9 = 1;
            }
            int iHighestOneBit = Integer.highestOneBit(i9 * 3);
            if (iHighestOneBit > this.f9952m.length) {
                j(iHighestOneBit);
            }
        }
    }

    public final int g(Object obj) {
        int i5 = i(obj);
        int i6 = this.n;
        while (true) {
            int i7 = this.f9952m[i5];
            if (i7 == 0) {
                return -1;
            }
            if (i7 > 0) {
                int i8 = i7 - 1;
                if (i.a(this.f9949j[i8], obj)) {
                    return i8;
                }
            }
            i6--;
            if (i6 < 0) {
                return -1;
            }
            i5 = i5 == 0 ? this.f9952m.length - 1 : i5 - 1;
        }
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        int iG = g(obj);
        if (iG < 0) {
            return null;
        }
        Object[] objArr = this.f9950k;
        i.c(objArr);
        return objArr[iG];
    }

    public final int h(Object obj) {
        int i5 = this.f9953o;
        while (true) {
            i5--;
            if (i5 < 0) {
                return -1;
            }
            if (this.f9951l[i5] >= 0) {
                Object[] objArr = this.f9950k;
                i.c(objArr);
                if (i.a(objArr[i5], obj)) {
                    return i5;
                }
            }
        }
    }

    @Override // java.util.Map
    public final int hashCode() {
        C0912c c0912c = new C0912c(this, 0);
        int i5 = 0;
        while (c0912c.hasNext()) {
            int i6 = c0912c.f9943k;
            C0914e c0914e = c0912c.f9942j;
            if (i6 >= c0914e.f9953o) {
                throw new NoSuchElementException();
            }
            c0912c.f9943k = i6 + 1;
            c0912c.f9944l = i6;
            Object obj = c0914e.f9949j[i6];
            int iHashCode = obj != null ? obj.hashCode() : 0;
            Object[] objArr = c0914e.f9950k;
            i.c(objArr);
            Object obj2 = objArr[c0912c.f9944l];
            int iHashCode2 = obj2 != null ? obj2.hashCode() : 0;
            c0912c.a();
            i5 += iHashCode ^ iHashCode2;
        }
        return i5;
    }

    public final int i(Object obj) {
        return ((obj != null ? obj.hashCode() : 0) * (-1640531527)) >>> this.f9954p;
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.f9955q == 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0060, code lost:
    
        r3[r0] = r7;
        r6.f9951l[r2] = r0;
        r2 = r7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j(int r7) {
        /*
            r6 = this;
            int r0 = r6.f9953o
            int r1 = r6.f9955q
            r2 = 0
            if (r0 <= r1) goto L34
            java.lang.Object[] r0 = r6.f9950k
            r1 = r2
            r3 = r1
        Lb:
            int r4 = r6.f9953o
            if (r1 >= r4) goto L26
            int[] r4 = r6.f9951l
            r4 = r4[r1]
            if (r4 < 0) goto L23
            java.lang.Object[] r4 = r6.f9949j
            r5 = r4[r1]
            r4[r3] = r5
            if (r0 == 0) goto L21
            r4 = r0[r1]
            r0[r3] = r4
        L21:
            int r3 = r3 + 1
        L23:
            int r1 = r1 + 1
            goto Lb
        L26:
            java.lang.Object[] r1 = r6.f9949j
            h4.d.n(r1, r3, r4)
            if (r0 == 0) goto L32
            int r1 = r6.f9953o
            h4.d.n(r0, r3, r1)
        L32:
            r6.f9953o = r3
        L34:
            int[] r0 = r6.f9952m
            int r1 = r0.length
            if (r7 == r1) goto L46
            int[] r0 = new int[r7]
            r6.f9952m = r0
            int r7 = java.lang.Integer.numberOfLeadingZeros(r7)
            int r7 = r7 + 1
            r6.f9954p = r7
            goto L4a
        L46:
            int r7 = r0.length
            java.util.Arrays.fill(r0, r2, r7, r2)
        L4a:
            int r7 = r6.f9953o
            if (r2 >= r7) goto L7e
            int r7 = r2 + 1
            java.lang.Object[] r0 = r6.f9949j
            r0 = r0[r2]
            int r0 = r6.i(r0)
            int r1 = r6.n
        L5a:
            int[] r3 = r6.f9952m
            r4 = r3[r0]
            if (r4 != 0) goto L68
            r3[r0] = r7
            int[] r1 = r6.f9951l
            r1[r2] = r0
            r2 = r7
            goto L4a
        L68:
            int r1 = r1 + (-1)
            if (r1 < 0) goto L76
            int r4 = r0 + (-1)
            if (r0 != 0) goto L74
            int r0 = r3.length
            int r0 = r0 + (-1)
            goto L5a
        L74:
            r0 = r4
            goto L5a
        L76:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?"
            r7.<init>(r0)
            throw r7
        L7e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: u3.C0914e.j(int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0062 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[LOOP:0: B:6:0x001e->B:30:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(int r12) {
        /*
            r11 = this;
            java.lang.Object[] r0 = r11.f9949j
            java.lang.String r1 = "<this>"
            F3.i.f(r0, r1)
            r1 = 0
            r0[r12] = r1
            int[] r0 = r11.f9951l
            r0 = r0[r12]
            int r1 = r11.n
            int r1 = r1 * 2
            int[] r2 = r11.f9952m
            int r2 = r2.length
            int r2 = r2 / 2
            if (r1 <= r2) goto L1a
            r1 = r2
        L1a:
            r2 = 0
            r3 = r1
            r4 = r2
            r1 = r0
        L1e:
            int r5 = r0 + (-1)
            if (r0 != 0) goto L28
            int[] r0 = r11.f9952m
            int r0 = r0.length
            int r0 = r0 + (-1)
            goto L29
        L28:
            r0 = r5
        L29:
            int r4 = r4 + 1
            int r5 = r11.n
            r6 = -1
            if (r4 <= r5) goto L35
            int[] r0 = r11.f9952m
            r0[r1] = r2
            goto L66
        L35:
            int[] r5 = r11.f9952m
            r7 = r5[r0]
            if (r7 != 0) goto L3e
            r5[r1] = r2
            goto L66
        L3e:
            if (r7 >= 0) goto L45
            r5[r1] = r6
        L42:
            r1 = r0
            r4 = r2
            goto L5f
        L45:
            java.lang.Object[] r5 = r11.f9949j
            int r8 = r7 + (-1)
            r5 = r5[r8]
            int r5 = r11.i(r5)
            int r5 = r5 - r0
            int[] r9 = r11.f9952m
            int r10 = r9.length
            int r10 = r10 + (-1)
            r5 = r5 & r10
            if (r5 < r4) goto L5f
            r9[r1] = r7
            int[] r4 = r11.f9951l
            r4[r8] = r1
            goto L42
        L5f:
            int r3 = r3 + r6
            if (r3 >= 0) goto L1e
            int[] r0 = r11.f9952m
            r0[r1] = r6
        L66:
            int[] r0 = r11.f9951l
            r0[r12] = r6
            int r12 = r11.f9955q
            int r12 = r12 + r6
            r11.f9955q = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: u3.C0914e.k(int):void");
    }

    @Override // java.util.Map
    public final Set keySet() {
        C0915f c0915f = this.f9956r;
        if (c0915f != null) {
            return c0915f;
        }
        C0915f c0915f2 = new C0915f(this, 1);
        this.f9956r = c0915f2;
        return c0915f2;
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        c();
        int iA = a(obj);
        Object[] objArr = this.f9950k;
        if (objArr == null) {
            int length = this.f9949j.length;
            if (length < 0) {
                throw new IllegalArgumentException("capacity must be non-negative.".toString());
            }
            objArr = new Object[length];
            this.f9950k = objArr;
        }
        if (iA >= 0) {
            objArr[iA] = obj2;
            return null;
        }
        int i5 = (-iA) - 1;
        Object obj3 = objArr[i5];
        objArr[i5] = obj2;
        return obj3;
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        i.f(map, "from");
        c();
        Set<Map.Entry> setEntrySet = map.entrySet();
        if (setEntrySet.isEmpty()) {
            return;
        }
        f(setEntrySet.size());
        for (Map.Entry entry : setEntrySet) {
            int iA = a(entry.getKey());
            Object[] objArr = this.f9950k;
            if (objArr == null) {
                int length = this.f9949j.length;
                if (length < 0) {
                    throw new IllegalArgumentException("capacity must be non-negative.".toString());
                }
                objArr = new Object[length];
                this.f9950k = objArr;
            }
            if (iA >= 0) {
                objArr[iA] = entry.getValue();
            } else {
                int i5 = (-iA) - 1;
                if (!i.a(entry.getValue(), objArr[i5])) {
                    objArr[i5] = entry.getValue();
                }
            }
        }
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        c();
        int iG = g(obj);
        if (iG < 0) {
            iG = -1;
        } else {
            k(iG);
        }
        if (iG < 0) {
            return null;
        }
        Object[] objArr = this.f9950k;
        i.c(objArr);
        Object obj2 = objArr[iG];
        objArr[iG] = null;
        return obj2;
    }

    @Override // java.util.Map
    public final int size() {
        return this.f9955q;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder((this.f9955q * 3) + 2);
        sb.append("{");
        C0912c c0912c = new C0912c(this, 0);
        int i5 = 0;
        while (c0912c.hasNext()) {
            if (i5 > 0) {
                sb.append(", ");
            }
            int i6 = c0912c.f9943k;
            C0914e c0914e = c0912c.f9942j;
            if (i6 >= c0914e.f9953o) {
                throw new NoSuchElementException();
            }
            c0912c.f9943k = i6 + 1;
            c0912c.f9944l = i6;
            Object obj = c0914e.f9949j[i6];
            if (i.a(obj, c0914e)) {
                sb.append("(this Map)");
            } else {
                sb.append(obj);
            }
            sb.append('=');
            Object[] objArr = c0914e.f9950k;
            i.c(objArr);
            Object obj2 = objArr[c0912c.f9944l];
            if (i.a(obj2, c0914e)) {
                sb.append("(this Map)");
            } else {
                sb.append(obj2);
            }
            c0912c.a();
            i5++;
        }
        sb.append("}");
        String string = sb.toString();
        i.e(string, "sb.toString()");
        return string;
    }

    @Override // java.util.Map
    public final Collection values() {
        C0916g c0916g = this.f9957s;
        if (c0916g != null) {
            return c0916g;
        }
        C0916g c0916g2 = new C0916g(this);
        this.f9957s = c0916g2;
        return c0916g2;
    }

    public C0914e(int i5) {
        if (i5 < 0) {
            throw new IllegalArgumentException("capacity must be non-negative.".toString());
        }
        Object[] objArr = new Object[i5];
        int[] iArr = new int[i5];
        int iHighestOneBit = Integer.highestOneBit((i5 < 1 ? 1 : i5) * 3);
        this.f9949j = objArr;
        this.f9950k = null;
        this.f9951l = iArr;
        this.f9952m = new int[iHighestOneBit];
        this.n = 2;
        this.f9953o = 0;
        this.f9954p = Integer.numberOfLeadingZeros(iHighestOneBit) + 1;
    }
}
