package F3;

import g0.AbstractC0535a;
import s3.InterfaceC0891a;

/* loaded from: classes.dex */
public abstract class h extends c implements g, K3.a, InterfaceC0891a {

    /* renamed from: p, reason: collision with root package name */
    public final int f598p;

    /* renamed from: q, reason: collision with root package name */
    public final int f599q;

    public h(int i5, Object obj, Class cls, String str, String str2, int i6) {
        super(obj, cls, str, str2, (i6 & 1) == 1);
        this.f598p = i5;
        this.f599q = 0;
    }

    public final K3.a b() {
        m.f603a.getClass();
        return this;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            return this.f593m.equals(hVar.f593m) && this.n.equals(hVar.n) && this.f599q == hVar.f599q && this.f598p == hVar.f598p && i.a(this.f591k, hVar.f591k) && i.a(a(), hVar.a());
        }
        if (!(obj instanceof h)) {
            return false;
        }
        K3.a aVar = this.f590j;
        if (aVar == null) {
            b();
            this.f590j = this;
            aVar = this;
        }
        return obj.equals(aVar);
    }

    @Override // F3.g
    public final int getArity() {
        return this.f598p;
    }

    public final int hashCode() {
        return this.n.hashCode() + ((this.f593m.hashCode() + (a() == null ? 0 : a().hashCode() * 31)) * 31);
    }

    public final String toString() {
        K3.a aVar = this.f590j;
        if (aVar == null) {
            b();
            this.f590j = this;
            aVar = this;
        }
        if (aVar != this) {
            return aVar.toString();
        }
        String str = this.f593m;
        return "<init>".equals(str) ? "constructor (Kotlin reflection is not available)" : AbstractC0535a.l("function ", str, " (Kotlin reflection is not available)");
    }
}
