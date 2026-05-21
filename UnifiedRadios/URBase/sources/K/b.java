package K;

import android.os.Bundle;
import android.util.Size;
import android.util.SizeF;

/* loaded from: classes.dex */
public abstract class b {
    public static final void a(Bundle bundle, String str, Size size) {
        F3.i.f(bundle, "bundle");
        F3.i.f(str, "key");
        bundle.putSize(str, size);
    }

    public static final void b(Bundle bundle, String str, SizeF sizeF) {
        F3.i.f(bundle, "bundle");
        F3.i.f(str, "key");
        bundle.putSizeF(str, sizeF);
    }
}
