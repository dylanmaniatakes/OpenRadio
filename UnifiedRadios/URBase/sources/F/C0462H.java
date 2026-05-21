package f;

import android.content.Context;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;
import k.C0637j;

/* renamed from: f.H, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0462H extends i.b implements j.k {

    /* renamed from: e, reason: collision with root package name */
    public final Context f6260e;

    /* renamed from: f, reason: collision with root package name */
    public final j.m f6261f;
    public i.a g;
    public WeakReference h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ C0463I f6262i;

    public C0462H(C0463I c0463i, Context context, L0.e eVar) {
        this.f6262i = c0463i;
        this.f6260e = context;
        this.g = eVar;
        j.m mVar = new j.m(context);
        mVar.f7463l = 1;
        this.f6261f = mVar;
        mVar.f7458e = this;
    }

    @Override // i.b
    public final void a() {
        C0463I c0463i = this.f6262i;
        if (c0463i.f6271i != this) {
            return;
        }
        boolean z4 = c0463i.f6277p;
        boolean z5 = c0463i.f6278q;
        if (z4 || z5) {
            c0463i.f6272j = this;
            c0463i.f6273k = this.g;
        } else {
            this.g.b(this);
        }
        this.g = null;
        c0463i.s(false);
        ActionBarContextView actionBarContextView = c0463i.f6270f;
        if (actionBarContextView.f3327m == null) {
            actionBarContextView.e();
        }
        c0463i.f6267c.setHideOnContentScrollEnabled(c0463i.f6283v);
        c0463i.f6271i = null;
    }

    @Override // i.b
    public final View b() {
        WeakReference weakReference = this.h;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // i.b
    public final j.m c() {
        return this.f6261f;
    }

    @Override // i.b
    public final MenuInflater d() {
        return new i.j(this.f6260e);
    }

    @Override // j.k
    public final void e(j.m mVar) {
        if (this.g == null) {
            return;
        }
        i();
        C0637j c0637j = this.f6262i.f6270f.f3322f;
        if (c0637j != null) {
            c0637j.n();
        }
    }

    @Override // i.b
    public final CharSequence f() {
        return this.f6262i.f6270f.getSubtitle();
    }

    @Override // j.k
    public final boolean g(j.m mVar, MenuItem menuItem) {
        i.a aVar = this.g;
        if (aVar != null) {
            return aVar.a(this, menuItem);
        }
        return false;
    }

    @Override // i.b
    public final CharSequence h() {
        return this.f6262i.f6270f.getTitle();
    }

    @Override // i.b
    public final void i() {
        if (this.f6262i.f6271i != this) {
            return;
        }
        j.m mVar = this.f6261f;
        mVar.w();
        try {
            this.g.e(this, mVar);
        } finally {
            mVar.v();
        }
    }

    @Override // i.b
    public final boolean j() {
        return this.f6262i.f6270f.f3334u;
    }

    @Override // i.b
    public final void k(View view) {
        this.f6262i.f6270f.setCustomView(view);
        this.h = new WeakReference(view);
    }

    @Override // i.b
    public final void l(int i5) {
        m(this.f6262i.f6265a.getResources().getString(i5));
    }

    @Override // i.b
    public final void m(CharSequence charSequence) {
        this.f6262i.f6270f.setSubtitle(charSequence);
    }

    @Override // i.b
    public final void n(int i5) {
        o(this.f6262i.f6265a.getResources().getString(i5));
    }

    @Override // i.b
    public final void o(CharSequence charSequence) {
        this.f6262i.f6270f.setTitle(charSequence);
    }

    @Override // i.b
    public final void p(boolean z4) {
        this.f7127d = z4;
        this.f6262i.f6270f.setTitleOptional(z4);
    }
}
