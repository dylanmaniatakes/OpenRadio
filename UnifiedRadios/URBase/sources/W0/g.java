package w0;

import android.view.View;

/* loaded from: classes.dex */
public final class g extends q {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10060a;

    /* renamed from: b, reason: collision with root package name */
    public Object f10061b;

    public /* synthetic */ g() {
        this.f10060a = 2;
    }

    @Override // w0.q, w0.o
    public void a() {
        switch (this.f10060a) {
            case 2:
                u uVar = (u) this.f10061b;
                if (!uVar.f10111J) {
                    uVar.F();
                    uVar.f10111J = true;
                    break;
                }
                break;
        }
    }

    @Override // w0.o
    public final void e(p pVar) {
        switch (this.f10060a) {
            case 0:
                x xVar = w.f10116a;
                xVar.E((View) this.f10061b, 1.0f);
                xVar.getClass();
                pVar.v(this);
                break;
            case 1:
                ((p) this.f10061b).y();
                pVar.v(this);
                break;
            default:
                u uVar = (u) this.f10061b;
                int i5 = uVar.I - 1;
                uVar.I = i5;
                if (i5 == 0) {
                    uVar.f10111J = false;
                    uVar.m();
                }
                pVar.v(this);
                break;
        }
    }

    public /* synthetic */ g(int i5, Object obj) {
        this.f10060a = i5;
        this.f10061b = obj;
    }
}
