package androidx.profileinstaller;

import android.content.Context;
import g3.k;
import h1.C0558b;
import j0.AbstractC0594g;
import java.util.Collections;
import java.util.List;
import s0.b;

/* loaded from: classes.dex */
public class ProfileInstallerInitializer implements b {
    @Override // s0.b
    public final List a() {
        return Collections.emptyList();
    }

    @Override // s0.b
    public final Object b(Context context) {
        AbstractC0594g.a(new k(this, 4, context.getApplicationContext()));
        return new C0558b(3);
    }
}
