package D1;

import com.google.android.gms.common.api.Status;
import p1.AbstractBinderC0833i;
import p1.InterfaceC0830f;

/* renamed from: D1.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class BinderC0008f extends AbstractBinderC0833i {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f388d = 0;

    /* renamed from: e, reason: collision with root package name */
    public final Object f389e;

    public BinderC0008f(N1.k kVar) {
        this.f389e = kVar;
    }

    @Override // p1.j
    public final void p(Status status) {
        switch (this.f388d) {
            case 0:
                h4.f.m(status, null, (N1.k) this.f389e);
                break;
            default:
                ((InterfaceC0830f) this.f389e).n(status);
                break;
        }
    }

    public BinderC0008f(Z2.c cVar) {
        this.f389e = cVar;
    }
}
