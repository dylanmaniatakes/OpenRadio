package m;

import java.util.HashMap;

/* renamed from: m.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0753a extends C0758f {
    public final HashMap n = new HashMap();

    @Override // m.C0758f
    public final C0755c a(Object obj) {
        return (C0755c) this.n.get(obj);
    }

    @Override // m.C0758f
    public final Object b(Object obj) {
        Object objB = super.b(obj);
        this.n.remove(obj);
        return objB;
    }

    public final Object d(Object obj, Object obj2) {
        C0755c c0755cA = a(obj);
        if (c0755cA != null) {
            return c0755cA.f8498k;
        }
        HashMap map = this.n;
        C0755c c0755c = new C0755c(obj, obj2);
        this.f8507m++;
        C0755c c0755c2 = this.f8505k;
        if (c0755c2 == null) {
            this.f8504j = c0755c;
            this.f8505k = c0755c;
        } else {
            c0755c2.f8499l = c0755c;
            c0755c.f8500m = c0755c2;
            this.f8505k = c0755c;
        }
        map.put(obj, c0755c);
        return null;
    }
}
