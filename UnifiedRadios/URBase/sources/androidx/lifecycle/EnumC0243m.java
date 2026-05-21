package androidx.lifecycle;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: androidx.lifecycle.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC0243m {
    private static final /* synthetic */ EnumC0243m[] $VALUES;
    public static final C0241k Companion;
    public static final EnumC0243m ON_ANY;
    public static final EnumC0243m ON_CREATE;
    public static final EnumC0243m ON_DESTROY;
    public static final EnumC0243m ON_PAUSE;
    public static final EnumC0243m ON_RESUME;
    public static final EnumC0243m ON_START;
    public static final EnumC0243m ON_STOP;

    static {
        EnumC0243m enumC0243m = new EnumC0243m("ON_CREATE", 0);
        ON_CREATE = enumC0243m;
        EnumC0243m enumC0243m2 = new EnumC0243m("ON_START", 1);
        ON_START = enumC0243m2;
        EnumC0243m enumC0243m3 = new EnumC0243m("ON_RESUME", 2);
        ON_RESUME = enumC0243m3;
        EnumC0243m enumC0243m4 = new EnumC0243m("ON_PAUSE", 3);
        ON_PAUSE = enumC0243m4;
        EnumC0243m enumC0243m5 = new EnumC0243m("ON_STOP", 4);
        ON_STOP = enumC0243m5;
        EnumC0243m enumC0243m6 = new EnumC0243m("ON_DESTROY", 5);
        ON_DESTROY = enumC0243m6;
        EnumC0243m enumC0243m7 = new EnumC0243m("ON_ANY", 6);
        ON_ANY = enumC0243m7;
        $VALUES = new EnumC0243m[]{enumC0243m, enumC0243m2, enumC0243m3, enumC0243m4, enumC0243m5, enumC0243m6, enumC0243m7};
        Companion = new C0241k();
    }

    public static EnumC0243m valueOf(String str) {
        return (EnumC0243m) Enum.valueOf(EnumC0243m.class, str);
    }

    public static EnumC0243m[] values() {
        return (EnumC0243m[]) $VALUES.clone();
    }

    public final EnumC0244n a() {
        switch (AbstractC0242l.f3960a[ordinal()]) {
            case 1:
            case 2:
                return EnumC0244n.f3963l;
            case 3:
            case 4:
                return EnumC0244n.f3964m;
            case 5:
                return EnumC0244n.n;
            case 6:
                return EnumC0244n.f3961j;
            default:
                throw new IllegalArgumentException(this + " has no target state");
        }
    }
}
