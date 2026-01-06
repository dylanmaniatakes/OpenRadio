package K;

import android.os.Bundle;
import android.os.IBinder;

/* loaded from: classes.dex */
public abstract class a {
    public static final void a(Bundle bundle, String str, IBinder iBinder) {
        F3.i.f(bundle, "bundle");
        F3.i.f(str, "key");
        bundle.putBinder(str, iBinder);
    }
}
