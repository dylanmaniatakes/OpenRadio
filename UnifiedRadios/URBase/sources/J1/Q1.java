package J1;

/* loaded from: classes.dex */
public abstract class Q1 extends M1 {

    /* renamed from: e, reason: collision with root package name */
    public boolean f935e;

    public Q1(V1 v12) {
        super(v12);
        this.f902d.f1031t++;
    }

    public final void k() {
        if (!this.f935e) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void l() {
        if (this.f935e) {
            throw new IllegalStateException("Can't initialize twice");
        }
        m();
        this.f902d.f1032u++;
        this.f935e = true;
    }

    public abstract void m();
}
