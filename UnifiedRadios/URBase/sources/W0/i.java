package w0;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class i extends p {

    /* renamed from: H, reason: collision with root package name */
    public static final String[] f10065H = {"android:visibility:visibility", "android:visibility:parent"};

    /* renamed from: G, reason: collision with root package name */
    public final int f10066G;

    public i(int i5) {
        this();
        this.f10066G = i5;
    }

    public static void H(v vVar) {
        int visibility = vVar.f10114b.getVisibility();
        HashMap map = vVar.f10113a;
        map.put("android:visibility:visibility", Integer.valueOf(visibility));
        View view = vVar.f10114b;
        map.put("android:visibility:parent", view.getParent());
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        map.put("android:visibility:screenLocation", iArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static w0.C0925B J(w0.v r8, w0.v r9) {
        /*
            w0.B r0 = new w0.B
            r0.<init>()
            r1 = 0
            r0.f10039a = r1
            r0.f10040b = r1
            r2 = 0
            r3 = -1
            java.lang.String r4 = "android:visibility:parent"
            java.lang.String r5 = "android:visibility:visibility"
            if (r8 == 0) goto L2f
            java.util.HashMap r6 = r8.f10113a
            boolean r7 = r6.containsKey(r5)
            if (r7 == 0) goto L2f
            java.lang.Object r7 = r6.get(r5)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r0.f10041c = r7
            java.lang.Object r6 = r6.get(r4)
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            r0.f10043e = r6
            goto L33
        L2f:
            r0.f10041c = r3
            r0.f10043e = r2
        L33:
            if (r9 == 0) goto L52
            java.util.HashMap r6 = r9.f10113a
            boolean r7 = r6.containsKey(r5)
            if (r7 == 0) goto L52
            java.lang.Object r2 = r6.get(r5)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r0.f10042d = r2
            java.lang.Object r2 = r6.get(r4)
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            r0.f10044f = r2
            goto L56
        L52:
            r0.f10042d = r3
            r0.f10044f = r2
        L56:
            r2 = 1
            if (r8 == 0) goto L8a
            if (r9 == 0) goto L8a
            int r8 = r0.f10041c
            int r9 = r0.f10042d
            if (r8 != r9) goto L68
            android.view.ViewGroup r3 = r0.f10043e
            android.view.ViewGroup r4 = r0.f10044f
            if (r3 != r4) goto L68
            return r0
        L68:
            if (r8 == r9) goto L78
            if (r8 != 0) goto L71
            r0.f10040b = r1
            r0.f10039a = r2
            goto L9f
        L71:
            if (r9 != 0) goto L9f
            r0.f10040b = r2
            r0.f10039a = r2
            goto L9f
        L78:
            android.view.ViewGroup r8 = r0.f10044f
            if (r8 != 0) goto L81
            r0.f10040b = r1
            r0.f10039a = r2
            goto L9f
        L81:
            android.view.ViewGroup r8 = r0.f10043e
            if (r8 != 0) goto L9f
            r0.f10040b = r2
            r0.f10039a = r2
            goto L9f
        L8a:
            if (r8 != 0) goto L95
            int r8 = r0.f10042d
            if (r8 != 0) goto L95
            r0.f10040b = r2
            r0.f10039a = r2
            goto L9f
        L95:
            if (r9 != 0) goto L9f
            int r8 = r0.f10041c
            if (r8 != 0) goto L9f
            r0.f10040b = r1
            r0.f10039a = r2
        L9f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: w0.i.J(w0.v, w0.v):w0.B");
    }

    public final ObjectAnimator I(View view, float f5, float f6) {
        int i5 = 0;
        if (f5 == f6) {
            return null;
        }
        w.f10116a.E(view, f5);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, w.f10117b, f6);
        objectAnimatorOfFloat.addListener(new h(view));
        a(new g(i5, view));
        return objectAnimatorOfFloat;
    }

    @Override // w0.p
    public final void d(v vVar) {
        H(vVar);
    }

    @Override // w0.p
    public final void g(v vVar) {
        H(vVar);
        vVar.f10113a.put("android:fade:transitionAlpha", Float.valueOf(w.f10116a.o(vVar.f10114b)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0048, code lost:
    
        if (J(n(r3, false), q(r3, false)).f10039a != false) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x020d  */
    @Override // w0.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.animation.Animator k(android.view.ViewGroup r22, w0.v r23, w0.v r24) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException, java.lang.SecurityException, java.lang.IllegalArgumentException {
        /*
            Method dump skipped, instructions count: 712
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w0.i.k(android.view.ViewGroup, w0.v, w0.v):android.animation.Animator");
    }

    @Override // w0.p
    public final String[] p() {
        return f10065H;
    }

    @Override // w0.p
    public final boolean r(v vVar, v vVar2) {
        if (vVar == null && vVar2 == null) {
            return false;
        }
        if (vVar != null && vVar2 != null && vVar2.f10113a.containsKey("android:visibility:visibility") != vVar.f10113a.containsKey("android:visibility:visibility")) {
            return false;
        }
        C0925B c0925bJ = J(vVar, vVar2);
        if (c0925bJ.f10039a) {
            return c0925bJ.f10041c == 0 || c0925bJ.f10042d == 0;
        }
        return false;
    }

    public i() {
        this.f10066G = 3;
    }
}
