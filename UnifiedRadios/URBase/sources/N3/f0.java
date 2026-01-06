package N3;

/* loaded from: classes.dex */
public abstract class f0 {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f1849a = new ThreadLocal();

    public static G a() {
        ThreadLocal threadLocal = f1849a;
        G g = (G) threadLocal.get();
        if (g != null) {
            return g;
        }
        C0129c c0129c = new C0129c(Thread.currentThread());
        threadLocal.set(c0129c);
        return c0129c;
    }
}
