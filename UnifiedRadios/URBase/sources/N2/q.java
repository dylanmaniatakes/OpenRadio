package n2;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import m2.C0762a;

/* loaded from: classes.dex */
public final class q extends v {

    /* renamed from: c, reason: collision with root package name */
    public final s f8862c;

    public q(s sVar) {
        this.f8862c = sVar;
    }

    @Override // n2.v
    public final void a(Matrix matrix, C0762a c0762a, int i5, Canvas canvas) {
        s sVar = this.f8862c;
        float f5 = sVar.f8870f;
        float f6 = sVar.g;
        RectF rectF = new RectF(sVar.f8866b, sVar.f8867c, sVar.f8868d, sVar.f8869e);
        c0762a.getClass();
        boolean z4 = f6 < BitmapDescriptorFactory.HUE_RED;
        Path path = c0762a.g;
        int[] iArr = C0762a.f8550k;
        if (z4) {
            iArr[0] = 0;
            iArr[1] = c0762a.f8557f;
            iArr[2] = c0762a.f8556e;
            iArr[3] = c0762a.f8555d;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f5, f6);
            path.close();
            float f7 = -i5;
            rectF.inset(f7, f7);
            iArr[0] = 0;
            iArr[1] = c0762a.f8555d;
            iArr[2] = c0762a.f8556e;
            iArr[3] = c0762a.f8557f;
        }
        float fWidth = rectF.width() / 2.0f;
        if (fWidth <= BitmapDescriptorFactory.HUE_RED) {
            return;
        }
        float f8 = 1.0f - (i5 / fWidth);
        float[] fArr = C0762a.f8551l;
        fArr[1] = f8;
        fArr[2] = ((1.0f - f8) / 2.0f) + f8;
        RadialGradient radialGradient = new RadialGradient(rectF.centerX(), rectF.centerY(), fWidth, iArr, fArr, Shader.TileMode.CLAMP);
        Paint paint = c0762a.f8553b;
        paint.setShader(radialGradient);
        canvas.save();
        canvas.concat(matrix);
        canvas.scale(1.0f, rectF.height() / rectF.width());
        if (!z4) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawPath(path, c0762a.h);
        }
        canvas.drawArc(rectF, f5, f6, true, paint);
        canvas.restore();
    }
}
