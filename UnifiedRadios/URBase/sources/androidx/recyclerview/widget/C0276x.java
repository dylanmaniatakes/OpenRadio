package androidx.recyclerview.widget;

import android.R;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* renamed from: androidx.recyclerview.widget.x, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0276x extends U {

    /* renamed from: C, reason: collision with root package name */
    public static final int[] f4361C = {R.attr.state_pressed};

    /* renamed from: D, reason: collision with root package name */
    public static final int[] f4362D = new int[0];

    /* renamed from: A, reason: collision with root package name */
    public int f4363A;

    /* renamed from: B, reason: collision with root package name */
    public final RunnableC0272t f4364B;

    /* renamed from: a, reason: collision with root package name */
    public final int f4365a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4366b;

    /* renamed from: c, reason: collision with root package name */
    public final StateListDrawable f4367c;

    /* renamed from: d, reason: collision with root package name */
    public final Drawable f4368d;

    /* renamed from: e, reason: collision with root package name */
    public final int f4369e;

    /* renamed from: f, reason: collision with root package name */
    public final int f4370f;
    public final StateListDrawable g;
    public final Drawable h;

    /* renamed from: i, reason: collision with root package name */
    public final int f4371i;

    /* renamed from: j, reason: collision with root package name */
    public final int f4372j;

    /* renamed from: k, reason: collision with root package name */
    public int f4373k;

    /* renamed from: l, reason: collision with root package name */
    public int f4374l;

    /* renamed from: m, reason: collision with root package name */
    public float f4375m;
    public int n;

    /* renamed from: o, reason: collision with root package name */
    public int f4376o;

    /* renamed from: p, reason: collision with root package name */
    public float f4377p;

    /* renamed from: s, reason: collision with root package name */
    public final RecyclerView f4380s;

    /* renamed from: z, reason: collision with root package name */
    public final ValueAnimator f4387z;

    /* renamed from: q, reason: collision with root package name */
    public int f4378q = 0;

    /* renamed from: r, reason: collision with root package name */
    public int f4379r = 0;

    /* renamed from: t, reason: collision with root package name */
    public boolean f4381t = false;

    /* renamed from: u, reason: collision with root package name */
    public boolean f4382u = false;

    /* renamed from: v, reason: collision with root package name */
    public int f4383v = 0;

    /* renamed from: w, reason: collision with root package name */
    public int f4384w = 0;

    /* renamed from: x, reason: collision with root package name */
    public final int[] f4385x = new int[2];

    /* renamed from: y, reason: collision with root package name */
    public final int[] f4386y = new int[2];

    public C0276x(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i5, int i6, int i7) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(BitmapDescriptorFactory.HUE_RED, 1.0f);
        this.f4387z = valueAnimatorOfFloat;
        this.f4363A = 0;
        RunnableC0272t runnableC0272t = new RunnableC0272t(0, this);
        this.f4364B = runnableC0272t;
        C0273u c0273u = new C0273u(this);
        this.f4367c = stateListDrawable;
        this.f4368d = drawable;
        this.g = stateListDrawable2;
        this.h = drawable2;
        this.f4369e = Math.max(i5, stateListDrawable.getIntrinsicWidth());
        this.f4370f = Math.max(i5, drawable.getIntrinsicWidth());
        this.f4371i = Math.max(i5, stateListDrawable2.getIntrinsicWidth());
        this.f4372j = Math.max(i5, drawable2.getIntrinsicWidth());
        this.f4365a = i6;
        this.f4366b = i7;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        valueAnimatorOfFloat.addListener(new C0274v(this));
        valueAnimatorOfFloat.addUpdateListener(new C0275w(this));
        RecyclerView recyclerView2 = this.f4380s;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            X x4 = recyclerView2.f4125p;
            if (x4 != null) {
                x4.c("Cannot remove item decoration during a scroll  or layout");
            }
            ArrayList arrayList = recyclerView2.f4129r;
            arrayList.remove(this);
            if (arrayList.isEmpty()) {
                recyclerView2.setWillNotDraw(recyclerView2.getOverScrollMode() == 2);
            }
            recyclerView2.R();
            recyclerView2.requestLayout();
            RecyclerView recyclerView3 = this.f4380s;
            recyclerView3.f4131s.remove(this);
            if (recyclerView3.f4133t == this) {
                recyclerView3.f4133t = null;
            }
            ArrayList arrayList2 = this.f4380s.f4119l0;
            if (arrayList2 != null) {
                arrayList2.remove(c0273u);
            }
            this.f4380s.removeCallbacks(runnableC0272t);
        }
        this.f4380s = recyclerView;
        if (recyclerView != null) {
            recyclerView.i(this);
            this.f4380s.f4131s.add(this);
            this.f4380s.j(c0273u);
        }
    }

    public static int e(float f5, float f6, int[] iArr, int i5, int i6, int i7) {
        int i8 = iArr[1] - iArr[0];
        if (i8 == 0) {
            return 0;
        }
        int i9 = i5 - i7;
        int i10 = (int) (((f6 - f5) / i8) * i9);
        int i11 = i6 + i10;
        if (i11 >= i9 || i11 < 0) {
            return 0;
        }
        return i10;
    }

    @Override // androidx.recyclerview.widget.U
    public final void b(Canvas canvas, RecyclerView recyclerView) {
        int i5 = this.f4378q;
        RecyclerView recyclerView2 = this.f4380s;
        if (i5 != recyclerView2.getWidth() || this.f4379r != recyclerView2.getHeight()) {
            this.f4378q = recyclerView2.getWidth();
            this.f4379r = recyclerView2.getHeight();
            f(0);
            return;
        }
        if (this.f4363A != 0) {
            if (this.f4381t) {
                int i6 = this.f4378q;
                int i7 = this.f4369e;
                int i8 = i6 - i7;
                int i9 = this.f4374l;
                int i10 = this.f4373k;
                int i11 = i9 - (i10 / 2);
                StateListDrawable stateListDrawable = this.f4367c;
                stateListDrawable.setBounds(0, 0, i7, i10);
                int i12 = this.f4379r;
                int i13 = this.f4370f;
                Drawable drawable = this.f4368d;
                drawable.setBounds(0, 0, i13, i12);
                WeakHashMap weakHashMap = O.Y.f1904a;
                if (O.H.d(recyclerView2) == 1) {
                    drawable.draw(canvas);
                    canvas.translate(i7, i11);
                    canvas.scale(-1.0f, 1.0f);
                    stateListDrawable.draw(canvas);
                    canvas.scale(-1.0f, 1.0f);
                    canvas.translate(-i7, -i11);
                } else {
                    canvas.translate(i8, BitmapDescriptorFactory.HUE_RED);
                    drawable.draw(canvas);
                    canvas.translate(BitmapDescriptorFactory.HUE_RED, i11);
                    stateListDrawable.draw(canvas);
                    canvas.translate(-i8, -i11);
                }
            }
            if (this.f4382u) {
                int i14 = this.f4379r;
                int i15 = this.f4371i;
                int i16 = i14 - i15;
                int i17 = this.f4376o;
                int i18 = this.n;
                int i19 = i17 - (i18 / 2);
                StateListDrawable stateListDrawable2 = this.g;
                stateListDrawable2.setBounds(0, 0, i18, i15);
                int i20 = this.f4378q;
                int i21 = this.f4372j;
                Drawable drawable2 = this.h;
                drawable2.setBounds(0, 0, i20, i21);
                canvas.translate(BitmapDescriptorFactory.HUE_RED, i16);
                drawable2.draw(canvas);
                canvas.translate(i19, BitmapDescriptorFactory.HUE_RED);
                stateListDrawable2.draw(canvas);
                canvas.translate(-i19, -i16);
            }
        }
    }

    public final boolean c(float f5, float f6) {
        if (f6 >= this.f4379r - this.f4371i) {
            int i5 = this.f4376o;
            int i6 = this.n;
            if (f5 >= i5 - (i6 / 2) && f5 <= (i6 / 2) + i5) {
                return true;
            }
        }
        return false;
    }

    public final boolean d(float f5, float f6) {
        RecyclerView recyclerView = this.f4380s;
        WeakHashMap weakHashMap = O.Y.f1904a;
        boolean z4 = O.H.d(recyclerView) == 1;
        int i5 = this.f4369e;
        if (z4) {
            if (f5 > i5) {
                return false;
            }
        } else if (f5 < this.f4378q - i5) {
            return false;
        }
        int i6 = this.f4374l;
        int i7 = this.f4373k / 2;
        return f6 >= ((float) (i6 - i7)) && f6 <= ((float) (i7 + i6));
    }

    public final void f(int i5) {
        RunnableC0272t runnableC0272t = this.f4364B;
        StateListDrawable stateListDrawable = this.f4367c;
        if (i5 == 2 && this.f4383v != 2) {
            stateListDrawable.setState(f4361C);
            this.f4380s.removeCallbacks(runnableC0272t);
        }
        if (i5 == 0) {
            this.f4380s.invalidate();
        } else {
            g();
        }
        if (this.f4383v == 2 && i5 != 2) {
            stateListDrawable.setState(f4362D);
            this.f4380s.removeCallbacks(runnableC0272t);
            this.f4380s.postDelayed(runnableC0272t, 1200);
        } else if (i5 == 1) {
            this.f4380s.removeCallbacks(runnableC0272t);
            this.f4380s.postDelayed(runnableC0272t, 1500);
        }
        this.f4383v = i5;
    }

    public final void g() {
        int i5 = this.f4363A;
        ValueAnimator valueAnimator = this.f4387z;
        if (i5 != 0) {
            if (i5 != 3) {
                return;
            } else {
                valueAnimator.cancel();
            }
        }
        this.f4363A = 1;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        valueAnimator.setDuration(500L);
        valueAnimator.setStartDelay(0L);
        valueAnimator.start();
    }
}
