package v;

import java.util.Iterator;

/* loaded from: classes.dex */
public class g extends f {

    /* renamed from: m, reason: collision with root package name */
    public int f9991m;

    public g(o oVar) {
        super(oVar);
        if (oVar instanceof k) {
            this.f9985e = 2;
        } else {
            this.f9985e = 3;
        }
    }

    @Override // v.f
    public final void d(int i5) {
        if (this.f9988j) {
            return;
        }
        this.f9988j = true;
        this.g = i5;
        Iterator it = this.f9989k.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            dVar.a(dVar);
        }
    }
}
