package D0;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Binder;
import android.util.Log;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import com.google.android.gms.internal.measurement.AbstractC0399v1;
import com.unified.ur1.primary.OptionsActivity;
import com.unified.ur1.rfmodule.ROIP.DMRBridge;
import e0.C0432c;
import f3.Q;
import f3.f0;
import f3.m0;
import java.net.URL;
import java.util.Iterator;
import k3.S0;

/* loaded from: classes.dex */
public final /* synthetic */ class g implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f256j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ boolean f257k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f258l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f259m;

    public /* synthetic */ g(int i5, Object obj, Object obj2, boolean z4) {
        this.f256j = i5;
        this.f258l = obj;
        this.f259m = obj2;
        this.f257k = z4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i5 = 1;
        switch (this.f256j) {
            case 0:
                h hVar = (h) this.f258l;
                L0.j jVar = (L0.j) this.f259m;
                boolean z4 = this.f257k;
                synchronized (hVar.f269k) {
                    try {
                        Iterator it = hVar.f268j.iterator();
                        while (it.hasNext()) {
                            ((c) it.next()).e(jVar, z4);
                        }
                    } finally {
                    }
                }
                return;
            case 1:
                Context context = (Context) this.f258l;
                N1.k kVar = (N1.k) this.f259m;
                try {
                    if (Binder.getCallingUid() == context.getApplicationInfo().uid) {
                        SharedPreferences.Editor editorEdit = AbstractC0399v1.d(context).edit();
                        editorEdit.putBoolean("proxy_notification_initialized", true);
                        editorEdit.apply();
                        NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
                        if (this.f257k) {
                            notificationManager.setNotificationDelegate("com.google.android.gms");
                        } else if ("com.google.android.gms".equals(notificationManager.getNotificationDelegate())) {
                            notificationManager.setNotificationDelegate(null);
                        }
                    } else {
                        Log.e("FirebaseMessaging", "error configuring notification delegate for package " + context.getPackageName());
                    }
                    kVar.c(null);
                    return;
                } finally {
                    kVar.c(null);
                }
            case 2:
                m0 m0Var = (m0) this.f259m;
                boolean z5 = this.f257k;
                f0 f0Var = (f0) this.f258l;
                Context context2 = f0Var.f6710b;
                try {
                    new URL("https://ur1.unifiedradios.com/repeater_status.php");
                    m0Var.f6752j = z5;
                    ((Activity) context2).runOnUiThread(new R2.c(f0Var, z5, i5));
                    return;
                } catch (Exception unused) {
                    ((Activity) context2).runOnUiThread(new Q(f0Var, 3));
                    return;
                }
            case 3:
                int i6 = OptionsActivity.f5981H;
                OptionsActivity optionsActivity = (OptionsActivity) this.f258l;
                if (optionsActivity.isFinishing()) {
                    return;
                }
                Switch r22 = optionsActivity.f5982A;
                boolean z6 = this.f257k;
                if (r22 != null) {
                    r22.setChecked(z6);
                }
                EditText editText = optionsActivity.f5984C;
                String str = (String) this.f259m;
                if (editText != null && str != null) {
                    editText.setText(str);
                }
                LinearLayout linearLayout = optionsActivity.f5983B;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
                try {
                    Switch r23 = optionsActivity.f5982A;
                    if (r23 != null) {
                        r23.setOnCheckedChangeListener(new S0(optionsActivity, 0));
                    }
                    EditText editText2 = optionsActivity.f5984C;
                    if (editText2 != null) {
                        editText2.addTextChangedListener(new g3.f(4, optionsActivity));
                    }
                } catch (Exception e5) {
                    Log.e("Unified - Settings", "Error setting up RadioTeams listeners", e5);
                }
                Log.d("Unified - Settings", "RadioTeams settings loaded: enabled=" + z6 + ", id=" + str);
                return;
            default:
                String str2 = (String) this.f259m;
                boolean z7 = this.f257k;
                boolean z8 = DMRBridge.f6068o;
                DMRBridge dMRBridge = (DMRBridge) this.f258l;
                dMRBridge.getClass();
                try {
                    Intent intent = new Intent("com.unified.ur1.SHOW_TOAST");
                    intent.putExtra("message", str2);
                    intent.putExtra("isError", z7);
                    intent.putExtra("timestamp", System.currentTimeMillis());
                    try {
                        C0432c.a(dMRBridge.f6070a).c(intent);
                        Log.i("DMRBridge", "Broadcast sent successfully: " + str2);
                        return;
                    } catch (Exception e6) {
                        Log.e("DMRBridge", "Failed to send broadcast", e6);
                        return;
                    }
                } catch (Exception e7) {
                    Log.e("DMRBridge", "Exception in showToastMessage main handler", e7);
                    return;
                }
        }
    }

    public /* synthetic */ g(h hVar, L0.j jVar) {
        this.f256j = 0;
        this.f258l = hVar;
        this.f259m = jVar;
        this.f257k = false;
    }

    public /* synthetic */ g(Context context, boolean z4, Object obj, int i5) {
        this.f256j = i5;
        this.f258l = context;
        this.f257k = z4;
        this.f259m = obj;
    }
}
