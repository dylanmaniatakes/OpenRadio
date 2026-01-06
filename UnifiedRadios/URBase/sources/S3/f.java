package S3;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceConfigurationError;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final List f2390a;

    static {
        try {
            Iterator it = Arrays.asList(new O3.b()).iterator();
            F3.i.f(it, "<this>");
            f2390a = L3.e.x(new L3.a(new L3.g(0, it)));
        } catch (Throwable th) {
            throw new ServiceConfigurationError(th.getMessage(), th);
        }
    }
}
