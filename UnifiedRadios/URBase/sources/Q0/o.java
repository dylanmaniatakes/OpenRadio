package Q0;

import android.util.Log;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class o {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f2164a = Log.isLoggable("Volley", 2);

    /* renamed from: b, reason: collision with root package name */
    public static final String f2165b = o.class.getName();

    public static String a(String str, Object... objArr) {
        String str2;
        String str3 = String.format(Locale.US, str, objArr);
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i5 = 2;
        while (true) {
            if (i5 >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            }
            if (!stackTrace[i5].getClassName().equals(f2165b)) {
                String className = stackTrace[i5].getClassName();
                String strSubstring = className.substring(className.lastIndexOf(46) + 1);
                str2 = strSubstring.substring(strSubstring.lastIndexOf(36) + 1) + "." + stackTrace[i5].getMethodName();
                break;
            }
            i5++;
        }
        Locale locale = Locale.US;
        long id = Thread.currentThread().getId();
        StringBuilder sb = new StringBuilder("[");
        sb.append(id);
        sb.append("] ");
        sb.append(str2);
        return com.unified.ur1.SatelliteTracker.h.e(sb, ": ", str3);
    }

    public static void b(String str, Object... objArr) {
        Log.d("Volley", a(str, objArr));
    }

    public static void c(String str, Object... objArr) {
        Log.e("Volley", a(str, objArr));
    }

    public static void d(String str, Object... objArr) {
        if (f2164a) {
            Log.v("Volley", a(str, objArr));
        }
    }
}
