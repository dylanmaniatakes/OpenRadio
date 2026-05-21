package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewPropertyAnimator;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: androidx.recyclerview.widget.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0259f implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f4229j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ ArrayList f4230k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ C0265l f4231l;

    public /* synthetic */ RunnableC0259f(C0265l c0265l, ArrayList arrayList, int i5) {
        this.f4229j = i5;
        this.f4231l = c0265l;
        this.f4230k = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator it;
        switch (this.f4229j) {
            case 0:
                ArrayList arrayList = this.f4230k;
                Iterator it2 = arrayList.iterator();
                while (true) {
                    boolean zHasNext = it2.hasNext();
                    C0265l c0265l = this.f4231l;
                    if (!zHasNext) {
                        arrayList.clear();
                        c0265l.f4284m.remove(arrayList);
                        break;
                    } else {
                        C0264k c0264k = (C0264k) it2.next();
                        n0 n0Var = c0264k.f4274a;
                        c0265l.getClass();
                        View view = n0Var.itemView;
                        int i5 = c0264k.f4277d - c0264k.f4275b;
                        int i6 = c0264k.f4278e - c0264k.f4276c;
                        if (i5 != 0) {
                            view.animate().translationX(BitmapDescriptorFactory.HUE_RED);
                        }
                        if (i6 != 0) {
                            view.animate().translationY(BitmapDescriptorFactory.HUE_RED);
                        }
                        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
                        c0265l.f4286p.add(n0Var);
                        viewPropertyAnimatorAnimate.setDuration(c0265l.f4170e).setListener(new C0261h(c0265l, n0Var, i5, view, i6, viewPropertyAnimatorAnimate)).start();
                    }
                }
            case 1:
                ArrayList arrayList2 = this.f4230k;
                Iterator it3 = arrayList2.iterator();
                while (true) {
                    boolean zHasNext2 = it3.hasNext();
                    C0265l c0265l2 = this.f4231l;
                    if (!zHasNext2) {
                        arrayList2.clear();
                        c0265l2.n.remove(arrayList2);
                        break;
                    } else {
                        C0263j c0263j = (C0263j) it3.next();
                        c0265l2.getClass();
                        n0 n0Var2 = c0263j.f4257a;
                        View view2 = n0Var2 == null ? null : n0Var2.itemView;
                        n0 n0Var3 = c0263j.f4258b;
                        View view3 = n0Var3 != null ? n0Var3.itemView : null;
                        ArrayList arrayList3 = c0265l2.f4288r;
                        long j5 = c0265l2.f4171f;
                        if (view2 != null) {
                            ViewPropertyAnimator duration = view2.animate().setDuration(j5);
                            arrayList3.add(c0263j.f4257a);
                            duration.translationX(c0263j.f4261e - c0263j.f4259c);
                            duration.translationY(c0263j.f4262f - c0263j.f4260d);
                            it = it3;
                            duration.alpha(BitmapDescriptorFactory.HUE_RED).setListener(new C0262i(c0265l2, c0263j, duration, view2, 0)).start();
                        } else {
                            it = it3;
                        }
                        if (view3 != null) {
                            ViewPropertyAnimator viewPropertyAnimatorAnimate2 = view3.animate();
                            arrayList3.add(c0263j.f4258b);
                            viewPropertyAnimatorAnimate2.translationX(BitmapDescriptorFactory.HUE_RED).translationY(BitmapDescriptorFactory.HUE_RED).setDuration(j5).alpha(1.0f).setListener(new C0262i(c0265l2, c0263j, viewPropertyAnimatorAnimate2, view3, 1)).start();
                        }
                        it3 = it;
                    }
                }
            default:
                ArrayList arrayList4 = this.f4230k;
                Iterator it4 = arrayList4.iterator();
                while (true) {
                    boolean zHasNext3 = it4.hasNext();
                    C0265l c0265l3 = this.f4231l;
                    if (!zHasNext3) {
                        arrayList4.clear();
                        c0265l3.f4283l.remove(arrayList4);
                        break;
                    } else {
                        n0 n0Var4 = (n0) it4.next();
                        c0265l3.getClass();
                        View view4 = n0Var4.itemView;
                        ViewPropertyAnimator viewPropertyAnimatorAnimate3 = view4.animate();
                        c0265l3.f4285o.add(n0Var4);
                        viewPropertyAnimatorAnimate3.alpha(1.0f).setDuration(c0265l3.f4168c).setListener(new C0260g(c0265l3, n0Var4, view4, viewPropertyAnimatorAnimate3)).start();
                    }
                }
        }
    }
}
