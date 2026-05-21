package x0;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.IOException;
import java.util.ArrayDeque;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: x0.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0959o extends AbstractC0950f {

    /* renamed from: l, reason: collision with root package name */
    public static final PorterDuff.Mode f10416l = PorterDuff.Mode.SRC_IN;

    /* renamed from: d, reason: collision with root package name */
    public C0957m f10417d;

    /* renamed from: e, reason: collision with root package name */
    public PorterDuffColorFilter f10418e;

    /* renamed from: f, reason: collision with root package name */
    public ColorFilter f10419f;
    public boolean g;
    public boolean h;

    /* renamed from: i, reason: collision with root package name */
    public final float[] f10420i;

    /* renamed from: j, reason: collision with root package name */
    public final Matrix f10421j;

    /* renamed from: k, reason: collision with root package name */
    public final Rect f10422k;

    public C0959o() {
        this.h = true;
        this.f10420i = new float[9];
        this.f10421j = new Matrix();
        this.f10422k = new Rect();
        C0957m c0957m = new C0957m();
        c0957m.f10407c = null;
        c0957m.f10408d = f10416l;
        c0957m.f10406b = new C0956l();
        this.f10417d = c0957m;
    }

    public final PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        Drawable drawable = this.f10369c;
        if (drawable == null) {
            return false;
        }
        F.b.b(drawable);
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Paint paint;
        Drawable drawable = this.f10369c;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        Rect rect = this.f10422k;
        copyBounds(rect);
        if (rect.width() <= 0 || rect.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.f10419f;
        if (colorFilter == null) {
            colorFilter = this.f10418e;
        }
        Matrix matrix = this.f10421j;
        canvas.getMatrix(matrix);
        float[] fArr = this.f10420i;
        matrix.getValues(fArr);
        float fAbs = Math.abs(fArr[0]);
        float fAbs2 = Math.abs(fArr[4]);
        float fAbs3 = Math.abs(fArr[1]);
        float fAbs4 = Math.abs(fArr[3]);
        if (fAbs3 != BitmapDescriptorFactory.HUE_RED || fAbs4 != BitmapDescriptorFactory.HUE_RED) {
            fAbs = 1.0f;
            fAbs2 = 1.0f;
        }
        int iWidth = (int) (rect.width() * fAbs);
        int iMin = Math.min(2048, iWidth);
        int iMin2 = Math.min(2048, (int) (rect.height() * fAbs2));
        if (iMin <= 0 || iMin2 <= 0) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(rect.left, rect.top);
        if (isAutoMirrored() && F.c.a(this) == 1) {
            canvas.translate(rect.width(), BitmapDescriptorFactory.HUE_RED);
            canvas.scale(-1.0f, 1.0f);
        }
        rect.offsetTo(0, 0);
        C0957m c0957m = this.f10417d;
        Bitmap bitmap = c0957m.f10410f;
        if (bitmap == null || iMin != bitmap.getWidth() || iMin2 != c0957m.f10410f.getHeight()) {
            c0957m.f10410f = Bitmap.createBitmap(iMin, iMin2, Bitmap.Config.ARGB_8888);
            c0957m.f10413k = true;
        }
        if (this.h) {
            C0957m c0957m2 = this.f10417d;
            if (c0957m2.f10413k || c0957m2.g != c0957m2.f10407c || c0957m2.h != c0957m2.f10408d || c0957m2.f10412j != c0957m2.f10409e || c0957m2.f10411i != c0957m2.f10406b.getRootAlpha()) {
                C0957m c0957m3 = this.f10417d;
                c0957m3.f10410f.eraseColor(0);
                Canvas canvas2 = new Canvas(c0957m3.f10410f);
                C0956l c0956l = c0957m3.f10406b;
                c0956l.a(c0956l.g, C0956l.f10392p, canvas2, iMin, iMin2);
                C0957m c0957m4 = this.f10417d;
                c0957m4.g = c0957m4.f10407c;
                c0957m4.h = c0957m4.f10408d;
                c0957m4.f10411i = c0957m4.f10406b.getRootAlpha();
                c0957m4.f10412j = c0957m4.f10409e;
                c0957m4.f10413k = false;
            }
        } else {
            C0957m c0957m5 = this.f10417d;
            c0957m5.f10410f.eraseColor(0);
            Canvas canvas3 = new Canvas(c0957m5.f10410f);
            C0956l c0956l2 = c0957m5.f10406b;
            c0956l2.a(c0956l2.g, C0956l.f10392p, canvas3, iMin, iMin2);
        }
        C0957m c0957m6 = this.f10417d;
        if (c0957m6.f10406b.getRootAlpha() >= 255 && colorFilter == null) {
            paint = null;
        } else {
            if (c0957m6.f10414l == null) {
                Paint paint2 = new Paint();
                c0957m6.f10414l = paint2;
                paint2.setFilterBitmap(true);
            }
            c0957m6.f10414l.setAlpha(c0957m6.f10406b.getRootAlpha());
            c0957m6.f10414l.setColorFilter(colorFilter);
            paint = c0957m6.f10414l;
        }
        canvas.drawBitmap(c0957m6.f10410f, (Rect) null, rect, paint);
        canvas.restoreToCount(iSave);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        Drawable drawable = this.f10369c;
        return drawable != null ? F.a.a(drawable) : this.f10417d.f10406b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        Drawable drawable = this.f10369c;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f10417d.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        Drawable drawable = this.f10369c;
        return drawable != null ? F.b.c(drawable) : this.f10419f;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.f10369c != null) {
            return new C0958n(this.f10369c.getConstantState());
        }
        this.f10417d.f10405a = getChangingConfigurations();
        return this.f10417d;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        Drawable drawable = this.f10369c;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.f10417d.f10406b.f10399i;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        Drawable drawable = this.f10369c;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.f10417d.f10406b.h;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.f10369c;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.f10369c;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        Drawable drawable = this.f10369c;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        Drawable drawable = this.f10369c;
        return drawable != null ? F.a.d(drawable) : this.f10417d.f10409e;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList colorStateList;
        Drawable drawable = this.f10369c;
        if (drawable != null) {
            return drawable.isStateful();
        }
        if (!super.isStateful()) {
            C0957m c0957m = this.f10417d;
            if (c0957m != null) {
                C0956l c0956l = c0957m.f10406b;
                if (c0956l.n == null) {
                    c0956l.n = Boolean.valueOf(c0956l.g.a());
                }
                if (c0956l.n.booleanValue() || ((colorStateList = this.f10417d.f10407c) != null && colorStateList.isStateful())) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        Drawable drawable = this.f10369c;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.g && super.mutate() == this) {
            C0957m c0957m = this.f10417d;
            C0957m c0957m2 = new C0957m();
            c0957m2.f10407c = null;
            c0957m2.f10408d = f10416l;
            if (c0957m != null) {
                c0957m2.f10405a = c0957m.f10405a;
                C0956l c0956l = new C0956l(c0957m.f10406b);
                c0957m2.f10406b = c0956l;
                if (c0957m.f10406b.f10397e != null) {
                    c0956l.f10397e = new Paint(c0957m.f10406b.f10397e);
                }
                if (c0957m.f10406b.f10396d != null) {
                    c0957m2.f10406b.f10396d = new Paint(c0957m.f10406b.f10396d);
                }
                c0957m2.f10407c = c0957m.f10407c;
                c0957m2.f10408d = c0957m.f10408d;
                c0957m2.f10409e = c0957m.f10409e;
            }
            this.f10417d = c0957m2;
            this.g = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f10369c;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        boolean z4;
        PorterDuff.Mode mode;
        Drawable drawable = this.f10369c;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        C0957m c0957m = this.f10417d;
        ColorStateList colorStateList = c0957m.f10407c;
        if (colorStateList == null || (mode = c0957m.f10408d) == null) {
            z4 = false;
        } else {
            this.f10418e = a(colorStateList, mode);
            invalidateSelf();
            z4 = true;
        }
        C0956l c0956l = c0957m.f10406b;
        if (c0956l.n == null) {
            c0956l.n = Boolean.valueOf(c0956l.g.a());
        }
        if (c0956l.n.booleanValue()) {
            boolean zB = c0957m.f10406b.g.b(iArr);
            c0957m.f10413k |= zB;
            if (zB) {
                invalidateSelf();
                return true;
            }
        }
        return z4;
    }

    @Override // android.graphics.drawable.Drawable
    public final void scheduleSelf(Runnable runnable, long j5) {
        Drawable drawable = this.f10369c;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j5);
        } else {
            super.scheduleSelf(runnable, j5);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i5) {
        Drawable drawable = this.f10369c;
        if (drawable != null) {
            drawable.setAlpha(i5);
        } else if (this.f10417d.f10406b.getRootAlpha() != i5) {
            this.f10417d.f10406b.setRootAlpha(i5);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z4) {
        Drawable drawable = this.f10369c;
        if (drawable != null) {
            F.a.e(drawable, z4);
        } else {
            this.f10417d.f10409e = z4;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f10369c;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f10419f = colorFilter;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i5) {
        Drawable drawable = this.f10369c;
        if (drawable != null) {
            A2.b.x(drawable, i5);
        } else {
            setTintList(ColorStateList.valueOf(i5));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f10369c;
        if (drawable != null) {
            F.b.h(drawable, colorStateList);
            return;
        }
        C0957m c0957m = this.f10417d;
        if (c0957m.f10407c != colorStateList) {
            c0957m.f10407c = colorStateList;
            this.f10418e = a(colorStateList, c0957m.f10408d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f10369c;
        if (drawable != null) {
            F.b.i(drawable, mode);
            return;
        }
        C0957m c0957m = this.f10417d;
        if (c0957m.f10408d != mode) {
            c0957m.f10408d = mode;
            this.f10418e = a(c0957m.f10407c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z4, boolean z5) {
        Drawable drawable = this.f10369c;
        return drawable != null ? drawable.setVisible(z4, z5) : super.setVisible(z4, z5);
    }

    @Override // android.graphics.drawable.Drawable
    public final void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f10369c;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        C0956l c0956l;
        int i5;
        int i6;
        boolean z4;
        int i7;
        boolean z5;
        Paint.Join join;
        Paint.Cap cap;
        Paint.Join join2;
        Drawable drawable = this.f10369c;
        if (drawable != null) {
            F.b.d(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        C0957m c0957m = this.f10417d;
        c0957m.f10406b = new C0956l();
        TypedArray typedArrayF = D.b.f(resources, theme, attributeSet, AbstractC0945a.f10354a);
        C0957m c0957m2 = this.f10417d;
        C0956l c0956l2 = c0957m2.f10406b;
        int i8 = !D.b.c(xmlPullParser, "tintMode") ? -1 : typedArrayF.getInt(6, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        int i9 = 3;
        if (i8 == 3) {
            mode = PorterDuff.Mode.SRC_OVER;
        } else if (i8 != 5) {
            if (i8 != 9) {
                switch (i8) {
                    case o1.f.INTERRUPTED /* 14 */:
                        mode = PorterDuff.Mode.MULTIPLY;
                        break;
                    case 15:
                        mode = PorterDuff.Mode.SCREEN;
                        break;
                    case 16:
                        mode = PorterDuff.Mode.ADD;
                        break;
                }
            } else {
                mode = PorterDuff.Mode.SRC_ATOP;
            }
        }
        c0957m2.f10408d = mode;
        int i10 = 1;
        ColorStateList colorStateListA = null;
        boolean z6 = false;
        if (D.b.c(xmlPullParser, "tint")) {
            TypedValue typedValue = new TypedValue();
            typedArrayF.getValue(1, typedValue);
            int i11 = typedValue.type;
            if (i11 == 2) {
                throw new UnsupportedOperationException("Failed to resolve attribute at index 1: " + typedValue);
            }
            if (i11 >= 28 && i11 <= 31) {
                colorStateListA = ColorStateList.valueOf(typedValue.data);
            } else {
                Resources resources2 = typedArrayF.getResources();
                int resourceId = typedArrayF.getResourceId(1, 0);
                ThreadLocal threadLocal = D.c.f202a;
                try {
                    colorStateListA = D.c.a(resources2, resources2.getXml(resourceId), theme);
                } catch (Exception e5) {
                    Log.e("CSLCompat", "Failed to inflate ColorStateList.", e5);
                }
            }
        }
        ColorStateList colorStateList = colorStateListA;
        if (colorStateList != null) {
            c0957m2.f10407c = colorStateList;
        }
        boolean z7 = c0957m2.f10409e;
        if (D.b.c(xmlPullParser, "autoMirrored")) {
            z7 = typedArrayF.getBoolean(5, z7);
        }
        c0957m2.f10409e = z7;
        float f5 = c0956l2.f10400j;
        if (D.b.c(xmlPullParser, "viewportWidth")) {
            f5 = typedArrayF.getFloat(7, f5);
        }
        c0956l2.f10400j = f5;
        float f6 = c0956l2.f10401k;
        if (D.b.c(xmlPullParser, "viewportHeight")) {
            f6 = typedArrayF.getFloat(8, f6);
        }
        c0956l2.f10401k = f6;
        if (c0956l2.f10400j <= BitmapDescriptorFactory.HUE_RED) {
            throw new XmlPullParserException(typedArrayF.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (f6 > BitmapDescriptorFactory.HUE_RED) {
            c0956l2.h = typedArrayF.getDimension(3, c0956l2.h);
            float dimension = typedArrayF.getDimension(2, c0956l2.f10399i);
            c0956l2.f10399i = dimension;
            if (c0956l2.h <= BitmapDescriptorFactory.HUE_RED) {
                throw new XmlPullParserException(typedArrayF.getPositionDescription() + "<vector> tag requires width > 0");
            }
            if (dimension > BitmapDescriptorFactory.HUE_RED) {
                float alpha = c0956l2.getAlpha();
                if (D.b.c(xmlPullParser, "alpha")) {
                    alpha = typedArrayF.getFloat(4, alpha);
                }
                c0956l2.setAlpha(alpha);
                String string = typedArrayF.getString(0);
                if (string != null) {
                    c0956l2.f10403m = string;
                    c0956l2.f10404o.put(string, c0956l2);
                }
                typedArrayF.recycle();
                c0957m.f10405a = getChangingConfigurations();
                c0957m.f10413k = true;
                C0957m c0957m3 = this.f10417d;
                C0956l c0956l3 = c0957m3.f10406b;
                ArrayDeque arrayDeque = new ArrayDeque();
                arrayDeque.push(c0956l3.g);
                int eventType = xmlPullParser.getEventType();
                int depth = xmlPullParser.getDepth() + 1;
                boolean z8 = true;
                while (eventType != i10 && (xmlPullParser.getDepth() >= depth || eventType != i9)) {
                    if (eventType == 2) {
                        String name = xmlPullParser.getName();
                        C0953i c0953i = (C0953i) arrayDeque.peek();
                        boolean zEquals = "path".equals(name);
                        i5 = depth;
                        q.b bVar = c0956l3.f10404o;
                        if (zEquals) {
                            C0952h c0952h = new C0952h();
                            c0952h.f10371f = BitmapDescriptorFactory.HUE_RED;
                            c0952h.h = 1.0f;
                            c0952h.f10372i = 1.0f;
                            c0952h.f10373j = BitmapDescriptorFactory.HUE_RED;
                            c0952h.f10374k = 1.0f;
                            c0952h.f10375l = BitmapDescriptorFactory.HUE_RED;
                            Paint.Cap cap2 = Paint.Cap.BUTT;
                            c0952h.f10376m = cap2;
                            Paint.Join join3 = Paint.Join.MITER;
                            c0952h.n = join3;
                            c0956l = c0956l3;
                            c0952h.f10377o = 4.0f;
                            TypedArray typedArrayF2 = D.b.f(resources, theme, attributeSet, AbstractC0945a.f10356c);
                            if (D.b.c(xmlPullParser, "pathData")) {
                                String string2 = typedArrayF2.getString(0);
                                if (string2 != null) {
                                    c0952h.f10389b = string2;
                                }
                                String string3 = typedArrayF2.getString(2);
                                if (string3 != null) {
                                    c0952h.f10388a = h4.d.f(string3);
                                }
                                c0952h.g = D.b.b(typedArrayF2, xmlPullParser, theme, "fillColor", 1);
                                float f7 = c0952h.f10372i;
                                if (D.b.c(xmlPullParser, "fillAlpha")) {
                                    f7 = typedArrayF2.getFloat(12, f7);
                                }
                                c0952h.f10372i = f7;
                                int i12 = !D.b.c(xmlPullParser, "strokeLineCap") ? -1 : typedArrayF2.getInt(8, -1);
                                Paint.Cap cap3 = c0952h.f10376m;
                                if (i12 != 0) {
                                    join = join3;
                                    if (i12 != 1) {
                                        cap = i12 != 2 ? cap3 : Paint.Cap.SQUARE;
                                    } else {
                                        cap = Paint.Cap.ROUND;
                                    }
                                } else {
                                    join = join3;
                                    cap = cap2;
                                }
                                c0952h.f10376m = cap;
                                int i13 = !D.b.c(xmlPullParser, "strokeLineJoin") ? -1 : typedArrayF2.getInt(9, -1);
                                Paint.Join join4 = c0952h.n;
                                if (i13 == 0) {
                                    join2 = join;
                                } else if (i13 != 1) {
                                    join2 = i13 != 2 ? join4 : Paint.Join.BEVEL;
                                } else {
                                    join2 = Paint.Join.ROUND;
                                }
                                c0952h.n = join2;
                                float f8 = c0952h.f10377o;
                                if (D.b.c(xmlPullParser, "strokeMiterLimit")) {
                                    f8 = typedArrayF2.getFloat(10, f8);
                                }
                                c0952h.f10377o = f8;
                                c0952h.f10370e = D.b.b(typedArrayF2, xmlPullParser, theme, "strokeColor", 3);
                                float f9 = c0952h.h;
                                if (D.b.c(xmlPullParser, "strokeAlpha")) {
                                    f9 = typedArrayF2.getFloat(11, f9);
                                }
                                c0952h.h = f9;
                                float f10 = c0952h.f10371f;
                                if (D.b.c(xmlPullParser, "strokeWidth")) {
                                    f10 = typedArrayF2.getFloat(4, f10);
                                }
                                c0952h.f10371f = f10;
                                float f11 = c0952h.f10374k;
                                if (D.b.c(xmlPullParser, "trimPathEnd")) {
                                    f11 = typedArrayF2.getFloat(6, f11);
                                }
                                c0952h.f10374k = f11;
                                float f12 = c0952h.f10375l;
                                if (D.b.c(xmlPullParser, "trimPathOffset")) {
                                    f12 = typedArrayF2.getFloat(7, f12);
                                }
                                c0952h.f10375l = f12;
                                float f13 = c0952h.f10373j;
                                if (D.b.c(xmlPullParser, "trimPathStart")) {
                                    f13 = typedArrayF2.getFloat(5, f13);
                                }
                                c0952h.f10373j = f13;
                                int i14 = c0952h.f10390c;
                                if (D.b.c(xmlPullParser, "fillType")) {
                                    i14 = typedArrayF2.getInt(13, i14);
                                }
                                c0952h.f10390c = i14;
                            }
                            typedArrayF2.recycle();
                            c0953i.f10379b.add(c0952h);
                            if (c0952h.getPathName() != null) {
                                bVar.put(c0952h.getPathName(), c0952h);
                            }
                            c0957m3.f10405a |= c0952h.f10391d;
                            z5 = false;
                            i6 = 1;
                            z8 = false;
                        } else {
                            c0956l = c0956l3;
                            if ("clip-path".equals(name)) {
                                C0951g c0951g = new C0951g();
                                if (D.b.c(xmlPullParser, "pathData")) {
                                    TypedArray typedArrayF3 = D.b.f(resources, theme, attributeSet, AbstractC0945a.f10357d);
                                    String string4 = typedArrayF3.getString(0);
                                    if (string4 != null) {
                                        c0951g.f10389b = string4;
                                    }
                                    String string5 = typedArrayF3.getString(1);
                                    if (string5 != null) {
                                        c0951g.f10388a = h4.d.f(string5);
                                    }
                                    c0951g.f10390c = !D.b.c(xmlPullParser, "fillType") ? 0 : typedArrayF3.getInt(2, 0);
                                    typedArrayF3.recycle();
                                }
                                c0953i.f10379b.add(c0951g);
                                if (c0951g.getPathName() != null) {
                                    bVar.put(c0951g.getPathName(), c0951g);
                                }
                                c0957m3.f10405a = c0951g.f10391d | c0957m3.f10405a;
                            } else if ("group".equals(name)) {
                                C0953i c0953i2 = new C0953i();
                                TypedArray typedArrayF4 = D.b.f(resources, theme, attributeSet, AbstractC0945a.f10355b);
                                float f14 = c0953i2.f10380c;
                                if (D.b.c(xmlPullParser, "rotation")) {
                                    f14 = typedArrayF4.getFloat(5, f14);
                                }
                                c0953i2.f10380c = f14;
                                i6 = 1;
                                c0953i2.f10381d = typedArrayF4.getFloat(1, c0953i2.f10381d);
                                c0953i2.f10382e = typedArrayF4.getFloat(2, c0953i2.f10382e);
                                float f15 = c0953i2.f10383f;
                                if (D.b.c(xmlPullParser, "scaleX")) {
                                    f15 = typedArrayF4.getFloat(3, f15);
                                }
                                c0953i2.f10383f = f15;
                                float f16 = c0953i2.g;
                                if (D.b.c(xmlPullParser, "scaleY")) {
                                    f16 = typedArrayF4.getFloat(4, f16);
                                }
                                c0953i2.g = f16;
                                float f17 = c0953i2.h;
                                if (D.b.c(xmlPullParser, "translateX")) {
                                    f17 = typedArrayF4.getFloat(6, f17);
                                }
                                c0953i2.h = f17;
                                float f18 = c0953i2.f10384i;
                                if (D.b.c(xmlPullParser, "translateY")) {
                                    f18 = typedArrayF4.getFloat(7, f18);
                                }
                                c0953i2.f10384i = f18;
                                z5 = false;
                                String string6 = typedArrayF4.getString(0);
                                if (string6 != null) {
                                    c0953i2.f10387l = string6;
                                }
                                c0953i2.c();
                                typedArrayF4.recycle();
                                c0953i.f10379b.add(c0953i2);
                                arrayDeque.push(c0953i2);
                                if (c0953i2.getGroupName() != null) {
                                    bVar.put(c0953i2.getGroupName(), c0953i2);
                                }
                                c0957m3.f10405a = c0953i2.f10386k | c0957m3.f10405a;
                            }
                            z5 = false;
                            i6 = 1;
                        }
                        z4 = z5;
                        i7 = 3;
                    } else {
                        c0956l = c0956l3;
                        i5 = depth;
                        i6 = i10;
                        z4 = z6;
                        i7 = 3;
                        if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                            arrayDeque.pop();
                        }
                    }
                    eventType = xmlPullParser.next();
                    i9 = i7;
                    z6 = z4;
                    i10 = i6;
                    depth = i5;
                    c0956l3 = c0956l;
                }
                if (!z8) {
                    this.f10418e = a(c0957m.f10407c, c0957m.f10408d);
                    return;
                }
                throw new XmlPullParserException("no path defined");
            }
            throw new XmlPullParserException(typedArrayF.getPositionDescription() + "<vector> tag requires height > 0");
        }
        throw new XmlPullParserException(typedArrayF.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
    }

    public C0959o(C0957m c0957m) {
        this.h = true;
        this.f10420i = new float[9];
        this.f10421j = new Matrix();
        this.f10422k = new Rect();
        this.f10417d = c0957m;
        this.f10418e = a(c0957m.f10407c, c0957m.f10408d);
    }
}
