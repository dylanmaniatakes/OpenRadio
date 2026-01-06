package J1;

import android.text.TextUtils;
import android.util.Log;

/* loaded from: classes.dex */
public final class Z extends F0 {

    /* renamed from: e, reason: collision with root package name */
    public char f1076e;

    /* renamed from: f, reason: collision with root package name */
    public long f1077f;
    public String g;
    public final X h;

    /* renamed from: i, reason: collision with root package name */
    public final X f1078i;

    /* renamed from: j, reason: collision with root package name */
    public final X f1079j;

    /* renamed from: k, reason: collision with root package name */
    public final X f1080k;

    /* renamed from: l, reason: collision with root package name */
    public final X f1081l;

    /* renamed from: m, reason: collision with root package name */
    public final X f1082m;
    public final X n;

    /* renamed from: o, reason: collision with root package name */
    public final X f1083o;

    /* renamed from: p, reason: collision with root package name */
    public final X f1084p;

    public Z(C0113v0 c0113v0) {
        super(c0113v0);
        this.f1076e = (char) 0;
        this.f1077f = -1L;
        this.h = new X(this, 6, false, false);
        this.f1078i = new X(this, 6, true, false);
        this.f1079j = new X(this, 6, false, true);
        this.f1080k = new X(this, 5, false, false);
        this.f1081l = new X(this, 5, true, false);
        this.f1082m = new X(this, 5, false, true);
        this.n = new X(this, 4, false, false);
        this.f1083o = new X(this, 3, false, false);
        this.f1084p = new X(this, 2, false, false);
    }

    public static Y q(String str) {
        if (str == null) {
            return null;
        }
        return new Y(str);
    }

    public static String r(boolean z4, String str, Object obj, Object obj2, Object obj3) {
        String strS = s(obj, z4);
        String strS2 = s(obj2, z4);
        String strS3 = s(obj3, z4);
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (str == null) {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(strS)) {
            sb.append(str2);
            sb.append(strS);
            str2 = ", ";
        }
        if (TextUtils.isEmpty(strS2)) {
            str3 = str2;
        } else {
            sb.append(str2);
            sb.append(strS2);
        }
        if (!TextUtils.isEmpty(strS3)) {
            sb.append(str3);
            sb.append(strS3);
        }
        return sb.toString();
    }

    public static String s(Object obj, boolean z4) {
        int iLastIndexOf;
        String className;
        int iLastIndexOf2;
        if (obj == null) {
            return "";
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Long) {
            if (!z4) {
                return obj.toString();
            }
            Long l5 = (Long) obj;
            if (Math.abs(l5.longValue()) < 100) {
                return obj.toString();
            }
            char cCharAt = obj.toString().charAt(0);
            String strValueOf = String.valueOf(Math.abs(l5.longValue()));
            long jRound = Math.round(Math.pow(10.0d, strValueOf.length() - 1));
            long jRound2 = Math.round(Math.pow(10.0d, strValueOf.length()) - 1.0d);
            StringBuilder sb = new StringBuilder();
            String str = cCharAt == '-' ? "-" : "";
            sb.append(str);
            sb.append(jRound);
            sb.append("...");
            sb.append(str);
            sb.append(jRound2);
            return sb.toString();
        }
        if (obj instanceof Boolean) {
            return obj.toString();
        }
        if (!(obj instanceof Throwable)) {
            return obj instanceof Y ? ((Y) obj).f1062a : z4 ? "-" : obj.toString();
        }
        Throwable th = (Throwable) obj;
        StringBuilder sb2 = new StringBuilder(z4 ? th.getClass().getName() : th.toString());
        String canonicalName = C0113v0.class.getCanonicalName();
        String strSubstring = (TextUtils.isEmpty(canonicalName) || (iLastIndexOf = canonicalName.lastIndexOf(46)) == -1) ? "" : canonicalName.substring(0, iLastIndexOf);
        StackTraceElement[] stackTrace = th.getStackTrace();
        int length = stackTrace.length;
        int i5 = 0;
        while (true) {
            if (i5 >= length) {
                break;
            }
            StackTraceElement stackTraceElement = stackTrace[i5];
            if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null) {
                if (((TextUtils.isEmpty(className) || (iLastIndexOf2 = className.lastIndexOf(46)) == -1) ? "" : className.substring(0, iLastIndexOf2)).equals(strSubstring)) {
                    sb2.append(": ");
                    sb2.append(stackTraceElement);
                    break;
                }
            }
            i5++;
        }
        return sb2.toString();
    }

    @Override // J1.F0
    public final boolean k() {
        return false;
    }

    public final X n() {
        return this.h;
    }

    public final X o() {
        return this.f1084p;
    }

    public final X p() {
        return this.f1080k;
    }

    public final String t() {
        String str;
        synchronized (this) {
            try {
                if (this.g == null) {
                    C0113v0 c0113v0 = (C0113v0) this.f84c;
                    String str2 = c0113v0.f1414f;
                    if (str2 != null) {
                        this.g = str2;
                    } else {
                        ((C0113v0) c0113v0.f1415i.f84c).getClass();
                        this.g = "FA";
                    }
                }
                q1.E.i(this.g);
                str = this.g;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    public final void u(int i5, boolean z4, boolean z5, String str, Object obj, Object obj2, Object obj3) {
        if (!z4 && Log.isLoggable(t(), i5)) {
            Log.println(i5, t(), r(false, str, obj, obj2, obj3));
        }
        if (z5 || i5 < 5) {
            return;
        }
        q1.E.i(str);
        C0104s0 c0104s0 = ((C0113v0) this.f84c).f1418l;
        if (c0104s0 == null) {
            Log.println(6, t(), "Scheduler not set. Not logging error/warn");
        } else {
            if (!c0104s0.f733d) {
                Log.println(6, t(), "Scheduler not initialized. Not logging error/warn");
                return;
            }
            if (i5 >= 9) {
                i5 = 8;
            }
            c0104s0.t(new W(this, i5, str, obj, obj2, obj3));
        }
    }
}
