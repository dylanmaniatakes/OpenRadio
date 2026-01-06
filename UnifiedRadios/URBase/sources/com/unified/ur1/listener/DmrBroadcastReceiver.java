package com.unified.ur1.listener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/* loaded from: classes.dex */
public class DmrBroadcastReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if ("dmr.play.DMR_REVC_END".equals(intent.getAction())) {
            Log.d("DmrBroadcastReceiver", "Received DMR_REVC_END broadcast");
        }
        if ("dmr.knob.TIMER".equals(intent.getAction())) {
            Log.d("DmrBroadcastReceiver", "Received dmr.knob.TIMER Broadcast");
        }
        if ("com.android.knobkey.channel".equals(intent.getAction())) {
            Log.d("DmrBroadcastReceiver", "Received com.android.knobkey.channel Broadcast");
        }
        if ("dmr.play.DMR_REVC_START".equals(intent.getAction())) {
            Log.d("DmrBroadcastReceiver", "Received DMR_REVC_START broadcast");
        }
        if ("com.interphone.ptt.down".equals(intent.getAction())) {
            Log.d("DmrBroadcastReceiver", "Received com.interphone.ptt.down");
        }
        if ("com.interphone.ptt.up".equals(intent.getAction())) {
            Log.d("DmrBroadcastReceiver", "com.interphone.ptt.up");
        }
        if ("dmr.play.SEND_START".equals(intent.getAction())) {
            Log.d("DmrBroadcastReceiver", "Received dmr.play.SEND_START broadcast");
        }
        if ("dmr.play.SEND_END".equals(intent.getAction())) {
            Log.d("DmrBroadcastReceiver", "Received dmr.play.SEND_END broadcast");
        }
        if ("android.intent.action.ACTION_VIDEO_DOWN".equals(intent.getAction())) {
            Log.d("DmrBroadcastReceiver", "Received android.intent.action.ACTION_VIDEO_DOWN broadcast");
        }
        if ("android.intent.action.ACTION_VIDEO_UP".equals(intent.getAction())) {
            Log.d("DmrBroadcastReceiver", "Received android.intent.action.ACTION_VIDEO_UP broadcast");
        }
        if ("android.intent.action.PTT.down".equals(intent.getAction())) {
            Log.d("DmrBroadcastReceiver", "Received android.intent.action.PTT.down broadcast");
        }
        if ("android.intent.action.PTT.up".equals(intent.getAction())) {
            Log.d("DmrBroadcastReceiver", "Received android.intent.action.PTT.up broadcast");
        }
        if ("com.android.ptt.key.down".equals(intent.getAction())) {
            Log.d("DmrBroadcastReceiver", "Received com.android.ptt.key.down broadcast");
        }
        if ("com.android.ptt.key.up".equals(intent.getAction())) {
            Log.d("DmrBroadcastReceiver", "Received com.android.ptt.key.up broadcast");
        }
    }
}
