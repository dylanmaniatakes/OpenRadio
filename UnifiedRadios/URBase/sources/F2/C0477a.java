package f2;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import x0.C0949e;

/* renamed from: f2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0477a extends Drawable.ConstantState {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6470a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final Object f6471b;

    public C0477a(C0478b c0478b) {
        this.f6471b = c0478b;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public boolean canApplyTheme() {
        switch (this.f6470a) {
            case 1:
                return ((Drawable.ConstantState) this.f6471b).canApplyTheme();
            default:
                return super.canApplyTheme();
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        switch (this.f6470a) {
            case 0:
                return 0;
            default:
                return ((Drawable.ConstantState) this.f6471b).getChangingConfigurations();
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        switch (this.f6470a) {
            case 0:
                return (C0478b) this.f6471b;
            default:
                C0949e c0949e = new C0949e(null);
                Drawable drawableNewDrawable = ((Drawable.ConstantState) this.f6471b).newDrawable();
                c0949e.f10369c = drawableNewDrawable;
                drawableNewDrawable.setCallback(c0949e.h);
                return c0949e;
        }
    }

    public C0477a(Drawable.ConstantState constantState) {
        this.f6471b = constantState;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources) {
        switch (this.f6470a) {
            case 1:
                C0949e c0949e = new C0949e(null);
                Drawable drawableNewDrawable = ((Drawable.ConstantState) this.f6471b).newDrawable(resources);
                c0949e.f10369c = drawableNewDrawable;
                drawableNewDrawable.setCallback(c0949e.h);
                return c0949e;
            default:
                return super.newDrawable(resources);
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources, Resources.Theme theme) {
        switch (this.f6470a) {
            case 1:
                C0949e c0949e = new C0949e(null);
                Drawable drawableNewDrawable = ((Drawable.ConstantState) this.f6471b).newDrawable(resources, theme);
                c0949e.f10369c = drawableNewDrawable;
                drawableNewDrawable.setCallback(c0949e.h);
                return c0949e;
            default:
                return super.newDrawable(resources, theme);
        }
    }
}
