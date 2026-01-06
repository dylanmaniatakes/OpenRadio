package N0;

import java.util.concurrent.Executor;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class j implements Executor {

    /* renamed from: j, reason: collision with root package name */
    public static final j f1786j;

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ j[] f1787k;

    static {
        j jVar = new j("INSTANCE", 0);
        f1786j = jVar;
        f1787k = new j[]{jVar};
    }

    public static j valueOf(String str) {
        return (j) Enum.valueOf(j.class, str);
    }

    public static j[] values() {
        return (j[]) f1787k.clone();
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "DirectExecutor";
    }
}
