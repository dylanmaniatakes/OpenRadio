package k;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.TextView;
import e.AbstractC0429a;
import w1.AbstractC0930a;

/* renamed from: k.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0651q {

    /* renamed from: a, reason: collision with root package name */
    public ColorStateList f7845a = null;

    /* renamed from: b, reason: collision with root package name */
    public PorterDuff.Mode f7846b = null;

    /* renamed from: c, reason: collision with root package name */
    public boolean f7847c = false;

    /* renamed from: d, reason: collision with root package name */
    public boolean f7848d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f7849e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f7850f;

    public /* synthetic */ C0651q(TextView textView) {
        this.f7850f = textView;
    }

    public void a() {
        CompoundButton compoundButton = (CompoundButton) this.f7850f;
        Drawable drawableA = S.c.a(compoundButton);
        if (drawableA != null) {
            if (this.f7847c || this.f7848d) {
                Drawable drawableMutate = drawableA.mutate();
                if (this.f7847c) {
                    F.b.h(drawableMutate, this.f7845a);
                }
                if (this.f7848d) {
                    F.b.i(drawableMutate, this.f7846b);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(compoundButton.getDrawableState());
                }
                compoundButton.setButtonDrawable(drawableMutate);
            }
        }
    }

    public void b() {
        CheckedTextView checkedTextView = (CheckedTextView) this.f7850f;
        Drawable checkMarkDrawable = checkedTextView.getCheckMarkDrawable();
        if (checkMarkDrawable != null) {
            if (this.f7847c || this.f7848d) {
                Drawable drawableMutate = checkMarkDrawable.mutate();
                if (this.f7847c) {
                    F.b.h(drawableMutate, this.f7845a);
                }
                if (this.f7848d) {
                    F.b.i(drawableMutate, this.f7846b);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(checkedTextView.getDrawableState());
                }
                checkedTextView.setCheckMarkDrawable(drawableMutate);
            }
        }
    }

    public void c(AttributeSet attributeSet, int i5) {
        int resourceId;
        int resourceId2;
        CompoundButton compoundButton = (CompoundButton) this.f7850f;
        Context context = compoundButton.getContext();
        int[] iArr = AbstractC0429a.f6125m;
        L0.m mVarK = L0.m.k(context, attributeSet, iArr, i5, 0);
        TypedArray typedArray = (TypedArray) mVarK.f1557e;
        O.Y.j(compoundButton, compoundButton.getContext(), iArr, attributeSet, (TypedArray) mVarK.f1557e, i5);
        try {
            if (typedArray.hasValue(1) && (resourceId2 = typedArray.getResourceId(1, 0)) != 0) {
                try {
                    compoundButton.setButtonDrawable(AbstractC0930a.k(compoundButton.getContext(), resourceId2));
                } catch (Resources.NotFoundException unused) {
                }
            } else if (typedArray.hasValue(0) && (resourceId = typedArray.getResourceId(0, 0)) != 0) {
                compoundButton.setButtonDrawable(AbstractC0930a.k(compoundButton.getContext(), resourceId));
            }
            if (typedArray.hasValue(2)) {
                S.b.c(compoundButton, mVarK.f(2));
            }
            if (typedArray.hasValue(3)) {
                S.b.d(compoundButton, AbstractC0636i0.b(typedArray.getInt(3, -1), null));
            }
        } finally {
            mVarK.n();
        }
    }
}
