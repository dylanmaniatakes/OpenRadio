package N0;

import z2.InterfaceFutureC1000b;

/* loaded from: classes.dex */
public final class f implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final i f1775j;

    /* renamed from: k, reason: collision with root package name */
    public final InterfaceFutureC1000b f1776k;

    public f(i iVar, InterfaceFutureC1000b interfaceFutureC1000b) {
        this.f1775j = iVar;
        this.f1776k = interfaceFutureC1000b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f1775j.f1783j != this) {
            return;
        }
        if (i.f1781o.b(this.f1775j, this, i.f(this.f1776k))) {
            i.c(this.f1775j);
        }
    }
}
