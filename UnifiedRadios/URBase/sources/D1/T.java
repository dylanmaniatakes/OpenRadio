package D1;

import java.util.concurrent.Executor;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class T implements Executor {

    /* renamed from: j, reason: collision with root package name */
    public static final T f376j;

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ T[] f377k;

    static {
        T t4 = new T("INSTANCE", 0);
        f376j = t4;
        f377k = new T[]{t4};
    }

    public static T[] values() {
        return (T[]) f377k.clone();
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "MoreExecutors.directExecutor()";
    }
}
