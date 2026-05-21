package p1;

import java.util.Set;
import n1.C0785b;
import q1.InterfaceC0853d;
import q1.InterfaceC0859j;

/* loaded from: classes.dex */
public final class v implements InterfaceC0853d {

    /* renamed from: a, reason: collision with root package name */
    public final o1.c f9149a;

    /* renamed from: b, reason: collision with root package name */
    public final C0826b f9150b;

    /* renamed from: c, reason: collision with root package name */
    public InterfaceC0859j f9151c = null;

    /* renamed from: d, reason: collision with root package name */
    public Set f9152d = null;

    /* renamed from: e, reason: collision with root package name */
    public boolean f9153e = false;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ C0832h f9154f;

    public v(C0832h c0832h, o1.c cVar, C0826b c0826b) {
        this.f9154f = c0832h;
        this.f9149a = cVar;
        this.f9150b = c0826b;
    }

    public final void a(C0785b c0785b) {
        t tVar = (t) this.f9154f.f9123j.get(this.f9150b);
        if (tVar != null) {
            tVar.p(c0785b);
        }
    }

    @Override // q1.InterfaceC0853d
    public final void d(C0785b c0785b) {
        this.f9154f.n.post(new N1.p(this, 9, c0785b));
    }
}
