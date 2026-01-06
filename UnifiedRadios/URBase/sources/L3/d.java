package L3;

import com.google.android.gms.internal.measurement.AbstractC0399v1;
import java.util.Iterator;
import java.util.NoSuchElementException;
import s3.C0900j;
import w3.C0942j;
import w3.InterfaceC0936d;
import w3.InterfaceC0941i;

/* loaded from: classes.dex */
public final class d implements Iterator, InterfaceC0936d, G3.a {

    /* renamed from: j, reason: collision with root package name */
    public int f1629j;

    /* renamed from: k, reason: collision with root package name */
    public Object f1630k;

    /* renamed from: l, reason: collision with root package name */
    public Iterator f1631l;

    /* renamed from: m, reason: collision with root package name */
    public InterfaceC0936d f1632m;

    public final RuntimeException a() {
        int i5 = this.f1629j;
        if (i5 == 4) {
            return new NoSuchElementException();
        }
        if (i5 == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.f1629j);
    }

    @Override // w3.InterfaceC0936d
    public final InterfaceC0941i getContext() {
        return C0942j.f10143j;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        while (true) {
            int i5 = this.f1629j;
            if (i5 != 0) {
                if (i5 != 1) {
                    if (i5 == 2 || i5 == 3) {
                        return true;
                    }
                    if (i5 == 4) {
                        return false;
                    }
                    throw a();
                }
                Iterator it = this.f1631l;
                F3.i.c(it);
                if (it.hasNext()) {
                    this.f1629j = 2;
                    return true;
                }
                this.f1631l = null;
            }
            this.f1629j = 5;
            InterfaceC0936d interfaceC0936d = this.f1632m;
            F3.i.c(interfaceC0936d);
            this.f1632m = null;
            interfaceC0936d.resumeWith(C0900j.f9694a);
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i5 = this.f1629j;
        if (i5 == 0 || i5 == 1) {
            if (hasNext()) {
                return next();
            }
            throw new NoSuchElementException();
        }
        if (i5 == 2) {
            this.f1629j = 1;
            Iterator it = this.f1631l;
            F3.i.c(it);
            return it.next();
        }
        if (i5 != 3) {
            throw a();
        }
        this.f1629j = 0;
        Object obj = this.f1630k;
        this.f1630k = null;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // w3.InterfaceC0936d
    public final void resumeWith(Object obj) {
        AbstractC0399v1.j(obj);
        this.f1629j = 4;
    }
}
