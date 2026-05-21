package L0;

import g0.AbstractC0535a;
import s.AbstractC0882e;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public String f1559a;

    /* renamed from: b, reason: collision with root package name */
    public int f1560b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return F3.i.a(this.f1559a, nVar.f1559a) && this.f1560b == nVar.f1560b;
    }

    public final int hashCode() {
        return AbstractC0882e.c(this.f1560b) + (this.f1559a.hashCode() * 31);
    }

    public final String toString() {
        return "IdAndState(id=" + this.f1559a + ", state=" + AbstractC0535a.y(this.f1560b) + ')';
    }
}
