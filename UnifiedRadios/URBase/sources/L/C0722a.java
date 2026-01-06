package l;

import android.os.Handler;
import android.os.Looper;
import h4.d;
import i0.ExecutorC0566c;

/* renamed from: l.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0722a extends d {

    /* renamed from: b, reason: collision with root package name */
    public static volatile C0722a f8318b;

    /* renamed from: c, reason: collision with root package name */
    public static final ExecutorC0566c f8319c = new ExecutorC0566c(1);

    /* renamed from: a, reason: collision with root package name */
    public final C0724c f8320a = new C0724c();

    public static C0722a o() {
        if (f8318b != null) {
            return f8318b;
        }
        synchronized (C0722a.class) {
            try {
                if (f8318b == null) {
                    f8318b = new C0722a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f8318b;
    }

    public final void p(Runnable runnable) {
        C0724c c0724c = this.f8320a;
        if (c0724c.f8324c == null) {
            synchronized (c0724c.f8322a) {
                try {
                    if (c0724c.f8324c == null) {
                        c0724c.f8324c = Handler.createAsync(Looper.getMainLooper());
                    }
                } finally {
                }
            }
        }
        c0724c.f8324c.post(runnable);
    }
}
