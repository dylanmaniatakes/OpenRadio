package L3;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class b implements c {

    /* renamed from: a, reason: collision with root package name */
    public final c f1627a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1628b;

    public b(c cVar, int i5) {
        this.f1627a = cVar;
        this.f1628b = i5;
        if (i5 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i5 + '.').toString());
    }

    @Override // L3.c
    public final Iterator iterator() {
        return new F3.a(this);
    }
}
