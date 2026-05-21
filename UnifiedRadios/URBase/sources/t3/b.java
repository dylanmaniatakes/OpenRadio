package t3;

import com.google.android.gms.internal.measurement.AbstractC0409x1;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class b extends c implements RandomAccess {

    /* renamed from: j, reason: collision with root package name */
    public final c f9701j;

    /* renamed from: k, reason: collision with root package name */
    public final int f9702k;

    /* renamed from: l, reason: collision with root package name */
    public final int f9703l;

    public b(c cVar, int i5, int i6) {
        F3.i.f(cVar, "list");
        this.f9701j = cVar;
        this.f9702k = i5;
        AbstractC0409x1.a(i5, i6, cVar.a());
        this.f9703l = i6 - i5;
    }

    @Override // t3.c
    public final int a() {
        return this.f9703l;
    }

    @Override // java.util.List
    public final Object get(int i5) {
        int i6 = this.f9703l;
        if (i5 < 0 || i5 >= i6) {
            throw new IndexOutOfBoundsException(com.unified.ur1.SatelliteTracker.h.c("index: ", ", size: ", i5, i6));
        }
        return this.f9701j.get(this.f9702k + i5);
    }
}
