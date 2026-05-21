package f;

import B.AbstractC0000a;
import android.R;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.AbstractActivityC0230z;
import java.util.ArrayList;
import k.G0;
import k.h1;

/* renamed from: f.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractActivityC0472i extends AbstractActivityC0230z implements j, B.z {
    private static final String DELEGATE_TAG = "androidx:appcompat";
    private n mDelegate;
    private Resources mResources;

    public AbstractActivityC0472i() {
        getSavedStateRegistry().c(DELEGATE_TAG, new C0470g(this));
        addOnContextAvailableListener(new C0471h(this));
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        i();
        x xVar = (x) getDelegate();
        xVar.x();
        ((ViewGroup) xVar.f6390C.findViewById(R.id.content)).addView(view, layoutParams);
        xVar.f6424o.a(xVar.n.getCallback());
    }

    /* JADX WARN: Removed duplicated region for block: B:167:0x0215 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void attachBaseContext(android.content.Context r11) {
        /*
            Method dump skipped, instructions count: 558
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f.AbstractActivityC0472i.attachBaseContext(android.content.Context):void");
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        AbstractC0464a supportActionBar = getSupportActionBar();
        if (getWindow().hasFeature(0)) {
            if (supportActionBar == null || !supportActionBar.a()) {
                super.closeOptionsMenu();
            }
        }
    }

    @Override // B.i, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        AbstractC0464a supportActionBar = getSupportActionBar();
        if (keyCode == 82 && supportActionBar != null && supportActionBar.k(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i5) {
        x xVar = (x) getDelegate();
        xVar.x();
        return (T) xVar.n.findViewById(i5);
    }

    public n getDelegate() {
        if (this.mDelegate == null) {
            M0.m mVar = n.f6350c;
            this.mDelegate = new x(this, null, this, this);
        }
        return this.mDelegate;
    }

    public InterfaceC0465b getDrawerToggleDelegate() {
        ((x) getDelegate()).getClass();
        return new J1.D(27);
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        x xVar = (x) getDelegate();
        if (xVar.f6427r == null) {
            xVar.B();
            AbstractC0464a abstractC0464a = xVar.f6426q;
            xVar.f6427r = new i.j(abstractC0464a != null ? abstractC0464a.e() : xVar.f6423m);
        }
        return xVar.f6427r;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources resources = this.mResources;
        if (resources == null) {
            int i5 = h1.f7784a;
        }
        return resources == null ? super.getResources() : resources;
    }

    public AbstractC0464a getSupportActionBar() {
        x xVar = (x) getDelegate();
        xVar.B();
        return xVar.f6426q;
    }

    @Override // B.z
    public Intent getSupportParentActivityIntent() {
        return A2.b.j(this);
    }

    public final void i() {
        View decorView = getWindow().getDecorView();
        F3.i.f(decorView, "<this>");
        decorView.setTag(com.unified.ur1.R.id.view_tree_lifecycle_owner, this);
        View decorView2 = getWindow().getDecorView();
        F3.i.f(decorView2, "<this>");
        decorView2.setTag(com.unified.ur1.R.id.view_tree_view_model_store_owner, this);
        View decorView3 = getWindow().getDecorView();
        F3.i.f(decorView3, "<this>");
        decorView3.setTag(com.unified.ur1.R.id.view_tree_saved_state_registry_owner, this);
        View decorView4 = getWindow().getDecorView();
        F3.i.f(decorView4, "<this>");
        decorView4.setTag(com.unified.ur1.R.id.view_tree_on_back_pressed_dispatcher_owner, this);
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        getDelegate().b();
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        x xVar = (x) getDelegate();
        if (xVar.f6395H && xVar.f6389B) {
            xVar.B();
            AbstractC0464a abstractC0464a = xVar.f6426q;
            if (abstractC0464a != null) {
                abstractC0464a.h();
            }
        }
        k.r rVarA = k.r.a();
        Context context = xVar.f6423m;
        synchronized (rVarA) {
            G0 g02 = rVarA.f7855a;
            synchronized (g02) {
                q.e eVar = (q.e) g02.f7650b.get(context);
                if (eVar != null) {
                    eVar.a();
                }
            }
        }
        xVar.f6406T = new Configuration(xVar.f6423m.getResources().getConfiguration());
        xVar.o(false, false);
        if (this.mResources != null) {
            this.mResources.updateConfiguration(super.getResources().getConfiguration(), super.getResources().getDisplayMetrics());
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        onSupportContentChanged();
    }

    public void onCreateSupportNavigateUpTaskStack(B.A a2) {
        a2.getClass();
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            supportParentActivityIntent = A2.b.j(this);
        }
        if (supportParentActivityIntent != null) {
            ComponentName component = supportParentActivityIntent.getComponent();
            Context context = a2.f46k;
            if (component == null) {
                component = supportParentActivityIntent.resolveActivity(context.getPackageManager());
            }
            ArrayList arrayList = a2.f45j;
            int size = arrayList.size();
            try {
                for (Intent intentK = A2.b.k(context, component); intentK != null; intentK = A2.b.k(context, intentK.getComponent())) {
                    arrayList.add(size, intentK);
                }
                arrayList.add(supportParentActivityIntent);
            } catch (PackageManager.NameNotFoundException e5) {
                Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
                throw new IllegalArgumentException(e5);
            }
        }
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        getDelegate().f();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i5, KeyEvent keyEvent) {
        return super.onKeyDown(i5, keyEvent);
    }

    public void onLocalesChanged(K.i iVar) {
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i5, MenuItem menuItem) {
        if (super.onMenuItemSelected(i5, menuItem)) {
            return true;
        }
        AbstractC0464a supportActionBar = getSupportActionBar();
        if (menuItem.getItemId() != 16908332 || supportActionBar == null || (supportActionBar.d() & 4) == 0) {
            return false;
        }
        return onSupportNavigateUp();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i5, Menu menu) {
        return super.onMenuOpened(i5, menu);
    }

    public void onNightModeChanged(int i5) {
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i5, Menu menu) {
        super.onPanelClosed(i5, menu);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        ((x) getDelegate()).x();
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        x xVar = (x) getDelegate();
        xVar.B();
        AbstractC0464a abstractC0464a = xVar.f6426q;
        if (abstractC0464a != null) {
            abstractC0464a.o(true);
        }
    }

    public void onPrepareSupportNavigateUpTaskStack(B.A a2) {
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, android.app.Activity
    public void onStart() {
        super.onStart();
        ((x) getDelegate()).o(true, false);
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, android.app.Activity
    public void onStop() {
        super.onStop();
        x xVar = (x) getDelegate();
        xVar.B();
        AbstractC0464a abstractC0464a = xVar.f6426q;
        if (abstractC0464a != null) {
            abstractC0464a.o(false);
        }
    }

    @Override // f.j
    public void onSupportActionModeFinished(i.b bVar) {
    }

    @Override // f.j
    public void onSupportActionModeStarted(i.b bVar) {
    }

    @Deprecated
    public void onSupportContentChanged() {
    }

    public boolean onSupportNavigateUp() {
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            return false;
        }
        if (!supportShouldUpRecreateTask(supportParentActivityIntent)) {
            supportNavigateUpTo(supportParentActivityIntent);
            return true;
        }
        B.A a2 = new B.A(this);
        onCreateSupportNavigateUpTaskStack(a2);
        onPrepareSupportNavigateUpTaskStack(a2);
        ArrayList arrayList = a2.f45j;
        if (arrayList.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[0]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        C.a.a(a2.f46k, intentArr, null);
        try {
            AbstractC0000a.a(this);
            return true;
        } catch (IllegalStateException unused) {
            finish();
            return true;
        }
    }

    @Override // android.app.Activity
    public void onTitleChanged(CharSequence charSequence, int i5) {
        super.onTitleChanged(charSequence, i5);
        getDelegate().m(charSequence);
    }

    @Override // f.j
    public i.b onWindowStartingSupportActionMode(i.a aVar) {
        return null;
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        AbstractC0464a supportActionBar = getSupportActionBar();
        if (getWindow().hasFeature(0)) {
            if (supportActionBar == null || !supportActionBar.l()) {
                super.openOptionsMenu();
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i5) {
        i();
        getDelegate().j(i5);
    }

    public void setSupportActionBar(Toolbar toolbar) {
        x xVar = (x) getDelegate();
        if (xVar.f6422l instanceof Activity) {
            xVar.B();
            AbstractC0464a abstractC0464a = xVar.f6426q;
            if (abstractC0464a instanceof C0463I) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            xVar.f6427r = null;
            if (abstractC0464a != null) {
                abstractC0464a.i();
            }
            xVar.f6426q = null;
            if (toolbar != null) {
                Object obj = xVar.f6422l;
                C0458D c0458d = new C0458D(toolbar, obj instanceof Activity ? ((Activity) obj).getTitle() : xVar.f6428s, xVar.f6424o);
                xVar.f6426q = c0458d;
                xVar.f6424o.f6362d = c0458d.f6248c;
                toolbar.setBackInvokedCallbackEnabled(true);
            } else {
                xVar.f6424o.f6362d = null;
            }
            xVar.b();
        }
    }

    @Deprecated
    public void setSupportProgress(int i5) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminate(boolean z4) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminateVisibility(boolean z4) {
    }

    @Deprecated
    public void setSupportProgressBarVisibility(boolean z4) {
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i5) {
        super.setTheme(i5);
        ((x) getDelegate()).f6408V = i5;
    }

    public i.b startSupportActionMode(i.a aVar) {
        return getDelegate().n(aVar);
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z
    public void supportInvalidateOptionsMenu() {
        getDelegate().b();
    }

    public void supportNavigateUpTo(Intent intent) {
        B.m.b(this, intent);
    }

    public boolean supportRequestWindowFeature(int i5) {
        return getDelegate().i(i5);
    }

    public boolean supportShouldUpRecreateTask(Intent intent) {
        return B.m.c(this, intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        i();
        getDelegate().k(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        i();
        getDelegate().l(view, layoutParams);
    }
}
