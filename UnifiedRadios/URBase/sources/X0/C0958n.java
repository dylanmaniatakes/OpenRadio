package x0;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;

/* renamed from: x0.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0958n extends Drawable.ConstantState {

    /* renamed from: a, reason: collision with root package name */
    public final Drawable.ConstantState f10415a;

    public C0958n(Drawable.ConstantState constantState) {
        this.f10415a = constantState;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final boolean canApplyTheme() {
        return this.f10415a.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        return this.f10415a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        C0959o c0959o = new C0959o();
        c0959o.f10369c = (VectorDrawable) this.f10415a.newDrawable();
        return c0959o;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources) {
        C0959o c0959o = new C0959o();
        c0959o.f10369c = (VectorDrawable) this.f10415a.newDrawable(resources);
        return c0959o;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources, Resources.Theme theme) {
        C0959o c0959o = new C0959o();
        c0959o.f10369c = (VectorDrawable) this.f10415a.newDrawable(resources, theme);
        return c0959o;
    }
}
