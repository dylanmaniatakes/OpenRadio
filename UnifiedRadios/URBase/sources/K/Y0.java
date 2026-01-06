package k;

import androidx.appcompat.widget.Toolbar;

/* loaded from: classes.dex */
public final /* synthetic */ class Y0 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f7739j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Toolbar f7740k;

    public /* synthetic */ Y0(Toolbar toolbar, int i5) {
        this.f7739j = i5;
        this.f7740k = toolbar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7739j) {
            case 0:
                a1 a1Var = this.f7740k.f3453O;
                j.o oVar = a1Var == null ? null : a1Var.f7747d;
                if (oVar != null) {
                    oVar.collapseActionView();
                    break;
                }
                break;
            default:
                this.f7740k.o();
                break;
        }
    }
}
