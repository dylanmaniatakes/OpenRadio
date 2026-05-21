package f;

import android.content.Context;
import c.InterfaceC0288b;

/* renamed from: f.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0471h implements InterfaceC0288b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractActivityC0472i f6347a;

    public C0471h(AbstractActivityC0472i abstractActivityC0472i) {
        this.f6347a = abstractActivityC0472i;
    }

    @Override // c.InterfaceC0288b
    public final void a(Context context) {
        AbstractActivityC0472i abstractActivityC0472i = this.f6347a;
        n delegate = abstractActivityC0472i.getDelegate();
        delegate.a();
        abstractActivityC0472i.getSavedStateRegistry().a("androidx:appcompat");
        delegate.d();
    }
}
