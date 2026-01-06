package W1;

import O.H;
import O.Y;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import com.google.android.gms.internal.measurement.AbstractC0296a2;
import com.google.android.material.button.MaterialButton;
import com.unified.ur1.R;
import java.util.WeakHashMap;
import l2.AbstractC0742a;
import n2.h;
import n2.m;
import n2.x;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final MaterialButton f2588a;

    /* renamed from: b, reason: collision with root package name */
    public m f2589b;

    /* renamed from: c, reason: collision with root package name */
    public int f2590c;

    /* renamed from: d, reason: collision with root package name */
    public int f2591d;

    /* renamed from: e, reason: collision with root package name */
    public int f2592e;

    /* renamed from: f, reason: collision with root package name */
    public int f2593f;
    public int g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public PorterDuff.Mode f2594i;

    /* renamed from: j, reason: collision with root package name */
    public ColorStateList f2595j;

    /* renamed from: k, reason: collision with root package name */
    public ColorStateList f2596k;

    /* renamed from: l, reason: collision with root package name */
    public ColorStateList f2597l;

    /* renamed from: m, reason: collision with root package name */
    public h f2598m;

    /* renamed from: q, reason: collision with root package name */
    public boolean f2601q;

    /* renamed from: s, reason: collision with root package name */
    public RippleDrawable f2603s;

    /* renamed from: t, reason: collision with root package name */
    public int f2604t;
    public boolean n = false;

    /* renamed from: o, reason: collision with root package name */
    public boolean f2599o = false;

    /* renamed from: p, reason: collision with root package name */
    public boolean f2600p = false;

    /* renamed from: r, reason: collision with root package name */
    public boolean f2602r = true;

    public c(MaterialButton materialButton, m mVar) {
        this.f2588a = materialButton;
        this.f2589b = mVar;
    }

    public final x a() {
        RippleDrawable rippleDrawable = this.f2603s;
        if (rippleDrawable == null || rippleDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        return this.f2603s.getNumberOfLayers() > 2 ? (x) this.f2603s.getDrawable(2) : (x) this.f2603s.getDrawable(1);
    }

    public final h b(boolean z4) {
        RippleDrawable rippleDrawable = this.f2603s;
        if (rippleDrawable == null || rippleDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return (h) ((LayerDrawable) ((InsetDrawable) this.f2603s.getDrawable(0)).getDrawable()).getDrawable(!z4 ? 1 : 0);
    }

    public final void c(m mVar) {
        this.f2589b = mVar;
        if (b(false) != null) {
            b(false).setShapeAppearanceModel(mVar);
        }
        if (b(true) != null) {
            b(true).setShapeAppearanceModel(mVar);
        }
        if (a() != null) {
            a().setShapeAppearanceModel(mVar);
        }
    }

    public final void d(int i5, int i6) {
        WeakHashMap weakHashMap = Y.f1904a;
        MaterialButton materialButton = this.f2588a;
        int iF = H.f(materialButton);
        int paddingTop = materialButton.getPaddingTop();
        int iE = H.e(materialButton);
        int paddingBottom = materialButton.getPaddingBottom();
        int i7 = this.f2592e;
        int i8 = this.f2593f;
        this.f2593f = i6;
        this.f2592e = i5;
        if (!this.f2599o) {
            e();
        }
        H.k(materialButton, iF, (paddingTop + i5) - i7, iE, (paddingBottom + i6) - i8);
    }

    public final void e() {
        h hVar = new h(this.f2589b);
        MaterialButton materialButton = this.f2588a;
        hVar.j(materialButton.getContext());
        F.b.h(hVar, this.f2595j);
        PorterDuff.Mode mode = this.f2594i;
        if (mode != null) {
            F.b.i(hVar, mode);
        }
        float f5 = this.h;
        ColorStateList colorStateList = this.f2596k;
        hVar.f8806c.f8795k = f5;
        hVar.invalidateSelf();
        hVar.n(colorStateList);
        h hVar2 = new h(this.f2589b);
        hVar2.setTint(0);
        float f6 = this.h;
        int iF = this.n ? AbstractC0296a2.f(materialButton, R.attr.colorSurface) : 0;
        hVar2.f8806c.f8795k = f6;
        hVar2.invalidateSelf();
        hVar2.n(ColorStateList.valueOf(iF));
        h hVar3 = new h(this.f2589b);
        this.f2598m = hVar3;
        F.b.g(hVar3, -1);
        RippleDrawable rippleDrawable = new RippleDrawable(AbstractC0742a.b(this.f2597l), new InsetDrawable((Drawable) new LayerDrawable(new Drawable[]{hVar2, hVar}), this.f2590c, this.f2592e, this.f2591d, this.f2593f), this.f2598m);
        this.f2603s = rippleDrawable;
        materialButton.setInternalBackground(rippleDrawable);
        h hVarB = b(false);
        if (hVarB != null) {
            hVarB.k(this.f2604t);
            hVarB.setState(materialButton.getDrawableState());
        }
    }

    public final void f() {
        h hVarB = b(false);
        h hVarB2 = b(true);
        if (hVarB != null) {
            float f5 = this.h;
            ColorStateList colorStateList = this.f2596k;
            hVarB.f8806c.f8795k = f5;
            hVarB.invalidateSelf();
            hVarB.n(colorStateList);
            if (hVarB2 != null) {
                float f6 = this.h;
                int iF = this.n ? AbstractC0296a2.f(this.f2588a, R.attr.colorSurface) : 0;
                hVarB2.f8806c.f8795k = f6;
                hVarB2.invalidateSelf();
                hVarB2.n(ColorStateList.valueOf(iF));
            }
        }
    }
}
