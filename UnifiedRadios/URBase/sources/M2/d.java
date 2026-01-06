package M2;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: j, reason: collision with root package name */
    public static final d f1726j;

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ d[] f1727k;

    static {
        d dVar = new d("DEFAULT", 0);
        f1726j = dVar;
        f1727k = new d[]{dVar, new d("SIGNED", 1), new d("FIXED", 2)};
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) f1727k.clone();
    }
}
