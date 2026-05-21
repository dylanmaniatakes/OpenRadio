package O;

import android.view.WindowInsets;

/* loaded from: classes.dex */
public class v0 extends x0 {

    /* renamed from: c, reason: collision with root package name */
    public final WindowInsets.Builder f1976c;

    public v0() {
        this.f1976c = B.v.e();
    }

    @Override // O.x0
    public F0 b() {
        a();
        F0 f0G = F0.g(null, this.f1976c.build());
        f0G.f1894a.o(this.f1978b);
        return f0G;
    }

    @Override // O.x0
    public void d(E.c cVar) {
        this.f1976c.setMandatorySystemGestureInsets(cVar.d());
    }

    @Override // O.x0
    public void e(E.c cVar) {
        this.f1976c.setStableInsets(cVar.d());
    }

    @Override // O.x0
    public void f(E.c cVar) {
        this.f1976c.setSystemGestureInsets(cVar.d());
    }

    @Override // O.x0
    public void g(E.c cVar) {
        this.f1976c.setSystemWindowInsets(cVar.d());
    }

    @Override // O.x0
    public void h(E.c cVar) {
        this.f1976c.setTappableElementInsets(cVar.d());
    }

    public v0(F0 f02) {
        WindowInsets.Builder builderE;
        super(f02);
        WindowInsets windowInsetsF = f02.f();
        if (windowInsetsF != null) {
            builderE = B.v.f(windowInsetsF);
        } else {
            builderE = B.v.e();
        }
        this.f1976c = builderE;
    }
}
