package M3;

import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class m extends l {
    public static boolean q(String str, String str2) {
        F3.i.f(str, "<this>");
        F3.i.f(str2, "suffix");
        return str.endsWith(str2);
    }

    public static boolean r(String str, String str2) {
        return str == null ? str2 == null : str.equalsIgnoreCase(str2);
    }

    public static boolean s(CharSequence charSequence) {
        F3.i.f(charSequence, "<this>");
        if (charSequence.length() == 0) {
            return true;
        }
        Iterable cVar = new J3.c(0, charSequence.length() - 1, 1);
        if ((cVar instanceof Collection) && ((Collection) cVar).isEmpty()) {
            return true;
        }
        Iterator it = cVar.iterator();
        while (it.hasNext()) {
            if (!h4.c.H(charSequence.charAt(((J3.b) it).a()))) {
                return false;
            }
        }
        return true;
    }

    public static final boolean t(int i5, int i6, int i7, String str, String str2, boolean z4) {
        F3.i.f(str, "<this>");
        F3.i.f(str2, "other");
        return !z4 ? str.regionMatches(i5, str2, i6, i7) : str.regionMatches(z4, i5, str2, i6, i7);
    }

    public static String u(String str, char c2, char c5) {
        F3.i.f(str, "<this>");
        String strReplace = str.replace(c2, c5);
        F3.i.e(strReplace, "this as java.lang.String…replace(oldChar, newChar)");
        return strReplace;
    }

    public static String v(String str, String str2, String str3) {
        F3.i.f(str, "<this>");
        int iB = e.B(str, str2, 0, false);
        if (iB < 0) {
            return str;
        }
        int length = str2.length();
        int i5 = length >= 1 ? length : 1;
        int length2 = str3.length() + (str.length() - length);
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb = new StringBuilder(length2);
        int i6 = 0;
        do {
            sb.append((CharSequence) str, i6, iB);
            sb.append(str3);
            i6 = iB + length;
            if (iB >= str.length()) {
                break;
            }
            iB = e.B(str, str2, iB + i5, false);
        } while (iB > 0);
        sb.append((CharSequence) str, i6, str.length());
        String string = sb.toString();
        F3.i.e(string, "stringBuilder.append(this, i, length).toString()");
        return string;
    }

    public static boolean w(String str, String str2, int i5, boolean z4) {
        F3.i.f(str, "<this>");
        return !z4 ? str.startsWith(str2, i5) : t(i5, 0, str2.length(), str, str2, z4);
    }

    public static boolean x(String str, String str2, boolean z4) {
        F3.i.f(str, "<this>");
        F3.i.f(str2, "prefix");
        return !z4 ? str.startsWith(str2) : t(0, 0, str2.length(), str, str2, z4);
    }
}
