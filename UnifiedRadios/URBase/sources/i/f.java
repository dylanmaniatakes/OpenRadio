package i;

import android.content.Context;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;
import k.C0637j;

/* loaded from: classes.dex */
public final class f extends b implements j.k {

    /* renamed from: e, reason: collision with root package name */
    public Context f7134e;

    /* renamed from: f, reason: collision with root package name */
    public ActionBarContextView f7135f;
    public a g;
    public WeakReference h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f7136i;

    /* renamed from: j, reason: collision with root package name */
    public j.m f7137j;

    @Override // i.b
    public final void a() {
        if (this.f7136i) {
            return;
        }
        this.f7136i = true;
        this.g.b(this);
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
        return this.f7137j;
    }

    @Override // i.b
    public final MenuInflater d() {
        return new j(this.f7135f.getContext());
    }

    @Override // j.k
    public final void e(j.m mVar) {
        i();
        C0637j c0637j = this.f7135f.f3322f;
        if (c0637j != null) {
            c0637j.n();
        }
    }

    @Override // i.b
    public final CharSequence f() {
        return this.f7135f.getSubtitle();
    }

    @Override // j.k
    public final boolean g(j.m mVar, MenuItem menuItem) {
        return this.g.a(this, menuItem);
    }

    @Override // i.b
    public final CharSequence h() {
        return this.f7135f.getTitle();
    }

    @Override // i.b
    public final void i() {
        this.g.e(this, this.f7137j);
    }

    @Override // i.b
    public final boolean j() {
        return this.f7135f.f3334u;
    }

    @Override // i.b
    public final void k(View view) {
        this.f7135f.setCustomView(view);
        this.h = view != null ? new WeakReference(view) : null;
    }

    @Override // i.b
    public final void l(int i5) {
        m(this.f7134e.getString(i5));
    }

    @Override // i.b
    public final void m(CharSequence charSequence) {
        this.f7135f.setSubtitle(charSequence);
    }

    @Override // i.b
    public final void n(int i5) {
        o(this.f7134e.getString(i5));
    }

    @Override // i.b
    public final void o(CharSequence charSequence) {
        this.f7135f.setTitle(charSequence);
    }

    @Override // i.b
    public final void p(boolean z4) {
        this.f7127d = z4;
        this.f7135f.setTitleOptional(z4);
    }
}
