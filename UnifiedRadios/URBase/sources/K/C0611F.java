package k;

import android.view.View;

/* renamed from: k.F, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0611F extends AbstractViewOnTouchListenerC0653r0 {

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ N f7646l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Q f7647m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0611F(Q q4, View view, N n) {
        super(view);
        this.f7647m = q4;
        this.f7646l = n;
    }

    @Override // k.AbstractViewOnTouchListenerC0653r0
    public final j.D b() {
        return this.f7646l;
    }

    @Override // k.AbstractViewOnTouchListenerC0653r0
    public final boolean c() {
        Q q4 = this.f7647m;
        if (q4.getInternalPopup().b()) {
            return true;
        }
        q4.h.m(AbstractC0613H.b(q4), AbstractC0613H.a(q4));
        return true;
    }
}
