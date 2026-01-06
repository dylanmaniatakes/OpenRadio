package androidx.fragment.app;

import android.transition.Transition;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class h0 implements Transition.TransitionListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f3810a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f3811b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3812c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ArrayList f3813d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f3814e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ ArrayList f3815f;
    public final /* synthetic */ j0 g;

    public h0(j0 j0Var, Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
        this.g = j0Var;
        this.f3810a = obj;
        this.f3811b = arrayList;
        this.f3812c = obj2;
        this.f3813d = arrayList2;
        this.f3814e = obj3;
        this.f3815f = arrayList3;
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionCancel(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionEnd(Transition transition) {
        transition.removeListener(this);
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionPause(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionResume(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionStart(Transition transition) {
        j0 j0Var = this.g;
        Object obj = this.f3810a;
        if (obj != null) {
            j0Var.t(obj, this.f3811b, null);
        }
        Object obj2 = this.f3812c;
        if (obj2 != null) {
            j0Var.t(obj2, this.f3813d, null);
        }
        Object obj3 = this.f3814e;
        if (obj3 != null) {
            j0Var.t(obj3, this.f3815f, null);
        }
    }
}
