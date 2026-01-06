package C0;

import android.content.Context;
import androidx.work.WorkerParameters;

/* loaded from: classes.dex */
public final class B {

    /* renamed from: a, reason: collision with root package name */
    public static final String f129a = t.f("WorkerFactory");

    public static s a(Context context, String str, WorkerParameters workerParameters) {
        Class clsAsSubclass;
        String str2 = f129a;
        s sVar = null;
        try {
            clsAsSubclass = Class.forName(str).asSubclass(s.class);
        } catch (Throwable th) {
            t.d().c(str2, "Invalid class: " + str, th);
            clsAsSubclass = null;
        }
        if (clsAsSubclass != null) {
            try {
                sVar = (s) clsAsSubclass.getDeclaredConstructor(Context.class, WorkerParameters.class).newInstance(context, workerParameters);
            } catch (Throwable th2) {
                t.d().c(str2, "Could not instantiate " + str, th2);
            }
        }
        if (sVar == null || !sVar.f171f) {
            return sVar;
        }
        throw new IllegalStateException("WorkerFactory (" + B.class.getName() + ") returned an instance of a ListenableWorker (" + str + ") which has already been invoked. createWorker() must always return a new instance of a ListenableWorker.");
    }
}
