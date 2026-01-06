package K0;

import android.app.Notification;
import android.app.Service;

/* loaded from: classes.dex */
public abstract class e {
    public static void a(Service service, int i5, Notification notification, int i6) {
        service.startForeground(i5, notification, i6);
    }
}
