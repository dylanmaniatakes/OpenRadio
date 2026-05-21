package androidx.appcompat.widget;

import L0.m;
import O.Y;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import e.AbstractC0429a;
import k.C0655s0;
import k.j1;

/* loaded from: classes.dex */
public class LinearLayoutCompat extends ViewGroup {

    /* renamed from: c, reason: collision with root package name */
    public boolean f3386c;

    /* renamed from: d, reason: collision with root package name */
    public int f3387d;

    /* renamed from: e, reason: collision with root package name */
    public int f3388e;

    /* renamed from: f, reason: collision with root package name */
    public int f3389f;
    public int g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public float f3390i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f3391j;

    /* renamed from: k, reason: collision with root package name */
    public int[] f3392k;

    /* renamed from: l, reason: collision with root package name */
    public int[] f3393l;

    /* renamed from: m, reason: collision with root package name */
    public Drawable f3394m;
    public int n;

    /* renamed from: o, reason: collision with root package name */
    public int f3395o;

    /* renamed from: p, reason: collision with root package name */
    public int f3396p;

    /* renamed from: q, reason: collision with root package name */
    public int f3397q;

    public LinearLayoutCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0655s0;
    }

    public final void f(Canvas canvas, int i5) {
        this.f3394m.setBounds(getPaddingLeft() + this.f3397q, i5, (getWidth() - getPaddingRight()) - this.f3397q, this.f3395o + i5);
        this.f3394m.draw(canvas);
    }

    public final void g(Canvas canvas, int i5) {
        this.f3394m.setBounds(i5, getPaddingTop() + this.f3397q, this.n + i5, (getHeight() - getPaddingBottom()) - this.f3397q);
        this.f3394m.draw(canvas);
    }

    @Override // android.view.View
    public int getBaseline() {
        int i5;
        if (this.f3387d < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i6 = this.f3387d;
        if (childCount <= i6) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(i6);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.f3387d == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int bottom = this.f3388e;
        if (this.f3389f == 1 && (i5 = this.g & 112) != 48) {
            if (i5 == 16) {
                bottom += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.h) / 2;
            } else if (i5 == 80) {
                bottom = ((getBottom() - getTop()) - getPaddingBottom()) - this.h;
            }
        }
        return bottom + ((LinearLayout.LayoutParams) ((C0655s0) childAt.getLayoutParams())).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.f3387d;
    }

    public Drawable getDividerDrawable() {
        return this.f3394m;
    }

    public int getDividerPadding() {
        return this.f3397q;
    }

    public int getDividerWidth() {
        return this.n;
    }

    public int getGravity() {
        return this.g;
    }

    public int getOrientation() {
        return this.f3389f;
    }

    public int getShowDividers() {
        return this.f3396p;
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f3390i;
    }

    @Override // android.view.ViewGroup
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public C0655s0 generateDefaultLayoutParams() {
        int i5 = this.f3389f;
        if (i5 == 0) {
            return new C0655s0(-2, -2);
        }
        if (i5 == 1) {
            return new C0655s0(-1, -2);
        }
        return null;
    }

    @Override // android.view.ViewGroup
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C0655s0 generateLayoutParams(AttributeSet attributeSet) {
        return new C0655s0(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C0655s0 generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new C0655s0(layoutParams);
    }

    public final boolean k(int i5) {
        if (i5 == 0) {
            return (this.f3396p & 1) != 0;
        }
        if (i5 == getChildCount()) {
            return (this.f3396p & 4) != 0;
        }
        if ((this.f3396p & 2) == 0) {
            return false;
        }
        for (int i6 = i5 - 1; i6 >= 0; i6--) {
            if (getChildAt(i6).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int right;
        int left;
        int i5;
        if (this.f3394m == null) {
            return;
        }
        int i6 = 0;
        if (this.f3389f == 1) {
            int virtualChildCount = getVirtualChildCount();
            while (i6 < virtualChildCount) {
                View childAt = getChildAt(i6);
                if (childAt != null && childAt.getVisibility() != 8 && k(i6)) {
                    f(canvas, (childAt.getTop() - ((LinearLayout.LayoutParams) ((C0655s0) childAt.getLayoutParams())).topMargin) - this.f3395o);
                }
                i6++;
            }
            if (k(virtualChildCount)) {
                View childAt2 = getChildAt(virtualChildCount - 1);
                f(canvas, childAt2 == null ? (getHeight() - getPaddingBottom()) - this.f3395o : childAt2.getBottom() + ((LinearLayout.LayoutParams) ((C0655s0) childAt2.getLayoutParams())).bottomMargin);
                return;
            }
            return;
        }
        int virtualChildCount2 = getVirtualChildCount();
        boolean zA = j1.a(this);
        while (i6 < virtualChildCount2) {
            View childAt3 = getChildAt(i6);
            if (childAt3 != null && childAt3.getVisibility() != 8 && k(i6)) {
                C0655s0 c0655s0 = (C0655s0) childAt3.getLayoutParams();
                g(canvas, zA ? childAt3.getRight() + ((LinearLayout.LayoutParams) c0655s0).rightMargin : (childAt3.getLeft() - ((LinearLayout.LayoutParams) c0655s0).leftMargin) - this.n);
            }
            i6++;
        }
        if (k(virtualChildCount2)) {
            View childAt4 = getChildAt(virtualChildCount2 - 1);
            if (childAt4 != null) {
                C0655s0 c0655s02 = (C0655s0) childAt4.getLayoutParams();
                if (zA) {
                    left = childAt4.getLeft() - ((LinearLayout.LayoutParams) c0655s02).leftMargin;
                    i5 = this.n;
                    right = left - i5;
                } else {
                    right = childAt4.getRight() + ((LinearLayout.LayoutParams) c0655s02).rightMargin;
                }
            } else if (zA) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i5 = this.n;
                right = left - i5;
            }
            g(canvas, right);
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x019e  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r24, int r25, int r26, int r27, int r28) {
        /*
            Method dump skipped, instructions count: 458
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:153:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0486  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x048b  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x04b3  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x04b8  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x04c0  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x04cc  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x04de  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x04f2  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0537  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0548  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0550  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x055b  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x05e4  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x0691  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x0698  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x06b4  */
    /* JADX WARN: Removed duplicated region for block: B:368:0x07cb  */
    /* JADX WARN: Removed duplicated region for block: B:381:0x0806  */
    /* JADX WARN: Removed duplicated region for block: B:388:0x083d  */
    /* JADX WARN: Removed duplicated region for block: B:391:0x0860  */
    /* JADX WARN: Removed duplicated region for block: B:442:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r38, int r39) {
        /*
            Method dump skipped, instructions count: 2208
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.onMeasure(int, int):void");
    }

    public void setBaselineAligned(boolean z4) {
        this.f3386c = z4;
    }

    public void setBaselineAlignedChildIndex(int i5) {
        if (i5 >= 0 && i5 < getChildCount()) {
            this.f3387d = i5;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.f3394m) {
            return;
        }
        this.f3394m = drawable;
        if (drawable != null) {
            this.n = drawable.getIntrinsicWidth();
            this.f3395o = drawable.getIntrinsicHeight();
        } else {
            this.n = 0;
            this.f3395o = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i5) {
        this.f3397q = i5;
    }

    public void setGravity(int i5) {
        if (this.g != i5) {
            if ((8388615 & i5) == 0) {
                i5 |= 8388611;
            }
            if ((i5 & 112) == 0) {
                i5 |= 48;
            }
            this.g = i5;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i5) {
        int i6 = i5 & 8388615;
        int i7 = this.g;
        if ((8388615 & i7) != i6) {
            this.g = i6 | ((-8388616) & i7);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z4) {
        this.f3391j = z4;
    }

    public void setOrientation(int i5) {
        if (this.f3389f != i5) {
            this.f3389f = i5;
            requestLayout();
        }
    }

    public void setShowDividers(int i5) {
        if (i5 != this.f3396p) {
            requestLayout();
        }
        this.f3396p = i5;
    }

    public void setVerticalGravity(int i5) {
        int i6 = i5 & 112;
        int i7 = this.g;
        if ((i7 & 112) != i6) {
            this.g = i6 | (i7 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f5) {
        this.f3390i = Math.max(BitmapDescriptorFactory.HUE_RED, f5);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f3386c = true;
        this.f3387d = -1;
        this.f3388e = 0;
        this.g = 8388659;
        int[] iArr = AbstractC0429a.n;
        m mVarK = m.k(context, attributeSet, iArr, i5, 0);
        Y.j(this, context, iArr, attributeSet, (TypedArray) mVarK.f1557e, i5);
        TypedArray typedArray = (TypedArray) mVarK.f1557e;
        int i6 = typedArray.getInt(1, -1);
        if (i6 >= 0) {
            setOrientation(i6);
        }
        int i7 = typedArray.getInt(0, -1);
        if (i7 >= 0) {
            setGravity(i7);
        }
        boolean z4 = typedArray.getBoolean(2, true);
        if (!z4) {
            setBaselineAligned(z4);
        }
        this.f3390i = typedArray.getFloat(4, -1.0f);
        this.f3387d = typedArray.getInt(3, -1);
        this.f3391j = typedArray.getBoolean(7, false);
        setDividerDrawable(mVarK.g(5));
        this.f3396p = typedArray.getInt(8, 0);
        this.f3397q = typedArray.getDimensionPixelSize(6, 0);
        mVarK.n();
    }
}
