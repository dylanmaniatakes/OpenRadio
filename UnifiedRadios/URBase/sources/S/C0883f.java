package s;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.Arrays;

/* renamed from: s.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0883f implements Comparable {

    /* renamed from: j, reason: collision with root package name */
    public boolean f9559j;
    public float n;

    /* renamed from: u, reason: collision with root package name */
    public int f9569u;

    /* renamed from: k, reason: collision with root package name */
    public int f9560k = -1;

    /* renamed from: l, reason: collision with root package name */
    public int f9561l = -1;

    /* renamed from: m, reason: collision with root package name */
    public int f9562m = 0;

    /* renamed from: o, reason: collision with root package name */
    public boolean f9563o = false;

    /* renamed from: p, reason: collision with root package name */
    public final float[] f9564p = new float[9];

    /* renamed from: q, reason: collision with root package name */
    public final float[] f9565q = new float[9];

    /* renamed from: r, reason: collision with root package name */
    public C0879b[] f9566r = new C0879b[16];

    /* renamed from: s, reason: collision with root package name */
    public int f9567s = 0;

    /* renamed from: t, reason: collision with root package name */
    public int f9568t = 0;

    public C0883f(int i5) {
        this.f9569u = i5;
    }

    public final void a(C0879b c0879b) {
        int i5 = 0;
        while (true) {
            int i6 = this.f9567s;
            if (i5 >= i6) {
                C0879b[] c0879bArr = this.f9566r;
                if (i6 >= c0879bArr.length) {
                    this.f9566r = (C0879b[]) Arrays.copyOf(c0879bArr, c0879bArr.length * 2);
                }
                C0879b[] c0879bArr2 = this.f9566r;
                int i7 = this.f9567s;
                c0879bArr2[i7] = c0879b;
                this.f9567s = i7 + 1;
                return;
            }
            if (this.f9566r[i5] == c0879b) {
                return;
            } else {
                i5++;
            }
        }
    }

    public final void b(C0879b c0879b) {
        int i5 = this.f9567s;
        int i6 = 0;
        while (i6 < i5) {
            if (this.f9566r[i6] == c0879b) {
                while (i6 < i5 - 1) {
                    C0879b[] c0879bArr = this.f9566r;
                    int i7 = i6 + 1;
                    c0879bArr[i6] = c0879bArr[i7];
                    i6 = i7;
                }
                this.f9567s--;
                return;
            }
            i6++;
        }
    }

    public final void c() {
        this.f9569u = 5;
        this.f9562m = 0;
        this.f9560k = -1;
        this.f9561l = -1;
        this.n = BitmapDescriptorFactory.HUE_RED;
        this.f9563o = false;
        int i5 = this.f9567s;
        for (int i6 = 0; i6 < i5; i6++) {
            this.f9566r[i6] = null;
        }
        this.f9567s = 0;
        this.f9568t = 0;
        this.f9559j = false;
        Arrays.fill(this.f9565q, BitmapDescriptorFactory.HUE_RED);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f9560k - ((C0883f) obj).f9560k;
    }

    public final void d(C0880c c0880c, float f5) {
        this.n = f5;
        this.f9563o = true;
        int i5 = this.f9567s;
        this.f9561l = -1;
        for (int i6 = 0; i6 < i5; i6++) {
            this.f9566r[i6].h(c0880c, this, false);
        }
        this.f9567s = 0;
    }

    public final void e(C0880c c0880c, C0879b c0879b) {
        int i5 = this.f9567s;
        for (int i6 = 0; i6 < i5; i6++) {
            this.f9566r[i6].i(c0880c, c0879b, false);
        }
        this.f9567s = 0;
    }

    public final String toString() {
        return "" + this.f9560k;
    }
}
