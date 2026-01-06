package g3;

import X2.C0202f;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.profileinstaller.ProfileInstallerInitializer;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.unified.ur1.R;
import com.unified.ur1.chat.ChatActivity;
import com.unified.ur1.chat.TypingBubbleView;
import com.unified.ur1.inbox.ApiResponse;
import com.unified.ur1.inbox.ComposeMessageActivity;
import com.unified.ur1.primary.DTMFKeypad;
import com.unified.ur1.primary.LaunchActivity;
import com.unified.ur1.primary.OptionsActivity;
import com.unified.ur1.radioteams.RadioTeamsActivity;
import com.unified.ur1.radioteams.RadioTeamsManagerActivity;
import com.unified.ur1.rfmodule.DmrAudioService;
import com.unified.ur1.rfmodule.DmrDatabase;
import com.unified.ur1.rfmodule.RecordingsActivity;
import f3.C0515f;
import f3.C0519j;
import f3.E0;
import j0.AbstractC0595h;
import j3.C0604b;
import j3.C0605c;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import k3.DialogInterfaceOnClickListenerC0681d0;
import k3.O;
import k3.RunnableC0721z;
import k3.y0;
import l0.AbstractC0737m;
import l3.C0749g;
import l3.InterfaceC0748f;
import l3.RunnableC0743a;
import l3.RunnableC0751i;
import m3.C0776l;
import m3.C0777m;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.conscrypt.FileClientSessionCache;
import org.json.JSONException;
import org.json.JSONObject;
import p3.C0836b;
import q0.C0847j;
import retrofit2.Response;

/* loaded from: classes.dex */
public final /* synthetic */ class k implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f6975j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f6976k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f6977l;

    public /* synthetic */ k(Object obj, int i5, Object obj2) {
        this.f6975j = i5;
        this.f6976k = obj;
        this.f6977l = obj2;
    }

    private final void a() {
        TextView textView;
        LaunchActivity launchActivity;
        TextView textView2;
        ImageView imageView;
        View view;
        C0515f c0515f = (C0515f) this.f6977l;
        LaunchActivity launchActivity2 = (LaunchActivity) ((N1.p) this.f6976k).f1803l;
        try {
            View viewInflate = LayoutInflater.from(launchActivity2).inflate(R.layout.popup_unified_user, (ViewGroup) null);
            PopupWindow popupWindow = new PopupWindow(viewInflate, -1, -1);
            popupWindow.setFocusable(false);
            popupWindow.setTouchable(false);
            popupWindow.setOutsideTouchable(false);
            View viewFindViewById = viewInflate.findViewById(R.id.popup_container);
            TextView textView3 = (TextView) viewInflate.findViewById(R.id.popup_callsign);
            TextView textView4 = (TextView) viewInflate.findViewById(R.id.popup_device);
            TextView textView5 = (TextView) viewInflate.findViewById(R.id.popup_message);
            TextView textView6 = (TextView) viewInflate.findViewById(R.id.popup_distance);
            ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.unified_logo);
            View viewFindViewById2 = viewInflate.findViewById(R.id.glow_effect);
            StringBuilder sb = new StringBuilder("CallerInfo - callsign: '");
            String str = c0515f.f6699c;
            String str2 = c0515f.f6708o;
            String str3 = c0515f.f6702f;
            String str4 = c0515f.f6701e;
            String str5 = c0515f.f6697a;
            String str6 = c0515f.f6705k;
            sb.append(str);
            sb.append("'");
            Log.d("Unified - Main Activity", sb.toString());
            Log.d("Unified - Main Activity", "CallerInfo - fname: '" + str5 + "'");
            Log.d("Unified - Main Activity", "CallerInfo - distance: '" + str6 + "'");
            Log.d("Unified - Main Activity", "CallerInfo - city: '" + str4 + "'");
            Log.d("Unified - Main Activity", "CallerInfo - state: '" + str3 + "'");
            Log.d("Unified - Main Activity", "CallerInfo - bearing: '" + str2 + "'");
            String str7 = "Unknown";
            if (textView3 != null) {
                String str8 = c0515f.f6699c;
                if (str8 == null || str8.equals("null")) {
                    str8 = "Unknown";
                }
                textView3.setText(str8);
            }
            if (textView4 != null) {
                String str9 = c0515f.f6700d;
                if (str9 != null && !str9.equals("null")) {
                    str7 = str9;
                }
                textView4.setText(str7);
            }
            if (textView5 != null) {
                String strConcat = "is a Unified Radios User";
                if (str5 != null && !str5.equals("null") && !str5.isEmpty()) {
                    strConcat = str5.concat(" is a Unified Radios User");
                }
                textView = textView5;
                textView.setText(strConcat);
            } else {
                textView = textView5;
            }
            if (textView6 != null) {
                StringBuilder sb2 = new StringBuilder();
                if (str6 == null || str6.equals("null") || str6.isEmpty()) {
                    launchActivity = launchActivity2;
                } else {
                    launchActivity = launchActivity2;
                    int i5 = launchActivity.f5880J;
                    String str10 = c0515f.f6706l;
                    if (str10 == null || str10.equals("null")) {
                        sb2.append(str6);
                        sb2.append(" miles");
                    } else {
                        sb2.append(str6);
                        sb2.append(" ");
                        sb2.append(str10);
                    }
                    String strF = LaunchActivity.F(launchActivity, str2);
                    if (strF != null && !strF.isEmpty()) {
                        sb2.append(" ");
                        sb2.append(strF);
                    }
                }
                StringBuilder sb3 = new StringBuilder();
                if (str4 == null || str4.equals("null") || str4.isEmpty()) {
                    sb3.append(" from your location");
                } else {
                    sb3.append(" from ");
                    sb3.append(str4);
                    if (str3 != null && !str3.equals("null") && !str3.isEmpty()) {
                        sb3.append(", ");
                        sb3.append(str3);
                    }
                }
                sb2.append(sb3.toString());
                textView2 = textView6;
                textView2.setText(sb2.toString());
                Log.d("Unified - Main Activity", "Final distance text: '" + sb2.toString() + "'");
            } else {
                launchActivity = launchActivity2;
                textView2 = textView6;
            }
            viewFindViewById.setAlpha(BitmapDescriptorFactory.HUE_RED);
            viewFindViewById.setScaleX(0.3f);
            viewFindViewById.setScaleY(0.3f);
            if (imageView2 != null) {
                imageView = imageView2;
                imageView.setAlpha(BitmapDescriptorFactory.HUE_RED);
                imageView.setScaleX(0.5f);
                imageView.setScaleY(0.5f);
                imageView.setRotation(-180.0f);
            } else {
                imageView = imageView2;
            }
            if (viewFindViewById2 != null) {
                view = viewFindViewById2;
                view.setAlpha(BitmapDescriptorFactory.HUE_RED);
                view.setScaleX(2.0f);
                view.setScaleY(2.0f);
            } else {
                view = viewFindViewById2;
            }
            if (textView3 != null) {
                textView3.setAlpha(BitmapDescriptorFactory.HUE_RED);
                textView3.setTranslationY(-100.0f);
            }
            if (textView != null) {
                textView.setAlpha(BitmapDescriptorFactory.HUE_RED);
                textView.setTranslationX(-200.0f);
            }
            if (textView2 != null) {
                textView2.setAlpha(BitmapDescriptorFactory.HUE_RED);
                textView2.setTranslationY(100.0f);
            }
            popupWindow.showAtLocation(launchActivity.findViewById(android.R.id.content), 17, 0, 0);
            viewFindViewById.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(600L).setInterpolator(new OvershootInterpolator(1.2f)).start();
            if (imageView != null) {
                imageView.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).rotation(BitmapDescriptorFactory.HUE_RED).setDuration(800L).setStartDelay(200L).setInterpolator(new OvershootInterpolator(0.8f)).start();
            }
            if (view != null) {
                view.animate().alpha(0.3f).scaleX(1.0f).scaleY(1.0f).setDuration(1000L).setStartDelay(300L).start();
            }
            if (textView3 != null) {
                textView3.animate().alpha(1.0f).translationY(BitmapDescriptorFactory.HUE_RED).setDuration(500L).setStartDelay(400L).setInterpolator(new DecelerateInterpolator()).start();
            }
            if (textView != null) {
                textView.animate().alpha(1.0f).translationX(BitmapDescriptorFactory.HUE_RED).setDuration(500L).setStartDelay(600L).setInterpolator(new DecelerateInterpolator()).start();
            }
            if (textView2 != null) {
                textView2.animate().alpha(1.0f).translationY(BitmapDescriptorFactory.HUE_RED).setDuration(500L).setStartDelay(800L).setInterpolator(new DecelerateInterpolator()).start();
            }
            if (imageView != null) {
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageView, "rotation", BitmapDescriptorFactory.HUE_RED, 360.0f);
                objectAnimatorOfFloat.setDuration(8000L);
                objectAnimatorOfFloat.setRepeatCount(-1);
                objectAnimatorOfFloat.setRepeatMode(1);
                objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
                objectAnimatorOfFloat.setStartDelay(1000L);
                objectAnimatorOfFloat.start();
            }
            if (view != null) {
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "alpha", 0.1f, 0.5f);
                objectAnimatorOfFloat2.setDuration(2000L);
                objectAnimatorOfFloat2.setRepeatCount(-1);
                objectAnimatorOfFloat2.setRepeatMode(2);
                objectAnimatorOfFloat2.setStartDelay(1200L);
                objectAnimatorOfFloat2.start();
            }
            new Handler(Looper.getMainLooper()).postDelayed(new k(popupWindow, 10, viewFindViewById), DeviceOrientationRequest.OUTPUT_PERIOD_FAST);
        } catch (Exception e5) {
            Log.e("Unified - Main Activity", "Error showing Unified popup", e5);
        }
    }

    private final void b() {
        boolean z4;
        RadioTeamsActivity radioTeamsActivity = (RadioTeamsActivity) this.f6976k;
        radioTeamsActivity.f6020o.clear();
        ArrayList arrayList = radioTeamsActivity.f6020o;
        List<C0749g> list = (List) this.f6977l;
        arrayList.addAll(list);
        radioTeamsActivity.f6021p.notifyDataSetChanged();
        if (radioTeamsActivity.f6014f == null) {
            return;
        }
        for (Map.Entry entry : radioTeamsActivity.f6022q.entrySet()) {
            if (!"USER_LOCATION".equals(entry.getKey())) {
                radioTeamsActivity.f6014f.getOverlays().remove(entry.getValue());
            }
        }
        m4.d dVar = (m4.d) radioTeamsActivity.f6022q.get("USER_LOCATION");
        radioTeamsActivity.f6022q.clear();
        if (dVar != null) {
            radioTeamsActivity.f6022q.put("USER_LOCATION", dVar);
        }
        ArrayList arrayList2 = new ArrayList();
        int size = list.size();
        int i5 = 0;
        for (C0749g c0749g : list) {
            if ("online".equals(c0749g.f8408e) || "emergency".equals(c0749g.f8407d)) {
                i5++;
                if (c0749g.c()) {
                    k4.d dVar2 = new k4.d(c0749g.f8405b, c0749g.f8406c);
                    m4.d dVar3 = new m4.d(radioTeamsActivity.f6014f);
                    dVar3.i(dVar2);
                    dVar3.f8675b = c0749g.f8404a;
                    dVar3.f8676c = c0749g.b();
                    dVar3.g = 0.5f;
                    dVar3.h = 1.0f;
                    dVar3.h(radioTeamsActivity.k(c0749g.f8404a, "emergency".equals(c0749g.f8407d), false));
                    dVar3.f8668k = new C0202f(radioTeamsActivity, 10, c0749g);
                    radioTeamsActivity.f6014f.getOverlays().add(dVar3);
                    radioTeamsActivity.f6022q.put(c0749g.f8404a, dVar3);
                    arrayList2.add(dVar2);
                }
            }
        }
        Log.d("RadioTeamsActivity", String.format("Map markers updated: %d/%d members online, %d with location data", Integer.valueOf(i5), Integer.valueOf(size), Integer.valueOf(arrayList2.size())));
        if (!radioTeamsActivity.f6012d && !radioTeamsActivity.f6011c && !arrayList2.isEmpty()) {
            if (arrayList2.size() == 1) {
                ((l4.f) radioTeamsActivity.g).c((d4.a) arrayList2.get(0));
                ((l4.f) radioTeamsActivity.g).d(15.0d);
                z4 = true;
            } else {
                Iterator it = arrayList2.iterator();
                double dMax = Double.MIN_VALUE;
                double dMin = Double.MAX_VALUE;
                double dMin2 = Double.MAX_VALUE;
                double dMax2 = Double.MIN_VALUE;
                while (it.hasNext()) {
                    k4.d dVar4 = (k4.d) it.next();
                    dMin = Math.min(dMin, dVar4.f8265k);
                    dMax = Math.max(dMax, dVar4.f8265k);
                    dMin2 = Math.min(dMin2, dVar4.f8264j);
                    dMax2 = Math.max(dMax2, dVar4.f8264j);
                }
                ((l4.f) radioTeamsActivity.g).c(new k4.d((dMin + dMax) / 2.0d, (dMin2 + dMax2) / 2.0d));
                double dMax3 = Math.max(dMax - dMin, dMax2 - dMin2);
                ((l4.f) radioTeamsActivity.g).d(dMax3 > 0.1d ? 10.0d : dMax3 > 0.01d ? 12.0d : dMax3 > 0.001d ? 14.0d : 16.0d);
                z4 = true;
            }
            radioTeamsActivity.f6012d = z4;
        }
        radioTeamsActivity.f6014f.invalidate();
    }

    private final void c() throws JSONException {
        l3.k kVar = (l3.k) this.f6977l;
        int i5 = RadioTeamsManagerActivity.f6026l;
        RadioTeamsManagerActivity radioTeamsManagerActivity = (RadioTeamsManagerActivity) this.f6976k;
        radioTeamsManagerActivity.getClass();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("team_id", kVar.f8423a);
            jSONObject.put("callsign", kVar.f8424b);
            Log.d("RadioTeamsManager", "Unsubscribe request: " + jSONObject.toString());
            String strL = RadioTeamsManagerActivity.l("https://ur1.unifiedradios.com/api-teams/unsubscribe.php", jSONObject);
            Log.d("RadioTeamsManager", "Unsubscribe response: ".concat(strL));
            radioTeamsManagerActivity.f6033k.post(new D0.f(radioTeamsManagerActivity, new JSONObject(strL), kVar, 15));
        } catch (Exception e5) {
            Log.e("RadioTeamsManager", "Error unsubscribing from team", e5);
            radioTeamsManagerActivity.f6033k.post(new RunnableC0751i(radioTeamsManagerActivity, e5, 0));
        }
    }

    private final void d() {
        C0776l c0776l = (C0776l) this.f6977l;
        int i5 = RecordingsActivity.f6091j;
        RecordingsActivity recordingsActivity = (RecordingsActivity) this.f6976k;
        recordingsActivity.getClass();
        C0777m c0777mR = DmrDatabase.q(recordingsActivity).r();
        AbstractC0737m abstractC0737m = (AbstractC0737m) c0777mR.f8620c;
        abstractC0737m.b();
        abstractC0737m.c();
        try {
            L0.p pVar = (L0.p) c0777mR.f8621d;
            C0847j c0847jA = pVar.a();
            try {
                pVar.q(c0847jA, c0776l);
                c0847jA.c();
                pVar.n(c0847jA);
                abstractC0737m.o();
                abstractC0737m.k();
                recordingsActivity.runOnUiThread(new m3.w(recordingsActivity, 1));
            } catch (Throwable th) {
                pVar.n(c0847jA);
                throw th;
            }
        } catch (Throwable th2) {
            abstractC0737m.k();
            throw th2;
        }
    }

    @Override // java.lang.Runnable
    public final void run() throws JSONException {
        String strString;
        JSONObject jSONObjectOptJSONObject;
        Location location;
        String str;
        String str2;
        int i5 = 3;
        int i6 = 1;
        Object obj = this.f6977l;
        Object obj2 = this.f6976k;
        switch (this.f6975j) {
            case 0:
                l lVar = (l) obj2;
                lVar.getClass();
                boolean zEquals = "1".equals((String) obj);
                ChatActivity chatActivity = lVar.f6979d;
                if (!zEquals) {
                    int i7 = ChatActivity.f5725L;
                    chatActivity.r();
                    return;
                }
                LinearLayout linearLayout = chatActivity.f5755y;
                if (linearLayout == null || chatActivity.f5754x == null || chatActivity.f5756z == null) {
                    return;
                }
                linearLayout.setVisibility(0);
                if (chatActivity.f5752v) {
                    chatActivity.f5756z.setText("Someone is typing...");
                } else {
                    chatActivity.f5756z.setText(chatActivity.f5746p + " is typing...");
                }
                TypingBubbleView typingBubbleView = chatActivity.f5754x;
                ValueAnimator valueAnimator = typingBubbleView.g;
                if (valueAnimator != null && !valueAnimator.isRunning()) {
                    typingBubbleView.g.start();
                }
                RecyclerView recyclerView = chatActivity.f5738e;
                if (recyclerView != null) {
                    recyclerView.post(new RunnableC0551b(chatActivity, i5));
                    return;
                }
                return;
            case 1:
                ChatActivity chatActivity2 = ((l) obj2).f6979d;
                chatActivity2.h.setEnabled(true);
                chatActivity2.h.setAlpha(1.0f);
                Log.e("ChatActivity", "=== NETWORK ERROR ===");
                StringBuilder sb = new StringBuilder("Error Message: ");
                Throwable th = (Throwable) obj;
                sb.append(th.getMessage());
                Log.e("ChatActivity", sb.toString());
                Toast.makeText(chatActivity2, "Network error: " + th.getMessage(), 1).show();
                return;
            case 2:
                ChatActivity chatActivity3 = ((l) obj2).f6979d;
                chatActivity3.h.setEnabled(true);
                chatActivity3.h.setAlpha(1.0f);
                Log.d("ChatActivity", "=== API RESPONSE RECEIVED ===");
                StringBuilder sb2 = new StringBuilder("Response Code: ");
                Response response = (Response) obj;
                sb2.append(response.code());
                Log.d("ChatActivity", sb2.toString());
                Log.d("ChatActivity", "Is Successful: " + response.isSuccessful());
                if (response.isSuccessful()) {
                    ApiResponse apiResponse = (ApiResponse) response.body();
                    if (apiResponse != null) {
                        Log.d("ChatActivity", "Response Success: " + apiResponse.isSuccess());
                        Log.d("ChatActivity", "Response Message: " + apiResponse.getMessage());
                    }
                    Log.d("ChatActivity", "Message sent successfully - waiting for automatic update");
                    Toast.makeText(chatActivity3, "Message sent!", 0).show();
                    return;
                }
                String str3 = chatActivity3.f5752v ? "Failed to send team message" : "Failed to send message";
                try {
                    String strString2 = response.errorBody() != null ? response.errorBody().string() : "No error body";
                    Log.e("ChatActivity", "=== SEND MESSAGE FAILED ===");
                    Log.e("ChatActivity", "HTTP Code: " + response.code());
                    Log.e("ChatActivity", "Error Body: " + strString2);
                    String str4 = str3 + "\nHTTP " + response.code() + ": " + response.message();
                    if (strString2.length() < 200) {
                        str4 = str4 + "\n" + strString2;
                    }
                    Toast.makeText(chatActivity3, str4, 1).show();
                    return;
                } catch (Exception e5) {
                    Log.e("ChatActivity", "Error reading error response: " + e5.getMessage());
                    Toast.makeText(chatActivity3, str3 + " (Code: " + response.code() + ")", 0).show();
                    return;
                }
            case 3:
                ComposeMessageActivity composeMessageActivity = (ComposeMessageActivity) ((f) obj2).f6967d;
                if (composeMessageActivity.f5802o == null || composeMessageActivity.n == null) {
                    composeMessageActivity.r(R.drawable.ic_error, R.color.accent_red, "Search unavailable");
                    return;
                }
                String str5 = (String) obj;
                com.unified.ur1.SatelliteTracker.h.q(new StringBuilder("Searching for user: "), str5, "ComposeMessageActivity");
                composeMessageActivity.f5802o.searchUsersRaw(str5, composeMessageActivity.n).enqueue(new C0519j(composeMessageActivity, str5));
                return;
            case 4:
                ((ProfileInstallerInitializer) obj2).getClass();
                AbstractC0595h.a(Looper.getMainLooper()).postDelayed(new f.k((Context) obj, i6), new Random().nextInt(Math.max(1000, 1)) + 5000);
                return;
            case 5:
                E0 e02 = (E0) obj;
                C0605c c0605c = (C0605c) obj2;
                C0604b c0604b = c0605c.f7610f;
                try {
                    c0605c.e();
                    c0605c.d();
                    c0605c.g();
                    if (c0605c.f7608d) {
                        c0605c.f();
                    }
                    c0605c.a();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
                    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                    c0604b.f7590k = simpleDateFormat.format(new Date()) + " UTC";
                    c0604b.f7591l = c0605c.h() ? "Day" : "Night";
                    if (c0605c.f7608d) {
                        c0604b.f7591l += " (Local)";
                    } else {
                        c0604b.f7591l += " (UTC)";
                    }
                    if (e02 != null) {
                        e02.e(c0604b);
                        return;
                    }
                    return;
                } catch (Exception e6) {
                    Log.e("SolarDataManager", "Error fetching solar data", e6);
                    if (e02 != null) {
                        ((OptionsActivity) e02.I).runOnUiThread(new RunnableC0721z(e02, (Dialog) e02.f6571i, e02.f6565a, e02.h, e02.f6564H, e6.getMessage()));
                        return;
                    }
                    return;
                }
            case 6:
                HashMap map = DTMFKeypad.f5846k;
                ((C0836b) obj2).c((byte[]) ((byte[]) obj).clone());
                return;
            case 7:
                JSONObject jSONObject = (JSONObject) obj;
                Context context = LaunchActivity.f5853D1;
                LaunchActivity launchActivity = (LaunchActivity) obj2;
                launchActivity.getClass();
                try {
                    String string = jSONObject.getString("status");
                    Log.e("Unified - Main Activity", "Validation Response: " + string);
                    if ("SUCCESS".equals(string)) {
                        if (!jSONObject.has("callsign") || jSONObject.isNull("callsign")) {
                            h4.c.c0(launchActivity, 888);
                            launchActivity.f5900U = "NOCALL";
                            launchActivity.P0("callsign", "NOCALL");
                            h4.c.L(launchActivity, "NOCALL");
                        } else {
                            launchActivity.f5900U = jSONObject.getString("callsign");
                            String string2 = jSONObject.getString("radio_id");
                            launchActivity.P0("callsign", launchActivity.f5900U);
                            h4.c.L(launchActivity, launchActivity.f5900U);
                            h4.c.c0(launchActivity, Integer.parseInt(string2));
                        }
                    }
                    return;
                } catch (JSONException unused) {
                    return;
                }
            case 8:
                Toast.makeText(((O) obj2).f8001b, (String) obj, 0).show();
                return;
            case 9:
                a();
                return;
            case 10:
                PopupWindow popupWindow = (PopupWindow) obj2;
                if (popupWindow.isShowing()) {
                    ((View) obj).animate().alpha(BitmapDescriptorFactory.HUE_RED).scaleX(0.3f).scaleY(0.3f).setDuration(300L).setInterpolator(new AccelerateInterpolator()).withEndAction(new C0.e(24, popupWindow)).start();
                    return;
                }
                return;
            case 11:
                String str6 = (String) obj;
                y0 y0Var = (y0) obj2;
                LaunchActivity launchActivity2 = y0Var.f8250j;
                OkHttpClient.Builder builder = new OkHttpClient.Builder();
                TimeUnit timeUnit = TimeUnit.SECONDS;
                OkHttpClient okHttpClientBuild = builder.connectTimeout(15L, timeUnit).readTimeout(15L, timeUnit).build();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("callsign", launchActivity2.f5900U);
                    jSONObject2.put("cloud_auth", LaunchActivity.I1);
                    jSONObject2.put("team_id", str6);
                    try {
                        okhttp3.Response responseExecute = okHttpClientBuild.newCall(new Request.Builder().url("https://ur1.unifiedradios.com/api-teams/team_user_update.php").post(RequestBody.create(jSONObject2.toString(), MediaType.get("application/json; charset=utf-8"))).addHeader("Content-Type", "application/json").addHeader("Cache-Control", "no-cache, no-store, must-revalidate").addHeader("Pragma", "no-cache").addHeader("Expires", "0").build()).execute();
                        ResponseBody responseBodyBody = responseExecute.body();
                        if (responseBodyBody != null) {
                            try {
                                strString = responseBodyBody.string();
                            } finally {
                            }
                        } else {
                            strString = "";
                        }
                        if (launchActivity2.f5900U.equals("N4KYS")) {
                            Log.d("Unified - Main Activity", "Team sync response code: " + responseExecute.code());
                            Log.d("Unified - Main Activity", "Team sync response body: " + strString);
                        }
                        if (!responseExecute.isSuccessful() || strString.isEmpty()) {
                            Log.e("Unified - Main Activity", "Team sync request failed with code: " + responseExecute.code());
                            if (!strString.isEmpty()) {
                                Log.e("Unified - Main Activity", "Team sync error response: ".concat(strString));
                            }
                        } else {
                            JSONObject jSONObject3 = new JSONObject(strString);
                            if (jSONObject3.has("success") && jSONObject3.getBoolean("success")) {
                                String strOptString = jSONObject3.optString("message", "Location synced");
                                JSONObject jSONObjectOptJSONObject2 = jSONObject3.optJSONObject("data");
                                if (launchActivity2.f5900U.equals("N4KYS")) {
                                    Log.d("Unified - Main Activity", "Team sync successful: " + strOptString);
                                    if (jSONObjectOptJSONObject2 != null && (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject("location")) != null) {
                                        Log.d("Unified - Main Activity", "Synced location: " + jSONObjectOptJSONObject.optDouble("latitude") + "," + jSONObjectOptJSONObject.optDouble("longitude"));
                                    }
                                }
                                launchActivity2.runOnUiThread(new C0.e(26, y0Var));
                            } else {
                                String strOptString2 = jSONObject3.optString("error", "Unknown error");
                                Log.e("Unified - Main Activity", "Team sync API error: " + strOptString2);
                                if (strOptString2.contains("Team ID") && strOptString2.contains("not found")) {
                                    Log.w("Unified - Main Activity", "Team not found - may need to join team first");
                                } else if (strOptString2.contains("Invalid cloud_auth")) {
                                    Log.e("Unified - Main Activity", "Authentication failed for team sync");
                                } else if (strOptString2.contains("No location data")) {
                                    Log.w("Unified - Main Activity", "No location data available in device table");
                                }
                            }
                        }
                        if (responseBodyBody != null) {
                            responseBodyBody.close();
                        }
                    } catch (JSONException e7) {
                        Log.e("Unified - Main Activity", "Team sync JSON parsing error: " + e7.getMessage());
                    } catch (Exception e8) {
                        com.unified.ur1.SatelliteTracker.h.o(e8, new StringBuilder("Team sync error: "), "Unified - Main Activity");
                    }
                    Handler handler = launchActivity2.f5946n1;
                    if (handler == null || !launchActivity2.f5955q1) {
                        return;
                    }
                    handler.postDelayed(launchActivity2.f5868C1, 30000L);
                    return;
                } catch (JSONException e9) {
                    Log.e("Unified - Main Activity", "Error creating team sync JSON payload: " + e9.getMessage());
                    return;
                }
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                DialogInterfaceOnClickListenerC0681d0 dialogInterfaceOnClickListenerC0681d0 = (DialogInterfaceOnClickListenerC0681d0) obj2;
                dialogInterfaceOnClickListenerC0681d0.getClass();
                Log.d("Unified - Main Activity", "Calling Validation 3 = " + ((String) obj));
                Context context2 = LaunchActivity.f5853D1;
                ((LaunchActivity) dialogInterfaceOnClickListenerC0681d0.f8120d).Q0();
                return;
            case o1.f.ERROR /* 13 */:
                OptionsActivity optionsActivity = (OptionsActivity) obj2;
                C0605c c0605c2 = (C0605c) obj;
                if (!optionsActivity.f5992f || (location = optionsActivity.f5991e) == null) {
                    c0605c2.f7606b = 39.8283d;
                    c0605c2.f7607c = -98.5795d;
                    c0605c2.f7608d = true;
                    Log.w("Unified - Settings", "Using default location for solar data");
                    Toast.makeText(optionsActivity, "Using approximate location for weather data", 0).show();
                    return;
                }
                double latitude = location.getLatitude();
                double longitude = optionsActivity.f5991e.getLongitude();
                c0605c2.f7606b = latitude;
                c0605c2.f7607c = longitude;
                c0605c2.f7608d = true;
                Log.d("Unified - Settings", String.format("GPS location ready for solar data: %.4f, %.4f", Double.valueOf(latitude), Double.valueOf(longitude)));
                return;
            case o1.f.INTERRUPTED /* 14 */:
                OptionsActivity optionsActivity2 = (OptionsActivity) obj2;
                if (optionsActivity2.f5992f) {
                    return;
                }
                Log.w("Unified - Settings", "Location timeout, using default location");
                optionsActivity2.f5991e = OptionsActivity.k();
                optionsActivity2.f5992f = true;
                optionsActivity2.f5990d.removeUpdates((LocationListener) obj);
                Toast.makeText(optionsActivity2, "Unable to get precise location. Using approximate location.", 0).show();
                return;
            case 15:
                b();
                return;
            case 16:
                int i8 = RadioTeamsActivity.f6010u;
                ((InterfaceC0748f) obj2).b((String) obj);
                return;
            case o1.f.API_NOT_CONNECTED /* 17 */:
                int i9 = RadioTeamsActivity.f6010u;
                ((InterfaceC0748f) obj2).b("Login failed: " + ((Exception) obj).getMessage());
                return;
            case 18:
                JSONObject jSONObject4 = (JSONObject) obj;
                int i10 = RadioTeamsActivity.f6010u;
                RadioTeamsActivity radioTeamsActivity = (RadioTeamsActivity) obj2;
                radioTeamsActivity.getClass();
                try {
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put("action", "save_profile");
                    jSONObject5.put("session_token", radioTeamsActivity.f6017k);
                    jSONObject5.put("profile", jSONObject4);
                    radioTeamsActivity.f6024s.post(new D0.f(radioTeamsActivity, new JSONObject(radioTeamsActivity.p("POST", null, jSONObject5)), jSONObject4, 13));
                    return;
                } catch (Exception e10) {
                    Log.e("RadioTeamsActivity", "Error saving profile", e10);
                    radioTeamsActivity.f6024s.post(new RunnableC0743a(radioTeamsActivity, i5));
                    return;
                }
            case o1.f.REMOTE_EXCEPTION /* 19 */:
                c();
                return;
            case o1.f.CONNECTION_SUSPENDED_DURING_CALL /* 20 */:
                int i11 = RadioTeamsManagerActivity.f6026l;
                Toast.makeText((RadioTeamsManagerActivity) obj2, "Failed to discover teams: " + ((JSONObject) obj).optString("message"), 1).show();
                return;
            case o1.f.RECONNECTION_TIMED_OUT_DURING_UPDATE /* 21 */:
                ((DmrAudioService) obj2).f6047r.c((byte[]) obj);
                return;
            case o1.f.RECONNECTION_TIMED_OUT /* 22 */:
                C0836b c0836b = (C0836b) obj;
                ((DmrAudioService) obj2).f6047r = c0836b;
                StringBuilder sb3 = new StringBuilder("Audio data callback set: ");
                sb3.append(c0836b != null);
                Log.d("DmrAudioService", sb3.toString());
                return;
            case 23:
                m3.z zVar = ((RecordingsActivity) obj2).f6092c;
                zVar.f8645a = (List) obj;
                zVar.notifyDataSetChanged();
                return;
            case 24:
                int i12 = RecordingsActivity.f6091j;
                RecordingsActivity recordingsActivity = (RecordingsActivity) obj2;
                recordingsActivity.getClass();
                Toast.makeText(recordingsActivity, (String) obj, 0).show();
                return;
            case 25:
                d();
                return;
            default:
                o3.x xVar = (o3.x) ((f) obj2).f6967d;
                int i13 = xVar.f8984H;
                String str7 = (String) obj;
                if (i13 == 2) {
                    xVar.n.clear();
                    if (str7.isEmpty()) {
                        xVar.n.addAll(xVar.f8995m);
                    } else {
                        String lowerCase = str7.toLowerCase();
                        Iterator it = xVar.f8995m.iterator();
                        while (it.hasNext()) {
                            o3.s sVar = (o3.s) it.next();
                            if (sVar.f8951b.toLowerCase().contains(lowerCase) || sVar.f8952c.toLowerCase().contains(lowerCase) || sVar.f8955f.toLowerCase().contains(lowerCase) || sVar.h.toLowerCase().contains(lowerCase) || ((str2 = sVar.f8957j) != null && str2.toLowerCase().contains(lowerCase))) {
                                xVar.n.add(sVar);
                            }
                        }
                    }
                    xVar.f8991i.notifyDataSetChanged();
                    xVar.m();
                    return;
                }
                if (i13 == 3) {
                    if (str7.isEmpty()) {
                        xVar.f8994l.clear();
                        xVar.f8994l.addAll(xVar.f8993k);
                        xVar.h.notifyDataSetChanged();
                        xVar.m();
                        return;
                    }
                    xVar.f8994l.clear();
                    String lowerCase2 = str7.toLowerCase();
                    Iterator it2 = xVar.f8993k.iterator();
                    boolean z4 = false;
                    while (it2.hasNext()) {
                        o3.v vVar = (o3.v) it2.next();
                        if (vVar.f8968c.toLowerCase().contains(lowerCase2) || vVar.f8969d.toLowerCase().contains(lowerCase2) || ((str = vVar.f8970e) != null && str.toLowerCase().contains(lowerCase2))) {
                            xVar.f8994l.add(vVar);
                            if (vVar.f8968c.equals(str7.trim())) {
                                z4 = true;
                            }
                        }
                    }
                    if (!z4 && o3.x.f(str7)) {
                        xVar.f8994l.add(0, xVar.b(str7));
                    }
                    xVar.h.notifyDataSetChanged();
                    xVar.m();
                    if (xVar.f8989e == null) {
                        return;
                    }
                    xVar.f8977A.setVisibility(0);
                    h4.c.I(xVar.f8985a).a(new o3.p(xVar.f8986b + "/talkgroups?cloud_auth=" + xVar.f8987c + "&network=" + xVar.f8989e + "&search=" + str7, new o3.l(xVar, str7), new o3.l(xVar, str7)));
                    return;
                }
                return;
        }
    }
}
