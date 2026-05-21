package androidx.databinding;

import C0.A;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Choreographer;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.C;
import androidx.lifecycle.C0251v;
import androidx.lifecycle.EnumC0243m;
import androidx.lifecycle.EnumC0244n;
import androidx.lifecycle.InterfaceC0248s;
import androidx.lifecycle.InterfaceC0249t;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public abstract class e extends e4.a {

    /* renamed from: l, reason: collision with root package name */
    public static final boolean f3583l = true;

    /* renamed from: m, reason: collision with root package name */
    public static final ReferenceQueue f3584m = new ReferenceQueue();
    public static final c n = new c(0);

    /* renamed from: b, reason: collision with root package name */
    public final A f3585b = new A(14, this);

    /* renamed from: c, reason: collision with root package name */
    public boolean f3586c = false;

    /* renamed from: d, reason: collision with root package name */
    public final f[] f3587d = new f[0];

    /* renamed from: e, reason: collision with root package name */
    public final View f3588e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f3589f;
    public final Choreographer g;
    public final d h;

    /* renamed from: i, reason: collision with root package name */
    public final Handler f3590i;

    /* renamed from: j, reason: collision with root package name */
    public InterfaceC0249t f3591j;

    /* renamed from: k, reason: collision with root package name */
    public ViewDataBinding$OnStartListener f3592k;

    public e(View view) {
        this.f3588e = view;
        if (Looper.myLooper() == null) {
            throw new IllegalStateException("DataBinding must be created in view's UI Thread");
        }
        if (f3583l) {
            this.g = Choreographer.getInstance();
            this.h = new d(this);
        } else {
            this.h = null;
            this.f3590i = new Handler(Looper.myLooper());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void y(android.view.View r5, java.lang.Object[] r6, android.util.SparseIntArray r7, boolean r8) {
        /*
            r0 = 0
            if (r5 == 0) goto Ld
            r1 = 2131362160(0x7f0a0170, float:1.8344093E38)
            java.lang.Object r1 = r5.getTag(r1)
            androidx.databinding.e r1 = (androidx.databinding.e) r1
            goto Le
        Ld:
            r1 = r0
        Le:
            if (r1 == 0) goto L11
            return
        L11:
            java.lang.Object r1 = r5.getTag()
            boolean r2 = r1 instanceof java.lang.String
            if (r2 == 0) goto L1c
            r0 = r1
            java.lang.String r0 = (java.lang.String) r0
        L1c:
            r1 = 0
            if (r8 == 0) goto L65
            if (r0 == 0) goto L65
            java.lang.String r8 = "layout"
            boolean r8 = r0.startsWith(r8)
            if (r8 == 0) goto L65
            r8 = 95
            int r8 = r0.lastIndexOf(r8)
            if (r8 <= 0) goto L8b
            int r8 = r8 + 1
            int r2 = r0.length()
            if (r2 != r8) goto L3a
            goto L8b
        L3a:
            r3 = r8
        L3b:
            if (r3 >= r2) goto L4b
            char r4 = r0.charAt(r3)
            boolean r4 = java.lang.Character.isDigit(r4)
            if (r4 != 0) goto L48
            goto L8b
        L48:
            int r3 = r3 + 1
            goto L3b
        L4b:
            int r2 = r0.length()
            r3 = r1
        L50:
            if (r8 >= r2) goto L5e
            int r3 = r3 * 10
            char r4 = r0.charAt(r8)
            int r4 = r4 + (-48)
            int r3 = r3 + r4
            int r8 = r8 + 1
            goto L50
        L5e:
            r8 = r6[r3]
            if (r8 != 0) goto La0
            r6[r3] = r5
            goto La0
        L65:
            if (r0 == 0) goto L8b
            java.lang.String r8 = "binding_"
            boolean r8 = r0.startsWith(r8)
            if (r8 == 0) goto L8b
            int r8 = r0.length()
            r2 = 8
            r3 = r1
        L76:
            if (r2 >= r8) goto L84
            int r3 = r3 * 10
            char r4 = r0.charAt(r2)
            int r4 = r4 + (-48)
            int r3 = r3 + r4
            int r2 = r2 + 1
            goto L76
        L84:
            r8 = r6[r3]
            if (r8 != 0) goto La0
            r6[r3] = r5
            goto La0
        L8b:
            int r8 = r5.getId()
            if (r8 <= 0) goto La0
            if (r7 == 0) goto La0
            r0 = -1
            int r8 = r7.get(r8, r0)
            if (r8 < 0) goto La0
            r0 = r6[r8]
            if (r0 != 0) goto La0
            r6[r8] = r5
        La0:
            boolean r8 = r5 instanceof android.view.ViewGroup
            if (r8 == 0) goto Lb7
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            int r8 = r5.getChildCount()
            r0 = r1
        Lab:
            if (r0 >= r8) goto Lb7
            android.view.View r2 = r5.getChildAt(r0)
            y(r2, r6, r7, r1)
            int r0 = r0 + 1
            goto Lab
        Lb7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.databinding.e.y(android.view.View, java.lang.Object[], android.util.SparseIntArray, boolean):void");
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [androidx.databinding.ViewDataBinding$OnStartListener] */
    public final void A(InterfaceC0249t interfaceC0249t) {
        if (interfaceC0249t instanceof Fragment) {
            Log.w("DataBinding", "Setting the fragment as the LifecycleOwner might cause memory leaks because views lives shorter than the Fragment. Consider using Fragment's view lifecycle");
        }
        InterfaceC0249t interfaceC0249t2 = this.f3591j;
        if (interfaceC0249t2 == interfaceC0249t) {
            return;
        }
        if (interfaceC0249t2 != null) {
            interfaceC0249t2.getLifecycle().b(this.f3592k);
        }
        this.f3591j = interfaceC0249t;
        if (interfaceC0249t != null) {
            if (this.f3592k == null) {
                this.f3592k = new InterfaceC0248s(this) { // from class: androidx.databinding.ViewDataBinding$OnStartListener

                    /* renamed from: j, reason: collision with root package name */
                    public final WeakReference f3579j;

                    {
                        this.f3579j = new WeakReference(this);
                    }

                    @C(EnumC0243m.ON_START)
                    public void onStart() {
                        e eVar = (e) this.f3579j.get();
                        if (eVar != null) {
                            if (eVar.f3589f) {
                                eVar.z();
                            } else if (eVar.x()) {
                                eVar.f3589f = true;
                                eVar.w();
                                eVar.f3589f = false;
                            }
                        }
                    }
                };
            }
            interfaceC0249t.getLifecycle().a(this.f3592k);
        }
        for (f fVar : this.f3587d) {
        }
    }

    public abstract void w();

    public abstract boolean x();

    public final void z() {
        InterfaceC0249t interfaceC0249t = this.f3591j;
        if (interfaceC0249t == null || ((C0251v) interfaceC0249t.getLifecycle()).f3971c.compareTo(EnumC0244n.f3964m) >= 0) {
            synchronized (this) {
                try {
                    if (this.f3586c) {
                        return;
                    }
                    this.f3586c = true;
                    if (f3583l) {
                        this.g.postFrameCallback(this.h);
                    } else {
                        this.f3590i.post(this.f3585b);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
