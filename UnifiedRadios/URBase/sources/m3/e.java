package M3;

import com.google.android.gms.internal.measurement.AbstractC0296a2;
import g0.AbstractC0535a;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public abstract class e extends m {
    public static final int A(CharSequence charSequence) {
        F3.i.f(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int B(CharSequence charSequence, String str, int i5, boolean z4) {
        F3.i.f(charSequence, "<this>");
        F3.i.f(str, "string");
        if (!z4 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(str, i5);
        }
        int length = charSequence.length();
        if (i5 < 0) {
            i5 = 0;
        }
        int length2 = charSequence.length();
        if (length > length2) {
            length = length2;
        }
        J3.c cVar = new J3.c(i5, length, 1);
        boolean z5 = charSequence instanceof String;
        int i6 = cVar.f1477l;
        int i7 = cVar.f1476k;
        int i8 = cVar.f1475j;
        if (!z5 || !(str instanceof String)) {
            if ((i6 > 0 && i8 <= i7) || (i6 < 0 && i7 <= i8)) {
                while (!H(str, 0, charSequence, i8, str.length(), z4)) {
                    if (i8 != i7) {
                        i8 += i6;
                    }
                }
                return i8;
            }
            return -1;
        }
        if ((i6 > 0 && i8 <= i7) || (i6 < 0 && i7 <= i8)) {
            while (!m.t(0, i8, str.length(), str, (String) charSequence, z4)) {
                if (i8 != i7) {
                    i8 += i6;
                }
            }
            return i8;
        }
        return -1;
    }

    public static int C(CharSequence charSequence, char c2, int i5, boolean z4, int i6) {
        if ((i6 & 2) != 0) {
            i5 = 0;
        }
        if ((i6 & 4) != 0) {
            z4 = false;
        }
        F3.i.f(charSequence, "<this>");
        return (z4 || !(charSequence instanceof String)) ? E(charSequence, new char[]{c2}, i5, z4) : ((String) charSequence).indexOf(c2, i5);
    }

    public static /* synthetic */ int D(CharSequence charSequence, String str, int i5, boolean z4, int i6) {
        if ((i6 & 2) != 0) {
            i5 = 0;
        }
        if ((i6 & 4) != 0) {
            z4 = false;
        }
        return B(charSequence, str, i5, z4);
    }

    public static final int E(CharSequence charSequence, char[] cArr, int i5, boolean z4) {
        int i6;
        F3.i.f(charSequence, "<this>");
        F3.i.f(cArr, "chars");
        boolean z5 = true;
        if (!z4 && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(t3.h.x(cArr), i5);
        }
        if (i5 < 0) {
            i5 = 0;
        }
        J3.c cVar = new J3.c(i5, A(charSequence), 1);
        int i7 = cVar.f1476k;
        int i8 = cVar.f1477l;
        if (i8 <= 0 ? i5 < i7 : i5 > i7) {
            z5 = false;
        }
        if (!z5) {
            i5 = i7;
        }
        while (z5) {
            if (i5 != i7) {
                i6 = i5 + i8;
            } else {
                if (!z5) {
                    throw new NoSuchElementException();
                }
                i6 = i5;
                z5 = false;
            }
            char cCharAt = charSequence.charAt(i5);
            for (char c2 : cArr) {
                if (h4.c.f(c2, cCharAt, z4)) {
                    return i5;
                }
            }
            i5 = i6;
        }
        return -1;
    }

    public static int F(CharSequence charSequence, char c2, int i5, int i6) {
        if ((i6 & 2) != 0) {
            i5 = A(charSequence);
        }
        F3.i.f(charSequence, "<this>");
        if (charSequence instanceof String) {
            return ((String) charSequence).lastIndexOf(c2, i5);
        }
        char[] cArr = {c2};
        if (charSequence instanceof String) {
            return ((String) charSequence).lastIndexOf(t3.h.x(cArr), i5);
        }
        int iA = A(charSequence);
        if (i5 > iA) {
            i5 = iA;
        }
        while (-1 < i5) {
            if (h4.c.f(cArr[0], charSequence.charAt(i5), false)) {
                return i5;
            }
            i5--;
        }
        return -1;
    }

    public static final List G(CharSequence charSequence) {
        F3.i.f(charSequence, "<this>");
        J(0);
        return L3.e.x(new L3.j(new c(charSequence, 0, 0, new n(t3.h.r(new String[]{"\r\n", "\n", "\r"}), false, 1)), new C0.m(1, charSequence)));
    }

    public static final boolean H(CharSequence charSequence, int i5, CharSequence charSequence2, int i6, int i7, boolean z4) {
        F3.i.f(charSequence, "<this>");
        F3.i.f(charSequence2, "other");
        if (i6 < 0 || i5 < 0 || i5 > charSequence.length() - i7 || i6 > charSequence2.length() - i7) {
            return false;
        }
        for (int i8 = 0; i8 < i7; i8++) {
            if (!h4.c.f(charSequence.charAt(i5 + i8), charSequence2.charAt(i6 + i8), z4)) {
                return false;
            }
        }
        return true;
    }

    public static String I(String str, String str2) {
        F3.i.f(str, "<this>");
        if (!L(str, str2)) {
            return str;
        }
        String strSubstring = str.substring(str2.length());
        F3.i.e(strSubstring, "this as java.lang.String).substring(startIndex)");
        return strSubstring;
    }

    public static final void J(int i5) {
        if (i5 < 0) {
            throw new IllegalArgumentException(com.unified.ur1.SatelliteTracker.h.a(i5, "Limit must be non-negative, but was ").toString());
        }
    }

    public static List K(CharSequence charSequence, char[] cArr) {
        F3.i.f(charSequence, "<this>");
        boolean z4 = false;
        if (cArr.length != 1) {
            J(0);
            c<J3.c> cVar = new c(charSequence, 0, 0, new n(cArr, z4, 0));
            ArrayList arrayList = new ArrayList(t3.k.A(new L3.h(cVar)));
            for (J3.c cVar2 : cVar) {
                F3.i.f(cVar2, "range");
                arrayList.add(charSequence.subSequence(cVar2.f1475j, cVar2.f1476k + 1).toString());
            }
            return arrayList;
        }
        String strValueOf = String.valueOf(cArr[0]);
        J(0);
        int iB = B(charSequence, strValueOf, 0, false);
        if (iB == -1) {
            return AbstractC0296a2.i(charSequence.toString());
        }
        ArrayList arrayList2 = new ArrayList(10);
        int length = 0;
        do {
            arrayList2.add(charSequence.subSequence(length, iB).toString());
            length = strValueOf.length() + iB;
            iB = B(charSequence, strValueOf, length, false);
        } while (iB != -1);
        arrayList2.add(charSequence.subSequence(length, charSequence.length()).toString());
        return arrayList2;
    }

    public static boolean L(CharSequence charSequence, String str) {
        F3.i.f(charSequence, "<this>");
        return charSequence instanceof String ? m.x((String) charSequence, str, false) : H(charSequence, 0, str, 0, str.length(), false);
    }

    public static String M(String str, String str2) {
        F3.i.f(str2, "delimiter");
        int iD = D(str, str2, 0, false, 6);
        if (iD == -1) {
            return str;
        }
        String strSubstring = str.substring(str2.length() + iD, str.length());
        F3.i.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static String N(String str) {
        F3.i.f(str, "<this>");
        F3.i.f(str, "missingDelimiterValue");
        int iF = F(str, '.', 0, 6);
        if (iF == -1) {
            return str;
        }
        String strSubstring = str.substring(iF + 1, str.length());
        F3.i.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static String O(int i5, String str) {
        F3.i.f(str, "<this>");
        if (i5 < 0) {
            throw new IllegalArgumentException(AbstractC0535a.j("Requested character count ", i5, " is less than zero.").toString());
        }
        int length = str.length();
        if (i5 > length) {
            i5 = length;
        }
        String strSubstring = str.substring(0, i5);
        F3.i.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static CharSequence P(CharSequence charSequence) {
        F3.i.f(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i5 = 0;
        boolean z4 = false;
        while (i5 <= length) {
            boolean zH = h4.c.H(charSequence.charAt(!z4 ? i5 : length));
            if (z4) {
                if (!zH) {
                    break;
                }
                length--;
            } else if (zH) {
                i5++;
            } else {
                z4 = true;
            }
        }
        return charSequence.subSequence(i5, length + 1);
    }

    public static boolean y(CharSequence charSequence, char c2) {
        F3.i.f(charSequence, "<this>");
        return C(charSequence, c2, 0, false, 2) >= 0;
    }

    public static boolean z(CharSequence charSequence, String str) {
        F3.i.f(charSequence, "<this>");
        return D(charSequence, str, 0, false, 2) >= 0;
    }
}
