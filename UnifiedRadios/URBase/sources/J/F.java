package j;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* loaded from: classes.dex */
public final class F extends m implements SubMenu {

    /* renamed from: A, reason: collision with root package name */
    public final o f7396A;

    /* renamed from: z, reason: collision with root package name */
    public final m f7397z;

    public F(Context context, m mVar, o oVar) {
        super(context);
        this.f7397z = mVar;
        this.f7396A = oVar;
    }

    @Override // j.m
    public final boolean d(o oVar) {
        return this.f7397z.d(oVar);
    }

    @Override // j.m
    public final boolean e(m mVar, MenuItem menuItem) {
        return super.e(mVar, menuItem) || this.f7397z.e(mVar, menuItem);
    }

    @Override // j.m
    public final boolean f(o oVar) {
        return this.f7397z.f(oVar);
    }

    @Override // android.view.SubMenu
    public final MenuItem getItem() {
        return this.f7396A;
    }

    @Override // j.m
    public final String j() {
        o oVar = this.f7396A;
        int i5 = oVar != null ? oVar.f7481a : 0;
        if (i5 == 0) {
            return null;
        }
        return com.unified.ur1.SatelliteTracker.h.a(i5, "android:menu:actionviewstates:");
    }

    @Override // j.m
    public final m k() {
        return this.f7397z.k();
    }

    @Override // j.m
    public final boolean m() {
        return this.f7397z.m();
    }

    @Override // j.m
    public final boolean n() {
        return this.f7397z.n();
    }

    @Override // j.m
    public final boolean o() {
        return this.f7397z.o();
    }

    @Override // j.m, android.view.Menu
    public final void setGroupDividerEnabled(boolean z4) {
        this.f7397z.setGroupDividerEnabled(z4);
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(Drawable drawable) {
        u(0, null, 0, drawable, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(CharSequence charSequence) {
        u(0, charSequence, 0, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderView(View view) {
        u(0, null, 0, null, view);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(Drawable drawable) {
        this.f7396A.setIcon(drawable);
        return this;
    }

    @Override // j.m, android.view.Menu
    public final void setQwertyMode(boolean z4) {
        this.f7397z.setQwertyMode(z4);
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(int i5) {
        u(0, null, i5, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(int i5) {
        u(i5, null, 0, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(int i5) {
        this.f7396A.setIcon(i5);
        return this;
    }
}
