package u0;

import a0.C0204a;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.LinearInterpolator;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* loaded from: classes.dex */
public final class e extends Drawable implements Animatable {

    /* renamed from: i, reason: collision with root package name */
    public static final LinearInterpolator f9903i = new LinearInterpolator();

    /* renamed from: j, reason: collision with root package name */
    public static final C0204a f9904j = new C0204a(1);

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f9905k = {-16777216};

    /* renamed from: c, reason: collision with root package name */
    public final d f9906c;

    /* renamed from: d, reason: collision with root package name */
    public float f9907d;

    /* renamed from: e, reason: collision with root package name */
    public final Resources f9908e;

    /* renamed from: f, reason: collision with root package name */
    public final ValueAnimator f9909f;
    public float g;
    public boolean h;

    public e(Context context) {
        context.getClass();
        this.f9908e = context.getResources();
        d dVar = new d();
        this.f9906c = dVar;
        dVar.f9891i = f9905k;
        dVar.a(0);
        dVar.h = 2.5f;
        dVar.f9886b.setStrokeWidth(2.5f);
        invalidateSelf();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(BitmapDescriptorFactory.HUE_RED, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new b(this, dVar));
        valueAnimatorOfFloat.setRepeatCount(-1);
        valueAnimatorOfFloat.setRepeatMode(1);
        valueAnimatorOfFloat.setInterpolator(f9903i);
        valueAnimatorOfFloat.addListener(new c(this, dVar));
        this.f9909f = valueAnimatorOfFloat;
    }

    public static void d(float f5, d dVar) {
        if (f5 <= 0.75f) {
            dVar.f9902u = dVar.f9891i[dVar.f9892j];
            return;
        }
        float f6 = (f5 - 0.75f) / 0.25f;
        int[] iArr = dVar.f9891i;
        int i5 = dVar.f9892j;
        int i6 = iArr[i5];
        int i7 = iArr[(i5 + 1) % iArr.length];
        dVar.f9902u = ((((i6 >> 24) & 255) + ((int) ((((i7 >> 24) & 255) - r1) * f6))) << 24) | ((((i6 >> 16) & 255) + ((int) ((((i7 >> 16) & 255) - r3) * f6))) << 16) | ((((i6 >> 8) & 255) + ((int) ((((i7 >> 8) & 255) - r4) * f6))) << 8) | ((i6 & 255) + ((int) (f6 * ((i7 & 255) - r2))));
    }

    public final void a(float f5, d dVar, boolean z4) {
        float interpolation;
        float interpolation2;
        if (this.h) {
            d(f5, dVar);
            float fFloor = (float) (Math.floor(dVar.f9895m / 0.8f) + 1.0d);
            float f6 = dVar.f9893k;
            float f7 = dVar.f9894l;
            dVar.f9889e = (((f7 - 0.01f) - f6) * f5) + f6;
            dVar.f9890f = f7;
            float f8 = dVar.f9895m;
            dVar.g = ((fFloor - f8) * f5) + f8;
            return;
        }
        if (f5 != 1.0f || z4) {
            float f9 = dVar.f9895m;
            C0204a c0204a = f9904j;
            if (f5 < 0.5f) {
                interpolation = dVar.f9893k;
                interpolation2 = (c0204a.getInterpolation(f5 / 0.5f) * 0.79f) + 0.01f + interpolation;
            } else {
                float f10 = dVar.f9893k + 0.79f;
                interpolation = f10 - (((1.0f - c0204a.getInterpolation((f5 - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
                interpolation2 = f10;
            }
            float f11 = (0.20999998f * f5) + f9;
            float f12 = (f5 + this.g) * 216.0f;
            dVar.f9889e = interpolation;
            dVar.f9890f = interpolation2;
            dVar.g = f11;
            this.f9907d = f12;
        }
    }

    public final void b(float f5, float f6, float f7, float f8) {
        float f9 = this.f9908e.getDisplayMetrics().density;
        float f10 = f6 * f9;
        d dVar = this.f9906c;
        dVar.h = f10;
        dVar.f9886b.setStrokeWidth(f10);
        dVar.f9898q = f5 * f9;
        dVar.a(0);
        dVar.f9899r = (int) (f7 * f9);
        dVar.f9900s = (int) (f8 * f9);
    }

    public final void c(int i5) {
        if (i5 == 0) {
            b(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            b(7.5f, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.f9907d, bounds.exactCenterX(), bounds.exactCenterY());
        d dVar = this.f9906c;
        RectF rectF = dVar.f9885a;
        float f5 = dVar.f9898q;
        float fMin = (dVar.h / 2.0f) + f5;
        if (f5 <= BitmapDescriptorFactory.HUE_RED) {
            fMin = (Math.min(bounds.width(), bounds.height()) / 2.0f) - Math.max((dVar.f9899r * dVar.f9897p) / 2.0f, dVar.h / 2.0f);
        }
        rectF.set(bounds.centerX() - fMin, bounds.centerY() - fMin, bounds.centerX() + fMin, bounds.centerY() + fMin);
        float f6 = dVar.f9889e;
        float f7 = dVar.g;
        float f8 = (f6 + f7) * 360.0f;
        float f9 = ((dVar.f9890f + f7) * 360.0f) - f8;
        Paint paint = dVar.f9886b;
        paint.setColor(dVar.f9902u);
        paint.setAlpha(dVar.f9901t);
        float f10 = dVar.h / 2.0f;
        rectF.inset(f10, f10);
        canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, dVar.f9888d);
        float f11 = -f10;
        rectF.inset(f11, f11);
        canvas.drawArc(rectF, f8, f9, false, paint);
        if (dVar.n) {
            Path path = dVar.f9896o;
            if (path == null) {
                Path path2 = new Path();
                dVar.f9896o = path2;
                path2.setFillType(Path.FillType.EVEN_ODD);
            } else {
                path.reset();
            }
            float fMin2 = Math.min(rectF.width(), rectF.height()) / 2.0f;
            float f12 = (dVar.f9899r * dVar.f9897p) / 2.0f;
            dVar.f9896o.moveTo(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
            dVar.f9896o.lineTo(dVar.f9899r * dVar.f9897p, BitmapDescriptorFactory.HUE_RED);
            Path path3 = dVar.f9896o;
            float f13 = dVar.f9899r;
            float f14 = dVar.f9897p;
            path3.lineTo((f13 * f14) / 2.0f, dVar.f9900s * f14);
            dVar.f9896o.offset((rectF.centerX() + fMin2) - f12, (dVar.h / 2.0f) + rectF.centerY());
            dVar.f9896o.close();
            Paint paint2 = dVar.f9887c;
            paint2.setColor(dVar.f9902u);
            paint2.setAlpha(dVar.f9901t);
            canvas.save();
            canvas.rotate(f8 + f9, rectF.centerX(), rectF.centerY());
            canvas.drawPath(dVar.f9896o, paint2);
            canvas.restore();
        }
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f9906c.f9901t;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        return this.f9909f.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i5) {
        this.f9906c.f9901t = i5;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f9906c.f9886b.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        this.f9909f.cancel();
        d dVar = this.f9906c;
        float f5 = dVar.f9889e;
        dVar.f9893k = f5;
        float f6 = dVar.f9890f;
        dVar.f9894l = f6;
        dVar.f9895m = dVar.g;
        if (f6 != f5) {
            this.h = true;
            this.f9909f.setDuration(666L);
            this.f9909f.start();
            return;
        }
        dVar.a(0);
        dVar.f9893k = BitmapDescriptorFactory.HUE_RED;
        dVar.f9894l = BitmapDescriptorFactory.HUE_RED;
        dVar.f9895m = BitmapDescriptorFactory.HUE_RED;
        dVar.f9889e = BitmapDescriptorFactory.HUE_RED;
        dVar.f9890f = BitmapDescriptorFactory.HUE_RED;
        dVar.g = BitmapDescriptorFactory.HUE_RED;
        this.f9909f.setDuration(1332L);
        this.f9909f.start();
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        this.f9909f.cancel();
        this.f9907d = BitmapDescriptorFactory.HUE_RED;
        d dVar = this.f9906c;
        if (dVar.n) {
            dVar.n = false;
        }
        dVar.a(0);
        dVar.f9893k = BitmapDescriptorFactory.HUE_RED;
        dVar.f9894l = BitmapDescriptorFactory.HUE_RED;
        dVar.f9895m = BitmapDescriptorFactory.HUE_RED;
        dVar.f9889e = BitmapDescriptorFactory.HUE_RED;
        dVar.f9890f = BitmapDescriptorFactory.HUE_RED;
        dVar.g = BitmapDescriptorFactory.HUE_RED;
        invalidateSelf();
    }
}
