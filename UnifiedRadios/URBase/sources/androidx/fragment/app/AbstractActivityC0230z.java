package androidx.fragment.app;

import B.AbstractC0000a;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.C0251v;
import androidx.lifecycle.EnumC0243m;
import androidx.lifecycle.EnumC0244n;
import d0.AbstractC0423a;
import f.AbstractActivityC0472i;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: androidx.fragment.app.z, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractActivityC0230z extends ComponentActivity implements B.d {
    static final String FRAGMENTS_TAG = "android:support:fragments";
    boolean mCreated;
    final E mFragments;
    boolean mResumed;
    final C0251v mFragmentLifecycleRegistry = new C0251v(this);
    boolean mStopped = true;

    public AbstractActivityC0230z() {
        AbstractActivityC0472i abstractActivityC0472i = (AbstractActivityC0472i) this;
        this.mFragments = new E(new C0229y(abstractActivityC0472i));
        getSavedStateRegistry().c(FRAGMENTS_TAG, new C0227w(abstractActivityC0472i));
        addOnContextAvailableListener(new C0228x(abstractActivityC0472i));
    }

    public static boolean h(T t4) {
        boolean zH = false;
        for (Fragment fragment : t4.f3697c.f()) {
            if (fragment != null) {
                if (fragment.getHost() != null) {
                    zH |= h(fragment.getChildFragmentManager());
                }
                m0 m0Var = fragment.mViewLifecycleOwner;
                EnumC0244n enumC0244n = EnumC0244n.f3964m;
                if (m0Var != null) {
                    m0Var.b();
                    if (m0Var.f3836f.f3971c.compareTo(enumC0244n) >= 0) {
                        fragment.mViewLifecycleOwner.f3836f.g();
                        zH = true;
                    }
                }
                if (fragment.mLifecycleRegistry.f3971c.compareTo(enumC0244n) >= 0) {
                    fragment.mLifecycleRegistry.g();
                    zH = true;
                }
            }
        }
        return zH;
    }

    public final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mFragments.f3650a.f3654f.f3700f.onCreateView(view, str, context, attributeSet);
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.mCreated);
        printWriter.print(" mResumed=");
        printWriter.print(this.mResumed);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        if (getApplication() != null) {
            AbstractC0423a.a(this).b(str2, printWriter);
        }
        this.mFragments.f3650a.f3654f.p(str, fileDescriptor, printWriter, strArr);
    }

    public T getSupportFragmentManager() {
        return this.mFragments.f3650a.f3654f;
    }

    @Deprecated
    public AbstractC0423a getSupportLoaderManager() {
        return AbstractC0423a.a(this);
    }

    public void markFragmentsCreated() {
        while (h(getSupportFragmentManager())) {
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i5, int i6, Intent intent) {
        this.mFragments.a();
        super.onActivityResult(i5, i6, intent);
    }

    @Deprecated
    public void onAttachFragment(Fragment fragment) {
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.mFragments.a();
        super.onConfigurationChanged(configuration);
        for (Fragment fragment : this.mFragments.f3650a.f3654f.f3697c.f()) {
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, B.i, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mFragmentLifecycleRegistry.e(EnumC0243m.ON_CREATE);
        U u4 = this.mFragments.f3650a.f3654f;
        u4.f3717z = false;
        u4.f3687A = false;
        u4.f3693G.f3729i = false;
        u4.o(1);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i5, Menu menu) {
        if (i5 != 0) {
            super.onCreatePanelMenu(i5, menu);
            return true;
        }
        super.onCreatePanelMenu(i5, menu);
        E e5 = this.mFragments;
        e5.f3650a.f3654f.i(menu, getMenuInflater());
        return true;
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View viewDispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view, str, context, attributeSet);
        return viewDispatchFragmentsOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : viewDispatchFragmentsOnCreateView;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mFragments.f3650a.f3654f.j();
        this.mFragmentLifecycleRegistry.e(EnumC0243m.ON_DESTROY);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        for (Fragment fragment : this.mFragments.f3650a.f3654f.f3697c.f()) {
            if (fragment != null) {
                fragment.performLowMemory();
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i5, MenuItem menuItem) {
        if (super.onMenuItemSelected(i5, menuItem)) {
            return true;
        }
        if (i5 == 0) {
            return this.mFragments.f3650a.f3654f.k(menuItem);
        }
        if (i5 != 6) {
            return false;
        }
        return this.mFragments.f3650a.f3654f.h(menuItem);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z4) {
        for (Fragment fragment : this.mFragments.f3650a.f3654f.f3697c.f()) {
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z4);
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(@SuppressLint({"UnknownNullness"}) Intent intent) {
        this.mFragments.a();
        super.onNewIntent(intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i5, Menu menu) {
        if (i5 == 0) {
            this.mFragments.f3650a.f3654f.l(menu);
        }
        super.onPanelClosed(i5, menu);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.f3650a.f3654f.o(5);
        this.mFragmentLifecycleRegistry.e(EnumC0243m.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z4) {
        for (Fragment fragment : this.mFragments.f3650a.f3654f.f3697c.f()) {
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z4);
            }
        }
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    @Deprecated
    public boolean onPrepareOptionsPanel(View view, Menu menu) {
        super.onPreparePanel(0, view, menu);
        return true;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i5, View view, Menu menu) {
        if (i5 == 0) {
            return onPrepareOptionsPanel(view, menu) | this.mFragments.f3650a.f3654f.n(menu);
        }
        super.onPreparePanel(i5, view, menu);
        return true;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i5, String[] strArr, int[] iArr) {
        this.mFragments.a();
        super.onRequestPermissionsResult(i5, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onResume() {
        this.mFragments.a();
        super.onResume();
        this.mResumed = true;
        this.mFragments.f3650a.f3654f.s(true);
    }

    public void onResumeFragments() {
        this.mFragmentLifecycleRegistry.e(EnumC0243m.ON_RESUME);
        U u4 = this.mFragments.f3650a.f3654f;
        u4.f3717z = false;
        u4.f3687A = false;
        u4.f3693G.f3729i = false;
        u4.o(7);
    }

    @Override // android.app.Activity
    public void onStart() {
        this.mFragments.a();
        super.onStart();
        this.mStopped = false;
        if (!this.mCreated) {
            this.mCreated = true;
            U u4 = this.mFragments.f3650a.f3654f;
            u4.f3717z = false;
            u4.f3687A = false;
            u4.f3693G.f3729i = false;
            u4.o(4);
        }
        this.mFragments.f3650a.f3654f.s(true);
        this.mFragmentLifecycleRegistry.e(EnumC0243m.ON_START);
        U u5 = this.mFragments.f3650a.f3654f;
        u5.f3717z = false;
        u5.f3687A = false;
        u5.f3693G.f3729i = false;
        u5.o(5);
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.mFragments.a();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        U u4 = this.mFragments.f3650a.f3654f;
        u4.f3687A = true;
        u4.f3693G.f3729i = true;
        u4.o(4);
        this.mFragmentLifecycleRegistry.e(EnumC0243m.ON_STOP);
    }

    public void setEnterSharedElementCallback(B.y yVar) {
        B.b.c(this, null);
    }

    public void setExitSharedElementCallback(B.y yVar) {
        B.b.d(this, null);
    }

    public void startActivityFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i5, Bundle bundle) {
        if (i5 == -1) {
            AbstractC0000a.b(this, intent, -1, bundle);
        } else {
            fragment.startActivityForResult(intent, i5, bundle);
        }
    }

    @Deprecated
    public void startIntentSenderFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i5, Intent intent, int i6, int i7, int i8, Bundle bundle) throws IntentSender.SendIntentException {
        if (i5 == -1) {
            AbstractC0000a.c(this, intentSender, i5, intent, i6, i7, i8, bundle);
        } else {
            fragment.startIntentSenderForResult(intentSender, i5, intent, i6, i7, i8, bundle);
        }
    }

    public void supportFinishAfterTransition() {
        B.b.a(this);
    }

    public abstract void supportInvalidateOptionsMenu();

    public void supportPostponeEnterTransition() {
        B.b.b(this);
    }

    public void supportStartPostponedEnterTransition() {
        B.b.e(this);
    }

    @Override // B.d
    @Deprecated
    public final void validateRequestPermissionsRequestCode(int i5) {
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View viewDispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(null, str, context, attributeSet);
        return viewDispatchFragmentsOnCreateView == null ? super.onCreateView(str, context, attributeSet) : viewDispatchFragmentsOnCreateView;
    }

    public void startActivityFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i5) {
        startActivityFromFragment(fragment, intent, i5, (Bundle) null);
    }
}
