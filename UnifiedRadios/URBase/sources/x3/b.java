package X3;

import F3.i;
import W3.C;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f2864a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static final int a(char c2) {
        if ('0' <= c2 && c2 < ':') {
            return c2 - '0';
        }
        if ('a' <= c2 && c2 < 'g') {
            return c2 - 'W';
        }
        if ('A' <= c2 && c2 < 'G') {
            return c2 - '7';
        }
        throw new IllegalArgumentException("Unexpected hex digit: " + c2);
    }

    public static final int b(C c2, int i5) {
        int i6;
        i.f(c2, "<this>");
        int i7 = i5 + 1;
        int length = c2.n.length;
        int[] iArr = c2.f2626o;
        i.f(iArr, "<this>");
        int i8 = length - 1;
        int i9 = 0;
        while (true) {
            if (i9 <= i8) {
                i6 = (i9 + i8) >>> 1;
                int i10 = iArr[i6];
                if (i10 >= i7) {
                    if (i10 <= i7) {
                        break;
                    }
                    i8 = i6 - 1;
                } else {
                    i9 = i6 + 1;
                }
            } else {
                i6 = (-i9) - 1;
                break;
            }
        }
        return i6 >= 0 ? i6 : ~i6;
    }
}
