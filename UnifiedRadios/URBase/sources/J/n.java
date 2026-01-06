package j;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import f.DialogC0469f;

/* loaded from: classes.dex */
public final class n implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, y {

    /* renamed from: c, reason: collision with root package name */
    public m f7475c;

    /* renamed from: d, reason: collision with root package name */
    public DialogC0469f f7476d;

    /* renamed from: e, reason: collision with root package name */
    public i f7477e;

    @Override // j.y
    public final void a(m mVar, boolean z4) {
        DialogC0469f dialogC0469f;
        if ((z4 || mVar == this.f7475c) && (dialogC0469f = this.f7476d) != null) {
            dialogC0469f.dismiss();
        }
    }

    @Override // j.y
    public final boolean i(m mVar) {
        return false;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i5) {
        i iVar = this.f7477e;
        if (iVar.h == null) {
            iVar.h = new h(iVar);
        }
        this.f7475c.q(iVar.h.getItem(i5), null, 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.f7477e.a(this.f7475c, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface dialogInterface, int i5, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        m mVar = this.f7475c;
        if (i5 == 82 || i5 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f7476d.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f7476d.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                mVar.c(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return mVar.performShortcut(i5, keyEvent, 0);
    }
}
