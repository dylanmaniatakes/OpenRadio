package O3;

import F3.i;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import com.google.android.gms.internal.measurement.AbstractC0399v1;
import java.lang.reflect.InvocationTargetException;
import s3.C0896f;

/* loaded from: classes.dex */
public abstract class d {
    private static volatile Choreographer choreographer;

    static {
        Object objC;
        try {
            objC = new c(a(Looper.getMainLooper()));
        } catch (Throwable th) {
            objC = AbstractC0399v1.c(th);
        }
        if (objC instanceof C0896f) {
            objC = null;
        }
    }

    public static final Handler a(Looper looper) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object objInvoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
        i.d(objInvoke, "null cannot be cast to non-null type android.os.Handler");
        return (Handler) objInvoke;
    }
}
