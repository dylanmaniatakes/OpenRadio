package com.unified.ur1.adapters;

import B0.a;
import D.m;
import L0.s;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Spinner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.unified.ur1.R;
import com.unified.ur1.SatelliteTracker.h;
import com.unified.ur1.primary.LaunchActivity;
import com.unified.ur1.rfmodule.ROIP.DMRBridge;
import f.AbstractActivityC0472i;
import f.C0467d;
import f3.C0494E;
import f3.C0495F;
import f3.C0524o;
import f3.C0532x;
import f3.DialogInterfaceOnCancelListenerC0533y;
import f3.DialogInterfaceOnClickListenerC0516g;
import f3.DialogInterfaceOnClickListenerC0517h;
import f3.InterfaceC0500K;
import f3.RunnableC0491B;
import f3.RunnableC0492C;
import f3.RunnableC0493D;
import g0.AbstractC0535a;
import h4.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import m3.C0774j;
import org.json.JSONException;
import org.json.JSONObject;
import y1.f;

/* loaded from: classes.dex */
public class MemoryChannelActivity extends AbstractActivityC0472i implements InterfaceC0500K {

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f5681l = 0;

    /* renamed from: c, reason: collision with root package name */
    public RecyclerView f5682c;

    /* renamed from: d, reason: collision with root package name */
    public Spinner f5683d;
    public C0524o g;

    /* renamed from: e, reason: collision with root package name */
    public final ExecutorService f5684e = Executors.newSingleThreadExecutor();

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f5685f = new ArrayList();
    public String h = "";

    /* renamed from: i, reason: collision with root package name */
    public boolean f5686i = false;

    /* renamed from: j, reason: collision with root package name */
    public final HashSet f5687j = new HashSet();

    /* renamed from: k, reason: collision with root package name */
    public final HashMap f5688k = new HashMap();

    public static String k(String str, JSONObject jSONObject) {
        try {
            return (!jSONObject.has(str) || jSONObject.isNull(str)) ? "" : jSONObject.getString(str);
        } catch (JSONException e5) {
            Log.e("Unified - MemoryChannel", "Error getting string for key: ".concat(str), e5);
            return "";
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x03f8  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0408  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x040b  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0515  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x068e  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x06c7  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x070f  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x07ca  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0804  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x082d  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x03a0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0324 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0390  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j(java.lang.String r60) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 2420
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unified.ur1.adapters.MemoryChannelActivity.j(java.lang.String):void");
    }

    public final void l(C0532x c0532x) {
        List list;
        StringBuilder sbH = h.h("Unified - MemoryChannel", "=== onChannelClick START ===", "Channel clicked: ");
        sbH.append(c0532x.f6828a);
        Log.d("Unified - MemoryChannel", sbH.toString());
        Log.d("Unified - MemoryChannel", "Channel Details:");
        StringBuilder sb = new StringBuilder("  Name: ");
        String str = c0532x.f6828a;
        StringBuilder sbI = h.i(h.i(h.i(h.i(h.i(sb, str, "Unified - MemoryChannel", "  Zone: "), c0532x.f6829b, "Unified - MemoryChannel", "  Mode: "), c0532x.f6832e, "Unified - MemoryChannel", "  RX Freq: "), c0532x.f6830c, "Unified - MemoryChannel", "  TX Freq: "), c0532x.f6831d, "Unified - MemoryChannel", "  Power: ");
        sbI.append(c0532x.f6839o);
        Log.d("Unified - MemoryChannel", sbI.toString());
        Log.d("Unified - MemoryChannel", "Tone/Squelch Settings:");
        Log.d("Unified - MemoryChannel", "  TX Tone: " + c0532x.f6833f);
        Log.d("Unified - MemoryChannel", "  RX Tone: " + c0532x.g);
        Log.d("Unified - MemoryChannel", "  TX DCS: " + c0532x.h);
        Log.d("Unified - MemoryChannel", "  RX DCS: " + c0532x.f6834i);
        Log.d("Unified - MemoryChannel", "DMR Settings:");
        Log.d("Unified - MemoryChannel", "  Color Code: " + c0532x.f6835j);
        Log.d("Unified - MemoryChannel", "  Timeslot: " + c0532x.f6836k);
        Log.d("Unified - MemoryChannel", "  Group Call/Contact: " + c0532x.f6837l);
        StringBuilder sbI2 = h.i(h.i(new StringBuilder("  DMR Network: "), c0532x.f6840p, "Unified - MemoryChannel", "  Contact Description: "), c0532x.f6841q, "Unified - MemoryChannel", "  DMR Contact Type: ");
        sbI2.append(c0532x.f6842r);
        Log.d("Unified - MemoryChannel", sbI2.toString());
        Log.d("Unified - MemoryChannel", "ROIP Settings:");
        StringBuilder sbI3 = h.i(h.i(h.i(h.i(h.i(new StringBuilder("  ROIP Status: "), c0532x.n, "Unified - MemoryChannel", "  ROIP Mode: "), c0532x.f6845u, "Unified - MemoryChannel", "  ROIP Network: "), c0532x.f6846v, "Unified - MemoryChannel", "  ROIP Server: "), c0532x.f6847w, "Unified - MemoryChannel", "  ROIP Server IP: "), c0532x.f6848x, "Unified - MemoryChannel", "  ROIP Port: ");
        sbI3.append(c0532x.f6849y);
        Log.d("Unified - MemoryChannel", sbI3.toString());
        String str2 = c0532x.f6850z;
        String str3 = "NOT SET";
        Log.d("Unified - MemoryChannel", "  ROIP Password: ".concat((str2 == null || str2.isEmpty()) ? "NOT SET" : "***SET***"));
        Log.d("Unified - MemoryChannel", "Multi-RX Settings:");
        Log.d("Unified - MemoryChannel", "  Multi-RX Enabled: " + c0532x.f6825E);
        Log.d("Unified - MemoryChannel", "  Multi-RX Status: ".concat(c0532x.e() ? "ENABLED" : "DISABLED"));
        boolean z4 = false;
        if (!c0532x.e() || (list = c0532x.f6826F) == null || list.isEmpty()) {
            Log.d("Unified - MemoryChannel", "  No Multi-RX contacts configured");
        } else {
            Log.d("Unified - MemoryChannel", "  Multi-RX Contact Count: " + c0532x.b());
            int i5 = 0;
            while (i5 < c0532x.b()) {
                String strA = c0532x.a(i5);
                String strC = c0532x.c(i5);
                StringBuilder sb2 = new StringBuilder("    Contact ");
                i5++;
                sb2.append(i5);
                sb2.append(": ");
                sb2.append(strA);
                h.q(sb2, strC != null ? AbstractC0535a.l(" (", strC, ")") : "", "Unified - MemoryChannel");
            }
        }
        StringBuilder sbI4 = h.i(h.h("Unified - MemoryChannel", "Encryption Settings:", "  Encrypt: "), c0532x.f6843s, "Unified - MemoryChannel", "  Encrypt Key: ");
        String str4 = c0532x.f6844t;
        if (str4 != null && !str4.isEmpty()) {
            str3 = "***SET***";
        }
        sbI4.append(str3);
        Log.d("Unified - MemoryChannel", sbI4.toString());
        Log.d("Unified - MemoryChannel", "Database/Order Info:");
        Log.d("Unified - MemoryChannel", "  Memory ID: " + c0532x.f6822B);
        Log.d("Unified - MemoryChannel", "  Zone Order: " + c0532x.f6823C);
        Log.d("Unified - MemoryChannel", "  Memory Order: " + c0532x.f6824D);
        Log.d("Unified - MemoryChannel", "Channel Type Checks:");
        Log.d("Unified - MemoryChannel", "  Is ROIP Channel: " + c0532x.f());
        Log.d("Unified - MemoryChannel", "  Is DMR Channel: " + c0532x.d());
        StringBuilder sb3 = new StringBuilder("  Is Encrypted: ");
        String str5 = c0532x.f6843s;
        sb3.append(("Off".equals(str5) || str5 == null || str5.isEmpty()) ? false : true);
        Log.d("Unified - MemoryChannel", sb3.toString());
        StringBuilder sb4 = new StringBuilder("  Has BrandMeister API: ");
        String str6 = c0532x.f6821A;
        if (str6 != null && !str6.isEmpty()) {
            z4 = true;
        }
        sb4.append(z4);
        Log.d("Unified - MemoryChannel", sb4.toString());
        Log.d("Unified - MemoryChannel", "  Is Multi-RX Enabled: " + c0532x.e());
        L.h hVar = new L.h(this, R.style.Base_Theme_Material3_Dark_Dialog);
        C0467d c0467d = (C0467d) hVar.f1522d;
        c0467d.f6292d = "Access Channel";
        c0467d.f6294f = AbstractC0535a.l("Do you want to access ", str, "?");
        hVar.e("Yes", new DialogInterfaceOnClickListenerC0517h(this, 2, c0532x));
        hVar.c("No", new DialogInterfaceOnClickListenerC0516g(3));
        c0467d.n = new DialogInterfaceOnCancelListenerC0533y();
        hVar.f();
        Log.d("Unified - MemoryChannel", "=== onChannelClick END - Dialog shown ===");
    }

    public final void m(C0532x c0532x) throws Throwable {
        int i5;
        StringBuilder sbI = h.i(h.h("Unified - MemoryChannel", "=== saveChannelSettings START ===", "Channel: "), c0532x.f6828a, "Unified - MemoryChannel", "Mode: ");
        String str = c0532x.f6832e;
        StringBuilder sbI2 = h.i(sbI, str, "Unified - MemoryChannel", "Is ROIP: ");
        sbI2.append(c0532x.f());
        Log.d("Unified - MemoryChannel", sbI2.toString());
        Log.d("Unified - MemoryChannel", "Multi-RX Enabled: " + c0532x.e());
        DMRBridge dMRBridgeJ = DMRBridge.j(this);
        boolean zE = c0532x.e();
        int i6 = c0532x.f6837l;
        if (zE) {
            Log.d("Unified - MemoryChannel", "Processing Multi-RX channel settings");
            LaunchActivity.f5854E1 = true;
            dMRBridgeJ.setMultiTalkgroupMode(true);
            List list = c0532x.f6826F;
            if (list == null || list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(Integer.valueOf(i6));
                c.g0(this, arrayList);
            } else {
                Log.d("Unified - MemoryChannel", "Storing Multi-RX contacts (" + c0532x.b() + " contacts)");
                int iB = c0532x.b();
                SharedPreferences.Editor editorEdit = getSharedPreferences("app_settings", 0).edit();
                editorEdit.putInt("multi_rx_contact_count", iB);
                editorEdit.apply();
                ArrayList arrayList2 = new ArrayList();
                if (i6 != 0) {
                    arrayList2.add(Integer.valueOf(i6));
                }
                for (int i7 = 0; i7 < c0532x.b(); i7++) {
                    String strA = c0532x.a(i7);
                    String strC = c0532x.c(i7);
                    if (strA != null) {
                        try {
                            int i8 = Integer.parseInt(strA);
                            if (i8 != 0 && !arrayList2.contains(Integer.valueOf(i8))) {
                                arrayList2.add(Integer.valueOf(i8));
                            }
                            SharedPreferences.Editor editorEdit2 = getSharedPreferences("app_settings", 0).edit();
                            editorEdit2.putString("multi_rx_contact_" + i7, strA);
                            editorEdit2.apply();
                            Log.d("Unified - MemoryChannel", "  Multi-RX Contact " + i7 + ": " + strA);
                        } catch (NumberFormatException unused) {
                            Log.e("Unified - MemoryChannel", "Invalid contact number: ".concat(strA));
                        }
                    }
                    if (strC != null) {
                        SharedPreferences.Editor editorEdit3 = getSharedPreferences("app_settings", 0).edit();
                        editorEdit3.putString("multi_rx_contact_desc_" + i7, strC);
                        editorEdit3.apply();
                        Log.d("Unified - MemoryChannel", "  Multi-RX Description " + i7 + ": " + strC);
                    }
                }
                SharedPreferences.Editor editorEdit4 = getSharedPreferences("AppPrefs", 0).edit();
                editorEdit4.putString("saved_talkgroups", arrayList2.toString());
                editorEdit4.apply();
                c.g0(this, arrayList2);
            }
            c.f0(this, true);
            dMRBridgeJ.setMultiTalkgroupMode(true);
        } else {
            LaunchActivity.f5854E1 = false;
            dMRBridgeJ.setMultiTalkgroupMode(false);
            c.f0(this, false);
            SharedPreferences.Editor editorEdit5 = getSharedPreferences("app_settings", 0).edit();
            editorEdit5.putInt("multi_rx_contact_count", 0);
            editorEdit5.apply();
            SharedPreferences.Editor editorEdit6 = getSharedPreferences("app_settings", 0).edit();
            editorEdit6.remove("multi_rx_talkgroups");
            editorEdit6.apply();
        }
        boolean zF = c0532x.f();
        String str2 = c0532x.f6830c;
        if (zF) {
            Log.d("Unified - MemoryChannel", "Processing ROIP channel");
            c.p0(this, "ROIP");
            c.M(this, 2);
            SharedPreferences.Editor editorEdit7 = getApplicationContext().getSharedPreferences("AppSettings", 0).edit();
            String str3 = c0532x.f6845u;
            editorEdit7.putString("roip_mode", str3).apply();
            String str4 = c0532x.f6846v;
            c.r0(this, str4);
            String str5 = c0532x.f6847w;
            c.s0(this, str5);
            String str6 = c0532x.f6848x;
            c.Q(this, str6);
            int i9 = c0532x.f6849y;
            c.C(this).edit().putInt("dmr_port", i9).apply();
            c.T(this, c0532x.f6850z);
            c.W(this, str4);
            String str7 = c0532x.f6841q;
            c.C(this).edit().putString("contact_description", str7).apply();
            String str8 = c0532x.f6842r;
            c.C(this).edit().putString("dmr_contact_type", str8).apply();
            c.U(this, i6);
            c.w0(this, i6);
            String str9 = c0532x.f6821A;
            c.C(this).edit().putString("bm_api_key", str9).apply();
            Log.d("Unified - MemoryChannel", "ROIP Mode: " + str3);
            Log.d("Unified - MemoryChannel", "ROIP Network: " + str4);
            Log.d("Unified - MemoryChannel", "ROIP Server: " + str5);
            Log.d("Unified - MemoryChannel", "ROIP Server IP: " + str6);
            Log.d("Unified - MemoryChannel", "ROIP Port: " + i9);
            Log.d("Unified - MemoryChannel", "ROIP TalkGroup: " + i6);
            Log.d("Unified - MemoryChannel", "Contact Description: " + str7);
            Log.d("Unified - MemoryChannel", "DMR Contact Type: " + str8);
            AbstractC0535a.v("BM API: ", str9, "Unified - MemoryChannel");
            c.t0(this, 0L);
            c.x0(this, 0L);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                Intent intent = new Intent(this, (Class<?>) LaunchActivity.class);
                intent.addFlags(603979776);
                intent.putExtra("ROIP_CONNECT", true);
                if (c0532x.e()) {
                    intent.putExtra("MULTI_RX_ENABLED", true);
                }
                startActivity(intent);
            } else {
                runOnUiThread(new m(this, 21, c0532x));
            }
        } else {
            Log.d("Unified - MemoryChannel", "Processing regular radio channel");
            new Thread(new RunnableC0491B(dMRBridgeJ, 0)).start();
            f.t();
            long j5 = (long) (Double.parseDouble(str2) * 1000000.0d);
            long j6 = (long) (Double.parseDouble(c0532x.f6831d) * 1000000.0d);
            c.t0(this, j5);
            c.x0(this, j6);
            Log.d("Unified - MemoryChannel", "RX Frequency: " + j5);
            Log.d("Unified - MemoryChannel", "TX Frequency: " + j6);
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            h.n(0, map, "None", 1, "67.0");
            h.n(2, map, "69.3", 3, "71.9");
            h.n(4, map, "74.4", 5, "77.0");
            h.n(6, map, "79.7", 7, "82.5");
            h.n(8, map, "85.4", 9, "88.5");
            h.n(10, map, "91.5", 11, "94.8");
            h.n(12, map, "97.4", 13, "100.0");
            h.n(14, map, "103.5", 15, "107.2");
            h.n(16, map, "110.9", 17, "114.8");
            h.n(18, map, "118.8", 19, "123.0");
            h.n(20, map, "127.3", 21, "131.8");
            h.n(22, map, "136.5", 23, "141.3");
            h.n(24, map, "146.2", 25, "151.4");
            h.n(26, map, "156.7", 27, "159.8");
            h.n(28, map, "162.2", 29, "165.5");
            h.n(30, map, "167.9", 31, "171.3");
            h.n(32, map, "173.8", 33, "177.3");
            h.n(34, map, "179.9", 35, "183.5");
            h.n(36, map, "186.2", 37, "189.9");
            h.n(38, map, "192.8", 39, "196.6");
            h.n(40, map, "199.5", 41, "203.5");
            h.n(42, map, "206.5", 43, "210.7");
            h.n(44, map, "218.1", 45, "225.7");
            h.n(46, map, "229.1", 47, "233.6");
            h.n(48, map, "241.8", 49, "250.3");
            map.put("254.1", 50);
            map2.put("None", -1);
            map2.put("023", 0);
            map2.put("025", 1);
            map2.put("026", 2);
            map2.put("031", 3);
            map2.put("032", 4);
            map2.put("043", 5);
            map2.put("047", 6);
            map2.put("051", 7);
            map2.put("054", 8);
            map2.put("065", 9);
            map2.put("071", 10);
            map2.put("072", 11);
            map2.put("073", 12);
            map2.put("074", 13);
            map2.put("114", 14);
            map2.put("115", 15);
            map2.put("116", 16);
            map2.put("125", 17);
            map2.put("131", 18);
            map2.put("132", 19);
            map2.put("134", 20);
            map2.put("143", 21);
            map2.put("152", 22);
            map2.put("155", 23);
            map2.put("156", 24);
            map2.put("162", 25);
            map2.put("165", 26);
            map2.put("172", 27);
            map2.put("174", 28);
            map2.put("205", 29);
            map2.put("223", 30);
            map2.put("226", 31);
            map2.put("243", 32);
            map2.put("244", 33);
            map2.put("245", 34);
            map2.put("251", 35);
            map2.put("261", 36);
            map2.put("263", 37);
            map2.put("265", 38);
            map2.put("271", 39);
            map2.put("306", 40);
            map2.put("311", 41);
            map2.put("315", 42);
            map2.put("331", 43);
            map2.put("343", 44);
            map2.put("346", 45);
            map2.put("351", 46);
            map2.put("364", 47);
            map2.put("365", 48);
            map2.put("371", 49);
            map2.put("411", 50);
            map2.put("412", 51);
            map2.put("413", 52);
            map2.put("423", 53);
            map2.put("431", 54);
            map2.put("432", 55);
            map2.put("445", 56);
            map2.put("464", 57);
            map2.put("465", 58);
            map2.put("466", 59);
            map2.put("503", 60);
            map2.put("506", 61);
            map2.put("516", 62);
            map2.put("532", 63);
            map2.put("546", 64);
            map2.put("565", 65);
            map2.put("606", 66);
            map2.put("612", 67);
            map2.put("624", 68);
            map2.put("627", 69);
            map2.put("631", 70);
            map2.put("632", 71);
            map2.put("654", 72);
            map2.put("662", 73);
            map2.put("664", 74);
            map2.put("703", 75);
            map2.put("712", 76);
            map2.put("723", 77);
            map2.put("731", 78);
            map2.put("732", 79);
            map2.put("734", 80);
            map2.put("743", 81);
            map2.put("754", 82);
            double d5 = c0532x.f6833f;
            double d6 = c0532x.g;
            if (d5 > 0.0d || d6 > 0.0d) {
                if (d5 > 0.0d) {
                    i5 = 1;
                    c.z0(this, 1);
                } else {
                    i5 = 1;
                    c.z0(this, 0);
                }
                if (d6 > 0.0d) {
                    c.v0(this, i5);
                } else {
                    c.v0(this, 0);
                }
                String str10 = String.format("%.1f", Double.valueOf(c0532x.f6833f));
                Integer num = (Integer) map.get(str10);
                if (num != null) {
                    c.y0(this, num.intValue());
                    Log.d("Unified - MemoryChannel", "TX CTCSS tone: " + str10 + " -> index: " + num);
                } else {
                    Log.w("Unified - MemoryChannel", "TX CTCSS tone not found in map: ".concat(str10));
                    c.y0(this, 0);
                }
                String str11 = String.format("%.1f", Double.valueOf(d6));
                Integer num2 = (Integer) map.get(str11);
                if (num2 != null) {
                    c.u0(this, num2.intValue());
                    Log.d("Unified - MemoryChannel", "RX CTCSS tone: " + str11 + " -> index: " + num2);
                } else {
                    Log.w("Unified - MemoryChannel", "RX CTCSS tone not found in map: ".concat(str11));
                    c.u0(this, 0);
                }
            } else if (c0532x.h > 0 || c0532x.f6834i > 0) {
                c.z0(this, 2);
                c.v0(this, 2);
                String str12 = String.format("%03d", Integer.valueOf(c0532x.h));
                Integer num3 = (Integer) map2.get(str12);
                if (num3 != null) {
                    c.y0(this, num3.intValue());
                    Log.d("Unified - MemoryChannel", "TX DCS code: " + str12 + " -> index: " + num3);
                } else {
                    Log.w("Unified - MemoryChannel", "TX DCS code not found in map: ".concat(str12));
                    c.y0(this, 0);
                }
                String str13 = String.format("%03d", Integer.valueOf(c0532x.f6834i));
                Integer num4 = (Integer) map2.get(str13);
                if (num4 != null) {
                    c.u0(this, num4.intValue());
                    Log.d("Unified - MemoryChannel", "RX DCS code: " + str13 + " -> index: " + num4);
                } else {
                    Log.w("Unified - MemoryChannel", "RX DCS code not found in map: ".concat(str13));
                    c.u0(this, 0);
                }
            } else {
                c.z0(this, 0);
                c.v0(this, 0);
                c.y0(this, 0);
                c.u0(this, 0);
                Log.d("Unified - MemoryChannel", "No tones or DCS codes set");
            }
            s sVar = new s(C0774j.a(), 20, this);
            Log.d("Unified - MemoryChannel", "Channel Mode: " + str);
            if (str.contains("DMR")) {
                c.p0(this, "DMR");
                c.M(this, 1);
                c.N(this, c0532x.f6835j);
                Log.d("Unified - MemoryChannel", "DMR Settings:");
                Log.d("Unified - MemoryChannel", "  Color Code: " + c0532x.f6835j);
                Log.d("Unified - MemoryChannel", "  Timeslot: " + c0532x.f6836k);
                Log.d("Unified - MemoryChannel", "  TX Contact: " + i6);
                if (c0532x.f6836k == 2) {
                    c.Z(this, 1);
                    c.k0(this, 1);
                } else {
                    c.Z(this, 0);
                    c.k0(this, 0);
                }
                c.w0(this, i6);
                c.W(this, c0532x.f6840p);
                if (this.f5686i) {
                    sVar.B();
                } else {
                    sVar.A();
                    new Handler(Looper.getMainLooper()).postDelayed(new RunnableC0492C(sVar, 0), 4000L);
                }
            } else {
                c.p0(this, "FM");
                c.M(this, 0);
                Log.d("Unified - MemoryChannel", "FM mode selected");
                if (this.f5686i) {
                    sVar.z();
                } else {
                    sVar.y();
                    new Handler(Looper.getMainLooper()).postDelayed(new RunnableC0492C(sVar, 1), 4000L);
                }
            }
            String str14 = c0532x.f6839o;
            if (str14 != null && !str14.isEmpty()) {
                Log.d("Unified - MemoryChannel", "Channel power: ".concat(str14));
                if (str14.equals("Low")) {
                    c.m0(this, 0);
                } else {
                    c.m0(this, 1);
                }
            }
        }
        c.b0(this, c0532x.f6828a);
        Log.d("Unified - MemoryChannel", "Channel Name: " + c0532x.f6828a);
        c.a0(this, str2);
        AbstractC0535a.v("Channel Frequency: ", str2, "Unified - MemoryChannel");
        String str15 = c0532x.f6843s;
        if (!"Off".equals(str15) && str15 != null && !str15.isEmpty()) {
            getApplicationContext().getSharedPreferences("AppSettings", 0).edit().putString("encryption", c0532x.f6843s).apply();
            getApplicationContext().getSharedPreferences("AppSettings", 0).edit().putString("encryption_key", c0532x.f6844t).apply();
            h.q(new StringBuilder("Encryption enabled: "), c0532x.f6843s, "Unified - MemoryChannel");
        }
        Log.d("Unified - MemoryChannel", "=== saveChannelSettings END ===");
    }

    public final void n(Set set) {
        ArrayList arrayList = new ArrayList();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            int iIntValue = ((Integer) this.f5688k.getOrDefault(str, 999)).intValue();
            C0495F c0495f = new C0495F();
            c0495f.f6588a = str;
            c0495f.f6589b = iIntValue;
            arrayList.add(c0495f);
        }
        Collections.sort(arrayList, new a(6));
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((C0495F) it2.next()).f6588a);
        }
        Log.d("Unified - MemoryChannel", "Zones sorted by order: " + arrayList2);
        runOnUiThread(new m(this, 20, arrayList2));
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, androidx.activity.ComponentActivity, B.i, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().getDecorView().setSystemUiVisibility(4098);
        setContentView(R.layout.activity_memory_channel);
        this.h = Build.DISPLAY;
        this.f5682c = (RecyclerView) findViewById(R.id.channelList);
        this.f5683d = (Spinner) findViewById(R.id.zoneSpinner);
        this.f5682c.setLayoutManager(new LinearLayoutManager(1));
        ArrayList arrayList = new ArrayList();
        C0524o c0524o = new C0524o(1);
        new HashMap();
        c0524o.f6769b = arrayList;
        c0524o.f6770c = this;
        this.g = c0524o;
        this.f5682c.setAdapter(c0524o);
        this.f5683d.setOnItemSelectedListener(new C0494E(this, 0));
        if (this.h.contains("A500V5TN7.GQU2") || this.h.contains("Ulefone.HJ.FHD") || this.h.contains("PPR1")) {
            this.f5686i = true;
        }
        Log.d("Unified - MemoryChannel", "=== CJ-26 = " + this.f5686i);
        this.f5685f.clear();
        this.f5687j.clear();
        this.f5688k.clear();
        Log.d("Unified - MemoryChannel", "=== CJ-26 Fetch = " + this.f5686i);
        this.f5684e.execute(new RunnableC0493D(this, 0));
    }
}
