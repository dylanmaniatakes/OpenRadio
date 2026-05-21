package J1;

import android.os.Bundle;
import g0.AbstractC0535a;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import okhttp3.HttpUrl;
import s.AbstractC0882e;

/* loaded from: classes.dex */
public final class S {

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicReference f944b = new AtomicReference();

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicReference f945c = new AtomicReference();

    /* renamed from: d, reason: collision with root package name */
    public static final AtomicReference f946d = new AtomicReference();

    /* renamed from: a, reason: collision with root package name */
    public final C0078j0 f947a;

    public S(C0078j0 c0078j0) {
        this.f947a = c0078j0;
    }

    public static final String g(String str, String[] strArr, String[] strArr2, AtomicReference atomicReference) {
        String str2;
        q1.E.i(atomicReference);
        q1.E.a(strArr.length == strArr2.length);
        for (int i5 = 0; i5 < strArr.length; i5++) {
            if (Objects.equals(str, strArr[i5])) {
                synchronized (atomicReference) {
                    try {
                        String[] strArr3 = (String[]) atomicReference.get();
                        if (strArr3 == null) {
                            strArr3 = new String[strArr2.length];
                            atomicReference.set(strArr3);
                        }
                        str2 = strArr3[i5];
                        if (str2 == null) {
                            str2 = strArr2[i5] + "(" + strArr[i5] + ")";
                            strArr3[i5] = str2;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return str2;
            }
        }
        return str;
    }

    public final String a(Object[] objArr) {
        if (objArr == null) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sbB = AbstractC0882e.b("[");
        for (Object obj : objArr) {
            String strB = obj instanceof Bundle ? b((Bundle) obj) : String.valueOf(obj);
            if (strB != null) {
                if (sbB.length() != 1) {
                    sbB.append(", ");
                }
                sbB.append(strB);
            }
        }
        sbB.append("]");
        return sbB.toString();
    }

    public final String b(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        if (!this.f947a.a()) {
            return bundle.toString();
        }
        StringBuilder sbB = AbstractC0882e.b("Bundle[{");
        for (String str : bundle.keySet()) {
            if (sbB.length() != 8) {
                sbB.append(", ");
            }
            sbB.append(e(str));
            sbB.append("=");
            Object obj = bundle.get(str);
            sbB.append(obj instanceof Bundle ? a(new Object[]{obj}) : obj instanceof Object[] ? a((Object[]) obj) : obj instanceof ArrayList ? a(((ArrayList) obj).toArray()) : String.valueOf(obj));
        }
        sbB.append("}]");
        return sbB.toString();
    }

    public final String c(C0112v c0112v) {
        C0078j0 c0078j0 = this.f947a;
        if (!c0078j0.a()) {
            return c0112v.toString();
        }
        StringBuilder sb = new StringBuilder("origin=");
        sb.append(c0112v.f1400l);
        sb.append(",name=");
        sb.append(d(c0112v.f1398j));
        sb.append(",params=");
        C0109u c0109u = c0112v.f1399k;
        sb.append(c0109u == null ? null : !c0078j0.a() ? c0109u.f1395j.toString() : b(c0109u.a()));
        return sb.toString();
    }

    public final String d(String str) {
        if (str == null) {
            return null;
        }
        return !this.f947a.a() ? str : g(str, L0.f886c, L0.f884a, f944b);
    }

    public final String e(String str) {
        if (str == null) {
            return null;
        }
        return !this.f947a.a() ? str : g(str, L0.f889f, L0.f888e, f945c);
    }

    public final String f(String str) {
        if (str == null) {
            return null;
        }
        return !this.f947a.a() ? str : str.startsWith("_exp_") ? AbstractC0535a.l("experiment_id(", str, ")") : g(str, L0.f891j, L0.f890i, f946d);
    }
}
