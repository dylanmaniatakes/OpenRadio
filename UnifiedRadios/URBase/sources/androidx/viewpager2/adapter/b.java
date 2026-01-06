package androidx.viewpager2.adapter;

import B0.l;
import C0.A;
import O.H;
import O.J;
import O.Y;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.fragment.app.AbstractActivityC0230z;
import androidx.fragment.app.C0206a;
import androidx.fragment.app.C0226v;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.I;
import androidx.fragment.app.T;
import androidx.lifecycle.AbstractC0245o;
import androidx.lifecycle.EnumC0243m;
import androidx.lifecycle.EnumC0244n;
import androidx.lifecycle.InterfaceC0249t;
import androidx.lifecycle.r;
import androidx.recyclerview.widget.N;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.f0;
import androidx.recyclerview.widget.n0;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.unified.ur1.SatelliteTracker.h;
import i3.E;
import i3.m;
import i3.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import m3.C0777m;
import q.d;
import q.e;
import q.g;

/* loaded from: classes.dex */
public abstract class b extends N {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC0245o f4452a;

    /* renamed from: b, reason: collision with root package name */
    public final T f4453b;

    /* renamed from: c, reason: collision with root package name */
    public final e f4454c;

    /* renamed from: d, reason: collision with root package name */
    public final e f4455d;

    /* renamed from: e, reason: collision with root package name */
    public final e f4456e;

    /* renamed from: f, reason: collision with root package name */
    public a f4457f;
    public final l g;
    public boolean h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f4458i;

    public b(AbstractActivityC0230z abstractActivityC0230z) {
        T supportFragmentManager = abstractActivityC0230z.getSupportFragmentManager();
        AbstractC0245o lifecycle = abstractActivityC0230z.getLifecycle();
        this.f4454c = new e();
        this.f4455d = new e();
        this.f4456e = new e();
        l lVar = new l(9);
        lVar.f110d = new CopyOnWriteArrayList();
        this.g = lVar;
        this.h = false;
        this.f4458i = false;
        this.f4453b = supportFragmentManager;
        this.f4452a = lifecycle;
        super.setHasStableIds(true);
    }

    public static void a(View view, FrameLayout frameLayout) {
        if (frameLayout.getChildCount() > 1) {
            throw new IllegalStateException("Design assumption violated.");
        }
        if (view.getParent() == frameLayout) {
            return;
        }
        if (frameLayout.getChildCount() > 0) {
            frameLayout.removeAllViews();
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        frameLayout.addView(view);
    }

    public static boolean b(long j5) {
        return j5 >= 0 && j5 < ((long) 2);
    }

    public final void c() {
        e eVar;
        e eVar2;
        Fragment fragment;
        View view;
        if (!this.f4458i || this.f4453b.E()) {
            return;
        }
        q.c cVar = new q.c(0);
        int i5 = 0;
        while (true) {
            eVar = this.f4454c;
            int iH = eVar.h();
            eVar2 = this.f4456e;
            if (i5 >= iH) {
                break;
            }
            long jE = eVar.e(i5);
            if (!b(jE)) {
                cVar.add(Long.valueOf(jE));
                eVar2.g(jE);
            }
            i5++;
        }
        if (!this.h) {
            this.f4458i = false;
            for (int i6 = 0; i6 < eVar.h(); i6++) {
                long jE2 = eVar.e(i6);
                if (eVar2.f9253j) {
                    eVar2.c();
                }
                if (d.b(eVar2.f9254k, eVar2.f9256m, jE2) < 0 && ((fragment = (Fragment) eVar.d(jE2, null)) == null || (view = fragment.getView()) == null || view.getParent() == null)) {
                    cVar.add(Long.valueOf(jE2));
                }
            }
        }
        Iterator it = cVar.iterator();
        while (true) {
            g gVar = (g) it;
            if (!gVar.hasNext()) {
                return;
            } else {
                f(((Long) gVar.next()).longValue());
            }
        }
    }

    public final Long d(int i5) {
        Long lValueOf = null;
        int i6 = 0;
        while (true) {
            e eVar = this.f4456e;
            if (i6 >= eVar.h()) {
                return lValueOf;
            }
            if (((Integer) eVar.i(i6)).intValue() == i5) {
                if (lValueOf != null) {
                    throw new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
                }
                lValueOf = Long.valueOf(eVar.e(i6));
            }
            i6++;
        }
    }

    public final void e(final c cVar) {
        Fragment fragment = (Fragment) this.f4454c.d(cVar.getItemId(), null);
        if (fragment == null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        FrameLayout frameLayout = (FrameLayout) cVar.itemView;
        View view = fragment.getView();
        if (!fragment.isAdded() && view != null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        boolean zIsAdded = fragment.isAdded();
        T t4 = this.f4453b;
        if (zIsAdded && view == null) {
            ((CopyOnWriteArrayList) t4.f3704l.f3644a).add(new I(new C0777m(this, fragment, frameLayout)));
            return;
        }
        if (fragment.isAdded() && view.getParent() != null) {
            if (view.getParent() != frameLayout) {
                a(view, frameLayout);
                return;
            }
            return;
        }
        if (fragment.isAdded()) {
            a(view, frameLayout);
            return;
        }
        if (t4.E()) {
            if (t4.f3688B) {
                return;
            }
            this.f4452a.a(new r() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter$1
                @Override // androidx.lifecycle.r
                public final void a(InterfaceC0249t interfaceC0249t, EnumC0243m enumC0243m) {
                    b bVar = this.f4442k;
                    if (bVar.f4453b.E()) {
                        return;
                    }
                    interfaceC0249t.getLifecycle().b(this);
                    c cVar2 = cVar;
                    FrameLayout frameLayout2 = (FrameLayout) cVar2.itemView;
                    WeakHashMap weakHashMap = Y.f1904a;
                    if (J.b(frameLayout2)) {
                        bVar.e(cVar2);
                    }
                }
            });
            return;
        }
        ((CopyOnWriteArrayList) t4.f3704l.f3644a).add(new I(new C0777m(this, fragment, frameLayout)));
        l lVar = this.g;
        lVar.getClass();
        ArrayList arrayList = new ArrayList();
        Iterator it = ((CopyOnWriteArrayList) lVar.f110d).iterator();
        if (it.hasNext()) {
            h.p(it.next());
            throw null;
        }
        try {
            fragment.setMenuVisibility(false);
            C0206a c0206a = new C0206a(t4);
            c0206a.e(0, fragment, "f" + cVar.getItemId(), 1);
            c0206a.j(fragment, EnumC0244n.f3964m);
            if (c0206a.g) {
                throw new IllegalStateException("This transaction is already being added to the back stack");
            }
            c0206a.f3754p.t(c0206a, false);
            this.f4457f.b(false);
        } finally {
            l.c(arrayList);
        }
    }

    public final void f(long j5) {
        ViewParent parent;
        e eVar = this.f4454c;
        Fragment fragment = (Fragment) eVar.d(j5, null);
        if (fragment == null) {
            return;
        }
        if (fragment.getView() != null && (parent = fragment.getView().getParent()) != null) {
            ((FrameLayout) parent).removeAllViews();
        }
        boolean zB = b(j5);
        e eVar2 = this.f4455d;
        if (!zB) {
            eVar2.g(j5);
        }
        if (!fragment.isAdded()) {
            eVar.g(j5);
            return;
        }
        T t4 = this.f4453b;
        if (t4.E()) {
            this.f4458i = true;
            return;
        }
        boolean zIsAdded = fragment.isAdded();
        l lVar = this.g;
        if (zIsAdded && b(j5)) {
            lVar.getClass();
            ArrayList arrayList = new ArrayList();
            Iterator it = ((CopyOnWriteArrayList) lVar.f110d).iterator();
            if (it.hasNext()) {
                h.p(it.next());
                throw null;
            }
            C0226v c0226vO = t4.O(fragment);
            l.c(arrayList);
            eVar2.f(j5, c0226vO);
        }
        lVar.getClass();
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = ((CopyOnWriteArrayList) lVar.f110d).iterator();
        if (it2.hasNext()) {
            h.p(it2.next());
            throw null;
        }
        try {
            C0206a c0206a = new C0206a(t4);
            c0206a.i(fragment);
            if (c0206a.g) {
                throw new IllegalStateException("This transaction is already being added to the back stack");
            }
            c0206a.f3754p.t(c0206a, false);
            eVar.g(j5);
        } finally {
            l.c(arrayList2);
        }
    }

    public final void g(Parcelable parcelable) {
        String next;
        e eVar = this.f4455d;
        if (eVar.h() == 0) {
            e eVar2 = this.f4454c;
            if (eVar2.h() == 0) {
                Bundle bundle = (Bundle) parcelable;
                if (bundle.getClassLoader() == null) {
                    bundle.setClassLoader(getClass().getClassLoader());
                }
                Iterator<String> it = bundle.keySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        if (eVar2.h() == 0) {
                            return;
                        }
                        this.f4458i = true;
                        this.h = true;
                        c();
                        final Handler handler = new Handler(Looper.getMainLooper());
                        final A a2 = new A(16, this);
                        this.f4452a.a(new r() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter$4
                            @Override // androidx.lifecycle.r
                            public final void a(InterfaceC0249t interfaceC0249t, EnumC0243m enumC0243m) {
                                if (enumC0243m == EnumC0243m.ON_DESTROY) {
                                    handler.removeCallbacks(a2);
                                    interfaceC0249t.getLifecycle().b(this);
                                }
                            }
                        });
                        handler.postDelayed(a2, DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM);
                        return;
                    }
                    next = it.next();
                    if (next.startsWith("f#") && next.length() > 2) {
                        long j5 = Long.parseLong(next.substring(2));
                        T t4 = this.f4453b;
                        t4.getClass();
                        String string = bundle.getString(next);
                        Fragment fragment = null;
                        if (string != null) {
                            Fragment fragmentB = t4.f3697c.b(string);
                            if (fragmentB == null) {
                                t4.X(new IllegalStateException("Fragment no longer exists for key " + next + ": unique id " + string));
                                throw null;
                            }
                            fragment = fragmentB;
                        }
                        eVar2.f(j5, fragment);
                    } else {
                        if (!next.startsWith("s#") || next.length() <= 2) {
                            break;
                        }
                        long j6 = Long.parseLong(next.substring(2));
                        C0226v c0226v = (C0226v) bundle.getParcelable(next);
                        if (b(j6)) {
                            eVar.f(j6, c0226v);
                        }
                    }
                }
                throw new IllegalArgumentException("Unexpected key in savedState: ".concat(next));
            }
        }
        throw new IllegalStateException("Expected the adapter to be 'fresh' while restoring state.");
    }

    @Override // androidx.recyclerview.widget.N
    public final long getItemId(int i5) {
        return i5;
    }

    @Override // androidx.recyclerview.widget.N
    public final void onAttachedToRecyclerView(RecyclerView recyclerView) {
        if (this.f4457f != null) {
            throw new IllegalArgumentException();
        }
        final a aVar = new a(this);
        this.f4457f = aVar;
        ViewPager2 viewPager2A = a.a(recyclerView);
        aVar.f4449d = viewPager2A;
        B0.c cVar = new B0.c(1, aVar);
        aVar.f4446a = cVar;
        ((ArrayList) viewPager2A.f4462e.f89b).add(cVar);
        f0 f0Var = new f0(1, aVar);
        aVar.f4447b = f0Var;
        registerAdapterDataObserver(f0Var);
        r rVar = new r() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter$FragmentMaxLifecycleEnforcer$3
            @Override // androidx.lifecycle.r
            public final void a(InterfaceC0249t interfaceC0249t, EnumC0243m enumC0243m) {
                aVar.b(false);
            }
        };
        aVar.f4448c = rVar;
        this.f4452a.a(rVar);
    }

    @Override // androidx.recyclerview.widget.N
    public final void onBindViewHolder(n0 n0Var, int i5) {
        Fragment mVar;
        c cVar = (c) n0Var;
        long itemId = cVar.getItemId();
        int id = ((FrameLayout) cVar.itemView).getId();
        Long lD = d(id);
        e eVar = this.f4456e;
        if (lD != null && lD.longValue() != itemId) {
            f(lD.longValue());
            eVar.g(lD.longValue());
        }
        eVar.f(itemId, Integer.valueOf(id));
        long j5 = i5;
        e eVar2 = this.f4454c;
        if (eVar2.f9253j) {
            eVar2.c();
        }
        if (d.b(eVar2.f9254k, eVar2.f9256m, j5) < 0) {
            y yVar = (y) this;
            if (i5 == 0) {
                if (yVar.f7365j == null) {
                    yVar.f7365j = new m();
                    Log.d("MessagesPagerAdapter", "Created new InboxFragment");
                } else {
                    Log.d("MessagesPagerAdapter", "Returning existing InboxFragment");
                }
                mVar = yVar.f7365j;
            } else if (i5 != 1) {
                mVar = new m();
            } else {
                if (yVar.f7366k == null) {
                    yVar.f7366k = new E();
                    Log.d("MessagesPagerAdapter", "Created new SentFragment");
                } else {
                    Log.d("MessagesPagerAdapter", "Returning existing SentFragment");
                }
                mVar = yVar.f7366k;
            }
            mVar.setInitialSavedState((C0226v) this.f4455d.d(j5, null));
            eVar2.f(j5, mVar);
        }
        FrameLayout frameLayout = (FrameLayout) cVar.itemView;
        WeakHashMap weakHashMap = Y.f1904a;
        if (J.b(frameLayout)) {
            e(cVar);
        }
        c();
    }

    @Override // androidx.recyclerview.widget.N
    public final n0 onCreateViewHolder(ViewGroup viewGroup, int i5) {
        int i6 = c.f4459a;
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        WeakHashMap weakHashMap = Y.f1904a;
        frameLayout.setId(H.a());
        frameLayout.setSaveEnabled(false);
        return new c(frameLayout);
    }

    @Override // androidx.recyclerview.widget.N
    public final void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        a aVar = this.f4457f;
        aVar.getClass();
        ViewPager2 viewPager2A = a.a(recyclerView);
        ((ArrayList) viewPager2A.f4462e.f89b).remove(aVar.f4446a);
        f0 f0Var = aVar.f4447b;
        b bVar = aVar.f4451f;
        bVar.unregisterAdapterDataObserver(f0Var);
        bVar.f4452a.b(aVar.f4448c);
        aVar.f4449d = null;
        this.f4457f = null;
    }

    @Override // androidx.recyclerview.widget.N
    public final /* bridge */ /* synthetic */ boolean onFailedToRecycleView(n0 n0Var) {
        return true;
    }

    @Override // androidx.recyclerview.widget.N
    public final void onViewAttachedToWindow(n0 n0Var) {
        e((c) n0Var);
        c();
    }

    @Override // androidx.recyclerview.widget.N
    public final void onViewRecycled(n0 n0Var) {
        Long lD = d(((FrameLayout) ((c) n0Var).itemView).getId());
        if (lD != null) {
            f(lD.longValue());
            this.f4456e.g(lD.longValue());
        }
    }

    @Override // androidx.recyclerview.widget.N
    public final void setHasStableIds(boolean z4) {
        throw new UnsupportedOperationException("Stable Ids are required for the adapter to function properly, and the adapter takes care of setting the flag.");
    }
}
