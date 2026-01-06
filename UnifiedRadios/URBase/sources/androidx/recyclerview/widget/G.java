package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* loaded from: classes.dex */
public class G {

    /* renamed from: a, reason: collision with root package name */
    public int f4021a = -1;

    /* renamed from: b, reason: collision with root package name */
    public RecyclerView f4022b;

    /* renamed from: c, reason: collision with root package name */
    public X f4023c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f4024d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f4025e;

    /* renamed from: f, reason: collision with root package name */
    public View f4026f;
    public final h0 g;
    public boolean h;

    /* renamed from: i, reason: collision with root package name */
    public final LinearInterpolator f4027i;

    /* renamed from: j, reason: collision with root package name */
    public final DecelerateInterpolator f4028j;

    /* renamed from: k, reason: collision with root package name */
    public PointF f4029k;

    /* renamed from: l, reason: collision with root package name */
    public final DisplayMetrics f4030l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f4031m;
    public float n;

    /* renamed from: o, reason: collision with root package name */
    public int f4032o;

    /* renamed from: p, reason: collision with root package name */
    public int f4033p;

    public G(Context context) {
        h0 h0Var = new h0(0);
        h0Var.f4251f = -1;
        h0Var.f4247b = false;
        h0Var.g = 0;
        h0Var.f4248c = 0;
        h0Var.f4249d = 0;
        h0Var.f4250e = Integer.MIN_VALUE;
        h0Var.h = null;
        this.g = h0Var;
        this.f4027i = new LinearInterpolator();
        this.f4028j = new DecelerateInterpolator();
        this.f4031m = false;
        this.f4032o = 0;
        this.f4033p = 0;
        this.f4030l = context.getResources().getDisplayMetrics();
    }

    public static int a(int i5, int i6, int i7, int i8, int i9) {
        if (i9 == -1) {
            return i7 - i5;
        }
        if (i9 != 0) {
            if (i9 == 1) {
                return i8 - i6;
            }
            throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
        int i10 = i7 - i5;
        if (i10 > 0) {
            return i10;
        }
        int i11 = i8 - i6;
        if (i11 < 0) {
            return i11;
        }
        return 0;
    }

    public int b(View view, int i5) {
        X x4 = this.f4023c;
        if (x4 == null || !x4.d()) {
            return 0;
        }
        Y y4 = (Y) view.getLayoutParams();
        return a((view.getLeft() - ((Y) view.getLayoutParams()).f4191b.left) - ((ViewGroup.MarginLayoutParams) y4).leftMargin, view.getRight() + ((Y) view.getLayoutParams()).f4191b.right + ((ViewGroup.MarginLayoutParams) y4).rightMargin, x4.C(), x4.n - x4.D(), i5);
    }

    public int c(View view, int i5) {
        X x4 = this.f4023c;
        if (x4 == null || !x4.e()) {
            return 0;
        }
        Y y4 = (Y) view.getLayoutParams();
        return a((view.getTop() - ((Y) view.getLayoutParams()).f4191b.top) - ((ViewGroup.MarginLayoutParams) y4).topMargin, view.getBottom() + ((Y) view.getLayoutParams()).f4191b.bottom + ((ViewGroup.MarginLayoutParams) y4).bottomMargin, x4.E(), x4.f4189o - x4.B(), i5);
    }

    public float d(DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }

    public int e(int i5) {
        float fAbs = Math.abs(i5);
        if (!this.f4031m) {
            this.n = d(this.f4030l);
            this.f4031m = true;
        }
        return (int) Math.ceil(fAbs * this.n);
    }

    public PointF f(int i5) {
        Object obj = this.f4023c;
        if (obj instanceof i0) {
            return ((i0) obj).a(i5);
        }
        Log.w("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + i0.class.getCanonicalName());
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(int r9, int r10) {
        /*
            Method dump skipped, instructions count: 277
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.G.g(int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void h(android.view.View r7, androidx.recyclerview.widget.h0 r8) {
        /*
            r6 = this;
            android.graphics.PointF r0 = r6.f4029k
            r1 = 1
            r2 = 0
            r3 = -1
            r4 = 0
            if (r0 == 0) goto L15
            float r0 = r0.x
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 != 0) goto Lf
            goto L15
        Lf:
            if (r0 <= 0) goto L13
            r0 = r1
            goto L16
        L13:
            r0 = r3
            goto L16
        L15:
            r0 = r2
        L16:
            int r0 = r6.b(r7, r0)
            android.graphics.PointF r5 = r6.f4029k
            if (r5 == 0) goto L2a
            float r5 = r5.y
            int r4 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r4 != 0) goto L25
            goto L2a
        L25:
            if (r4 <= 0) goto L29
            r2 = r1
            goto L2a
        L29:
            r2 = r3
        L2a:
            int r7 = r6.c(r7, r2)
            int r2 = r0 * r0
            int r3 = r7 * r7
            int r3 = r3 + r2
            double r2 = (double) r3
            double r2 = java.lang.Math.sqrt(r2)
            int r2 = (int) r2
            int r2 = r6.e(r2)
            double r2 = (double) r2
            r4 = 4599717252057688074(0x3fd57a786c22680a, double:0.3356)
            double r2 = r2 / r4
            double r2 = java.lang.Math.ceil(r2)
            int r2 = (int) r2
            if (r2 <= 0) goto L59
            int r0 = -r0
            int r7 = -r7
            android.view.animation.DecelerateInterpolator r3 = r6.f4028j
            r8.f4248c = r0
            r8.f4249d = r7
            r8.f4250e = r2
            r8.h = r3
            r8.f4247b = r1
        L59:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.G.h(android.view.View, androidx.recyclerview.widget.h0):void");
    }

    public final void i() {
        if (this.f4025e) {
            this.f4025e = false;
            this.f4033p = 0;
            this.f4032o = 0;
            this.f4029k = null;
            this.f4022b.f4115j0.f4263a = -1;
            this.f4026f = null;
            this.f4021a = -1;
            this.f4024d = false;
            X x4 = this.f4023c;
            if (x4.f4182e == this) {
                x4.f4182e = null;
            }
            this.f4023c = null;
            this.f4022b = null;
        }
    }
}
