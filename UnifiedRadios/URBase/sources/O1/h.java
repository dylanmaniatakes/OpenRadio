package o1;

import N1.r;
import android.content.Context;
import i3.C0573b;
import java.util.Collections;
import java.util.Set;
import p1.C0820A;
import p1.C0821B;
import p1.C0824E;
import p1.C0825a;
import p1.C0826b;
import p1.C0832h;
import p1.F;
import q1.E;

/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public final Context f8901a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8902b;

    /* renamed from: c, reason: collision with root package name */
    public final d f8903c;

    /* renamed from: d, reason: collision with root package name */
    public final b f8904d;

    /* renamed from: e, reason: collision with root package name */
    public final C0826b f8905e;

    /* renamed from: f, reason: collision with root package name */
    public final int f8906f;
    public final C0825a g;
    public final C0832h h;

    /* JADX WARN: Removed duplicated region for block: B:22:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0074 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public h(android.content.Context r5, android.app.Activity r6, o1.d r7, o1.b r8, o1.g r9) {
        /*
            Method dump skipped, instructions count: 285
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o1.h.<init>(android.content.Context, android.app.Activity, o1.d, o1.b, o1.g):void");
    }

    public final L0.i a() {
        L0.i iVar = new L0.i(8);
        iVar.f1547c = null;
        Set setEmptySet = Collections.emptySet();
        if (((q.c) iVar.f1548d) == null) {
            iVar.f1548d = new q.c(0);
        }
        ((q.c) iVar.f1548d).addAll(setEmptySet);
        Context context = this.f8901a;
        iVar.f1550f = context.getClass().getName();
        iVar.f1549e = context.getPackageName();
        return iVar;
    }

    public final r b(L0.e eVar) {
        E.j((p1.l) ((androidx.emoji2.text.e) ((C0573b) eVar.f1541d).f7296d).f3602c, "Listener has already been released.");
        E.j((p1.l) ((L0.e) eVar.f1542e).f1541d, "Listener has already been released.");
        C0573b c0573b = (C0573b) eVar.f1541d;
        L0.e eVar2 = (L0.e) eVar.f1542e;
        C0832h c0832h = this.h;
        c0832h.getClass();
        N1.k kVar = new N1.k();
        c0832h.f(kVar, c0573b.f7295c, this);
        C0820A c0820a = new C0820A(new C0824E(new C0821B(c0573b, eVar2), kVar), c0832h.f9122i.get(), this);
        A1.f fVar = c0832h.n;
        fVar.sendMessage(fVar.obtainMessage(8, c0820a));
        return kVar.f1789a;
    }

    public final r c(p1.l lVar, int i5) {
        E.j(lVar, "Listener key cannot be null.");
        C0832h c0832h = this.h;
        c0832h.getClass();
        N1.k kVar = new N1.k();
        c0832h.f(kVar, i5, this);
        C0820A c0820a = new C0820A(new C0824E(lVar, kVar), c0832h.f9122i.get(), this);
        A1.f fVar = c0832h.n;
        fVar.sendMessage(fVar.obtainMessage(13, c0820a));
        return kVar.f1789a;
    }

    public final r d(int i5, V1.d dVar) {
        N1.k kVar = new N1.k();
        C0832h c0832h = this.h;
        c0832h.getClass();
        c0832h.f(kVar, dVar.f2525b, this);
        C0820A c0820a = new C0820A(new F(i5, dVar, kVar, this.g), c0832h.f9122i.get(), this);
        A1.f fVar = c0832h.n;
        fVar.sendMessage(fVar.obtainMessage(4, c0820a));
        return kVar.f1789a;
    }

    public final C0826b getApiKey() {
        return this.f8905e;
    }
}
