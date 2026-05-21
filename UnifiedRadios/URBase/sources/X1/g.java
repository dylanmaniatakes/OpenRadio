package x1;

import android.os.Bundle;

/* loaded from: classes.dex */
public final class g implements k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Bundle f10428a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AbstractC0960a f10429b;

    public g(AbstractC0960a abstractC0960a, Bundle bundle) {
        this.f10429b = abstractC0960a;
        this.f10428a = bundle;
    }

    @Override // x1.k
    public final int a() {
        return 1;
    }

    @Override // x1.k
    public final void b() {
        this.f10429b.zaa.onCreate(this.f10428a);
    }
}
