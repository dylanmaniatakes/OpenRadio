package androidx.lifecycle;

import c0.C0291c;

/* loaded from: classes.dex */
public interface V {
    default S b(Class cls) {
        throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
    }

    default S f(Class cls, C0291c c0291c) {
        return b(cls);
    }
}
