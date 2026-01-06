package f2;

import a.AbstractC0203a;
import a0.C0204a;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Property;
import android.view.View;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.unified.ur1.R;
import f3.C0513e;
import java.util.ArrayList;
import l2.AbstractC0742a;
import n2.x;

/* renamed from: f2.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0487k {

    /* renamed from: a, reason: collision with root package name */
    public n2.m f6517a;

    /* renamed from: b, reason: collision with root package name */
    public n2.h f6518b;

    /* renamed from: c, reason: collision with root package name */
    public Drawable f6519c;

    /* renamed from: d, reason: collision with root package name */
    public C0478b f6520d;

    /* renamed from: e, reason: collision with root package name */
    public LayerDrawable f6521e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f6522f;
    public float h;

    /* renamed from: i, reason: collision with root package name */
    public float f6523i;

    /* renamed from: j, reason: collision with root package name */
    public float f6524j;

    /* renamed from: k, reason: collision with root package name */
    public int f6525k;

    /* renamed from: l, reason: collision with root package name */
    public Animator f6526l;

    /* renamed from: m, reason: collision with root package name */
    public P1.d f6527m;
    public P1.d n;

    /* renamed from: o, reason: collision with root package name */
    public float f6528o;

    /* renamed from: q, reason: collision with root package name */
    public int f6530q;

    /* renamed from: s, reason: collision with root package name */
    public final FloatingActionButton f6532s;

    /* renamed from: t, reason: collision with root package name */
    public final L0.l f6533t;

    /* renamed from: y, reason: collision with root package name */
    public ViewTreeObserverOnPreDrawListenerC0483g f6538y;

    /* renamed from: z, reason: collision with root package name */
    public static final C0204a f6516z = P1.a.f2066c;

    /* renamed from: A, reason: collision with root package name */
    public static final int f6507A = R.attr.motionDurationLong2;

    /* renamed from: B, reason: collision with root package name */
    public static final int f6508B = R.attr.motionEasingEmphasizedInterpolator;

    /* renamed from: C, reason: collision with root package name */
    public static final int f6509C = R.attr.motionDurationMedium1;

    /* renamed from: D, reason: collision with root package name */
    public static final int f6510D = R.attr.motionEasingEmphasizedAccelerateInterpolator;

    /* renamed from: E, reason: collision with root package name */
    public static final int[] f6511E = {android.R.attr.state_pressed, android.R.attr.state_enabled};

    /* renamed from: F, reason: collision with root package name */
    public static final int[] f6512F = {android.R.attr.state_hovered, android.R.attr.state_focused, android.R.attr.state_enabled};

    /* renamed from: G, reason: collision with root package name */
    public static final int[] f6513G = {android.R.attr.state_focused, android.R.attr.state_enabled};

    /* renamed from: H, reason: collision with root package name */
    public static final int[] f6514H = {android.R.attr.state_hovered, android.R.attr.state_enabled};
    public static final int[] I = {android.R.attr.state_enabled};

    /* renamed from: J, reason: collision with root package name */
    public static final int[] f6515J = new int[0];
    public boolean g = true;

    /* renamed from: p, reason: collision with root package name */
    public float f6529p = 1.0f;

    /* renamed from: r, reason: collision with root package name */
    public int f6531r = 0;

    /* renamed from: u, reason: collision with root package name */
    public final Rect f6534u = new Rect();

    /* renamed from: v, reason: collision with root package name */
    public final RectF f6535v = new RectF();

    /* renamed from: w, reason: collision with root package name */
    public final RectF f6536w = new RectF();

    /* renamed from: x, reason: collision with root package name */
    public final Matrix f6537x = new Matrix();

    public AbstractC0487k(FloatingActionButton floatingActionButton, L0.l lVar) {
        this.f6532s = floatingActionButton;
        this.f6533t = lVar;
        C0513e c0513e = new C0513e();
        c0513e.f6686c = new ArrayList();
        c0513e.f6687d = null;
        c0513e.f6688e = new S1.a(1, c0513e);
        C0489m c0489m = (C0489m) this;
        c0513e.a(f6511E, d(new C0485i(c0489m, 1)));
        c0513e.a(f6512F, d(new C0485i(c0489m, 0)));
        c0513e.a(f6513G, d(new C0485i(c0489m, 0)));
        c0513e.a(f6514H, d(new C0485i(c0489m, 0)));
        c0513e.a(I, d(new C0485i(c0489m, 2)));
        c0513e.a(f6515J, d(new C0484h(c0489m)));
        this.f6528o = floatingActionButton.getRotation();
    }

    public static ValueAnimator d(AbstractC0486j abstractC0486j) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(f6516z);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(abstractC0486j);
        valueAnimator.addUpdateListener(abstractC0486j);
        valueAnimator.setFloatValues(BitmapDescriptorFactory.HUE_RED, 1.0f);
        return valueAnimator;
    }

    public final void a(float f5, Matrix matrix) {
        matrix.reset();
        if (this.f6532s.getDrawable() == null || this.f6530q == 0) {
            return;
        }
        RectF rectF = this.f6535v;
        RectF rectF2 = this.f6536w;
        rectF.set(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        int i5 = this.f6530q;
        rectF2.set(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, i5, i5);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        int i6 = this.f6530q;
        matrix.postScale(f5, f5, i6 / 2.0f, i6 / 2.0f);
    }

    public final AnimatorSet b(P1.d dVar, float f5, float f6, float f7) {
        ArrayList arrayList = new ArrayList();
        Property property = View.ALPHA;
        float[] fArr = {f5};
        FloatingActionButton floatingActionButton = this.f6532s;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) property, fArr);
        dVar.d("opacity").a(objectAnimatorOfFloat);
        arrayList.add(objectAnimatorOfFloat);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.SCALE_X, f6);
        dVar.d("scale").a(objectAnimatorOfFloat2);
        arrayList.add(objectAnimatorOfFloat2);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.SCALE_Y, f6);
        dVar.d("scale").a(objectAnimatorOfFloat3);
        arrayList.add(objectAnimatorOfFloat3);
        Matrix matrix = this.f6537x;
        a(f7, matrix);
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(floatingActionButton, new P1.c(), new C0481e(this), new Matrix(matrix));
        dVar.d("iconScale").a(objectAnimatorOfObject);
        arrayList.add(objectAnimatorOfObject);
        AnimatorSet animatorSet = new AnimatorSet();
        AbstractC0203a.k(animatorSet, arrayList);
        return animatorSet;
    }

    public final AnimatorSet c(float f5, float f6, float f7, int i5, int i6) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(BitmapDescriptorFactory.HUE_RED, 1.0f);
        FloatingActionButton floatingActionButton = this.f6532s;
        valueAnimatorOfFloat.addUpdateListener(new C0482f(this, floatingActionButton.getAlpha(), f5, floatingActionButton.getScaleX(), f6, floatingActionButton.getScaleY(), this.f6529p, f7, new Matrix(this.f6537x)));
        arrayList.add(valueAnimatorOfFloat);
        AbstractC0203a.k(animatorSet, arrayList);
        animatorSet.setDuration(A2.b.v(floatingActionButton.getContext(), i5, floatingActionButton.getContext().getResources().getInteger(R.integer.material_motion_duration_long_1)));
        animatorSet.setInterpolator(A2.b.w(floatingActionButton.getContext(), i6, P1.a.f2065b));
        return animatorSet;
    }

    public abstract float e();

    public void f(Rect rect) {
        int iMax = this.f6522f ? Math.max((this.f6525k - this.f6532s.getSizeDimension()) / 2, 0) : 0;
        int iMax2 = Math.max(iMax, (int) Math.ceil(this.g ? e() + this.f6524j : BitmapDescriptorFactory.HUE_RED));
        int iMax3 = Math.max(iMax, (int) Math.ceil(r0 * 1.5f));
        rect.set(iMax2, iMax3, iMax2, iMax3);
    }

    public abstract void g(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i5);

    public abstract void h();

    public abstract void i();

    public abstract void j(int[] iArr);

    public abstract void k(float f5, float f6, float f7);

    public final void l() {
    }

    public void m(ColorStateList colorStateList) {
        Drawable drawable = this.f6519c;
        if (drawable != null) {
            F.b.h(drawable, AbstractC0742a.b(colorStateList));
        }
    }

    public final void n(n2.m mVar) {
        this.f6517a = mVar;
        n2.h hVar = this.f6518b;
        if (hVar != null) {
            hVar.setShapeAppearanceModel(mVar);
        }
        Object obj = this.f6519c;
        if (obj instanceof x) {
            ((x) obj).setShapeAppearanceModel(mVar);
        }
        C0478b c0478b = this.f6520d;
        if (c0478b != null) {
            c0478b.f6483o = mVar;
            c0478b.invalidateSelf();
        }
    }

    public abstract boolean o();

    public abstract void p();

    public final void q() {
        Rect rect = this.f6534u;
        f(rect);
        h4.f.c(this.f6521e, "Didn't initialize content background");
        boolean zO = o();
        L0.l lVar = this.f6533t;
        if (zO) {
            super/*android.view.View*/.setBackgroundDrawable(new InsetDrawable((Drawable) this.f6521e, rect.left, rect.top, rect.right, rect.bottom));
        } else {
            LayerDrawable layerDrawable = this.f6521e;
            if (layerDrawable != null) {
                super/*android.view.View*/.setBackgroundDrawable(layerDrawable);
            } else {
                lVar.getClass();
            }
        }
        int i5 = rect.left;
        int i6 = rect.top;
        int i7 = rect.right;
        int i8 = rect.bottom;
        FloatingActionButton floatingActionButton = (FloatingActionButton) lVar.f1554d;
        floatingActionButton.n.set(i5, i6, i7, i8);
        int i9 = floatingActionButton.f5365k;
        floatingActionButton.setPadding(i5 + i9, i6 + i9, i7 + i9, i8 + i9);
    }
}
