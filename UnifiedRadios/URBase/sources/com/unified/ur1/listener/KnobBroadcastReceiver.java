package com.unified.ur1.listener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/* loaded from: classes.dex */
public class KnobBroadcastReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        int i5;
        int intExtra;
        boolean z4;
        int intExtra2;
        Log.e("KnobBroadcastReceiver", "========== BROADCAST RECEIVED ==========");
        StringBuilder sb = new StringBuilder("Action: ");
        sb.append(intent != null ? intent.getAction() : "null");
        Log.e("KnobBroadcastReceiver", sb.toString());
        Log.e("KnobBroadcastReceiver", "Timestamp: " + System.currentTimeMillis());
        if (intent == null) {
            Log.e("KnobBroadcastReceiver", "Intent is null!");
            return;
        }
        if (intent.getExtras() != null) {
            Log.e("KnobBroadcastReceiver", "Extras found: " + intent.getExtras().size());
            for (String str : intent.getExtras().keySet()) {
                Object obj = intent.getExtras().get(str);
                StringBuilder sb2 = new StringBuilder("Extra: ");
                sb2.append(str);
                sb2.append(" = ");
                sb2.append(obj);
                sb2.append(" (type: ");
                sb2.append(obj != null ? obj.getClass().getSimpleName() : "null");
                sb2.append(")");
                Log.e("KnobBroadcastReceiver", sb2.toString());
            }
        } else {
            Log.e("KnobBroadcastReceiver", "No extras in intent");
        }
        if ("dmr.knob.TIMER".equals(intent.getAction()) || "com.android.knobkey.channel".equals(intent.getAction())) {
            Log.e("KnobBroadcastReceiver", "Processing knob timer broadcast...");
            String[] strArr = {"direction", "rotation", "delta", "value", "step", "change"};
            String[] strArr2 = {"steps", "count", "amount"};
            int i6 = 0;
            int i7 = 0;
            while (true) {
                i5 = 1;
                if (i7 >= 6) {
                    intExtra = 0;
                    z4 = false;
                    break;
                }
                String str2 = strArr[i7];
                if (intent.hasExtra(str2)) {
                    intExtra = intent.getIntExtra(str2, 0);
                    Log.e("KnobBroadcastReceiver", "Found direction in key '" + str2 + "': " + intExtra);
                    z4 = true;
                    break;
                }
                i7++;
            }
            while (true) {
                if (i6 >= 3) {
                    intExtra2 = 1;
                    break;
                }
                String str3 = strArr2[i6];
                if (intent.hasExtra(str3)) {
                    intExtra2 = intent.getIntExtra(str3, 1);
                    Log.e("KnobBroadcastReceiver", "Found steps in key '" + str3 + "': " + intExtra2);
                    break;
                }
                i6++;
            }
            if (z4) {
                i5 = intExtra;
            } else {
                Log.e("KnobBroadcastReceiver", "No direction extra found, defaulting to clockwise (1)");
            }
            Log.e("KnobBroadcastReceiver", "Final values - direction: " + i5 + ", steps: " + intExtra2);
            Intent intent2 = new Intent(context, (Class<?>) VolumeControlService.class);
            intent2.setAction("HANDLE_KNOB_ROTATION");
            intent2.putExtra("direction", i5);
            intent2.putExtra("steps", intExtra2);
            intent2.putExtra("timestamp", System.currentTimeMillis());
            try {
                context.startForegroundService(intent2);
                Log.e("KnobBroadcastReceiver", "Volume control service started successfully");
            } catch (Exception e5) {
                Log.e("KnobBroadcastReceiver", "Failed to start volume control service: " + e5.getMessage());
                e5.printStackTrace();
            }
        } else {
            Log.e("KnobBroadcastReceiver", "Ignoring broadcast with action: " + intent.getAction());
        }
        Log.e("KnobBroadcastReceiver", "========================================");
    }
}
