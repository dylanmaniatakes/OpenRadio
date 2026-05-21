package j;

import android.view.MenuItem;

/* loaded from: classes.dex */
public final class r implements MenuItem.OnActionExpandListener {

    /* renamed from: a, reason: collision with root package name */
    public final MenuItem.OnActionExpandListener f7508a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t f7509b;

    public r(t tVar, MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f7509b = tVar;
        this.f7508a = onActionExpandListener;
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public final boolean onMenuItemActionCollapse(MenuItem menuItem) {
        return this.f7508a.onMenuItemActionCollapse(this.f7509b.f(menuItem));
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public final boolean onMenuItemActionExpand(MenuItem menuItem) {
        return this.f7508a.onMenuItemActionExpand(this.f7509b.f(menuItem));
    }
}
