package J1;

/* loaded from: classes.dex */
public abstract class E extends B {

    /* renamed from: d, reason: collision with root package name */
    public boolean f727d;

    public E(C0113v0 c0113v0) {
        super(c0113v0);
        ((C0113v0) this.f84c).f1408F++;
    }

    public final void k() {
        if (!this.f727d) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void l() {
        if (this.f727d) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (m()) {
            return;
        }
        ((C0113v0) this.f84c).f1410H.incrementAndGet();
        this.f727d = true;
    }

    public abstract boolean m();
}
