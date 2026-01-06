package androidx.lifecycle;

import android.os.Looper;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.C0222q;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0219n;
import g0.AbstractC0535a;
import java.util.Map;
import l.C0722a;
import m.C0755c;
import m.C0756d;
import m.C0758f;

/* loaded from: classes.dex */
public abstract class A {

    /* renamed from: k, reason: collision with root package name */
    public static final Object f3894k = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final Object f3895a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final C0758f f3896b = new C0758f();

    /* renamed from: c, reason: collision with root package name */
    public int f3897c = 0;

    /* renamed from: d, reason: collision with root package name */
    public boolean f3898d;

    /* renamed from: e, reason: collision with root package name */
    public volatile Object f3899e;

    /* renamed from: f, reason: collision with root package name */
    public volatile Object f3900f;
    public int g;
    public boolean h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f3901i;

    /* renamed from: j, reason: collision with root package name */
    public final C0.A f3902j;

    public A() {
        Object obj = f3894k;
        this.f3900f = obj;
        this.f3902j = new C0.A(15, this);
        this.f3899e = obj;
        this.g = -1;
    }

    public static void a(String str) {
        C0722a.o().f8320a.getClass();
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException(AbstractC0535a.l("Cannot invoke ", str, " on a background thread"));
        }
    }

    public final void b(z zVar) {
        if (zVar.f3979k) {
            if (!zVar.d()) {
                zVar.b(false);
                return;
            }
            int i5 = zVar.f3980l;
            int i6 = this.g;
            if (i5 >= i6) {
                return;
            }
            zVar.f3980l = i6;
            C0222q c0222q = zVar.f3978j;
            Object obj = this.f3899e;
            c0222q.getClass();
            if (((InterfaceC0249t) obj) != null) {
                DialogInterfaceOnCancelListenerC0219n dialogInterfaceOnCancelListenerC0219n = (DialogInterfaceOnCancelListenerC0219n) c0222q.f3865b;
                if (dialogInterfaceOnCancelListenerC0219n.f3842j) {
                    View viewRequireView = dialogInterfaceOnCancelListenerC0219n.requireView();
                    if (viewRequireView.getParent() != null) {
                        throw new IllegalStateException("DialogFragment can not be attached to a container view");
                    }
                    if (dialogInterfaceOnCancelListenerC0219n.n != null) {
                        if (Log.isLoggable("FragmentManager", 3)) {
                            Log.d("FragmentManager", "DialogFragment " + c0222q + " setting the content view on " + dialogInterfaceOnCancelListenerC0219n.n);
                        }
                        dialogInterfaceOnCancelListenerC0219n.n.setContentView(viewRequireView);
                    }
                }
            }
        }
    }

    public final void c(z zVar) {
        if (this.h) {
            this.f3901i = true;
            return;
        }
        this.h = true;
        do {
            this.f3901i = false;
            if (zVar != null) {
                b(zVar);
                zVar = null;
            } else {
                C0758f c0758f = this.f3896b;
                c0758f.getClass();
                C0756d c0756d = new C0756d(c0758f);
                c0758f.f8506l.put(c0756d, Boolean.FALSE);
                while (c0756d.hasNext()) {
                    b((z) ((Map.Entry) c0756d.next()).getValue());
                    if (this.f3901i) {
                        break;
                    }
                }
            }
        } while (this.f3901i);
        this.h = false;
    }

    public final void d(C0222q c0222q) {
        Object obj;
        a("observeForever");
        y yVar = new y(this, c0222q);
        C0758f c0758f = this.f3896b;
        C0755c c0755cA = c0758f.a(c0222q);
        if (c0755cA != null) {
            obj = c0755cA.f8498k;
        } else {
            C0755c c0755c = new C0755c(c0222q, yVar);
            c0758f.f8507m++;
            C0755c c0755c2 = c0758f.f8505k;
            if (c0755c2 == null) {
                c0758f.f8504j = c0755c;
                c0758f.f8505k = c0755c;
            } else {
                c0755c2.f8499l = c0755c;
                c0755c.f8500m = c0755c2;
                c0758f.f8505k = c0755c;
            }
            obj = null;
        }
        z zVar = (z) obj;
        if (zVar instanceof LiveData$LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (zVar != null) {
            return;
        }
        yVar.b(true);
    }

    public abstract void e(Object obj);
}
