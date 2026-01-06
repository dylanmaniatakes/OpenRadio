package s2;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public final class f extends n2.h {

    /* renamed from: A, reason: collision with root package name */
    public static final /* synthetic */ int f9590A = 0;

    /* renamed from: z, reason: collision with root package name */
    public e f9591z;

    public f(e eVar) {
        super(eVar);
        this.f9591z = eVar;
    }

    @Override // n2.h
    public final void g(Canvas canvas) {
        if (this.f9591z.f9589v.isEmpty()) {
            super.g(canvas);
            return;
        }
        canvas.save();
        canvas.clipOutRect(this.f9591z.f9589v);
        super.g(canvas);
        canvas.restore();
    }

    @Override // n2.h, android.graphics.drawable.Drawable
    public final Drawable mutate() {
        this.f9591z = new e(this.f9591z);
        return this;
    }

    public final void r(float f5, float f6, float f7, float f8) {
        RectF rectF = this.f9591z.f9589v;
        if (f5 == rectF.left && f6 == rectF.top && f7 == rectF.right && f8 == rectF.bottom) {
            return;
        }
        rectF.set(f5, f6, f7, f8);
        invalidateSelf();
    }
}
