package N3;

import S3.AbstractC0187a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class X extends S3.b {

    /* renamed from: b, reason: collision with root package name */
    public final S3.k f1834b;

    /* renamed from: c, reason: collision with root package name */
    public S3.k f1835c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Y f1836d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f1837e;

    public X(S3.k kVar, Y y4, K k5) {
        this.f1836d = y4;
        this.f1837e = k5;
        this.f1834b = kVar;
    }

    @Override // S3.b
    public final void b(Object obj, Object obj2) {
        S3.k kVar = (S3.k) obj;
        boolean z4 = obj2 == null;
        S3.k kVar2 = this.f1834b;
        S3.k kVar3 = z4 ? kVar2 : this.f1835c;
        if (kVar3 != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = S3.k.f2401j;
            while (!atomicReferenceFieldUpdater.compareAndSet(kVar, this, kVar3)) {
                if (atomicReferenceFieldUpdater.get(kVar) != this) {
                    return;
                }
            }
            if (z4) {
                S3.k kVar4 = this.f1835c;
                F3.i.c(kVar4);
                kVar2.g(kVar4);
            }
        }
    }

    @Override // S3.b
    public final S3.w c(Object obj) {
        if (this.f1836d.A() == this.f1837e) {
            return null;
        }
        return AbstractC0187a.f2383e;
    }
}
