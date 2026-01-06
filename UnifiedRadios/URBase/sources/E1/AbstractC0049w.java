package E1;

import java.util.Arrays;
import java.util.Set;

/* renamed from: E1.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0049w extends r implements Set {

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f480l = 0;

    /* renamed from: k, reason: collision with root package name */
    public transient AbstractC0047u f481k;

    public static int f(int i5) {
        int iMax = Math.max(i5, 2);
        if (iMax >= 751619276) {
            if (iMax < 1073741824) {
                return 1073741824;
            }
            throw new IllegalArgumentException("collection too large");
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1);
        do {
            iHighestOneBit += iHighestOneBit;
        } while (iHighestOneBit * 0.7d < iMax);
        return iHighestOneBit;
    }

    public static AbstractC0049w g(int i5, Object... objArr) {
        if (i5 == 0) {
            return z.f487s;
        }
        if (i5 == 1) {
            Object obj = objArr[0];
            obj.getClass();
            return new A(obj);
        }
        int iF = f(i5);
        Object[] objArr2 = new Object[iF];
        int i6 = iF - 1;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < i5; i9++) {
            Object obj2 = objArr[i9];
            if (obj2 == null) {
                throw new NullPointerException(com.unified.ur1.SatelliteTracker.h.a(i9, "at index "));
            }
            int iHashCode = obj2.hashCode();
            int iRotateLeft = (int) (Integer.rotateLeft((int) (iHashCode * (-862048943)), 15) * 461845907);
            while (true) {
                int i10 = iRotateLeft & i6;
                Object obj3 = objArr2[i10];
                if (obj3 == null) {
                    objArr[i8] = obj2;
                    objArr2[i10] = obj2;
                    i7 += iHashCode;
                    i8++;
                    break;
                }
                if (!obj3.equals(obj2)) {
                    iRotateLeft++;
                }
            }
        }
        Arrays.fill(objArr, i8, i5, (Object) null);
        if (i8 == 1) {
            Object obj4 = objArr[0];
            obj4.getClass();
            return new A(obj4);
        }
        if (f(i8) < iF / 2) {
            return g(i8, objArr);
        }
        if (i8 < 4) {
            objArr = Arrays.copyOf(objArr, i8);
        }
        return new z(i7, i6, i8, objArr, objArr2);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof AbstractC0049w) && (this instanceof z)) {
            AbstractC0049w abstractC0049w = (AbstractC0049w) obj;
            abstractC0049w.getClass();
            if ((abstractC0049w instanceof z) && hashCode() != obj.hashCode()) {
                return false;
            }
        }
        if (obj == this) {
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

    @Override // java.util.Collection, java.util.Set
    public abstract int hashCode();
}
