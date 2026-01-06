package com.unified.ur1.rfmodule;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import m3.r;

/* loaded from: classes.dex */
public class KeyHandlerService$KeyReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action == null) {
        }
        switch (action) {
            case "android.intent.action.SCREEN_OFF":
                new Intent(context, (Class<?>) r.class).setAction("SCREEN_OFF_ACTION");
                break;
            case "android.intent.action.KEYCODE_F1":
                Intent intent2 = new Intent("com.unified.ur1.PTT_ACTION");
                intent2.putExtra("action", "toggle");
                context.sendBroadcast(intent2);
                break;
            case "android.intent.action.SCREEN_ON":
                Intent intent3 = new Intent(context, (Class<?>) r.class);
                intent3.setAction("SCREEN_ON_ACTION");
                context.startService(intent3);
                break;
        }
    }
}
