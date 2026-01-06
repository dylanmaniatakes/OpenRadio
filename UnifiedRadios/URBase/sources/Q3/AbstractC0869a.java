package q3;

import com.unified.ur1.SatelliteTracker.h;

/* renamed from: q3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0869a {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f9481a = "0123456789ABCDEF".toCharArray();

    public static String a(int i5, int i6) {
        String hexString = Integer.toHexString(i5);
        if (hexString.length() < i6) {
            int length = i6 - hexString.length();
            for (int i7 = 0; i7 < length; i7++) {
                hexString = h.s("0", hexString);
            }
        }
        return hexString.length() > i6 ? hexString.substring(hexString.length() - i6) : hexString;
    }

    public static String b(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i5 = 0; i5 < bArr.length; i5++) {
            byte b5 = bArr[i5];
            int i6 = i5 * 2;
            char[] cArr2 = f9481a;
            cArr[i6] = cArr2[(b5 & 255) >>> 4];
            cArr[i6 + 1] = cArr2[b5 & 15];
        }
        return new String(cArr);
    }

    public static byte[] c(String str) {
        if (str.length() % 2 != 0) {
            d3.a.b("Text: ".concat(str), new Object[0]);
            throw new IllegalArgumentException("Hex string length must be even");
        }
        if (!str.matches("^[0-9a-fA-F]+$")) {
            d3.a.b("Text: ".concat(str), new Object[0]);
            throw new IllegalArgumentException("Hex string must contain only [0-9a-fA-F]");
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i5 = 0; i5 < length; i5++) {
            int i6 = i5 * 2;
            bArr[i5] = Integer.valueOf(str.substring(i6, i6 + 2), 16).byteValue();
        }
        return bArr;
    }

    public static String d(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b5 : bArr) {
            String hexString = Integer.toHexString(b5 & 255);
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString);
        }
        return sb.toString().toUpperCase();
    }

    public static byte[] e(int i5) {
        return new byte[]{(byte) ((i5 >> 24) & 255), (byte) ((i5 >> 16) & 255), (byte) ((i5 >> 8) & 255), (byte) (i5 & 255)};
    }
}
