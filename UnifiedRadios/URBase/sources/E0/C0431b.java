package e0;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;

/* renamed from: e0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0431b {

    /* renamed from: a, reason: collision with root package name */
    public final IntentFilter f6140a;

    /* renamed from: b, reason: collision with root package name */
    public final BroadcastReceiver f6141b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f6142c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f6143d;

    public C0431b(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        this.f6140a = intentFilter;
        this.f6141b = broadcastReceiver;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("Receiver{");
        sb.append(this.f6141b);
        sb.append(" filter=");
        sb.append(this.f6140a);
        if (this.f6143d) {
            sb.append(" DEAD");
        }
        sb.append("}");
        return sb.toString();
    }
}
