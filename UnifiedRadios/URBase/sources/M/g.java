package M;

import android.net.Uri;
import androidx.appcompat.widget.ActionMenuView;
import com.google.android.gms.internal.measurement.J1;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import f.C0458D;
import g2.n;
import j.m;
import j.y;
import k.C0627e;
import k.C0637j;

/* loaded from: classes.dex */
public final class g implements n, y {

    /* renamed from: c, reason: collision with root package name */
    public boolean f1656c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f1657d;

    public g(Uri uri, boolean z4, boolean z5) {
        this.f1657d = uri;
        this.f1656c = z4;
    }

    @Override // j.y
    public void a(m mVar, boolean z4) {
        C0637j c0637j;
        if (this.f1656c) {
            return;
        }
        this.f1656c = true;
        C0458D c0458d = (C0458D) this.f1657d;
        ActionMenuView actionMenuView = c0458d.f6246a.f7769a.f3461c;
        if (actionMenuView != null && (c0637j = actionMenuView.f3368v) != null) {
            c0637j.c();
            C0627e c0627e = c0637j.f7806w;
            if (c0627e != null && c0627e.b()) {
                c0627e.f7523j.dismiss();
            }
        }
        c0458d.f6247b.onPanelClosed(108, mVar);
        this.f1656c = false;
    }

    public boolean b() {
        return this.f1656c;
    }

    public boolean c(CharSequence charSequence, int i5) {
        if (charSequence == null || i5 < 0 || charSequence.length() - i5 < 0) {
            throw new IllegalArgumentException();
        }
        f fVar = (f) this.f1657d;
        if (fVar == null) {
            return b();
        }
        int iA = fVar.a(charSequence, i5);
        if (iA == 0) {
            return true;
        }
        if (iA != 1) {
            return b();
        }
        return false;
    }

    public J1 d(long j5, String str) {
        Long lValueOf = Long.valueOf(j5);
        Object obj = J1.g;
        return new J1(this, str, lValueOf, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x007b  */
    @Override // g2.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public O.F0 e(android.view.View r11, O.F0 r12, g2.o r13) {
        /*
            r10 = this;
            O.D0 r0 = r12.f1894a
            r1 = 7
            E.c r1 = r0.f(r1)
            r2 = 32
            E.c r0 = r0.f(r2)
            int r2 = r1.f420b
            java.lang.Object r3 = r10.f1657d
            com.google.android.material.bottomsheet.BottomSheetBehavior r3 = (com.google.android.material.bottomsheet.BottomSheetBehavior) r3
            r3.f5229w = r2
            boolean r2 = g2.m.h(r11)
            int r4 = r11.getPaddingBottom()
            int r5 = r11.getPaddingLeft()
            int r6 = r11.getPaddingRight()
            boolean r7 = r3.f5221o
            if (r7 == 0) goto L32
            int r4 = r12.a()
            r3.f5228v = r4
            int r7 = r13.f6953d
            int r4 = r4 + r7
        L32:
            boolean r7 = r3.f5222p
            int r8 = r1.f419a
            if (r7 == 0) goto L40
            if (r2 == 0) goto L3d
            int r5 = r13.f6952c
            goto L3f
        L3d:
            int r5 = r13.f6950a
        L3f:
            int r5 = r5 + r8
        L40:
            boolean r7 = r3.f5223q
            int r9 = r1.f421c
            if (r7 == 0) goto L4f
            if (r2 == 0) goto L4b
            int r13 = r13.f6950a
            goto L4d
        L4b:
            int r13 = r13.f6952c
        L4d:
            int r6 = r13 + r9
        L4f:
            android.view.ViewGroup$LayoutParams r13 = r11.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r13 = (android.view.ViewGroup.MarginLayoutParams) r13
            boolean r2 = r3.f5225s
            r7 = 1
            if (r2 == 0) goto L62
            int r2 = r13.leftMargin
            if (r2 == r8) goto L62
            r13.leftMargin = r8
            r2 = r7
            goto L63
        L62:
            r2 = 0
        L63:
            boolean r8 = r3.f5226t
            if (r8 == 0) goto L6e
            int r8 = r13.rightMargin
            if (r8 == r9) goto L6e
            r13.rightMargin = r9
            r2 = r7
        L6e:
            boolean r8 = r3.f5227u
            if (r8 == 0) goto L7b
            int r8 = r13.topMargin
            int r1 = r1.f420b
            if (r8 == r1) goto L7b
            r13.topMargin = r1
            goto L7c
        L7b:
            r7 = r2
        L7c:
            if (r7 == 0) goto L81
            r11.setLayoutParams(r13)
        L81:
            int r13 = r11.getPaddingTop()
            r11.setPadding(r5, r13, r6, r4)
            boolean r11 = r10.f1656c
            if (r11 == 0) goto L90
            int r13 = r0.f422d
            r3.f5220m = r13
        L90:
            boolean r13 = r3.f5221o
            if (r13 != 0) goto L96
            if (r11 == 0) goto L99
        L96:
            r3.I()
        L99:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: M.g.e(android.view.View, O.F0, g2.o):O.F0");
    }

    public J1 f(String str, String str2) {
        Object obj = J1.g;
        return new J1(this, str, str2, 3);
    }

    public J1 g(String str, boolean z4) {
        Boolean boolValueOf = Boolean.valueOf(z4);
        Object obj = J1.g;
        return new J1(this, str, boolValueOf, 1);
    }

    @Override // j.y
    public boolean i(m mVar) {
        ((C0458D) this.f1657d).f6247b.onMenuOpened(108, mVar);
        return true;
    }

    public /* synthetic */ g(Object obj) {
        this.f1657d = obj;
    }

    public g(f fVar, boolean z4) {
        this(fVar);
        this.f1656c = z4;
    }

    public g(BottomSheetBehavior bottomSheetBehavior, boolean z4) {
        this.f1657d = bottomSheetBehavior;
        this.f1656c = z4;
    }
}
