package S3;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceConfigurationError;

/* loaded from: classes.dex */
public abstract class o {

    /* renamed from: a, reason: collision with root package name */
    public static final O3.c f2412a;

    static {
        String property;
        int i5 = x.f2423a;
        Object next = null;
        try {
            property = System.getProperty("kotlinx.coroutines.fast.service.loader");
        } catch (SecurityException unused) {
            property = null;
        }
        if (property != null) {
            Boolean.parseBoolean(property);
        }
        try {
            Iterator it = Arrays.asList(new O3.a()).iterator();
            F3.i.f(it, "<this>");
            List listX = L3.e.x(new L3.a(new L3.g(0, it)));
            Iterator it2 = listX.iterator();
            if (it2.hasNext()) {
                next = it2.next();
                if (it2.hasNext()) {
                    int iB = ((O3.a) next).b();
                    do {
                        Object next2 = it2.next();
                        int iB2 = ((O3.a) next2).b();
                        if (iB < iB2) {
                            next = next2;
                            iB = iB2;
                        }
                    } while (it2.hasNext());
                }
            }
            O3.a aVar = (O3.a) next;
            if (aVar != null) {
                try {
                    O3.c cVarA = aVar.a(listX);
                    if (cVarA != null) {
                        f2412a = cVarA;
                        return;
                    }
                } catch (Throwable th) {
                    aVar.c();
                    throw th;
                }
            }
            throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
        } catch (Throwable th2) {
            throw new ServiceConfigurationError(th2.getMessage(), th2);
        }
    }
}
