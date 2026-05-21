package s;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import f3.C0513e;
import java.util.Arrays;

/* renamed from: s.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0880c {

    /* renamed from: p, reason: collision with root package name */
    public static boolean f9542p = false;

    /* renamed from: q, reason: collision with root package name */
    public static int f9543q = 1000;

    /* renamed from: c, reason: collision with root package name */
    public final C0881d f9546c;

    /* renamed from: f, reason: collision with root package name */
    public C0879b[] f9549f;

    /* renamed from: l, reason: collision with root package name */
    public final C0513e f9553l;

    /* renamed from: o, reason: collision with root package name */
    public C0879b f9555o;

    /* renamed from: a, reason: collision with root package name */
    public boolean f9544a = false;

    /* renamed from: b, reason: collision with root package name */
    public int f9545b = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f9547d = 32;

    /* renamed from: e, reason: collision with root package name */
    public int f9548e = 32;
    public boolean g = false;
    public boolean[] h = new boolean[32];

    /* renamed from: i, reason: collision with root package name */
    public int f9550i = 1;

    /* renamed from: j, reason: collision with root package name */
    public int f9551j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f9552k = 32;

    /* renamed from: m, reason: collision with root package name */
    public C0883f[] f9554m = new C0883f[f9543q];
    public int n = 0;

    public C0880c() {
        this.f9549f = null;
        this.f9549f = new C0879b[32];
        s();
        C0513e c0513e = new C0513e();
        c0513e.f6686c = new N.c();
        c0513e.f6687d = new N.c();
        c0513e.f6688e = new C0883f[32];
        this.f9553l = c0513e;
        C0881d c0881d = new C0881d(c0513e);
        c0881d.f9556f = new C0883f[128];
        c0881d.g = new C0883f[128];
        c0881d.h = 0;
        c0881d.f9557i = new L0.c(24, c0881d);
        this.f9546c = c0881d;
        this.f9555o = new C0879b(c0513e);
    }

    public static int n(Object obj) {
        C0883f c0883f = ((u.c) obj).f9739i;
        if (c0883f != null) {
            return (int) (c0883f.n + 0.5f);
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r4v0 */
    public final C0883f a(int i5) {
        N.c cVar = (N.c) this.f9553l.f6687d;
        int i6 = cVar.f1757b;
        C0883f c0883f = null;
        if (i6 > 0) {
            int i7 = i6 - 1;
            ?? r32 = cVar.f1756a;
            ?? r4 = r32[i7];
            r32[i7] = 0;
            cVar.f1757b = i7;
            c0883f = r4;
        }
        C0883f c0883f2 = c0883f;
        if (c0883f2 == null) {
            c0883f2 = new C0883f(i5);
            c0883f2.f9569u = i5;
        } else {
            c0883f2.c();
            c0883f2.f9569u = i5;
        }
        int i8 = this.n;
        int i9 = f9543q;
        if (i8 >= i9) {
            int i10 = i9 * 2;
            f9543q = i10;
            this.f9554m = (C0883f[]) Arrays.copyOf(this.f9554m, i10);
        }
        C0883f[] c0883fArr = this.f9554m;
        int i11 = this.n;
        this.n = i11 + 1;
        c0883fArr[i11] = c0883f2;
        return c0883f2;
    }

    public final void b(C0883f c0883f, C0883f c0883f2, int i5, float f5, C0883f c0883f3, C0883f c0883f4, int i6, int i7) {
        C0879b c0879bL = l();
        if (c0883f2 == c0883f3) {
            c0879bL.f9540d.j(c0883f, 1.0f);
            c0879bL.f9540d.j(c0883f4, 1.0f);
            c0879bL.f9540d.j(c0883f2, -2.0f);
        } else if (f5 == 0.5f) {
            c0879bL.f9540d.j(c0883f, 1.0f);
            c0879bL.f9540d.j(c0883f2, -1.0f);
            c0879bL.f9540d.j(c0883f3, -1.0f);
            c0879bL.f9540d.j(c0883f4, 1.0f);
            if (i5 > 0 || i6 > 0) {
                c0879bL.f9538b = (-i5) + i6;
            }
        } else if (f5 <= BitmapDescriptorFactory.HUE_RED) {
            c0879bL.f9540d.j(c0883f, -1.0f);
            c0879bL.f9540d.j(c0883f2, 1.0f);
            c0879bL.f9538b = i5;
        } else if (f5 >= 1.0f) {
            c0879bL.f9540d.j(c0883f4, -1.0f);
            c0879bL.f9540d.j(c0883f3, 1.0f);
            c0879bL.f9538b = -i6;
        } else {
            float f6 = 1.0f - f5;
            c0879bL.f9540d.j(c0883f, f6 * 1.0f);
            c0879bL.f9540d.j(c0883f2, f6 * (-1.0f));
            c0879bL.f9540d.j(c0883f3, (-1.0f) * f5);
            c0879bL.f9540d.j(c0883f4, 1.0f * f5);
            if (i5 > 0 || i6 > 0) {
                c0879bL.f9538b = (i6 * f5) + ((-i5) * f6);
            }
        }
        if (i7 != 8) {
            c0879bL.a(this, i7);
        }
        c(c0879bL);
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01a5 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(s.C0879b r17) {
        /*
            Method dump skipped, instructions count: 429
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s.C0880c.c(s.b):void");
    }

    public final void d(C0883f c0883f, int i5) {
        int i6 = c0883f.f9561l;
        if (i6 == -1) {
            c0883f.d(this, i5);
            for (int i7 = 0; i7 < this.f9545b + 1; i7++) {
                C0883f c0883f2 = ((C0883f[]) this.f9553l.f6688e)[i7];
            }
            return;
        }
        if (i6 == -1) {
            C0879b c0879bL = l();
            c0879bL.f9537a = c0883f;
            float f5 = i5;
            c0883f.n = f5;
            c0879bL.f9538b = f5;
            c0879bL.f9541e = true;
            c(c0879bL);
            return;
        }
        C0879b c0879b = this.f9549f[i6];
        if (c0879b.f9541e) {
            c0879b.f9538b = i5;
            return;
        }
        if (c0879b.f9540d.f() == 0) {
            c0879b.f9541e = true;
            c0879b.f9538b = i5;
            return;
        }
        C0879b c0879bL2 = l();
        if (i5 < 0) {
            c0879bL2.f9538b = i5 * (-1);
            c0879bL2.f9540d.j(c0883f, 1.0f);
        } else {
            c0879bL2.f9538b = i5;
            c0879bL2.f9540d.j(c0883f, -1.0f);
        }
        c(c0879bL2);
    }

    public final void e(C0883f c0883f, C0883f c0883f2, int i5, int i6) {
        if (i6 == 8 && c0883f2.f9563o && c0883f.f9561l == -1) {
            c0883f.d(this, c0883f2.n + i5);
            return;
        }
        C0879b c0879bL = l();
        boolean z4 = false;
        if (i5 != 0) {
            if (i5 < 0) {
                i5 *= -1;
                z4 = true;
            }
            c0879bL.f9538b = i5;
        }
        if (z4) {
            c0879bL.f9540d.j(c0883f, 1.0f);
            c0879bL.f9540d.j(c0883f2, -1.0f);
        } else {
            c0879bL.f9540d.j(c0883f, -1.0f);
            c0879bL.f9540d.j(c0883f2, 1.0f);
        }
        if (i6 != 8) {
            c0879bL.a(this, i6);
        }
        c(c0879bL);
    }

    public final void f(C0883f c0883f, C0883f c0883f2, int i5, int i6) {
        C0879b c0879bL = l();
        C0883f c0883fM = m();
        c0883fM.f9562m = 0;
        c0879bL.b(c0883f, c0883f2, c0883fM, i5);
        if (i6 != 8) {
            c0879bL.f9540d.j(j(i6), (int) (c0879bL.f9540d.e(c0883fM) * (-1.0f)));
        }
        c(c0879bL);
    }

    public final void g(C0883f c0883f, C0883f c0883f2, int i5, int i6) {
        C0879b c0879bL = l();
        C0883f c0883fM = m();
        c0883fM.f9562m = 0;
        c0879bL.c(c0883f, c0883f2, c0883fM, i5);
        if (i6 != 8) {
            c0879bL.f9540d.j(j(i6), (int) (c0879bL.f9540d.e(c0883fM) * (-1.0f)));
        }
        c(c0879bL);
    }

    public final void h(C0879b c0879b) {
        int i5;
        if (c0879b.f9541e) {
            c0879b.f9537a.d(this, c0879b.f9538b);
        } else {
            C0879b[] c0879bArr = this.f9549f;
            int i6 = this.f9551j;
            c0879bArr[i6] = c0879b;
            C0883f c0883f = c0879b.f9537a;
            c0883f.f9561l = i6;
            this.f9551j = i6 + 1;
            c0883f.e(this, c0879b);
        }
        if (this.f9544a) {
            int i7 = 0;
            while (i7 < this.f9551j) {
                if (this.f9549f[i7] == null) {
                    System.out.println("WTF");
                }
                C0879b c0879b2 = this.f9549f[i7];
                if (c0879b2 != null && c0879b2.f9541e) {
                    c0879b2.f9537a.d(this, c0879b2.f9538b);
                    ((N.c) this.f9553l.f6686c).b(c0879b2);
                    this.f9549f[i7] = null;
                    int i8 = i7 + 1;
                    int i9 = i8;
                    while (true) {
                        i5 = this.f9551j;
                        if (i8 >= i5) {
                            break;
                        }
                        C0879b[] c0879bArr2 = this.f9549f;
                        int i10 = i8 - 1;
                        C0879b c0879b3 = c0879bArr2[i8];
                        c0879bArr2[i10] = c0879b3;
                        C0883f c0883f2 = c0879b3.f9537a;
                        if (c0883f2.f9561l == i8) {
                            c0883f2.f9561l = i10;
                        }
                        i9 = i8;
                        i8++;
                    }
                    if (i9 < i5) {
                        this.f9549f[i9] = null;
                    }
                    this.f9551j = i5 - 1;
                    i7--;
                }
                i7++;
            }
            this.f9544a = false;
        }
    }

    public final void i() {
        for (int i5 = 0; i5 < this.f9551j; i5++) {
            C0879b c0879b = this.f9549f[i5];
            c0879b.f9537a.n = c0879b.f9538b;
        }
    }

    public final C0883f j(int i5) {
        if (this.f9550i + 1 >= this.f9548e) {
            o();
        }
        C0883f c0883fA = a(4);
        int i6 = this.f9545b + 1;
        this.f9545b = i6;
        this.f9550i++;
        c0883fA.f9560k = i6;
        c0883fA.f9562m = i5;
        ((C0883f[]) this.f9553l.f6688e)[i6] = c0883fA;
        C0881d c0881d = this.f9546c;
        c0881d.f9557i.f1536d = c0883fA;
        float[] fArr = c0883fA.f9565q;
        Arrays.fill(fArr, BitmapDescriptorFactory.HUE_RED);
        fArr[c0883fA.f9562m] = 1.0f;
        c0881d.j(c0883fA);
        return c0883fA;
    }

    public final C0883f k(Object obj) {
        C0883f c0883f = null;
        if (obj == null) {
            return null;
        }
        if (this.f9550i + 1 >= this.f9548e) {
            o();
        }
        if (obj instanceof u.c) {
            u.c cVar = (u.c) obj;
            c0883f = cVar.f9739i;
            if (c0883f == null) {
                cVar.k();
                c0883f = cVar.f9739i;
            }
            int i5 = c0883f.f9560k;
            C0513e c0513e = this.f9553l;
            if (i5 == -1 || i5 > this.f9545b || ((C0883f[]) c0513e.f6688e)[i5] == null) {
                if (i5 != -1) {
                    c0883f.c();
                }
                int i6 = this.f9545b + 1;
                this.f9545b = i6;
                this.f9550i++;
                c0883f.f9560k = i6;
                c0883f.f9569u = 1;
                ((C0883f[]) c0513e.f6688e)[i6] = c0883f;
            }
        }
        return c0883f;
    }

    public final C0879b l() {
        Object obj;
        C0513e c0513e = this.f9553l;
        N.c cVar = (N.c) c0513e.f6686c;
        int i5 = cVar.f1757b;
        if (i5 > 0) {
            int i6 = i5 - 1;
            Object[] objArr = cVar.f1756a;
            obj = objArr[i6];
            objArr[i6] = null;
            cVar.f1757b = i6;
        } else {
            obj = null;
        }
        C0879b c0879b = (C0879b) obj;
        if (c0879b == null) {
            return new C0879b(c0513e);
        }
        c0879b.f9537a = null;
        c0879b.f9540d.b();
        c0879b.f9538b = BitmapDescriptorFactory.HUE_RED;
        c0879b.f9541e = false;
        return c0879b;
    }

    public final C0883f m() {
        if (this.f9550i + 1 >= this.f9548e) {
            o();
        }
        C0883f c0883fA = a(3);
        int i5 = this.f9545b + 1;
        this.f9545b = i5;
        this.f9550i++;
        c0883fA.f9560k = i5;
        ((C0883f[]) this.f9553l.f6688e)[i5] = c0883fA;
        return c0883fA;
    }

    public final void o() {
        int i5 = this.f9547d * 2;
        this.f9547d = i5;
        this.f9549f = (C0879b[]) Arrays.copyOf(this.f9549f, i5);
        C0513e c0513e = this.f9553l;
        c0513e.f6688e = (C0883f[]) Arrays.copyOf((C0883f[]) c0513e.f6688e, this.f9547d);
        int i6 = this.f9547d;
        this.h = new boolean[i6];
        this.f9548e = i6;
        this.f9552k = i6;
    }

    public final void p() {
        C0881d c0881d = this.f9546c;
        if (c0881d.e()) {
            i();
            return;
        }
        if (!this.g) {
            q(c0881d);
            return;
        }
        for (int i5 = 0; i5 < this.f9551j; i5++) {
            if (!this.f9549f[i5].f9541e) {
                q(c0881d);
                return;
            }
        }
        i();
    }

    public final void q(C0879b c0879b) {
        int i5 = 0;
        while (true) {
            if (i5 >= this.f9551j) {
                break;
            }
            C0879b c0879b2 = this.f9549f[i5];
            int i6 = 1;
            if (c0879b2.f9537a.f9569u != 1) {
                float f5 = c0879b2.f9538b;
                float f6 = BitmapDescriptorFactory.HUE_RED;
                if (f5 < BitmapDescriptorFactory.HUE_RED) {
                    boolean z4 = false;
                    int i7 = 0;
                    while (!z4) {
                        i7 += i6;
                        float f7 = Float.MAX_VALUE;
                        int i8 = -1;
                        int i9 = -1;
                        int i10 = 0;
                        int i11 = 0;
                        while (i10 < this.f9551j) {
                            C0879b c0879b3 = this.f9549f[i10];
                            if (c0879b3.f9537a.f9569u != i6 && !c0879b3.f9541e && c0879b3.f9538b < f6) {
                                int iF = c0879b3.f9540d.f();
                                int i12 = 0;
                                while (i12 < iF) {
                                    C0883f c0883fG = c0879b3.f9540d.g(i12);
                                    float fE = c0879b3.f9540d.e(c0883fG);
                                    if (fE > f6) {
                                        for (int i13 = 0; i13 < 9; i13++) {
                                            float f8 = c0883fG.f9564p[i13] / fE;
                                            if ((f8 < f7 && i13 == i11) || i13 > i11) {
                                                i11 = i13;
                                                i9 = c0883fG.f9560k;
                                                i8 = i10;
                                                f7 = f8;
                                            }
                                        }
                                    }
                                    i12++;
                                    f6 = BitmapDescriptorFactory.HUE_RED;
                                }
                            }
                            i10++;
                            f6 = BitmapDescriptorFactory.HUE_RED;
                            i6 = 1;
                        }
                        if (i8 != -1) {
                            C0879b c0879b4 = this.f9549f[i8];
                            c0879b4.f9537a.f9561l = -1;
                            c0879b4.g(((C0883f[]) this.f9553l.f6688e)[i9]);
                            C0883f c0883f = c0879b4.f9537a;
                            c0883f.f9561l = i8;
                            c0883f.e(this, c0879b4);
                        } else {
                            z4 = true;
                        }
                        if (i7 > this.f9550i / 2) {
                            z4 = true;
                        }
                        f6 = BitmapDescriptorFactory.HUE_RED;
                        i6 = 1;
                    }
                }
            }
            i5++;
        }
        r(c0879b);
        i();
    }

    public final void r(C0879b c0879b) {
        for (int i5 = 0; i5 < this.f9550i; i5++) {
            this.h[i5] = false;
        }
        boolean z4 = false;
        int i6 = 0;
        while (!z4) {
            i6++;
            if (i6 >= this.f9550i * 2) {
                return;
            }
            C0883f c0883f = c0879b.f9537a;
            if (c0883f != null) {
                this.h[c0883f.f9560k] = true;
            }
            C0883f c0883fD = c0879b.d(this.h);
            if (c0883fD != null) {
                boolean[] zArr = this.h;
                int i7 = c0883fD.f9560k;
                if (zArr[i7]) {
                    return;
                } else {
                    zArr[i7] = true;
                }
            }
            if (c0883fD != null) {
                float f5 = Float.MAX_VALUE;
                int i8 = -1;
                for (int i9 = 0; i9 < this.f9551j; i9++) {
                    C0879b c0879b2 = this.f9549f[i9];
                    if (c0879b2.f9537a.f9569u != 1 && !c0879b2.f9541e && c0879b2.f9540d.c(c0883fD)) {
                        float fE = c0879b2.f9540d.e(c0883fD);
                        if (fE < BitmapDescriptorFactory.HUE_RED) {
                            float f6 = (-c0879b2.f9538b) / fE;
                            if (f6 < f5) {
                                i8 = i9;
                                f5 = f6;
                            }
                        }
                    }
                }
                if (i8 > -1) {
                    C0879b c0879b3 = this.f9549f[i8];
                    c0879b3.f9537a.f9561l = -1;
                    c0879b3.g(c0883fD);
                    C0883f c0883f2 = c0879b3.f9537a;
                    c0883f2.f9561l = i8;
                    c0883f2.e(this, c0879b3);
                }
            } else {
                z4 = true;
            }
        }
    }

    public final void s() {
        for (int i5 = 0; i5 < this.f9551j; i5++) {
            C0879b c0879b = this.f9549f[i5];
            if (c0879b != null) {
                ((N.c) this.f9553l.f6686c).b(c0879b);
            }
            this.f9549f[i5] = null;
        }
    }

    public final void t() {
        C0513e c0513e;
        int i5 = 0;
        while (true) {
            c0513e = this.f9553l;
            C0883f[] c0883fArr = (C0883f[]) c0513e.f6688e;
            if (i5 >= c0883fArr.length) {
                break;
            }
            C0883f c0883f = c0883fArr[i5];
            if (c0883f != null) {
                c0883f.c();
            }
            i5++;
        }
        N.c cVar = (N.c) c0513e.f6687d;
        C0883f[] c0883fArr2 = this.f9554m;
        int length = this.n;
        cVar.getClass();
        if (length > c0883fArr2.length) {
            length = c0883fArr2.length;
        }
        for (int i6 = 0; i6 < length; i6++) {
            C0883f c0883f2 = c0883fArr2[i6];
            int i7 = cVar.f1757b;
            Object[] objArr = cVar.f1756a;
            if (i7 < objArr.length) {
                objArr[i7] = c0883f2;
                cVar.f1757b = i7 + 1;
            }
        }
        this.n = 0;
        Arrays.fill((C0883f[]) c0513e.f6688e, (Object) null);
        this.f9545b = 0;
        C0881d c0881d = this.f9546c;
        c0881d.h = 0;
        c0881d.f9538b = BitmapDescriptorFactory.HUE_RED;
        this.f9550i = 1;
        for (int i8 = 0; i8 < this.f9551j; i8++) {
            C0879b c0879b = this.f9549f[i8];
        }
        s();
        this.f9551j = 0;
        this.f9555o = new C0879b(c0513e);
    }
}
