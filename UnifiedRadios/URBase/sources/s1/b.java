package S1;

import B0.l;
import O.H;
import O.Y;
import X2.t;
import android.view.View;
import android.view.ViewParent;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.material.behavior.SwipeDismissBehavior;
import java.util.WeakHashMap;
import q2.i;

/* loaded from: classes.dex */
public final class b extends A2.b {

    /* renamed from: a, reason: collision with root package name */
    public int f2355a;

    /* renamed from: b, reason: collision with root package name */
    public int f2356b = -1;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SwipeDismissBehavior f2357c;

    public b(SwipeDismissBehavior swipeDismissBehavior) {
        this.f2357c = swipeDismissBehavior;
    }

    @Override // A2.b
    public final int d(View view, int i5) {
        int width;
        int width2;
        int width3;
        WeakHashMap weakHashMap = Y.f1904a;
        boolean z4 = H.d(view) == 1;
        int i6 = this.f2357c.f5178e;
        if (i6 == 0) {
            if (z4) {
                width = this.f2355a - view.getWidth();
                width2 = this.f2355a;
            } else {
                width = this.f2355a;
                width3 = view.getWidth();
                width2 = width3 + width;
            }
        } else if (i6 != 1) {
            width = this.f2355a - view.getWidth();
            width2 = view.getWidth() + this.f2355a;
        } else if (z4) {
            width = this.f2355a;
            width3 = view.getWidth();
            width2 = width3 + width;
        } else {
            width = this.f2355a - view.getWidth();
            width2 = this.f2355a;
        }
        return Math.min(Math.max(width, i5), width2);
    }

    @Override // A2.b
    public final int e(View view, int i5) {
        return view.getTop();
    }

    @Override // A2.b
    public final int m(View view) {
        return view.getWidth();
    }

    @Override // A2.b
    public final void q(View view, int i5) {
        this.f2356b = i5;
        this.f2355a = view.getLeft();
        ViewParent parent = view.getParent();
        if (parent != null) {
            SwipeDismissBehavior swipeDismissBehavior = this.f2357c;
            swipeDismissBehavior.f5177d = true;
            parent.requestDisallowInterceptTouchEvent(true);
            swipeDismissBehavior.f5177d = false;
        }
    }

    @Override // A2.b
    public final void r(int i5) {
        l lVar = this.f2357c.f5175b;
        if (lVar != null) {
            i iVar = (i) lVar.f110d;
            if (i5 == 0) {
                t.d().l(iVar.f9474v);
            } else if (i5 == 1 || i5 == 2) {
                t.d().k(iVar.f9474v);
            }
        }
    }

    @Override // A2.b
    public final void s(View view, int i5, int i6) {
        float width = view.getWidth();
        SwipeDismissBehavior swipeDismissBehavior = this.f2357c;
        float f5 = width * swipeDismissBehavior.g;
        float width2 = view.getWidth() * swipeDismissBehavior.h;
        float fAbs = Math.abs(i5 - this.f2355a);
        if (fAbs <= f5) {
            view.setAlpha(1.0f);
        } else if (fAbs >= width2) {
            view.setAlpha(BitmapDescriptorFactory.HUE_RED);
        } else {
            view.setAlpha(Math.min(Math.max(BitmapDescriptorFactory.HUE_RED, 1.0f - ((fAbs - f5) / (width2 - f5))), 1.0f));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0066  */
    @Override // A2.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t(android.view.View r9, float r10, float r11) {
        /*
            r8 = this;
            r11 = -1
            r8.f2356b = r11
            int r11 = r9.getWidth()
            r0 = 0
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            r2 = 1
            com.google.android.material.behavior.SwipeDismissBehavior r3 = r8.f2357c
            r4 = 0
            if (r1 == 0) goto L39
            java.util.WeakHashMap r5 = O.Y.f1904a
            int r5 = O.H.d(r9)
            if (r5 != r2) goto L1a
            r5 = r2
            goto L1b
        L1a:
            r5 = r4
        L1b:
            int r6 = r3.f5178e
            r7 = 2
            if (r6 != r7) goto L21
            goto L52
        L21:
            if (r6 != 0) goto L2d
            if (r5 == 0) goto L2a
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 >= 0) goto L66
            goto L52
        L2a:
            if (r1 <= 0) goto L66
            goto L52
        L2d:
            if (r6 != r2) goto L66
            if (r5 == 0) goto L34
            if (r1 <= 0) goto L66
            goto L52
        L34:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 >= 0) goto L66
            goto L52
        L39:
            int r1 = r9.getLeft()
            int r5 = r8.f2355a
            int r1 = r1 - r5
            int r5 = r9.getWidth()
            float r5 = (float) r5
            float r6 = r3.f5179f
            float r5 = r5 * r6
            int r5 = java.lang.Math.round(r5)
            int r1 = java.lang.Math.abs(r1)
            if (r1 < r5) goto L66
        L52:
            int r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r10 < 0) goto L61
            int r10 = r9.getLeft()
            int r0 = r8.f2355a
            if (r10 >= r0) goto L5f
            goto L61
        L5f:
            int r0 = r0 + r11
            goto L69
        L61:
            int r10 = r8.f2355a
            int r0 = r10 - r11
            goto L69
        L66:
            int r0 = r8.f2355a
            r2 = r4
        L69:
            W.e r10 = r3.f5174a
            int r11 = r9.getTop()
            boolean r10 = r10.o(r0, r11)
            if (r10 == 0) goto L80
            S1.c r10 = new S1.c
            r10.<init>(r3, r9, r2)
            java.util.WeakHashMap r11 = O.Y.f1904a
            O.G.m(r9, r10)
            goto L89
        L80:
            if (r2 == 0) goto L89
            B0.l r10 = r3.f5175b
            if (r10 == 0) goto L89
            r10.v(r9)
        L89:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: S1.b.t(android.view.View, float, float):void");
    }

    @Override // A2.b
    public final boolean y(View view, int i5) {
        int i6 = this.f2356b;
        return (i6 == -1 || i6 == i5) && this.f2357c.r(view);
    }
}
