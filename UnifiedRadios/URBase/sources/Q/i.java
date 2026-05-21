package q;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import l0.AbstractC0740p;

/* loaded from: classes.dex */
public final class i implements Iterator, Map.Entry {

    /* renamed from: j, reason: collision with root package name */
    public int f9268j;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ AbstractC0740p f9271m;

    /* renamed from: l, reason: collision with root package name */
    public boolean f9270l = false;

    /* renamed from: k, reason: collision with root package name */
    public int f9269k = -1;

    public i(AbstractC0740p abstractC0740p) {
        this.f9271m = abstractC0740p;
        this.f9268j = abstractC0740p.e() - 1;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!this.f9270l) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        int i5 = this.f9269k;
        AbstractC0740p abstractC0740p = this.f9271m;
        Object objC = abstractC0740p.c(i5, 0);
        if (key != objC && (key == null || !key.equals(objC))) {
            return false;
        }
        Object value = entry.getValue();
        Object objC2 = abstractC0740p.c(this.f9269k, 1);
        return value == objC2 || (value != null && value.equals(objC2));
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        if (!this.f9270l) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        return this.f9271m.c(this.f9269k, 0);
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (!this.f9270l) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        return this.f9271m.c(this.f9269k, 1);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f9269k < this.f9268j;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        if (!this.f9270l) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        int i5 = this.f9269k;
        AbstractC0740p abstractC0740p = this.f9271m;
        Object objC = abstractC0740p.c(i5, 0);
        Object objC2 = abstractC0740p.c(this.f9269k, 1);
        return (objC == null ? 0 : objC.hashCode()) ^ (objC2 != null ? objC2.hashCode() : 0);
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f9269k++;
        this.f9270l = true;
        return this;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f9270l) {
            throw new IllegalStateException();
        }
        this.f9271m.i(this.f9269k);
        this.f9269k--;
        this.f9268j--;
        this.f9270l = false;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (this.f9270l) {
            return this.f9271m.j(this.f9269k, obj);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public final String toString() {
        return getKey() + "=" + getValue();
    }
}
