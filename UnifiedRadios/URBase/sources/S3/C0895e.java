package s3;

import java.io.Serializable;

/* renamed from: s3.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0895e implements Serializable {

    /* renamed from: j, reason: collision with root package name */
    public final Object f9687j;

    /* renamed from: k, reason: collision with root package name */
    public final Object f9688k;

    public C0895e(Object obj, Object obj2) {
        this.f9687j = obj;
        this.f9688k = obj2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0895e)) {
            return false;
        }
        C0895e c0895e = (C0895e) obj;
        return F3.i.a(this.f9687j, c0895e.f9687j) && F3.i.a(this.f9688k, c0895e.f9688k);
    }

    public final int hashCode() {
        Object obj = this.f9687j;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f9688k;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public final String toString() {
        return "(" + this.f9687j + ", " + this.f9688k + ')';
    }
}
