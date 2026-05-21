package androidx.fragment.app;

import B.AbstractC0000a;
import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.lifecycle.AbstractC0245o;
import androidx.lifecycle.C0251v;
import androidx.lifecycle.EnumC0243m;
import androidx.lifecycle.EnumC0244n;
import androidx.lifecycle.InterfaceC0239i;
import androidx.lifecycle.InterfaceC0249t;
import com.unified.ur1.R;
import d.AbstractC0422a;
import d0.AbstractC0423a;
import g0.AbstractC0535a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public abstract class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, InterfaceC0249t, androidx.lifecycle.X, InterfaceC0239i, o0.e {
    static final int ACTIVITY_CREATED = 4;
    static final int ATTACHED = 0;
    static final int AWAITING_ENTER_EFFECTS = 6;
    static final int AWAITING_EXIT_EFFECTS = 3;
    static final int CREATED = 1;
    static final int INITIALIZING = -1;
    static final int RESUMED = 7;
    static final int STARTED = 5;
    static final Object USE_DEFAULT_TRANSITION = new Object();
    static final int VIEW_CREATED = 2;
    boolean mAdded;
    C0224t mAnimationInfo;
    Bundle mArguments;
    int mBackStackNesting;
    private boolean mCalled;
    ViewGroup mContainer;
    int mContainerId;
    private int mContentLayoutId;
    boolean mDeferStart;
    boolean mDetached;
    int mFragmentId;
    T mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    boolean mHiddenChanged;
    F mHost;
    boolean mInLayout;
    boolean mIsCreated;
    boolean mIsNewlyAdded;
    LayoutInflater mLayoutInflater;
    Fragment mParentFragment;
    boolean mPerformedCreateView;
    float mPostponedAlpha;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetainInstanceChangedWhileDetached;
    Bundle mSavedFragmentState;
    Boolean mSavedUserVisibleHint;
    Bundle mSavedViewRegistryState;
    SparseArray<Parcelable> mSavedViewState;
    String mTag;
    Fragment mTarget;
    int mTargetRequestCode;
    View mView;
    m0 mViewLifecycleOwner;
    int mState = -1;
    String mWho = UUID.randomUUID().toString();
    String mTargetWho = null;
    private Boolean mIsPrimaryNavigationFragment = null;
    T mChildFragmentManager = new U();
    boolean mMenuVisible = true;
    boolean mUserVisibleHint = true;
    Runnable mPostponedDurationRunnable = new RunnableC0220o(this, 0);
    EnumC0244n mMaxState = EnumC0244n.n;
    androidx.lifecycle.B mViewLifecycleOwnerLiveData = new androidx.lifecycle.B();
    private final AtomicInteger mNextLocalRequestCode = new AtomicInteger();
    private final ArrayList<r> mOnPreAttachedListeners = new ArrayList<>();
    C0251v mLifecycleRegistry = new C0251v(this);
    o0.d mSavedStateRegistryController = new o0.d(this);
    androidx.lifecycle.V mDefaultFactory = null;

    @Deprecated
    public static Fragment instantiate(Context context, String str) {
        return instantiate(context, str, null);
    }

    public Activity c() {
        return getActivity();
    }

    public void callStartTransitionListener(boolean z4) {
        ViewGroup viewGroup;
        T t4;
        C0224t c0224t = this.mAnimationInfo;
        if (c0224t != null) {
            c0224t.f3889u = false;
            c0224t.getClass();
            c0224t.getClass();
        }
        if (this.mView == null || (viewGroup = this.mContainer) == null || (t4 = this.mFragmentManager) == null) {
            return;
        }
        C0215j c0215jH = C0215j.h(viewGroup, t4.A());
        c0215jH.j();
        if (z4) {
            this.mHost.f3653e.post(new RunnableC0210e(4, c0215jH));
        } else {
            c0215jH.d();
        }
    }

    public D createFragmentContainer() {
        return new C0221p(this);
    }

    public final C0224t d() {
        if (this.mAnimationInfo == null) {
            C0224t c0224t = new C0224t();
            c0224t.f3880k = null;
            Object obj = USE_DEFAULT_TRANSITION;
            c0224t.f3881l = obj;
            c0224t.f3882m = null;
            c0224t.n = obj;
            c0224t.f3883o = null;
            c0224t.f3884p = obj;
            c0224t.f3887s = 1.0f;
            c0224t.f3888t = null;
            this.mAnimationInfo = c0224t;
        }
        return this.mAnimationInfo;
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.mFragmentId));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.mContainerId));
        printWriter.print(" mTag=");
        printWriter.println(this.mTag);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.mState);
        printWriter.print(" mWho=");
        printWriter.print(this.mWho);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.mBackStackNesting);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.mAdded);
        printWriter.print(" mRemoving=");
        printWriter.print(this.mRemoving);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.mFromLayout);
        printWriter.print(" mInLayout=");
        printWriter.println(this.mInLayout);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.mHidden);
        printWriter.print(" mDetached=");
        printWriter.print(this.mDetached);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.mMenuVisible);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.mHasMenu);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.mRetainInstance);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.mUserVisibleHint);
        if (this.mFragmentManager != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.mFragmentManager);
        }
        if (this.mHost != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.mHost);
        }
        if (this.mParentFragment != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.mParentFragment);
        }
        if (this.mArguments != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.mArguments);
        }
        if (this.mSavedFragmentState != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.mSavedFragmentState);
        }
        if (this.mSavedViewState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.mSavedViewState);
        }
        if (this.mSavedViewRegistryState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.mSavedViewRegistryState);
        }
        Fragment targetFragment = getTargetFragment();
        if (targetFragment != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(targetFragment);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.mTargetRequestCode);
        }
        printWriter.print(str);
        printWriter.print("mPopDirection=");
        printWriter.println(getPopDirection());
        if (getEnterAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getEnterAnim=");
            printWriter.println(getEnterAnim());
        }
        if (getExitAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getExitAnim=");
            printWriter.println(getExitAnim());
        }
        if (getPopEnterAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getPopEnterAnim=");
            printWriter.println(getPopEnterAnim());
        }
        if (getPopExitAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getPopExitAnim=");
            printWriter.println(getPopExitAnim());
        }
        if (this.mContainer != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.mContainer);
        }
        if (this.mView != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.mView);
        }
        if (getAnimatingAway() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(getAnimatingAway());
        }
        if (getContext() != null) {
            AbstractC0423a.a(this).b(str, printWriter);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.mChildFragmentManager + ":");
        this.mChildFragmentManager.p(com.unified.ur1.SatelliteTracker.h.b(str, "  "), fileDescriptor, printWriter, strArr);
    }

    public final int e() {
        EnumC0244n enumC0244n = this.mMaxState;
        return (enumC0244n == EnumC0244n.f3962k || this.mParentFragment == null) ? enumC0244n.ordinal() : Math.min(enumC0244n.ordinal(), this.mParentFragment.e());
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final C0223s f(AbstractC0422a abstractC0422a, C0222q c0222q, androidx.activity.result.b bVar) {
        if (this.mState > 1) {
            throw new IllegalStateException(AbstractC0535a.k("Fragment ", this, " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate())."));
        }
        AtomicReference atomicReference = new AtomicReference();
        r rVar = new r(this, c0222q, atomicReference, abstractC0422a, bVar);
        if (this.mState >= 0) {
            atomicReference.set(((androidx.activity.result.g) c0222q.a()).c(generateActivityResultKey(), this, abstractC0422a, bVar));
        } else {
            this.mOnPreAttachedListeners.add(rVar);
        }
        return new C0223s(atomicReference);
    }

    public Fragment findFragmentByWho(String str) {
        return str.equals(this.mWho) ? this : this.mChildFragmentManager.f3697c.c(str);
    }

    public String generateActivityResultKey() {
        return "fragment_" + this.mWho + "_rq#" + this.mNextLocalRequestCode.getAndIncrement();
    }

    public final AbstractActivityC0230z getActivity() {
        F f5 = this.mHost;
        if (f5 == null) {
            return null;
        }
        return (AbstractActivityC0230z) f5.f3651c;
    }

    public boolean getAllowEnterTransitionOverlap() {
        Boolean bool;
        C0224t c0224t = this.mAnimationInfo;
        if (c0224t == null || (bool = c0224t.f3886r) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public boolean getAllowReturnTransitionOverlap() {
        Boolean bool;
        C0224t c0224t = this.mAnimationInfo;
        if (c0224t == null || (bool = c0224t.f3885q) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public View getAnimatingAway() {
        C0224t c0224t = this.mAnimationInfo;
        if (c0224t == null) {
            return null;
        }
        return c0224t.f3872a;
    }

    public Animator getAnimator() {
        C0224t c0224t = this.mAnimationInfo;
        if (c0224t == null) {
            return null;
        }
        return c0224t.f3873b;
    }

    public final Bundle getArguments() {
        return this.mArguments;
    }

    public final T getChildFragmentManager() {
        if (this.mHost != null) {
            return this.mChildFragmentManager;
        }
        throw new IllegalStateException(AbstractC0535a.k("Fragment ", this, " has not been attached yet."));
    }

    public Context getContext() {
        F f5 = this.mHost;
        if (f5 == null) {
            return null;
        }
        return f5.f3652d;
    }

    @Override // androidx.lifecycle.InterfaceC0239i
    public androidx.lifecycle.V getDefaultViewModelProviderFactory() {
        Application application;
        if (this.mFragmentManager == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (this.mDefaultFactory == null) {
            Context applicationContext = requireContext().getApplicationContext();
            while (true) {
                if (!(applicationContext instanceof ContextWrapper)) {
                    application = null;
                    break;
                }
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                }
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
            if (application == null && Log.isLoggable("FragmentManager", 3)) {
                Log.d("FragmentManager", "Could not find Application instance from Context " + requireContext().getApplicationContext() + ", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
            }
            this.mDefaultFactory = new androidx.lifecycle.P(application, this, getArguments());
        }
        return this.mDefaultFactory;
    }

    public int getEnterAnim() {
        C0224t c0224t = this.mAnimationInfo;
        if (c0224t == null) {
            return 0;
        }
        return c0224t.f3875d;
    }

    public Object getEnterTransition() {
        C0224t c0224t = this.mAnimationInfo;
        if (c0224t == null) {
            return null;
        }
        return c0224t.f3880k;
    }

    public B.y getEnterTransitionCallback() {
        C0224t c0224t = this.mAnimationInfo;
        if (c0224t == null) {
            return null;
        }
        c0224t.getClass();
        return null;
    }

    public int getExitAnim() {
        C0224t c0224t = this.mAnimationInfo;
        if (c0224t == null) {
            return 0;
        }
        return c0224t.f3876e;
    }

    public Object getExitTransition() {
        C0224t c0224t = this.mAnimationInfo;
        if (c0224t == null) {
            return null;
        }
        return c0224t.f3882m;
    }

    public B.y getExitTransitionCallback() {
        C0224t c0224t = this.mAnimationInfo;
        if (c0224t == null) {
            return null;
        }
        c0224t.getClass();
        return null;
    }

    public View getFocusedView() {
        C0224t c0224t = this.mAnimationInfo;
        if (c0224t == null) {
            return null;
        }
        return c0224t.f3888t;
    }

    @Deprecated
    public final T getFragmentManager() {
        return this.mFragmentManager;
    }

    public final Object getHost() {
        F f5 = this.mHost;
        if (f5 == null) {
            return null;
        }
        return ((C0229y) f5).g;
    }

    public final int getId() {
        return this.mFragmentId;
    }

    public final LayoutInflater getLayoutInflater() {
        LayoutInflater layoutInflater = this.mLayoutInflater;
        return layoutInflater == null ? performGetLayoutInflater(null) : layoutInflater;
    }

    @Override // androidx.lifecycle.InterfaceC0249t
    public AbstractC0245o getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Deprecated
    public AbstractC0423a getLoaderManager() {
        return AbstractC0423a.a(this);
    }

    public int getNextTransition() {
        C0224t c0224t = this.mAnimationInfo;
        if (c0224t == null) {
            return 0;
        }
        return c0224t.h;
    }

    public final Fragment getParentFragment() {
        return this.mParentFragment;
    }

    public final T getParentFragmentManager() {
        T t4 = this.mFragmentManager;
        if (t4 != null) {
            return t4;
        }
        throw new IllegalStateException(AbstractC0535a.k("Fragment ", this, " not associated with a fragment manager."));
    }

    public boolean getPopDirection() {
        C0224t c0224t = this.mAnimationInfo;
        if (c0224t == null) {
            return false;
        }
        return c0224t.f3874c;
    }

    public int getPopEnterAnim() {
        C0224t c0224t = this.mAnimationInfo;
        if (c0224t == null) {
            return 0;
        }
        return c0224t.f3877f;
    }

    public int getPopExitAnim() {
        C0224t c0224t = this.mAnimationInfo;
        if (c0224t == null) {
            return 0;
        }
        return c0224t.g;
    }

    public float getPostOnViewCreatedAlpha() {
        C0224t c0224t = this.mAnimationInfo;
        if (c0224t == null) {
            return 1.0f;
        }
        return c0224t.f3887s;
    }

    public Object getReenterTransition() {
        C0224t c0224t = this.mAnimationInfo;
        if (c0224t == null) {
            return null;
        }
        Object obj = c0224t.n;
        return obj == USE_DEFAULT_TRANSITION ? getExitTransition() : obj;
    }

    public final Resources getResources() {
        return requireContext().getResources();
    }

    @Deprecated
    public final boolean getRetainInstance() {
        return this.mRetainInstance;
    }

    public Object getReturnTransition() {
        C0224t c0224t = this.mAnimationInfo;
        if (c0224t == null) {
            return null;
        }
        Object obj = c0224t.f3881l;
        return obj == USE_DEFAULT_TRANSITION ? getEnterTransition() : obj;
    }

    @Override // o0.e
    public final o0.c getSavedStateRegistry() {
        return this.mSavedStateRegistryController.f8893b;
    }

    public Object getSharedElementEnterTransition() {
        C0224t c0224t = this.mAnimationInfo;
        if (c0224t == null) {
            return null;
        }
        return c0224t.f3883o;
    }

    public Object getSharedElementReturnTransition() {
        C0224t c0224t = this.mAnimationInfo;
        if (c0224t == null) {
            return null;
        }
        Object obj = c0224t.f3884p;
        return obj == USE_DEFAULT_TRANSITION ? getSharedElementEnterTransition() : obj;
    }

    public ArrayList<String> getSharedElementSourceNames() {
        ArrayList<String> arrayList;
        C0224t c0224t = this.mAnimationInfo;
        return (c0224t == null || (arrayList = c0224t.f3878i) == null) ? new ArrayList<>() : arrayList;
    }

    public ArrayList<String> getSharedElementTargetNames() {
        ArrayList<String> arrayList;
        C0224t c0224t = this.mAnimationInfo;
        return (c0224t == null || (arrayList = c0224t.f3879j) == null) ? new ArrayList<>() : arrayList;
    }

    public final String getString(int i5) {
        return getResources().getString(i5);
    }

    public final String getTag() {
        return this.mTag;
    }

    @Deprecated
    public final Fragment getTargetFragment() {
        String str;
        Fragment fragment = this.mTarget;
        if (fragment != null) {
            return fragment;
        }
        T t4 = this.mFragmentManager;
        if (t4 == null || (str = this.mTargetWho) == null) {
            return null;
        }
        return t4.f3697c.b(str);
    }

    @Deprecated
    public final int getTargetRequestCode() {
        return this.mTargetRequestCode;
    }

    public final CharSequence getText(int i5) {
        return getResources().getText(i5);
    }

    @Deprecated
    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    public View getView() {
        return this.mView;
    }

    public InterfaceC0249t getViewLifecycleOwner() {
        m0 m0Var = this.mViewLifecycleOwner;
        if (m0Var != null) {
            return m0Var;
        }
        throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    public androidx.lifecycle.A getViewLifecycleOwnerLiveData() {
        return this.mViewLifecycleOwnerLiveData;
    }

    @Override // androidx.lifecycle.X
    public androidx.lifecycle.W getViewModelStore() {
        if (this.mFragmentManager == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (e() == 1) {
            throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
        }
        HashMap map = this.mFragmentManager.f3693G.f3728f;
        androidx.lifecycle.W w4 = (androidx.lifecycle.W) map.get(this.mWho);
        if (w4 != null) {
            return w4;
        }
        androidx.lifecycle.W w5 = new androidx.lifecycle.W();
        map.put(this.mWho, w5);
        return w5;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public void initState() {
        this.mLifecycleRegistry = new C0251v(this);
        this.mSavedStateRegistryController = new o0.d(this);
        this.mDefaultFactory = null;
        this.mWho = UUID.randomUUID().toString();
        this.mAdded = false;
        this.mRemoving = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.mFragmentManager = null;
        this.mChildFragmentManager = new U();
        this.mHost = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
    }

    public final boolean isAdded() {
        return this.mHost != null && this.mAdded;
    }

    public final boolean isDetached() {
        return this.mDetached;
    }

    public final boolean isHidden() {
        return this.mHidden;
    }

    public boolean isHideReplaced() {
        C0224t c0224t = this.mAnimationInfo;
        if (c0224t == null) {
            return false;
        }
        return c0224t.f3890v;
    }

    public final boolean isInBackStack() {
        return this.mBackStackNesting > 0;
    }

    public final boolean isInLayout() {
        return this.mInLayout;
    }

    public final boolean isMenuVisible() {
        if (this.mMenuVisible) {
            if (this.mFragmentManager == null) {
                return true;
            }
            Fragment fragment = this.mParentFragment;
            if (fragment == null ? true : fragment.isMenuVisible()) {
                return true;
            }
        }
        return false;
    }

    public boolean isPostponed() {
        C0224t c0224t = this.mAnimationInfo;
        if (c0224t == null) {
            return false;
        }
        return c0224t.f3889u;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    public final boolean isRemovingParent() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null && (parentFragment.isRemoving() || parentFragment.isRemovingParent());
    }

    public final boolean isResumed() {
        return this.mState >= 7;
    }

    public final boolean isStateSaved() {
        T t4 = this.mFragmentManager;
        if (t4 == null) {
            return false;
        }
        return t4.E();
    }

    public final boolean isVisible() {
        View view;
        return (!isAdded() || isHidden() || (view = this.mView) == null || view.getWindowToken() == null || this.mView.getVisibility() != 0) ? false : true;
    }

    public void noteStateNotSaved() {
        this.mChildFragmentManager.G();
    }

    public void onActivityCreated(Bundle bundle) {
        this.mCalled = true;
    }

    @Deprecated
    public void onActivityResult(int i5, int i6, Intent intent) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i5 + " resultCode: " + i6 + " data: " + intent);
        }
    }

    public void onAttach(Context context) {
        this.mCalled = true;
        F f5 = this.mHost;
        Activity activity = f5 == null ? null : f5.f3651c;
        if (activity != null) {
            this.mCalled = false;
            onAttach(activity);
        }
    }

    @Deprecated
    public void onAttachFragment(Fragment fragment) {
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.mCalled = true;
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onCreate(Bundle bundle) {
        this.mCalled = true;
        restoreChildFragmentState(bundle);
        T t4 = this.mChildFragmentManager;
        if (t4.n >= 1) {
            return;
        }
        t4.f3717z = false;
        t4.f3687A = false;
        t4.f3693G.f3729i = false;
        t4.o(1);
    }

    public Animation onCreateAnimation(int i5, boolean z4, int i6) {
        return null;
    }

    public Animator onCreateAnimator(int i5, boolean z4, int i6) {
        return null;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        requireActivity().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i5 = this.mContentLayoutId;
        if (i5 != 0) {
            return layoutInflater.inflate(i5, viewGroup, false);
        }
        return null;
    }

    public void onDestroy() {
        this.mCalled = true;
    }

    public void onDestroyOptionsMenu() {
    }

    public void onDestroyView() {
        this.mCalled = true;
    }

    public void onDetach() {
        this.mCalled = true;
    }

    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        return getLayoutInflater(bundle);
    }

    public void onHiddenChanged(boolean z4) {
    }

    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
        F f5 = this.mHost;
        Activity activity = f5 == null ? null : f5.f3651c;
        if (activity != null) {
            this.mCalled = false;
            onInflate(activity, attributeSet, bundle);
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onMultiWindowModeChanged(boolean z4) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onOptionsMenuClosed(Menu menu) {
    }

    public void onPause() {
        this.mCalled = true;
    }

    public void onPictureInPictureModeChanged(boolean z4) {
    }

    public void onPrepareOptionsMenu(Menu menu) {
    }

    public void onPrimaryNavigationFragmentChanged(boolean z4) {
    }

    @Deprecated
    public void onRequestPermissionsResult(int i5, String[] strArr, int[] iArr) {
    }

    public void onResume() {
        this.mCalled = true;
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onStart() {
        this.mCalled = true;
    }

    public void onStop() {
        this.mCalled = true;
    }

    public void onViewCreated(View view, Bundle bundle) {
    }

    public void onViewStateRestored(Bundle bundle) {
        this.mCalled = true;
    }

    public void performActivityCreated(Bundle bundle) {
        this.mChildFragmentManager.G();
        this.mState = 3;
        this.mCalled = false;
        onActivityCreated(bundle);
        if (!this.mCalled) {
            throw new q0(AbstractC0535a.k("Fragment ", this, " did not call through to super.onActivityCreated()"));
        }
        if (Log.isLoggable("FragmentManager", 3)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + this);
        }
        if (this.mView != null) {
            restoreViewState(this.mSavedFragmentState);
        }
        this.mSavedFragmentState = null;
        T t4 = this.mChildFragmentManager;
        t4.f3717z = false;
        t4.f3687A = false;
        t4.f3693G.f3729i = false;
        t4.o(4);
    }

    public void performAttach() {
        Iterator<r> it = this.mOnPreAttachedListeners.iterator();
        while (it.hasNext()) {
            r next = it.next();
            Fragment fragment = next.f3870e;
            next.f3867b.set(((androidx.activity.result.g) next.f3866a.a()).c(fragment.generateActivityResultKey(), fragment, next.f3868c, next.f3869d));
        }
        this.mOnPreAttachedListeners.clear();
        this.mChildFragmentManager.b(this.mHost, createFragmentContainer(), this);
        this.mState = 0;
        this.mCalled = false;
        onAttach(this.mHost.f3652d);
        if (!this.mCalled) {
            throw new q0(AbstractC0535a.k("Fragment ", this, " did not call through to super.onAttach()"));
        }
        Iterator it2 = this.mFragmentManager.f3705m.iterator();
        while (it2.hasNext()) {
            ((X) it2.next()).a(this);
        }
        T t4 = this.mChildFragmentManager;
        t4.f3717z = false;
        t4.f3687A = false;
        t4.f3693G.f3729i = false;
        t4.o(0);
    }

    public void performConfigurationChanged(Configuration configuration) {
        onConfigurationChanged(configuration);
        for (Fragment fragment : this.mChildFragmentManager.f3697c.f()) {
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
            }
        }
    }

    public boolean performContextItemSelected(MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        if (onContextItemSelected(menuItem)) {
            return true;
        }
        return this.mChildFragmentManager.h(menuItem);
    }

    public void performCreate(Bundle bundle) {
        this.mChildFragmentManager.G();
        this.mState = 1;
        this.mCalled = false;
        this.mLifecycleRegistry.a(new androidx.lifecycle.r() { // from class: androidx.fragment.app.Fragment.5
            @Override // androidx.lifecycle.r
            public final void a(InterfaceC0249t interfaceC0249t, EnumC0243m enumC0243m) {
                View view;
                if (enumC0243m != EnumC0243m.ON_STOP || (view = Fragment.this.mView) == null) {
                    return;
                }
                view.cancelPendingInputEvents();
            }
        });
        this.mSavedStateRegistryController.b(bundle);
        onCreate(bundle);
        this.mIsCreated = true;
        if (!this.mCalled) {
            throw new q0(AbstractC0535a.k("Fragment ", this, " did not call through to super.onCreate()"));
        }
        this.mLifecycleRegistry.e(EnumC0243m.ON_CREATE);
    }

    public boolean performCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        boolean z4 = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onCreateOptionsMenu(menu, menuInflater);
            z4 = true;
        }
        return z4 | this.mChildFragmentManager.i(menu, menuInflater);
    }

    public void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mChildFragmentManager.G();
        this.mPerformedCreateView = true;
        this.mViewLifecycleOwner = new m0(this, getViewModelStore());
        View viewOnCreateView = onCreateView(layoutInflater, viewGroup, bundle);
        this.mView = viewOnCreateView;
        if (viewOnCreateView == null) {
            if (this.mViewLifecycleOwner.f3836f != null) {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.mViewLifecycleOwner = null;
            return;
        }
        this.mViewLifecycleOwner.b();
        View view = this.mView;
        m0 m0Var = this.mViewLifecycleOwner;
        F3.i.f(view, "<this>");
        view.setTag(R.id.view_tree_lifecycle_owner, m0Var);
        View view2 = this.mView;
        m0 m0Var2 = this.mViewLifecycleOwner;
        F3.i.f(view2, "<this>");
        view2.setTag(R.id.view_tree_view_model_store_owner, m0Var2);
        View view3 = this.mView;
        m0 m0Var3 = this.mViewLifecycleOwner;
        F3.i.f(view3, "<this>");
        view3.setTag(R.id.view_tree_saved_state_registry_owner, m0Var3);
        this.mViewLifecycleOwnerLiveData.e(this.mViewLifecycleOwner);
    }

    public void performDestroy() {
        this.mChildFragmentManager.j();
        this.mLifecycleRegistry.e(EnumC0243m.ON_DESTROY);
        this.mState = 0;
        this.mCalled = false;
        this.mIsCreated = false;
        onDestroy();
        if (!this.mCalled) {
            throw new q0(AbstractC0535a.k("Fragment ", this, " did not call through to super.onDestroy()"));
        }
    }

    public void performDestroyView() {
        this.mChildFragmentManager.o(1);
        if (this.mView != null) {
            m0 m0Var = this.mViewLifecycleOwner;
            m0Var.b();
            if (m0Var.f3836f.f3971c.compareTo(EnumC0244n.f3963l) >= 0) {
                this.mViewLifecycleOwner.a(EnumC0243m.ON_DESTROY);
            }
        }
        this.mState = 1;
        this.mCalled = false;
        onDestroyView();
        if (!this.mCalled) {
            throw new q0(AbstractC0535a.k("Fragment ", this, " did not call through to super.onDestroyView()"));
        }
        q.l lVar = AbstractC0423a.a(this).f6100b.f6098d;
        if (lVar.f9282l <= 0) {
            this.mPerformedCreateView = false;
        } else {
            com.unified.ur1.SatelliteTracker.h.p(lVar.f9281k[0]);
            throw null;
        }
    }

    public void performDetach() {
        this.mState = -1;
        this.mCalled = false;
        onDetach();
        this.mLayoutInflater = null;
        if (!this.mCalled) {
            throw new q0(AbstractC0535a.k("Fragment ", this, " did not call through to super.onDetach()"));
        }
        T t4 = this.mChildFragmentManager;
        if (t4.f3688B) {
            return;
        }
        t4.j();
        this.mChildFragmentManager = new U();
    }

    public LayoutInflater performGetLayoutInflater(Bundle bundle) {
        LayoutInflater layoutInflaterOnGetLayoutInflater = onGetLayoutInflater(bundle);
        this.mLayoutInflater = layoutInflaterOnGetLayoutInflater;
        return layoutInflaterOnGetLayoutInflater;
    }

    public void performLowMemory() {
        onLowMemory();
        for (Fragment fragment : this.mChildFragmentManager.f3697c.f()) {
            if (fragment != null) {
                fragment.performLowMemory();
            }
        }
    }

    public void performMultiWindowModeChanged(boolean z4) {
        onMultiWindowModeChanged(z4);
        for (Fragment fragment : this.mChildFragmentManager.f3697c.f()) {
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z4);
            }
        }
    }

    public boolean performOptionsItemSelected(MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible && onOptionsItemSelected(menuItem)) {
            return true;
        }
        return this.mChildFragmentManager.k(menuItem);
    }

    public void performOptionsMenuClosed(Menu menu) {
        if (this.mHidden) {
            return;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onOptionsMenuClosed(menu);
        }
        this.mChildFragmentManager.l(menu);
    }

    public void performPause() {
        this.mChildFragmentManager.o(5);
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(EnumC0243m.ON_PAUSE);
        }
        this.mLifecycleRegistry.e(EnumC0243m.ON_PAUSE);
        this.mState = 6;
        this.mCalled = false;
        onPause();
        if (!this.mCalled) {
            throw new q0(AbstractC0535a.k("Fragment ", this, " did not call through to super.onPause()"));
        }
    }

    public void performPictureInPictureModeChanged(boolean z4) {
        onPictureInPictureModeChanged(z4);
        for (Fragment fragment : this.mChildFragmentManager.f3697c.f()) {
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z4);
            }
        }
    }

    public boolean performPrepareOptionsMenu(Menu menu) {
        boolean z4 = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onPrepareOptionsMenu(menu);
            z4 = true;
        }
        return z4 | this.mChildFragmentManager.n(menu);
    }

    public void performPrimaryNavigationFragmentChanged() {
        this.mFragmentManager.getClass();
        boolean zD = T.D(this);
        Boolean bool = this.mIsPrimaryNavigationFragment;
        if (bool == null || bool.booleanValue() != zD) {
            this.mIsPrimaryNavigationFragment = Boolean.valueOf(zD);
            onPrimaryNavigationFragmentChanged(zD);
            T t4 = this.mChildFragmentManager;
            t4.Y();
            t4.m(t4.f3709r);
        }
    }

    public void performResume() {
        this.mChildFragmentManager.G();
        this.mChildFragmentManager.s(true);
        this.mState = 7;
        this.mCalled = false;
        onResume();
        if (!this.mCalled) {
            throw new q0(AbstractC0535a.k("Fragment ", this, " did not call through to super.onResume()"));
        }
        C0251v c0251v = this.mLifecycleRegistry;
        EnumC0243m enumC0243m = EnumC0243m.ON_RESUME;
        c0251v.e(enumC0243m);
        if (this.mView != null) {
            this.mViewLifecycleOwner.f3836f.e(enumC0243m);
        }
        T t4 = this.mChildFragmentManager;
        t4.f3717z = false;
        t4.f3687A = false;
        t4.f3693G.f3729i = false;
        t4.o(7);
    }

    public void performSaveInstanceState(Bundle bundle) {
        onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.c(bundle);
        V vN = this.mChildFragmentManager.N();
        if (vN != null) {
            bundle.putParcelable("android:support:fragments", vN);
        }
    }

    public void performStart() {
        this.mChildFragmentManager.G();
        this.mChildFragmentManager.s(true);
        this.mState = 5;
        this.mCalled = false;
        onStart();
        if (!this.mCalled) {
            throw new q0(AbstractC0535a.k("Fragment ", this, " did not call through to super.onStart()"));
        }
        C0251v c0251v = this.mLifecycleRegistry;
        EnumC0243m enumC0243m = EnumC0243m.ON_START;
        c0251v.e(enumC0243m);
        if (this.mView != null) {
            this.mViewLifecycleOwner.f3836f.e(enumC0243m);
        }
        T t4 = this.mChildFragmentManager;
        t4.f3717z = false;
        t4.f3687A = false;
        t4.f3693G.f3729i = false;
        t4.o(5);
    }

    public void performStop() {
        T t4 = this.mChildFragmentManager;
        t4.f3687A = true;
        t4.f3693G.f3729i = true;
        t4.o(4);
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(EnumC0243m.ON_STOP);
        }
        this.mLifecycleRegistry.e(EnumC0243m.ON_STOP);
        this.mState = 4;
        this.mCalled = false;
        onStop();
        if (!this.mCalled) {
            throw new q0(AbstractC0535a.k("Fragment ", this, " did not call through to super.onStop()"));
        }
    }

    public void performViewCreated() {
        onViewCreated(this.mView, this.mSavedFragmentState);
        this.mChildFragmentManager.o(2);
    }

    public void postponeEnterTransition() {
        d().f3889u = true;
    }

    public final <I, O> androidx.activity.result.c registerForActivityResult(AbstractC0422a abstractC0422a, androidx.activity.result.b bVar) {
        return f(abstractC0422a, new C0222q(0, this), bVar);
    }

    public void registerForContextMenu(View view) {
        view.setOnCreateContextMenuListener(this);
    }

    @Deprecated
    public final void requestPermissions(String[] strArr, int i5) throws Exception {
        if (this.mHost == null) {
            throw new IllegalStateException(AbstractC0535a.k("Fragment ", this, " not attached to Activity"));
        }
        T parentFragmentManager = getParentFragmentManager();
        if (parentFragmentManager.f3714w == null) {
            parentFragmentManager.f3706o.getClass();
            return;
        }
        parentFragmentManager.f3715x.addLast(new O(this.mWho, i5));
        parentFragmentManager.f3714w.a(strArr);
    }

    public final AbstractActivityC0230z requireActivity() {
        AbstractActivityC0230z activity = getActivity();
        if (activity != null) {
            return activity;
        }
        throw new IllegalStateException(AbstractC0535a.k("Fragment ", this, " not attached to an activity."));
    }

    public final Bundle requireArguments() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments;
        }
        throw new IllegalStateException(AbstractC0535a.k("Fragment ", this, " does not have any arguments."));
    }

    public final Context requireContext() {
        Context context = getContext();
        if (context != null) {
            return context;
        }
        throw new IllegalStateException(AbstractC0535a.k("Fragment ", this, " not attached to a context."));
    }

    @Deprecated
    public final T requireFragmentManager() {
        return getParentFragmentManager();
    }

    public final Object requireHost() {
        Object host = getHost();
        if (host != null) {
            return host;
        }
        throw new IllegalStateException(AbstractC0535a.k("Fragment ", this, " not attached to a host."));
    }

    public final Fragment requireParentFragment() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            return parentFragment;
        }
        if (getContext() == null) {
            throw new IllegalStateException(AbstractC0535a.k("Fragment ", this, " is not attached to any Fragment or host"));
        }
        throw new IllegalStateException("Fragment " + this + " is not a child Fragment, it is directly attached to " + getContext());
    }

    public final View requireView() {
        View view = getView();
        if (view != null) {
            return view;
        }
        throw new IllegalStateException(AbstractC0535a.k("Fragment ", this, " did not return a View from onCreateView() or this was called before onCreateView()."));
    }

    public void restoreChildFragmentState(Bundle bundle) {
        Parcelable parcelable;
        if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
            return;
        }
        this.mChildFragmentManager.M(parcelable);
        T t4 = this.mChildFragmentManager;
        t4.f3717z = false;
        t4.f3687A = false;
        t4.f3693G.f3729i = false;
        t4.o(1);
    }

    public final void restoreViewState(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.mSavedViewState;
        if (sparseArray != null) {
            this.mView.restoreHierarchyState(sparseArray);
            this.mSavedViewState = null;
        }
        if (this.mView != null) {
            m0 m0Var = this.mViewLifecycleOwner;
            m0Var.g.b(this.mSavedViewRegistryState);
            this.mSavedViewRegistryState = null;
        }
        this.mCalled = false;
        onViewStateRestored(bundle);
        if (!this.mCalled) {
            throw new q0(AbstractC0535a.k("Fragment ", this, " did not call through to super.onViewStateRestored()"));
        }
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(EnumC0243m.ON_CREATE);
        }
    }

    public void setAllowEnterTransitionOverlap(boolean z4) {
        d().f3886r = Boolean.valueOf(z4);
    }

    public void setAllowReturnTransitionOverlap(boolean z4) {
        d().f3885q = Boolean.valueOf(z4);
    }

    public void setAnimatingAway(View view) {
        d().f3872a = view;
    }

    public void setAnimations(int i5, int i6, int i7, int i8) {
        if (this.mAnimationInfo == null && i5 == 0 && i6 == 0 && i7 == 0 && i8 == 0) {
            return;
        }
        d().f3875d = i5;
        d().f3876e = i6;
        d().f3877f = i7;
        d().g = i8;
    }

    public void setAnimator(Animator animator) {
        d().f3873b = animator;
    }

    public void setArguments(Bundle bundle) {
        if (this.mFragmentManager != null && isStateSaved()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.mArguments = bundle;
    }

    public void setEnterSharedElementCallback(B.y yVar) {
        d().getClass();
    }

    public void setEnterTransition(Object obj) {
        d().f3880k = obj;
    }

    public void setExitSharedElementCallback(B.y yVar) {
        d().getClass();
    }

    public void setExitTransition(Object obj) {
        d().f3882m = obj;
    }

    public void setFocusedView(View view) {
        d().f3888t = view;
    }

    public void setHasOptionsMenu(boolean z4) {
        if (this.mHasMenu != z4) {
            this.mHasMenu = z4;
            if (!isAdded() || isHidden()) {
                return;
            }
            ((C0229y) this.mHost).g.supportInvalidateOptionsMenu();
        }
    }

    public void setHideReplaced(boolean z4) {
        d().f3890v = z4;
    }

    public void setInitialSavedState(C0226v c0226v) {
        Bundle bundle;
        if (this.mFragmentManager != null) {
            throw new IllegalStateException("Fragment already added");
        }
        if (c0226v == null || (bundle = c0226v.f3891j) == null) {
            bundle = null;
        }
        this.mSavedFragmentState = bundle;
    }

    public void setMenuVisibility(boolean z4) {
        if (this.mMenuVisible != z4) {
            this.mMenuVisible = z4;
            if (this.mHasMenu && isAdded() && !isHidden()) {
                ((C0229y) this.mHost).g.supportInvalidateOptionsMenu();
            }
        }
    }

    public void setNextTransition(int i5) {
        if (this.mAnimationInfo == null && i5 == 0) {
            return;
        }
        d();
        this.mAnimationInfo.h = i5;
    }

    public void setOnStartEnterTransitionListener(InterfaceC0225u interfaceC0225u) {
        d();
        C0224t c0224t = this.mAnimationInfo;
        c0224t.getClass();
        if (interfaceC0225u == null) {
            return;
        }
        if (c0224t.f3889u) {
            c0224t.getClass();
        }
        if (interfaceC0225u != null) {
            ((X1.e) interfaceC0225u).f2754a++;
        }
    }

    public void setPopDirection(boolean z4) {
        if (this.mAnimationInfo == null) {
            return;
        }
        d().f3874c = z4;
    }

    public void setPostOnViewCreatedAlpha(float f5) {
        d().f3887s = f5;
    }

    public void setReenterTransition(Object obj) {
        d().n = obj;
    }

    @Deprecated
    public void setRetainInstance(boolean z4) {
        this.mRetainInstance = z4;
        T t4 = this.mFragmentManager;
        if (t4 == null) {
            this.mRetainInstanceChangedWhileDetached = true;
        } else if (z4) {
            t4.f3693G.c(this);
        } else {
            t4.f3693G.d(this);
        }
    }

    public void setReturnTransition(Object obj) {
        d().f3881l = obj;
    }

    public void setSharedElementEnterTransition(Object obj) {
        d().f3883o = obj;
    }

    public void setSharedElementNames(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        d();
        C0224t c0224t = this.mAnimationInfo;
        c0224t.f3878i = arrayList;
        c0224t.f3879j = arrayList2;
    }

    public void setSharedElementReturnTransition(Object obj) {
        d().f3884p = obj;
    }

    @Deprecated
    public void setTargetFragment(Fragment fragment, int i5) {
        T t4 = this.mFragmentManager;
        T t5 = fragment != null ? fragment.mFragmentManager : null;
        if (t4 != null && t5 != null && t4 != t5) {
            throw new IllegalArgumentException(AbstractC0535a.k("Fragment ", fragment, " must share the same FragmentManager to be set as a target fragment"));
        }
        for (Fragment targetFragment = fragment; targetFragment != null; targetFragment = targetFragment.getTargetFragment()) {
            if (targetFragment.equals(this)) {
                throw new IllegalArgumentException("Setting " + fragment + " as the target of " + this + " would create a target cycle");
            }
        }
        if (fragment == null) {
            this.mTargetWho = null;
            this.mTarget = null;
        } else if (this.mFragmentManager == null || fragment.mFragmentManager == null) {
            this.mTargetWho = null;
            this.mTarget = fragment;
        } else {
            this.mTargetWho = fragment.mWho;
            this.mTarget = null;
        }
        this.mTargetRequestCode = i5;
    }

    @Deprecated
    public void setUserVisibleHint(boolean z4) {
        boolean z5 = false;
        if (!this.mUserVisibleHint && z4 && this.mState < 5 && this.mFragmentManager != null && isAdded() && this.mIsCreated) {
            T t4 = this.mFragmentManager;
            b0 b0VarF = t4.f(this);
            Fragment fragment = b0VarF.f3773c;
            if (fragment.mDeferStart) {
                if (t4.f3696b) {
                    t4.f3689C = true;
                } else {
                    fragment.mDeferStart = false;
                    b0VarF.k();
                }
            }
        }
        this.mUserVisibleHint = z4;
        if (this.mState < 5 && !z4) {
            z5 = true;
        }
        this.mDeferStart = z5;
        if (this.mSavedFragmentState != null) {
            this.mSavedUserVisibleHint = Boolean.valueOf(z4);
        }
    }

    public boolean shouldShowRequestPermissionRationale(String str) {
        F f5 = this.mHost;
        if (f5 != null) {
            return B.e.e(((C0229y) f5).g, str);
        }
        return false;
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent intent) {
        startActivity(intent, null);
    }

    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i5) {
        startActivityForResult(intent, i5, null);
    }

    @Deprecated
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i5, Intent intent, int i6, int i7, int i8, Bundle bundle) throws IntentSender.SendIntentException {
        Intent intent2 = intent;
        if (this.mHost == null) {
            throw new IllegalStateException(AbstractC0535a.k("Fragment ", this, " not attached to Activity"));
        }
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in startIntentSenderForResult() requestCode: " + i5 + " IntentSender: " + intentSender + " fillInIntent: " + intent + " options: " + bundle);
        }
        T parentFragmentManager = getParentFragmentManager();
        if (parentFragmentManager.f3713v == null) {
            F f5 = parentFragmentManager.f3706o;
            if (i5 == -1) {
                AbstractC0000a.c(f5.f3651c, intentSender, i5, intent, i6, i7, i8, bundle);
                return;
            } else {
                f5.getClass();
                throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
            }
        }
        if (bundle != null) {
            if (intent2 == null) {
                intent2 = new Intent();
                intent2.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
            }
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "ActivityOptions " + bundle + " were added to fillInIntent " + intent2 + " for fragment " + this);
            }
            intent2.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        }
        F3.i.f(intentSender, "intentSender");
        androidx.activity.result.i iVar = new androidx.activity.result.i(intentSender, intent2, i6, i7);
        parentFragmentManager.f3715x.addLast(new O(this.mWho, i5));
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Fragment " + this + "is launching an IntentSender for result ");
        }
        parentFragmentManager.f3713v.a(iVar);
    }

    public void startPostponedEnterTransition() {
        if (this.mAnimationInfo == null || !d().f3889u) {
            return;
        }
        if (this.mHost == null) {
            d().f3889u = false;
        } else if (Looper.myLooper() != this.mHost.f3653e.getLooper()) {
            this.mHost.f3653e.postAtFrontOfQueue(new RunnableC0220o(this, 1));
        } else {
            callStartTransitionListener(true);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} (");
        sb.append(this.mWho);
        if (this.mFragmentId != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.mFragmentId));
        }
        if (this.mTag != null) {
            sb.append(" tag=");
            sb.append(this.mTag);
        }
        sb.append(")");
        return sb.toString();
    }

    public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener(null);
    }

    @Deprecated
    public static Fragment instantiate(Context context, String str, Bundle bundle) {
        try {
            Fragment fragment = (Fragment) L.b(context.getClassLoader(), str).getConstructor(null).newInstance(null);
            if (bundle != null) {
                bundle.setClassLoader(fragment.getClass().getClassLoader());
                fragment.setArguments(bundle);
            }
            return fragment;
        } catch (IllegalAccessException e5) {
            throw new F1.b(AbstractC0535a.l("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e5);
        } catch (InstantiationException e6) {
            throw new F1.b(AbstractC0535a.l("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e6);
        } catch (NoSuchMethodException e7) {
            throw new F1.b(AbstractC0535a.l("Unable to instantiate fragment ", str, ": could not find Fragment constructor"), e7);
        } catch (InvocationTargetException e8) {
            throw new F1.b(AbstractC0535a.l("Unable to instantiate fragment ", str, ": calling Fragment constructor caused an exception"), e8);
        }
    }

    public final String getString(int i5, Object... objArr) {
        return getResources().getString(i5, objArr);
    }

    public final void postponeEnterTransition(long j5, TimeUnit timeUnit) {
        d().f3889u = true;
        T t4 = this.mFragmentManager;
        Handler handler = t4 != null ? t4.f3706o.f3653e : new Handler(Looper.getMainLooper());
        handler.removeCallbacks(this.mPostponedDurationRunnable);
        handler.postDelayed(this.mPostponedDurationRunnable, timeUnit.toMillis(j5));
    }

    public final <I, O> androidx.activity.result.c registerForActivityResult(AbstractC0422a abstractC0422a, androidx.activity.result.g gVar, androidx.activity.result.b bVar) {
        return f(abstractC0422a, new C0222q(3, gVar), bVar);
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent intent, Bundle bundle) {
        F f5 = this.mHost;
        if (f5 == null) {
            throw new IllegalStateException(AbstractC0535a.k("Fragment ", this, " not attached to Activity"));
        }
        C.a.b(f5.f3652d, intent, bundle);
    }

    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i5, Bundle bundle) {
        if (this.mHost == null) {
            throw new IllegalStateException(AbstractC0535a.k("Fragment ", this, " not attached to Activity"));
        }
        T parentFragmentManager = getParentFragmentManager();
        if (parentFragmentManager.f3712u == null) {
            F f5 = parentFragmentManager.f3706o;
            if (i5 == -1) {
                C.a.b(f5.f3652d, intent, bundle);
                return;
            } else {
                f5.getClass();
                throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
            }
        }
        parentFragmentManager.f3715x.addLast(new O(this.mWho, i5));
        if (intent != null && bundle != null) {
            intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        }
        parentFragmentManager.f3712u.a(intent);
    }

    @Deprecated
    public LayoutInflater getLayoutInflater(Bundle bundle) {
        F f5 = this.mHost;
        if (f5 != null) {
            AbstractActivityC0230z abstractActivityC0230z = ((C0229y) f5).g;
            LayoutInflater layoutInflaterCloneInContext = abstractActivityC0230z.getLayoutInflater().cloneInContext(abstractActivityC0230z);
            layoutInflaterCloneInContext.setFactory2(this.mChildFragmentManager.f3700f);
            return layoutInflaterCloneInContext;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    public void onAttach(Activity activity) {
        this.mCalled = true;
    }

    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
    }
}
