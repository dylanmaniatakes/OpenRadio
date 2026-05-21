package androidx.room;

import F3.i;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import java.util.LinkedHashMap;
import l0.BinderC0734j;
import l0.RemoteCallbackListC0735k;

/* loaded from: classes.dex */
public final class MultiInstanceInvalidationService extends Service {

    /* renamed from: c, reason: collision with root package name */
    public int f4402c;

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f4403d = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    public final RemoteCallbackListC0735k f4404e = new RemoteCallbackListC0735k(this);

    /* renamed from: f, reason: collision with root package name */
    public final BinderC0734j f4405f = new BinderC0734j(this);

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        i.f(intent, "intent");
        return this.f4405f;
    }
}
