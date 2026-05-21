package k3;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;

/* loaded from: classes.dex */
public final class J extends KeyguardManager.KeyguardDismissCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7975a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f7976b;

    public /* synthetic */ J(Context context, int i5) {
        this.f7975a = i5;
        this.f7976b = context;
    }

    @Override // android.app.KeyguardManager.KeyguardDismissCallback
    public final void onDismissSucceeded() {
        switch (this.f7975a) {
            case 0:
                ((PowerManager) this.f7976b.getSystemService("power")).newWakeLock(268435466, "MyApp:ScreenWakeLockTag").acquire(600000L);
                break;
            case 1:
                ((PowerManager) this.f7976b.getSystemService("power")).newWakeLock(268435466, "MyApp:ScreenWakeLockTag").acquire(600000L);
                break;
            case 2:
                ((PowerManager) this.f7976b.getSystemService("power")).newWakeLock(268435466, "MyApp:ScreenWakeLockTag").acquire(600000L);
                break;
            case 3:
                ((PowerManager) this.f7976b.getSystemService("power")).newWakeLock(268435466, "MyApp:ScreenWakeLockTag").acquire(600000L);
                break;
            default:
                ((PowerManager) this.f7976b.getSystemService("power")).newWakeLock(268435466, "MyApp:ScreenWakeLockTag").acquire(600000L);
                break;
        }
    }
}
