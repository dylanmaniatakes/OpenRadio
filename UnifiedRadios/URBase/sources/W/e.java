package W;

import C0.A;
import O.Y;
import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.OverScroller;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.Arrays;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: v, reason: collision with root package name */
    public static final d f2553v = new d(0);

    /* renamed from: a, reason: collision with root package name */
    public int f2554a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2555b;

    /* renamed from: d, reason: collision with root package name */
    public float[] f2557d;

    /* renamed from: e, reason: collision with root package name */
    public float[] f2558e;

    /* renamed from: f, reason: collision with root package name */
    public float[] f2559f;
    public float[] g;
    public int[] h;

    /* renamed from: i, reason: collision with root package name */
    public int[] f2560i;

    /* renamed from: j, reason: collision with root package name */
    public int[] f2561j;

    /* renamed from: k, reason: collision with root package name */
    public int f2562k;

    /* renamed from: l, reason: collision with root package name */
    public VelocityTracker f2563l;

    /* renamed from: m, reason: collision with root package name */
    public final float f2564m;
    public final float n;

    /* renamed from: o, reason: collision with root package name */
    public final int f2565o;

    /* renamed from: p, reason: collision with root package name */
    public final OverScroller f2566p;

    /* renamed from: q, reason: collision with root package name */
    public final A2.b f2567q;

    /* renamed from: r, reason: collision with root package name */
    public View f2568r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f2569s;

    /* renamed from: t, reason: collision with root package name */
    public final ViewGroup f2570t;

    /* renamed from: c, reason: collision with root package name */
    public int f2556c = -1;

    /* renamed from: u, reason: collision with root package name */
    public final A f2571u = new A(12, this);

    public e(Context context, ViewGroup viewGroup, A2.b bVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (bVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.f2570t = viewGroup;
        this.f2567q = bVar;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f2565o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f2555b = viewConfiguration.getScaledTouchSlop();
        this.f2564m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f2566p = new OverScroller(context, f2553v);
    }

    public final void a() {
        this.f2556c = -1;
        float[] fArr = this.f2557d;
        if (fArr != null) {
            Arrays.fill(fArr, BitmapDescriptorFactory.HUE_RED);
            Arrays.fill(this.f2558e, BitmapDescriptorFactory.HUE_RED);
            Arrays.fill(this.f2559f, BitmapDescriptorFactory.HUE_RED);
            Arrays.fill(this.g, BitmapDescriptorFactory.HUE_RED);
            Arrays.fill(this.h, 0);
            Arrays.fill(this.f2560i, 0);
            Arrays.fill(this.f2561j, 0);
            this.f2562k = 0;
        }
        VelocityTracker velocityTracker = this.f2563l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f2563l = null;
        }
    }

    public final void b(View view, int i5) {
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = this.f2570t;
        if (parent != viewGroup) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + viewGroup + ")");
        }
        this.f2568r = view;
        this.f2556c = i5;
        this.f2567q.q(view, i5);
        n(1);
    }

    public final boolean c(View view, float f5, float f6) {
        if (view == null) {
            return false;
        }
        A2.b bVar = this.f2567q;
        boolean z4 = bVar.m(view) > 0;
        boolean z5 = bVar.n() > 0;
        if (!z4 || !z5) {
            return z4 ? Math.abs(f5) > ((float) this.f2555b) : z5 && Math.abs(f6) > ((float) this.f2555b);
        }
        float f7 = (f6 * f6) + (f5 * f5);
        int i5 = this.f2555b;
        return f7 > ((float) (i5 * i5));
    }

    public final void d(int i5) {
        float[] fArr = this.f2557d;
        if (fArr != null) {
            int i6 = this.f2562k;
            int i7 = 1 << i5;
            if ((i6 & i7) != 0) {
                fArr[i5] = 0.0f;
                this.f2558e[i5] = 0.0f;
                this.f2559f[i5] = 0.0f;
                this.g[i5] = 0.0f;
                this.h[i5] = 0;
                this.f2560i[i5] = 0;
                this.f2561j[i5] = 0;
                this.f2562k = (~i7) & i6;
            }
        }
    }

    public final int e(int i5, int i6, int i7) {
        if (i5 == 0) {
            return 0;
        }
        float width = this.f2570t.getWidth() / 2;
        float fSin = (((float) Math.sin((Math.min(1.0f, Math.abs(i5) / r0) - 0.5f) * 0.47123894f)) * width) + width;
        int iAbs = Math.abs(i6);
        return Math.min(iAbs > 0 ? Math.round(Math.abs(fSin / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i5) / i7) + 1.0f) * 256.0f), 600);
    }

    public final boolean f() {
        if (this.f2554a == 2) {
            OverScroller overScroller = this.f2566p;
            boolean zComputeScrollOffset = overScroller.computeScrollOffset();
            int currX = overScroller.getCurrX();
            int currY = overScroller.getCurrY();
            int left = currX - this.f2568r.getLeft();
            int top = currY - this.f2568r.getTop();
            if (left != 0) {
                View view = this.f2568r;
                WeakHashMap weakHashMap = Y.f1904a;
                view.offsetLeftAndRight(left);
            }
            if (top != 0) {
                View view2 = this.f2568r;
                WeakHashMap weakHashMap2 = Y.f1904a;
                view2.offsetTopAndBottom(top);
            }
            if (left != 0 || top != 0) {
                this.f2567q.s(this.f2568r, currX, currY);
            }
            if (zComputeScrollOffset && currX == overScroller.getFinalX() && currY == overScroller.getFinalY()) {
                overScroller.abortAnimation();
                zComputeScrollOffset = false;
            }
            if (!zComputeScrollOffset) {
                this.f2570t.post(this.f2571u);
            }
        }
        return this.f2554a == 2;
    }

    public final View g(int i5, int i6) {
        ViewGroup viewGroup = this.f2570t;
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            this.f2567q.getClass();
            View childAt = viewGroup.getChildAt(childCount);
            if (i5 >= childAt.getLeft() && i5 < childAt.getRight() && i6 >= childAt.getTop() && i6 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public final boolean h(int i5, int i6, int i7, int i8) {
        float f5;
        float f6;
        float f7;
        float f8;
        int left = this.f2568r.getLeft();
        int top = this.f2568r.getTop();
        int i9 = i5 - left;
        int i10 = i6 - top;
        OverScroller overScroller = this.f2566p;
        int i11 = 0;
        if (i9 == 0 && i10 == 0) {
            overScroller.abortAnimation();
            n(0);
            return false;
        }
        View view = this.f2568r;
        int i12 = (int) this.n;
        int i13 = (int) this.f2564m;
        int iAbs = Math.abs(i7);
        if (iAbs < i12) {
            i7 = 0;
        } else if (iAbs > i13) {
            i7 = i7 > 0 ? i13 : -i13;
        }
        int iAbs2 = Math.abs(i8);
        if (iAbs2 < i12) {
            i8 = i11;
        } else if (iAbs2 > i13) {
            if (i8 > 0) {
                i8 = i13;
            } else {
                i11 = -i13;
                i8 = i11;
            }
        }
        int iAbs3 = Math.abs(i9);
        int iAbs4 = Math.abs(i10);
        int iAbs5 = Math.abs(i7);
        int iAbs6 = Math.abs(i8);
        int i14 = iAbs5 + iAbs6;
        int i15 = iAbs3 + iAbs4;
        if (i7 != 0) {
            f5 = iAbs5;
            f6 = i14;
        } else {
            f5 = iAbs3;
            f6 = i15;
        }
        float f9 = f5 / f6;
        if (i8 != 0) {
            f7 = iAbs6;
            f8 = i14;
        } else {
            f7 = iAbs4;
            f8 = i15;
        }
        float f10 = f7 / f8;
        A2.b bVar = this.f2567q;
        overScroller.startScroll(left, top, i9, i10, (int) ((e(i10, i8, bVar.n()) * f10) + (e(i9, i7, bVar.m(view)) * f9)));
        n(2);
        return true;
    }

    public final boolean i(int i5) {
        if ((this.f2562k & (1 << i5)) != 0) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i5 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    public final void j(MotionEvent motionEvent) {
        int i5;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.f2563l == null) {
            this.f2563l = VelocityTracker.obtain();
        }
        this.f2563l.addMovement(motionEvent);
        int i6 = 0;
        if (actionMasked == 0) {
            float x4 = motionEvent.getX();
            float y4 = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View viewG = g((int) x4, (int) y4);
            l(x4, y4, pointerId);
            q(viewG, pointerId);
            int i7 = this.h[pointerId];
            return;
        }
        if (actionMasked == 1) {
            if (this.f2554a == 1) {
                k();
            }
            a();
            return;
        }
        A2.b bVar = this.f2567q;
        if (actionMasked != 2) {
            if (actionMasked == 3) {
                if (this.f2554a == 1) {
                    this.f2569s = true;
                    bVar.t(this.f2568r, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
                    this.f2569s = false;
                    if (this.f2554a == 1) {
                        n(0);
                    }
                }
                a();
                return;
            }
            if (actionMasked == 5) {
                int pointerId2 = motionEvent.getPointerId(actionIndex);
                float x5 = motionEvent.getX(actionIndex);
                float y5 = motionEvent.getY(actionIndex);
                l(x5, y5, pointerId2);
                if (this.f2554a == 0) {
                    q(g((int) x5, (int) y5), pointerId2);
                    int i8 = this.h[pointerId2];
                    return;
                }
                int i9 = (int) x5;
                int i10 = (int) y5;
                View view = this.f2568r;
                if (view != null) {
                    i6 = (i9 < view.getLeft() || i9 >= view.getRight() || i10 < view.getTop() || i10 >= view.getBottom()) ? 0 : 1;
                }
                if (i6 != 0) {
                    q(this.f2568r, pointerId2);
                    return;
                }
                return;
            }
            if (actionMasked != 6) {
                return;
            }
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            if (this.f2554a == 1 && pointerId3 == this.f2556c) {
                int pointerCount = motionEvent.getPointerCount();
                while (true) {
                    if (i6 >= pointerCount) {
                        i5 = -1;
                        break;
                    }
                    int pointerId4 = motionEvent.getPointerId(i6);
                    if (pointerId4 != this.f2556c) {
                        View viewG2 = g((int) motionEvent.getX(i6), (int) motionEvent.getY(i6));
                        View view2 = this.f2568r;
                        if (viewG2 == view2 && q(view2, pointerId4)) {
                            i5 = this.f2556c;
                            break;
                        }
                    }
                    i6++;
                }
                if (i5 == -1) {
                    k();
                }
            }
            d(pointerId3);
            return;
        }
        if (this.f2554a == 1) {
            if (i(this.f2556c)) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.f2556c);
                float x6 = motionEvent.getX(iFindPointerIndex);
                float y6 = motionEvent.getY(iFindPointerIndex);
                float[] fArr = this.f2559f;
                int i11 = this.f2556c;
                int i12 = (int) (x6 - fArr[i11]);
                int i13 = (int) (y6 - this.g[i11]);
                int left = this.f2568r.getLeft() + i12;
                int top = this.f2568r.getTop() + i13;
                int left2 = this.f2568r.getLeft();
                int top2 = this.f2568r.getTop();
                if (i12 != 0) {
                    left = bVar.d(this.f2568r, left);
                    WeakHashMap weakHashMap = Y.f1904a;
                    this.f2568r.offsetLeftAndRight(left - left2);
                }
                if (i13 != 0) {
                    top = bVar.e(this.f2568r, top);
                    WeakHashMap weakHashMap2 = Y.f1904a;
                    this.f2568r.offsetTopAndBottom(top - top2);
                }
                if (i12 != 0 || i13 != 0) {
                    bVar.s(this.f2568r, left, top);
                }
                m(motionEvent);
                return;
            }
            return;
        }
        int pointerCount2 = motionEvent.getPointerCount();
        while (i6 < pointerCount2) {
            int pointerId5 = motionEvent.getPointerId(i6);
            if (i(pointerId5)) {
                float x7 = motionEvent.getX(i6);
                float y7 = motionEvent.getY(i6);
                float f5 = x7 - this.f2557d[pointerId5];
                float f6 = y7 - this.f2558e[pointerId5];
                Math.abs(f5);
                Math.abs(f6);
                int i14 = this.h[pointerId5];
                Math.abs(f6);
                Math.abs(f5);
                int i15 = this.h[pointerId5];
                Math.abs(f5);
                Math.abs(f6);
                int i16 = this.h[pointerId5];
                Math.abs(f6);
                Math.abs(f5);
                int i17 = this.h[pointerId5];
                if (this.f2554a != 1) {
                    View viewG3 = g((int) x7, (int) y7);
                    if (c(viewG3, f5, f6) && q(viewG3, pointerId5)) {
                        break;
                    }
                } else {
                    break;
                }
            }
            i6++;
        }
        m(motionEvent);
    }

    public final void k() {
        VelocityTracker velocityTracker = this.f2563l;
        float f5 = this.f2564m;
        velocityTracker.computeCurrentVelocity(1000, f5);
        float xVelocity = this.f2563l.getXVelocity(this.f2556c);
        float f6 = this.n;
        float fAbs = Math.abs(xVelocity);
        float f7 = BitmapDescriptorFactory.HUE_RED;
        if (fAbs < f6) {
            xVelocity = 0.0f;
        } else if (fAbs > f5) {
            xVelocity = xVelocity > BitmapDescriptorFactory.HUE_RED ? f5 : -f5;
        }
        float yVelocity = this.f2563l.getYVelocity(this.f2556c);
        float fAbs2 = Math.abs(yVelocity);
        if (fAbs2 >= f6) {
            if (fAbs2 > f5) {
                if (yVelocity <= BitmapDescriptorFactory.HUE_RED) {
                    f5 = -f5;
                }
                f7 = f5;
            } else {
                f7 = yVelocity;
            }
        }
        this.f2569s = true;
        this.f2567q.t(this.f2568r, xVelocity, f7);
        this.f2569s = false;
        if (this.f2554a == 1) {
            n(0);
        }
    }

    public final void l(float f5, float f6, int i5) {
        float[] fArr = this.f2557d;
        if (fArr == null || fArr.length <= i5) {
            int i6 = i5 + 1;
            float[] fArr2 = new float[i6];
            float[] fArr3 = new float[i6];
            float[] fArr4 = new float[i6];
            float[] fArr5 = new float[i6];
            int[] iArr = new int[i6];
            int[] iArr2 = new int[i6];
            int[] iArr3 = new int[i6];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f2558e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f2559f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f2560i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f2561j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f2557d = fArr2;
            this.f2558e = fArr3;
            this.f2559f = fArr4;
            this.g = fArr5;
            this.h = iArr;
            this.f2560i = iArr2;
            this.f2561j = iArr3;
        }
        float[] fArr9 = this.f2557d;
        this.f2559f[i5] = f5;
        fArr9[i5] = f5;
        float[] fArr10 = this.f2558e;
        this.g[i5] = f6;
        fArr10[i5] = f6;
        int[] iArr7 = this.h;
        int i7 = (int) f5;
        int i8 = (int) f6;
        ViewGroup viewGroup = this.f2570t;
        int left = viewGroup.getLeft();
        int i9 = this.f2565o;
        int i10 = i7 < left + i9 ? 1 : 0;
        if (i8 < viewGroup.getTop() + i9) {
            i10 |= 4;
        }
        if (i7 > viewGroup.getRight() - i9) {
            i10 |= 2;
        }
        if (i8 > viewGroup.getBottom() - i9) {
            i10 |= 8;
        }
        iArr7[i5] = i10;
        this.f2562k |= 1 << i5;
    }

    public final void m(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i5 = 0; i5 < pointerCount; i5++) {
            int pointerId = motionEvent.getPointerId(i5);
            if (i(pointerId)) {
                float x4 = motionEvent.getX(i5);
                float y4 = motionEvent.getY(i5);
                this.f2559f[pointerId] = x4;
                this.g[pointerId] = y4;
            }
        }
    }

    public final void n(int i5) {
        this.f2570t.removeCallbacks(this.f2571u);
        if (this.f2554a != i5) {
            this.f2554a = i5;
            this.f2567q.r(i5);
            if (this.f2554a == 0) {
                this.f2568r = null;
            }
        }
    }

    public final boolean o(int i5, int i6) {
        if (this.f2569s) {
            return h(i5, i6, (int) this.f2563l.getXVelocity(this.f2556c), (int) this.f2563l.getYVelocity(this.f2556c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0114  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean p(android.view.MotionEvent r18) {
        /*
            Method dump skipped, instructions count: 323
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: W.e.p(android.view.MotionEvent):boolean");
    }

    public final boolean q(View view, int i5) {
        if (view == this.f2568r && this.f2556c == i5) {
            return true;
        }
        if (view == null || !this.f2567q.y(view, i5)) {
            return false;
        }
        this.f2556c = i5;
        b(view, i5);
        return true;
    }
}
