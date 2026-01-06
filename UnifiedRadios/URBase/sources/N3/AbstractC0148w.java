package N3;

/* renamed from: N3.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0148w {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f1881a = 0;

    static {
        String property;
        int i5 = S3.x.f2423a;
        try {
            property = System.getProperty("kotlinx.coroutines.main.delay");
        } catch (SecurityException unused) {
            property = null;
        }
        if (!(property != null ? Boolean.parseBoolean(property) : false)) {
            RunnableC0147v runnableC0147v = RunnableC0147v.f1879r;
            return;
        }
        U3.d dVar = B.f1811a;
        O3.c cVar = S3.o.f2412a;
        O3.c cVar2 = cVar.f2041o;
        if (cVar instanceof InterfaceC0151z) {
            return;
        }
        RunnableC0147v runnableC0147v2 = RunnableC0147v.f1879r;
    }
}
