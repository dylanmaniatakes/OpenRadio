package R2;

import J1.D;
import android.text.TextUtils;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: b, reason: collision with root package name */
    public static final long f2300b = TimeUnit.HOURS.toSeconds(1);

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f2301c = Pattern.compile("\\AA[\\w-]{38}\\z");

    /* renamed from: d, reason: collision with root package name */
    public static k f2302d;

    /* renamed from: a, reason: collision with root package name */
    public final D f2303a;

    public k(D d5) {
        this.f2303a = d5;
    }

    public final boolean a(S2.b bVar) {
        if (TextUtils.isEmpty(bVar.f2370c)) {
            return true;
        }
        long j5 = bVar.f2373f + bVar.f2372e;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.f2303a.getClass();
        return j5 < timeUnit.toSeconds(System.currentTimeMillis()) + f2300b;
    }
}
