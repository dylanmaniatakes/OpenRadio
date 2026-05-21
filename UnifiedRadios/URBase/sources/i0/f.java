package I0;

import C0.t;
import F3.i;
import L0.o;

/* loaded from: classes.dex */
public final class f extends e {

    /* renamed from: b, reason: collision with root package name */
    public final int f678b;

    static {
        i.e(t.f("NetworkMeteredCtrlr"), "tagWithPrefix(\"NetworkMeteredCtrlr\")");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(J0.f fVar) {
        super(fVar);
        i.f(fVar, "tracker");
        this.f678b = 7;
    }

    @Override // I0.e
    public final int a() {
        return this.f678b;
    }

    @Override // I0.e
    public final boolean b(o oVar) {
        i.f(oVar, "workSpec");
        return oVar.f1568j.f143a == 5;
    }

    @Override // I0.e
    public final boolean c(Object obj) {
        H0.d dVar = (H0.d) obj;
        i.f(dVar, "value");
        return (dVar.f646a && dVar.f648c) ? false : true;
    }
}
