package w0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class r extends q {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q.b f10102a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s f10103b;

    public r(s sVar, q.b bVar) {
        this.f10103b = sVar;
        this.f10102a = bVar;
    }

    @Override // w0.o
    public final void e(p pVar) {
        ((ArrayList) this.f10102a.getOrDefault(this.f10103b.f10105d, null)).remove(pVar);
        pVar.v(this);
    }
}
