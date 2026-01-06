package l1;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.locks.ReentrantLock;
import q1.E;

/* renamed from: l1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0741a {

    /* renamed from: c, reason: collision with root package name */
    public static final ReentrantLock f8385c = new ReentrantLock();

    /* renamed from: d, reason: collision with root package name */
    public static C0741a f8386d;

    /* renamed from: a, reason: collision with root package name */
    public final ReentrantLock f8387a = new ReentrantLock();

    /* renamed from: b, reason: collision with root package name */
    public final SharedPreferences f8388b;

    public C0741a(Context context) {
        this.f8388b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static C0741a a(Context context) {
        E.i(context);
        ReentrantLock reentrantLock = f8385c;
        reentrantLock.lock();
        try {
            if (f8386d == null) {
                f8386d = new C0741a(context.getApplicationContext());
            }
            C0741a c0741a = f8386d;
            reentrantLock.unlock();
            return c0741a;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final String b(String str) {
        ReentrantLock reentrantLock = this.f8387a;
        reentrantLock.lock();
        try {
            return this.f8388b.getString(str, null);
        } finally {
            reentrantLock.unlock();
        }
    }
}
