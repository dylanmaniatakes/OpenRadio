package X0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class q {

    /* renamed from: j, reason: collision with root package name */
    public static final q f2739j;

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ q[] f2740k;

    /* JADX INFO: Fake field, exist only in values array */
    q EF0;

    static {
        q qVar = new q("UNKNOWN", 0);
        q qVar2 = new q("ANDROID_FIREBASE", 1);
        f2739j = qVar2;
        f2740k = new q[]{qVar, qVar2};
    }

    public static q valueOf(String str) {
        return (q) Enum.valueOf(q.class, str);
    }

    public static q[] values() {
        return (q[]) f2740k.clone();
    }
}
