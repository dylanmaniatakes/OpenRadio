package Y0;

import J1.C;
import X2.t;
import d1.C0426a;
import d1.InterfaceC0427b;
import e1.C0436d;
import e1.C0442j;
import e1.C0443k;
import e1.C0444l;
import f1.C0475a;
import h1.AbstractC0557a;
import h1.C0558b;
import h1.C0559c;
import java.util.concurrent.Executor;
import m3.C0777m;
import r3.InterfaceC0877a;

/* loaded from: classes.dex */
public final class r implements InterfaceC0877a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2933c = 0;

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC0877a f2934d;

    /* renamed from: e, reason: collision with root package name */
    public final InterfaceC0877a f2935e;

    /* renamed from: f, reason: collision with root package name */
    public final InterfaceC0877a f2936f;
    public final InterfaceC0877a g;
    public final InterfaceC0877a h;

    public r(C0777m c0777m, InterfaceC0877a interfaceC0877a) {
        C0558b c0558b = AbstractC0557a.f7080a;
        C0559c c0559c = AbstractC0557a.f7081b;
        C c2 = f1.e.f6454c;
        this.f2934d = c0558b;
        this.f2935e = c0559c;
        this.f2936f = c2;
        this.g = c0777m;
        this.h = interfaceC0877a;
    }

    @Override // r3.InterfaceC0877a
    public final Object get() {
        switch (this.f2933c) {
            case 0:
                return new q((h1.d) this.f2934d.get(), (h1.d) this.f2935e.get(), (InterfaceC0427b) this.f2936f.get(), (C0442j) this.g.get(), (C0444l) this.h.get());
            case 1:
                return new C0426a((Executor) this.f2934d.get(), (Z0.e) this.f2935e.get(), (C0436d) this.f2936f.get(), (f1.d) this.g.get(), (g1.c) this.h.get());
            default:
                return new f1.j((h1.d) this.f2934d.get(), (h1.d) this.f2935e.get(), (C0475a) this.f2936f.get(), (f1.l) this.g.get(), this.h);
        }
    }

    public r(r rVar, C0443k c0443k, t tVar) {
        C0558b c0558b = AbstractC0557a.f7080a;
        C0559c c0559c = AbstractC0557a.f7081b;
        this.f2934d = c0558b;
        this.f2935e = c0559c;
        this.f2936f = rVar;
        this.g = c0443k;
        this.h = tVar;
    }

    public r(InterfaceC0877a interfaceC0877a, InterfaceC0877a interfaceC0877a2, L0.i iVar, InterfaceC0877a interfaceC0877a3, InterfaceC0877a interfaceC0877a4) {
        this.f2934d = interfaceC0877a;
        this.f2935e = interfaceC0877a2;
        this.f2936f = iVar;
        this.g = interfaceC0877a3;
        this.h = interfaceC0877a4;
    }
}
