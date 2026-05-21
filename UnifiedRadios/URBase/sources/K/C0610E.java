package k;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.unified.ur1.R;
import e.AbstractC0429a;

/* renamed from: k.E, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0610E extends C0668z {

    /* renamed from: e, reason: collision with root package name */
    public final SeekBar f7640e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f7641f;
    public ColorStateList g;
    public PorterDuff.Mode h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f7642i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f7643j;

    public C0610E(SeekBar seekBar) {
        super(seekBar);
        this.g = null;
        this.h = null;
        this.f7642i = false;
        this.f7643j = false;
        this.f7640e = seekBar;
    }

    @Override // k.C0668z
    public final void d(AttributeSet attributeSet, int i5) {
        super.d(attributeSet, R.attr.seekBarStyle);
        SeekBar seekBar = this.f7640e;
        Context context = seekBar.getContext();
        int[] iArr = AbstractC0429a.g;
        L0.m mVarK = L0.m.k(context, attributeSet, iArr, R.attr.seekBarStyle, 0);
        O.Y.j(seekBar, seekBar.getContext(), iArr, attributeSet, (TypedArray) mVarK.f1557e, R.attr.seekBarStyle);
        Drawable drawableI = mVarK.i(0);
        if (drawableI != null) {
            seekBar.setThumb(drawableI);
        }
        Drawable drawableG = mVarK.g(1);
        Drawable drawable = this.f7641f;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.f7641f = drawableG;
        if (drawableG != null) {
            drawableG.setCallback(seekBar);
            F.c.b(drawableG, O.H.d(seekBar));
            if (drawableG.isStateful()) {
                drawableG.setState(seekBar.getDrawableState());
            }
            h();
        }
        seekBar.invalidate();
        TypedArray typedArray = (TypedArray) mVarK.f1557e;
        if (typedArray.hasValue(3)) {
            this.h = AbstractC0636i0.b(typedArray.getInt(3, -1), this.h);
            this.f7643j = true;
        }
        if (typedArray.hasValue(2)) {
            this.g = mVarK.f(2);
            this.f7642i = true;
        }
        mVarK.n();
        h();
    }

    public final void h() {
        Drawable drawable = this.f7641f;
        if (drawable != null) {
            if (this.f7642i || this.f7643j) {
                Drawable drawableMutate = drawable.mutate();
                this.f7641f = drawableMutate;
                if (this.f7642i) {
                    F.b.h(drawableMutate, this.g);
                }
                if (this.f7643j) {
                    F.b.i(this.f7641f, this.h);
                }
                if (this.f7641f.isStateful()) {
                    this.f7641f.setState(this.f7640e.getDrawableState());
                }
            }
        }
    }

    public final void i(Canvas canvas) {
        if (this.f7641f != null) {
            int max = this.f7640e.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f7641f.getIntrinsicWidth();
                int intrinsicHeight = this.f7641f.getIntrinsicHeight();
                int i5 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i6 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f7641f.setBounds(-i5, -i6, i5, i6);
                float width = ((r0.getWidth() - r0.getPaddingLeft()) - r0.getPaddingRight()) / max;
                int iSave = canvas.save();
                canvas.translate(r0.getPaddingLeft(), r0.getHeight() / 2);
                for (int i7 = 0; i7 <= max; i7++) {
                    this.f7641f.draw(canvas);
                    canvas.translate(width, BitmapDescriptorFactory.HUE_RED);
                }
                canvas.restoreToCount(iSave);
            }
        }
    }
}
