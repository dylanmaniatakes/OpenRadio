package k;

import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import j.ViewTreeObserverOnGlobalLayoutListenerC0585d;

/* renamed from: k.M, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0618M implements PopupWindow.OnDismissListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f7671c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ N f7672d;

    public C0618M(N n, ViewTreeObserverOnGlobalLayoutListenerC0585d viewTreeObserverOnGlobalLayoutListenerC0585d) {
        this.f7672d = n;
        this.f7671c = viewTreeObserverOnGlobalLayoutListenerC0585d;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        ViewTreeObserver viewTreeObserver = this.f7672d.I.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f7671c);
        }
    }
}
