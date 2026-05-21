package J1;

import X2.C0202f;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import com.google.android.gms.internal.measurement.AbstractC0409x1;
import com.google.android.gms.internal.measurement.C0307c3;
import com.google.android.gms.internal.measurement.C0317e3;
import com.google.android.gms.internal.measurement.C0322f3;
import com.google.android.gms.internal.measurement.C0332h3;
import com.google.android.gms.internal.measurement.InterfaceC0312d3;
import com.google.android.gms.internal.measurement.InterfaceC0327g3;
import com.google.android.gms.internal.measurement.W2;
import com.google.android.gms.internal.measurement.Y2;
import com.google.firebase.components.ComponentRegistrar;
import f.InterfaceC0465b;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import n2.C0802a;
import org.conscrypt.FileClientSessionCache;
import r3.InterfaceC0877a;

/* loaded from: classes.dex */
public final /* synthetic */ class D implements F, Z3.f, InterfaceC0465b, InterfaceC0877a {

    /* renamed from: d, reason: collision with root package name */
    public static D f717d;

    /* renamed from: e, reason: collision with root package name */
    public static D f718e;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f719c;

    public /* synthetic */ D(int i5) {
        this.f719c = i5;
    }

    public static void b(HttpURLConnection httpURLConnection, R0.f fVar, byte[] bArr) throws IOException {
        httpURLConnection.setDoOutput(true);
        if (!httpURLConnection.getRequestProperties().containsKey("Content-Type")) {
            httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
        }
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        dataOutputStream.write(bArr);
        dataOutputStream.close();
    }

    public static ArrayList e(Map map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getKey() != null) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    arrayList.add(new Q0.f((String) entry.getKey(), (String) it.next()));
                }
            }
        }
        return arrayList;
    }

    public static D f(Context context, int i5) throws Resources.NotFoundException {
        h4.f.a(i5 != 0, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i5, O1.a.f2011p);
        Rect rect = new Rect(typedArrayObtainStyledAttributes.getDimensionPixelOffset(0, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(2, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(3, 0));
        ColorStateList colorStateListF = AbstractC0409x1.f(context, typedArrayObtainStyledAttributes, 4);
        ColorStateList colorStateListF2 = AbstractC0409x1.f(context, typedArrayObtainStyledAttributes, 9);
        ColorStateList colorStateListF3 = AbstractC0409x1.f(context, typedArrayObtainStyledAttributes, 7);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(8, 0);
        n2.m mVarA = n2.m.a(context, typedArrayObtainStyledAttributes.getResourceId(5, 0), typedArrayObtainStyledAttributes.getResourceId(6, 0), new C0802a(0)).a();
        typedArrayObtainStyledAttributes.recycle();
        return new D(colorStateListF, colorStateListF2, colorStateListF3, dimensionPixelSize, mVarA, rect);
    }

    public static void i(HttpURLConnection httpURLConnection, R0.f fVar) throws IOException {
        switch (fVar.f2214k) {
            case o1.f.SUCCESS_CACHE /* -1 */:
                byte[] bArrC = fVar.c();
                if (bArrC != null) {
                    httpURLConnection.setRequestMethod("POST");
                    b(httpURLConnection, fVar, bArrC);
                    return;
                }
                return;
            case 0:
                httpURLConnection.setRequestMethod("GET");
                return;
            case 1:
                httpURLConnection.setRequestMethod("POST");
                byte[] bArrC2 = fVar.c();
                if (bArrC2 != null) {
                    b(httpURLConnection, fVar, bArrC2);
                    return;
                }
                return;
            case 2:
                httpURLConnection.setRequestMethod("PUT");
                byte[] bArrC3 = fVar.c();
                if (bArrC3 != null) {
                    b(httpURLConnection, fVar, bArrC3);
                    return;
                }
                return;
            case 3:
                httpURLConnection.setRequestMethod("DELETE");
                return;
            case 4:
                httpURLConnection.setRequestMethod("HEAD");
                return;
            case 5:
                httpURLConnection.setRequestMethod("OPTIONS");
                return;
            case 6:
                httpURLConnection.setRequestMethod("TRACE");
                return;
            case 7:
                httpURLConnection.setRequestMethod("PATCH");
                byte[] bArrC4 = fVar.c();
                if (bArrC4 != null) {
                    b(httpURLConnection, fVar, bArrC4);
                    return;
                }
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    @Override // J1.F
    public Object a() {
        switch (this.f719c) {
            case 0:
                List list = H.f796a;
                ((Y2) W2.f4795k.get()).getClass();
                return Integer.valueOf((int) ((Long) Y2.f4863q.b()).longValue());
            case 1:
                List list2 = H.f796a;
                ((Y2) W2.f4795k.get()).getClass();
                return Integer.valueOf((int) ((Long) Y2.f4859o.b()).longValue());
            case 2:
                List list3 = H.f796a;
                ((Y2) W2.f4795k.get()).getClass();
                Long l5 = (Long) Y2.f4835a0.b();
                l5.getClass();
                return l5;
            case 3:
                List list4 = H.f796a;
                ((C0332h3) ((InterfaceC0327g3) C0322f3.f4933k.f4934j.f10447j)).getClass();
                Boolean bool = (Boolean) C0332h3.f4949b.b();
                bool.getClass();
                return bool;
            case 4:
                List list5 = H.f796a;
                ((Y2) W2.f4795k.get()).getClass();
                return Integer.valueOf((int) ((Long) Y2.f4872v.b()).longValue());
            case 5:
                List list6 = H.f796a;
                ((Y2) W2.f4795k.get()).getClass();
                return (String) Y2.f4833Z.b();
            case 6:
                List list7 = H.f796a;
                ((Y2) W2.f4795k.get()).getClass();
                return (String) Y2.f4831X.b();
            case 7:
                List list8 = H.f796a;
                ((Y2) W2.f4795k.get()).getClass();
                return (String) Y2.f4810B.b();
            case 8:
                List list9 = H.f796a;
                ((Y2) W2.f4795k.get()).getClass();
                return (String) Y2.f4850j.b();
            case 9:
                List list10 = H.f796a;
                ((Y2) W2.f4795k.get()).getClass();
                return (String) Y2.f4832Y.b();
            case 10:
                List list11 = H.f796a;
                ((Y2) W2.f4795k.get()).getClass();
                Long l6 = (Long) Y2.f4830W.b();
                l6.getClass();
                return l6;
            case 11:
                List list12 = H.f796a;
                ((Y2) W2.f4795k.get()).getClass();
                return Integer.valueOf((int) ((Long) Y2.f4828U.b()).longValue());
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                List list13 = H.f796a;
                ((Y2) W2.f4795k.get()).getClass();
                return Integer.valueOf((int) ((Long) Y2.f4869t.b()).longValue());
            case o1.f.ERROR /* 13 */:
                List list14 = H.f796a;
                ((Y2) W2.f4795k.get()).getClass();
                Boolean bool2 = (Boolean) Y2.f4809A.b();
                bool2.getClass();
                return bool2;
            default:
                List list15 = H.f796a;
                ((C0317e3) ((InterfaceC0312d3) C0307c3.f4914k.f4915j.f10447j)).getClass();
                Boolean bool3 = (Boolean) C0317e3.f4926b.b();
                bool3.getClass();
                return bool3;
        }
    }

    @Override // Z3.f
    public void c(Level level, String str) {
        System.out.println("[" + level + "] " + str);
    }

    @Override // Z3.f
    public void d(Level level, String str, Exception exc) {
        PrintStream printStream = System.out;
        printStream.println("[" + level + "] " + str);
        exc.printStackTrace(printStream);
    }

    public R0.a g(R0.f fVar, Map map) throws Throwable {
        HashMap map2 = new HashMap();
        map2.putAll(map);
        map2.putAll(fVar.e());
        URL url = new URL(fVar.f2215l);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        int i5 = fVar.f2222t.f1974a;
        httpURLConnection.setConnectTimeout(i5);
        httpURLConnection.setReadTimeout(i5);
        boolean z4 = false;
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        "https".equals(url.getProtocol());
        try {
            for (String str : map2.keySet()) {
                httpURLConnection.setRequestProperty(str, (String) map2.get(str));
            }
            i(httpURLConnection, fVar);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == -1) {
                throw new IOException("Could not retrieve response code from HttpUrlConnection.");
            }
            if (fVar.f2214k == 4 || ((100 <= responseCode && responseCode < 200) || responseCode == 204 || responseCode == 304)) {
                R0.a aVar = new R0.a(responseCode, e(httpURLConnection.getHeaderFields()), -1, null);
                httpURLConnection.disconnect();
                return aVar;
            }
            try {
                return new R0.a(responseCode, e(httpURLConnection.getHeaderFields()), httpURLConnection.getContentLength(), new R0.e(httpURLConnection));
            } catch (Throwable th) {
                th = th;
                z4 = true;
                if (!z4) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // r3.InterfaceC0877a
    public Object get() {
        return Integer.valueOf(f1.l.f6467m);
    }

    public List h(ComponentRegistrar componentRegistrar) {
        ArrayList arrayList = new ArrayList();
        for (F2.b bVar : componentRegistrar.getComponents()) {
            String str = bVar.f543a;
            if (str != null) {
                C0202f c0202f = new C0202f(str, 3, bVar);
                bVar = new F2.b(str, bVar.f544b, bVar.f545c, bVar.f546d, bVar.f547e, c0202f, bVar.g);
            }
            arrayList.add(bVar);
        }
        return arrayList;
    }

    public D(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i5, n2.m mVar, Rect rect) {
        this.f719c = 26;
        h4.f.b(rect.left);
        h4.f.b(rect.top);
        h4.f.b(rect.right);
        h4.f.b(rect.bottom);
    }

    public D(int[] iArr, ValueAnimator valueAnimator) {
        this.f719c = 29;
    }
}
