package androidx.recyclerview.widget;

import android.view.View;

/* loaded from: classes.dex */
public final class C {

    /* renamed from: a, reason: collision with root package name */
    public androidx.emoji2.text.f f3999a;

    /* renamed from: b, reason: collision with root package name */
    public int f4000b;

    /* renamed from: c, reason: collision with root package name */
    public int f4001c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f4002d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f4003e;

    public C() {
        d();
    }

    public final void a() {
        this.f4001c = this.f4002d ? this.f3999a.g() : this.f3999a.k();
    }

    public final void b(View view, int i5) {
        if (this.f4002d) {
            this.f4001c = this.f3999a.m() + this.f3999a.b(view);
        } else {
            this.f4001c = this.f3999a.e(view);
        }
        this.f4000b = i5;
    }

    public final void c(View view, int i5) {
        int iM = this.f3999a.m();
        if (iM >= 0) {
            b(view, i5);
            return;
        }
        this.f4000b = i5;
        if (!this.f4002d) {
            int iE = this.f3999a.e(view);
            int iK = iE - this.f3999a.k();
            this.f4001c = iE;
            if (iK > 0) {
                int iG = (this.f3999a.g() - Math.min(0, (this.f3999a.g() - iM) - this.f3999a.b(view))) - (this.f3999a.c(view) + iE);
                if (iG < 0) {
                    this.f4001c -= Math.min(iK, -iG);
                    return;
                }
                return;
            }
            return;
        }
        int iG2 = (this.f3999a.g() - iM) - this.f3999a.b(view);
        this.f4001c = this.f3999a.g() - iG2;
        if (iG2 > 0) {
            int iC = this.f4001c - this.f3999a.c(view);
            int iK2 = this.f3999a.k();
            int iMin = iC - (Math.min(this.f3999a.e(view) - iK2, 0) + iK2);
            if (iMin < 0) {
                this.f4001c = Math.min(iG2, -iMin) + this.f4001c;
            }
        }
    }

    public final void d() {
        this.f4000b = -1;
        this.f4001c = Integer.MIN_VALUE;
        this.f4002d = false;
        this.f4003e = false;
    }

    public final String toString() {
        return "AnchorInfo{mPosition=" + this.f4000b + ", mCoordinate=" + this.f4001c + ", mLayoutFromEnd=" + this.f4002d + ", mValid=" + this.f4003e + '}';
    }
}
