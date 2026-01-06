package q2;

import O.G;
import O.J;
import O.M;
import O.Y;
import X2.t;
import a0.C0204a;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.LinearInterpolator;
import com.google.android.gms.internal.measurement.AbstractC0296a2;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.snackbar.SnackbarContentLayout;
import com.unified.ur1.R;
import g2.m;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public final int f9456a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9457b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9458c;

    /* renamed from: d, reason: collision with root package name */
    public final TimeInterpolator f9459d;

    /* renamed from: e, reason: collision with root package name */
    public final TimeInterpolator f9460e;

    /* renamed from: f, reason: collision with root package name */
    public final TimeInterpolator f9461f;
    public final ViewGroup g;
    public final Context h;

    /* renamed from: i, reason: collision with root package name */
    public final h f9462i;

    /* renamed from: j, reason: collision with root package name */
    public final j f9463j;

    /* renamed from: k, reason: collision with root package name */
    public int f9464k;

    /* renamed from: l, reason: collision with root package name */
    public f f9465l;
    public int n;

    /* renamed from: o, reason: collision with root package name */
    public int f9467o;

    /* renamed from: p, reason: collision with root package name */
    public int f9468p;

    /* renamed from: q, reason: collision with root package name */
    public int f9469q;

    /* renamed from: r, reason: collision with root package name */
    public int f9470r;

    /* renamed from: s, reason: collision with root package name */
    public int f9471s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f9472t;

    /* renamed from: u, reason: collision with root package name */
    public final AccessibilityManager f9473u;

    /* renamed from: w, reason: collision with root package name */
    public static final C0204a f9452w = P1.a.f2065b;

    /* renamed from: x, reason: collision with root package name */
    public static final LinearInterpolator f9453x = P1.a.f2064a;

    /* renamed from: y, reason: collision with root package name */
    public static final C0204a f9454y = P1.a.f2067d;

    /* renamed from: A, reason: collision with root package name */
    public static final int[] f9450A = {R.attr.snackbarStyle};

    /* renamed from: B, reason: collision with root package name */
    public static final String f9451B = i.class.getSimpleName();

    /* renamed from: z, reason: collision with root package name */
    public static final Handler f9455z = new Handler(Looper.getMainLooper(), new c());

    /* renamed from: m, reason: collision with root package name */
    public final d f9466m = new d(this, 0);

    /* renamed from: v, reason: collision with root package name */
    public final e f9474v = new e(this);

    public i(Context context, ViewGroup viewGroup, SnackbarContentLayout snackbarContentLayout, SnackbarContentLayout snackbarContentLayout2) {
        if (snackbarContentLayout == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        }
        if (snackbarContentLayout2 == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
        }
        this.g = viewGroup;
        this.f9463j = snackbarContentLayout2;
        this.h = context;
        m.c(context, m.f6946a, "Theme.AppCompat");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(f9450A);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        h hVar = (h) layoutInflaterFrom.inflate(resourceId != -1 ? R.layout.mtrl_layout_snackbar : R.layout.design_layout_snackbar, viewGroup, false);
        this.f9462i = hVar;
        hVar.setBaseTransientBottomBar(this);
        float actionTextColorAlpha = hVar.getActionTextColorAlpha();
        if (actionTextColorAlpha != 1.0f) {
            snackbarContentLayout.f5409d.setTextColor(AbstractC0296a2.h(actionTextColorAlpha, AbstractC0296a2.f(snackbarContentLayout, R.attr.colorSurface), snackbarContentLayout.f5409d.getCurrentTextColor()));
        }
        snackbarContentLayout.setMaxInlineActionWidth(hVar.getMaxInlineActionWidth());
        hVar.addView(snackbarContentLayout);
        WeakHashMap weakHashMap = Y.f1904a;
        J.f(hVar, 1);
        G.s(hVar, 1);
        hVar.setFitsSystemWindows(true);
        M.u(hVar, new Z2.c(26, this));
        Y.k(hVar, new W1.e(4, this));
        this.f9473u = (AccessibilityManager) context.getSystemService("accessibility");
        this.f9458c = A2.b.v(context, R.attr.motionDurationLong2, 250);
        this.f9456a = A2.b.v(context, R.attr.motionDurationLong2, 150);
        this.f9457b = A2.b.v(context, R.attr.motionDurationMedium1, 75);
        this.f9459d = A2.b.w(context, R.attr.motionEasingEmphasizedInterpolator, f9453x);
        this.f9461f = A2.b.w(context, R.attr.motionEasingEmphasizedInterpolator, f9454y);
        this.f9460e = A2.b.w(context, R.attr.motionEasingEmphasizedInterpolator, f9452w);
    }

    public final void a(int i5) {
        t tVarD = t.d();
        e eVar = this.f9474v;
        synchronized (tVarD.f2833c) {
            try {
                if (tVarD.g(eVar)) {
                    tVarD.a((l) tVarD.f2835e, i5);
                } else {
                    l lVar = (l) tVarD.f2836f;
                    if (lVar != null && eVar != null && lVar.f9478a.get() == eVar) {
                        tVarD.a((l) tVarD.f2836f, i5);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final View b() {
        f fVar = this.f9465l;
        if (fVar == null) {
            return null;
        }
        return (View) fVar.f9440d.get();
    }

    public final void c() {
        t tVarD = t.d();
        e eVar = this.f9474v;
        synchronized (tVarD.f2833c) {
            try {
                if (tVarD.g(eVar)) {
                    tVarD.f2835e = null;
                    if (((l) tVarD.f2836f) != null) {
                        tVarD.n();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        ViewParent parent = this.f9462i.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f9462i);
        }
    }

    public final void d() {
        t tVarD = t.d();
        e eVar = this.f9474v;
        synchronized (tVarD.f2833c) {
            try {
                if (tVarD.g(eVar)) {
                    tVarD.m((l) tVarD.f2835e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void e() {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        boolean z4 = true;
        AccessibilityManager accessibilityManager = this.f9473u;
        if (accessibilityManager != null && ((enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(1)) == null || !enabledAccessibilityServiceList.isEmpty())) {
            z4 = false;
        }
        h hVar = this.f9462i;
        if (z4) {
            hVar.post(new d(this, 2));
            return;
        }
        if (hVar.getParent() != null) {
            hVar.setVisibility(0);
        }
        d();
    }

    public final void f() {
        h hVar = this.f9462i;
        ViewGroup.LayoutParams layoutParams = hVar.getLayoutParams();
        boolean z4 = layoutParams instanceof ViewGroup.MarginLayoutParams;
        String str = f9451B;
        if (!z4) {
            Log.w(str, "Unable to update margins because layout params are not MarginLayoutParams");
            return;
        }
        if (hVar.f9448l == null) {
            Log.w(str, "Unable to update margins because original view margins are not set");
            return;
        }
        if (hVar.getParent() == null) {
            return;
        }
        int i5 = b() != null ? this.f9469q : this.n;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        Rect rect = hVar.f9448l;
        int i6 = rect.bottom + i5;
        int i7 = rect.left + this.f9467o;
        int i8 = rect.right + this.f9468p;
        int i9 = rect.top;
        boolean z5 = (marginLayoutParams.bottomMargin == i6 && marginLayoutParams.leftMargin == i7 && marginLayoutParams.rightMargin == i8 && marginLayoutParams.topMargin == i9) ? false : true;
        if (z5) {
            marginLayoutParams.bottomMargin = i6;
            marginLayoutParams.leftMargin = i7;
            marginLayoutParams.rightMargin = i8;
            marginLayoutParams.topMargin = i9;
            hVar.requestLayout();
        }
        if ((z5 || this.f9471s != this.f9470r) && Build.VERSION.SDK_INT >= 29 && this.f9470r > 0) {
            ViewGroup.LayoutParams layoutParams2 = hVar.getLayoutParams();
            if ((layoutParams2 instanceof z.e) && (((z.e) layoutParams2).f10529a instanceof SwipeDismissBehavior)) {
                d dVar = this.f9466m;
                hVar.removeCallbacks(dVar);
                hVar.post(dVar);
            }
        }
    }
}
