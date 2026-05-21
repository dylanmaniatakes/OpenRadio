package N3;

import java.util.concurrent.CancellationException;

/* renamed from: N3.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0137k {

    /* renamed from: a, reason: collision with root package name */
    public final Object f1854a;

    /* renamed from: b, reason: collision with root package name */
    public final M f1855b;

    /* renamed from: c, reason: collision with root package name */
    public final E3.l f1856c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f1857d;

    /* renamed from: e, reason: collision with root package name */
    public final Throwable f1858e;

    public C0137k(Object obj, M m5, E3.l lVar, Object obj2, Throwable th) {
        this.f1854a = obj;
        this.f1855b = m5;
        this.f1856c = lVar;
        this.f1857d = obj2;
        this.f1858e = th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.lang.Throwable] */
    public static C0137k a(C0137k c0137k, M m5, CancellationException cancellationException, int i5) {
        Object obj = c0137k.f1854a;
        if ((i5 & 2) != 0) {
            m5 = c0137k.f1855b;
        }
        M m6 = m5;
        E3.l lVar = c0137k.f1856c;
        Object obj2 = c0137k.f1857d;
        CancellationException cancellationException2 = cancellationException;
        if ((i5 & 16) != 0) {
            cancellationException2 = c0137k.f1858e;
        }
        c0137k.getClass();
        return new C0137k(obj, m6, lVar, obj2, cancellationException2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0137k)) {
            return false;
        }
        C0137k c0137k = (C0137k) obj;
        return F3.i.a(this.f1854a, c0137k.f1854a) && F3.i.a(this.f1855b, c0137k.f1855b) && F3.i.a(this.f1856c, c0137k.f1856c) && F3.i.a(this.f1857d, c0137k.f1857d) && F3.i.a(this.f1858e, c0137k.f1858e);
    }

    public final int hashCode() {
        Object obj = this.f1854a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        M m5 = this.f1855b;
        int iHashCode2 = (iHashCode + (m5 == null ? 0 : m5.hashCode())) * 31;
        E3.l lVar = this.f1856c;
        int iHashCode3 = (iHashCode2 + (lVar == null ? 0 : lVar.hashCode())) * 31;
        Object obj2 = this.f1857d;
        int iHashCode4 = (iHashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.f1858e;
        return iHashCode4 + (th != null ? th.hashCode() : 0);
    }

    public final String toString() {
        return "CompletedContinuation(result=" + this.f1854a + ", cancelHandler=" + this.f1855b + ", onCancellation=" + this.f1856c + ", idempotentResume=" + this.f1857d + ", cancelCause=" + this.f1858e + ')';
    }

    public /* synthetic */ C0137k(Object obj, M m5, E3.l lVar, CancellationException cancellationException, int i5) {
        this(obj, (i5 & 2) != 0 ? null : m5, (i5 & 4) != 0 ? null : lVar, (Object) null, (i5 & 16) != 0 ? null : cancellationException);
    }
}
