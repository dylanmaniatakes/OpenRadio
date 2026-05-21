package k3;

import com.unified.ur1.primary.LaunchActivity;

/* renamed from: k3.u0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0714u0 extends e4.a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f8220b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LaunchActivity f8221c;

    public C0714u0(LaunchActivity launchActivity, int i5) {
        this.f8221c = launchActivity;
        this.f8220b = i5;
    }

    @Override // e4.a
    public final void s() {
        this.f8221c.runOnUiThread(new RunnableC0691i0(2, this));
    }
}
