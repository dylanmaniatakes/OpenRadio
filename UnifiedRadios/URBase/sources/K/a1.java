package k;

import android.content.Context;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class a1 implements j.z {

    /* renamed from: c, reason: collision with root package name */
    public j.m f7746c;

    /* renamed from: d, reason: collision with root package name */
    public j.o f7747d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Toolbar f7748e;

    public a1(Toolbar toolbar) {
        this.f7748e = toolbar;
    }

    @Override // j.z
    public final void a(j.m mVar, boolean z4) {
    }

    @Override // j.z
    public final boolean d(j.o oVar) {
        Toolbar toolbar = this.f7748e;
        toolbar.c();
        ViewParent parent = toolbar.f3466j.getParent();
        if (parent != toolbar) {
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(toolbar.f3466j);
            }
            toolbar.addView(toolbar.f3466j);
        }
        View actionView = oVar.getActionView();
        toolbar.f3467k = actionView;
        this.f7747d = oVar;
        ViewParent parent2 = actionView.getParent();
        if (parent2 != toolbar) {
            if (parent2 instanceof ViewGroup) {
                ((ViewGroup) parent2).removeView(toolbar.f3467k);
            }
            b1 b1VarH = Toolbar.h();
            b1VarH.f7751a = (toolbar.f3471p & 112) | 8388611;
            b1VarH.f7752b = 2;
            toolbar.f3467k.setLayoutParams(b1VarH);
            toolbar.addView(toolbar.f3467k);
        }
        for (int childCount = toolbar.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = toolbar.getChildAt(childCount);
            if (((b1) childAt.getLayoutParams()).f7752b != 2 && childAt != toolbar.f3461c) {
                toolbar.removeViewAt(childCount);
                toolbar.f3446G.add(childAt);
            }
        }
        toolbar.requestLayout();
        oVar.f7480C = true;
        oVar.n.p(false);
        KeyEvent.Callback callback = toolbar.f3467k;
        if (callback instanceof i.c) {
            ((i.c) callback).b();
        }
        toolbar.x();
        return true;
    }

    @Override // j.z
    public final void e(Parcelable parcelable) {
    }

    @Override // j.z
    public final void g(boolean z4) {
        if (this.f7747d != null) {
            j.m mVar = this.f7746c;
            if (mVar != null) {
                int size = mVar.f7459f.size();
                for (int i5 = 0; i5 < size; i5++) {
                    if (this.f7746c.getItem(i5) == this.f7747d) {
                        return;
                    }
                }
            }
            k(this.f7747d);
        }
    }

    @Override // j.z
    public final int getId() {
        return 0;
    }

    @Override // j.z
    public final void h(Context context, j.m mVar) {
        j.o oVar;
        j.m mVar2 = this.f7746c;
        if (mVar2 != null && (oVar = this.f7747d) != null) {
            mVar2.d(oVar);
        }
        this.f7746c = mVar;
    }

    @Override // j.z
    public final boolean i() {
        return false;
    }

    @Override // j.z
    public final Parcelable j() {
        return null;
    }

    @Override // j.z
    public final boolean k(j.o oVar) {
        Toolbar toolbar = this.f7748e;
        KeyEvent.Callback callback = toolbar.f3467k;
        if (callback instanceof i.c) {
            ((i.c) callback).e();
        }
        toolbar.removeView(toolbar.f3467k);
        toolbar.removeView(toolbar.f3466j);
        toolbar.f3467k = null;
        ArrayList arrayList = toolbar.f3446G;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            toolbar.addView((View) arrayList.get(size));
        }
        arrayList.clear();
        this.f7747d = null;
        toolbar.requestLayout();
        oVar.f7480C = false;
        oVar.n.p(false);
        toolbar.x();
        return true;
    }

    @Override // j.z
    public final boolean m(j.F f5) {
        return false;
    }
}
