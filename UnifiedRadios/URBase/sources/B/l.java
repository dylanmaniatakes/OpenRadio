package B;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import java.util.HashMap;

/* loaded from: classes.dex */
public abstract class l extends Service {

    /* renamed from: c, reason: collision with root package name */
    public k f52c;

    /* renamed from: d, reason: collision with root package name */
    public j f53d;

    static {
        new HashMap();
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        k kVar = this.f52c;
        if (kVar != null) {
            return kVar.getBinder();
        }
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        this.f52c = new k(this);
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i5, int i6) {
        return 2;
    }
}
