package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewPropertyAnimator;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class K implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f4046j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f4047k;

    public /* synthetic */ K(int i5, RecyclerView recyclerView) {
        this.f4046j = i5;
        this.f4047k = recyclerView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3 = this.f4047k;
        switch (this.f4046j) {
            case 0:
                if (recyclerView3.f4138w && !recyclerView3.isLayoutRequested()) {
                    if (!recyclerView3.f4135u) {
                        recyclerView3.requestLayout();
                        break;
                    } else if (!recyclerView3.f4144z) {
                        recyclerView3.p();
                        break;
                    } else {
                        recyclerView3.f4142y = true;
                        break;
                    }
                }
                break;
            default:
                T t4 = recyclerView3.f4091O;
                if (t4 != null) {
                    C0265l c0265l = (C0265l) t4;
                    ArrayList arrayList = c0265l.h;
                    boolean z4 = !arrayList.isEmpty();
                    ArrayList arrayList2 = c0265l.f4281j;
                    boolean z5 = !arrayList2.isEmpty();
                    ArrayList arrayList3 = c0265l.f4282k;
                    boolean z6 = !arrayList3.isEmpty();
                    ArrayList arrayList4 = c0265l.f4280i;
                    boolean z7 = !arrayList4.isEmpty();
                    if (z4 || z5 || z7 || z6) {
                        Iterator it = arrayList.iterator();
                        while (true) {
                            boolean zHasNext = it.hasNext();
                            recyclerView2 = recyclerView3;
                            long j5 = c0265l.f4169d;
                            if (zHasNext) {
                                n0 n0Var = (n0) it.next();
                                View view = n0Var.itemView;
                                ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
                                c0265l.f4287q.add(n0Var);
                                viewPropertyAnimatorAnimate.setDuration(j5).alpha(BitmapDescriptorFactory.HUE_RED).setListener(new C0260g(c0265l, n0Var, viewPropertyAnimatorAnimate, view)).start();
                                recyclerView3 = recyclerView2;
                            } else {
                                arrayList.clear();
                                if (z5) {
                                    ArrayList arrayList5 = new ArrayList();
                                    arrayList5.addAll(arrayList2);
                                    c0265l.f4284m.add(arrayList5);
                                    arrayList2.clear();
                                    RunnableC0259f runnableC0259f = new RunnableC0259f(c0265l, arrayList5, 0);
                                    if (z4) {
                                        View view2 = ((C0264k) arrayList5.get(0)).f4274a.itemView;
                                        WeakHashMap weakHashMap = O.Y.f1904a;
                                        O.G.n(view2, runnableC0259f, j5);
                                    } else {
                                        runnableC0259f.run();
                                    }
                                }
                                if (z6) {
                                    ArrayList arrayList6 = new ArrayList();
                                    arrayList6.addAll(arrayList3);
                                    c0265l.n.add(arrayList6);
                                    arrayList3.clear();
                                    RunnableC0259f runnableC0259f2 = new RunnableC0259f(c0265l, arrayList6, 1);
                                    if (z4) {
                                        View view3 = ((C0263j) arrayList6.get(0)).f4257a.itemView;
                                        WeakHashMap weakHashMap2 = O.Y.f1904a;
                                        O.G.n(view3, runnableC0259f2, j5);
                                    } else {
                                        runnableC0259f2.run();
                                    }
                                }
                                if (z7) {
                                    ArrayList arrayList7 = new ArrayList();
                                    arrayList7.addAll(arrayList4);
                                    c0265l.f4283l.add(arrayList7);
                                    arrayList4.clear();
                                    RunnableC0259f runnableC0259f3 = new RunnableC0259f(c0265l, arrayList7, 2);
                                    if (z4 || z5 || z6) {
                                        if (!z4) {
                                            j5 = 0;
                                        }
                                        long jMax = Math.max(z5 ? c0265l.f4170e : 0L, z6 ? c0265l.f4171f : 0L) + j5;
                                        View view4 = ((n0) arrayList7.get(0)).itemView;
                                        WeakHashMap weakHashMap3 = O.Y.f1904a;
                                        O.G.n(view4, runnableC0259f3, jMax);
                                    } else {
                                        runnableC0259f3.run();
                                    }
                                }
                            }
                        }
                    } else {
                        recyclerView2 = recyclerView3;
                    }
                    recyclerView = recyclerView2;
                } else {
                    recyclerView = recyclerView3;
                }
                recyclerView.f4126p0 = false;
                break;
        }
    }
}
