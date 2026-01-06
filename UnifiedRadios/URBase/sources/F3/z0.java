package f3;

import android.app.AlertDialog;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;
import com.unified.ur1.radioteams.RadioTeamsManagerActivity;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final /* synthetic */ class z0 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f6857j = 1;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ String f6858k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ String f6859l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ boolean f6860m;
    public final /* synthetic */ Object n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Object f6861o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Object f6862p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Object f6863q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ Object f6864r;

    public /* synthetic */ z0(RadioTeamsManagerActivity radioTeamsManagerActivity, ProgressBar progressBar, Button button, JSONObject jSONObject, String str, String str2, boolean z4, AlertDialog alertDialog) {
        this.n = radioTeamsManagerActivity;
        this.f6861o = progressBar;
        this.f6862p = button;
        this.f6863q = jSONObject;
        this.f6858k = str;
        this.f6859l = str2;
        this.f6860m = z4;
        this.f6864r = alertDialog;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj = this.f6864r;
        boolean z4 = this.f6860m;
        String str = this.f6859l;
        String str2 = this.f6858k;
        int i5 = 0;
        Object obj2 = this.f6863q;
        Object obj3 = this.f6862p;
        Object obj4 = this.f6861o;
        Object obj5 = this.n;
        switch (this.f6857j) {
            case 0:
                String str3 = (String) obj4;
                String str4 = (String) obj3;
                String str5 = (String) obj2;
                String str6 = (String) obj;
                E0 e02 = (E0) obj5;
                if (!((D0) e02.I).isFinishing()) {
                    try {
                        Switch r10 = (Switch) e02.f6573k;
                        if (r10 != null) {
                            r10.setChecked(z4);
                        }
                        E0.h((Spinner) e02.f6578q, str2, h4.c.g());
                        E0.h((Spinner) e02.f6579r, str, h4.c.g());
                        E0.h((Spinner) e02.f6580s, str3, h4.c.g());
                        E0.h((Spinner) e02.f6581t, str4, h4.c.g());
                        E0.h((Spinner) e02.f6582u, str5, h4.c.g());
                        E0.h((Spinner) e02.f6583v, str6, new String[]{"none", "default", "custom"});
                        LinearLayout linearLayout = e02.f6565a;
                        if (linearLayout != null) {
                            linearLayout.setVisibility(z4 ? 0 : 8);
                        }
                        E0.p(e02.h, str2);
                        E0.p((LinearLayout) e02.f6574l, str);
                        E0.p((LinearLayout) e02.f6575m, str3);
                        E0.p((LinearLayout) e02.n, str4);
                        E0.p((LinearLayout) e02.f6576o, str5);
                        LinearLayout linearLayout2 = (LinearLayout) e02.f6577p;
                        boolean zEquals = "custom".equals(str6);
                        if (linearLayout2 != null) {
                            if (!zEquals) {
                                i5 = 8;
                            }
                            linearLayout2.setVisibility(i5);
                        }
                        e02.o();
                        Log.d("SoundCustomizationManager", "UI updated with all sound settings");
                    } catch (Exception e5) {
                        Log.e("SoundCustomizationManager", "Error updating UI with settings", e5);
                    }
                    try {
                        Switch r02 = (Switch) e02.f6573k;
                        if (r02 != null) {
                            r02.setOnCheckedChangeListener(new Z1.a(2, e02));
                        }
                        e02.l();
                        try {
                            e02.n((Spinner) e02.f6583v, (LinearLayout) e02.f6577p, (Button) e02.f6563G, (Button) e02.f6564H, "notification_sound", 1006, "Notification");
                            Log.d("SoundCustomizationManager", "Notification sound listeners setup completed");
                        } catch (Exception e6) {
                            Log.e("SoundCustomizationManager", "Error setting up notification sound listeners", e6);
                        }
                        Log.d("SoundCustomizationManager", "All sound listeners setup completed");
                    } catch (Exception e7) {
                        Log.e("SoundCustomizationManager", "Error setting up sound listeners", e7);
                    }
                    Log.d("SoundCustomizationManager", "All sound settings loaded successfully");
                    break;
                }
                break;
            default:
                int i6 = RadioTeamsManagerActivity.f6026l;
                RadioTeamsManagerActivity radioTeamsManagerActivity = (RadioTeamsManagerActivity) obj5;
                radioTeamsManagerActivity.getClass();
                ProgressBar progressBar = (ProgressBar) obj4;
                if (progressBar != null) {
                    progressBar.setVisibility(8);
                }
                ((Button) obj3).setEnabled(true);
                JSONObject jSONObject = (JSONObject) obj2;
                if (!jSONObject.optBoolean("success", false)) {
                    String strOptString = jSONObject.optString("message", "Unknown error");
                    Log.e("RadioTeamsManager", "Team subscription failed: " + strOptString);
                    Toast.makeText(radioTeamsManagerActivity, "Team subscription failed" + strOptString, 1).show();
                    break;
                } else {
                    Log.d("RadioTeamsManager", "Team subscription successful");
                    l3.k kVar = new l3.k();
                    kVar.f8423a = str2;
                    kVar.f8424b = str;
                    kVar.f8425c = z4;
                    kVar.f8426d = System.currentTimeMillis();
                    Iterator it = radioTeamsManagerActivity.h.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            l3.k kVar2 = (l3.k) it.next();
                            if (kVar2.f8423a.equals(str2) && kVar2.f8424b.equals(str)) {
                                Log.w("RadioTeamsManager", "Team already exists");
                                Toast.makeText(radioTeamsManagerActivity, "Team already exists in your list", 0).show();
                            }
                        } else {
                            radioTeamsManagerActivity.h.add(kVar);
                            Log.d("RadioTeamsManager", "Team added to list, new size: " + radioTeamsManagerActivity.h.size());
                            radioTeamsManagerActivity.m();
                            radioTeamsManagerActivity.f6031i.notifyDataSetChanged();
                            radioTeamsManagerActivity.n();
                            Toast.makeText(radioTeamsManagerActivity, "Team added successfully!", 0).show();
                            if (z4) {
                                Log.d("RadioTeamsManager", "Auto-connecting to team");
                                radioTeamsManagerActivity.j(kVar);
                            }
                        }
                    }
                    ((AlertDialog) obj).dismiss();
                    break;
                }
                break;
        }
    }

    public /* synthetic */ z0(E0 e02, boolean z4, String str, String str2, String str3, String str4, String str5, String str6) {
        this.n = e02;
        this.f6860m = z4;
        this.f6858k = str;
        this.f6859l = str2;
        this.f6861o = str3;
        this.f6862p = str4;
        this.f6863q = str5;
        this.f6864r = str6;
    }
}
