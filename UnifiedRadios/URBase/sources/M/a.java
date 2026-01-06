package M;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: e, reason: collision with root package name */
    public static final byte[] f1640e = new byte[1792];

    /* renamed from: a, reason: collision with root package name */
    public final CharSequence f1641a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1642b;

    /* renamed from: c, reason: collision with root package name */
    public int f1643c;

    /* renamed from: d, reason: collision with root package name */
    public char f1644d;

    static {
        for (int i5 = 0; i5 < 1792; i5++) {
            f1640e[i5] = Character.getDirectionality(i5);
        }
    }

    public a(CharSequence charSequence) {
        this.f1641a = charSequence;
        this.f1642b = charSequence.length();
    }

    public final byte a() {
        int i5 = this.f1643c - 1;
        CharSequence charSequence = this.f1641a;
        char cCharAt = charSequence.charAt(i5);
        this.f1644d = cCharAt;
        if (Character.isLowSurrogate(cCharAt)) {
            int iCodePointBefore = Character.codePointBefore(charSequence, this.f1643c);
            this.f1643c -= Character.charCount(iCodePointBefore);
            return Character.getDirectionality(iCodePointBefore);
        }
        this.f1643c--;
        char c2 = this.f1644d;
        return c2 < 1792 ? f1640e[c2] : Character.getDirectionality(c2);
    }
}
