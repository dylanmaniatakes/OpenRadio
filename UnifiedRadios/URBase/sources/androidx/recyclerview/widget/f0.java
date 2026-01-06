package androidx.recyclerview.widget;

import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class f0 extends P {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4232a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4233b;

    public /* synthetic */ f0(int i5, Object obj) {
        this.f4232a = i5;
        this.f4233b = obj;
    }

    @Override // androidx.recyclerview.widget.P
    public final void a() {
        switch (this.f4232a) {
            case 0:
                RecyclerView recyclerView = (RecyclerView) this.f4233b;
                recyclerView.k(null);
                recyclerView.f4115j0.f4268f = true;
                recyclerView.Y(true);
                if (!recyclerView.g.j()) {
                    recyclerView.requestLayout();
                    break;
                }
                break;
            default:
                ((androidx.viewpager2.adapter.a) this.f4233b).b(true);
                break;
        }
    }

    @Override // androidx.recyclerview.widget.P
    public final void b(int i5, int i6, Object obj) {
        switch (this.f4232a) {
            case 0:
                RecyclerView recyclerView = (RecyclerView) this.f4233b;
                recyclerView.k(null);
                C0255b c0255b = recyclerView.g;
                if (i6 >= 1) {
                    ArrayList arrayList = (ArrayList) c0255b.f4200c;
                    arrayList.add(c0255b.l(obj, 4, i5, i6));
                    c0255b.f4198a |= 4;
                    if (arrayList.size() == 1) {
                        g();
                        break;
                    }
                } else {
                    c0255b.getClass();
                    break;
                }
                break;
            default:
                a();
                break;
        }
    }

    @Override // androidx.recyclerview.widget.P
    public final void c(int i5, int i6) {
        switch (this.f4232a) {
            case 0:
                RecyclerView recyclerView = (RecyclerView) this.f4233b;
                recyclerView.k(null);
                C0255b c0255b = recyclerView.g;
                if (i6 >= 1) {
                    ArrayList arrayList = (ArrayList) c0255b.f4200c;
                    arrayList.add(c0255b.l(null, 1, i5, i6));
                    c0255b.f4198a |= 1;
                    if (arrayList.size() == 1) {
                        g();
                        break;
                    }
                } else {
                    c0255b.getClass();
                    break;
                }
                break;
            default:
                a();
                break;
        }
    }

    @Override // androidx.recyclerview.widget.P
    public final void d(int i5, int i6) {
        switch (this.f4232a) {
            case 0:
                RecyclerView recyclerView = (RecyclerView) this.f4233b;
                recyclerView.k(null);
                C0255b c0255b = recyclerView.g;
                c0255b.getClass();
                if (i5 != i6) {
                    ArrayList arrayList = (ArrayList) c0255b.f4200c;
                    arrayList.add(c0255b.l(null, 8, i5, i6));
                    c0255b.f4198a |= 8;
                    if (arrayList.size() == 1) {
                        g();
                        break;
                    }
                }
                break;
            default:
                a();
                break;
        }
    }

    @Override // androidx.recyclerview.widget.P
    public final void e(int i5, int i6) {
        switch (this.f4232a) {
            case 0:
                RecyclerView recyclerView = (RecyclerView) this.f4233b;
                recyclerView.k(null);
                C0255b c0255b = recyclerView.g;
                if (i6 >= 1) {
                    ArrayList arrayList = (ArrayList) c0255b.f4200c;
                    arrayList.add(c0255b.l(null, 2, i5, i6));
                    c0255b.f4198a |= 2;
                    if (arrayList.size() == 1) {
                        g();
                        break;
                    }
                } else {
                    c0255b.getClass();
                    break;
                }
                break;
            default:
                a();
                break;
        }
    }

    @Override // androidx.recyclerview.widget.P
    public void f() {
        N n;
        switch (this.f4232a) {
            case 0:
                RecyclerView recyclerView = (RecyclerView) this.f4233b;
                if (recyclerView.f4108f != null && (n = recyclerView.f4123o) != null && n.canRestoreState()) {
                    recyclerView.requestLayout();
                    break;
                }
                break;
        }
    }

    public void g() {
        boolean z4 = RecyclerView.f4071H0;
        RecyclerView recyclerView = (RecyclerView) this.f4233b;
        if (z4 && recyclerView.f4137v && recyclerView.f4135u) {
            WeakHashMap weakHashMap = O.Y.f1904a;
            O.G.m(recyclerView, recyclerView.f4116k);
        } else {
            recyclerView.f4080C = true;
            recyclerView.requestLayout();
        }
    }
}
