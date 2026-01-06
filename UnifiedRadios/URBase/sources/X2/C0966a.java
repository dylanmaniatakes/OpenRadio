package x2;

/* renamed from: x2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0966a extends AbstractC0967b {

    /* renamed from: j, reason: collision with root package name */
    public static final C0966a f10439j = new C0966a();

    @Override // x2.AbstractC0967b
    public final Object a() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    @Override // x2.AbstractC0967b
    public final boolean b() {
        return false;
    }

    public final boolean equals(Object obj) {
        return obj == this;
    }

    public final int hashCode() {
        return 2040732332;
    }

    public final String toString() {
        return "Optional.absent()";
    }
}
