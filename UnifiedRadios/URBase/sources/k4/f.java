package k4;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class f implements Iterable {

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f8270j = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    public int f8271k;

    public final void a(long j5, long j6) {
        o oVar;
        int i5 = this.f8271k;
        ArrayList arrayList = this.f8270j;
        if (i5 >= arrayList.size()) {
            oVar = new o();
            arrayList.add(oVar);
        } else {
            oVar = (o) arrayList.get(this.f8271k);
        }
        this.f8271k++;
        oVar.f8285a = j5;
        oVar.f8286b = j6;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new e(this, 0);
    }
}
