package f;

import O.AbstractC0167h0;
import O.C0163f0;
import O.C0169i0;
import O.J;
import O.K;
import O.M;
import O.Y;
import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import e.AbstractC0429a;
import java.util.ArrayList;
import java.util.WeakHashMap;
import k.InterfaceC0623c;
import k.InterfaceC0634h0;
import k.a1;
import k.f1;

/* renamed from: f.I, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0463I extends AbstractC0464a implements InterfaceC0623c {

    /* renamed from: a, reason: collision with root package name */
    public Context f6265a;

    /* renamed from: b, reason: collision with root package name */
    public Context f6266b;

    /* renamed from: c, reason: collision with root package name */
    public ActionBarOverlayLayout f6267c;

    /* renamed from: d, reason: collision with root package name */
    public ActionBarContainer f6268d;

    /* renamed from: e, reason: collision with root package name */
    public InterfaceC0634h0 f6269e;

    /* renamed from: f, reason: collision with root package name */
    public ActionBarContextView f6270f;
    public final View g;
    public boolean h;

    /* renamed from: i, reason: collision with root package name */
    public C0462H f6271i;

    /* renamed from: j, reason: collision with root package name */
    public C0462H f6272j;

    /* renamed from: k, reason: collision with root package name */
    public i.a f6273k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f6274l;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList f6275m;
    public int n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f6276o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f6277p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f6278q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f6279r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f6280s;

    /* renamed from: t, reason: collision with root package name */
    public i.l f6281t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f6282u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f6283v;

    /* renamed from: w, reason: collision with root package name */
    public final C0461G f6284w;

    /* renamed from: x, reason: collision with root package name */
    public final C0461G f6285x;

    /* renamed from: y, reason: collision with root package name */
    public final B0.l f6286y;

    /* renamed from: z, reason: collision with root package name */
    public static final AccelerateInterpolator f6264z = new AccelerateInterpolator();

    /* renamed from: A, reason: collision with root package name */
    public static final DecelerateInterpolator f6263A = new DecelerateInterpolator();

    public C0463I(Activity activity, boolean z4) {
        new ArrayList();
        this.f6275m = new ArrayList();
        this.n = 0;
        this.f6276o = true;
        this.f6280s = true;
        this.f6284w = new C0461G(this, 0);
        this.f6285x = new C0461G(this, 1);
        this.f6286y = new B0.l(12, this);
        View decorView = activity.getWindow().getDecorView();
        t(decorView);
        if (z4) {
            return;
        }
        this.g = decorView.findViewById(R.id.content);
    }

    @Override // f.AbstractC0464a
    public final boolean b() {
        a1 a1Var;
        InterfaceC0634h0 interfaceC0634h0 = this.f6269e;
        if (interfaceC0634h0 == null || (a1Var = ((f1) interfaceC0634h0).f7769a.f3453O) == null || a1Var.f7747d == null) {
            return false;
        }
        a1 a1Var2 = ((f1) interfaceC0634h0).f7769a.f3453O;
        j.o oVar = a1Var2 == null ? null : a1Var2.f7747d;
        if (oVar == null) {
            return true;
        }
        oVar.collapseActionView();
        return true;
    }

    @Override // f.AbstractC0464a
    public final void c(boolean z4) {
        if (z4 == this.f6274l) {
            return;
        }
        this.f6274l = z4;
        ArrayList arrayList = this.f6275m;
        if (arrayList.size() <= 0) {
            return;
        }
        com.unified.ur1.SatelliteTracker.h.p(arrayList.get(0));
        throw null;
    }

    @Override // f.AbstractC0464a
    public final int d() {
        return ((f1) this.f6269e).f7770b;
    }

    @Override // f.AbstractC0464a
    public final Context e() {
        if (this.f6266b == null) {
            TypedValue typedValue = new TypedValue();
            this.f6265a.getTheme().resolveAttribute(com.unified.ur1.R.attr.actionBarWidgetTheme, typedValue, true);
            int i5 = typedValue.resourceId;
            if (i5 != 0) {
                this.f6266b = new ContextThemeWrapper(this.f6265a, i5);
            } else {
                this.f6266b = this.f6265a;
            }
        }
        return this.f6266b;
    }

    @Override // f.AbstractC0464a
    public final void f() {
        if (this.f6277p) {
            return;
        }
        this.f6277p = true;
        v(false);
    }

    @Override // f.AbstractC0464a
    public final void h() {
        u(this.f6265a.getResources().getBoolean(com.unified.ur1.R.bool.abc_action_bar_embed_tabs));
    }

    @Override // f.AbstractC0464a
    public final boolean j(int i5, KeyEvent keyEvent) {
        j.m mVar;
        C0462H c0462h = this.f6271i;
        if (c0462h == null || (mVar = c0462h.f6261f) == null) {
            return false;
        }
        mVar.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return mVar.performShortcut(i5, keyEvent, 0);
    }

    @Override // f.AbstractC0464a
    public final void m(boolean z4) {
        if (this.h) {
            return;
        }
        n(z4);
    }

    @Override // f.AbstractC0464a
    public final void n(boolean z4) {
        int i5 = z4 ? 4 : 0;
        f1 f1Var = (f1) this.f6269e;
        int i6 = f1Var.f7770b;
        this.h = true;
        f1Var.a((i5 & 4) | (i6 & (-5)));
    }

    @Override // f.AbstractC0464a
    public final void o(boolean z4) {
        i.l lVar;
        this.f6282u = z4;
        if (z4 || (lVar = this.f6281t) == null) {
            return;
        }
        lVar.a();
    }

    @Override // f.AbstractC0464a
    public final void p(String str) {
        f1 f1Var = (f1) this.f6269e;
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
        f1 f1Var = (f1) this.f6269e;
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

    @Override // f.AbstractC0464a
    public final i.b r(L0.e eVar) {
        C0462H c0462h = this.f6271i;
        if (c0462h != null) {
            c0462h.a();
        }
        this.f6267c.setHideOnContentScrollEnabled(false);
        this.f6270f.e();
        C0462H c0462h2 = new C0462H(this, this.f6270f.getContext(), eVar);
        j.m mVar = c0462h2.f6261f;
        mVar.w();
        try {
            if (!c0462h2.g.d(c0462h2, mVar)) {
                return null;
            }
            this.f6271i = c0462h2;
            c0462h2.i();
            this.f6270f.c(c0462h2);
            s(true);
            return c0462h2;
        } finally {
            mVar.v();
        }
    }

    public final void s(boolean z4) {
        C0169i0 c0169i0I;
        C0169i0 c0169i0I2;
        if (z4) {
            if (!this.f6279r) {
                this.f6279r = true;
                ActionBarOverlayLayout actionBarOverlayLayout = this.f6267c;
                if (actionBarOverlayLayout != null) {
                    actionBarOverlayLayout.setShowingForActionMode(true);
                }
                v(false);
            }
        } else if (this.f6279r) {
            this.f6279r = false;
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.f6267c;
            if (actionBarOverlayLayout2 != null) {
                actionBarOverlayLayout2.setShowingForActionMode(false);
            }
            v(false);
        }
        ActionBarContainer actionBarContainer = this.f6268d;
        WeakHashMap weakHashMap = Y.f1904a;
        if (!J.c(actionBarContainer)) {
            if (z4) {
                ((f1) this.f6269e).f7769a.setVisibility(4);
                this.f6270f.setVisibility(0);
                return;
            } else {
                ((f1) this.f6269e).f7769a.setVisibility(0);
                this.f6270f.setVisibility(8);
                return;
            }
        }
        if (z4) {
            f1 f1Var = (f1) this.f6269e;
            c0169i0I = Y.a(f1Var.f7769a);
            c0169i0I.a(BitmapDescriptorFactory.HUE_RED);
            c0169i0I.c(100L);
            c0169i0I.d(new i.k(f1Var, 4));
            c0169i0I2 = this.f6270f.i(0, 200L);
        } else {
            f1 f1Var2 = (f1) this.f6269e;
            C0169i0 c0169i0A = Y.a(f1Var2.f7769a);
            c0169i0A.a(1.0f);
            c0169i0A.c(200L);
            c0169i0A.d(new i.k(f1Var2, 0));
            c0169i0I = this.f6270f.i(8, 100L);
            c0169i0I2 = c0169i0A;
        }
        i.l lVar = new i.l();
        ArrayList arrayList = lVar.f7181a;
        arrayList.add(c0169i0I);
        View view = (View) c0169i0I.f1934a.get();
        long duration = view != null ? view.animate().getDuration() : 0L;
        View view2 = (View) c0169i0I2.f1934a.get();
        if (view2 != null) {
            view2.animate().setStartDelay(duration);
        }
        arrayList.add(c0169i0I2);
        lVar.b();
    }

    public final void t(View view) {
        InterfaceC0634h0 wrapper;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(com.unified.ur1.R.id.decor_content_parent);
        this.f6267c = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        KeyEvent.Callback callbackFindViewById = view.findViewById(com.unified.ur1.R.id.action_bar);
        if (callbackFindViewById instanceof InterfaceC0634h0) {
            wrapper = (InterfaceC0634h0) callbackFindViewById;
        } else {
            if (!(callbackFindViewById instanceof Toolbar)) {
                throw new IllegalStateException("Can't make a decor toolbar out of ".concat(callbackFindViewById != null ? callbackFindViewById.getClass().getSimpleName() : "null"));
            }
            wrapper = ((Toolbar) callbackFindViewById).getWrapper();
        }
        this.f6269e = wrapper;
        this.f6270f = (ActionBarContextView) view.findViewById(com.unified.ur1.R.id.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(com.unified.ur1.R.id.action_bar_container);
        this.f6268d = actionBarContainer;
        InterfaceC0634h0 interfaceC0634h0 = this.f6269e;
        if (interfaceC0634h0 == null || this.f6270f == null || actionBarContainer == null) {
            throw new IllegalStateException(C0463I.class.getSimpleName().concat(" can only be used with a compatible window decor layout"));
        }
        Context context = ((f1) interfaceC0634h0).f7769a.getContext();
        this.f6265a = context;
        if ((((f1) this.f6269e).f7770b & 4) != 0) {
            this.h = true;
        }
        int i5 = context.getApplicationInfo().targetSdkVersion;
        this.f6269e.getClass();
        u(context.getResources().getBoolean(com.unified.ur1.R.bool.abc_action_bar_embed_tabs));
        TypedArray typedArrayObtainStyledAttributes = this.f6265a.obtainStyledAttributes(null, AbstractC0429a.f6115a, com.unified.ur1.R.attr.actionBarStyle, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(14, false)) {
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.f6267c;
            if (!actionBarOverlayLayout2.f3345j) {
                throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
            }
            this.f6283v = true;
            actionBarOverlayLayout2.setHideOnContentScrollEnabled(true);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(12, 0);
        if (dimensionPixelSize != 0) {
            ActionBarContainer actionBarContainer2 = this.f6268d;
            WeakHashMap weakHashMap = Y.f1904a;
            M.s(actionBarContainer2, dimensionPixelSize);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void u(boolean z4) {
        if (z4) {
            this.f6268d.setTabContainer(null);
            ((f1) this.f6269e).getClass();
        } else {
            ((f1) this.f6269e).getClass();
            this.f6268d.setTabContainer(null);
        }
        this.f6269e.getClass();
        ((f1) this.f6269e).f7769a.setCollapsible(false);
        this.f6267c.setHasNonEmbeddedTabs(false);
    }

    public final void v(boolean z4) {
        boolean z5 = this.f6279r || !(this.f6277p || this.f6278q);
        View view = this.g;
        B0.l lVar = this.f6286y;
        if (!z5) {
            if (this.f6280s) {
                this.f6280s = false;
                i.l lVar2 = this.f6281t;
                if (lVar2 != null) {
                    lVar2.a();
                }
                int i5 = this.n;
                C0461G c0461g = this.f6284w;
                if (i5 != 0 || (!this.f6282u && !z4)) {
                    c0461g.a();
                    return;
                }
                this.f6268d.setAlpha(1.0f);
                this.f6268d.setTransitioning(true);
                i.l lVar3 = new i.l();
                float f5 = -this.f6268d.getHeight();
                if (z4) {
                    this.f6268d.getLocationInWindow(new int[]{0, 0});
                    f5 -= r12[1];
                }
                C0169i0 c0169i0A = Y.a(this.f6268d);
                c0169i0A.e(f5);
                View view2 = (View) c0169i0A.f1934a.get();
                if (view2 != null) {
                    AbstractC0167h0.a(view2.animate(), lVar != null ? new C0163f0(lVar, view2) : null);
                }
                boolean z6 = lVar3.f7185e;
                ArrayList arrayList = lVar3.f7181a;
                if (!z6) {
                    arrayList.add(c0169i0A);
                }
                if (this.f6276o && view != null) {
                    C0169i0 c0169i0A2 = Y.a(view);
                    c0169i0A2.e(f5);
                    if (!lVar3.f7185e) {
                        arrayList.add(c0169i0A2);
                    }
                }
                AccelerateInterpolator accelerateInterpolator = f6264z;
                boolean z7 = lVar3.f7185e;
                if (!z7) {
                    lVar3.f7183c = accelerateInterpolator;
                }
                if (!z7) {
                    lVar3.f7182b = 250L;
                }
                if (!z7) {
                    lVar3.f7184d = c0461g;
                }
                this.f6281t = lVar3;
                lVar3.b();
                return;
            }
            return;
        }
        if (this.f6280s) {
            return;
        }
        this.f6280s = true;
        i.l lVar4 = this.f6281t;
        if (lVar4 != null) {
            lVar4.a();
        }
        this.f6268d.setVisibility(0);
        int i6 = this.n;
        C0461G c0461g2 = this.f6285x;
        if (i6 == 0 && (this.f6282u || z4)) {
            this.f6268d.setTranslationY(BitmapDescriptorFactory.HUE_RED);
            float f6 = -this.f6268d.getHeight();
            if (z4) {
                this.f6268d.getLocationInWindow(new int[]{0, 0});
                f6 -= r12[1];
            }
            this.f6268d.setTranslationY(f6);
            i.l lVar5 = new i.l();
            C0169i0 c0169i0A3 = Y.a(this.f6268d);
            c0169i0A3.e(BitmapDescriptorFactory.HUE_RED);
            View view3 = (View) c0169i0A3.f1934a.get();
            if (view3 != null) {
                AbstractC0167h0.a(view3.animate(), lVar != null ? new C0163f0(lVar, view3) : null);
            }
            boolean z8 = lVar5.f7185e;
            ArrayList arrayList2 = lVar5.f7181a;
            if (!z8) {
                arrayList2.add(c0169i0A3);
            }
            if (this.f6276o && view != null) {
                view.setTranslationY(f6);
                C0169i0 c0169i0A4 = Y.a(view);
                c0169i0A4.e(BitmapDescriptorFactory.HUE_RED);
                if (!lVar5.f7185e) {
                    arrayList2.add(c0169i0A4);
                }
            }
            DecelerateInterpolator decelerateInterpolator = f6263A;
            boolean z9 = lVar5.f7185e;
            if (!z9) {
                lVar5.f7183c = decelerateInterpolator;
            }
            if (!z9) {
                lVar5.f7182b = 250L;
            }
            if (!z9) {
                lVar5.f7184d = c0461g2;
            }
            this.f6281t = lVar5;
            lVar5.b();
        } else {
            this.f6268d.setAlpha(1.0f);
            this.f6268d.setTranslationY(BitmapDescriptorFactory.HUE_RED);
            if (this.f6276o && view != null) {
                view.setTranslationY(BitmapDescriptorFactory.HUE_RED);
            }
            c0461g2.a();
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f6267c;
        if (actionBarOverlayLayout != null) {
            WeakHashMap weakHashMap = Y.f1904a;
            K.c(actionBarOverlayLayout);
        }
    }

    public C0463I(Dialog dialog) {
        new ArrayList();
        this.f6275m = new ArrayList();
        this.n = 0;
        this.f6276o = true;
        this.f6280s = true;
        this.f6284w = new C0461G(this, 0);
        this.f6285x = new C0461G(this, 1);
        this.f6286y = new B0.l(12, this);
        t(dialog.getWindow().getDecorView());
    }
}
