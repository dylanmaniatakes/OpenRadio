package y2;

import D1.S;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class g extends S {

    /* renamed from: k, reason: collision with root package name */
    public boolean f10499k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f10500l;

    public g(Object obj) {
        super(2);
        this.f10500l = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.f10499k;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f10499k) {
            throw new NoSuchElementException();
        }
        this.f10499k = true;
        return this.f10500l;
    }
}
