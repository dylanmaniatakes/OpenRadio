package E1;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class z extends AbstractC0049w {

    /* renamed from: r, reason: collision with root package name */
    public static final Object[] f486r;

    /* renamed from: s, reason: collision with root package name */
    public static final z f487s;

    /* renamed from: m, reason: collision with root package name */
    public final transient Object[] f488m;
    public final transient int n;

    /* renamed from: o, reason: collision with root package name */
    public final transient Object[] f489o;

    /* renamed from: p, reason: collision with root package name */
    public final transient int f490p;

    /* renamed from: q, reason: collision with root package name */
    public final transient int f491q;

    static {
        Object[] objArr = new Object[0];
        f486r = objArr;
        f487s = new z(0, 0, 0, objArr, objArr);
    }

    public z(int i5, int i6, int i7, Object[] objArr, Object[] objArr2) {
        this.f488m = objArr;
        this.n = i5;
        this.f489o = objArr2;
        this.f490p = i6;
        this.f491q = i7;
    }

    @Override // E1.r
    public final int a(Object[] objArr) {
        Object[] objArr2 = this.f488m;
        int i5 = this.f491q;
        System.arraycopy(objArr2, 0, objArr, 0, i5);
        return i5;
    }

    @Override // E1.r
    public final int b() {
        return this.f491q;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj != null) {
            Object[] objArr = this.f489o;
            if (objArr.length != 0) {
                int iRotateLeft = (int) (Integer.rotateLeft((int) (obj.hashCode() * (-862048943)), 15) * 461845907);
                while (true) {
                    int i5 = iRotateLeft & this.f490p;
                    Object obj2 = objArr[i5];
                    if (obj2 == null) {
                        return false;
                    }
                    if (obj2.equals(obj)) {
                        return true;
                    }
                    iRotateLeft = i5 + 1;
                }
            }
        }
        return false;
    }

    @Override // E1.r
    public final int d() {
        return 0;
    }

    @Override // E1.r
    public final Object[] e() {
        return this.f488m;
    }

    public final y h() {
        C0045s c0045s = AbstractC0047u.f479k;
        int i5 = this.f491q;
        return i5 == 0 ? y.n : new y(i5, this.f488m);
    }

    @Override // E1.AbstractC0049w, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.n;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        AbstractC0047u abstractC0047uH = this.f481k;
        if (abstractC0047uH == null) {
            abstractC0047uH = h();
            this.f481k = abstractC0047uH;
        }
        return abstractC0047uH.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f491q;
    }
}
