package s3;

import java.io.Serializable;

/* renamed from: s3.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0898h implements InterfaceC0894d, Serializable {

    /* renamed from: j, reason: collision with root package name */
    public E3.a f9690j;

    /* renamed from: k, reason: collision with root package name */
    public volatile Object f9691k = C0899i.f9693a;

    /* renamed from: l, reason: collision with root package name */
    public final Object f9692l = this;

    public C0898h(E3.a aVar) {
        this.f9690j = aVar;
    }

    public final Object a() {
        Object objInvoke;
        Object obj = this.f9691k;
        C0899i c0899i = C0899i.f9693a;
        if (obj != c0899i) {
            return obj;
        }
        synchronized (this.f9692l) {
            objInvoke = this.f9691k;
            if (objInvoke == c0899i) {
                E3.a aVar = this.f9690j;
                F3.i.c(aVar);
                objInvoke = aVar.invoke();
                this.f9691k = objInvoke;
                this.f9690j = null;
            }
        }
        return objInvoke;
    }

    public final String toString() {
        return this.f9691k != C0899i.f9693a ? String.valueOf(a()) : "Lazy value not initialized yet.";
    }
}
