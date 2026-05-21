package f;

import android.content.Context;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class s implements Window.Callback {

    /* renamed from: c, reason: collision with root package name */
    public final Window.Callback f6361c;

    /* renamed from: d, reason: collision with root package name */
    public Z2.c f6362d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f6363e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f6364f;
    public boolean g;
    public final /* synthetic */ x h;

    public s(x xVar, Window.Callback callback) {
        this.h = xVar;
        if (callback == null) {
            throw new IllegalArgumentException("Window callback may not be null");
        }
        this.f6361c = callback;
    }

    public final void a(Window.Callback callback) {
        try {
            this.f6363e = true;
            callback.onContentChanged();
        } finally {
            this.f6363e = false;
        }
    }

    public final boolean b(int i5, Menu menu) {
        return this.f6361c.onMenuOpened(i5, menu);
    }

    public final void c(int i5, Menu menu) {
        this.f6361c.onPanelClosed(i5, menu);
    }

    public final void d(List list, Menu menu, int i5) {
        i.n.a(this.f6361c, list, menu, i5);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.f6361c.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean z4 = this.f6364f;
        Window.Callback callback = this.f6361c;
        return z4 ? callback.dispatchKeyEvent(keyEvent) : this.h.v(keyEvent) || callback.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        if (this.f6361c.dispatchKeyShortcutEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        x xVar = this.h;
        xVar.B();
        AbstractC0464a abstractC0464a = xVar.f6426q;
        if (abstractC0464a != null && abstractC0464a.j(keyCode, keyEvent)) {
            return true;
        }
        w wVar = xVar.f6401O;
        if (wVar != null && xVar.G(wVar, keyEvent.getKeyCode(), keyEvent)) {
            w wVar2 = xVar.f6401O;
            if (wVar2 == null) {
                return true;
            }
            wVar2.f6380l = true;
            return true;
        }
        if (xVar.f6401O == null) {
            w wVarA = xVar.A(0);
            xVar.H(wVarA, keyEvent);
            boolean zG = xVar.G(wVarA, keyEvent.getKeyCode(), keyEvent);
            wVarA.f6379k = false;
            if (zG) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.f6361c.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f6361c.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.f6361c.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeFinished(ActionMode actionMode) {
        this.f6361c.onActionModeFinished(actionMode);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeStarted(ActionMode actionMode) {
        this.f6361c.onActionModeStarted(actionMode);
    }

    @Override // android.view.Window.Callback
    public final void onAttachedToWindow() {
        this.f6361c.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public final void onContentChanged() {
        if (this.f6363e) {
            this.f6361c.onContentChanged();
        }
    }

    @Override // android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i5, Menu menu) {
        if (i5 != 0 || (menu instanceof j.m)) {
            return this.f6361c.onCreatePanelMenu(i5, menu);
        }
        return false;
    }

    @Override // android.view.Window.Callback
    public final View onCreatePanelView(int i5) {
        Z2.c cVar = this.f6362d;
        if (cVar != null) {
            View view = i5 == 0 ? new View(((C0458D) cVar.f3147d).f6246a.f7769a.getContext()) : null;
            if (view != null) {
                return view;
            }
        }
        return this.f6361c.onCreatePanelView(i5);
    }

    @Override // android.view.Window.Callback
    public final void onDetachedFromWindow() {
        this.f6361c.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuItemSelected(int i5, MenuItem menuItem) {
        return this.f6361c.onMenuItemSelected(i5, menuItem);
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuOpened(int i5, Menu menu) {
        b(i5, menu);
        x xVar = this.h;
        if (i5 == 108) {
            xVar.B();
            AbstractC0464a abstractC0464a = xVar.f6426q;
            if (abstractC0464a != null) {
                abstractC0464a.c(true);
            }
        } else {
            xVar.getClass();
        }
        return true;
    }

    @Override // android.view.Window.Callback
    public final void onPanelClosed(int i5, Menu menu) {
        if (this.g) {
            this.f6361c.onPanelClosed(i5, menu);
            return;
        }
        c(i5, menu);
        x xVar = this.h;
        if (i5 == 108) {
            xVar.B();
            AbstractC0464a abstractC0464a = xVar.f6426q;
            if (abstractC0464a != null) {
                abstractC0464a.c(false);
                return;
            }
            return;
        }
        if (i5 != 0) {
            xVar.getClass();
            return;
        }
        w wVarA = xVar.A(i5);
        if (wVarA.f6381m) {
            xVar.t(wVarA, false);
        }
    }

    @Override // android.view.Window.Callback
    public final void onPointerCaptureChanged(boolean z4) {
        i.o.a(this.f6361c, z4);
    }

    @Override // android.view.Window.Callback
    public final boolean onPreparePanel(int i5, View view, Menu menu) {
        j.m mVar = menu instanceof j.m ? (j.m) menu : null;
        if (i5 == 0 && mVar == null) {
            return false;
        }
        if (mVar != null) {
            mVar.f7474x = true;
        }
        Z2.c cVar = this.f6362d;
        if (cVar != null && i5 == 0) {
            C0458D c0458d = (C0458D) cVar.f3147d;
            if (!c0458d.f6249d) {
                c0458d.f6246a.f7778l = true;
                c0458d.f6249d = true;
            }
        }
        boolean zOnPreparePanel = this.f6361c.onPreparePanel(i5, view, menu);
        if (mVar != null) {
            mVar.f7474x = false;
        }
        return zOnPreparePanel;
    }

    @Override // android.view.Window.Callback
    public final void onProvideKeyboardShortcuts(List list, Menu menu, int i5) {
        j.m mVar = this.h.A(0).h;
        if (mVar != null) {
            d(list, mVar, i5);
        } else {
            d(list, menu, i5);
        }
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested(SearchEvent searchEvent) {
        return i.m.a(this.f6361c, searchEvent);
    }

    @Override // android.view.Window.Callback
    public final void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.f6361c.onWindowAttributesChanged(layoutParams);
    }

    @Override // android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z4) {
        this.f6361c.onWindowFocusChanged(z4);
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i5) {
        x xVar = this.h;
        xVar.getClass();
        if (i5 != 0) {
            return i.m.b(this.f6361c, callback, i5);
        }
        Context context = xVar.f6423m;
        L0.i iVar = new L0.i();
        iVar.f1548d = context;
        iVar.f1547c = callback;
        iVar.f1549e = new ArrayList();
        iVar.f1550f = new q.k();
        i.b bVarN = xVar.n(iVar);
        if (bVarN != null) {
            return iVar.f(bVarN);
        }
        return null;
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested() {
        return this.f6361c.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return null;
    }
}
