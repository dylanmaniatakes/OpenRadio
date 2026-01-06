package s;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.unified.ur1.SatelliteTracker.h;
import f3.C0513e;
import java.util.Arrays;

/* renamed from: s.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0878a {

    /* renamed from: b, reason: collision with root package name */
    public final C0879b f9530b;

    /* renamed from: c, reason: collision with root package name */
    public final C0513e f9531c;

    /* renamed from: a, reason: collision with root package name */
    public int f9529a = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f9532d = 8;

    /* renamed from: e, reason: collision with root package name */
    public int[] f9533e = new int[8];

    /* renamed from: f, reason: collision with root package name */
    public int[] f9534f = new int[8];
    public float[] g = new float[8];
    public int h = -1;

    /* renamed from: i, reason: collision with root package name */
    public int f9535i = -1;

    /* renamed from: j, reason: collision with root package name */
    public boolean f9536j = false;

    public C0878a(C0879b c0879b, C0513e c0513e) {
        this.f9530b = c0879b;
        this.f9531c = c0513e;
    }

    public final void a(C0883f c0883f, float f5, boolean z4) {
        if (f5 <= -0.001f || f5 >= 0.001f) {
            int i5 = this.h;
            C0879b c0879b = this.f9530b;
            if (i5 == -1) {
                this.h = 0;
                this.g[0] = f5;
                this.f9533e[0] = c0883f.f9560k;
                this.f9534f[0] = -1;
                c0883f.f9568t++;
                c0883f.a(c0879b);
                this.f9529a++;
                if (this.f9536j) {
                    return;
                }
                int i6 = this.f9535i + 1;
                this.f9535i = i6;
                int[] iArr = this.f9533e;
                if (i6 >= iArr.length) {
                    this.f9536j = true;
                    this.f9535i = iArr.length - 1;
                    return;
                }
                return;
            }
            int i7 = -1;
            for (int i8 = 0; i5 != -1 && i8 < this.f9529a; i8++) {
                int i9 = this.f9533e[i5];
                int i10 = c0883f.f9560k;
                if (i9 == i10) {
                    float[] fArr = this.g;
                    float f6 = fArr[i5] + f5;
                    if (f6 > -0.001f && f6 < 0.001f) {
                        f6 = 0.0f;
                    }
                    fArr[i5] = f6;
                    if (f6 == BitmapDescriptorFactory.HUE_RED) {
                        if (i5 == this.h) {
                            this.h = this.f9534f[i5];
                        } else {
                            int[] iArr2 = this.f9534f;
                            iArr2[i7] = iArr2[i5];
                        }
                        if (z4) {
                            c0883f.b(c0879b);
                        }
                        if (this.f9536j) {
                            this.f9535i = i5;
                        }
                        c0883f.f9568t--;
                        this.f9529a--;
                        return;
                    }
                    return;
                }
                if (i9 < i10) {
                    i7 = i5;
                }
                i5 = this.f9534f[i5];
            }
            int length = this.f9535i;
            int i11 = length + 1;
            if (this.f9536j) {
                int[] iArr3 = this.f9533e;
                if (iArr3[length] != -1) {
                    length = iArr3.length;
                }
            } else {
                length = i11;
            }
            int[] iArr4 = this.f9533e;
            if (length >= iArr4.length && this.f9529a < iArr4.length) {
                int i12 = 0;
                while (true) {
                    int[] iArr5 = this.f9533e;
                    if (i12 >= iArr5.length) {
                        break;
                    }
                    if (iArr5[i12] == -1) {
                        length = i12;
                        break;
                    }
                    i12++;
                }
            }
            int[] iArr6 = this.f9533e;
            if (length >= iArr6.length) {
                length = iArr6.length;
                int i13 = this.f9532d * 2;
                this.f9532d = i13;
                this.f9536j = false;
                this.f9535i = length - 1;
                this.g = Arrays.copyOf(this.g, i13);
                this.f9533e = Arrays.copyOf(this.f9533e, this.f9532d);
                this.f9534f = Arrays.copyOf(this.f9534f, this.f9532d);
            }
            this.f9533e[length] = c0883f.f9560k;
            this.g[length] = f5;
            if (i7 != -1) {
                int[] iArr7 = this.f9534f;
                iArr7[length] = iArr7[i7];
                iArr7[i7] = length;
            } else {
                this.f9534f[length] = this.h;
                this.h = length;
            }
            c0883f.f9568t++;
            c0883f.a(c0879b);
            this.f9529a++;
            if (!this.f9536j) {
                this.f9535i++;
            }
            int i14 = this.f9535i;
            int[] iArr8 = this.f9533e;
            if (i14 >= iArr8.length) {
                this.f9536j = true;
                this.f9535i = iArr8.length - 1;
            }
        }
    }

    public final void b() {
        int i5 = this.h;
        for (int i6 = 0; i5 != -1 && i6 < this.f9529a; i6++) {
            C0883f c0883f = ((C0883f[]) this.f9531c.f6688e)[this.f9533e[i5]];
            if (c0883f != null) {
                c0883f.b(this.f9530b);
            }
            i5 = this.f9534f[i5];
        }
        this.h = -1;
        this.f9535i = -1;
        this.f9536j = false;
        this.f9529a = 0;
    }

    public final boolean c(C0883f c0883f) {
        int i5 = this.h;
        if (i5 == -1) {
            return false;
        }
        for (int i6 = 0; i5 != -1 && i6 < this.f9529a; i6++) {
            if (this.f9533e[i5] == c0883f.f9560k) {
                return true;
            }
            i5 = this.f9534f[i5];
        }
        return false;
    }

    public final void d(float f5) {
        int i5 = this.h;
        for (int i6 = 0; i5 != -1 && i6 < this.f9529a; i6++) {
            float[] fArr = this.g;
            fArr[i5] = fArr[i5] / f5;
            i5 = this.f9534f[i5];
        }
    }

    public final float e(C0883f c0883f) {
        int i5 = this.h;
        for (int i6 = 0; i5 != -1 && i6 < this.f9529a; i6++) {
            if (this.f9533e[i5] == c0883f.f9560k) {
                return this.g[i5];
            }
            i5 = this.f9534f[i5];
        }
        return BitmapDescriptorFactory.HUE_RED;
    }

    public final int f() {
        return this.f9529a;
    }

    public final C0883f g(int i5) {
        int i6 = this.h;
        for (int i7 = 0; i6 != -1 && i7 < this.f9529a; i7++) {
            if (i7 == i5) {
                return ((C0883f[]) this.f9531c.f6688e)[this.f9533e[i6]];
            }
            i6 = this.f9534f[i6];
        }
        return null;
    }

    public final float h(int i5) {
        int i6 = this.h;
        for (int i7 = 0; i6 != -1 && i7 < this.f9529a; i7++) {
            if (i7 == i5) {
                return this.g[i6];
            }
            i6 = this.f9534f[i6];
        }
        return BitmapDescriptorFactory.HUE_RED;
    }

    public final void i() {
        int i5 = this.h;
        for (int i6 = 0; i5 != -1 && i6 < this.f9529a; i6++) {
            float[] fArr = this.g;
            fArr[i5] = fArr[i5] * (-1.0f);
            i5 = this.f9534f[i5];
        }
    }

    public final void j(C0883f c0883f, float f5) {
        if (f5 == BitmapDescriptorFactory.HUE_RED) {
            k(c0883f, true);
            return;
        }
        int i5 = this.h;
        C0879b c0879b = this.f9530b;
        if (i5 == -1) {
            this.h = 0;
            this.g[0] = f5;
            this.f9533e[0] = c0883f.f9560k;
            this.f9534f[0] = -1;
            c0883f.f9568t++;
            c0883f.a(c0879b);
            this.f9529a++;
            if (this.f9536j) {
                return;
            }
            int i6 = this.f9535i + 1;
            this.f9535i = i6;
            int[] iArr = this.f9533e;
            if (i6 >= iArr.length) {
                this.f9536j = true;
                this.f9535i = iArr.length - 1;
                return;
            }
            return;
        }
        int i7 = -1;
        for (int i8 = 0; i5 != -1 && i8 < this.f9529a; i8++) {
            int i9 = this.f9533e[i5];
            int i10 = c0883f.f9560k;
            if (i9 == i10) {
                this.g[i5] = f5;
                return;
            }
            if (i9 < i10) {
                i7 = i5;
            }
            i5 = this.f9534f[i5];
        }
        int length = this.f9535i;
        int i11 = length + 1;
        if (this.f9536j) {
            int[] iArr2 = this.f9533e;
            if (iArr2[length] != -1) {
                length = iArr2.length;
            }
        } else {
            length = i11;
        }
        int[] iArr3 = this.f9533e;
        if (length >= iArr3.length && this.f9529a < iArr3.length) {
            int i12 = 0;
            while (true) {
                int[] iArr4 = this.f9533e;
                if (i12 >= iArr4.length) {
                    break;
                }
                if (iArr4[i12] == -1) {
                    length = i12;
                    break;
                }
                i12++;
            }
        }
        int[] iArr5 = this.f9533e;
        if (length >= iArr5.length) {
            length = iArr5.length;
            int i13 = this.f9532d * 2;
            this.f9532d = i13;
            this.f9536j = false;
            this.f9535i = length - 1;
            this.g = Arrays.copyOf(this.g, i13);
            this.f9533e = Arrays.copyOf(this.f9533e, this.f9532d);
            this.f9534f = Arrays.copyOf(this.f9534f, this.f9532d);
        }
        this.f9533e[length] = c0883f.f9560k;
        this.g[length] = f5;
        if (i7 != -1) {
            int[] iArr6 = this.f9534f;
            iArr6[length] = iArr6[i7];
            iArr6[i7] = length;
        } else {
            this.f9534f[length] = this.h;
            this.h = length;
        }
        c0883f.f9568t++;
        c0883f.a(c0879b);
        int i14 = this.f9529a + 1;
        this.f9529a = i14;
        if (!this.f9536j) {
            this.f9535i++;
        }
        int[] iArr7 = this.f9533e;
        if (i14 >= iArr7.length) {
            this.f9536j = true;
        }
        if (this.f9535i >= iArr7.length) {
            this.f9536j = true;
            this.f9535i = iArr7.length - 1;
        }
    }

    public final float k(C0883f c0883f, boolean z4) {
        int i5 = this.h;
        if (i5 == -1) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        int i6 = 0;
        int i7 = -1;
        while (i5 != -1 && i6 < this.f9529a) {
            if (this.f9533e[i5] == c0883f.f9560k) {
                if (i5 == this.h) {
                    this.h = this.f9534f[i5];
                } else {
                    int[] iArr = this.f9534f;
                    iArr[i7] = iArr[i5];
                }
                if (z4) {
                    c0883f.b(this.f9530b);
                }
                c0883f.f9568t--;
                this.f9529a--;
                this.f9533e[i5] = -1;
                if (this.f9536j) {
                    this.f9535i = i5;
                }
                return this.g[i5];
            }
            i6++;
            i7 = i5;
            i5 = this.f9534f[i5];
        }
        return BitmapDescriptorFactory.HUE_RED;
    }

    public final float l(C0879b c0879b, boolean z4) {
        float fE = e(c0879b.f9537a);
        k(c0879b.f9537a, z4);
        C0878a c0878a = c0879b.f9540d;
        int iF = c0878a.f();
        for (int i5 = 0; i5 < iF; i5++) {
            C0883f c0883fG = c0878a.g(i5);
            a(c0883fG, c0878a.e(c0883fG) * fE, z4);
        }
        return fE;
    }

    public final String toString() {
        int i5 = this.h;
        String string = "";
        for (int i6 = 0; i5 != -1 && i6 < this.f9529a; i6++) {
            StringBuilder sbB = AbstractC0882e.b(h.b(string, " -> "));
            sbB.append(this.g[i5]);
            sbB.append(" : ");
            StringBuilder sbB2 = AbstractC0882e.b(sbB.toString());
            sbB2.append(((C0883f[]) this.f9531c.f6688e)[this.f9533e[i5]]);
            string = sbB2.toString();
            i5 = this.f9534f[i5];
        }
        return string;
    }
}
