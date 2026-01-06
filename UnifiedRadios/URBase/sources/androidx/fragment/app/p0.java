package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import g0.AbstractC0535a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import s.AbstractC0882e;

/* loaded from: classes.dex */
public final class p0 {

    /* renamed from: a, reason: collision with root package name */
    public int f3858a;

    /* renamed from: b, reason: collision with root package name */
    public int f3859b;

    /* renamed from: c, reason: collision with root package name */
    public final Fragment f3860c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f3861d;

    /* renamed from: e, reason: collision with root package name */
    public final HashSet f3862e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f3863f;
    public boolean g;
    public final b0 h;

    public p0(int i5, int i6, b0 b0Var, K.d dVar) {
        Fragment fragment = b0Var.f3773c;
        this.f3861d = new ArrayList();
        this.f3862e = new HashSet();
        this.f3863f = false;
        this.g = false;
        this.f3858a = i5;
        this.f3859b = i6;
        this.f3860c = fragment;
        dVar.b(new C0222q(4, this));
        this.h = b0Var;
    }

    public final void a() {
        if (this.f3863f) {
            return;
        }
        this.f3863f = true;
        HashSet hashSet = this.f3862e;
        if (hashSet.isEmpty()) {
            b();
            return;
        }
        Iterator it = new ArrayList(hashSet).iterator();
        while (it.hasNext()) {
            ((K.d) it.next()).a();
        }
    }

    public final void b() {
        if (!this.g) {
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.g = true;
            Iterator it = this.f3861d.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
        }
        this.h.k();
    }

    public final void c(int i5, int i6) {
        int iC = AbstractC0882e.c(i6);
        Fragment fragment = this.f3860c;
        if (iC == 0) {
            if (this.f3858a != 1) {
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + fragment + " mFinalState = " + AbstractC0535a.A(this.f3858a) + " -> " + AbstractC0535a.A(i5) + ". ");
                }
                this.f3858a = i5;
                return;
            }
            return;
        }
        if (iC == 1) {
            if (this.f3858a == 1) {
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + fragment + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + AbstractC0535a.z(this.f3859b) + " to ADDING.");
                }
                this.f3858a = 2;
                this.f3859b = 2;
                return;
            }
            return;
        }
        if (iC != 2) {
            return;
        }
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "SpecialEffectsController: For fragment " + fragment + " mFinalState = " + AbstractC0535a.A(this.f3858a) + " -> REMOVED. mLifecycleImpact  = " + AbstractC0535a.z(this.f3859b) + " to REMOVING.");
        }
        this.f3858a = 1;
        this.f3859b = 3;
    }

    public final void d() {
        if (this.f3859b == 2) {
            b0 b0Var = this.h;
            Fragment fragment = b0Var.f3773c;
            View viewFindFocus = fragment.mView.findFocus();
            if (viewFindFocus != null) {
                fragment.setFocusedView(viewFindFocus);
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + fragment);
                }
            }
            View viewRequireView = this.f3860c.requireView();
            if (viewRequireView.getParent() == null) {
                b0Var.b();
                viewRequireView.setAlpha(BitmapDescriptorFactory.HUE_RED);
            }
            if (viewRequireView.getAlpha() == BitmapDescriptorFactory.HUE_RED && viewRequireView.getVisibility() == 0) {
                viewRequireView.setVisibility(4);
            }
            viewRequireView.setAlpha(fragment.getPostOnViewCreatedAlpha());
        }
    }

    public final String toString() {
        return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {mFinalState = " + AbstractC0535a.A(this.f3858a) + "} {mLifecycleImpact = " + AbstractC0535a.z(this.f3859b) + "} {mFragment = " + this.f3860c + "}";
    }
}
