package k4;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class j implements k, Iterable {

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f8281j = new ArrayList();

    @Override // k4.k
    public final boolean a(long j5) {
        Iterator it = this.f8281j.iterator();
        while (it.hasNext()) {
            if (((g) it.next()).a(j5)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new i(this);
    }
}
