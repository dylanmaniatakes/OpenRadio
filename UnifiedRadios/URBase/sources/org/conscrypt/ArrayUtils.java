package org.conscrypt;

/* loaded from: classes.dex */
final class ArrayUtils {
    private ArrayUtils() {
    }

    public static void checkOffsetAndCount(int i5, int i6, int i7) {
        if ((i6 | i7) < 0 || i6 > i5 || i5 - i6 < i7) {
            throw new ArrayIndexOutOfBoundsException("length=" + i5 + "; regionStart=" + i6 + "; regionLength=" + i7);
        }
    }
}
