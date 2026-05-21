package F2;

/* loaded from: classes.dex */
public final class n implements Q2.a {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f569c = new Object();

    /* renamed from: a, reason: collision with root package name */
    public volatile Object f570a = f569c;

    /* renamed from: b, reason: collision with root package name */
    public volatile Q2.a f571b;

    public n(Q2.a aVar) {
        this.f571b = aVar;
    }

    @Override // Q2.a
    public final Object get() {
        Object obj = this.f570a;
        Object obj2 = f569c;
        if (obj == obj2) {
            synchronized (this) {
                try {
                    obj = this.f570a;
                    if (obj == obj2) {
                        obj = this.f571b.get();
                        this.f570a = obj;
                        this.f571b = null;
                    }
                } finally {
                }
            }
        }
        return obj;
    }
}
