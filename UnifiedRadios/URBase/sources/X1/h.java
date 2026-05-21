package x1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public final class h implements k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FrameLayout f10430a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LayoutInflater f10431b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f10432c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Bundle f10433d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ AbstractC0960a f10434e;

    public h(AbstractC0960a abstractC0960a, FrameLayout frameLayout, LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f10434e = abstractC0960a;
        this.f10430a = frameLayout;
        this.f10431b = layoutInflater;
        this.f10432c = viewGroup;
        this.f10433d = bundle;
    }

    @Override // x1.k
    public final int a() {
        return 2;
    }

    @Override // x1.k
    public final void b() {
        FrameLayout frameLayout = this.f10430a;
        frameLayout.removeAllViews();
        frameLayout.addView(this.f10434e.zaa.onCreateView(this.f10431b, this.f10432c, this.f10433d));
    }
}
