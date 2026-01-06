package j;

import O.J;
import O.Y;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityManager;
import java.util.WeakHashMap;

/* renamed from: j.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ViewOnAttachStateChangeListenerC0586e implements View.OnAttachStateChangeListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f7415c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f7416d;

    public /* synthetic */ ViewOnAttachStateChangeListenerC0586e(int i5, Object obj) {
        this.f7415c = i5;
        this.f7416d = obj;
    }

    private final void a(View view) {
    }

    private final void b(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        AccessibilityManager accessibilityManager;
        switch (this.f7415c) {
            case 0:
            case 1:
                break;
            default:
                s2.l lVar = (s2.l) this.f7416d;
                if (lVar.f9627w != null && (accessibilityManager = lVar.f9626v) != null) {
                    WeakHashMap weakHashMap = Y.f1904a;
                    if (J.b(lVar)) {
                        P.c.a(accessibilityManager, lVar.f9627w);
                        break;
                    }
                }
                break;
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        AccessibilityManager accessibilityManager;
        switch (this.f7415c) {
            case 0:
                g gVar = (g) this.f7416d;
                ViewTreeObserver viewTreeObserver = gVar.f7420A;
                if (viewTreeObserver != null) {
                    if (!viewTreeObserver.isAlive()) {
                        gVar.f7420A = view.getViewTreeObserver();
                    }
                    gVar.f7420A.removeGlobalOnLayoutListener(gVar.f7429l);
                }
                view.removeOnAttachStateChangeListener(this);
                break;
            case 1:
                E e5 = (E) this.f7416d;
                ViewTreeObserver viewTreeObserver2 = e5.f7390r;
                if (viewTreeObserver2 != null) {
                    if (!viewTreeObserver2.isAlive()) {
                        e5.f7390r = view.getViewTreeObserver();
                    }
                    e5.f7390r.removeGlobalOnLayoutListener(e5.f7385l);
                }
                view.removeOnAttachStateChangeListener(this);
                break;
            default:
                s2.l lVar = (s2.l) this.f7416d;
                P.d dVar = lVar.f9627w;
                if (dVar != null && (accessibilityManager = lVar.f9626v) != null) {
                    P.c.b(accessibilityManager, dVar);
                    break;
                }
                break;
        }
    }
}
