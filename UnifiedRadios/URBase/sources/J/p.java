package j;

import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;

/* loaded from: classes.dex */
public final class p implements ActionProvider.VisibilityListener {

    /* renamed from: a, reason: collision with root package name */
    public final ActionProvider f7504a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t f7505b;

    /* renamed from: c, reason: collision with root package name */
    public B0.l f7506c;

    public p(t tVar, ActionProvider actionProvider) {
        this.f7505b = tVar;
        this.f7504a = actionProvider;
    }

    public final boolean a() {
        return this.f7504a.isVisible();
    }

    public final View b(MenuItem menuItem) {
        return this.f7504a.onCreateActionView(menuItem);
    }

    public final boolean c() {
        return this.f7504a.overridesItemVisibility();
    }

    public final void d(B0.l lVar) {
        this.f7506c = lVar;
        this.f7504a.setVisibilityListener(this);
    }

    @Override // android.view.ActionProvider.VisibilityListener
    public final void onActionProviderVisibilityChanged(boolean z4) {
        B0.l lVar = this.f7506c;
        if (lVar != null) {
            m mVar = ((o) lVar.f110d).n;
            mVar.h = true;
            mVar.p(true);
        }
    }
}
