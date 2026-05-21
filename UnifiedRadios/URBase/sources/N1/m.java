package N1;

import java.util.concurrent.CountDownLatch;

/* loaded from: classes.dex */
public final class m implements g, f, d, e {

    /* renamed from: c, reason: collision with root package name */
    public final CountDownLatch f1792c;

    @Override // N1.d
    public void b() {
        this.f1792c.countDown();
    }

    @Override // N1.f
    public void d(Exception exc) {
        this.f1792c.countDown();
    }

    @Override // N1.g
    public void h(Object obj) {
        this.f1792c.countDown();
    }

    @Override // N1.e
    public void k(j jVar) {
        this.f1792c.countDown();
    }

    public /* synthetic */ m() {
        this.f1792c = new CountDownLatch(1);
    }
}
