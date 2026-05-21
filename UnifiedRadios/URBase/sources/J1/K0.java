package J1;

import android.os.Bundle;
import java.util.EnumMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class K0 {

    /* renamed from: c, reason: collision with root package name */
    public static final K0 f878c = new K0(100);

    /* renamed from: a, reason: collision with root package name */
    public final EnumMap f879a;

    /* renamed from: b, reason: collision with root package name */
    public final int f880b;

    public K0(int i5) {
        EnumMap enumMap = new EnumMap(J0.class);
        this.f879a = enumMap;
        J0 j02 = J0.AD_STORAGE;
        H0 h02 = H0.UNINITIALIZED;
        enumMap.put((EnumMap) j02, (J0) h02);
        enumMap.put((EnumMap) J0.ANALYTICS_STORAGE, (J0) h02);
        this.f880b = i5;
    }

    public static char a(H0 h02) {
        if (h02 == null) {
            return '-';
        }
        int iOrdinal = h02.ordinal();
        if (iOrdinal == 1) {
            return '+';
        }
        if (iOrdinal != 2) {
            return iOrdinal != 3 ? '-' : '1';
        }
        return '0';
    }

    public static H0 b(String str) {
        H0 h02 = H0.UNINITIALIZED;
        return str == null ? h02 : str.equals("granted") ? H0.GRANTED : str.equals("denied") ? H0.DENIED : h02;
    }

    public static H0 c(char c2) {
        return c2 != '+' ? c2 != '0' ? c2 != '1' ? H0.UNINITIALIZED : H0.GRANTED : H0.DENIED : H0.POLICY;
    }

    public static K0 d(int i5, Bundle bundle) {
        if (bundle == null) {
            return new K0(i5);
        }
        EnumMap enumMap = new EnumMap(J0.class);
        for (J0 j02 : I0.STORAGE.f868j) {
            enumMap.put((EnumMap) j02, (J0) b(bundle.getString(j02.f876j)));
        }
        return new K0(enumMap, i5);
    }

    public static K0 e(int i5, String str) {
        EnumMap enumMap = new EnumMap(J0.class);
        I0 i02 = I0.STORAGE;
        int i6 = 0;
        while (true) {
            J0[] j0Arr = i02.f868j;
            if (i6 >= j0Arr.length) {
                return new K0(enumMap, i5);
            }
            String str2 = str == null ? "" : str;
            J0 j02 = j0Arr[i6];
            int i7 = i6 + 2;
            if (i7 < str2.length()) {
                enumMap.put((EnumMap) j02, (J0) c(str2.charAt(i7)));
            } else {
                enumMap.put((EnumMap) j02, (J0) H0.UNINITIALIZED);
            }
            i6++;
        }
    }

    public static String h(int i5) {
        return i5 != -30 ? i5 != -20 ? i5 != -10 ? i5 != 0 ? i5 != 30 ? i5 != 90 ? i5 != 100 ? "OTHER" : "UNKNOWN" : "REMOTE_CONFIG" : "1P_INIT" : "1P_API" : "MANIFEST" : "API" : "TCF";
    }

    public static boolean l(int i5, int i6) {
        int i7 = -30;
        if (i5 == -20) {
            if (i6 == -30) {
                return true;
            }
            i5 = -20;
        }
        if (i5 != -30) {
            i7 = i5;
        } else if (i6 == -20) {
            return true;
        }
        return i7 == i6 || i5 < i6;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof K0)) {
            return false;
        }
        K0 k02 = (K0) obj;
        for (J0 j02 : I0.STORAGE.f868j) {
            if (this.f879a.get(j02) != k02.f879a.get(j02)) {
                return false;
            }
        }
        return this.f880b == k02.f880b;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final J1.K0 f(J1.K0 r9) {
        /*
            r8 = this;
            java.util.EnumMap r0 = new java.util.EnumMap
            java.lang.Class<J1.J0> r1 = J1.J0.class
            r0.<init>(r1)
            J1.I0 r1 = J1.I0.STORAGE
            J1.J0[] r1 = r1.f868j
            int r2 = r1.length
            r3 = 0
        Ld:
            if (r3 >= r2) goto L48
            r4 = r1[r3]
            java.util.EnumMap r5 = r8.f879a
            java.lang.Object r5 = r5.get(r4)
            J1.H0 r5 = (J1.H0) r5
            java.util.EnumMap r6 = r9.f879a
            java.lang.Object r6 = r6.get(r4)
            J1.H0 r6 = (J1.H0) r6
            if (r5 != 0) goto L24
            goto L31
        L24:
            if (r6 == 0) goto L40
            J1.H0 r7 = J1.H0.UNINITIALIZED
            if (r5 != r7) goto L2b
            goto L31
        L2b:
            if (r6 == r7) goto L40
            J1.H0 r7 = J1.H0.POLICY
            if (r5 != r7) goto L33
        L31:
            r5 = r6
            goto L40
        L33:
            if (r6 == r7) goto L40
            J1.H0 r7 = J1.H0.DENIED
            if (r5 == r7) goto L3f
            if (r6 != r7) goto L3c
            goto L3f
        L3c:
            J1.H0 r5 = J1.H0.GRANTED
            goto L40
        L3f:
            r5 = r7
        L40:
            if (r5 == 0) goto L45
            r0.put(r4, r5)
        L45:
            int r3 = r3 + 1
            goto Ld
        L48:
            J1.K0 r9 = new J1.K0
            r1 = 100
            r9.<init>(r0, r1)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.K0.f(J1.K0):J1.K0");
    }

    public final K0 g(K0 k02) {
        EnumMap enumMap = new EnumMap(J0.class);
        for (J0 j02 : I0.STORAGE.f868j) {
            H0 h02 = (H0) this.f879a.get(j02);
            if (h02 == H0.UNINITIALIZED) {
                h02 = (H0) k02.f879a.get(j02);
            }
            if (h02 != null) {
                enumMap.put((EnumMap) j02, (J0) h02);
            }
        }
        return new K0(enumMap, this.f880b);
    }

    public final int hashCode() {
        Iterator it = this.f879a.values().iterator();
        int iHashCode = this.f880b * 17;
        while (it.hasNext()) {
            iHashCode = (iHashCode * 31) + ((H0) it.next()).hashCode();
        }
        return iHashCode;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String i() {
        /*
            r7 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "G1"
            r0.<init>(r1)
            J1.I0 r1 = J1.I0.STORAGE
            J1.J0[] r1 = r1.f868j
            int r2 = r1.length
            r3 = 0
        Ld:
            if (r3 >= r2) goto L38
            r4 = r1[r3]
            java.util.EnumMap r5 = r7.f879a
            java.lang.Object r4 = r5.get(r4)
            J1.H0 r4 = (J1.H0) r4
            r5 = 45
            if (r4 == 0) goto L32
            int r4 = r4.ordinal()
            if (r4 == 0) goto L32
            r6 = 1
            if (r4 == r6) goto L30
            r6 = 2
            if (r4 == r6) goto L2d
            r6 = 3
            if (r4 == r6) goto L30
            goto L32
        L2d:
            r5 = 48
            goto L32
        L30:
            r5 = 49
        L32:
            r0.append(r5)
            int r3 = r3 + 1
            goto Ld
        L38:
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.K0.i():java.lang.String");
    }

    public final String j() {
        StringBuilder sb = new StringBuilder("G1");
        for (J0 j02 : I0.STORAGE.f868j) {
            sb.append(a((H0) this.f879a.get(j02)));
        }
        return sb.toString();
    }

    public final boolean k(J0 j02) {
        return ((H0) this.f879a.get(j02)) != H0.DENIED;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("source=");
        sb.append(h(this.f880b));
        for (J0 j02 : I0.STORAGE.f868j) {
            sb.append(",");
            sb.append(j02.f876j);
            sb.append("=");
            H0 h02 = (H0) this.f879a.get(j02);
            if (h02 == null) {
                h02 = H0.UNINITIALIZED;
            }
            sb.append(h02);
        }
        return sb.toString();
    }

    public K0(EnumMap enumMap, int i5) {
        EnumMap enumMap2 = new EnumMap(J0.class);
        this.f879a = enumMap2;
        enumMap2.putAll(enumMap);
        this.f880b = i5;
    }
}
