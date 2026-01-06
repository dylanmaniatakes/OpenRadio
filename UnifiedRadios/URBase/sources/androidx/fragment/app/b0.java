package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.EnumC0244n;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.unified.ur1.R;
import g0.AbstractC0535a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class b0 {

    /* renamed from: a, reason: collision with root package name */
    public final A f3771a;

    /* renamed from: b, reason: collision with root package name */
    public final c0 f3772b;

    /* renamed from: c, reason: collision with root package name */
    public final Fragment f3773c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f3774d = false;

    /* renamed from: e, reason: collision with root package name */
    public int f3775e = -1;

    public b0(A a2, c0 c0Var, Fragment fragment) {
        this.f3771a = a2;
        this.f3772b = c0Var;
        this.f3773c = fragment;
    }

    public final void a() {
        boolean zIsLoggable = Log.isLoggable("FragmentManager", 3);
        Fragment fragment = this.f3773c;
        if (zIsLoggable) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + fragment);
        }
        fragment.performActivityCreated(fragment.mSavedFragmentState);
        this.f3771a.a(false);
    }

    public final void b() {
        View view;
        View view2;
        c0 c0Var = this.f3772b;
        c0Var.getClass();
        Fragment fragment = this.f3773c;
        ViewGroup viewGroup = fragment.mContainer;
        int iIndexOfChild = -1;
        if (viewGroup != null) {
            ArrayList arrayList = (ArrayList) c0Var.f3780a;
            int iIndexOf = arrayList.indexOf(fragment);
            int i5 = iIndexOf - 1;
            while (true) {
                if (i5 < 0) {
                    while (true) {
                        iIndexOf++;
                        if (iIndexOf >= arrayList.size()) {
                            break;
                        }
                        Fragment fragment2 = (Fragment) arrayList.get(iIndexOf);
                        if (fragment2.mContainer == viewGroup && (view = fragment2.mView) != null) {
                            iIndexOfChild = viewGroup.indexOfChild(view);
                            break;
                        }
                    }
                } else {
                    Fragment fragment3 = (Fragment) arrayList.get(i5);
                    if (fragment3.mContainer == viewGroup && (view2 = fragment3.mView) != null) {
                        iIndexOfChild = viewGroup.indexOfChild(view2) + 1;
                        break;
                    }
                    i5--;
                }
            }
        }
        fragment.mContainer.addView(fragment.mView, iIndexOfChild);
    }

    public final void c() {
        boolean zIsLoggable = Log.isLoggable("FragmentManager", 3);
        Fragment fragment = this.f3773c;
        if (zIsLoggable) {
            Log.d("FragmentManager", "moveto ATTACHED: " + fragment);
        }
        Fragment fragment2 = fragment.mTarget;
        b0 b0Var = null;
        c0 c0Var = this.f3772b;
        if (fragment2 != null) {
            b0 b0Var2 = (b0) ((HashMap) c0Var.f3781b).get(fragment2.mWho);
            if (b0Var2 == null) {
                throw new IllegalStateException("Fragment " + fragment + " declared target fragment " + fragment.mTarget + " that does not belong to this FragmentManager!");
            }
            fragment.mTargetWho = fragment.mTarget.mWho;
            fragment.mTarget = null;
            b0Var = b0Var2;
        } else {
            String str = fragment.mTargetWho;
            if (str != null && (b0Var = (b0) ((HashMap) c0Var.f3781b).get(str)) == null) {
                StringBuilder sb = new StringBuilder("Fragment ");
                sb.append(fragment);
                sb.append(" declared target fragment ");
                throw new IllegalStateException(com.unified.ur1.SatelliteTracker.h.e(sb, fragment.mTargetWho, " that does not belong to this FragmentManager!"));
            }
        }
        if (b0Var != null) {
            b0Var.k();
        }
        T t4 = fragment.mFragmentManager;
        fragment.mHost = t4.f3706o;
        fragment.mParentFragment = t4.f3708q;
        A a2 = this.f3771a;
        a2.g(false);
        fragment.performAttach();
        a2.b(false);
    }

    public final int d() {
        p0 p0Var;
        Fragment fragment = this.f3773c;
        if (fragment.mFragmentManager == null) {
            return fragment.mState;
        }
        int iMin = this.f3775e;
        int iOrdinal = fragment.mMaxState.ordinal();
        if (iOrdinal == 1) {
            iMin = Math.min(iMin, 0);
        } else if (iOrdinal == 2) {
            iMin = Math.min(iMin, 1);
        } else if (iOrdinal == 3) {
            iMin = Math.min(iMin, 5);
        } else if (iOrdinal != 4) {
            iMin = Math.min(iMin, -1);
        }
        if (fragment.mFromLayout) {
            if (fragment.mInLayout) {
                iMin = Math.max(this.f3775e, 2);
                View view = fragment.mView;
                if (view != null && view.getParent() == null) {
                    iMin = Math.min(iMin, 2);
                }
            } else {
                iMin = this.f3775e < 4 ? Math.min(iMin, fragment.mState) : Math.min(iMin, 1);
            }
        }
        if (!fragment.mAdded) {
            iMin = Math.min(iMin, 1);
        }
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            C0215j c0215jI = C0215j.i(viewGroup, fragment.getParentFragmentManager());
            c0215jI.getClass();
            p0 p0VarF = c0215jI.f(fragment);
            i = p0VarF != null ? p0VarF.f3859b : 0;
            Iterator it = c0215jI.f3822c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    p0Var = null;
                    break;
                }
                p0Var = (p0) it.next();
                if (p0Var.f3860c.equals(fragment) && !p0Var.f3863f) {
                    break;
                }
            }
            if (p0Var != null && (i == 0 || i == 1)) {
                i = p0Var.f3859b;
            }
        }
        if (i == 2) {
            iMin = Math.min(iMin, 6);
        } else if (i == 3) {
            iMin = Math.max(iMin, 3);
        } else if (fragment.mRemoving) {
            iMin = fragment.isInBackStack() ? Math.min(iMin, 1) : Math.min(iMin, -1);
        }
        if (fragment.mDeferStart && fragment.mState < 5) {
            iMin = Math.min(iMin, 4);
        }
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + iMin + " for " + fragment);
        }
        return iMin;
    }

    public final void e() {
        boolean zIsLoggable = Log.isLoggable("FragmentManager", 3);
        Fragment fragment = this.f3773c;
        if (zIsLoggable) {
            Log.d("FragmentManager", "moveto CREATED: " + fragment);
        }
        if (fragment.mIsCreated) {
            fragment.restoreChildFragmentState(fragment.mSavedFragmentState);
            fragment.mState = 1;
        } else {
            A a2 = this.f3771a;
            a2.h(false);
            fragment.performCreate(fragment.mSavedFragmentState);
            a2.c(false);
        }
    }

    public final void f() throws Resources.NotFoundException {
        String resourceName;
        Fragment fragment = this.f3773c;
        if (fragment.mFromLayout) {
            return;
        }
        if (Log.isLoggable("FragmentManager", 3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + fragment);
        }
        LayoutInflater layoutInflaterPerformGetLayoutInflater = fragment.performGetLayoutInflater(fragment.mSavedFragmentState);
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup == null) {
            int i5 = fragment.mContainerId;
            if (i5 == 0) {
                viewGroup = null;
            } else {
                if (i5 == -1) {
                    throw new IllegalArgumentException(AbstractC0535a.k("Cannot create fragment ", fragment, " for a container view with no id"));
                }
                viewGroup = (ViewGroup) fragment.mFragmentManager.f3707p.b(i5);
                if (viewGroup == null && !fragment.mRestored) {
                    try {
                        resourceName = fragment.getResources().getResourceName(fragment.mContainerId);
                    } catch (Resources.NotFoundException unused) {
                        resourceName = "unknown";
                    }
                    throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(fragment.mContainerId) + " (" + resourceName + ") for fragment " + fragment);
                }
            }
        }
        fragment.mContainer = viewGroup;
        fragment.performCreateView(layoutInflaterPerformGetLayoutInflater, viewGroup, fragment.mSavedFragmentState);
        View view = fragment.mView;
        if (view != null) {
            view.setSaveFromParentEnabled(false);
            fragment.mView.setTag(R.id.fragment_container_view_tag, fragment);
            if (viewGroup != null) {
                b();
            }
            if (fragment.mHidden) {
                fragment.mView.setVisibility(8);
            }
            View view2 = fragment.mView;
            WeakHashMap weakHashMap = O.Y.f1904a;
            if (O.J.b(view2)) {
                O.K.c(fragment.mView);
            } else {
                View view3 = fragment.mView;
                view3.addOnAttachStateChangeListener(new a0(view3));
            }
            fragment.performViewCreated();
            this.f3771a.m(fragment, fragment.mView, false);
            int visibility = fragment.mView.getVisibility();
            fragment.setPostOnViewCreatedAlpha(fragment.mView.getAlpha());
            if (fragment.mContainer != null && visibility == 0) {
                View viewFindFocus = fragment.mView.findFocus();
                if (viewFindFocus != null) {
                    fragment.setFocusedView(viewFindFocus);
                    if (Log.isLoggable("FragmentManager", 2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + fragment);
                    }
                }
                fragment.mView.setAlpha(BitmapDescriptorFactory.HUE_RED);
            }
        }
        fragment.mState = 2;
    }

    public final void g() {
        Fragment fragmentB;
        boolean zIsLoggable = Log.isLoggable("FragmentManager", 3);
        Fragment fragment = this.f3773c;
        if (zIsLoggable) {
            Log.d("FragmentManager", "movefrom CREATED: " + fragment);
        }
        boolean zIsChangingConfigurations = true;
        boolean z4 = fragment.mRemoving && !fragment.isInBackStack();
        c0 c0Var = this.f3772b;
        if (!z4) {
            W w4 = (W) c0Var.f3782c;
            if (!((w4.f3726d.containsKey(fragment.mWho) && w4.g) ? w4.h : true)) {
                String str = fragment.mTargetWho;
                if (str != null && (fragmentB = c0Var.b(str)) != null && fragmentB.mRetainInstance) {
                    fragment.mTarget = fragmentB;
                }
                fragment.mState = 0;
                return;
            }
        }
        F f5 = fragment.mHost;
        if (f5 instanceof androidx.lifecycle.X) {
            zIsChangingConfigurations = ((W) c0Var.f3782c).h;
        } else {
            Context context = f5.f3652d;
            if (context instanceof Activity) {
                zIsChangingConfigurations = true ^ ((Activity) context).isChangingConfigurations();
            }
        }
        if (z4 || zIsChangingConfigurations) {
            W w5 = (W) c0Var.f3782c;
            w5.getClass();
            if (Log.isLoggable("FragmentManager", 3)) {
                Log.d("FragmentManager", "Clearing non-config state for " + fragment);
            }
            HashMap map = w5.f3727e;
            W w6 = (W) map.get(fragment.mWho);
            if (w6 != null) {
                w6.b();
                map.remove(fragment.mWho);
            }
            HashMap map2 = w5.f3728f;
            androidx.lifecycle.W w7 = (androidx.lifecycle.W) map2.get(fragment.mWho);
            if (w7 != null) {
                w7.a();
                map2.remove(fragment.mWho);
            }
        }
        fragment.performDestroy();
        this.f3771a.d(false);
        Iterator it = c0Var.d().iterator();
        while (it.hasNext()) {
            b0 b0Var = (b0) it.next();
            if (b0Var != null) {
                String str2 = fragment.mWho;
                Fragment fragment2 = b0Var.f3773c;
                if (str2.equals(fragment2.mTargetWho)) {
                    fragment2.mTarget = fragment;
                    fragment2.mTargetWho = null;
                }
            }
        }
        String str3 = fragment.mTargetWho;
        if (str3 != null) {
            fragment.mTarget = c0Var.b(str3);
        }
        c0Var.h(this);
    }

    public final void h() {
        View view;
        boolean zIsLoggable = Log.isLoggable("FragmentManager", 3);
        Fragment fragment = this.f3773c;
        if (zIsLoggable) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + fragment);
        }
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null && (view = fragment.mView) != null) {
            viewGroup.removeView(view);
        }
        fragment.performDestroyView();
        this.f3771a.n(false);
        fragment.mContainer = null;
        fragment.mView = null;
        fragment.mViewLifecycleOwner = null;
        fragment.mViewLifecycleOwnerLiveData.e(null);
        fragment.mInLayout = false;
    }

    public final void i() {
        boolean zIsLoggable = Log.isLoggable("FragmentManager", 3);
        Fragment fragment = this.f3773c;
        if (zIsLoggable) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + fragment);
        }
        fragment.performDetach();
        this.f3771a.e(false);
        fragment.mState = -1;
        fragment.mHost = null;
        fragment.mParentFragment = null;
        fragment.mFragmentManager = null;
        if (!fragment.mRemoving || fragment.isInBackStack()) {
            W w4 = (W) this.f3772b.f3782c;
            boolean z4 = true;
            if (w4.f3726d.containsKey(fragment.mWho) && w4.g) {
                z4 = w4.h;
            }
            if (!z4) {
                return;
            }
        }
        if (Log.isLoggable("FragmentManager", 3)) {
            Log.d("FragmentManager", "initState called for fragment: " + fragment);
        }
        fragment.initState();
    }

    public final void j() {
        Fragment fragment = this.f3773c;
        if (fragment.mFromLayout && fragment.mInLayout && !fragment.mPerformedCreateView) {
            if (Log.isLoggable("FragmentManager", 3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + fragment);
            }
            fragment.performCreateView(fragment.performGetLayoutInflater(fragment.mSavedFragmentState), null, fragment.mSavedFragmentState);
            View view = fragment.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                fragment.mView.setTag(R.id.fragment_container_view_tag, fragment);
                if (fragment.mHidden) {
                    fragment.mView.setVisibility(8);
                }
                fragment.performViewCreated();
                this.f3771a.m(fragment, fragment.mView, false);
                fragment.mState = 2;
            }
        }
    }

    public final void k() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        boolean z4 = this.f3774d;
        Fragment fragment = this.f3773c;
        if (z4) {
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + fragment);
                return;
            }
            return;
        }
        try {
            this.f3774d = true;
            while (true) {
                int iD = d();
                int i5 = fragment.mState;
                if (iD == i5) {
                    if (fragment.mHiddenChanged) {
                        if (fragment.mView != null && (viewGroup = fragment.mContainer) != null) {
                            C0215j c0215jI = C0215j.i(viewGroup, fragment.getParentFragmentManager());
                            if (fragment.mHidden) {
                                c0215jI.getClass();
                                if (Log.isLoggable("FragmentManager", 2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + fragment);
                                }
                                c0215jI.b(3, 1, this);
                            } else {
                                c0215jI.getClass();
                                if (Log.isLoggable("FragmentManager", 2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + fragment);
                                }
                                c0215jI.b(2, 1, this);
                            }
                        }
                        T t4 = fragment.mFragmentManager;
                        if (t4 != null && fragment.mAdded && T.C(fragment)) {
                            t4.f3716y = true;
                        }
                        fragment.mHiddenChanged = false;
                        fragment.onHiddenChanged(fragment.mHidden);
                    }
                    this.f3774d = false;
                    return;
                }
                if (iD <= i5) {
                    switch (i5 - 1) {
                        case o1.f.SUCCESS_CACHE /* -1 */:
                            i();
                            break;
                        case 0:
                            g();
                            break;
                        case 1:
                            h();
                            fragment.mState = 1;
                            break;
                        case 2:
                            fragment.mInLayout = false;
                            fragment.mState = 2;
                            break;
                        case 3:
                            if (Log.isLoggable("FragmentManager", 3)) {
                                Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + fragment);
                            }
                            if (fragment.mView != null && fragment.mSavedViewState == null) {
                                p();
                            }
                            if (fragment.mView != null && (viewGroup3 = fragment.mContainer) != null) {
                                C0215j c0215jI2 = C0215j.i(viewGroup3, fragment.getParentFragmentManager());
                                c0215jI2.getClass();
                                if (Log.isLoggable("FragmentManager", 2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + fragment);
                                }
                                c0215jI2.b(1, 3, this);
                            }
                            fragment.mState = 3;
                            break;
                        case 4:
                            r();
                            break;
                        case 5:
                            fragment.mState = 5;
                            break;
                        case 6:
                            l();
                            break;
                    }
                } else {
                    switch (i5 + 1) {
                        case 0:
                            c();
                            break;
                        case 1:
                            e();
                            break;
                        case 2:
                            j();
                            f();
                            break;
                        case 3:
                            a();
                            break;
                        case 4:
                            if (fragment.mView != null && (viewGroup2 = fragment.mContainer) != null) {
                                C0215j c0215jI3 = C0215j.i(viewGroup2, fragment.getParentFragmentManager());
                                int iB = AbstractC0535a.b(fragment.mView.getVisibility());
                                c0215jI3.getClass();
                                if (Log.isLoggable("FragmentManager", 2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + fragment);
                                }
                                c0215jI3.b(iB, 2, this);
                            }
                            fragment.mState = 4;
                            break;
                        case 5:
                            q();
                            break;
                        case 6:
                            fragment.mState = 6;
                            break;
                        case 7:
                            n();
                            break;
                    }
                }
            }
        } catch (Throwable th) {
            this.f3774d = false;
            throw th;
        }
    }

    public final void l() {
        boolean zIsLoggable = Log.isLoggable("FragmentManager", 3);
        Fragment fragment = this.f3773c;
        if (zIsLoggable) {
            Log.d("FragmentManager", "movefrom RESUMED: " + fragment);
        }
        fragment.performPause();
        this.f3771a.f(false);
    }

    public final void m(ClassLoader classLoader) {
        Fragment fragment = this.f3773c;
        Bundle bundle = fragment.mSavedFragmentState;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
        fragment.mSavedViewRegistryState = fragment.mSavedFragmentState.getBundle("android:view_registry_state");
        fragment.mTargetWho = fragment.mSavedFragmentState.getString("android:target_state");
        if (fragment.mTargetWho != null) {
            fragment.mTargetRequestCode = fragment.mSavedFragmentState.getInt("android:target_req_state", 0);
        }
        Boolean bool = fragment.mSavedUserVisibleHint;
        if (bool != null) {
            fragment.mUserVisibleHint = bool.booleanValue();
            fragment.mSavedUserVisibleHint = null;
        } else {
            fragment.mUserVisibleHint = fragment.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
        }
        if (fragment.mUserVisibleHint) {
            return;
        }
        fragment.mDeferStart = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n() {
        /*
            r6 = this;
            r0 = 3
            java.lang.String r1 = "FragmentManager"
            boolean r0 = android.util.Log.isLoggable(r1, r0)
            androidx.fragment.app.Fragment r2 = r6.f3773c
            if (r0 == 0) goto L1c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "moveto RESUMED: "
            r0.<init>(r3)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r1, r0)
        L1c:
            android.view.View r0 = r2.getFocusedView()
            if (r0 == 0) goto L78
            android.view.View r3 = r2.mView
            if (r0 != r3) goto L27
            goto L31
        L27:
            android.view.ViewParent r3 = r0.getParent()
        L2b:
            if (r3 == 0) goto L78
            android.view.View r4 = r2.mView
            if (r3 != r4) goto L73
        L31:
            boolean r3 = r0.requestFocus()
            r4 = 2
            boolean r4 = android.util.Log.isLoggable(r1, r4)
            if (r4 == 0) goto L78
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "requestFocus: Restoring focused view "
            r4.<init>(r5)
            r4.append(r0)
            java.lang.String r0 = " "
            r4.append(r0)
            if (r3 == 0) goto L50
            java.lang.String r0 = "succeeded"
            goto L52
        L50:
            java.lang.String r0 = "failed"
        L52:
            r4.append(r0)
            java.lang.String r0 = " on Fragment "
            r4.append(r0)
            r4.append(r2)
            java.lang.String r0 = " resulting in focused view "
            r4.append(r0)
            android.view.View r0 = r2.mView
            android.view.View r0 = r0.findFocus()
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            android.util.Log.v(r1, r0)
            goto L78
        L73:
            android.view.ViewParent r3 = r3.getParent()
            goto L2b
        L78:
            r0 = 0
            r2.setFocusedView(r0)
            r2.performResume()
            androidx.fragment.app.A r1 = r6.f3771a
            r3 = 0
            r1.i(r3)
            r2.mSavedFragmentState = r0
            r2.mSavedViewState = r0
            r2.mSavedViewRegistryState = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.b0.n():void");
    }

    public final Bundle o() {
        Bundle bundle = new Bundle();
        Fragment fragment = this.f3773c;
        fragment.performSaveInstanceState(bundle);
        this.f3771a.j(false);
        if (bundle.isEmpty()) {
            bundle = null;
        }
        if (fragment.mView != null) {
            p();
        }
        if (fragment.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.mSavedViewState);
        }
        if (fragment.mSavedViewRegistryState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBundle("android:view_registry_state", fragment.mSavedViewRegistryState);
        }
        if (!fragment.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", fragment.mUserVisibleHint);
        }
        return bundle;
    }

    public final void p() {
        Fragment fragment = this.f3773c;
        if (fragment.mView == null) {
            return;
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        fragment.mView.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            fragment.mSavedViewState = sparseArray;
        }
        Bundle bundle = new Bundle();
        fragment.mViewLifecycleOwner.g.c(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        fragment.mSavedViewRegistryState = bundle;
    }

    public final void q() {
        boolean zIsLoggable = Log.isLoggable("FragmentManager", 3);
        Fragment fragment = this.f3773c;
        if (zIsLoggable) {
            Log.d("FragmentManager", "moveto STARTED: " + fragment);
        }
        fragment.performStart();
        this.f3771a.k(false);
    }

    public final void r() {
        boolean zIsLoggable = Log.isLoggable("FragmentManager", 3);
        Fragment fragment = this.f3773c;
        if (zIsLoggable) {
            Log.d("FragmentManager", "movefrom STARTED: " + fragment);
        }
        fragment.performStop();
        this.f3771a.l(false);
    }

    public b0(A a2, c0 c0Var, ClassLoader classLoader, L l5, Z z4) {
        this.f3771a = a2;
        this.f3772b = c0Var;
        Fragment fragmentInstantiate = Fragment.instantiate(l5.f3676a.f3706o.f3652d, z4.f3730j, null);
        this.f3773c = fragmentInstantiate;
        Bundle bundle = z4.f3738s;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        fragmentInstantiate.setArguments(bundle);
        fragmentInstantiate.mWho = z4.f3731k;
        fragmentInstantiate.mFromLayout = z4.f3732l;
        fragmentInstantiate.mRestored = true;
        fragmentInstantiate.mFragmentId = z4.f3733m;
        fragmentInstantiate.mContainerId = z4.n;
        fragmentInstantiate.mTag = z4.f3734o;
        fragmentInstantiate.mRetainInstance = z4.f3735p;
        fragmentInstantiate.mRemoving = z4.f3736q;
        fragmentInstantiate.mDetached = z4.f3737r;
        fragmentInstantiate.mHidden = z4.f3739t;
        fragmentInstantiate.mMaxState = EnumC0244n.values()[z4.f3740u];
        Bundle bundle2 = z4.f3741v;
        if (bundle2 != null) {
            fragmentInstantiate.mSavedFragmentState = bundle2;
        } else {
            fragmentInstantiate.mSavedFragmentState = new Bundle();
        }
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Instantiated fragment " + fragmentInstantiate);
        }
    }

    public b0(A a2, c0 c0Var, Fragment fragment, Z z4) {
        this.f3771a = a2;
        this.f3772b = c0Var;
        this.f3773c = fragment;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
        fragment.mBackStackNesting = 0;
        fragment.mInLayout = false;
        fragment.mAdded = false;
        Fragment fragment2 = fragment.mTarget;
        fragment.mTargetWho = fragment2 != null ? fragment2.mWho : null;
        fragment.mTarget = null;
        Bundle bundle = z4.f3741v;
        if (bundle != null) {
            fragment.mSavedFragmentState = bundle;
        } else {
            fragment.mSavedFragmentState = new Bundle();
        }
    }
}
