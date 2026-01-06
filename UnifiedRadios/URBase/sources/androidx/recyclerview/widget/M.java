package androidx.recyclerview.widget;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class M {

    /* renamed from: j, reason: collision with root package name */
    public static final M f4064j;

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ M[] f4065k;

    static {
        M m5 = new M("ALLOW", 0);
        f4064j = m5;
        f4065k = new M[]{m5, new M("PREVENT_WHEN_EMPTY", 1), new M("PREVENT", 2)};
    }

    public static M valueOf(String str) {
        return (M) Enum.valueOf(M.class, str);
    }

    public static M[] values() {
        return (M[]) f4065k.clone();
    }
}
