package K0;

import C0.t;
import android.app.ForegroundServiceStartNotAllowedException;
import android.app.Notification;
import android.app.Service;
import android.util.Log;
import androidx.work.impl.foreground.SystemForegroundService;

/* loaded from: classes.dex */
public abstract class f {
    public static void a(Service service, int i5, Notification notification, int i6) {
        try {
            service.startForeground(i5, notification, i6);
        } catch (ForegroundServiceStartNotAllowedException e5) {
            t tVarD = t.d();
            String str = SystemForegroundService.h;
            if (tVarD.f174a <= 5) {
                Log.w(str, "Unable to start foreground service", e5);
            }
        }
    }
}
