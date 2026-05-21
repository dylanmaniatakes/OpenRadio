package f3;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.unified.ur1.R;
import com.unified.ur1.primary.OptionsActivity;
import e3.C0454h;
import j3.C0604b;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class E0 {

    /* renamed from: A, reason: collision with root package name */
    public TextView f6557A;

    /* renamed from: B, reason: collision with root package name */
    public TextView f6558B;

    /* renamed from: C, reason: collision with root package name */
    public TextView f6559C;

    /* renamed from: D, reason: collision with root package name */
    public TextView f6560D;

    /* renamed from: E, reason: collision with root package name */
    public TextView f6561E;

    /* renamed from: F, reason: collision with root package name */
    public TextView f6562F;

    /* renamed from: G, reason: collision with root package name */
    public TextView f6563G;

    /* renamed from: H, reason: collision with root package name */
    public TextView f6564H;
    public Object I;

    /* renamed from: a, reason: collision with root package name */
    public LinearLayout f6565a;

    /* renamed from: b, reason: collision with root package name */
    public TextView f6566b;

    /* renamed from: c, reason: collision with root package name */
    public TextView f6567c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f6568d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f6569e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f6570f;
    public TextView g;
    public LinearLayout h;

    /* renamed from: i, reason: collision with root package name */
    public Object f6571i;

    /* renamed from: j, reason: collision with root package name */
    public Object f6572j;

    /* renamed from: k, reason: collision with root package name */
    public TextView f6573k;

    /* renamed from: l, reason: collision with root package name */
    public View f6574l;

    /* renamed from: m, reason: collision with root package name */
    public View f6575m;
    public View n;

    /* renamed from: o, reason: collision with root package name */
    public View f6576o;

    /* renamed from: p, reason: collision with root package name */
    public View f6577p;

    /* renamed from: q, reason: collision with root package name */
    public View f6578q;

    /* renamed from: r, reason: collision with root package name */
    public View f6579r;

    /* renamed from: s, reason: collision with root package name */
    public View f6580s;

    /* renamed from: t, reason: collision with root package name */
    public View f6581t;

    /* renamed from: u, reason: collision with root package name */
    public View f6582u;

    /* renamed from: v, reason: collision with root package name */
    public View f6583v;

    /* renamed from: w, reason: collision with root package name */
    public TextView f6584w;

    /* renamed from: x, reason: collision with root package name */
    public TextView f6585x;

    /* renamed from: y, reason: collision with root package name */
    public TextView f6586y;

    /* renamed from: z, reason: collision with root package name */
    public TextView f6587z;

    public static void f(Context context) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        MediaPlayer mediaPlayerCreate;
        try {
            String strS = h4.c.s(context);
            String string = h4.c.C(context).getString("notification_sound_path", null);
            if ("none".equals(strS)) {
                return;
            }
            if ("custom".equals(strS) && string != null && new File(string).exists()) {
                mediaPlayerCreate = new MediaPlayer();
                mediaPlayerCreate.setDataSource(string);
                mediaPlayerCreate.prepareAsync();
                mediaPlayerCreate.setOnPreparedListener(new y0());
            } else {
                mediaPlayerCreate = MediaPlayer.create(context, R.raw.mail);
                if (mediaPlayerCreate != null) {
                    mediaPlayerCreate.start();
                }
            }
            if (mediaPlayerCreate != null) {
                mediaPlayerCreate.setOnCompletionListener(new B0());
                mediaPlayerCreate.setOnErrorListener(new t0());
            }
        } catch (Exception e5) {
            Log.e("SoundCustomizationManager", "Error playing notification sound", e5);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void g(int r15, android.content.Context r16, java.lang.String r17) {
        /*
            Method dump skipped, instructions count: 424
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.E0.g(int, android.content.Context, java.lang.String):void");
    }

    public static void h(Spinner spinner, String str, String[] strArr) {
        if (spinner == null || spinner.getAdapter() == null) {
            return;
        }
        for (int i5 = 0; i5 < strArr.length; i5++) {
            if (strArr[i5].equals(str)) {
                spinner.setSelection(i5);
                Log.d("SoundCustomizationManager", "Set spinner selection to: " + str + " (position: " + i5 + ")");
                return;
            }
        }
    }

    public static void p(LinearLayout linearLayout, String str) {
        if (linearLayout != null) {
            linearLayout.setVisibility(("custom".equals(str) || "custom".equals(str)) ? 0 : 8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void q(android.widget.TextView r16, java.lang.String r17, boolean r18) {
        /*
            r0 = r16
            r1 = r17
            if (r0 != 0) goto L7
            return
        L7:
            java.lang.String r2 = "#757575"
            java.lang.String r3 = "#00BCD4"
            java.lang.String r4 = "Custom ✓"
            java.lang.String r5 = "custom"
            java.lang.String r7 = "none"
            java.lang.String r8 = "default"
            r9 = 1544803905(0x5c13d641, float:1.6644958E17)
            r10 = 3387192(0x33af38, float:4.746467E-39)
            r11 = -1349088399(0xffffffffaf968b71, float:-2.738392E-10)
            java.lang.String r13 = "#4CAF50"
            java.lang.String r14 = "Default"
            r15 = 2
            r6 = 1
            if (r18 == 0) goto L82
            int r12 = r17.hashCode()     // Catch: java.lang.Exception -> L37
            if (r12 == r11) goto L42
            if (r12 == r10) goto L3a
            if (r12 == r9) goto L2f
            goto L4a
        L2f:
            boolean r1 = r1.equals(r8)     // Catch: java.lang.Exception -> L37
            if (r1 == 0) goto L4a
            r1 = r6
            goto L4b
        L37:
            r0 = move-exception
            goto Lda
        L3a:
            boolean r1 = r1.equals(r7)     // Catch: java.lang.Exception -> L37
            if (r1 == 0) goto L4a
            r1 = 0
            goto L4b
        L42:
            boolean r1 = r1.equals(r5)     // Catch: java.lang.Exception -> L37
            if (r1 == 0) goto L4a
            r1 = r15
            goto L4b
        L4a:
            r1 = -1
        L4b:
            if (r1 == 0) goto L75
            if (r1 == r6) goto L69
            if (r1 == r15) goto L5d
            r0.setText(r14)     // Catch: java.lang.Exception -> L37
            int r1 = android.graphics.Color.parseColor(r13)     // Catch: java.lang.Exception -> L37
            r0.setTextColor(r1)     // Catch: java.lang.Exception -> L37
            goto Le1
        L5d:
            r0.setText(r4)     // Catch: java.lang.Exception -> L37
            int r1 = android.graphics.Color.parseColor(r3)     // Catch: java.lang.Exception -> L37
            r0.setTextColor(r1)     // Catch: java.lang.Exception -> L37
            goto Le1
        L69:
            r0.setText(r14)     // Catch: java.lang.Exception -> L37
            int r1 = android.graphics.Color.parseColor(r13)     // Catch: java.lang.Exception -> L37
            r0.setTextColor(r1)     // Catch: java.lang.Exception -> L37
            goto Le1
        L75:
            java.lang.String r1 = "No Sound"
            r0.setText(r1)     // Catch: java.lang.Exception -> L37
            int r1 = android.graphics.Color.parseColor(r2)     // Catch: java.lang.Exception -> L37
            r0.setTextColor(r1)     // Catch: java.lang.Exception -> L37
            goto Le1
        L82:
            int r12 = r17.hashCode()     // Catch: java.lang.Exception -> L37
            if (r12 == r11) goto L9d
            if (r12 == r10) goto L95
            if (r12 == r9) goto L8d
            goto La5
        L8d:
            boolean r1 = r1.equals(r8)     // Catch: java.lang.Exception -> L37
            if (r1 == 0) goto La5
            r1 = r6
            goto La6
        L95:
            boolean r1 = r1.equals(r7)     // Catch: java.lang.Exception -> L37
            if (r1 == 0) goto La5
            r1 = 0
            goto La6
        L9d:
            boolean r1 = r1.equals(r5)     // Catch: java.lang.Exception -> L37
            if (r1 == 0) goto La5
            r1 = r15
            goto La6
        La5:
            r1 = -1
        La6:
            if (r1 == 0) goto Lcd
            if (r1 == r6) goto Lc2
            if (r1 == r15) goto Lb7
            r0.setText(r14)     // Catch: java.lang.Exception -> L37
            int r1 = android.graphics.Color.parseColor(r13)     // Catch: java.lang.Exception -> L37
            r0.setTextColor(r1)     // Catch: java.lang.Exception -> L37
            goto Le1
        Lb7:
            r0.setText(r4)     // Catch: java.lang.Exception -> L37
            int r1 = android.graphics.Color.parseColor(r3)     // Catch: java.lang.Exception -> L37
            r0.setTextColor(r1)     // Catch: java.lang.Exception -> L37
            goto Le1
        Lc2:
            r0.setText(r14)     // Catch: java.lang.Exception -> L37
            int r1 = android.graphics.Color.parseColor(r13)     // Catch: java.lang.Exception -> L37
            r0.setTextColor(r1)     // Catch: java.lang.Exception -> L37
            goto Le1
        Lcd:
            java.lang.String r1 = "No Tone"
            r0.setText(r1)     // Catch: java.lang.Exception -> L37
            int r1 = android.graphics.Color.parseColor(r2)     // Catch: java.lang.Exception -> L37
            r0.setTextColor(r1)     // Catch: java.lang.Exception -> L37
            goto Le1
        Lda:
            java.lang.String r1 = "SoundCustomizationManager"
            java.lang.String r2 = "Error updating status text"
            android.util.Log.e(r1, r2, r0)
        Le1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.E0.q(android.widget.TextView, java.lang.String, boolean):void");
    }

    public void a() {
        try {
            MediaPlayer mediaPlayer = (MediaPlayer) this.f6572j;
            if (mediaPlayer != null) {
                mediaPlayer.release();
                this.f6572j = null;
            }
            Log.d("SoundCustomizationManager", "Sound customization manager cleaned up");
        } catch (Exception e5) {
            Log.e("SoundCustomizationManager", "Error during cleanup", e5);
        }
    }

    public void b(Activity activity) {
        try {
            this.f6583v = (Spinner) activity.findViewById(R.id.notificationSoundModeSpinner);
            this.f6577p = (LinearLayout) activity.findViewById(R.id.notificationCustomAudioContainer);
            this.f6563G = (Button) activity.findViewById(R.id.selectNotificationSoundButton);
            this.f6564H = (Button) activity.findViewById(R.id.previewNotificationSoundButton);
            this.g = (TextView) activity.findViewById(R.id.notificationSoundStatusText);
            Log.d("SoundCustomizationManager", "Notification sound components initialized");
        } catch (Exception e5) {
            Log.e("SoundCustomizationManager", "Error initializing notification sound components", e5);
        }
    }

    public void c(Activity activity) {
        try {
            this.f6573k = (Switch) activity.findViewById(R.id.pttSoundSwitch);
            this.f6565a = (LinearLayout) activity.findViewById(R.id.pttSoundConfigContainer);
            this.f6578q = (Spinner) activity.findViewById(R.id.fmPttModeSpinner);
            this.h = (LinearLayout) activity.findViewById(R.id.fmCustomAudioContainer);
            this.f6584w = (Button) activity.findViewById(R.id.selectFmPttSoundButton);
            this.f6585x = (Button) activity.findViewById(R.id.previewFmPttSoundButton);
            this.f6566b = (TextView) activity.findViewById(R.id.fmPttStatusText);
            this.f6579r = (Spinner) activity.findViewById(R.id.dmrPttModeSpinner);
            this.f6574l = (LinearLayout) activity.findViewById(R.id.dmrCustomAudioContainer);
            this.f6586y = (Button) activity.findViewById(R.id.selectDmrPttSoundButton);
            this.f6587z = (Button) activity.findViewById(R.id.previewDmrPttSoundButton);
            this.f6567c = (TextView) activity.findViewById(R.id.dmrPttStatusText);
            this.f6580s = (Spinner) activity.findViewById(R.id.roipPttModeSpinner);
            this.f6575m = (LinearLayout) activity.findViewById(R.id.roipCustomAudioContainer);
            this.f6557A = (Button) activity.findViewById(R.id.selectRoipPttSoundButton);
            this.f6558B = (Button) activity.findViewById(R.id.previewRoipPttSoundButton);
            this.f6568d = (TextView) activity.findViewById(R.id.roipPttStatusText);
            this.f6581t = (Spinner) activity.findViewById(R.id.connectedSoundModeSpinner);
            this.n = (LinearLayout) activity.findViewById(R.id.connectedCustomAudioContainer);
            this.f6559C = (Button) activity.findViewById(R.id.selectConnectedSoundButton);
            this.f6560D = (Button) activity.findViewById(R.id.previewConnectedSoundButton);
            this.f6569e = (TextView) activity.findViewById(R.id.connectedSoundStatusText);
            this.f6582u = (Spinner) activity.findViewById(R.id.disconnectSoundModeSpinner);
            this.f6576o = (LinearLayout) activity.findViewById(R.id.disconnectCustomAudioContainer);
            this.f6561E = (Button) activity.findViewById(R.id.selectDisconnectSoundButton);
            this.f6562F = (Button) activity.findViewById(R.id.previewDisconnectSoundButton);
            this.f6570f = (TextView) activity.findViewById(R.id.disconnectSoundStatusText);
            Log.d("SoundCustomizationManager", "PTT sound components initialized");
        } catch (Exception e5) {
            Log.e("SoundCustomizationManager", "Error initializing PTT sound components", e5);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0039 A[Catch: Exception -> 0x0067, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x0067, blocks: (B:3:0x0006, B:5:0x0016, B:28:0x006e, B:13:0x0039, B:24:0x0061, B:27:0x0069, B:6:0x0024, B:8:0x002e, B:15:0x0041, B:17:0x0050, B:21:0x0058, B:22:0x005b), top: B:36:0x0006, inners: #0, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(android.app.Activity r6) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.I
            f3.D0 r0 = (f3.D0) r0
            java.lang.String r1 = "SoundCustomizationManager"
            java.lang.String r2 = "Initializing all sound components..."
            android.util.Log.d(r1, r2)     // Catch: java.lang.Exception -> L67
            r5.c(r6)     // Catch: java.lang.Exception -> L67
            r5.b(r6)     // Catch: java.lang.Exception -> L67
            r5.i()     // Catch: java.lang.Exception -> L67
            if (r0 == 0) goto L24
            f3.x0 r2 = new f3.x0     // Catch: java.lang.Exception -> L67
            r3 = 1
            r2.<init>(r5, r3)     // Catch: java.lang.Exception -> L67
            java.lang.String r3 = "LoadAllSoundSettings"
            r4 = r0
            com.unified.ur1.adapters.SoundCustomizationActivity r4 = (com.unified.ur1.adapters.SoundCustomizationActivity) r4     // Catch: java.lang.Exception -> L67
            r4.o(r3, r2)     // Catch: java.lang.Exception -> L67
        L24:
            java.lang.String r2 = android.os.Build.DISPLAY     // Catch: java.lang.Exception -> L37
            java.lang.String r3 = "A500V5TN7.GQU2"
            boolean r3 = r2.contains(r3)     // Catch: java.lang.Exception -> L37
            if (r3 != 0) goto L39
            java.lang.String r3 = "Ulefone.HJ.FHD"
            boolean r2 = r2.contains(r3)     // Catch: java.lang.Exception -> L37
            if (r2 == 0) goto L6e
            goto L39
        L37:
            r6 = move-exception
            goto L69
        L39:
            java.lang.String r2 = "PTT sound settings hidden for this device ROM"
            android.util.Log.d(r1, r2)     // Catch: java.lang.Exception -> L67
            r2 = 2131361809(0x7f0a0011, float:1.834338E38)
            android.view.View r2 = r6.findViewById(r2)     // Catch: java.lang.Exception -> L54
            r3 = 2131361802(0x7f0a000a, float:1.8343367E38)
            android.view.View r6 = r6.findViewById(r3)     // Catch: java.lang.Exception -> L54
            r3 = 8
            if (r2 == 0) goto L56
            r2.setVisibility(r3)     // Catch: java.lang.Exception -> L54
            goto L56
        L54:
            r6 = move-exception
            goto L61
        L56:
            if (r6 == 0) goto L5b
            r6.setVisibility(r3)     // Catch: java.lang.Exception -> L54
        L5b:
            java.lang.String r6 = "PTT Sound cards hidden for unsupported device"
            android.util.Log.d(r1, r6)     // Catch: java.lang.Exception -> L54
            goto L6e
        L61:
            java.lang.String r2 = "Error hiding PTT sound cards"
            android.util.Log.e(r1, r2, r6)     // Catch: java.lang.Exception -> L67
            goto L6e
        L67:
            r6 = move-exception
            goto L74
        L69:
            java.lang.String r2 = "Error checking device ROM"
            android.util.Log.e(r1, r2, r6)     // Catch: java.lang.Exception -> L67
        L6e:
            java.lang.String r6 = "All sound components initialized successfully"
            android.util.Log.d(r1, r6)     // Catch: java.lang.Exception -> L67
            goto Lac
        L74:
            java.lang.String r2 = "Error initializing sound components"
            android.util.Log.e(r1, r2, r6)
            if (r0 == 0) goto Lac
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Failed to initialize sound components: "
            r1.<init>(r2)
            java.lang.String r6 = r6.getMessage()
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            com.unified.ur1.adapters.SoundCustomizationActivity r0 = (com.unified.ur1.adapters.SoundCustomizationActivity) r0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Sound customization error: "
            r1.<init>(r2)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "SoundCustomizationActivity"
            android.util.Log.e(r2, r1)
            D.m r1 = new D.m
            r2 = 26
            r1.<init>(r0, r2, r6)
            r0.runOnUiThread(r1)
        Lac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.E0.d(android.app.Activity):void");
    }

    public void e(final C0604b c0604b) {
        final Dialog dialog = (Dialog) this.f6571i;
        final LinearLayout linearLayout = this.f6565a;
        final TextView textView = this.f6566b;
        final TextView textView2 = this.f6567c;
        final TextView textView3 = this.f6568d;
        final TextView textView4 = this.f6569e;
        final TextView textView5 = this.f6570f;
        final TextView textView6 = this.g;
        final TextView textView7 = (TextView) this.f6572j;
        final TextView textView8 = this.f6573k;
        final TextView textView9 = (TextView) this.f6574l;
        final TextView textView10 = (TextView) this.f6575m;
        final TextView textView11 = (TextView) this.n;
        final TextView textView12 = (TextView) this.f6576o;
        final TextView textView13 = (TextView) this.f6577p;
        final TextView textView14 = (TextView) this.f6578q;
        final TextView textView15 = (TextView) this.f6579r;
        final TextView textView16 = (TextView) this.f6580s;
        final TextView textView17 = (TextView) this.f6581t;
        final TextView textView18 = (TextView) this.f6582u;
        final TextView textView19 = (TextView) this.f6583v;
        final TextView textView20 = this.f6584w;
        final TextView textView21 = this.f6585x;
        final TextView textView22 = this.f6586y;
        final TextView textView23 = this.f6587z;
        final TextView textView24 = this.f6557A;
        final TextView textView25 = this.f6558B;
        final TextView textView26 = this.f6559C;
        final TextView textView27 = this.f6560D;
        final TextView textView28 = this.f6561E;
        final TextView textView29 = this.f6562F;
        final TextView textView30 = this.f6563G;
        ((OptionsActivity) this.I).runOnUiThread(new Runnable() { // from class: k3.W0
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
            /* JADX WARN: Removed duplicated region for block: B:52:0x0116  */
            /* JADX WARN: Removed duplicated region for block: B:74:0x0171  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void run() {
                /*
                    Method dump skipped, instructions count: 646
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: k3.W0.run():void");
            }
        });
    }

    public void i() {
        try {
            Log.d("SoundCustomizationManager", "Setting up all sound spinners...");
            k();
            j();
            Log.d("SoundCustomizationManager", "All sound spinners setup completed");
        } catch (Exception e5) {
            Log.e("SoundCustomizationManager", "Error setting up sound spinners", e5);
            try {
                Log.d("SoundCustomizationManager", "Setting up fallback spinners");
                String[] strArr = {"No Tone", "Default", "Custom Audio"};
                String[] strArr2 = {"No Sound", "Default", "Custom Audio"};
                m((Spinner) this.f6581t, "Connected Sound (Fallback)", strArr);
                m((Spinner) this.f6582u, "Disconnect Sound (Fallback)", strArr);
                if (((Spinner) this.f6583v) != null) {
                    ((Spinner) this.f6583v).setAdapter((SpinnerAdapter) new C0454h((Context) this.f6571i, android.R.layout.simple_spinner_item, strArr2));
                    Log.d("SoundCustomizationManager", "Notification sound fallback spinner configured");
                }
            } catch (Exception e6) {
                Log.e("SoundCustomizationManager", "Error setting up fallback spinners", e6);
            }
        }
    }

    public void j() {
        try {
            if (((Spinner) this.f6583v) != null) {
                ((Spinner) this.f6583v).setAdapter((SpinnerAdapter) new C0454h((Context) this.f6571i, android.R.layout.simple_spinner_item, new String[]{"No Sound", "Default (Mail)", "Custom Audio"}));
                Log.d("SoundCustomizationManager", "Notification sound spinner configured with 3 items");
            } else {
                Log.w("SoundCustomizationManager", "Notification sound spinner is null");
            }
        } catch (Exception e5) {
            Log.e("SoundCustomizationManager", "Error setting up notification sound spinner", e5);
        }
    }

    public void k() {
        try {
            Log.d("SoundCustomizationManager", "Setting up PTT mode spinners...");
            String[] strArr = {"No Tone", "Default", "Custom Audio"};
            Log.d("SoundCustomizationManager", "PTT mode display names: " + Arrays.toString(strArr));
            m((Spinner) this.f6578q, "FM PTT", strArr);
            m((Spinner) this.f6579r, "DMR PTT", strArr);
            m((Spinner) this.f6580s, "ROIP PTT", strArr);
            m((Spinner) this.f6581t, "Connected Sound", strArr);
            m((Spinner) this.f6582u, "Disconnect Sound", strArr);
        } catch (Exception e5) {
            Log.e("SoundCustomizationManager", "Error setting up PTT mode spinners", e5);
        }
    }

    public void l() {
        try {
            n((Spinner) this.f6578q, this.h, (Button) this.f6584w, (Button) this.f6585x, "fm_ptt", 1001, "FM PTT");
            n((Spinner) this.f6579r, (LinearLayout) this.f6574l, (Button) this.f6586y, (Button) this.f6587z, "dmr_rf_ptt", 1002, "DMR PTT");
            n((Spinner) this.f6580s, (LinearLayout) this.f6575m, (Button) this.f6557A, (Button) this.f6558B, "roip_ptt", 1003, "ROIP PTT");
            n((Spinner) this.f6581t, (LinearLayout) this.n, (Button) this.f6559C, (Button) this.f6560D, "connected_sound", GeofenceStatusCodes.GEOFENCE_INSUFFICIENT_LOCATION_PERMISSION, "Connected");
            n((Spinner) this.f6582u, (LinearLayout) this.f6576o, (Button) this.f6561E, (Button) this.f6562F, "disconnect_sound", 1005, "Disconnect");
        } catch (Exception e5) {
            Log.e("SoundCustomizationManager", "Error setting up PTT sound listeners", e5);
        }
    }

    public void m(Spinner spinner, String str, String[] strArr) {
        if (spinner == null) {
            Log.w("SoundCustomizationManager", str.concat(" spinner is null"));
            return;
        }
        try {
            spinner.setAdapter((SpinnerAdapter) new C0454h((Context) this.f6571i, android.R.layout.simple_spinner_item, strArr));
            Log.d("SoundCustomizationManager", str + " spinner configured with " + strArr.length + " items");
        } catch (Exception e5) {
            Log.e("SoundCustomizationManager", "Error setting up " + str + " spinner", e5);
        }
    }

    public void n(Spinner spinner, LinearLayout linearLayout, Button button, Button button2, String str, final int i5, final String str2) {
        if (spinner != null) {
            try {
                spinner.setOnItemSelectedListener(new C0(this, str, linearLayout, button, button2));
            } catch (Exception e5) {
                Log.e("SoundCustomizationManager", "Error setting up listeners for ".concat(str2), e5);
                return;
            }
        }
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: f3.u0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i6 = i5;
                    String str3 = str2;
                    Context context = (Context) this.f6571i;
                    try {
                        Intent intent = new Intent("android.intent.action.GET_CONTENT");
                        intent.setType("audio/*");
                        intent.addCategory("android.intent.category.OPENABLE");
                        intent.putExtra("android.intent.extra.TITLE", "Select " + str3 + " Sound");
                        ((Activity) context).startActivityForResult(Intent.createChooser(intent, "Select " + str3 + " Sound"), i6);
                    } catch (Exception e6) {
                        Log.e("SoundCustomizationManager", "Error selecting audio file", e6);
                        Toast.makeText(context, "Error opening file selector", 0).show();
                    }
                }
            });
        }
        if (button2 != null) {
            button2.setOnClickListener(new o0(this, 1, str));
        }
    }

    public void o() {
        Context context = (Context) this.f6571i;
        try {
            q(this.f6566b, h4.c.o(context), false);
            q(this.f6567c, h4.c.k(context), false);
            q(this.f6568d, h4.c.x(context), false);
            q(this.f6569e, h4.c.i(context), false);
            q(this.f6570f, h4.c.m(context), false);
            q(this.g, h4.c.s(context), true);
        } catch (Exception e5) {
            Log.e("SoundCustomizationManager", "Error updating sound status", e5);
        }
    }
}
