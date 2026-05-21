package org.conscrypt;

import com.unified.ur1.SatelliteTracker.h;

/* loaded from: classes.dex */
final class Preconditions {
    private Preconditions() {
    }

    private static String badPositionIndex(int i5, int i6, String str) {
        if (i5 < 0) {
            return str + " (" + i5 + ") must not be negative";
        }
        if (i6 < 0) {
            throw new IllegalArgumentException(h.a(i6, "negative size: "));
        }
        return str + " (" + i5 + ") must not be greater than size (" + i6 + ")";
    }

    private static String badPositionIndexes(int i5, int i6, int i7) {
        if (i5 < 0 || i5 > i7) {
            return badPositionIndex(i5, i7, "start index");
        }
        if (i6 < 0 || i6 > i7) {
            return badPositionIndex(i6, i7, "end index");
        }
        return "end index (" + i6 + ") must not be less than start index (" + i5 + ")";
    }

    public static void checkArgument(boolean z4, String str) {
        if (!z4) {
            throw new IllegalArgumentException(str);
        }
    }

    public static <T> T checkNotNull(T t4, String str) {
        if (t4 != null) {
            return t4;
        }
        throw new NullPointerException(str);
    }

    public static void checkPositionIndexes(int i5, int i6, int i7) {
        if (i5 < 0 || i6 < i5 || i6 > i7) {
            throw new IndexOutOfBoundsException(badPositionIndexes(i5, i6, i7));
        }
    }

    public static void checkArgument(boolean z4, String str, Object obj) {
        if (!z4) {
            throw new IllegalArgumentException(String.format(str, obj));
        }
    }
}
