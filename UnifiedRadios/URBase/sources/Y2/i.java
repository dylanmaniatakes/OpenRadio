package y2;

import java.util.AbstractMap;
import java.util.Objects;

/* loaded from: classes.dex */
public final class i extends AbstractC0985d {

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ j f10503l;

    public i(j jVar) {
        this.f10503l = jVar;
    }

    @Override // java.util.List
    public final Object get(int i5) {
        j jVar = this.f10503l;
        L0.f.c(i5, jVar.f10506p);
        int i6 = i5 * 2;
        int i7 = jVar.f10505o;
        Object[] objArr = jVar.n;
        Object obj = objArr[i6 + i7];
        Objects.requireNonNull(obj);
        Object obj2 = objArr[i6 + (i7 ^ 1)];
        Objects.requireNonNull(obj2);
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f10503l.f10506p;
    }
}
