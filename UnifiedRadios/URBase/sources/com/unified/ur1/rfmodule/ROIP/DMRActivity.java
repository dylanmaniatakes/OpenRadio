package com.unified.ur1.rfmodule.ROIP;

import C.h;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.unified.ur1.R;
import com.unified.ur1.rfmodule.ROIP.DMRActivity;
import com.unified.ur1.rfmodule.ROIP.DMRBridge;
import f.AbstractActivityC0472i;
import j0.RunnableC0588a;
import java.io.File;
import m3.o;
import o3.RunnableC0813b;
import o3.ViewOnTouchListenerC0815d;
import o3.e;
import o3.k;

/* loaded from: classes.dex */
public class DMRActivity extends AbstractActivityC0472i implements k {

    /* renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f6054s = 0;

    /* renamed from: c, reason: collision with root package name */
    public TextView f6055c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f6056d;

    /* renamed from: e, reason: collision with root package name */
    public Button f6057e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f6058f;
    public EditText g;
    public Spinner h;

    /* renamed from: i, reason: collision with root package name */
    public Spinner f6059i;

    /* renamed from: j, reason: collision with root package name */
    public EditText f6060j;

    /* renamed from: k, reason: collision with root package name */
    public EditText f6061k;

    /* renamed from: l, reason: collision with root package name */
    public Button f6062l;

    /* renamed from: m, reason: collision with root package name */
    public Button f6063m;
    public Button n;

    /* renamed from: o, reason: collision with root package name */
    public DMRBridge f6064o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f6065p = false;

    /* renamed from: q, reason: collision with root package name */
    public boolean f6066q = false;

    /* renamed from: r, reason: collision with root package name */
    public int f6067r = 91;

    @Override // o3.k
    public final void a(int i5, int i6, int i7) {
        Log.d("DMRActivity", "DMR packet received from " + i5 + " to " + i6 + ", type: " + i7);
    }

    @Override // o3.k
    public final void b(int i5) {
        runOnUiThread(new o(2, this));
    }

    @Override // o3.k
    public final void c(int i5, String str, int i6) {
        Intent intent = new Intent("com.unified.ur1.ROIP_CALL_STARTED");
        intent.putExtra("srcId", i5);
        intent.putExtra("callsign", str);
        sendBroadcast(intent);
        runOnUiThread(new RunnableC0588a(this, str, i5, 4));
    }

    @Override // o3.k
    public final void d(boolean z4) {
        this.f6065p = z4;
        runOnUiThread(new RunnableC0813b(this, z4, 1));
    }

    @Override // o3.k
    public final void e(boolean z4) {
        this.f6066q = z4;
        runOnUiThread(new RunnableC0813b(this, z4, 0));
    }

    public final void j() {
        Button button = this.f6063m;
        if (button != null) {
            button.setEnabled(false);
        }
        Button button2 = this.f6062l;
        if (button2 != null) {
            button2.setEnabled(false);
        }
        Button button3 = this.n;
        if (button3 != null) {
            button3.setEnabled(false);
        }
        Button button4 = this.f6057e;
        if (button4 != null) {
            button4.setEnabled(false);
        }
        EditText editText = this.g;
        if (editText != null) {
            editText.setEnabled(false);
        }
        Spinner spinner = this.h;
        if (spinner != null) {
            spinner.setEnabled(false);
        }
        Spinner spinner2 = this.f6059i;
        if (spinner2 != null) {
            spinner2.setEnabled(false);
        }
        EditText editText2 = this.f6060j;
        if (editText2 != null) {
            editText2.setEnabled(false);
        }
        EditText editText3 = this.f6061k;
        if (editText3 != null) {
            editText3.setEnabled(false);
        }
        TextView textView = this.f6055c;
        if (textView != null) {
            textView.setText("Not available");
        }
    }

    public final void k() {
        Button button = this.f6057e;
        if (button != null) {
            button.setOnTouchListener(new ViewOnTouchListenerC0815d(0, this));
        }
        EditText editText = this.g;
        if (editText != null) {
            editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: o3.c
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView, int i5, KeyEvent keyEvent) throws NumberFormatException {
                    int i6 = DMRActivity.f6054s;
                    DMRActivity dMRActivity = this.f8918a;
                    dMRActivity.getClass();
                    if (i5 != 6) {
                        return false;
                    }
                    try {
                        int i7 = Integer.parseInt(textView.getText().toString().trim());
                        if (dMRActivity.f6065p) {
                            dMRActivity.f6064o.setTalkgroup(i7);
                            dMRActivity.f6067r = i7;
                            Toast.makeText(dMRActivity, "Talkgroup set to " + i7, 0).show();
                        }
                    } catch (NumberFormatException unused) {
                        Toast.makeText(dMRActivity, "Invalid talkgroup number", 0).show();
                    }
                    return true;
                }
            });
        }
        Spinner spinner = this.h;
        if (spinner != null) {
            spinner.setOnItemSelectedListener(new e(this, 0));
        }
        Spinner spinner2 = this.f6059i;
        if (spinner2 != null) {
            spinner2.setOnItemSelectedListener(new e(this, 1));
        }
        Button button2 = this.f6063m;
        if (button2 != null) {
            final int i5 = 1;
            button2.setOnClickListener(new View.OnClickListener(this) { // from class: o3.a

                /* renamed from: d, reason: collision with root package name */
                public final /* synthetic */ DMRActivity f8914d;

                {
                    this.f8914d = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws Throwable {
                    EditText editText2;
                    boolean zD;
                    switch (i5) {
                        case 0:
                            DMRActivity dMRActivity = this.f8914d;
                            if (!dMRActivity.f6065p && (editText2 = dMRActivity.f6060j) != null && dMRActivity.f6061k != null) {
                                String strTrim = editText2.getText().toString().trim();
                                String strTrim2 = dMRActivity.f6061k.getText().toString().trim();
                                if (strTrim.isEmpty()) {
                                    Toast.makeText(dMRActivity, "Please enter a server address", 0).show();
                                    break;
                                } else {
                                    try {
                                        int i6 = Integer.parseInt(strTrim2);
                                        Spinner spinner3 = dMRActivity.h;
                                        if (spinner3 != null) {
                                            spinner3.getSelectedItemPosition();
                                        }
                                        Spinner spinner4 = dMRActivity.f6059i;
                                        if (spinner4 != null) {
                                            spinner4.getSelectedItemPosition();
                                        }
                                        if (!dMRActivity.f6064o.connect(new DMRBridge.DMRConnectionParams())) {
                                            Toast.makeText(dMRActivity, "Failed to connect to ".concat(strTrim), 0).show();
                                            break;
                                        } else {
                                            Toast.makeText(dMRActivity, "Connecting to " + strTrim + ":" + i6, 0).show();
                                            try {
                                                dMRActivity.f6067r = Integer.parseInt(dMRActivity.g.getText().toString().trim());
                                            } catch (NumberFormatException unused) {
                                                Log.w("DMRActivity", "Invalid talkgroup value, using default");
                                            }
                                            dMRActivity.f6064o.setTalkgroup(dMRActivity.f6067r);
                                            dMRActivity.m(true);
                                            break;
                                        }
                                    } catch (NumberFormatException unused2) {
                                        Toast.makeText(dMRActivity, "Invalid port number", 0).show();
                                        return;
                                    }
                                }
                            }
                            break;
                        default:
                            DMRActivity dMRActivity2 = this.f8914d;
                            if (dMRActivity2.f6065p) {
                                dMRActivity2.f6063m.setText("Connected");
                                break;
                            } else {
                                try {
                                    Log.d("DMRActivity", "Connect button clicked - starting connection with hardcoded parameters");
                                    Toast.makeText(dMRActivity2, "Connecting to DMR network...", 0).show();
                                    DMRBridge dMRBridge = dMRActivity2.f6064o;
                                    dMRBridge.getClass();
                                    try {
                                        Log.d("DMRBridge", "Connecting with hardcoded parameters");
                                        zD = dMRBridge.d();
                                    } catch (Exception e5) {
                                        Log.e("DMRBridge", "Exception during connect", e5);
                                        zD = false;
                                    }
                                    if (!zD) {
                                        Log.e("DMRActivity", "Connection failed");
                                        Log.d("DMRActivity", "Connection diagnosis: " + dMRActivity2.f6064o.getDetailedConnectionStatus());
                                        Toast.makeText(dMRActivity2, "Failed to connect - check logs for details", 0).show();
                                        dMRActivity2.m(false);
                                        break;
                                    } else {
                                        ((Button) dMRActivity2.findViewById(R.id.connect_button)).setText("Connected");
                                        Log.d("DMRActivity", "Connection established successfully");
                                        Toast.makeText(dMRActivity2, "Connected to DMR network", 0).show();
                                        y1.f.f();
                                        try {
                                            Log.d("DMRActivity", "Setting current talkgroup");
                                            dMRActivity2.f6067r = Integer.parseInt(dMRActivity2.g.getText().toString().trim());
                                            Log.d("DMRActivity", "Using talkgroup: " + dMRActivity2.f6067r);
                                            dMRActivity2.f6064o.setTalkgroup(dMRActivity2.f6067r);
                                            Log.d("DMRActivity", "Talkgroup set successfully");
                                            break;
                                        } catch (Exception e6) {
                                            Log.e("DMRActivity", "Error setting talkgroup", e6);
                                            return;
                                        }
                                    }
                                } catch (Exception e7) {
                                    StringBuilder sbG = com.unified.ur1.SatelliteTracker.h.g("DMRActivity", "Exception during connect", e7, "Exception during connect: ");
                                    sbG.append(e7.getMessage());
                                    Toast.makeText(dMRActivity2, sbG.toString(), 1).show();
                                    return;
                                }
                            }
                    }
                }
            });
        }
        Button button3 = this.f6062l;
        if (button3 != null) {
            final int i6 = 0;
            button3.setOnClickListener(new View.OnClickListener(this) { // from class: o3.a

                /* renamed from: d, reason: collision with root package name */
                public final /* synthetic */ DMRActivity f8914d;

                {
                    this.f8914d = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws Throwable {
                    EditText editText2;
                    boolean zD;
                    switch (i6) {
                        case 0:
                            DMRActivity dMRActivity = this.f8914d;
                            if (!dMRActivity.f6065p && (editText2 = dMRActivity.f6060j) != null && dMRActivity.f6061k != null) {
                                String strTrim = editText2.getText().toString().trim();
                                String strTrim2 = dMRActivity.f6061k.getText().toString().trim();
                                if (strTrim.isEmpty()) {
                                    Toast.makeText(dMRActivity, "Please enter a server address", 0).show();
                                    break;
                                } else {
                                    try {
                                        int i62 = Integer.parseInt(strTrim2);
                                        Spinner spinner3 = dMRActivity.h;
                                        if (spinner3 != null) {
                                            spinner3.getSelectedItemPosition();
                                        }
                                        Spinner spinner4 = dMRActivity.f6059i;
                                        if (spinner4 != null) {
                                            spinner4.getSelectedItemPosition();
                                        }
                                        if (!dMRActivity.f6064o.connect(new DMRBridge.DMRConnectionParams())) {
                                            Toast.makeText(dMRActivity, "Failed to connect to ".concat(strTrim), 0).show();
                                            break;
                                        } else {
                                            Toast.makeText(dMRActivity, "Connecting to " + strTrim + ":" + i62, 0).show();
                                            try {
                                                dMRActivity.f6067r = Integer.parseInt(dMRActivity.g.getText().toString().trim());
                                            } catch (NumberFormatException unused) {
                                                Log.w("DMRActivity", "Invalid talkgroup value, using default");
                                            }
                                            dMRActivity.f6064o.setTalkgroup(dMRActivity.f6067r);
                                            dMRActivity.m(true);
                                            break;
                                        }
                                    } catch (NumberFormatException unused2) {
                                        Toast.makeText(dMRActivity, "Invalid port number", 0).show();
                                        return;
                                    }
                                }
                            }
                            break;
                        default:
                            DMRActivity dMRActivity2 = this.f8914d;
                            if (dMRActivity2.f6065p) {
                                dMRActivity2.f6063m.setText("Connected");
                                break;
                            } else {
                                try {
                                    Log.d("DMRActivity", "Connect button clicked - starting connection with hardcoded parameters");
                                    Toast.makeText(dMRActivity2, "Connecting to DMR network...", 0).show();
                                    DMRBridge dMRBridge = dMRActivity2.f6064o;
                                    dMRBridge.getClass();
                                    try {
                                        Log.d("DMRBridge", "Connecting with hardcoded parameters");
                                        zD = dMRBridge.d();
                                    } catch (Exception e5) {
                                        Log.e("DMRBridge", "Exception during connect", e5);
                                        zD = false;
                                    }
                                    if (!zD) {
                                        Log.e("DMRActivity", "Connection failed");
                                        Log.d("DMRActivity", "Connection diagnosis: " + dMRActivity2.f6064o.getDetailedConnectionStatus());
                                        Toast.makeText(dMRActivity2, "Failed to connect - check logs for details", 0).show();
                                        dMRActivity2.m(false);
                                        break;
                                    } else {
                                        ((Button) dMRActivity2.findViewById(R.id.connect_button)).setText("Connected");
                                        Log.d("DMRActivity", "Connection established successfully");
                                        Toast.makeText(dMRActivity2, "Connected to DMR network", 0).show();
                                        y1.f.f();
                                        try {
                                            Log.d("DMRActivity", "Setting current talkgroup");
                                            dMRActivity2.f6067r = Integer.parseInt(dMRActivity2.g.getText().toString().trim());
                                            Log.d("DMRActivity", "Using talkgroup: " + dMRActivity2.f6067r);
                                            dMRActivity2.f6064o.setTalkgroup(dMRActivity2.f6067r);
                                            Log.d("DMRActivity", "Talkgroup set successfully");
                                            break;
                                        } catch (Exception e6) {
                                            Log.e("DMRActivity", "Error setting talkgroup", e6);
                                            return;
                                        }
                                    }
                                } catch (Exception e7) {
                                    StringBuilder sbG = com.unified.ur1.SatelliteTracker.h.g("DMRActivity", "Exception during connect", e7, "Exception during connect: ");
                                    sbG.append(e7.getMessage());
                                    Toast.makeText(dMRActivity2, sbG.toString(), 1).show();
                                    return;
                                }
                            }
                    }
                }
            });
        }
        m(false);
    }

    public final void l(boolean z4) {
        Button button = this.f6057e;
        if (button != null) {
            if (z4) {
                button.setBackgroundResource(R.drawable.ptt_active_background);
                this.f6057e.setText("TX");
            } else {
                button.setBackgroundResource(R.drawable.ptt_inactive_background);
                this.f6057e.setText("PTT");
            }
        }
    }

    public final void m(boolean z4) {
        TextView textView = this.f6055c;
        if (textView != null) {
            textView.setText(z4 ? "Connected" : "Disconnected");
        }
        TextView textView2 = this.f6056d;
        if (textView2 != null) {
            if (z4) {
                this.f6056d.setText(this.f6060j.getText().toString().trim());
            } else {
                textView2.setText("");
            }
        }
        TextView textView3 = this.f6058f;
        if (textView3 != null) {
            textView3.setVisibility(z4 ? 0 : 4);
            this.f6058f.setText("");
        }
        Button button = this.f6063m;
        if (button != null) {
            button.setEnabled(!z4);
        }
        Button button2 = this.f6062l;
        if (button2 != null) {
            button2.setEnabled(!z4);
        }
        Button button3 = this.n;
        if (button3 != null) {
            button3.setEnabled(z4);
        }
        Button button4 = this.f6057e;
        if (button4 != null) {
            button4.setEnabled(z4);
        }
        EditText editText = this.g;
        if (editText != null) {
            editText.setEnabled(z4);
        }
        Spinner spinner = this.h;
        if (spinner != null) {
            spinner.setEnabled(z4);
        }
        Spinner spinner2 = this.f6059i;
        if (spinner2 != null) {
            spinner2.setEnabled(z4);
        }
        EditText editText2 = this.f6060j;
        if (editText2 != null) {
            editText2.setEnabled(!z4);
        }
        EditText editText3 = this.f6061k;
        if (editText3 != null) {
            editText3.setEnabled(!z4);
        }
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, androidx.activity.ComponentActivity, B.i, android.app.Activity
    public final void onCreate(Bundle bundle) throws InterruptedException {
        super.onCreate(bundle);
        setContentView(R.layout.activity_dmr);
        DMRBridge dMRBridgeJ = DMRBridge.j(this);
        if (!dMRBridgeJ.f6072c) {
            dMRBridgeJ.m();
        }
        this.f6055c = (TextView) findViewById(R.id.connection_status_text);
        this.f6056d = (TextView) findViewById(R.id.server_info);
        this.f6057e = (Button) findViewById(R.id.ptt_button);
        this.f6058f = (TextView) findViewById(R.id.current_speaker);
        this.g = (EditText) findViewById(R.id.talkgroup_edit);
        this.h = (Spinner) findViewById(R.id.color_code_spinner);
        this.f6059i = (Spinner) findViewById(R.id.timeslot_spinner);
        this.f6060j = (EditText) findViewById(R.id.server_address_edit);
        this.f6061k = (EditText) findViewById(R.id.server_port_edit);
        this.f6062l = (Button) findViewById(R.id.custom_connect_button);
        this.f6063m = (Button) findViewById(R.id.connect_button);
        this.n = (Button) findViewById(R.id.disconnect_button);
        if (this.h != null) {
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item);
            for (int i5 = 1; i5 <= 15; i5++) {
                arrayAdapter.add(String.valueOf(i5));
            }
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            this.h.setAdapter((SpinnerAdapter) arrayAdapter);
            this.h.setSelection(0);
        }
        if (this.f6059i != null) {
            ArrayAdapter arrayAdapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item);
            arrayAdapter2.add("1");
            arrayAdapter2.add("2");
            arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            this.f6059i.setAdapter((SpinnerAdapter) arrayAdapter2);
            this.f6059i.setSelection(1);
        }
        EditText editText = this.f6060j;
        if (editText != null) {
            editText.setText("3104.amcomm.network");
        }
        EditText editText2 = this.f6061k;
        if (editText2 != null) {
            editText2.setText("62031");
        }
        EditText editText3 = this.g;
        if (editText3 != null) {
            editText3.setText(String.valueOf(this.f6067r));
        }
        if (h.a(this, "android.permission.RECORD_AUDIO") != 0) {
            B.e.d(this, new String[]{"android.permission.RECORD_AUDIO"}, 1001);
        }
        try {
            File file = new File(getApplicationInfo().nativeLibraryDir);
            Log.d("DMRActivity", "Native library directory: " + file.getAbsolutePath());
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                for (File file2 : fileArrListFiles) {
                    Log.d("DMRActivity", "Found native library: " + file2.getName());
                }
            }
        } catch (Exception e5) {
            Log.e("DMRActivity", "Error listing native libraries", e5);
        }
        try {
            DMRBridge dMRBridgeJ2 = DMRBridge.j(this);
            this.f6064o = dMRBridgeJ2;
            dMRBridgeJ2.v(this);
            this.f6064o.m();
            Thread.sleep(1000L);
            k();
            Log.d("DMRActivity", "DMR Bridge initialized successfully");
        } catch (Exception e6) {
            Toast.makeText(this, "Error initializing DMR: " + e6.getMessage(), 1).show();
            Log.e("DMRActivity", "Error initializing DMR", e6);
            j();
        } catch (UnsatisfiedLinkError e7) {
            Toast.makeText(this, "DMR functionality unavailable: Missing native library", 1).show();
            Log.e("DMRActivity", "Native library not found", e7);
            j();
        }
        try {
            this.f6064o = DMRBridge.j(this);
        } catch (Exception e8) {
            Log.e("DMRActivity", "Failed to initialize DMR Bridge", e8);
        }
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, androidx.activity.ComponentActivity, android.app.Activity
    public final void onRequestPermissionsResult(int i5, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i5, strArr, iArr);
        if (i5 == 1001) {
            if (iArr.length > 0 && iArr[0] == 0) {
                Log.d("DMRActivity", "RECORD_AUDIO permission granted");
            } else {
                Log.w("DMRActivity", "RECORD_AUDIO permission denied - PTT functionality may not work");
                Toast.makeText(this, "Microphone permission denied - PTT may not work properly", 1).show();
            }
        }
    }
}
