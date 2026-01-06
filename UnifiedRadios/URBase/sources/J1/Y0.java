package J1;

import android.os.Bundle;

/* loaded from: classes.dex */
public final class Y0 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ String f1063j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ String f1064k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ long f1065l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Bundle f1066m;
    public final /* synthetic */ boolean n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ boolean f1067o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ boolean f1068p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ C0058c1 f1069q;

    public Y0(C0058c1 c0058c1, String str, String str2, long j5, Bundle bundle, boolean z4, boolean z5, boolean z6) {
        this.f1063j = str;
        this.f1064k = str2;
        this.f1065l = j5;
        this.f1066m = bundle;
        this.n = z4;
        this.f1067o = z5;
        this.f1068p = z6;
        this.f1069q = c0058c1;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        this.f1069q.w(this.f1063j, this.f1064k, this.f1065l, this.f1066m, this.n, this.f1067o, this.f1068p);
    }
}
