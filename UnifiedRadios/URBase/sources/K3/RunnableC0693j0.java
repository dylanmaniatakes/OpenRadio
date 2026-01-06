package k3;

import com.unified.ur1.primary.LaunchActivity;

/* renamed from: k3.j0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0693j0 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ byte f8144j = -128;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ LaunchActivity f8145k;

    public RunnableC0693j0(LaunchActivity launchActivity) {
        this.f8145k = launchActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f8145k.runOnUiThread(new RunnableC0691i0(0, this));
    }
}
