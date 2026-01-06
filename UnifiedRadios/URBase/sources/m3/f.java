package M3;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class f extends h4.d {
    public static String o(String str) {
        F3.i.f(str, "<this>");
        if (!(!m.s("|"))) {
            throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
        }
        List listG = e.G(str);
        int length = str.length();
        listG.size();
        int iX = t3.j.x(listG);
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        for (Object obj : listG) {
            int i6 = i5 + 1;
            String strSubstring = null;
            if (i5 < 0) {
                t3.j.z();
                throw null;
            }
            String str2 = (String) obj;
            if ((i5 != 0 && i5 != iX) || !m.s(str2)) {
                int length2 = str2.length();
                int i7 = 0;
                while (true) {
                    if (i7 >= length2) {
                        i7 = -1;
                        break;
                    }
                    if (!h4.c.H(str2.charAt(i7))) {
                        break;
                    }
                    i7++;
                }
                if (i7 != -1 && m.w(str2, "|", i7, false)) {
                    strSubstring = str2.substring(i7 + 1);
                    F3.i.e(strSubstring, "this as java.lang.String).substring(startIndex)");
                }
                if (strSubstring == null) {
                    strSubstring = str2;
                }
            }
            if (strSubstring != null) {
                arrayList.add(strSubstring);
            }
            i5 = i6;
        }
        StringBuilder sb = new StringBuilder(length);
        t3.i.C(arrayList, sb, "\n", "", "", -1, "...", null);
        String string = sb.toString();
        F3.i.e(string, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return string;
    }
}
