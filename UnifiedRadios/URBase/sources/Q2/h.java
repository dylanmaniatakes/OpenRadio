package q2;

import O.G;
import O.K;
import O.M;
import O.Y;
import X2.t;
import a0.C0204a;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import com.google.android.gms.internal.measurement.AbstractC0296a2;
import com.google.android.gms.internal.measurement.AbstractC0409x1;
import com.unified.ur1.R;
import java.util.WeakHashMap;
import n2.m;

/* loaded from: classes.dex */
public abstract class h extends FrameLayout {
    public static final g n = new g();

    /* renamed from: c, reason: collision with root package name */
    public i f9441c;

    /* renamed from: d, reason: collision with root package name */
    public final m f9442d;

    /* renamed from: e, reason: collision with root package name */
    public int f9443e;

    /* renamed from: f, reason: collision with root package name */
    public final float f9444f;
    public final float g;
    public final int h;

    /* renamed from: i, reason: collision with root package name */
    public final int f9445i;

    /* renamed from: j, reason: collision with root package name */
    public ColorStateList f9446j;

    /* renamed from: k, reason: collision with root package name */
    public PorterDuff.Mode f9447k;

    /* renamed from: l, reason: collision with root package name */
    public Rect f9448l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f9449m;

    /* JADX WARN: Multi-variable type inference failed */
    public h(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        GradientDrawable gradientDrawable;
        super(u2.a.a(context, attributeSet, 0, 0), attributeSet);
        Context context2 = getContext();
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, O1.a.f1994D);
        if (typedArrayObtainStyledAttributes.hasValue(6)) {
            float dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(6, 0);
            WeakHashMap weakHashMap = Y.f1904a;
            M.s(this, dimensionPixelSize);
        }
        this.f9443e = typedArrayObtainStyledAttributes.getInt(2, 0);
        if (typedArrayObtainStyledAttributes.hasValue(8) || typedArrayObtainStyledAttributes.hasValue(9)) {
            this.f9442d = m.b(context2, attributeSet, 0, 0).a();
        }
        this.f9444f = typedArrayObtainStyledAttributes.getFloat(3, 1.0f);
        setBackgroundTintList(AbstractC0409x1.f(context2, typedArrayObtainStyledAttributes, 4));
        setBackgroundTintMode(g2.m.k(typedArrayObtainStyledAttributes.getInt(5, -1), PorterDuff.Mode.SRC_IN));
        this.g = typedArrayObtainStyledAttributes.getFloat(1, 1.0f);
        this.h = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1);
        this.f9445i = typedArrayObtainStyledAttributes.getDimensionPixelSize(7, -1);
        typedArrayObtainStyledAttributes.recycle();
        setOnTouchListener(n);
        setFocusable(true);
        if (getBackground() == null) {
            int iH = AbstractC0296a2.h(getBackgroundOverlayColorAlpha(), AbstractC0296a2.f(this, R.attr.colorSurface), AbstractC0296a2.f(this, R.attr.colorOnSurface));
            m mVar = this.f9442d;
            if (mVar != null) {
                C0204a c0204a = i.f9452w;
                n2.h hVar = new n2.h(mVar);
                hVar.l(ColorStateList.valueOf(iH));
                gradientDrawable = hVar;
            } else {
                Resources resources = getResources();
                C0204a c0204a2 = i.f9452w;
                float dimension = resources.getDimension(R.dimen.mtrl_snackbar_background_corner_radius);
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setShape(0);
                gradientDrawable2.setCornerRadius(dimension);
                gradientDrawable2.setColor(iH);
                gradientDrawable = gradientDrawable2;
            }
            ColorStateList colorStateList = this.f9446j;
            if (colorStateList != null) {
                F.b.h(gradientDrawable, colorStateList);
            }
            WeakHashMap weakHashMap2 = Y.f1904a;
            G.q(this, gradientDrawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBaseTransientBottomBar(i iVar) {
        this.f9441c = iVar;
    }

    public float getActionTextColorAlpha() {
        return this.g;
    }

    public int getAnimationMode() {
        return this.f9443e;
    }

    public float getBackgroundOverlayColorAlpha() {
        return this.f9444f;
    }

    public int getMaxInlineActionWidth() {
        return this.f9445i;
    }

    public int getMaxWidth() {
        return this.h;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        i iVar = this.f9441c;
        if (iVar != null) {
            if (Build.VERSION.SDK_INT >= 29) {
                WindowInsets rootWindowInsets = iVar.f9462i.getRootWindowInsets();
                if (rootWindowInsets != null) {
                    iVar.f9470r = rootWindowInsets.getMandatorySystemGestureInsets().bottom;
                    iVar.f();
                }
            } else {
                iVar.getClass();
            }
        }
        WeakHashMap weakHashMap = Y.f1904a;
        K.c(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        boolean z4;
        l lVar;
        super.onDetachedFromWindow();
        i iVar = this.f9441c;
        if (iVar != null) {
            t tVarD = t.d();
            e eVar = iVar.f9474v;
            synchronized (tVarD.f2833c) {
                z4 = tVarD.g(eVar) || !((lVar = (l) tVarD.f2836f) == null || eVar == null || lVar.f9478a.get() != eVar);
            }
            if (z4) {
                i.f9455z.post(new d(iVar, 1));
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        super.onLayout(z4, i5, i6, i7, i8);
        i iVar = this.f9441c;
        if (iVar == null || !iVar.f9472t) {
            return;
        }
        iVar.e();
        iVar.f9472t = false;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
        int i7 = this.h;
        if (i7 <= 0 || getMeasuredWidth() <= i7) {
            return;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(i7, 1073741824), i6);
    }

    public void setAnimationMode(int i5) {
        this.f9443e = i5;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable != null && this.f9446j != null) {
            drawable = drawable.mutate();
            F.b.h(drawable, this.f9446j);
            F.b.i(drawable, this.f9447k);
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        this.f9446j = colorStateList;
        if (getBackground() != null) {
            Drawable drawableMutate = getBackground().mutate();
            F.b.h(drawableMutate, colorStateList);
            F.b.i(drawableMutate, this.f9447k);
            if (drawableMutate != getBackground()) {
                super.setBackgroundDrawable(drawableMutate);
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        this.f9447k = mode;
        if (getBackground() != null) {
            Drawable drawableMutate = getBackground().mutate();
            F.b.i(drawableMutate, mode);
            if (drawableMutate != getBackground()) {
                super.setBackgroundDrawable(drawableMutate);
            }
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        if (this.f9449m || !(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        this.f9448l = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        i iVar = this.f9441c;
        if (iVar != null) {
            C0204a c0204a = i.f9452w;
            iVar.f();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        setOnTouchListener(onClickListener != null ? null : n);
        super.setOnClickListener(onClickListener);
    }
}
