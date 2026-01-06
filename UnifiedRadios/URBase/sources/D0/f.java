package D0;

import android.animation.ObjectAnimator;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.util.Log;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.internal.measurement.AbstractC0409x1;
import com.unified.ur1.SatelliteTracker.FullscreenMapActivity;
import com.unified.ur1.SatelliteTracker.SatelliteTrackerActivity;
import com.unified.ur1.adapters.MemoryChannelActivity;
import com.unified.ur1.primary.DTMFKeypad;
import com.unified.ur1.primary.LaunchActivity;
import com.unified.ur1.radioteams.RadioTeamsActivity;
import com.unified.ur1.radioteams.RadioTeamsManagerActivity;
import com.unified.ur1.rfmodule.RecordingsActivity;
import f3.C0515f;
import f3.f0;
import h1.C0558b;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import l3.RunnableC0751i;
import m3.C0776l;
import org.conscrypt.FileClientSessionCache;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p3.C0836b;
import z2.InterfaceFutureC1000b;

/* loaded from: classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f252j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f253k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f254l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f255m;

    public /* synthetic */ f(Object obj, Object obj2, Object obj3, int i5) {
        this.f252j = i5;
        this.f253k = obj;
        this.f254l = obj2;
        this.f255m = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() throws JSONException, InterruptedException, IOException {
        boolean zBooleanValue;
        int i5 = 24;
        final int i6 = 0;
        int i7 = 1;
        switch (this.f252j) {
            case 0:
                h hVar = (h) this.f253k;
                InterfaceFutureC1000b interfaceFutureC1000b = (InterfaceFutureC1000b) this.f254l;
                x xVar = (x) this.f255m;
                hVar.getClass();
                try {
                    zBooleanValue = ((Boolean) interfaceFutureC1000b.get()).booleanValue();
                } catch (InterruptedException | ExecutionException unused) {
                    zBooleanValue = true;
                }
                synchronized (hVar.f269k) {
                    try {
                        L0.j jVarD = AbstractC0409x1.d(xVar.f317l);
                        String str = jVarD.f1551a;
                        if (hVar.c(str) == xVar) {
                            hVar.b(str);
                        }
                        C0.t.d().a(h.f260l, h.class.getSimpleName() + " " + str + " executed; reschedule = " + zBooleanValue);
                        Iterator it = hVar.f268j.iterator();
                        while (it.hasNext()) {
                            ((c) it.next()).e(jVarD, zBooleanValue);
                        }
                    } finally {
                    }
                }
                return;
            case 1:
                Intent intent = (Intent) this.f254l;
                N1.k kVar = (N1.k) this.f255m;
                X2.g gVar = (X2.g) this.f253k;
                gVar.getClass();
                try {
                    gVar.b(intent);
                    return;
                } finally {
                    kVar.a(null);
                }
            case 2:
                L0.l lVar = (L0.l) this.f253k;
                h4.d dVar = (h4.d) this.f254l;
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) this.f255m;
                lVar.getClass();
                try {
                    androidx.emoji2.text.o oVarD = h4.c.d((Context) lVar.f1554d);
                    if (oVarD == null) {
                        throw new RuntimeException("EmojiCompat font provider not available on this device.");
                    }
                    androidx.emoji2.text.n nVar = (androidx.emoji2.text.n) ((androidx.emoji2.text.i) oVarD.f3604b);
                    synchronized (nVar.f3629f) {
                        nVar.h = threadPoolExecutor;
                    }
                    ((androidx.emoji2.text.i) oVarD.f3604b).d(new androidx.emoji2.text.k(dVar, threadPoolExecutor));
                    return;
                } catch (Throwable th) {
                    dVar.i(th);
                    threadPoolExecutor.shutdown();
                    return;
                }
            case 3:
                ((FullscreenMapActivity) this.f253k).lambda$fetchSatelliteData$3((String) this.f254l, (Runnable) this.f255m);
                return;
            case 4:
                ((SatelliteTrackerActivity) this.f253k).lambda$updateSatelliteCalculations$12((ArrayList) ((List) this.f254l), (ArrayList) ((List) this.f255m));
                return;
            case 5:
                int i8 = MemoryChannelActivity.f5681l;
                MemoryChannelActivity memoryChannelActivity = (MemoryChannelActivity) this.f253k;
                memoryChannelActivity.getClass();
                ((ProgressDialog) this.f254l).dismiss();
                Exception exc = (Exception) this.f255m;
                Log.e("Unified - MemoryChannel", "ERROR in channel switching: ".concat(exc.getClass().getName()));
                com.unified.ur1.SatelliteTracker.h.o(exc, new StringBuilder("Error message: "), "Unified - MemoryChannel");
                StringBuilder sbG = com.unified.ur1.SatelliteTracker.h.g("Unified - MemoryChannel", "Stack trace:", exc, "Error switching channels: ");
                sbG.append(exc.getMessage());
                Toast.makeText(memoryChannelActivity, sbG.toString(), 1).show();
                return;
            case 6:
                f0 f0Var = (f0) this.f253k;
                f0Var.getClass();
                ((ProgressDialog) this.f254l).dismiss();
                Toast.makeText(f0Var.f6710b, "Error disconnecting from network: " + ((Exception) this.f255m).getMessage(), 1).show();
                return;
            case 7:
                byte[] bArr = (byte[]) this.f255m;
                HashMap map = DTMFKeypad.f5846k;
                DTMFKeypad dTMFKeypad = (DTMFKeypad) this.f253k;
                dTMFKeypad.getClass();
                try {
                    final byte[] bArr2 = new byte[320];
                    int i9 = 0;
                    while (true) {
                        final C0836b c0836b = (C0836b) this.f254l;
                        if (i9 >= 2) {
                            System.currentTimeMillis();
                            int i10 = 0;
                            final int i11 = 0;
                            while (i10 < bArr.length) {
                                int iMin = Math.min(320, bArr.length - i10);
                                byte[] bArr3 = new byte[320];
                                System.arraycopy(bArr, i10, bArr3, 0, iMin);
                                if (iMin < 320) {
                                    Log.d("DTMFKeypad", "Partial frame: " + iMin + " bytes");
                                }
                                final byte[] bArr4 = (byte[]) bArr3.clone();
                                dTMFKeypad.f5849e.post(new Runnable() { // from class: k3.g
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        int i12 = i11;
                                        C0836b c0836b2 = c0836b;
                                        byte[] bArr5 = bArr4;
                                        switch (i6) {
                                            case 0:
                                                HashMap map2 = DTMFKeypad.f5846k;
                                                c0836b2.c(bArr5);
                                                Log.v("DTMFKeypad", "Sent frame " + i12 + " to TX");
                                                break;
                                            default:
                                                HashMap map3 = DTMFKeypad.f5846k;
                                                c0836b2.c((byte[]) bArr5.clone());
                                                Log.v("DTMFKeypad", "Sent gap frame " + i12);
                                                break;
                                        }
                                    }
                                });
                                i11++;
                                i10 += iMin;
                                Thread.sleep(20L);
                            }
                            while (i6 < 10) {
                                final int i12 = 1;
                                dTMFKeypad.f5849e.post(new Runnable() { // from class: k3.g
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        int i122 = i6;
                                        C0836b c0836b2 = c0836b;
                                        byte[] bArr5 = bArr2;
                                        switch (i12) {
                                            case 0:
                                                HashMap map2 = DTMFKeypad.f5846k;
                                                c0836b2.c(bArr5);
                                                Log.v("DTMFKeypad", "Sent frame " + i122 + " to TX");
                                                break;
                                            default:
                                                HashMap map3 = DTMFKeypad.f5846k;
                                                c0836b2.c((byte[]) bArr5.clone());
                                                Log.v("DTMFKeypad", "Sent gap frame " + i122);
                                                break;
                                        }
                                    }
                                });
                                Thread.sleep(20L);
                                i6++;
                            }
                            Log.d("DTMFKeypad", "DTMF transmission complete: " + i11 + " tone frames + 10 silence frames");
                            return;
                        }
                        dTMFKeypad.f5849e.post(new g3.k(c0836b, 6, bArr2));
                        Thread.sleep(20L);
                        i9++;
                    }
                } catch (InterruptedException e5) {
                    Thread.currentThread().interrupt();
                    Log.e("DTMFKeypad", "DTMF transmission interrupted", e5);
                    return;
                } catch (Exception e6) {
                    Log.e("DTMFKeypad", "Error in DTMF frame transmission", e6);
                    return;
                }
            case 8:
                int[] iArr = (int[]) this.f254l;
                HashMap map2 = DTMFKeypad.f5846k;
                DTMFKeypad dTMFKeypad2 = (DTMFKeypad) this.f253k;
                dTMFKeypad2.getClass();
                try {
                    C0836b c0836bB = C0836b.b(dTMFKeypad2.f5848d);
                    if (c0836bB != null && c0836bB.g.get()) {
                        c0836bB.c(new byte[320]);
                    }
                    Thread.sleep(50L);
                    C0558b c0558b = dTMFKeypad2.h;
                    int i13 = iArr[0];
                    int i14 = iArr[1];
                    c0558b.getClass();
                    short[] sArrF = C0558b.f(i13, i14);
                    dTMFKeypad2.b(sArrF);
                    Thread.sleep(10L);
                    dTMFKeypad2.d(sArrF);
                    return;
                } catch (Exception e7) {
                    Log.e("DTMFKeypad", "Error playing DTMF tone for key " + ((String) this.f255m), e7);
                    return;
                }
            case 9:
                HashMap map3 = DTMFKeypad.f5846k;
                DTMFKeypad dTMFKeypad3 = (DTMFKeypad) this.f253k;
                dTMFKeypad3.getClass();
                C0836b c0836b2 = (C0836b) this.f254l;
                if (!c0836b2.g.get()) {
                    Log.e("DTMFKeypad", "TX still not transmitting after restart attempt");
                    return;
                } else {
                    dTMFKeypad3.c(c0836b2, (short[]) this.f255m);
                    Log.d("DTMFKeypad", "DTMF tone sent after TX restart");
                    return;
                }
            case 10:
                Context context = LaunchActivity.f5853D1;
                SharedPreferences.Editor editorEdit = ((LaunchActivity) this.f253k).getSharedPreferences("app_settings", 0).edit();
                editorEdit.putString((String) this.f254l, (String) this.f255m);
                editorEdit.apply();
                return;
            case 11:
                Context context2 = LaunchActivity.f5853D1;
                LaunchActivity launchActivity = (LaunchActivity) this.f253k;
                launchActivity.getClass();
                launchActivity.D0("✓ TG " + ((StringBuilder) this.f254l).toString() + " changed (" + ((String) this.f255m) + ")");
                return;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                Context context3 = LaunchActivity.f5853D1;
                LaunchActivity launchActivity2 = (LaunchActivity) this.f253k;
                launchActivity2.getClass();
                String strY = h4.c.y(LaunchActivity.f5853D1);
                String string = h4.c.C(LaunchActivity.f5853D1).getString("channel_name", "");
                int iL = h4.c.l(launchActivity2);
                boolean z4 = LaunchActivity.f5854E1;
                TextView textView = (TextView) this.f254l;
                if (z4) {
                    Log.e("Unified - Main Activity", "Multi-RX Mode - Setting TG to " + launchActivity2.f5947o);
                    if (iL != 777) {
                        h4.c.U(launchActivity2, launchActivity2.f5947o);
                    }
                    String str2 = "TG: " + launchActivity2.f5947o;
                    textView.setText(str2);
                    if (str2.length() > 8) {
                        textView.setTextSize(1, Math.max((8.0f / str2.length()) * 60.0f, 30.0f));
                    } else {
                        textView.setTextSize(1, 60.0f);
                    }
                    ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f, 1, 0.5f, 1, 0.5f);
                    launchActivity2.f5935j0 = scaleAnimation;
                    scaleAnimation.setDuration(1000L);
                    launchActivity2.f5935j0.setRepeatMode(2);
                    launchActivity2.f5935j0.setRepeatCount(-1);
                    ObjectAnimator objectAnimatorOfArgb = ObjectAnimator.ofArgb(textView, "textColor", Color.parseColor("#000000"), Color.parseColor("#009051"), Color.parseColor("#009051"));
                    launchActivity2.f5932i0 = objectAnimatorOfArgb;
                    objectAnimatorOfArgb.setDuration(1000L);
                    launchActivity2.f5932i0.setRepeatMode(2);
                    launchActivity2.f5932i0.setRepeatCount(-1);
                    if (launchActivity2.f5953q) {
                        textView.setTextColor(Color.parseColor("#009051"));
                        textView.startAnimation(launchActivity2.f5935j0);
                        return;
                    }
                    return;
                }
                if (strY == null || !strY.toLowerCase().contains("tgif") || !"TG: 777".equals(string)) {
                    ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f, 1, 0.5f, 1, 0.5f);
                    launchActivity2.f5935j0 = scaleAnimation2;
                    scaleAnimation2.setDuration(1000L);
                    launchActivity2.f5935j0.setRepeatMode(2);
                    launchActivity2.f5935j0.setRepeatCount(-1);
                    ObjectAnimator objectAnimatorOfArgb2 = ObjectAnimator.ofArgb(textView, "textColor", Color.parseColor("#000000"), Color.parseColor("#009051"), Color.parseColor("#009051"));
                    launchActivity2.f5932i0 = objectAnimatorOfArgb2;
                    objectAnimatorOfArgb2.setDuration(1000L);
                    launchActivity2.f5932i0.setRepeatMode(2);
                    launchActivity2.f5932i0.setRepeatCount(-1);
                    if (launchActivity2.f5953q) {
                        textView.setText(((C0515f) this.f255m).f6699c);
                        textView.setTextColor(Color.parseColor("#009051"));
                        textView.startAnimation(launchActivity2.f5935j0);
                        return;
                    }
                    return;
                }
                h4.c.f0(launchActivity2, true);
                Log.e("Unified - Main Activity", "Multi-RX Mode - Setting TG to " + launchActivity2.f5947o);
                String str3 = "TG: " + launchActivity2.f5947o;
                textView.setText(str3);
                if (str3.length() > 8) {
                    textView.setTextSize(1, Math.max((8.0f / str3.length()) * 60.0f, 30.0f));
                } else {
                    textView.setTextSize(1, 60.0f);
                }
                ScaleAnimation scaleAnimation3 = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f, 1, 0.5f, 1, 0.5f);
                launchActivity2.f5935j0 = scaleAnimation3;
                scaleAnimation3.setDuration(1000L);
                launchActivity2.f5935j0.setRepeatMode(2);
                launchActivity2.f5935j0.setRepeatCount(-1);
                ObjectAnimator objectAnimatorOfArgb3 = ObjectAnimator.ofArgb(textView, "textColor", Color.parseColor("#000000"), Color.parseColor("#009051"), Color.parseColor("#009051"));
                launchActivity2.f5932i0 = objectAnimatorOfArgb3;
                objectAnimatorOfArgb3.setDuration(1000L);
                launchActivity2.f5932i0.setRepeatMode(2);
                launchActivity2.f5932i0.setRepeatCount(-1);
                if (launchActivity2.f5953q) {
                    textView.setTextColor(Color.parseColor("#009051"));
                    textView.startAnimation(launchActivity2.f5935j0);
                    return;
                }
                return;
            case o1.f.ERROR /* 13 */:
                int i15 = RadioTeamsActivity.f6010u;
                RadioTeamsActivity radioTeamsActivity = (RadioTeamsActivity) this.f253k;
                radioTeamsActivity.getClass();
                JSONObject jSONObject = (JSONObject) this.f254l;
                if (!jSONObject.optBoolean("success", false)) {
                    Toast.makeText(radioTeamsActivity, "Failed to save profile: " + jSONObject.optString("message"), 1).show();
                    return;
                } else {
                    radioTeamsActivity.n = (JSONObject) this.f255m;
                    Toast.makeText(radioTeamsActivity, "Profile saved successfully", 0).show();
                    return;
                }
            case o1.f.INTERRUPTED /* 14 */:
                String str4 = (String) this.f254l;
                RadioTeamsManagerActivity radioTeamsManagerActivity = (RadioTeamsManagerActivity) this.f255m;
                int i16 = RadioTeamsManagerActivity.f6026l;
                RadioTeamsManagerActivity radioTeamsManagerActivity2 = (RadioTeamsManagerActivity) this.f253k;
                radioTeamsManagerActivity2.getClass();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("callsign", str4);
                    JSONObject jSONObject3 = new JSONObject(RadioTeamsManagerActivity.l("https://ur1.unifiedradios.com/api-teams/get_teams.php", jSONObject2));
                    if (!jSONObject3.getBoolean("success")) {
                        Log.e("RadioTeamsManager", "Failed to discover teams: " + jSONObject3.optString("message"));
                        radioTeamsManagerActivity2.f6033k.post(new g3.k(radioTeamsManagerActivity, 20, jSONObject3));
                        return;
                    }
                    Log.d("RadioTeamsManager", "Teams discovered successfully for " + str4);
                    JSONArray jSONArray = jSONObject3.getJSONObject("data").getJSONArray("subscribed_teams");
                    Log.d("RadioTeamsManager", "Found " + jSONArray.length() + " teams");
                    ArrayList arrayList = new ArrayList();
                    for (int i17 = 0; i17 < jSONArray.length(); i17++) {
                        String string2 = jSONArray.getString(i17);
                        Log.d("RadioTeamsManager", "Processing discovered team: " + string2);
                        Iterator it2 = radioTeamsManagerActivity2.h.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                l3.k kVar2 = (l3.k) it2.next();
                                if (kVar2.f8423a.equals(string2) && kVar2.f8424b.equals(str4)) {
                                    Log.d("RadioTeamsManager", "Team " + string2 + " already exists, skipping");
                                }
                            } else {
                                l3.k kVar3 = new l3.k();
                                kVar3.f8423a = string2;
                                kVar3.f8424b = str4;
                                kVar3.f8425c = false;
                                kVar3.f8426d = System.currentTimeMillis();
                                arrayList.add(kVar3);
                                Log.d("RadioTeamsManager", "Added discovered team: " + string2);
                            }
                        }
                    }
                    radioTeamsManagerActivity2.f6033k.post(new l(radioTeamsManagerActivity2, arrayList, radioTeamsManagerActivity, str4));
                    return;
                } catch (Exception e8) {
                    Log.e("RadioTeamsManager", "Error discovering teams", e8);
                    radioTeamsManagerActivity2.f6033k.post(new RunnableC0751i(radioTeamsManagerActivity, e8, i7));
                    return;
                }
            case 15:
                int i18 = RadioTeamsManagerActivity.f6026l;
                RadioTeamsManagerActivity radioTeamsManagerActivity3 = (RadioTeamsManagerActivity) this.f253k;
                radioTeamsManagerActivity3.getClass();
                JSONObject jSONObject4 = (JSONObject) this.f254l;
                if (!jSONObject4.optBoolean("success", false)) {
                    String strOptString = jSONObject4.optString("error", "Unknown error");
                    Log.e("RadioTeamsManager", "Team unsubscription failed on backend: " + strOptString);
                    Toast.makeText(radioTeamsManagerActivity3, "Failed to remove team: " + strOptString, 1).show();
                    return;
                }
                Log.d("RadioTeamsManager", "Team unsubscription successful on backend");
                ArrayList arrayList2 = radioTeamsManagerActivity3.h;
                l3.k kVar4 = (l3.k) this.f255m;
                arrayList2.remove(kVar4);
                Log.d("RadioTeamsManager", "Team removed from local list, new size: " + radioTeamsManagerActivity3.h.size());
                radioTeamsManagerActivity3.m();
                radioTeamsManagerActivity3.f6031i.notifyDataSetChanged();
                radioTeamsManagerActivity3.n();
                Toast.makeText(radioTeamsManagerActivity3, "Team '" + kVar4.f8423a + "' removed successfully!", 0).show();
                return;
            default:
                Uri uri = (Uri) this.f255m;
                int i19 = RecordingsActivity.f6091j;
                RecordingsActivity recordingsActivity = (RecordingsActivity) this.f253k;
                recordingsActivity.getClass();
                File file = new File(((C0776l) this.f254l).f8618c);
                try {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    try {
                        OutputStream outputStreamOpenOutputStream = recordingsActivity.getContentResolver().openOutputStream(uri);
                        try {
                            if (outputStreamOpenOutputStream == null) {
                                recordingsActivity.runOnUiThread(new g3.k(recordingsActivity, i5, "Could not open destination file"));
                                if (outputStreamOpenOutputStream != null) {
                                    outputStreamOpenOutputStream.close();
                                }
                            } else {
                                byte[] bArr5 = new byte[8192];
                                long length = file.length();
                                long j5 = 0;
                                while (true) {
                                    int i20 = fileInputStream.read(bArr5);
                                    if (i20 > 0) {
                                        outputStreamOpenOutputStream.write(bArr5, 0, i20);
                                        j5 += i20;
                                        long j6 = (100 * j5) / length;
                                    } else {
                                        recordingsActivity.runOnUiThread(new m3.w(recordingsActivity, 3));
                                        outputStreamOpenOutputStream.close();
                                    }
                                }
                            }
                            fileInputStream.close();
                            return;
                        } finally {
                        }
                    } finally {
                    }
                } catch (IOException e9) {
                    Log.e("RecordingsActivity", "Error saving file", e9);
                    recordingsActivity.runOnUiThread(new g3.k(recordingsActivity, i5, "Error saving file: " + e9.getMessage()));
                    return;
                }
        }
    }
}
