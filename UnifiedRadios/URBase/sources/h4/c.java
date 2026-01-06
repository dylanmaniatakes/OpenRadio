package h4;

import F2.t;
import J1.D;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.media.AudioAttributes;
import android.net.Uri;
import android.util.Log;
import com.unified.ur1.R;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import u3.C0914e;
import u3.C0917h;

/* loaded from: classes.dex */
public abstract class c implements S.k {
    public static long A(Context context) {
        return C(context).getLong("rx_frequency", 440000000L);
    }

    public static void A0(Context context, boolean z4) {
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("AppSettings", 0).edit();
            editorEdit.putBoolean("unified_messaging_enabled", z4);
            editorEdit.apply();
            Log.d("SharedSettings", "Unified messaging enabled set to: " + z4);
        } catch (Exception e5) {
            Log.e("SharedSettings", "Error setting unified messaging enabled", e5);
        }
    }

    public static int B(Context context) {
        return C(context).getInt("rx_subcode", 0);
    }

    public static SharedPreferences C(Context context) {
        return context.getApplicationContext().getSharedPreferences("AppSettings", 0);
    }

    public static int D(Context context) {
        return C(context).getInt("tx_contact", 91);
    }

    public static long E(Context context) {
        return C(context).getLong("tx_frequency", 440000000L);
    }

    public static int F(Context context) {
        return C(context).getInt("tx_subcode", 0);
    }

    public static boolean G(Context context) {
        try {
            return context.getSharedPreferences("AppSettings", 0).getBoolean("unified_messaging_enabled", true);
        } catch (Exception e5) {
            Log.e("SharedSettings", "Error getting unified messaging enabled", e5);
            return true;
        }
    }

    public static final boolean H(char c2) {
        return Character.isWhitespace(c2) || Character.isSpaceChar(c2);
    }

    public static Q0.i I(Context context) {
        Q0.i iVar = new Q0.i(new R0.d(new L0.c(context.getApplicationContext())), new L0.e(new D(15)));
        Q0.c cVar = iVar.f2155i;
        if (cVar != null) {
            cVar.b();
        }
        for (Q0.g gVar : iVar.h) {
            if (gVar != null) {
                gVar.n = true;
                gVar.interrupt();
            }
        }
        Q0.c cVar2 = new Q0.c(iVar.f2151c, iVar.f2152d, iVar.f2153e, iVar.g);
        iVar.f2155i = cVar2;
        cVar2.start();
        for (int i5 = 0; i5 < iVar.h.length; i5++) {
            Q0.g gVar2 = new Q0.g(iVar.f2152d, iVar.f2154f, iVar.f2153e, iVar.g);
            iVar.h[i5] = gVar2;
            gVar2.start();
        }
        return iVar;
    }

    public static void J(Context context, int i5) {
        com.unified.ur1.SatelliteTracker.h.m(i5, context, "aprstx");
    }

    public static void K(Context context, boolean z4) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("app_settings", 0).edit();
        editorEdit.putBoolean("CJ_26_enabled", z4);
        editorEdit.apply();
    }

    public static void L(Context context, String str) {
        C(context).edit().putString("callsign", str).apply();
    }

    public static void M(Context context, int i5) {
        com.unified.ur1.SatelliteTracker.h.m(i5, context, "channel_mode");
    }

    public static void N(Context context, int i5) {
        com.unified.ur1.SatelliteTracker.h.m(i5, context, "color_code");
    }

    public static void O(Context context, String str) {
        C(context).edit().putString("connected_sound_mode", str).apply();
        Log.d("SharedSettings", "Connected sound mode set to: " + str);
    }

    public static void P(Context context, String str) {
        C(context).edit().putString("connected_sound_path", str).apply();
        Log.d("SharedSettings", "Connected sound path set to: " + str);
    }

    public static void Q(Context context, String str) {
        C(context).edit().putString("dmr_hostname", str).apply();
    }

    public static void R(Context context, String str) {
        C(context).edit().putString("dmr_ptt_sound_mode", str).apply();
        Log.d("SharedSettings", "DMR PTT sound mode set to: " + str);
    }

    public static void S(Context context, String str) {
        C(context).edit().putString("dmr_ptt_sound_path", str).apply();
        Log.d("SharedSettings", "DMR PTT sound path set to: " + str);
    }

    public static void T(Context context, String str) {
        C(context).edit().putString("dmr_password", str).apply();
    }

    public static void U(Context context, int i5) {
        com.unified.ur1.SatelliteTracker.h.m(i5, context, "dmr_talkgroup");
    }

    public static void V(Context context, String str) {
        C(context).edit().putString("txinhibit", str).apply();
    }

    public static void W(Context context, String str) {
        C(context).edit().putString("dmr_network", str).apply();
    }

    public static void X(Context context, String str) {
        C(context).edit().putString("fm_ptt_sound_mode", str).apply();
        Log.d("SharedSettings", "FM PTT sound mode set to: " + str);
    }

    public static void Y(Context context, String str) {
        C(context).edit().putString("fm_ptt_sound_path", str).apply();
        Log.d("SharedSettings", "FM PTT sound path set to: " + str);
    }

    public static void Z(Context context, int i5) {
        com.unified.ur1.SatelliteTracker.h.m(i5, context, "inbound_slot");
    }

    public static C0917h a(C0917h c0917h) {
        C0914e c0914e = c0917h.f9964j;
        c0914e.b();
        return c0914e.f9955q > 0 ? c0917h : C0917h.f9963k;
    }

    public static void a0(Context context, String str) {
        C(context).edit().putString("channel_freq", str).apply();
    }

    public static void b(int i5) {
        if (new J3.c(2, 36, 1).a(i5)) {
            return;
        }
        StringBuilder sbF = com.unified.ur1.SatelliteTracker.h.f("radix ", i5, " was not in valid range ");
        sbF.append(new J3.c(2, 36, 1));
        throw new IllegalArgumentException(sbF.toString());
    }

    public static void b0(Context context, String str) {
        C(context).edit().putString("channel_name", str).apply();
    }

    public static String c(Context context, Uri uri, String str) throws IOException {
        try {
            Log.d("SharedSettings", "Copying audio file for sound type: ".concat(str));
            Log.d("SharedSettings", "Source URI: " + uri);
            File externalFilesDir = context.getExternalFilesDir("sounds");
            if (externalFilesDir == null) {
                Log.e("SharedSettings", "External files directory not available, using internal");
                externalFilesDir = new File(context.getFilesDir(), "sounds");
            }
            if (!externalFilesDir.exists()) {
                Log.d("SharedSettings", "Created sounds directory: " + externalFilesDir.mkdirs());
            }
            File file = new File(externalFilesDir, str.replace("_", "_") + "_sound.mp3");
            StringBuilder sb = new StringBuilder("Destination file: ");
            sb.append(file.getAbsolutePath());
            Log.d("SharedSettings", sb.toString());
            try {
                InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    try {
                        if (inputStreamOpenInputStream == null) {
                            Log.e("SharedSettings", "Could not open input stream for URI: " + uri);
                            fileOutputStream.close();
                            if (inputStreamOpenInputStream != null) {
                                inputStreamOpenInputStream.close();
                            }
                            return null;
                        }
                        byte[] bArr = new byte[8192];
                        long j5 = 0;
                        while (true) {
                            int i5 = inputStreamOpenInputStream.read(bArr);
                            if (i5 == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, i5);
                            j5 += i5;
                        }
                        fileOutputStream.flush();
                        Log.d("SharedSettings", "Audio file copied successfully, size: " + j5 + " bytes");
                        if (!file.exists() || !file.canRead()) {
                            Log.e("SharedSettings", "Destination file is not accessible");
                            fileOutputStream.close();
                            inputStreamOpenInputStream.close();
                            return null;
                        }
                        String absolutePath = file.getAbsolutePath();
                        Log.d("SharedSettings", "Audio file copied to: " + absolutePath);
                        try {
                            new FileInputStream(file).close();
                            Log.d("SharedSettings", "File is readable - SUCCESS");
                        } catch (Exception e5) {
                            Log.e("SharedSettings", "File is not readable: " + e5.getMessage());
                        }
                        fileOutputStream.close();
                        inputStreamOpenInputStream.close();
                        return absolutePath;
                    } finally {
                    }
                } finally {
                }
            } catch (Exception e6) {
                Log.e("SharedSettings", "Error copying audio file: " + e6.getMessage(), e6);
                return null;
            }
        } catch (Exception e7) {
            Log.e("SharedSettings", "Error in copyAudioFileToInternal: " + e7.getMessage(), e7);
            return null;
        }
    }

    public static void c0(Context context, int i5) {
        com.unified.ur1.SatelliteTracker.h.m(i5, context, "local_id");
    }

    public static androidx.emoji2.text.o d(Context context) {
        ProviderInfo providerInfo;
        t tVar;
        ApplicationInfo applicationInfo;
        PackageManager packageManager = context.getPackageManager();
        f.c(packageManager, "Package manager required to locate emoji font provider");
        Iterator<ResolveInfo> it = packageManager.queryIntentContentProviders(new Intent("androidx.content.action.LOAD_EMOJI_FONT"), 0).iterator();
        while (true) {
            if (!it.hasNext()) {
                providerInfo = null;
                break;
            }
            providerInfo = it.next().providerInfo;
            if (providerInfo != null && (applicationInfo = providerInfo.applicationInfo) != null && (applicationInfo.flags & 1) == 1) {
                break;
            }
        }
        if (providerInfo == null) {
            tVar = null;
        } else {
            try {
                String str = providerInfo.authority;
                String str2 = providerInfo.packageName;
                Signature[] signatureArr = packageManager.getPackageInfo(str2, 64).signatures;
                ArrayList arrayList = new ArrayList();
                for (Signature signature : signatureArr) {
                    arrayList.add(signature.toByteArray());
                }
                tVar = new t(str, str2, "emojicompat-emoji-font", Collections.singletonList(arrayList));
            } catch (PackageManager.NameNotFoundException e5) {
                Log.wtf("emoji2.text.DefaultEmojiConfig", e5);
            }
        }
        if (tVar == null) {
            return null;
        }
        return new androidx.emoji2.text.o(new androidx.emoji2.text.n(context, tVar));
    }

    public static void d0(Context context, String str) {
        C(context).edit().putString("marscap", str).apply();
    }

    public static void e(Context context, NotificationManager notificationManager, String str) {
        try {
            NotificationChannel notificationChannel = new NotificationChannel("MESSAGE_NOTIFICATIONS", "Message Notifications", 4);
            notificationChannel.setDescription("Notifications for new messages");
            notificationChannel.enableVibration(true);
            notificationChannel.setVibrationPattern(new long[]{0, 250, 250, 250});
            notificationChannel.setShowBadge(true);
            try {
                notificationChannel.setLightColor(context.getColor(R.color.primary));
            } catch (Exception unused) {
                notificationChannel.setLightColor(-16776961);
            }
            notificationChannel.enableLights(true);
            Uri uriT = t(context, str);
            if (uriT != null) {
                notificationChannel.setSound(uriT, new AudioAttributes.Builder().setContentType(4).setUsage(5).build());
                Log.d("SharedSettings", "Main channel created with sound: " + uriT);
            } else {
                notificationChannel.setSound(null, null);
                Log.d("SharedSettings", "Main channel created with no sound");
            }
            notificationManager.createNotificationChannel(notificationChannel);
            NotificationChannel notificationChannel2 = new NotificationChannel("MESSAGE_NOTIFICATIONS_SILENT", "Silent Message Notifications", 4);
            notificationChannel2.setDescription("Silent notifications for new messages");
            notificationChannel2.enableVibration(false);
            notificationChannel2.setShowBadge(true);
            try {
                notificationChannel2.setLightColor(context.getColor(R.color.primary));
            } catch (Exception unused2) {
                notificationChannel2.setLightColor(-16776961);
            }
            notificationChannel2.enableLights(true);
            notificationChannel2.setSound(null, null);
            notificationManager.createNotificationChannel(notificationChannel2);
            Log.d("SharedSettings", "Notification channels created successfully");
        } catch (Exception e5) {
            Log.e("SharedSettings", "Error creating notification channels", e5);
        }
    }

    public static void e0(Context context, int i5) {
        com.unified.ur1.SatelliteTracker.h.m(i5, context, "metricEnable");
    }

    public static final boolean f(char c2, char c5, boolean z4) {
        if (c2 == c5) {
            return true;
        }
        if (!z4) {
            return false;
        }
        char upperCase = Character.toUpperCase(c2);
        char upperCase2 = Character.toUpperCase(c5);
        return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
    }

    public static void f0(Context context, boolean z4) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("app_settings", 0).edit();
        editorEdit.putBoolean("multi_rx_enabled", z4);
        editorEdit.apply();
    }

    public static String[] g() {
        return new String[]{"none", "default", "custom"};
    }

    public static void g0(Context context, ArrayList arrayList) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("app_settings", 0).edit();
        StringBuilder sb = new StringBuilder();
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            if (i5 > 0) {
                sb.append(",");
            }
            sb.append(arrayList.get(i5));
        }
        editorEdit.putString("multi_rx_talkgroups", sb.toString());
        editorEdit.apply();
    }

    public static String h(Context context) {
        return C(context).getString("callsign", "");
    }

    public static void h0(Context context, boolean z4) {
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("AppSettings", 0).edit();
            editorEdit.putBoolean("new_message_sound_enabled", z4);
            editorEdit.apply();
            Log.d("SharedSettings", "New message sound enabled set to: " + z4);
        } catch (Exception e5) {
            Log.e("SharedSettings", "Error setting new message sound enabled", e5);
        }
    }

    public static String i(Context context) {
        return C(context).getString("connected_sound_mode", "default");
    }

    public static void i0(Context context, String str) {
        C(context).edit().putString("notification_sound_mode", str).apply();
        Log.d("SharedSettings", "Notification sound mode set to: " + str);
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (notificationManager != null) {
                notificationManager.deleteNotificationChannel("MESSAGE_NOTIFICATIONS");
                notificationManager.deleteNotificationChannel("MESSAGE_NOTIFICATIONS_SILENT");
                String strS = s(context);
                e(context, notificationManager, strS);
                Log.d("SharedSettings", "Notification channels updated for sound mode: " + strS);
            }
        } catch (Exception e5) {
            Log.e("SharedSettings", "Error updating notification channels", e5);
        }
    }

    public static String j(Context context) {
        return C(context).getString("dmr_hostname", "");
    }

    public static void j0(Context context, String str) {
        C(context).edit().putString("notification_sound_path", str).apply();
        Log.d("SharedSettings", "Notification sound path set to: " + str);
    }

    public static String k(Context context) {
        return C(context).getString("dmr_ptt_sound_mode", "default");
    }

    public static void k0(Context context, int i5) {
        com.unified.ur1.SatelliteTracker.h.m(i5, context, "outbound_slot");
    }

    public static int l(Context context) {
        return C(context).getInt("dmr_talkgroup", 91);
    }

    public static void l0(Context context, boolean z4) {
        C(context).edit().putBoolean("ptt_sound_enabled", z4).apply();
        Log.d("SharedSettings", "PTT sound enabled set to: " + z4);
    }

    public static String m(Context context) {
        return C(context).getString("disconnect_sound_mode", "default");
    }

    public static void m0(Context context, int i5) {
        com.unified.ur1.SatelliteTracker.h.m(i5, context, "power");
    }

    public static Integer n(Context context) {
        return Integer.valueOf(C(context).getInt("dmr_rptid", 0));
    }

    public static void n0(Context context, String str) {
        C(context).edit().putString("roip_ptt_sound_mode", str).apply();
        Log.d("SharedSettings", "ROIP PTT sound mode set to: " + str);
    }

    public static String o(Context context) {
        return C(context).getString("fm_ptt_sound_mode", "default");
    }

    public static void o0(Context context, String str) {
        C(context).edit().putString("roip_ptt_sound_path", str).apply();
        Log.d("SharedSettings", "ROIP PTT sound path set to: " + str);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    public static final Class p(K3.b bVar) {
        F3.i.f(bVar, "<this>");
        Class clsA = ((F3.d) bVar).a();
        if (!clsA.isPrimitive()) {
            return clsA;
        }
        String name = clsA.getName();
        switch (name.hashCode()) {
            case -1325958191:
                if (!name.equals("double")) {
                }
                break;
            case 104431:
                if (!name.equals("int")) {
                }
                break;
            case 3039496:
                if (!name.equals("byte")) {
                }
                break;
            case 3052374:
                if (!name.equals("char")) {
                }
                break;
            case 3327612:
                if (!name.equals("long")) {
                }
                break;
            case 3625364:
                if (!name.equals("void")) {
                }
                break;
            case 64711720:
                if (!name.equals("boolean")) {
                }
                break;
            case 97526364:
                if (!name.equals("float")) {
                }
                break;
            case 109413500:
                if (!name.equals("short")) {
                }
                break;
        }
        return clsA;
    }

    public static void p0(Context context, String str) {
        C(context).edit().putString("radio_mode", str).apply();
    }

    public static int q(Context context) {
        return C(context).getInt("local_id", 888);
    }

    public static void q0(Context context, int i5) {
        com.unified.ur1.SatelliteTracker.h.m(i5, context, "roip_connection");
    }

    public static ArrayList r(Context context) {
        String string = context.getSharedPreferences("app_settings", 0).getString("multi_rx_talkgroups", "");
        ArrayList arrayList = new ArrayList();
        if (!string.isEmpty()) {
            for (String str : string.split(",")) {
                try {
                    arrayList.add(Integer.valueOf(Integer.parseInt(str.trim())));
                } catch (NumberFormatException unused) {
                    Log.e("SharedSettings", "Invalid talkgroup number: " + str);
                }
            }
        }
        return arrayList;
    }

    public static void r0(Context context, String str) {
        C(context).edit().putString("roip_network", str).apply();
    }

    public static String s(Context context) {
        return C(context).getString("notification_sound_mode", "default");
    }

    public static void s0(Context context, String str) {
        C(context).edit().putString("roip_server", str).apply();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.net.Uri t(android.content.Context r7, java.lang.String r8) {
        /*
            java.lang.String r0 = "SharedSettings"
            java.lang.String r1 = "/raw/mail"
            java.lang.String r2 = "android.resource://"
            int r3 = r8.hashCode()     // Catch: java.lang.Exception -> L26
            r4 = -1349088399(0xffffffffaf968b71, float:-2.738392E-10)
            r5 = 2
            r6 = 1
            if (r3 == r4) goto L33
            r4 = 3387192(0x33af38, float:4.746467E-39)
            if (r3 == r4) goto L29
            r4 = 1544803905(0x5c13d641, float:1.6644958E17)
            if (r3 == r4) goto L1c
            goto L3d
        L1c:
            java.lang.String r3 = "default"
            boolean r8 = r8.equals(r3)     // Catch: java.lang.Exception -> L26
            if (r8 == 0) goto L3d
            r8 = r6
            goto L3e
        L26:
            r8 = move-exception
            goto Lb4
        L29:
            java.lang.String r3 = "none"
            boolean r8 = r8.equals(r3)     // Catch: java.lang.Exception -> L26
            if (r8 == 0) goto L3d
            r8 = 0
            goto L3e
        L33:
            java.lang.String r3 = "custom"
            boolean r8 = r8.equals(r3)     // Catch: java.lang.Exception -> L26
            if (r8 == 0) goto L3d
            r8 = r5
            goto L3e
        L3d:
            r8 = -1
        L3e:
            r3 = 0
            if (r8 == 0) goto Lb3
            if (r8 == r6) goto L9b
            if (r8 == r5) goto L5d
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L26
            r8.<init>(r2)     // Catch: java.lang.Exception -> L26
            java.lang.String r3 = r7.getPackageName()     // Catch: java.lang.Exception -> L26
            r8.append(r3)     // Catch: java.lang.Exception -> L26
            r8.append(r1)     // Catch: java.lang.Exception -> L26
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Exception -> L26
            android.net.Uri r7 = android.net.Uri.parse(r8)     // Catch: java.lang.Exception -> L26
            return r7
        L5d:
            android.content.SharedPreferences r8 = C(r7)     // Catch: java.lang.Exception -> L26
            java.lang.String r4 = "notification_sound_path"
            java.lang.String r8 = r8.getString(r4, r3)     // Catch: java.lang.Exception -> L26
            if (r8 == 0) goto L7e
            java.io.File r3 = new java.io.File     // Catch: java.lang.Exception -> L26
            r3.<init>(r8)     // Catch: java.lang.Exception -> L26
            boolean r3 = r3.exists()     // Catch: java.lang.Exception -> L26
            if (r3 == 0) goto L7e
            java.io.File r3 = new java.io.File     // Catch: java.lang.Exception -> L26
            r3.<init>(r8)     // Catch: java.lang.Exception -> L26
            android.net.Uri r7 = android.net.Uri.fromFile(r3)     // Catch: java.lang.Exception -> L26
            return r7
        L7e:
            java.lang.String r8 = "Custom notification sound file not found, using default"
            android.util.Log.w(r0, r8)     // Catch: java.lang.Exception -> L26
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L26
            r8.<init>(r2)     // Catch: java.lang.Exception -> L26
            java.lang.String r3 = r7.getPackageName()     // Catch: java.lang.Exception -> L26
            r8.append(r3)     // Catch: java.lang.Exception -> L26
            r8.append(r1)     // Catch: java.lang.Exception -> L26
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Exception -> L26
            android.net.Uri r7 = android.net.Uri.parse(r8)     // Catch: java.lang.Exception -> L26
            return r7
        L9b:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L26
            r8.<init>(r2)     // Catch: java.lang.Exception -> L26
            java.lang.String r3 = r7.getPackageName()     // Catch: java.lang.Exception -> L26
            r8.append(r3)     // Catch: java.lang.Exception -> L26
            r8.append(r1)     // Catch: java.lang.Exception -> L26
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Exception -> L26
            android.net.Uri r7 = android.net.Uri.parse(r8)     // Catch: java.lang.Exception -> L26
            return r7
        Lb3:
            return r3
        Lb4:
            java.lang.String r3 = "Error getting notification sound URI"
            java.lang.StringBuilder r8 = com.unified.ur1.SatelliteTracker.h.g(r0, r3, r8, r2)
            java.lang.String r7 = r7.getPackageName()
            r8.append(r7)
            r8.append(r1)
            java.lang.String r7 = r8.toString()
            android.net.Uri r7 = android.net.Uri.parse(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: h4.c.t(android.content.Context, java.lang.String):android.net.Uri");
    }

    public static void t0(Context context, long j5) {
        C(context).edit().putLong("rx_frequency", j5).apply();
    }

    public static boolean u(Context context) {
        return C(context).getBoolean("ptt_sound_enabled", true);
    }

    public static void u0(Context context, int i5) {
        com.unified.ur1.SatelliteTracker.h.m(i5, context, "rx_subcode");
    }

    public static int v(Context context) {
        return C(context).getInt("power", 1);
    }

    public static void v0(Context context, int i5) {
        com.unified.ur1.SatelliteTracker.h.m(i5, context, "rx_type");
    }

    public static final int w(int i5, int i6, int i7) {
        if (i7 > 0) {
            if (i5 >= i6) {
                return i6;
            }
            int i8 = i6 % i7;
            if (i8 < 0) {
                i8 += i7;
            }
            int i9 = i5 % i7;
            if (i9 < 0) {
                i9 += i7;
            }
            int i10 = (i8 - i9) % i7;
            if (i10 < 0) {
                i10 += i7;
            }
            return i6 - i10;
        }
        if (i7 >= 0) {
            throw new IllegalArgumentException("Step is zero.");
        }
        if (i5 <= i6) {
            return i6;
        }
        int i11 = -i7;
        int i12 = i5 % i11;
        if (i12 < 0) {
            i12 += i11;
        }
        int i13 = i6 % i11;
        if (i13 < 0) {
            i13 += i11;
        }
        int i14 = (i12 - i13) % i11;
        if (i14 < 0) {
            i14 += i11;
        }
        return i6 + i14;
    }

    public static void w0(Context context, int i5) {
        com.unified.ur1.SatelliteTracker.h.m(i5, context, "tx_contact");
    }

    public static String x(Context context) {
        return C(context).getString("roip_ptt_sound_mode", "default");
    }

    public static void x0(Context context, long j5) {
        C(context).edit().putLong("tx_frequency", j5).apply();
    }

    public static String y(Context context) {
        return C(context).getString("roip_network", "");
    }

    public static void y0(Context context, int i5) {
        com.unified.ur1.SatelliteTracker.h.m(i5, context, "tx_subcode");
    }

    public static String z(Context context) {
        return C(context).getString("roip_server", "");
    }

    public static void z0(Context context, int i5) {
        com.unified.ur1.SatelliteTracker.h.m(i5, context, "tx_type");
    }
}
