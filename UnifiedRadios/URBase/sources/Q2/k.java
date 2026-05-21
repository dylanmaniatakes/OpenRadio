package q2;

import X2.t;
import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Handler;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import com.google.android.material.snackbar.SnackbarContentLayout;
import com.unified.ur1.R;

/* loaded from: classes.dex */
public final class k extends i {

    /* renamed from: E, reason: collision with root package name */
    public static final int[] f9475E = {R.attr.snackbarButtonStyle, R.attr.snackbarTextViewStyle};

    /* renamed from: C, reason: collision with root package name */
    public final AccessibilityManager f9476C;

    /* renamed from: D, reason: collision with root package name */
    public boolean f9477D;

    public k(Context context, ViewGroup viewGroup, SnackbarContentLayout snackbarContentLayout, SnackbarContentLayout snackbarContentLayout2) {
        super(context, viewGroup, snackbarContentLayout, snackbarContentLayout2);
        this.f9476C = (AccessibilityManager) viewGroup.getContext().getSystemService("accessibility");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x002c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x002a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[LOOP:0: B:3:0x0002->B:37:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static q2.k g(android.content.Context r6, android.view.View r7, java.lang.String r8, int r9) {
        /*
            r0 = 0
            r1 = r0
        L2:
            boolean r2 = r7 instanceof androidx.coordinatorlayout.widget.CoordinatorLayout
            if (r2 == 0) goto L9
            android.view.ViewGroup r7 = (android.view.ViewGroup) r7
            goto L2d
        L9:
            boolean r2 = r7 instanceof android.widget.FrameLayout
            if (r2 == 0) goto L1c
            int r1 = r7.getId()
            r2 = 16908290(0x1020002, float:2.3877235E-38)
            if (r1 != r2) goto L19
            android.view.ViewGroup r7 = (android.view.ViewGroup) r7
            goto L2d
        L19:
            r1 = r7
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
        L1c:
            if (r7 == 0) goto L2a
            android.view.ViewParent r7 = r7.getParent()
            boolean r2 = r7 instanceof android.view.View
            if (r2 == 0) goto L29
            android.view.View r7 = (android.view.View) r7
            goto L2a
        L29:
            r7 = r0
        L2a:
            if (r7 != 0) goto L2
            r7 = r1
        L2d:
            if (r7 == 0) goto L75
            if (r6 != 0) goto L35
            android.content.Context r6 = r7.getContext()
        L35:
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r6)
            int[] r1 = q2.k.f9475E
            android.content.res.TypedArray r1 = r6.obtainStyledAttributes(r1)
            r2 = 0
            r3 = -1
            int r4 = r1.getResourceId(r2, r3)
            r5 = 1
            int r5 = r1.getResourceId(r5, r3)
            r1.recycle()
            if (r4 == r3) goto L55
            if (r5 == r3) goto L55
            r1 = 2131558557(0x7f0d009d, float:1.8742433E38)
            goto L58
        L55:
            r1 = 2131558463(0x7f0d003f, float:1.8742243E38)
        L58:
            android.view.View r0 = r0.inflate(r1, r7, r2)
            com.google.android.material.snackbar.SnackbarContentLayout r0 = (com.google.android.material.snackbar.SnackbarContentLayout) r0
            q2.k r1 = new q2.k
            r1.<init>(r6, r7, r0, r0)
            q2.h r6 = r1.f9462i
            android.view.View r6 = r6.getChildAt(r2)
            com.google.android.material.snackbar.SnackbarContentLayout r6 = (com.google.android.material.snackbar.SnackbarContentLayout) r6
            android.widget.TextView r6 = r6.getMessageView()
            r6.setText(r8)
            r1.f9464k = r9
            return r1
        L75:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r7 = "No suitable parent found from the given view. Please provide a valid view."
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: q2.k.g(android.content.Context, android.view.View, java.lang.String, int):q2.k");
    }

    public final void h(int i5) {
        this.f9462i.setBackgroundTintList(ColorStateList.valueOf(i5));
    }

    public final void i(int i5) {
        ((SnackbarContentLayout) this.f9462i.getChildAt(0)).getMessageView().setTextColor(i5);
    }

    public final void j() {
        t tVarD = t.d();
        int i5 = this.f9464k;
        int recommendedTimeoutMillis = -2;
        if (i5 != -2) {
            int i6 = Build.VERSION.SDK_INT;
            AccessibilityManager accessibilityManager = this.f9476C;
            if (i6 >= 29) {
                recommendedTimeoutMillis = accessibilityManager.getRecommendedTimeoutMillis(i5, (this.f9477D ? 4 : 0) | 3);
            } else {
                if (this.f9477D && accessibilityManager.isTouchExplorationEnabled()) {
                    i5 = -2;
                }
                recommendedTimeoutMillis = i5;
            }
        }
        e eVar = this.f9474v;
        synchronized (tVarD.f2833c) {
            try {
                if (tVarD.g(eVar)) {
                    l lVar = (l) tVarD.f2835e;
                    lVar.f9479b = recommendedTimeoutMillis;
                    ((Handler) tVarD.f2834d).removeCallbacksAndMessages(lVar);
                    tVarD.m((l) tVarD.f2835e);
                    return;
                }
                l lVar2 = (l) tVarD.f2836f;
                if (lVar2 == null || eVar == null || lVar2.f9478a.get() != eVar) {
                    tVarD.f2836f = new l(recommendedTimeoutMillis, eVar);
                } else {
                    ((l) tVarD.f2836f).f9479b = recommendedTimeoutMillis;
                }
                l lVar3 = (l) tVarD.f2835e;
                if (lVar3 == null || !tVarD.a(lVar3, 4)) {
                    tVarD.f2835e = null;
                    tVarD.n();
                }
            } finally {
            }
        }
    }
}
