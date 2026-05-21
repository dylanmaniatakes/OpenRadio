package R0;

import D1.C0016n;
import J1.R0;
import O.C0182v;
import Q0.i;
import Q0.j;
import Q0.k;
import Q0.n;
import Q0.o;
import X2.t;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.measurement.AbstractC0296a2;
import com.unified.ur1.SatelliteTracker.h;
import f3.C0519j;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class f implements Comparable {

    /* renamed from: j, reason: collision with root package name */
    public final n f2213j;

    /* renamed from: k, reason: collision with root package name */
    public final int f2214k;

    /* renamed from: l, reason: collision with root package name */
    public final String f2215l;

    /* renamed from: m, reason: collision with root package name */
    public final int f2216m;
    public final Object n;

    /* renamed from: o, reason: collision with root package name */
    public final j f2217o;

    /* renamed from: p, reason: collision with root package name */
    public Integer f2218p;

    /* renamed from: q, reason: collision with root package name */
    public i f2219q;

    /* renamed from: r, reason: collision with root package name */
    public final boolean f2220r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f2221s;

    /* renamed from: t, reason: collision with root package name */
    public final C0182v f2222t;

    /* renamed from: u, reason: collision with root package name */
    public Q0.b f2223u;

    /* renamed from: v, reason: collision with root package name */
    public t f2224v;

    /* renamed from: w, reason: collision with root package name */
    public final Object f2225w;

    /* renamed from: x, reason: collision with root package name */
    public final k f2226x;

    /* renamed from: y, reason: collision with root package name */
    public final String f2227y;

    public f(String str, k kVar, j jVar) {
        Uri uri;
        String host;
        this.f2213j = n.f2161c ? new n() : null;
        this.n = new Object();
        this.f2220r = true;
        int iHashCode = 0;
        this.f2221s = false;
        this.f2223u = null;
        this.f2214k = 0;
        this.f2215l = str;
        this.f2217o = jVar;
        C0182v c0182v = new C0182v();
        c0182v.f1974a = 2500;
        this.f2222t = c0182v;
        if (!TextUtils.isEmpty(str) && (uri = Uri.parse(str)) != null && (host = uri.getHost()) != null) {
            iHashCode = host.hashCode();
        }
        this.f2216m = iHashCode;
        this.f2225w = new Object();
        this.f2226x = kVar;
        this.f2227y = null;
    }

    public final void a(String str) {
        if (n.f2161c) {
            this.f2213j.a(Thread.currentThread().getId(), str);
        }
    }

    public final void b(String str) {
        i iVar = this.f2219q;
        if (iVar != null) {
            synchronized (iVar.f2150b) {
                iVar.f2150b.remove(this);
            }
            synchronized (iVar.f2156j) {
                Iterator it = iVar.f2156j.iterator();
                if (it.hasNext()) {
                    h.p(it.next());
                    throw null;
                }
            }
            iVar.b();
        }
        if (n.f2161c) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new R0(this, str, id, 2));
            } else {
                this.f2213j.a(id, str);
                this.f2213j.b(toString());
            }
        }
    }

    public final byte[] c() {
        String str = this.f2227y;
        if (str == null) {
            return null;
        }
        try {
            return str.getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
            Log.wtf("Volley", o.a("Unsupported Encoding while trying to get the bytes of %s using %s", str, "utf-8"));
            return null;
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        f fVar = (f) obj;
        fVar.getClass();
        return this.f2218p.intValue() - fVar.f2218p.intValue();
    }

    public final String d() {
        String str = this.f2215l;
        int i5 = this.f2214k;
        if (i5 == 0 || i5 == -1) {
            return str;
        }
        return Integer.toString(i5) + '-' + str;
    }

    public Map e() {
        return Collections.emptyMap();
    }

    public final boolean f() {
        boolean z4;
        synchronized (this.n) {
            z4 = this.f2221s;
        }
        return z4;
    }

    public final void g() {
        t tVar;
        synchronized (this.n) {
            tVar = this.f2224v;
        }
        if (tVar != null) {
            tVar.j(this);
        }
    }

    public final void h(C0016n c0016n) {
        t tVar;
        List list;
        synchronized (this.n) {
            tVar = this.f2224v;
        }
        if (tVar != null) {
            Q0.b bVar = (Q0.b) c0016n.f396e;
            if (bVar != null) {
                if (bVar.f2133e >= System.currentTimeMillis()) {
                    String strD = d();
                    synchronized (tVar) {
                        list = (List) ((HashMap) tVar.f2833c).remove(strD);
                    }
                    if (list != null) {
                        if (o.f2164a) {
                            o.d("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(list.size()), strD);
                        }
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            ((C0519j) tVar.f2834d).s((f) it.next(), c0016n, null);
                        }
                        return;
                    }
                    return;
                }
            }
            tVar.j(this);
        }
    }

    public final C0016n i(C0016n c0016n) {
        try {
            return new C0016n(new JSONObject(new String((byte[]) c0016n.f395d, AbstractC0296a2.l((Map) c0016n.f396e))), AbstractC0296a2.k(c0016n));
        } catch (UnsupportedEncodingException e5) {
            return new C0016n(new Q0.a(e5));
        } catch (JSONException e6) {
            return new C0016n(new Q0.a(e6));
        }
    }

    public final void j(int i5) {
        i iVar = this.f2219q;
        if (iVar != null) {
            iVar.b();
        }
    }

    public final String toString() {
        String str = "0x" + Integer.toHexString(this.f2216m);
        StringBuilder sb = new StringBuilder("[ ] ");
        synchronized (this.n) {
        }
        sb.append(this.f2215l);
        sb.append(" ");
        sb.append(str);
        sb.append(" ");
        sb.append("NORMAL");
        sb.append(" ");
        sb.append(this.f2218p);
        return sb.toString();
    }
}
