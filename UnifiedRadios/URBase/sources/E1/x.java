package E1;

import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class x extends D1.S {

    /* renamed from: k, reason: collision with root package name */
    public boolean f482k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f483l;

    public x(Object obj) {
        super(1);
        this.f483l = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.f482k;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f482k) {
            throw new NoSuchElementException();
        }
        this.f482k = true;
        return this.f483l;
    }
}
