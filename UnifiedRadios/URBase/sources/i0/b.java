package I0;

import F3.i;
import F3.j;
import s3.C0900j;

/* loaded from: classes.dex */
public final class b extends j implements E3.a {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ e f670j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ c f671k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(e eVar, c cVar) {
        super(0);
        this.f670j = eVar;
        this.f671k = cVar;
    }

    @Override // E3.a
    public final Object invoke() {
        J0.f fVar = this.f670j.f677a;
        c cVar = this.f671k;
        fVar.getClass();
        i.f(cVar, "listener");
        synchronized (fVar.f688c) {
            if (fVar.f689d.remove(cVar) && fVar.f689d.isEmpty()) {
                fVar.d();
            }
        }
        return C0900j.f9694a;
    }
}
