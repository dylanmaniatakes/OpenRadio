package k4;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class i implements Iterator {

    /* renamed from: j, reason: collision with root package name */
    public int f8278j;

    /* renamed from: k, reason: collision with root package name */
    public e f8279k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ j f8280l;

    public i(j jVar) {
        this.f8280l = jVar;
    }

    public final Iterator a() {
        e eVar = this.f8279k;
        if (eVar != null) {
            return eVar;
        }
        int i5 = this.f8278j;
        j jVar = this.f8280l;
        if (i5 >= jVar.f8281j.size()) {
            return null;
        }
        ArrayList arrayList = jVar.f8281j;
        int i6 = this.f8278j;
        this.f8278j = i6 + 1;
        g gVar = (g) arrayList.get(i6);
        gVar.getClass();
        e eVar2 = new e(gVar, 1);
        this.f8279k = eVar2;
        return eVar2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        Iterator itA = a();
        return itA != null && itA.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        Long l5 = (Long) ((e) a()).next();
        l5.getClass();
        if (!((e) a()).hasNext()) {
            this.f8279k = null;
        }
        return l5;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
