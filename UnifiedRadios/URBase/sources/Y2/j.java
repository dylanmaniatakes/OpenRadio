package y2;

import D1.S;
import java.util.Map;

/* loaded from: classes.dex */
public final class j extends f {

    /* renamed from: m, reason: collision with root package name */
    public final transient m f10504m;
    public final transient Object[] n;

    /* renamed from: o, reason: collision with root package name */
    public final transient int f10505o = 0;

    /* renamed from: p, reason: collision with root package name */
    public final transient int f10506p;

    public j(m mVar, Object[] objArr, int i5) {
        this.f10504m = mVar;
        this.n = objArr;
        this.f10506p = i5;
    }

    @Override // y2.AbstractC0982a
    public final int a(Object[] objArr) {
        return f().a(objArr);
    }

    @Override // y2.AbstractC0982a, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        Object value = entry.getValue();
        return value != null && value.equals(this.f10504m.get(key));
    }

    @Override // y2.f
    public final AbstractC0985d i() {
        return new i(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public final S iterator() {
        return f().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f10506p;
    }
}
