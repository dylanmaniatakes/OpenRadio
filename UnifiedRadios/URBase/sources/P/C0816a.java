package p;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* renamed from: p.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0816a extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    public float f9064a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f9065b;

    /* renamed from: c, reason: collision with root package name */
    public final RectF f9066c;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f9067d;

    /* renamed from: e, reason: collision with root package name */
    public float f9068e;
    public ColorStateList h;

    /* renamed from: i, reason: collision with root package name */
    public PorterDuffColorFilter f9070i;

    /* renamed from: j, reason: collision with root package name */
    public ColorStateList f9071j;

    /* renamed from: f, reason: collision with root package name */
    public boolean f9069f = false;
    public boolean g = true;

    /* renamed from: k, reason: collision with root package name */
    public PorterDuff.Mode f9072k = PorterDuff.Mode.SRC_IN;

    public C0816a(ColorStateList colorStateList, float f5) {
        this.f9064a = f5;
        Paint paint = new Paint(5);
        this.f9065b = paint;
        colorStateList = colorStateList == null ? ColorStateList.valueOf(0) : colorStateList;
        this.h = colorStateList;
        paint.setColor(colorStateList.getColorForState(getState(), this.h.getDefaultColor()));
        this.f9066c = new RectF();
        this.f9067d = new Rect();
    }

    public final PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public final void b(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        RectF rectF = this.f9066c;
        rectF.set(rect.left, rect.top, rect.right, rect.bottom);
        Rect rect2 = this.f9067d;
        rect2.set(rect);
        if (this.f9069f) {
            rect2.inset((int) Math.ceil(AbstractC0817b.a(this.f9068e, this.f9064a, this.g)), (int) Math.ceil(AbstractC0817b.b(this.f9068e, this.f9064a, this.g)));
            rectF.set(rect2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        boolean z4;
        Paint paint = this.f9065b;
        if (this.f9070i == null || paint.getColorFilter() != null) {
            z4 = false;
        } else {
            paint.setColorFilter(this.f9070i);
            z4 = true;
        }
        RectF rectF = this.f9066c;
        float f5 = this.f9064a;
        canvas.drawRoundRect(rectF, f5, f5, paint);
        if (z4) {
            paint.setColorFilter(null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        outline.setRoundRect(this.f9067d, this.f9064a);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f9071j;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.h) != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        b(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        Paint paint = this.f9065b;
        boolean z4 = colorForState != paint.getColor();
        if (z4) {
            paint.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f9071j;
        if (colorStateList2 == null || (mode = this.f9072k) == null) {
            return z4;
        }
        this.f9070i = a(colorStateList2, mode);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i5) {
        this.f9065b.setAlpha(i5);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f9065b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        this.f9071j = colorStateList;
        this.f9070i = a(colorStateList, this.f9072k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        this.f9072k = mode;
        this.f9070i = a(this.f9071j, mode);
        invalidateSelf();
    }
}
