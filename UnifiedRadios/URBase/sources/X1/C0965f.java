package x1;

import android.app.Activity;
import android.os.Bundle;

/* renamed from: x1.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0965f implements k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f10424a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bundle f10425b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Bundle f10426c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AbstractC0960a f10427d;

    public C0965f(AbstractC0960a abstractC0960a, Activity activity, Bundle bundle, Bundle bundle2) {
        this.f10427d = abstractC0960a;
        this.f10424a = activity;
        this.f10425b = bundle;
        this.f10426c = bundle2;
    }

    @Override // x1.k
    public final int a() {
        return 0;
    }

    @Override // x1.k
    public final void b() {
        this.f10427d.zaa.onInflate(this.f10424a, this.f10425b, this.f10426c);
    }
}
