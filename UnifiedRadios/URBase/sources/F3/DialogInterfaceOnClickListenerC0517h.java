package f3;

import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.unified.ur1.R;
import com.unified.ur1.adapters.LastHeardActivity;
import com.unified.ur1.adapters.MemoryChannelActivity;
import com.unified.ur1.adapters.RepeaterMapActivity;
import com.unified.ur1.chat.ChatActivity;
import com.unified.ur1.inbox.Message;
import com.unified.ur1.primary.LaunchActivity;
import com.unified.ur1.radioteams.RadioTeamsActivity;
import com.unified.ur1.radioteams.RadioTeamsManagerActivity;
import com.unified.ur1.rfmodule.ROIP.DMRBridge;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import k3.RunnableC0672A;
import k3.RunnableC0704p;
import l3.C0749g;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: f3.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class DialogInterfaceOnClickListenerC0517h implements DialogInterface.OnClickListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6715c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f6716d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f6717e;

    public /* synthetic */ DialogInterfaceOnClickListenerC0517h(Object obj, int i5, Object obj2) {
        this.f6715c = i5;
        this.f6716d = obj;
        this.f6717e = obj2;
    }

    private final void a(DialogInterface dialogInterface, int i5) throws JSONException {
        View view = (View) this.f6717e;
        int i6 = RadioTeamsActivity.f6010u;
        RadioTeamsActivity radioTeamsActivity = (RadioTeamsActivity) this.f6716d;
        radioTeamsActivity.getClass();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("primary_role", RadioTeamsActivity.n((Spinner) view.findViewById(R.id.spinnerPrimaryRole)));
            jSONObject.put("organization", RadioTeamsActivity.n((Spinner) view.findViewById(R.id.spinnerOrganization)));
            jSONObject.put("ppe_level", RadioTeamsActivity.n((Spinner) view.findViewById(R.id.spinnerPPELevel)));
            jSONObject.put("vehicle_type", RadioTeamsActivity.n((Spinner) view.findViewById(R.id.spinnerVehicleType)));
            jSONObject.put("supply_days", RadioTeamsActivity.n((Spinner) view.findViewById(R.id.spinnerSupplyDays)));
            jSONObject.put("fcc_license", RadioTeamsActivity.n((Spinner) view.findViewById(R.id.spinnerFCCLicense)));
            jSONObject.put("ares_status", RadioTeamsActivity.n((Spinner) view.findViewById(R.id.spinnerARESStatus)));
            jSONObject.put("skywarn_status", RadioTeamsActivity.n((Spinner) view.findViewById(R.id.spinnerSkywarnStatus)));
            jSONObject.put("has_extra_fuel", RadioTeamsActivity.n((Spinner) view.findViewById(R.id.spinnerHasExtraFuel)));
            jSONObject.put("fuel_amount", RadioTeamsActivity.n((Spinner) view.findViewById(R.id.spinnerFuelAmount)));
            jSONObject.put("medical_limitations", RadioTeamsActivity.n((Spinner) view.findViewById(R.id.spinnerMedicalLimitations)));
            jSONObject.put("has_medication", "Yes".equals(RadioTeamsActivity.m((Spinner) view.findViewById(R.id.spinnerHasMedication))) ? 1 : 0);
            jSONObject.put("grol_license", "Yes".equals(RadioTeamsActivity.m((Spinner) view.findViewById(R.id.spinnerGROL))) ? 1 : 0);
            jSONObject.put("races_status", "Yes".equals(RadioTeamsActivity.m((Spinner) view.findViewById(R.id.spinnerRACES))) ? 1 : 0);
            jSONObject.put("auxcomm_status", "Yes".equals(RadioTeamsActivity.m((Spinner) view.findViewById(R.id.spinnerAUXCOMM))) ? 1 : 0);
            JSONArray jSONArray = new JSONArray();
            if (((CheckBox) view.findViewById(R.id.cbChainsaw)).isChecked()) {
                jSONArray.put("chainsaw");
            }
            if (((CheckBox) view.findViewById(R.id.cbHandTools)).isChecked()) {
                jSONArray.put("hand-tools");
            }
            if (((CheckBox) view.findViewById(R.id.cbFirstAid)).isChecked()) {
                jSONArray.put("first-aid");
            }
            if (((CheckBox) view.findViewById(R.id.cbAED)).isChecked()) {
                jSONArray.put("aed");
            }
            if (((CheckBox) view.findViewById(R.id.cbRopeRescue)).isChecked()) {
                jSONArray.put("rope-rescue");
            }
            if (((CheckBox) view.findViewById(R.id.cbGenerator)).isChecked()) {
                jSONArray.put("generator");
            }
            jSONObject.put("tools_gear", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            if (((CheckBox) view.findViewById(R.id.cbSatellitePhone)).isChecked()) {
                jSONArray2.put("satellite-phone");
            }
            if (((CheckBox) view.findViewById(R.id.cbSatelliteMessenger)).isChecked()) {
                jSONArray2.put("satellite-messenger");
            }
            if (((CheckBox) view.findViewById(R.id.cbCellularBooster)).isChecked()) {
                jSONArray2.put("cellular-booster");
            }
            if (((CheckBox) view.findViewById(R.id.cbCBRadio)).isChecked()) {
                jSONArray2.put("cb-radio");
            }
            if (((CheckBox) view.findViewById(R.id.cbGMRS)).isChecked()) {
                jSONArray2.put("gmrs");
            }
            if (((CheckBox) view.findViewById(R.id.cbInternetBackup)).isChecked()) {
                jSONArray2.put("internet-backup");
            }
            if (((CheckBox) view.findViewById(R.id.cbVHFRadio)).isChecked()) {
                jSONArray2.put("vhf-radio");
            }
            if (((CheckBox) view.findViewById(R.id.cbUHFRadio)).isChecked()) {
                jSONArray2.put("uhf-radio");
            }
            if (((CheckBox) view.findViewById(R.id.cbHFRadio)).isChecked()) {
                jSONArray2.put("hf-radio");
            }
            jSONObject.put("alt_communication", jSONArray2);
            JSONArray jSONArray3 = new JSONArray();
            if (((CheckBox) view.findViewById(R.id.cbWaterBottles)).isChecked()) {
                jSONArray3.put("bottles");
            }
            if (((CheckBox) view.findViewById(R.id.cbWaterBulk)).isChecked()) {
                jSONArray3.put("bulk-containers");
            }
            if (((CheckBox) view.findViewById(R.id.cbWaterPurification)).isChecked()) {
                jSONArray3.put("purification");
            }
            if (((CheckBox) view.findViewById(R.id.cbWaterStorage)).isChecked()) {
                jSONArray3.put("storage-tanks");
            }
            jSONObject.put("water_supplies", jSONArray3);
            JSONArray jSONArray4 = new JSONArray();
            if (((CheckBox) view.findViewById(R.id.cbFoodMREs)).isChecked()) {
                jSONArray4.put("mres");
            }
            if (((CheckBox) view.findViewById(R.id.cbFoodCanned)).isChecked()) {
                jSONArray4.put("canned-goods");
            }
            if (((CheckBox) view.findViewById(R.id.cbFoodDry)).isChecked()) {
                jSONArray4.put("dry-goods");
            }
            if (((CheckBox) view.findViewById(R.id.cbFoodCooking)).isChecked()) {
                jSONArray4.put("cooking-supplies");
            }
            if (((CheckBox) view.findViewById(R.id.cbFoodBulk)).isChecked()) {
                jSONArray4.put("bulk-food");
            }
            jSONObject.put("food_supplies", jSONArray4);
            JSONArray jSONArray5 = new JSONArray();
            if (((CheckBox) view.findViewById(R.id.cbShelterTarps)).isChecked()) {
                jSONArray5.put("tarps");
            }
            if (((CheckBox) view.findViewById(R.id.cbShelterTents)).isChecked()) {
                jSONArray5.put("tents");
            }
            if (((CheckBox) view.findViewById(R.id.cbShelterSleeping)).isChecked()) {
                jSONArray5.put("sleeping-gear");
            }
            if (((CheckBox) view.findViewById(R.id.cbShelterBlankets)).isChecked()) {
                jSONArray5.put("blankets");
            }
            if (((CheckBox) view.findViewById(R.id.cbShelterPortable)).isChecked()) {
                jSONArray5.put("portable-shelter");
            }
            jSONObject.put("shelter_supplies", jSONArray5);
            JSONArray jSONArray6 = new JSONArray();
            if (((CheckBox) view.findViewById(R.id.cbEC001)).isChecked()) {
                jSONArray6.put("ec001");
            }
            if (((CheckBox) view.findViewById(R.id.cbEC016)).isChecked()) {
                jSONArray6.put("ec016");
            }
            if (((CheckBox) view.findViewById(R.id.cbIS100)).isChecked()) {
                jSONArray6.put("is100");
            }
            if (((CheckBox) view.findViewById(R.id.cbIS200)).isChecked()) {
                jSONArray6.put("is200");
            }
            if (((CheckBox) view.findViewById(R.id.cbIS700)).isChecked()) {
                jSONArray6.put("is700");
            }
            if (((CheckBox) view.findViewById(R.id.cbIS800)).isChecked()) {
                jSONArray6.put("is800");
            }
            jSONObject.put("emcomm_training", jSONArray6);
            JSONArray jSONArray7 = new JSONArray();
            if (((CheckBox) view.findViewById(R.id.cbWinlink)).isChecked()) {
                jSONArray7.put("winlink");
            }
            if (((CheckBox) view.findViewById(R.id.cbAPRS)).isChecked()) {
                jSONArray7.put("aprs");
            }
            if (((CheckBox) view.findViewById(R.id.cbHFDigital)).isChecked()) {
                jSONArray7.put("hf-digital");
            }
            if (((CheckBox) view.findViewById(R.id.cbDMR)).isChecked()) {
                jSONArray7.put("dmr");
            }
            if (((CheckBox) view.findViewById(R.id.cbSatellite)).isChecked()) {
                jSONArray7.put("satellite");
            }
            if (((CheckBox) view.findViewById(R.id.cbMesh)).isChecked()) {
                jSONArray7.put("mesh");
            }
            if (((CheckBox) view.findViewById(R.id.cbMicrowave)).isChecked()) {
                jSONArray7.put("microwave");
            }
            if (((CheckBox) view.findViewById(R.id.cbAntennaModeling)).isChecked()) {
                jSONArray7.put("antenna-modeling");
            }
            jSONObject.put("specialized_skills", jSONArray7);
        } catch (JSONException e5) {
            Log.e("RadioTeamsActivity", "Error collecting profile data", e5);
        }
        radioTeamsActivity.f6023r.execute(new g3.k(radioTeamsActivity, 18, jSONObject));
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i5) throws Throwable {
        int i6 = 1;
        int i7 = 0;
        Object obj = this.f6717e;
        Object obj2 = this.f6716d;
        switch (this.f6715c) {
            case 0:
                B.j jVar = (B.j) obj2;
                jVar.getClass();
                String upperCase = ((EditText) obj).getText().toString().trim().toUpperCase();
                if (!upperCase.isEmpty()) {
                    jVar.execute(upperCase);
                    break;
                }
                break;
            case 1:
                int i8 = LastHeardActivity.f5664i;
                LastHeardActivity lastHeardActivity = (LastHeardActivity) obj2;
                lastHeardActivity.getClass();
                lastHeardActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.qrz.com/db/" + ((C0525p) obj).f6774a)));
                break;
            case 2:
                int i9 = MemoryChannelActivity.f5681l;
                MemoryChannelActivity memoryChannelActivity = (MemoryChannelActivity) obj2;
                memoryChannelActivity.getClass();
                Log.d("Unified - MemoryChannel", "User clicked YES - attempting to save channel settings");
                ProgressDialog progressDialog = new ProgressDialog(memoryChannelActivity);
                progressDialog.setMessage("Please Wait!");
                progressDialog.setCancelable(false);
                progressDialog.show();
                View viewFindViewById = memoryChannelActivity.findViewById(R.id.waiting);
                if (viewFindViewById != null) {
                    viewFindViewById.setVisibility(0);
                    Log.d("Unified - MemoryChannel", "Wait layout found and shown");
                } else {
                    Log.d("Unified - MemoryChannel", "Wait layout not found in this activity, using progress dialog only");
                }
                new Handler(Looper.getMainLooper()).postDelayed(new RunnableC0534z(memoryChannelActivity, (C0532x) obj, progressDialog, i7), 50L);
                break;
            case 3:
                f0 f0Var = (f0) obj2;
                Context context = f0Var.f6710b;
                try {
                    Log.d("Unified - RepeaterDir", "=== Starting Repeater Programming Process ===");
                    DMRBridge dMRBridgeJ = DMRBridge.j(context);
                    boolean zIsSocketConnected = dMRBridgeJ.isSocketConnected();
                    Log.d("Unified - RepeaterDir", "Current ROIP status: ".concat(zIsSocketConnected ? "Connected" : "Disconnected"));
                    m0 m0Var = (m0) obj;
                    if (zIsSocketConnected) {
                        Log.d("Unified - RepeaterDir", "Disconnecting from ROIP before programming repeater...");
                        ProgressDialog progressDialog2 = new ProgressDialog(context);
                        progressDialog2.setMessage("Disconnecting from network...");
                        progressDialog2.setCancelable(false);
                        progressDialog2.show();
                        new Thread(new U(f0Var, dMRBridgeJ, progressDialog2, m0Var, context)).start();
                    } else {
                        Log.d("Unified - RepeaterDir", "No ROIP connection, proceeding with repeater programming");
                        f0Var.a(m0Var, context);
                    }
                    break;
                } catch (Exception e5) {
                    StringBuilder sbG = com.unified.ur1.SatelliteTracker.h.g("Unified - RepeaterDir", "Error starting repeater programming process", e5, "Error programming repeater: ");
                    sbG.append(e5.getMessage());
                    Toast.makeText(context, sbG.toString(), 1).show();
                    return;
                }
            case 4:
                RepeaterMapActivity repeaterMapActivity = (RepeaterMapActivity) obj2;
                d4.b bVar = repeaterMapActivity.f5705d;
                if (bVar != null) {
                    m0 m0Var2 = (m0) obj;
                    ((l4.f) bVar).c(new k4.d(m0Var2.n, m0Var2.f6756o));
                    ((l4.f) repeaterMapActivity.f5705d).d(15.0d);
                    repeaterMapActivity.f5704c.invalidate();
                    break;
                }
                break;
            case 5:
                int i10 = ChatActivity.f5725L;
                ChatActivity chatActivity = (ChatActivity) obj2;
                if (i5 == 0) {
                    ((ClipboardManager) chatActivity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("Message", ((Message) obj).getMessageBody()));
                    Toast.makeText(chatActivity, "Message copied", 0).show();
                    break;
                } else {
                    chatActivity.getClass();
                    if (i5 == 1) {
                        Toast.makeText(chatActivity, "Delete feature coming soon", 0).show();
                        break;
                    }
                }
                break;
            case 6:
                Context context2 = LaunchActivity.f5853D1;
                LaunchActivity launchActivity = (LaunchActivity) obj2;
                launchActivity.getClass();
                String strTrim = ((EditText) obj).getText().toString().trim();
                String[] strArrSplit = strTrim.split(",");
                ArrayList arrayList = new ArrayList();
                HashSet hashSet = new HashSet();
                for (String str : strArrSplit) {
                    String strTrim2 = str.trim();
                    try {
                        int i11 = Integer.parseInt(strTrim2);
                        if (i11 < 1 || i11 > 99999999) {
                            hashSet.add(strTrim2);
                        } else {
                            arrayList.add(Integer.valueOf(i11));
                        }
                    } catch (NumberFormatException unused) {
                        hashSet.add(strTrim2);
                    }
                }
                if (arrayList.isEmpty()) {
                    Toast.makeText(launchActivity, "❌ No valid talkgroups entered.", 1).show();
                    break;
                } else {
                    if (!hashSet.isEmpty()) {
                        Toast.makeText(launchActivity, "⚠️ Skipped invalid TG(s): " + TextUtils.join(", ", hashSet), 1).show();
                    }
                    SharedPreferences.Editor editorEdit = launchActivity.getSharedPreferences("AppPrefs", 0).edit();
                    editorEdit.putString("saved_talkgroups", strTrim);
                    editorEdit.apply();
                    h4.c.U(launchActivity, ((Integer) arrayList.get(0)).intValue());
                    String strY = h4.c.y(launchActivity);
                    ProgressDialog progressDialog3 = new ProgressDialog(launchActivity);
                    launchActivity.f5977y0 = progressDialog3;
                    progressDialog3.setTitle("🔄 Establishing Connection");
                    launchActivity.f5977y0.setMessage("Please wait while we connect to TG(s)...");
                    launchActivity.f5977y0.setProgressStyle(0);
                    launchActivity.f5977y0.setCancelable(false);
                    launchActivity.f5977y0.show();
                    if (strY == null || !strY.toLowerCase().contains("brandmeister")) {
                        launchActivity.f5915b1.f();
                        launchActivity.m0();
                        new Handler().postDelayed(new RunnableC0672A(launchActivity, 5), 2000L);
                    } else {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            launchActivity.f5915b1.subscribeTalkgroup(((Integer) it.next()).intValue());
                        }
                        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
                        executorServiceNewSingleThreadExecutor.execute(new RunnableC0704p(launchActivity, arrayList, i6));
                        executorServiceNewSingleThreadExecutor.shutdown();
                        new Handler().postDelayed(new RunnableC0672A(launchActivity, 4), 1500L);
                    }
                    TextView textView = (TextView) launchActivity.findViewById(R.id.activeFrequency);
                    TextView textView2 = (TextView) launchActivity.findViewById(R.id.activeMemoryName);
                    String strJoin = TextUtils.join(", ", arrayList);
                    textView.setText("TG: " + strJoin);
                    textView.setTextSize(1, Math.max(Math.max(0.5f, 8.0f / ((float) strJoin.length())) * 60.0f, 24.0f));
                    textView2.setText("Manual Entry");
                    h4.c.b0(launchActivity, "Manual Entry");
                    h4.c.a0(launchActivity, strJoin);
                    q2.k kVarG = q2.k.g(null, launchActivity.findViewById(android.R.id.content), "✅ Connecting to TG(s) " + launchActivity.f5921e, -1);
                    kVarG.h(C.d.a(launchActivity, R.color.accent_green));
                    kVarG.i(-1);
                    kVarG.j();
                    break;
                }
                break;
            case 7:
                Context context3 = LaunchActivity.f5853D1;
                ((LaunchActivity) obj2).a0((String) obj);
                break;
            case 8:
                RadioTeamsActivity radioTeamsActivity = (RadioTeamsActivity) obj2;
                if (radioTeamsActivity.g != null) {
                    C0749g c0749g = (C0749g) obj;
                    if (radioTeamsActivity.f6022q.containsKey(c0749g.f8404a)) {
                        ((l4.f) radioTeamsActivity.g).c(new k4.d(c0749g.f8405b, c0749g.f8406c));
                        ((l4.f) radioTeamsActivity.g).d(15.0d);
                        radioTeamsActivity.f6014f.invalidate();
                        break;
                    }
                }
                break;
            case 9:
                a(dialogInterface, i5);
                break;
            default:
                int i12 = RadioTeamsManagerActivity.f6026l;
                RadioTeamsManagerActivity radioTeamsManagerActivity = (RadioTeamsManagerActivity) obj2;
                radioTeamsManagerActivity.getClass();
                Log.d("RadioTeamsManager", "User confirmed team removal");
                StringBuilder sb = new StringBuilder("Removing ");
                l3.k kVar = (l3.k) obj;
                sb.append(kVar.f8423a);
                sb.append("...");
                Toast.makeText(radioTeamsManagerActivity, sb.toString(), 0).show();
                radioTeamsManagerActivity.f6032j.execute(new g3.k(radioTeamsManagerActivity, 19, kVar));
                break;
        }
    }
}
