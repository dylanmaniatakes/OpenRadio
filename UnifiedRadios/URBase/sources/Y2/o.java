package y2;

import D1.S;

/* loaded from: classes.dex */
public final class o extends f {

    /* renamed from: m, reason: collision with root package name */
    public final transient Object f10522m;

    public o(Object obj) {
        this.f10522m = obj;
    }

    @Override // y2.AbstractC0982a
    public final int a(Object[] objArr) {
        objArr[0] = this.f10522m;
        return 1;
    }

    @Override // y2.AbstractC0982a, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f10522m.equals(obj);
    }

    @Override // y2.f, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.f10522m.hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public final S iterator() {
        return new g(this.f10522m);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        String string = this.f10522m.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 2);
        sb.append('[');
        sb.append(string);
        sb.append(']');
        return sb.toString();
    }
}
