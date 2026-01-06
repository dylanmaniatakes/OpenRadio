package androidx.lifecycle;

/* renamed from: androidx.lifecycle.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0241k {
    public static EnumC0243m a(EnumC0244n enumC0244n) {
        F3.i.f(enumC0244n, "state");
        int iOrdinal = enumC0244n.ordinal();
        if (iOrdinal == 2) {
            return EnumC0243m.ON_DESTROY;
        }
        if (iOrdinal == 3) {
            return EnumC0243m.ON_STOP;
        }
        if (iOrdinal != 4) {
            return null;
        }
        return EnumC0243m.ON_PAUSE;
    }

    public static EnumC0243m b(EnumC0244n enumC0244n) {
        F3.i.f(enumC0244n, "state");
        int iOrdinal = enumC0244n.ordinal();
        if (iOrdinal == 1) {
            return EnumC0243m.ON_CREATE;
        }
        if (iOrdinal == 2) {
            return EnumC0243m.ON_START;
        }
        if (iOrdinal != 3) {
            return null;
        }
        return EnumC0243m.ON_RESUME;
    }
}
