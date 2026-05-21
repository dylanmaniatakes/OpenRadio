package x3;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: x3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC0973a {

    /* renamed from: j, reason: collision with root package name */
    public static final EnumC0973a f10448j;

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ EnumC0973a[] f10449k;

    static {
        EnumC0973a enumC0973a = new EnumC0973a("COROUTINE_SUSPENDED", 0);
        f10448j = enumC0973a;
        f10449k = new EnumC0973a[]{enumC0973a, new EnumC0973a("UNDECIDED", 1), new EnumC0973a("RESUMED", 2)};
    }

    public static EnumC0973a valueOf(String str) {
        return (EnumC0973a) Enum.valueOf(EnumC0973a.class, str);
    }

    public static EnumC0973a[] values() {
        return (EnumC0973a[]) f10449k.clone();
    }
}
