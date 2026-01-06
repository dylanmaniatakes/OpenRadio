package C0;

import android.util.Log;

/* loaded from: classes.dex */
public final class t {

    /* renamed from: b, reason: collision with root package name */
    public static final Object f172b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static volatile t f173c;

    /* renamed from: a, reason: collision with root package name */
    public final int f174a;

    public t(int i5) {
        this.f174a = i5;
    }

    public static t d() {
        t tVar;
        synchronized (f172b) {
            try {
                if (f173c == null) {
                    f173c = new t(3);
                }
                tVar = f173c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return tVar;
    }

    public static String f(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(23);
        sb.append("WM-");
        if (length >= 20) {
            sb.append(str.substring(0, 20));
        } else {
            sb.append(str);
        }
        return sb.toString();
    }

    public final void a(String str, String str2) {
        if (this.f174a <= 3) {
            Log.d(str, str2);
        }
    }

    public final void b(String str, String str2) {
        if (this.f174a <= 6) {
            Log.e(str, str2);
        }
    }

    public final void c(String str, String str2, Throwable th) {
        if (this.f174a <= 6) {
            Log.e(str, str2, th);
        }
    }

    public final void e(String str, String str2) {
        if (this.f174a <= 4) {
            Log.i(str, str2);
        }
    }

    public final void g(String str, String str2) {
        if (this.f174a <= 5) {
            Log.w(str, str2);
        }
    }
}
