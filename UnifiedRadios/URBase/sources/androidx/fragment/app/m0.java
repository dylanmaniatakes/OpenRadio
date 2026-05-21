package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import androidx.lifecycle.AbstractC0245o;
import androidx.lifecycle.C0251v;
import androidx.lifecycle.EnumC0243m;
import androidx.lifecycle.InterfaceC0239i;

/* loaded from: classes.dex */
public final class m0 implements InterfaceC0239i, o0.e, androidx.lifecycle.X {

    /* renamed from: c, reason: collision with root package name */
    public final Fragment f3833c;

    /* renamed from: d, reason: collision with root package name */
    public final androidx.lifecycle.W f3834d;

    /* renamed from: e, reason: collision with root package name */
    public androidx.lifecycle.V f3835e;

    /* renamed from: f, reason: collision with root package name */
    public C0251v f3836f = null;
    public o0.d g = null;

    public m0(Fragment fragment, androidx.lifecycle.W w4) {
        this.f3833c = fragment;
        this.f3834d = w4;
    }

    public final void a(EnumC0243m enumC0243m) {
        this.f3836f.e(enumC0243m);
    }

    public final void b() {
        if (this.f3836f == null) {
            this.f3836f = new C0251v(this);
            this.g = new o0.d(this);
        }
    }

    @Override // androidx.lifecycle.InterfaceC0239i
    public final androidx.lifecycle.V getDefaultViewModelProviderFactory() {
        Application application;
        Fragment fragment = this.f3833c;
        androidx.lifecycle.V defaultViewModelProviderFactory = fragment.getDefaultViewModelProviderFactory();
        if (!defaultViewModelProviderFactory.equals(fragment.mDefaultFactory)) {
            this.f3835e = defaultViewModelProviderFactory;
            return defaultViewModelProviderFactory;
        }
        if (this.f3835e == null) {
            Context applicationContext = fragment.requireContext().getApplicationContext();
            while (true) {
                if (!(applicationContext instanceof ContextWrapper)) {
                    application = null;
                    break;
                }
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                }
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
            this.f3835e = new androidx.lifecycle.P(application, this, fragment.getArguments());
        }
        return this.f3835e;
    }

    @Override // androidx.lifecycle.InterfaceC0249t
    public final AbstractC0245o getLifecycle() {
        b();
        return this.f3836f;
    }

    @Override // o0.e
    public final o0.c getSavedStateRegistry() {
        b();
        return this.g.f8893b;
    }

    @Override // androidx.lifecycle.X
    public final androidx.lifecycle.W getViewModelStore() {
        b();
        return this.f3834d;
    }
}
