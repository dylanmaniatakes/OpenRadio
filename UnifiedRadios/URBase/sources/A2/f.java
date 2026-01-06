package A2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class f extends BroadcastReceiver {

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicReference f22b = new AtomicReference();

    /* renamed from: a, reason: collision with root package name */
    public final Context f23a;

    public f(Context context) {
        this.f23a = context;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        synchronized (g.f24j) {
            try {
                Iterator it = ((q.j) g.f25k.values()).iterator();
                while (it.hasNext()) {
                    ((g) it.next()).d();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f23a.unregisterReceiver(this);
    }
}
