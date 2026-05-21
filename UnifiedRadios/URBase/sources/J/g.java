package j;

import O.H;
import O.Y;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import com.unified.ur1.R;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import k.A0;
import k.C0648o0;
import k.E0;

/* loaded from: classes.dex */
public final class g extends u implements View.OnKeyListener, PopupWindow.OnDismissListener {

    /* renamed from: A, reason: collision with root package name */
    public ViewTreeObserver f7420A;

    /* renamed from: B, reason: collision with root package name */
    public PopupWindow.OnDismissListener f7421B;

    /* renamed from: C, reason: collision with root package name */
    public boolean f7422C;

    /* renamed from: d, reason: collision with root package name */
    public final Context f7423d;

    /* renamed from: e, reason: collision with root package name */
    public final int f7424e;

    /* renamed from: f, reason: collision with root package name */
    public final int f7425f;
    public final int g;
    public final boolean h;

    /* renamed from: i, reason: collision with root package name */
    public final Handler f7426i;

    /* renamed from: l, reason: collision with root package name */
    public final ViewTreeObserverOnGlobalLayoutListenerC0585d f7429l;

    /* renamed from: m, reason: collision with root package name */
    public final ViewOnAttachStateChangeListenerC0586e f7430m;

    /* renamed from: q, reason: collision with root package name */
    public View f7433q;

    /* renamed from: r, reason: collision with root package name */
    public View f7434r;

    /* renamed from: s, reason: collision with root package name */
    public int f7435s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f7436t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f7437u;

    /* renamed from: v, reason: collision with root package name */
    public int f7438v;

    /* renamed from: w, reason: collision with root package name */
    public int f7439w;

    /* renamed from: y, reason: collision with root package name */
    public boolean f7441y;

    /* renamed from: z, reason: collision with root package name */
    public y f7442z;

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f7427j = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f7428k = new ArrayList();
    public final Z2.c n = new Z2.c(21, this);

    /* renamed from: o, reason: collision with root package name */
    public int f7431o = 0;

    /* renamed from: p, reason: collision with root package name */
    public int f7432p = 0;

    /* renamed from: x, reason: collision with root package name */
    public boolean f7440x = false;

    public g(Context context, View view, int i5, int i6, boolean z4) {
        this.f7429l = new ViewTreeObserverOnGlobalLayoutListenerC0585d(i, this);
        this.f7430m = new ViewOnAttachStateChangeListenerC0586e(i, this);
        this.f7423d = context;
        this.f7433q = view;
        this.f7425f = i5;
        this.g = i6;
        this.h = z4;
        WeakHashMap weakHashMap = Y.f1904a;
        this.f7435s = H.d(view) != 1 ? 1 : 0;
        Resources resources = context.getResources();
        this.f7424e = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f7426i = new Handler();
    }

    @Override // j.z
    public final void a(m mVar, boolean z4) {
        ArrayList arrayList = this.f7428k;
        int size = arrayList.size();
        int i5 = 0;
        while (true) {
            if (i5 >= size) {
                i5 = -1;
                break;
            } else if (mVar == ((C0587f) arrayList.get(i5)).f7418b) {
                break;
            } else {
                i5++;
            }
        }
        if (i5 < 0) {
            return;
        }
        int i6 = i5 + 1;
        if (i6 < arrayList.size()) {
            ((C0587f) arrayList.get(i6)).f7418b.c(false);
        }
        C0587f c0587f = (C0587f) arrayList.remove(i5);
        c0587f.f7418b.r(this);
        boolean z5 = this.f7422C;
        E0 e02 = c0587f.f7417a;
        if (z5) {
            A0.b(e02.f7888B, null);
            e02.f7888B.setAnimationStyle(0);
        }
        e02.dismiss();
        int size2 = arrayList.size();
        if (size2 > 0) {
            this.f7435s = ((C0587f) arrayList.get(size2 - 1)).f7419c;
        } else {
            View view = this.f7433q;
            WeakHashMap weakHashMap = Y.f1904a;
            this.f7435s = H.d(view) == 1 ? 0 : 1;
        }
        if (size2 != 0) {
            if (z4) {
                ((C0587f) arrayList.get(0)).f7418b.c(false);
                return;
            }
            return;
        }
        dismiss();
        y yVar = this.f7442z;
        if (yVar != null) {
            yVar.a(mVar, true);
        }
        ViewTreeObserver viewTreeObserver = this.f7420A;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.f7420A.removeGlobalOnLayoutListener(this.f7429l);
            }
            this.f7420A = null;
        }
        this.f7434r.removeOnAttachStateChangeListener(this.f7430m);
        this.f7421B.onDismiss();
    }

    @Override // j.D
    public final boolean b() {
        ArrayList arrayList = this.f7428k;
        return arrayList.size() > 0 && ((C0587f) arrayList.get(0)).f7417a.f7888B.isShowing();
    }

    @Override // j.D
    public final void c() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (b()) {
            return;
        }
        ArrayList arrayList = this.f7427j;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            x((m) it.next());
        }
        arrayList.clear();
        View view = this.f7433q;
        this.f7434r = view;
        if (view != null) {
            boolean z4 = this.f7420A == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.f7420A = viewTreeObserver;
            if (z4) {
                viewTreeObserver.addOnGlobalLayoutListener(this.f7429l);
            }
            this.f7434r.addOnAttachStateChangeListener(this.f7430m);
        }
    }

    @Override // j.D
    public final void dismiss() {
        ArrayList arrayList = this.f7428k;
        int size = arrayList.size();
        if (size > 0) {
            C0587f[] c0587fArr = (C0587f[]) arrayList.toArray(new C0587f[size]);
            for (int i5 = size - 1; i5 >= 0; i5--) {
                C0587f c0587f = c0587fArr[i5];
                if (c0587f.f7417a.f7888B.isShowing()) {
                    c0587f.f7417a.dismiss();
                }
            }
        }
    }

    @Override // j.z
    public final void e(Parcelable parcelable) {
    }

    @Override // j.D
    public final C0648o0 f() {
        ArrayList arrayList = this.f7428k;
        if (arrayList.isEmpty()) {
            return null;
        }
        return ((C0587f) arrayList.get(arrayList.size() - 1)).f7417a.f7891e;
    }

    @Override // j.z
    public final void g(boolean z4) {
        Iterator it = this.f7428k.iterator();
        while (it.hasNext()) {
            ListAdapter adapter = ((C0587f) it.next()).f7417a.f7891e.getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((j) adapter).notifyDataSetChanged();
        }
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
    public final void l(y yVar) {
        this.f7442z = yVar;
    }

    @Override // j.z
    public final boolean m(F f5) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Iterator it = this.f7428k.iterator();
        while (it.hasNext()) {
            C0587f c0587f = (C0587f) it.next();
            if (f5 == c0587f.f7418b) {
                c0587f.f7417a.f7891e.requestFocus();
                return true;
            }
        }
        if (!f5.hasVisibleItems()) {
            return false;
        }
        n(f5);
        y yVar = this.f7442z;
        if (yVar != null) {
            yVar.i(f5);
        }
        return true;
    }

    @Override // j.u
    public final void n(m mVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        mVar.b(this, this.f7423d);
        if (b()) {
            x(mVar);
        } else {
            this.f7427j.add(mVar);
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        C0587f c0587f;
        ArrayList arrayList = this.f7428k;
        int size = arrayList.size();
        int i5 = 0;
        while (true) {
            if (i5 >= size) {
                c0587f = null;
                break;
            }
            c0587f = (C0587f) arrayList.get(i5);
            if (!c0587f.f7417a.f7888B.isShowing()) {
                break;
            } else {
                i5++;
            }
        }
        if (c0587f != null) {
            c0587f.f7418b.c(false);
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i5, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i5 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // j.u
    public final void p(View view) {
        if (this.f7433q != view) {
            this.f7433q = view;
            int i5 = this.f7431o;
            WeakHashMap weakHashMap = Y.f1904a;
            this.f7432p = Gravity.getAbsoluteGravity(i5, H.d(view));
        }
    }

    @Override // j.u
    public final void q(boolean z4) {
        this.f7440x = z4;
    }

    @Override // j.u
    public final void r(int i5) {
        if (this.f7431o != i5) {
            this.f7431o = i5;
            View view = this.f7433q;
            WeakHashMap weakHashMap = Y.f1904a;
            this.f7432p = Gravity.getAbsoluteGravity(i5, H.d(view));
        }
    }

    @Override // j.u
    public final void s(int i5) {
        this.f7436t = true;
        this.f7438v = i5;
    }

    @Override // j.u
    public final void t(PopupWindow.OnDismissListener onDismissListener) {
        this.f7421B = onDismissListener;
    }

    @Override // j.u
    public final void u(boolean z4) {
        this.f7441y = z4;
    }

    @Override // j.u
    public final void v(int i5) {
        this.f7437u = true;
        this.f7439w = i5;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x017c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void x(j.m r17) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 472
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j.g.x(j.m):void");
    }
}
