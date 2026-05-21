package q;

import java.util.Map;
import l0.AbstractC0740p;

/* renamed from: q.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0837a extends AbstractC0740p {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f9239d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f9240e;

    public /* synthetic */ C0837a(int i5, Object obj) {
        this.f9239d = i5;
        this.f9240e = obj;
    }

    @Override // l0.AbstractC0740p
    public final void b() {
        switch (this.f9239d) {
            case 0:
                ((b) this.f9240e).clear();
                break;
            default:
                ((c) this.f9240e).clear();
                break;
        }
    }

    @Override // l0.AbstractC0740p
    public final Object c(int i5, int i6) {
        switch (this.f9239d) {
            case 0:
                return ((b) this.f9240e).f9277k[(i5 << 1) + i6];
            default:
                return ((c) this.f9240e).f9248k[i5];
        }
    }

    @Override // l0.AbstractC0740p
    public final Map d() {
        switch (this.f9239d) {
            case 0:
                return (b) this.f9240e;
            default:
                throw new UnsupportedOperationException("not a map");
        }
    }

    @Override // l0.AbstractC0740p
    public final int e() {
        switch (this.f9239d) {
            case 0:
                return ((b) this.f9240e).f9278l;
            default:
                return ((c) this.f9240e).f9249l;
        }
    }

    @Override // l0.AbstractC0740p
    public final int f(Object obj) {
        switch (this.f9239d) {
            case 0:
                return ((b) this.f9240e).e(obj);
            default:
                return ((c) this.f9240e).indexOf(obj);
        }
    }

    @Override // l0.AbstractC0740p
    public final int g(Object obj) {
        switch (this.f9239d) {
            case 0:
                return ((b) this.f9240e).g(obj);
            default:
                return ((c) this.f9240e).indexOf(obj);
        }
    }

    @Override // l0.AbstractC0740p
    public final void h(Object obj, Object obj2) {
        switch (this.f9239d) {
            case 0:
                ((b) this.f9240e).put(obj, obj2);
                break;
            default:
                ((c) this.f9240e).add(obj);
                break;
        }
    }

    @Override // l0.AbstractC0740p
    public final void i(int i5) {
        switch (this.f9239d) {
            case 0:
                ((b) this.f9240e).i(i5);
                break;
            default:
                ((c) this.f9240e).f(i5);
                break;
        }
    }

    @Override // l0.AbstractC0740p
    public final Object j(int i5, Object obj) {
        switch (this.f9239d) {
            case 0:
                int i6 = (i5 << 1) + 1;
                Object[] objArr = ((b) this.f9240e).f9277k;
                Object obj2 = objArr[i6];
                objArr[i6] = obj;
                return obj2;
            default:
                throw new UnsupportedOperationException("not a map");
        }
    }
}
