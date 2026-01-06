package L0;

import B.w;
import D1.AbstractC0019q;
import D1.BinderC0008f;
import D1.BinderC0024w;
import D1.C0025x;
import D1.F;
import D1.K;
import D1.T;
import D1.U;
import D1.a0;
import J1.C0058c1;
import J1.C0113v0;
import J1.InterfaceC0081k0;
import J1.RunnableC0122y0;
import J1.V1;
import J1.Z;
import O.InterfaceC0162f;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContentInfo;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputContentInfo;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.work.impl.WorkDatabase;
import com.google.android.gms.location.CurrentLocationRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.zzo;
import com.unified.ur1.chat.ChatActivity;
import com.unified.ur1.inbox.Message;
import com.unified.ur1.inbox.MessageResponse;
import com.unified.ur1.inbox.UnifiedInboxActivity;
import f.C0458D;
import f3.C0519j;
import h1.C0558b;
import i3.D;
import i3.DialogInterfaceOnClickListenerC0580i;
import i3.E;
import i3.y;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.TreeMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import k.InterfaceC0630f0;
import k.InterfaceC0643m;
import k.c1;
import l0.AbstractC0737m;
import m0.AbstractC0759a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import q1.AbstractBinderC0860k;
import q1.InterfaceC0861l;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes.dex */
public final class l implements p1.o, p1.m, N1.e, InterfaceC0162f, W1.a, androidx.emoji2.text.i, InterfaceC0630f0, j.k, i3.s, Callback, j3.f {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1553c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f1554d;

    public /* synthetic */ l(int i5, Object obj) {
        this.f1553c = i5;
        this.f1554d = obj;
    }

    @Override // O.InterfaceC0162f
    public ClipData a() {
        return ((ContentInfo) this.f1554d).getClip();
    }

    @Override // j3.f
    public void b(String str) throws JSONException {
        Log.w("WeatherDataManager", "WeatherAPI also failed, trying NOAA: " + str);
        j3.e eVar = (j3.e) ((Z2.c) this.f1554d).f3147d;
        C0558b c0558b = eVar.f7615f;
        double d5 = eVar.f7613d;
        double d6 = eVar.f7614e;
        j3.f fVar = eVar.f7612c;
        c0558b.getClass();
        try {
            JSONArray jSONArray = new JSONObject(C0558b.h(new JSONObject(C0558b.h(String.format("https://api.weather.gov/points/%.4f,%.4f", Double.valueOf(d5), Double.valueOf(d6)))).getJSONObject("properties").getString("observationStations"))).getJSONArray("features");
            if (jSONArray.length() == 0) {
                fVar.b("No NOAA stations found nearby");
                return;
            }
            JSONObject jSONObject = new JSONObject(C0558b.h("https://api.weather.gov/stations/" + jSONArray.getJSONObject(0).getJSONObject("properties").getString("stationIdentifier") + "/observations/latest")).getJSONObject("properties");
            j3.g gVar = new j3.g();
            if (jSONObject.has("barometricPressure") && !jSONObject.isNull("barometricPressure")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("barometricPressure");
                if (!jSONObject2.isNull("value")) {
                    gVar.f7616a = jSONObject2.getDouble("value") / 100.0d;
                }
            }
            if (jSONObject.has("temperature") && !jSONObject.isNull("temperature")) {
                JSONObject jSONObject3 = jSONObject.getJSONObject("temperature");
                if (!jSONObject3.isNull("value")) {
                    gVar.f7617b = jSONObject3.getDouble("value");
                }
            }
            if (jSONObject.has("relativeHumidity") && !jSONObject.isNull("relativeHumidity")) {
                JSONObject jSONObject4 = jSONObject.getJSONObject("relativeHumidity");
                if (!jSONObject4.isNull("value")) {
                    gVar.f7618c = jSONObject4.getDouble("value");
                }
            }
            if (jSONObject.has("windSpeed") && !jSONObject.isNull("windSpeed")) {
                JSONObject jSONObject5 = jSONObject.getJSONObject("windSpeed");
                if (!jSONObject5.isNull("value")) {
                    gVar.f7619d = jSONObject5.getDouble("value") * 3.6d;
                }
            }
            if (jSONObject.has("timestamp")) {
                jSONObject.getString("timestamp");
            }
            Log.d("WeatherDataManager", String.format("NOAA: Pressure=%.1f hPa, Temp=%.1f°C, Humidity=%.1f%%", Double.valueOf(gVar.f7616a), Double.valueOf(gVar.f7617b), Double.valueOf(gVar.f7618c)));
            C0558b.a(gVar);
            fVar.c(gVar);
        } catch (Exception e5) {
            StringBuilder sbG = com.unified.ur1.SatelliteTracker.h.g("WeatherDataManager", "Error fetching NOAA data", e5, "NOAA: ");
            sbG.append(e5.getMessage());
            fVar.b(sbG.toString());
        }
    }

    @Override // j3.f
    public void c(j3.g gVar) {
        Z2.c cVar = (Z2.c) this.f1554d;
        ((j3.e) cVar.f3147d).f7615f.getClass();
        C0558b.a(gVar);
        ((j3.e) cVar.f3147d).f7612c.c(gVar);
    }

    @Override // androidx.emoji2.text.i
    public void d(h4.d dVar) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new androidx.emoji2.text.a("EmojiCompatInitializer"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        threadPoolExecutor.execute(new D0.f(this, dVar, threadPoolExecutor, 2));
    }

    @Override // j.k
    public void e(j.m mVar) {
        switch (this.f1553c) {
            case o1.f.CONNECTION_SUSPENDED_DURING_CALL /* 20 */:
                C0458D c0458d = (C0458D) this.f1554d;
                boolean zQ = c0458d.f6246a.f7769a.q();
                Window.Callback callback = c0458d.f6247b;
                if (!zQ) {
                    if (callback.onPreparePanel(0, null, mVar)) {
                        callback.onMenuOpened(108, mVar);
                        break;
                    }
                } else {
                    callback.onPanelClosed(108, mVar);
                    break;
                }
                break;
            default:
                j.k kVar = ((ActionMenuView) this.f1554d).f3370x;
                if (kVar != null) {
                    kVar.e(mVar);
                    break;
                }
                break;
        }
    }

    @Override // i3.s
    public void f(Message message, int i5) {
        i3.m.g((i3.m) this.f1554d, message, i5);
    }

    @Override // j.k
    public boolean g(j.m mVar, MenuItem menuItem) {
        switch (this.f1553c) {
            case o1.f.CONNECTION_SUSPENDED_DURING_CALL /* 20 */:
                return false;
            default:
                InterfaceC0643m interfaceC0643m = ((ActionMenuView) this.f1554d).f3363C;
                if (interfaceC0643m == null) {
                    return false;
                }
                Toolbar toolbar = (Toolbar) ((Z2.c) interfaceC0643m).f3147d;
                Iterator it = toolbar.I.f1949b.iterator();
                if (it.hasNext()) {
                    com.unified.ur1.SatelliteTracker.h.p(it.next());
                    throw null;
                }
                c1 c1Var = toolbar.f3449K;
                return c1Var != null ? ((C0458D) ((C0519j) c1Var).f6730d).f6247b.onMenuItemSelected(0, menuItem) : false;
        }
    }

    @Override // i3.s
    public void h(Message message) {
        i3.m mVar = (i3.m) this.f1554d;
        if (mVar.getContext() == null) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(mVar.getContext());
        String[] strArr = message.isRead() ? new String[]{"Mark as Unread", "Delete", "Forward", "Reply"} : new String[]{"Mark as Read", "Delete", "Forward", "Reply"};
        if (message.isTeamMessage()) {
            message.getTeamId();
        } else if (message.getFromCallsign() != null) {
            message.getFromCallsign();
        }
        builder.setTitle("Message Options").setItems(strArr, new DialogInterfaceOnClickListenerC0580i(mVar, 0, message)).show();
    }

    @Override // O.InterfaceC0162f
    public int i() {
        return ((ContentInfo) this.f1554d).getFlags();
    }

    @Override // p1.m
    public /* synthetic */ void j(Object obj) {
        ((LocationCallback) obj).onLocationAvailability((LocationAvailability) this.f1554d);
    }

    @Override // N1.e
    public /* synthetic */ void k(N1.j jVar) {
        if (jVar.f()) {
            return;
        }
        Exception excC = jVar.c();
        Objects.requireNonNull(excC);
        ((N1.k) this.f1554d).b(excC);
    }

    @Override // i3.s
    public void l(Message message) {
        boolean zIsTeamMessage = message.isTeamMessage();
        i3.m mVar = (i3.m) this.f1554d;
        if (zIsTeamMessage) {
            String teamId = message.getTeamId();
            String fromCallsign = message.getFromCallsign();
            if (mVar.getContext() != null) {
                Intent intent = new Intent(mVar.getContext(), (Class<?>) ChatActivity.class);
                intent.putExtra("team_id", teamId);
                if (fromCallsign.startsWith("Teams: ")) {
                    fromCallsign = fromCallsign.substring(6);
                }
                intent.putExtra("team_name", fromCallsign);
                mVar.getContext().startActivity(intent);
                return;
            }
            return;
        }
        String displayTime = message.getDisplayTime();
        if (displayTime == null || displayTime.isEmpty() || displayTime.startsWith("TEAM:")) {
            i3.l lVar = mVar.f7320i;
            displayTime = message.getFromCallsign().equals(lVar != null ? ((UnifiedInboxActivity) lVar).f5836j : h4.c.h(mVar.getContext())) ? message.getToCallsign() : message.getFromCallsign();
        }
        if (mVar.getContext() != null) {
            Intent intent2 = new Intent(mVar.getContext(), (Class<?>) ChatActivity.class);
            intent2.putExtra("other_user_callsign", displayTime);
            mVar.getContext().startActivity(intent2);
        }
    }

    @Override // O.InterfaceC0162f
    public ContentInfo m() {
        return (ContentInfo) this.f1554d;
    }

    @Override // O.InterfaceC0162f
    public int n() {
        return ((ContentInfo) this.f1554d).getSource();
    }

    @Override // i3.s
    public void o(Message message) {
        i3.l lVar = ((i3.m) this.f1554d).f7320i;
        if (lVar != null) {
            ((UnifiedInboxActivity) lVar).t(message);
        }
    }

    @Override // retrofit2.Callback
    public void onFailure(Call call, Throwable th) {
        switch (this.f1553c) {
            case 24:
                Log.e("SentFragment", "=== SentFragment API Call Failed ===");
                Log.e("SentFragment", "Error: " + th.getMessage(), th);
                E e5 = (E) this.f1554d;
                SwipeRefreshLayout swipeRefreshLayout = e5.f7277d;
                if (swipeRefreshLayout != null) {
                    swipeRefreshLayout.setRefreshing(false);
                }
                if (e5.getContext() != null) {
                    Toast.makeText(e5.getContext(), "Network error: " + th.getMessage(), 0).show();
                    break;
                }
                break;
            default:
                Log.e("UnifiedInbox", "API Call Failed: " + th.getMessage(), th);
                UnifiedInboxActivity unifiedInboxActivity = (UnifiedInboxActivity) this.f1554d;
                ProgressBar progressBar = unifiedInboxActivity.f5831c;
                if (progressBar != null) {
                    progressBar.setVisibility(8);
                }
                Toast.makeText(unifiedInboxActivity, "Network error: " + th.getMessage(), 0).show();
                break;
        }
    }

    @Override // retrofit2.Callback
    public void onResponse(Call call, Response response) {
        switch (this.f1553c) {
            case 24:
                E e5 = (E) this.f1554d;
                SwipeRefreshLayout swipeRefreshLayout = e5.f7277d;
                int i5 = 0;
                if (swipeRefreshLayout != null) {
                    swipeRefreshLayout.setRefreshing(false);
                }
                if (!response.isSuccessful() || response.body() == null) {
                    Log.e("SentFragment", "Sent messages response not successful or body is null");
                    Log.e("SentFragment", "Response code: " + response.code());
                    if (response.errorBody() != null) {
                        try {
                            Log.e("SentFragment", "Error body: " + response.errorBody().string());
                        } catch (Exception e6) {
                            Log.e("SentFragment", "Error reading error body", e6);
                        }
                    }
                    if (e5.getContext() != null) {
                        Toast.makeText(e5.getContext(), "Failed to load sent messages (Code: " + response.code() + ")", 0).show();
                        break;
                    }
                } else {
                    List<Message> messages = ((MessageResponse) response.body()).getMessages();
                    if (messages != null) {
                        Log.d("SentFragment", "Total sent messages received: " + messages.size());
                        e5.g.clear();
                        int i6 = 0;
                        for (Message message : messages) {
                            if (!message.isDeleted()) {
                                e5.g.add(message);
                                i6++;
                            }
                        }
                        Log.d("SentFragment", "Sent messages added to fragment list: " + i6);
                        Log.d("SentFragment", "Fragment sentMessageList size: " + e5.g.size());
                        if (e5.f7279f != null) {
                            Log.d("SentFragment", "Notifying sent adapter of data change");
                            e5.f7279f.notifyDataSetChanged();
                        } else {
                            Log.e("SentFragment", "SentMessageAdapter is null!");
                        }
                        if (e5.g.isEmpty()) {
                            e5.f7278e.setVisibility(0);
                            e5.f7276c.setVisibility(8);
                        } else {
                            e5.f7278e.setVisibility(8);
                            e5.f7276c.setVisibility(0);
                        }
                        if (e5.h != null) {
                            Iterator it = e5.g.iterator();
                            while (it.hasNext()) {
                                if (!((Message) it.next()).isRead()) {
                                    i5++;
                                }
                            }
                            D d5 = e5.h;
                            int size = e5.g.size();
                            UnifiedInboxActivity unifiedInboxActivity = (UnifiedInboxActivity) d5;
                            unifiedInboxActivity.getClass();
                            StringBuilder sb = new StringBuilder("Sent message stats updated: ");
                            sb.append(size);
                            sb.append(" sent, ");
                            sb.append(i5);
                            com.unified.ur1.SatelliteTracker.h.q(sb, " delivered", "UnifiedInbox");
                            SharedPreferences.Editor editorEdit = unifiedInboxActivity.f5837k.edit();
                            editorEdit.putInt("sent_message_count", size);
                            editorEdit.putInt("delivered_message_count", i5);
                            editorEdit.putLong("last_stats_update", System.currentTimeMillis());
                            editorEdit.apply();
                            Log.d("SentFragment", "Updated sent message stats: " + e5.g.size() + " total, " + i5 + " unread");
                        }
                        Log.d("SentFragment", "Loaded " + e5.g.size() + " sent messages");
                        break;
                    } else {
                        Log.e("SentFragment", "Sent messages list is null in response");
                        break;
                    }
                }
                break;
            default:
                StringBuilder sbH = com.unified.ur1.SatelliteTracker.h.h("UnifiedInbox", "=== API Response Received ===", "Response Code: ");
                sbH.append(response.code());
                Log.d("UnifiedInbox", sbH.toString());
                UnifiedInboxActivity unifiedInboxActivity2 = (UnifiedInboxActivity) this.f1554d;
                ProgressBar progressBar = unifiedInboxActivity2.f5831c;
                if (progressBar != null) {
                    progressBar.setVisibility(8);
                }
                int i7 = 0;
                if (!response.isSuccessful() || response.body() == null) {
                    Log.e("UnifiedInbox", "Response not successful. Code: " + response.code());
                    Toast.makeText(unifiedInboxActivity2, "Failed to load messages", 0).show();
                    break;
                } else {
                    List<Message> messages2 = ((MessageResponse) response.body()).getMessages();
                    if (messages2 != null) {
                        Log.d("UnifiedInbox", "Total messages received: " + messages2.size());
                        unifiedInboxActivity2.f5835i.clear();
                        for (Message message2 : messages2) {
                            if (!message2.isDeleted()) {
                                unifiedInboxActivity2.f5835i.add(message2);
                                i7++;
                            }
                        }
                        Log.d("UnifiedInbox", "Messages added to list: " + i7);
                        Log.d("UnifiedInbox", "Notifying fragments of data change");
                        y yVar = unifiedInboxActivity2.f5834f;
                        if (yVar == null) {
                            Log.w("UnifiedInbox", "PagerAdapter is null, cannot notify fragments");
                        } else {
                            i3.m mVarH = yVar.h();
                            if (mVarH != null) {
                                Log.d("UnifiedInbox", "Notifying InboxFragment to refresh");
                                mVarH.i();
                            } else {
                                Log.w("UnifiedInbox", "InboxFragment is null");
                            }
                            E eI = unifiedInboxActivity2.f5834f.i();
                            if (eI != null) {
                                Log.d("UnifiedInbox", "Notifying SentFragment to refresh");
                                eI.g();
                            } else {
                                Log.w("UnifiedInbox", "SentFragment is null");
                            }
                        }
                        unifiedInboxActivity2.u();
                        break;
                    }
                }
                break;
        }
    }

    @Override // p1.o
    public void p(Object obj, Object obj2) throws RemoteException {
        N1.k kVar = (N1.k) obj2;
        switch (this.f1553c) {
            case 3:
                Z2.c cVar = new Z2.c(kVar);
                PendingIntent pendingIntent = (PendingIntent) this.f1554d;
                q1.E.j(pendingIntent, "PendingIntent must be specified.");
                BinderC0008f binderC0008f = new BinderC0008f(cVar);
                a0 a0Var = (a0) ((U) obj).t();
                Parcel parcelZza = a0Var.zza();
                AbstractC0019q.b(parcelZza, pendingIntent);
                parcelZza.writeStrongBinder(binderC0008f);
                a0Var.zzc(69, parcelZza);
                break;
            case 4:
                D1.D d5 = (D1.D) obj;
                CurrentLocationRequest currentLocationRequest = (CurrentLocationRequest) this.f1554d;
                if (!d5.G(zzo.zzj)) {
                    if (!d5.G(zzo.zze)) {
                        androidx.emoji2.text.e eVarD = h4.d.d(new C0025x(d5, kVar), "GetCurrentLocation", T.f376j);
                        Objects.requireNonNull((p1.l) eVarD.f3602c);
                        s sVar = new s(eVarD, 5, kVar);
                        N1.k kVar2 = new N1.k();
                        LocationRequest.Builder builder = new LocationRequest.Builder(currentLocationRequest.getPriority(), 0L);
                        builder.setMinUpdateIntervalMillis(0L);
                        builder.setDurationMillis(currentLocationRequest.getDurationMillis());
                        builder.setGranularity(currentLocationRequest.getGranularity());
                        builder.setMaxUpdateAgeMillis(currentLocationRequest.getMaxUpdateAgeMillis());
                        builder.zzb(currentLocationRequest.zza());
                        builder.zza(currentLocationRequest.zzb());
                        builder.setWaitForAccurateLocation(true);
                        builder.zzc(currentLocationRequest.zzc());
                        d5.J(sVar, builder.build(), kVar2);
                        kVar2.f1789a.g(new l(7, kVar));
                        break;
                    } else {
                        a0 a0Var2 = (a0) d5.t();
                        BinderC0024w binderC0024w = new BinderC0024w(1, kVar);
                        Parcel parcelZza2 = a0Var2.zza();
                        AbstractC0019q.b(parcelZza2, currentLocationRequest);
                        parcelZza2.writeStrongBinder(binderC0024w.asBinder());
                        Parcel parcelZzb = a0Var2.zzb(87, parcelZza2);
                        IBinder strongBinder = parcelZzb.readStrongBinder();
                        int i5 = AbstractBinderC0860k.f9390d;
                        if (strongBinder != null) {
                            boolean z4 = strongBinder.queryLocalInterface("com.google.android.gms.common.internal.ICancelToken") instanceof InterfaceC0861l;
                        }
                        parcelZzb.recycle();
                        break;
                    }
                } else {
                    a0 a0Var3 = (a0) d5.t();
                    F f5 = new F(4, null, new BinderC0024w(1, kVar), null, null);
                    Parcel parcelZza3 = a0Var3.zza();
                    AbstractC0019q.b(parcelZza3, currentLocationRequest);
                    AbstractC0019q.b(parcelZza3, f5);
                    Parcel parcelZzb2 = a0Var3.zzb(92, parcelZza3);
                    IBinder strongBinder2 = parcelZzb2.readStrongBinder();
                    int i6 = AbstractBinderC0860k.f9390d;
                    if (strongBinder2 != null) {
                        boolean z5 = strongBinder2.queryLocalInterface("com.google.android.gms.common.internal.ICancelToken") instanceof InterfaceC0861l;
                    }
                    parcelZzb2.recycle();
                    break;
                }
            default:
                List list = (List) this.f1554d;
                q1.E.j(list, "geofence can't be null.");
                q1.E.b(true ^ list.isEmpty(), "Geofences must contains at least one id.");
                ((D1.D) obj).F(new K(list, null, ""), kVar);
                break;
        }
    }

    @Override // i3.s
    public void q(Message message) {
        i3.l lVar = ((i3.m) this.f1554d).f7320i;
        if (lVar != null) {
            ((UnifiedInboxActivity) lVar).l(message);
        }
    }

    @Override // i3.s
    public void r(Message message) {
        i3.l lVar = ((i3.m) this.f1554d).f7320i;
        if (lVar != null) {
            ((UnifiedInboxActivity) lVar).n(message);
        }
    }

    public void s(AbstractC0759a... abstractC0759aArr) {
        F3.i.f(abstractC0759aArr, "migrations");
        for (AbstractC0759a abstractC0759a : abstractC0759aArr) {
            int i5 = abstractC0759a.f8508a;
            LinkedHashMap linkedHashMap = (LinkedHashMap) this.f1554d;
            Integer numValueOf = Integer.valueOf(i5);
            Object treeMap = linkedHashMap.get(numValueOf);
            if (treeMap == null) {
                treeMap = new TreeMap();
                linkedHashMap.put(numValueOf, treeMap);
            }
            TreeMap treeMap2 = (TreeMap) treeMap;
            int i6 = abstractC0759a.f8509b;
            if (treeMap2.containsKey(Integer.valueOf(i6))) {
                Log.w("ROOM", "Overriding migration " + treeMap2.get(Integer.valueOf(i6)) + " with " + abstractC0759a);
            }
            treeMap2.put(Integer.valueOf(i6), abstractC0759a);
        }
    }

    public void t() {
        ((InputContentInfo) this.f1554d).requestPermission();
    }

    public String toString() {
        switch (this.f1553c) {
            case o1.f.ERROR /* 13 */:
                return "ContentInfoCompat{" + ((ContentInfo) this.f1554d) + "}";
            default:
                return super.toString();
        }
    }

    public void u(String str, String str2, Bundle bundle) {
        switch (this.f1553c) {
            case 10:
                boolean zIsEmpty = TextUtils.isEmpty(str);
                C0058c1 c0058c1 = (C0058c1) this.f1554d;
                if (!zIsEmpty) {
                    c0058c1.getClass();
                    throw new IllegalStateException("Unexpected call on client side");
                }
                ((C0113v0) c0058c1.f84c).f1421p.getClass();
                c0058c1.t("auto", "_err", bundle, true, true, System.currentTimeMillis());
                return;
            default:
                boolean zIsEmpty2 = TextUtils.isEmpty(str);
                V1 v12 = (V1) this.f1554d;
                if (!zIsEmpty2) {
                    v12.e().t(new RunnableC0122y0(this, str, str2, bundle));
                    return;
                }
                C0113v0 c0113v0 = v12.n;
                if (c0113v0 != null) {
                    Z z4 = c0113v0.f1417k;
                    C0113v0.k(z4);
                    z4.h.b(str2, "AppId not known when logging event");
                    return;
                }
                return;
        }
    }

    public l(InterfaceC0081k0 interfaceC0081k0) {
        this.f1553c = 9;
        q1.E.i(interfaceC0081k0);
        this.f1554d = interfaceC0081k0;
    }

    public l(AbstractC0737m abstractC0737m) {
        this.f1553c = 0;
        this.f1554d = abstractC0737m;
        new b(abstractC0737m, 3);
    }

    public l(ViewGroup viewGroup) {
        this.f1553c = 22;
        this.f1554d = viewGroup.getOverlay();
    }

    public l(WorkDatabase workDatabase) {
        this.f1553c = 12;
        F3.i.f(workDatabase, "workDatabase");
        this.f1554d = workDatabase;
    }

    public l(int i5) {
        this.f1553c = i5;
        switch (i5) {
            case 28:
                this.f1554d = new LinkedHashMap();
                break;
            default:
                this.f1554d = Handler.createAsync(Looper.getMainLooper());
                break;
        }
    }

    public l(EditText editText) {
        this.f1553c = 16;
        h4.f.c(editText, "editText cannot be null");
        this.f1554d = new c(editText);
    }

    public l(Object obj) {
        this.f1553c = 14;
        this.f1554d = (InputContentInfo) obj;
    }

    public l(Context context) {
        this.f1553c = 17;
        this.f1554d = context.getApplicationContext();
    }

    public l(ContentInfo contentInfo) {
        this.f1553c = 13;
        contentInfo.getClass();
        this.f1554d = w.h(contentInfo);
    }
}
