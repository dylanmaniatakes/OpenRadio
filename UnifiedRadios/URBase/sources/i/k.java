package i;

import O.InterfaceC0171j0;
import android.view.View;
import k.f1;

/* loaded from: classes.dex */
public final class k extends A2.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7177a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f7178b;

    /* renamed from: c, reason: collision with root package name */
    public int f7179c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f7180d;

    public k(l lVar) {
        this.f7177a = 0;
        this.f7180d = lVar;
        this.f7178b = false;
        this.f7179c = 0;
    }

    @Override // O.InterfaceC0171j0
    public final void a() {
        switch (this.f7177a) {
            case 0:
                int i5 = this.f7179c + 1;
                this.f7179c = i5;
                l lVar = (l) this.f7180d;
                if (i5 == lVar.f7181a.size()) {
                    InterfaceC0171j0 interfaceC0171j0 = lVar.f7184d;
                    if (interfaceC0171j0 != null) {
                        interfaceC0171j0.a();
                    }
                    this.f7179c = 0;
                    this.f7178b = false;
                    lVar.f7185e = false;
                    break;
                }
                break;
            default:
                if (!this.f7178b) {
                    ((f1) this.f7180d).f7769a.setVisibility(this.f7179c);
                    break;
                }
                break;
        }
    }

    @Override // A2.b, O.InterfaceC0171j0
    public void b(View view) {
        switch (this.f7177a) {
            case 1:
                this.f7178b = true;
                break;
        }
    }

    @Override // A2.b, O.InterfaceC0171j0
    public final void c() {
        switch (this.f7177a) {
            case 0:
                if (!this.f7178b) {
                    this.f7178b = true;
                    InterfaceC0171j0 interfaceC0171j0 = ((l) this.f7180d).f7184d;
                    if (interfaceC0171j0 != null) {
                        interfaceC0171j0.c();
                        break;
                    }
                }
                break;
            default:
                ((f1) this.f7180d).f7769a.setVisibility(0);
                break;
        }
    }

    public k(f1 f1Var, int i5) {
        this.f7177a = 1;
        this.f7180d = f1Var;
        this.f7179c = i5;
        this.f7178b = false;
    }
}
