package i3;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.text.method.DigitsKeyListener;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.unified.ur1.R;
import com.unified.ur1.SatelliteTracker.SatelliteTrackerActivity;
import com.unified.ur1.inbox.Message;
import com.unified.ur1.inbox.UnifiedInboxActivity;
import com.unified.ur1.primary.LaunchActivity;
import f.C0467d;
import f.C0468e;
import f.DialogC0469f;
import f3.C0519j;
import f3.C0524o;
import f3.DialogInterfaceOnClickListenerC0516g;
import f3.DialogInterfaceOnClickListenerC0517h;
import g0.AbstractC0535a;
import k3.C0708r0;
import k3.C0710s0;
import k3.DialogInterfaceOnClickListenerC0719x;
import k3.DialogInterfaceOnClickListenerC0720y;
import k3.O;
import k3.X;

/* loaded from: classes.dex */
public final class k implements DialogInterface.OnClickListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f7312c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f7313d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f7314e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f7315f;

    public /* synthetic */ k(Object obj, Object obj2, int i5, int i6) {
        this.f7312c = i6;
        this.f7315f = obj;
        this.f7313d = obj2;
        this.f7314e = i5;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i5) throws Throwable {
        int i6 = this.f7314e;
        Object obj = this.f7315f;
        Object obj2 = this.f7313d;
        switch (this.f7312c) {
            case 0:
                m mVar = (m) obj;
                l lVar = mVar.f7320i;
                if (lVar != null) {
                    ((UnifiedInboxActivity) lVar).s((Message) obj2, i6);
                    mVar.i();
                    return;
                }
                return;
            case 1:
                UnifiedInboxActivity unifiedInboxActivity = (UnifiedInboxActivity) obj;
                if (unifiedInboxActivity.h != null) {
                    unifiedInboxActivity.f5831c.setVisibility(0);
                    Message message = (Message) obj2;
                    unifiedInboxActivity.h.markAsRead("mark_deleted", message.getId()).enqueue(new C0573b(unifiedInboxActivity, i6, message));
                    return;
                } else {
                    Toast.makeText(unifiedInboxActivity, "Cannot delete message - API not available", 0).show();
                    C0524o c0524o = unifiedInboxActivity.g;
                    if (c0524o != null) {
                        c0524o.notifyItemChanged(i6);
                        return;
                    }
                    return;
                }
            case 2:
                if (String.valueOf(i6).isEmpty()) {
                    return;
                }
                O o5 = (O) obj;
                TextView textView = (TextView) o5.f8001b.findViewById(R.id.activeFrequency);
                LaunchActivity launchActivity = o5.f8001b;
                TextView textView2 = (TextView) launchActivity.findViewById(R.id.activeMemoryName);
                TextView textView3 = (TextView) launchActivity.findViewById(R.id.network);
                try {
                    h4.c.U(launchActivity, i6);
                    String strY = h4.c.y((Context) obj2);
                    launchActivity.f5977y0 = new ProgressDialog(launchActivity);
                    launchActivity.f5977y0.setTitle("🔄 Establishing Connection");
                    launchActivity.f5977y0.setMessage("Please wait while we establish the link.");
                    launchActivity.f5977y0.setProgressStyle(0);
                    launchActivity.f5977y0.setCancelable(false);
                    launchActivity.f5977y0.show();
                    if (strY == null || !strY.toLowerCase().contains("brandmeister")) {
                        launchActivity.f5915b1.f();
                        launchActivity.m0();
                        final int i7 = 1;
                        new Handler().postDelayed(new Runnable(this) { // from class: k3.N

                            /* renamed from: k, reason: collision with root package name */
                            public final /* synthetic */ i3.k f7995k;

                            {
                                this.f7995k = this;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                switch (i7) {
                                    case 0:
                                        O o6 = (O) this.f7995k.f7315f;
                                        ProgressDialog progressDialog = o6.f8001b.f5977y0;
                                        if (progressDialog != null && progressDialog.isShowing()) {
                                            LaunchActivity launchActivity2 = o6.f8001b;
                                            h4.c.f0(launchActivity2, false);
                                            launchActivity2.f5977y0.dismiss();
                                            break;
                                        }
                                        break;
                                    default:
                                        O o7 = (O) this.f7995k.f7315f;
                                        ProgressDialog progressDialog2 = o7.f8001b.f5977y0;
                                        if (progressDialog2 != null && progressDialog2.isShowing()) {
                                            o7.f8001b.f5977y0.dismiss();
                                            break;
                                        }
                                        break;
                                }
                            }
                        }, 2000L);
                    } else {
                        launchActivity.f5915b1.subscribeTalkgroup(i6);
                        launchActivity.q0(i6);
                        final int i8 = 0;
                        new Handler().postDelayed(new Runnable(this) { // from class: k3.N

                            /* renamed from: k, reason: collision with root package name */
                            public final /* synthetic */ i3.k f7995k;

                            {
                                this.f7995k = this;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                switch (i8) {
                                    case 0:
                                        O o6 = (O) this.f7995k.f7315f;
                                        ProgressDialog progressDialog = o6.f8001b.f5977y0;
                                        if (progressDialog != null && progressDialog.isShowing()) {
                                            LaunchActivity launchActivity2 = o6.f8001b;
                                            h4.c.f0(launchActivity2, false);
                                            launchActivity2.f5977y0.dismiss();
                                            break;
                                        }
                                        break;
                                    default:
                                        O o7 = (O) this.f7995k.f7315f;
                                        ProgressDialog progressDialog2 = o7.f8001b.f5977y0;
                                        if (progressDialog2 != null && progressDialog2.isShowing()) {
                                            o7.f8001b.f5977y0.dismiss();
                                            break;
                                        }
                                        break;
                                }
                            }
                        }, 1500L);
                    }
                    String str = "TG: " + i6;
                    textView.setText(str);
                    if (str.length() > 8) {
                        textView.setTextSize(1, Math.max(Math.max(0.5f, 8.0f / str.length()) * 60.0f, 24.0f));
                    } else {
                        textView.setTextSize(1, 60.0f);
                    }
                    textView2.setText("Manual Entry");
                    h4.c.b0(launchActivity, "Manual Entry");
                    h4.c.a0(launchActivity, str);
                    textView3.setText(h4.c.y(launchActivity) + " - " + h4.c.z(launchActivity));
                    StringBuilder sb = new StringBuilder("✅ Connecting to TG ");
                    sb.append(i6);
                    q2.k kVarG = q2.k.g(null, launchActivity.findViewById(android.R.id.content), sb.toString(), -1);
                    kVarG.h(C.d.a(launchActivity, R.color.accent_green));
                    kVarG.i(-1);
                    kVarG.j();
                    return;
                } catch (Exception e5) {
                    throw new RuntimeException(e5);
                }
            default:
                String str2 = ((String[]) obj2)[i5];
                String str3 = "power";
                LaunchActivity launchActivity2 = (LaunchActivity) obj;
                if (str2.equals("Analog - FM")) {
                    Toast.makeText(launchActivity2, "Opening Analog - FM Settings", 0).show();
                    Context context = LaunchActivity.f5853D1;
                    if (launchActivity2.isFinishing() || launchActivity2.isDestroyed()) {
                        Log.w("Unified - Main Activity", "Activity is finishing/destroyed, cannot show dialog");
                    } else {
                        L.h hVar = new L.h(launchActivity2, R.style.Base_Theme_Material3_Dark_Dialog);
                        C0467d c0467d = (C0467d) hVar.f1522d;
                        c0467d.f6292d = "Edit Settings";
                        View viewInflate = launchActivity2.getLayoutInflater().inflate(R.layout.dialog_analog_settings, (ViewGroup) null);
                        EditText editText = (EditText) viewInflate.findViewById(R.id.rx_freq);
                        EditText editText2 = (EditText) viewInflate.findViewById(R.id.tx_freq);
                        Spinner spinner = (Spinner) viewInflate.findViewById(R.id.band_spinner);
                        Spinner spinner2 = (Spinner) viewInflate.findViewById(R.id.power_spinner);
                        SeekBar seekBar = (SeekBar) viewInflate.findViewById(R.id.squelch_seekbar);
                        Spinner spinner3 = (Spinner) viewInflate.findViewById(R.id.rx_type_spinner);
                        Spinner spinner4 = (Spinner) viewInflate.findViewById(R.id.tx_type_spinner);
                        Spinner spinner5 = (Spinner) viewInflate.findViewById(R.id.rx_subcode_spinner);
                        Spinner spinner6 = (Spinner) viewInflate.findViewById(R.id.tx_subcode_spinner);
                        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(launchActivity2, R.array.band_options, android.R.layout.simple_spinner_item);
                        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner.setAdapter((SpinnerAdapter) arrayAdapterCreateFromResource);
                        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource2 = ArrayAdapter.createFromResource(launchActivity2, R.array.power_options, android.R.layout.simple_spinner_item);
                        arrayAdapterCreateFromResource2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        Log.d("PowerSpinner", "Adapter size: " + arrayAdapterCreateFromResource2.getCount());
                        int i9 = 0;
                        while (i9 < arrayAdapterCreateFromResource2.getCount()) {
                            StringBuilder sbF = com.unified.ur1.SatelliteTracker.h.f("Item ", i9, ": ");
                            sbF.append((Object) arrayAdapterCreateFromResource2.getItem(i9));
                            Log.d("PowerSpinner", sbF.toString());
                            i9++;
                            str3 = str3;
                        }
                        spinner2.setAdapter((SpinnerAdapter) arrayAdapterCreateFromResource2);
                        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource3 = ArrayAdapter.createFromResource(launchActivity2, R.array.tone_type_options, android.R.layout.simple_spinner_item);
                        arrayAdapterCreateFromResource3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner3.setAdapter((SpinnerAdapter) arrayAdapterCreateFromResource3);
                        spinner4.setAdapter((SpinnerAdapter) arrayAdapterCreateFromResource3);
                        spinner3.setOnItemSelectedListener(new C0708r0(launchActivity2, spinner5));
                        spinner4.setOnItemSelectedListener(new C0710s0(launchActivity2, spinner6, spinner3));
                        editText.setText(String.format("%.5f", Double.valueOf(h4.c.A(launchActivity2) / 1000000.0d)));
                        editText2.setText(String.format("%.5f", Double.valueOf(h4.c.E(launchActivity2) / 1000000.0d)));
                        spinner.setSelection(launchActivity2.getApplicationContext().getSharedPreferences("AppSettings", 0).getInt("band", 1));
                        spinner2.setSelection(launchActivity2.getApplicationContext().getSharedPreferences("AppSettings", 0).getInt(str3, 1));
                        seekBar.setProgress(launchActivity2.getApplicationContext().getSharedPreferences("AppSettings", 0).getInt("squelch", 1));
                        spinner3.setSelection(launchActivity2.getApplicationContext().getSharedPreferences("AppSettings", 0).getInt("rx_type", 0));
                        spinner4.setSelection(launchActivity2.getApplicationContext().getSharedPreferences("AppSettings", 0).getInt("tx_type", 0));
                        c0467d.f6304s = viewInflate;
                        hVar.e("SAVE", new DialogInterfaceOnClickListenerC0720y(launchActivity2, editText, editText2, spinner, spinner2, seekBar, spinner3, spinner4, spinner5, spinner6, 0));
                        hVar.c("CANCEL", new DialogInterfaceOnClickListenerC0516g(10));
                        try {
                            hVar.b().show();
                        } catch (WindowManager.BadTokenException e6) {
                            Log.e("Unified - Main Activity", "Failed to show dialog - invalid window token", e6);
                            if (!launchActivity2.isFinishing() && !launchActivity2.isDestroyed()) {
                                Toast.makeText(launchActivity2, "Cannot show dialog - please try again", 0).show();
                            }
                        }
                    }
                } else if (str2.equals("Digital - DMR")) {
                    Toast.makeText(launchActivity2, "Opening Digital - DMR Settings", 0).show();
                    Context context2 = LaunchActivity.f5853D1;
                    launchActivity2.getClass();
                    L.h hVar2 = new L.h(launchActivity2, R.style.Base_Theme_Material3_Dark_Dialog);
                    C0467d c0467d2 = (C0467d) hVar2.f1522d;
                    c0467d2.f6292d = "Edit Settings";
                    View viewInflate2 = launchActivity2.getLayoutInflater().inflate(R.layout.dialog_digital_settings, (ViewGroup) null);
                    int iQ = h4.c.q(launchActivity2);
                    TextView textView4 = (TextView) viewInflate2.findViewById(R.id.localID);
                    EditText editText3 = (EditText) viewInflate2.findViewById(R.id.rx_freq);
                    EditText editText4 = (EditText) viewInflate2.findViewById(R.id.tx_freq);
                    EditText editText5 = (EditText) viewInflate2.findViewById(R.id.local_id);
                    EditText editText6 = (EditText) viewInflate2.findViewById(R.id.tx_contact);
                    EditText editText7 = (EditText) viewInflate2.findViewById(R.id.group_list);
                    Spinner spinner7 = (Spinner) viewInflate2.findViewById(R.id.contact_type_spinner);
                    Spinner spinner8 = (Spinner) viewInflate2.findViewById(R.id.power_spinner);
                    Spinner spinner9 = (Spinner) viewInflate2.findViewById(R.id.color_code_spinner);
                    Spinner spinner10 = (Spinner) viewInflate2.findViewById(R.id.inbound_slot_spinner);
                    Spinner spinner11 = (Spinner) viewInflate2.findViewById(R.id.outbound_slot_spinner);
                    Spinner spinner12 = (Spinner) viewInflate2.findViewById(R.id.channel_mode_spinner);
                    launchActivity2.u0(spinner8, R.array.power_options);
                    launchActivity2.u0(spinner7, R.array.contact_type_options);
                    launchActivity2.u0(spinner9, R.array.color_code_options);
                    launchActivity2.u0(spinner10, R.array.time_slot_options);
                    launchActivity2.u0(spinner11, R.array.time_slot_options);
                    launchActivity2.u0(spinner12, R.array.channel_mode_options);
                    editText3.setText(String.format("%.5f", Double.valueOf(h4.c.A(launchActivity2) / 1000000.0d)));
                    editText4.setText(String.format("%.5f", Double.valueOf(h4.c.E(launchActivity2) / 1000000.0d)));
                    editText5.setText(String.valueOf(h4.c.q(launchActivity2)));
                    editText6.setText(String.valueOf(h4.c.D(launchActivity2)));
                    editText7.setText(h4.c.C(launchActivity2).getString("group_list", ""));
                    spinner8.setSelection(launchActivity2.getApplicationContext().getSharedPreferences("AppSettings", 0).getInt("power", 1));
                    spinner7.setSelection(launchActivity2.getApplicationContext().getSharedPreferences("AppSettings", 0).getInt("contact_type", 1));
                    spinner9.setSelection(launchActivity2.getApplicationContext().getSharedPreferences("AppSettings", 0).getInt("color_code", 2));
                    spinner10.setSelection(launchActivity2.getApplicationContext().getSharedPreferences("AppSettings", 0).getInt("outbound_slot", 0));
                    spinner11.setSelection(launchActivity2.getApplicationContext().getSharedPreferences("AppSettings", 0).getInt("outbound_slot", 0));
                    spinner12.setSelection(launchActivity2.getApplicationContext().getSharedPreferences("AppSettings", 0).getInt("channel_mode", 0));
                    if (iQ > 1000) {
                        editText5.setVisibility(8);
                        textView4.setVisibility(8);
                    }
                    c0467d2.f6304s = viewInflate2;
                    hVar2.e("SAVE", new DialogInterfaceOnClickListenerC0719x(launchActivity2, editText3, editText4, editText5, editText6, editText7, spinner8, spinner7, spinner9, spinner11, spinner12, 0));
                    hVar2.c("CANCEL", new DialogInterfaceOnClickListenerC0516g(9));
                    hVar2.b().show();
                } else if (str2.equals("AmSAT")) {
                    Toast.makeText(launchActivity2, "Opening Amateur Radio Satellite Tracker", 0).show();
                    launchActivity2.getClass();
                    launchActivity2.startActivity(new Intent(launchActivity2, (Class<?>) SatelliteTrackerActivity.class));
                } else {
                    if (!str2.equals("Change Talkgroup (Existing Network)")) {
                        if (str2.equals("Activate new ROIP Session")) {
                            String str4 = launchActivity2.f5862A1;
                            String str5 = LaunchActivity.I1;
                            o3.x xVar = new o3.x();
                            xVar.f8985a = launchActivity2;
                            xVar.f8986b = "https://ur1.unifiedradios.com/api-ip";
                            xVar.f8987c = str5;
                            xVar.f8988d = str4;
                            xVar.f8989e = null;
                            xVar.f8984H = 1;
                            xVar.e();
                            xVar.i(new C0519j(22, this));
                            return;
                        }
                        if (!str2.equals("Brandmeister Multi-RX")) {
                            if (str2.equals("Switch to Last Heard TG:" + i6)) {
                                TextView textView5 = (TextView) launchActivity2.findViewById(R.id.activeFrequency);
                                TextView textView6 = (TextView) launchActivity2.findViewById(R.id.activeMemoryName);
                                TextView textView7 = (TextView) launchActivity2.findViewById(R.id.network);
                                try {
                                    if (i6 < 1 || i6 > 99999999) {
                                        Toast.makeText(launchActivity2, "⚠️ Please enter a valid talkgroup (1-99999999)", 1).show();
                                        return;
                                    }
                                    h4.c.U(launchActivity2, i6);
                                    String strY2 = h4.c.y(LaunchActivity.f5853D1);
                                    ProgressDialog progressDialog = new ProgressDialog(launchActivity2);
                                    launchActivity2.f5977y0 = progressDialog;
                                    progressDialog.setTitle("🔄 Establishing Connection");
                                    launchActivity2.f5977y0.setMessage("Please wait while we establish the link.");
                                    launchActivity2.f5977y0.setProgressStyle(0);
                                    launchActivity2.f5977y0.setCancelable(false);
                                    launchActivity2.f5977y0.show();
                                    if (strY2 == null || !strY2.toLowerCase().contains("brandmeister")) {
                                        launchActivity2.f5915b1.f();
                                        launchActivity2.m0();
                                        final int i10 = 1;
                                        new Handler().postDelayed(new Runnable(this) { // from class: k3.v0

                                            /* renamed from: k, reason: collision with root package name */
                                            public final /* synthetic */ i3.k f8225k;

                                            {
                                                this.f8225k = this;
                                            }

                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                switch (i10) {
                                                    case 0:
                                                        LaunchActivity launchActivity3 = (LaunchActivity) this.f8225k.f7315f;
                                                        ProgressDialog progressDialog2 = launchActivity3.f5977y0;
                                                        if (progressDialog2 != null && progressDialog2.isShowing()) {
                                                            h4.c.f0(launchActivity3, false);
                                                            launchActivity3.f5977y0.dismiss();
                                                            break;
                                                        }
                                                        break;
                                                    default:
                                                        LaunchActivity launchActivity4 = (LaunchActivity) this.f8225k.f7315f;
                                                        ProgressDialog progressDialog3 = launchActivity4.f5977y0;
                                                        if (progressDialog3 != null && progressDialog3.isShowing()) {
                                                            launchActivity4.f5977y0.dismiss();
                                                            break;
                                                        }
                                                        break;
                                                }
                                            }
                                        }, 2000L);
                                    } else {
                                        launchActivity2.f5915b1.subscribeTalkgroup(i6);
                                        launchActivity2.q0(i6);
                                        final int i11 = 0;
                                        new Handler().postDelayed(new Runnable(this) { // from class: k3.v0

                                            /* renamed from: k, reason: collision with root package name */
                                            public final /* synthetic */ i3.k f8225k;

                                            {
                                                this.f8225k = this;
                                            }

                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                switch (i11) {
                                                    case 0:
                                                        LaunchActivity launchActivity3 = (LaunchActivity) this.f8225k.f7315f;
                                                        ProgressDialog progressDialog2 = launchActivity3.f5977y0;
                                                        if (progressDialog2 != null && progressDialog2.isShowing()) {
                                                            h4.c.f0(launchActivity3, false);
                                                            launchActivity3.f5977y0.dismiss();
                                                            break;
                                                        }
                                                        break;
                                                    default:
                                                        LaunchActivity launchActivity4 = (LaunchActivity) this.f8225k.f7315f;
                                                        ProgressDialog progressDialog3 = launchActivity4.f5977y0;
                                                        if (progressDialog3 != null && progressDialog3.isShowing()) {
                                                            launchActivity4.f5977y0.dismiss();
                                                            break;
                                                        }
                                                        break;
                                                }
                                            }
                                        }, 1500L);
                                    }
                                    String str6 = "TG: " + i6;
                                    textView5.setText(str6);
                                    if (str6.length() > 8) {
                                        textView5.setTextSize(1, Math.max(Math.max(0.5f, 8.0f / str6.length()) * 60.0f, 24.0f));
                                    } else {
                                        textView5.setTextSize(1, 60.0f);
                                    }
                                    textView6.setText("Manual Entry");
                                    h4.c.b0(launchActivity2, "Manual Entry");
                                    h4.c.a0(launchActivity2, str6);
                                    textView7.setText(h4.c.y(launchActivity2) + " - " + h4.c.z(launchActivity2));
                                    StringBuilder sb2 = new StringBuilder("✅ Connecting to TG ");
                                    sb2.append(i6);
                                    q2.k kVarG2 = q2.k.g(null, launchActivity2.findViewById(android.R.id.content), sb2.toString(), -1);
                                    kVarG2.h(C.d.a(launchActivity2, R.color.accent_green));
                                    kVarG2.i(-1);
                                    kVarG2.j();
                                    return;
                                } catch (Exception e7) {
                                    throw new RuntimeException(e7);
                                }
                            }
                            return;
                        }
                        String string = h4.c.C(launchActivity2).getString("dmr_network", "");
                        L.h hVar3 = new L.h(launchActivity2, R.style.Base_Theme_Material3_Dark_Dialog);
                        String strL = AbstractC0535a.l("📡 Switch your ", string, " Talkgroups");
                        C0467d c0467d3 = (C0467d) hVar3.f1522d;
                        c0467d3.f6292d = strL;
                        LinearLayout linearLayout = new LinearLayout(launchActivity2);
                        linearLayout.setOrientation(1);
                        linearLayout.setPadding(48, 32, 48, 32);
                        GradientDrawable gradientDrawable = new GradientDrawable();
                        gradientDrawable.setColors(new int[]{Color.parseColor("#1A1F2E"), Color.parseColor("#252A3A")});
                        gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
                        gradientDrawable.setCornerRadius(24.0f);
                        linearLayout.setBackground(new ColorDrawable(Color.parseColor("#000000")));
                        LinearLayout linearLayout2 = new LinearLayout(launchActivity2);
                        linearLayout2.setOrientation(0);
                        linearLayout2.setGravity(16);
                        linearLayout2.setPadding(0, 0, 0, 24);
                        TextView textView8 = new TextView(launchActivity2);
                        textView8.setText("🌐");
                        textView8.setTextSize(28.0f);
                        textView8.setPadding(0, 0, 16, 0);
                        linearLayout2.addView(textView8);
                        TextView textView9 = new TextView(launchActivity2);
                        textView9.setText("Enter your destination talkgroups (comma-separated)");
                        textView9.setTextColor(Color.parseColor("#B0FFFFFF"));
                        textView9.setTextSize(16.0f);
                        linearLayout2.addView(textView9);
                        linearLayout.addView(linearLayout2);
                        EditText editText8 = new EditText(launchActivity2);
                        editText8.setInputType(2);
                        editText8.setKeyListener(DigitsKeyListener.getInstance("0123456789,"));
                        editText8.setHint("e.g. 91,3100,312700");
                        editText8.setHintTextColor(Color.parseColor("#6B7280"));
                        editText8.setTextColor(-1);
                        editText8.setTextSize(24.0f);
                        editText8.setTypeface(Typeface.MONOSPACE, 1);
                        editText8.setGravity(17);
                        editText8.setPadding(32, 24, 32, 24);
                        String strTrim = launchActivity2.getSharedPreferences("AppPrefs", 0).getString("saved_talkgroups", "").replace("[", "").replace("]", "").replaceAll("\\s+", "").trim();
                        if (strTrim.isEmpty()) {
                            editText8.setText(String.valueOf(h4.c.l(launchActivity2)));
                            editText8.selectAll();
                        } else {
                            editText8.setText(strTrim);
                            editText8.setSelection(strTrim.length());
                        }
                        GradientDrawable gradientDrawable2 = new GradientDrawable();
                        gradientDrawable2.setColor(Color.parseColor("#252A3A"));
                        gradientDrawable2.setCornerRadius(16.0f);
                        gradientDrawable2.setStroke(2, Color.parseColor("#FFD700"));
                        editText8.setBackground(gradientDrawable2);
                        linearLayout.addView(editText8);
                        TextView textView10 = new TextView(launchActivity2);
                        textView10.setText("CURRENT TALKGROUP: TG " + h4.c.l(launchActivity2));
                        textView10.setTextColor(Color.parseColor("#4CAF50"));
                        textView10.setTextSize(14.0f);
                        textView10.setGravity(1);
                        textView10.setPadding(0, 24, 0, 0);
                        linearLayout.addView(textView10);
                        TextView textView11 = new TextView(launchActivity2);
                        textView11.setText("Network: " + string);
                        textView11.setTextColor(Color.parseColor("#B0FFFFFF"));
                        textView11.setTextSize(12.0f);
                        textView11.setGravity(1);
                        textView11.setPadding(0, 16, 0, 0);
                        linearLayout.addView(textView11);
                        c0467d3.f6304s = linearLayout;
                        hVar3.e("🚀 Connect", new DialogInterfaceOnClickListenerC0517h(launchActivity2, 6, editText8));
                        hVar3.c("✖️ Cancel", new DialogInterfaceOnClickListenerC0516g(8));
                        DialogC0469f dialogC0469fB = hVar3.b();
                        if (dialogC0469fB.getWindow() != null) {
                            Window window = dialogC0469fB.getWindow();
                            window.setBackgroundDrawableResource(android.R.color.black);
                            window.getAttributes().windowAnimations = android.R.style.Animation.Dialog;
                            window.setFlags(4, 4);
                            window.getAttributes().dimAmount = 0.7f;
                        }
                        dialogC0469fB.show();
                        C0468e c0468e = dialogC0469fB.h;
                        Button button = c0468e.f6326k;
                        Button button2 = c0468e.f6329o;
                        if (button != null) {
                            button.setTextColor(Color.parseColor("#4CAF50"));
                            button.setTypeface(Typeface.DEFAULT_BOLD);
                            GradientDrawable gradientDrawable3 = new GradientDrawable();
                            gradientDrawable3.setColor(Color.parseColor("#1A4CAF50"));
                            gradientDrawable3.setCornerRadius(8.0f);
                            gradientDrawable3.setStroke(1, Color.parseColor("#4CAF50"));
                            button.setBackground(gradientDrawable3);
                        }
                        if (button2 != null) {
                            button2.setTextColor(Color.parseColor("#FF5252"));
                            button2.setTypeface(Typeface.DEFAULT_BOLD);
                            GradientDrawable gradientDrawable4 = new GradientDrawable();
                            gradientDrawable4.setColor(Color.parseColor("#1AFF5252"));
                            gradientDrawable4.setCornerRadius(8.0f);
                            gradientDrawable4.setStroke(1, Color.parseColor("#FF5252"));
                            button2.setBackground(gradientDrawable4);
                            return;
                        }
                        return;
                    }
                    launchActivity2.getClass();
                    String string2 = h4.c.C(launchActivity2).getString("dmr_network", "");
                    String strZ = h4.c.z(launchActivity2);
                    String str7 = LaunchActivity.I1;
                    o3.x xVar2 = new o3.x();
                    xVar2.f8985a = launchActivity2;
                    xVar2.f8986b = "https://ur1.unifiedradios.com/api-ip";
                    xVar2.f8987c = str7;
                    xVar2.f8988d = launchActivity2.f5862A1;
                    xVar2.f8989e = string2;
                    xVar2.f8984H = 2;
                    xVar2.e();
                    if (strZ != null && !strZ.isEmpty()) {
                        xVar2.f8983G = strZ;
                    }
                    xVar2.i(new X(launchActivity2));
                }
                return;
        }
    }

    public k(O o5, int i5, Context context) {
        this.f7312c = 2;
        this.f7315f = o5;
        this.f7314e = i5;
        this.f7313d = context;
    }
}
