package k2;

import D.p;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import android.util.TypedValue;
import com.google.android.gms.internal.measurement.AbstractC0296a2;
import com.google.android.gms.internal.measurement.AbstractC0409x1;
import com.google.android.gms.internal.measurement.D1;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final ColorStateList f7923a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7924b;

    /* renamed from: c, reason: collision with root package name */
    public final int f7925c;

    /* renamed from: d, reason: collision with root package name */
    public final int f7926d;

    /* renamed from: e, reason: collision with root package name */
    public final float f7927e;

    /* renamed from: f, reason: collision with root package name */
    public final float f7928f;
    public final float g;
    public final boolean h;

    /* renamed from: i, reason: collision with root package name */
    public final float f7929i;

    /* renamed from: j, reason: collision with root package name */
    public ColorStateList f7930j;

    /* renamed from: k, reason: collision with root package name */
    public float f7931k;

    /* renamed from: l, reason: collision with root package name */
    public final int f7932l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f7933m = false;
    public Typeface n;

    public d(Context context, int i5) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i5, O1.a.f1995E);
        this.f7931k = typedArrayObtainStyledAttributes.getDimension(0, BitmapDescriptorFactory.HUE_RED);
        this.f7930j = AbstractC0409x1.f(context, typedArrayObtainStyledAttributes, 3);
        AbstractC0409x1.f(context, typedArrayObtainStyledAttributes, 4);
        AbstractC0409x1.f(context, typedArrayObtainStyledAttributes, 5);
        this.f7925c = typedArrayObtainStyledAttributes.getInt(2, 0);
        this.f7926d = typedArrayObtainStyledAttributes.getInt(1, 1);
        int i6 = typedArrayObtainStyledAttributes.hasValue(12) ? 12 : 10;
        this.f7932l = typedArrayObtainStyledAttributes.getResourceId(i6, 0);
        this.f7924b = typedArrayObtainStyledAttributes.getString(i6);
        typedArrayObtainStyledAttributes.getBoolean(14, false);
        this.f7923a = AbstractC0409x1.f(context, typedArrayObtainStyledAttributes, 6);
        this.f7927e = typedArrayObtainStyledAttributes.getFloat(7, BitmapDescriptorFactory.HUE_RED);
        this.f7928f = typedArrayObtainStyledAttributes.getFloat(8, BitmapDescriptorFactory.HUE_RED);
        this.g = typedArrayObtainStyledAttributes.getFloat(9, BitmapDescriptorFactory.HUE_RED);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(i5, O1.a.f2015t);
        this.h = typedArrayObtainStyledAttributes2.hasValue(0);
        this.f7929i = typedArrayObtainStyledAttributes2.getFloat(0, BitmapDescriptorFactory.HUE_RED);
        typedArrayObtainStyledAttributes2.recycle();
    }

    public final void a() {
        String str;
        Typeface typeface = this.n;
        int i5 = this.f7925c;
        if (typeface == null && (str = this.f7924b) != null) {
            this.n = Typeface.create(str, i5);
        }
        if (this.n == null) {
            int i6 = this.f7926d;
            if (i6 == 1) {
                this.n = Typeface.SANS_SERIF;
            } else if (i6 == 2) {
                this.n = Typeface.SERIF;
            } else if (i6 != 3) {
                this.n = Typeface.DEFAULT;
            } else {
                this.n = Typeface.MONOSPACE;
            }
            this.n = Typeface.create(this.n, i5);
        }
    }

    public final Typeface b(Context context) {
        if (this.f7933m) {
            return this.n;
        }
        if (!context.isRestricted()) {
            try {
                Typeface typefaceA = p.a(context, this.f7932l);
                this.n = typefaceA;
                if (typefaceA != null) {
                    this.n = Typeface.create(typefaceA, this.f7925c);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e5) {
                Log.d("TextAppearance", "Error loading font " + this.f7924b, e5);
            }
        }
        a();
        this.f7933m = true;
        return this.n;
    }

    public final void c(Context context, D1 d12) {
        if (d(context)) {
            b(context);
        } else {
            a();
        }
        int i5 = this.f7932l;
        if (i5 == 0) {
            this.f7933m = true;
        }
        if (this.f7933m) {
            d12.m(this.n, true);
            return;
        }
        try {
            b bVar = new b(this, d12);
            ThreadLocal threadLocal = p.f225a;
            if (context.isRestricted()) {
                bVar.a(-4);
            } else {
                p.b(context, i5, new TypedValue(), 0, bVar, false, false);
            }
        } catch (Resources.NotFoundException unused) {
            this.f7933m = true;
            d12.l(1);
        } catch (Exception e5) {
            Log.d("TextAppearance", "Error loading font " + this.f7924b, e5);
            this.f7933m = true;
            d12.l(-3);
        }
    }

    public final boolean d(Context context) {
        Typeface typefaceB = null;
        int i5 = this.f7932l;
        if (i5 != 0) {
            ThreadLocal threadLocal = p.f225a;
            if (!context.isRestricted()) {
                typefaceB = p.b(context, i5, new TypedValue(), 0, null, false, true);
            }
        }
        return typefaceB != null;
    }

    public final void e(Context context, TextPaint textPaint, D1 d12) {
        f(context, textPaint, d12);
        ColorStateList colorStateList = this.f7930j;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        ColorStateList colorStateList2 = this.f7923a;
        textPaint.setShadowLayer(this.g, this.f7927e, this.f7928f, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public final void f(Context context, TextPaint textPaint, D1 d12) {
        if (d(context)) {
            g(context, textPaint, b(context));
            return;
        }
        a();
        g(context, textPaint, this.n);
        c(context, new c(this, context, textPaint, d12));
    }

    public final void g(Context context, TextPaint textPaint, Typeface typeface) {
        Typeface typefaceJ = AbstractC0296a2.j(context.getResources().getConfiguration(), typeface);
        if (typefaceJ != null) {
            typeface = typefaceJ;
        }
        textPaint.setTypeface(typeface);
        int i5 = (~typeface.getStyle()) & this.f7925c;
        textPaint.setFakeBoldText((i5 & 1) != 0);
        textPaint.setTextSkewX((i5 & 2) != 0 ? -0.25f : BitmapDescriptorFactory.HUE_RED);
        textPaint.setTextSize(this.f7931k);
        if (this.h) {
            textPaint.setLetterSpacing(this.f7929i);
        }
    }
}
