package f;

import O.C0169i0;
import O.J;
import O.M;
import O.Y;
import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.ContentFrameLayout;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import e.AbstractC0429a;
import f3.C0513e;
import f3.C0519j;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.WeakHashMap;
import k.C0627e;
import k.C0637j;
import k.InterfaceC0632g0;
import k.f1;
import k.j1;
import okhttp3.internal.ws.WebSocketProtocol;

/* loaded from: classes.dex */
public final class x extends n implements j.k, LayoutInflater.Factory2 {

    /* renamed from: j0, reason: collision with root package name */
    public static final q.k f6384j0 = new q.k();

    /* renamed from: k0, reason: collision with root package name */
    public static final int[] f6385k0 = {R.attr.windowBackground};

    /* renamed from: l0, reason: collision with root package name */
    public static final boolean f6386l0 = !"robolectric".equals(Build.FINGERPRINT);

    /* renamed from: m0, reason: collision with root package name */
    public static final boolean f6387m0 = true;

    /* renamed from: B, reason: collision with root package name */
    public boolean f6389B;

    /* renamed from: C, reason: collision with root package name */
    public ViewGroup f6390C;

    /* renamed from: D, reason: collision with root package name */
    public TextView f6391D;

    /* renamed from: E, reason: collision with root package name */
    public View f6392E;

    /* renamed from: F, reason: collision with root package name */
    public boolean f6393F;

    /* renamed from: G, reason: collision with root package name */
    public boolean f6394G;

    /* renamed from: H, reason: collision with root package name */
    public boolean f6395H;
    public boolean I;

    /* renamed from: J, reason: collision with root package name */
    public boolean f6396J;

    /* renamed from: K, reason: collision with root package name */
    public boolean f6397K;

    /* renamed from: L, reason: collision with root package name */
    public boolean f6398L;

    /* renamed from: M, reason: collision with root package name */
    public boolean f6399M;

    /* renamed from: N, reason: collision with root package name */
    public w[] f6400N;

    /* renamed from: O, reason: collision with root package name */
    public w f6401O;

    /* renamed from: P, reason: collision with root package name */
    public boolean f6402P;

    /* renamed from: Q, reason: collision with root package name */
    public boolean f6403Q;

    /* renamed from: R, reason: collision with root package name */
    public boolean f6404R;

    /* renamed from: S, reason: collision with root package name */
    public boolean f6405S;

    /* renamed from: T, reason: collision with root package name */
    public Configuration f6406T;

    /* renamed from: U, reason: collision with root package name */
    public final int f6407U;

    /* renamed from: V, reason: collision with root package name */
    public int f6408V;

    /* renamed from: W, reason: collision with root package name */
    public int f6409W;

    /* renamed from: X, reason: collision with root package name */
    public boolean f6410X;

    /* renamed from: Y, reason: collision with root package name */
    public t f6411Y;

    /* renamed from: Z, reason: collision with root package name */
    public t f6412Z;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f6413a0;

    /* renamed from: b0, reason: collision with root package name */
    public int f6414b0;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f6416d0;

    /* renamed from: e0, reason: collision with root package name */
    public Rect f6417e0;

    /* renamed from: f0, reason: collision with root package name */
    public Rect f6418f0;

    /* renamed from: g0, reason: collision with root package name */
    public C0455A f6419g0;

    /* renamed from: h0, reason: collision with root package name */
    public OnBackInvokedDispatcher f6420h0;

    /* renamed from: i0, reason: collision with root package name */
    public OnBackInvokedCallback f6421i0;

    /* renamed from: l, reason: collision with root package name */
    public final Object f6422l;

    /* renamed from: m, reason: collision with root package name */
    public final Context f6423m;
    public Window n;

    /* renamed from: o, reason: collision with root package name */
    public s f6424o;

    /* renamed from: p, reason: collision with root package name */
    public final j f6425p;

    /* renamed from: q, reason: collision with root package name */
    public AbstractC0464a f6426q;

    /* renamed from: r, reason: collision with root package name */
    public i.j f6427r;

    /* renamed from: s, reason: collision with root package name */
    public CharSequence f6428s;

    /* renamed from: t, reason: collision with root package name */
    public InterfaceC0632g0 f6429t;

    /* renamed from: u, reason: collision with root package name */
    public Z2.c f6430u;

    /* renamed from: v, reason: collision with root package name */
    public B0.l f6431v;

    /* renamed from: w, reason: collision with root package name */
    public i.b f6432w;

    /* renamed from: x, reason: collision with root package name */
    public ActionBarContextView f6433x;

    /* renamed from: y, reason: collision with root package name */
    public PopupWindow f6434y;

    /* renamed from: z, reason: collision with root package name */
    public o f6435z;

    /* renamed from: A, reason: collision with root package name */
    public C0169i0 f6388A = null;

    /* renamed from: c0, reason: collision with root package name */
    public final o f6415c0 = new o(this, 0);

    public x(Context context, Window window, j jVar, Object obj) {
        AbstractActivityC0472i abstractActivityC0472i;
        this.f6407U = -100;
        this.f6423m = context;
        this.f6425p = jVar;
        this.f6422l = obj;
        if (obj instanceof Dialog) {
            while (context != null) {
                if (!(context instanceof AbstractActivityC0472i)) {
                    if (!(context instanceof ContextWrapper)) {
                        break;
                    } else {
                        context = ((ContextWrapper) context).getBaseContext();
                    }
                } else {
                    abstractActivityC0472i = (AbstractActivityC0472i) context;
                    break;
                }
            }
            abstractActivityC0472i = null;
            if (abstractActivityC0472i != null) {
                this.f6407U = ((x) abstractActivityC0472i.getDelegate()).f6407U;
            }
        }
        if (this.f6407U == -100) {
            q.k kVar = f6384j0;
            Integer num = (Integer) kVar.getOrDefault(this.f6422l.getClass().getName(), null);
            if (num != null) {
                this.f6407U = num.intValue();
                kVar.remove(this.f6422l.getClass().getName());
            }
        }
        if (window != null) {
            p(window);
        }
        k.r.d();
    }

    public static K.i q(Context context) {
        K.i iVar;
        K.i iVar2;
        if (Build.VERSION.SDK_INT >= 33 || (iVar = n.f6352e) == null) {
            return null;
        }
        K.i iVarB = q.b(context.getApplicationContext().getResources().getConfiguration());
        K.j jVar = iVar.f1489a;
        if (jVar.f1490a.isEmpty()) {
            iVar2 = K.i.f1488b;
        } else {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int i5 = 0;
            while (i5 < iVarB.f1489a.f1490a.size() + jVar.f1490a.size()) {
                Locale locale = i5 < jVar.f1490a.size() ? jVar.f1490a.get(i5) : iVarB.f1489a.f1490a.get(i5 - jVar.f1490a.size());
                if (locale != null) {
                    linkedHashSet.add(locale);
                }
                i5++;
            }
            iVar2 = new K.i(new K.j(K.h.a((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]))));
        }
        return iVar2.f1489a.f1490a.isEmpty() ? iVarB : iVar2;
    }

    public static Configuration u(Context context, int i5, K.i iVar, Configuration configuration, boolean z4) {
        int i6 = i5 != 1 ? i5 != 2 ? z4 ? 0 : context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = BitmapDescriptorFactory.HUE_RED;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i6 | (configuration2.uiMode & (-49));
        if (iVar != null) {
            q.d(configuration2, iVar);
        }
        return configuration2;
    }

    public final w A(int i5) {
        w[] wVarArr = this.f6400N;
        if (wVarArr == null || wVarArr.length <= i5) {
            w[] wVarArr2 = new w[i5 + 1];
            if (wVarArr != null) {
                System.arraycopy(wVarArr, 0, wVarArr2, 0, wVarArr.length);
            }
            this.f6400N = wVarArr2;
            wVarArr = wVarArr2;
        }
        w wVar = wVarArr[i5];
        if (wVar != null) {
            return wVar;
        }
        w wVar2 = new w();
        wVar2.f6371a = i5;
        wVar2.n = false;
        wVarArr[i5] = wVar2;
        return wVar2;
    }

    public final void B() {
        x();
        if (this.f6395H && this.f6426q == null) {
            Object obj = this.f6422l;
            if (obj instanceof Activity) {
                this.f6426q = new C0463I((Activity) obj, this.I);
            } else if (obj instanceof Dialog) {
                this.f6426q = new C0463I((Dialog) obj);
            }
            AbstractC0464a abstractC0464a = this.f6426q;
            if (abstractC0464a != null) {
                abstractC0464a.m(this.f6416d0);
            }
        }
    }

    public final void C(int i5) {
        this.f6414b0 = (1 << i5) | this.f6414b0;
        if (this.f6413a0) {
            return;
        }
        View decorView = this.n.getDecorView();
        WeakHashMap weakHashMap = Y.f1904a;
        O.G.m(decorView, this.f6415c0);
        this.f6413a0 = true;
    }

    public final int D(Context context, int i5) {
        if (i5 == -100) {
            return -1;
        }
        if (i5 != -1) {
            if (i5 == 0) {
                if (((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() == 0) {
                    return -1;
                }
                return z(context).e();
            }
            if (i5 != 1 && i5 != 2) {
                if (i5 != 3) {
                    throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                }
                if (this.f6412Z == null) {
                    this.f6412Z = new t(this, context);
                }
                return this.f6412Z.e();
            }
        }
        return i5;
    }

    public final boolean E() {
        boolean z4 = this.f6402P;
        this.f6402P = false;
        w wVarA = A(0);
        if (wVarA.f6381m) {
            if (!z4) {
                t(wVarA, true);
            }
            return true;
        }
        i.b bVar = this.f6432w;
        if (bVar != null) {
            bVar.a();
            return true;
        }
        B();
        AbstractC0464a abstractC0464a = this.f6426q;
        return abstractC0464a != null && abstractC0464a.b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:87:0x0174, code lost:
    
        if (r3.h.getCount() > 0) goto L88;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void F(f.w r18, android.view.KeyEvent r19) {
        /*
            Method dump skipped, instructions count: 473
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f.x.F(f.w, android.view.KeyEvent):void");
    }

    public final boolean G(w wVar, int i5, KeyEvent keyEvent) {
        j.m mVar;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((wVar.f6379k || H(wVar, keyEvent)) && (mVar = wVar.h) != null) {
            return mVar.performShortcut(i5, keyEvent, 1);
        }
        return false;
    }

    public final boolean H(w wVar, KeyEvent keyEvent) {
        InterfaceC0632g0 interfaceC0632g0;
        InterfaceC0632g0 interfaceC0632g02;
        Resources.Theme themeNewTheme;
        InterfaceC0632g0 interfaceC0632g03;
        InterfaceC0632g0 interfaceC0632g04;
        if (this.f6405S) {
            return false;
        }
        if (wVar.f6379k) {
            return true;
        }
        w wVar2 = this.f6401O;
        if (wVar2 != null && wVar2 != wVar) {
            t(wVar2, false);
        }
        Window.Callback callback = this.n.getCallback();
        int i5 = wVar.f6371a;
        if (callback != null) {
            wVar.g = callback.onCreatePanelView(i5);
        }
        boolean z4 = i5 == 0 || i5 == 108;
        if (z4 && (interfaceC0632g04 = this.f6429t) != null) {
            ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) interfaceC0632g04;
            actionBarOverlayLayout.k();
            ((f1) actionBarOverlayLayout.g).f7778l = true;
        }
        if (wVar.g == null && (!z4 || !(this.f6426q instanceof C0458D))) {
            j.m mVar = wVar.h;
            if (mVar == null || wVar.f6382o) {
                if (mVar == null) {
                    Context context = this.f6423m;
                    if ((i5 == 0 || i5 == 108) && this.f6429t != null) {
                        TypedValue typedValue = new TypedValue();
                        Resources.Theme theme = context.getTheme();
                        theme.resolveAttribute(com.unified.ur1.R.attr.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            themeNewTheme = context.getResources().newTheme();
                            themeNewTheme.setTo(theme);
                            themeNewTheme.applyStyle(typedValue.resourceId, true);
                            themeNewTheme.resolveAttribute(com.unified.ur1.R.attr.actionBarWidgetTheme, typedValue, true);
                        } else {
                            theme.resolveAttribute(com.unified.ur1.R.attr.actionBarWidgetTheme, typedValue, true);
                            themeNewTheme = null;
                        }
                        if (typedValue.resourceId != 0) {
                            if (themeNewTheme == null) {
                                themeNewTheme = context.getResources().newTheme();
                                themeNewTheme.setTo(theme);
                            }
                            themeNewTheme.applyStyle(typedValue.resourceId, true);
                        }
                        if (themeNewTheme != null) {
                            i.e eVar = new i.e(context, 0);
                            eVar.getTheme().setTo(themeNewTheme);
                            context = eVar;
                        }
                    }
                    j.m mVar2 = new j.m(context);
                    mVar2.f7458e = this;
                    j.m mVar3 = wVar.h;
                    if (mVar2 != mVar3) {
                        if (mVar3 != null) {
                            mVar3.r(wVar.f6377i);
                        }
                        wVar.h = mVar2;
                        j.i iVar = wVar.f6377i;
                        if (iVar != null) {
                            mVar2.b(iVar, mVar2.f7454a);
                        }
                    }
                    if (wVar.h == null) {
                        return false;
                    }
                }
                if (z4 && (interfaceC0632g02 = this.f6429t) != null) {
                    if (this.f6430u == null) {
                        this.f6430u = new Z2.c(15, this);
                    }
                    ((ActionBarOverlayLayout) interfaceC0632g02).l(wVar.h, this.f6430u);
                }
                wVar.h.w();
                if (!callback.onCreatePanelMenu(i5, wVar.h)) {
                    j.m mVar4 = wVar.h;
                    if (mVar4 != null) {
                        if (mVar4 != null) {
                            mVar4.r(wVar.f6377i);
                        }
                        wVar.h = null;
                    }
                    if (z4 && (interfaceC0632g0 = this.f6429t) != null) {
                        ((ActionBarOverlayLayout) interfaceC0632g0).l(null, this.f6430u);
                    }
                    return false;
                }
                wVar.f6382o = false;
            }
            wVar.h.w();
            Bundle bundle = wVar.f6383p;
            if (bundle != null) {
                wVar.h.s(bundle);
                wVar.f6383p = null;
            }
            if (!callback.onPreparePanel(0, wVar.g, wVar.h)) {
                if (z4 && (interfaceC0632g03 = this.f6429t) != null) {
                    ((ActionBarOverlayLayout) interfaceC0632g03).l(null, this.f6430u);
                }
                wVar.h.v();
                return false;
            }
            wVar.h.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
            wVar.h.v();
        }
        wVar.f6379k = true;
        wVar.f6380l = false;
        this.f6401O = wVar;
        return true;
    }

    public final void I() {
        if (this.f6389B) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    public final void J() {
        OnBackInvokedCallback onBackInvokedCallback;
        if (Build.VERSION.SDK_INT >= 33) {
            boolean z4 = false;
            if (this.f6420h0 != null && (A(0).f6381m || this.f6432w != null)) {
                z4 = true;
            }
            if (z4 && this.f6421i0 == null) {
                this.f6421i0 = r.b(this.f6420h0, this);
            } else {
                if (z4 || (onBackInvokedCallback = this.f6421i0) == null) {
                    return;
                }
                r.c(this.f6420h0, onBackInvokedCallback);
            }
        }
    }

    @Override // f.n
    public final void a() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f6423m);
        if (layoutInflaterFrom.getFactory() == null) {
            layoutInflaterFrom.setFactory2(this);
        } else {
            if (layoutInflaterFrom.getFactory2() instanceof x) {
                return;
            }
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // f.n
    public final void b() {
        if (this.f6426q != null) {
            B();
            if (this.f6426q.g()) {
                return;
            }
            C(0);
        }
    }

    @Override // f.n
    public final void d() {
        String strL;
        this.f6403Q = true;
        o(false, true);
        y();
        Object obj = this.f6422l;
        if (obj instanceof Activity) {
            try {
                Activity activity = (Activity) obj;
                try {
                    strL = A2.b.l(activity, activity.getComponentName());
                } catch (PackageManager.NameNotFoundException e5) {
                    throw new IllegalArgumentException(e5);
                }
            } catch (IllegalArgumentException unused) {
                strL = null;
            }
            if (strL != null) {
                AbstractC0464a abstractC0464a = this.f6426q;
                if (abstractC0464a == null) {
                    this.f6416d0 = true;
                } else {
                    abstractC0464a.m(true);
                }
            }
            synchronized (n.f6355j) {
                n.h(this);
                n.f6354i.add(new WeakReference(this));
            }
        }
        this.f6406T = new Configuration(this.f6423m.getResources().getConfiguration());
        this.f6404R = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0048, code lost:
    
        if (r6.f() != false) goto L20;
     */
    @Override // j.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(j.m r6) {
        /*
            r5 = this;
            k.g0 r6 = r5.f6429t
            r0 = 1
            r1 = 0
            if (r6 == 0) goto Ld3
            androidx.appcompat.widget.ActionBarOverlayLayout r6 = (androidx.appcompat.widget.ActionBarOverlayLayout) r6
            r6.k()
            k.h0 r6 = r6.g
            k.f1 r6 = (k.f1) r6
            androidx.appcompat.widget.Toolbar r6 = r6.f7769a
            int r2 = r6.getVisibility()
            if (r2 != 0) goto Ld3
            androidx.appcompat.widget.ActionMenuView r6 = r6.f3461c
            if (r6 == 0) goto Ld3
            boolean r6 = r6.f3367u
            if (r6 == 0) goto Ld3
            android.content.Context r6 = r5.f6423m
            android.view.ViewConfiguration r6 = android.view.ViewConfiguration.get(r6)
            boolean r6 = r6.hasPermanentMenuKey()
            if (r6 == 0) goto L4a
            k.g0 r6 = r5.f6429t
            androidx.appcompat.widget.ActionBarOverlayLayout r6 = (androidx.appcompat.widget.ActionBarOverlayLayout) r6
            r6.k()
            k.h0 r6 = r6.g
            k.f1 r6 = (k.f1) r6
            androidx.appcompat.widget.Toolbar r6 = r6.f7769a
            androidx.appcompat.widget.ActionMenuView r6 = r6.f3461c
            if (r6 == 0) goto Ld3
            k.j r6 = r6.f3368v
            if (r6 == 0) goto Ld3
            k.g r2 = r6.f7807x
            if (r2 != 0) goto L4a
            boolean r6 = r6.f()
            if (r6 == 0) goto Ld3
        L4a:
            android.view.Window r6 = r5.n
            android.view.Window$Callback r6 = r6.getCallback()
            k.g0 r2 = r5.f6429t
            androidx.appcompat.widget.ActionBarOverlayLayout r2 = (androidx.appcompat.widget.ActionBarOverlayLayout) r2
            r2.k()
            k.h0 r2 = r2.g
            k.f1 r2 = (k.f1) r2
            androidx.appcompat.widget.Toolbar r2 = r2.f7769a
            boolean r2 = r2.q()
            r3 = 108(0x6c, float:1.51E-43)
            if (r2 == 0) goto L8c
            k.g0 r0 = r5.f6429t
            androidx.appcompat.widget.ActionBarOverlayLayout r0 = (androidx.appcompat.widget.ActionBarOverlayLayout) r0
            r0.k()
            k.h0 r0 = r0.g
            k.f1 r0 = (k.f1) r0
            androidx.appcompat.widget.Toolbar r0 = r0.f7769a
            androidx.appcompat.widget.ActionMenuView r0 = r0.f3461c
            if (r0 == 0) goto L7e
            k.j r0 = r0.f3368v
            if (r0 == 0) goto L7e
            boolean r0 = r0.c()
        L7e:
            boolean r0 = r5.f6405S
            if (r0 != 0) goto Le0
            f.w r0 = r5.A(r1)
            j.m r0 = r0.h
            r6.onPanelClosed(r3, r0)
            goto Le0
        L8c:
            if (r6 == 0) goto Le0
            boolean r2 = r5.f6405S
            if (r2 != 0) goto Le0
            boolean r2 = r5.f6413a0
            if (r2 == 0) goto La9
            int r2 = r5.f6414b0
            r0 = r0 & r2
            if (r0 == 0) goto La9
            android.view.Window r0 = r5.n
            android.view.View r0 = r0.getDecorView()
            f.o r2 = r5.f6415c0
            r0.removeCallbacks(r2)
            r2.run()
        La9:
            f.w r0 = r5.A(r1)
            j.m r2 = r0.h
            if (r2 == 0) goto Le0
            boolean r4 = r0.f6382o
            if (r4 != 0) goto Le0
            android.view.View r4 = r0.g
            boolean r1 = r6.onPreparePanel(r1, r4, r2)
            if (r1 == 0) goto Le0
            j.m r0 = r0.h
            r6.onMenuOpened(r3, r0)
            k.g0 r6 = r5.f6429t
            androidx.appcompat.widget.ActionBarOverlayLayout r6 = (androidx.appcompat.widget.ActionBarOverlayLayout) r6
            r6.k()
            k.h0 r6 = r6.g
            k.f1 r6 = (k.f1) r6
            androidx.appcompat.widget.Toolbar r6 = r6.f7769a
            r6.w()
            goto Le0
        Ld3:
            f.w r6 = r5.A(r1)
            r6.n = r0
            r5.t(r6, r1)
            r0 = 0
            r5.F(r6, r0)
        Le0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f.x.e(j.m):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004d  */
    @Override // f.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f6422l
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L11
            java.lang.Object r0 = f.n.f6355j
            monitor-enter(r0)
            f.n.h(r3)     // Catch: java.lang.Throwable -> Le
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            goto L11
        Le:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            throw r1
        L11:
            boolean r0 = r3.f6413a0
            if (r0 == 0) goto L20
            android.view.Window r0 = r3.n
            android.view.View r0 = r0.getDecorView()
            f.o r1 = r3.f6415c0
            r0.removeCallbacks(r1)
        L20:
            r0 = 1
            r3.f6405S = r0
            int r0 = r3.f6407U
            r1 = -100
            if (r0 == r1) goto L4d
            java.lang.Object r0 = r3.f6422l
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L4d
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L4d
            q.k r0 = f.x.f6384j0
            java.lang.Object r1 = r3.f6422l
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.f6407U
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L5c
        L4d:
            q.k r0 = f.x.f6384j0
            java.lang.Object r1 = r3.f6422l
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L5c:
            f.a r0 = r3.f6426q
            if (r0 == 0) goto L63
            r0.i()
        L63:
            f.t r0 = r3.f6411Y
            if (r0 == 0) goto L6a
            r0.c()
        L6a:
            f.t r0 = r3.f6412Z
            if (r0 == 0) goto L71
            r0.c()
        L71:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f.x.f():void");
    }

    @Override // j.k
    public final boolean g(j.m mVar, MenuItem menuItem) {
        w wVar;
        Window.Callback callback = this.n.getCallback();
        if (callback != null && !this.f6405S) {
            j.m mVarK = mVar.k();
            w[] wVarArr = this.f6400N;
            int length = wVarArr != null ? wVarArr.length : 0;
            int i5 = 0;
            while (true) {
                if (i5 < length) {
                    wVar = wVarArr[i5];
                    if (wVar != null && wVar.h == mVarK) {
                        break;
                    }
                    i5++;
                } else {
                    wVar = null;
                    break;
                }
            }
            if (wVar != null) {
                return callback.onMenuItemSelected(wVar.f6371a, menuItem);
            }
        }
        return false;
    }

    @Override // f.n
    public final boolean i(int i5) {
        if (i5 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            i5 = 108;
        } else if (i5 == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            i5 = 109;
        }
        if (this.f6398L && i5 == 108) {
            return false;
        }
        if (this.f6395H && i5 == 1) {
            this.f6395H = false;
        }
        if (i5 == 1) {
            I();
            this.f6398L = true;
            return true;
        }
        if (i5 == 2) {
            I();
            this.f6393F = true;
            return true;
        }
        if (i5 == 5) {
            I();
            this.f6394G = true;
            return true;
        }
        if (i5 == 10) {
            I();
            this.f6396J = true;
            return true;
        }
        if (i5 == 108) {
            I();
            this.f6395H = true;
            return true;
        }
        if (i5 != 109) {
            return this.n.requestFeature(i5);
        }
        I();
        this.I = true;
        return true;
    }

    @Override // f.n
    public final void j(int i5) {
        x();
        ViewGroup viewGroup = (ViewGroup) this.f6390C.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f6423m).inflate(i5, viewGroup);
        this.f6424o.a(this.n.getCallback());
    }

    @Override // f.n
    public final void k(View view) {
        x();
        ViewGroup viewGroup = (ViewGroup) this.f6390C.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f6424o.a(this.n.getCallback());
    }

    @Override // f.n
    public final void l(View view, ViewGroup.LayoutParams layoutParams) {
        x();
        ViewGroup viewGroup = (ViewGroup) this.f6390C.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f6424o.a(this.n.getCallback());
    }

    @Override // f.n
    public final void m(CharSequence charSequence) {
        this.f6428s = charSequence;
        InterfaceC0632g0 interfaceC0632g0 = this.f6429t;
        if (interfaceC0632g0 != null) {
            interfaceC0632g0.setWindowTitle(charSequence);
            return;
        }
        AbstractC0464a abstractC0464a = this.f6426q;
        if (abstractC0464a != null) {
            abstractC0464a.q(charSequence);
            return;
        }
        TextView textView = this.f6391D;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x019d  */
    @Override // f.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final i.b n(i.a r9) {
        /*
            Method dump skipped, instructions count: 457
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f.x.n(i.a):i.b");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean o(boolean r13, boolean r14) {
        /*
            Method dump skipped, instructions count: 396
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f.x.o(boolean, boolean):boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009a  */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r8v3 */
    @Override // android.view.LayoutInflater.Factory2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View onCreateView(android.view.View r18, java.lang.String r19, android.content.Context r20, android.util.AttributeSet r21) {
        /*
            Method dump skipped, instructions count: 742
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f.x.onCreateView(android.view.View, java.lang.String, android.content.Context, android.util.AttributeSet):android.view.View");
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void p(android.view.Window r8) {
        /*
            r7 = this;
            android.view.Window r0 = r7.n
            java.lang.String r1 = "AppCompat has already installed itself into the Window"
            if (r0 != 0) goto L80
            android.view.Window$Callback r0 = r8.getCallback()
            boolean r2 = r0 instanceof f.s
            if (r2 != 0) goto L7a
            f.s r1 = new f.s
            r1.<init>(r7, r0)
            r7.f6424o = r1
            r8.setCallback(r1)
            int[] r0 = f.x.f6385k0
            android.content.Context r1 = r7.f6423m
            r2 = 0
            android.content.res.TypedArray r0 = r1.obtainStyledAttributes(r2, r0)
            r3 = 0
            boolean r4 = r0.hasValue(r3)
            if (r4 == 0) goto L3f
            int r3 = r0.getResourceId(r3, r3)
            if (r3 == 0) goto L3f
            k.r r4 = k.r.a()
            monitor-enter(r4)
            k.G0 r5 = r4.f7855a     // Catch: java.lang.Throwable -> L3c
            r6 = 1
            android.graphics.drawable.Drawable r1 = r5.f(r1, r3, r6)     // Catch: java.lang.Throwable -> L3c
            monitor-exit(r4)
            goto L40
        L3c:
            r8 = move-exception
            monitor-exit(r4)
            throw r8
        L3f:
            r1 = r2
        L40:
            if (r1 == 0) goto L45
            r8.setBackgroundDrawable(r1)
        L45:
            r0.recycle()
            r7.n = r8
            int r8 = android.os.Build.VERSION.SDK_INT
            r0 = 33
            if (r8 < r0) goto L79
            android.window.OnBackInvokedDispatcher r8 = r7.f6420h0
            if (r8 != 0) goto L79
            if (r8 == 0) goto L5f
            android.window.OnBackInvokedCallback r0 = r7.f6421i0
            if (r0 == 0) goto L5f
            f.r.c(r8, r0)
            r7.f6421i0 = r2
        L5f:
            java.lang.Object r8 = r7.f6422l
            boolean r0 = r8 instanceof android.app.Activity
            if (r0 == 0) goto L74
            android.app.Activity r8 = (android.app.Activity) r8
            android.view.Window r0 = r8.getWindow()
            if (r0 == 0) goto L74
            android.window.OnBackInvokedDispatcher r8 = f.r.a(r8)
            r7.f6420h0 = r8
            goto L76
        L74:
            r7.f6420h0 = r2
        L76:
            r7.J()
        L79:
            return
        L7a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            r8.<init>(r1)
            throw r8
        L80:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            r8.<init>(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: f.x.p(android.view.Window):void");
    }

    public final void r(int i5, w wVar, j.m mVar) {
        if (mVar == null) {
            if (wVar == null && i5 >= 0) {
                w[] wVarArr = this.f6400N;
                if (i5 < wVarArr.length) {
                    wVar = wVarArr[i5];
                }
            }
            if (wVar != null) {
                mVar = wVar.h;
            }
        }
        if ((wVar == null || wVar.f6381m) && !this.f6405S) {
            s sVar = this.f6424o;
            Window.Callback callback = this.n.getCallback();
            sVar.getClass();
            try {
                sVar.g = true;
                callback.onPanelClosed(i5, mVar);
            } finally {
                sVar.g = false;
            }
        }
    }

    public final void s(j.m mVar) {
        C0637j c0637j;
        if (this.f6399M) {
            return;
        }
        this.f6399M = true;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.f6429t;
        actionBarOverlayLayout.k();
        ActionMenuView actionMenuView = ((f1) actionBarOverlayLayout.g).f7769a.f3461c;
        if (actionMenuView != null && (c0637j = actionMenuView.f3368v) != null) {
            c0637j.c();
            C0627e c0627e = c0637j.f7806w;
            if (c0627e != null && c0627e.b()) {
                c0627e.f7523j.dismiss();
            }
        }
        Window.Callback callback = this.n.getCallback();
        if (callback != null && !this.f6405S) {
            callback.onPanelClosed(108, mVar);
        }
        this.f6399M = false;
    }

    public final void t(w wVar, boolean z4) {
        v vVar;
        InterfaceC0632g0 interfaceC0632g0;
        if (z4 && wVar.f6371a == 0 && (interfaceC0632g0 = this.f6429t) != null) {
            ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) interfaceC0632g0;
            actionBarOverlayLayout.k();
            if (((f1) actionBarOverlayLayout.g).f7769a.q()) {
                s(wVar.h);
                return;
            }
        }
        WindowManager windowManager = (WindowManager) this.f6423m.getSystemService("window");
        if (windowManager != null && wVar.f6381m && (vVar = wVar.f6375e) != null) {
            windowManager.removeView(vVar);
            if (z4) {
                r(wVar.f6371a, wVar, null);
            }
        }
        wVar.f6379k = false;
        wVar.f6380l = false;
        wVar.f6381m = false;
        wVar.f6376f = null;
        wVar.n = true;
        if (this.f6401O == wVar) {
            this.f6401O = null;
        }
        if (wVar.f6371a == 0) {
            J();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x00ed  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean v(android.view.KeyEvent r7) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f.x.v(android.view.KeyEvent):boolean");
    }

    public final void w(int i5) {
        w wVarA = A(i5);
        if (wVarA.h != null) {
            Bundle bundle = new Bundle();
            wVarA.h.t(bundle);
            if (bundle.size() > 0) {
                wVarA.f6383p = bundle;
            }
            wVarA.h.w();
            wVarA.h.clear();
        }
        wVarA.f6382o = true;
        wVarA.n = true;
        if ((i5 == 108 || i5 == 0) && this.f6429t != null) {
            w wVarA2 = A(0);
            wVarA2.f6379k = false;
            H(wVarA2, null);
        }
    }

    public final void x() {
        ViewGroup viewGroup;
        if (this.f6389B) {
            return;
        }
        int[] iArr = AbstractC0429a.f6122j;
        Context context = this.f6423m;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iArr);
        if (!typedArrayObtainStyledAttributes.hasValue(117)) {
            typedArrayObtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (typedArrayObtainStyledAttributes.getBoolean(WebSocketProtocol.PAYLOAD_SHORT, false)) {
            i(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(117, false)) {
            i(108);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(118, false)) {
            i(109);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(119, false)) {
            i(10);
        }
        this.f6397K = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        y();
        this.n.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        if (this.f6398L) {
            viewGroup = this.f6396J ? (ViewGroup) layoutInflaterFrom.inflate(com.unified.ur1.R.layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) layoutInflaterFrom.inflate(com.unified.ur1.R.layout.abc_screen_simple, (ViewGroup) null);
        } else if (this.f6397K) {
            viewGroup = (ViewGroup) layoutInflaterFrom.inflate(com.unified.ur1.R.layout.abc_dialog_title_material, (ViewGroup) null);
            this.I = false;
            this.f6395H = false;
        } else if (this.f6395H) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(com.unified.ur1.R.attr.actionBarTheme, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new i.e(context, typedValue.resourceId) : context).inflate(com.unified.ur1.R.layout.abc_screen_toolbar, (ViewGroup) null);
            InterfaceC0632g0 interfaceC0632g0 = (InterfaceC0632g0) viewGroup.findViewById(com.unified.ur1.R.id.decor_content_parent);
            this.f6429t = interfaceC0632g0;
            interfaceC0632g0.setWindowCallback(this.n.getCallback());
            if (this.I) {
                ((ActionBarOverlayLayout) this.f6429t).j(109);
            }
            if (this.f6393F) {
                ((ActionBarOverlayLayout) this.f6429t).j(2);
            }
            if (this.f6394G) {
                ((ActionBarOverlayLayout) this.f6429t).j(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.f6395H + ", windowActionBarOverlay: " + this.I + ", android:windowIsFloating: " + this.f6397K + ", windowActionModeOverlay: " + this.f6396J + ", windowNoTitle: " + this.f6398L + " }");
        }
        C0519j c0519j = new C0519j(13, this);
        WeakHashMap weakHashMap = Y.f1904a;
        M.u(viewGroup, c0519j);
        if (this.f6429t == null) {
            this.f6391D = (TextView) viewGroup.findViewById(com.unified.ur1.R.id.title);
        }
        Method method = j1.f7810a;
        try {
            Method method2 = viewGroup.getClass().getMethod("makeOptionalFitsSystemWindows", null);
            if (!method2.isAccessible()) {
                method2.setAccessible(true);
            }
            method2.invoke(viewGroup, null);
        } catch (IllegalAccessException e5) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e5);
        } catch (NoSuchMethodException unused) {
            Log.d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
        } catch (InvocationTargetException e6) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e6);
        }
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(com.unified.ur1.R.id.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) this.n.findViewById(R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.n.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new L0.l(19, this));
        this.f6390C = viewGroup;
        Object obj = this.f6422l;
        CharSequence title = obj instanceof Activity ? ((Activity) obj).getTitle() : this.f6428s;
        if (!TextUtils.isEmpty(title)) {
            InterfaceC0632g0 interfaceC0632g02 = this.f6429t;
            if (interfaceC0632g02 != null) {
                interfaceC0632g02.setWindowTitle(title);
            } else {
                AbstractC0464a abstractC0464a = this.f6426q;
                if (abstractC0464a != null) {
                    abstractC0464a.q(title);
                } else {
                    TextView textView = this.f6391D;
                    if (textView != null) {
                        textView.setText(title);
                    }
                }
            }
        }
        ContentFrameLayout contentFrameLayout2 = (ContentFrameLayout) this.f6390C.findViewById(R.id.content);
        View decorView = this.n.getDecorView();
        contentFrameLayout2.f3384i.set(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        WeakHashMap weakHashMap2 = Y.f1904a;
        if (J.c(contentFrameLayout2)) {
            contentFrameLayout2.requestLayout();
        }
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(iArr);
        typedArrayObtainStyledAttributes2.getValue(124, contentFrameLayout2.getMinWidthMajor());
        typedArrayObtainStyledAttributes2.getValue(125, contentFrameLayout2.getMinWidthMinor());
        if (typedArrayObtainStyledAttributes2.hasValue(122)) {
            typedArrayObtainStyledAttributes2.getValue(122, contentFrameLayout2.getFixedWidthMajor());
        }
        if (typedArrayObtainStyledAttributes2.hasValue(123)) {
            typedArrayObtainStyledAttributes2.getValue(123, contentFrameLayout2.getFixedWidthMinor());
        }
        if (typedArrayObtainStyledAttributes2.hasValue(120)) {
            typedArrayObtainStyledAttributes2.getValue(120, contentFrameLayout2.getFixedHeightMajor());
        }
        if (typedArrayObtainStyledAttributes2.hasValue(121)) {
            typedArrayObtainStyledAttributes2.getValue(121, contentFrameLayout2.getFixedHeightMinor());
        }
        typedArrayObtainStyledAttributes2.recycle();
        contentFrameLayout2.requestLayout();
        this.f6389B = true;
        w wVarA = A(0);
        if (this.f6405S || wVarA.h != null) {
            return;
        }
        C(108);
    }

    public final void y() {
        if (this.n == null) {
            Object obj = this.f6422l;
            if (obj instanceof Activity) {
                p(((Activity) obj).getWindow());
            }
        }
        if (this.n == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    public final u z(Context context) {
        if (this.f6411Y == null) {
            if (C0513e.g == null) {
                Context applicationContext = context.getApplicationContext();
                LocationManager locationManager = (LocationManager) applicationContext.getSystemService("location");
                C0513e c0513e = new C0513e();
                c0513e.f6688e = new C0460F();
                c0513e.f6686c = applicationContext;
                c0513e.f6687d = locationManager;
                C0513e.g = c0513e;
            }
            this.f6411Y = new t(this, C0513e.g);
        }
        return this.f6411Y;
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
