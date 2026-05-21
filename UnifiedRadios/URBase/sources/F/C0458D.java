package f;

import O.Y;
import android.content.Context;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.Window;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import f3.C0519j;
import java.util.ArrayList;
import java.util.WeakHashMap;
import k.C0637j;
import k.a1;
import k.f1;

/* renamed from: f.D, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0458D extends AbstractC0464a {

    /* renamed from: a, reason: collision with root package name */
    public final f1 f6246a;

    /* renamed from: b, reason: collision with root package name */
    public final Window.Callback f6247b;

    /* renamed from: c, reason: collision with root package name */
    public final Z2.c f6248c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f6249d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f6250e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f6251f;
    public final ArrayList g = new ArrayList();
    public final C0.A h = new C0.A(18, this);

    public C0458D(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        C0519j c0519j = new C0519j(14, this);
        toolbar.getClass();
        f1 f1Var = new f1(toolbar, false);
        this.f6246a = f1Var;
        callback.getClass();
        this.f6247b = callback;
        f1Var.f7777k = callback;
        toolbar.setOnMenuItemClickListener(c0519j);
        if (!f1Var.g) {
            f1Var.h = charSequence;
            if ((f1Var.f7770b & 8) != 0) {
                Toolbar toolbar2 = f1Var.f7769a;
                toolbar2.setTitle(charSequence);
                if (f1Var.g) {
                    Y.l(toolbar2.getRootView(), charSequence);
                }
            }
        }
        this.f6248c = new Z2.c(16, this);
    }

    @Override // f.AbstractC0464a
    public final boolean a() {
        C0637j c0637j;
        ActionMenuView actionMenuView = this.f6246a.f7769a.f3461c;
        return (actionMenuView == null || (c0637j = actionMenuView.f3368v) == null || !c0637j.c()) ? false : true;
    }

    @Override // f.AbstractC0464a
    public final boolean b() {
        j.o oVar;
        a1 a1Var = this.f6246a.f7769a.f3453O;
        if (a1Var == null || (oVar = a1Var.f7747d) == null) {
            return false;
        }
        if (a1Var == null) {
            oVar = null;
        }
        if (oVar == null) {
            return true;
        }
        oVar.collapseActionView();
        return true;
    }

    @Override // f.AbstractC0464a
    public final void c(boolean z4) {
        if (z4 == this.f6251f) {
            return;
        }
        this.f6251f = z4;
        ArrayList arrayList = this.g;
        if (arrayList.size() <= 0) {
            return;
        }
        com.unified.ur1.SatelliteTracker.h.p(arrayList.get(0));
        throw null;
    }

    @Override // f.AbstractC0464a
    public final int d() {
        return this.f6246a.f7770b;
    }

    @Override // f.AbstractC0464a
    public final Context e() {
        return this.f6246a.f7769a.getContext();
    }

    @Override // f.AbstractC0464a
    public final void f() {
        this.f6246a.f7769a.setVisibility(8);
    }

    @Override // f.AbstractC0464a
    public final boolean g() {
        f1 f1Var = this.f6246a;
        Toolbar toolbar = f1Var.f7769a;
        C0.A a2 = this.h;
        toolbar.removeCallbacks(a2);
        Toolbar toolbar2 = f1Var.f7769a;
        WeakHashMap weakHashMap = Y.f1904a;
        O.G.m(toolbar2, a2);
        return true;
    }

    @Override // f.AbstractC0464a
    public final void h() {
    }

    @Override // f.AbstractC0464a
    public final void i() {
        this.f6246a.f7769a.removeCallbacks(this.h);
    }

    @Override // f.AbstractC0464a
    public final boolean j(int i5, KeyEvent keyEvent) {
        Menu menuS = s();
        if (menuS == null) {
            return false;
        }
        menuS.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menuS.performShortcut(i5, keyEvent, 0);
    }

    @Override // f.AbstractC0464a
    public final boolean k(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            l();
        }
        return true;
    }

    @Override // f.AbstractC0464a
    public final boolean l() {
        return this.f6246a.f7769a.w();
    }

    @Override // f.AbstractC0464a
    public final void m(boolean z4) {
    }

    @Override // f.AbstractC0464a
    public final void n(boolean z4) {
        f1 f1Var = this.f6246a;
        f1Var.a((f1Var.f7770b & (-5)) | 4);
    }

    @Override // f.AbstractC0464a
    public final void o(boolean z4) {
    }

    @Override // f.AbstractC0464a
    public final void p(String str) {
        f1 f1Var = this.f6246a;
        f1Var.g = true;
        f1Var.h = str;
        if ((f1Var.f7770b & 8) != 0) {
            Toolbar toolbar = f1Var.f7769a;
            toolbar.setTitle(str);
            if (f1Var.g) {
                Y.l(toolbar.getRootView(), str);
            }
        }
    }

    @Override // f.AbstractC0464a
    public final void q(CharSequence charSequence) {
        f1 f1Var = this.f6246a;
        if (f1Var.g) {
            return;
        }
        f1Var.h = charSequence;
        if ((f1Var.f7770b & 8) != 0) {
            Toolbar toolbar = f1Var.f7769a;
            toolbar.setTitle(charSequence);
            if (f1Var.g) {
                Y.l(toolbar.getRootView(), charSequence);
            }
        }
    }

    public final Menu s() {
        boolean z4 = this.f6250e;
        f1 f1Var = this.f6246a;
        if (!z4) {
            M.g gVar = new M.g(this);
            L0.l lVar = new L0.l(20, this);
            Toolbar toolbar = f1Var.f7769a;
            toolbar.f3454P = gVar;
            toolbar.f3455Q = lVar;
            ActionMenuView actionMenuView = toolbar.f3461c;
            if (actionMenuView != null) {
                actionMenuView.f3369w = gVar;
                actionMenuView.f3370x = lVar;
            }
            this.f6250e = true;
        }
        return f1Var.f7769a.getMenu();
    }
}
