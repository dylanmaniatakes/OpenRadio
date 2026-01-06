package L0;

import J1.InterfaceC0054b0;
import J1.V1;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import androidx.lifecycle.C0251v;
import androidx.lifecycle.EnumC0243m;
import androidx.lifecycle.InterfaceC0249t;
import com.google.gson.Gson;
import e0.HandlerC0430a;
import f3.C0515f;
import j3.C0604b;
import j3.C0605c;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import k.S;
import l0.AbstractC0737m;
import m3.C0764B;
import w1.AbstractC0930a;

/* loaded from: classes.dex */
public final class m implements InterfaceC0054b0, Q3.f, j3.f {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1555c;

    /* renamed from: d, reason: collision with root package name */
    public Object f1556d;

    /* renamed from: e, reason: collision with root package name */
    public Object f1557e;

    /* renamed from: f, reason: collision with root package name */
    public Object f1558f;

    public /* synthetic */ m() {
        this.f1555c = 4;
    }

    public static m k(Context context, AttributeSet attributeSet, int[] iArr, int i5, int i6) {
        return new m(context, context.obtainStyledAttributes(attributeSet, iArr, i5, i6));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // Q3.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(java.lang.Object r9, w3.InterfaceC0936d r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof Q3.c
            if (r0 == 0) goto L13
            r0 = r10
            Q3.c r0 = (Q3.c) r0
            int r1 = r0.f2182l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f2182l = r1
            goto L18
        L13:
            Q3.c r0 = new Q3.c
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.f2180j
            x3.a r1 = x3.EnumC0973a.f10448j
            int r2 = r0.f2182l
            s3.j r3 = s3.C0900j.f9694a
            r4 = 1
            if (r2 == 0) goto L31
            if (r2 != r4) goto L29
            com.google.android.gms.internal.measurement.AbstractC0399v1.j(r10)
            goto L67
        L29:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L31:
            com.google.android.gms.internal.measurement.AbstractC0399v1.j(r10)
            java.lang.Object r10 = r8.f1556d
            Q3.d r10 = (Q3.d) r10
            E3.l r2 = r10.f2184b
            java.lang.Object r2 = r2.invoke(r9)
            java.lang.Object r5 = r8.f1557e
            F3.l r5 = (F3.l) r5
            java.lang.Object r6 = r5.f602j
            S3.w r7 = R3.g.f2326a
            if (r6 == r7) goto L58
            E3.p r10 = r10.f2185c
            java.lang.Object r10 = r10.c(r6, r2)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 != 0) goto L57
            goto L58
        L57:
            return r3
        L58:
            r5.f602j = r2
            r0.f2182l = r4
            java.lang.Object r10 = r8.f1558f
            Q3.f r10 = (Q3.f) r10
            java.lang.Object r9 = r10.a(r9, r0)
            if (r9 != r1) goto L67
            return r1
        L67:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: L0.m.a(java.lang.Object, w3.d):java.lang.Object");
    }

    @Override // j3.f
    public void b(String str) {
        Log.w("SolarDataManager", "Weather fetch failed: " + str);
        synchronized (this.f1556d) {
            ((boolean[]) this.f1557e)[0] = true;
            this.f1556d.notify();
        }
    }

    @Override // j3.f
    public void c(j3.g gVar) {
        ((C0605c) this.f1558f).getClass();
        C0604b c0604b = ((C0605c) this.f1558f).f7610f;
        c0604b.f7578A = gVar.f7616a;
        c0604b.f7579B = gVar.f7617b;
        c0604b.f7580C = gVar.f7620e;
        c0604b.getClass();
        double d5 = gVar.h;
        if (d5 > 0.8d) {
            ((C0605c) this.f1558f).f7610f.f7581D = "Strong";
        } else if (d5 > 0.6d) {
            ((C0605c) this.f1558f).f7610f.f7581D = "Moderate";
        } else if (d5 > 0.3d) {
            ((C0605c) this.f1558f).f7610f.f7581D = "Weak";
        } else {
            ((C0605c) this.f1558f).f7610f.f7581D = "None";
        }
        Log.d("SolarDataManager", String.format("Weather: %.1f hPa, %.1f°C, %s, Tropo: %s", Double.valueOf(gVar.f7616a), Double.valueOf(gVar.f7617b), gVar.f7620e, ((C0605c) this.f1558f).f7610f.f7581D));
        synchronized (this.f1556d) {
            ((boolean[]) this.f1557e)[0] = true;
            this.f1556d.notify();
        }
    }

    public Y0.i d() {
        String strConcat = ((String) this.f1556d) == null ? " backendName" : "";
        if (((V0.d) this.f1558f) == null) {
            strConcat = strConcat.concat(" priority");
        }
        if (strConcat.isEmpty()) {
            return new Y0.i((String) this.f1556d, (byte[]) this.f1557e, (V0.d) this.f1558f);
        }
        throw new IllegalStateException("Missing required properties:".concat(strConcat));
    }

    public C0515f e(int i5) {
        HashMap map = (HashMap) this.f1558f;
        C0515f c0515f = (C0515f) map.get(Integer.valueOf(i5));
        if (c0515f == null || System.currentTimeMillis() - c0515f.f6703i <= 2592000000L) {
            return c0515f;
        }
        map.remove(Integer.valueOf(i5));
        ((SharedPreferences) this.f1556d).edit().remove("caller_" + i5).apply();
        return null;
    }

    public ColorStateList f(int i5) {
        int resourceId;
        ColorStateList colorStateListC;
        TypedArray typedArray = (TypedArray) this.f1557e;
        return (!typedArray.hasValue(i5) || (resourceId = typedArray.getResourceId(i5, 0)) == 0 || (colorStateListC = C.h.c((Context) this.f1556d, resourceId)) == null) ? typedArray.getColorStateList(i5) : colorStateListC;
    }

    public Drawable g(int i5) {
        int resourceId;
        TypedArray typedArray = (TypedArray) this.f1557e;
        return (!typedArray.hasValue(i5) || (resourceId = typedArray.getResourceId(i5, 0)) == 0) ? typedArray.getDrawable(i5) : AbstractC0930a.k((Context) this.f1556d, resourceId);
    }

    @Override // J1.InterfaceC0054b0
    public void h(String str, int i5, IOException iOException, byte[] bArr, Map map) {
        ((V1) this.f1558f).s(true, i5, iOException, bArr, (String) this.f1556d, (List) this.f1557e);
    }

    public Drawable i(int i5) {
        int resourceId;
        Drawable drawableF;
        if (!((TypedArray) this.f1557e).hasValue(i5) || (resourceId = ((TypedArray) this.f1557e).getResourceId(i5, 0)) == 0) {
            return null;
        }
        k.r rVarA = k.r.a();
        Context context = (Context) this.f1556d;
        synchronized (rVarA) {
            drawableF = rVarA.f7855a.f(context, resourceId, true);
        }
        return drawableF;
    }

    public Typeface j(int i5, int i6, S s4) {
        int resourceId = ((TypedArray) this.f1557e).getResourceId(i5, 0);
        if (resourceId == 0) {
            return null;
        }
        if (((TypedValue) this.f1558f) == null) {
            this.f1558f = new TypedValue();
        }
        TypedValue typedValue = (TypedValue) this.f1558f;
        ThreadLocal threadLocal = D.p.f225a;
        Context context = (Context) this.f1556d;
        if (context.isRestricted()) {
            return null;
        }
        return D.p.b(context, resourceId, typedValue, i6, s4, true, false);
    }

    public void l(EnumC0243m enumC0243m) {
        S1.c cVar = (S1.c) this.f1558f;
        if (cVar != null) {
            cVar.run();
        }
        S1.c cVar2 = new S1.c((C0251v) this.f1556d, enumC0243m);
        this.f1558f = cVar2;
        ((Handler) this.f1557e).postAtFrontOfQueue(cVar2);
    }

    public void m(int i5, C0515f c0515f) {
        c0515f.f6703i = System.currentTimeMillis();
        ((HashMap) this.f1558f).put(Integer.valueOf(i5), c0515f);
        String json = ((Gson) this.f1557e).toJson(c0515f);
        ((SharedPreferences) this.f1556d).edit().putString("caller_" + i5, json).apply();
    }

    public void n() {
        ((TypedArray) this.f1557e).recycle();
    }

    public void o(String str) {
        if (str == null) {
            throw new NullPointerException("Null backendName");
        }
        this.f1556d = str;
    }

    public String toString() {
        switch (this.f1555c) {
            case 11:
                StringBuilder sb = new StringBuilder(32);
                sb.append((String) this.f1556d);
                sb.append('{');
                c cVar = (c) ((c) this.f1557e).f1537e;
                String str = "";
                while (cVar != null) {
                    Object obj = cVar.f1536d;
                    sb.append(str);
                    if (obj == null || !obj.getClass().isArray()) {
                        sb.append(obj);
                    } else {
                        String strDeepToString = Arrays.deepToString(new Object[]{obj});
                        sb.append((CharSequence) strDeepToString, 1, strDeepToString.length() - 1);
                    }
                    cVar = (c) cVar.f1537e;
                    str = ", ";
                }
                sb.append('}');
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public /* synthetic */ m(Object obj, Serializable serializable, Object obj2, int i5) {
        this.f1555c = i5;
        this.f1556d = obj;
        this.f1557e = serializable;
        this.f1558f = obj2;
    }

    public /* synthetic */ m(Object obj, Object obj2, Object obj3, int i5) {
        this.f1555c = i5;
        this.f1556d = obj2;
        this.f1557e = obj3;
        this.f1558f = obj;
    }

    public m(Context context) throws NumberFormatException {
        this.f1555c = 7;
        SharedPreferences sharedPreferences = context.getSharedPreferences("caller_info_cache", 0);
        this.f1556d = sharedPreferences;
        this.f1557e = new Gson();
        this.f1558f = new HashMap();
        for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
            try {
                if (entry.getKey().startsWith("caller_")) {
                    int i5 = Integer.parseInt(entry.getKey().substring(7));
                    C0515f c0515f = (C0515f) ((Gson) this.f1557e).fromJson((String) entry.getValue(), C0515f.class);
                    c0515f.getClass();
                    if (System.currentTimeMillis() - c0515f.f6703i > 2592000000L) {
                        sharedPreferences.edit().remove(entry.getKey()).apply();
                    } else {
                        ((HashMap) this.f1558f).put(Integer.valueOf(i5), c0515f);
                    }
                }
            } catch (Exception e5) {
                com.unified.ur1.SatelliteTracker.h.o(e5, new StringBuilder("Error loading cache entry: "), "Unified - CallerInfoCache");
            }
        }
    }

    public m(InterfaceC0249t interfaceC0249t) {
        this.f1555c = 5;
        F3.i.f(interfaceC0249t, "provider");
        this.f1556d = new C0251v(interfaceC0249t);
        this.f1557e = new Handler();
    }

    public m(m3.p pVar) {
        this.f1555c = 10;
        this.f1556d = pVar;
        this.f1557e = C0764B.e();
        this.f1558f = new HandlerC0430a(this, Looper.getMainLooper(), 3);
    }

    public m(AbstractC0737m abstractC0737m) {
        this.f1555c = 0;
        this.f1556d = abstractC0737m;
        new b(abstractC0737m, 4);
        this.f1557e = new h(abstractC0737m, 2);
        this.f1558f = new h(abstractC0737m, 3);
    }

    public m(Context context, TypedArray typedArray) {
        this.f1555c = 9;
        this.f1556d = context;
        this.f1557e = typedArray;
    }

    public m(ExecutorService executorService, Z3.c cVar) {
        this.f1555c = 6;
        this.f1557e = cVar;
        this.f1558f = null;
        try {
            this.f1556d = b4.a.class.getConstructor(Throwable.class);
        } catch (NoSuchMethodException e5) {
            throw new RuntimeException("Failure event class must have a constructor with one parameter of type Throwable", e5);
        }
    }

    public m(String str) {
        this.f1555c = 11;
        c cVar = new c(25);
        this.f1557e = cVar;
        this.f1558f = cVar;
        this.f1556d = str;
    }
}
