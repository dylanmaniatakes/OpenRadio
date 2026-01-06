package M3;

/* loaded from: classes.dex */
public abstract class l extends k {
    public static Integer p(String str) {
        boolean z4;
        int i5;
        int i6;
        h4.c.b(10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i7 = 0;
        char cCharAt = str.charAt(0);
        int i8 = -2147483647;
        if (F3.i.h(cCharAt, 48) < 0) {
            i5 = 1;
            if (length == 1) {
                return null;
            }
            if (cCharAt == '-') {
                i8 = Integer.MIN_VALUE;
                z4 = true;
            } else {
                if (cCharAt != '+') {
                    return null;
                }
                z4 = false;
            }
        } else {
            z4 = false;
            i5 = 0;
        }
        int i9 = -59652323;
        while (i5 < length) {
            int iDigit = Character.digit((int) str.charAt(i5), 10);
            if (iDigit < 0) {
                return null;
            }
            if ((i7 < i9 && (i9 != -59652323 || i7 < (i9 = i8 / 10))) || (i6 = i7 * 10) < i8 + iDigit) {
                return null;
            }
            i7 = i6 - iDigit;
            i5++;
        }
        return z4 ? Integer.valueOf(i7) : Integer.valueOf(-i7);
    }
}
