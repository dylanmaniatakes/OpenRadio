package j;

import android.widget.PopupWindow;

/* loaded from: classes.dex */
public final class v implements PopupWindow.OnDismissListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ x f7515c;

    public v(x xVar) {
        this.f7515c = xVar;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.f7515c.c();
    }
}
