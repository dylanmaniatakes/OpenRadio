package B0;

import D1.AbstractC0019q;
import D1.D;
import D1.U;
import D1.a0;
import J1.C0058c1;
import J1.C0072h0;
import J1.C0113v0;
import J1.G1;
import J1.H0;
import J1.K0;
import J1.Z;
import O.H;
import O.Y;
import P.u;
import X2.t;
import android.app.ActivityManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.gms.location.DeviceOrientation;
import com.google.android.gms.location.DeviceOrientationListener;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.unified.ur1.chat.ChatActivity;
import com.unified.ur1.inbox.Message;
import com.unified.ur1.inbox.MessageDetailActivity;
import com.unified.ur1.inbox.MessageResponse;
import com.unified.ur1.inbox.UnifiedInboxActivity;
import com.unified.ur1.primary.LaunchActivity;
import e0.C0432c;
import e1.C0434b;
import e1.C0435c;
import e1.EnumC0437e;
import f.w;
import f.x;
import f3.C0524o;
import h1.AbstractC0557a;
import j.y;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.MissingFormatArgumentException;
import java.util.Set;
import java.util.WeakHashMap;
import k.C0637j;
import org.json.JSONArray;
import org.json.JSONException;
import q1.E;
import r3.InterfaceC0877a;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import u1.C0906a;
import x1.AbstractC0960a;
import x1.InterfaceC0962c;
import x1.InterfaceC0964e;

/* loaded from: classes.dex */
public final class l implements u, p1.o, p1.m, InterfaceC0877a, y, Callback, j.k, m3.p, InterfaceC0964e {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f109c;

    /* renamed from: d, reason: collision with root package name */
    public Object f110d;

    public /* synthetic */ l(int i5, Object obj) {
        this.f109c = i5;
        this.f110d = obj;
    }

    public static void c(List list) {
        Iterator it = list.iterator();
        if (it.hasNext()) {
            com.unified.ur1.SatelliteTracker.h.p(it.next());
            throw null;
        }
    }

    public static boolean t(Bundle bundle) {
        return "1".equals(bundle.getString("gcm.n.e")) || "1".equals(bundle.getString("gcm.n.e".replace("gcm.n.", "gcm.notification.")));
    }

    private final void w(j.m mVar) {
    }

    public static String y(String str) {
        return str.startsWith("gcm.n.") ? str.substring(6) : str;
    }

    public static l z(String str) {
        return new l(5, (TextUtils.isEmpty(str) || str.length() > 1) ? H0.UNINITIALIZED : K0.c(str.charAt(0)));
    }

    public void A() {
        G1 g12 = (G1) this.f110d;
        g12.j();
        C0113v0 c0113v0 = (C0113v0) g12.f84c;
        C0072h0 c0072h0 = c0113v0.f1416j;
        C0113v0.i(c0072h0);
        C0906a c0906a = c0113v0.f1421p;
        c0906a.getClass();
        if (c0072h0.t(System.currentTimeMillis())) {
            C0072h0 c0072h02 = c0113v0.f1416j;
            C0113v0.i(c0072h02);
            c0072h02.f1241o.a(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                Z z4 = c0113v0.f1417k;
                C0113v0.k(z4);
                z4.f1084p.a("Detected application was in foreground");
                c0906a.getClass();
                C(System.currentTimeMillis());
            }
        }
    }

    public void B(long j5, boolean z4) {
        G1 g12 = (G1) this.f110d;
        g12.j();
        g12.n();
        C0113v0 c0113v0 = (C0113v0) g12.f84c;
        C0072h0 c0072h0 = c0113v0.f1416j;
        C0113v0.i(c0072h0);
        boolean zT = c0072h0.t(j5);
        C0072h0 c0072h02 = c0113v0.f1416j;
        if (zT) {
            C0113v0.i(c0072h02);
            c0072h02.f1241o.a(true);
            c0113v0.n().s();
        }
        C0113v0.i(c0072h02);
        c0072h02.f1245s.b(j5);
        if (c0072h02.f1241o.b()) {
            C(j5);
        }
    }

    public void C(long j5) {
        G1 g12 = (G1) this.f110d;
        g12.j();
        C0113v0 c0113v0 = (C0113v0) g12.f84c;
        if (c0113v0.b()) {
            C0072h0 c0072h0 = c0113v0.f1416j;
            C0113v0.i(c0072h0);
            c0072h0.f1245s.b(j5);
            c0113v0.f1421p.getClass();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            Z z4 = c0113v0.f1417k;
            C0113v0.k(z4);
            z4.f1084p.b(Long.valueOf(jElapsedRealtime), "Session started, time");
            long j6 = j5 / 1000;
            Long lValueOf = Long.valueOf(j6);
            C0058c1 c0058c1 = c0113v0.f1423r;
            C0113v0.j(c0058c1);
            c0058c1.E(j5, lValueOf, "auto", "_sid");
            C0113v0.i(c0072h0);
            c0072h0.f1246t.b(j6);
            c0072h0.f1241o.a(false);
            Bundle bundle = new Bundle();
            bundle.putLong("_sid", j6);
            C0113v0.j(c0058c1);
            c0058c1.v(j5, bundle, "auto", "_s");
            String strG = c0072h0.f1251y.g();
            if (TextUtils.isEmpty(strG)) {
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("_ffr", strG);
            C0113v0.j(c0058c1);
            c0058c1.v(j5, bundle2, "auto", "_ssr");
        }
    }

    @Override // j.y
    public void a(j.m mVar, boolean z4) {
        w wVar;
        j.m mVarK = mVar.k();
        int i5 = 0;
        boolean z5 = mVarK != mVar;
        if (z5) {
            mVar = mVarK;
        }
        x xVar = (x) this.f110d;
        w[] wVarArr = xVar.f6400N;
        int length = wVarArr != null ? wVarArr.length : 0;
        while (true) {
            if (i5 < length) {
                wVar = wVarArr[i5];
                if (wVar != null && wVar.h == mVar) {
                    break;
                } else {
                    i5++;
                }
            } else {
                wVar = null;
                break;
            }
        }
        if (wVar != null) {
            if (!z5) {
                xVar.t(wVar, z4);
            } else {
                xVar.r(wVar.f6371a, wVar, mVarK);
                xVar.t(wVar, true);
            }
        }
    }

    @Override // m3.p
    public void b(int i5) {
        ((LaunchActivity) this.f110d).runOnUiThread(new D.n(i5, 6, this));
    }

    @Override // P.u
    public boolean d(View view) {
        switch (this.f109c) {
            case 0:
                int currentItem = ((ViewPager2) view).getCurrentItem() - 1;
                ViewPager2 viewPager2 = (ViewPager2) ((t) this.f110d).f2836f;
                if (viewPager2.f4474t) {
                    viewPager2.c(currentItem, true);
                }
                return true;
            default:
                SwipeDismissBehavior swipeDismissBehavior = (SwipeDismissBehavior) this.f110d;
                if (!swipeDismissBehavior.r(view)) {
                    return false;
                }
                WeakHashMap weakHashMap = Y.f1904a;
                boolean z4 = H.d(view) == 1;
                int i5 = swipeDismissBehavior.f5178e;
                view.offsetLeftAndRight((!(i5 == 0 && z4) && (i5 != 1 || z4)) ? view.getWidth() : -view.getWidth());
                view.setAlpha(BitmapDescriptorFactory.HUE_RED);
                l lVar = swipeDismissBehavior.f5175b;
                if (lVar == null) {
                    return true;
                }
                lVar.v(view);
                return true;
        }
    }

    @Override // j.k
    public void e(j.m mVar) {
        switch (this.f109c) {
            case 16:
                return;
            default:
                Toolbar toolbar = (Toolbar) this.f110d;
                C0637j c0637j = toolbar.f3461c.f3368v;
                if (c0637j == null || !c0637j.f()) {
                    Iterator it = toolbar.I.f1949b.iterator();
                    if (it.hasNext()) {
                        com.unified.ur1.SatelliteTracker.h.p(it.next());
                        throw null;
                    }
                }
                j.k kVar = toolbar.f3455Q;
                if (kVar != null) {
                    kVar.e(mVar);
                    return;
                }
                return;
        }
    }

    public boolean f(String str) {
        String strR = r(str);
        return "1".equals(strR) || Boolean.parseBoolean(strR);
    }

    @Override // j.k
    public boolean g(j.m mVar, MenuItem menuItem) {
        switch (this.f109c) {
            case 16:
                i2.k kVar = (i2.k) this.f110d;
                kVar.getClass();
                i2.i iVar = kVar.g;
                if (iVar == null || iVar.d(menuItem)) {
                }
                break;
            default:
                j.k kVar2 = ((Toolbar) this.f110d).f3455Q;
                if (kVar2 == null || !kVar2.g(mVar, menuItem)) {
                }
                break;
        }
        return false;
    }

    @Override // r3.InterfaceC0877a
    public Object get() {
        h1.d dVar = (h1.d) ((InterfaceC0877a) this.f110d).get();
        HashMap map = new HashMap();
        V0.d dVar2 = V0.d.f2512j;
        Set setEmptySet = Collections.emptySet();
        if (setEmptySet == null) {
            throw new NullPointerException("Null flags");
        }
        Long l5 = 30000L;
        Long l6 = 86400000L;
        map.put(dVar2, new C0435c(l5.longValue(), l6.longValue(), setEmptySet));
        V0.d dVar3 = V0.d.f2514l;
        Set setEmptySet2 = Collections.emptySet();
        if (setEmptySet2 == null) {
            throw new NullPointerException("Null flags");
        }
        Long l7 = 1000L;
        Long l8 = 86400000L;
        map.put(dVar3, new C0435c(l7.longValue(), l8.longValue(), setEmptySet2));
        V0.d dVar4 = V0.d.f2513k;
        if (Collections.emptySet() == null) {
            throw new NullPointerException("Null flags");
        }
        Long l9 = 86400000L;
        Long l10 = 86400000L;
        Set setUnmodifiableSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(EnumC0437e.f6160k)));
        if (setUnmodifiableSet == null) {
            throw new NullPointerException("Null flags");
        }
        map.put(dVar4, new C0435c(l9.longValue(), l10.longValue(), setUnmodifiableSet));
        if (dVar == null) {
            throw new NullPointerException("missing required property: clock");
        }
        if (map.keySet().size() < V0.d.values().length) {
            throw new IllegalStateException("Not all priorities have been configured");
        }
        new HashMap();
        return new C0434b(dVar, map);
    }

    public Integer h(String str) {
        String strR = r(str);
        if (TextUtils.isEmpty(strR)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(strR));
        } catch (NumberFormatException unused) {
            Log.w("NotificationParams", "Couldn't parse value of " + y(str) + "(" + strR + ") into an int");
            return null;
        }
    }

    @Override // j.y
    public boolean i(j.m mVar) {
        Window.Callback callback;
        if (mVar != mVar.k()) {
            return true;
        }
        x xVar = (x) this.f110d;
        if (!xVar.f6395H || (callback = xVar.n.getCallback()) == null || xVar.f6405S) {
            return true;
        }
        callback.onMenuOpened(108, mVar);
        return true;
    }

    @Override // p1.m
    public /* bridge */ /* synthetic */ void j(Object obj) {
        ((DeviceOrientationListener) obj).onDeviceOrientationChanged((DeviceOrientation) this.f110d);
    }

    public JSONArray k(String str) {
        String strR = r(str);
        if (TextUtils.isEmpty(strR)) {
            return null;
        }
        try {
            return new JSONArray(strR);
        } catch (JSONException unused) {
            Log.w("NotificationParams", "Malformed JSON for key " + y(str) + ": " + strR + ", falling back to default");
            return null;
        }
    }

    public int[] l() throws JSONException {
        JSONArray jSONArrayK = k("gcm.n.light_settings");
        if (jSONArrayK == null) {
            return null;
        }
        int[] iArr = new int[3];
        try {
            if (jSONArrayK.length() != 3) {
                throw new JSONException("lightSettings don't have all three fields");
            }
            int color = Color.parseColor(jSONArrayK.optString(0));
            if (color == -16777216) {
                throw new IllegalArgumentException("Transparent color is invalid");
            }
            iArr[0] = color;
            iArr[1] = jSONArrayK.optInt(1);
            iArr[2] = jSONArrayK.optInt(2);
            return iArr;
        } catch (IllegalArgumentException e5) {
            Log.w("NotificationParams", "LightSettings is invalid: " + jSONArrayK + ". " + e5.getMessage() + ". Skipping setting LightSettings");
            return null;
        } catch (JSONException unused) {
            Log.w("NotificationParams", "LightSettings is invalid: " + jSONArrayK + ". Skipping setting LightSettings");
            return null;
        }
    }

    public Object[] m(String str) {
        JSONArray jSONArrayK = k(str.concat("_loc_args"));
        if (jSONArrayK == null) {
            return null;
        }
        int length = jSONArrayK.length();
        String[] strArr = new String[length];
        for (int i5 = 0; i5 < length; i5++) {
            strArr[i5] = jSONArrayK.optString(i5);
        }
        return strArr;
    }

    public String n(String str) {
        return r(str.concat("_loc_key"));
    }

    public Long o() {
        String strR = r("gcm.n.event_time");
        if (TextUtils.isEmpty(strR)) {
            return null;
        }
        try {
            return Long.valueOf(Long.parseLong(strR));
        } catch (NumberFormatException unused) {
            Log.w("NotificationParams", "Couldn't parse value of " + y("gcm.n.event_time") + "(" + strR + ") into a long");
            return null;
        }
    }

    @Override // retrofit2.Callback
    public void onFailure(Call call, Throwable th) {
        switch (this.f109c) {
            case o1.f.INTERRUPTED /* 14 */:
                Log.w("ChatActivity", "Failed to send direct typing status: " + th.getMessage());
                break;
            case 15:
                ChatActivity chatActivity = (ChatActivity) this.f110d;
                chatActivity.f5739f.setRefreshing(false);
                Log.e("ChatActivity", "Failed to load team messages: " + th.getMessage());
                Toast.makeText(chatActivity, "Could not load team messages", 0).show();
                break;
            case 16:
            default:
                Toast.makeText((UnifiedInboxActivity) this.f110d, "Failed to mark all as read", 0).show();
                break;
            case o1.f.API_NOT_CONNECTED /* 17 */:
                Log.e("MessageDetailActivity", "Network error marking message as read", th);
                break;
        }
    }

    @Override // retrofit2.Callback
    public void onResponse(Call call, Response response) {
        switch (this.f109c) {
            case o1.f.INTERRUPTED /* 14 */:
                com.unified.ur1.SatelliteTracker.h.q(new StringBuilder("Direct typing status sent: "), (String) this.f110d, "ChatActivity");
                break;
            case 15:
                ChatActivity chatActivity = (ChatActivity) this.f110d;
                chatActivity.f5739f.setRefreshing(false);
                chatActivity.n.clear();
                if (!response.isSuccessful() || response.body() == null || ((MessageResponse) response.body()).getMessages() == null) {
                    Log.w("ChatActivity", "Failed to load team messages or empty response");
                } else {
                    for (Message message : ((MessageResponse) response.body()).getMessages()) {
                        if (chatActivity.s(message)) {
                            chatActivity.n.add(message);
                        }
                    }
                    chatActivity.n.sort(new g3.m(this, 0));
                    Log.d("ChatActivity", "Loaded " + chatActivity.n.size() + " team messages");
                }
                chatActivity.f5743l.notifyDataSetChanged();
                if (!chatActivity.n.isEmpty()) {
                    chatActivity.f5738e.post(new C0.e(16, this));
                }
                chatActivity.u();
                break;
            case 16:
            default:
                if (response.isSuccessful()) {
                    UnifiedInboxActivity unifiedInboxActivity = (UnifiedInboxActivity) this.f110d;
                    Iterator it = unifiedInboxActivity.f5835i.iterator();
                    while (it.hasNext()) {
                        ((Message) it.next()).setRead(true);
                    }
                    C0524o c0524o = unifiedInboxActivity.g;
                    if (c0524o != null) {
                        c0524o.notifyDataSetChanged();
                    }
                    unifiedInboxActivity.u();
                    Toast.makeText(unifiedInboxActivity, "All messages marked as read", 0).show();
                    break;
                }
                break;
            case o1.f.API_NOT_CONNECTED /* 17 */:
                if (response.isSuccessful()) {
                    Log.d("MessageDetailActivity", "Message marked as read successfully");
                    Intent intent = new Intent();
                    intent.putExtra("message_read", true);
                    intent.putExtra("refresh_needed", true);
                    MessageDetailActivity messageDetailActivity = (MessageDetailActivity) this.f110d;
                    messageDetailActivity.setResult(-1, intent);
                    C0432c.a(messageDetailActivity).c(new Intent("REFRESH_INBOX"));
                    Log.d("MessageDetailActivity", "Sent REFRESH_INBOX broadcast");
                    break;
                } else {
                    Log.w("MessageDetailActivity", "Failed to mark message as read: " + response.code());
                    break;
                }
        }
    }

    @Override // p1.o
    public void p(Object obj, Object obj2) throws RemoteException {
        N1.k kVar = (N1.k) obj2;
        switch (this.f109c) {
            case 1:
                U u4 = (U) obj;
                u4.getClass();
                PendingIntent pendingIntent = (PendingIntent) this.f110d;
                E.i(pendingIntent);
                a0 a0Var = (a0) u4.t();
                Parcel parcelZza = a0Var.zza();
                AbstractC0019q.b(parcelZza, pendingIntent);
                a0Var.zzc(6, parcelZza);
                kVar.a(null);
                break;
            default:
                D d5 = (D) obj;
                p1.l lVar = (p1.l) ((androidx.emoji2.text.e) this.f110d).f3602c;
                if (lVar != null) {
                    d5.D(lVar, kVar);
                    break;
                }
                break;
        }
    }

    public String q(Resources resources, String str, String str2) {
        String strR = r(str2);
        if (!TextUtils.isEmpty(strR)) {
            return strR;
        }
        String strN = n(str2);
        if (TextUtils.isEmpty(strN)) {
            return null;
        }
        int identifier = resources.getIdentifier(strN, "string", str);
        if (identifier == 0) {
            Log.w("NotificationParams", y(str2.concat("_loc_key")) + " resource not found: " + str2 + " Default value will be used.");
            return null;
        }
        Object[] objArrM = m(str2);
        if (objArrM == null) {
            return resources.getString(identifier);
        }
        try {
            return resources.getString(identifier, objArrM);
        } catch (MissingFormatArgumentException e5) {
            Log.w("NotificationParams", "Missing format argument for " + y(str2) + ": " + Arrays.toString(objArrM) + " Default value will be used.", e5);
            return null;
        }
    }

    public String r(String str) {
        Bundle bundle = (Bundle) this.f110d;
        if (!bundle.containsKey(str) && str.startsWith("gcm.n.")) {
            String strReplace = !str.startsWith("gcm.n.") ? str : str.replace("gcm.n.", "gcm.notification.");
            if (bundle.containsKey(strReplace)) {
                str = strReplace;
            }
        }
        return bundle.getString(str);
    }

    public long[] s() throws JSONException {
        JSONArray jSONArrayK = k("gcm.n.vibrate_timings");
        if (jSONArrayK == null) {
            return null;
        }
        try {
            if (jSONArrayK.length() <= 1) {
                throw new JSONException("vibrateTimings have invalid length");
            }
            int length = jSONArrayK.length();
            long[] jArr = new long[length];
            for (int i5 = 0; i5 < length; i5++) {
                jArr[i5] = jSONArrayK.optLong(i5);
            }
            return jArr;
        } catch (NumberFormatException | JSONException unused) {
            Log.w("NotificationParams", "User defined vibrateTimings is invalid: " + jSONArrayK + ". Skipping setting vibrateTimings.");
            return null;
        }
    }

    public void u(InterfaceC0962c interfaceC0962c) {
        AbstractC0960a abstractC0960a = (AbstractC0960a) this.f110d;
        abstractC0960a.zaa = interfaceC0962c;
        Iterator it = abstractC0960a.zac.iterator();
        while (it.hasNext()) {
            x1.k kVar = (x1.k) it.next();
            InterfaceC0962c unused = abstractC0960a.zaa;
            kVar.b();
        }
        abstractC0960a.zac.clear();
        abstractC0960a.zab = null;
    }

    public void v(View view) {
        if (view.getParent() != null) {
            view.setVisibility(8);
        }
        ((q2.i) this.f110d).a(0);
    }

    public Bundle x() {
        Bundle bundle = (Bundle) this.f110d;
        Bundle bundle2 = new Bundle(bundle);
        for (String str : bundle.keySet()) {
            if (!str.startsWith("google.c.a.") && !str.equals("from")) {
                bundle2.remove(str);
            }
        }
        return bundle2;
    }

    public l(int i5) {
        this.f109c = i5;
        switch (i5) {
            case 10:
                this.f110d = AbstractC0557a.f7080a;
                break;
        }
    }

    public l(Bundle bundle) {
        this.f109c = 8;
        if (bundle != null) {
            this.f110d = new Bundle(bundle);
            return;
        }
        throw new NullPointerException("data");
    }
}
