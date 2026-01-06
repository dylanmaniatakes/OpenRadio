package O;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* renamed from: O.g0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0165g0 extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1930a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1931b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1932c;

    public /* synthetic */ C0165g0(Object obj, View view, int i5) {
        this.f1930a = i5;
        this.f1932c = obj;
        this.f1931b = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.f1930a) {
            case 0:
                ((InterfaceC0171j0) this.f1932c).b((View) this.f1931b);
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f1930a) {
            case 0:
                ((InterfaceC0171j0) this.f1932c).a();
                break;
            case 1:
                ((s0) this.f1932c).f1965a.d(1.0f);
                o0.e((View) this.f1931b);
                break;
            default:
                ((q.b) this.f1932c).remove(animator);
                ((w0.p) this.f1931b).f10097v.remove(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.f1930a) {
            case 0:
                ((InterfaceC0171j0) this.f1932c).c();
                break;
            case 1:
            default:
                super.onAnimationStart(animator);
                break;
            case 2:
                ((w0.p) this.f1931b).f10097v.add(animator);
                break;
        }
    }

    public C0165g0(w0.p pVar, q.b bVar) {
        this.f1930a = 2;
        this.f1931b = pVar;
        this.f1932c = bVar;
    }
}
