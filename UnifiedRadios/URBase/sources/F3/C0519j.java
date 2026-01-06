package f3;

import D1.C0016n;
import J1.InterfaceC0054b0;
import J1.V1;
import O.C0164g;
import O.F0;
import O.InterfaceC0158d;
import O.InterfaceC0183w;
import android.content.ClipData;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import android.view.ContentInfo;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.profileinstaller.ProfileInstallReceiver;
import c0.C0291c;
import c0.C0292d;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;
import com.google.gson.Gson;
import com.unified.ur1.R;
import com.unified.ur1.adapters.AppDatabase;
import com.unified.ur1.inbox.ApiResponse;
import com.unified.ur1.inbox.ComposeMessageActivity;
import com.unified.ur1.inbox.FCMTokenRequest;
import com.unified.ur1.inbox.UnifiedInboxActivity;
import com.unified.ur1.primary.LaunchActivity;
import g0.AbstractC0535a;
import j0.InterfaceC0591d;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.WeakHashMap;
import k.C0637j;
import k.c1;
import k.j1;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import r3.InterfaceC0877a;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* renamed from: f3.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0519j implements p1.o, p1.m, InterfaceC0054b0, InterfaceC0158d, InterfaceC0877a, androidx.lifecycle.V, InterfaceC0183w, c1, Callback, N1.e, InterfaceC0591d, j.y, o3.r {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6729c;

    /* renamed from: d, reason: collision with root package name */
    public Object f6730d;

    public /* synthetic */ C0519j(int i5, Object obj) {
        this.f6729c = i5;
        this.f6730d = obj;
    }

    @Override // j.y
    public void a(j.m mVar, boolean z4) {
        if (mVar instanceof j.F) {
            ((j.F) mVar).f7397z.k().c(false);
        }
        j.y yVar = ((C0637j) this.f6730d).g;
        if (yVar != null) {
            yVar.a(mVar, z4);
        }
    }

    @Override // O.InterfaceC0158d
    public C0164g c() {
        return new C0164g(new L0.l(((ContentInfo.Builder) this.f6730d).build()));
    }

    @Override // j0.InterfaceC0591d
    public void d(int i5, Serializable serializable) {
        String str;
        switch (i5) {
            case 1:
                str = "RESULT_INSTALL_SUCCESS";
                break;
            case 2:
                str = "RESULT_ALREADY_INSTALLED";
                break;
            case 3:
                str = "RESULT_UNSUPPORTED_ART_VERSION";
                break;
            case 4:
                str = "RESULT_NOT_WRITABLE";
                break;
            case 5:
                str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                break;
            case 6:
                str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                break;
            case 7:
                str = "RESULT_IO_EXCEPTION";
                break;
            case 8:
                str = "RESULT_PARSE_EXCEPTION";
                break;
            case 9:
            default:
                str = "";
                break;
            case 10:
                str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                break;
            case 11:
                str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                break;
        }
        if (i5 == 6 || i5 == 7 || i5 == 8) {
            Log.e("ProfileInstaller", str, (Throwable) serializable);
        } else {
            Log.d("ProfileInstaller", str);
        }
        ((ProfileInstallReceiver) this.f6730d).setResultCode(i5);
    }

    @Override // O.InterfaceC0183w
    public F0 e(View view, F0 f02) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        boolean z4;
        F0 f0B;
        boolean z5;
        boolean z6;
        switch (this.f6729c) {
            case o1.f.ERROR /* 13 */:
                int iD = f02.d();
                f.x xVar = (f.x) this.f6730d;
                xVar.getClass();
                int iD2 = f02.d();
                ActionBarContextView actionBarContextView = xVar.f6433x;
                if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                    z4 = false;
                } else {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) xVar.f6433x.getLayoutParams();
                    if (xVar.f6433x.isShown()) {
                        if (xVar.f6417e0 == null) {
                            xVar.f6417e0 = new Rect();
                            xVar.f6418f0 = new Rect();
                        }
                        Rect rect = xVar.f6417e0;
                        Rect rect2 = xVar.f6418f0;
                        rect.set(f02.b(), f02.d(), f02.c(), f02.a());
                        ViewGroup viewGroup = xVar.f6390C;
                        Method method = j1.f7810a;
                        if (method != null) {
                            try {
                                method.invoke(viewGroup, rect, rect2);
                            } catch (Exception e5) {
                                Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", e5);
                            }
                        }
                        int i5 = rect.top;
                        int i6 = rect.left;
                        int i7 = rect.right;
                        ViewGroup viewGroup2 = xVar.f6390C;
                        WeakHashMap weakHashMap = O.Y.f1904a;
                        F0 f0A = O.N.a(viewGroup2);
                        int iB = f0A == null ? 0 : f0A.b();
                        int iC = f0A == null ? 0 : f0A.c();
                        if (marginLayoutParams.topMargin == i5 && marginLayoutParams.leftMargin == i6 && marginLayoutParams.rightMargin == i7) {
                            z6 = false;
                        } else {
                            marginLayoutParams.topMargin = i5;
                            marginLayoutParams.leftMargin = i6;
                            marginLayoutParams.rightMargin = i7;
                            z6 = true;
                        }
                        Context context = xVar.f6423m;
                        if (i5 <= 0 || xVar.f6392E != null) {
                            View view2 = xVar.f6392E;
                            if (view2 != null) {
                                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
                                int i8 = marginLayoutParams2.height;
                                int i9 = marginLayoutParams.topMargin;
                                if (i8 != i9 || marginLayoutParams2.leftMargin != iB || marginLayoutParams2.rightMargin != iC) {
                                    marginLayoutParams2.height = i9;
                                    marginLayoutParams2.leftMargin = iB;
                                    marginLayoutParams2.rightMargin = iC;
                                    xVar.f6392E.setLayoutParams(marginLayoutParams2);
                                }
                            }
                        } else {
                            View view3 = new View(context);
                            xVar.f6392E = view3;
                            view3.setVisibility(8);
                            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                            layoutParams.leftMargin = iB;
                            layoutParams.rightMargin = iC;
                            xVar.f6390C.addView(xVar.f6392E, -1, layoutParams);
                        }
                        View view4 = xVar.f6392E;
                        boolean z7 = view4 != null;
                        if (z7 && view4.getVisibility() != 0) {
                            View view5 = xVar.f6392E;
                            view5.setBackgroundColor((O.G.g(view5) & 8192) != 0 ? C.d.a(context, R.color.abc_decor_view_status_guard_light) : C.d.a(context, R.color.abc_decor_view_status_guard));
                        }
                        if (!xVar.f6396J && z7) {
                            iD2 = 0;
                        }
                        z4 = z7;
                        z5 = z6;
                    } else if (marginLayoutParams.topMargin != 0) {
                        marginLayoutParams.topMargin = 0;
                        z4 = false;
                        z5 = true;
                    } else {
                        z4 = false;
                        z5 = false;
                    }
                    if (z5) {
                        xVar.f6433x.setLayoutParams(marginLayoutParams);
                    }
                }
                View view6 = xVar.f6392E;
                if (view6 != null) {
                    view6.setVisibility(z4 ? 0 : 8);
                }
                if (iD != iD2) {
                    int iB2 = f02.b();
                    int iC2 = f02.c();
                    int iA = f02.a();
                    int i10 = Build.VERSION.SDK_INT;
                    O.x0 w0Var = i10 >= 30 ? new O.w0(f02) : i10 >= 29 ? new O.v0(f02) : new O.u0(f02);
                    w0Var.g(E.c.b(iB2, iD2, iC2, iA));
                    f0B = w0Var.b();
                } else {
                    f0B = f02;
                }
                WeakHashMap weakHashMap2 = O.Y.f1904a;
                WindowInsets windowInsetsF = f0B.f();
                if (windowInsetsF == null) {
                    return f0B;
                }
                WindowInsets windowInsetsB = O.K.b(view, windowInsetsF);
                return !windowInsetsB.equals(windowInsetsF) ? F0.g(view, windowInsetsB) : f0B;
            default:
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.f6730d;
                if (!N.b.a(coordinatorLayout.f3525p, f02)) {
                    coordinatorLayout.f3525p = f02;
                    boolean z8 = f02.d() > 0;
                    coordinatorLayout.f3526q = z8;
                    coordinatorLayout.setWillNotDraw(!z8 && coordinatorLayout.getBackground() == null);
                    O.D0 d02 = f02.f1894a;
                    if (!d02.m()) {
                        int childCount = coordinatorLayout.getChildCount();
                        while (i < childCount) {
                            View childAt = coordinatorLayout.getChildAt(i);
                            WeakHashMap weakHashMap3 = O.Y.f1904a;
                            if (!O.G.b(childAt) || ((z.e) childAt.getLayoutParams()).f10529a == null || !d02.m()) {
                                i++;
                            }
                        }
                    }
                    coordinatorLayout.requestLayout();
                }
                return f02;
        }
    }

    @Override // androidx.lifecycle.V
    public androidx.lifecycle.S f(Class cls, C0291c c0291c) {
        androidx.lifecycle.S s4 = null;
        for (C0292d c0292d : (C0292d[]) this.f6730d) {
            if (F3.i.a(c0292d.f4545a, cls)) {
                Object objInvoke = c0292d.f4546b.invoke(c0291c);
                s4 = objInvoke instanceof androidx.lifecycle.S ? (androidx.lifecycle.S) objInvoke : null;
            }
        }
        if (s4 != null) {
            return s4;
        }
        throw new IllegalArgumentException("No initializer set for given class ".concat(cls.getName()));
    }

    @Override // O.InterfaceC0158d
    public void g(Bundle bundle) {
        ((ContentInfo.Builder) this.f6730d).setExtras(bundle);
    }

    @Override // r3.InterfaceC0877a
    public Object get() {
        switch (this.f6729c) {
            case 11:
                return this.f6730d;
            default:
                String packageName = ((Context) ((InterfaceC0877a) this.f6730d).get()).getPackageName();
                if (packageName != null) {
                    return packageName;
                }
                throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
        }
    }

    @Override // J1.InterfaceC0054b0
    public void h(String str, int i5, IOException iOException, byte[] bArr, Map map) {
        ((V1) this.f6730d).r(str, i5, iOException, bArr, map);
    }

    @Override // j.y
    public boolean i(j.m mVar) {
        C0637j c0637j = (C0637j) this.f6730d;
        if (mVar == c0637j.f7791e) {
            return false;
        }
        c0637j.f7788A = ((j.F) mVar).f7396A.f7481a;
        j.y yVar = c0637j.g;
        if (yVar != null) {
            return yVar.i(mVar);
        }
        return false;
    }

    @Override // p1.m
    public /* synthetic */ void j(Object obj) {
        switch (this.f6729c) {
            case 3:
                ((LocationCallback) obj).onLocationResult((LocationResult) this.f6730d);
                break;
            default:
                ((D1.C) this.f6730d).f332c.zzc();
                break;
        }
    }

    @Override // N1.e
    public void k(N1.j jVar) {
        String str;
        String strConcat;
        boolean zF = jVar.f();
        UnifiedInboxActivity unifiedInboxActivity = (UnifiedInboxActivity) this.f6730d;
        if (!zF) {
            Log.w("UnifiedInbox", "Fetching FCM registration token failed", jVar.c());
            Toast.makeText(unifiedInboxActivity, "FCM token fetch failed: " + jVar.c().getMessage(), 1).show();
            return;
        }
        String str2 = (String) jVar.d();
        AbstractC0535a.v("FCM Token obtained: ", str2, "UnifiedInbox");
        SharedPreferences.Editor editorEdit = unifiedInboxActivity.f5837k.edit();
        editorEdit.putString("fcm_token", str2);
        editorEdit.putLong("fcm_token_timestamp", System.currentTimeMillis());
        editorEdit.apply();
        Log.d("UnifiedInbox", "FCM Token stored locally");
        Log.d("UnifiedInbox", "=== FCM Token Registration Debug ===");
        StringBuilder sbI = com.unified.ur1.SatelliteTracker.h.i(new StringBuilder("Registering FCM token with server for callsign: "), unifiedInboxActivity.f5836j, "UnifiedInbox", "FCM Token: ");
        if (str2 != null) {
            str = str2.substring(0, Math.min(20, str2.length())) + "...";
        } else {
            str = "NULL";
        }
        com.unified.ur1.SatelliteTracker.h.q(sbI, str, "UnifiedInbox");
        if (unifiedInboxActivity.h == null) {
            Log.e("UnifiedInbox", "API service is null, cannot register FCM token");
            Toast.makeText(unifiedInboxActivity, "Cannot register for notifications - API not available", 1).show();
            return;
        }
        String str3 = unifiedInboxActivity.f5836j;
        if (str3 == null || str3.trim().isEmpty()) {
            Log.e("UnifiedInbox", "User callsign is null or empty, cannot register FCM token");
            Toast.makeText(unifiedInboxActivity, "Cannot register for notifications - No callsign", 1).show();
            return;
        }
        if (str2 == null || str2.trim().isEmpty()) {
            Log.e("UnifiedInbox", "FCM token is null or empty, cannot register");
            Toast.makeText(unifiedInboxActivity, "Cannot register for notifications - No FCM token", 1).show();
            return;
        }
        String string = unifiedInboxActivity.f5837k.getString("device_id", null);
        if (string == null || string.isEmpty()) {
            try {
                String string2 = Settings.Secure.getString(unifiedInboxActivity.getContentResolver(), "android_id");
                if (string2 == null || string2.isEmpty() || "9774d56d682e549c".equals(string2)) {
                    strConcat = "uuid_" + UUID.randomUUID().toString();
                } else {
                    strConcat = "android_".concat(string2);
                }
                string = strConcat;
                unifiedInboxActivity.f5837k.edit().putString("device_id", string).apply();
                Log.d("UnifiedInbox", "Generated new device ID: " + string);
            } catch (Exception e5) {
                StringBuilder sbG = com.unified.ur1.SatelliteTracker.h.g("UnifiedInbox", "Error generating device ID", e5, "fallback_");
                sbG.append(System.currentTimeMillis());
                string = sbG.toString();
                unifiedInboxActivity.f5837k.edit().putString("device_id", string).apply();
            }
        } else {
            Log.d("UnifiedInbox", "Using existing device ID: ".concat(string));
        }
        String str4 = string;
        String str5 = Build.MANUFACTURER + " " + Build.MODEL;
        Log.d("UnifiedInbox", "=== Registration Request Details ===");
        Log.d("UnifiedInbox", "Callsign: '" + unifiedInboxActivity.f5836j + "'");
        Log.d("UnifiedInbox", "Device ID: '" + str4 + "'");
        Log.d("UnifiedInbox", "Device Name: '" + str5 + "'");
        StringBuilder sbH = com.unified.ur1.SatelliteTracker.h.h("UnifiedInbox", "Platform: 'android'", "Token length: ");
        sbH.append(str2.length());
        Log.d("UnifiedInbox", sbH.toString());
        FCMTokenRequest fCMTokenRequest = new FCMTokenRequest(unifiedInboxActivity.f5836j, str2, "android", str4, str5);
        Log.d("UnifiedInbox", "Request object: " + fCMTokenRequest.toString());
        AbstractC0535a.v("Request JSON: ", new Gson().toJson(fCMTokenRequest), "UnifiedInbox");
        Call<ApiResponse> callRegisterFCMToken = unifiedInboxActivity.h.registerFCMToken(fCMTokenRequest);
        Log.d("UnifiedInbox", "Making API call to register FCM token...");
        callRegisterFCMToken.enqueue(new L0.s(18, unifiedInboxActivity, str4, false));
    }

    @Override // o3.r
    public void l() {
        Toast.makeText((LaunchActivity) ((i3.k) this.f6730d).f7315f, "Talkgroup selection cancelled", 0).show();
    }

    @Override // j0.InterfaceC0591d
    public void m() {
        Log.d("ProfileInstaller", "DIAGNOSTIC_PROFILE_IS_COMPRESSED");
    }

    @Override // o3.r
    public void n(o3.v vVar, String str, String str2, o3.s sVar) throws Throwable {
        LaunchActivity.A((LaunchActivity) ((i3.k) this.f6730d).f7315f, vVar, str2, sVar);
    }

    @Override // O.InterfaceC0158d
    public void o(Uri uri) {
        ((ContentInfo.Builder) this.f6730d).setLinkUri(uri);
    }

    @Override // retrofit2.Callback
    public void onFailure(Call call, Throwable th) {
        Log.e("ComposeMessageActivity", "User search network error", th);
        int i5 = ComposeMessageActivity.f5790C;
        ComposeMessageActivity composeMessageActivity = (ComposeMessageActivity) this.f6730d;
        composeMessageActivity.r(R.drawable.ic_error, R.color.accent_red, "Network error");
        composeMessageActivity.n();
        composeMessageActivity.f5809v = false;
    }

    @Override // retrofit2.Callback
    public void onResponse(Call call, Response response) throws JSONException {
        ComposeMessageActivity composeMessageActivity = (ComposeMessageActivity) this.f6730d;
        try {
            Log.d("ComposeMessageActivity", "Response code: " + response.code());
            if (!response.isSuccessful() || response.body() == null) {
                Log.e("ComposeMessageActivity", "User search failed: " + response.code());
                if (response.errorBody() != null) {
                    try {
                        Log.e("ComposeMessageActivity", "Error response body: " + response.errorBody().string());
                    } catch (Exception e5) {
                        Log.e("ComposeMessageActivity", "Error reading error body", e5);
                    }
                }
                int i5 = ComposeMessageActivity.f5790C;
                composeMessageActivity.r(R.drawable.ic_error, R.color.accent_red, "Search error");
                composeMessageActivity.n();
                composeMessageActivity.f5809v = false;
                return;
            }
            String strString = ((ResponseBody) response.body()).string();
            Log.d("ComposeMessageActivity", "Raw JSON Response: " + strString);
            JSONObject jSONObject = new JSONObject(strString);
            if (!jSONObject.getBoolean("success") || !jSONObject.has("data")) {
                Log.w("ComposeMessageActivity", "Search response not successful");
                int i6 = ComposeMessageActivity.f5790C;
                composeMessageActivity.r(R.drawable.ic_error, R.color.accent_red, "Search failed");
                composeMessageActivity.n();
                composeMessageActivity.f5809v = false;
                return;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
            if (!jSONObject2.has("users")) {
                Log.w("ComposeMessageActivity", "No users array in response");
                int i7 = ComposeMessageActivity.f5790C;
                composeMessageActivity.r(R.drawable.ic_info, R.color.gray_600, "No users found");
                composeMessageActivity.n();
                composeMessageActivity.f5809v = false;
                return;
            }
            JSONArray jSONArray = jSONObject2.getJSONArray("users");
            ArrayList arrayList = new ArrayList();
            for (int i8 = 0; i8 < jSONArray.length(); i8++) {
                JSONObject jSONObject3 = jSONArray.getJSONObject(i8);
                i3.I i9 = new i3.I(jSONObject3.optString("callsign", ""), jSONObject3.optString("first_name", ""), jSONObject3.optString("last_name", ""));
                arrayList.add(i9);
                Log.d("ComposeMessageActivity", "Parsed user: " + i9.toString());
            }
            Log.d("ComposeMessageActivity", "Successfully parsed " + arrayList.size() + " users");
            ComposeMessageActivity.j(composeMessageActivity, arrayList);
        } catch (Exception e6) {
            Log.e("ComposeMessageActivity", "Exception in user search response handling", e6);
            int i10 = ComposeMessageActivity.f5790C;
            composeMessageActivity.r(R.drawable.ic_error, R.color.accent_red, "Response error");
            composeMessageActivity.n();
            composeMessageActivity.f5809v = false;
        }
    }

    @Override // p1.o
    public void p(Object obj, Object obj2) {
        N1.k kVar = (N1.k) obj2;
        D1.D d5 = (D1.D) obj;
        p1.l lVar = (p1.l) ((androidx.emoji2.text.e) this.f6730d).f3602c;
        if (lVar != null) {
            d5.D(lVar, kVar);
        }
    }

    @Override // O.InterfaceC0158d
    public void q(int i5) {
        ((ContentInfo.Builder) this.f6730d).setFlags(i5);
    }

    public boolean r(L0.o oVar) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : (List) this.f6730d) {
            I0.e eVar = (I0.e) obj;
            eVar.getClass();
            if (eVar.b(oVar) && eVar.c(eVar.f677a.a())) {
                arrayList.add(obj);
            }
        }
        if (!arrayList.isEmpty()) {
            C0.t.d().a(H0.k.f660a, "Work " + oVar.f1561a + " constrained by " + t3.i.E(arrayList, null, null, null, H0.f.f650j, 31));
        }
        return arrayList.isEmpty();
    }

    public void s(R0.f fVar, C0016n c0016n, N1.p pVar) {
        synchronized (fVar.n) {
            fVar.f2221s = true;
        }
        fVar.a("post-response");
        ((Q0.e) this.f6730d).execute(new F0.e(fVar, c0016n, pVar, 13));
    }

    public void t(HashMap map) {
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            HashMap map2 = (HashMap) this.f6730d;
            if (value == null) {
                map2.put(str, null);
            } else {
                Class<?> cls = value.getClass();
                if (cls == Boolean.class || cls == Byte.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == String.class || cls == Boolean[].class || cls == Byte[].class || cls == Integer[].class || cls == Long[].class || cls == Float[].class || cls == Double[].class || cls == String[].class) {
                    map2.put(str, value);
                } else {
                    int i5 = 0;
                    if (cls == boolean[].class) {
                        boolean[] zArr = (boolean[]) value;
                        String str2 = C0.h.f156b;
                        Boolean[] boolArr = new Boolean[zArr.length];
                        while (i5 < zArr.length) {
                            boolArr[i5] = Boolean.valueOf(zArr[i5]);
                            i5++;
                        }
                        map2.put(str, boolArr);
                    } else if (cls == byte[].class) {
                        byte[] bArr = (byte[]) value;
                        String str3 = C0.h.f156b;
                        Byte[] bArr2 = new Byte[bArr.length];
                        while (i5 < bArr.length) {
                            bArr2[i5] = Byte.valueOf(bArr[i5]);
                            i5++;
                        }
                        map2.put(str, bArr2);
                    } else if (cls == int[].class) {
                        int[] iArr = (int[]) value;
                        String str4 = C0.h.f156b;
                        Integer[] numArr = new Integer[iArr.length];
                        while (i5 < iArr.length) {
                            numArr[i5] = Integer.valueOf(iArr[i5]);
                            i5++;
                        }
                        map2.put(str, numArr);
                    } else if (cls == long[].class) {
                        long[] jArr = (long[]) value;
                        String str5 = C0.h.f156b;
                        Long[] lArr = new Long[jArr.length];
                        while (i5 < jArr.length) {
                            lArr[i5] = Long.valueOf(jArr[i5]);
                            i5++;
                        }
                        map2.put(str, lArr);
                    } else if (cls == float[].class) {
                        float[] fArr = (float[]) value;
                        String str6 = C0.h.f156b;
                        Float[] fArr2 = new Float[fArr.length];
                        while (i5 < fArr.length) {
                            fArr2[i5] = Float.valueOf(fArr[i5]);
                            i5++;
                        }
                        map2.put(str, fArr2);
                    } else {
                        if (cls != double[].class) {
                            throw new IllegalArgumentException("Key " + str + " has invalid type " + cls);
                        }
                        double[] dArr = (double[]) value;
                        String str7 = C0.h.f156b;
                        Double[] dArr2 = new Double[dArr.length];
                        while (i5 < dArr.length) {
                            dArr2[i5] = Double.valueOf(dArr[i5]);
                            i5++;
                        }
                        map2.put(str, dArr2);
                    }
                }
            }
        }
    }

    public C0519j(AppDatabase appDatabase) {
        this.f6729c = 0;
        this.f6730d = appDatabase;
        new L0.b(appDatabase, 8);
        new L0.p(appDatabase, 3);
        new L0.p(appDatabase, 4);
    }

    public C0519j(Handler handler) {
        this.f6729c = 9;
        this.f6730d = new Q0.e(handler, 0);
    }

    public C0519j(Context context) {
        boolean zIsEmpty;
        this.f6729c = 10;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.appid", 0);
        this.f6730d = sharedPreferences;
        File file = new File(C.c.c(context), "com.google.android.gms.appid-no-backup");
        if (file.exists()) {
            return;
        }
        try {
            if (file.createNewFile()) {
                synchronized (this) {
                    zIsEmpty = sharedPreferences.getAll().isEmpty();
                }
                if (zIsEmpty) {
                    return;
                }
                Log.i("FirebaseMessaging", "App restored, clearing state");
                synchronized (this) {
                    sharedPreferences.edit().clear().commit();
                }
            }
        } catch (IOException e5) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Error creating file in no backup dir: " + e5.getMessage());
            }
        }
    }

    public C0519j(L0.i iVar) {
        this.f6729c = 5;
        F3.i.f(iVar, "trackers");
        I0.a aVar = new I0.a((J0.f) iVar.f1547c, 0);
        I0.a aVar2 = new I0.a((J0.a) iVar.f1548d);
        I0.a aVar3 = new I0.a((J0.f) iVar.f1550f, 4);
        J0.f fVar = (J0.f) iVar.f1549e;
        this.f6730d = t3.j.y(aVar, aVar2, aVar3, new I0.a(fVar, 2), new I0.a(fVar, 3), new I0.g(fVar), new I0.f(fVar));
    }

    public C0519j(C0292d[] c0292dArr) {
        this.f6729c = 12;
        F3.i.f(c0292dArr, "initializers");
        this.f6730d = c0292dArr;
    }

    public C0519j(ComposeMessageActivity composeMessageActivity, String str) {
        this.f6729c = 17;
        this.f6730d = composeMessageActivity;
    }

    public C0519j(int i5) {
        this.f6729c = i5;
        switch (i5) {
            case 24:
                break;
            default:
                this.f6730d = new HashMap();
                break;
        }
    }

    public C0519j(ClipData clipData, int i5) {
        this.f6729c = 8;
        this.f6730d = B.w.f(clipData, i5);
    }
}
