package g2;

import O.G;
import O.H;
import O.Y;
import a0.C0204a;
import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import com.google.android.gms.internal.measurement.AbstractC0296a2;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.WeakHashMap;
import k2.C0671a;

/* renamed from: g2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0538b {

    /* renamed from: A, reason: collision with root package name */
    public CharSequence f6868A;

    /* renamed from: B, reason: collision with root package name */
    public CharSequence f6869B;

    /* renamed from: C, reason: collision with root package name */
    public boolean f6870C;

    /* renamed from: E, reason: collision with root package name */
    public Bitmap f6872E;

    /* renamed from: F, reason: collision with root package name */
    public float f6873F;

    /* renamed from: G, reason: collision with root package name */
    public float f6874G;

    /* renamed from: H, reason: collision with root package name */
    public float f6875H;
    public float I;

    /* renamed from: J, reason: collision with root package name */
    public float f6876J;

    /* renamed from: K, reason: collision with root package name */
    public int f6877K;

    /* renamed from: L, reason: collision with root package name */
    public int[] f6878L;

    /* renamed from: M, reason: collision with root package name */
    public boolean f6879M;

    /* renamed from: N, reason: collision with root package name */
    public final TextPaint f6880N;

    /* renamed from: O, reason: collision with root package name */
    public final TextPaint f6881O;

    /* renamed from: P, reason: collision with root package name */
    public TimeInterpolator f6882P;

    /* renamed from: Q, reason: collision with root package name */
    public TimeInterpolator f6883Q;

    /* renamed from: R, reason: collision with root package name */
    public float f6884R;

    /* renamed from: S, reason: collision with root package name */
    public float f6885S;

    /* renamed from: T, reason: collision with root package name */
    public float f6886T;

    /* renamed from: U, reason: collision with root package name */
    public ColorStateList f6887U;

    /* renamed from: V, reason: collision with root package name */
    public float f6888V;

    /* renamed from: W, reason: collision with root package name */
    public float f6889W;

    /* renamed from: X, reason: collision with root package name */
    public float f6890X;

    /* renamed from: Y, reason: collision with root package name */
    public StaticLayout f6891Y;

    /* renamed from: Z, reason: collision with root package name */
    public float f6892Z;

    /* renamed from: a, reason: collision with root package name */
    public final View f6893a;

    /* renamed from: a0, reason: collision with root package name */
    public float f6894a0;

    /* renamed from: b, reason: collision with root package name */
    public float f6895b;

    /* renamed from: b0, reason: collision with root package name */
    public float f6896b0;

    /* renamed from: c, reason: collision with root package name */
    public final Rect f6897c;

    /* renamed from: c0, reason: collision with root package name */
    public CharSequence f6898c0;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f6899d;

    /* renamed from: e, reason: collision with root package name */
    public final RectF f6901e;

    /* renamed from: j, reason: collision with root package name */
    public ColorStateList f6906j;

    /* renamed from: k, reason: collision with root package name */
    public ColorStateList f6907k;

    /* renamed from: l, reason: collision with root package name */
    public float f6908l;

    /* renamed from: m, reason: collision with root package name */
    public float f6909m;
    public float n;

    /* renamed from: o, reason: collision with root package name */
    public float f6910o;

    /* renamed from: p, reason: collision with root package name */
    public float f6911p;

    /* renamed from: q, reason: collision with root package name */
    public float f6912q;

    /* renamed from: r, reason: collision with root package name */
    public Typeface f6913r;

    /* renamed from: s, reason: collision with root package name */
    public Typeface f6914s;

    /* renamed from: t, reason: collision with root package name */
    public Typeface f6915t;

    /* renamed from: u, reason: collision with root package name */
    public Typeface f6916u;

    /* renamed from: v, reason: collision with root package name */
    public Typeface f6917v;

    /* renamed from: w, reason: collision with root package name */
    public Typeface f6918w;

    /* renamed from: x, reason: collision with root package name */
    public Typeface f6919x;

    /* renamed from: y, reason: collision with root package name */
    public C0671a f6920y;

    /* renamed from: f, reason: collision with root package name */
    public int f6903f = 16;
    public int g = 16;
    public float h = 15.0f;

    /* renamed from: i, reason: collision with root package name */
    public float f6905i = 15.0f;

    /* renamed from: z, reason: collision with root package name */
    public final TextUtils.TruncateAt f6921z = TextUtils.TruncateAt.END;

    /* renamed from: D, reason: collision with root package name */
    public final boolean f6871D = true;

    /* renamed from: d0, reason: collision with root package name */
    public final int f6900d0 = 1;

    /* renamed from: e0, reason: collision with root package name */
    public final float f6902e0 = 1.0f;

    /* renamed from: f0, reason: collision with root package name */
    public final int f6904f0 = 1;

    public C0538b(View view) {
        this.f6893a = view;
        TextPaint textPaint = new TextPaint(129);
        this.f6880N = textPaint;
        this.f6881O = new TextPaint(textPaint);
        this.f6899d = new Rect();
        this.f6897c = new Rect();
        this.f6901e = new RectF();
        g(view.getContext().getResources().getConfiguration());
    }

    public static int a(float f5, int i5, int i6) {
        float f6 = 1.0f - f5;
        return Color.argb(Math.round((Color.alpha(i6) * f5) + (Color.alpha(i5) * f6)), Math.round((Color.red(i6) * f5) + (Color.red(i5) * f6)), Math.round((Color.green(i6) * f5) + (Color.green(i5) * f6)), Math.round((Color.blue(i6) * f5) + (Color.blue(i5) * f6)));
    }

    public static float f(float f5, float f6, float f7, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f7 = timeInterpolator.getInterpolation(f7);
        }
        return P1.a.a(f5, f6, f7);
    }

    public final boolean b(CharSequence charSequence) {
        WeakHashMap weakHashMap = Y.f1904a;
        boolean z4 = H.d(this.f6893a) == 1;
        if (this.f6871D) {
            return (z4 ? M.h.f1661d : M.h.f1660c).c(charSequence, charSequence.length());
        }
        return z4;
    }

    public final void c(float f5, boolean z4) {
        float f6;
        float f7;
        Typeface typeface;
        boolean z5;
        Layout.Alignment alignment;
        if (this.f6868A == null) {
            return;
        }
        float fWidth = this.f6899d.width();
        float fWidth2 = this.f6897c.width();
        if (Math.abs(f5 - 1.0f) < 1.0E-5f) {
            f6 = this.f6905i;
            f7 = this.f6888V;
            this.f6873F = 1.0f;
            typeface = this.f6913r;
        } else {
            float f8 = this.h;
            float f9 = this.f6889W;
            Typeface typeface2 = this.f6916u;
            if (Math.abs(f5 - BitmapDescriptorFactory.HUE_RED) < 1.0E-5f) {
                this.f6873F = 1.0f;
            } else {
                this.f6873F = f(this.h, this.f6905i, f5, this.f6883Q) / this.h;
            }
            float f10 = this.f6905i / this.h;
            fWidth = (z4 || fWidth2 * f10 <= fWidth) ? fWidth2 : Math.min(fWidth / f10, fWidth2);
            f6 = f8;
            f7 = f9;
            typeface = typeface2;
        }
        TextPaint textPaint = this.f6880N;
        if (fWidth > BitmapDescriptorFactory.HUE_RED) {
            boolean z6 = this.f6874G != f6;
            boolean z7 = this.f6890X != f7;
            boolean z8 = this.f6919x != typeface;
            StaticLayout staticLayout = this.f6891Y;
            boolean z9 = z6 || z7 || (staticLayout != null && (fWidth > ((float) staticLayout.getWidth()) ? 1 : (fWidth == ((float) staticLayout.getWidth()) ? 0 : -1)) != 0) || z8 || this.f6879M;
            this.f6874G = f6;
            this.f6890X = f7;
            this.f6919x = typeface;
            this.f6879M = false;
            textPaint.setLinearText(this.f6873F != 1.0f);
            z5 = z9;
        } else {
            z5 = false;
        }
        if (this.f6869B == null || z5) {
            textPaint.setTextSize(this.f6874G);
            textPaint.setTypeface(this.f6919x);
            textPaint.setLetterSpacing(this.f6890X);
            boolean zB = b(this.f6868A);
            this.f6870C = zB;
            int i5 = this.f6900d0;
            if (i5 <= 1 || zB) {
                i5 = 1;
            }
            if (i5 == 1) {
                alignment = Layout.Alignment.ALIGN_NORMAL;
            } else {
                int absoluteGravity = Gravity.getAbsoluteGravity(this.f6903f, zB ? 1 : 0) & 7;
                alignment = absoluteGravity != 1 ? absoluteGravity != 5 ? this.f6870C ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : this.f6870C ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_CENTER;
            }
            C0544h c0544h = new C0544h(this.f6868A, textPaint, (int) fWidth);
            c0544h.f6939l = this.f6921z;
            c0544h.f6938k = zB;
            c0544h.f6934e = alignment;
            c0544h.f6937j = false;
            c0544h.f6935f = i5;
            float f11 = this.f6902e0;
            c0544h.g = BitmapDescriptorFactory.HUE_RED;
            c0544h.h = f11;
            c0544h.f6936i = this.f6904f0;
            StaticLayout staticLayoutA = c0544h.a();
            staticLayoutA.getClass();
            this.f6891Y = staticLayoutA;
            this.f6869B = staticLayoutA.getText();
        }
    }

    public final float d() {
        TextPaint textPaint = this.f6881O;
        textPaint.setTextSize(this.f6905i);
        textPaint.setTypeface(this.f6913r);
        textPaint.setLetterSpacing(this.f6888V);
        return -textPaint.ascent();
    }

    public final int e(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.f6878L;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    public final void g(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            Typeface typeface = this.f6915t;
            if (typeface != null) {
                this.f6914s = AbstractC0296a2.j(configuration, typeface);
            }
            Typeface typeface2 = this.f6918w;
            if (typeface2 != null) {
                this.f6917v = AbstractC0296a2.j(configuration, typeface2);
            }
            Typeface typeface3 = this.f6914s;
            if (typeface3 == null) {
                typeface3 = this.f6915t;
            }
            this.f6913r = typeface3;
            Typeface typeface4 = this.f6917v;
            if (typeface4 == null) {
                typeface4 = this.f6918w;
            }
            this.f6916u = typeface4;
            h(true);
        }
    }

    public final void h(boolean z4) {
        float fMeasureText;
        StaticLayout staticLayout;
        View view = this.f6893a;
        if ((view.getHeight() <= 0 || view.getWidth() <= 0) && !z4) {
            return;
        }
        c(1.0f, z4);
        CharSequence charSequence = this.f6869B;
        TextPaint textPaint = this.f6880N;
        if (charSequence != null && (staticLayout = this.f6891Y) != null) {
            this.f6898c0 = TextUtils.ellipsize(charSequence, textPaint, staticLayout.getWidth(), this.f6921z);
        }
        CharSequence charSequence2 = this.f6898c0;
        if (charSequence2 != null) {
            this.f6892Z = textPaint.measureText(charSequence2, 0, charSequence2.length());
        } else {
            this.f6892Z = BitmapDescriptorFactory.HUE_RED;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(this.g, this.f6870C ? 1 : 0);
        int i5 = absoluteGravity & 112;
        Rect rect = this.f6899d;
        if (i5 == 48) {
            this.f6909m = rect.top;
        } else if (i5 != 80) {
            this.f6909m = rect.centerY() - ((textPaint.descent() - textPaint.ascent()) / 2.0f);
        } else {
            this.f6909m = textPaint.ascent() + rect.bottom;
        }
        int i6 = absoluteGravity & 8388615;
        if (i6 == 1) {
            this.f6910o = rect.centerX() - (this.f6892Z / 2.0f);
        } else if (i6 != 5) {
            this.f6910o = rect.left;
        } else {
            this.f6910o = rect.right - this.f6892Z;
        }
        c(BitmapDescriptorFactory.HUE_RED, z4);
        float height = this.f6891Y != null ? r1.getHeight() : 0.0f;
        StaticLayout staticLayout2 = this.f6891Y;
        if (staticLayout2 == null || this.f6900d0 <= 1) {
            CharSequence charSequence3 = this.f6869B;
            fMeasureText = charSequence3 != null ? textPaint.measureText(charSequence3, 0, charSequence3.length()) : 0.0f;
        } else {
            fMeasureText = staticLayout2.getWidth();
        }
        StaticLayout staticLayout3 = this.f6891Y;
        if (staticLayout3 != null) {
            staticLayout3.getLineCount();
        }
        int absoluteGravity2 = Gravity.getAbsoluteGravity(this.f6903f, this.f6870C ? 1 : 0);
        int i7 = absoluteGravity2 & 112;
        Rect rect2 = this.f6897c;
        if (i7 == 48) {
            this.f6908l = rect2.top;
        } else if (i7 != 80) {
            this.f6908l = rect2.centerY() - (height / 2.0f);
        } else {
            this.f6908l = textPaint.descent() + (rect2.bottom - height);
        }
        int i8 = absoluteGravity2 & 8388615;
        if (i8 == 1) {
            this.n = rect2.centerX() - (fMeasureText / 2.0f);
        } else if (i8 != 5) {
            this.n = rect2.left;
        } else {
            this.n = rect2.right - fMeasureText;
        }
        Bitmap bitmap = this.f6872E;
        if (bitmap != null) {
            bitmap.recycle();
            this.f6872E = null;
        }
        l(this.f6895b);
        float f5 = this.f6895b;
        float f6 = f(rect2.left, rect.left, f5, this.f6882P);
        RectF rectF = this.f6901e;
        rectF.left = f6;
        rectF.top = f(this.f6908l, this.f6909m, f5, this.f6882P);
        rectF.right = f(rect2.right, rect.right, f5, this.f6882P);
        rectF.bottom = f(rect2.bottom, rect.bottom, f5, this.f6882P);
        this.f6911p = f(this.n, this.f6910o, f5, this.f6882P);
        this.f6912q = f(this.f6908l, this.f6909m, f5, this.f6882P);
        l(f5);
        C0204a c0204a = P1.a.f2065b;
        this.f6894a0 = 1.0f - f(BitmapDescriptorFactory.HUE_RED, 1.0f, 1.0f - f5, c0204a);
        WeakHashMap weakHashMap = Y.f1904a;
        G.k(view);
        this.f6896b0 = f(1.0f, BitmapDescriptorFactory.HUE_RED, f5, c0204a);
        G.k(view);
        ColorStateList colorStateList = this.f6907k;
        ColorStateList colorStateList2 = this.f6906j;
        if (colorStateList != colorStateList2) {
            textPaint.setColor(a(f5, e(colorStateList2), e(this.f6907k)));
        } else {
            textPaint.setColor(e(colorStateList));
        }
        float f7 = this.f6888V;
        float f8 = this.f6889W;
        if (f7 != f8) {
            textPaint.setLetterSpacing(f(f8, f7, f5, c0204a));
        } else {
            textPaint.setLetterSpacing(f7);
        }
        this.f6875H = P1.a.a(BitmapDescriptorFactory.HUE_RED, this.f6884R, f5);
        this.I = P1.a.a(BitmapDescriptorFactory.HUE_RED, this.f6885S, f5);
        this.f6876J = P1.a.a(BitmapDescriptorFactory.HUE_RED, this.f6886T, f5);
        int iA = a(f5, 0, e(this.f6887U));
        this.f6877K = iA;
        textPaint.setShadowLayer(this.f6875H, this.I, this.f6876J, iA);
        G.k(view);
    }

    public final void i(ColorStateList colorStateList) {
        if (this.f6907k == colorStateList && this.f6906j == colorStateList) {
            return;
        }
        this.f6907k = colorStateList;
        this.f6906j = colorStateList;
        h(false);
    }

    public final boolean j(Typeface typeface) {
        C0671a c0671a = this.f6920y;
        if (c0671a != null) {
            c0671a.f7917d = true;
        }
        if (this.f6915t == typeface) {
            return false;
        }
        this.f6915t = typeface;
        Typeface typefaceJ = AbstractC0296a2.j(this.f6893a.getContext().getResources().getConfiguration(), typeface);
        this.f6914s = typefaceJ;
        if (typefaceJ == null) {
            typefaceJ = this.f6915t;
        }
        this.f6913r = typefaceJ;
        return true;
    }

    public final void k(float f5) {
        if (f5 < BitmapDescriptorFactory.HUE_RED) {
            f5 = 0.0f;
        } else if (f5 > 1.0f) {
            f5 = 1.0f;
        }
        if (f5 != this.f6895b) {
            this.f6895b = f5;
            float f6 = this.f6897c.left;
            Rect rect = this.f6899d;
            float f7 = f(f6, rect.left, f5, this.f6882P);
            RectF rectF = this.f6901e;
            rectF.left = f7;
            rectF.top = f(this.f6908l, this.f6909m, f5, this.f6882P);
            rectF.right = f(r1.right, rect.right, f5, this.f6882P);
            rectF.bottom = f(r1.bottom, rect.bottom, f5, this.f6882P);
            this.f6911p = f(this.n, this.f6910o, f5, this.f6882P);
            this.f6912q = f(this.f6908l, this.f6909m, f5, this.f6882P);
            l(f5);
            C0204a c0204a = P1.a.f2065b;
            this.f6894a0 = 1.0f - f(BitmapDescriptorFactory.HUE_RED, 1.0f, 1.0f - f5, c0204a);
            WeakHashMap weakHashMap = Y.f1904a;
            View view = this.f6893a;
            G.k(view);
            this.f6896b0 = f(1.0f, BitmapDescriptorFactory.HUE_RED, f5, c0204a);
            G.k(view);
            ColorStateList colorStateList = this.f6907k;
            ColorStateList colorStateList2 = this.f6906j;
            TextPaint textPaint = this.f6880N;
            if (colorStateList != colorStateList2) {
                textPaint.setColor(a(f5, e(colorStateList2), e(this.f6907k)));
            } else {
                textPaint.setColor(e(colorStateList));
            }
            float f8 = this.f6888V;
            float f9 = this.f6889W;
            if (f8 != f9) {
                textPaint.setLetterSpacing(f(f9, f8, f5, c0204a));
            } else {
                textPaint.setLetterSpacing(f8);
            }
            this.f6875H = P1.a.a(BitmapDescriptorFactory.HUE_RED, this.f6884R, f5);
            this.I = P1.a.a(BitmapDescriptorFactory.HUE_RED, this.f6885S, f5);
            this.f6876J = P1.a.a(BitmapDescriptorFactory.HUE_RED, this.f6886T, f5);
            int iA = a(f5, 0, e(this.f6887U));
            this.f6877K = iA;
            textPaint.setShadowLayer(this.f6875H, this.I, this.f6876J, iA);
            G.k(view);
        }
    }

    public final void l(float f5) {
        c(f5, false);
        WeakHashMap weakHashMap = Y.f1904a;
        G.k(this.f6893a);
    }

    public final void m(Typeface typeface) {
        boolean z4;
        boolean zJ = j(typeface);
        if (this.f6918w != typeface) {
            this.f6918w = typeface;
            Typeface typefaceJ = AbstractC0296a2.j(this.f6893a.getContext().getResources().getConfiguration(), typeface);
            this.f6917v = typefaceJ;
            if (typefaceJ == null) {
                typefaceJ = this.f6918w;
            }
            this.f6916u = typefaceJ;
            z4 = true;
        } else {
            z4 = false;
        }
        if (zJ || z4) {
            h(false);
        }
    }
}
