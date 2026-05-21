package com.unified.ur1.chat;

import O.C0163f0;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* loaded from: classes.dex */
public class TypingBubbleView extends View {

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f5782l = 0;

    /* renamed from: c, reason: collision with root package name */
    public final Paint f5783c;

    /* renamed from: d, reason: collision with root package name */
    public final Paint f5784d;

    /* renamed from: e, reason: collision with root package name */
    public final RectF f5785e;

    /* renamed from: f, reason: collision with root package name */
    public final float[] f5786f;
    public final ValueAnimator g;
    public final float h;

    /* renamed from: i, reason: collision with root package name */
    public final float f5787i;

    /* renamed from: j, reason: collision with root package name */
    public final float f5788j;

    /* renamed from: k, reason: collision with root package name */
    public final float f5789k;

    public TypingBubbleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5786f = new float[]{1.0f, 1.0f, 1.0f};
        this.h = 18.0f;
        this.f5787i = 3.0f;
        this.f5788j = 8.0f;
        this.f5789k = 12.0f;
        Paint paint = new Paint(1);
        this.f5783c = paint;
        paint.setColor(-13882322);
        Paint paint2 = new Paint(1);
        this.f5784d = paint2;
        paint2.setColor(-7434605);
        this.f5785e = new RectF();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(BitmapDescriptorFactory.HUE_RED, 1.0f);
        this.g = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(1200L);
        this.g.setRepeatCount(-1);
        this.g.setInterpolator(new AccelerateDecelerateInterpolator());
        this.g.addUpdateListener(new C0163f0(1, this));
    }

    public final void a() {
        ValueAnimator valueAnimator = this.g;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.g.cancel();
        }
        int i5 = 0;
        while (true) {
            float[] fArr = this.f5786f;
            if (i5 >= fArr.length) {
                invalidate();
                return;
            } else {
                fArr[i5] = 1.0f;
                i5++;
            }
        }
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getVisibility() != 0) {
            return;
        }
        float width = getWidth() / 2.0f;
        float height = getHeight() / 2.0f;
        float f5 = this.f5787i;
        float f6 = this.f5788j;
        float f7 = this.f5789k;
        float f8 = ((f7 * 2.0f) + ((f6 * 2.0f) + ((f5 * 2.0f) * 3.0f))) / 2.0f;
        float f9 = ((f7 * 2.0f) + (f5 * 2.0f)) / 2.0f;
        this.f5785e.set(width - f8, height - f9, f8 + width, f9 + height);
        RectF rectF = this.f5785e;
        Paint paint = this.f5783c;
        float f10 = this.h;
        canvas.drawRoundRect(rectF, f10, f10, paint);
        float f11 = width - f6;
        for (int i5 = 0; i5 < 3; i5++) {
            canvas.drawCircle((i5 * f6) + f11, height, this.f5786f[i5] * f5, this.f5784d);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i5, int i6) {
        float f5 = this.f5787i;
        float f6 = (this.f5788j * 2.0f) + (f5 * 2.0f * 3.0f);
        float f7 = this.f5789k;
        setMeasuredDimension((int) ((f7 * 2.0f) + f6 + getPaddingLeft() + getPaddingRight()), (int) ((f7 * 2.0f) + (f5 * 2.0f) + getPaddingTop() + getPaddingBottom()));
    }
}
