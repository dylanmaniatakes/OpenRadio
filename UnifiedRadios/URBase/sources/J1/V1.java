package J1;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.measurement.C0295a1;
import com.google.android.gms.internal.measurement.C0310d1;
import com.google.android.gms.internal.measurement.C0315e1;
import com.google.android.gms.internal.measurement.C0320f1;
import com.google.android.gms.internal.measurement.C0360n1;
import com.google.android.gms.internal.measurement.C0365o1;
import com.google.android.gms.internal.measurement.M3;
import com.google.android.gms.internal.measurement.V3;
import com.google.android.gms.internal.measurement.W3;
import f3.C0513e;
import f3.C0519j;
import g0.AbstractC0535a;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.conscrypt.PSKKeyManager;
import u1.C0906a;
import w1.C0931b;

/* loaded from: classes.dex */
public final class V1 implements G0 {

    /* renamed from: M, reason: collision with root package name */
    public static volatile V1 f1005M;

    /* renamed from: A, reason: collision with root package name */
    public ArrayList f1006A;

    /* renamed from: B, reason: collision with root package name */
    public ArrayList f1007B;

    /* renamed from: D, reason: collision with root package name */
    public final HashMap f1009D;

    /* renamed from: E, reason: collision with root package name */
    public final HashMap f1010E;

    /* renamed from: F, reason: collision with root package name */
    public final HashMap f1011F;

    /* renamed from: H, reason: collision with root package name */
    public C0082k1 f1013H;
    public String I;

    /* renamed from: J, reason: collision with root package name */
    public E1 f1014J;

    /* renamed from: K, reason: collision with root package name */
    public long f1015K;

    /* renamed from: c, reason: collision with root package name */
    public final C0093o0 f1017c;

    /* renamed from: d, reason: collision with root package name */
    public final C0060d0 f1018d;

    /* renamed from: e, reason: collision with root package name */
    public C0089n f1019e;

    /* renamed from: f, reason: collision with root package name */
    public C0063e0 f1020f;
    public L1 g;
    public C0056c h;

    /* renamed from: i, reason: collision with root package name */
    public final C0060d0 f1021i;

    /* renamed from: j, reason: collision with root package name */
    public C0060d0 f1022j;

    /* renamed from: k, reason: collision with root package name */
    public C0126z1 f1023k;

    /* renamed from: m, reason: collision with root package name */
    public C0078j0 f1025m;
    public final C0113v0 n;

    /* renamed from: p, reason: collision with root package name */
    public boolean f1027p;

    /* renamed from: q, reason: collision with root package name */
    public long f1028q;

    /* renamed from: r, reason: collision with root package name */
    public ArrayList f1029r;

    /* renamed from: t, reason: collision with root package name */
    public int f1031t;

    /* renamed from: u, reason: collision with root package name */
    public int f1032u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f1033v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f1034w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f1035x;

    /* renamed from: y, reason: collision with root package name */
    public FileLock f1036y;

    /* renamed from: z, reason: collision with root package name */
    public FileChannel f1037z;

    /* renamed from: o, reason: collision with root package name */
    public final AtomicBoolean f1026o = new AtomicBoolean(false);

    /* renamed from: s, reason: collision with root package name */
    public final LinkedList f1030s = new LinkedList();

    /* renamed from: G, reason: collision with root package name */
    public final HashMap f1012G = new HashMap();

    /* renamed from: L, reason: collision with root package name */
    public final L0.l f1016L = new L0.l(11, this);

    /* renamed from: C, reason: collision with root package name */
    public long f1008C = -1;

    /* renamed from: l, reason: collision with root package name */
    public final S1 f1024l = new S1(this);

    public V1(B1 b12) {
        this.n = C0113v0.q(b12.f707a, null, null);
        C0060d0 c0060d0 = new C0060d0(this, 2);
        c0060d0.l();
        this.f1021i = c0060d0;
        C0060d0 c0060d02 = new C0060d0(this, 0);
        c0060d02.l();
        this.f1018d = c0060d02;
        C0093o0 c0093o0 = new C0093o0(this);
        c0093o0.l();
        this.f1017c = c0093o0;
        this.f1009D = new HashMap();
        this.f1010E = new HashMap();
        this.f1011F = new HashMap();
        e().t(new C0.A(this, b12));
    }

    public static final boolean I(b2 b2Var) {
        return (TextUtils.isEmpty(b2Var.f1139k) && TextUtils.isEmpty(b2Var.f1152y)) ? false : true;
    }

    public static final void J(Q1 q12) {
        if (q12 == null) {
            throw new IllegalStateException("Upload Component not created");
        }
        if (!q12.f935e) {
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(q12.getClass())));
        }
    }

    public static final Boolean K(b2 b2Var) {
        Boolean bool = b2Var.f1153z;
        String str = b2Var.f1135N;
        if (!TextUtils.isEmpty(str)) {
            int iOrdinal = ((H0) B0.l.z(str).f110d).ordinal();
            if (iOrdinal == 0 || iOrdinal == 1) {
                return null;
            }
            if (iOrdinal == 2) {
                return Boolean.TRUE;
            }
            if (iOrdinal == 3) {
                return Boolean.FALSE;
            }
        }
        return bool;
    }

    public static V1 k0(Context context) {
        q1.E.i(context);
        q1.E.i(context.getApplicationContext());
        if (f1005M == null) {
            synchronized (V1.class) {
                try {
                    if (f1005M == null) {
                        f1005M = new V1(new B1(context, 1));
                    }
                } finally {
                }
            }
        }
        return f1005M;
    }

    public static final void u(com.google.android.gms.internal.measurement.W0 w02, int i5, String str) {
        List listN = w02.n();
        for (int i6 = 0; i6 < listN.size(); i6++) {
            if ("_err".equals(((C0295a1) listN.get(i6)).u())) {
                return;
            }
        }
        com.google.android.gms.internal.measurement.Z0 z0T = C0295a1.t();
        z0T.i("_err");
        z0T.h(i5);
        C0295a1 c0295a1 = (C0295a1) z0T.e();
        com.google.android.gms.internal.measurement.Z0 z0T2 = C0295a1.t();
        z0T2.i("_ev");
        z0T2.j(str);
        C0295a1 c0295a12 = (C0295a1) z0T2.e();
        w02.k(c0295a1);
        w02.k(c0295a12);
    }

    public static final void v(com.google.android.gms.internal.measurement.W0 w02, String str) {
        List listN = w02.n();
        for (int i5 = 0; i5 < listN.size(); i5++) {
            if (str.equals(((C0295a1) listN.get(i5)).u())) {
                w02.g();
                com.google.android.gms.internal.measurement.X0.A((com.google.android.gms.internal.measurement.X0) w02.f4913k, i5);
                return;
            }
        }
    }

    public static String z(String str, Map map) {
        if (map == null) {
            return null;
        }
        for (Map.Entry entry : map.entrySet()) {
            if (str.equalsIgnoreCase((String) entry.getKey())) {
                if (((List) entry.getValue()).isEmpty()) {
                    return null;
                }
                return (String) ((List) entry.getValue()).get(0);
            }
        }
        return null;
    }

    public final void A() {
        e().j();
        if (this.f1033v || this.f1034w || this.f1035x) {
            Z zC = c();
            zC.f1084p.d("Not stopping services. fetch, network, upload", Boolean.valueOf(this.f1033v), Boolean.valueOf(this.f1034w), Boolean.valueOf(this.f1035x));
            return;
        }
        c().f1084p.a("Stopping uploading service(s)");
        ArrayList arrayList = this.f1029r;
        if (arrayList == null) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        ArrayList arrayList2 = this.f1029r;
        q1.E.i(arrayList2);
        arrayList2.clear();
    }

    public final void B(C0315e1 c0315e1, long j5, boolean z4) {
        Z1 z12;
        Object obj;
        String str = true != z4 ? "_lte" : "_se";
        C0089n c0089n = this.f1019e;
        J(c0089n);
        Z1 z1P0 = c0089n.p0(c0315e1.l(), str);
        if (z1P0 == null || (obj = z1P0.f1094e) == null) {
            String strL = c0315e1.l();
            f().getClass();
            z12 = new Z1(strL, "auto", str, System.currentTimeMillis(), Long.valueOf(j5));
        } else {
            String strL2 = c0315e1.l();
            f().getClass();
            z12 = new Z1(strL2, "auto", str, System.currentTimeMillis(), Long.valueOf(((Long) obj).longValue() + j5));
        }
        C0360n1 c0360n1T = C0365o1.t();
        c0360n1T.g();
        C0365o1.B((C0365o1) c0360n1T.f4913k, str);
        f().getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        c0360n1T.g();
        C0365o1.C((C0365o1) c0360n1T.f4913k, jCurrentTimeMillis);
        Object obj2 = z12.f1094e;
        long jLongValue = ((Long) obj2).longValue();
        c0360n1T.g();
        C0365o1.A((C0365o1) c0360n1T.f4913k, jLongValue);
        C0365o1 c0365o1 = (C0365o1) c0360n1T.e();
        int iD = C0060d0.D(c0315e1, str);
        if (iD >= 0) {
            c0315e1.g();
            C0320f1.F1((C0320f1) c0315e1.f4913k, iD, c0365o1);
        } else {
            c0315e1.g();
            C0320f1.t0((C0320f1) c0315e1.f4913k, c0365o1);
        }
        if (j5 > 0) {
            C0089n c0089n2 = this.f1019e;
            J(c0089n2);
            c0089n2.X(z12);
            c().f1084p.c(true != z4 ? "lifetime" : "session-scoped", obj2, "Updated engagement user property. scope, value");
        }
    }

    public final void C() {
        e().j();
        if (this.f1030s.isEmpty()) {
            return;
        }
        if (this.f1014J == null) {
            this.f1014J = new E1(this, this.n, 2);
        }
        if (this.f1014J.f1325c != 0) {
            return;
        }
        f().getClass();
        long jMax = Math.max(0L, ((Integer) H.f748A0.a(null)).intValue() - (SystemClock.elapsedRealtime() - this.f1015K));
        c().f1084p.b(Long.valueOf(jMax), "Scheduling notify next app runnable, delay in ms");
        if (this.f1014J == null) {
            this.f1014J = new E1(this, this.n, 2);
        }
        this.f1014J.c(jMax);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0311  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void D() {
        /*
            Method dump skipped, instructions count: 950
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.V1.D():void");
    }

    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:96)
        */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    public final boolean E(long r62, java.lang.String r64) {
        /*
            Method dump skipped, instructions count: 8546
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.V1.E(long, java.lang.String):boolean");
    }

    public final boolean F() {
        AbstractC0535a.q(this);
        C0089n c0089n = this.f1019e;
        J(c0089n);
        if (c0089n.a0("select count(1) > 0 from raw_events", null) != 0) {
            return true;
        }
        C0089n c0089n2 = this.f1019e;
        J(c0089n2);
        return !TextUtils.isEmpty(c0089n2.n());
    }

    public final boolean G(String str, String str2) {
        C0089n c0089n = this.f1019e;
        J(c0089n);
        C0103s c0103sL = c0089n.L("events", str, str2);
        return c0103sL == null || c0103sL.f1371c < 1;
    }

    public final boolean H(com.google.android.gms.internal.measurement.W0 w02, com.google.android.gms.internal.measurement.W0 w03) {
        q1.E.a("_e".equals(w02.m()));
        b();
        C0295a1 c0295a1S = C0060d0.s((com.google.android.gms.internal.measurement.X0) w02.e(), "_sc");
        String strV = c0295a1S == null ? null : c0295a1S.v();
        b();
        C0295a1 c0295a1S2 = C0060d0.s((com.google.android.gms.internal.measurement.X0) w03.e(), "_pc");
        String strV2 = c0295a1S2 != null ? c0295a1S2.v() : null;
        if (strV2 == null || !strV2.equals(strV)) {
            return false;
        }
        q1.E.a("_e".equals(w02.m()));
        b();
        C0295a1 c0295a1S3 = C0060d0.s((com.google.android.gms.internal.measurement.X0) w02.e(), "_et");
        if (c0295a1S3 == null || !c0295a1S3.J() || c0295a1S3.s() <= 0) {
            return true;
        }
        long jS = c0295a1S3.s();
        b();
        C0295a1 c0295a1S4 = C0060d0.s((com.google.android.gms.internal.measurement.X0) w03.e(), "_et");
        if (c0295a1S4 != null && c0295a1S4.s() > 0) {
            jS += c0295a1S4.s();
        }
        b();
        C0060d0.q(w03, "_et", Long.valueOf(jS));
        b();
        C0060d0.q(w02, "_fr", 1L);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:137:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x017d  */
    /* JADX WARN: Type inference failed for: r13v1, types: [long] */
    /* JADX WARN: Type inference failed for: r13v11, types: [J1.V1] */
    /* JADX WARN: Type inference failed for: r13v18 */
    /* JADX WARN: Type inference failed for: r13v19 */
    /* JADX WARN: Type inference failed for: r13v20 */
    /* JADX WARN: Type inference failed for: r13v21 */
    /* JADX WARN: Type inference failed for: r13v22 */
    /* JADX WARN: Type inference failed for: r13v23 */
    /* JADX WARN: Type inference failed for: r13v6, types: [J1.V1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void L(J1.b2 r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1043
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.V1.L(J1.b2):void");
    }

    public final void M(C0062e c0062e, b2 b2Var) {
        q1.E.f(c0062e.f1191j);
        q1.E.i(c0062e.f1193l);
        q1.E.f(c0062e.f1193l.f1071k);
        e().j();
        k();
        if (I(b2Var)) {
            if (!b2Var.f1144q) {
                c0(b2Var);
                return;
            }
            C0089n c0089n = this.f1019e;
            J(c0089n);
            c0089n.u();
            try {
                c0(b2Var);
                String str = c0062e.f1191j;
                q1.E.i(str);
                C0089n c0089n2 = this.f1019e;
                J(c0089n2);
                C0062e c0062eH0 = c0089n2.h0(str, c0062e.f1193l.f1071k);
                C0113v0 c0113v0 = this.n;
                if (c0062eH0 != null) {
                    c().f1083o.c(c0062e.f1191j, c0113v0.f1420o.f(c0062e.f1193l.f1071k), "Removing conditional user property");
                    C0089n c0089n3 = this.f1019e;
                    J(c0089n3);
                    c0089n3.K(str, c0062e.f1193l.f1071k);
                    if (c0062eH0.n) {
                        C0089n c0089n4 = this.f1019e;
                        J(c0089n4);
                        c0089n4.C(str, c0062e.f1193l.f1071k);
                    }
                    C0112v c0112v = c0062e.f1200t;
                    if (c0112v != null) {
                        C0109u c0109u = c0112v.f1399k;
                        C0112v c0112vP = g().p(c0112v.f1398j, c0109u != null ? c0109u.a() : null, c0062eH0.f1192k, c0112v.f1401m, true);
                        q1.E.i(c0112vP);
                        Y(c0112vP, b2Var);
                    }
                } else {
                    c().f1080k.c(Z.q(c0062e.f1191j), c0113v0.f1420o.f(c0062e.f1193l.f1071k), "Conditional user property doesn't exist");
                }
                C0089n c0089n5 = this.f1019e;
                J(c0089n5);
                c0089n5.E();
                C0089n c0089n6 = this.f1019e;
                J(c0089n6);
                c0089n6.y();
            } catch (Throwable th) {
                C0089n c0089n7 = this.f1019e;
                J(c0089n7);
                c0089n7.y();
                throw th;
            }
        }
    }

    public final void N(String str, b2 b2Var) {
        e().j();
        k();
        if (I(b2Var)) {
            if (!b2Var.f1144q) {
                c0(b2Var);
                return;
            }
            Boolean boolK = K(b2Var);
            if ("_npa".equals(str) && boolK != null) {
                c().f1083o.a("Falling back to manifest metadata value for ad personalization");
                f().getClass();
                T(new Y1(System.currentTimeMillis(), Long.valueOf(true != boolK.booleanValue() ? 0L : 1L), "_npa", "auto"), b2Var);
                return;
            }
            Z zC = c();
            C0113v0 c0113v0 = this.n;
            zC.f1083o.b(c0113v0.f1420o.f(str), "Removing user property");
            C0089n c0089n = this.f1019e;
            J(c0089n);
            c0089n.u();
            try {
                c0(b2Var);
                boolean zEquals = "_id".equals(str);
                String str2 = b2Var.f1138j;
                if (zEquals) {
                    C0089n c0089n2 = this.f1019e;
                    J(c0089n2);
                    q1.E.i(str2);
                    c0089n2.C(str2, "_lair");
                }
                C0089n c0089n3 = this.f1019e;
                J(c0089n3);
                q1.E.i(str2);
                c0089n3.C(str2, str);
                C0089n c0089n4 = this.f1019e;
                J(c0089n4);
                c0089n4.E();
                c().f1083o.b(c0113v0.f1420o.f(str), "User property removed");
                C0089n c0089n5 = this.f1019e;
                J(c0089n5);
                c0089n5.y();
            } catch (Throwable th) {
                C0089n c0089n6 = this.f1019e;
                J(c0089n6);
                c0089n6.y();
                throw th;
            }
        }
    }

    public final void O(b2 b2Var) throws NumberFormatException {
        AbstractC0535a.q(this);
        String str = b2Var.f1138j;
        q1.E.f(str);
        C0095p c0095pB = C0095p.b(b2Var.f1131J);
        c().f1084p.c(str, c0095pB, "Setting DMA consent for package");
        e().j();
        k();
        H0 h0C = C0095p.a(100, a0(str)).c();
        this.f1010E.put(str, c0095pB);
        C0089n c0089n = this.f1019e;
        J(c0089n);
        q1.E.i(str);
        q1.E.i(c0095pB);
        c0089n.j();
        c0089n.k();
        K0 k0N0 = c0089n.n0(str);
        K0 k02 = K0.f878c;
        if (k0N0 == k02) {
            c0089n.H(str, k02);
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("dma_consent_settings", c0095pB.f1338b);
        c0089n.R(contentValues);
        H0 h0C2 = C0095p.a(100, a0(str)).c();
        AbstractC0535a.q(this);
        H0 h02 = H0.DENIED;
        H0 h03 = H0.GRANTED;
        boolean z4 = h0C == h02 && h0C2 == h03;
        boolean z5 = h0C == h03 && h0C2 == h02;
        if (z4 || z5) {
            c().f1084p.b(str, "Generated _dcu event for");
            Bundle bundle = new Bundle();
            C0089n c0089n2 = this.f1019e;
            J(c0089n2);
            if (c0089n2.j0(t(), str, false, false, false, false).f1268f < d0().p(str, H.f826l0)) {
                bundle.putLong("_r", 1L);
                C0089n c0089n3 = this.f1019e;
                J(c0089n3);
                c().f1084p.c(str, Long.valueOf(c0089n3.j0(t(), str, false, false, true, false).f1268f), "_dcu realtime event count");
            }
            this.f1016L.u(str, "_dcu", bundle);
        }
    }

    public final void P(b2 b2Var) {
        AbstractC0535a.q(this);
        String str = b2Var.f1138j;
        q1.E.f(str);
        K0 k0E = K0.e(b2Var.I, b2Var.f1126D);
        j0(str);
        c().f1084p.c(str, k0E, "Setting storage consent for package");
        e().j();
        k();
        this.f1009D.put(str, k0E);
        C0089n c0089n = this.f1019e;
        J(c0089n);
        c0089n.H(str, k0E);
    }

    public final void Q(ArrayList arrayList) {
        q1.E.a(!arrayList.isEmpty());
        if (this.f1006A != null) {
            c().h.a("Set uploading progress before finishing the previous upload");
        } else {
            this.f1006A = new ArrayList(arrayList);
        }
    }

    public final void R(C0062e c0062e, b2 b2Var) {
        C0112v c0112v;
        q1.E.f(c0062e.f1191j);
        q1.E.i(c0062e.f1192k);
        q1.E.i(c0062e.f1193l);
        q1.E.f(c0062e.f1193l.f1071k);
        e().j();
        k();
        if (I(b2Var)) {
            if (!b2Var.f1144q) {
                c0(b2Var);
                return;
            }
            C0062e c0062e2 = new C0062e(c0062e);
            boolean z4 = false;
            c0062e2.n = false;
            C0089n c0089n = this.f1019e;
            J(c0089n);
            c0089n.u();
            try {
                C0089n c0089n2 = this.f1019e;
                J(c0089n2);
                String str = c0062e2.f1191j;
                q1.E.i(str);
                C0062e c0062eH0 = c0089n2.h0(str, c0062e2.f1193l.f1071k);
                C0113v0 c0113v0 = this.n;
                if (c0062eH0 != null && !c0062eH0.f1192k.equals(c0062e2.f1192k)) {
                    c().f1080k.d("Updating a conditional user property with different origin. name, origin, origin (from DB)", c0113v0.f1420o.f(c0062e2.f1193l.f1071k), c0062e2.f1192k, c0062eH0.f1192k);
                }
                if (c0062eH0 != null && c0062eH0.n) {
                    c0062e2.f1192k = c0062eH0.f1192k;
                    c0062e2.f1194m = c0062eH0.f1194m;
                    c0062e2.f1197q = c0062eH0.f1197q;
                    c0062e2.f1195o = c0062eH0.f1195o;
                    c0062e2.f1198r = c0062eH0.f1198r;
                    c0062e2.n = true;
                    Y1 y12 = c0062e2.f1193l;
                    c0062e2.f1193l = new Y1(c0062eH0.f1193l.f1072l, y12.a(), y12.f1071k, c0062eH0.f1193l.f1074o);
                } else if (TextUtils.isEmpty(c0062e2.f1195o)) {
                    Y1 y13 = c0062e2.f1193l;
                    c0062e2.f1193l = new Y1(c0062e2.f1194m, y13.a(), y13.f1071k, c0062e2.f1193l.f1074o);
                    c0062e2.n = true;
                    z4 = true;
                }
                if (c0062e2.n) {
                    Y1 y14 = c0062e2.f1193l;
                    String str2 = c0062e2.f1191j;
                    q1.E.i(str2);
                    String str3 = c0062e2.f1192k;
                    String str4 = y14.f1071k;
                    long j5 = y14.f1072l;
                    Object objA = y14.a();
                    q1.E.i(objA);
                    Z1 z12 = new Z1(str2, str3, str4, j5, objA);
                    Object obj = z12.f1094e;
                    String str5 = z12.f1092c;
                    C0089n c0089n3 = this.f1019e;
                    J(c0089n3);
                    if (c0089n3.X(z12)) {
                        c().f1083o.d("User property updated immediately", c0062e2.f1191j, c0113v0.f1420o.f(str5), obj);
                    } else {
                        c().h.d("(2)Too many active user properties, ignoring", Z.q(c0062e2.f1191j), c0113v0.f1420o.f(str5), obj);
                    }
                    if (z4 && (c0112v = c0062e2.f1198r) != null) {
                        Y(new C0112v(c0112v, c0062e2.f1194m), b2Var);
                    }
                }
                C0089n c0089n4 = this.f1019e;
                J(c0089n4);
                if (c0089n4.W(c0062e2)) {
                    c().f1083o.d("Conditional property added", c0062e2.f1191j, c0113v0.f1420o.f(c0062e2.f1193l.f1071k), c0062e2.f1193l.a());
                } else {
                    c().h.d("Too many conditional properties, ignoring", Z.q(c0062e2.f1191j), c0113v0.f1420o.f(c0062e2.f1193l.f1071k), c0062e2.f1193l.a());
                }
                C0089n c0089n5 = this.f1019e;
                J(c0089n5);
                c0089n5.E();
                C0089n c0089n6 = this.f1019e;
                J(c0089n6);
                c0089n6.y();
            } catch (Throwable th) {
                C0089n c0089n7 = this.f1019e;
                J(c0089n7);
                c0089n7.y();
                throw th;
            }
        }
    }

    public final void S(String str, boolean z4, Long l5, Long l6) {
        C0089n c0089n = this.f1019e;
        J(c0089n);
        V vG0 = c0089n.g0(str);
        if (vG0 != null) {
            C0113v0 c0113v0 = vG0.f980a;
            C0104s0 c0104s0 = c0113v0.f1418l;
            C0113v0.k(c0104s0);
            c0104s0.j();
            vG0.f977R |= vG0.f1002z != z4;
            vG0.f1002z = z4;
            C0104s0 c0104s02 = c0113v0.f1418l;
            C0113v0.k(c0104s02);
            c0104s02.j();
            vG0.f977R |= !Objects.equals(vG0.f961A, l5);
            vG0.f961A = l5;
            C0104s0 c0104s03 = c0113v0.f1418l;
            C0113v0.k(c0104s03);
            c0104s03.j();
            vG0.f977R |= !Objects.equals(vG0.f962B, l6);
            vG0.f962B = l6;
            if (vG0.s()) {
                C0089n c0089n2 = this.f1019e;
                J(c0089n2);
                c0089n2.F(vG0, false);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void T(J1.Y1 r25, J1.b2 r26) {
        /*
            Method dump skipped, instructions count: 511
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.V1.T(J1.Y1, J1.b2):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01a4 A[Catch: all -> 0x0021, TryCatch #1 {all -> 0x0021, blocks: (B:3:0x0007, B:5:0x0014, B:8:0x0024, B:10:0x002a, B:11:0x0037, B:13:0x003f, B:14:0x0044, B:16:0x004f, B:17:0x005c, B:19:0x0067, B:20:0x0077, B:22:0x00a1, B:24:0x00a7, B:25:0x00aa, B:27:0x00c3, B:28:0x00d8, B:30:0x00e9, B:32:0x00ef, B:35:0x0104, B:45:0x0123, B:47:0x0128, B:48:0x012b, B:49:0x012c, B:50:0x0131, B:55:0x0176, B:71:0x019e, B:73:0x01a4, B:75:0x01af, B:79:0x01ba, B:80:0x01bd, B:33:0x00f4, B:37:0x0108, B:42:0x0110), top: B:83:0x0007, inners: #6 }] */
    /* JADX WARN: Type inference failed for: r11v0, types: [J1.V1] */
    /* JADX WARN: Type inference failed for: r1v12, types: [long] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v22, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v25, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void U() {
        /*
            Method dump skipped, instructions count: 452
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.V1.U():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0483  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x04e0  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x056c  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x056f  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x069f  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x092d  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x095d  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x0974  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x0991 A[LOOP:5: B:337:0x098b->B:339:0x0991, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:342:0x09d0  */
    /* JADX WARN: Removed duplicated region for block: B:347:0x09ed  */
    /* JADX WARN: Removed duplicated region for block: B:355:0x0a46 A[LOOP:6: B:353:0x0a40->B:355:0x0a46, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:358:0x0a98  */
    /* JADX WARN: Removed duplicated region for block: B:363:0x0add  */
    /* JADX WARN: Removed duplicated region for block: B:370:0x0b00  */
    /* JADX WARN: Removed duplicated region for block: B:381:0x0b98  */
    /* JADX WARN: Removed duplicated region for block: B:392:0x0bfc  */
    /* JADX WARN: Removed duplicated region for block: B:397:0x0c03  */
    /* JADX WARN: Removed duplicated region for block: B:429:0x0942 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x020f  */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v50 */
    /* JADX WARN: Type inference failed for: r10v6, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r33v0, types: [J1.V1, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void V(long r34, java.lang.String r36) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 3079
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.V1.V(long, java.lang.String):void");
    }

    public final void W(String str) {
        C0310d1 c0310d1;
        AbstractC0535a.q(this);
        this.f1035x = true;
        try {
            C0113v0 c0113v0 = this.n;
            c0113v0.getClass();
            Boolean bool = c0113v0.r().g;
            if (bool == null) {
                c().f1080k.a("Upload data called on the client side before use of service was decided");
            } else if (bool.booleanValue()) {
                c().h.a("Upload called in the client side when service should be used");
            } else if (this.f1028q > 0) {
                D();
            } else {
                C0060d0 c0060d0 = this.f1018d;
                J(c0060d0);
                if (c0060d0.I()) {
                    C0089n c0089n = this.f1019e;
                    J(c0089n);
                    if (c0089n.I(str)) {
                        C0089n c0089n2 = this.f1019e;
                        J(c0089n2);
                        W1 w1O0 = c0089n2.o0(str);
                        if (w1O0 != null && (c0310d1 = w1O0.f1048b) != null) {
                            c().f1084p.d("[sgtm] Uploading data from upload queue. appId, type, url", str, w1O0.f1051e, w1O0.f1049c);
                            byte[] bArrC = c0310d1.c();
                            if (Log.isLoggable(c().t(), 2)) {
                                C0060d0 c0060d02 = this.f1021i;
                                J(c0060d02);
                                c().f1084p.d("[sgtm] Uploading data from upload queue. appId, uncompressed size, data", str, Integer.valueOf(bArrC.length), c0060d02.Q(c0310d1));
                            }
                            this.f1034w = true;
                            C0060d0 c0060d03 = this.f1018d;
                            J(c0060d03);
                            c0060d03.H(str, new R1(w1O0.f1049c, w1O0.f1050d, w1O0.f1051e, null), c0310d1, new C0513e((Object) this, (Object) w1O0, str));
                        }
                    } else {
                        c().f1084p.b(str, "[sgtm] Upload queue has no batches for appId");
                    }
                } else {
                    c().f1084p.a("Network not connected, ignoring upload request");
                    D();
                }
            }
            this.f1035x = false;
            A();
        } catch (Throwable th) {
            this.f1035x = false;
            A();
            throw th;
        }
    }

    public final void X(String str, com.google.android.gms.internal.measurement.Z0 z0, Bundle bundle, String str2) {
        int iMax;
        List listUnmodifiableList = Collections.unmodifiableList(Arrays.asList("_o", "_sn", "_sc", "_si"));
        if (a2.e0(((C0295a1) z0.f4913k).u()) || a2.e0(str)) {
            C0068g c0068gD0 = d0();
            c0068gD0.getClass();
            iMax = Math.max(Math.max(Math.min(c0068gD0.p(str2, H.f813g0), 500), 100), PSKKeyManager.MAX_KEY_LENGTH_BYTES);
        } else {
            C0068g c0068gD02 = d0();
            c0068gD02.getClass();
            iMax = Math.max(Math.min(c0068gD02.p(str2, H.f813g0), 500), 100);
        }
        long j5 = iMax;
        long jCodePointCount = ((C0295a1) z0.f4913k).v().codePointCount(0, ((C0295a1) z0.f4913k).v().length());
        g();
        String strU = ((C0295a1) z0.f4913k).u();
        d0();
        String strT = a2.t(40, strU, true);
        if (jCodePointCount <= j5 || listUnmodifiableList.contains(((C0295a1) z0.f4913k).u())) {
            return;
        }
        if ("_ev".equals(((C0295a1) z0.f4913k).u())) {
            g();
            String strV = ((C0295a1) z0.f4913k).v();
            C0068g c0068gD03 = d0();
            c0068gD03.getClass();
            bundle.putString("_ev", a2.t(Math.max(Math.max(Math.min(c0068gD03.p(str2, H.f813g0), 500), 100), PSKKeyManager.MAX_KEY_LENGTH_BYTES), strV, true));
            return;
        }
        c().f1082m.c(strT, Long.valueOf(jCodePointCount), "Param value is too long; discarded. Name, value length");
        if (bundle.getLong("_err") == 0) {
            bundle.putLong("_err", 4L);
            if (bundle.getString("_ev") == null) {
                bundle.putString("_ev", strT);
                bundle.putLong("_el", jCodePointCount);
            }
        }
        bundle.remove(((C0295a1) z0.f4913k).u());
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:(1:337)(32:339|(2:340|(3:342|(3:490|344|(2:346|(2:348|536)(1:539))(1:538))(1:537)|352)(2:535|354))|355|(1:357)|(1:359)|360|(1:362)|363|(1:393)(4:367|(1:369)(1:370)|371|(4:373|(1:375)|376|(0)(3:382|383|(5:385|(1:387)(1:388)|389|(1:391)|392)(0)))(0))|394|(2:396|(1:398)(2:399|400))|401|(3:403|(1:405)|406)(1:407)|408|(1:412)|413|(1:415)|416|(6:419|(1:421)(2:422|(1:424)(2:425|(1:427)(1:428)))|429|(2:431|(4:433|(1:435)(1:436)|437|(2:439|543)(1:542))(2:441|541))(0)|442|417)|496|443|528|444|445|(2:446|(2:448|(1:544)(1:546))(3:545|451|(1:455)))|456|502|457|(1:459)(2:463|464)|474|475|476)|528|444|445|(3:446|(0)(0)|546)|456|502|457|(0)(0)|474|475|476) */
    /* JADX WARN: Can't wrap try/catch for region: R(12:82|(2:84|(1:86)(3:88|102|(1:104)))(1:89)|87|90|530|91|92|518|93|101|102|(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(27:28|(4:31|(2:33|533)(1:534)|34|29)|532|35|(1:37)|38|(6:520|39|40|(1:46)(1:47)|51|52)|(11:(1:55)|56|107|(1:109)(4:110|111|(8:512|114|509|115|116|(2:118|548)(1:549)|119|112)|547)|124|125|126|(3:128|(1:130)|131)(38:(2:133|(3:135|(1:137)|138))|140|(2:142|(3:144|(1:146)|147))(1:148)|149|150|(1:152)(1:153)|154|(2:158|(1:160))|161|(2:504|171)|172|173|174|484|175|176|526|177|178|179|185|(1:187)|188|189|498|190|(6:497|192|524|193|194|(3:207|208|209)(6:197|500|198|199|200|201))(7:212|213|214|215|216|217|218)|219|220|221|222|223|224|225|226|(10:486|228|232|(2:514|234)(1:238)|239|(2:522|241)(1:245)|246|(2:492|248)(1:252)|253|(50:255|516|256|260|261|262|263|(2:488|265)(1:269)|270|271|506|272|(1:276)|279|280|(2:282|(6:284|(1:288)|289|(1:291)(1:292)|293|(1:295)(15:296|(1:298)(1:299)|300|(1:302)(1:303)|304|(1:306)(1:307)|308|(1:310)(1:311)|312|(1:314)(1:315)|316|(1:318)(1:319)|320|(1:322)(1:323)|324))(1:326))(0)|327|(1:329)|330|(1:332)(1:333)|(1:337)(32:339|(2:340|(3:342|(3:490|344|(2:346|(2:348|536)(1:539))(1:538))(1:537)|352)(2:535|354))|355|(1:357)|(1:359)|360|(1:362)|363|(1:393)(4:367|(1:369)(1:370)|371|(4:373|(1:375)|376|(0)(3:382|383|(5:385|(1:387)(1:388)|389|(1:391)|392)(0)))(0))|394|(2:396|(1:398)(2:399|400))|401|(3:403|(1:405)|406)(1:407)|408|(1:412)|413|(1:415)|416|(6:419|(1:421)(2:422|(1:424)(2:425|(1:427)(1:428)))|429|(2:431|(4:433|(1:435)(1:436)|437|(2:439|543)(1:542))(2:441|541))(0)|442|417)|496|443|528|444|445|(2:446|(2:448|(1:544)(1:546))(3:545|451|(1:455)))|456|502|457|(1:459)(2:463|464)|474|475|476)|338|(0)|360|(0)|363|(2:365|393)(0)|394|(0)|401|(0)(0)|408|(2:410|412)|413|(0)|416|(1:417)|496|443|528|444|445|(3:446|(0)(0)|546)|456|502|457|(0)(0)|474|475|476)(46:260|261|262|263|(0)(0)|270|271|506|272|(2:274|276)|279|280|(0)(0)|327|(0)|330|(0)(0)|(3:335|337|338)(0)|(0)|360|(0)|363|(0)(0)|394|(0)|401|(0)(0)|408|(0)|413|(0)|416|(1:417)|496|443|528|444|445|(3:446|(0)(0)|546)|456|502|457|(0)(0)|474|475|476))(8:232|(0)(0)|239|(0)(0)|246|(0)(0)|253|(0)(0))|481|482)|76|200|201)|57|511|58|494|59|60|(4:62|(1:64)|66|(4:75|76|200|201)(2:70|(1:72)))(1:77)|78|(11:80|(12:82|(2:84|(1:86)(3:88|102|(1:104)))(1:89)|87|90|530|91|92|518|93|101|102|(0))|107|(0)(0)|124|125|126|(0)(0)|76|200|201)|56|107|(0)(0)|124|125|126|(0)(0)|76|200|201) */
    /* JADX WARN: Can't wrap try/catch for region: R(29:506|272|(1:276)|279|280|(2:282|(6:284|(1:288)|289|(1:291)(1:292)|293|(1:295)(15:296|(1:298)(1:299)|300|(1:302)(1:303)|304|(1:306)(1:307)|308|(1:310)(1:311)|312|(1:314)(1:315)|316|(1:318)(1:319)|320|(1:322)(1:323)|324))(1:326))(0)|327|(1:329)|330|(1:332)(1:333)|(12:(1:337)(32:339|(2:340|(3:342|(3:490|344|(2:346|(2:348|536)(1:539))(1:538))(1:537)|352)(2:535|354))|355|(1:357)|(1:359)|360|(1:362)|363|(1:393)(4:367|(1:369)(1:370)|371|(4:373|(1:375)|376|(0)(3:382|383|(5:385|(1:387)(1:388)|389|(1:391)|392)(0)))(0))|394|(2:396|(1:398)(2:399|400))|401|(3:403|(1:405)|406)(1:407)|408|(1:412)|413|(1:415)|416|(6:419|(1:421)(2:422|(1:424)(2:425|(1:427)(1:428)))|429|(2:431|(4:433|(1:435)(1:436)|437|(2:439|543)(1:542))(2:441|541))(0)|442|417)|496|443|528|444|445|(2:446|(2:448|(1:544)(1:546))(3:545|451|(1:455)))|456|502|457|(1:459)(2:463|464)|474|475|476)|528|444|445|(3:446|(0)(0)|546)|456|502|457|(0)(0)|474|475|476)|338|(0)|360|(0)|363|(2:365|393)(0)|394|(0)|401|(0)(0)|408|(2:410|412)|413|(0)|416|(1:417)|496|443) */
    /* JADX WARN: Can't wrap try/catch for region: R(36:(2:133|(3:135|(1:137)|138))|140|(2:142|(3:144|(1:146)|147))(1:148)|149|150|(1:152)(1:153)|154|(2:158|(1:160))|161|(2:504|171)|172|173|174|484|175|176|(3:526|177|178)|179|185|(1:187)|188|189|498|190|(6:497|192|524|193|194|(3:207|208|209)(6:197|500|198|199|200|201))(7:212|213|214|215|216|217|218)|219|220|221|222|223|224|225|226|(10:486|228|232|(2:514|234)(1:238)|239|(2:522|241)(1:245)|246|(2:492|248)(1:252)|253|(50:255|516|256|260|261|262|263|(2:488|265)(1:269)|270|271|506|272|(1:276)|279|280|(2:282|(6:284|(1:288)|289|(1:291)(1:292)|293|(1:295)(15:296|(1:298)(1:299)|300|(1:302)(1:303)|304|(1:306)(1:307)|308|(1:310)(1:311)|312|(1:314)(1:315)|316|(1:318)(1:319)|320|(1:322)(1:323)|324))(1:326))(0)|327|(1:329)|330|(1:332)(1:333)|(1:337)(32:339|(2:340|(3:342|(3:490|344|(2:346|(2:348|536)(1:539))(1:538))(1:537)|352)(2:535|354))|355|(1:357)|(1:359)|360|(1:362)|363|(1:393)(4:367|(1:369)(1:370)|371|(4:373|(1:375)|376|(0)(3:382|383|(5:385|(1:387)(1:388)|389|(1:391)|392)(0)))(0))|394|(2:396|(1:398)(2:399|400))|401|(3:403|(1:405)|406)(1:407)|408|(1:412)|413|(1:415)|416|(6:419|(1:421)(2:422|(1:424)(2:425|(1:427)(1:428)))|429|(2:431|(4:433|(1:435)(1:436)|437|(2:439|543)(1:542))(2:441|541))(0)|442|417)|496|443|528|444|445|(2:446|(2:448|(1:544)(1:546))(3:545|451|(1:455)))|456|502|457|(1:459)(2:463|464)|474|475|476)|338|(0)|360|(0)|363|(2:365|393)(0)|394|(0)|401|(0)(0)|408|(2:410|412)|413|(0)|416|(1:417)|496|443|528|444|445|(3:446|(0)(0)|546)|456|502|457|(0)(0)|474|475|476)(46:260|261|262|263|(0)(0)|270|271|506|272|(2:274|276)|279|280|(0)(0)|327|(0)|330|(0)(0)|(3:335|337|338)(0)|(0)|360|(0)|363|(0)(0)|394|(0)|401|(0)(0)|408|(0)|413|(0)|416|(1:417)|496|443|528|444|445|(3:446|(0)(0)|546)|456|502|457|(0)(0)|474|475|476))(8:232|(0)(0)|239|(0)(0)|246|(0)(0)|253|(0)(0))|481|482) */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x0313, code lost:
    
        ((J1.C0113v0) r14.f84c).c().n().c(J1.Z.q(r13), r0, "Error pruning currencies. appId");
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x037a, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:450:0x0d3e, code lost:
    
        r12 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:461:0x0de9, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:465:0x0df1, code lost:
    
        ((J1.C0113v0) r1.f84c).c().n().c(J1.Z.q(r4.f1357a), r0, "Error storing raw event. appId");
     */
    /* JADX WARN: Code restructure failed: missing block: B:467:0x0e09, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:473:0x0e28, code lost:
    
        c().n().c(J1.Z.q(r1.l()), r0, "Data loss. Failed to insert raw event metadata. appId");
     */
    /* JADX WARN: Code restructure failed: missing block: B:477:0x0e6e, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:479:0x0e71, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x023c, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0308, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x030b, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x030c, code lost:
    
        r28 = "_sno";
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x034c A[Catch: all -> 0x023c, TryCatch #15 {all -> 0x023c, blocks: (B:107:0x0380, B:124:0x03c0, B:128:0x03fc, B:130:0x0403, B:131:0x041a, B:133:0x0425, B:135:0x043f, B:137:0x0448, B:138:0x045f, B:142:0x0481, B:146:0x04a5, B:147:0x04bc, B:149:0x04c6, B:152:0x04e3, B:154:0x04fe, B:156:0x0506, B:158:0x0512, B:160:0x0518, B:161:0x051f, B:163:0x052c, B:165:0x0534, B:167:0x053c, B:169:0x0544, B:171:0x0548, B:172:0x0554, B:174:0x055c, B:175:0x0565, B:177:0x0589, B:187:0x05b0, B:188:0x05c5, B:219:0x06de, B:222:0x06e7, B:224:0x070d, B:226:0x0717, B:232:0x072b, B:239:0x0743, B:246:0x075b, B:260:0x078d, B:263:0x0799, B:270:0x07b1, B:215:0x06b5, B:184:0x0598, B:110:0x0390, B:116:0x03b0, B:118:0x03b4, B:58:0x01fa, B:62:0x0204, B:64:0x0219, B:70:0x0230, B:78:0x0262, B:80:0x0268, B:82:0x0276, B:84:0x0286, B:90:0x02d5, B:91:0x02f4, B:93:0x02fa, B:101:0x0324, B:102:0x0342, B:104:0x034c, B:100:0x0313, B:88:0x0297, B:75:0x023e), top: B:511:0x01fa }] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0390 A[Catch: all -> 0x023c, TRY_LEAVE, TryCatch #15 {all -> 0x023c, blocks: (B:107:0x0380, B:124:0x03c0, B:128:0x03fc, B:130:0x0403, B:131:0x041a, B:133:0x0425, B:135:0x043f, B:137:0x0448, B:138:0x045f, B:142:0x0481, B:146:0x04a5, B:147:0x04bc, B:149:0x04c6, B:152:0x04e3, B:154:0x04fe, B:156:0x0506, B:158:0x0512, B:160:0x0518, B:161:0x051f, B:163:0x052c, B:165:0x0534, B:167:0x053c, B:169:0x0544, B:171:0x0548, B:172:0x0554, B:174:0x055c, B:175:0x0565, B:177:0x0589, B:187:0x05b0, B:188:0x05c5, B:219:0x06de, B:222:0x06e7, B:224:0x070d, B:226:0x0717, B:232:0x072b, B:239:0x0743, B:246:0x075b, B:260:0x078d, B:263:0x0799, B:270:0x07b1, B:215:0x06b5, B:184:0x0598, B:110:0x0390, B:116:0x03b0, B:118:0x03b4, B:58:0x01fa, B:62:0x0204, B:64:0x0219, B:70:0x0230, B:78:0x0262, B:80:0x0268, B:82:0x0276, B:84:0x0286, B:90:0x02d5, B:91:0x02f4, B:93:0x02fa, B:101:0x0324, B:102:0x0342, B:104:0x034c, B:100:0x0313, B:88:0x0297, B:75:0x023e), top: B:511:0x01fa }] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x03fc A[Catch: all -> 0x023c, TRY_ENTER, TryCatch #15 {all -> 0x023c, blocks: (B:107:0x0380, B:124:0x03c0, B:128:0x03fc, B:130:0x0403, B:131:0x041a, B:133:0x0425, B:135:0x043f, B:137:0x0448, B:138:0x045f, B:142:0x0481, B:146:0x04a5, B:147:0x04bc, B:149:0x04c6, B:152:0x04e3, B:154:0x04fe, B:156:0x0506, B:158:0x0512, B:160:0x0518, B:161:0x051f, B:163:0x052c, B:165:0x0534, B:167:0x053c, B:169:0x0544, B:171:0x0548, B:172:0x0554, B:174:0x055c, B:175:0x0565, B:177:0x0589, B:187:0x05b0, B:188:0x05c5, B:219:0x06de, B:222:0x06e7, B:224:0x070d, B:226:0x0717, B:232:0x072b, B:239:0x0743, B:246:0x075b, B:260:0x078d, B:263:0x0799, B:270:0x07b1, B:215:0x06b5, B:184:0x0598, B:110:0x0390, B:116:0x03b0, B:118:0x03b4, B:58:0x01fa, B:62:0x0204, B:64:0x0219, B:70:0x0230, B:78:0x0262, B:80:0x0268, B:82:0x0276, B:84:0x0286, B:90:0x02d5, B:91:0x02f4, B:93:0x02fa, B:101:0x0324, B:102:0x0342, B:104:0x034c, B:100:0x0313, B:88:0x0297, B:75:0x023e), top: B:511:0x01fa }] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0423  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x05b0 A[Catch: all -> 0x023c, TryCatch #15 {all -> 0x023c, blocks: (B:107:0x0380, B:124:0x03c0, B:128:0x03fc, B:130:0x0403, B:131:0x041a, B:133:0x0425, B:135:0x043f, B:137:0x0448, B:138:0x045f, B:142:0x0481, B:146:0x04a5, B:147:0x04bc, B:149:0x04c6, B:152:0x04e3, B:154:0x04fe, B:156:0x0506, B:158:0x0512, B:160:0x0518, B:161:0x051f, B:163:0x052c, B:165:0x0534, B:167:0x053c, B:169:0x0544, B:171:0x0548, B:172:0x0554, B:174:0x055c, B:175:0x0565, B:177:0x0589, B:187:0x05b0, B:188:0x05c5, B:219:0x06de, B:222:0x06e7, B:224:0x070d, B:226:0x0717, B:232:0x072b, B:239:0x0743, B:246:0x075b, B:260:0x078d, B:263:0x0799, B:270:0x07b1, B:215:0x06b5, B:184:0x0598, B:110:0x0390, B:116:0x03b0, B:118:0x03b4, B:58:0x01fa, B:62:0x0204, B:64:0x0219, B:70:0x0230, B:78:0x0262, B:80:0x0268, B:82:0x0276, B:84:0x0286, B:90:0x02d5, B:91:0x02f4, B:93:0x02fa, B:101:0x0324, B:102:0x0342, B:104:0x034c, B:100:0x0313, B:88:0x0297, B:75:0x023e), top: B:511:0x01fa }] */
    /* JADX WARN: Removed duplicated region for block: B:212:0x069c  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x072b A[Catch: all -> 0x023c, TRY_ENTER, TRY_LEAVE, TryCatch #15 {all -> 0x023c, blocks: (B:107:0x0380, B:124:0x03c0, B:128:0x03fc, B:130:0x0403, B:131:0x041a, B:133:0x0425, B:135:0x043f, B:137:0x0448, B:138:0x045f, B:142:0x0481, B:146:0x04a5, B:147:0x04bc, B:149:0x04c6, B:152:0x04e3, B:154:0x04fe, B:156:0x0506, B:158:0x0512, B:160:0x0518, B:161:0x051f, B:163:0x052c, B:165:0x0534, B:167:0x053c, B:169:0x0544, B:171:0x0548, B:172:0x0554, B:174:0x055c, B:175:0x0565, B:177:0x0589, B:187:0x05b0, B:188:0x05c5, B:219:0x06de, B:222:0x06e7, B:224:0x070d, B:226:0x0717, B:232:0x072b, B:239:0x0743, B:246:0x075b, B:260:0x078d, B:263:0x0799, B:270:0x07b1, B:215:0x06b5, B:184:0x0598, B:110:0x0390, B:116:0x03b0, B:118:0x03b4, B:58:0x01fa, B:62:0x0204, B:64:0x0219, B:70:0x0230, B:78:0x0262, B:80:0x0268, B:82:0x0276, B:84:0x0286, B:90:0x02d5, B:91:0x02f4, B:93:0x02fa, B:101:0x0324, B:102:0x0342, B:104:0x034c, B:100:0x0313, B:88:0x0297, B:75:0x023e), top: B:511:0x01fa }] */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0741  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0759  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0771  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x077e  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x078d A[Catch: all -> 0x023c, TRY_ENTER, TRY_LEAVE, TryCatch #15 {all -> 0x023c, blocks: (B:107:0x0380, B:124:0x03c0, B:128:0x03fc, B:130:0x0403, B:131:0x041a, B:133:0x0425, B:135:0x043f, B:137:0x0448, B:138:0x045f, B:142:0x0481, B:146:0x04a5, B:147:0x04bc, B:149:0x04c6, B:152:0x04e3, B:154:0x04fe, B:156:0x0506, B:158:0x0512, B:160:0x0518, B:161:0x051f, B:163:0x052c, B:165:0x0534, B:167:0x053c, B:169:0x0544, B:171:0x0548, B:172:0x0554, B:174:0x055c, B:175:0x0565, B:177:0x0589, B:187:0x05b0, B:188:0x05c5, B:219:0x06de, B:222:0x06e7, B:224:0x070d, B:226:0x0717, B:232:0x072b, B:239:0x0743, B:246:0x075b, B:260:0x078d, B:263:0x0799, B:270:0x07b1, B:215:0x06b5, B:184:0x0598, B:110:0x0390, B:116:0x03b0, B:118:0x03b4, B:58:0x01fa, B:62:0x0204, B:64:0x0219, B:70:0x0230, B:78:0x0262, B:80:0x0268, B:82:0x0276, B:84:0x0286, B:90:0x02d5, B:91:0x02f4, B:93:0x02fa, B:101:0x0324, B:102:0x0342, B:104:0x034c, B:100:0x0313, B:88:0x0297, B:75:0x023e), top: B:511:0x01fa }] */
    /* JADX WARN: Removed duplicated region for block: B:269:0x07af  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x080d A[Catch: all -> 0x07f9, TRY_ENTER, TryCatch #12 {all -> 0x07f9, blocks: (B:272:0x07b6, B:274:0x07e6, B:276:0x07ec, B:279:0x07fc, B:282:0x080d, B:284:0x0816, B:288:0x082d, B:293:0x083c, B:329:0x08bd, B:330:0x08c7, B:332:0x08f7, B:335:0x0902, B:339:0x090d, B:340:0x0927, B:342:0x092d, B:344:0x0947, B:346:0x0953, B:348:0x0960, B:355:0x0996, B:359:0x09a0, B:360:0x09a3, B:362:0x09b0, B:363:0x09b3, B:365:0x09c7, B:367:0x09cb, B:369:0x09d6, B:371:0x09e4, B:373:0x09ee, B:375:0x0a00, B:376:0x0a10, B:378:0x0a1a, B:380:0x0a26, B:383:0x0a32, B:385:0x0a3e, B:387:0x0a54, B:389:0x0a6e, B:391:0x0a7a, B:392:0x0a83, B:394:0x0a99, B:396:0x0af8, B:399:0x0b03, B:400:0x0b0d, B:401:0x0b0e, B:403:0x0b18, B:405:0x0b38, B:406:0x0b43, B:408:0x0b7b, B:410:0x0b83, B:412:0x0b8d, B:413:0x0b9e, B:415:0x0ba8, B:416:0x0bb9, B:417:0x0bc2, B:419:0x0bc8, B:421:0x0c21, B:429:0x0c68, B:431:0x0c7b, B:433:0x0c8d, B:437:0x0cac, B:439:0x0cbc, B:436:0x0c9c, B:422:0x0c2e, B:424:0x0c32, B:425:0x0c43, B:427:0x0c47, B:428:0x0c58, B:443:0x0ccf, B:444:0x0d10, B:445:0x0d1b, B:446:0x0d2c, B:448:0x0d32, B:456:0x0d76, B:457:0x0dc2, B:459:0x0dd3, B:474:0x0e3d, B:464:0x0dee, B:465:0x0df1, B:451:0x0d40, B:453:0x0d64, B:471:0x0e0e, B:472:0x0e27, B:473:0x0e28, B:370:0x09db, B:353:0x0982, B:333:0x08fc, B:296:0x0847, B:300:0x0854, B:304:0x0862, B:308:0x0870, B:312:0x087e, B:316:0x088c, B:320:0x0898, B:324:0x08a6), top: B:506:0x07b6, inners: #3, #6, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:326:0x08b3  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x08bd A[Catch: all -> 0x07f9, TRY_ENTER, TryCatch #12 {all -> 0x07f9, blocks: (B:272:0x07b6, B:274:0x07e6, B:276:0x07ec, B:279:0x07fc, B:282:0x080d, B:284:0x0816, B:288:0x082d, B:293:0x083c, B:329:0x08bd, B:330:0x08c7, B:332:0x08f7, B:335:0x0902, B:339:0x090d, B:340:0x0927, B:342:0x092d, B:344:0x0947, B:346:0x0953, B:348:0x0960, B:355:0x0996, B:359:0x09a0, B:360:0x09a3, B:362:0x09b0, B:363:0x09b3, B:365:0x09c7, B:367:0x09cb, B:369:0x09d6, B:371:0x09e4, B:373:0x09ee, B:375:0x0a00, B:376:0x0a10, B:378:0x0a1a, B:380:0x0a26, B:383:0x0a32, B:385:0x0a3e, B:387:0x0a54, B:389:0x0a6e, B:391:0x0a7a, B:392:0x0a83, B:394:0x0a99, B:396:0x0af8, B:399:0x0b03, B:400:0x0b0d, B:401:0x0b0e, B:403:0x0b18, B:405:0x0b38, B:406:0x0b43, B:408:0x0b7b, B:410:0x0b83, B:412:0x0b8d, B:413:0x0b9e, B:415:0x0ba8, B:416:0x0bb9, B:417:0x0bc2, B:419:0x0bc8, B:421:0x0c21, B:429:0x0c68, B:431:0x0c7b, B:433:0x0c8d, B:437:0x0cac, B:439:0x0cbc, B:436:0x0c9c, B:422:0x0c2e, B:424:0x0c32, B:425:0x0c43, B:427:0x0c47, B:428:0x0c58, B:443:0x0ccf, B:444:0x0d10, B:445:0x0d1b, B:446:0x0d2c, B:448:0x0d32, B:456:0x0d76, B:457:0x0dc2, B:459:0x0dd3, B:474:0x0e3d, B:464:0x0dee, B:465:0x0df1, B:451:0x0d40, B:453:0x0d64, B:471:0x0e0e, B:472:0x0e27, B:473:0x0e28, B:370:0x09db, B:353:0x0982, B:333:0x08fc, B:296:0x0847, B:300:0x0854, B:304:0x0862, B:308:0x0870, B:312:0x087e, B:316:0x088c, B:320:0x0898, B:324:0x08a6), top: B:506:0x07b6, inners: #3, #6, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:332:0x08f7 A[Catch: all -> 0x07f9, TryCatch #12 {all -> 0x07f9, blocks: (B:272:0x07b6, B:274:0x07e6, B:276:0x07ec, B:279:0x07fc, B:282:0x080d, B:284:0x0816, B:288:0x082d, B:293:0x083c, B:329:0x08bd, B:330:0x08c7, B:332:0x08f7, B:335:0x0902, B:339:0x090d, B:340:0x0927, B:342:0x092d, B:344:0x0947, B:346:0x0953, B:348:0x0960, B:355:0x0996, B:359:0x09a0, B:360:0x09a3, B:362:0x09b0, B:363:0x09b3, B:365:0x09c7, B:367:0x09cb, B:369:0x09d6, B:371:0x09e4, B:373:0x09ee, B:375:0x0a00, B:376:0x0a10, B:378:0x0a1a, B:380:0x0a26, B:383:0x0a32, B:385:0x0a3e, B:387:0x0a54, B:389:0x0a6e, B:391:0x0a7a, B:392:0x0a83, B:394:0x0a99, B:396:0x0af8, B:399:0x0b03, B:400:0x0b0d, B:401:0x0b0e, B:403:0x0b18, B:405:0x0b38, B:406:0x0b43, B:408:0x0b7b, B:410:0x0b83, B:412:0x0b8d, B:413:0x0b9e, B:415:0x0ba8, B:416:0x0bb9, B:417:0x0bc2, B:419:0x0bc8, B:421:0x0c21, B:429:0x0c68, B:431:0x0c7b, B:433:0x0c8d, B:437:0x0cac, B:439:0x0cbc, B:436:0x0c9c, B:422:0x0c2e, B:424:0x0c32, B:425:0x0c43, B:427:0x0c47, B:428:0x0c58, B:443:0x0ccf, B:444:0x0d10, B:445:0x0d1b, B:446:0x0d2c, B:448:0x0d32, B:456:0x0d76, B:457:0x0dc2, B:459:0x0dd3, B:474:0x0e3d, B:464:0x0dee, B:465:0x0df1, B:451:0x0d40, B:453:0x0d64, B:471:0x0e0e, B:472:0x0e27, B:473:0x0e28, B:370:0x09db, B:353:0x0982, B:333:0x08fc, B:296:0x0847, B:300:0x0854, B:304:0x0862, B:308:0x0870, B:312:0x087e, B:316:0x088c, B:320:0x0898, B:324:0x08a6), top: B:506:0x07b6, inners: #3, #6, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:333:0x08fc A[Catch: all -> 0x07f9, TryCatch #12 {all -> 0x07f9, blocks: (B:272:0x07b6, B:274:0x07e6, B:276:0x07ec, B:279:0x07fc, B:282:0x080d, B:284:0x0816, B:288:0x082d, B:293:0x083c, B:329:0x08bd, B:330:0x08c7, B:332:0x08f7, B:335:0x0902, B:339:0x090d, B:340:0x0927, B:342:0x092d, B:344:0x0947, B:346:0x0953, B:348:0x0960, B:355:0x0996, B:359:0x09a0, B:360:0x09a3, B:362:0x09b0, B:363:0x09b3, B:365:0x09c7, B:367:0x09cb, B:369:0x09d6, B:371:0x09e4, B:373:0x09ee, B:375:0x0a00, B:376:0x0a10, B:378:0x0a1a, B:380:0x0a26, B:383:0x0a32, B:385:0x0a3e, B:387:0x0a54, B:389:0x0a6e, B:391:0x0a7a, B:392:0x0a83, B:394:0x0a99, B:396:0x0af8, B:399:0x0b03, B:400:0x0b0d, B:401:0x0b0e, B:403:0x0b18, B:405:0x0b38, B:406:0x0b43, B:408:0x0b7b, B:410:0x0b83, B:412:0x0b8d, B:413:0x0b9e, B:415:0x0ba8, B:416:0x0bb9, B:417:0x0bc2, B:419:0x0bc8, B:421:0x0c21, B:429:0x0c68, B:431:0x0c7b, B:433:0x0c8d, B:437:0x0cac, B:439:0x0cbc, B:436:0x0c9c, B:422:0x0c2e, B:424:0x0c32, B:425:0x0c43, B:427:0x0c47, B:428:0x0c58, B:443:0x0ccf, B:444:0x0d10, B:445:0x0d1b, B:446:0x0d2c, B:448:0x0d32, B:456:0x0d76, B:457:0x0dc2, B:459:0x0dd3, B:474:0x0e3d, B:464:0x0dee, B:465:0x0df1, B:451:0x0d40, B:453:0x0d64, B:471:0x0e0e, B:472:0x0e27, B:473:0x0e28, B:370:0x09db, B:353:0x0982, B:333:0x08fc, B:296:0x0847, B:300:0x0854, B:304:0x0862, B:308:0x0870, B:312:0x087e, B:316:0x088c, B:320:0x0898, B:324:0x08a6), top: B:506:0x07b6, inners: #3, #6, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:337:0x0908  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x09a0 A[Catch: all -> 0x07f9, TryCatch #12 {all -> 0x07f9, blocks: (B:272:0x07b6, B:274:0x07e6, B:276:0x07ec, B:279:0x07fc, B:282:0x080d, B:284:0x0816, B:288:0x082d, B:293:0x083c, B:329:0x08bd, B:330:0x08c7, B:332:0x08f7, B:335:0x0902, B:339:0x090d, B:340:0x0927, B:342:0x092d, B:344:0x0947, B:346:0x0953, B:348:0x0960, B:355:0x0996, B:359:0x09a0, B:360:0x09a3, B:362:0x09b0, B:363:0x09b3, B:365:0x09c7, B:367:0x09cb, B:369:0x09d6, B:371:0x09e4, B:373:0x09ee, B:375:0x0a00, B:376:0x0a10, B:378:0x0a1a, B:380:0x0a26, B:383:0x0a32, B:385:0x0a3e, B:387:0x0a54, B:389:0x0a6e, B:391:0x0a7a, B:392:0x0a83, B:394:0x0a99, B:396:0x0af8, B:399:0x0b03, B:400:0x0b0d, B:401:0x0b0e, B:403:0x0b18, B:405:0x0b38, B:406:0x0b43, B:408:0x0b7b, B:410:0x0b83, B:412:0x0b8d, B:413:0x0b9e, B:415:0x0ba8, B:416:0x0bb9, B:417:0x0bc2, B:419:0x0bc8, B:421:0x0c21, B:429:0x0c68, B:431:0x0c7b, B:433:0x0c8d, B:437:0x0cac, B:439:0x0cbc, B:436:0x0c9c, B:422:0x0c2e, B:424:0x0c32, B:425:0x0c43, B:427:0x0c47, B:428:0x0c58, B:443:0x0ccf, B:444:0x0d10, B:445:0x0d1b, B:446:0x0d2c, B:448:0x0d32, B:456:0x0d76, B:457:0x0dc2, B:459:0x0dd3, B:474:0x0e3d, B:464:0x0dee, B:465:0x0df1, B:451:0x0d40, B:453:0x0d64, B:471:0x0e0e, B:472:0x0e27, B:473:0x0e28, B:370:0x09db, B:353:0x0982, B:333:0x08fc, B:296:0x0847, B:300:0x0854, B:304:0x0862, B:308:0x0870, B:312:0x087e, B:316:0x088c, B:320:0x0898, B:324:0x08a6), top: B:506:0x07b6, inners: #3, #6, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:362:0x09b0 A[Catch: all -> 0x07f9, TryCatch #12 {all -> 0x07f9, blocks: (B:272:0x07b6, B:274:0x07e6, B:276:0x07ec, B:279:0x07fc, B:282:0x080d, B:284:0x0816, B:288:0x082d, B:293:0x083c, B:329:0x08bd, B:330:0x08c7, B:332:0x08f7, B:335:0x0902, B:339:0x090d, B:340:0x0927, B:342:0x092d, B:344:0x0947, B:346:0x0953, B:348:0x0960, B:355:0x0996, B:359:0x09a0, B:360:0x09a3, B:362:0x09b0, B:363:0x09b3, B:365:0x09c7, B:367:0x09cb, B:369:0x09d6, B:371:0x09e4, B:373:0x09ee, B:375:0x0a00, B:376:0x0a10, B:378:0x0a1a, B:380:0x0a26, B:383:0x0a32, B:385:0x0a3e, B:387:0x0a54, B:389:0x0a6e, B:391:0x0a7a, B:392:0x0a83, B:394:0x0a99, B:396:0x0af8, B:399:0x0b03, B:400:0x0b0d, B:401:0x0b0e, B:403:0x0b18, B:405:0x0b38, B:406:0x0b43, B:408:0x0b7b, B:410:0x0b83, B:412:0x0b8d, B:413:0x0b9e, B:415:0x0ba8, B:416:0x0bb9, B:417:0x0bc2, B:419:0x0bc8, B:421:0x0c21, B:429:0x0c68, B:431:0x0c7b, B:433:0x0c8d, B:437:0x0cac, B:439:0x0cbc, B:436:0x0c9c, B:422:0x0c2e, B:424:0x0c32, B:425:0x0c43, B:427:0x0c47, B:428:0x0c58, B:443:0x0ccf, B:444:0x0d10, B:445:0x0d1b, B:446:0x0d2c, B:448:0x0d32, B:456:0x0d76, B:457:0x0dc2, B:459:0x0dd3, B:474:0x0e3d, B:464:0x0dee, B:465:0x0df1, B:451:0x0d40, B:453:0x0d64, B:471:0x0e0e, B:472:0x0e27, B:473:0x0e28, B:370:0x09db, B:353:0x0982, B:333:0x08fc, B:296:0x0847, B:300:0x0854, B:304:0x0862, B:308:0x0870, B:312:0x087e, B:316:0x088c, B:320:0x0898, B:324:0x08a6), top: B:506:0x07b6, inners: #3, #6, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:365:0x09c7 A[Catch: all -> 0x07f9, TryCatch #12 {all -> 0x07f9, blocks: (B:272:0x07b6, B:274:0x07e6, B:276:0x07ec, B:279:0x07fc, B:282:0x080d, B:284:0x0816, B:288:0x082d, B:293:0x083c, B:329:0x08bd, B:330:0x08c7, B:332:0x08f7, B:335:0x0902, B:339:0x090d, B:340:0x0927, B:342:0x092d, B:344:0x0947, B:346:0x0953, B:348:0x0960, B:355:0x0996, B:359:0x09a0, B:360:0x09a3, B:362:0x09b0, B:363:0x09b3, B:365:0x09c7, B:367:0x09cb, B:369:0x09d6, B:371:0x09e4, B:373:0x09ee, B:375:0x0a00, B:376:0x0a10, B:378:0x0a1a, B:380:0x0a26, B:383:0x0a32, B:385:0x0a3e, B:387:0x0a54, B:389:0x0a6e, B:391:0x0a7a, B:392:0x0a83, B:394:0x0a99, B:396:0x0af8, B:399:0x0b03, B:400:0x0b0d, B:401:0x0b0e, B:403:0x0b18, B:405:0x0b38, B:406:0x0b43, B:408:0x0b7b, B:410:0x0b83, B:412:0x0b8d, B:413:0x0b9e, B:415:0x0ba8, B:416:0x0bb9, B:417:0x0bc2, B:419:0x0bc8, B:421:0x0c21, B:429:0x0c68, B:431:0x0c7b, B:433:0x0c8d, B:437:0x0cac, B:439:0x0cbc, B:436:0x0c9c, B:422:0x0c2e, B:424:0x0c32, B:425:0x0c43, B:427:0x0c47, B:428:0x0c58, B:443:0x0ccf, B:444:0x0d10, B:445:0x0d1b, B:446:0x0d2c, B:448:0x0d32, B:456:0x0d76, B:457:0x0dc2, B:459:0x0dd3, B:474:0x0e3d, B:464:0x0dee, B:465:0x0df1, B:451:0x0d40, B:453:0x0d64, B:471:0x0e0e, B:472:0x0e27, B:473:0x0e28, B:370:0x09db, B:353:0x0982, B:333:0x08fc, B:296:0x0847, B:300:0x0854, B:304:0x0862, B:308:0x0870, B:312:0x087e, B:316:0x088c, B:320:0x0898, B:324:0x08a6), top: B:506:0x07b6, inners: #3, #6, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:393:0x0a92  */
    /* JADX WARN: Removed duplicated region for block: B:396:0x0af8 A[Catch: all -> 0x07f9, TryCatch #12 {all -> 0x07f9, blocks: (B:272:0x07b6, B:274:0x07e6, B:276:0x07ec, B:279:0x07fc, B:282:0x080d, B:284:0x0816, B:288:0x082d, B:293:0x083c, B:329:0x08bd, B:330:0x08c7, B:332:0x08f7, B:335:0x0902, B:339:0x090d, B:340:0x0927, B:342:0x092d, B:344:0x0947, B:346:0x0953, B:348:0x0960, B:355:0x0996, B:359:0x09a0, B:360:0x09a3, B:362:0x09b0, B:363:0x09b3, B:365:0x09c7, B:367:0x09cb, B:369:0x09d6, B:371:0x09e4, B:373:0x09ee, B:375:0x0a00, B:376:0x0a10, B:378:0x0a1a, B:380:0x0a26, B:383:0x0a32, B:385:0x0a3e, B:387:0x0a54, B:389:0x0a6e, B:391:0x0a7a, B:392:0x0a83, B:394:0x0a99, B:396:0x0af8, B:399:0x0b03, B:400:0x0b0d, B:401:0x0b0e, B:403:0x0b18, B:405:0x0b38, B:406:0x0b43, B:408:0x0b7b, B:410:0x0b83, B:412:0x0b8d, B:413:0x0b9e, B:415:0x0ba8, B:416:0x0bb9, B:417:0x0bc2, B:419:0x0bc8, B:421:0x0c21, B:429:0x0c68, B:431:0x0c7b, B:433:0x0c8d, B:437:0x0cac, B:439:0x0cbc, B:436:0x0c9c, B:422:0x0c2e, B:424:0x0c32, B:425:0x0c43, B:427:0x0c47, B:428:0x0c58, B:443:0x0ccf, B:444:0x0d10, B:445:0x0d1b, B:446:0x0d2c, B:448:0x0d32, B:456:0x0d76, B:457:0x0dc2, B:459:0x0dd3, B:474:0x0e3d, B:464:0x0dee, B:465:0x0df1, B:451:0x0d40, B:453:0x0d64, B:471:0x0e0e, B:472:0x0e27, B:473:0x0e28, B:370:0x09db, B:353:0x0982, B:333:0x08fc, B:296:0x0847, B:300:0x0854, B:304:0x0862, B:308:0x0870, B:312:0x087e, B:316:0x088c, B:320:0x0898, B:324:0x08a6), top: B:506:0x07b6, inners: #3, #6, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:403:0x0b18 A[Catch: all -> 0x07f9, TryCatch #12 {all -> 0x07f9, blocks: (B:272:0x07b6, B:274:0x07e6, B:276:0x07ec, B:279:0x07fc, B:282:0x080d, B:284:0x0816, B:288:0x082d, B:293:0x083c, B:329:0x08bd, B:330:0x08c7, B:332:0x08f7, B:335:0x0902, B:339:0x090d, B:340:0x0927, B:342:0x092d, B:344:0x0947, B:346:0x0953, B:348:0x0960, B:355:0x0996, B:359:0x09a0, B:360:0x09a3, B:362:0x09b0, B:363:0x09b3, B:365:0x09c7, B:367:0x09cb, B:369:0x09d6, B:371:0x09e4, B:373:0x09ee, B:375:0x0a00, B:376:0x0a10, B:378:0x0a1a, B:380:0x0a26, B:383:0x0a32, B:385:0x0a3e, B:387:0x0a54, B:389:0x0a6e, B:391:0x0a7a, B:392:0x0a83, B:394:0x0a99, B:396:0x0af8, B:399:0x0b03, B:400:0x0b0d, B:401:0x0b0e, B:403:0x0b18, B:405:0x0b38, B:406:0x0b43, B:408:0x0b7b, B:410:0x0b83, B:412:0x0b8d, B:413:0x0b9e, B:415:0x0ba8, B:416:0x0bb9, B:417:0x0bc2, B:419:0x0bc8, B:421:0x0c21, B:429:0x0c68, B:431:0x0c7b, B:433:0x0c8d, B:437:0x0cac, B:439:0x0cbc, B:436:0x0c9c, B:422:0x0c2e, B:424:0x0c32, B:425:0x0c43, B:427:0x0c47, B:428:0x0c58, B:443:0x0ccf, B:444:0x0d10, B:445:0x0d1b, B:446:0x0d2c, B:448:0x0d32, B:456:0x0d76, B:457:0x0dc2, B:459:0x0dd3, B:474:0x0e3d, B:464:0x0dee, B:465:0x0df1, B:451:0x0d40, B:453:0x0d64, B:471:0x0e0e, B:472:0x0e27, B:473:0x0e28, B:370:0x09db, B:353:0x0982, B:333:0x08fc, B:296:0x0847, B:300:0x0854, B:304:0x0862, B:308:0x0870, B:312:0x087e, B:316:0x088c, B:320:0x0898, B:324:0x08a6), top: B:506:0x07b6, inners: #3, #6, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:407:0x0b78  */
    /* JADX WARN: Removed duplicated region for block: B:410:0x0b83 A[Catch: all -> 0x07f9, TryCatch #12 {all -> 0x07f9, blocks: (B:272:0x07b6, B:274:0x07e6, B:276:0x07ec, B:279:0x07fc, B:282:0x080d, B:284:0x0816, B:288:0x082d, B:293:0x083c, B:329:0x08bd, B:330:0x08c7, B:332:0x08f7, B:335:0x0902, B:339:0x090d, B:340:0x0927, B:342:0x092d, B:344:0x0947, B:346:0x0953, B:348:0x0960, B:355:0x0996, B:359:0x09a0, B:360:0x09a3, B:362:0x09b0, B:363:0x09b3, B:365:0x09c7, B:367:0x09cb, B:369:0x09d6, B:371:0x09e4, B:373:0x09ee, B:375:0x0a00, B:376:0x0a10, B:378:0x0a1a, B:380:0x0a26, B:383:0x0a32, B:385:0x0a3e, B:387:0x0a54, B:389:0x0a6e, B:391:0x0a7a, B:392:0x0a83, B:394:0x0a99, B:396:0x0af8, B:399:0x0b03, B:400:0x0b0d, B:401:0x0b0e, B:403:0x0b18, B:405:0x0b38, B:406:0x0b43, B:408:0x0b7b, B:410:0x0b83, B:412:0x0b8d, B:413:0x0b9e, B:415:0x0ba8, B:416:0x0bb9, B:417:0x0bc2, B:419:0x0bc8, B:421:0x0c21, B:429:0x0c68, B:431:0x0c7b, B:433:0x0c8d, B:437:0x0cac, B:439:0x0cbc, B:436:0x0c9c, B:422:0x0c2e, B:424:0x0c32, B:425:0x0c43, B:427:0x0c47, B:428:0x0c58, B:443:0x0ccf, B:444:0x0d10, B:445:0x0d1b, B:446:0x0d2c, B:448:0x0d32, B:456:0x0d76, B:457:0x0dc2, B:459:0x0dd3, B:474:0x0e3d, B:464:0x0dee, B:465:0x0df1, B:451:0x0d40, B:453:0x0d64, B:471:0x0e0e, B:472:0x0e27, B:473:0x0e28, B:370:0x09db, B:353:0x0982, B:333:0x08fc, B:296:0x0847, B:300:0x0854, B:304:0x0862, B:308:0x0870, B:312:0x087e, B:316:0x088c, B:320:0x0898, B:324:0x08a6), top: B:506:0x07b6, inners: #3, #6, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:415:0x0ba8 A[Catch: all -> 0x07f9, TryCatch #12 {all -> 0x07f9, blocks: (B:272:0x07b6, B:274:0x07e6, B:276:0x07ec, B:279:0x07fc, B:282:0x080d, B:284:0x0816, B:288:0x082d, B:293:0x083c, B:329:0x08bd, B:330:0x08c7, B:332:0x08f7, B:335:0x0902, B:339:0x090d, B:340:0x0927, B:342:0x092d, B:344:0x0947, B:346:0x0953, B:348:0x0960, B:355:0x0996, B:359:0x09a0, B:360:0x09a3, B:362:0x09b0, B:363:0x09b3, B:365:0x09c7, B:367:0x09cb, B:369:0x09d6, B:371:0x09e4, B:373:0x09ee, B:375:0x0a00, B:376:0x0a10, B:378:0x0a1a, B:380:0x0a26, B:383:0x0a32, B:385:0x0a3e, B:387:0x0a54, B:389:0x0a6e, B:391:0x0a7a, B:392:0x0a83, B:394:0x0a99, B:396:0x0af8, B:399:0x0b03, B:400:0x0b0d, B:401:0x0b0e, B:403:0x0b18, B:405:0x0b38, B:406:0x0b43, B:408:0x0b7b, B:410:0x0b83, B:412:0x0b8d, B:413:0x0b9e, B:415:0x0ba8, B:416:0x0bb9, B:417:0x0bc2, B:419:0x0bc8, B:421:0x0c21, B:429:0x0c68, B:431:0x0c7b, B:433:0x0c8d, B:437:0x0cac, B:439:0x0cbc, B:436:0x0c9c, B:422:0x0c2e, B:424:0x0c32, B:425:0x0c43, B:427:0x0c47, B:428:0x0c58, B:443:0x0ccf, B:444:0x0d10, B:445:0x0d1b, B:446:0x0d2c, B:448:0x0d32, B:456:0x0d76, B:457:0x0dc2, B:459:0x0dd3, B:474:0x0e3d, B:464:0x0dee, B:465:0x0df1, B:451:0x0d40, B:453:0x0d64, B:471:0x0e0e, B:472:0x0e27, B:473:0x0e28, B:370:0x09db, B:353:0x0982, B:333:0x08fc, B:296:0x0847, B:300:0x0854, B:304:0x0862, B:308:0x0870, B:312:0x087e, B:316:0x088c, B:320:0x0898, B:324:0x08a6), top: B:506:0x07b6, inners: #3, #6, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:419:0x0bc8 A[Catch: all -> 0x07f9, TryCatch #12 {all -> 0x07f9, blocks: (B:272:0x07b6, B:274:0x07e6, B:276:0x07ec, B:279:0x07fc, B:282:0x080d, B:284:0x0816, B:288:0x082d, B:293:0x083c, B:329:0x08bd, B:330:0x08c7, B:332:0x08f7, B:335:0x0902, B:339:0x090d, B:340:0x0927, B:342:0x092d, B:344:0x0947, B:346:0x0953, B:348:0x0960, B:355:0x0996, B:359:0x09a0, B:360:0x09a3, B:362:0x09b0, B:363:0x09b3, B:365:0x09c7, B:367:0x09cb, B:369:0x09d6, B:371:0x09e4, B:373:0x09ee, B:375:0x0a00, B:376:0x0a10, B:378:0x0a1a, B:380:0x0a26, B:383:0x0a32, B:385:0x0a3e, B:387:0x0a54, B:389:0x0a6e, B:391:0x0a7a, B:392:0x0a83, B:394:0x0a99, B:396:0x0af8, B:399:0x0b03, B:400:0x0b0d, B:401:0x0b0e, B:403:0x0b18, B:405:0x0b38, B:406:0x0b43, B:408:0x0b7b, B:410:0x0b83, B:412:0x0b8d, B:413:0x0b9e, B:415:0x0ba8, B:416:0x0bb9, B:417:0x0bc2, B:419:0x0bc8, B:421:0x0c21, B:429:0x0c68, B:431:0x0c7b, B:433:0x0c8d, B:437:0x0cac, B:439:0x0cbc, B:436:0x0c9c, B:422:0x0c2e, B:424:0x0c32, B:425:0x0c43, B:427:0x0c47, B:428:0x0c58, B:443:0x0ccf, B:444:0x0d10, B:445:0x0d1b, B:446:0x0d2c, B:448:0x0d32, B:456:0x0d76, B:457:0x0dc2, B:459:0x0dd3, B:474:0x0e3d, B:464:0x0dee, B:465:0x0df1, B:451:0x0d40, B:453:0x0d64, B:471:0x0e0e, B:472:0x0e27, B:473:0x0e28, B:370:0x09db, B:353:0x0982, B:333:0x08fc, B:296:0x0847, B:300:0x0854, B:304:0x0862, B:308:0x0870, B:312:0x087e, B:316:0x088c, B:320:0x0898, B:324:0x08a6), top: B:506:0x07b6, inners: #3, #6, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:441:0x0cc7  */
    /* JADX WARN: Removed duplicated region for block: B:448:0x0d32 A[Catch: all -> 0x07f9, TryCatch #12 {all -> 0x07f9, blocks: (B:272:0x07b6, B:274:0x07e6, B:276:0x07ec, B:279:0x07fc, B:282:0x080d, B:284:0x0816, B:288:0x082d, B:293:0x083c, B:329:0x08bd, B:330:0x08c7, B:332:0x08f7, B:335:0x0902, B:339:0x090d, B:340:0x0927, B:342:0x092d, B:344:0x0947, B:346:0x0953, B:348:0x0960, B:355:0x0996, B:359:0x09a0, B:360:0x09a3, B:362:0x09b0, B:363:0x09b3, B:365:0x09c7, B:367:0x09cb, B:369:0x09d6, B:371:0x09e4, B:373:0x09ee, B:375:0x0a00, B:376:0x0a10, B:378:0x0a1a, B:380:0x0a26, B:383:0x0a32, B:385:0x0a3e, B:387:0x0a54, B:389:0x0a6e, B:391:0x0a7a, B:392:0x0a83, B:394:0x0a99, B:396:0x0af8, B:399:0x0b03, B:400:0x0b0d, B:401:0x0b0e, B:403:0x0b18, B:405:0x0b38, B:406:0x0b43, B:408:0x0b7b, B:410:0x0b83, B:412:0x0b8d, B:413:0x0b9e, B:415:0x0ba8, B:416:0x0bb9, B:417:0x0bc2, B:419:0x0bc8, B:421:0x0c21, B:429:0x0c68, B:431:0x0c7b, B:433:0x0c8d, B:437:0x0cac, B:439:0x0cbc, B:436:0x0c9c, B:422:0x0c2e, B:424:0x0c32, B:425:0x0c43, B:427:0x0c47, B:428:0x0c58, B:443:0x0ccf, B:444:0x0d10, B:445:0x0d1b, B:446:0x0d2c, B:448:0x0d32, B:456:0x0d76, B:457:0x0dc2, B:459:0x0dd3, B:474:0x0e3d, B:464:0x0dee, B:465:0x0df1, B:451:0x0d40, B:453:0x0d64, B:471:0x0e0e, B:472:0x0e27, B:473:0x0e28, B:370:0x09db, B:353:0x0982, B:333:0x08fc, B:296:0x0847, B:300:0x0854, B:304:0x0862, B:308:0x0870, B:312:0x087e, B:316:0x088c, B:320:0x0898, B:324:0x08a6), top: B:506:0x07b6, inners: #3, #6, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:459:0x0dd3 A[Catch: all -> 0x07f9, SQLiteException -> 0x0de9, TRY_LEAVE, TryCatch #10 {SQLiteException -> 0x0de9, blocks: (B:457:0x0dc2, B:459:0x0dd3), top: B:502:0x0dc2, outer: #12 }] */
    /* JADX WARN: Removed duplicated region for block: B:463:0x0dec  */
    /* JADX WARN: Removed duplicated region for block: B:486:0x071d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:488:0x079f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:492:0x0761 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:497:0x05f2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:514:0x0731 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:522:0x0749 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:545:0x0d40 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Y(J1.C0112v r50, J1.b2 r51) throws java.net.MalformedURLException, java.net.URISyntaxException, java.lang.NumberFormatException, android.database.SQLException {
        /*
            Method dump skipped, instructions count: 3709
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.V1.Y(J1.v, J1.b2):void");
    }

    public final boolean Z(String str, String str2) {
        C0089n c0089n = this.f1019e;
        J(c0089n);
        V vG0 = c0089n.g0(str);
        HashMap map = this.f1012G;
        if (vG0 != null && g().a0(str, vG0.i())) {
            map.remove(str2);
            return true;
        }
        U1 u12 = (U1) map.get(str2);
        if (u12 == null) {
            return true;
        }
        u12.f958a.f().getClass();
        return System.currentTimeMillis() >= u12.f960c;
    }

    @Override // J1.G0
    public final O2.e a() {
        return this.n.h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Bundle a0(String str) {
        AbstractC0535a.q(this);
        C0093o0 c0093o0 = this.f1017c;
        J(c0093o0);
        if (c0093o0.x(str) == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        K0 k0J0 = j0(str);
        Bundle bundle2 = new Bundle();
        Iterator it = k0J0.f879a.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            int iOrdinal = ((H0) entry.getValue()).ordinal();
            String str2 = iOrdinal != 2 ? iOrdinal != 3 ? null : "granted" : "denied";
            if (str2 != null) {
                bundle2.putString(((J0) entry.getKey()).f876j, str2);
            }
        }
        bundle.putAll(bundle2);
        C0095p c0095pF0 = f0(str, g0(str), k0J0, new Z2.c(8));
        Bundle bundle3 = new Bundle();
        for (Map.Entry entry2 : c0095pF0.f1341e.entrySet()) {
            int iOrdinal2 = ((H0) entry2.getValue()).ordinal();
            String str3 = iOrdinal2 != 2 ? iOrdinal2 != 3 ? null : "granted" : "denied";
            if (str3 != null) {
                bundle3.putString(((J0) entry2.getKey()).f876j, str3);
            }
        }
        Boolean bool = c0095pF0.f1339c;
        if (bool != null) {
            bundle3.putString("is_dma_region", bool.toString());
        }
        String str4 = c0095pF0.f1340d;
        if (str4 != null) {
            bundle3.putString("cps_display_str", str4);
        }
        bundle.putAll(bundle3);
        C0089n c0089n = this.f1019e;
        J(c0089n);
        Z1 z1P0 = c0089n.p0(str, "_npa");
        bundle.putString("ad_personalization", 1 != (z1P0 != null ? z1P0.f1094e.equals(1L) : w(str, new Z2.c(8))) ? "granted" : "denied");
        return bundle;
    }

    public final C0060d0 b() {
        C0060d0 c0060d0 = this.f1021i;
        J(c0060d0);
        return c0060d0;
    }

    public final Bundle b0(C0112v c0112v, String str) {
        Bundle bundle = new Bundle();
        bundle.putLong("_sid", c0112v.f1399k.f1395j.getLong("_sid"));
        C0089n c0089n = this.f1019e;
        J(c0089n);
        Z1 z1P0 = c0089n.p0(str, "_sno");
        if (z1P0 != null) {
            Object obj = z1P0.f1094e;
            if (obj instanceof Long) {
                bundle.putLong("_sno", ((Long) obj).longValue());
            }
        }
        return bundle;
    }

    @Override // J1.G0
    public final Z c() {
        C0113v0 c0113v0 = this.n;
        q1.E.i(c0113v0);
        Z z4 = c0113v0.f1417k;
        C0113v0.k(z4);
        return z4;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0296  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final J1.V c0(J1.b2 r14) {
        /*
            Method dump skipped, instructions count: 703
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.V1.c0(J1.b2):J1.V");
    }

    @Override // J1.G0
    public final Context d() {
        return this.n.f1411c;
    }

    public final C0068g d0() {
        C0113v0 c0113v0 = this.n;
        q1.E.i(c0113v0);
        return c0113v0.f1415i;
    }

    @Override // J1.G0
    public final C0104s0 e() {
        C0113v0 c0113v0 = this.n;
        q1.E.i(c0113v0);
        C0104s0 c0104s0 = c0113v0.f1418l;
        C0113v0.k(c0104s0);
        return c0104s0;
    }

    public final C0089n e0() {
        C0089n c0089n = this.f1019e;
        J(c0089n);
        return c0089n;
    }

    @Override // J1.G0
    public final C0906a f() {
        C0113v0 c0113v0 = this.n;
        q1.E.i(c0113v0);
        return c0113v0.f1421p;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final J1.C0095p f0(java.lang.String r12, J1.C0095p r13, J1.K0 r14, Z2.c r15) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.V1.f0(java.lang.String, J1.p, J1.K0, Z2.c):J1.p");
    }

    public final a2 g() {
        C0113v0 c0113v0 = this.n;
        q1.E.i(c0113v0);
        a2 a2Var = c0113v0.n;
        C0113v0.i(a2Var);
        return a2Var;
    }

    public final C0095p g0(String str) throws NumberFormatException {
        AbstractC0535a.q(this);
        HashMap map = this.f1010E;
        C0095p c0095p = (C0095p) map.get(str);
        if (c0095p != null) {
            return c0095p;
        }
        C0089n c0089n = this.f1019e;
        J(c0089n);
        q1.E.i(str);
        c0089n.j();
        c0089n.k();
        C0095p c0095pB = C0095p.b(c0089n.O("select dma_consent_settings from consent_settings where app_id=? limit 1;", new String[]{str}));
        map.put(str, c0095pB);
        return c0095pB;
    }

    public final String h(K0 k02) {
        if (!k02.k(J0.ANALYTICS_STORAGE)) {
            return null;
        }
        byte[] bArr = new byte[16];
        g().v().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    public final C0063e0 h0() {
        C0063e0 c0063e0 = this.f1020f;
        if (c0063e0 != null) {
            return c0063e0;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.util.List] */
    public final List i(b2 b2Var, Bundle bundle) {
        e().j();
        M3.b();
        C0068g c0068gD0 = d0();
        String str = b2Var.f1138j;
        if (!c0068gD0.w(str, H.f787V0) || str == null) {
            return new ArrayList();
        }
        if (bundle != null) {
            int[] intArray = bundle.getIntArray("uriSources");
            long[] longArray = bundle.getLongArray("uriTimestamps");
            if (intArray != null) {
                if (longArray == null || longArray.length != intArray.length) {
                    c().h.a("Uri sources and timestamps do not match");
                } else {
                    for (int i5 = 0; i5 < intArray.length; i5++) {
                        C0089n c0089n = this.f1019e;
                        J(c0089n);
                        C0113v0 c0113v0 = (C0113v0) c0089n.f84c;
                        int i6 = intArray[i5];
                        long j5 = longArray[i5];
                        q1.E.f(str);
                        c0089n.j();
                        c0089n.k();
                        try {
                            int iDelete = c0089n.f0().delete("trigger_uris", "app_id=? and source=? and timestamp_millis<=?", new String[]{str, String.valueOf(i6), String.valueOf(j5)});
                            Z z4 = c0113v0.f1417k;
                            C0113v0.k(z4);
                            z4.f1084p.d("Pruned " + iDelete + " trigger URIs. appId, source, timestamp", str, Integer.valueOf(i6), Long.valueOf(j5));
                        } catch (SQLiteException e5) {
                            Z z5 = c0113v0.f1417k;
                            C0113v0.k(z5);
                            z5.h.c(Z.q(str), e5, "Error pruning trigger URIs. appId");
                        }
                    }
                }
            }
        }
        C0089n c0089n2 = this.f1019e;
        J(c0089n2);
        String str2 = b2Var.f1138j;
        q1.E.f(str2);
        c0089n2.j();
        c0089n2.k();
        ?? arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = c0089n2.f0().query("trigger_uris", new String[]{"trigger_uri", "timestamp_millis", "source"}, "app_id=?", new String[]{str2}, null, null, "rowid", null);
                if (cursorQuery.moveToFirst()) {
                    do {
                        String string = cursorQuery.getString(0);
                        if (string == null) {
                            string = "";
                        }
                        arrayList.add(new K1(cursorQuery.getInt(2), string, cursorQuery.getLong(1)));
                    } while (cursorQuery.moveToNext());
                }
            } catch (SQLiteException e6) {
                Z z6 = ((C0113v0) c0089n2.f84c).f1417k;
                C0113v0.k(z6);
                z6.h.c(Z.q(str2), e6, "Error querying trigger uris. appId");
                arrayList = Collections.emptyList();
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return arrayList;
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    public final C0093o0 i0() {
        C0093o0 c0093o0 = this.f1017c;
        J(c0093o0);
        return c0093o0;
    }

    public final void j() {
        AbstractC0535a.q(this);
        if (this.f1027p) {
            return;
        }
        this.f1027p = true;
        e().j();
        FileLock fileLock = this.f1036y;
        C0113v0 c0113v0 = this.n;
        if (fileLock == null || !fileLock.isValid()) {
            ((C0113v0) this.f1019e.f84c).getClass();
            File filesDir = c0113v0.f1411c.getFilesDir();
            int i5 = com.google.android.gms.internal.measurement.D.f4670d;
            try {
                FileChannel channel = new RandomAccessFile(new File(new File(filesDir, "google_app_measurement.db").getPath()), "rw").getChannel();
                this.f1037z = channel;
                FileLock fileLockTryLock = channel.tryLock();
                this.f1036y = fileLockTryLock;
                if (fileLockTryLock == null) {
                    c().h.a("Storage concurrent data access panic");
                    return;
                }
                c().f1084p.a("Storage concurrent access okay");
            } catch (FileNotFoundException e5) {
                c().h.b(e5, "Failed to acquire storage lock");
                return;
            } catch (IOException e6) {
                c().h.b(e6, "Failed to access storage lock file");
                return;
            } catch (OverlappingFileLockException e7) {
                c().f1080k.b(e7, "Storage lock already acquired");
                return;
            }
        } else {
            c().f1084p.a("Storage concurrent access okay");
        }
        FileChannel fileChannel = this.f1037z;
        e().j();
        int i6 = 0;
        if (fileChannel == null || !fileChannel.isOpen()) {
            c().h.a("Bad channel to read from");
        } else {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
            try {
                fileChannel.position(0L);
                int i7 = fileChannel.read(byteBufferAllocate);
                if (i7 == 4) {
                    byteBufferAllocate.flip();
                    i6 = byteBufferAllocate.getInt();
                } else if (i7 != -1) {
                    c().f1080k.b(Integer.valueOf(i7), "Unexpected data length. Bytes read");
                }
            } catch (IOException e8) {
                c().h.b(e8, "Failed to read from channel");
            }
        }
        O oN = c0113v0.n();
        oN.k();
        int i8 = oN.g;
        e().j();
        if (i6 > i8) {
            Z zC = c();
            zC.h.c(Integer.valueOf(i6), Integer.valueOf(i8), "Panic: can't downgrade version. Previous, current version");
            return;
        }
        if (i6 < i8) {
            FileChannel fileChannel2 = this.f1037z;
            e().j();
            if (fileChannel2 == null || !fileChannel2.isOpen()) {
                c().h.a("Bad channel to read from");
            } else {
                ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(4);
                byteBufferAllocate2.putInt(i8);
                byteBufferAllocate2.flip();
                try {
                    fileChannel2.truncate(0L);
                    fileChannel2.write(byteBufferAllocate2);
                    fileChannel2.force(true);
                    if (fileChannel2.size() != 4) {
                        c().h.b(Long.valueOf(fileChannel2.size()), "Error writing to channel. Bytes written");
                    }
                    Z zC2 = c();
                    zC2.f1084p.c(Integer.valueOf(i6), Integer.valueOf(i8), "Storage version upgraded. Previous, current version");
                    return;
                } catch (IOException e9) {
                    c().h.b(e9, "Failed to write to channel");
                }
            }
            Z zC3 = c();
            zC3.h.c(Integer.valueOf(i6), Integer.valueOf(i8), "Storage version upgrade failed. Previous, current version");
        }
    }

    public final K0 j0(String str) {
        K0 k02 = K0.f878c;
        AbstractC0535a.q(this);
        HashMap map = this.f1009D;
        K0 k0N0 = (K0) map.get(str);
        if (k0N0 == null) {
            C0089n c0089n = this.f1019e;
            J(c0089n);
            k0N0 = c0089n.n0(str);
            if (k0N0 == null) {
                k0N0 = K0.f878c;
            }
            e().j();
            k();
            map.put(str, k0N0);
            C0089n c0089n2 = this.f1019e;
            J(c0089n2);
            c0089n2.H(str, k0N0);
        }
        return k0N0;
    }

    public final void k() {
        if (!this.f1026o.get()) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    public final void l(V v4) throws MalformedURLException, URISyntaxException {
        q.b bVar;
        q.b bVar2;
        e().j();
        if (TextUtils.isEmpty(v4.g()) && TextUtils.isEmpty(v4.a())) {
            String strC = v4.c();
            q1.E.i(strC);
            r(strC, 204, null, null, null);
            return;
        }
        String strC2 = v4.c();
        q1.E.i(strC2);
        c().f1084p.b(strC2, "Fetching remote configuration");
        C0093o0 c0093o0 = this.f1017c;
        J(c0093o0);
        com.google.android.gms.internal.measurement.H0 h0Y = c0093o0.y(strC2);
        J(c0093o0);
        c0093o0.j();
        String str = (String) c0093o0.f1332o.getOrDefault(strC2, null);
        if (h0Y != null) {
            if (TextUtils.isEmpty(str)) {
                bVar2 = null;
            } else {
                bVar2 = new q.b();
                bVar2.put("If-Modified-Since", str);
            }
            J(c0093o0);
            c0093o0.j();
            String str2 = (String) c0093o0.f1333p.getOrDefault(strC2, null);
            if (!TextUtils.isEmpty(str2)) {
                if (bVar2 == null) {
                    bVar2 = new q.b();
                }
                bVar2.put("If-None-Match", str2);
            }
            bVar = bVar2;
        } else {
            bVar = null;
        }
        this.f1033v = true;
        C0060d0 c0060d0 = this.f1018d;
        J(c0060d0);
        C0519j c0519j = new C0519j(6, this);
        C0113v0 c0113v0 = (C0113v0) c0060d0.f84c;
        c0060d0.j();
        c0060d0.k();
        S1 s12 = c0060d0.f902d.f1024l;
        Uri.Builder builder = new Uri.Builder();
        String strG = v4.g();
        if (TextUtils.isEmpty(strG)) {
            strG = v4.a();
        }
        Uri.Builder builderAppendQueryParameter = builder.scheme((String) H.f810f.a(null)).encodedAuthority((String) H.g.a(null)).path("config/app/".concat(String.valueOf(strG))).appendQueryParameter("platform", "android");
        ((C0113v0) s12.f84c).f1415i.q();
        builderAppendQueryParameter.appendQueryParameter("gmp_version", String.valueOf(119002L)).appendQueryParameter("runtime_version", "0");
        String string = builder.build().toString();
        try {
            URL url = new URI(string).toURL();
            C0104s0 c0104s0 = c0113v0.f1418l;
            C0113v0.k(c0104s0);
            c0104s0.s(new RunnableC0057c0(c0060d0, v4.c(), url, (byte[]) null, bVar, c0519j));
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused) {
            Z z4 = c0113v0.f1417k;
            C0113v0.k(z4);
            z4.h.c(Z.q(v4.c()), string, "Failed to parse config URL. Not fetching. appId");
        }
    }

    public final void m(b2 b2Var, long j5) throws MalformedURLException, URISyntaxException, NumberFormatException, SQLException {
        C0089n c0089n = this.f1019e;
        J(c0089n);
        String str = b2Var.f1138j;
        q1.E.i(str);
        V vG0 = c0089n.g0(str);
        if (vG0 != null) {
            if (g().i0(b2Var.f1139k, vG0.g(), b2Var.f1152y, vG0.a())) {
                c().f1080k.b(Z.q(vG0.c()), "New GMP App Id passed in. Removing cached database data. appId");
                C0089n c0089n2 = this.f1019e;
                J(c0089n2);
                C0113v0 c0113v0 = (C0113v0) c0089n2.f84c;
                String strC = vG0.c();
                c0089n2.k();
                c0089n2.j();
                q1.E.f(strC);
                try {
                    SQLiteDatabase sQLiteDatabaseF0 = c0089n2.f0();
                    String[] strArr = {strC};
                    int iDelete = sQLiteDatabaseF0.delete("events", "app_id=?", strArr) + sQLiteDatabaseF0.delete("user_attributes", "app_id=?", strArr) + sQLiteDatabaseF0.delete("conditional_properties", "app_id=?", strArr) + sQLiteDatabaseF0.delete("apps", "app_id=?", strArr) + sQLiteDatabaseF0.delete("raw_events", "app_id=?", strArr) + sQLiteDatabaseF0.delete("raw_events_metadata", "app_id=?", strArr) + sQLiteDatabaseF0.delete("event_filters", "app_id=?", strArr) + sQLiteDatabaseF0.delete("property_filters", "app_id=?", strArr) + sQLiteDatabaseF0.delete("audience_filter_values", "app_id=?", strArr) + sQLiteDatabaseF0.delete("consent_settings", "app_id=?", strArr) + sQLiteDatabaseF0.delete("default_event_params", "app_id=?", strArr) + sQLiteDatabaseF0.delete("trigger_uris", "app_id=?", strArr);
                    if (iDelete > 0) {
                        Z z4 = c0113v0.f1417k;
                        C0113v0.k(z4);
                        z4.f1084p.c(strC, Integer.valueOf(iDelete), "Deleted application data. app, records");
                    }
                } catch (SQLiteException e5) {
                    Z z5 = c0113v0.f1417k;
                    C0113v0.k(z5);
                    z5.h.c(Z.q(strC), e5, "Error deleting application data. appId, error");
                }
                vG0 = null;
            }
        }
        if (vG0 != null) {
            boolean z6 = (vG0.S() == -2147483648L || vG0.S() == b2Var.f1146s) ? false : true;
            String strE = vG0.e();
            if (z6 || ((vG0.S() != -2147483648L || strE == null || strE.equals(b2Var.f1140l)) ? false : true)) {
                Bundle bundle = new Bundle();
                bundle.putString("_pv", strE);
                C0112v c0112v = new C0112v("_au", new C0109u(bundle), "auto", j5);
                if (d0().w(null, H.f830m1)) {
                    q(c0112v, b2Var);
                } else {
                    o(c0112v, b2Var);
                }
            }
        }
    }

    public final void n(C0315e1 c0315e1, E0.d dVar) {
        String strS;
        String strS2;
        for (int i5 = 0; i5 < c0315e1.r(); i5++) {
            com.google.android.gms.internal.measurement.W0 w02 = (com.google.android.gms.internal.measurement.W0) ((C0320f1) c0315e1.f4913k).l2(i5).g();
            Iterator it = w02.n().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if ("_c".equals(((C0295a1) it.next()).u())) {
                    if (((C0320f1) dVar.f457b).O() >= d0().p(((C0320f1) dVar.f457b).t(), H.f824k0)) {
                        int iP = d0().p(((C0320f1) dVar.f457b).t(), H.f855x0);
                        LinkedList linkedList = this.f1030s;
                        C0060d0 c0060d0 = this.f1021i;
                        if (iP > 0) {
                            C0089n c0089n = this.f1019e;
                            J(c0089n);
                            if (c0089n.j0(t(), ((C0320f1) dVar.f457b).t(), false, false, false, true).g > iP) {
                                com.google.android.gms.internal.measurement.Z0 z0T = C0295a1.t();
                                z0T.i("_tnr");
                                z0T.h(1L);
                                w02.k((C0295a1) z0T.e());
                            } else {
                                if (d0().w(((C0320f1) dVar.f457b).t(), H.f791X0)) {
                                    strS2 = g().s();
                                    com.google.android.gms.internal.measurement.Z0 z0T2 = C0295a1.t();
                                    z0T2.i("_tu");
                                    z0T2.j(strS2);
                                    w02.k((C0295a1) z0T2.e());
                                } else {
                                    strS2 = null;
                                }
                                com.google.android.gms.internal.measurement.Z0 z0T3 = C0295a1.t();
                                z0T3.i("_tr");
                                z0T3.h(1L);
                                w02.k((C0295a1) z0T3.e());
                                J(c0060d0);
                                K1 k1N = c0060d0.N(((C0320f1) dVar.f457b).t(), c0315e1, w02, strS2);
                                if (k1N != null) {
                                    c().f1084p.c(((C0320f1) dVar.f457b).t(), k1N.f881j, "Generated trigger URI. appId, uri");
                                    C0089n c0089n2 = this.f1019e;
                                    J(c0089n2);
                                    c0089n2.T(((C0320f1) dVar.f457b).t(), k1N);
                                    if (!linkedList.contains(((C0320f1) dVar.f457b).t())) {
                                        linkedList.add(((C0320f1) dVar.f457b).t());
                                    }
                                }
                            }
                        } else {
                            if (d0().w(((C0320f1) dVar.f457b).t(), H.f791X0)) {
                                strS = g().s();
                                com.google.android.gms.internal.measurement.Z0 z0T4 = C0295a1.t();
                                z0T4.i("_tu");
                                z0T4.j(strS);
                                w02.k((C0295a1) z0T4.e());
                            } else {
                                strS = null;
                            }
                            com.google.android.gms.internal.measurement.Z0 z0T5 = C0295a1.t();
                            z0T5.i("_tr");
                            z0T5.h(1L);
                            w02.k((C0295a1) z0T5.e());
                            J(c0060d0);
                            K1 k1N2 = c0060d0.N(((C0320f1) dVar.f457b).t(), c0315e1, w02, strS);
                            if (k1N2 != null) {
                                c().f1084p.c(((C0320f1) dVar.f457b).t(), k1N2.f881j, "Generated trigger URI. appId, uri");
                                C0089n c0089n3 = this.f1019e;
                                J(c0089n3);
                                c0089n3.T(((C0320f1) dVar.f457b).t(), k1N2);
                                if (!linkedList.contains(((C0320f1) dVar.f457b).t())) {
                                    linkedList.add(((C0320f1) dVar.f457b).t());
                                }
                            }
                        }
                    }
                    com.google.android.gms.internal.measurement.X0 x02 = (com.google.android.gms.internal.measurement.X0) w02.e();
                    c0315e1.g();
                    C0320f1.i0((C0320f1) c0315e1.f4913k, i5, x02);
                }
            }
        }
    }

    public final void o(C0112v c0112v, b2 b2Var) throws MalformedURLException, URISyntaxException, NumberFormatException, SQLException {
        List listP;
        C0113v0 c0113v0;
        List listP2;
        List<C0062e> listP3;
        String str;
        q1.E.i(b2Var);
        String str2 = b2Var.f1138j;
        q1.E.f(str2);
        e().j();
        k();
        C0051a0 c0051a0C = C0051a0.c(c0112v);
        e().j();
        a2.z((this.f1013H == null || (str = this.I) == null || !str.equals(str2)) ? null : this.f1013H, (Bundle) c0051a0C.f1103e, false);
        C0112v c0112vA = c0051a0C.a();
        b();
        if (TextUtils.isEmpty(b2Var.f1139k) && TextUtils.isEmpty(b2Var.f1152y)) {
            return;
        }
        if (!b2Var.f1144q) {
            c0(b2Var);
            return;
        }
        List list = b2Var.f1124B;
        if (list != null) {
            String str3 = c0112vA.f1398j;
            if (!list.contains(str3)) {
                c().f1083o.d("Dropping non-safelisted event. appId, event name, origin", str2, c0112vA.f1398j, c0112vA.f1400l);
                return;
            } else {
                Bundle bundleA = c0112vA.f1399k.a();
                bundleA.putLong("ga_safelisted", 1L);
                c0112vA = new C0112v(str3, new C0109u(bundleA), c0112vA.f1400l, c0112vA.f1401m);
            }
        }
        C0089n c0089n = this.f1019e;
        J(c0089n);
        c0089n.u();
        try {
            ((W3) V3.f4792k.f4793j.f10447j).getClass();
            boolean zW = d0().w(null, H.f819i1);
            String str4 = c0112vA.f1398j;
            if (zW && "_s".equals(str4)) {
                C0089n c0089n2 = this.f1019e;
                J(c0089n2);
                if (!c0089n2.J(str2, "_s") && c0112vA.f1399k.f1395j.getLong("_sid") != 0) {
                    C0089n c0089n3 = this.f1019e;
                    J(c0089n3);
                    if (c0089n3.J(str2, "_f")) {
                        C0089n c0089n4 = this.f1019e;
                        J(c0089n4);
                        c0089n4.t(str2, null, "_sid", b0(c0112vA, str2));
                    } else {
                        C0089n c0089n5 = this.f1019e;
                        J(c0089n5);
                        if (c0089n5.J(str2, "_v")) {
                            C0089n c0089n42 = this.f1019e;
                            J(c0089n42);
                            c0089n42.t(str2, null, "_sid", b0(c0112vA, str2));
                        } else {
                            C0089n c0089n6 = this.f1019e;
                            J(c0089n6);
                            f().getClass();
                            c0089n6.t(str2, Long.valueOf(System.currentTimeMillis() - 15000), "_sid", b0(c0112vA, str2));
                        }
                    }
                }
            }
            C0089n c0089n7 = this.f1019e;
            J(c0089n7);
            q1.E.f(str2);
            c0089n7.j();
            c0089n7.k();
            long j5 = c0112v.f1401m;
            if (j5 < 0) {
                Z z4 = ((C0113v0) c0089n7.f84c).f1417k;
                C0113v0.k(z4);
                z4.f1080k.c(Z.q(str2), Long.valueOf(j5), "Invalid time querying timed out conditional properties");
                listP = Collections.emptyList();
            } else {
                listP = c0089n7.p("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str2, String.valueOf(j5)});
            }
            Iterator it = listP.iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                c0113v0 = this.n;
                if (!zHasNext) {
                    break;
                }
                C0062e c0062e = (C0062e) it.next();
                if (c0062e != null) {
                    c().f1084p.d("User property timed out", c0062e.f1191j, c0113v0.f1420o.f(c0062e.f1193l.f1071k), c0062e.f1193l.a());
                    C0112v c0112v2 = c0062e.f1196p;
                    if (c0112v2 != null) {
                        Y(new C0112v(c0112v2, j5), b2Var);
                    }
                    C0089n c0089n8 = this.f1019e;
                    J(c0089n8);
                    c0089n8.K(str2, c0062e.f1193l.f1071k);
                }
            }
            C0089n c0089n9 = this.f1019e;
            J(c0089n9);
            q1.E.f(str2);
            c0089n9.j();
            c0089n9.k();
            if (j5 < 0) {
                Z z5 = ((C0113v0) c0089n9.f84c).f1417k;
                C0113v0.k(z5);
                z5.f1080k.c(Z.q(str2), Long.valueOf(j5), "Invalid time querying expired conditional properties");
                listP2 = Collections.emptyList();
            } else {
                listP2 = c0089n9.p("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str2, String.valueOf(j5)});
            }
            ArrayList arrayList = new ArrayList(listP2.size());
            Iterator it2 = listP2.iterator();
            while (it2.hasNext()) {
                C0062e c0062e2 = (C0062e) it2.next();
                if (c0062e2 != null) {
                    Iterator it3 = it2;
                    c().f1084p.d("User property expired", c0062e2.f1191j, c0113v0.f1420o.f(c0062e2.f1193l.f1071k), c0062e2.f1193l.a());
                    C0089n c0089n10 = this.f1019e;
                    J(c0089n10);
                    c0089n10.C(str2, c0062e2.f1193l.f1071k);
                    C0112v c0112v3 = c0062e2.f1200t;
                    if (c0112v3 != null) {
                        arrayList.add(c0112v3);
                    }
                    C0089n c0089n11 = this.f1019e;
                    J(c0089n11);
                    c0089n11.K(str2, c0062e2.f1193l.f1071k);
                    it2 = it3;
                }
            }
            Iterator it4 = arrayList.iterator();
            while (it4.hasNext()) {
                Y(new C0112v((C0112v) it4.next(), j5), b2Var);
            }
            C0089n c0089n12 = this.f1019e;
            J(c0089n12);
            q1.E.f(str2);
            q1.E.f(str4);
            c0089n12.j();
            c0089n12.k();
            if (j5 < 0) {
                C0113v0 c0113v02 = (C0113v0) c0089n12.f84c;
                Z z6 = c0113v02.f1417k;
                C0113v0.k(z6);
                z6.f1080k.d("Invalid time querying triggered conditional properties", Z.q(str2), c0113v02.f1420o.d(str4), Long.valueOf(j5));
                listP3 = Collections.emptyList();
            } else {
                listP3 = c0089n12.p("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str2, str4, String.valueOf(j5)});
            }
            ArrayList arrayList2 = new ArrayList(listP3.size());
            for (C0062e c0062e3 : listP3) {
                if (c0062e3 != null) {
                    Y1 y12 = c0062e3.f1193l;
                    String str5 = c0062e3.f1191j;
                    q1.E.i(str5);
                    String str6 = c0062e3.f1192k;
                    String str7 = y12.f1071k;
                    Object objA = y12.a();
                    q1.E.i(objA);
                    Z1 z12 = new Z1(str5, str6, str7, j5, objA);
                    Object obj = z12.f1094e;
                    String str8 = z12.f1092c;
                    C0089n c0089n13 = this.f1019e;
                    J(c0089n13);
                    if (c0089n13.X(z12)) {
                        c().f1084p.d("User property triggered", c0062e3.f1191j, c0113v0.f1420o.f(str8), obj);
                    } else {
                        c().h.d("Too many active user properties, ignoring", Z.q(c0062e3.f1191j), c0113v0.f1420o.f(str8), obj);
                    }
                    C0112v c0112v4 = c0062e3.f1198r;
                    if (c0112v4 != null) {
                        arrayList2.add(c0112v4);
                    }
                    c0062e3.f1193l = new Y1(z12);
                    c0062e3.n = true;
                    C0089n c0089n14 = this.f1019e;
                    J(c0089n14);
                    c0089n14.W(c0062e3);
                }
            }
            Y(c0112vA, b2Var);
            Iterator it5 = arrayList2.iterator();
            while (it5.hasNext()) {
                Y(new C0112v((C0112v) it5.next(), j5), b2Var);
            }
            C0089n c0089n15 = this.f1019e;
            J(c0089n15);
            c0089n15.E();
            C0089n c0089n16 = this.f1019e;
            J(c0089n16);
            c0089n16.y();
        } catch (Throwable th) {
            C0089n c0089n17 = this.f1019e;
            J(c0089n17);
            c0089n17.y();
            throw th;
        }
    }

    public final void p(C0112v c0112v, String str) throws MalformedURLException, URISyntaxException, NumberFormatException, SQLException {
        C0089n c0089n = this.f1019e;
        J(c0089n);
        V vG0 = c0089n.g0(str);
        if (vG0 == null || TextUtils.isEmpty(vG0.e())) {
            c().f1083o.b(str, "No app data available; dropping event");
            return;
        }
        Boolean boolY = y(vG0);
        if (boolY == null) {
            if (!"_ui".equals(c0112v.f1398j)) {
                Z zC = c();
                zC.f1080k.b(Z.q(str), "Could not find package. appId");
            }
        } else if (!boolY.booleanValue()) {
            Z zC2 = c();
            zC2.h.b(Z.q(str), "App version does not match; dropping event. appId");
            return;
        }
        String strG = vG0.g();
        String strE = vG0.e();
        long jS = vG0.S();
        C0113v0 c0113v0 = vG0.f980a;
        C0104s0 c0104s0 = c0113v0.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.j();
        String str2 = vG0.f989l;
        C0104s0 c0104s02 = c0113v0.f1418l;
        C0113v0.k(c0104s02);
        c0104s02.j();
        long j5 = vG0.f990m;
        C0104s0 c0104s03 = c0113v0.f1418l;
        C0113v0.k(c0104s03);
        c0104s03.j();
        long j6 = vG0.n;
        C0104s0 c0104s04 = c0113v0.f1418l;
        C0113v0.k(c0104s04);
        c0104s04.j();
        boolean z4 = vG0.f991o;
        String strF = vG0.f();
        C0104s0 c0104s05 = c0113v0.f1418l;
        C0113v0.k(c0104s05);
        c0104s05.j();
        boolean z5 = vG0.f992p;
        String strA = vG0.a();
        Boolean boolU = vG0.U();
        long jT = vG0.T();
        C0104s0 c0104s06 = c0113v0.f1418l;
        C0113v0.k(c0104s06);
        c0104s06.j();
        ArrayList arrayList = vG0.f996t;
        String strJ = j0(str).j();
        boolean zT = vG0.t();
        C0104s0 c0104s07 = c0113v0.f1418l;
        C0113v0.k(c0104s07);
        c0104s07.j();
        long j7 = vG0.f999w;
        K0 k0J0 = j0(str);
        String str3 = g0(str).f1338b;
        C0104s0 c0104s08 = c0113v0.f1418l;
        C0113v0.k(c0104s08);
        c0104s08.j();
        int i5 = vG0.f1001y;
        C0104s0 c0104s09 = c0113v0.f1418l;
        C0113v0.k(c0104s09);
        c0104s09.j();
        q(c0112v, new b2(str, strG, strE, jS, str2, j5, j6, (String) null, z4, false, strF, 0L, 0, z5, false, strA, boolU, jT, (List) arrayList, (String) null, strJ, "", (String) null, zT, j7, k0J0.f880b, str3, i5, vG0.f963C, vG0.i(), vG0.h(), 0L, vG0.R()));
    }

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x007a: MOVE (r4 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:18:0x007a */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0064 A[PHI: r4 r5
      0x0064: PHI (r4v3 android.os.Bundle) = (r4v7 android.os.Bundle), (r4v5 android.os.Bundle) binds: [B:24:0x008e, B:13:0x0057] A[DONT_GENERATE, DONT_INLINE]
      0x0064: PHI (r5v3 android.database.Cursor) = (r5v5 android.database.Cursor), (r5v7 android.database.Cursor) binds: [B:24:0x008e, B:13:0x0057] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void q(J1.C0112v r10, J1.b2 r11) throws java.net.MalformedURLException, java.net.URISyntaxException, java.lang.NumberFormatException, android.database.SQLException {
        /*
            Method dump skipped, instructions count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.V1.q(J1.v, J1.b2):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0166 A[Catch: all -> 0x005f, TryCatch #1 {all -> 0x005f, blocks: (B:8:0x0030, B:18:0x004e, B:57:0x0169, B:26:0x006c, B:31:0x00c8, B:30:0x00b6, B:32:0x00cd, B:36:0x00de, B:40:0x00f4, B:42:0x010c, B:44:0x0127, B:46:0x0130, B:48:0x0136, B:49:0x013a, B:51:0x0146, B:53:0x014f, B:55:0x015e, B:56:0x0166, B:43:0x0118, B:37:0x00e5, B:39:0x00ee), top: B:66:0x0030, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r(java.lang.String r10, int r11, java.io.IOException r12, byte[] r13, java.util.Map r14) {
        /*
            Method dump skipped, instructions count: 398
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.V1.r(java.lang.String, int, java.io.IOException, byte[], java.util.Map):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0270 A[Catch: SQLiteException -> 0x00b2, all -> 0x028a, TRY_ENTER, TryCatch #3 {SQLiteException -> 0x00b2, blocks: (B:26:0x009f, B:30:0x00b5, B:32:0x00c3, B:35:0x00df, B:98:0x0258, B:101:0x0270, B:103:0x0279, B:105:0x0284, B:115:0x02a6, B:109:0x028d, B:111:0x0296, B:113:0x029c, B:114:0x02a0, B:117:0x02aa, B:118:0x02b2, B:34:0x00d4), top: B:129:0x009f, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x028d A[Catch: SQLiteException -> 0x00b2, all -> 0x028a, TryCatch #3 {SQLiteException -> 0x00b2, blocks: (B:26:0x009f, B:30:0x00b5, B:32:0x00c3, B:35:0x00df, B:98:0x0258, B:101:0x0270, B:103:0x0279, B:105:0x0284, B:115:0x02a6, B:109:0x028d, B:111:0x0296, B:113:0x029c, B:114:0x02a0, B:117:0x02aa, B:118:0x02b2, B:34:0x00d4), top: B:129:0x009f, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006a A[Catch: all -> 0x0011, TryCatch #0 {all -> 0x0011, blocks: (B:4:0x000e, B:17:0x002c, B:22:0x007c, B:21:0x006a, B:26:0x009f, B:32:0x00c3), top: B:125:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008a A[Catch: all -> 0x028a, PHI: r0
      0x008a: PHI (r0v4 int) = (r0v0 int), (r0v36 int) binds: [B:10:0x001f, B:16:0x002a] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x028a, blocks: (B:9:0x0017, B:24:0x008a, B:30:0x00b5, B:35:0x00df, B:98:0x0258, B:101:0x0270, B:103:0x0279, B:105:0x0284, B:115:0x02a6, B:109:0x028d, B:111:0x0296, B:113:0x029c, B:114:0x02a0, B:117:0x02aa, B:118:0x02b2, B:34:0x00d4, B:119:0x02b3, B:26:0x009f, B:32:0x00c3), top: B:130:0x0017, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c3 A[Catch: all -> 0x0011, SQLiteException -> 0x00b2, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0011, blocks: (B:4:0x000e, B:17:0x002c, B:22:0x007c, B:21:0x006a, B:26:0x009f, B:32:0x00c3), top: B:125:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d4 A[Catch: SQLiteException -> 0x00b2, all -> 0x028a, TRY_ENTER, TryCatch #3 {SQLiteException -> 0x00b2, blocks: (B:26:0x009f, B:30:0x00b5, B:32:0x00c3, B:35:0x00df, B:98:0x0258, B:101:0x0270, B:103:0x0279, B:105:0x0284, B:115:0x02a6, B:109:0x028d, B:111:0x0296, B:113:0x029c, B:114:0x02a0, B:117:0x02aa, B:118:0x02b2, B:34:0x00d4), top: B:129:0x009f, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00f5 A[Catch: all -> 0x0173, TryCatch #1 {all -> 0x0173, blocks: (B:36:0x00e7, B:38:0x00f5, B:40:0x0101, B:41:0x010a, B:44:0x0112, B:46:0x0127, B:48:0x0132, B:49:0x0136, B:53:0x0159, B:55:0x0163, B:60:0x0176, B:61:0x017b, B:63:0x0181, B:65:0x0194, B:67:0x01aa, B:68:0x01ae, B:77:0x01f1, B:78:0x01f5, B:80:0x01fb, B:81:0x0202, B:82:0x021d, B:85:0x0229, B:86:0x0230, B:88:0x0232, B:89:0x0242, B:91:0x0244, B:93:0x0248, B:96:0x024f, B:97:0x0250, B:69:0x01bd, B:70:0x01c2, B:72:0x01c8, B:74:0x01e2, B:75:0x01e6), top: B:126:0x00e7, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01fb A[Catch: all -> 0x0173, TRY_LEAVE, TryCatch #1 {all -> 0x0173, blocks: (B:36:0x00e7, B:38:0x00f5, B:40:0x0101, B:41:0x010a, B:44:0x0112, B:46:0x0127, B:48:0x0132, B:49:0x0136, B:53:0x0159, B:55:0x0163, B:60:0x0176, B:61:0x017b, B:63:0x0181, B:65:0x0194, B:67:0x01aa, B:68:0x01ae, B:77:0x01f1, B:78:0x01f5, B:80:0x01fb, B:81:0x0202, B:82:0x021d, B:85:0x0229, B:86:0x0230, B:88:0x0232, B:89:0x0242, B:91:0x0244, B:93:0x0248, B:96:0x024f, B:97:0x0250, B:69:0x01bd, B:70:0x01c2, B:72:0x01c8, B:74:0x01e2, B:75:0x01e6), top: B:126:0x00e7, inners: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void s(boolean r21, int r22, java.io.IOException r23, byte[] r24, java.lang.String r25, java.util.List r26) {
        /*
            Method dump skipped, instructions count: 745
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.V1.s(boolean, int, java.io.IOException, byte[], java.lang.String, java.util.List):void");
    }

    public final long t() {
        f().getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        C0126z1 c0126z1 = this.f1023k;
        c0126z1.k();
        c0126z1.j();
        C0069g0 c0069g0 = c0126z1.f1472l;
        long jA = c0069g0.a();
        if (jA == 0) {
            C0113v0.i(((C0113v0) c0126z1.f84c).n);
            jA = r2.v().nextInt(86400000) + 1;
            c0069g0.b(jA);
        }
        return ((((jCurrentTimeMillis + jA) / 1000) / 60) / 60) / 24;
    }

    public final int w(String str, Z2.c cVar) {
        H0 h0W;
        C0093o0 c0093o0 = this.f1017c;
        com.google.android.gms.internal.measurement.C0 c0X = c0093o0.x(str);
        J0 j02 = J0.AD_PERSONALIZATION;
        if (c0X == null) {
            cVar.v(j02, EnumC0071h.FAILSAFE);
            return 1;
        }
        C0089n c0089n = this.f1019e;
        J(c0089n);
        V vG0 = c0089n.g0(str);
        if (vG0 != null) {
            if (((H0) B0.l.z(vG0.h()).f110d) == H0.POLICY && (h0W = c0093o0.w(str, j02)) != H0.UNINITIALIZED) {
                cVar.v(j02, EnumC0071h.REMOTE_ENFORCED_DEFAULT);
                return h0W == H0.GRANTED ? 0 : 1;
            }
        }
        cVar.v(j02, EnumC0071h.REMOTE_DEFAULT);
        return c0093o0.A(str, j02) ? 0 : 1;
    }

    public final b2 x(String str) {
        C0089n c0089n = this.f1019e;
        J(c0089n);
        V vG0 = c0089n.g0(str);
        if (vG0 == null || TextUtils.isEmpty(vG0.e())) {
            c().f1083o.b(str, "No app data available; dropping");
            return null;
        }
        Boolean boolY = y(vG0);
        if (boolY != null && !boolY.booleanValue()) {
            Z zC = c();
            zC.h.b(Z.q(str), "App version does not match; dropping. appId");
            return null;
        }
        String strG = vG0.g();
        String strE = vG0.e();
        long jS = vG0.S();
        C0113v0 c0113v0 = vG0.f980a;
        C0104s0 c0104s0 = c0113v0.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.j();
        String str2 = vG0.f989l;
        C0104s0 c0104s02 = c0113v0.f1418l;
        C0113v0.k(c0104s02);
        c0104s02.j();
        long j5 = vG0.f990m;
        C0104s0 c0104s03 = c0113v0.f1418l;
        C0113v0.k(c0104s03);
        c0104s03.j();
        long j6 = vG0.n;
        C0104s0 c0104s04 = c0113v0.f1418l;
        C0113v0.k(c0104s04);
        c0104s04.j();
        boolean z4 = vG0.f991o;
        String strF = vG0.f();
        C0104s0 c0104s05 = c0113v0.f1418l;
        C0113v0.k(c0104s05);
        c0104s05.j();
        boolean z5 = vG0.f992p;
        String strA = vG0.a();
        Boolean boolU = vG0.U();
        long jT = vG0.T();
        C0104s0 c0104s06 = c0113v0.f1418l;
        C0113v0.k(c0104s06);
        c0104s06.j();
        ArrayList arrayList = vG0.f996t;
        String strJ = j0(str).j();
        boolean zT = vG0.t();
        C0104s0 c0104s07 = c0113v0.f1418l;
        C0113v0.k(c0104s07);
        c0104s07.j();
        long j7 = vG0.f999w;
        K0 k0J0 = j0(str);
        String str3 = g0(str).f1338b;
        C0104s0 c0104s08 = c0113v0.f1418l;
        C0113v0.k(c0104s08);
        c0104s08.j();
        int i5 = vG0.f1001y;
        C0104s0 c0104s09 = c0113v0.f1418l;
        C0113v0.k(c0104s09);
        c0104s09.j();
        return new b2(str, strG, strE, jS, str2, j5, j6, (String) null, z4, false, strF, 0L, 0, z5, false, strA, boolU, jT, (List) arrayList, (String) null, strJ, "", (String) null, zT, j7, k0J0.f880b, str3, i5, vG0.f963C, vG0.i(), vG0.h(), 0L, vG0.R());
    }

    public final Boolean y(V v4) {
        try {
            long jS = v4.S();
            C0113v0 c0113v0 = this.n;
            if (jS != -2147483648L) {
                if (v4.S() == C0931b.a(c0113v0.f1411c).b(0, v4.c()).versionCode) {
                    return Boolean.TRUE;
                }
            } else {
                String str = C0931b.a(c0113v0.f1411c).b(0, v4.c()).versionName;
                String strE = v4.e();
                if (strE != null && strE.equals(str)) {
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }
}
