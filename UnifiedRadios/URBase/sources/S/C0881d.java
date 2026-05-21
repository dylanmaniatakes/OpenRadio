package s;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.Arrays;

/* renamed from: s.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0881d extends C0879b {

    /* renamed from: f, reason: collision with root package name */
    public C0883f[] f9556f;
    public C0883f[] g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public L0.c f9557i;

    @Override // s.C0879b
    public final C0883f d(boolean[] zArr) {
        int i5 = -1;
        for (int i6 = 0; i6 < this.h; i6++) {
            C0883f[] c0883fArr = this.f9556f;
            C0883f c0883f = c0883fArr[i6];
            if (!zArr[c0883f.f9560k]) {
                L0.c cVar = this.f9557i;
                cVar.f1536d = c0883f;
                int i7 = 8;
                if (i5 == -1) {
                    while (i7 >= 0) {
                        float f5 = ((C0883f) cVar.f1536d).f9565q[i7];
                        if (f5 <= BitmapDescriptorFactory.HUE_RED) {
                            if (f5 < BitmapDescriptorFactory.HUE_RED) {
                                i5 = i6;
                                break;
                            }
                            i7--;
                        }
                    }
                } else {
                    C0883f c0883f2 = c0883fArr[i5];
                    while (true) {
                        if (i7 >= 0) {
                            float f6 = c0883f2.f9565q[i7];
                            float f7 = ((C0883f) cVar.f1536d).f9565q[i7];
                            if (f7 == f6) {
                                i7--;
                            } else if (f7 < f6) {
                            }
                        }
                    }
                }
            }
        }
        if (i5 == -1) {
            return null;
        }
        return this.f9556f[i5];
    }

    @Override // s.C0879b
    public final boolean e() {
        return this.h == 0;
    }

    @Override // s.C0879b
    public final void i(C0880c c0880c, C0879b c0879b, boolean z4) {
        C0883f c0883f = c0879b.f9537a;
        if (c0883f == null) {
            return;
        }
        C0878a c0878a = c0879b.f9540d;
        int iF = c0878a.f();
        for (int i5 = 0; i5 < iF; i5++) {
            C0883f c0883fG = c0878a.g(i5);
            float fH = c0878a.h(i5);
            L0.c cVar = this.f9557i;
            cVar.f1536d = c0883fG;
            boolean z5 = c0883fG.f9559j;
            float[] fArr = c0883f.f9565q;
            if (z5) {
                boolean z6 = true;
                for (int i6 = 0; i6 < 9; i6++) {
                    float[] fArr2 = ((C0883f) cVar.f1536d).f9565q;
                    float f5 = (fArr[i6] * fH) + fArr2[i6];
                    fArr2[i6] = f5;
                    if (Math.abs(f5) < 1.0E-4f) {
                        ((C0883f) cVar.f1536d).f9565q[i6] = 0.0f;
                    } else {
                        z6 = false;
                    }
                }
                if (z6) {
                    ((C0881d) cVar.f1537e).k((C0883f) cVar.f1536d);
                }
            } else {
                for (int i7 = 0; i7 < 9; i7++) {
                    float f6 = fArr[i7];
                    if (f6 != BitmapDescriptorFactory.HUE_RED) {
                        float f7 = f6 * fH;
                        if (Math.abs(f7) < 1.0E-4f) {
                            f7 = 0.0f;
                        }
                        ((C0883f) cVar.f1536d).f9565q[i7] = f7;
                    } else {
                        ((C0883f) cVar.f1536d).f9565q[i7] = 0.0f;
                    }
                }
                j(c0883fG);
            }
            this.f9538b = (c0879b.f9538b * fH) + this.f9538b;
        }
        k(c0883f);
    }

    public final void j(C0883f c0883f) {
        int i5;
        int i6 = this.h + 1;
        C0883f[] c0883fArr = this.f9556f;
        if (i6 > c0883fArr.length) {
            C0883f[] c0883fArr2 = (C0883f[]) Arrays.copyOf(c0883fArr, c0883fArr.length * 2);
            this.f9556f = c0883fArr2;
            this.g = (C0883f[]) Arrays.copyOf(c0883fArr2, c0883fArr2.length * 2);
        }
        C0883f[] c0883fArr3 = this.f9556f;
        int i7 = this.h;
        c0883fArr3[i7] = c0883f;
        int i8 = i7 + 1;
        this.h = i8;
        if (i8 > 1 && c0883fArr3[i7].f9560k > c0883f.f9560k) {
            int i9 = 0;
            while (true) {
                i5 = this.h;
                if (i9 >= i5) {
                    break;
                }
                this.g[i9] = this.f9556f[i9];
                i9++;
            }
            Arrays.sort(this.g, 0, i5, new B0.a(10));
            for (int i10 = 0; i10 < this.h; i10++) {
                this.f9556f[i10] = this.g[i10];
            }
        }
        c0883f.f9559j = true;
        c0883f.a(this);
    }

    public final void k(C0883f c0883f) {
        int i5 = 0;
        while (i5 < this.h) {
            if (this.f9556f[i5] == c0883f) {
                while (true) {
                    int i6 = this.h;
                    if (i5 >= i6 - 1) {
                        this.h = i6 - 1;
                        c0883f.f9559j = false;
                        return;
                    } else {
                        C0883f[] c0883fArr = this.f9556f;
                        int i7 = i5 + 1;
                        c0883fArr[i5] = c0883fArr[i7];
                        i5 = i7;
                    }
                }
            } else {
                i5++;
            }
        }
    }

    @Override // s.C0879b
    public final String toString() {
        String str = " goal -> (" + this.f9538b + ") : ";
        for (int i5 = 0; i5 < this.h; i5++) {
            C0883f c0883f = this.f9556f[i5];
            L0.c cVar = this.f9557i;
            cVar.f1536d = c0883f;
            str = str + cVar + " ";
        }
        return str;
    }
}
