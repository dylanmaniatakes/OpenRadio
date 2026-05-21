package androidx.fragment.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.unified.ur1.R;

/* renamed from: androidx.fragment.app.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class DialogInterfaceOnCancelListenerC0219n extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {

    /* renamed from: c, reason: collision with root package name */
    public Handler f3837c;

    /* renamed from: l, reason: collision with root package name */
    public boolean f3844l;
    public Dialog n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f3846o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f3847p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f3848q;

    /* renamed from: d, reason: collision with root package name */
    public final RunnableC0210e f3838d = new RunnableC0210e(3, this);

    /* renamed from: e, reason: collision with root package name */
    public final DialogInterfaceOnCancelListenerC0216k f3839e = new DialogInterfaceOnCancelListenerC0216k(this);

    /* renamed from: f, reason: collision with root package name */
    public final DialogInterfaceOnDismissListenerC0217l f3840f = new DialogInterfaceOnDismissListenerC0217l(this);
    public int g = 0;
    public int h = 0;

    /* renamed from: i, reason: collision with root package name */
    public boolean f3841i = true;

    /* renamed from: j, reason: collision with root package name */
    public boolean f3842j = true;

    /* renamed from: k, reason: collision with root package name */
    public int f3843k = -1;

    /* renamed from: m, reason: collision with root package name */
    public final C0222q f3845m = new C0222q(2, this);

    /* renamed from: r, reason: collision with root package name */
    public boolean f3849r = false;

    @Override // androidx.fragment.app.Fragment
    public final D createFragmentContainer() {
        return new C0218m(this, super.createFragmentContainer());
    }

    public final void g(boolean z4, boolean z5) {
        if (this.f3847p) {
            return;
        }
        this.f3847p = true;
        this.f3848q = false;
        Dialog dialog = this.n;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.n.dismiss();
            if (!z5) {
                if (Looper.myLooper() == this.f3837c.getLooper()) {
                    onDismiss(this.n);
                } else {
                    this.f3837c.post(this.f3838d);
                }
            }
        }
        this.f3846o = true;
        if (this.f3843k >= 0) {
            T parentFragmentManager = getParentFragmentManager();
            int i5 = this.f3843k;
            parentFragmentManager.getClass();
            if (i5 < 0) {
                throw new IllegalArgumentException(com.unified.ur1.SatelliteTracker.h.a(i5, "Bad id: "));
            }
            parentFragmentManager.q(new S(parentFragmentManager, i5), false);
            this.f3843k = -1;
            return;
        }
        T parentFragmentManager2 = getParentFragmentManager();
        parentFragmentManager2.getClass();
        C0206a c0206a = new C0206a(parentFragmentManager2);
        c0206a.i(this);
        if (z4) {
            c0206a.d(true);
        } else {
            c0206a.d(false);
        }
    }

    public Dialog h() {
        if (Log.isLoggable("FragmentManager", 3)) {
            Log.d("FragmentManager", "onCreateDialog called for DialogFragment " + this);
        }
        return new Dialog(requireContext(), this.h);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Context context) {
        super.onAttach(context);
        getViewLifecycleOwnerLiveData().d(this.f3845m);
        if (this.f3848q) {
            return;
        }
        this.f3847p = false;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3837c = new Handler();
        this.f3842j = this.mContainerId == 0;
        if (bundle != null) {
            this.g = bundle.getInt("android:style", 0);
            this.h = bundle.getInt("android:theme", 0);
            this.f3841i = bundle.getBoolean("android:cancelable", true);
            this.f3842j = bundle.getBoolean("android:showsDialog", this.f3842j);
            this.f3843k = bundle.getInt("android:backStackId", -1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        Dialog dialog = this.n;
        if (dialog != null) {
            this.f3846o = true;
            dialog.setOnDismissListener(null);
            this.n.dismiss();
            if (!this.f3847p) {
                onDismiss(this.n);
            }
            this.n = null;
            this.f3849r = false;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDetach() {
        super.onDetach();
        if (!this.f3848q && !this.f3847p) {
            this.f3847p = true;
        }
        androidx.lifecycle.A viewLifecycleOwnerLiveData = getViewLifecycleOwnerLiveData();
        C0222q c0222q = this.f3845m;
        viewLifecycleOwnerLiveData.getClass();
        androidx.lifecycle.A.a("removeObserver");
        androidx.lifecycle.z zVar = (androidx.lifecycle.z) viewLifecycleOwnerLiveData.f3896b.b(c0222q);
        if (zVar == null) {
            return;
        }
        zVar.c();
        zVar.b(false);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.f3846o) {
            return;
        }
        if (Log.isLoggable("FragmentManager", 3)) {
            Log.d("FragmentManager", "onDismiss called for DialogFragment " + this);
        }
        g(true, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0046 A[Catch: all -> 0x004e, TryCatch #0 {all -> 0x004e, blocks: (B:12:0x001a, B:14:0x0026, B:24:0x003e, B:26:0x0046, B:29:0x0050, B:20:0x0030, B:22:0x0036, B:23:0x003b, B:30:0x0068), top: B:48:0x001a }] */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.LayoutInflater onGetLayoutInflater(android.os.Bundle r8) {
        /*
            r7 = this;
            android.view.LayoutInflater r8 = super.onGetLayoutInflater(r8)
            boolean r0 = r7.f3842j
            r1 = 2
            java.lang.String r2 = "FragmentManager"
            if (r0 == 0) goto L9a
            boolean r3 = r7.f3844l
            if (r3 == 0) goto L11
            goto L9a
        L11:
            if (r0 != 0) goto L14
            goto L71
        L14:
            boolean r0 = r7.f3849r
            if (r0 != 0) goto L71
            r0 = 0
            r3 = 1
            r7.f3844l = r3     // Catch: java.lang.Throwable -> L4e
            android.app.Dialog r4 = r7.h()     // Catch: java.lang.Throwable -> L4e
            r7.n = r4     // Catch: java.lang.Throwable -> L4e
            boolean r5 = r7.f3842j     // Catch: java.lang.Throwable -> L4e
            if (r5 == 0) goto L68
            int r5 = r7.g     // Catch: java.lang.Throwable -> L4e
            if (r5 == r3) goto L3b
            if (r5 == r1) goto L3b
            r6 = 3
            if (r5 == r6) goto L30
            goto L3e
        L30:
            android.view.Window r5 = r4.getWindow()     // Catch: java.lang.Throwable -> L4e
            if (r5 == 0) goto L3b
            r6 = 24
            r5.addFlags(r6)     // Catch: java.lang.Throwable -> L4e
        L3b:
            r4.requestWindowFeature(r3)     // Catch: java.lang.Throwable -> L4e
        L3e:
            android.content.Context r4 = r7.getContext()     // Catch: java.lang.Throwable -> L4e
            boolean r5 = r4 instanceof android.app.Activity     // Catch: java.lang.Throwable -> L4e
            if (r5 == 0) goto L50
            android.app.Dialog r5 = r7.n     // Catch: java.lang.Throwable -> L4e
            android.app.Activity r4 = (android.app.Activity) r4     // Catch: java.lang.Throwable -> L4e
            r5.setOwnerActivity(r4)     // Catch: java.lang.Throwable -> L4e
            goto L50
        L4e:
            r8 = move-exception
            goto L6e
        L50:
            android.app.Dialog r4 = r7.n     // Catch: java.lang.Throwable -> L4e
            boolean r5 = r7.f3841i     // Catch: java.lang.Throwable -> L4e
            r4.setCancelable(r5)     // Catch: java.lang.Throwable -> L4e
            android.app.Dialog r4 = r7.n     // Catch: java.lang.Throwable -> L4e
            androidx.fragment.app.k r5 = r7.f3839e     // Catch: java.lang.Throwable -> L4e
            r4.setOnCancelListener(r5)     // Catch: java.lang.Throwable -> L4e
            android.app.Dialog r4 = r7.n     // Catch: java.lang.Throwable -> L4e
            androidx.fragment.app.l r5 = r7.f3840f     // Catch: java.lang.Throwable -> L4e
            r4.setOnDismissListener(r5)     // Catch: java.lang.Throwable -> L4e
            r7.f3849r = r3     // Catch: java.lang.Throwable -> L4e
            goto L6b
        L68:
            r3 = 0
            r7.n = r3     // Catch: java.lang.Throwable -> L4e
        L6b:
            r7.f3844l = r0
            goto L71
        L6e:
            r7.f3844l = r0
            throw r8
        L71:
            boolean r0 = android.util.Log.isLoggable(r2, r1)
            if (r0 == 0) goto L8d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "get layout inflater for DialogFragment "
            r0.<init>(r1)
            r0.append(r7)
            java.lang.String r1 = " from dialog context"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r2, r0)
        L8d:
            android.app.Dialog r0 = r7.n
            if (r0 == 0) goto L99
            android.content.Context r0 = r0.getContext()
            android.view.LayoutInflater r8 = r8.cloneInContext(r0)
        L99:
            return r8
        L9a:
            boolean r0 = android.util.Log.isLoggable(r2, r1)
            if (r0 == 0) goto Lbd
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "getting layout inflater for DialogFragment "
            r0.<init>(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            boolean r1 = r7.f3842j
            if (r1 != 0) goto Lb8
            java.lang.String r1 = "mShowsDialog = false: "
            g0.AbstractC0535a.v(r1, r0, r2)
            goto Lbd
        Lb8:
            java.lang.String r1 = "mCreatingDialog = true: "
            g0.AbstractC0535a.v(r1, r0, r2)
        Lbd:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.DialogInterfaceOnCancelListenerC0219n.onGetLayoutInflater(android.os.Bundle):android.view.LayoutInflater");
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Dialog dialog = this.n;
        if (dialog != null) {
            Bundle bundleOnSaveInstanceState = dialog.onSaveInstanceState();
            bundleOnSaveInstanceState.putBoolean("android:dialogShowing", false);
            bundle.putBundle("android:savedDialogState", bundleOnSaveInstanceState);
        }
        int i5 = this.g;
        if (i5 != 0) {
            bundle.putInt("android:style", i5);
        }
        int i6 = this.h;
        if (i6 != 0) {
            bundle.putInt("android:theme", i6);
        }
        boolean z4 = this.f3841i;
        if (!z4) {
            bundle.putBoolean("android:cancelable", z4);
        }
        boolean z5 = this.f3842j;
        if (!z5) {
            bundle.putBoolean("android:showsDialog", z5);
        }
        int i7 = this.f3843k;
        if (i7 != -1) {
            bundle.putInt("android:backStackId", i7);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = this.n;
        if (dialog != null) {
            this.f3846o = false;
            dialog.show();
            View decorView = this.n.getWindow().getDecorView();
            F3.i.f(decorView, "<this>");
            decorView.setTag(R.id.view_tree_lifecycle_owner, this);
            decorView.setTag(R.id.view_tree_view_model_store_owner, this);
            decorView.setTag(R.id.view_tree_saved_state_registry_owner, this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        Dialog dialog = this.n;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewStateRestored(Bundle bundle) {
        Bundle bundle2;
        super.onViewStateRestored(bundle);
        if (this.n == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.n.onRestoreInstanceState(bundle2);
    }

    @Override // androidx.fragment.app.Fragment
    public final void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.performCreateView(layoutInflater, viewGroup, bundle);
        if (this.mView != null || this.n == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.n.onRestoreInstanceState(bundle2);
    }
}
