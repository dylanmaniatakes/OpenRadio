package f3;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.unified.ur1.R;
import com.unified.ur1.primary.LaunchActivity;
import f.C0467d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import m3.C0774j;

/* loaded from: classes.dex */
public final class f0 extends androidx.recyclerview.widget.N {

    /* renamed from: a, reason: collision with root package name */
    public final List f6709a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f6710b;

    /* renamed from: c, reason: collision with root package name */
    public final ExecutorService f6711c = Executors.newSingleThreadExecutor();

    public f0(Context context, ArrayList arrayList) {
        this.f6709a = arrayList;
        this.f6710b = context;
    }

    public static void e(HashMap map) {
        com.unified.ur1.SatelliteTracker.h.n(-1, map, "None", 0, "023");
        com.unified.ur1.SatelliteTracker.h.n(1, map, "025", 2, "026");
        com.unified.ur1.SatelliteTracker.h.n(3, map, "031", 4, "032");
        com.unified.ur1.SatelliteTracker.h.n(5, map, "043", 6, "047");
        com.unified.ur1.SatelliteTracker.h.n(7, map, "051", 8, "054");
        com.unified.ur1.SatelliteTracker.h.n(9, map, "065", 10, "071");
        com.unified.ur1.SatelliteTracker.h.n(11, map, "072", 12, "073");
        com.unified.ur1.SatelliteTracker.h.n(13, map, "074", 14, "114");
        com.unified.ur1.SatelliteTracker.h.n(15, map, "115", 16, "116");
        com.unified.ur1.SatelliteTracker.h.n(17, map, "125", 18, "131");
        com.unified.ur1.SatelliteTracker.h.n(19, map, "132", 20, "134");
        com.unified.ur1.SatelliteTracker.h.n(21, map, "143", 22, "152");
        com.unified.ur1.SatelliteTracker.h.n(23, map, "155", 24, "156");
        com.unified.ur1.SatelliteTracker.h.n(25, map, "162", 26, "165");
        com.unified.ur1.SatelliteTracker.h.n(27, map, "172", 28, "174");
        com.unified.ur1.SatelliteTracker.h.n(29, map, "205", 30, "223");
        com.unified.ur1.SatelliteTracker.h.n(31, map, "226", 32, "243");
        com.unified.ur1.SatelliteTracker.h.n(33, map, "244", 34, "245");
        com.unified.ur1.SatelliteTracker.h.n(35, map, "251", 36, "261");
        com.unified.ur1.SatelliteTracker.h.n(37, map, "263", 38, "265");
        com.unified.ur1.SatelliteTracker.h.n(39, map, "271", 40, "306");
        com.unified.ur1.SatelliteTracker.h.n(41, map, "311", 42, "315");
        com.unified.ur1.SatelliteTracker.h.n(43, map, "331", 44, "343");
        com.unified.ur1.SatelliteTracker.h.n(45, map, "346", 46, "351");
        com.unified.ur1.SatelliteTracker.h.n(47, map, "364", 48, "365");
        com.unified.ur1.SatelliteTracker.h.n(49, map, "371", 50, "411");
        com.unified.ur1.SatelliteTracker.h.n(51, map, "412", 52, "413");
        com.unified.ur1.SatelliteTracker.h.n(53, map, "423", 54, "431");
        com.unified.ur1.SatelliteTracker.h.n(55, map, "432", 56, "445");
        com.unified.ur1.SatelliteTracker.h.n(57, map, "464", 58, "465");
        com.unified.ur1.SatelliteTracker.h.n(59, map, "466", 60, "503");
        com.unified.ur1.SatelliteTracker.h.n(61, map, "506", 62, "516");
        com.unified.ur1.SatelliteTracker.h.n(63, map, "532", 64, "546");
        com.unified.ur1.SatelliteTracker.h.n(65, map, "565", 66, "606");
        com.unified.ur1.SatelliteTracker.h.n(67, map, "612", 68, "624");
        com.unified.ur1.SatelliteTracker.h.n(69, map, "627", 70, "631");
        com.unified.ur1.SatelliteTracker.h.n(71, map, "632", 72, "654");
        com.unified.ur1.SatelliteTracker.h.n(73, map, "662", 74, "664");
        com.unified.ur1.SatelliteTracker.h.n(75, map, "703", 76, "712");
        com.unified.ur1.SatelliteTracker.h.n(77, map, "723", 78, "731");
        com.unified.ur1.SatelliteTracker.h.n(79, map, "732", 80, "734");
        com.unified.ur1.SatelliteTracker.h.n(81, map, "743", 82, "754");
    }

    public static void f(HashMap map) {
        com.unified.ur1.SatelliteTracker.h.n(0, map, "None", 1, "67.0");
        com.unified.ur1.SatelliteTracker.h.n(2, map, "69.3", 3, "71.9");
        com.unified.ur1.SatelliteTracker.h.n(4, map, "74.4", 5, "77.0");
        com.unified.ur1.SatelliteTracker.h.n(6, map, "79.7", 7, "82.5");
        com.unified.ur1.SatelliteTracker.h.n(8, map, "85.4", 9, "88.5");
        com.unified.ur1.SatelliteTracker.h.n(10, map, "91.5", 11, "94.8");
        com.unified.ur1.SatelliteTracker.h.n(12, map, "97.4", 13, "100.0");
        com.unified.ur1.SatelliteTracker.h.n(14, map, "103.5", 15, "107.2");
        com.unified.ur1.SatelliteTracker.h.n(16, map, "110.9", 17, "114.8");
        com.unified.ur1.SatelliteTracker.h.n(18, map, "118.8", 19, "123.0");
        com.unified.ur1.SatelliteTracker.h.n(20, map, "127.3", 21, "131.8");
        com.unified.ur1.SatelliteTracker.h.n(22, map, "136.5", 23, "141.3");
        com.unified.ur1.SatelliteTracker.h.n(24, map, "146.2", 25, "151.4");
        com.unified.ur1.SatelliteTracker.h.n(26, map, "156.7", 27, "159.8");
        com.unified.ur1.SatelliteTracker.h.n(28, map, "162.2", 29, "165.5");
        com.unified.ur1.SatelliteTracker.h.n(30, map, "167.9", 31, "171.3");
        com.unified.ur1.SatelliteTracker.h.n(32, map, "173.8", 33, "177.3");
        com.unified.ur1.SatelliteTracker.h.n(34, map, "179.9", 35, "183.5");
        com.unified.ur1.SatelliteTracker.h.n(36, map, "186.2", 37, "189.9");
        com.unified.ur1.SatelliteTracker.h.n(38, map, "192.8", 39, "196.6");
        com.unified.ur1.SatelliteTracker.h.n(40, map, "199.5", 41, "203.5");
        com.unified.ur1.SatelliteTracker.h.n(42, map, "206.5", 43, "210.7");
        com.unified.ur1.SatelliteTracker.h.n(44, map, "218.1", 45, "225.7");
        com.unified.ur1.SatelliteTracker.h.n(46, map, "229.1", 47, "233.6");
        com.unified.ur1.SatelliteTracker.h.n(48, map, "241.8", 49, "250.3");
        map.put("254.1", 50);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r1v28 */
    public final void a(m0 m0Var, Context context) throws NumberFormatException {
        ?? r12;
        L0.s sVar;
        long j5;
        CharSequence charSequence;
        int i5;
        m0 m0Var2 = m0Var;
        Context context2 = this.f6710b;
        Log.d("Unified - RepeaterDir", "--------------performOriginalProgramming Called--------------");
        try {
            L0.s sVar2 = new L0.s(C0774j.a(), 20, context);
            String str = m0Var2.f6757p;
            String str2 = m0Var2.f6745a;
            Log.d("Unified - RepeaterDir", "Programming - RX frequency (from repeater TX): " + str);
            try {
                if (str == null || str.isEmpty()) {
                    throw new IllegalArgumentException("Programming -Invalid RX frequency");
                }
                String strTrim = str.replace(" MHz", "").trim();
                String strTrim2 = strTrim.replace(" MHz", "").trim();
                long j6 = (long) (Double.parseDouble(strTrim) * 1000000.0d);
                String str3 = m0Var2.f6758q;
                if (str3 == null || str3.isEmpty()) {
                    sVar = sVar2;
                    j5 = j6;
                } else {
                    String strTrim3 = str3.replace(" MHz", "").trim();
                    Log.d("Unified - RepeaterDir", "Programming -TX frequency (from repeater RX): " + strTrim3);
                    sVar = sVar2;
                    j5 = (long) (Double.parseDouble(strTrim3) * 1000000.0d);
                }
                try {
                    i5 = Integer.parseInt(m0Var2.f6746b);
                    charSequence = "";
                } catch (NumberFormatException e5) {
                    charSequence = "";
                    Log.e("Unified - RepeaterDir", "Programming -Error parsing color code, defaulting to 1", e5);
                    i5 = 1;
                }
                Log.d("Unified - RepeaterDir", "Programming -SharedSettings -> RX Frequency: " + j6 + " Hz");
                h4.c.t0(context, j6);
                Log.d("Unified - RepeaterDir", "Programming -SharedSettings -> TX Frequency: " + j5 + " Hz");
                h4.c.x0(context, j5);
                HashMap map = new HashMap();
                HashMap map2 = new HashMap();
                f(map);
                e(map2);
                String str4 = m0Var2.f6748d;
                Log.d("Unified - RepeaterDir", "Programming -Processing mode: " + str4);
                if (str4 == null || !str4.contains("DMR")) {
                    Log.d("Unified - RepeaterDir", "Programming -SharedSettings -> Setting FM mode: RadioMode=FM, ChannelMode=0");
                    h4.c.p0(context, "FM");
                    h4.c.M(context, 0);
                    h4.c.N(context, 1);
                    String str5 = m0Var2.f6749e;
                    Log.d("Unified - RepeaterDir", "Programming -Processing tone: " + str5);
                    if (str5 != null && !str5.equals("0.0") && !str5.isEmpty() && !str5.equals("null")) {
                        CharSequence charSequence2 = charSequence;
                        String strTrim4 = str5.replace("Hz", charSequence2).replace(" ", charSequence2).trim();
                        if (strTrim4.matches("\\d{3}")) {
                            Integer num = (Integer) map2.get(strTrim4);
                            if (num != null) {
                                Log.d("Unified - RepeaterDir", "Programming -Setting DCS code: " + strTrim4 + " (index: " + num + ")");
                                h4.c.z0(context, 2);
                                h4.c.v0(context, 2);
                                h4.c.y0(context, num.intValue());
                                h4.c.u0(context, num.intValue());
                            }
                        } else {
                            try {
                                String str6 = String.format("%.1f", Double.valueOf(Double.parseDouble(strTrim4)));
                                Integer num2 = (Integer) map.get(str6);
                                if (num2 != null) {
                                    Log.d("Unified - RepeaterDir", "Programming -Setting CTCSS tone: " + str6 + " (index: " + num2 + ")");
                                    h4.c.z0(context, 1);
                                    h4.c.v0(context, 0);
                                    h4.c.y0(context, num2.intValue());
                                    h4.c.u0(context, num2.intValue());
                                }
                            } catch (NumberFormatException e6) {
                                Log.e("Unified - RepeaterDir", "Programming -Error parsing tone: ".concat(strTrim4), e6);
                            }
                        }
                    }
                    Context context3 = LaunchActivity.f5853D1;
                    new Handler(Looper.getMainLooper()).postDelayed(new RunnableC0492C(sVar, 3), 6000L);
                } else {
                    Log.d("Unified - RepeaterDir", "Programming -SharedSettings -> Setting DMR mode with Color Code: " + i5);
                    h4.c.p0(context, "DMR");
                    h4.c.M(context, 1);
                    h4.c.N(context, i5);
                    h4.c.z0(context, 0);
                    h4.c.v0(context, 0);
                    h4.c.y0(context, 0);
                    h4.c.u0(context, 0);
                    Context context4 = LaunchActivity.f5853D1;
                    new Handler(Looper.getMainLooper()).postDelayed(new RunnableC0492C(sVar, 2), 6000L);
                }
                h4.c.b0(context, str2);
                h4.c.a0(context, strTrim2);
                h4.c.m0(context, 1);
                Toast.makeText(context2, str2 + " Repeater Programmed Successfully", 0).show();
                if (context2 instanceof Activity) {
                    ((Activity) context2).finish();
                }
            } catch (Exception e7) {
                e = e7;
                r12 = m0Var2;
                StringBuilder sbG = com.unified.ur1.SatelliteTracker.h.g("Unified - RepeaterDir", "Error programming repeater", e, "Error programming repeater: ");
                sbG.append(e.getMessage());
                Toast.makeText((Context) r12, sbG.toString(), 1).show();
            }
        } catch (Exception e8) {
            e = e8;
            r12 = context2;
            StringBuilder sbG2 = com.unified.ur1.SatelliteTracker.h.g("Unified - RepeaterDir", "Error programming repeater", e, "Error programming repeater: ");
            sbG2.append(e.getMessage());
            Toast.makeText((Context) r12, sbG2.toString(), 1).show();
        }
    }

    public final void b(m0 m0Var, L.h hVar) {
        Log.d("Unified - RepeaterDir", "--------------proceedWithProgramming Called--------------");
        C0467d c0467d = (C0467d) hVar.f1522d;
        c0467d.f6292d = "Program Repeater";
        c0467d.f6294f = com.unified.ur1.SatelliteTracker.h.e(new StringBuilder("Program "), m0Var.f6745a, " to radio?");
        hVar.e("Yes", new DialogInterfaceOnClickListenerC0517h(this, 3, m0Var));
        hVar.c("Cancel", null);
        hVar.f();
    }

    public final void c(InterfaceC0512d0 interfaceC0512d0) {
        Context context = this.f6710b;
        L.h hVar = new L.h(context, R.style.ThemeOverlay_MaterialComponents_Dialog_Alert);
        EditText editText = new EditText(context);
        editText.setHint("Enter your callsign");
        C0467d c0467d = (C0467d) hVar.f1522d;
        c0467d.f6292d = "Callsign Required";
        c0467d.f6304s = editText;
        hVar.e("OK", new S(this, editText, interfaceC0512d0, 0));
        hVar.c("Cancel", new DialogInterfaceOnClickListenerC0520k(1, interfaceC0512d0));
        hVar.f();
    }

    public final void d(String str) {
        PreferenceManager.getDefaultSharedPreferences(this.f6710b).edit().putString("user_callsign", str).apply();
    }

    public final void g(final m0 m0Var) {
        final boolean z4 = !m0Var.f6752j;
        String str = z4 ? "Are you sure you want to report this repeater as offline?" : "Are you sure you want to report this repeater as back online?";
        L.h hVar = new L.h(this.f6710b, R.style.ThemeOverlay_MaterialComponents_Dialog_Alert);
        C0467d c0467d = (C0467d) hVar.f1522d;
        c0467d.f6292d = "Confirm Status Change";
        c0467d.f6294f = str;
        hVar.e("Yes", new DialogInterface.OnClickListener() { // from class: f3.T
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                f0 f0Var = this.f6636c;
                f0Var.f6711c.execute(new D0.g(2, f0Var, m0Var, z4));
            }
        });
        hVar.c("No", null);
        hVar.f();
    }

    @Override // androidx.recyclerview.widget.N
    public final int getItemCount() {
        return this.f6709a.size();
    }

    @Override // androidx.recyclerview.widget.N
    public final void onBindViewHolder(androidx.recyclerview.widget.n0 n0Var, int i5) {
        C0514e0 c0514e0 = (C0514e0) n0Var;
        m0 m0Var = (m0) this.f6709a.get(i5);
        c0514e0.f6689a.setText(m0Var.f6745a);
        c0514e0.f6690b.setText(String.format("(%.1f mi)", Double.valueOf(m0Var.f6751i)));
        c0514e0.f6691c.setText(m0Var.f6747c);
        TextView textView = c0514e0.f6692d;
        String str = m0Var.f6748d;
        textView.setText(str);
        boolean zContains = str.contains("DMR");
        TextView textView2 = c0514e0.f6693e;
        if (zContains) {
            textView2.setText("CC: " + m0Var.f6746b);
        } else {
            String str2 = m0Var.f6749e;
            if (str2.equals("null") || str2.equals("")) {
                textView2.setText("Tone: None");
            } else {
                textView2.setText("Tone: ".concat(str2));
            }
        }
        String str3 = "Score: " + m0Var.f6750f;
        TextView textView3 = c0514e0.f6694f;
        textView3.setText(str3);
        if (m0Var.f6750f > 0) {
            textView3.setTextColor(Color.rgb(100, 255, 100));
        }
        boolean zContains2 = str.contains("DMR");
        View view = c0514e0.g;
        if (zContains2) {
            view.setVisibility(0);
            TextView textView4 = c0514e0.h;
            String str4 = m0Var.g;
            if (str4 == null || str4.equals("") || str4.equals("null")) {
                textView4.setVisibility(8);
            } else {
                textView4.setVisibility(0);
                textView4.setText("TS1: ".concat(str4));
            }
            TextView textView5 = c0514e0.f6695i;
            String str5 = m0Var.h;
            if (str5 == null || str5.equals("") || str5.equals("null")) {
                textView5.setVisibility(8);
            } else {
                textView5.setVisibility(0);
                textView5.setText("TS2: ".concat(str5));
            }
        } else {
            view.setVisibility(8);
        }
        boolean z4 = m0Var.f6752j;
        View view2 = c0514e0.f6696j;
        if (z4) {
            view2.setVisibility(0);
        } else {
            view2.setVisibility(8);
        }
        ViewOnClickListenerC0503N viewOnClickListenerC0503N = new ViewOnClickListenerC0503N(this, m0Var, 0);
        textView3.setOnClickListener(viewOnClickListenerC0503N);
        c0514e0.f6689a.setOnClickListener(viewOnClickListenerC0503N);
    }

    @Override // androidx.recyclerview.widget.N
    public final androidx.recyclerview.widget.n0 onCreateViewHolder(ViewGroup viewGroup, int i5) {
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.repeater_item, viewGroup, false);
        C0514e0 c0514e0 = new C0514e0(viewInflate);
        c0514e0.f6689a = (TextView) viewInflate.findViewById(R.id.callsign);
        c0514e0.f6690b = (TextView) viewInflate.findViewById(R.id.location);
        c0514e0.f6691c = (TextView) viewInflate.findViewById(R.id.frequency);
        c0514e0.f6692d = (TextView) viewInflate.findViewById(R.id.mode);
        c0514e0.f6693e = (TextView) viewInflate.findViewById(R.id.tone);
        c0514e0.f6694f = (TextView) viewInflate.findViewById(R.id.score);
        c0514e0.g = viewInflate.findViewById(R.id.dmrInfoContainer);
        c0514e0.h = (TextView) viewInflate.findViewById(R.id.dmrTS1Info);
        c0514e0.f6695i = (TextView) viewInflate.findViewById(R.id.dmrTS2Info);
        c0514e0.f6696j = viewInflate.findViewById(R.id.offlineIndicator);
        return c0514e0;
    }
}
