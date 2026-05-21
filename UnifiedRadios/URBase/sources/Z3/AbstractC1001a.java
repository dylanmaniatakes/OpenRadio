package z3;

import F3.i;
import java.lang.reflect.Method;

/* renamed from: z3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1001a {

    /* renamed from: a, reason: collision with root package name */
    public static final Method f10552a;

    static {
        Method method;
        Method[] methods = Throwable.class.getMethods();
        i.e(methods, "throwableMethods");
        int length = methods.length;
        int i5 = 0;
        while (true) {
            method = null;
            if (i5 >= length) {
                break;
            }
            Method method2 = methods[i5];
            if (i.a(method2.getName(), "addSuppressed")) {
                Class<?>[] parameterTypes = method2.getParameterTypes();
                i.e(parameterTypes, "it.parameterTypes");
                if (i.a(parameterTypes.length == 1 ? parameterTypes[0] : null, Throwable.class)) {
                    method = method2;
                    break;
                }
            }
            i5++;
        }
        f10552a = method;
        int length2 = methods.length;
        for (int i6 = 0; i6 < length2 && !i.a(methods[i6].getName(), "getSuppressed"); i6++) {
        }
    }
}
