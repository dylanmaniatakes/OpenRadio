package J1;

/* loaded from: classes.dex */
public abstract class F0 extends B.u {

    /* renamed from: d, reason: collision with root package name */
    public boolean f733d;

    public F0(C0113v0 c0113v0) {
        super(c0113v0);
        ((C0113v0) this.f84c).f1408F++;
    }

    public abstract boolean k();

    public final void l() {
        if (!this.f733d) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void m() {
        if (this.f733d) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (k()) {
            return;
        }
        ((C0113v0) this.f84c).f1410H.incrementAndGet();
        this.f733d = true;
    }
}
