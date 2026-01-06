package q;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class b extends k implements Map {

    /* renamed from: q, reason: collision with root package name */
    public C0837a f9241q;

    public b() {
    }

    @Override // java.util.Map
    public final Set entrySet() {
        if (this.f9241q == null) {
            this.f9241q = new C0837a(0, this);
        }
        C0837a c0837a = this.f9241q;
        if (((h) c0837a.f8382a) == null) {
            c0837a.f8382a = new h(c0837a, 0);
        }
        return (h) c0837a.f8382a;
    }

    @Override // java.util.Map
    public final Set keySet() {
        if (this.f9241q == null) {
            this.f9241q = new C0837a(0, this);
        }
        C0837a c0837a = this.f9241q;
        if (((h) c0837a.f8383b) == null) {
            c0837a.f8383b = new h(c0837a, 1);
        }
        return (h) c0837a.f8383b;
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        b(map.size() + this.f9278l);
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public final Collection values() {
        if (this.f9241q == null) {
            this.f9241q = new C0837a(0, this);
        }
        C0837a c0837a = this.f9241q;
        if (((j) c0837a.f8384c) == null) {
            c0837a.f8384c = new j(c0837a);
        }
        return (j) c0837a.f8384c;
    }

    public b(k kVar) {
        int i5 = kVar.f9278l;
        b(i5);
        if (this.f9278l != 0) {
            for (int i6 = 0; i6 < i5; i6++) {
                put(kVar.h(i6), kVar.j(i6));
            }
        } else if (i5 > 0) {
            System.arraycopy(kVar.f9276j, 0, this.f9276j, 0, i5);
            System.arraycopy(kVar.f9277k, 0, this.f9277k, 0, i5 << 1);
            this.f9278l = i5;
        }
    }
}
