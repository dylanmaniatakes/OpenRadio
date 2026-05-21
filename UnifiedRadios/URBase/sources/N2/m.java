package n2;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import com.google.android.gms.internal.measurement.AbstractC0409x1;
import com.google.android.gms.internal.measurement.D1;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: m, reason: collision with root package name */
    public static final j f8838m = new j(0.5f);

    /* renamed from: a, reason: collision with root package name */
    public AbstractC0409x1 f8839a = new k();

    /* renamed from: b, reason: collision with root package name */
    public AbstractC0409x1 f8840b = new k();

    /* renamed from: c, reason: collision with root package name */
    public AbstractC0409x1 f8841c = new k();

    /* renamed from: d, reason: collision with root package name */
    public AbstractC0409x1 f8842d = new k();

    /* renamed from: e, reason: collision with root package name */
    public InterfaceC0804c f8843e = new C0802a(BitmapDescriptorFactory.HUE_RED);

    /* renamed from: f, reason: collision with root package name */
    public InterfaceC0804c f8844f = new C0802a(BitmapDescriptorFactory.HUE_RED);
    public InterfaceC0804c g = new C0802a(BitmapDescriptorFactory.HUE_RED);
    public InterfaceC0804c h = new C0802a(BitmapDescriptorFactory.HUE_RED);

    /* renamed from: i, reason: collision with root package name */
    public e f8845i = new e(0);

    /* renamed from: j, reason: collision with root package name */
    public e f8846j = new e(0);

    /* renamed from: k, reason: collision with root package name */
    public e f8847k = new e(0);

    /* renamed from: l, reason: collision with root package name */
    public e f8848l = new e(0);

    public static l a(Context context, int i5, int i6, InterfaceC0804c interfaceC0804c) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i5);
        if (i6 != 0) {
            contextThemeWrapper = new ContextThemeWrapper(contextThemeWrapper, i6);
        }
        TypedArray typedArrayObtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(O1.a.f1991A);
        try {
            int i7 = typedArrayObtainStyledAttributes.getInt(0, 0);
            int i8 = typedArrayObtainStyledAttributes.getInt(3, i7);
            int i9 = typedArrayObtainStyledAttributes.getInt(4, i7);
            int i10 = typedArrayObtainStyledAttributes.getInt(2, i7);
            int i11 = typedArrayObtainStyledAttributes.getInt(1, i7);
            InterfaceC0804c interfaceC0804cC = c(typedArrayObtainStyledAttributes, 5, interfaceC0804c);
            InterfaceC0804c interfaceC0804cC2 = c(typedArrayObtainStyledAttributes, 8, interfaceC0804cC);
            InterfaceC0804c interfaceC0804cC3 = c(typedArrayObtainStyledAttributes, 9, interfaceC0804cC);
            InterfaceC0804c interfaceC0804cC4 = c(typedArrayObtainStyledAttributes, 7, interfaceC0804cC);
            InterfaceC0804c interfaceC0804cC5 = c(typedArrayObtainStyledAttributes, 6, interfaceC0804cC);
            l lVar = new l();
            AbstractC0409x1 abstractC0409x1E = D1.e(i8);
            lVar.f8828a = abstractC0409x1E;
            l.b(abstractC0409x1E);
            lVar.f8832e = interfaceC0804cC2;
            AbstractC0409x1 abstractC0409x1E2 = D1.e(i9);
            lVar.f8829b = abstractC0409x1E2;
            l.b(abstractC0409x1E2);
            lVar.f8833f = interfaceC0804cC3;
            AbstractC0409x1 abstractC0409x1E3 = D1.e(i10);
            lVar.f8830c = abstractC0409x1E3;
            l.b(abstractC0409x1E3);
            lVar.g = interfaceC0804cC4;
            AbstractC0409x1 abstractC0409x1E4 = D1.e(i11);
            lVar.f8831d = abstractC0409x1E4;
            l.b(abstractC0409x1E4);
            lVar.h = interfaceC0804cC5;
            return lVar;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static l b(Context context, AttributeSet attributeSet, int i5, int i6) {
        C0802a c0802a = new C0802a(0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, O1.a.f2014s, i5, i6);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        return a(context, resourceId, resourceId2, c0802a);
    }

    public static InterfaceC0804c c(TypedArray typedArray, int i5, InterfaceC0804c interfaceC0804c) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i5);
        if (typedValuePeekValue == null) {
            return interfaceC0804c;
        }
        int i6 = typedValuePeekValue.type;
        return i6 == 5 ? new C0802a(TypedValue.complexToDimensionPixelSize(typedValuePeekValue.data, typedArray.getResources().getDisplayMetrics())) : i6 == 6 ? new j(typedValuePeekValue.getFraction(1.0f, 1.0f)) : interfaceC0804c;
    }

    public final boolean d(RectF rectF) {
        boolean z4 = this.f8848l.getClass().equals(e.class) && this.f8846j.getClass().equals(e.class) && this.f8845i.getClass().equals(e.class) && this.f8847k.getClass().equals(e.class);
        float fA = this.f8843e.a(rectF);
        return z4 && ((this.f8844f.a(rectF) > fA ? 1 : (this.f8844f.a(rectF) == fA ? 0 : -1)) == 0 && (this.h.a(rectF) > fA ? 1 : (this.h.a(rectF) == fA ? 0 : -1)) == 0 && (this.g.a(rectF) > fA ? 1 : (this.g.a(rectF) == fA ? 0 : -1)) == 0) && ((this.f8840b instanceof k) && (this.f8839a instanceof k) && (this.f8841c instanceof k) && (this.f8842d instanceof k));
    }

    public final l e() {
        l lVar = new l();
        lVar.f8828a = this.f8839a;
        lVar.f8829b = this.f8840b;
        lVar.f8830c = this.f8841c;
        lVar.f8831d = this.f8842d;
        lVar.f8832e = this.f8843e;
        lVar.f8833f = this.f8844f;
        lVar.g = this.g;
        lVar.h = this.h;
        lVar.f8834i = this.f8845i;
        lVar.f8835j = this.f8846j;
        lVar.f8836k = this.f8847k;
        lVar.f8837l = this.f8848l;
        return lVar;
    }
}
