package com.unified.ur1.inbox;

import B.n;
import B.t;
import B0.l;
import X2.j;
import X2.r;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.unified.ur1.R;
import com.unified.ur1.chat.ChatActivity;
import f3.E0;
import g0.AbstractC0535a;
import h4.c;
import i3.C0573b;
import i3.z;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import q.b;

/* loaded from: classes.dex */
public class MyFirebaseMessagingService extends FirebaseMessagingService {

    /* renamed from: j, reason: collision with root package name */
    public C0573b f5825j;

    /* renamed from: k, reason: collision with root package name */
    public SharedPreferences f5826k;

    public static void f(SharedPreferences sharedPreferences) {
        try {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            long jCurrentTimeMillis = System.currentTimeMillis() - 300000;
            for (String str : sharedPreferences.getAll().keySet()) {
                if (str.startsWith("msg_") && sharedPreferences.getLong(str, 0L) < jCurrentTimeMillis) {
                    editorEdit.remove(str);
                }
            }
            editorEdit.apply();
        } catch (Exception e5) {
            Log.e("MyFirebaseMsgService", "Error cleaning up processed messages", e5);
        }
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService, X2.g
    public final void b(Intent intent) throws NumberFormatException {
        String str;
        Bundle extras;
        String string;
        String string2;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        String str2;
        String str3 = "message_body";
        try {
            Log.d("MyFirebaseMsgService", "Handling intent: " + intent.toString());
            Bundle extras2 = intent.getExtras();
            try {
                if (extras2 != null) {
                    Log.d("MyFirebaseMsgService", "Intent extras: " + extras2.toString());
                    String string3 = extras2.getString("message_id");
                    String string4 = extras2.getString("from_callsign");
                    String string5 = extras2.getString("subject");
                    String string6 = extras2.getString("message_body");
                    String string7 = extras2.getString("priority");
                    String string8 = extras2.getString("is_high_sensitivity");
                    String string9 = extras2.getString("type");
                    String string10 = extras2.getString("to_callsign");
                    String string11 = extras2.getString("team_id");
                    try {
                        string = extras2.getString("team_name");
                        string2 = extras2.getString("gcm.notification.title");
                        str = "gcm.notification.title";
                    } catch (Exception e5) {
                        e = e5;
                        str = "gcm.notification.title";
                    }
                    try {
                        String string12 = extras2.getString("gcm.notification.body");
                        String string13 = extras2.getString("google.message_id");
                        String string14 = extras2.getString("gcm.message_id");
                        if (string3 == null && string2 == null && string13 == null && string14 == null && string4 == null && string11 == null) {
                        }
                        Log.d("MyFirebaseMsgService", "INTERCEPTING FCM message to prevent duplicate notification");
                        HashMap map = new HashMap();
                        if (string3 != null) {
                            map.put("message_id", string3);
                        }
                        if (string4 != null) {
                            map.put("from_callsign", string4);
                        }
                        if (string10 != null) {
                            map.put("to_callsign", string10);
                        }
                        if (string5 != null) {
                            obj = "subject";
                            map.put(obj, string5);
                        } else {
                            obj = "subject";
                        }
                        if (string6 != null) {
                            obj2 = "message_body";
                            map.put(obj2, string6);
                        } else {
                            obj2 = "message_body";
                        }
                        if (string7 != null) {
                            obj3 = "priority";
                            map.put(obj3, string7);
                        } else {
                            obj3 = "priority";
                        }
                        if (string8 != null) {
                            map.put("is_high_sensitivity", string8);
                        }
                        if (string9 != null) {
                            obj4 = "type";
                            map.put(obj4, string9);
                        } else {
                            obj4 = "type";
                        }
                        if (string11 != null) {
                            str3 = "team_id";
                            try {
                                map.put(str3, string11);
                            } catch (Exception e6) {
                                e = e6;
                                Log.e("MyFirebaseMsgService", "Error handling intent", e);
                                extras = intent.getExtras();
                                if (extras != null || (extras.getString("message_id") == null && extras.getString("from_callsign") == null && extras.getString(str3) == null && extras.getString(str) == null)) {
                                    super.b(intent);
                                    return;
                                } else {
                                    Log.d("MyFirebaseMsgService", "Error in our handler but detected our message - not passing to FCM");
                                    return;
                                }
                            }
                        } else {
                            str3 = "team_id";
                        }
                        if (string != null) {
                            map.put("team_name", string);
                        }
                        if (string2 != null) {
                            map.put("title", string2);
                        }
                        if (string12 == null || map.containsKey(obj2)) {
                            str2 = string12;
                        } else {
                            str2 = string12;
                            map.put(obj2, str2);
                        }
                        if (str2 != null && !map.containsKey(obj)) {
                            map.put(obj, str2);
                        }
                        if (!map.containsKey(obj4)) {
                            if (string11 == null || string11.isEmpty()) {
                                map.put(obj4, "direct_message");
                            } else {
                                map.put(obj4, "team_message");
                            }
                        }
                        if (!map.containsKey(obj3)) {
                            map.put(obj3, "normal");
                        }
                        Log.d("MyFirebaseMsgService", "Processing intercepted FCM message with data: " + map.toString());
                        g(map);
                        Log.d("MyFirebaseMsgService", "FCM message intercepted successfully - preventing default notification");
                        return;
                    } catch (Exception e7) {
                        e = e7;
                        str3 = "team_id";
                        Log.e("MyFirebaseMsgService", "Error handling intent", e);
                        extras = intent.getExtras();
                        if (extras != null) {
                        }
                        super.b(intent);
                        return;
                    }
                }
                Log.d("MyFirebaseMsgService", "No FCM message data found, passing to FCM default handler");
                super.b(intent);
            } catch (Exception e8) {
                e = e8;
            }
        } catch (Exception e9) {
            e = e9;
            str = "gcm.notification.title";
            str3 = "team_id";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.util.HashMap] */
    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public final void c(r rVar) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        Log.d("MyFirebaseMsgService", "Message received from: " + rVar.f2830j.getString("from"));
        b bVar = rVar.f2831k;
        Bundle bundle = rVar.f2830j;
        if (bVar == null) {
            b bVar2 = new b();
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (!str.startsWith("google.") && !str.startsWith("gcm.") && !str.equals("from") && !str.equals("message_type") && !str.equals("collapse_key")) {
                        bVar2.put(str, str2);
                    }
                }
            }
            rVar.f2831k = bVar2;
        }
        b map = rVar.f2831k;
        if (rVar.f2832l == null && l.t(bundle)) {
            rVar.f2832l = new j(new l(bundle));
        }
        j jVar = rVar.f2832l;
        if (jVar != null) {
            StringBuilder sb = new StringBuilder("FCM notification payload detected: ");
            String str3 = (String) jVar.f2808a;
            sb.append(str3);
            sb.append(" - ");
            String str4 = (String) jVar.f2809b;
            sb.append(str4);
            Log.d("MyFirebaseMsgService", sb.toString());
            map = map.isEmpty() ? new HashMap() : new HashMap(map);
            if (str3 != null) {
                map.put("title", str3);
            }
            if (str4 != null) {
                map.put("subject", str4);
                if (!map.containsKey("message_body")) {
                    map.put("message_body", str4);
                }
            }
        }
        boolean zIsEmpty = map.isEmpty();
        b bVar3 = map;
        if (zIsEmpty) {
            Log.d("MyFirebaseMsgService", "No data payload found, creating minimal message data");
            ?? map2 = new HashMap();
            map2.put("message_id", String.valueOf(System.currentTimeMillis()));
            map2.put("type", "new_message");
            map2.put("priority", "normal");
            map2.put("title", "New Message");
            map2.put("subject", "You have a new message");
            bVar3 = map2;
        }
        if (!bVar3.containsKey("type")) {
            bVar3.put("type", "new_message");
        }
        if (!bVar3.containsKey("priority")) {
            bVar3.put("priority", "normal");
        }
        if (!bVar3.containsKey("message_id")) {
            bVar3.put("message_id", String.valueOf(System.currentTimeMillis()));
        }
        Log.d("MyFirebaseMsgService", "Processing all messages through custom handler: " + bVar3.toString());
        g(bVar3);
        Log.d("MyFirebaseMsgService", "Message processed through custom handler - FCM defaults suppressed");
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public final void d(String str) {
        AbstractC0535a.v("Refreshed token: ", str, "MyFirebaseMsgService");
        try {
            SharedPreferences.Editor editorEdit = this.f5826k.edit();
            editorEdit.putString("fcm_token", str);
            editorEdit.putLong("fcm_token_timestamp", System.currentTimeMillis());
            editorEdit.putBoolean("fcm_registered", false);
            editorEdit.apply();
            Log.d("MyFirebaseMsgService", "New FCM token stored locally");
            try {
                String strH = c.h(this);
                if (strH == null || strH.isEmpty()) {
                    Log.w("MyFirebaseMsgService", "Cannot send token to server - no user callsign");
                } else {
                    Log.d("MyFirebaseMsgService", "Token will be sent to server for callsign: ".concat(strH));
                }
            } catch (Exception e5) {
                Log.e("MyFirebaseMsgService", "Error preparing to send token to server", e5);
            }
        } catch (Exception e6) {
            Log.e("MyFirebaseMsgService", "Error handling new FCM token", e6);
        }
    }

    public final void e(t tVar, int i5, boolean z4, String str, String str2) {
        Intent intent;
        if (i5 > 0 || z4) {
            if (!z4 && i5 > 0) {
                try {
                    Intent intent2 = new Intent(this, (Class<?>) z.class);
                    intent2.setAction("MARK_AS_READ");
                    intent2.putExtra("message_id", i5);
                    tVar.f65b.add(new n(R.drawable.ic_envelope, "Mark Read", PendingIntent.getBroadcast(this, i5 + 1000, intent2, 201326592)));
                } catch (Exception e5) {
                    Log.e("MyFirebaseMsgService", "Error adding notification actions", e5);
                    return;
                }
            }
            if (z4 && str != null) {
                intent = new Intent(this, (Class<?>) ChatActivity.class);
                intent.putExtra("team_id", str);
            } else if (z4 || str2 == null) {
                intent = new Intent(this, (Class<?>) ComposeMessageActivity.class);
                if (i5 > 0) {
                    intent.putExtra("reply_to_message_id", i5);
                }
            } else {
                intent = new Intent(this, (Class<?>) ChatActivity.class);
                intent.putExtra("other_user_callsign", str2);
            }
            intent.addFlags(335544320);
            tVar.f65b.add(new n(R.drawable.ic_message, "Reply", PendingIntent.getActivity(this, i5 + 2000, intent, 201326592)));
        }
    }

    public final void g(Map map) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        String str;
        boolean z4;
        String str2;
        int i5;
        String str3;
        String str4;
        int i6;
        String string;
        Log.d("MyFirebaseMsgService", "Handling data message: " + map.toString());
        try {
            String str5 = (String) map.get("message_id");
            System.currentTimeMillis();
            if (h(str5)) {
                Log.d("MyFirebaseMsgService", "Skipping duplicate message: " + str5);
                return;
            }
            String str6 = (String) map.get("type");
            String str7 = (String) map.get("title");
            String str8 = (String) map.get("message_body");
            String str9 = (String) map.get("from_callsign");
            String str10 = (String) map.get("to_callsign");
            String str11 = (String) map.get("subject");
            String str12 = str8;
            String str13 = (String) map.get("unread_count");
            String str14 = (String) map.get("priority");
            String str15 = (String) map.get("is_high_sensitivity");
            String str16 = (String) map.get("team_id");
            String str17 = (String) map.get("team_name");
            if (str16 == null || str16.isEmpty()) {
                str = str17;
                z4 = false;
            } else {
                str = str17;
                z4 = true;
            }
            Log.d("MyFirebaseMsgService", "Message details - From: " + str9 + ", To: " + str10 + ", Subject: " + str11 + ", Type: " + str6 + ", ID: " + str5 + ", TeamID: " + str16 + ", IsTeam: " + z4);
            String strH = c.h(this);
            if (strH == null || strH.isEmpty()) {
                Log.w("MyFirebaseMsgService", "Could not determine my callsign - showing notification anyway");
            } else {
                Log.d("MyFirebaseMsgService", "My callsign: ".concat(strH));
                if (!z4) {
                    if (str10 != null && str10.equalsIgnoreCase(strH.trim())) {
                        if (str9 != null && str9.equalsIgnoreCase(strH.trim())) {
                            Log.d("MyFirebaseMsgService", "Direct message is from me - skipping notification");
                            return;
                        }
                        Log.d("MyFirebaseMsgService", "Direct message addressed to me - showing notification");
                    }
                    Log.d("MyFirebaseMsgService", "Direct message not addressed to me - skipping notification");
                    return;
                }
                if (str9 != null && str9.equalsIgnoreCase(strH.trim())) {
                    Log.d("MyFirebaseMsgService", "Team message is from me - skipping notification");
                    return;
                }
                Log.d("MyFirebaseMsgService", "Team message from " + str9 + " - showing notification");
            }
            if (str13 == null || str13.isEmpty()) {
                C0573b c0573b = this.f5825j;
                c0573b.o(c0573b.f7295c + 1);
                Log.d("MyFirebaseMsgService", "Badge incremented (no server count provided)");
            } else {
                try {
                    int i7 = Integer.parseInt(str13);
                    this.f5825j.o(i7);
                    Log.d("MyFirebaseMsgService", "Badge updated from server data: " + i7);
                } catch (NumberFormatException unused) {
                    Log.w("MyFirebaseMsgService", "Invalid unread count from server: ".concat(str13));
                    C0573b c0573b2 = this.f5825j;
                    c0573b2.o(c0573b2.f7295c + 1);
                }
            }
            if (z4) {
                String str18 = (str == null || str.isEmpty()) ? str16 : str;
                if (str7 == null || str7.isEmpty()) {
                    str2 = str15;
                    if ("true".equals(str2)) {
                        str4 = "🔐 Secure Team Message";
                    } else {
                        str4 = "👥 " + str18;
                    }
                } else {
                    str2 = str15;
                    str4 = str7;
                }
                if (str12 != null && !str12.isEmpty()) {
                    string = str12;
                } else if ("true".equals(str2)) {
                    string = "From: " + str9 + " in " + str18;
                } else {
                    String string2 = (str11 == null || str11.isEmpty()) ? str12 : str11;
                    if (string2 == null || string2.length() <= 100) {
                        i5 = 0;
                    } else {
                        StringBuilder sb = new StringBuilder();
                        i5 = 0;
                        sb.append(string2.substring(0, 100));
                        sb.append("...");
                        string2 = sb.toString();
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str9);
                    sb2.append(": ");
                    if (string2 == null) {
                        string2 = "New team message";
                    }
                    sb2.append(string2);
                    string = sb2.toString();
                    str12 = string;
                }
                i5 = 0;
                str12 = string;
            } else {
                str2 = str15;
                i5 = 0;
                if (str7 != null && !str7.isEmpty()) {
                    str3 = str7;
                } else if ("true".equals(str2)) {
                    str3 = "🔐 Secure Message from " + str9;
                } else {
                    str3 = "📻 " + str9;
                }
                if (str12 == null || str12.isEmpty()) {
                    if ("true".equals(str2)) {
                        str12 = "Secure message received";
                    } else {
                        if (str11 != null && !str11.isEmpty()) {
                            str12 = str11;
                        }
                        if (str12 == null) {
                            str12 = "You have a new message";
                        }
                    }
                }
                str4 = str3;
            }
            if (str5 == null || str5.isEmpty()) {
                i6 = i5;
            } else {
                try {
                    i6 = Integer.parseInt(str5);
                } catch (NumberFormatException unused2) {
                    Log.w("MyFirebaseMsgService", "Invalid message ID: ".concat(str5));
                }
            }
            k(str4, str12, i6, str14, str2, z4, str16, str, str9);
            E0.f(this);
            j(i6, str9, str11, z4, str16);
            i();
            Log.d("MyFirebaseMsgService", "Data message handled successfully with message ID: " + i6 + ", isTeam: " + z4);
        } catch (Exception e5) {
            Log.e("MyFirebaseMsgService", "Error handling data message", e5);
            C0573b c0573b3 = this.f5825j;
            c0573b3.o(c0573b3.f7295c + 1);
            k("New Message", "You have a new message", 0, null, null, false, null, null, null);
            E0.f(this);
            i();
        }
    }

    public final boolean h(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                SharedPreferences sharedPreferences = getSharedPreferences("processed_messages", 0);
                String strConcat = "msg_".concat(str);
                long j5 = sharedPreferences.getLong(strConcat, 0L);
                if (j5 > 0 && System.currentTimeMillis() - j5 < 300000) {
                    Log.d("MyFirebaseMsgService", "Duplicate message detected: ".concat(str));
                    return true;
                }
                sharedPreferences.edit().putLong(strConcat, System.currentTimeMillis()).apply();
                f(sharedPreferences);
                return false;
            } catch (Exception e5) {
                Log.e("MyFirebaseMsgService", "Error checking duplicate message", e5);
            }
        }
        return false;
    }

    public final void i() {
        try {
            Intent intent = new Intent("UPDATE_MESSAGE_BADGE");
            intent.putExtra("unread_count", this.f5825j.f7295c);
            sendBroadcast(intent);
            Log.d("MyFirebaseMsgService", "Badge update broadcast sent: " + this.f5825j.f7295c);
        } catch (Exception e5) {
            Log.e("MyFirebaseMsgService", "Error sending badge update broadcast", e5);
        }
    }

    public final void j(int i5, String str, String str2, boolean z4, String str3) {
        try {
            Intent intent = new Intent("NEW_MESSAGE_RECEIVED");
            intent.putExtra("message_id", i5);
            intent.putExtra("from_callsign", str);
            intent.putExtra("subject", str2);
            intent.putExtra("unread_count", this.f5825j.f7295c);
            intent.putExtra("is_team_message", z4);
            intent.putExtra("team_id", str3);
            sendBroadcast(intent);
            Log.d("MyFirebaseMsgService", "New message broadcast sent - isTeam: " + z4 + ", teamId: " + str3);
        } catch (Exception e5) {
            Log.e("MyFirebaseMsgService", "Error sending new message broadcast", e5);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(java.lang.String r20, java.lang.String r21, int r22, java.lang.String r23, java.lang.String r24, boolean r25, java.lang.String r26, java.lang.String r27, java.lang.String r28) {
        /*
            Method dump skipped, instructions count: 478
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unified.ur1.inbox.MyFirebaseMessagingService.k(java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, boolean, java.lang.String, java.lang.String, java.lang.String):void");
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        Log.d("MyFirebaseMsgService", "Firebase Messaging Service created");
        this.f5825j = C0573b.g(this);
        this.f5826k = getSharedPreferences("user_prefs", 0);
        try {
            Log.d("MyFirebaseMsgService", "Creating notification channels");
            NotificationManager notificationManager = (NotificationManager) getSystemService(NotificationManager.class);
            if (notificationManager != null) {
                try {
                    notificationManager.deleteNotificationChannel("MESSAGE_NOTIFICATIONS");
                    Log.d("MyFirebaseMsgService", "Deleted FCM's expected MESSAGE_NOTIFICATIONS channel");
                } catch (Exception e5) {
                    Log.w("MyFirebaseMsgService", "Error deleting FCM channel: " + e5.getMessage());
                }
                NotificationChannel notificationChannel = new NotificationChannel("CUSTOM_MESSAGE_NOTIFICATIONS", "Direct Messages", 4);
                notificationChannel.setDescription("Notifications for direct messages");
                notificationChannel.enableVibration(true);
                notificationChannel.setVibrationPattern(new long[]{0, 250, 250, 250});
                notificationChannel.setShowBadge(true);
                notificationChannel.setLightColor(-16711936);
                notificationChannel.enableLights(true);
                notificationChannel.setSound(null, null);
                notificationManager.createNotificationChannel(notificationChannel);
                Log.d("MyFirebaseMsgService", "Direct messages channel created");
                NotificationChannel notificationChannel2 = new NotificationChannel("TEAM_MESSAGE_NOTIFICATIONS", "Team Messages", 4);
                notificationChannel2.setDescription("Notifications for team messages");
                notificationChannel2.enableVibration(true);
                notificationChannel2.setVibrationPattern(new long[]{0, 250, 250, 250});
                notificationChannel2.setShowBadge(true);
                notificationChannel2.setLightColor(-16776961);
                notificationChannel2.enableLights(true);
                notificationChannel2.setSound(null, null);
                notificationManager.createNotificationChannel(notificationChannel2);
                Log.d("MyFirebaseMsgService", "Team messages channel created");
                NotificationChannel notificationChannel3 = new NotificationChannel("SECURE_MESSAGE_NOTIFICATIONS", "Secure Messages", 5);
                notificationChannel3.setDescription("Notifications for high-sensitivity secure messages");
                notificationChannel3.enableVibration(true);
                notificationChannel3.setVibrationPattern(new long[]{0, 500, 200, 500});
                notificationChannel3.setShowBadge(true);
                notificationChannel3.setLightColor(-65536);
                notificationChannel3.enableLights(true);
                notificationChannel3.setSound(null, null);
                notificationManager.createNotificationChannel(notificationChannel3);
                Log.d("MyFirebaseMsgService", "Secure messages channel created");
            }
        } catch (Exception e6) {
            Log.e("MyFirebaseMsgService", "Error creating notification channel", e6);
        }
    }

    @Override // X2.g, android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        Log.d("MyFirebaseMsgService", "Firebase Messaging Service destroyed");
    }
}
