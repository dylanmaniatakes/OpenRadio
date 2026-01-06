package k;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import com.google.android.gms.internal.measurement.D1;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import e.AbstractC0429a;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class X {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f7728a;

    /* renamed from: b, reason: collision with root package name */
    public W0 f7729b;

    /* renamed from: c, reason: collision with root package name */
    public W0 f7730c;

    /* renamed from: d, reason: collision with root package name */
    public W0 f7731d;

    /* renamed from: e, reason: collision with root package name */
    public W0 f7732e;

    /* renamed from: f, reason: collision with root package name */
    public W0 f7733f;
    public W0 g;
    public W0 h;

    /* renamed from: i, reason: collision with root package name */
    public final C0626d0 f7734i;

    /* renamed from: j, reason: collision with root package name */
    public int f7735j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f7736k = -1;

    /* renamed from: l, reason: collision with root package name */
    public Typeface f7737l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f7738m;

    public X(TextView textView) {
        this.f7728a = textView;
        this.f7734i = new C0626d0(textView);
    }

    public static W0 c(Context context, r rVar, int i5) {
        ColorStateList colorStateListH;
        synchronized (rVar) {
            colorStateListH = rVar.f7855a.h(context, i5);
        }
        if (colorStateListH == null) {
            return null;
        }
        W0 w02 = new W0();
        w02.f7727d = true;
        w02.f7724a = colorStateListH;
        return w02;
    }

    public static void h(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 30 || inputConnection == null) {
            return;
        }
        CharSequence text = textView.getText();
        if (i5 >= 30) {
            R.a.a(editorInfo, text);
            return;
        }
        text.getClass();
        if (i5 >= 30) {
            R.a.a(editorInfo, text);
            return;
        }
        int i6 = editorInfo.initialSelStart;
        int i7 = editorInfo.initialSelEnd;
        int i8 = i6 > i7 ? i7 : i6;
        if (i6 <= i7) {
            i6 = i7;
        }
        int length = text.length();
        if (i8 < 0 || i6 > length) {
            D1.o(editorInfo, null, 0, 0);
            return;
        }
        int i9 = editorInfo.inputType & 4095;
        if (i9 == 129 || i9 == 225 || i9 == 18) {
            D1.o(editorInfo, null, 0, 0);
            return;
        }
        if (length <= 2048) {
            D1.o(editorInfo, text, i8, i6);
            return;
        }
        int i10 = i6 - i8;
        int i11 = i10 > 1024 ? 0 : i10;
        int i12 = 2048 - i11;
        int iMin = Math.min(text.length() - i6, i12 - Math.min(i8, (int) (i12 * 0.8d)));
        int iMin2 = Math.min(i8, i12 - iMin);
        int i13 = i8 - iMin2;
        if (Character.isLowSurrogate(text.charAt(i13))) {
            i13++;
            iMin2--;
        }
        if (Character.isHighSurrogate(text.charAt((i6 + iMin) - 1))) {
            iMin--;
        }
        int i14 = iMin2 + i11;
        D1.o(editorInfo, i11 != i10 ? TextUtils.concat(text.subSequence(i13, i13 + iMin2), text.subSequence(i6, iMin + i6)) : text.subSequence(i13, i14 + iMin + i13), iMin2, i14);
    }

    public final void a(Drawable drawable, W0 w02) {
        if (drawable == null || w02 == null) {
            return;
        }
        r.e(drawable, w02, this.f7728a.getDrawableState());
    }

    public final void b() {
        W0 w02 = this.f7729b;
        TextView textView = this.f7728a;
        if (w02 != null || this.f7730c != null || this.f7731d != null || this.f7732e != null) {
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            a(compoundDrawables[0], this.f7729b);
            a(compoundDrawables[1], this.f7730c);
            a(compoundDrawables[2], this.f7731d);
            a(compoundDrawables[3], this.f7732e);
        }
        if (this.f7733f == null && this.g == null) {
            return;
        }
        Drawable[] drawableArrA = T.a(textView);
        a(drawableArrA[0], this.f7733f);
        a(drawableArrA[2], this.g);
    }

    public final ColorStateList d() {
        W0 w02 = this.h;
        if (w02 != null) {
            return w02.f7724a;
        }
        return null;
    }

    public final PorterDuff.Mode e() {
        W0 w02 = this.h;
        if (w02 != null) {
            return w02.f7725b;
        }
        return null;
    }

    public final void f(AttributeSet attributeSet, int i5) {
        boolean z4;
        boolean z5;
        String string;
        String string2;
        boolean z6;
        int i6;
        int i7;
        ColorStateList colorStateList;
        int resourceId;
        int i8;
        int resourceId2;
        int i9;
        TextView textView = this.f7728a;
        Context context = textView.getContext();
        r rVarA = r.a();
        int[] iArr = AbstractC0429a.h;
        L0.m mVarK = L0.m.k(context, attributeSet, iArr, i5, 0);
        O.Y.j(textView, textView.getContext(), iArr, attributeSet, (TypedArray) mVarK.f1557e, i5);
        TypedArray typedArray = (TypedArray) mVarK.f1557e;
        int resourceId3 = typedArray.getResourceId(0, -1);
        if (typedArray.hasValue(3)) {
            this.f7729b = c(context, rVarA, typedArray.getResourceId(3, 0));
        }
        if (typedArray.hasValue(1)) {
            this.f7730c = c(context, rVarA, typedArray.getResourceId(1, 0));
        }
        if (typedArray.hasValue(4)) {
            this.f7731d = c(context, rVarA, typedArray.getResourceId(4, 0));
        }
        if (typedArray.hasValue(2)) {
            this.f7732e = c(context, rVarA, typedArray.getResourceId(2, 0));
        }
        if (typedArray.hasValue(5)) {
            this.f7733f = c(context, rVarA, typedArray.getResourceId(5, 0));
        }
        if (typedArray.hasValue(6)) {
            this.g = c(context, rVarA, typedArray.getResourceId(6, 0));
        }
        mVarK.n();
        boolean z7 = textView.getTransformationMethod() instanceof PasswordTransformationMethod;
        int[] iArr2 = AbstractC0429a.f6134w;
        if (resourceId3 != -1) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(resourceId3, iArr2);
            L0.m mVar = new L0.m(context, typedArrayObtainStyledAttributes);
            if (z7 || !typedArrayObtainStyledAttributes.hasValue(14)) {
                z4 = false;
                z5 = false;
            } else {
                z5 = typedArrayObtainStyledAttributes.getBoolean(14, false);
                z4 = true;
            }
            k(context, mVar);
            if (typedArrayObtainStyledAttributes.hasValue(15)) {
                string2 = typedArrayObtainStyledAttributes.getString(15);
                i9 = 13;
            } else {
                i9 = 13;
                string2 = null;
            }
            string = typedArrayObtainStyledAttributes.hasValue(i9) ? typedArrayObtainStyledAttributes.getString(i9) : null;
            mVar.n();
        } else {
            z4 = false;
            z5 = false;
            string = null;
            string2 = null;
        }
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i5, 0);
        L0.m mVar2 = new L0.m(context, typedArrayObtainStyledAttributes2);
        if (z7 || !typedArrayObtainStyledAttributes2.hasValue(14)) {
            z6 = z5;
        } else {
            z6 = typedArrayObtainStyledAttributes2.getBoolean(14, false);
            z4 = true;
        }
        if (typedArrayObtainStyledAttributes2.hasValue(15)) {
            string2 = typedArrayObtainStyledAttributes2.getString(15);
        }
        if (typedArrayObtainStyledAttributes2.hasValue(13)) {
            string = typedArrayObtainStyledAttributes2.getString(13);
        }
        if (typedArrayObtainStyledAttributes2.hasValue(0) && typedArrayObtainStyledAttributes2.getDimensionPixelSize(0, -1) == 0) {
            textView.setTextSize(0, BitmapDescriptorFactory.HUE_RED);
        }
        k(context, mVar2);
        mVar2.n();
        if (!z7 && z4) {
            textView.setAllCaps(z6);
        }
        Typeface typeface = this.f7737l;
        if (typeface != null) {
            if (this.f7736k == -1) {
                textView.setTypeface(typeface, this.f7735j);
            } else {
                textView.setTypeface(typeface);
            }
        }
        if (string != null) {
            V.d(textView, string);
        }
        if (string2 != null) {
            U.b(textView, U.a(string2));
        }
        int[] iArr3 = AbstractC0429a.f6121i;
        C0626d0 c0626d0 = this.f7734i;
        Context context2 = c0626d0.f7759i;
        TypedArray typedArrayObtainStyledAttributes3 = context2.obtainStyledAttributes(attributeSet, iArr3, i5, 0);
        TextView textView2 = c0626d0.h;
        O.Y.j(textView2, textView2.getContext(), iArr3, attributeSet, typedArrayObtainStyledAttributes3, i5);
        if (typedArrayObtainStyledAttributes3.hasValue(5)) {
            c0626d0.f7753a = typedArrayObtainStyledAttributes3.getInt(5, 0);
        }
        float dimension = typedArrayObtainStyledAttributes3.hasValue(4) ? typedArrayObtainStyledAttributes3.getDimension(4, -1.0f) : -1.0f;
        float dimension2 = typedArrayObtainStyledAttributes3.hasValue(2) ? typedArrayObtainStyledAttributes3.getDimension(2, -1.0f) : -1.0f;
        float dimension3 = typedArrayObtainStyledAttributes3.hasValue(1) ? typedArrayObtainStyledAttributes3.getDimension(1, -1.0f) : -1.0f;
        if (typedArrayObtainStyledAttributes3.hasValue(3) && (resourceId2 = typedArrayObtainStyledAttributes3.getResourceId(3, 0)) > 0) {
            TypedArray typedArrayObtainTypedArray = typedArrayObtainStyledAttributes3.getResources().obtainTypedArray(resourceId2);
            int length = typedArrayObtainTypedArray.length();
            int[] iArr4 = new int[length];
            if (length > 0) {
                for (int i10 = 0; i10 < length; i10++) {
                    iArr4[i10] = typedArrayObtainTypedArray.getDimensionPixelSize(i10, -1);
                }
                c0626d0.f7758f = C0626d0.a(iArr4);
                c0626d0.c();
            }
            typedArrayObtainTypedArray.recycle();
        }
        typedArrayObtainStyledAttributes3.recycle();
        if (!c0626d0.d()) {
            c0626d0.f7753a = 0;
        } else if (c0626d0.f7753a == 1) {
            if (!c0626d0.g) {
                DisplayMetrics displayMetrics = context2.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    i8 = 2;
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                } else {
                    i8 = 2;
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(i8, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                c0626d0.e(dimension2, dimension3, dimension);
            }
            c0626d0.b();
        }
        Method method = j1.f7810a;
        if (c0626d0.f7753a != 0) {
            int[] iArr5 = c0626d0.f7758f;
            if (iArr5.length > 0) {
                if (V.a(textView) != -1.0f) {
                    V.b(textView, Math.round(c0626d0.f7756d), Math.round(c0626d0.f7757e), Math.round(c0626d0.f7755c), 0);
                } else {
                    V.c(textView, iArr5, 0);
                }
            }
        }
        TypedArray typedArrayObtainStyledAttributes4 = context.obtainStyledAttributes(attributeSet, iArr3);
        int resourceId4 = typedArrayObtainStyledAttributes4.getResourceId(8, -1);
        Drawable drawableB = resourceId4 != -1 ? rVarA.b(context, resourceId4) : null;
        int resourceId5 = typedArrayObtainStyledAttributes4.getResourceId(13, -1);
        Drawable drawableB2 = resourceId5 != -1 ? rVarA.b(context, resourceId5) : null;
        int resourceId6 = typedArrayObtainStyledAttributes4.getResourceId(9, -1);
        Drawable drawableB3 = resourceId6 != -1 ? rVarA.b(context, resourceId6) : null;
        int resourceId7 = typedArrayObtainStyledAttributes4.getResourceId(6, -1);
        Drawable drawableB4 = resourceId7 != -1 ? rVarA.b(context, resourceId7) : null;
        int resourceId8 = typedArrayObtainStyledAttributes4.getResourceId(10, -1);
        Drawable drawableB5 = resourceId8 != -1 ? rVarA.b(context, resourceId8) : null;
        int resourceId9 = typedArrayObtainStyledAttributes4.getResourceId(7, -1);
        Drawable drawableB6 = resourceId9 != -1 ? rVarA.b(context, resourceId9) : null;
        if (drawableB5 != null || drawableB6 != null) {
            Drawable[] drawableArrA = T.a(textView);
            if (drawableB5 == null) {
                drawableB5 = drawableArrA[0];
            }
            if (drawableB2 == null) {
                drawableB2 = drawableArrA[1];
            }
            if (drawableB6 == null) {
                drawableB6 = drawableArrA[2];
            }
            if (drawableB4 == null) {
                drawableB4 = drawableArrA[3];
            }
            T.b(textView, drawableB5, drawableB2, drawableB6, drawableB4);
        } else if (drawableB != null || drawableB2 != null || drawableB3 != null || drawableB4 != null) {
            Drawable[] drawableArrA2 = T.a(textView);
            Drawable drawable = drawableArrA2[0];
            if (drawable == null && drawableArrA2[2] == null) {
                Drawable[] compoundDrawables = textView.getCompoundDrawables();
                if (drawableB == null) {
                    drawableB = compoundDrawables[0];
                }
                if (drawableB2 == null) {
                    drawableB2 = compoundDrawables[1];
                }
                if (drawableB3 == null) {
                    drawableB3 = compoundDrawables[2];
                }
                if (drawableB4 == null) {
                    drawableB4 = compoundDrawables[3];
                }
                textView.setCompoundDrawablesWithIntrinsicBounds(drawableB, drawableB2, drawableB3, drawableB4);
            } else {
                if (drawableB2 == null) {
                    drawableB2 = drawableArrA2[1];
                }
                Drawable drawable2 = drawableArrA2[2];
                if (drawableB4 == null) {
                    drawableB4 = drawableArrA2[3];
                }
                T.b(textView, drawable, drawableB2, drawable2, drawableB4);
            }
        }
        if (typedArrayObtainStyledAttributes4.hasValue(11)) {
            if (!typedArrayObtainStyledAttributes4.hasValue(11) || (resourceId = typedArrayObtainStyledAttributes4.getResourceId(11, 0)) == 0 || (colorStateList = C.h.c(context, resourceId)) == null) {
                colorStateList = typedArrayObtainStyledAttributes4.getColorStateList(11);
            }
            S.q.f(textView, colorStateList);
        }
        if (typedArrayObtainStyledAttributes4.hasValue(12)) {
            i6 = -1;
            S.q.g(textView, AbstractC0636i0.b(typedArrayObtainStyledAttributes4.getInt(12, -1), null));
        } else {
            i6 = -1;
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes4.getDimensionPixelSize(15, i6);
        int dimensionPixelSize2 = typedArrayObtainStyledAttributes4.getDimensionPixelSize(18, i6);
        int dimensionPixelSize3 = typedArrayObtainStyledAttributes4.getDimensionPixelSize(19, i6);
        typedArrayObtainStyledAttributes4.recycle();
        if (dimensionPixelSize != i6) {
            h4.f.b(dimensionPixelSize);
            S.r.c(textView, dimensionPixelSize);
        }
        if (dimensionPixelSize2 != i6) {
            h4.f.b(dimensionPixelSize2);
            Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
            int i11 = S.o.a(textView) ? fontMetricsInt.bottom : fontMetricsInt.descent;
            if (dimensionPixelSize2 > Math.abs(i11)) {
                textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), dimensionPixelSize2 - i11);
            }
            i7 = -1;
        } else {
            i7 = i6;
        }
        if (dimensionPixelSize3 != i7) {
            h4.f.b(dimensionPixelSize3);
            if (dimensionPixelSize3 != textView.getPaint().getFontMetricsInt(null)) {
                textView.setLineSpacing(dimensionPixelSize3 - r1, 1.0f);
            }
        }
    }

    public final void g(Context context, int i5) {
        String string;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i5, AbstractC0429a.f6134w);
        L0.m mVar = new L0.m(context, typedArrayObtainStyledAttributes);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(14);
        TextView textView = this.f7728a;
        if (zHasValue) {
            textView.setAllCaps(typedArrayObtainStyledAttributes.getBoolean(14, false));
        }
        if (typedArrayObtainStyledAttributes.hasValue(0) && typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1) == 0) {
            textView.setTextSize(0, BitmapDescriptorFactory.HUE_RED);
        }
        k(context, mVar);
        if (typedArrayObtainStyledAttributes.hasValue(13) && (string = typedArrayObtainStyledAttributes.getString(13)) != null) {
            V.d(textView, string);
        }
        mVar.n();
        Typeface typeface = this.f7737l;
        if (typeface != null) {
            textView.setTypeface(typeface, this.f7735j);
        }
    }

    public final void i(ColorStateList colorStateList) {
        if (this.h == null) {
            this.h = new W0();
        }
        W0 w02 = this.h;
        w02.f7724a = colorStateList;
        w02.f7727d = colorStateList != null;
        this.f7729b = w02;
        this.f7730c = w02;
        this.f7731d = w02;
        this.f7732e = w02;
        this.f7733f = w02;
        this.g = w02;
    }

    public final void j(PorterDuff.Mode mode) {
        if (this.h == null) {
            this.h = new W0();
        }
        W0 w02 = this.h;
        w02.f7725b = mode;
        w02.f7726c = mode != null;
        this.f7729b = w02;
        this.f7730c = w02;
        this.f7731d = w02;
        this.f7732e = w02;
        this.f7733f = w02;
        this.g = w02;
    }

    public final void k(Context context, L0.m mVar) {
        String string;
        int i5 = this.f7735j;
        TypedArray typedArray = (TypedArray) mVar.f1557e;
        this.f7735j = typedArray.getInt(2, i5);
        int i6 = typedArray.getInt(11, -1);
        this.f7736k = i6;
        if (i6 != -1) {
            this.f7735j &= 2;
        }
        if (!typedArray.hasValue(10) && !typedArray.hasValue(12)) {
            if (typedArray.hasValue(1)) {
                this.f7738m = false;
                int i7 = typedArray.getInt(1, 1);
                if (i7 == 1) {
                    this.f7737l = Typeface.SANS_SERIF;
                    return;
                } else if (i7 == 2) {
                    this.f7737l = Typeface.SERIF;
                    return;
                } else {
                    if (i7 != 3) {
                        return;
                    }
                    this.f7737l = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.f7737l = null;
        int i8 = typedArray.hasValue(12) ? 12 : 10;
        int i9 = this.f7736k;
        int i10 = this.f7735j;
        if (!context.isRestricted()) {
            try {
                Typeface typefaceJ = mVar.j(i8, this.f7735j, new S(this, i9, i10, new WeakReference(this.f7728a)));
                if (typefaceJ != null) {
                    if (this.f7736k != -1) {
                        this.f7737l = W.a(Typeface.create(typefaceJ, 0), this.f7736k, (this.f7735j & 2) != 0);
                    } else {
                        this.f7737l = typefaceJ;
                    }
                }
                this.f7738m = this.f7737l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f7737l != null || (string = typedArray.getString(i8)) == null) {
            return;
        }
        if (this.f7736k != -1) {
            this.f7737l = W.a(Typeface.create(string, 0), this.f7736k, (this.f7735j & 2) != 0);
        } else {
            this.f7737l = Typeface.create(string, this.f7735j);
        }
    }
}
