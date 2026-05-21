package com.unified.ur1.rfmodule;

import android.accessibilityservice.AccessibilityService;
import android.content.Intent;
import android.util.Log;
import android.view.KeyEvent;
import android.view.accessibility.AccessibilityEvent;

/* loaded from: classes.dex */
public class KeyAccessibilityService extends AccessibilityService {
    @Override // android.accessibilityservice.AccessibilityService
    public final void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
    }

    @Override // android.accessibilityservice.AccessibilityService
    public final void onInterrupt() {
    }

    @Override // android.accessibilityservice.AccessibilityService
    public final boolean onKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 131) {
            return super.onKeyEvent(keyEvent);
        }
        Log.d("KeyAccessibilityService", "F1 key event detected: " + keyEvent.getAction());
        Intent intent = new Intent("com.unified.ur1.KEY_EVENT");
        intent.putExtra("keyCode", keyCode);
        intent.putExtra("action", keyEvent.getAction());
        sendBroadcast(intent);
        return true;
    }
}
