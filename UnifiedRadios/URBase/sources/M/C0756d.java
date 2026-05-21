package m;

import java.util.Iterator;

/* renamed from: m.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0756d extends AbstractC0757e implements Iterator {

    /* renamed from: j, reason: collision with root package name */
    public C0755c f8501j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f8502k = true;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ C0758f f8503l;

    public C0756d(C0758f c0758f) {
        this.f8503l = c0758f;
    }

    @Override // m.AbstractC0757e
    public final void a(C0755c c0755c) {
        C0755c c0755c2 = this.f8501j;
        if (c0755c == c0755c2) {
            C0755c c0755c3 = c0755c2.f8500m;
            this.f8501j = c0755c3;
            this.f8502k = c0755c3 == null;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f8502k) {
            return this.f8503l.f8504j != null;
        }
        C0755c c0755c = this.f8501j;
        return (c0755c == null || c0755c.f8499l == null) ? false : true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f8502k) {
            this.f8502k = false;
            this.f8501j = this.f8503l.f8504j;
        } else {
            C0755c c0755c = this.f8501j;
            this.f8501j = c0755c != null ? c0755c.f8499l : null;
        }
        return this.f8501j;
    }
}
