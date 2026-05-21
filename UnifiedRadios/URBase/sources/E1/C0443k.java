package e1;

import android.content.Context;
import f3.C0519j;
import h1.AbstractC0557a;
import h1.C0558b;
import h1.C0559c;
import java.util.concurrent.Executor;
import r3.InterfaceC0877a;

/* renamed from: e1.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0443k implements InterfaceC0877a {

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC0877a f6183c;

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC0877a f6184d;

    /* renamed from: e, reason: collision with root package name */
    public final InterfaceC0877a f6185e;

    /* renamed from: f, reason: collision with root package name */
    public final InterfaceC0877a f6186f;
    public final InterfaceC0877a g;
    public final InterfaceC0877a h;

    /* renamed from: i, reason: collision with root package name */
    public final InterfaceC0877a f6187i;

    /* renamed from: j, reason: collision with root package name */
    public final InterfaceC0877a f6188j;

    /* renamed from: k, reason: collision with root package name */
    public final InterfaceC0877a f6189k;

    public C0443k(C0519j c0519j, InterfaceC0877a interfaceC0877a, InterfaceC0877a interfaceC0877a2, L0.i iVar, InterfaceC0877a interfaceC0877a3, InterfaceC0877a interfaceC0877a4, InterfaceC0877a interfaceC0877a5) {
        C0558b c0558b = AbstractC0557a.f7080a;
        C0559c c0559c = AbstractC0557a.f7081b;
        this.f6183c = c0519j;
        this.f6184d = interfaceC0877a;
        this.f6185e = interfaceC0877a2;
        this.f6186f = iVar;
        this.g = interfaceC0877a3;
        this.h = interfaceC0877a4;
        this.f6187i = c0558b;
        this.f6188j = c0559c;
        this.f6189k = interfaceC0877a5;
    }

    @Override // r3.InterfaceC0877a
    public final Object get() {
        return new C0442j((Context) this.f6183c.get(), (Z0.e) this.f6184d.get(), (f1.d) this.f6185e.get(), (C0436d) this.f6186f.get(), (Executor) this.g.get(), (g1.c) this.h.get(), (h1.d) this.f6187i.get(), (h1.d) this.f6188j.get(), (f1.c) this.f6189k.get());
    }
}
