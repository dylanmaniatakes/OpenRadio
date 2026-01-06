package J1;

/* loaded from: classes.dex */
public final class G {

    /* renamed from: f, reason: collision with root package name */
    public static final Object f738f = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final String f739a;

    /* renamed from: b, reason: collision with root package name */
    public final F f740b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f741c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f742d = new Object();

    /* renamed from: e, reason: collision with root package name */
    public volatile Object f743e = null;

    public /* synthetic */ G(String str, Object obj, F f5) {
        this.f739a = str;
        this.f741c = obj;
        this.f740b = f5;
    }

    public final Object a(Object obj) {
        synchronized (this.f742d) {
        }
        if (obj != null) {
            return obj;
        }
        if (L0.f892k == null) {
            return this.f741c;
        }
        synchronized (f738f) {
            try {
                if (O2.e.e()) {
                    return this.f743e == null ? this.f741c : this.f743e;
                }
                try {
                    for (G g : H.f796a) {
                        if (O2.e.e()) {
                            throw new IllegalStateException("Refreshing flag cache must be done on a worker thread.");
                        }
                        Object objA = null;
                        try {
                            F f5 = g.f740b;
                            if (f5 != null) {
                                objA = f5.a();
                            }
                        } catch (IllegalStateException unused) {
                        }
                        synchronized (f738f) {
                            g.f743e = objA;
                        }
                    }
                } catch (SecurityException unused2) {
                }
                F f6 = this.f740b;
                if (f6 != null) {
                    try {
                        return f6.a();
                    } catch (IllegalStateException | SecurityException unused3) {
                    }
                }
                return this.f741c;
            } finally {
            }
        }
    }
}
