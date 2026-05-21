package K0;

import android.app.Notification;
import android.os.Build;
import androidx.work.impl.foreground.SystemForegroundService;

/* loaded from: classes.dex */
public final class d implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f1500j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Notification f1501k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f1502l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ SystemForegroundService f1503m;

    public d(SystemForegroundService systemForegroundService, int i5, Notification notification, int i6) {
        this.f1503m = systemForegroundService;
        this.f1500j = i5;
        this.f1501k = notification;
        this.f1502l = i6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i5 = Build.VERSION.SDK_INT;
        int i6 = this.f1502l;
        Notification notification = this.f1501k;
        int i7 = this.f1500j;
        SystemForegroundService systemForegroundService = this.f1503m;
        if (i5 >= 31) {
            f.a(systemForegroundService, i7, notification, i6);
        } else if (i5 >= 29) {
            e.a(systemForegroundService, i7, notification, i6);
        } else {
            systemForegroundService.startForeground(i7, notification);
        }
    }
}
