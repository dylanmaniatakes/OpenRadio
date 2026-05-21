package O;

import android.view.View;
import java.lang.ref.WeakReference;

/* renamed from: O.i0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0169i0 {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f1934a;

    public C0169i0(View view) {
        this.f1934a = new WeakReference(view);
    }

    public final void a(float f5) {
        View view = (View) this.f1934a.get();
        if (view != null) {
            view.animate().alpha(f5);
        }
    }

    public final void b() {
        View view = (View) this.f1934a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public final void c(long j5) {
        View view = (View) this.f1934a.get();
        if (view != null) {
            view.animate().setDuration(j5);
        }
    }

    public final void d(InterfaceC0171j0 interfaceC0171j0) {
        View view = (View) this.f1934a.get();
        if (view != null) {
            if (interfaceC0171j0 != null) {
                view.animate().setListener(new C0165g0(interfaceC0171j0, view, 0));
            } else {
                view.animate().setListener(null);
            }
        }
    }

    public final void e(float f5) {
        View view = (View) this.f1934a.get();
        if (view != null) {
            view.animate().translationY(f5);
        }
    }
}
