package q1;

import android.os.Bundle;
import n1.C0785b;

/* loaded from: classes.dex */
public final class K extends y {
    public final /* synthetic */ AbstractC0854e g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public K(AbstractC0854e abstractC0854e, int i5, Bundle bundle) {
        super(abstractC0854e, i5, bundle);
        this.g = abstractC0854e;
    }

    @Override // q1.y
    public final void b(C0785b c0785b) {
        AbstractC0854e abstractC0854e = this.g;
        abstractC0854e.getClass();
        abstractC0854e.f9353j.d(c0785b);
        System.currentTimeMillis();
    }

    @Override // q1.y
    public final boolean c() {
        this.g.f9353j.d(C0785b.n);
        return true;
    }
}
