package x;

import android.view.ViewGroup;

/* loaded from: classes.dex */
public final class e extends ViewGroup.MarginLayoutParams {

    /* renamed from: A, reason: collision with root package name */
    public int f10159A;

    /* renamed from: B, reason: collision with root package name */
    public int f10160B;

    /* renamed from: C, reason: collision with root package name */
    public int f10161C;

    /* renamed from: D, reason: collision with root package name */
    public int f10162D;

    /* renamed from: E, reason: collision with root package name */
    public float f10163E;

    /* renamed from: F, reason: collision with root package name */
    public float f10164F;

    /* renamed from: G, reason: collision with root package name */
    public String f10165G;

    /* renamed from: H, reason: collision with root package name */
    public float f10166H;
    public float I;

    /* renamed from: J, reason: collision with root package name */
    public int f10167J;

    /* renamed from: K, reason: collision with root package name */
    public int f10168K;

    /* renamed from: L, reason: collision with root package name */
    public int f10169L;

    /* renamed from: M, reason: collision with root package name */
    public int f10170M;

    /* renamed from: N, reason: collision with root package name */
    public int f10171N;

    /* renamed from: O, reason: collision with root package name */
    public int f10172O;

    /* renamed from: P, reason: collision with root package name */
    public int f10173P;

    /* renamed from: Q, reason: collision with root package name */
    public int f10174Q;

    /* renamed from: R, reason: collision with root package name */
    public float f10175R;

    /* renamed from: S, reason: collision with root package name */
    public float f10176S;

    /* renamed from: T, reason: collision with root package name */
    public int f10177T;

    /* renamed from: U, reason: collision with root package name */
    public int f10178U;

    /* renamed from: V, reason: collision with root package name */
    public int f10179V;

    /* renamed from: W, reason: collision with root package name */
    public boolean f10180W;

    /* renamed from: X, reason: collision with root package name */
    public boolean f10181X;

    /* renamed from: Y, reason: collision with root package name */
    public String f10182Y;

    /* renamed from: Z, reason: collision with root package name */
    public int f10183Z;

    /* renamed from: a, reason: collision with root package name */
    public int f10184a;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f10185a0;

    /* renamed from: b, reason: collision with root package name */
    public int f10186b;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f10187b0;

    /* renamed from: c, reason: collision with root package name */
    public float f10188c;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f10189c0;

    /* renamed from: d, reason: collision with root package name */
    public boolean f10190d;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f10191d0;

    /* renamed from: e, reason: collision with root package name */
    public int f10192e;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f10193e0;

    /* renamed from: f, reason: collision with root package name */
    public int f10194f;

    /* renamed from: f0, reason: collision with root package name */
    public int f10195f0;
    public int g;

    /* renamed from: g0, reason: collision with root package name */
    public int f10196g0;
    public int h;

    /* renamed from: h0, reason: collision with root package name */
    public int f10197h0;

    /* renamed from: i, reason: collision with root package name */
    public int f10198i;

    /* renamed from: i0, reason: collision with root package name */
    public int f10199i0;

    /* renamed from: j, reason: collision with root package name */
    public int f10200j;

    /* renamed from: j0, reason: collision with root package name */
    public int f10201j0;

    /* renamed from: k, reason: collision with root package name */
    public int f10202k;

    /* renamed from: k0, reason: collision with root package name */
    public int f10203k0;

    /* renamed from: l, reason: collision with root package name */
    public int f10204l;

    /* renamed from: l0, reason: collision with root package name */
    public float f10205l0;

    /* renamed from: m, reason: collision with root package name */
    public int f10206m;

    /* renamed from: m0, reason: collision with root package name */
    public int f10207m0;
    public int n;

    /* renamed from: n0, reason: collision with root package name */
    public int f10208n0;

    /* renamed from: o, reason: collision with root package name */
    public int f10209o;

    /* renamed from: o0, reason: collision with root package name */
    public float f10210o0;

    /* renamed from: p, reason: collision with root package name */
    public int f10211p;

    /* renamed from: p0, reason: collision with root package name */
    public u.d f10212p0;

    /* renamed from: q, reason: collision with root package name */
    public int f10213q;

    /* renamed from: r, reason: collision with root package name */
    public float f10214r;

    /* renamed from: s, reason: collision with root package name */
    public int f10215s;

    /* renamed from: t, reason: collision with root package name */
    public int f10216t;

    /* renamed from: u, reason: collision with root package name */
    public int f10217u;

    /* renamed from: v, reason: collision with root package name */
    public int f10218v;

    /* renamed from: w, reason: collision with root package name */
    public int f10219w;

    /* renamed from: x, reason: collision with root package name */
    public int f10220x;

    /* renamed from: y, reason: collision with root package name */
    public int f10221y;

    /* renamed from: z, reason: collision with root package name */
    public int f10222z;

    public final void a() {
        this.f10191d0 = false;
        this.f10185a0 = true;
        this.f10187b0 = true;
        int i5 = ((ViewGroup.MarginLayoutParams) this).width;
        if (i5 == -2 && this.f10180W) {
            this.f10185a0 = false;
            if (this.f10169L == 0) {
                this.f10169L = 1;
            }
        }
        int i6 = ((ViewGroup.MarginLayoutParams) this).height;
        if (i6 == -2 && this.f10181X) {
            this.f10187b0 = false;
            if (this.f10170M == 0) {
                this.f10170M = 1;
            }
        }
        if (i5 == 0 || i5 == -1) {
            this.f10185a0 = false;
            if (i5 == 0 && this.f10169L == 1) {
                ((ViewGroup.MarginLayoutParams) this).width = -2;
                this.f10180W = true;
            }
        }
        if (i6 == 0 || i6 == -1) {
            this.f10187b0 = false;
            if (i6 == 0 && this.f10170M == 1) {
                ((ViewGroup.MarginLayoutParams) this).height = -2;
                this.f10181X = true;
            }
        }
        if (this.f10188c == -1.0f && this.f10184a == -1 && this.f10186b == -1) {
            return;
        }
        this.f10191d0 = true;
        this.f10185a0 = true;
        this.f10187b0 = true;
        if (!(this.f10212p0 instanceof u.h)) {
            this.f10212p0 = new u.h();
        }
        ((u.h) this.f10212p0).S(this.f10179V);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0082  */
    @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void resolveLayoutDirection(int r11) {
        /*
            Method dump skipped, instructions count: 259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x.e.resolveLayoutDirection(int):void");
    }
}
