package m3;

/* renamed from: m3.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0766b {

    /* renamed from: a, reason: collision with root package name */
    public int f8577a;

    /* renamed from: b, reason: collision with root package name */
    public int f8578b;

    /* renamed from: c, reason: collision with root package name */
    public int f8579c;

    /* renamed from: d, reason: collision with root package name */
    public int f8580d;

    /* renamed from: e, reason: collision with root package name */
    public int f8581e;

    /* renamed from: f, reason: collision with root package name */
    public int f8582f;
    public int g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public int f8583i;

    /* renamed from: j, reason: collision with root package name */
    public int f8584j;

    /* renamed from: k, reason: collision with root package name */
    public int f8585k;

    /* renamed from: l, reason: collision with root package name */
    public String f8586l;

    /* renamed from: m, reason: collision with root package name */
    public int f8587m;
    public int n;

    /* renamed from: o, reason: collision with root package name */
    public int f8588o;

    /* renamed from: p, reason: collision with root package name */
    public int f8589p;

    /* renamed from: q, reason: collision with root package name */
    public int[] f8590q;

    public static String a(int i5) {
        byte[] bArr = {(byte) (i5 & 255), (byte) ((i5 >> 8) & 255), (byte) ((i5 >> 16) & 255), (byte) ((i5 >> 24) & 255)};
        StringBuilder sb = new StringBuilder();
        for (int i6 = 0; i6 < 4; i6++) {
            sb.append(String.format("%02X", Integer.valueOf(bArr[i6] & 255)));
        }
        return sb.toString();
    }

    public static String b(int i5) {
        byte[] bArr = {(byte) (i5 & 255), (byte) ((i5 >> 8) & 255), (byte) ((i5 >> 16) & 255), (byte) ((i5 >> 24) & 255)};
        StringBuilder sb = new StringBuilder();
        for (int i6 = 0; i6 < 4; i6++) {
            sb.append(String.format("%02X", Integer.valueOf(bArr[i6] & 255)));
        }
        return sb.toString();
    }

    public static String c(int i5) {
        return String.format("%02X", Integer.valueOf(i5 & 255));
    }
}
