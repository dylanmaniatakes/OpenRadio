package n2;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import m2.C0762a;

/* loaded from: classes.dex */
public final class r extends v {

    /* renamed from: c, reason: collision with root package name */
    public final t f8863c;

    /* renamed from: d, reason: collision with root package name */
    public final float f8864d;

    /* renamed from: e, reason: collision with root package name */
    public final float f8865e;

    public r(t tVar, float f5, float f6) {
        this.f8863c = tVar;
        this.f8864d = f5;
        this.f8865e = f6;
    }

    @Override // n2.v
    public final void a(Matrix matrix, C0762a c0762a, int i5, Canvas canvas) {
        t tVar = this.f8863c;
        float f5 = tVar.f8872c;
        float f6 = this.f8865e;
        float f7 = tVar.f8871b;
        float f8 = this.f8864d;
        RectF rectF = new RectF(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (float) Math.hypot(f5 - f6, f7 - f8), BitmapDescriptorFactory.HUE_RED);
        Matrix matrix2 = this.f8875a;
        matrix2.set(matrix);
        matrix2.preTranslate(f8, f6);
        matrix2.preRotate(b());
        c0762a.getClass();
        rectF.bottom += i5;
        rectF.offset(BitmapDescriptorFactory.HUE_RED, -i5);
        int[] iArr = C0762a.f8548i;
        iArr[0] = c0762a.f8557f;
        iArr[1] = c0762a.f8556e;
        iArr[2] = c0762a.f8555d;
        Paint paint = c0762a.f8554c;
        float f9 = rectF.left;
        paint.setShader(new LinearGradient(f9, rectF.top, f9, rectF.bottom, iArr, C0762a.f8549j, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix2);
        canvas.drawRect(rectF, paint);
        canvas.restore();
    }

    public final float b() {
        t tVar = this.f8863c;
        return (float) Math.toDegrees(Math.atan((tVar.f8872c - this.f8865e) / (tVar.f8871b - this.f8864d)));
    }
}
