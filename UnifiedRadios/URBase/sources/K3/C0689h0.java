package k3;

import com.unified.ur1.primary.LaunchActivity;
import java.util.concurrent.ThreadPoolExecutor;

/* renamed from: k3.h0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0689h0 extends e4.a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LaunchActivity f8135b;

    public C0689h0(LaunchActivity launchActivity) {
        this.f8135b = launchActivity;
    }

    @Override // e4.a
    public final void s() {
        ThreadPoolExecutor threadPoolExecutor;
        LaunchActivity launchActivity = this.f8135b;
        if (launchActivity.f5886M == 0 && C0.g != null && (threadPoolExecutor = launchActivity.f5922e0) != null) {
            threadPoolExecutor.execute(new T(launchActivity, 7));
        }
        launchActivity.f5919d0.f7949f = null;
    }
}
