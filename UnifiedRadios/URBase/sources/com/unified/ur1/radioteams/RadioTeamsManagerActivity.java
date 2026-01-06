package com.unified.ur1.radioteams;

import D0.f;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.datepicker.l;
import com.unified.ur1.R;
import com.unified.ur1.SatelliteTracker.h;
import com.unified.ur1.radioteams.RadioTeamsManagerActivity;
import e3.C0451e;
import e3.C0454h;
import f.AbstractActivityC0472i;
import f3.S;
import g0.AbstractC0535a;
import h4.c;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import l3.k;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class RadioTeamsManagerActivity extends AbstractActivityC0472i {

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f6026l = 0;

    /* renamed from: c, reason: collision with root package name */
    public TextView f6027c;

    /* renamed from: d, reason: collision with root package name */
    public ListView f6028d;

    /* renamed from: e, reason: collision with root package name */
    public Button f6029e;

    /* renamed from: f, reason: collision with root package name */
    public ProgressBar f6030f;
    public LinearLayout g;
    public ArrayList h;

    /* renamed from: i, reason: collision with root package name */
    public C0454h f6031i;

    /* renamed from: j, reason: collision with root package name */
    public ExecutorService f6032j;

    /* renamed from: k, reason: collision with root package name */
    public Handler f6033k;

    public static String l(String str, JSONObject jSONObject) {
        InputStream errorStream;
        Log.d("RadioTeamsManager", "=== API CALL DEBUG ===");
        Log.d("RadioTeamsManager", "Method: POST");
        Log.d("RadioTeamsManager", "Full URL: ".concat(str));
        Log.d("RadioTeamsManager", "Request data: " + jSONObject.toString());
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("User-Agent", "RadioTeams-Android-Manager/1.0");
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(15000);
        Log.d("RadioTeamsManager", "Connection configured - timeout: 15s");
        httpURLConnection.setDoOutput(true);
        Log.d("RadioTeamsManager", "Writing POST data...");
        OutputStream outputStream = httpURLConnection.getOutputStream();
        try {
            byte[] bytes = jSONObject.toString().getBytes("utf-8");
            outputStream.write(bytes, 0, bytes.length);
            Log.d("RadioTeamsManager", "POST data written: " + bytes.length + " bytes");
            outputStream.close();
            int responseCode = httpURLConnection.getResponseCode();
            AbstractC0535a.u("Response code: ", responseCode, "RadioTeamsManager");
            if (responseCode < 200 || responseCode >= 300) {
                errorStream = httpURLConnection.getErrorStream();
                Log.d("RadioTeamsManager", "Reading from error stream (error response)");
            } else {
                errorStream = httpURLConnection.getInputStream();
                Log.d("RadioTeamsManager", "Reading from input stream (success)");
            }
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(errorStream, "utf-8"));
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    sb.append(line.trim());
                } catch (Throwable th) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
            bufferedReader.close();
            String string = sb.toString();
            Log.d("RadioTeamsManager", "Raw response: " + string);
            Log.d("RadioTeamsManager", "Response length: " + string.length());
            if (string.isEmpty()) {
                Log.e("RadioTeamsManager", "Empty response received!");
                throw new Exception("Empty response from server");
            }
            if (string.startsWith("{") || string.startsWith("[")) {
                Log.d("RadioTeamsManager", "=== API CALL COMPLETE ===");
                return string;
            }
            Log.e("RadioTeamsManager", "Response is not JSON! Response: ".concat(string));
            throw new Exception("Invalid JSON response: ".concat(string));
        } catch (Throwable th3) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
            }
            throw th3;
        }
    }

    public final void j(k kVar) {
        StringBuilder sbH = h.h("RadioTeamsManager", "=== CONNECTING TO TEAM ===", "Team: ");
        sbH.append(kVar.f8423a);
        sbH.append(", Callsign: ");
        StringBuilder sbI = h.i(sbH, kVar.f8424b, "RadioTeamsManager", "Connecting to ");
        sbI.append(kVar.f8423a);
        sbI.append("...");
        Toast.makeText(this, sbI.toString(), 0).show();
        Intent intent = new Intent(this, (Class<?>) RadioTeamsActivity.class);
        intent.putExtra("team_id", kVar.f8423a);
        intent.putExtra("callsign", kVar.f8424b);
        intent.putExtra("auto_login", true);
        Log.d("RadioTeamsManager", "Starting RadioTeamsActivity with intent extras");
        startActivity(intent);
    }

    public final void k() {
        StringBuilder sbH = h.h("RadioTeamsManager", "=== DEBUG: Saved Teams State ===", "Total saved teams: ");
        sbH.append(this.h.size());
        Log.d("RadioTeamsManager", sbH.toString());
        for (int i5 = 0; i5 < this.h.size(); i5++) {
            k kVar = (k) this.h.get(i5);
            Log.d("RadioTeamsManager", String.format("Team %d: ID=%s, Callsign=%s, AutoConnect=%s", Integer.valueOf(i5), kVar.f8423a, kVar.f8424b, Boolean.valueOf(kVar.f8425c)));
        }
        AbstractC0535a.v("Raw SharedPreferences data: ", getSharedPreferences("RadioTeamsPrefs", 0).getString("saved_teams", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI), "RadioTeamsManager");
        Log.d("RadioTeamsManager", "ListView visibility: ".concat(this.f6028d.getVisibility() == 0 ? "VISIBLE" : "GONE"));
        Log.d("RadioTeamsManager", "NoTeams layout visibility: ".concat(this.g.getVisibility() == 0 ? "VISIBLE" : "GONE"));
        Log.d("RadioTeamsManager", "ListView child count: " + this.f6028d.getChildCount());
        Log.d("RadioTeamsManager", "Adapter count: " + this.f6031i.getCount());
    }

    public final void m() {
        Log.d("RadioTeamsManager", "=== SAVING TEAMS TO PREFERENCES ===");
        SharedPreferences sharedPreferences = getSharedPreferences("RadioTeamsPrefs", 0);
        JSONArray jSONArray = new JSONArray();
        Iterator it = this.h.iterator();
        while (it.hasNext()) {
            k kVar = (k) it.next();
            kVar.getClass();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("team_id", kVar.f8423a);
                jSONObject.put("callsign", kVar.f8424b);
                jSONObject.put("auto_connect", kVar.f8425c);
                jSONObject.put("last_checked", kVar.f8426d);
            } catch (JSONException e5) {
                Log.e("SavedTeam", "Error converting team to JSON", e5);
            }
            jSONArray.put(jSONObject);
            Log.d("RadioTeamsManager", "Added team to JSON: " + jSONObject.toString());
        }
        String string = jSONArray.toString();
        Log.d("RadioTeamsManager", "Final JSON to save: " + string);
        sharedPreferences.edit().putString("saved_teams", string).apply();
        Log.d("RadioTeamsManager", "Saved to preferences successfully");
    }

    public final void n() {
        StringBuilder sbH = h.h("RadioTeamsManager", "=== UPDATING UI ===", "Saved teams count: ");
        sbH.append(this.h.size());
        Log.d("RadioTeamsManager", sbH.toString());
        if (this.h.isEmpty()) {
            Log.d("RadioTeamsManager", "No teams - showing empty state");
            this.f6028d.setVisibility(8);
            this.g.setVisibility(0);
        } else {
            Log.d("RadioTeamsManager", "Has teams - showing list");
            this.f6028d.setVisibility(0);
            this.g.setVisibility(8);
        }
        StringBuilder sb = new StringBuilder("UI updated - ListView: ");
        sb.append(this.f6028d.getVisibility() == 0 ? "VISIBLE" : "GONE");
        sb.append(", NoTeams: ");
        h.q(sb, this.g.getVisibility() == 0 ? "VISIBLE" : "GONE", "RadioTeamsManager");
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, androidx.activity.ComponentActivity, B.i, android.app.Activity
    public final void onCreate(Bundle bundle) throws JSONException {
        super.onCreate(bundle);
        Log.d("RadioTeamsManager", "=== onCreate START ===");
        setContentView(R.layout.activity_radio_teams_manager);
        Log.d("RadioTeamsManager", "Layout set successfully");
        Log.d("RadioTeamsManager", "=== INITIALIZING COMPONENTS ===");
        this.f6027c = (TextView) findViewById(R.id.tvWelcome);
        this.f6028d = (ListView) findViewById(R.id.lvSavedTeams);
        this.f6029e = (Button) findViewById(R.id.btnAddTeam);
        this.f6030f = (ProgressBar) findViewById(R.id.progressBar);
        this.g = (LinearLayout) findViewById(R.id.layoutNoTeams);
        StringBuilder sb = new StringBuilder("UI components found: tvWelcome=");
        int i5 = 0;
        sb.append(this.f6027c != null);
        sb.append(", lvSavedTeams=");
        sb.append(this.f6028d != null);
        sb.append(", btnAddTeam=");
        sb.append(this.f6029e != null);
        sb.append(", progressBar=");
        sb.append(this.f6030f != null);
        sb.append(", layoutNoTeams=");
        sb.append(this.g != null);
        Log.d("RadioTeamsManager", sb.toString());
        this.h = new ArrayList();
        C0454h c0454h = new C0454h(this, i5, this.h, 4);
        this.f6031i = c0454h;
        this.f6028d.setAdapter((ListAdapter) c0454h);
        Log.d("RadioTeamsManager", "Adapter set, initial savedTeams size: " + this.h.size());
        this.f6027c.setText("Welcome to RadioTeams\nSelect a team to connect or add a new one");
        Log.d("RadioTeamsManager", "Components initialized successfully");
        Log.d("RadioTeamsManager", "=== SETTING UP EVENT LISTENERS ===");
        this.f6029e.setOnClickListener(new l(6, this));
        this.f6028d.setOnItemClickListener(new C0451e(this, 2));
        this.f6028d.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: l3.j
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public final boolean onItemLongClick(AdapterView adapterView, View view, int i6, long j5) {
                int i7 = RadioTeamsManagerActivity.f6026l;
                RadioTeamsManagerActivity radioTeamsManagerActivity = this.f8422a;
                radioTeamsManagerActivity.getClass();
                Log.d("RadioTeamsManager", "Team item long-clicked at position: " + i6);
                k kVar = (k) radioTeamsManagerActivity.h.get(i6);
                StringBuilder sbH = com.unified.ur1.SatelliteTracker.h.h("RadioTeamsManager", "=== SHOWING TEAM OPTIONS DIALOG ===", "Team: ");
                sbH.append(kVar.f8423a);
                sbH.append(" / ");
                com.unified.ur1.SatelliteTracker.h.q(sbH, kVar.f8424b, "RadioTeamsManager");
                String[] strArr = {"Connect", "Edit", "Remove", "Toggle Auto-Connect"};
                new AlertDialog.Builder(radioTeamsManagerActivity).setTitle(kVar.f8423a + " - " + kVar.f8424b).setItems(strArr, new S(radioTeamsManagerActivity, strArr, kVar, 5)).show();
                return true;
            }
        });
        Log.d("RadioTeamsManager", "Event listeners set up successfully");
        this.f6032j = Executors.newFixedThreadPool(2);
        this.f6033k = new Handler(Looper.getMainLooper());
        Log.d("RadioTeamsManager", "Background services initialized");
        Log.d("RadioTeamsManager", "=== LOADING SAVED TEAMS ===");
        String string = getSharedPreferences("RadioTeamsPrefs", 0).getString("saved_teams", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        Log.d("RadioTeamsManager", "Raw SharedPreferences JSON: " + string);
        Log.d("RadioTeamsManager", "JSON length: " + string.length());
        try {
            JSONArray jSONArray = new JSONArray(string);
            Log.d("RadioTeamsManager", "Parsed JSONArray length: " + jSONArray.length());
            this.h.clear();
            Log.d("RadioTeamsManager", "Cleared existing teams, size now: " + this.h.size());
            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i6);
                Log.d("RadioTeamsManager", "Processing team " + i6 + ": " + jSONObject.toString());
                k kVarA = k.a(jSONObject);
                Log.d("RadioTeamsManager", "Created team object: " + kVarA.f8423a + " / " + kVarA.f8424b);
                this.h.add(kVarA);
            }
            Log.d("RadioTeamsManager", "Final savedTeams size: " + this.h.size());
            this.f6031i.notifyDataSetChanged();
            Log.d("RadioTeamsManager", "Notified adapter of data change");
            n();
            Log.d("RadioTeamsManager", "Updated UI");
        } catch (JSONException e5) {
            Log.e("RadioTeamsManager", "Error loading saved teams", e5);
        }
        k();
        Log.d("RadioTeamsManager", "=== HANDLING LAUNCH PARAMETERS ===");
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String strH = c.h(this);
            boolean z4 = extras.getBoolean("auto_discover", false);
            Log.d("RadioTeamsManager", "Launch params - defaultCallsign: " + strH + ", autoDiscover: " + z4);
            if (strH != null && z4) {
                Log.d("RadioTeamsManager", "=== DISCOVERING TEAMS FOR USER: " + strH + " ===");
                this.f6032j.execute(new f(this, strH, this, 14));
            }
        } else {
            Log.d("RadioTeamsManager", "No launch parameters found");
        }
        Log.d("RadioTeamsManager", "=== onCreate END ===");
    }

    @Override // f.AbstractActivityC0472i, androidx.fragment.app.AbstractActivityC0230z, android.app.Activity
    public final void onDestroy() {
        Log.d("RadioTeamsManager", "=== onDestroy ===");
        super.onDestroy();
        ExecutorService executorService = this.f6032j;
        if (executorService != null) {
            executorService.shutdown();
        }
    }
}
