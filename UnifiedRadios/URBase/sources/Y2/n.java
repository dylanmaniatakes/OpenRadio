package y2;

import D1.S;
import com.google.android.gms.internal.measurement.AbstractC0399v1;

/* loaded from: classes.dex */
public final class n extends f {

    /* renamed from: r, reason: collision with root package name */
    public static final Object[] f10516r;

    /* renamed from: s, reason: collision with root package name */
    public static final n f10517s;

    /* renamed from: m, reason: collision with root package name */
    public final transient Object[] f10518m;
    public final transient int n;

    /* renamed from: o, reason: collision with root package name */
    public final transient Object[] f10519o;

    /* renamed from: p, reason: collision with root package name */
    public final transient int f10520p;

    /* renamed from: q, reason: collision with root package name */
    public final transient int f10521q;

    static {
        Object[] objArr = new Object[0];
        f10516r = objArr;
        f10517s = new n(0, 0, 0, objArr, objArr);
    }

    public n(int i5, int i6, int i7, Object[] objArr, Object[] objArr2) {
        this.f10518m = objArr;
        this.n = i5;
        this.f10519o = objArr2;
        this.f10520p = i6;
        this.f10521q = i7;
    }

    @Override // y2.AbstractC0982a
    public final int a(Object[] objArr) {
        Object[] objArr2 = this.f10518m;
        int i5 = this.f10521q;
        System.arraycopy(objArr2, 0, objArr, 0, i5);
        return i5;
    }

    @Override // y2.AbstractC0982a
    public final Object[] b() {
        return this.f10518m;
    }

    @Override // y2.AbstractC0982a, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj != null) {
            Object[] objArr = this.f10519o;
            if (objArr.length != 0) {
                int i5 = AbstractC0399v1.i(obj.hashCode());
                while (true) {
                    int i6 = i5 & this.f10520p;
                    Object obj2 = objArr[i6];
                    if (obj2 == null) {
                        return false;
                    }
                    if (obj2.equals(obj)) {
                        return true;
                    }
                    i5 = i6 + 1;
                }
            }
        }
        return false;
    }

    @Override // y2.AbstractC0982a
    public final int d() {
        return this.f10521q;
    }

    @Override // y2.AbstractC0982a
    public final int e() {
        return 0;
    }

    @Override // y2.f, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.n;
    }

    @Override // y2.f
    public final AbstractC0985d i() {
        return AbstractC0985d.f(this.f10521q, this.f10518m);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public final S iterator() {
        return f().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f10521q;
    }
}
