package u;

import java.util.ArrayList;
import v.n;

/* loaded from: classes.dex */
public abstract class i extends d {

    /* renamed from: q0, reason: collision with root package name */
    public d[] f9876q0 = new d[4];

    /* renamed from: r0, reason: collision with root package name */
    public int f9877r0 = 0;

    public final void R(int i5, ArrayList arrayList, n nVar) {
        for (int i6 = 0; i6 < this.f9877r0; i6++) {
            d dVar = this.f9876q0[i6];
            ArrayList arrayList2 = nVar.f9999a;
            if (!arrayList2.contains(dVar)) {
                arrayList2.add(dVar);
            }
        }
        for (int i7 = 0; i7 < this.f9877r0; i7++) {
            v.h.b(this.f9876q0[i7], i5, arrayList, nVar);
        }
    }

    public void S() {
    }
}
