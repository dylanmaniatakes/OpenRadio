package G2;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class k implements Executor {

    /* renamed from: j, reason: collision with root package name */
    public static final k f641j;

    /* renamed from: k, reason: collision with root package name */
    public static final Handler f642k;

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ k[] f643l;

    static {
        k kVar = new k("INSTANCE", 0);
        f641j = kVar;
        f643l = new k[]{kVar};
        f642k = new Handler(Looper.getMainLooper());
    }

    public static k valueOf(String str) {
        return (k) Enum.valueOf(k.class, str);
    }

    public static k[] values() {
        return (k[]) f643l.clone();
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        f642k.post(runnable);
    }
}
