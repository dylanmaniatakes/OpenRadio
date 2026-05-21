package androidx.recyclerview.widget;

import O.C0182v;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.List;

/* renamed from: androidx.recyclerview.widget.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0265l extends T {

    /* renamed from: s, reason: collision with root package name */
    public static TimeInterpolator f4279s;
    public boolean g;
    public ArrayList h;

    /* renamed from: i, reason: collision with root package name */
    public ArrayList f4280i;

    /* renamed from: j, reason: collision with root package name */
    public ArrayList f4281j;

    /* renamed from: k, reason: collision with root package name */
    public ArrayList f4282k;

    /* renamed from: l, reason: collision with root package name */
    public ArrayList f4283l;

    /* renamed from: m, reason: collision with root package name */
    public ArrayList f4284m;
    public ArrayList n;

    /* renamed from: o, reason: collision with root package name */
    public ArrayList f4285o;

    /* renamed from: p, reason: collision with root package name */
    public ArrayList f4286p;

    /* renamed from: q, reason: collision with root package name */
    public ArrayList f4287q;

    /* renamed from: r, reason: collision with root package name */
    public ArrayList f4288r;

    public static void i(ArrayList arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((n0) arrayList.get(size)).itemView.animate().cancel();
        }
    }

    @Override // androidx.recyclerview.widget.T
    public final boolean a(n0 n0Var, n0 n0Var2, C0182v c0182v, C0182v c0182v2) {
        int i5;
        int i6;
        int i7 = c0182v.f1974a;
        int i8 = c0182v.f1975b;
        if (n0Var2.shouldIgnore()) {
            int i9 = c0182v.f1974a;
            i6 = c0182v.f1975b;
            i5 = i9;
        } else {
            i5 = c0182v2.f1974a;
            i6 = c0182v2.f1975b;
        }
        if (n0Var == n0Var2) {
            return h(n0Var, i7, i8, i5, i6);
        }
        float translationX = n0Var.itemView.getTranslationX();
        float translationY = n0Var.itemView.getTranslationY();
        float alpha = n0Var.itemView.getAlpha();
        m(n0Var);
        n0Var.itemView.setTranslationX(translationX);
        n0Var.itemView.setTranslationY(translationY);
        n0Var.itemView.setAlpha(alpha);
        m(n0Var2);
        n0Var2.itemView.setTranslationX(-((int) ((i5 - i7) - translationX)));
        n0Var2.itemView.setTranslationY(-((int) ((i6 - i8) - translationY)));
        n0Var2.itemView.setAlpha(BitmapDescriptorFactory.HUE_RED);
        ArrayList arrayList = this.f4282k;
        C0263j c0263j = new C0263j();
        c0263j.f4257a = n0Var;
        c0263j.f4258b = n0Var2;
        c0263j.f4259c = i7;
        c0263j.f4260d = i8;
        c0263j.f4261e = i5;
        c0263j.f4262f = i6;
        arrayList.add(c0263j);
        return true;
    }

    @Override // androidx.recyclerview.widget.T
    public final void e(n0 n0Var) {
        View view = n0Var.itemView;
        view.animate().cancel();
        ArrayList arrayList = this.f4281j;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (((C0264k) arrayList.get(size)).f4274a == n0Var) {
                view.setTranslationY(BitmapDescriptorFactory.HUE_RED);
                view.setTranslationX(BitmapDescriptorFactory.HUE_RED);
                d(n0Var);
                arrayList.remove(size);
            }
        }
        k(this.f4282k, n0Var);
        if (this.h.remove(n0Var)) {
            view.setAlpha(1.0f);
            d(n0Var);
        }
        if (this.f4280i.remove(n0Var)) {
            view.setAlpha(1.0f);
            c(n0Var);
        }
        ArrayList arrayList2 = this.n;
        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList3 = (ArrayList) arrayList2.get(size2);
            k(arrayList3, n0Var);
            if (arrayList3.isEmpty()) {
                arrayList2.remove(size2);
            }
        }
        ArrayList arrayList4 = this.f4284m;
        for (int size3 = arrayList4.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList5 = (ArrayList) arrayList4.get(size3);
            int size4 = arrayList5.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (((C0264k) arrayList5.get(size4)).f4274a == n0Var) {
                    view.setTranslationY(BitmapDescriptorFactory.HUE_RED);
                    view.setTranslationX(BitmapDescriptorFactory.HUE_RED);
                    d(n0Var);
                    arrayList5.remove(size4);
                    if (arrayList5.isEmpty()) {
                        arrayList4.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        ArrayList arrayList6 = this.f4283l;
        for (int size5 = arrayList6.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList7 = (ArrayList) arrayList6.get(size5);
            if (arrayList7.remove(n0Var)) {
                view.setAlpha(1.0f);
                c(n0Var);
                if (arrayList7.isEmpty()) {
                    arrayList6.remove(size5);
                }
            }
        }
        this.f4287q.remove(n0Var);
        this.f4285o.remove(n0Var);
        this.f4288r.remove(n0Var);
        this.f4286p.remove(n0Var);
        j();
    }

    @Override // androidx.recyclerview.widget.T
    public final void f() {
        ArrayList arrayList = this.f4281j;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            C0264k c0264k = (C0264k) arrayList.get(size);
            View view = c0264k.f4274a.itemView;
            view.setTranslationY(BitmapDescriptorFactory.HUE_RED);
            view.setTranslationX(BitmapDescriptorFactory.HUE_RED);
            d(c0264k.f4274a);
            arrayList.remove(size);
        }
        ArrayList arrayList2 = this.h;
        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
            d((n0) arrayList2.get(size2));
            arrayList2.remove(size2);
        }
        ArrayList arrayList3 = this.f4280i;
        int size3 = arrayList3.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            n0 n0Var = (n0) arrayList3.get(size3);
            n0Var.itemView.setAlpha(1.0f);
            d(n0Var);
            arrayList3.remove(size3);
        }
        ArrayList arrayList4 = this.f4282k;
        for (int size4 = arrayList4.size() - 1; size4 >= 0; size4--) {
            C0263j c0263j = (C0263j) arrayList4.get(size4);
            n0 n0Var2 = c0263j.f4257a;
            if (n0Var2 != null) {
                l(c0263j, n0Var2);
            }
            n0 n0Var3 = c0263j.f4258b;
            if (n0Var3 != null) {
                l(c0263j, n0Var3);
            }
        }
        arrayList4.clear();
        if (g()) {
            ArrayList arrayList5 = this.f4284m;
            for (int size5 = arrayList5.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList6 = (ArrayList) arrayList5.get(size5);
                for (int size6 = arrayList6.size() - 1; size6 >= 0; size6--) {
                    C0264k c0264k2 = (C0264k) arrayList6.get(size6);
                    View view2 = c0264k2.f4274a.itemView;
                    view2.setTranslationY(BitmapDescriptorFactory.HUE_RED);
                    view2.setTranslationX(BitmapDescriptorFactory.HUE_RED);
                    d(c0264k2.f4274a);
                    arrayList6.remove(size6);
                    if (arrayList6.isEmpty()) {
                        arrayList5.remove(arrayList6);
                    }
                }
            }
            ArrayList arrayList7 = this.f4283l;
            for (int size7 = arrayList7.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList8 = (ArrayList) arrayList7.get(size7);
                for (int size8 = arrayList8.size() - 1; size8 >= 0; size8--) {
                    n0 n0Var4 = (n0) arrayList8.get(size8);
                    n0Var4.itemView.setAlpha(1.0f);
                    d(n0Var4);
                    arrayList8.remove(size8);
                    if (arrayList8.isEmpty()) {
                        arrayList7.remove(arrayList8);
                    }
                }
            }
            ArrayList arrayList9 = this.n;
            for (int size9 = arrayList9.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList10 = (ArrayList) arrayList9.get(size9);
                for (int size10 = arrayList10.size() - 1; size10 >= 0; size10--) {
                    C0263j c0263j2 = (C0263j) arrayList10.get(size10);
                    n0 n0Var5 = c0263j2.f4257a;
                    if (n0Var5 != null) {
                        l(c0263j2, n0Var5);
                    }
                    n0 n0Var6 = c0263j2.f4258b;
                    if (n0Var6 != null) {
                        l(c0263j2, n0Var6);
                    }
                    if (arrayList10.isEmpty()) {
                        arrayList9.remove(arrayList10);
                    }
                }
            }
            i(this.f4287q);
            i(this.f4286p);
            i(this.f4285o);
            i(this.f4288r);
            ArrayList arrayList11 = this.f4167b;
            if (arrayList11.size() > 0) {
                com.unified.ur1.SatelliteTracker.h.p(arrayList11.get(0));
                throw null;
            }
            arrayList11.clear();
        }
    }

    @Override // androidx.recyclerview.widget.T
    public final boolean g() {
        return (this.f4280i.isEmpty() && this.f4282k.isEmpty() && this.f4281j.isEmpty() && this.h.isEmpty() && this.f4286p.isEmpty() && this.f4287q.isEmpty() && this.f4285o.isEmpty() && this.f4288r.isEmpty() && this.f4284m.isEmpty() && this.f4283l.isEmpty() && this.n.isEmpty()) ? false : true;
    }

    public final boolean h(n0 n0Var, int i5, int i6, int i7, int i8) {
        View view = n0Var.itemView;
        int translationX = i5 + ((int) view.getTranslationX());
        int translationY = i6 + ((int) n0Var.itemView.getTranslationY());
        m(n0Var);
        int i9 = i7 - translationX;
        int i10 = i8 - translationY;
        if (i9 == 0 && i10 == 0) {
            d(n0Var);
            return false;
        }
        if (i9 != 0) {
            view.setTranslationX(-i9);
        }
        if (i10 != 0) {
            view.setTranslationY(-i10);
        }
        ArrayList arrayList = this.f4281j;
        C0264k c0264k = new C0264k();
        c0264k.f4274a = n0Var;
        c0264k.f4275b = translationX;
        c0264k.f4276c = translationY;
        c0264k.f4277d = i7;
        c0264k.f4278e = i8;
        arrayList.add(c0264k);
        return true;
    }

    public final void j() {
        if (g()) {
            return;
        }
        ArrayList arrayList = this.f4167b;
        if (arrayList.size() <= 0) {
            arrayList.clear();
        } else {
            com.unified.ur1.SatelliteTracker.h.p(arrayList.get(0));
            throw null;
        }
    }

    public final void k(List list, n0 n0Var) {
        for (int size = list.size() - 1; size >= 0; size--) {
            C0263j c0263j = (C0263j) list.get(size);
            if (l(c0263j, n0Var) && c0263j.f4257a == null && c0263j.f4258b == null) {
                list.remove(c0263j);
            }
        }
    }

    public final boolean l(C0263j c0263j, n0 n0Var) {
        if (c0263j.f4258b == n0Var) {
            c0263j.f4258b = null;
        } else {
            if (c0263j.f4257a != n0Var) {
                return false;
            }
            c0263j.f4257a = null;
        }
        n0Var.itemView.setAlpha(1.0f);
        n0Var.itemView.setTranslationX(BitmapDescriptorFactory.HUE_RED);
        n0Var.itemView.setTranslationY(BitmapDescriptorFactory.HUE_RED);
        d(n0Var);
        return true;
    }

    public final void m(n0 n0Var) {
        if (f4279s == null) {
            f4279s = new ValueAnimator().getInterpolator();
        }
        n0Var.itemView.animate().setInterpolator(f4279s);
        e(n0Var);
    }
}
