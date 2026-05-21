package h0;

import F3.i;
import N3.AbstractC0146u;
import N3.B;
import android.net.Uri;
import android.view.InputEvent;
import i0.AbstractC0564a;
import i0.AbstractC0568e;
import i0.AbstractC0569f;
import i0.AbstractC0570g;
import i0.h;
import y1.f;
import z2.InterfaceFutureC1000b;

/* renamed from: h0.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0556d {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC0568e f7079a;

    public C0556d(AbstractC0568e abstractC0568e) {
        this.f7079a = abstractC0568e;
    }

    public InterfaceFutureC1000b a(AbstractC0564a abstractC0564a) {
        i.f(abstractC0564a, "deletionRequest");
        throw null;
    }

    public InterfaceFutureC1000b b() {
        return f.a(AbstractC0146u.c(AbstractC0146u.a(B.f1811a), new C0553a(this, null)));
    }

    public InterfaceFutureC1000b c(Uri uri, InputEvent inputEvent) {
        i.f(uri, "attributionSource");
        return f.a(AbstractC0146u.c(AbstractC0146u.a(B.f1811a), new C0554b(this, uri, inputEvent, null)));
    }

    public InterfaceFutureC1000b d(AbstractC0569f abstractC0569f) {
        i.f(abstractC0569f, "request");
        throw null;
    }

    public InterfaceFutureC1000b e(Uri uri) {
        i.f(uri, "trigger");
        return f.a(AbstractC0146u.c(AbstractC0146u.a(B.f1811a), new C0555c(this, uri, null)));
    }

    public InterfaceFutureC1000b f(AbstractC0570g abstractC0570g) {
        i.f(abstractC0570g, "request");
        throw null;
    }

    public InterfaceFutureC1000b g(h hVar) {
        i.f(hVar, "request");
        throw null;
    }
}
