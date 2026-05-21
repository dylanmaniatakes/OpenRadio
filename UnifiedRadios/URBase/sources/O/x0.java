package O;

/* loaded from: classes.dex */
public abstract class x0 {

    /* renamed from: a, reason: collision with root package name */
    public final F0 f1977a;

    /* renamed from: b, reason: collision with root package name */
    public E.c[] f1978b;

    public x0() {
        this(new F0());
    }

    public final void a() {
        E.c[] cVarArr = this.f1978b;
        if (cVarArr != null) {
            E.c cVarF = cVarArr[0];
            E.c cVarF2 = cVarArr[1];
            F0 f02 = this.f1977a;
            if (cVarF2 == null) {
                cVarF2 = f02.f1894a.f(2);
            }
            if (cVarF == null) {
                cVarF = f02.f1894a.f(1);
            }
            g(E.c.a(cVarF, cVarF2));
            E.c cVar = this.f1978b[4];
            if (cVar != null) {
                f(cVar);
            }
            E.c cVar2 = this.f1978b[5];
            if (cVar2 != null) {
                d(cVar2);
            }
            E.c cVar3 = this.f1978b[6];
            if (cVar3 != null) {
                h(cVar3);
            }
        }
    }

    public abstract F0 b();

    public void c(int i5, E.c cVar) {
        char c2;
        if (this.f1978b == null) {
            this.f1978b = new E.c[9];
        }
        for (int i6 = 1; i6 <= 256; i6 <<= 1) {
            if ((i5 & i6) != 0) {
                E.c[] cVarArr = this.f1978b;
                if (i6 != 1) {
                    c2 = 2;
                    if (i6 == 2) {
                        c2 = 1;
                    } else if (i6 != 4) {
                        c2 = '\b';
                        if (i6 == 8) {
                            c2 = 3;
                        } else if (i6 == 16) {
                            c2 = 4;
                        } else if (i6 == 32) {
                            c2 = 5;
                        } else if (i6 == 64) {
                            c2 = 6;
                        } else if (i6 == 128) {
                            c2 = 7;
                        } else if (i6 != 256) {
                            throw new IllegalArgumentException(com.unified.ur1.SatelliteTracker.h.a(i6, "type needs to be >= FIRST and <= LAST, type="));
                        }
                    }
                } else {
                    c2 = 0;
                }
                cVarArr[c2] = cVar;
            }
        }
    }

    public void d(E.c cVar) {
    }

    public abstract void e(E.c cVar);

    public void f(E.c cVar) {
    }

    public abstract void g(E.c cVar);

    public void h(E.c cVar) {
    }

    public x0(F0 f02) {
        this.f1977a = f02;
    }
}
