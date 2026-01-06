package androidx.viewpager2.adapter;

import B0.l;
import android.view.ViewParent;
import androidx.fragment.app.C0206a;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.T;
import androidx.lifecycle.EnumC0244n;
import androidx.lifecycle.r;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.f0;
import androidx.viewpager2.widget.ViewPager2;
import com.unified.ur1.SatelliteTracker.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import q.e;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public B0.c f4446a;

    /* renamed from: b, reason: collision with root package name */
    public f0 f4447b;

    /* renamed from: c, reason: collision with root package name */
    public r f4448c;

    /* renamed from: d, reason: collision with root package name */
    public ViewPager2 f4449d;

    /* renamed from: e, reason: collision with root package name */
    public long f4450e = -1;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ b f4451f;

    public a(b bVar) {
        this.f4451f = bVar;
    }

    public static ViewPager2 a(RecyclerView recyclerView) {
        ViewParent parent = recyclerView.getParent();
        if (parent instanceof ViewPager2) {
            return (ViewPager2) parent;
        }
        throw new IllegalStateException("Expected ViewPager2 instance. Got: " + parent);
    }

    public final void b(boolean z4) {
        int currentItem;
        Fragment fragment;
        b bVar = this.f4451f;
        if (!bVar.f4453b.E() && this.f4449d.getScrollState() == 0) {
            e eVar = bVar.f4454c;
            if (eVar.h() != 0 && (currentItem = this.f4449d.getCurrentItem()) < 2) {
                long j5 = currentItem;
                if ((j5 != this.f4450e || z4) && (fragment = (Fragment) eVar.d(j5, null)) != null && fragment.isAdded()) {
                    this.f4450e = j5;
                    T t4 = bVar.f4453b;
                    t4.getClass();
                    C0206a c0206a = new C0206a(t4);
                    ArrayList arrayList = new ArrayList();
                    Fragment fragment2 = null;
                    for (int i5 = 0; i5 < eVar.h(); i5++) {
                        long jE = eVar.e(i5);
                        Fragment fragment3 = (Fragment) eVar.i(i5);
                        if (fragment3.isAdded()) {
                            if (jE != this.f4450e) {
                                c0206a.j(fragment3, EnumC0244n.f3964m);
                                l lVar = bVar.g;
                                lVar.getClass();
                                ArrayList arrayList2 = new ArrayList();
                                Iterator it = ((CopyOnWriteArrayList) lVar.f110d).iterator();
                                if (it.hasNext()) {
                                    h.p(it.next());
                                    throw null;
                                }
                                arrayList.add(arrayList2);
                            } else {
                                fragment2 = fragment3;
                            }
                            fragment3.setMenuVisibility(jE == this.f4450e);
                        }
                    }
                    if (fragment2 != null) {
                        c0206a.j(fragment2, EnumC0244n.n);
                        l lVar2 = bVar.g;
                        lVar2.getClass();
                        ArrayList arrayList3 = new ArrayList();
                        Iterator it2 = ((CopyOnWriteArrayList) lVar2.f110d).iterator();
                        if (it2.hasNext()) {
                            h.p(it2.next());
                            throw null;
                        }
                        arrayList.add(arrayList3);
                    }
                    if (c0206a.f3742a.isEmpty()) {
                        return;
                    }
                    if (c0206a.g) {
                        throw new IllegalStateException("This transaction is already being added to the back stack");
                    }
                    c0206a.f3754p.t(c0206a, false);
                    Collections.reverse(arrayList);
                    Iterator it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        List list = (List) it3.next();
                        bVar.g.getClass();
                        l.c(list);
                    }
                }
            }
        }
    }
}
