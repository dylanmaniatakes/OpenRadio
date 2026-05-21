package f2;

import android.animation.ValueAnimator;
import android.graphics.Matrix;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* renamed from: f2.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0482f implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f6492a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f6493b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f6494c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ float f6495d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ float f6496e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ float f6497f;
    public final /* synthetic */ float g;
    public final /* synthetic */ Matrix h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ AbstractC0487k f6498i;

    public C0482f(AbstractC0487k abstractC0487k, float f5, float f6, float f7, float f8, float f9, float f10, float f11, Matrix matrix) {
        this.f6498i = abstractC0487k;
        this.f6492a = f5;
        this.f6493b = f6;
        this.f6494c = f7;
        this.f6495d = f8;
        this.f6496e = f9;
        this.f6497f = f10;
        this.g = f11;
        this.h = matrix;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        AbstractC0487k abstractC0487k = this.f6498i;
        abstractC0487k.f6532s.setAlpha(P1.a.b(this.f6492a, this.f6493b, BitmapDescriptorFactory.HUE_RED, 0.2f, fFloatValue));
        FloatingActionButton floatingActionButton = abstractC0487k.f6532s;
        float f5 = this.f6494c;
        float f6 = this.f6495d;
        floatingActionButton.setScaleX(P1.a.a(f5, f6, fFloatValue));
        abstractC0487k.f6532s.setScaleY(P1.a.a(this.f6496e, f6, fFloatValue));
        float f7 = this.f6497f;
        float f8 = this.g;
        abstractC0487k.f6529p = P1.a.a(f7, f8, fFloatValue);
        float fA = P1.a.a(f7, f8, fFloatValue);
        Matrix matrix = this.h;
        abstractC0487k.a(fA, matrix);
        abstractC0487k.f6532s.setImageMatrix(matrix);
    }
}
