package y2;

import com.google.android.gms.internal.measurement.AbstractC0399v1;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class f extends AbstractC0982a implements Set {

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f10497l = 0;

    /* renamed from: k, reason: collision with root package name */
    public transient AbstractC0985d f10498k;

    public static int g(int i5) {
        int iMax = Math.max(i5, 2);
        if (iMax >= 751619276) {
            if (iMax < 1073741824) {
                return 1073741824;
            }
            throw new IllegalArgumentException("collection too large");
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1) << 1;
        while (iHighestOneBit * 0.7d < iMax) {
            iHighestOneBit <<= 1;
        }
        return iHighestOneBit;
    }

    public static f h(int i5, Object... objArr) {
        if (i5 == 0) {
            return n.f10517s;
        }
        if (i5 == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            return new o(obj);
        }
        int iG = g(i5);
        Object[] objArr2 = new Object[iG];
        int i6 = iG - 1;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < i5; i9++) {
            Object obj2 = objArr[i9];
            if (obj2 == null) {
                StringBuilder sb = new StringBuilder(20);
                sb.append("at index ");
                sb.append(i9);
                throw new NullPointerException(sb.toString());
            }
            int iHashCode = obj2.hashCode();
            int i10 = AbstractC0399v1.i(iHashCode);
            while (true) {
                int i11 = i10 & i6;
                Object obj3 = objArr2[i11];
                if (obj3 == null) {
                    objArr[i8] = obj2;
                    objArr2[i11] = obj2;
                    i7 += iHashCode;
                    i8++;
                    break;
                }
                if (obj3.equals(obj2)) {
                    break;
                }
                i10++;
            }
        }
        Arrays.fill(objArr, i8, i5, (Object) null);
        if (i8 == 1) {
            Object obj4 = objArr[0];
            Objects.requireNonNull(obj4);
            return new o(obj4);
        }
        if (g(i8) < iG / 2) {
            return h(i8, objArr);
        }
        int length = objArr.length;
        if (i8 < (length >> 1) + (length >> 2)) {
            objArr = Arrays.copyOf(objArr, i8);
        }
        return new n(i7, i6, i8, objArr, objArr2);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof f) && (this instanceof n)) {
            f fVar = (f) obj;
            fVar.getClass();
            if ((fVar instanceof n) && hashCode() != obj.hashCode()) {
                return false;
            }
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size()) {
                    if (containsAll(set)) {
                        return true;
                    }
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public AbstractC0985d f() {
        AbstractC0985d abstractC0985d = this.f10498k;
        if (abstractC0985d != null) {
            return abstractC0985d;
        }
        AbstractC0985d abstractC0985dI = i();
        this.f10498k = abstractC0985dI;
        return abstractC0985dI;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        Iterator it = iterator();
        int i5 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i5 = ~(~(i5 + (next != null ? next.hashCode() : 0)));
        }
        return i5;
    }

    public AbstractC0985d i() {
        Object[] array = toArray(AbstractC0982a.f10487j);
        C0983b c0983b = AbstractC0985d.f10493k;
        return AbstractC0985d.f(array.length, array);
    }
}
