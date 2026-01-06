package e1;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: e1.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC0437e {

    /* renamed from: j, reason: collision with root package name */
    public static final EnumC0437e f6159j;

    /* renamed from: k, reason: collision with root package name */
    public static final EnumC0437e f6160k;

    /* renamed from: l, reason: collision with root package name */
    public static final EnumC0437e f6161l;

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ EnumC0437e[] f6162m;

    static {
        EnumC0437e enumC0437e = new EnumC0437e("NETWORK_UNMETERED", 0);
        f6159j = enumC0437e;
        EnumC0437e enumC0437e2 = new EnumC0437e("DEVICE_IDLE", 1);
        f6160k = enumC0437e2;
        EnumC0437e enumC0437e3 = new EnumC0437e("DEVICE_CHARGING", 2);
        f6161l = enumC0437e3;
        f6162m = new EnumC0437e[]{enumC0437e, enumC0437e2, enumC0437e3};
    }

    public static EnumC0437e valueOf(String str) {
        return (EnumC0437e) Enum.valueOf(EnumC0437e.class, str);
    }

    public static EnumC0437e[] values() {
        return (EnumC0437e[]) f6162m.clone();
    }
}
