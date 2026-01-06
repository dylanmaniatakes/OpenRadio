package J1;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import f0.C0473a;
import f0.C0474b;
import g0.AbstractC0535a;
import h0.C0556d;
import i0.AbstractC0568e;
import i0.C0565b;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;
import n1.AbstractC0791h;
import n1.C0789f;
import org.conscrypt.PSKKeyManager;
import w1.C0931b;

/* loaded from: classes.dex */
public final class a2 extends F0 {

    /* renamed from: k, reason: collision with root package name */
    public static final String[] f1108k = {"firebase_", "google_", "ga_"};

    /* renamed from: l, reason: collision with root package name */
    public static final String[] f1109l = {"_err"};

    /* renamed from: e, reason: collision with root package name */
    public SecureRandom f1110e;

    /* renamed from: f, reason: collision with root package name */
    public final AtomicLong f1111f;
    public int g;
    public C0556d h;

    /* renamed from: i, reason: collision with root package name */
    public Boolean f1112i;

    /* renamed from: j, reason: collision with root package name */
    public Integer f1113j;

    public a2(C0113v0 c0113v0) {
        super(c0113v0);
        this.f1113j = null;
        this.f1111f = new AtomicLong(0L);
    }

    public static void D(L0.l lVar, String str, int i5, String str2, String str3, int i6) {
        Bundle bundle = new Bundle();
        l0(i5, bundle);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (i5 == 6 || i5 == 7 || i5 == 2) {
            bundle.putLong("_el", i6);
        }
        lVar.u(str, "_err", bundle);
    }

    public static boolean P(String str, String[] strArr) {
        q1.E.i(strArr);
        for (String str2 : strArr) {
            if (Objects.equals(str, str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean S(String str) {
        String str2 = (String) H.f840q0.a(null);
        return str2.equals("*") || Arrays.asList(str2.split(",")).contains(str);
    }

    public static boolean b0(Object obj) {
        return (obj instanceof Parcelable[]) || (obj instanceof ArrayList) || (obj instanceof Bundle);
    }

    public static boolean e0(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    public static boolean f0(String str) {
        q1.E.f(str);
        return str.charAt(0) != '_' || str.equals("_ep");
    }

    public static boolean g0(Context context) {
        ActivityInfo receiverInfo;
        q1.E.i(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) != null) {
                if (receiverInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public static boolean h0(Context context) {
        ServiceInfo serviceInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementJobService"), 0)) != null) {
                if (serviceInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public static byte[] k0(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(parcelObtain, 0);
            return parcelObtain.marshall();
        } finally {
            parcelObtain.recycle();
        }
    }

    public static final boolean l0(int i5, Bundle bundle) {
        if (bundle == null || bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", i5);
        return true;
    }

    public static String t(int i5, String str, boolean z4) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) <= i5) {
            return str;
        }
        if (z4) {
            return String.valueOf(str.substring(0, str.offsetByCodePoints(0, i5))).concat("...");
        }
        return null;
    }

    public static long t0(byte[] bArr) {
        q1.E.i(bArr);
        int length = bArr.length;
        if (length <= 0) {
            throw new IllegalStateException();
        }
        int i5 = 0;
        long j5 = 0;
        for (int i6 = length - 1; i6 >= 0 && i6 >= bArr.length - 8; i6--) {
            j5 += (bArr[i6] & 255) << i5;
            i5 += 8;
        }
        return j5;
    }

    public static MessageDigest u() {
        MessageDigest messageDigest;
        for (int i5 = 0; i5 < 2; i5++) {
            try {
                messageDigest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException unused) {
            }
            if (messageDigest != null) {
                return messageDigest;
            }
        }
        return null;
    }

    public static ArrayList w(List list) {
        if (list == null) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C0062e c0062e = (C0062e) it.next();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", c0062e.f1191j);
            bundle.putString("origin", c0062e.f1192k);
            bundle.putLong("creation_timestamp", c0062e.f1194m);
            bundle.putString("name", c0062e.f1193l.f1071k);
            Object objA = c0062e.f1193l.a();
            q1.E.i(objA);
            L0.f(bundle, objA);
            bundle.putBoolean("active", c0062e.n);
            String str = c0062e.f1195o;
            if (str != null) {
                bundle.putString("trigger_event_name", str);
            }
            C0112v c0112v = c0062e.f1196p;
            if (c0112v != null) {
                bundle.putString("timed_out_event_name", c0112v.f1398j);
                C0109u c0109u = c0112v.f1399k;
                if (c0109u != null) {
                    bundle.putBundle("timed_out_event_params", c0109u.a());
                }
            }
            bundle.putLong("trigger_timeout", c0062e.f1197q);
            C0112v c0112v2 = c0062e.f1198r;
            if (c0112v2 != null) {
                bundle.putString("triggered_event_name", c0112v2.f1398j);
                C0109u c0109u2 = c0112v2.f1399k;
                if (c0109u2 != null) {
                    bundle.putBundle("triggered_event_params", c0109u2.a());
                }
            }
            bundle.putLong("triggered_timestamp", c0062e.f1193l.f1072l);
            bundle.putLong("time_to_live", c0062e.f1199s);
            C0112v c0112v3 = c0062e.f1200t;
            if (c0112v3 != null) {
                bundle.putString("expired_event_name", c0112v3.f1398j);
                C0109u c0109u3 = c0112v3.f1399k;
                if (c0109u3 != null) {
                    bundle.putBundle("expired_event_params", c0109u3.a());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    public static void z(C0082k1 c0082k1, Bundle bundle, boolean z4) {
        if (bundle != null && c0082k1 != null) {
            if (!bundle.containsKey("_sc") || z4) {
                String str = c0082k1.f1282a;
                if (str != null) {
                    bundle.putString("_sn", str);
                } else {
                    bundle.remove("_sn");
                }
                String str2 = c0082k1.f1283b;
                if (str2 != null) {
                    bundle.putString("_sc", str2);
                } else {
                    bundle.remove("_sc");
                }
                bundle.putLong("_si", c0082k1.f1284c);
                return;
            }
            z4 = false;
        }
        if (bundle != null && c0082k1 == null && z4) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    public final void A(Bundle bundle, Bundle bundle2) {
        if (bundle2 == null) {
            return;
        }
        for (String str : bundle2.keySet()) {
            if (!bundle.containsKey(str)) {
                a2 a2Var = ((C0113v0) this.f84c).n;
                C0113v0.i(a2Var);
                a2Var.E(bundle, str, bundle2.get(str));
            }
        }
    }

    public final void B(Parcelable[] parcelableArr, int i5) {
        q1.E.i(parcelableArr);
        for (Parcelable parcelable : parcelableArr) {
            Bundle bundle = (Bundle) parcelable;
            Iterator it = new TreeSet(bundle.keySet()).iterator();
            int i6 = 0;
            boolean z4 = false;
            while (it.hasNext()) {
                String str = (String) it.next();
                if (f0(str) && !P(str, L0.h) && (i6 = i6 + 1) > i5) {
                    C0113v0 c0113v0 = (C0113v0) this.f84c;
                    if (!c0113v0.f1415i.w(null, H.f844r1) || !z4) {
                        Z z5 = c0113v0.f1417k;
                        C0113v0.k(z5);
                        S s4 = c0113v0.f1420o;
                        z5.f1079j.c(s4.e(str), s4.b(bundle), "Param can't contain more than " + i5 + " item-scoped custom parameters");
                    }
                    l0(28, bundle);
                    bundle.remove(str);
                    z4 = true;
                }
            }
        }
    }

    public final void C(C0051a0 c0051a0, int i5) {
        Bundle bundle = (Bundle) c0051a0.f1103e;
        Iterator it = new TreeSet(bundle.keySet()).iterator();
        int i6 = 0;
        boolean z4 = false;
        while (it.hasNext()) {
            String str = (String) it.next();
            if (f0(str) && (i6 = i6 + 1) > i5) {
                C0113v0 c0113v0 = (C0113v0) this.f84c;
                if (!c0113v0.f1415i.w(null, H.f844r1) || !z4) {
                    String strJ = AbstractC0535a.j("Event can't contain more than ", i5, " params");
                    Z z5 = c0113v0.f1417k;
                    C0113v0.k(z5);
                    S s4 = c0113v0.f1420o;
                    z5.f1079j.c(s4.d((String) c0051a0.f1101c), s4.b(bundle), strJ);
                    l0(5, bundle);
                }
                bundle.remove(str);
                z4 = true;
            }
        }
    }

    public final void E(Bundle bundle, String str, Object obj) {
        if (bundle == null) {
            return;
        }
        if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof String) {
            bundle.putString(str, String.valueOf(obj));
            return;
        }
        if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof Bundle[]) {
            bundle.putParcelableArray(str, (Bundle[]) obj);
            return;
        }
        if (str != null) {
            String simpleName = obj != null ? obj.getClass().getSimpleName() : null;
            C0113v0 c0113v0 = (C0113v0) this.f84c;
            Z z4 = c0113v0.f1417k;
            C0113v0.k(z4);
            z4.f1082m.c(c0113v0.f1420o.e(str), simpleName, "Not putting event parameter. Invalid value type. name, type");
        }
    }

    public final void F(com.google.android.gms.internal.measurement.M m5, boolean z4) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("r", z4);
        try {
            m5.q(bundle);
        } catch (RemoteException e5) {
            Z z5 = ((C0113v0) this.f84c).f1417k;
            C0113v0.k(z5);
            z5.f1080k.b(e5, "Error returning boolean value to wrapper");
        }
    }

    public final void G(com.google.android.gms.internal.measurement.M m5, ArrayList arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("r", arrayList);
        try {
            m5.q(bundle);
        } catch (RemoteException e5) {
            Z z4 = ((C0113v0) this.f84c).f1417k;
            C0113v0.k(z4);
            z4.f1080k.b(e5, "Error returning bundle list to wrapper");
        }
    }

    public final void H(com.google.android.gms.internal.measurement.M m5, Bundle bundle) {
        try {
            m5.q(bundle);
        } catch (RemoteException e5) {
            Z z4 = ((C0113v0) this.f84c).f1417k;
            C0113v0.k(z4);
            z4.f1080k.b(e5, "Error returning bundle value to wrapper");
        }
    }

    public final void I(com.google.android.gms.internal.measurement.M m5, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("r", bArr);
        try {
            m5.q(bundle);
        } catch (RemoteException e5) {
            Z z4 = ((C0113v0) this.f84c).f1417k;
            C0113v0.k(z4);
            z4.f1080k.b(e5, "Error returning byte array to wrapper");
        }
    }

    public final void J(com.google.android.gms.internal.measurement.M m5, int i5) {
        Bundle bundle = new Bundle();
        bundle.putInt("r", i5);
        try {
            m5.q(bundle);
        } catch (RemoteException e5) {
            Z z4 = ((C0113v0) this.f84c).f1417k;
            C0113v0.k(z4);
            z4.f1080k.b(e5, "Error returning int value to wrapper");
        }
    }

    public final void K(com.google.android.gms.internal.measurement.M m5, long j5) {
        Bundle bundle = new Bundle();
        bundle.putLong("r", j5);
        try {
            m5.q(bundle);
        } catch (RemoteException e5) {
            Z z4 = ((C0113v0) this.f84c).f1417k;
            C0113v0.k(z4);
            z4.f1080k.b(e5, "Error returning long value to wrapper");
        }
    }

    public final void L(String str, com.google.android.gms.internal.measurement.M m5) {
        Bundle bundle = new Bundle();
        bundle.putString("r", str);
        try {
            m5.q(bundle);
        } catch (RemoteException e5) {
            Z z4 = ((C0113v0) this.f84c).f1417k;
            C0113v0.k(z4);
            z4.f1080k.b(e5, "Error returning string value to wrapper");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int M(java.lang.String r14, java.lang.String r15, java.lang.Object r16, android.os.Bundle r17, java.util.List r18, boolean r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 339
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.a2.M(java.lang.String, java.lang.String, java.lang.Object, android.os.Bundle, java.util.List, boolean, boolean):int");
    }

    public final int N(String str) {
        boolean zEquals = "_ldl".equals(str);
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        if (zEquals) {
            c0113v0.getClass();
            return 2048;
        }
        if ("_id".equals(str)) {
            c0113v0.getClass();
            return PSKKeyManager.MAX_KEY_LENGTH_BYTES;
        }
        if ("_lgclid".equals(str)) {
            c0113v0.getClass();
            return 100;
        }
        c0113v0.getClass();
        return 36;
    }

    public final Object O(int i5, Object obj, boolean z4, boolean z5) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf(((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf(((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(true != ((Boolean) obj).booleanValue() ? 0L : 1L);
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
            return t(i5, obj.toString(), z4);
        }
        if (!z5 || (!(obj instanceof Bundle[]) && !(obj instanceof Parcelable[]))) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Parcelable parcelable : (Parcelable[]) obj) {
            if (parcelable instanceof Bundle) {
                Bundle bundleW0 = w0((Bundle) parcelable);
                if (!bundleW0.isEmpty()) {
                    arrayList.add(bundleW0);
                }
            }
        }
        return arrayList.toArray(new Bundle[arrayList.size()]);
    }

    public final void Q() {
        j();
        SecureRandom secureRandom = new SecureRandom();
        long jNextLong = secureRandom.nextLong();
        if (jNextLong == 0) {
            jNextLong = secureRandom.nextLong();
            if (jNextLong == 0) {
                Z z4 = ((C0113v0) this.f84c).f1417k;
                C0113v0.k(z4);
                z4.f1080k.a("Utils falling back to Random for random id");
            }
        }
        this.f1111f.set(jNextLong);
    }

    public final void R(String str, String str2, Bundle bundle, List list, boolean z4) {
        int iP0;
        int i5;
        Z z5;
        String str3;
        int iM;
        if (bundle == null) {
            return;
        }
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        a2 a2Var = ((C0113v0) c0113v0.f1415i.f84c).n;
        C0113v0.i(a2Var);
        int i6 = true != a2Var.d0(231100000) ? 0 : 35;
        Iterator it = new TreeSet(bundle.keySet()).iterator();
        int i7 = 0;
        boolean z6 = false;
        while (it.hasNext()) {
            String str4 = (String) it.next();
            if (list == null || !list.contains(str4)) {
                iP0 = !z4 ? p0(str4) : 0;
                if (iP0 == 0) {
                    iP0 = o0(str4);
                }
            } else {
                iP0 = 0;
            }
            if (iP0 != 0) {
                y(bundle, iP0, str4, iP0 == 3 ? str4 : null);
                bundle.remove(str4);
                i5 = i6;
            } else {
                boolean zB0 = b0(bundle.get(str4));
                Z z7 = c0113v0.f1417k;
                if (zB0) {
                    C0113v0.k(z7);
                    z7.f1082m.d("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", str, str2, str4);
                    iM = 22;
                    z5 = z7;
                    str3 = str4;
                    i5 = i6;
                } else {
                    z5 = z7;
                    str3 = str4;
                    i5 = i6;
                    iM = M(str, str4, bundle.get(str4), bundle, list, z4, false);
                }
                if (iM != 0 && !"_ev".equals(str3)) {
                    y(bundle, iM, str3, bundle.get(str3));
                    bundle.remove(str3);
                } else if (f0(str3) && !P(str3, L0.h)) {
                    int i8 = i7 + 1;
                    boolean zD0 = d0(231100000);
                    S s4 = c0113v0.f1420o;
                    if (zD0) {
                        Z z8 = z5;
                        if (i8 > i5) {
                            if (!c0113v0.f1415i.w(null, H.f844r1) || !z6) {
                                C0113v0.k(z8);
                                z8.f1079j.c(s4.d(str), s4.b(bundle), "Item can't contain more than " + i5 + " item-scoped custom params");
                            }
                            l0(28, bundle);
                            bundle.remove(str3);
                            i7 = i8;
                            i6 = i5;
                            z6 = true;
                        }
                    } else {
                        C0113v0.k(z5);
                        z5.f1079j.c(s4.d(str), s4.b(bundle), "Item array not supported on client's version of Google Play Services (Android Only)");
                        l0(23, bundle);
                        bundle.remove(str3);
                    }
                    i7 = i8;
                }
            }
            i6 = i5;
        }
    }

    public final boolean T(String str, String str2) {
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        boolean zW = c0113v0.f1415i.w(null, H.f838p1);
        String str3 = c0113v0.f1412d;
        Z z4 = c0113v0.f1417k;
        if (zW) {
            if (TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str3)) {
                    C0113v0.k(z4);
                    z4.f1079j.a("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
                    return false;
                }
            } else {
                if (j0(str)) {
                    return true;
                }
                if (TextUtils.isEmpty(str3)) {
                    C0113v0.k(z4);
                    z4.f1079j.b(Z.q(str), "Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id");
                    return false;
                }
            }
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str2)) {
                if (TextUtils.isEmpty(str3)) {
                    C0113v0.k(z4);
                    z4.f1079j.a("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
                }
                return false;
            }
            if (!j0(str2)) {
                C0113v0.k(z4);
                z4.f1079j.b(Z.q(str2), "Invalid admob_app_id. Analytics disabled.");
                return false;
            }
        } else if (!j0(str)) {
            if (TextUtils.isEmpty(str3)) {
                C0113v0.k(z4);
                z4.f1079j.b(Z.q(str), "Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id");
            }
            return false;
        }
        return true;
    }

    public final boolean U(String str, int i5, String str2) {
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        if (str2 == null) {
            Z z4 = c0113v0.f1417k;
            C0113v0.k(z4);
            z4.f1079j.b(str, "Name is required and can't be null. Type");
            return false;
        }
        if (str2.codePointCount(0, str2.length()) <= i5) {
            return true;
        }
        Z z5 = c0113v0.f1417k;
        C0113v0.k(z5);
        z5.f1079j.d("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i5), str2);
        return false;
    }

    public final boolean V(String str, String[] strArr, String[] strArr2, String str2) {
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        if (str2 == null) {
            Z z4 = c0113v0.f1417k;
            C0113v0.k(z4);
            z4.f1079j.b(str, "Name is required and can't be null. Type");
            return false;
        }
        String[] strArr3 = f1108k;
        for (int i5 = 0; i5 < 3; i5++) {
            if (str2.startsWith(strArr3[i5])) {
                Z z5 = c0113v0.f1417k;
                C0113v0.k(z5);
                z5.f1079j.c(str, str2, "Name starts with reserved prefix. Type, name");
                return false;
            }
        }
        if (strArr == null || !P(str2, strArr)) {
            return true;
        }
        if (strArr2 != null && P(str2, strArr2)) {
            return true;
        }
        Z z6 = c0113v0.f1417k;
        C0113v0.k(z6);
        z6.f1079j.c(str, str2, "Name is reserved. Type, name");
        return false;
    }

    public final boolean W(String str, String str2, int i5, Object obj) {
        if (obj != null && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                return false;
            }
            String string = obj.toString();
            if (string.codePointCount(0, string.length()) > i5) {
                Z z4 = ((C0113v0) this.f84c).f1417k;
                C0113v0.k(z4);
                z4.f1082m.d("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(string.length()));
                return false;
            }
        }
        return true;
    }

    public final boolean X(String str, String str2) {
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        if (str2 == null) {
            Z z4 = c0113v0.f1417k;
            C0113v0.k(z4);
            z4.f1079j.b(str, "Name is required and can't be null. Type");
            return false;
        }
        if (str2.length() == 0) {
            Z z5 = c0113v0.f1417k;
            C0113v0.k(z5);
            z5.f1079j.b(str, "Name is required and can't be empty. Type");
            return false;
        }
        int iCodePointAt = str2.codePointAt(0);
        if (!Character.isLetter(iCodePointAt)) {
            if (iCodePointAt != 95) {
                Z z6 = c0113v0.f1417k;
                C0113v0.k(z6);
                z6.f1079j.c(str, str2, "Name must start with a letter or _ (underscore). Type, name");
                return false;
            }
            iCodePointAt = 95;
        }
        int length = str2.length();
        int iCharCount = Character.charCount(iCodePointAt);
        while (iCharCount < length) {
            int iCodePointAt2 = str2.codePointAt(iCharCount);
            if (iCodePointAt2 != 95 && !Character.isLetterOrDigit(iCodePointAt2)) {
                Z z7 = c0113v0.f1417k;
                C0113v0.k(z7);
                z7.f1079j.c(str, str2, "Name must consist of letters, digits or _ (underscores). Type, name");
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt2);
        }
        return true;
    }

    public final boolean Y(String str, String str2) {
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        if (str2 == null) {
            Z z4 = c0113v0.f1417k;
            C0113v0.k(z4);
            z4.f1079j.b(str, "Name is required and can't be null. Type");
            return false;
        }
        if (str2.length() == 0) {
            Z z5 = c0113v0.f1417k;
            C0113v0.k(z5);
            z5.f1079j.b(str, "Name is required and can't be empty. Type");
            return false;
        }
        int iCodePointAt = str2.codePointAt(0);
        if (!Character.isLetter(iCodePointAt)) {
            Z z6 = c0113v0.f1417k;
            C0113v0.k(z6);
            z6.f1079j.c(str, str2, "Name must start with a letter. Type, name");
            return false;
        }
        int length = str2.length();
        int iCharCount = Character.charCount(iCodePointAt);
        while (iCharCount < length) {
            int iCodePointAt2 = str2.codePointAt(iCharCount);
            if (iCodePointAt2 != 95 && !Character.isLetterOrDigit(iCodePointAt2)) {
                Z z7 = c0113v0.f1417k;
                C0113v0.k(z7);
                z7.f1079j.c(str, str2, "Name must consist of letters, digits or _ (underscores). Type, name");
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt2);
        }
        return true;
    }

    public final boolean Z(String str) {
        j();
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        if (C0931b.a(c0113v0.f1411c).f707a.checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        Z z4 = c0113v0.f1417k;
        C0113v0.k(z4);
        z4.f1083o.b(str, "Permission not granted");
        return false;
    }

    public final boolean a0(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            return true;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return ((C0113v0) this.f84c).f1415i.n("debug.firebase.analytics.app").equals(str);
    }

    public final boolean c0(Context context, String str) {
        Signature[] signatureArr;
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfoB = C0931b.a(context).b(64, str);
            if (packageInfoB == null || (signatureArr = packageInfoB.signatures) == null || signatureArr.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (PackageManager.NameNotFoundException e5) {
            Z z4 = c0113v0.f1417k;
            C0113v0.k(z4);
            z4.h.b(e5, "Package name not found");
            return true;
        } catch (CertificateException e6) {
            Z z5 = c0113v0.f1417k;
            C0113v0.k(z5);
            z5.h.b(e6, "Error obtaining certificate");
            return true;
        }
    }

    public final boolean d0(int i5) {
        Boolean bool = ((C0113v0) this.f84c).r().g;
        if (r0() < i5 / 1000) {
            return (bool == null || bool.booleanValue()) ? false : true;
        }
        return true;
    }

    public final boolean i0(String str, String str2, String str3, String str4) {
        if (((C0113v0) this.f84c).f1415i.w(null, H.f838p1)) {
            boolean zIsEmpty = TextUtils.isEmpty(str);
            boolean zIsEmpty2 = TextUtils.isEmpty(str2);
            if (!zIsEmpty && !zIsEmpty2) {
                q1.E.i(str);
                if (!str.equals(str2)) {
                    return true;
                }
            }
            return false;
        }
        boolean zIsEmpty3 = TextUtils.isEmpty(str);
        boolean zIsEmpty4 = TextUtils.isEmpty(str2);
        if (!zIsEmpty3 && !zIsEmpty4) {
            q1.E.i(str);
            return !str.equals(str2);
        }
        if (zIsEmpty3 && zIsEmpty4) {
            return (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) ? !TextUtils.isEmpty(str4) : !str3.equals(str4);
        }
        if (zIsEmpty3) {
            return TextUtils.isEmpty(str3) || !str3.equals(str4);
        }
        if (TextUtils.isEmpty(str4)) {
            return false;
        }
        return TextUtils.isEmpty(str3) || !str3.equals(str4);
    }

    public final boolean j0(String str) {
        q1.E.i(str);
        return str.matches(true != ((C0113v0) this.f84c).f1415i.w(null, H.f838p1) ? "^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$" : "^1:\\d+:android:[a-f0-9]+$");
    }

    @Override // J1.F0
    public final boolean k() {
        return true;
    }

    public final int m0(Object obj, String str) {
        return "_ldl".equals(str) ? W("user property referrer", str, N(str), obj) : W("user property", str, N(str), obj) ? 0 : 7;
    }

    public final Bundle n(String str, Bundle bundle, List list, boolean z4) {
        int iP0;
        int i5;
        List list2 = list;
        boolean zP = P(str, L0.f887d);
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = new Bundle(bundle);
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        a2 a2Var = ((C0113v0) c0113v0.f1415i.f84c).n;
        C0113v0.i(a2Var);
        int i6 = a2Var.d0(201500000) ? 100 : 25;
        Iterator it = new TreeSet(bundle.keySet()).iterator();
        int i7 = 0;
        boolean z5 = false;
        while (it.hasNext()) {
            String str2 = (String) it.next();
            if (list2 == null || !list2.contains(str2)) {
                iP0 = !z4 ? p0(str2) : 0;
                if (iP0 == 0) {
                    iP0 = o0(str2);
                }
            } else {
                iP0 = 0;
            }
            if (iP0 != 0) {
                y(bundle2, iP0, str2, iP0 == 3 ? str2 : null);
                bundle2.remove(str2);
                i5 = i6;
            } else {
                i5 = i6;
                int iM = M(str, str2, bundle.get(str2), bundle2, list, z4, zP);
                if (iM == 17) {
                    y(bundle2, 17, str2, Boolean.FALSE);
                } else if (iM != 0 && !"_ev".equals(str2)) {
                    y(bundle2, iM, iM == 21 ? str : str2, bundle.get(str2));
                    bundle2.remove(str2);
                }
                if (f0(str2)) {
                    int i8 = i7 + 1;
                    if (i8 > i5) {
                        if (!c0113v0.f1415i.w(null, H.f844r1) || !z5) {
                            String strJ = AbstractC0535a.j("Event can't contain more than ", i5, " params");
                            Z z6 = c0113v0.f1417k;
                            C0113v0.k(z6);
                            S s4 = c0113v0.f1420o;
                            z6.f1079j.c(s4.d(str), s4.b(bundle), strJ);
                        }
                        l0(5, bundle2);
                        bundle2.remove(str2);
                        z5 = true;
                    }
                    i7 = i8;
                }
                i6 = i5;
                list2 = list;
            }
            i6 = i5;
            list2 = list;
        }
        return bundle2;
    }

    public final int n0(String str) {
        if (!X("event", str)) {
            return 2;
        }
        if (!V("event", L0.f884a, L0.f885b, str)) {
            return 13;
        }
        ((C0113v0) this.f84c).getClass();
        return !U("event", 40, str) ? 2 : 0;
    }

    public final C0556d o() {
        AbstractC0568e c0565b;
        Object objInvoke;
        if (this.h == null) {
            Context context = ((C0113v0) this.f84c).f1411c;
            F3.i.f(context, "context");
            StringBuilder sb = new StringBuilder("AdServicesInfo.version=");
            int i5 = Build.VERSION.SDK_INT;
            C0474b c0474b = C0474b.f6442a;
            sb.append(i5 >= 33 ? c0474b.a() : 0);
            Log.d("MeasurementManager", sb.toString());
            if ((i5 >= 33 ? c0474b.a() : 0) >= 5) {
                Object systemService = context.getSystemService((Class<Object>) AbstractC0110u0.f());
                F3.i.e(systemService, "context.getSystemService…ementManager::class.java)");
                c0565b = new C0565b(AbstractC0110u0.b(systemService));
            } else {
                C0473a c0473a = C0473a.f6441a;
                if (((i5 == 31 || i5 == 32) ? c0473a.a() : 0) >= 9) {
                    try {
                        objInvoke = new C0.m(3, context).invoke(context);
                    } catch (NoClassDefFoundError unused) {
                        StringBuilder sb2 = new StringBuilder("Unable to find adservices code, check manifest for uses-library tag, versionS=");
                        int i6 = Build.VERSION.SDK_INT;
                        sb2.append((i6 == 31 || i6 == 32) ? c0473a.a() : 0);
                        Log.d("MeasurementManager", sb2.toString());
                        objInvoke = null;
                    }
                    c0565b = (AbstractC0568e) objInvoke;
                } else {
                    c0565b = null;
                }
            }
            this.h = c0565b != null ? new C0556d(c0565b) : null;
        }
        return this.h;
    }

    public final int o0(String str) {
        if (!X("event param", str)) {
            return 3;
        }
        if (!V("event param", null, null, str)) {
            return 14;
        }
        ((C0113v0) this.f84c).getClass();
        return !U("event param", 40, str) ? 3 : 0;
    }

    public final C0112v p(String str, Bundle bundle, String str2, long j5, boolean z4) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (n0(str) != 0) {
            C0113v0 c0113v0 = (C0113v0) this.f84c;
            Z z5 = c0113v0.f1417k;
            C0113v0.k(z5);
            z5.h.b(c0113v0.f1420o.f(str), "Invalid conditional property event name");
            throw new IllegalArgumentException();
        }
        Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        bundle2.putString("_o", str2);
        Bundle bundleN = n(str, bundle2, Collections.singletonList("_o"), true);
        if (z4) {
            bundleN = w0(bundleN);
        }
        q1.E.i(bundleN);
        return new C0112v(str, new C0109u(bundleN), str2, j5);
    }

    public final int p0(String str) {
        if (!Y("event param", str)) {
            return 3;
        }
        if (!V("event param", null, null, str)) {
            return 14;
        }
        ((C0113v0) this.f84c).getClass();
        return !U("event param", 40, str) ? 3 : 0;
    }

    public final Object q(Object obj, String str) {
        boolean zEquals = "_ev".equals(str);
        int iMax = 500;
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        if (zEquals) {
            c0113v0.f1415i.getClass();
            return O(Math.max(500, PSKKeyManager.MAX_KEY_LENGTH_BYTES), obj, true, true);
        }
        if (e0(str)) {
            c0113v0.f1415i.getClass();
            iMax = Math.max(500, PSKKeyManager.MAX_KEY_LENGTH_BYTES);
        } else {
            c0113v0.f1415i.getClass();
        }
        return O(iMax, obj, false, true);
    }

    public final int q0(String str) {
        if (!X("user property", str)) {
            return 6;
        }
        if (!V("user property", L0.f890i, null, str)) {
            return 15;
        }
        ((C0113v0) this.f84c).getClass();
        return !U("user property", 24, str) ? 6 : 0;
    }

    public final Object r(Object obj, String str) {
        return "_ldl".equals(str) ? O(N(str), obj, true, false) : O(N(str), obj, false, false);
    }

    public final int r0() {
        if (this.f1113j == null) {
            C0789f c0789f = C0789f.f8740b;
            Context context = ((C0113v0) this.f84c).f1411c;
            c0789f.getClass();
            int i5 = AbstractC0791h.f8746e;
            int i6 = 0;
            try {
                i6 = context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            }
            this.f1113j = Integer.valueOf(i6 / 1000);
        }
        return this.f1113j.intValue();
    }

    public final String s() {
        byte[] bArr = new byte[16];
        v().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c7 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long s0() {
        /*
            Method dump skipped, instructions count: 200
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.a2.s0():long");
    }

    public final long u0() {
        long andIncrement;
        long j5;
        AtomicLong atomicLong = this.f1111f;
        if (atomicLong.get() != 0) {
            AtomicLong atomicLong2 = this.f1111f;
            synchronized (atomicLong2) {
                atomicLong2.compareAndSet(-1L, 1L);
                andIncrement = atomicLong2.getAndIncrement();
            }
            return andIncrement;
        }
        synchronized (atomicLong) {
            long jNanoTime = System.nanoTime();
            ((C0113v0) this.f84c).f1421p.getClass();
            long jNextLong = new Random(jNanoTime ^ System.currentTimeMillis()).nextLong();
            int i5 = this.g + 1;
            this.g = i5;
            j5 = jNextLong + i5;
        }
        return j5;
    }

    public final SecureRandom v() {
        j();
        if (this.f1110e == null) {
            this.f1110e = new SecureRandom();
        }
        return this.f1110e;
    }

    public final Bundle v0(Uri uri) {
        String queryParameter;
        String queryParameter2;
        String queryParameter3;
        String queryParameter4;
        String queryParameter5;
        String queryParameter6;
        String queryParameter7;
        String queryParameter8;
        String queryParameter9;
        String str;
        if (uri == null) {
            return null;
        }
        try {
            if (uri.isHierarchical()) {
                queryParameter = uri.getQueryParameter("utm_campaign");
                queryParameter2 = uri.getQueryParameter("utm_source");
                queryParameter3 = uri.getQueryParameter("utm_medium");
                queryParameter4 = uri.getQueryParameter("gclid");
                queryParameter5 = uri.getQueryParameter("gbraid");
                queryParameter6 = uri.getQueryParameter("utm_id");
                queryParameter7 = uri.getQueryParameter("dclid");
                queryParameter8 = uri.getQueryParameter("srsltid");
                queryParameter9 = uri.getQueryParameter("sfmc_id");
            } else {
                queryParameter = null;
                queryParameter2 = null;
                queryParameter3 = null;
                queryParameter4 = null;
                queryParameter5 = null;
                queryParameter6 = null;
                queryParameter7 = null;
                queryParameter8 = null;
                queryParameter9 = null;
            }
            if (TextUtils.isEmpty(queryParameter) && TextUtils.isEmpty(queryParameter2) && TextUtils.isEmpty(queryParameter3) && TextUtils.isEmpty(queryParameter4) && TextUtils.isEmpty(queryParameter5) && TextUtils.isEmpty(queryParameter6) && TextUtils.isEmpty(queryParameter7) && TextUtils.isEmpty(queryParameter8) && TextUtils.isEmpty(queryParameter9)) {
                return null;
            }
            Bundle bundle = new Bundle();
            if (TextUtils.isEmpty(queryParameter)) {
                str = "sfmc_id";
            } else {
                str = "sfmc_id";
                bundle.putString("campaign", queryParameter);
            }
            if (!TextUtils.isEmpty(queryParameter2)) {
                bundle.putString("source", queryParameter2);
            }
            if (!TextUtils.isEmpty(queryParameter3)) {
                bundle.putString("medium", queryParameter3);
            }
            if (!TextUtils.isEmpty(queryParameter4)) {
                bundle.putString("gclid", queryParameter4);
            }
            if (!TextUtils.isEmpty(queryParameter5)) {
                bundle.putString("gbraid", queryParameter5);
            }
            String queryParameter10 = uri.getQueryParameter("gad_source");
            if (!TextUtils.isEmpty(queryParameter10)) {
                bundle.putString("gad_source", queryParameter10);
            }
            String queryParameter11 = uri.getQueryParameter("utm_term");
            if (!TextUtils.isEmpty(queryParameter11)) {
                bundle.putString("term", queryParameter11);
            }
            String queryParameter12 = uri.getQueryParameter("utm_content");
            if (!TextUtils.isEmpty(queryParameter12)) {
                bundle.putString("content", queryParameter12);
            }
            String queryParameter13 = uri.getQueryParameter("aclid");
            if (!TextUtils.isEmpty(queryParameter13)) {
                bundle.putString("aclid", queryParameter13);
            }
            String queryParameter14 = uri.getQueryParameter("cp1");
            if (!TextUtils.isEmpty(queryParameter14)) {
                bundle.putString("cp1", queryParameter14);
            }
            String queryParameter15 = uri.getQueryParameter("anid");
            if (!TextUtils.isEmpty(queryParameter15)) {
                bundle.putString("anid", queryParameter15);
            }
            if (!TextUtils.isEmpty(queryParameter6)) {
                bundle.putString("campaign_id", queryParameter6);
            }
            if (!TextUtils.isEmpty(queryParameter7)) {
                bundle.putString("dclid", queryParameter7);
            }
            String queryParameter16 = uri.getQueryParameter("utm_source_platform");
            if (!TextUtils.isEmpty(queryParameter16)) {
                bundle.putString("source_platform", queryParameter16);
            }
            String queryParameter17 = uri.getQueryParameter("utm_creative_format");
            if (!TextUtils.isEmpty(queryParameter17)) {
                bundle.putString("creative_format", queryParameter17);
            }
            String queryParameter18 = uri.getQueryParameter("utm_marketing_tactic");
            if (!TextUtils.isEmpty(queryParameter18)) {
                bundle.putString("marketing_tactic", queryParameter18);
            }
            if (!TextUtils.isEmpty(queryParameter8)) {
                bundle.putString("srsltid", queryParameter8);
            }
            if (!TextUtils.isEmpty(queryParameter9)) {
                bundle.putString(str, queryParameter9);
            }
            return bundle;
        } catch (UnsupportedOperationException e5) {
            Z z4 = ((C0113v0) this.f84c).f1417k;
            C0113v0.k(z4);
            z4.f1080k.b(e5, "Install referrer url isn't a hierarchical URI");
            return null;
        }
    }

    public final Bundle w0(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object objQ = q(bundle.get(str), str);
                if (objQ == null) {
                    C0113v0 c0113v0 = (C0113v0) this.f84c;
                    Z z4 = c0113v0.f1417k;
                    C0113v0.k(z4);
                    z4.f1082m.b(c0113v0.f1420o.e(str), "Param value can't be null");
                } else {
                    E(bundle2, str, objQ);
                }
            }
        }
        return bundle2;
    }

    public final void x(Bundle bundle, long j5) {
        long j6 = bundle.getLong("_et");
        if (j6 != 0) {
            Z z4 = ((C0113v0) this.f84c).f1417k;
            C0113v0.k(z4);
            z4.f1080k.b(Long.valueOf(j6), "Params already contained engagement");
        } else {
            j6 = 0;
        }
        bundle.putLong("_et", j5 + j6);
    }

    public final void y(Bundle bundle, int i5, String str, Object obj) {
        if (l0(i5, bundle)) {
            ((C0113v0) this.f84c).getClass();
            bundle.putString("_ev", t(40, str, true));
            if (obj != null) {
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    bundle.putLong("_el", obj.toString().length());
                }
            }
        }
    }
}
