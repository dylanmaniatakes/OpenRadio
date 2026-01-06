package j;

import O.H;
import O.Y;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.unified.ur1.R;
import java.util.WeakHashMap;
import k.C0648o0;
import k.E0;

/* loaded from: classes.dex */
public final class E extends u implements PopupWindow.OnDismissListener, View.OnKeyListener {

    /* renamed from: d, reason: collision with root package name */
    public final Context f7379d;

    /* renamed from: e, reason: collision with root package name */
    public final m f7380e;

    /* renamed from: f, reason: collision with root package name */
    public final j f7381f;
    public final boolean g;
    public final int h;

    /* renamed from: i, reason: collision with root package name */
    public final int f7382i;

    /* renamed from: j, reason: collision with root package name */
    public final int f7383j;

    /* renamed from: k, reason: collision with root package name */
    public final E0 f7384k;

    /* renamed from: l, reason: collision with root package name */
    public final ViewTreeObserverOnGlobalLayoutListenerC0585d f7385l;

    /* renamed from: m, reason: collision with root package name */
    public final ViewOnAttachStateChangeListenerC0586e f7386m;
    public PopupWindow.OnDismissListener n;

    /* renamed from: o, reason: collision with root package name */
    public View f7387o;

    /* renamed from: p, reason: collision with root package name */
    public View f7388p;

    /* renamed from: q, reason: collision with root package name */
    public y f7389q;

    /* renamed from: r, reason: collision with root package name */
    public ViewTreeObserver f7390r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f7391s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f7392t;

    /* renamed from: u, reason: collision with root package name */
    public int f7393u;

    /* renamed from: v, reason: collision with root package name */
    public int f7394v = 0;

    /* renamed from: w, reason: collision with root package name */
    public boolean f7395w;

    public E(int i5, int i6, Context context, View view, m mVar, boolean z4) {
        int i7 = 1;
        this.f7385l = new ViewTreeObserverOnGlobalLayoutListenerC0585d(i7, this);
        this.f7386m = new ViewOnAttachStateChangeListenerC0586e(i7, this);
        this.f7379d = context;
        this.f7380e = mVar;
        this.g = z4;
        this.f7381f = new j(mVar, LayoutInflater.from(context), z4, R.layout.abc_popup_menu_item_layout);
        this.f7382i = i5;
        this.f7383j = i6;
        Resources resources = context.getResources();
        this.h = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f7387o = view;
        this.f7384k = new E0(context, null, i5, i6);
        mVar.b(this, context);
    }

    @Override // j.z
    public final void a(m mVar, boolean z4) {
        if (mVar != this.f7380e) {
            return;
        }
        dismiss();
        y yVar = this.f7389q;
        if (yVar != null) {
            yVar.a(mVar, z4);
        }
    }

    @Override // j.D
    public final boolean b() {
        return !this.f7391s && this.f7384k.f7888B.isShowing();
    }

    @Override // j.D
    public final void c() {
        View view;
        if (b()) {
            return;
        }
        if (this.f7391s || (view = this.f7387o) == null) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
        this.f7388p = view;
        E0 e02 = this.f7384k;
        e02.f7888B.setOnDismissListener(this);
        e02.f7901r = this;
        e02.f7887A = true;
        e02.f7888B.setFocusable(true);
        View view2 = this.f7388p;
        boolean z4 = this.f7390r == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.f7390r = viewTreeObserver;
        if (z4) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f7385l);
        }
        view2.addOnAttachStateChangeListener(this.f7386m);
        e02.f7900q = view2;
        e02.n = this.f7394v;
        boolean z5 = this.f7392t;
        Context context = this.f7379d;
        j jVar = this.f7381f;
        if (!z5) {
            this.f7393u = u.o(jVar, context, this.h);
            this.f7392t = true;
        }
        e02.r(this.f7393u);
        e02.f7888B.setInputMethodMode(2);
        Rect rect = this.f7514c;
        e02.f7909z = rect != null ? new Rect(rect) : null;
        e02.c();
        C0648o0 c0648o0 = e02.f7891e;
        c0648o0.setOnKeyListener(this);
        if (this.f7395w) {
            m mVar = this.f7380e;
            if (mVar.f7464m != null) {
                FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) c0648o0, false);
                TextView textView = (TextView) frameLayout.findViewById(android.R.id.title);
                if (textView != null) {
                    textView.setText(mVar.f7464m);
                }
                frameLayout.setEnabled(false);
                c0648o0.addHeaderView(frameLayout, null, false);
            }
        }
        e02.p(jVar);
        e02.c();
    }

    @Override // j.D
    public final void dismiss() {
        if (b()) {
            this.f7384k.dismiss();
        }
    }

    @Override // j.z
    public final void e(Parcelable parcelable) {
    }

    @Override // j.D
    public final C0648o0 f() {
        return this.f7384k.f7891e;
    }

    @Override // j.z
    public final void g(boolean z4) {
        this.f7392t = false;
        j jVar = this.f7381f;
        if (jVar != null) {
            jVar.notifyDataSetChanged();
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
        this.f7389q = yVar;
    }

    @Override // j.z
    public final boolean m(F f5) {
        if (f5.hasVisibleItems()) {
            View view = this.f7388p;
            x xVar = new x(this.f7382i, this.f7383j, this.f7379d, view, f5, this.g);
            y yVar = this.f7389q;
            xVar.f7522i = yVar;
            u uVar = xVar.f7523j;
            if (uVar != null) {
                uVar.l(yVar);
            }
            boolean zW = u.w(f5);
            xVar.h = zW;
            u uVar2 = xVar.f7523j;
            if (uVar2 != null) {
                uVar2.q(zW);
            }
            xVar.f7524k = this.n;
            this.n = null;
            this.f7380e.c(false);
            E0 e02 = this.f7384k;
            int width = e02.h;
            int iN = e02.n();
            int i5 = this.f7394v;
            View view2 = this.f7387o;
            WeakHashMap weakHashMap = Y.f1904a;
            if ((Gravity.getAbsoluteGravity(i5, H.d(view2)) & 7) == 5) {
                width += this.f7387o.getWidth();
            }
            if (!xVar.b()) {
                if (xVar.f7521f != null) {
                    xVar.d(width, iN, true, true);
                }
            }
            y yVar2 = this.f7389q;
            if (yVar2 != null) {
                yVar2.i(f5);
            }
            return true;
        }
        return false;
    }

    @Override // j.u
    public final void n(m mVar) {
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.f7391s = true;
        this.f7380e.c(true);
        ViewTreeObserver viewTreeObserver = this.f7390r;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f7390r = this.f7388p.getViewTreeObserver();
            }
            this.f7390r.removeGlobalOnLayoutListener(this.f7385l);
            this.f7390r = null;
        }
        this.f7388p.removeOnAttachStateChangeListener(this.f7386m);
        PopupWindow.OnDismissListener onDismissListener = this.n;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
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
        this.f7387o = view;
    }

    @Override // j.u
    public final void q(boolean z4) {
        this.f7381f.f7451e = z4;
    }

    @Override // j.u
    public final void r(int i5) {
        this.f7394v = i5;
    }

    @Override // j.u
    public final void s(int i5) {
        this.f7384k.h = i5;
    }

    @Override // j.u
    public final void t(PopupWindow.OnDismissListener onDismissListener) {
        this.n = onDismissListener;
    }

    @Override // j.u
    public final void u(boolean z4) {
        this.f7395w = z4;
    }

    @Override // j.u
    public final void v(int i5) {
        this.f7384k.i(i5);
    }
}
