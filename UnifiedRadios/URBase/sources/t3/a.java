package t3;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class a extends F3.a implements ListIterator {

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ c f9700m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c cVar, int i5) {
        super(cVar);
        this.f9700m = cVar;
        int iA = cVar.a();
        if (i5 < 0 || i5 > iA) {
            throw new IndexOutOfBoundsException(com.unified.ur1.SatelliteTracker.h.c("index: ", ", size: ", i5, iA));
        }
        this.f587k = i5;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f587k > 0;
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f587k;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i5 = this.f587k - 1;
        this.f587k = i5;
        return this.f9700m.get(i5);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f587k - 1;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
