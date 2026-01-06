package com.unified.ur1.listener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.unified.ur1.primary.LaunchActivity;
import y1.f;

/* loaded from: classes.dex */
public class BootReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) throws Throwable {
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
            Intent intent2 = new Intent(context, (Class<?>) LaunchActivity.class);
            intent2.addFlags(268435456);
            context.startActivity(intent2);
            f.f();
        }
    }
}
