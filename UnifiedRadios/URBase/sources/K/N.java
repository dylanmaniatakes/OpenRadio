package k;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;
import com.unified.ur1.R;
import j.ViewTreeObserverOnGlobalLayoutListenerC0585d;

/* loaded from: classes.dex */
public final class N extends C0667y0 implements P {

    /* renamed from: E, reason: collision with root package name */
    public CharSequence f7674E;

    /* renamed from: F, reason: collision with root package name */
    public ListAdapter f7675F;

    /* renamed from: G, reason: collision with root package name */
    public final Rect f7676G;

    /* renamed from: H, reason: collision with root package name */
    public int f7677H;
    public final /* synthetic */ Q I;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public N(Q q4, Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.spinnerStyle, 0);
        this.I = q4;
        this.f7676G = new Rect();
        this.f7900q = q4;
        this.f7887A = true;
        this.f7888B.setFocusable(true);
        this.f7901r = new C0617L(0, this);
    }

    @Override // k.P
    public final void e(CharSequence charSequence) {
        this.f7674E = charSequence;
    }

    @Override // k.P
    public final void j(int i5) {
        this.f7677H = i5;
    }

    @Override // k.P
    public final void m(int i5, int i6) {
        ViewTreeObserver viewTreeObserver;
        C0666y c0666y = this.f7888B;
        boolean zIsShowing = c0666y.isShowing();
        s();
        this.f7888B.setInputMethodMode(2);
        c();
        C0648o0 c0648o0 = this.f7891e;
        c0648o0.setChoiceMode(1);
        AbstractC0613H.d(c0648o0, i5);
        AbstractC0613H.c(c0648o0, i6);
        Q q4 = this.I;
        int selectedItemPosition = q4.getSelectedItemPosition();
        C0648o0 c0648o02 = this.f7891e;
        if (c0666y.isShowing() && c0648o02 != null) {
            c0648o02.setListSelectionHidden(false);
            c0648o02.setSelection(selectedItemPosition);
            if (c0648o02.getChoiceMode() != 0) {
                c0648o02.setItemChecked(selectedItemPosition, true);
            }
        }
        if (zIsShowing || (viewTreeObserver = q4.getViewTreeObserver()) == null) {
            return;
        }
        ViewTreeObserverOnGlobalLayoutListenerC0585d viewTreeObserverOnGlobalLayoutListenerC0585d = new ViewTreeObserverOnGlobalLayoutListenerC0585d(3, this);
        viewTreeObserver.addOnGlobalLayoutListener(viewTreeObserverOnGlobalLayoutListenerC0585d);
        this.f7888B.setOnDismissListener(new C0618M(this, viewTreeObserverOnGlobalLayoutListenerC0585d));
    }

    @Override // k.P
    public final CharSequence o() {
        return this.f7674E;
    }

    @Override // k.C0667y0, k.P
    public final void p(ListAdapter listAdapter) {
        super.p(listAdapter);
        this.f7675F = listAdapter;
    }

    public final void s() {
        int i5;
        C0666y c0666y = this.f7888B;
        Drawable background = c0666y.getBackground();
        Q q4 = this.I;
        if (background != null) {
            background.getPadding(q4.f7685j);
            boolean zA = j1.a(q4);
            Rect rect = q4.f7685j;
            i5 = zA ? rect.right : -rect.left;
        } else {
            Rect rect2 = q4.f7685j;
            rect2.right = 0;
            rect2.left = 0;
            i5 = 0;
        }
        int paddingLeft = q4.getPaddingLeft();
        int paddingRight = q4.getPaddingRight();
        int width = q4.getWidth();
        int i6 = q4.f7684i;
        if (i6 == -2) {
            int iA = q4.a((SpinnerAdapter) this.f7675F, c0666y.getBackground());
            int i7 = q4.getContext().getResources().getDisplayMetrics().widthPixels;
            Rect rect3 = q4.f7685j;
            int i8 = (i7 - rect3.left) - rect3.right;
            if (iA > i8) {
                iA = i8;
            }
            r(Math.max(iA, (width - paddingLeft) - paddingRight));
        } else if (i6 == -1) {
            r((width - paddingLeft) - paddingRight);
        } else {
            r(i6);
        }
        this.h = j1.a(q4) ? (((width - paddingRight) - this.g) - this.f7677H) + i5 : paddingLeft + this.f7677H + i5;
    }
}
