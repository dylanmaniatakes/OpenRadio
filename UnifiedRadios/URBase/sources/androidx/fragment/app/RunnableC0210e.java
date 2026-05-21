package androidx.fragment.app;

import java.util.ArrayList;

/* renamed from: androidx.fragment.app.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0210e implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f3794j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f3795k;

    public /* synthetic */ RunnableC0210e(int i5, Object obj) {
        this.f3794j = i5;
        this.f3795k = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3794j) {
            case 0:
                AnimationAnimationListenerC0211f animationAnimationListenerC0211f = (AnimationAnimationListenerC0211f) this.f3795k;
                animationAnimationListenerC0211f.f3798a.endViewTransition(animationAnimationListenerC0211f.f3799b);
                animationAnimationListenerC0211f.f3800c.a();
                break;
            case 1:
                e0.b((ArrayList) this.f3795k, 4);
                break;
            case 2:
                ((C0214i) this.f3795k).a();
                break;
            case 3:
                DialogInterfaceOnCancelListenerC0219n dialogInterfaceOnCancelListenerC0219n = (DialogInterfaceOnCancelListenerC0219n) this.f3795k;
                dialogInterfaceOnCancelListenerC0219n.f3840f.onDismiss(dialogInterfaceOnCancelListenerC0219n.n);
                break;
            case 4:
                ((C0215j) this.f3795k).d();
                break;
            default:
                ((T) this.f3795k).s(true);
                break;
        }
    }
}
