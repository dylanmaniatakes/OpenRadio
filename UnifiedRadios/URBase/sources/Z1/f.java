package Z1;

import F.i;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.material.chip.Chip;
import g2.C0546j;
import g2.InterfaceC0545i;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import l2.AbstractC0742a;
import n2.C0802a;
import n2.g;
import n2.h;
import n2.l;

/* loaded from: classes.dex */
public final class f extends h implements Drawable.Callback, InterfaceC0545i {

    /* renamed from: I0, reason: collision with root package name */
    public static final int[] f3081I0 = {R.attr.state_enabled};

    /* renamed from: J0, reason: collision with root package name */
    public static final ShapeDrawable f3082J0 = new ShapeDrawable(new OvalShape());

    /* renamed from: A, reason: collision with root package name */
    public ColorStateList f3083A;

    /* renamed from: A0, reason: collision with root package name */
    public int[] f3084A0;

    /* renamed from: B, reason: collision with root package name */
    public float f3085B;

    /* renamed from: B0, reason: collision with root package name */
    public boolean f3086B0;

    /* renamed from: C, reason: collision with root package name */
    public float f3087C;

    /* renamed from: C0, reason: collision with root package name */
    public ColorStateList f3088C0;

    /* renamed from: D, reason: collision with root package name */
    public ColorStateList f3089D;

    /* renamed from: D0, reason: collision with root package name */
    public WeakReference f3090D0;

    /* renamed from: E, reason: collision with root package name */
    public float f3091E;

    /* renamed from: E0, reason: collision with root package name */
    public TextUtils.TruncateAt f3092E0;

    /* renamed from: F, reason: collision with root package name */
    public ColorStateList f3093F;

    /* renamed from: F0, reason: collision with root package name */
    public boolean f3094F0;

    /* renamed from: G, reason: collision with root package name */
    public CharSequence f3095G;

    /* renamed from: G0, reason: collision with root package name */
    public int f3096G0;

    /* renamed from: H, reason: collision with root package name */
    public boolean f3097H;

    /* renamed from: H0, reason: collision with root package name */
    public boolean f3098H0;
    public Drawable I;

    /* renamed from: J, reason: collision with root package name */
    public ColorStateList f3099J;

    /* renamed from: K, reason: collision with root package name */
    public float f3100K;

    /* renamed from: L, reason: collision with root package name */
    public boolean f3101L;

    /* renamed from: M, reason: collision with root package name */
    public boolean f3102M;

    /* renamed from: N, reason: collision with root package name */
    public Drawable f3103N;

    /* renamed from: O, reason: collision with root package name */
    public RippleDrawable f3104O;

    /* renamed from: P, reason: collision with root package name */
    public ColorStateList f3105P;

    /* renamed from: Q, reason: collision with root package name */
    public float f3106Q;

    /* renamed from: R, reason: collision with root package name */
    public SpannableStringBuilder f3107R;

    /* renamed from: S, reason: collision with root package name */
    public boolean f3108S;

    /* renamed from: T, reason: collision with root package name */
    public boolean f3109T;

    /* renamed from: U, reason: collision with root package name */
    public Drawable f3110U;

    /* renamed from: V, reason: collision with root package name */
    public ColorStateList f3111V;

    /* renamed from: W, reason: collision with root package name */
    public P1.d f3112W;

    /* renamed from: X, reason: collision with root package name */
    public P1.d f3113X;

    /* renamed from: Y, reason: collision with root package name */
    public float f3114Y;

    /* renamed from: Z, reason: collision with root package name */
    public float f3115Z;

    /* renamed from: a0, reason: collision with root package name */
    public float f3116a0;

    /* renamed from: b0, reason: collision with root package name */
    public float f3117b0;

    /* renamed from: c0, reason: collision with root package name */
    public float f3118c0;

    /* renamed from: d0, reason: collision with root package name */
    public float f3119d0;

    /* renamed from: e0, reason: collision with root package name */
    public float f3120e0;

    /* renamed from: f0, reason: collision with root package name */
    public float f3121f0;

    /* renamed from: g0, reason: collision with root package name */
    public final Context f3122g0;

    /* renamed from: h0, reason: collision with root package name */
    public final Paint f3123h0;

    /* renamed from: i0, reason: collision with root package name */
    public final Paint.FontMetrics f3124i0;

    /* renamed from: j0, reason: collision with root package name */
    public final RectF f3125j0;

    /* renamed from: k0, reason: collision with root package name */
    public final PointF f3126k0;

    /* renamed from: l0, reason: collision with root package name */
    public final Path f3127l0;

    /* renamed from: m0, reason: collision with root package name */
    public final C0546j f3128m0;

    /* renamed from: n0, reason: collision with root package name */
    public int f3129n0;

    /* renamed from: o0, reason: collision with root package name */
    public int f3130o0;

    /* renamed from: p0, reason: collision with root package name */
    public int f3131p0;

    /* renamed from: q0, reason: collision with root package name */
    public int f3132q0;

    /* renamed from: r0, reason: collision with root package name */
    public int f3133r0;

    /* renamed from: s0, reason: collision with root package name */
    public int f3134s0;

    /* renamed from: t0, reason: collision with root package name */
    public boolean f3135t0;

    /* renamed from: u0, reason: collision with root package name */
    public int f3136u0;
    public int v0;

    /* renamed from: w0, reason: collision with root package name */
    public ColorFilter f3137w0;

    /* renamed from: x0, reason: collision with root package name */
    public PorterDuffColorFilter f3138x0;

    /* renamed from: y0, reason: collision with root package name */
    public ColorStateList f3139y0;

    /* renamed from: z, reason: collision with root package name */
    public ColorStateList f3140z;
    public PorterDuff.Mode z0;

    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, com.unified.ur1.R.attr.chipStyle, com.unified.ur1.R.style.Widget_MaterialComponents_Chip_Action);
        this.f3087C = -1.0f;
        this.f3123h0 = new Paint(1);
        this.f3124i0 = new Paint.FontMetrics();
        this.f3125j0 = new RectF();
        this.f3126k0 = new PointF();
        this.f3127l0 = new Path();
        this.v0 = 255;
        this.z0 = PorterDuff.Mode.SRC_IN;
        this.f3090D0 = new WeakReference(null);
        j(context);
        this.f3122g0 = context;
        C0546j c0546j = new C0546j(this);
        this.f3128m0 = c0546j;
        this.f3095G = "";
        c0546j.f6940a.density = context.getResources().getDisplayMetrics().density;
        int[] iArr = f3081I0;
        setState(iArr);
        if (!Arrays.equals(this.f3084A0, iArr)) {
            this.f3084A0 = iArr;
            if (W()) {
                z(getState(), iArr);
            }
        }
        this.f3094F0 = true;
        f3082J0.setTint(-1);
    }

    public static void X(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public static boolean w(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    public static boolean x(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    public final void A(boolean z4) {
        if (this.f3108S != z4) {
            this.f3108S = z4;
            float fT = t();
            if (!z4 && this.f3135t0) {
                this.f3135t0 = false;
            }
            float fT2 = t();
            invalidateSelf();
            if (fT != fT2) {
                y();
            }
        }
    }

    public final void B(Drawable drawable) {
        if (this.f3110U != drawable) {
            float fT = t();
            this.f3110U = drawable;
            float fT2 = t();
            X(this.f3110U);
            r(this.f3110U);
            invalidateSelf();
            if (fT != fT2) {
                y();
            }
        }
    }

    public final void C(ColorStateList colorStateList) {
        Drawable drawable;
        if (this.f3111V != colorStateList) {
            this.f3111V = colorStateList;
            if (this.f3109T && (drawable = this.f3110U) != null && this.f3108S) {
                F.b.h(drawable, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void D(boolean z4) {
        if (this.f3109T != z4) {
            boolean zU = U();
            this.f3109T = z4;
            boolean zU2 = U();
            if (zU != zU2) {
                if (zU2) {
                    r(this.f3110U);
                } else {
                    X(this.f3110U);
                }
                invalidateSelf();
                y();
            }
        }
    }

    public final void E(float f5) {
        if (this.f3087C != f5) {
            this.f3087C = f5;
            l lVarE = this.f8806c.f8787a.e();
            lVarE.f8832e = new C0802a(f5);
            lVarE.f8833f = new C0802a(f5);
            lVarE.g = new C0802a(f5);
            lVarE.h = new C0802a(f5);
            setShapeAppearanceModel(lVarE.a());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void F(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.I;
        if (drawable3 != 0) {
            boolean z4 = drawable3 instanceof F.h;
            drawable2 = drawable3;
            if (z4) {
                ((i) ((F.h) drawable3)).getClass();
                drawable2 = null;
            }
        } else {
            drawable2 = null;
        }
        if (drawable2 != drawable) {
            float fT = t();
            this.I = drawable != null ? drawable.mutate() : null;
            float fT2 = t();
            X(drawable2);
            if (V()) {
                r(this.I);
            }
            invalidateSelf();
            if (fT != fT2) {
                y();
            }
        }
    }

    public final void G(float f5) {
        if (this.f3100K != f5) {
            float fT = t();
            this.f3100K = f5;
            float fT2 = t();
            invalidateSelf();
            if (fT != fT2) {
                y();
            }
        }
    }

    public final void H(ColorStateList colorStateList) {
        this.f3101L = true;
        if (this.f3099J != colorStateList) {
            this.f3099J = colorStateList;
            if (V()) {
                F.b.h(this.I, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void I(boolean z4) {
        if (this.f3097H != z4) {
            boolean zV = V();
            this.f3097H = z4;
            boolean zV2 = V();
            if (zV != zV2) {
                if (zV2) {
                    r(this.I);
                } else {
                    X(this.I);
                }
                invalidateSelf();
                y();
            }
        }
    }

    public final void J(ColorStateList colorStateList) {
        if (this.f3089D != colorStateList) {
            this.f3089D = colorStateList;
            if (this.f3098H0) {
                n(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void K(float f5) {
        if (this.f3091E != f5) {
            this.f3091E = f5;
            this.f3123h0.setStrokeWidth(f5);
            if (this.f3098H0) {
                this.f8806c.f8795k = f5;
                invalidateSelf();
            }
            invalidateSelf();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void L(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f3103N;
        if (drawable3 != 0) {
            boolean z4 = drawable3 instanceof F.h;
            drawable2 = drawable3;
            if (z4) {
                ((i) ((F.h) drawable3)).getClass();
                drawable2 = null;
            }
        } else {
            drawable2 = null;
        }
        if (drawable2 != drawable) {
            float fU = u();
            this.f3103N = drawable != null ? drawable.mutate() : null;
            this.f3104O = new RippleDrawable(AbstractC0742a.b(this.f3093F), this.f3103N, f3082J0);
            float fU2 = u();
            X(drawable2);
            if (W()) {
                r(this.f3103N);
            }
            invalidateSelf();
            if (fU != fU2) {
                y();
            }
        }
    }

    public final void M(float f5) {
        if (this.f3120e0 != f5) {
            this.f3120e0 = f5;
            invalidateSelf();
            if (W()) {
                y();
            }
        }
    }

    public final void N(float f5) {
        if (this.f3106Q != f5) {
            this.f3106Q = f5;
            invalidateSelf();
            if (W()) {
                y();
            }
        }
    }

    public final void O(float f5) {
        if (this.f3119d0 != f5) {
            this.f3119d0 = f5;
            invalidateSelf();
            if (W()) {
                y();
            }
        }
    }

    public final void P(ColorStateList colorStateList) {
        if (this.f3105P != colorStateList) {
            this.f3105P = colorStateList;
            if (W()) {
                F.b.h(this.f3103N, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void Q(boolean z4) {
        if (this.f3102M != z4) {
            boolean zW = W();
            this.f3102M = z4;
            boolean zW2 = W();
            if (zW != zW2) {
                if (zW2) {
                    r(this.f3103N);
                } else {
                    X(this.f3103N);
                }
                invalidateSelf();
                y();
            }
        }
    }

    public final void R(float f5) {
        if (this.f3116a0 != f5) {
            float fT = t();
            this.f3116a0 = f5;
            float fT2 = t();
            invalidateSelf();
            if (fT != fT2) {
                y();
            }
        }
    }

    public final void S(float f5) {
        if (this.f3115Z != f5) {
            float fT = t();
            this.f3115Z = f5;
            float fT2 = t();
            invalidateSelf();
            if (fT != fT2) {
                y();
            }
        }
    }

    public final void T(ColorStateList colorStateList) {
        if (this.f3093F != colorStateList) {
            this.f3093F = colorStateList;
            this.f3088C0 = this.f3086B0 ? AbstractC0742a.b(colorStateList) : null;
            onStateChange(getState());
        }
    }

    public final boolean U() {
        return this.f3109T && this.f3110U != null && this.f3135t0;
    }

    public final boolean V() {
        return this.f3097H && this.I != null;
    }

    public final boolean W() {
        return this.f3102M && this.f3103N != null;
    }

    @Override // n2.h, g2.InterfaceC0545i
    public final void a() {
        y();
        invalidateSelf();
    }

    @Override // n2.h, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        int i5;
        RectF rectF;
        int i6;
        int i7;
        int i8;
        RectF rectF2;
        int iSave;
        Rect bounds = getBounds();
        if (bounds.isEmpty() || (i5 = this.v0) == 0) {
            return;
        }
        int iSaveLayerAlpha = i5 < 255 ? canvas.saveLayerAlpha(bounds.left, bounds.top, bounds.right, bounds.bottom, i5) : 0;
        boolean z4 = this.f3098H0;
        Paint paint = this.f3123h0;
        RectF rectF3 = this.f3125j0;
        if (!z4) {
            paint.setColor(this.f3129n0);
            paint.setStyle(Paint.Style.FILL);
            rectF3.set(bounds);
            canvas.drawRoundRect(rectF3, v(), v(), paint);
        }
        if (!this.f3098H0) {
            paint.setColor(this.f3130o0);
            paint.setStyle(Paint.Style.FILL);
            ColorFilter colorFilter = this.f3137w0;
            if (colorFilter == null) {
                colorFilter = this.f3138x0;
            }
            paint.setColorFilter(colorFilter);
            rectF3.set(bounds);
            canvas.drawRoundRect(rectF3, v(), v(), paint);
        }
        if (this.f3098H0) {
            super.draw(canvas);
        }
        if (this.f3091E > BitmapDescriptorFactory.HUE_RED && !this.f3098H0) {
            paint.setColor(this.f3132q0);
            paint.setStyle(Paint.Style.STROKE);
            if (!this.f3098H0) {
                ColorFilter colorFilter2 = this.f3137w0;
                if (colorFilter2 == null) {
                    colorFilter2 = this.f3138x0;
                }
                paint.setColorFilter(colorFilter2);
            }
            float f5 = bounds.left;
            float f6 = this.f3091E / 2.0f;
            rectF3.set(f5 + f6, bounds.top + f6, bounds.right - f6, bounds.bottom - f6);
            float f7 = this.f3087C - (this.f3091E / 2.0f);
            canvas.drawRoundRect(rectF3, f7, f7, paint);
        }
        paint.setColor(this.f3133r0);
        paint.setStyle(Paint.Style.FILL);
        rectF3.set(bounds);
        if (this.f3098H0) {
            RectF rectF4 = new RectF(bounds);
            Path path = this.f3127l0;
            g gVar = this.f8806c;
            this.f8820t.a(gVar.f8787a, gVar.f8794j, rectF4, this.f8819s, path);
            f(canvas, paint, path, this.f8806c.f8787a, h());
        } else {
            canvas.drawRoundRect(rectF3, v(), v(), paint);
        }
        if (V()) {
            s(bounds, rectF3);
            float f8 = rectF3.left;
            float f9 = rectF3.top;
            canvas.translate(f8, f9);
            this.I.setBounds(0, 0, (int) rectF3.width(), (int) rectF3.height());
            this.I.draw(canvas);
            canvas.translate(-f8, -f9);
        }
        if (U()) {
            s(bounds, rectF3);
            float f10 = rectF3.left;
            float f11 = rectF3.top;
            canvas.translate(f10, f11);
            this.f3110U.setBounds(0, 0, (int) rectF3.width(), (int) rectF3.height());
            this.f3110U.draw(canvas);
            canvas.translate(-f10, -f11);
        }
        if (!this.f3094F0 || this.f3095G == null) {
            rectF = rectF3;
            i6 = iSaveLayerAlpha;
            i7 = 0;
            i8 = 255;
        } else {
            PointF pointF = this.f3126k0;
            pointF.set(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
            Paint.Align align = Paint.Align.LEFT;
            CharSequence charSequence = this.f3095G;
            C0546j c0546j = this.f3128m0;
            if (charSequence != null) {
                float fT = t() + this.f3114Y + this.f3117b0;
                if (F.c.a(this) == 0) {
                    pointF.x = bounds.left + fT;
                } else {
                    pointF.x = bounds.right - fT;
                    align = Paint.Align.RIGHT;
                }
                float fCenterY = bounds.centerY();
                TextPaint textPaint = c0546j.f6940a;
                Paint.FontMetrics fontMetrics = this.f3124i0;
                textPaint.getFontMetrics(fontMetrics);
                pointF.y = fCenterY - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f);
            }
            rectF3.setEmpty();
            if (this.f3095G != null) {
                float fT2 = t() + this.f3114Y + this.f3117b0;
                float fU = u() + this.f3121f0 + this.f3118c0;
                if (F.c.a(this) == 0) {
                    rectF3.left = bounds.left + fT2;
                    rectF3.right = bounds.right - fU;
                } else {
                    rectF3.left = bounds.left + fU;
                    rectF3.right = bounds.right - fT2;
                }
                rectF3.top = bounds.top;
                rectF3.bottom = bounds.bottom;
            }
            k2.d dVar = c0546j.g;
            TextPaint textPaint2 = c0546j.f6940a;
            if (dVar != null) {
                textPaint2.drawableState = getState();
                c0546j.g.e(this.f3122g0, textPaint2, c0546j.f6941b);
            }
            textPaint2.setTextAlign(align);
            boolean z5 = Math.round(c0546j.a(this.f3095G.toString())) > Math.round(rectF3.width());
            if (z5) {
                iSave = canvas.save();
                canvas.clipRect(rectF3);
            } else {
                iSave = 0;
            }
            CharSequence charSequenceEllipsize = this.f3095G;
            if (z5 && this.f3092E0 != null) {
                charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, textPaint2, rectF3.width(), this.f3092E0);
            }
            CharSequence charSequence2 = charSequenceEllipsize;
            int length = charSequence2.length();
            float f12 = pointF.x;
            float f13 = pointF.y;
            rectF = rectF3;
            i6 = iSaveLayerAlpha;
            i7 = 0;
            i8 = 255;
            canvas.drawText(charSequence2, 0, length, f12, f13, textPaint2);
            if (z5) {
                canvas.restoreToCount(iSave);
            }
        }
        if (W()) {
            rectF.setEmpty();
            if (W()) {
                float f14 = this.f3121f0 + this.f3120e0;
                if (F.c.a(this) == 0) {
                    float f15 = bounds.right - f14;
                    rectF2 = rectF;
                    rectF2.right = f15;
                    rectF2.left = f15 - this.f3106Q;
                } else {
                    rectF2 = rectF;
                    float f16 = bounds.left + f14;
                    rectF2.left = f16;
                    rectF2.right = f16 + this.f3106Q;
                }
                float fExactCenterY = bounds.exactCenterY();
                float f17 = this.f3106Q;
                float f18 = fExactCenterY - (f17 / 2.0f);
                rectF2.top = f18;
                rectF2.bottom = f18 + f17;
            } else {
                rectF2 = rectF;
            }
            float f19 = rectF2.left;
            float f20 = rectF2.top;
            canvas.translate(f19, f20);
            this.f3103N.setBounds(i7, i7, (int) rectF2.width(), (int) rectF2.height());
            this.f3104O.setBounds(this.f3103N.getBounds());
            this.f3104O.jumpToCurrentState();
            this.f3104O.draw(canvas);
            canvas.translate(-f19, -f20);
        }
        if (this.v0 < i8) {
            canvas.restoreToCount(i6);
        }
    }

    @Override // n2.h, android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.v0;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        return this.f3137w0;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return (int) this.f3085B;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return Math.min(Math.round(u() + this.f3128m0.a(this.f3095G.toString()) + t() + this.f3114Y + this.f3117b0 + this.f3118c0 + this.f3121f0), this.f3096G0);
    }

    @Override // n2.h, android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // n2.h, android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        if (this.f3098H0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), (int) this.f3085B, this.f3087C);
        } else {
            outline.setRoundRect(bounds, this.f3087C);
        }
        outline.setAlpha(this.v0 / 255.0f);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // n2.h, android.graphics.drawable.Drawable
    public final boolean isStateful() {
        k2.d dVar;
        ColorStateList colorStateList;
        return w(this.f3140z) || w(this.f3083A) || w(this.f3089D) || (this.f3086B0 && w(this.f3088C0)) || (!((dVar = this.f3128m0.g) == null || (colorStateList = dVar.f7930j) == null || !colorStateList.isStateful()) || ((this.f3109T && this.f3110U != null && this.f3108S) || x(this.I) || x(this.f3110U) || w(this.f3139y0)));
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLayoutDirectionChanged(int i5) {
        boolean zOnLayoutDirectionChanged = super.onLayoutDirectionChanged(i5);
        if (V()) {
            zOnLayoutDirectionChanged |= F.c.b(this.I, i5);
        }
        if (U()) {
            zOnLayoutDirectionChanged |= F.c.b(this.f3110U, i5);
        }
        if (W()) {
            zOnLayoutDirectionChanged |= F.c.b(this.f3103N, i5);
        }
        if (!zOnLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i5) {
        boolean zOnLevelChange = super.onLevelChange(i5);
        if (V()) {
            zOnLevelChange |= this.I.setLevel(i5);
        }
        if (U()) {
            zOnLevelChange |= this.f3110U.setLevel(i5);
        }
        if (W()) {
            zOnLevelChange |= this.f3103N.setLevel(i5);
        }
        if (zOnLevelChange) {
            invalidateSelf();
        }
        return zOnLevelChange;
    }

    @Override // n2.h, android.graphics.drawable.Drawable, g2.InterfaceC0545i
    public final boolean onStateChange(int[] iArr) {
        if (this.f3098H0) {
            super.onStateChange(iArr);
        }
        return z(iArr, this.f3084A0);
    }

    public final void r(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        F.c.b(drawable, F.c.a(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.f3103N) {
            if (drawable.isStateful()) {
                drawable.setState(this.f3084A0);
            }
            F.b.h(drawable, this.f3105P);
            return;
        }
        Drawable drawable2 = this.I;
        if (drawable == drawable2 && this.f3101L) {
            F.b.h(drawable2, this.f3099J);
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
    }

    public final void s(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (V() || U()) {
            float f5 = this.f3114Y + this.f3115Z;
            Drawable drawable = this.f3135t0 ? this.f3110U : this.I;
            float intrinsicWidth = this.f3100K;
            if (intrinsicWidth <= BitmapDescriptorFactory.HUE_RED && drawable != null) {
                intrinsicWidth = drawable.getIntrinsicWidth();
            }
            if (F.c.a(this) == 0) {
                float f6 = rect.left + f5;
                rectF.left = f6;
                rectF.right = f6 + intrinsicWidth;
            } else {
                float f7 = rect.right - f5;
                rectF.right = f7;
                rectF.left = f7 - intrinsicWidth;
            }
            Drawable drawable2 = this.f3135t0 ? this.f3110U : this.I;
            float fCeil = this.f3100K;
            if (fCeil <= BitmapDescriptorFactory.HUE_RED && drawable2 != null) {
                fCeil = (float) Math.ceil(TypedValue.applyDimension(1, 24, this.f3122g0.getResources().getDisplayMetrics()));
                if (drawable2.getIntrinsicHeight() <= fCeil) {
                    fCeil = drawable2.getIntrinsicHeight();
                }
            }
            float fExactCenterY = rect.exactCenterY() - (fCeil / 2.0f);
            rectF.top = fExactCenterY;
            rectF.bottom = fExactCenterY + fCeil;
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j5) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j5);
        }
    }

    @Override // n2.h, android.graphics.drawable.Drawable
    public final void setAlpha(int i5) {
        if (this.v0 != i5) {
            this.v0 = i5;
            invalidateSelf();
        }
    }

    @Override // n2.h, android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.f3137w0 != colorFilter) {
            this.f3137w0 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // n2.h, android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        if (this.f3139y0 != colorStateList) {
            this.f3139y0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // n2.h, android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        if (this.z0 != mode) {
            this.z0 = mode;
            ColorStateList colorStateList = this.f3139y0;
            this.f3138x0 = (colorStateList == null || mode == null) ? null : new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z4, boolean z5) {
        boolean visible = super.setVisible(z4, z5);
        if (V()) {
            visible |= this.I.setVisible(z4, z5);
        }
        if (U()) {
            visible |= this.f3110U.setVisible(z4, z5);
        }
        if (W()) {
            visible |= this.f3103N.setVisible(z4, z5);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public final float t() {
        if (!V() && !U()) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        float f5 = this.f3115Z;
        Drawable drawable = this.f3135t0 ? this.f3110U : this.I;
        float intrinsicWidth = this.f3100K;
        if (intrinsicWidth <= BitmapDescriptorFactory.HUE_RED && drawable != null) {
            intrinsicWidth = drawable.getIntrinsicWidth();
        }
        return intrinsicWidth + f5 + this.f3116a0;
    }

    public final float u() {
        return W() ? this.f3119d0 + this.f3106Q + this.f3120e0 : BitmapDescriptorFactory.HUE_RED;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public final float v() {
        return this.f3098H0 ? this.f8806c.f8787a.f8843e.a(h()) : this.f3087C;
    }

    public final void y() {
        e eVar = (e) this.f3090D0.get();
        if (eVar != null) {
            Chip chip = (Chip) eVar;
            chip.c(chip.f5268r);
            chip.requestLayout();
            chip.invalidateOutline();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean z(int[] r12, int[] r13) {
        /*
            Method dump skipped, instructions count: 388
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: Z1.f.z(int[], int[]):boolean");
    }
}
