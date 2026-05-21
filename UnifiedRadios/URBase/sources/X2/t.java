package X2;

import J1.C0072h0;
import J1.C0113v0;
import J1.H;
import J1.Z;
import O.G;
import O.Y;
import android.R;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.gms.internal.measurement.C0313e;
import com.google.android.gms.internal.measurement.C0323g;
import com.google.android.gms.internal.measurement.InterfaceC0363o;
import com.google.android.gms.internal.measurement.M3;
import e1.C0436d;
import e1.C0444l;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import r3.InterfaceC0877a;

/* loaded from: classes.dex */
public final class t implements InterfaceC0877a {
    public static t g;
    public static t h;

    /* renamed from: c, reason: collision with root package name */
    public Object f2833c;

    /* renamed from: d, reason: collision with root package name */
    public Object f2834d;

    /* renamed from: e, reason: collision with root package name */
    public Object f2835e;

    /* renamed from: f, reason: collision with root package name */
    public Object f2836f;

    public t(C0072h0 c0072h0, String str) {
        this.f2836f = c0072h0;
        q1.E.f(str);
        this.f2833c = str;
        this.f2834d = new Bundle();
    }

    public static synchronized t c() {
        try {
            if (g == null) {
                g = new t(0);
            }
        } catch (Throwable th) {
            throw th;
        }
        return g;
    }

    public static t d() {
        if (h == null) {
            h = new t(8);
        }
        return h;
    }

    public boolean a(q2.l lVar, int i5) {
        q2.e eVar = (q2.e) lVar.f9478a.get();
        if (eVar == null) {
            return false;
        }
        ((Handler) this.f2834d).removeCallbacksAndMessages(lVar);
        Handler handler = q2.i.f9455z;
        handler.sendMessage(handler.obtainMessage(1, i5, 0, eVar.f9438a));
        return true;
    }

    public void b(Object obj, ArrayList arrayList, HashSet hashSet) {
        if (arrayList.contains(obj)) {
            return;
        }
        if (hashSet.contains(obj)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(obj);
        ArrayList arrayList2 = (ArrayList) ((q.k) this.f2834d).getOrDefault(obj, null);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i5 = 0; i5 < size; i5++) {
                b(arrayList2.get(i5), arrayList, hashSet);
            }
        }
        hashSet.remove(obj);
        arrayList.add(obj);
    }

    public boolean e(Context context) {
        if (((Boolean) this.f2835e) == null) {
            this.f2835e = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0);
        }
        if (!((Boolean) this.f2834d).booleanValue() && Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Missing Permission: android.permission.ACCESS_NETWORK_STATE this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return ((Boolean) this.f2835e).booleanValue();
    }

    public boolean f(Context context) {
        if (((Boolean) this.f2834d) == null) {
            this.f2834d = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0);
        }
        if (!((Boolean) this.f2834d).booleanValue() && Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Missing Permission: android.permission.WAKE_LOCK this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return ((Boolean) this.f2834d).booleanValue();
    }

    public boolean g(q2.e eVar) {
        q2.l lVar = (q2.l) this.f2835e;
        return (lVar == null || eVar == null || lVar.f9478a.get() != eVar) ? false : true;
    }

    @Override // r3.InterfaceC0877a
    public Object get() {
        return new C0444l((Executor) ((InterfaceC0877a) this.f2833c).get(), (f1.d) ((InterfaceC0877a) this.f2834d).get(), (C0436d) ((InterfaceC0877a) this.f2835e).get(), (g1.c) ((InterfaceC0877a) this.f2836f).get());
    }

    public synchronized boolean h(R0.f fVar) {
        try {
            String strD = fVar.d();
            if (!((HashMap) this.f2833c).containsKey(strD)) {
                ((HashMap) this.f2833c).put(strD, null);
                synchronized (fVar.n) {
                    fVar.f2224v = this;
                }
                if (Q0.o.f2164a) {
                    Q0.o.b("new request, sending to network %s", strD);
                }
                return false;
            }
            List arrayList = (List) ((HashMap) this.f2833c).get(strD);
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            fVar.a("waiting-for-response");
            arrayList.add(fVar);
            ((HashMap) this.f2833c).put(strD, arrayList);
            if (Q0.o.f2164a) {
                Q0.o.b("Request for cacheKey=%s is in flight, putting on hold.", strD);
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public void i(B0.o oVar) {
        WeakHashMap weakHashMap = Y.f1904a;
        G.s(oVar, 2);
        this.f2835e = new B0.g(1, this);
        ViewPager2 viewPager2 = (ViewPager2) this.f2836f;
        if (G.c(viewPager2) == 0) {
            G.s(viewPager2, 1);
        }
    }

    public synchronized void j(R0.f fVar) {
        BlockingQueue blockingQueue;
        try {
            String strD = fVar.d();
            List list = (List) ((HashMap) this.f2833c).remove(strD);
            if (list != null && !list.isEmpty()) {
                if (Q0.o.f2164a) {
                    Q0.o.d("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(list.size()), strD);
                }
                R0.f fVar2 = (R0.f) list.remove(0);
                ((HashMap) this.f2833c).put(strD, list);
                synchronized (fVar2.n) {
                    fVar2.f2224v = this;
                }
                if (((Q0.c) this.f2835e) != null && (blockingQueue = (BlockingQueue) this.f2836f) != null) {
                    try {
                        blockingQueue.put(fVar2);
                    } catch (InterruptedException e5) {
                        Q0.o.c("Couldn't add request to queue. %s", e5.toString());
                        Thread.currentThread().interrupt();
                        ((Q0.c) this.f2835e).b();
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void k(q2.e eVar) {
        synchronized (this.f2833c) {
            try {
                if (g(eVar)) {
                    q2.l lVar = (q2.l) this.f2835e;
                    if (!lVar.f9480c) {
                        lVar.f9480c = true;
                        ((Handler) this.f2834d).removeCallbacksAndMessages(lVar);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void l(q2.e eVar) {
        synchronized (this.f2833c) {
            try {
                if (g(eVar)) {
                    q2.l lVar = (q2.l) this.f2835e;
                    if (lVar.f9480c) {
                        lVar.f9480c = false;
                        m(lVar);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void m(q2.l lVar) {
        int i5 = lVar.f9479b;
        if (i5 == -2) {
            return;
        }
        if (i5 <= 0) {
            i5 = i5 == -1 ? 1500 : 2750;
        }
        Handler handler = (Handler) this.f2834d;
        handler.removeCallbacksAndMessages(lVar);
        handler.sendMessageDelayed(Message.obtain(handler, 0, lVar), i5);
    }

    public void n() {
        q2.l lVar = (q2.l) this.f2836f;
        if (lVar != null) {
            this.f2835e = lVar;
            this.f2836f = null;
            q2.e eVar = (q2.e) lVar.f9478a.get();
            if (eVar == null) {
                this.f2835e = null;
            } else {
                Handler handler = q2.i.f9455z;
                handler.sendMessage(handler.obtainMessage(0, eVar.f9438a));
            }
        }
    }

    public void o() {
        int itemCount;
        int i5 = R.id.accessibilityActionPageLeft;
        ViewPager2 viewPager2 = (ViewPager2) this.f2836f;
        Y.h(viewPager2, R.id.accessibilityActionPageLeft);
        Y.f(viewPager2, 0);
        Y.h(viewPager2, R.id.accessibilityActionPageRight);
        Y.f(viewPager2, 0);
        Y.h(viewPager2, R.id.accessibilityActionPageUp);
        Y.f(viewPager2, 0);
        Y.h(viewPager2, R.id.accessibilityActionPageDown);
        Y.f(viewPager2, 0);
        if (viewPager2.getAdapter() == null || (itemCount = viewPager2.getAdapter().getItemCount()) == 0 || !viewPager2.f4474t) {
            return;
        }
        int orientation = viewPager2.getOrientation();
        B0.l lVar = (B0.l) this.f2834d;
        Z2.c cVar = (Z2.c) this.f2833c;
        if (orientation != 0) {
            if (viewPager2.f4463f < itemCount - 1) {
                Y.i(viewPager2, new P.h(R.id.accessibilityActionPageDown), cVar);
            }
            if (viewPager2.f4463f > 0) {
                Y.i(viewPager2, new P.h(R.id.accessibilityActionPageUp), lVar);
                return;
            }
            return;
        }
        boolean z4 = viewPager2.f4464i.A() == 1;
        int i6 = z4 ? 16908360 : 16908361;
        if (z4) {
            i5 = 16908361;
        }
        if (viewPager2.f4463f < itemCount - 1) {
            Y.i(viewPager2, new P.h(i6), cVar);
        }
        if (viewPager2.f4463f > 0) {
            Y.i(viewPager2, new P.h(i5), lVar);
        }
    }

    public t p() {
        return new t(this, (L0.s) this.f2834d);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x011b A[Catch: NumberFormatException | JSONException -> 0x0123, NumberFormatException | JSONException -> 0x0123, TRY_LEAVE, TryCatch #0 {NumberFormatException | JSONException -> 0x0123, blocks: (B:10:0x0031, B:44:0x009d, B:44:0x009d, B:45:0x00ab, B:45:0x00ab, B:47:0x00b8, B:47:0x00b8, B:49:0x00ca, B:49:0x00ca, B:50:0x00d3, B:50:0x00d3, B:51:0x00d7, B:51:0x00d7, B:53:0x00e4, B:53:0x00e4, B:55:0x00f6, B:55:0x00f6, B:56:0x00ff, B:56:0x00ff, B:57:0x0103, B:57:0x0103, B:58:0x010f, B:58:0x010f, B:59:0x011b, B:59:0x011b), top: B:71:0x0031, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.os.Bundle q() throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 347
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: X2.t.q():android.os.Bundle");
    }

    public InterfaceC0363o r(InterfaceC0363o interfaceC0363o) {
        return ((L0.s) this.f2834d).D(this, interfaceC0363o);
    }

    public void s(Bundle bundle) throws JSONException {
        Iterator<String> it;
        JSONObject jSONObject;
        boolean zW;
        Z z4;
        Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
        C0072h0 c0072h0 = (C0072h0) this.f2836f;
        SharedPreferences sharedPreferencesP = c0072h0.p();
        C0113v0 c0113v0 = (C0113v0) c0072h0.f84c;
        SharedPreferences.Editor editorEdit = sharedPreferencesP.edit();
        int size = bundle2.size();
        String str = (String) this.f2833c;
        if (size == 0) {
            editorEdit.remove(str);
        } else {
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it2 = bundle2.keySet().iterator();
            while (it2.hasNext()) {
                String next = it2.next();
                Object obj = bundle2.get(next);
                if (obj != null) {
                    try {
                        jSONObject = new JSONObject();
                        jSONObject.put("n", next);
                        M3.b();
                        zW = c0113v0.f1415i.w(null, H.f789W0);
                        it = it2;
                        z4 = c0113v0.f1417k;
                    } catch (JSONException e5) {
                        e = e5;
                        it = it2;
                    }
                    if (zW) {
                        try {
                        } catch (JSONException e6) {
                            e = e6;
                            Z z5 = c0113v0.f1417k;
                            C0113v0.k(z5);
                            z5.h.b(e, "Cannot serialize bundle value to SharedPreferences");
                            it2 = it;
                        }
                        if (obj instanceof String) {
                            jSONObject.put("v", obj.toString());
                            jSONObject.put("t", "s");
                        } else if (obj instanceof Long) {
                            jSONObject.put("v", obj.toString());
                            jSONObject.put("t", "l");
                        } else if (obj instanceof int[]) {
                            jSONObject.put("v", Arrays.toString((int[]) obj));
                            jSONObject.put("t", "ia");
                        } else if (obj instanceof long[]) {
                            jSONObject.put("v", Arrays.toString((long[]) obj));
                            jSONObject.put("t", "la");
                        } else if (obj instanceof Double) {
                            jSONObject.put("v", obj.toString());
                            jSONObject.put("t", "d");
                        } else {
                            C0113v0.k(z4);
                            z4.h.b(obj.getClass(), "Cannot serialize bundle value to SharedPreferences. Type");
                            it2 = it;
                        }
                        jSONArray.put(jSONObject);
                        it2 = it;
                    } else {
                        jSONObject.put("v", obj.toString());
                        if (obj instanceof String) {
                            jSONObject.put("t", "s");
                        } else if (obj instanceof Long) {
                            jSONObject.put("t", "l");
                        } else if (obj instanceof Double) {
                            jSONObject.put("t", "d");
                        } else {
                            C0113v0.k(z4);
                            z4.h.b(obj.getClass(), "Cannot serialize bundle value to SharedPreferences. Type");
                            it2 = it;
                        }
                        jSONArray.put(jSONObject);
                        it2 = it;
                    }
                }
            }
            editorEdit.putString(str, jSONArray.toString());
        }
        editorEdit.apply();
        this.f2835e = bundle2;
    }

    public InterfaceC0363o t(C0313e c0313e) {
        InterfaceC0363o interfaceC0363oD = InterfaceC0363o.f5004b;
        Iterator itM = c0313e.m();
        while (itM.hasNext()) {
            interfaceC0363oD = ((L0.s) this.f2834d).D(this, c0313e.k(((Integer) itM.next()).intValue()));
            if (interfaceC0363oD instanceof C0323g) {
                break;
            }
        }
        return interfaceC0363oD;
    }

    public InterfaceC0363o u(String str) {
        HashMap map = (HashMap) this.f2835e;
        if (map.containsKey(str)) {
            return (InterfaceC0363o) map.get(str);
        }
        t tVar = (t) this.f2833c;
        if (tVar != null) {
            return tVar.u(str);
        }
        throw new IllegalArgumentException(com.unified.ur1.SatelliteTracker.h.b(str, " is not defined"));
    }

    public void v(String str, InterfaceC0363o interfaceC0363o) {
        if (((HashMap) this.f2836f).containsKey(str)) {
            return;
        }
        HashMap map = (HashMap) this.f2835e;
        if (interfaceC0363o == null) {
            map.remove(str);
        } else {
            map.put(str, interfaceC0363o);
        }
    }

    public void w(String str, InterfaceC0363o interfaceC0363o) {
        t tVar;
        HashMap map = (HashMap) this.f2835e;
        if (!map.containsKey(str) && (tVar = (t) this.f2833c) != null && tVar.x(str)) {
            tVar.w(str, interfaceC0363o);
        } else {
            if (((HashMap) this.f2836f).containsKey(str)) {
                return;
            }
            if (interfaceC0363o == null) {
                map.remove(str);
            } else {
                map.put(str, interfaceC0363o);
            }
        }
    }

    public boolean x(String str) {
        if (((HashMap) this.f2835e).containsKey(str)) {
            return true;
        }
        t tVar = (t) this.f2833c;
        if (tVar != null) {
            return tVar.x(str);
        }
        return false;
    }

    public t(t tVar, L0.s sVar) {
        this.f2835e = new HashMap();
        this.f2836f = new HashMap();
        this.f2833c = tVar;
        this.f2834d = sVar;
    }

    public t(int i5) {
        switch (i5) {
            case 4:
                this.f2834d = null;
                this.f2835e = new ArrayList();
                this.f2836f = null;
                this.f2833c = "";
                break;
            case 5:
            case 6:
            default:
                this.f2833c = null;
                this.f2834d = null;
                this.f2835e = null;
                this.f2836f = new ArrayDeque();
                break;
            case 7:
                this.f2834d = new LinkedBlockingQueue(100);
                this.f2835e = new AtomicBoolean(false);
                this.f2833c = Executors.newSingleThreadExecutor();
                break;
            case 8:
                this.f2833c = new Object();
                this.f2834d = new Handler(Looper.getMainLooper(), new m1.j(1, this));
                break;
            case 9:
                this.f2833c = new N.c(10);
                this.f2834d = new q.k();
                this.f2835e = new ArrayList();
                this.f2836f = new HashSet();
                break;
        }
    }
}
