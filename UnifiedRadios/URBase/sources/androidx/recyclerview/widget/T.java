package androidx.recyclerview.widget;

import O.C0182v;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class T {

    /* renamed from: a, reason: collision with root package name */
    public L f4166a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f4167b;

    /* renamed from: c, reason: collision with root package name */
    public long f4168c;

    /* renamed from: d, reason: collision with root package name */
    public long f4169d;

    /* renamed from: e, reason: collision with root package name */
    public long f4170e;

    /* renamed from: f, reason: collision with root package name */
    public long f4171f;

    public static void b(n0 n0Var) {
        int i5 = n0Var.mFlags;
        if (!n0Var.isInvalid() && (i5 & 4) == 0) {
            n0Var.getOldPosition();
            n0Var.getAbsoluteAdapterPosition();
        }
    }

    public abstract boolean a(n0 n0Var, n0 n0Var2, C0182v c0182v, C0182v c0182v2);

    public void c(n0 n0Var) {
        d(n0Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(androidx.recyclerview.widget.n0 r10) {
        /*
            r9 = this;
            androidx.recyclerview.widget.L r0 = r9.f4166a
            if (r0 == 0) goto Lb5
            r1 = 1
            r10.setIsRecyclable(r1)
            androidx.recyclerview.widget.n0 r2 = r10.mShadowedHolder
            r3 = 0
            if (r2 == 0) goto L13
            androidx.recyclerview.widget.n0 r2 = r10.mShadowingHolder
            if (r2 != 0) goto L13
            r10.mShadowedHolder = r3
        L13:
            r10.mShadowingHolder = r3
            boolean r2 = r10.shouldBeKeptAsChild()
            if (r2 != 0) goto Lb5
            android.view.View r2 = r10.itemView
            androidx.recyclerview.widget.RecyclerView r0 = r0.f4048a
            r0.k0()
            androidx.recyclerview.widget.e r3 = r0.h
            java.lang.Object r4 = r3.f4226d
            J1.U r4 = (J1.U) r4
            java.lang.Object r5 = r3.f4225c
            androidx.recyclerview.widget.L r5 = (androidx.recyclerview.widget.L) r5
            int r6 = r3.f4224b
            r7 = 0
            if (r6 != r1) goto L41
            java.lang.Object r1 = r3.f4228f
            android.view.View r1 = (android.view.View) r1
            if (r1 != r2) goto L39
        L37:
            r1 = r7
            goto L6a
        L39:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "Cannot call removeViewIfHidden within removeView(At) for a different view"
            r10.<init>(r0)
            throw r10
        L41:
            r8 = 2
            if (r6 == r8) goto Lad
            r3.f4224b = r8     // Catch: java.lang.Throwable -> L55
            androidx.recyclerview.widget.RecyclerView r6 = r5.f4048a     // Catch: java.lang.Throwable -> L55
            int r6 = r6.indexOfChild(r2)     // Catch: java.lang.Throwable -> L55
            r8 = -1
            if (r6 != r8) goto L57
            r3.u(r2)     // Catch: java.lang.Throwable -> L55
        L52:
            r3.f4224b = r7
            goto L6a
        L55:
            r10 = move-exception
            goto Laa
        L57:
            boolean r8 = r4.e(r6)     // Catch: java.lang.Throwable -> L55
            if (r8 == 0) goto L67
            r4.g(r6)     // Catch: java.lang.Throwable -> L55
            r3.u(r2)     // Catch: java.lang.Throwable -> L55
            r5.h(r6)     // Catch: java.lang.Throwable -> L55
            goto L52
        L67:
            r3.f4224b = r7
            goto L37
        L6a:
            if (r1 == 0) goto L97
            androidx.recyclerview.widget.n0 r3 = androidx.recyclerview.widget.RecyclerView.M(r2)
            androidx.recyclerview.widget.d0 r4 = r0.f4106e
            r4.l(r3)
            r4.i(r3)
            boolean r3 = androidx.recyclerview.widget.RecyclerView.f4067D0
            if (r3 == 0) goto L97
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "after removing animated view: "
            r3.<init>(r4)
            r3.append(r2)
            java.lang.String r2 = ", "
            r3.append(r2)
            r3.append(r0)
            java.lang.String r2 = r3.toString()
            java.lang.String r3 = "RecyclerView"
            android.util.Log.d(r3, r2)
        L97:
            r2 = r1 ^ 1
            r0.l0(r2)
            if (r1 != 0) goto Lb5
            boolean r1 = r10.isTmpDetached()
            if (r1 == 0) goto Lb5
            android.view.View r10 = r10.itemView
            r0.removeDetachedView(r10, r7)
            goto Lb5
        Laa:
            r3.f4224b = r7
            throw r10
        Lad:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "Cannot call removeViewIfHidden within removeViewIfHidden"
            r10.<init>(r0)
            throw r10
        Lb5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.T.d(androidx.recyclerview.widget.n0):void");
    }

    public abstract void e(n0 n0Var);

    public abstract void f();

    public abstract boolean g();
}
