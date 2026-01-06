package x;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public int[] f10234a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f10235b;

    /* renamed from: c, reason: collision with root package name */
    public int f10236c;

    /* renamed from: d, reason: collision with root package name */
    public int[] f10237d;

    /* renamed from: e, reason: collision with root package name */
    public float[] f10238e;

    /* renamed from: f, reason: collision with root package name */
    public int f10239f;
    public int[] g;
    public String[] h;

    /* renamed from: i, reason: collision with root package name */
    public int f10240i;

    /* renamed from: j, reason: collision with root package name */
    public int[] f10241j;

    /* renamed from: k, reason: collision with root package name */
    public boolean[] f10242k;

    /* renamed from: l, reason: collision with root package name */
    public int f10243l;

    public final void a(int i5, float f5) {
        int i6 = this.f10239f;
        int[] iArr = this.f10237d;
        if (i6 >= iArr.length) {
            this.f10237d = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.f10238e;
            this.f10238e = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.f10237d;
        int i7 = this.f10239f;
        iArr2[i7] = i5;
        float[] fArr2 = this.f10238e;
        this.f10239f = i7 + 1;
        fArr2[i7] = f5;
    }

    public final void b(int i5, int i6) {
        int i7 = this.f10236c;
        int[] iArr = this.f10234a;
        if (i7 >= iArr.length) {
            this.f10234a = Arrays.copyOf(iArr, iArr.length * 2);
            int[] iArr2 = this.f10235b;
            this.f10235b = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.f10234a;
        int i8 = this.f10236c;
        iArr3[i8] = i5;
        int[] iArr4 = this.f10235b;
        this.f10236c = i8 + 1;
        iArr4[i8] = i6;
    }

    public final void c(int i5, String str) {
        int i6 = this.f10240i;
        int[] iArr = this.g;
        if (i6 >= iArr.length) {
            this.g = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.h;
            this.h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
        }
        int[] iArr2 = this.g;
        int i7 = this.f10240i;
        iArr2[i7] = i5;
        String[] strArr2 = this.h;
        this.f10240i = i7 + 1;
        strArr2[i7] = str;
    }

    public final void d(int i5, boolean z4) {
        int i6 = this.f10243l;
        int[] iArr = this.f10241j;
        if (i6 >= iArr.length) {
            this.f10241j = Arrays.copyOf(iArr, iArr.length * 2);
            boolean[] zArr = this.f10242k;
            this.f10242k = Arrays.copyOf(zArr, zArr.length * 2);
        }
        int[] iArr2 = this.f10241j;
        int i7 = this.f10243l;
        iArr2[i7] = i5;
        boolean[] zArr2 = this.f10242k;
        this.f10243l = i7 + 1;
        zArr2[i7] = z4;
    }
}
