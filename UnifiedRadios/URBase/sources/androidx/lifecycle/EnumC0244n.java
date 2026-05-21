package androidx.lifecycle;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: androidx.lifecycle.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC0244n {

    /* renamed from: j, reason: collision with root package name */
    public static final EnumC0244n f3961j;

    /* renamed from: k, reason: collision with root package name */
    public static final EnumC0244n f3962k;

    /* renamed from: l, reason: collision with root package name */
    public static final EnumC0244n f3963l;

    /* renamed from: m, reason: collision with root package name */
    public static final EnumC0244n f3964m;
    public static final EnumC0244n n;

    /* renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ EnumC0244n[] f3965o;

    static {
        EnumC0244n enumC0244n = new EnumC0244n("DESTROYED", 0);
        f3961j = enumC0244n;
        EnumC0244n enumC0244n2 = new EnumC0244n("INITIALIZED", 1);
        f3962k = enumC0244n2;
        EnumC0244n enumC0244n3 = new EnumC0244n("CREATED", 2);
        f3963l = enumC0244n3;
        EnumC0244n enumC0244n4 = new EnumC0244n("STARTED", 3);
        f3964m = enumC0244n4;
        EnumC0244n enumC0244n5 = new EnumC0244n("RESUMED", 4);
        n = enumC0244n5;
        f3965o = new EnumC0244n[]{enumC0244n, enumC0244n2, enumC0244n3, enumC0244n4, enumC0244n5};
    }

    public static EnumC0244n valueOf(String str) {
        return (EnumC0244n) Enum.valueOf(EnumC0244n.class, str);
    }

    public static EnumC0244n[] values() {
        return (EnumC0244n[]) f3965o.clone();
    }
}
