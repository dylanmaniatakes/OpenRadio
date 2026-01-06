package W3;

/* loaded from: classes.dex */
public final class A {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f2617a;

    /* renamed from: b, reason: collision with root package name */
    public int f2618b;

    /* renamed from: c, reason: collision with root package name */
    public int f2619c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2620d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f2621e;

    /* renamed from: f, reason: collision with root package name */
    public A f2622f;
    public A g;

    public A() {
        this.f2617a = new byte[8192];
        this.f2621e = true;
        this.f2620d = false;
    }

    public final A a() {
        A a2 = this.f2622f;
        if (a2 == this) {
            a2 = null;
        }
        A a3 = this.g;
        F3.i.c(a3);
        a3.f2622f = this.f2622f;
        A a4 = this.f2622f;
        F3.i.c(a4);
        a4.g = this.g;
        this.f2622f = null;
        this.g = null;
        return a2;
    }

    public final void b(A a2) {
        F3.i.f(a2, "segment");
        a2.g = this;
        a2.f2622f = this.f2622f;
        A a3 = this.f2622f;
        F3.i.c(a3);
        a3.g = a2;
        this.f2622f = a2;
    }

    public final A c() {
        this.f2620d = true;
        return new A(this.f2617a, this.f2618b, this.f2619c, true, false);
    }

    public final void d(A a2, int i5) {
        F3.i.f(a2, "sink");
        if (!a2.f2621e) {
            throw new IllegalStateException("only owner can write".toString());
        }
        int i6 = a2.f2619c;
        int i7 = i6 + i5;
        byte[] bArr = a2.f2617a;
        if (i7 > 8192) {
            if (a2.f2620d) {
                throw new IllegalArgumentException();
            }
            int i8 = a2.f2618b;
            if (i7 - i8 > 8192) {
                throw new IllegalArgumentException();
            }
            t3.h.t(bArr, 0, i8, bArr, i6);
            a2.f2619c -= a2.f2618b;
            a2.f2618b = 0;
        }
        int i9 = a2.f2619c;
        int i10 = this.f2618b;
        t3.h.t(this.f2617a, i9, i10, bArr, i10 + i5);
        a2.f2619c += i5;
        this.f2618b += i5;
    }

    public A(byte[] bArr, int i5, int i6, boolean z4, boolean z5) {
        F3.i.f(bArr, "data");
        this.f2617a = bArr;
        this.f2618b = i5;
        this.f2619c = i6;
        this.f2620d = z4;
        this.f2621e = z5;
    }
}
