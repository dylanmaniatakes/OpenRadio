package androidx.appcompat.widget;

import O.G;
import O.Y;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.unified.ur1.R;
import e.AbstractC0429a;
import java.util.WeakHashMap;
import k.C0619a;
import k.J0;

/* loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: c, reason: collision with root package name */
    public boolean f3312c;

    /* renamed from: d, reason: collision with root package name */
    public View f3313d;

    /* renamed from: e, reason: collision with root package name */
    public View f3314e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f3315f;
    public Drawable g;
    public Drawable h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f3316i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f3317j;

    /* renamed from: k, reason: collision with root package name */
    public final int f3318k;

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C0619a c0619a = new C0619a(this);
        WeakHashMap weakHashMap = Y.f1904a;
        G.q(this, c0619a);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0429a.f6115a);
        boolean z4 = false;
        this.f3315f = typedArrayObtainStyledAttributes.getDrawable(0);
        this.g = typedArrayObtainStyledAttributes.getDrawable(2);
        this.f3318k = typedArrayObtainStyledAttributes.getDimensionPixelSize(13, -1);
        if (getId() == R.id.split_action_bar) {
            this.f3316i = true;
            this.h = typedArrayObtainStyledAttributes.getDrawable(1);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!this.f3316i ? !(this.f3315f != null || this.g != null) : this.h == null) {
            z4 = true;
        }
        setWillNotDraw(z4);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f3315f;
        if (drawable != null && drawable.isStateful()) {
            this.f3315f.setState(getDrawableState());
        }
        Drawable drawable2 = this.g;
        if (drawable2 != null && drawable2.isStateful()) {
            this.g.setState(getDrawableState());
        }
        Drawable drawable3 = this.h;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.h.setState(getDrawableState());
    }

    public View getTabContainer() {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f3315f;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.g;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.h;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f3313d = findViewById(R.id.action_bar);
        this.f3314e = findViewById(R.id.action_context_bar);
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f3312c || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        super.onLayout(z4, i5, i6, i7, i8);
        boolean z5 = true;
        if (this.f3316i) {
            Drawable drawable = this.h;
            if (drawable != null) {
                drawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z5 = false;
            }
        } else {
            if (this.f3315f == null) {
                z5 = false;
            } else if (this.f3313d.getVisibility() == 0) {
                this.f3315f.setBounds(this.f3313d.getLeft(), this.f3313d.getTop(), this.f3313d.getRight(), this.f3313d.getBottom());
            } else {
                View view = this.f3314e;
                if (view == null || view.getVisibility() != 0) {
                    this.f3315f.setBounds(0, 0, 0, 0);
                } else {
                    this.f3315f.setBounds(this.f3314e.getLeft(), this.f3314e.getTop(), this.f3314e.getRight(), this.f3314e.getBottom());
                }
            }
            this.f3317j = false;
        }
        if (z5) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i5, int i6) {
        int i7;
        if (this.f3313d == null && View.MeasureSpec.getMode(i6) == Integer.MIN_VALUE && (i7 = this.f3318k) >= 0) {
            i6 = View.MeasureSpec.makeMeasureSpec(Math.min(i7, View.MeasureSpec.getSize(i6)), Integer.MIN_VALUE);
        }
        super.onMeasure(i5, i6);
        if (this.f3313d == null) {
            return;
        }
        View.MeasureSpec.getMode(i6);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f3315f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f3315f);
        }
        this.f3315f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f3313d;
            if (view != null) {
                this.f3315f.setBounds(view.getLeft(), this.f3313d.getTop(), this.f3313d.getRight(), this.f3313d.getBottom());
            }
        }
        boolean z4 = false;
        if (!this.f3316i ? !(this.f3315f != null || this.g != null) : this.h == null) {
            z4 = true;
        }
        setWillNotDraw(z4);
        invalidate();
        invalidateOutline();
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.h;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.h);
        }
        this.h = drawable;
        boolean z4 = this.f3316i;
        boolean z5 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (z4 && (drawable2 = this.h) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!z4 ? !(this.f3315f != null || this.g != null) : this.h == null) {
            z5 = true;
        }
        setWillNotDraw(z5);
        invalidate();
        invalidateOutline();
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2 = this.g;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.g);
        }
        this.g = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f3317j && this.g != null) {
                throw null;
            }
        }
        boolean z4 = false;
        if (!this.f3316i ? !(this.f3315f != null || this.g != null) : this.h == null) {
            z4 = true;
        }
        setWillNotDraw(z4);
        invalidate();
        invalidateOutline();
    }

    public void setTabContainer(J0 j02) {
    }

    public void setTransitioning(boolean z4) {
        this.f3312c = z4;
        setDescendantFocusability(z4 ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i5) {
        super.setVisibility(i5);
        boolean z4 = i5 == 0;
        Drawable drawable = this.f3315f;
        if (drawable != null) {
            drawable.setVisible(z4, false);
        }
        Drawable drawable2 = this.g;
        if (drawable2 != null) {
            drawable2.setVisible(z4, false);
        }
        Drawable drawable3 = this.h;
        if (drawable3 != null) {
            drawable3.setVisible(z4, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        Drawable drawable2 = this.f3315f;
        boolean z4 = this.f3316i;
        return (drawable == drawable2 && !z4) || (drawable == this.g && this.f3317j) || ((drawable == this.h && z4) || super.verifyDrawable(drawable));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i5) {
        if (i5 != 0) {
            return super.startActionModeForChild(view, callback, i5);
        }
        return null;
    }
}
