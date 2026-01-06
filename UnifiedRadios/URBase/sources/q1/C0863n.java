package q1;

import n1.C0785b;

/* renamed from: q1.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0863n implements InterfaceC0853d, InterfaceC0851b, InterfaceC0852c {

    /* renamed from: b, reason: collision with root package name */
    public static C0863n f9399b;

    /* renamed from: c, reason: collision with root package name */
    public static final C0864o f9400c = new C0864o(0, false, false, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    public Object f9401a;

    public /* synthetic */ C0863n(Object obj) {
        this.f9401a = obj;
    }

    public static synchronized C0863n e() {
        try {
            if (f9399b == null) {
                f9399b = new C0863n();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f9399b;
    }

    @Override // q1.InterfaceC0851b
    public void a(int i5) {
        ((o1.i) this.f9401a).a(i5);
    }

    @Override // q1.InterfaceC0852c
    public void b(C0785b c0785b) {
        ((o1.j) this.f9401a).b(c0785b);
    }

    @Override // q1.InterfaceC0851b
    public void c() {
        ((o1.i) this.f9401a).c();
    }

    @Override // q1.InterfaceC0853d
    public void d(C0785b c0785b) {
        boolean z4 = c0785b.f8728k == 0;
        AbstractC0854e abstractC0854e = (AbstractC0854e) this.f9401a;
        if (z4) {
            abstractC0854e.c(null, abstractC0854e.s());
            return;
        }
        InterfaceC0852c interfaceC0852c = abstractC0854e.f9358p;
        if (interfaceC0852c != null) {
            interfaceC0852c.b(c0785b);
        }
    }
}
