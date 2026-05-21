package U3;

/* loaded from: classes.dex */
public final class d extends g {

    /* renamed from: m, reason: collision with root package name */
    public static final d f2487m;

    static {
        int i5 = k.f2496c;
        int i6 = k.f2497d;
        f2487m = new d(k.f2494a, k.f2498e, i5, i6);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // N3.AbstractC0143q
    public final String toString() {
        return "Dispatchers.Default";
    }
}
