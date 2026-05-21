package com.unified.ur1.rfmodule;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import m3.q;

/* loaded from: classes.dex */
public class BootReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if ("android.intent.action.BOOT_COMPLETED".equals(intent.getAction())) {
            context.startForegroundService(new Intent(context, (Class<?>) q.class));
        }
    }
}
