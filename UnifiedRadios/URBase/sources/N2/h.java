package n2;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import com.google.android.gms.internal.measurement.AbstractC0296a2;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import d2.C0428a;
import java.util.BitSet;
import m2.C0762a;
import w1.AbstractC0930a;

/* loaded from: classes.dex */
public class h extends Drawable implements x {

    /* renamed from: y, reason: collision with root package name */
    public static final Paint f8805y;

    /* renamed from: c, reason: collision with root package name */
    public g f8806c;

    /* renamed from: d, reason: collision with root package name */
    public final v[] f8807d;

    /* renamed from: e, reason: collision with root package name */
    public final v[] f8808e;

    /* renamed from: f, reason: collision with root package name */
    public final BitSet f8809f;
    public boolean g;
    public final Matrix h;

    /* renamed from: i, reason: collision with root package name */
    public final Path f8810i;

    /* renamed from: j, reason: collision with root package name */
    public final Path f8811j;

    /* renamed from: k, reason: collision with root package name */
    public final RectF f8812k;

    /* renamed from: l, reason: collision with root package name */
    public final RectF f8813l;

    /* renamed from: m, reason: collision with root package name */
    public final Region f8814m;
    public final Region n;

    /* renamed from: o, reason: collision with root package name */
    public m f8815o;

    /* renamed from: p, reason: collision with root package name */
    public final Paint f8816p;

    /* renamed from: q, reason: collision with root package name */
    public final Paint f8817q;

    /* renamed from: r, reason: collision with root package name */
    public final C0762a f8818r;

    /* renamed from: s, reason: collision with root package name */
    public final B0.l f8819s;

    /* renamed from: t, reason: collision with root package name */
    public final o f8820t;

    /* renamed from: u, reason: collision with root package name */
    public PorterDuffColorFilter f8821u;

    /* renamed from: v, reason: collision with root package name */
    public PorterDuffColorFilter f8822v;

    /* renamed from: w, reason: collision with root package name */
    public final RectF f8823w;

    /* renamed from: x, reason: collision with root package name */
    public final boolean f8824x;

    static {
        Paint paint = new Paint(1);
        f8805y = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public h() {
        this(new m());
    }

    public void a() {
        invalidateSelf();
    }

    public final void b(RectF rectF, Path path) {
        g gVar = this.f8806c;
        this.f8820t.a(gVar.f8787a, gVar.f8794j, rectF, this.f8819s, path);
        if (this.f8806c.f8793i != 1.0f) {
            Matrix matrix = this.h;
            matrix.reset();
            float f5 = this.f8806c.f8793i;
            matrix.setScale(f5, f5, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(matrix);
        }
        path.computeBounds(this.f8823w, true);
    }

    public final PorterDuffColorFilter c(ColorStateList colorStateList, PorterDuff.Mode mode, Paint paint, boolean z4) {
        int color;
        int iD;
        if (colorStateList == null || mode == null) {
            return (!z4 || (iD = d((color = paint.getColor()))) == color) ? null : new PorterDuffColorFilter(iD, PorterDuff.Mode.SRC_IN);
        }
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z4) {
            colorForState = d(colorForState);
        }
        return new PorterDuffColorFilter(colorForState, mode);
    }

    public final int d(int i5) {
        int i6;
        g gVar = this.f8806c;
        float f5 = gVar.n + gVar.f8798o + gVar.f8797m;
        C0428a c0428a = gVar.f8788b;
        if (c0428a == null || !c0428a.f6108a || E.a.d(i5, 255) != c0428a.f6111d) {
            return i5;
        }
        float fMin = (c0428a.f6112e <= BitmapDescriptorFactory.HUE_RED || f5 <= BitmapDescriptorFactory.HUE_RED) ? 0.0f : Math.min(((((float) Math.log1p(f5 / r3)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
        int iAlpha = Color.alpha(i5);
        int iH = AbstractC0296a2.h(fMin, E.a.d(i5, 255), c0428a.f6109b);
        if (fMin > BitmapDescriptorFactory.HUE_RED && (i6 = c0428a.f6110c) != 0) {
            iH = E.a.b(E.a.d(i6, C0428a.f6107f), iH);
        }
        return E.a.d(iH, iAlpha);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00f3  */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void draw(android.graphics.Canvas r19) {
        /*
            Method dump skipped, instructions count: 465
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n2.h.draw(android.graphics.Canvas):void");
    }

    public final void e(Canvas canvas) {
        if (this.f8809f.cardinality() > 0) {
            Log.w("h", "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        int i5 = this.f8806c.f8801r;
        Path path = this.f8810i;
        C0762a c0762a = this.f8818r;
        if (i5 != 0) {
            canvas.drawPath(path, c0762a.f8552a);
        }
        for (int i6 = 0; i6 < 4; i6++) {
            v vVar = this.f8807d[i6];
            int i7 = this.f8806c.f8800q;
            Matrix matrix = v.f8874b;
            vVar.a(matrix, c0762a, i7, canvas);
            this.f8808e[i6].a(matrix, c0762a, this.f8806c.f8800q, canvas);
        }
        if (this.f8824x) {
            g gVar = this.f8806c;
            int iSin = (int) (Math.sin(Math.toRadians(gVar.f8802s)) * gVar.f8801r);
            g gVar2 = this.f8806c;
            int iCos = (int) (Math.cos(Math.toRadians(gVar2.f8802s)) * gVar2.f8801r);
            canvas.translate(-iSin, -iCos);
            canvas.drawPath(path, f8805y);
            canvas.translate(iSin, iCos);
        }
    }

    public final void f(Canvas canvas, Paint paint, Path path, m mVar, RectF rectF) {
        if (!mVar.d(rectF)) {
            canvas.drawPath(path, paint);
        } else {
            float fA = mVar.f8844f.a(rectF) * this.f8806c.f8794j;
            canvas.drawRoundRect(rectF, fA, fA, paint);
        }
    }

    public void g(Canvas canvas) {
        Paint paint = this.f8817q;
        Path path = this.f8811j;
        m mVar = this.f8815o;
        RectF rectF = this.f8813l;
        rectF.set(h());
        float strokeWidth = i() ? paint.getStrokeWidth() / 2.0f : BitmapDescriptorFactory.HUE_RED;
        rectF.inset(strokeWidth, strokeWidth);
        f(canvas, paint, path, mVar, rectF);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f8806c.f8796l;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.f8806c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        g gVar = this.f8806c;
        if (gVar.f8799p == 2) {
            return;
        }
        if (gVar.f8787a.d(h())) {
            outline.setRoundRect(getBounds(), this.f8806c.f8787a.f8843e.a(h()) * this.f8806c.f8794j);
        } else {
            RectF rectFH = h();
            Path path = this.f8810i;
            b(rectFH, path);
            AbstractC0930a.o(outline, path);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        Rect rect2 = this.f8806c.h;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final Region getTransparentRegion() {
        Rect bounds = getBounds();
        Region region = this.f8814m;
        region.set(bounds);
        RectF rectFH = h();
        Path path = this.f8810i;
        b(rectFH, path);
        Region region2 = this.n;
        region2.setPath(path, region);
        region.op(region2, Region.Op.DIFFERENCE);
        return region;
    }

    public final RectF h() {
        RectF rectF = this.f8812k;
        rectF.set(getBounds());
        return rectF;
    }

    public final boolean i() {
        Paint.Style style = this.f8806c.f8804u;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.f8817q.getStrokeWidth() > BitmapDescriptorFactory.HUE_RED;
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        this.g = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        return super.isStateful() || ((colorStateList = this.f8806c.f8792f) != null && colorStateList.isStateful()) || (((colorStateList2 = this.f8806c.f8791e) != null && colorStateList2.isStateful()) || (((colorStateList3 = this.f8806c.f8790d) != null && colorStateList3.isStateful()) || ((colorStateList4 = this.f8806c.f8789c) != null && colorStateList4.isStateful())));
    }

    public final void j(Context context) {
        this.f8806c.f8788b = new C0428a(context);
        q();
    }

    public final void k(float f5) {
        g gVar = this.f8806c;
        if (gVar.n != f5) {
            gVar.n = f5;
            q();
        }
    }

    public final void l(ColorStateList colorStateList) {
        g gVar = this.f8806c;
        if (gVar.f8789c != colorStateList) {
            gVar.f8789c = colorStateList;
            onStateChange(getState());
        }
    }

    public final void m() {
        g gVar = this.f8806c;
        if (gVar.f8799p != 2) {
            gVar.f8799p = 2;
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f8806c = new g(this.f8806c);
        return this;
    }

    public final void n(ColorStateList colorStateList) {
        g gVar = this.f8806c;
        if (gVar.f8790d != colorStateList) {
            gVar.f8790d = colorStateList;
            onStateChange(getState());
        }
    }

    public final boolean o(int[] iArr) {
        boolean z4;
        Paint paint;
        int color;
        int colorForState;
        Paint paint2;
        int color2;
        int colorForState2;
        if (this.f8806c.f8789c == null || color2 == (colorForState2 = this.f8806c.f8789c.getColorForState(iArr, (color2 = (paint2 = this.f8816p).getColor())))) {
            z4 = false;
        } else {
            paint2.setColor(colorForState2);
            z4 = true;
        }
        if (this.f8806c.f8790d == null || color == (colorForState = this.f8806c.f8790d.getColorForState(iArr, (color = (paint = this.f8817q).getColor())))) {
            return z4;
        }
        paint.setColor(colorForState);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.g = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable, g2.InterfaceC0545i
    public boolean onStateChange(int[] iArr) {
        boolean z4 = o(iArr) || p();
        if (z4) {
            invalidateSelf();
        }
        return z4;
    }

    public final boolean p() {
        PorterDuffColorFilter porterDuffColorFilter = this.f8821u;
        PorterDuffColorFilter porterDuffColorFilter2 = this.f8822v;
        g gVar = this.f8806c;
        this.f8821u = c(gVar.f8792f, gVar.g, this.f8816p, true);
        g gVar2 = this.f8806c;
        this.f8822v = c(gVar2.f8791e, gVar2.g, this.f8817q, false);
        g gVar3 = this.f8806c;
        if (gVar3.f8803t) {
            this.f8818r.a(gVar3.f8792f.getColorForState(getState(), 0));
        }
        return (N.b.a(porterDuffColorFilter, this.f8821u) && N.b.a(porterDuffColorFilter2, this.f8822v)) ? false : true;
    }

    public final void q() {
        g gVar = this.f8806c;
        float f5 = gVar.n + gVar.f8798o;
        gVar.f8800q = (int) Math.ceil(0.75f * f5);
        this.f8806c.f8801r = (int) Math.ceil(f5 * 0.25f);
        p();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i5) {
        g gVar = this.f8806c;
        if (gVar.f8796l != i5) {
            gVar.f8796l = i5;
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f8806c.getClass();
        super.invalidateSelf();
    }

    @Override // n2.x
    public final void setShapeAppearanceModel(m mVar) {
        this.f8806c.f8787a = mVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i5) {
        setTintList(ColorStateList.valueOf(i5));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f8806c.f8792f = colorStateList;
        p();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        g gVar = this.f8806c;
        if (gVar.g != mode) {
            gVar.g = mode;
            p();
            super.invalidateSelf();
        }
    }

    public h(Context context, AttributeSet attributeSet, int i5, int i6) {
        this(m.b(context, attributeSet, i5, i6).a());
    }

    public h(m mVar) {
        this(new g(mVar));
    }

    public h(g gVar) {
        o oVar;
        this.f8807d = new v[4];
        this.f8808e = new v[4];
        this.f8809f = new BitSet(8);
        this.h = new Matrix();
        this.f8810i = new Path();
        this.f8811j = new Path();
        this.f8812k = new RectF();
        this.f8813l = new RectF();
        this.f8814m = new Region();
        this.n = new Region();
        Paint paint = new Paint(1);
        this.f8816p = paint;
        Paint paint2 = new Paint(1);
        this.f8817q = paint2;
        this.f8818r = new C0762a();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            oVar = n.f8849a;
        } else {
            oVar = new o();
        }
        this.f8820t = oVar;
        this.f8823w = new RectF();
        this.f8824x = true;
        this.f8806c = gVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        p();
        o(getState());
        this.f8819s = new B0.l(23, this);
    }
}
