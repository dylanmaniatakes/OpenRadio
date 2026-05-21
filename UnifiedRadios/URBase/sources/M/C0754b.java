package m;

import java.util.Iterator;

/* renamed from: m.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0754b extends AbstractC0757e implements Iterator {

    /* renamed from: j, reason: collision with root package name */
    public C0755c f8494j;

    /* renamed from: k, reason: collision with root package name */
    public C0755c f8495k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f8496l;

    public C0754b(C0755c c0755c, C0755c c0755c2, int i5) {
        this.f8496l = i5;
        this.f8494j = c0755c2;
        this.f8495k = c0755c;
    }

    @Override // m.AbstractC0757e
    public final void a(C0755c c0755c) {
        C0755c c0755cC = null;
        if (this.f8494j == c0755c && c0755c == this.f8495k) {
            this.f8495k = null;
            this.f8494j = null;
        }
        C0755c c0755c2 = this.f8494j;
        if (c0755c2 == c0755c) {
            this.f8494j = b(c0755c2);
        }
        C0755c c0755c3 = this.f8495k;
        if (c0755c3 == c0755c) {
            C0755c c0755c4 = this.f8494j;
            if (c0755c3 != c0755c4 && c0755c4 != null) {
                c0755cC = c(c0755c3);
            }
            this.f8495k = c0755cC;
        }
    }

    public final C0755c b(C0755c c0755c) {
        switch (this.f8496l) {
            case 0:
                return c0755c.f8500m;
            default:
                return c0755c.f8499l;
        }
    }

    public final C0755c c(C0755c c0755c) {
        switch (this.f8496l) {
            case 0:
                return c0755c.f8499l;
            default:
                return c0755c.f8500m;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f8495k != null;
    }

    @Override // java.util.Iterator
    public final Object next() {
        C0755c c0755c = this.f8495k;
        C0755c c0755c2 = this.f8494j;
        this.f8495k = (c0755c == c0755c2 || c0755c2 == null) ? null : c(c0755c);
        return c0755c;
    }
}
