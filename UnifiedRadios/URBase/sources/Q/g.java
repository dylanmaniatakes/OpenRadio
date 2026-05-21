package q;

import java.util.Iterator;
import java.util.NoSuchElementException;
import l0.AbstractC0740p;

/* loaded from: classes.dex */
public final class g implements Iterator {

    /* renamed from: j, reason: collision with root package name */
    public final int f9262j;

    /* renamed from: k, reason: collision with root package name */
    public int f9263k;

    /* renamed from: l, reason: collision with root package name */
    public int f9264l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f9265m = false;
    public final /* synthetic */ AbstractC0740p n;

    public g(AbstractC0740p abstractC0740p, int i5) {
        this.n = abstractC0740p;
        this.f9262j = i5;
        this.f9263k = abstractC0740p.e();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f9264l < this.f9263k;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Object objC = this.n.c(this.f9264l, this.f9262j);
        this.f9264l++;
        this.f9265m = true;
        return objC;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f9265m) {
            throw new IllegalStateException();
        }
        int i5 = this.f9264l - 1;
        this.f9264l = i5;
        this.f9263k--;
        this.f9265m = false;
        this.n.i(i5);
    }
}
