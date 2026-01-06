package J1;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class I1 {

    /* renamed from: j, reason: collision with root package name */
    public static final I1 f869j;

    /* renamed from: k, reason: collision with root package name */
    public static final I1 f870k;

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ I1[] f871l;

    static {
        I1 i12 = new I1("CONSENT", 0);
        f869j = i12;
        I1 i13 = new I1("LEGITIMATE_INTEREST", 1);
        I1 i14 = new I1("FLEXIBLE_CONSENT", 2);
        I1 i15 = new I1("FLEXIBLE_LEGITIMATE_INTEREST", 3);
        f870k = i15;
        f871l = new I1[]{i12, i13, i14, i15};
    }

    public static I1[] values() {
        return (I1[]) f871l.clone();
    }
}
