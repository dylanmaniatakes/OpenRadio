package g0;

import E3.l;
import F3.j;
import N3.C0138l;
import N3.C0150y;
import N3.InterfaceC0149x;
import N3.K;
import N3.L;
import java.util.concurrent.CancellationException;
import r.h;
import s3.C0900j;

/* renamed from: g0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0536b extends j implements l {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ h f6865j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0149x f6866k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0536b(h hVar, C0150y c0150y) {
        super(1);
        this.f6865j = hVar;
        this.f6866k = c0150y;
    }

    @Override // E3.l
    public final Object invoke(Object obj) throws Throwable {
        K k5;
        Throwable th = (Throwable) obj;
        h hVar = this.f6865j;
        if (th == null) {
            Object objA = ((C0150y) this.f6866k).A();
            if (!(!(objA instanceof K))) {
                throw new IllegalStateException("This job has not completed yet".toString());
            }
            if (objA instanceof C0138l) {
                throw ((C0138l) objA).f1860a;
            }
            L l5 = objA instanceof L ? (L) objA : null;
            if (l5 != null && (k5 = l5.f1821a) != null) {
                objA = k5;
            }
            hVar.f9506d = true;
            r.j jVar = hVar.f9504b;
            if (jVar != null && jVar.f9509k.i(objA)) {
                hVar.f9503a = null;
                hVar.f9504b = null;
                hVar.f9505c = null;
            }
        } else if (th instanceof CancellationException) {
            hVar.f9506d = true;
            r.j jVar2 = hVar.f9504b;
            if (jVar2 != null && jVar2.f9509k.cancel(true)) {
                hVar.f9503a = null;
                hVar.f9504b = null;
                hVar.f9505c = null;
            }
        } else {
            hVar.f9506d = true;
            r.j jVar3 = hVar.f9504b;
            if (jVar3 != null && jVar3.f9509k.j(th)) {
                hVar.f9503a = null;
                hVar.f9504b = null;
                hVar.f9505c = null;
            }
        }
        return C0900j.f9694a;
    }
}
