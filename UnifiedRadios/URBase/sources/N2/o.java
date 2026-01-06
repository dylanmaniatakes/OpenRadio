package n2;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.google.android.gms.internal.measurement.AbstractC0409x1;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.BitSet;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final w[] f8850a = new w[4];

    /* renamed from: b, reason: collision with root package name */
    public final Matrix[] f8851b = new Matrix[4];

    /* renamed from: c, reason: collision with root package name */
    public final Matrix[] f8852c = new Matrix[4];

    /* renamed from: d, reason: collision with root package name */
    public final PointF f8853d = new PointF();

    /* renamed from: e, reason: collision with root package name */
    public final Path f8854e = new Path();

    /* renamed from: f, reason: collision with root package name */
    public final Path f8855f = new Path();
    public final w g = new w();
    public final float[] h = new float[2];

    /* renamed from: i, reason: collision with root package name */
    public final float[] f8856i = new float[2];

    /* renamed from: j, reason: collision with root package name */
    public final Path f8857j = new Path();

    /* renamed from: k, reason: collision with root package name */
    public final Path f8858k = new Path();

    /* renamed from: l, reason: collision with root package name */
    public final boolean f8859l = true;

    public o() {
        for (int i5 = 0; i5 < 4; i5++) {
            this.f8850a[i5] = new w();
            this.f8851b[i5] = new Matrix();
            this.f8852c[i5] = new Matrix();
        }
    }

    public final void a(m mVar, float f5, RectF rectF, B0.l lVar, Path path) {
        int i5;
        Matrix[] matrixArr;
        float[] fArr;
        Matrix[] matrixArr2;
        w[] wVarArr;
        Path path2;
        Path path3;
        o oVar = this;
        m mVar2 = mVar;
        B0.l lVar2 = lVar;
        path.rewind();
        Path path4 = oVar.f8854e;
        path4.rewind();
        Path path5 = oVar.f8855f;
        path5.rewind();
        path5.addRect(rectF, Path.Direction.CW);
        int i6 = 0;
        while (true) {
            matrixArr = oVar.f8852c;
            fArr = oVar.h;
            matrixArr2 = oVar.f8851b;
            wVarArr = oVar.f8850a;
            if (i6 >= 4) {
                break;
            }
            InterfaceC0804c interfaceC0804c = i6 != 1 ? i6 != 2 ? i6 != 3 ? mVar2.f8844f : mVar2.f8843e : mVar2.h : mVar2.g;
            AbstractC0409x1 abstractC0409x1 = i6 != 1 ? i6 != 2 ? i6 != 3 ? mVar2.f8840b : mVar2.f8839a : mVar2.f8842d : mVar2.f8841c;
            w wVar = wVarArr[i6];
            abstractC0409x1.getClass();
            abstractC0409x1.g(wVar, f5, interfaceC0804c.a(rectF));
            int i7 = i6 + 1;
            float f6 = (i7 % 4) * 90;
            matrixArr2[i6].reset();
            PointF pointF = oVar.f8853d;
            if (i6 == 1) {
                path3 = path4;
                pointF.set(rectF.right, rectF.bottom);
            } else if (i6 == 2) {
                path3 = path4;
                pointF.set(rectF.left, rectF.bottom);
            } else if (i6 != 3) {
                path3 = path4;
                pointF.set(rectF.right, rectF.top);
            } else {
                path3 = path4;
                pointF.set(rectF.left, rectF.top);
            }
            matrixArr2[i6].setTranslate(pointF.x, pointF.y);
            matrixArr2[i6].preRotate(f6);
            w wVar2 = wVarArr[i6];
            fArr[0] = wVar2.f8878c;
            fArr[1] = wVar2.f8879d;
            matrixArr2[i6].mapPoints(fArr);
            matrixArr[i6].reset();
            matrixArr[i6].setTranslate(fArr[0], fArr[1]);
            matrixArr[i6].preRotate(f6);
            i6 = i7;
            path4 = path3;
        }
        Path path6 = path4;
        int i8 = 0;
        for (i5 = 4; i8 < i5; i5 = 4) {
            w wVar3 = wVarArr[i8];
            fArr[0] = wVar3.f8876a;
            fArr[1] = wVar3.f8877b;
            matrixArr2[i8].mapPoints(fArr);
            if (i8 == 0) {
                path.moveTo(fArr[0], fArr[1]);
            } else {
                path.lineTo(fArr[0], fArr[1]);
            }
            wVarArr[i8].b(matrixArr2[i8], path);
            if (lVar2 != null) {
                w wVar4 = wVarArr[i8];
                Matrix matrix = matrixArr2[i8];
                h hVar = (h) lVar2.f110d;
                BitSet bitSet = hVar.f8809f;
                wVar4.getClass();
                bitSet.set(i8, false);
                wVar4.a(wVar4.f8881f);
                hVar.f8807d[i8] = new p(new ArrayList(wVar4.h), new Matrix(matrix));
            }
            int i9 = i8 + 1;
            int i10 = i9 % 4;
            w wVar5 = wVarArr[i8];
            fArr[0] = wVar5.f8878c;
            fArr[1] = wVar5.f8879d;
            matrixArr2[i8].mapPoints(fArr);
            w wVar6 = wVarArr[i10];
            float f7 = wVar6.f8876a;
            float[] fArr2 = oVar.f8856i;
            fArr2[0] = f7;
            fArr2[1] = wVar6.f8877b;
            matrixArr2[i10].mapPoints(fArr2);
            float fMax = Math.max(((float) Math.hypot(fArr[0] - fArr2[0], fArr[1] - fArr2[1])) - 0.001f, BitmapDescriptorFactory.HUE_RED);
            w wVar7 = wVarArr[i8];
            fArr[0] = wVar7.f8878c;
            fArr[1] = wVar7.f8879d;
            matrixArr2[i8].mapPoints(fArr);
            float fAbs = (i8 == 1 || i8 == 3) ? Math.abs(rectF.centerX() - fArr[0]) : Math.abs(rectF.centerY() - fArr[1]);
            w wVar8 = oVar.g;
            wVar8.d(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 270.0f, BitmapDescriptorFactory.HUE_RED);
            e eVar = i8 != 1 ? i8 != 2 ? i8 != 3 ? mVar2.f8846j : mVar2.f8845i : mVar2.f8848l : mVar2.f8847k;
            eVar.e(fMax, fAbs, f5, wVar8);
            Path path7 = oVar.f8857j;
            path7.reset();
            wVar8.b(matrixArr[i8], path7);
            if (oVar.f8859l && (eVar.d() || oVar.b(path7, i8) || oVar.b(path7, i10))) {
                path7.op(path7, path5, Path.Op.DIFFERENCE);
                fArr[0] = wVar8.f8876a;
                fArr[1] = wVar8.f8877b;
                matrixArr[i8].mapPoints(fArr);
                path2 = path6;
                path2.moveTo(fArr[0], fArr[1]);
                wVar8.b(matrixArr[i8], path2);
            } else {
                path2 = path6;
                wVar8.b(matrixArr[i8], path);
            }
            if (lVar != null) {
                Matrix matrix2 = matrixArr[i8];
                h hVar2 = (h) lVar.f110d;
                hVar2.f8809f.set(i8 + 4, false);
                wVar8.a(wVar8.f8881f);
                hVar2.f8808e[i8] = new p(new ArrayList(wVar8.h), new Matrix(matrix2));
            }
            oVar = this;
            mVar2 = mVar;
            lVar2 = lVar;
            path6 = path2;
            i8 = i9;
        }
        Path path8 = path6;
        path.close();
        path8.close();
        if (path8.isEmpty()) {
            return;
        }
        path.op(path8, Path.Op.UNION);
    }

    public final boolean b(Path path, int i5) {
        Path path2 = this.f8858k;
        path2.reset();
        this.f8850a[i5].b(this.f8851b[i5], path2);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        path2.computeBounds(rectF, true);
        path.op(path2, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (rectF.isEmpty()) {
            return rectF.width() > 1.0f && rectF.height() > 1.0f;
        }
        return true;
    }
}
