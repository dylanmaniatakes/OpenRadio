package J1;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.A2;
import com.google.android.gms.internal.measurement.AbstractC0296a2;
import com.google.android.gms.internal.measurement.AbstractC0306c2;
import com.google.android.gms.internal.measurement.C0295a1;
import com.google.android.gms.internal.measurement.C0298b;
import com.google.android.gms.internal.measurement.C0310d1;
import com.google.android.gms.internal.measurement.C0315e1;
import com.google.android.gms.internal.measurement.C0320f1;
import com.google.android.gms.internal.measurement.C0335i1;
import com.google.android.gms.internal.measurement.C0345k1;
import com.google.android.gms.internal.measurement.C0355m1;
import com.google.android.gms.internal.measurement.C0365o1;
import com.google.android.gms.internal.measurement.C0371p2;
import com.google.android.gms.internal.measurement.C0383s0;
import com.google.android.gms.internal.measurement.C0398v0;
import com.google.android.gms.internal.measurement.C0408x0;
import com.google.android.gms.internal.measurement.C0413y0;
import com.google.android.gms.internal.measurement.InterfaceC0336i2;
import com.google.android.gms.internal.measurement.InterfaceC0341j2;
import com.google.android.gms.internal.measurement.M3;
import com.google.android.gms.internal.measurement.Y3;
import com.google.android.gms.internal.measurement.Z3;
import g0.AbstractC0535a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.zip.GZIPOutputStream;
import r1.C0874b;
import s.AbstractC0882e;

/* renamed from: J1.d0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0060d0 extends Q1 {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f1190f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0060d0(V1 v12, int i5) {
        super(v12);
        this.f1190f = i5;
    }

    public static final void A(StringBuilder sb, String str, C0335i1 c0335i1) {
        if (c0335i1 == null) {
            return;
        }
        w(3, sb);
        sb.append(str);
        sb.append(" {\n");
        if (c0335i1.q() != 0) {
            w(4, sb);
            sb.append("results: ");
            int i5 = 0;
            for (Long l5 : c0335i1.w()) {
                int i6 = i5 + 1;
                if (i5 != 0) {
                    sb.append(", ");
                }
                sb.append(l5);
                i5 = i6;
            }
            sb.append('\n');
        }
        if (c0335i1.s() != 0) {
            w(4, sb);
            sb.append("status: ");
            int i7 = 0;
            for (Long l6 : c0335i1.y()) {
                int i8 = i7 + 1;
                if (i7 != 0) {
                    sb.append(", ");
                }
                sb.append(l6);
                i7 = i8;
            }
            sb.append('\n');
        }
        if (c0335i1.p() != 0) {
            w(4, sb);
            sb.append("dynamic_filter_timestamps: {");
            int i9 = 0;
            for (com.google.android.gms.internal.measurement.V0 v0 : c0335i1.v()) {
                int i10 = i9 + 1;
                if (i9 != 0) {
                    sb.append(", ");
                }
                sb.append(v0.v() ? Integer.valueOf(v0.p()) : null);
                sb.append(":");
                sb.append(v0.u() ? Long.valueOf(v0.q()) : null);
                i9 = i10;
            }
            sb.append("}\n");
        }
        if (c0335i1.r() != 0) {
            w(4, sb);
            sb.append("sequence_filter_timestamps: {");
            int i11 = 0;
            for (C0345k1 c0345k1 : c0335i1.x()) {
                int i12 = i11 + 1;
                if (i11 != 0) {
                    sb.append(", ");
                }
                sb.append(c0345k1.w() ? Integer.valueOf(c0345k1.q()) : null);
                sb.append(": [");
                Iterator it = c0345k1.t().iterator();
                int i13 = 0;
                while (it.hasNext()) {
                    long jLongValue = ((Long) it.next()).longValue();
                    int i14 = i13 + 1;
                    if (i13 != 0) {
                        sb.append(", ");
                    }
                    sb.append(jLongValue);
                    i13 = i14;
                }
                sb.append("]");
                i11 = i12;
            }
            sb.append("}\n");
        }
        w(3, sb);
        sb.append("}\n");
    }

    public static final void B(StringBuilder sb, int i5, String str, Object obj) {
        if (obj == null) {
            return;
        }
        w(i5 + 1, sb);
        sb.append(str);
        sb.append(": ");
        sb.append(obj);
        sb.append('\n');
    }

    public static final void C(StringBuilder sb, int i5, String str, C0398v0 c0398v0) {
        if (c0398v0 == null) {
            return;
        }
        w(i5, sb);
        sb.append(str);
        sb.append(" {\n");
        if (c0398v0.u()) {
            int iZ = c0398v0.z();
            B(sb, i5, "comparison_type", iZ != 1 ? iZ != 2 ? iZ != 3 ? iZ != 4 ? "BETWEEN" : "EQUAL" : "GREATER_THAN" : "LESS_THAN" : "UNKNOWN_COMPARISON_TYPE");
        }
        if (c0398v0.w()) {
            B(sb, i5, "match_as_float", Boolean.valueOf(c0398v0.t()));
        }
        if (c0398v0.v()) {
            B(sb, i5, "comparison_value", c0398v0.q());
        }
        if (c0398v0.y()) {
            B(sb, i5, "min_comparison_value", c0398v0.s());
        }
        if (c0398v0.x()) {
            B(sb, i5, "max_comparison_value", c0398v0.r());
        }
        w(i5, sb);
        sb.append("}\n");
    }

    public static int D(C0315e1 c0315e1, String str) {
        for (int i5 = 0; i5 < ((C0320f1) c0315e1.f4913k).W1(); i5++) {
            if (str.equals(((C0320f1) c0315e1.f4913k).r(i5).u())) {
                return i5;
            }
        }
        return -1;
    }

    private final void E() {
    }

    private final void F() {
    }

    private final void G() {
    }

    public static Bundle K(Map map, boolean z4) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj == null) {
                bundle.putString(str, null);
            } else if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (!(obj instanceof ArrayList)) {
                bundle.putString(str, obj.toString());
            } else if (z4) {
                ArrayList arrayList = (ArrayList) obj;
                ArrayList arrayList2 = new ArrayList();
                int size = arrayList.size();
                for (int i5 = 0; i5 < size; i5++) {
                    arrayList2.add(K((Map) arrayList.get(i5), false));
                }
                bundle.putParcelableArray(str, (Parcelable[]) arrayList2.toArray(new Parcelable[0]));
            }
        }
        return bundle;
    }

    public static C0112v M(C0298b c0298b) {
        Object obj;
        Bundle bundleK = K(c0298b.f4897c, true);
        String string = (!bundleK.containsKey("_o") || (obj = bundleK.get("_o")) == null) ? "app" : obj.toString();
        String strD = L0.d(c0298b.f4895a, L0.f884a, L0.f886c);
        if (strD == null) {
            strD = c0298b.f4895a;
        }
        return new C0112v(strD, new C0109u(bundleK), string, c0298b.f4896b);
    }

    public static AbstractC0306c2 P(AbstractC0306c2 abstractC0306c2, byte[] bArr) {
        com.google.android.gms.internal.measurement.X1 x1O;
        com.google.android.gms.internal.measurement.X1 x12 = com.google.android.gms.internal.measurement.X1.f4800a;
        if (x12 == null) {
            synchronized (com.google.android.gms.internal.measurement.X1.class) {
                try {
                    x1O = com.google.android.gms.internal.measurement.X1.f4800a;
                    if (x1O == null) {
                        A2 a2 = A2.f4649c;
                        x1O = AbstractC0296a2.o();
                        com.google.android.gms.internal.measurement.X1.f4800a = x1O;
                    }
                } finally {
                }
            }
            x12 = x1O;
        }
        if (x12 != null) {
            abstractC0306c2.getClass();
            abstractC0306c2.d(bArr, bArr.length, x12);
            return abstractC0306c2;
        }
        abstractC0306c2.getClass();
        int length = bArr.length;
        com.google.android.gms.internal.measurement.X1 x13 = com.google.android.gms.internal.measurement.X1.f4800a;
        A2 a22 = A2.f4649c;
        abstractC0306c2.d(bArr, length, com.google.android.gms.internal.measurement.X1.f4801b);
        return abstractC0306c2;
    }

    public static ArrayList T(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i5 = 0; i5 < length; i5++) {
            long j5 = 0;
            for (int i6 = 0; i6 < 64; i6++) {
                int i7 = (i5 * 64) + i6;
                if (i7 >= bitSet.length()) {
                    break;
                }
                if (bitSet.get(i7)) {
                    j5 |= 1 << i6;
                }
            }
            arrayList.add(Long.valueOf(j5));
        }
        return arrayList;
    }

    public static HashMap U(Bundle bundle, boolean z4) {
        HashMap map = new HashMap();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            boolean z5 = obj instanceof Parcelable[];
            if (z5 || (obj instanceof ArrayList) || (obj instanceof Bundle)) {
                if (z4) {
                    ArrayList arrayList = new ArrayList();
                    if (z5) {
                        for (Parcelable parcelable : (Parcelable[]) obj) {
                            if (parcelable instanceof Bundle) {
                                arrayList.add(U((Bundle) parcelable, false));
                            }
                        }
                    } else if (obj instanceof ArrayList) {
                        ArrayList arrayList2 = (ArrayList) obj;
                        int size = arrayList2.size();
                        for (int i5 = 0; i5 < size; i5++) {
                            Object obj2 = arrayList2.get(i5);
                            if (obj2 instanceof Bundle) {
                                arrayList.add(U((Bundle) obj2, false));
                            }
                        }
                    } else if (obj instanceof Bundle) {
                        arrayList.add(U((Bundle) obj, false));
                    }
                    map.put(str, arrayList);
                }
            } else if (obj != null) {
                map.put(str, obj);
            }
        }
        return map;
    }

    public static boolean W(InterfaceC0336i2 interfaceC0336i2, int i5) {
        if (i5 < ((C0371p2) interfaceC0336i2).f5017l * 64) {
            return ((1 << (i5 % 64)) & ((Long) ((C0371p2) interfaceC0336i2).get(i5 / 64)).longValue()) != 0;
        }
        return false;
    }

    public static boolean n(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    public static Bundle[] p(InterfaceC0341j2 interfaceC0341j2) {
        ArrayList arrayList = new ArrayList();
        Iterator it = interfaceC0341j2.iterator();
        while (it.hasNext()) {
            C0295a1 c0295a1 = (C0295a1) it.next();
            if (c0295a1 != null) {
                Bundle bundle = new Bundle();
                for (C0295a1 c0295a12 : c0295a1.w()) {
                    if (c0295a12.L()) {
                        bundle.putString(c0295a12.u(), c0295a12.v());
                    } else if (c0295a12.J()) {
                        bundle.putLong(c0295a12.u(), c0295a12.s());
                    } else if (c0295a12.H()) {
                        bundle.putDouble(c0295a12.u(), c0295a12.p());
                    }
                }
                if (!bundle.isEmpty()) {
                    arrayList.add(bundle);
                }
            }
        }
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    public static final void q(com.google.android.gms.internal.measurement.W0 w02, String str, Object obj) {
        List listN = w02.n();
        int i5 = 0;
        while (true) {
            if (i5 >= listN.size()) {
                i5 = -1;
                break;
            } else if (str.equals(((C0295a1) listN.get(i5)).u())) {
                break;
            } else {
                i5++;
            }
        }
        com.google.android.gms.internal.measurement.Z0 z0T = C0295a1.t();
        z0T.i(str);
        z0T.h(((Long) obj).longValue());
        if (i5 < 0) {
            w02.j(z0T);
        } else {
            w02.g();
            com.google.android.gms.internal.measurement.X0.C((com.google.android.gms.internal.measurement.X0) w02.f4913k, i5, (C0295a1) z0T.e());
        }
    }

    public static final Bundle r(List list) {
        Bundle bundle = new Bundle();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C0295a1 c0295a1 = (C0295a1) it.next();
            String strU = c0295a1.u();
            if (c0295a1.H()) {
                bundle.putDouble(strU, c0295a1.p());
            } else if (c0295a1.I()) {
                bundle.putFloat(strU, c0295a1.q());
            } else if (c0295a1.L()) {
                bundle.putString(strU, c0295a1.v());
            } else if (c0295a1.J()) {
                bundle.putLong(strU, c0295a1.s());
            }
        }
        return bundle;
    }

    public static final C0295a1 s(com.google.android.gms.internal.measurement.X0 x02, String str) {
        for (C0295a1 c0295a1 : x02.w()) {
            if (c0295a1.u().equals(str)) {
                return c0295a1;
            }
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [android.os.Bundle[], java.io.Serializable] */
    public static final Serializable t(com.google.android.gms.internal.measurement.X0 x02, String str) {
        C0295a1 c0295a1S = s(x02, str);
        if (c0295a1S == null) {
            return null;
        }
        if (c0295a1S.L()) {
            return c0295a1S.v();
        }
        if (c0295a1S.J()) {
            return Long.valueOf(c0295a1S.s());
        }
        if (c0295a1S.H()) {
            return Double.valueOf(c0295a1S.p());
        }
        if (c0295a1S.r() > 0) {
            return p((InterfaceC0341j2) c0295a1S.w());
        }
        return null;
    }

    public static final void w(int i5, StringBuilder sb) {
        for (int i6 = 0; i6 < i5; i6++) {
            sb.append("  ");
        }
    }

    public static final void x(Uri.Builder builder, String str, String str2, Set set) {
        if (set.contains(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        builder.appendQueryParameter(str, str2);
    }

    public static final String y(boolean z4, boolean z5, boolean z6) {
        StringBuilder sb = new StringBuilder();
        if (z4) {
            sb.append("Dynamic ");
        }
        if (z5) {
            sb.append("Sequence ");
        }
        if (z6) {
            sb.append("Session-Scoped ");
        }
        return sb.toString();
    }

    public static final void z(Uri.Builder builder, String[] strArr, Bundle bundle, Set set) {
        for (String str : strArr) {
            String[] strArrSplit = str.split(",");
            String str2 = strArrSplit[0];
            String str3 = strArrSplit[strArrSplit.length - 1];
            String string = bundle.getString(str2);
            if (string != null) {
                x(builder, str3, string, set);
            }
        }
    }

    public void H(String str, R1 r12, C0310d1 c0310d1, InterfaceC0054b0 interfaceC0054b0) {
        String str2 = r12.f940a;
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        j();
        k();
        try {
            URL url = new URI(str2).toURL();
            this.f902d.b();
            byte[] bArrC = c0310d1.c();
            C0104s0 c0104s0 = c0113v0.f1418l;
            C0113v0.k(c0104s0);
            Map mapEmptyMap = r12.f941b;
            if (mapEmptyMap == null) {
                mapEmptyMap = Collections.emptyMap();
            }
            c0104s0.s(new RunnableC0057c0(this, str, url, bArrC, mapEmptyMap, interfaceC0054b0));
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused) {
            Z z4 = c0113v0.f1417k;
            C0113v0.k(z4);
            z4.h.c(Z.q(str), str2, "Failed to parse URL. Not uploading MeasurementBatch. appId");
        }
    }

    public boolean I() {
        k();
        ConnectivityManager connectivityManager = (ConnectivityManager) ((C0113v0) this.f84c).f1411c.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = null;
        if (connectivityManager != null) {
            try {
                activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (SecurityException unused) {
            }
        }
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public long J(byte[] bArr) {
        q1.E.i(bArr);
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        a2 a2Var = c0113v0.n;
        C0113v0.i(a2Var);
        a2Var.j();
        MessageDigest messageDigestU = a2.u();
        if (messageDigestU != null) {
            return a2.t0(messageDigestU.digest(bArr));
        }
        Z z4 = c0113v0.f1417k;
        C0113v0.k(z4);
        z4.h.a("Failed to get MD5");
        return 0L;
    }

    public Parcelable L(byte[] bArr, Parcelable.Creator creator) {
        Parcelable parcelable = null;
        if (bArr == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                parcelObtain.unmarshall(bArr, 0, bArr.length);
                parcelObtain.setDataPosition(0);
                parcelable = (Parcelable) creator.createFromParcel(parcelObtain);
            } catch (C0874b unused) {
                Z z4 = ((C0113v0) this.f84c).f1417k;
                C0113v0.k(z4);
                z4.h.a("Failed to load parcelable from buffer");
            }
            return parcelable;
        } finally {
            parcelObtain.recycle();
        }
    }

    public K1 N(String str, C0315e1 c0315e1, com.google.android.gms.internal.measurement.W0 w02, String str2) {
        int iIndexOf;
        M3.b();
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        if (!c0113v0.f1415i.w(str, H.f787V0)) {
            return null;
        }
        c0113v0.f1421p.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        G g = H.f848t0;
        C0068g c0068g = c0113v0.f1415i;
        String[] strArrSplit = c0068g.v(str, g).split(",");
        HashSet hashSet = new HashSet(strArrSplit.length);
        for (String str3 : strArrSplit) {
            Objects.requireNonNull(str3);
            if (!hashSet.add(str3)) {
                throw new IllegalArgumentException("duplicate element: ".concat(str3));
            }
        }
        Set setUnmodifiableSet = Collections.unmodifiableSet(hashSet);
        V1 v12 = this.f902d;
        S1 s12 = v12.f1024l;
        C0093o0 c0093o0 = s12.f902d.f1017c;
        V1.J(c0093o0);
        String strZ = c0093o0.z(str);
        Uri.Builder builder = new Uri.Builder();
        C0113v0 c0113v02 = (C0113v0) s12.f84c;
        builder.scheme(c0113v02.f1415i.v(str, H.f829m0));
        boolean zIsEmpty = TextUtils.isEmpty(strZ);
        C0068g c0068g2 = c0113v02.f1415i;
        if (zIsEmpty) {
            builder.authority(c0068g2.v(str, H.f831n0));
        } else {
            builder.authority(strZ + "." + c0068g2.v(str, H.f831n0));
        }
        builder.path(c0068g2.v(str, H.f834o0));
        x(builder, "gmp_app_id", ((C0320f1) c0315e1.f4913k).D(), setUnmodifiableSet);
        c0068g.q();
        x(builder, "gmp_version", String.valueOf(119002L), setUnmodifiableSet);
        String strU = ((C0320f1) c0315e1.f4913k).u();
        G g5 = H.f793Y0;
        boolean zW = c0068g.w(str, g5);
        C0093o0 c0093o02 = v12.f1017c;
        if (zW) {
            V1.J(c0093o02);
            if (c0093o02.n(str)) {
                strU = "";
            }
        }
        x(builder, "app_instance_id", strU, setUnmodifiableSet);
        x(builder, "rdid", ((C0320f1) c0315e1.f4913k).H(), setUnmodifiableSet);
        x(builder, "bundle_id", c0315e1.l(), setUnmodifiableSet);
        String strM = w02.m();
        String strD = L0.d(strM, L0.f886c, L0.f884a);
        if (true != TextUtils.isEmpty(strD)) {
            strM = strD;
        }
        x(builder, "app_event_name", strM, setUnmodifiableSet);
        x(builder, "app_version", String.valueOf(((C0320f1) c0315e1.f4913k).O0()), setUnmodifiableSet);
        String strF = ((C0320f1) c0315e1.f4913k).F();
        if (c0068g.w(str, g5)) {
            V1.J(c0093o02);
            if (c0093o02.o(str) && !TextUtils.isEmpty(strF) && (iIndexOf = strF.indexOf(".")) != -1) {
                strF = strF.substring(0, iIndexOf);
            }
        }
        x(builder, "os_version", strF, setUnmodifiableSet);
        x(builder, "timestamp", String.valueOf(w02.i()), setUnmodifiableSet);
        if (((C0320f1) c0315e1.f4913k).J1()) {
            x(builder, "lat", "1", setUnmodifiableSet);
        }
        x(builder, "privacy_sandbox_version", String.valueOf(((C0320f1) c0315e1.f4913k).O()), setUnmodifiableSet);
        x(builder, "trigger_uri_source", "1", setUnmodifiableSet);
        x(builder, "trigger_uri_timestamp", String.valueOf(jCurrentTimeMillis), setUnmodifiableSet);
        x(builder, "request_uuid", str2, setUnmodifiableSet);
        List<C0295a1> listN = w02.n();
        Bundle bundle = new Bundle();
        for (C0295a1 c0295a1 : listN) {
            String strU2 = c0295a1.u();
            if (c0295a1.H()) {
                bundle.putString(strU2, String.valueOf(c0295a1.p()));
            } else if (c0295a1.I()) {
                bundle.putString(strU2, String.valueOf(c0295a1.q()));
            } else if (c0295a1.L()) {
                bundle.putString(strU2, c0295a1.v());
            } else if (c0295a1.J()) {
                bundle.putString(strU2, String.valueOf(c0295a1.s()));
            }
        }
        z(builder, c0068g.v(str, H.f846s0).split("\\|"), bundle, setUnmodifiableSet);
        List<C0365o1> listUnmodifiableList = Collections.unmodifiableList(((C0320f1) c0315e1.f4913k).M());
        Bundle bundle2 = new Bundle();
        for (C0365o1 c0365o1 : listUnmodifiableList) {
            String strU3 = c0365o1.u();
            if (c0365o1.E()) {
                bundle2.putString(strU3, String.valueOf(c0365o1.p()));
            } else if (c0365o1.F()) {
                bundle2.putString(strU3, String.valueOf(c0365o1.q()));
            } else if (c0365o1.I()) {
                bundle2.putString(strU3, c0365o1.v());
            } else if (c0365o1.G()) {
                bundle2.putString(strU3, String.valueOf(c0365o1.r()));
            }
        }
        z(builder, c0068g.v(str, H.f843r0).split("\\|"), bundle2, setUnmodifiableSet);
        x(builder, "dma", true != ((C0320f1) c0315e1.f4913k).I1() ? "0" : "1", setUnmodifiableSet);
        if (!((C0320f1) c0315e1.f4913k).z().isEmpty()) {
            x(builder, "dma_cps", ((C0320f1) c0315e1.f4913k).z(), setUnmodifiableSet);
        }
        if (((C0320f1) c0315e1.f4913k).L1()) {
            com.google.android.gms.internal.measurement.O0 o0J2 = ((C0320f1) c0315e1.f4913k).j2();
            if (!o0J2.D().isEmpty()) {
                x(builder, "dl_gclid", o0J2.D(), setUnmodifiableSet);
            }
            if (!o0J2.C().isEmpty()) {
                x(builder, "dl_gbraid", o0J2.C(), setUnmodifiableSet);
            }
            if (!o0J2.B().isEmpty()) {
                x(builder, "dl_gs", o0J2.B(), setUnmodifiableSet);
            }
            if (o0J2.x() > 0) {
                x(builder, "dl_ss_ts", String.valueOf(o0J2.x()), setUnmodifiableSet);
            }
            if (!o0J2.G().isEmpty()) {
                x(builder, "mr_gclid", o0J2.G(), setUnmodifiableSet);
            }
            if (!o0J2.F().isEmpty()) {
                x(builder, "mr_gbraid", o0J2.F(), setUnmodifiableSet);
            }
            if (!o0J2.E().isEmpty()) {
                x(builder, "mr_gs", o0J2.E(), setUnmodifiableSet);
            }
            if (o0J2.y() > 0) {
                x(builder, "mr_click_ts", String.valueOf(o0J2.y()), setUnmodifiableSet);
            }
        }
        return new K1(1, builder.build().toString(), jCurrentTimeMillis);
    }

    public com.google.android.gms.internal.measurement.X0 O(r rVar) {
        Bundle bundle;
        com.google.android.gms.internal.measurement.W0 w0T = com.google.android.gms.internal.measurement.X0.t();
        w0T.g();
        com.google.android.gms.internal.measurement.X0.D(rVar.f1361e, (com.google.android.gms.internal.measurement.X0) w0T.f4913k);
        C0109u c0109u = rVar.f1362f;
        Iterator<String> it = c0109u.f1395j.keySet().iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            bundle = c0109u.f1395j;
            if (!zHasNext) {
                break;
            }
            String next = it.next();
            com.google.android.gms.internal.measurement.Z0 z0T = C0295a1.t();
            z0T.i(next);
            Object obj = bundle.get(next);
            q1.E.i(obj);
            V(z0T, obj);
            w0T.j(z0T);
        }
        String str = rVar.f1359c;
        if (!TextUtils.isEmpty(str) && bundle.get("_o") == null) {
            com.google.android.gms.internal.measurement.Z0 z0T2 = C0295a1.t();
            z0T2.i("_o");
            z0T2.j(str);
            w0T.k((C0295a1) z0T2.e());
        }
        return (com.google.android.gms.internal.measurement.X0) w0T.e();
    }

    public String Q(C0310d1 c0310d1) {
        com.google.android.gms.internal.measurement.R0 r0K2;
        StringBuilder sbB = AbstractC0882e.b("\nbatch {\n");
        if (c0310d1.D()) {
            B(sbB, 0, "upload_subdomain", c0310d1.u());
        }
        if (c0310d1.C()) {
            B(sbB, 0, "sgtm_join_id", c0310d1.t());
        }
        for (C0320f1 c0320f1 : c0310d1.v()) {
            if (c0320f1 != null) {
                w(1, sbB);
                sbB.append("bundle {\n");
                if (c0320f1.f1()) {
                    B(sbB, 1, "protocol_version", Integer.valueOf(c0320f1.T1()));
                }
                ((Z3) Y3.f4877k.f4878j.f10447j).getClass();
                C0113v0 c0113v0 = (C0113v0) this.f84c;
                if (c0113v0.f1415i.w(c0320f1.t(), H.f769L0) && c0320f1.i1()) {
                    B(sbB, 1, "session_stitching_token", c0320f1.I());
                }
                B(sbB, 1, "platform", c0320f1.G());
                if (c0320f1.a1()) {
                    B(sbB, 1, "gmp_version", Long.valueOf(c0320f1.c2()));
                }
                if (c0320f1.o1()) {
                    B(sbB, 1, "uploading_gmp_version", Long.valueOf(c0320f1.i2()));
                }
                if (c0320f1.Y0()) {
                    B(sbB, 1, "dynamite_version", Long.valueOf(c0320f1.a2()));
                }
                if (c0320f1.R0()) {
                    B(sbB, 1, "config_version", Long.valueOf(c0320f1.Y1()));
                }
                B(sbB, 1, "gmp_app_id", c0320f1.D());
                B(sbB, 1, "admob_app_id", c0320f1.s());
                B(sbB, 1, "app_id", c0320f1.t());
                B(sbB, 1, "app_version", c0320f1.w());
                if (c0320f1.M1()) {
                    B(sbB, 1, "app_version_major", Integer.valueOf(c0320f1.O0()));
                }
                B(sbB, 1, "firebase_instance_id", c0320f1.C());
                if (c0320f1.W0()) {
                    B(sbB, 1, "dev_cert_hash", Long.valueOf(c0320f1.Z1()));
                }
                B(sbB, 1, "app_store", c0320f1.v());
                if (c0320f1.n1()) {
                    B(sbB, 1, "upload_timestamp_millis", Long.valueOf(c0320f1.h2()));
                }
                if (c0320f1.k1()) {
                    B(sbB, 1, "start_timestamp_millis", Long.valueOf(c0320f1.f2()));
                }
                if (c0320f1.Z0()) {
                    B(sbB, 1, "end_timestamp_millis", Long.valueOf(c0320f1.b2()));
                }
                if (c0320f1.e1()) {
                    B(sbB, 1, "previous_bundle_start_timestamp_millis", Long.valueOf(c0320f1.e2()));
                }
                if (c0320f1.d1()) {
                    B(sbB, 1, "previous_bundle_end_timestamp_millis", Long.valueOf(c0320f1.d2()));
                }
                B(sbB, 1, "app_instance_id", c0320f1.u());
                B(sbB, 1, "resettable_device_id", c0320f1.H());
                B(sbB, 1, "ds_id", c0320f1.B());
                if (c0320f1.c1()) {
                    B(sbB, 1, "limited_ad_tracking", Boolean.valueOf(c0320f1.J1()));
                }
                B(sbB, 1, "os_version", c0320f1.F());
                B(sbB, 1, "device_model", c0320f1.A());
                B(sbB, 1, "user_default_language", c0320f1.J());
                if (c0320f1.m1()) {
                    B(sbB, 1, "time_zone_offset_minutes", Integer.valueOf(c0320f1.V1()));
                }
                if (c0320f1.Q0()) {
                    B(sbB, 1, "bundle_sequential_index", Integer.valueOf(c0320f1.O1()));
                }
                if (c0320f1.V0()) {
                    B(sbB, 1, "delivery_index", Integer.valueOf(c0320f1.R1()));
                }
                if (c0320f1.h1()) {
                    B(sbB, 1, "service_upload", Boolean.valueOf(c0320f1.K1()));
                }
                B(sbB, 1, "health_monitor", c0320f1.E());
                if (c0320f1.g1()) {
                    B(sbB, 1, "retry_counter", Integer.valueOf(c0320f1.U1()));
                }
                if (c0320f1.T0()) {
                    B(sbB, 1, "consent_signals", c0320f1.y());
                }
                if (c0320f1.b1()) {
                    B(sbB, 1, "is_dma_region", Boolean.valueOf(c0320f1.I1()));
                }
                if (c0320f1.U0()) {
                    B(sbB, 1, "core_platform_services", c0320f1.z());
                }
                if (c0320f1.S0()) {
                    B(sbB, 1, "consent_diagnostics", c0320f1.x());
                }
                if (c0320f1.l1()) {
                    B(sbB, 1, "target_os_version", Long.valueOf(c0320f1.g2()));
                }
                M3.b();
                if (c0113v0.f1415i.w(c0320f1.t(), H.f787V0)) {
                    B(sbB, 1, "ad_services_version", Integer.valueOf(c0320f1.O()));
                    if (c0320f1.N1() && (r0K2 = c0320f1.k2()) != null) {
                        w(2, sbB);
                        sbB.append("attribution_eligibility_status {\n");
                        B(sbB, 2, "eligible", Boolean.valueOf(r0K2.A()));
                        B(sbB, 2, "no_access_adservices_attribution_permission", Boolean.valueOf(r0K2.C()));
                        B(sbB, 2, "pre_r", Boolean.valueOf(r0K2.D()));
                        B(sbB, 2, "r_extensions_too_old", Boolean.valueOf(r0K2.E()));
                        B(sbB, 2, "adservices_extension_too_old", Boolean.valueOf(r0K2.z()));
                        B(sbB, 2, "ad_storage_not_allowed", Boolean.valueOf(r0K2.y()));
                        B(sbB, 2, "measurement_manager_disabled", Boolean.valueOf(r0K2.B()));
                        w(2, sbB);
                        sbB.append("}\n");
                    }
                }
                if (c0320f1.L1()) {
                    com.google.android.gms.internal.measurement.O0 o0J2 = c0320f1.j2();
                    w(2, sbB);
                    sbB.append("ad_campaign_info {\n");
                    if (o0J2.r()) {
                        B(sbB, 2, "deep_link_gclid", o0J2.D());
                    }
                    if (o0J2.q()) {
                        B(sbB, 2, "deep_link_gbraid", o0J2.C());
                    }
                    if (o0J2.p()) {
                        B(sbB, 2, "deep_link_gad_source", o0J2.B());
                    }
                    if (o0J2.s()) {
                        B(sbB, 2, "deep_link_session_millis", Long.valueOf(o0J2.x()));
                    }
                    if (o0J2.w()) {
                        B(sbB, 2, "market_referrer_gclid", o0J2.G());
                    }
                    if (o0J2.v()) {
                        B(sbB, 2, "market_referrer_gbraid", o0J2.F());
                    }
                    if (o0J2.u()) {
                        B(sbB, 2, "market_referrer_gad_source", o0J2.E());
                    }
                    if (o0J2.t()) {
                        B(sbB, 2, "market_referrer_click_millis", Long.valueOf(o0J2.y()));
                    }
                    w(2, sbB);
                    sbB.append("}\n");
                }
                if (c0320f1.P0()) {
                    B(sbB, 1, "batching_timestamp_millis", Long.valueOf(c0320f1.X1()));
                }
                if (c0320f1.j1()) {
                    C0355m1 c0355m1Q = c0320f1.q();
                    w(2, sbB);
                    sbB.append("sgtm_diagnostics {\n");
                    int iU = c0355m1Q.u();
                    B(sbB, 2, "upload_type", iU != 1 ? iU != 2 ? iU != 3 ? iU != 4 ? "SDK_SERVICE_UPLOAD" : "PACKAGE_SERVICE_UPLOAD" : "SDK_CLIENT_UPLOAD" : "GA_UPLOAD" : "UPLOAD_TYPE_UNKNOWN");
                    B(sbB, 2, "client_upload_eligibility", AbstractC0535a.w(c0355m1Q.q()));
                    int iT = c0355m1Q.t();
                    B(sbB, 2, "service_upload_eligibility", iT != 1 ? iT != 2 ? iT != 3 ? iT != 4 ? iT != 5 ? "NON_PLAY_MISSING_SGTM_SERVER_URL" : "MISSING_SGTM_PROXY_INFO" : "MISSING_SGTM_SETTINGS" : "NOT_IN_ROLLOUT" : "SERVICE_UPLOAD_ELIGIBLE" : "SERVICE_UPLOAD_ELIGIBILITY_UNKNOWN");
                    w(2, sbB);
                    sbB.append("}\n");
                }
                InterfaceC0341j2<C0365o1> interfaceC0341j2M = c0320f1.M();
                S s4 = c0113v0.f1420o;
                if (interfaceC0341j2M != null) {
                    for (C0365o1 c0365o1 : interfaceC0341j2M) {
                        if (c0365o1 != null) {
                            w(2, sbB);
                            sbB.append("user_property {\n");
                            B(sbB, 2, "set_timestamp_millis", c0365o1.H() ? Long.valueOf(c0365o1.s()) : null);
                            B(sbB, 2, "name", s4.f(c0365o1.u()));
                            B(sbB, 2, "string_value", c0365o1.v());
                            B(sbB, 2, "int_value", c0365o1.G() ? Long.valueOf(c0365o1.r()) : null);
                            B(sbB, 2, "double_value", c0365o1.E() ? Double.valueOf(c0365o1.p()) : null);
                            w(2, sbB);
                            sbB.append("}\n");
                        }
                    }
                }
                InterfaceC0341j2<com.google.android.gms.internal.measurement.T0> interfaceC0341j2K = c0320f1.K();
                if (interfaceC0341j2K != null) {
                    for (com.google.android.gms.internal.measurement.T0 t02 : interfaceC0341j2K) {
                        if (t02 != null) {
                            w(2, sbB);
                            sbB.append("audience_membership {\n");
                            if (t02.y()) {
                                B(sbB, 2, "audience_id", Integer.valueOf(t02.p()));
                            }
                            if (t02.z()) {
                                B(sbB, 2, "new_audience", Boolean.valueOf(t02.x()));
                            }
                            A(sbB, "current_data", t02.r());
                            if (t02.A()) {
                                A(sbB, "previous_data", t02.s());
                            }
                            w(2, sbB);
                            sbB.append("}\n");
                        }
                    }
                }
                InterfaceC0341j2<com.google.android.gms.internal.measurement.X0> interfaceC0341j2L = c0320f1.L();
                if (interfaceC0341j2L != null) {
                    for (com.google.android.gms.internal.measurement.X0 x02 : interfaceC0341j2L) {
                        if (x02 != null) {
                            w(2, sbB);
                            sbB.append("event {\n");
                            B(sbB, 2, "name", s4.d(x02.v()));
                            if (x02.H()) {
                                B(sbB, 2, "timestamp_millis", Long.valueOf(x02.s()));
                            }
                            if (x02.G()) {
                                B(sbB, 2, "previous_timestamp_millis", Long.valueOf(x02.r()));
                            }
                            if (x02.F()) {
                                B(sbB, 2, "count", Integer.valueOf(x02.p()));
                            }
                            if (x02.q() != 0) {
                                u(sbB, 2, (InterfaceC0341j2) x02.w());
                            }
                            w(2, sbB);
                            sbB.append("}\n");
                        }
                    }
                }
                w(1, sbB);
                sbB.append("}\n");
            }
        }
        sbB.append("} // End-of-batch\n");
        return sbB.toString();
    }

    public String R(C0408x0 c0408x0) {
        StringBuilder sbB = AbstractC0882e.b("\nproperty_filter {\n");
        if (c0408x0.x()) {
            B(sbB, 0, "filter_id", Integer.valueOf(c0408x0.p()));
        }
        B(sbB, 0, "property_name", ((C0113v0) this.f84c).f1420o.f(c0408x0.s()));
        String strY = y(c0408x0.u(), c0408x0.v(), c0408x0.w());
        if (!strY.isEmpty()) {
            B(sbB, 0, "filter_type", strY);
        }
        v(sbB, 1, c0408x0.q());
        sbB.append("}\n");
        return sbB.toString();
    }

    public List S(InterfaceC0336i2 interfaceC0336i2, List list) {
        int i5;
        ArrayList arrayList = new ArrayList(interfaceC0336i2);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            int iIntValue = num.intValue();
            C0113v0 c0113v0 = (C0113v0) this.f84c;
            if (iIntValue < 0) {
                Z z4 = c0113v0.f1417k;
                C0113v0.k(z4);
                z4.f1080k.b(num, "Ignoring negative bit index to be cleared");
            } else {
                int iIntValue2 = num.intValue() / 64;
                if (iIntValue2 >= arrayList.size()) {
                    Z z5 = c0113v0.f1417k;
                    C0113v0.k(z5);
                    z5.f1080k.c(num, Integer.valueOf(arrayList.size()), "Ignoring bit index greater than bitSet size");
                } else {
                    arrayList.set(iIntValue2, Long.valueOf(((Long) arrayList.get(iIntValue2)).longValue() & (~(1 << (num.intValue() % 64)))));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        while (true) {
            int i6 = size2;
            i5 = size;
            size = i6;
            if (size < 0 || ((Long) arrayList.get(size)).longValue() != 0) {
                break;
            }
            size2 = size - 1;
        }
        return arrayList.subList(0, i5);
    }

    public void V(com.google.android.gms.internal.measurement.Z0 z0, Object obj) {
        z0.g();
        C0295a1.C((C0295a1) z0.f4913k);
        z0.g();
        C0295a1.A((C0295a1) z0.f4913k);
        z0.g();
        C0295a1.z((C0295a1) z0.f4913k);
        z0.g();
        C0295a1.B((C0295a1) z0.f4913k);
        if (obj instanceof String) {
            z0.j((String) obj);
            return;
        }
        if (obj instanceof Long) {
            z0.h(((Long) obj).longValue());
            return;
        }
        if (obj instanceof Double) {
            double dDoubleValue = ((Double) obj).doubleValue();
            z0.g();
            C0295a1.D((C0295a1) z0.f4913k, dDoubleValue);
            return;
        }
        if (!(obj instanceof Bundle[])) {
            Z z4 = ((C0113v0) this.f84c).f1417k;
            C0113v0.k(z4);
            z4.h.b(obj, "Ignoring invalid (type) event param value");
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Bundle bundle : (Bundle[]) obj) {
            if (bundle != null) {
                com.google.android.gms.internal.measurement.Z0 z0T = C0295a1.t();
                for (String str : bundle.keySet()) {
                    com.google.android.gms.internal.measurement.Z0 z0T2 = C0295a1.t();
                    z0T2.i(str);
                    Object obj2 = bundle.get(str);
                    if (obj2 instanceof Long) {
                        z0T2.h(((Long) obj2).longValue());
                    } else if (obj2 instanceof String) {
                        z0T2.j((String) obj2);
                    } else if (obj2 instanceof Double) {
                        double dDoubleValue2 = ((Double) obj2).doubleValue();
                        z0T2.g();
                        C0295a1.D((C0295a1) z0T2.f4913k, dDoubleValue2);
                    }
                    z0T.g();
                    C0295a1.y((C0295a1) z0T.f4913k, (C0295a1) z0T2.e());
                }
                if (((C0295a1) z0T.f4913k).r() > 0) {
                    arrayList.add((C0295a1) z0T.e());
                }
            }
        }
        z0.g();
        C0295a1.x((C0295a1) z0.f4913k, arrayList);
    }

    public boolean X(long j5, long j6) {
        if (j5 == 0 || j6 <= 0) {
            return true;
        }
        ((C0113v0) this.f84c).f1421p.getClass();
        return Math.abs(System.currentTimeMillis() - j5) > j6;
    }

    @Override // J1.Q1
    public final void m() {
        int i5 = this.f1190f;
    }

    public byte[] o(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e5) {
            Z z4 = ((C0113v0) this.f84c).f1417k;
            C0113v0.k(z4);
            z4.h.b(e5, "Failed to gzip content");
            throw e5;
        }
    }

    public void u(StringBuilder sb, int i5, InterfaceC0341j2 interfaceC0341j2) {
        if (interfaceC0341j2 == null) {
            return;
        }
        int i6 = i5 + 1;
        Iterator it = interfaceC0341j2.iterator();
        while (it.hasNext()) {
            C0295a1 c0295a1 = (C0295a1) it.next();
            if (c0295a1 != null) {
                w(i6, sb);
                sb.append("param {\n");
                B(sb, i6, "name", c0295a1.K() ? ((C0113v0) this.f84c).f1420o.e(c0295a1.u()) : null);
                B(sb, i6, "string_value", c0295a1.L() ? c0295a1.v() : null);
                B(sb, i6, "int_value", c0295a1.J() ? Long.valueOf(c0295a1.s()) : null);
                B(sb, i6, "double_value", c0295a1.H() ? Double.valueOf(c0295a1.p()) : null);
                if (c0295a1.r() > 0) {
                    u(sb, i6, (InterfaceC0341j2) c0295a1.w());
                }
                w(i6, sb);
                sb.append("}\n");
            }
        }
    }

    public void v(StringBuilder sb, int i5, C0383s0 c0383s0) {
        String str;
        if (c0383s0 == null) {
            return;
        }
        w(i5, sb);
        sb.append("filter {\n");
        if (c0383s0.v()) {
            B(sb, i5, "complement", Boolean.valueOf(c0383s0.u()));
        }
        if (c0383s0.x()) {
            B(sb, i5, "param_name", ((C0113v0) this.f84c).f1420o.e(c0383s0.s()));
        }
        if (c0383s0.y()) {
            int i6 = i5 + 1;
            C0413y0 c0413y0R = c0383s0.r();
            if (c0413y0R != null) {
                w(i6, sb);
                sb.append("string_filter {\n");
                if (c0413y0R.w()) {
                    switch (c0413y0R.x()) {
                        case 1:
                            str = "UNKNOWN_MATCH_TYPE";
                            break;
                        case 2:
                            str = "REGEXP";
                            break;
                        case 3:
                            str = "BEGINS_WITH";
                            break;
                        case 4:
                            str = "ENDS_WITH";
                            break;
                        case 5:
                            str = "PARTIAL";
                            break;
                        case 6:
                            str = "EXACT";
                            break;
                        default:
                            str = "IN_LIST";
                            break;
                    }
                    B(sb, i6, "match_type", str);
                }
                if (c0413y0R.v()) {
                    B(sb, i6, "expression", c0413y0R.r());
                }
                if (c0413y0R.u()) {
                    B(sb, i6, "case_sensitive", Boolean.valueOf(c0413y0R.t()));
                }
                if (c0413y0R.p() > 0) {
                    w(i5 + 2, sb);
                    sb.append("expression_list {\n");
                    for (String str2 : c0413y0R.s()) {
                        w(i5 + 3, sb);
                        sb.append(str2);
                        sb.append("\n");
                    }
                    sb.append("}\n");
                }
                w(i6, sb);
                sb.append("}\n");
            }
        }
        if (c0383s0.w()) {
            C(sb, i5 + 1, "number_filter", c0383s0.q());
        }
        w(i5, sb);
        sb.append("}\n");
    }
}
