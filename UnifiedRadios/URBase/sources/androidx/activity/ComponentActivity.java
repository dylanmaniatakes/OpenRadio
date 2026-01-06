package androidx.activity;

import C0.A;
import O.C0175n;
import O.C0176o;
import O.C0177p;
import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Trace;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.fragment.app.AbstractActivityC0230z;
import androidx.lifecycle.AbstractC0245o;
import androidx.lifecycle.C0241k;
import androidx.lifecycle.C0251v;
import androidx.lifecycle.EnumC0243m;
import androidx.lifecycle.EnumC0244n;
import androidx.lifecycle.InterfaceC0239i;
import androidx.lifecycle.InterfaceC0249t;
import androidx.lifecycle.J;
import androidx.lifecycle.M;
import androidx.lifecycle.N;
import androidx.lifecycle.P;
import androidx.lifecycle.SavedStateHandleAttacher;
import androidx.lifecycle.T;
import androidx.lifecycle.V;
import androidx.lifecycle.W;
import androidx.lifecycle.X;
import c.C0287a;
import c.InterfaceC0288b;
import c0.AbstractC0290b;
import c0.C0289a;
import c0.C0291c;
import com.unified.ur1.R;
import d.AbstractC0422a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class ComponentActivity extends B.i implements X, InterfaceC0239i, o0.e, v, androidx.activity.result.h {
    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    private final androidx.activity.result.g mActivityResultRegistry;
    private int mContentLayoutId;
    private V mDefaultFactory;
    private boolean mDispatchingOnMultiWindowModeChanged;
    private boolean mDispatchingOnPictureInPictureModeChanged;
    final l mFullyDrawnReporter;
    private final C0177p mMenuHostHelper;
    private final AtomicInteger mNextLocalRequestCode;
    private u mOnBackPressedDispatcher;
    private final CopyOnWriteArrayList<N.a> mOnConfigurationChangedListeners;
    private final CopyOnWriteArrayList<N.a> mOnMultiWindowModeChangedListeners;
    private final CopyOnWriteArrayList<N.a> mOnNewIntentListeners;
    private final CopyOnWriteArrayList<N.a> mOnPictureInPictureModeChangedListeners;
    private final CopyOnWriteArrayList<N.a> mOnTrimMemoryListeners;
    final j mReportFullyDrawnExecutor;
    final o0.d mSavedStateRegistryController;
    private W mViewModelStore;
    final C0287a mContextAwareHelper = new C0287a();
    private final C0251v mLifecycleRegistry = new C0251v(this);

    /* JADX WARN: Type inference failed for: r4v0, types: [androidx.activity.d] */
    public ComponentActivity() {
        final AbstractActivityC0230z abstractActivityC0230z = (AbstractActivityC0230z) this;
        this.mMenuHostHelper = new C0177p(new C0.e(7, abstractActivityC0230z));
        o0.d dVar = new o0.d(this);
        this.mSavedStateRegistryController = dVar;
        this.mOnBackPressedDispatcher = null;
        k kVar = new k(abstractActivityC0230z);
        this.mReportFullyDrawnExecutor = kVar;
        this.mFullyDrawnReporter = new l(kVar, new E3.a() { // from class: androidx.activity.d
            @Override // E3.a
            public final Object invoke() {
                abstractActivityC0230z.reportFullyDrawn();
                return null;
            }
        });
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mActivityResultRegistry = new g(abstractActivityC0230z);
        this.mOnConfigurationChangedListeners = new CopyOnWriteArrayList<>();
        this.mOnTrimMemoryListeners = new CopyOnWriteArrayList<>();
        this.mOnNewIntentListeners = new CopyOnWriteArrayList<>();
        this.mOnMultiWindowModeChangedListeners = new CopyOnWriteArrayList<>();
        this.mOnPictureInPictureModeChangedListeners = new CopyOnWriteArrayList<>();
        this.mDispatchingOnMultiWindowModeChanged = false;
        this.mDispatchingOnPictureInPictureModeChanged = false;
        if (getLifecycle() == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        getLifecycle().a(new androidx.lifecycle.r() { // from class: androidx.activity.ComponentActivity.2
            @Override // androidx.lifecycle.r
            public final void a(InterfaceC0249t interfaceC0249t, EnumC0243m enumC0243m) {
                if (enumC0243m == EnumC0243m.ON_STOP) {
                    Window window = abstractActivityC0230z.getWindow();
                    View viewPeekDecorView = window != null ? window.peekDecorView() : null;
                    if (viewPeekDecorView != null) {
                        viewPeekDecorView.cancelPendingInputEvents();
                    }
                }
            }
        });
        getLifecycle().a(new androidx.lifecycle.r() { // from class: androidx.activity.ComponentActivity.3
            @Override // androidx.lifecycle.r
            public final void a(InterfaceC0249t interfaceC0249t, EnumC0243m enumC0243m) {
                if (enumC0243m == EnumC0243m.ON_DESTROY) {
                    abstractActivityC0230z.mContextAwareHelper.f4542b = null;
                    if (!abstractActivityC0230z.isChangingConfigurations()) {
                        abstractActivityC0230z.getViewModelStore().a();
                    }
                    k kVar2 = (k) abstractActivityC0230z.mReportFullyDrawnExecutor;
                    ComponentActivity componentActivity = kVar2.f3235m;
                    componentActivity.getWindow().getDecorView().removeCallbacks(kVar2);
                    componentActivity.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(kVar2);
                }
            }
        });
        getLifecycle().a(new androidx.lifecycle.r() { // from class: androidx.activity.ComponentActivity.4
            @Override // androidx.lifecycle.r
            public final void a(InterfaceC0249t interfaceC0249t, EnumC0243m enumC0243m) {
                ComponentActivity componentActivity = abstractActivityC0230z;
                componentActivity.ensureViewModelStore();
                componentActivity.getLifecycle().b(this);
            }
        });
        dVar.a();
        EnumC0244n enumC0244n = ((C0251v) getLifecycle()).f3971c;
        if (enumC0244n != EnumC0244n.f3962k && enumC0244n != EnumC0244n.f3963l) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (getSavedStateRegistry().b() == null) {
            N n = new N(getSavedStateRegistry(), abstractActivityC0230z);
            getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider", n);
            getLifecycle().a(new SavedStateHandleAttacher(n));
        }
        getSavedStateRegistry().c(ACTIVITY_RESULT_TAG, new e(0, abstractActivityC0230z));
        addOnContextAvailableListener(new InterfaceC0288b() { // from class: androidx.activity.f
            @Override // c.InterfaceC0288b
            public final void a(Context context) {
                ComponentActivity.f(abstractActivityC0230z);
            }
        });
    }

    public static void f(ComponentActivity componentActivity) {
        Bundle bundleA = componentActivity.getSavedStateRegistry().a(ACTIVITY_RESULT_TAG);
        if (bundleA != null) {
            androidx.activity.result.g gVar = componentActivity.mActivityResultRegistry;
            gVar.getClass();
            ArrayList<Integer> integerArrayList = bundleA.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
            ArrayList<String> stringArrayList = bundleA.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
            if (stringArrayList == null || integerArrayList == null) {
                return;
            }
            gVar.f3268d = bundleA.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
            Bundle bundle = bundleA.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT");
            Bundle bundle2 = gVar.g;
            bundle2.putAll(bundle);
            for (int i5 = 0; i5 < stringArrayList.size(); i5++) {
                String str = stringArrayList.get(i5);
                HashMap map = gVar.f3266b;
                boolean zContainsKey = map.containsKey(str);
                HashMap map2 = gVar.f3265a;
                if (zContainsKey) {
                    Integer num = (Integer) map.remove(str);
                    if (!bundle2.containsKey(str)) {
                        map2.remove(num);
                    }
                }
                Integer num2 = integerArrayList.get(i5);
                num2.intValue();
                String str2 = stringArrayList.get(i5);
                map2.put(num2, str2);
                map.put(str2, num2);
            }
        }
    }

    public static Bundle g(AbstractActivityC0230z abstractActivityC0230z) {
        Bundle bundle = new Bundle();
        androidx.activity.result.g gVar = ((ComponentActivity) abstractActivityC0230z).mActivityResultRegistry;
        gVar.getClass();
        HashMap map = gVar.f3266b;
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(map.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(map.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(gVar.f3268d));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) gVar.g.clone());
        return bundle;
    }

    public void addMenuProvider(O.r rVar) {
        C0177p c0177p = this.mMenuHostHelper;
        c0177p.f1949b.add(null);
        c0177p.f1948a.run();
    }

    public final void addOnConfigurationChangedListener(N.a aVar) {
        this.mOnConfigurationChangedListeners.add(aVar);
    }

    public final void addOnContextAvailableListener(InterfaceC0288b interfaceC0288b) {
        C0287a c0287a = this.mContextAwareHelper;
        c0287a.getClass();
        F3.i.f(interfaceC0288b, "listener");
        Context context = c0287a.f4542b;
        if (context != null) {
            interfaceC0288b.a(context);
        }
        c0287a.f4541a.add(interfaceC0288b);
    }

    public final void addOnMultiWindowModeChangedListener(N.a aVar) {
        this.mOnMultiWindowModeChangedListeners.add(aVar);
    }

    public final void addOnNewIntentListener(N.a aVar) {
        this.mOnNewIntentListeners.add(aVar);
    }

    public final void addOnPictureInPictureModeChangedListener(N.a aVar) {
        this.mOnPictureInPictureModeChangedListeners.add(aVar);
    }

    public final void addOnTrimMemoryListener(N.a aVar) {
        this.mOnTrimMemoryListeners.add(aVar);
    }

    public void ensureViewModelStore() {
        if (this.mViewModelStore == null) {
            i iVar = (i) getLastNonConfigurationInstance();
            if (iVar != null) {
                this.mViewModelStore = iVar.f3231b;
            }
            if (this.mViewModelStore == null) {
                this.mViewModelStore = new W();
            }
        }
    }

    @Override // androidx.activity.result.h
    public final androidx.activity.result.g getActivityResultRegistry() {
        return this.mActivityResultRegistry;
    }

    @Override // androidx.lifecycle.InterfaceC0239i
    public AbstractC0290b getDefaultViewModelCreationExtras() {
        C0291c c0291c = new C0291c(C0289a.f4543b);
        Application application = getApplication();
        LinkedHashMap linkedHashMap = c0291c.f4544a;
        if (application != null) {
            linkedHashMap.put(T.f3947c, getApplication());
        }
        linkedHashMap.put(M.f3924a, this);
        linkedHashMap.put(M.f3925b, this);
        if (getIntent() != null && getIntent().getExtras() != null) {
            linkedHashMap.put(M.f3926c, getIntent().getExtras());
        }
        return c0291c;
    }

    @Override // androidx.lifecycle.InterfaceC0239i
    public V getDefaultViewModelProviderFactory() {
        if (this.mDefaultFactory == null) {
            this.mDefaultFactory = new P(getApplication(), this, getIntent() != null ? getIntent().getExtras() : null);
        }
        return this.mDefaultFactory;
    }

    public l getFullyDrawnReporter() {
        return this.mFullyDrawnReporter;
    }

    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        i iVar = (i) getLastNonConfigurationInstance();
        if (iVar != null) {
            return iVar.f3230a;
        }
        return null;
    }

    @Override // androidx.lifecycle.InterfaceC0249t
    public AbstractC0245o getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // androidx.activity.v
    public final u getOnBackPressedDispatcher() {
        if (this.mOnBackPressedDispatcher == null) {
            this.mOnBackPressedDispatcher = new u(new A(13, this));
            getLifecycle().a(new androidx.lifecycle.r() { // from class: androidx.activity.ComponentActivity.6
                @Override // androidx.lifecycle.r
                public final void a(InterfaceC0249t interfaceC0249t, EnumC0243m enumC0243m) {
                    if (enumC0243m != EnumC0243m.ON_CREATE || Build.VERSION.SDK_INT < 33) {
                        return;
                    }
                    u uVar = ComponentActivity.this.mOnBackPressedDispatcher;
                    OnBackInvokedDispatcher onBackInvokedDispatcherA = h.a((ComponentActivity) interfaceC0249t);
                    uVar.getClass();
                    F3.i.f(onBackInvokedDispatcherA, "invoker");
                    uVar.f3282e = onBackInvokedDispatcherA;
                    uVar.c(uVar.g);
                }
            });
        }
        return this.mOnBackPressedDispatcher;
    }

    @Override // o0.e
    public final o0.c getSavedStateRegistry() {
        return this.mSavedStateRegistryController.f8893b;
    }

    @Override // androidx.lifecycle.X
    public W getViewModelStore() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        ensureViewModelStore();
        return this.mViewModelStore;
    }

    public void initializeViewTreeOwners() {
        View decorView = getWindow().getDecorView();
        F3.i.f(decorView, "<this>");
        decorView.setTag(R.id.view_tree_lifecycle_owner, this);
        View decorView2 = getWindow().getDecorView();
        F3.i.f(decorView2, "<this>");
        decorView2.setTag(R.id.view_tree_view_model_store_owner, this);
        View decorView3 = getWindow().getDecorView();
        F3.i.f(decorView3, "<this>");
        decorView3.setTag(R.id.view_tree_saved_state_registry_owner, this);
        View decorView4 = getWindow().getDecorView();
        F3.i.f(decorView4, "<this>");
        decorView4.setTag(R.id.view_tree_on_back_pressed_dispatcher_owner, this);
        View decorView5 = getWindow().getDecorView();
        F3.i.f(decorView5, "<this>");
        decorView5.setTag(R.id.report_drawn, this);
    }

    public void invalidateMenu() {
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i5, int i6, Intent intent) {
        if (this.mActivityResultRegistry.a(i5, i6, intent)) {
            return;
        }
        super.onActivityResult(i5, i6, intent);
    }

    @Override // android.app.Activity
    @Deprecated
    public void onBackPressed() {
        getOnBackPressedDispatcher().b();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Iterator<N.a> it = this.mOnConfigurationChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().a(configuration);
        }
    }

    @Override // B.i, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.mSavedStateRegistryController.b(bundle);
        C0287a c0287a = this.mContextAwareHelper;
        c0287a.getClass();
        c0287a.f4542b = this;
        Iterator it = c0287a.f4541a.iterator();
        while (it.hasNext()) {
            ((InterfaceC0288b) it.next()).a(this);
        }
        super.onCreate(bundle);
        int i5 = J.f3913d;
        M.f(this);
        int i6 = this.mContentLayoutId;
        if (i6 != 0) {
            setContentView(i6);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i5, Menu menu) {
        if (i5 != 0) {
            return true;
        }
        super.onCreatePanelMenu(i5, menu);
        C0177p c0177p = this.mMenuHostHelper;
        getMenuInflater();
        Iterator it = c0177p.f1949b.iterator();
        if (!it.hasNext()) {
            return true;
        }
        com.unified.ur1.SatelliteTracker.h.p(it.next());
        throw null;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i5, MenuItem menuItem) {
        if (super.onMenuItemSelected(i5, menuItem)) {
            return true;
        }
        if (i5 != 0) {
            return false;
        }
        Iterator it = this.mMenuHostHelper.f1949b.iterator();
        if (!it.hasNext()) {
            return false;
        }
        com.unified.ur1.SatelliteTracker.h.p(it.next());
        throw null;
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z4, Configuration configuration) {
        this.mDispatchingOnMultiWindowModeChanged = true;
        try {
            super.onMultiWindowModeChanged(z4, configuration);
            this.mDispatchingOnMultiWindowModeChanged = false;
            Iterator<N.a> it = this.mOnMultiWindowModeChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().a(new O2.e(1));
            }
        } catch (Throwable th) {
            this.mDispatchingOnMultiWindowModeChanged = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Iterator<N.a> it = this.mOnNewIntentListeners.iterator();
        while (it.hasNext()) {
            it.next().a(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i5, Menu menu) {
        Iterator it = this.mMenuHostHelper.f1949b.iterator();
        if (it.hasNext()) {
            com.unified.ur1.SatelliteTracker.h.p(it.next());
            throw null;
        }
        super.onPanelClosed(i5, menu);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z4, Configuration configuration) {
        this.mDispatchingOnPictureInPictureModeChanged = true;
        try {
            super.onPictureInPictureModeChanged(z4, configuration);
            this.mDispatchingOnPictureInPictureModeChanged = false;
            Iterator<N.a> it = this.mOnPictureInPictureModeChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().a(new n2.e(1));
            }
        } catch (Throwable th) {
            this.mDispatchingOnPictureInPictureModeChanged = false;
            throw th;
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i5, View view, Menu menu) {
        if (i5 != 0) {
            return true;
        }
        super.onPreparePanel(i5, view, menu);
        Iterator it = this.mMenuHostHelper.f1949b.iterator();
        if (!it.hasNext()) {
            return true;
        }
        com.unified.ur1.SatelliteTracker.h.p(it.next());
        throw null;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i5, String[] strArr, int[] iArr) {
        if (this.mActivityResultRegistry.a(i5, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr))) {
            return;
        }
        super.onRequestPermissionsResult(i5, strArr, iArr);
    }

    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        i iVar;
        Object objOnRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        W w4 = this.mViewModelStore;
        if (w4 == null && (iVar = (i) getLastNonConfigurationInstance()) != null) {
            w4 = iVar.f3231b;
        }
        if (w4 == null && objOnRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        i iVar2 = new i();
        iVar2.f3230a = objOnRetainCustomNonConfigurationInstance;
        iVar2.f3231b = w4;
        return iVar2;
    }

    @Override // B.i, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        AbstractC0245o lifecycle = getLifecycle();
        if (lifecycle instanceof C0251v) {
            ((C0251v) lifecycle).g();
        }
        super.onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.c(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i5) {
        super.onTrimMemory(i5);
        Iterator<N.a> it = this.mOnTrimMemoryListeners.iterator();
        while (it.hasNext()) {
            it.next().a(Integer.valueOf(i5));
        }
    }

    public Context peekAvailableContext() {
        return this.mContextAwareHelper.f4542b;
    }

    public final <I, O> androidx.activity.result.c registerForActivityResult(AbstractC0422a abstractC0422a, androidx.activity.result.g gVar, androidx.activity.result.b bVar) {
        return gVar.c("activity_rq#" + this.mNextLocalRequestCode.getAndIncrement(), this, abstractC0422a, bVar);
    }

    public void removeMenuProvider(O.r rVar) {
        this.mMenuHostHelper.a();
    }

    public final void removeOnConfigurationChangedListener(N.a aVar) {
        this.mOnConfigurationChangedListeners.remove(aVar);
    }

    public final void removeOnContextAvailableListener(InterfaceC0288b interfaceC0288b) {
        C0287a c0287a = this.mContextAwareHelper;
        c0287a.getClass();
        F3.i.f(interfaceC0288b, "listener");
        c0287a.f4541a.remove(interfaceC0288b);
    }

    public final void removeOnMultiWindowModeChangedListener(N.a aVar) {
        this.mOnMultiWindowModeChangedListeners.remove(aVar);
    }

    public final void removeOnNewIntentListener(N.a aVar) {
        this.mOnNewIntentListeners.remove(aVar);
    }

    public final void removeOnPictureInPictureModeChangedListener(N.a aVar) {
        this.mOnPictureInPictureModeChangedListeners.remove(aVar);
    }

    public final void removeOnTrimMemoryListener(N.a aVar) {
        this.mOnTrimMemoryListeners.remove(aVar);
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        try {
            if (h4.f.j()) {
                Trace.beginSection("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
            l lVar = this.mFullyDrawnReporter;
            synchronized (lVar.f3236a) {
                try {
                    lVar.f3237b = true;
                    Iterator it = lVar.f3238c.iterator();
                    while (it.hasNext()) {
                        ((E3.a) it.next()).invoke();
                    }
                    lVar.f3238c.clear();
                } finally {
                }
            }
            Trace.endSection();
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    @Override // android.app.Activity
    public abstract void setContentView(int i5);

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.s(getWindow().getDecorView());
        super.setContentView(view);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(Intent intent, int i5) {
        super.startActivityForResult(intent, i5);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i5, Intent intent, int i6, int i7, int i8) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i5, intent, i6, i7, i8);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(Intent intent, int i5, Bundle bundle) {
        super.startActivityForResult(intent, i5, bundle);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i5, Intent intent, int i6, int i7, int i8, Bundle bundle) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i5, intent, i6, i7, i8, bundle);
    }

    public final <I, O> androidx.activity.result.c registerForActivityResult(AbstractC0422a abstractC0422a, androidx.activity.result.b bVar) {
        return registerForActivityResult(abstractC0422a, this.mActivityResultRegistry, bVar);
    }

    public void addMenuProvider(O.r rVar, InterfaceC0249t interfaceC0249t) {
        C0177p c0177p = this.mMenuHostHelper;
        c0177p.f1949b.add(null);
        c0177p.f1948a.run();
        AbstractC0245o lifecycle = interfaceC0249t.getLifecycle();
        HashMap map = c0177p.f1950c;
        C0176o c0176o = (C0176o) map.remove(rVar);
        if (c0176o != null) {
            c0176o.f1946a.b(c0176o.f1947b);
            c0176o.f1947b = null;
        }
        map.put(rVar, new C0176o(lifecycle, new C0175n(0, c0177p)));
    }

    @SuppressLint({"LambdaLast"})
    public void addMenuProvider(O.r rVar, InterfaceC0249t interfaceC0249t, final EnumC0244n enumC0244n) {
        final C0177p c0177p = this.mMenuHostHelper;
        c0177p.getClass();
        AbstractC0245o lifecycle = interfaceC0249t.getLifecycle();
        HashMap map = c0177p.f1950c;
        C0176o c0176o = (C0176o) map.remove(rVar);
        if (c0176o != null) {
            c0176o.f1946a.b(c0176o.f1947b);
            c0176o.f1947b = null;
        }
        map.put(rVar, new C0176o(lifecycle, new androidx.lifecycle.r() { // from class: O.m
            @Override // androidx.lifecycle.r
            public final void a(InterfaceC0249t interfaceC0249t2, EnumC0243m enumC0243m) {
                C0177p c0177p2 = c0177p;
                c0177p2.getClass();
                EnumC0243m.Companion.getClass();
                EnumC0244n enumC0244n2 = enumC0244n;
                F3.i.f(enumC0244n2, "state");
                int iOrdinal = enumC0244n2.ordinal();
                EnumC0243m enumC0243m2 = iOrdinal != 2 ? iOrdinal != 3 ? iOrdinal != 4 ? null : EnumC0243m.ON_RESUME : EnumC0243m.ON_START : EnumC0243m.ON_CREATE;
                Runnable runnable = c0177p2.f1948a;
                CopyOnWriteArrayList copyOnWriteArrayList = c0177p2.f1949b;
                if (enumC0243m == enumC0243m2) {
                    copyOnWriteArrayList.add(null);
                    runnable.run();
                } else if (enumC0243m == EnumC0243m.ON_DESTROY) {
                    c0177p2.a();
                } else if (enumC0243m == C0241k.a(enumC0244n2)) {
                    copyOnWriteArrayList.remove((Object) null);
                    runnable.run();
                }
            }
        }));
    }
}
