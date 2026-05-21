package k4;

import android.graphics.Rect;

/* loaded from: classes.dex */
public abstract class s {

    /* renamed from: b, reason: collision with root package name */
    public int f8311b;

    /* renamed from: a, reason: collision with root package name */
    public final Rect f8310a = new Rect();

    /* renamed from: c, reason: collision with root package name */
    public boolean f8312c = false;

    /* renamed from: d, reason: collision with root package name */
    public boolean f8313d = false;

    public abstract void a();

    public abstract void b(int i5, int i6, long j5);

    public abstract void c();

    public final void d(double d5, p pVar) {
        int i5;
        int i6;
        double dPow = Math.pow(2.0d, d5 - l.b(d5)) * t.f8314a;
        Rect rect = this.f8310a;
        t.g(pVar, dPow, rect);
        this.f8311b = l.b(d5);
        c();
        int i7 = 1 << this.f8311b;
        for (int i8 = rect.left; i8 <= rect.right; i8++) {
            for (int i9 = rect.top; i9 <= rect.bottom; i9++) {
                if ((this.f8312c || (i8 >= 0 && i8 < i7)) && (this.f8313d || (i9 >= 0 && i9 < i7))) {
                    if (i8 > 0) {
                        i5 = i8 % i7;
                    } else {
                        i5 = i8;
                        while (i5 < 0) {
                            i5 += i7;
                        }
                    }
                    if (i9 > 0) {
                        i6 = i9 % i7;
                    } else {
                        i6 = i9;
                        while (i6 < 0) {
                            i6 += i7;
                        }
                    }
                    b(i8, i9, l.f(this.f8311b, i5, i6));
                }
            }
        }
        a();
    }
}
