package k3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes.dex */
public final class F extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if ("com.unified.ur1.ROIP_CALL_STARTED".equals(intent.getAction())) {
            intent.getIntExtra("srcId", 0);
            intent.getStringExtra("callsign");
        }
    }
}
