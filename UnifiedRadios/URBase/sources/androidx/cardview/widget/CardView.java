package androidx.cardview.widget;

import L0.c;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import h1.C0558b;
import o.AbstractC0807a;
import p.C0816a;

/* loaded from: classes.dex */
public class CardView extends FrameLayout {
    public static final int[] h = {R.attr.colorBackground};

    /* renamed from: i, reason: collision with root package name */
    public static final C0558b f3489i = new C0558b(7);

    /* renamed from: c, reason: collision with root package name */
    public boolean f3490c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f3491d;

    /* renamed from: e, reason: collision with root package name */
    public final Rect f3492e;

    /* renamed from: f, reason: collision with root package name */
    public final Rect f3493f;
    public final c g;

    public CardView(Context context) {
        this(context, null);
    }

    public ColorStateList getCardBackgroundColor() {
        return ((C0816a) ((Drawable) this.g.f1536d)).h;
    }

    public float getCardElevation() {
        return ((CardView) this.g.f1537e).getElevation();
    }

    public int getContentPaddingBottom() {
        return this.f3492e.bottom;
    }

    public int getContentPaddingLeft() {
        return this.f3492e.left;
    }

    public int getContentPaddingRight() {
        return this.f3492e.right;
    }

    public int getContentPaddingTop() {
        return this.f3492e.top;
    }

    public float getMaxCardElevation() {
        return ((C0816a) ((Drawable) this.g.f1536d)).f9068e;
    }

    public boolean getPreventCornerOverlap() {
        return this.f3491d;
    }

    public float getRadius() {
        return ((C0816a) ((Drawable) this.g.f1536d)).f9064a;
    }

    public boolean getUseCompatPadding() {
        return this.f3490c;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
    }

    public void setCardBackgroundColor(int i5) {
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(i5);
        C0816a c0816a = (C0816a) ((Drawable) this.g.f1536d);
        if (colorStateListValueOf == null) {
            c0816a.getClass();
            colorStateListValueOf = ColorStateList.valueOf(0);
        }
        c0816a.h = colorStateListValueOf;
        c0816a.f9065b.setColor(colorStateListValueOf.getColorForState(c0816a.getState(), c0816a.h.getDefaultColor()));
        c0816a.invalidateSelf();
    }

    public void setCardElevation(float f5) {
        ((CardView) this.g.f1537e).setElevation(f5);
    }

    public void setMaxCardElevation(float f5) {
        f3489i.i(this.g, f5);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i5) {
        super.setMinimumHeight(i5);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i5) {
        super.setMinimumWidth(i5);
    }

    @Override // android.view.View
    public final void setPadding(int i5, int i6, int i7, int i8) {
    }

    @Override // android.view.View
    public final void setPaddingRelative(int i5, int i6, int i7, int i8) {
    }

    public void setPreventCornerOverlap(boolean z4) {
        if (z4 != this.f3491d) {
            this.f3491d = z4;
            C0558b c0558b = f3489i;
            c cVar = this.g;
            c0558b.i(cVar, ((C0816a) ((Drawable) cVar.f1536d)).f9068e);
        }
    }

    public void setRadius(float f5) {
        C0816a c0816a = (C0816a) ((Drawable) this.g.f1536d);
        if (f5 == c0816a.f9064a) {
            return;
        }
        c0816a.f9064a = f5;
        c0816a.b(null);
        c0816a.invalidateSelf();
    }

    public void setUseCompatPadding(boolean z4) {
        if (this.f3490c != z4) {
            this.f3490c = z4;
            C0558b c0558b = f3489i;
            c cVar = this.g;
            c0558b.i(cVar, ((C0816a) ((Drawable) cVar.f1536d)).f9068e);
        }
    }

    public CardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.unified.ur1.R.attr.cardViewStyle);
    }

    public CardView(Context context, AttributeSet attributeSet, int i5) throws Resources.NotFoundException {
        int color;
        ColorStateList colorStateListValueOf;
        super(context, attributeSet, i5);
        Rect rect = new Rect();
        this.f3492e = rect;
        this.f3493f = new Rect();
        c cVar = new c(21, this);
        this.g = cVar;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0807a.f8885a, i5, com.unified.ur1.R.style.CardView);
        if (typedArrayObtainStyledAttributes.hasValue(2)) {
            colorStateListValueOf = typedArrayObtainStyledAttributes.getColorStateList(2);
        } else {
            TypedArray typedArrayObtainStyledAttributes2 = getContext().obtainStyledAttributes(h);
            int color2 = typedArrayObtainStyledAttributes2.getColor(0, 0);
            typedArrayObtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color2, fArr);
            if (fArr[2] > 0.5f) {
                color = getResources().getColor(com.unified.ur1.R.color.cardview_light_background);
            } else {
                color = getResources().getColor(com.unified.ur1.R.color.cardview_dark_background);
            }
            colorStateListValueOf = ColorStateList.valueOf(color);
        }
        float dimension = typedArrayObtainStyledAttributes.getDimension(3, BitmapDescriptorFactory.HUE_RED);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(4, BitmapDescriptorFactory.HUE_RED);
        float dimension3 = typedArrayObtainStyledAttributes.getDimension(5, BitmapDescriptorFactory.HUE_RED);
        this.f3490c = typedArrayObtainStyledAttributes.getBoolean(7, false);
        this.f3491d = typedArrayObtainStyledAttributes.getBoolean(6, true);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(8, 0);
        rect.left = typedArrayObtainStyledAttributes.getDimensionPixelSize(10, dimensionPixelSize);
        rect.top = typedArrayObtainStyledAttributes.getDimensionPixelSize(12, dimensionPixelSize);
        rect.right = typedArrayObtainStyledAttributes.getDimensionPixelSize(11, dimensionPixelSize);
        rect.bottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(9, dimensionPixelSize);
        dimension3 = dimension2 > dimension3 ? dimension2 : dimension3;
        typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        C0558b c0558b = f3489i;
        C0816a c0816a = new C0816a(colorStateListValueOf, dimension);
        cVar.f1536d = c0816a;
        setBackgroundDrawable(c0816a);
        setClipToOutline(true);
        setElevation(dimension2);
        c0558b.i(cVar, dimension3);
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        C0816a c0816a = (C0816a) ((Drawable) this.g.f1536d);
        if (colorStateList == null) {
            c0816a.getClass();
            colorStateList = ColorStateList.valueOf(0);
        }
        c0816a.h = colorStateList;
        c0816a.f9065b.setColor(colorStateList.getColorForState(c0816a.getState(), c0816a.h.getDefaultColor()));
        c0816a.invalidateSelf();
    }
}
