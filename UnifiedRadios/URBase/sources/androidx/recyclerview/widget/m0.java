package androidx.recyclerview.widget;

import android.view.animation.Interpolator;
import android.widget.OverScroller;
import java.util.Arrays;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class m0 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public int f4289j;

    /* renamed from: k, reason: collision with root package name */
    public int f4290k;

    /* renamed from: l, reason: collision with root package name */
    public OverScroller f4291l;

    /* renamed from: m, reason: collision with root package name */
    public Interpolator f4292m;
    public boolean n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f4293o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f4294p;

    public m0(RecyclerView recyclerView) {
        this.f4294p = recyclerView;
        W.d dVar = RecyclerView.f4074K0;
        this.f4292m = dVar;
        this.n = false;
        this.f4293o = false;
        this.f4291l = new OverScroller(recyclerView.getContext(), dVar);
    }

    public final void a(int i5, int i6) {
        RecyclerView recyclerView = this.f4294p;
        recyclerView.setScrollState(2);
        this.f4290k = 0;
        this.f4289j = 0;
        Interpolator interpolator = this.f4292m;
        W.d dVar = RecyclerView.f4074K0;
        if (interpolator != dVar) {
            this.f4292m = dVar;
            this.f4291l = new OverScroller(recyclerView.getContext(), dVar);
        }
        this.f4291l.fling(0, 0, i5, i6, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        b();
    }

    public final void b() {
        if (this.n) {
            this.f4293o = true;
            return;
        }
        RecyclerView recyclerView = this.f4294p;
        recyclerView.removeCallbacks(this);
        WeakHashMap weakHashMap = O.Y.f1904a;
        O.G.m(recyclerView, this);
    }

    public final void c(int i5, int i6, int i7, Interpolator interpolator) {
        RecyclerView recyclerView = this.f4294p;
        if (i7 == Integer.MIN_VALUE) {
            int iAbs = Math.abs(i5);
            int iAbs2 = Math.abs(i6);
            boolean z4 = iAbs > iAbs2;
            int width = z4 ? recyclerView.getWidth() : recyclerView.getHeight();
            if (!z4) {
                iAbs = iAbs2;
            }
            i7 = Math.min((int) (((iAbs / width) + 1.0f) * 300.0f), 2000);
        }
        int i8 = i7;
        if (interpolator == null) {
            interpolator = RecyclerView.f4074K0;
        }
        if (this.f4292m != interpolator) {
            this.f4292m = interpolator;
            this.f4291l = new OverScroller(recyclerView.getContext(), interpolator);
        }
        this.f4290k = 0;
        this.f4289j = 0;
        recyclerView.setScrollState(2);
        this.f4291l.startScroll(0, 0, i5, i6, i8);
        b();
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i5;
        int i6;
        int i7;
        int i8;
        RecyclerView recyclerView = this.f4294p;
        if (recyclerView.f4125p == null) {
            recyclerView.removeCallbacks(this);
            this.f4291l.abortAnimation();
            return;
        }
        this.f4293o = false;
        this.n = true;
        recyclerView.p();
        OverScroller overScroller = this.f4291l;
        if (overScroller.computeScrollOffset()) {
            int currX = overScroller.getCurrX();
            int currY = overScroller.getCurrY();
            int i9 = currX - this.f4289j;
            int i10 = currY - this.f4290k;
            this.f4289j = currX;
            this.f4290k = currY;
            int iO = RecyclerView.o(i9, recyclerView.f4087K, recyclerView.f4089M, recyclerView.getWidth());
            int iO2 = RecyclerView.o(i10, recyclerView.f4088L, recyclerView.f4090N, recyclerView.getHeight());
            int[] iArr = recyclerView.v0;
            iArr[0] = 0;
            iArr[1] = 0;
            boolean zV = recyclerView.v(iO, iO2, 1, iArr, null);
            int[] iArr2 = recyclerView.v0;
            if (zV) {
                iO -= iArr2[0];
                iO2 -= iArr2[1];
            }
            if (recyclerView.getOverScrollMode() != 2) {
                recyclerView.n(iO, iO2);
            }
            if (recyclerView.f4123o != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
                recyclerView.f0(iO, iO2, iArr2);
                int i11 = iArr2[0];
                int i12 = iArr2[1];
                int i13 = iO - i11;
                int i14 = iO2 - i12;
                G g = recyclerView.f4125p.f4182e;
                if (g != null && !g.f4024d && g.f4025e) {
                    int iB = recyclerView.f4115j0.b();
                    if (iB == 0) {
                        g.i();
                    } else if (g.f4021a >= iB) {
                        g.f4021a = iB - 1;
                        g.g(i11, i12);
                    } else {
                        g.g(i11, i12);
                    }
                }
                i8 = i11;
                i5 = i13;
                i6 = i14;
                i7 = i12;
            } else {
                i5 = iO;
                i6 = iO2;
                i7 = 0;
                i8 = 0;
            }
            if (!recyclerView.f4129r.isEmpty()) {
                recyclerView.invalidate();
            }
            int[] iArr3 = recyclerView.v0;
            iArr3[0] = 0;
            iArr3[1] = 0;
            int i15 = i7;
            recyclerView.w(i8, i7, i5, i6, null, 1, iArr3);
            int i16 = i5 - iArr2[0];
            int i17 = i6 - iArr2[1];
            if (i8 != 0 || i15 != 0) {
                recyclerView.x(i8, i15);
            }
            if (!recyclerView.awakenScrollBars()) {
                recyclerView.invalidate();
            }
            boolean z4 = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i16 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i17 != 0));
            G g5 = recyclerView.f4125p.f4182e;
            if ((g5 == null || !g5.f4024d) && z4) {
                if (recyclerView.getOverScrollMode() != 2) {
                    int currVelocity = (int) overScroller.getCurrVelocity();
                    int i18 = i16 < 0 ? -currVelocity : i16 > 0 ? currVelocity : 0;
                    if (i17 < 0) {
                        currVelocity = -currVelocity;
                    } else if (i17 <= 0) {
                        currVelocity = 0;
                    }
                    if (i18 < 0) {
                        recyclerView.z();
                        if (recyclerView.f4087K.isFinished()) {
                            recyclerView.f4087K.onAbsorb(-i18);
                        }
                    } else if (i18 > 0) {
                        recyclerView.A();
                        if (recyclerView.f4089M.isFinished()) {
                            recyclerView.f4089M.onAbsorb(i18);
                        }
                    }
                    if (currVelocity < 0) {
                        recyclerView.B();
                        if (recyclerView.f4088L.isFinished()) {
                            recyclerView.f4088L.onAbsorb(-currVelocity);
                        }
                    } else if (currVelocity > 0) {
                        recyclerView.y();
                        if (recyclerView.f4090N.isFinished()) {
                            recyclerView.f4090N.onAbsorb(currVelocity);
                        }
                    }
                    if (i18 != 0 || currVelocity != 0) {
                        WeakHashMap weakHashMap = O.Y.f1904a;
                        O.G.k(recyclerView);
                    }
                }
                if (RecyclerView.f4072I0) {
                    Q1.b bVar = recyclerView.f4113i0;
                    int[] iArr4 = (int[]) bVar.f2171d;
                    if (iArr4 != null) {
                        Arrays.fill(iArr4, -1);
                    }
                    bVar.f2170c = 0;
                }
            } else {
                b();
                RunnableC0278z runnableC0278z = recyclerView.f4111h0;
                if (runnableC0278z != null) {
                    runnableC0278z.a(recyclerView, i8, i15);
                }
            }
        }
        G g6 = recyclerView.f4125p.f4182e;
        if (g6 != null && g6.f4024d) {
            g6.g(0, 0);
        }
        this.n = false;
        if (!this.f4293o) {
            recyclerView.setScrollState(0);
            recyclerView.m0(1);
        } else {
            recyclerView.removeCallbacks(this);
            WeakHashMap weakHashMap2 = O.Y.f1904a;
            O.G.m(recyclerView, this);
        }
    }
}
