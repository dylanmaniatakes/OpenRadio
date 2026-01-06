package androidx.work;

import C0.C0001a;
import C0.t;
import C0.u;
import D0.v;
import android.content.Context;
import com.google.android.gms.internal.measurement.D1;
import java.util.Collections;
import java.util.List;
import s0.b;

/* loaded from: classes.dex */
public final class WorkManagerInitializer implements b {

    /* renamed from: a, reason: collision with root package name */
    public static final String f4478a = t.f("WrkMgrInitializer");

    @Override // s0.b
    public final List a() {
        return Collections.emptyList();
    }

    @Override // s0.b
    public final Object b(Context context) {
        t.d().a(f4478a, "Initializing WorkManager with default configuration.");
        C0001a c0001a = new C0001a(new u());
        synchronized (v.f299m) {
            try {
                v vVar = v.f297k;
                if (vVar != null && v.f298l != null) {
                    throw new IllegalStateException("WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information.");
                }
                if (vVar == null) {
                    Context applicationContext = context.getApplicationContext();
                    if (v.f298l == null) {
                        v.f298l = D1.f(applicationContext, c0001a);
                    }
                    v.f297k = v.f298l;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return v.y(context);
    }
}
