package i;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import j.C;

/* loaded from: classes.dex */
public final class g extends ActionMode {

    /* renamed from: a, reason: collision with root package name */
    public final Context f7138a;

    /* renamed from: b, reason: collision with root package name */
    public final b f7139b;

    public g(Context context, b bVar) {
        this.f7138a = context;
        this.f7139b = bVar;
    }

    @Override // android.view.ActionMode
    public final void finish() {
        this.f7139b.a();
    }

    @Override // android.view.ActionMode
    public final View getCustomView() {
        return this.f7139b.b();
    }

    @Override // android.view.ActionMode
    public final Menu getMenu() {
        return new C(this.f7138a, this.f7139b.c());
    }

    @Override // android.view.ActionMode
    public final MenuInflater getMenuInflater() {
        return this.f7139b.d();
    }

    @Override // android.view.ActionMode
    public final CharSequence getSubtitle() {
        return this.f7139b.f();
    }

    @Override // android.view.ActionMode
    public final Object getTag() {
        return this.f7139b.f7126c;
    }

    @Override // android.view.ActionMode
    public final CharSequence getTitle() {
        return this.f7139b.h();
    }

    @Override // android.view.ActionMode
    public final boolean getTitleOptionalHint() {
        return this.f7139b.f7127d;
    }

    @Override // android.view.ActionMode
    public final void invalidate() {
        this.f7139b.i();
    }

    @Override // android.view.ActionMode
    public final boolean isTitleOptional() {
        return this.f7139b.j();
    }

    @Override // android.view.ActionMode
    public final void setCustomView(View view) {
        this.f7139b.k(view);
    }

    @Override // android.view.ActionMode
    public final void setSubtitle(CharSequence charSequence) {
        this.f7139b.m(charSequence);
    }

    @Override // android.view.ActionMode
    public final void setTag(Object obj) {
        this.f7139b.f7126c = obj;
    }

    @Override // android.view.ActionMode
    public final void setTitle(CharSequence charSequence) {
        this.f7139b.o(charSequence);
    }

    @Override // android.view.ActionMode
    public final void setTitleOptionalHint(boolean z4) {
        this.f7139b.p(z4);
    }

    @Override // android.view.ActionMode
    public final void setSubtitle(int i5) {
        this.f7139b.l(i5);
    }

    @Override // android.view.ActionMode
    public final void setTitle(int i5) {
        this.f7139b.n(i5);
    }
}
