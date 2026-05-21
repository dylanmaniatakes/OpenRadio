package N1;

import java.util.concurrent.Executor;
import z2.RunnableC0999a;

/* loaded from: classes.dex */
public final class n implements q, g, f, d {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1793c;

    /* renamed from: d, reason: collision with root package name */
    public final Executor f1794d;

    /* renamed from: e, reason: collision with root package name */
    public final b f1795e;

    /* renamed from: f, reason: collision with root package name */
    public final r f1796f;

    public /* synthetic */ n(Executor executor, b bVar, r rVar, int i5) {
        this.f1793c = i5;
        this.f1794d = executor;
        this.f1795e = bVar;
        this.f1796f = rVar;
    }

    @Override // N1.q
    public final void a(j jVar) {
        switch (this.f1793c) {
            case 0:
                this.f1794d.execute(new RunnableC0999a(26, this, jVar, false));
                break;
            default:
                this.f1794d.execute(new RunnableC0999a(27, this, jVar, false));
                break;
        }
    }

    @Override // N1.d
    public void b() {
        this.f1796f.n();
    }

    @Override // N1.f
    public void d(Exception exc) {
        this.f1796f.l(exc);
    }

    @Override // N1.g
    public void h(Object obj) {
        this.f1796f.m(obj);
    }
}
