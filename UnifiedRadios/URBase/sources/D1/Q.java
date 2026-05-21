package D1;

import com.google.android.gms.internal.measurement.AbstractC0296a2;
import java.util.Objects;

/* loaded from: classes.dex */
public final class Q extends P {
    public static final Q n = new Q(0, new Object[0]);

    /* renamed from: l, reason: collision with root package name */
    public final transient Object[] f373l;

    /* renamed from: m, reason: collision with root package name */
    public final transient int f374m;

    public Q(int i5, Object[] objArr) {
        this.f373l = objArr;
        this.f374m = i5;
    }

    @Override // D1.M
    public final Object[] a() {
        return this.f373l;
    }

    @Override // D1.M
    public final int b() {
        return 0;
    }

    @Override // D1.M
    public final int d() {
        return this.f374m;
    }

    @Override // D1.M
    public final boolean e() {
        return false;
    }

    @Override // D1.P, D1.M
    public final int f(Object[] objArr) {
        Object[] objArr2 = this.f373l;
        int i5 = this.f374m;
        System.arraycopy(objArr2, 0, objArr, 0, i5);
        return i5;
    }

    @Override // java.util.List
    public final Object get(int i5) {
        AbstractC0296a2.s(i5, this.f374m);
        Object obj = this.f373l[i5];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f374m;
    }
}
