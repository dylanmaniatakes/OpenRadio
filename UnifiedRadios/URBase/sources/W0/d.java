package w0;

import android.view.ViewGroup;
import w1.AbstractC0930a;

/* loaded from: classes.dex */
public final class d extends q {

    /* renamed from: a, reason: collision with root package name */
    public boolean f10047a = false;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f10048b;

    public d(ViewGroup viewGroup) {
        this.f10048b = viewGroup;
    }

    @Override // w0.q, w0.o
    public final void b() {
        AbstractC0930a.p(this.f10048b, false);
    }

    @Override // w0.q, w0.o
    public final void c() {
        AbstractC0930a.p(this.f10048b, true);
    }

    @Override // w0.q, w0.o
    public final void d() {
        AbstractC0930a.p(this.f10048b, false);
        this.f10047a = true;
    }

    @Override // w0.o
    public final void e(p pVar) {
        if (!this.f10047a) {
            AbstractC0930a.p(this.f10048b, false);
        }
        pVar.v(this);
    }
}
