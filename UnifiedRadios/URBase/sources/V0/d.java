package V0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: j, reason: collision with root package name */
    public static final d f2512j;

    /* renamed from: k, reason: collision with root package name */
    public static final d f2513k;

    /* renamed from: l, reason: collision with root package name */
    public static final d f2514l;

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ d[] f2515m;

    static {
        d dVar = new d("DEFAULT", 0);
        f2512j = dVar;
        d dVar2 = new d("VERY_LOW", 1);
        f2513k = dVar2;
        d dVar3 = new d("HIGHEST", 2);
        f2514l = dVar3;
        f2515m = new d[]{dVar, dVar2, dVar3};
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) f2515m.clone();
    }
}
