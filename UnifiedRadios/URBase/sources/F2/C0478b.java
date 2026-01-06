package f2;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import n2.InterfaceC0804c;
import n2.n;
import n2.o;
import w1.AbstractC0930a;

/* renamed from: f2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0478b extends Drawable {

    /* renamed from: b, reason: collision with root package name */
    public final Paint f6473b;
    public float h;

    /* renamed from: i, reason: collision with root package name */
    public int f6478i;

    /* renamed from: j, reason: collision with root package name */
    public int f6479j;

    /* renamed from: k, reason: collision with root package name */
    public int f6480k;

    /* renamed from: l, reason: collision with root package name */
    public int f6481l;

    /* renamed from: m, reason: collision with root package name */
    public int f6482m;

    /* renamed from: o, reason: collision with root package name */
    public n2.m f6483o;

    /* renamed from: p, reason: collision with root package name */
    public ColorStateList f6484p;

    /* renamed from: a, reason: collision with root package name */
    public final o f6472a = n.f8849a;

    /* renamed from: c, reason: collision with root package name */
    public final Path f6474c = new Path();

    /* renamed from: d, reason: collision with root package name */
    public final Rect f6475d = new Rect();

    /* renamed from: e, reason: collision with root package name */
    public final RectF f6476e = new RectF();

    /* renamed from: f, reason: collision with root package name */
    public final RectF f6477f = new RectF();
    public final C0477a g = new C0477a(this);
    public boolean n = true;

    public C0478b(n2.m mVar) {
        this.f6483o = mVar;
        Paint paint = new Paint(1);
        this.f6473b = paint;
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        boolean z4 = this.n;
        Paint paint = this.f6473b;
        Rect rect = this.f6475d;
        if (z4) {
            copyBounds(rect);
            float fHeight = this.h / rect.height();
            paint.setShader(new LinearGradient(BitmapDescriptorFactory.HUE_RED, rect.top, BitmapDescriptorFactory.HUE_RED, rect.bottom, new int[]{E.a.b(this.f6478i, this.f6482m), E.a.b(this.f6479j, this.f6482m), E.a.b(E.a.d(this.f6479j, 0), this.f6482m), E.a.b(E.a.d(this.f6481l, 0), this.f6482m), E.a.b(this.f6481l, this.f6482m), E.a.b(this.f6480k, this.f6482m)}, new float[]{BitmapDescriptorFactory.HUE_RED, fHeight, 0.5f, 0.5f, 1.0f - fHeight, 1.0f}, Shader.TileMode.CLAMP));
            this.n = false;
        }
        float strokeWidth = paint.getStrokeWidth() / 2.0f;
        copyBounds(rect);
        RectF rectF = this.f6476e;
        rectF.set(rect);
        InterfaceC0804c interfaceC0804c = this.f6483o.f8843e;
        RectF rectF2 = this.f6477f;
        rectF2.set(getBounds());
        float fMin = Math.min(interfaceC0804c.a(rectF2), rectF.width() / 2.0f);
        n2.m mVar = this.f6483o;
        rectF2.set(getBounds());
        if (mVar.d(rectF2)) {
            rectF.inset(strokeWidth, strokeWidth);
            canvas.drawRoundRect(rectF, fMin, fMin, paint);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.g;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return this.h > BitmapDescriptorFactory.HUE_RED ? -3 : -2;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        n2.m mVar = this.f6483o;
        RectF rectF = this.f6477f;
        rectF.set(getBounds());
        if (mVar.d(rectF)) {
            InterfaceC0804c interfaceC0804c = this.f6483o.f8843e;
            rectF.set(getBounds());
            outline.setRoundRect(getBounds(), interfaceC0804c.a(rectF));
            return;
        }
        Rect rect = this.f6475d;
        copyBounds(rect);
        RectF rectF2 = this.f6476e;
        rectF2.set(rect);
        n2.m mVar2 = this.f6483o;
        Path path = this.f6474c;
        this.f6472a.a(mVar2, 1.0f, rectF2, null, path);
        AbstractC0930a.o(outline, path);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        n2.m mVar = this.f6483o;
        RectF rectF = this.f6477f;
        rectF.set(getBounds());
        if (!mVar.d(rectF)) {
            return true;
        }
        int iRound = Math.round(this.h);
        rect.set(iRound, iRound, iRound, iRound);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList colorStateList = this.f6484p;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        this.n = true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        int colorForState;
        ColorStateList colorStateList = this.f6484p;
        if (colorStateList != null && (colorForState = colorStateList.getColorForState(iArr, this.f6482m)) != this.f6482m) {
            this.n = true;
            this.f6482m = colorForState;
        }
        if (this.n) {
            invalidateSelf();
        }
        return this.n;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i5) {
        this.f6473b.setAlpha(i5);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f6473b.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
