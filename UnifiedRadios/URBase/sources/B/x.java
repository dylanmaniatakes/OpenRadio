package B;

import android.app.NotificationManager;
import android.content.Context;
import java.util.HashSet;

/* loaded from: classes.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public final NotificationManager f85a;

    static {
        new HashSet();
    }

    public x(Context context) {
        this.f85a = (NotificationManager) context.getSystemService("notification");
    }
}
