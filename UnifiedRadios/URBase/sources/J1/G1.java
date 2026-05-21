package J1;

import android.os.Looper;

/* loaded from: classes.dex */
public final class G1 extends E {

    /* renamed from: e, reason: collision with root package name */
    public A1.f f744e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f745f;
    public final B0.l g;
    public final F1 h;

    /* renamed from: i, reason: collision with root package name */
    public final L0.c f746i;

    public G1(C0113v0 c0113v0) {
        super(c0113v0);
        this.f745f = true;
        this.g = new B0.l(6, this);
        this.h = new F1(this);
        this.f746i = new L0.c(7, this);
    }

    @Override // J1.E
    public final boolean m() {
        return false;
    }

    public final void n() {
        j();
        if (this.f744e == null) {
            this.f744e = new A1.f(Looper.getMainLooper(), 4);
        }
    }
}
