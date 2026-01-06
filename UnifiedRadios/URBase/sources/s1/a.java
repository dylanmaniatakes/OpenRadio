package S1;

import L0.l;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.view.ViewOverlay;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.transformation.ExpandableTransformationBehavior;
import com.unified.ur1.chat.ChatActivity;
import f3.C0513e;
import g2.m;
import java.util.ArrayList;
import java.util.Iterator;
import s2.h;
import v2.C0921a;
import w0.p;
import x0.C0949e;

/* loaded from: classes.dex */
public final class a extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2353a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2354b;

    public /* synthetic */ a(int i5, Object obj) {
        this.f2353a = i5;
        this.f2354b = obj;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.f2353a) {
            case 3:
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.f2354b;
                actionBarOverlayLayout.f3359y = null;
                actionBarOverlayLayout.f3348m = false;
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f2353a) {
            case 0:
                ((HideBottomViewOnScrollBehavior) this.f2354b).h = null;
                break;
            case 1:
                C0513e c0513e = (C0513e) this.f2354b;
                if (((ValueAnimator) c0513e.f6687d) == animator) {
                    c0513e.f6687d = null;
                    break;
                }
                break;
            case 2:
                ((ChatActivity) this.f2354b).f5727B.setVisibility(8);
                break;
            case 3:
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.f2354b;
                actionBarOverlayLayout.f3359y = null;
                actionBarOverlayLayout.f3348m = false;
                break;
            case 4:
                super.onAnimationEnd(animator);
                p2.c cVar = (p2.c) this.f2354b;
                l lVarF = m.f(cVar);
                Iterator it = cVar.f9210m.iterator();
                while (it.hasNext()) {
                    ((ViewOverlay) lVarF.f1554d).remove((C0921a) it.next());
                }
                break;
            case 5:
                h hVar = (h) this.f2354b;
                hVar.q();
                hVar.f9603r.start();
                break;
            case 6:
                ((p) this.f2354b).m();
                animator.removeListener(this);
                break;
            case 7:
                ((ExpandableTransformationBehavior) this.f2354b).f5523b = null;
                break;
            default:
                C0949e c0949e = (C0949e) this.f2354b;
                ArrayList arrayList = new ArrayList(c0949e.g);
                int size = arrayList.size();
                for (int i5 = 0; i5 < size; i5++) {
                    ColorStateList colorStateList = ((Y1.a) arrayList.get(i5)).f2938b.f2951q;
                    if (colorStateList != null) {
                        F.b.h(c0949e, colorStateList);
                    }
                }
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.f2353a) {
            case 8:
                C0949e c0949e = (C0949e) this.f2354b;
                ArrayList arrayList = new ArrayList(c0949e.g);
                int size = arrayList.size();
                for (int i5 = 0; i5 < size; i5++) {
                    Y1.c cVar = ((Y1.a) arrayList.get(i5)).f2938b;
                    ColorStateList colorStateList = cVar.f2951q;
                    if (colorStateList != null) {
                        F.b.g(c0949e, colorStateList.getColorForState(cVar.f2955u, colorStateList.getDefaultColor()));
                    }
                }
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }
}
