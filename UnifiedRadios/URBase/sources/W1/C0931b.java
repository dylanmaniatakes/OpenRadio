package w1;

import J1.B1;
import android.content.Context;

/* renamed from: w1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0931b {

    /* renamed from: b, reason: collision with root package name */
    public static final C0931b f10127b;

    /* renamed from: a, reason: collision with root package name */
    public B1 f10128a;

    static {
        C0931b c0931b = new C0931b();
        c0931b.f10128a = null;
        f10127b = c0931b;
    }

    public static B1 a(Context context) {
        B1 b12;
        C0931b c0931b = f10127b;
        synchronized (c0931b) {
            try {
                if (c0931b.f10128a == null) {
                    if (context.getApplicationContext() != null) {
                        context = context.getApplicationContext();
                    }
                    c0931b.f10128a = new B1(context, 2);
                }
                b12 = c0931b.f10128a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return b12;
    }
}
