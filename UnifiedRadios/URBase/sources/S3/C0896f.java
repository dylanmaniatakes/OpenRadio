package s3;

import java.io.Serializable;

/* renamed from: s3.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0896f implements Serializable {

    /* renamed from: j, reason: collision with root package name */
    public final Throwable f9689j;

    public C0896f(Throwable th) {
        F3.i.f(th, "exception");
        this.f9689j = th;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C0896f) {
            if (F3.i.a(this.f9689j, ((C0896f) obj).f9689j)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f9689j.hashCode();
    }

    public final String toString() {
        return "Failure(" + this.f9689j + ')';
    }
}
