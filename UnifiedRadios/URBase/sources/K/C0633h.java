package k;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.unified.ur1.R;
import j.C0583b;

/* renamed from: k.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0633h extends C0662w implements InterfaceC0639k {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ C0637j f7783f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0633h(C0637j c0637j, Context context) {
        super(context, null, R.attr.actionOverflowButtonStyle);
        this.f7783f = c0637j;
        setClickable(true);
        setFocusable(true);
        setVisibility(0);
        setEnabled(true);
        g1.a(this, getContentDescription());
        setOnTouchListener(new C0583b(this, this));
    }

    @Override // k.InterfaceC0639k
    public final boolean a() {
        return false;
    }

    @Override // k.InterfaceC0639k
    public final boolean b() {
        return false;
    }

    @Override // android.view.View
    public final boolean performClick() {
        if (super.performClick()) {
            return true;
        }
        playSoundEffect(0);
        this.f7783f.n();
        return true;
    }

    @Override // android.widget.ImageView
    public final boolean setFrame(int i5, int i6, int i7, int i8) {
        boolean frame = super.setFrame(i5, i6, i7, i8);
        Drawable drawable = getDrawable();
        Drawable background = getBackground();
        if (drawable != null && background != null) {
            int width = getWidth();
            int height = getHeight();
            int iMax = Math.max(width, height) / 2;
            int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
            int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
            F.b.f(background, paddingLeft - iMax, paddingTop - iMax, paddingLeft + iMax, paddingTop + iMax);
        }
        return frame;
    }
}
