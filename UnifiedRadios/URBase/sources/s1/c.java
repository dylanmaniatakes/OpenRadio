package S1;

import B0.l;
import F3.i;
import O.G;
import O.Y;
import W.e;
import android.view.View;
import androidx.fragment.app.e0;
import androidx.fragment.app.p0;
import androidx.lifecycle.C0251v;
import androidx.lifecycle.EnumC0243m;
import com.google.android.material.behavior.SwipeDismissBehavior;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class c implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f2358j = 1;

    /* renamed from: k, reason: collision with root package name */
    public boolean f2359k;

    /* renamed from: l, reason: collision with root package name */
    public final Object f2360l;

    /* renamed from: m, reason: collision with root package name */
    public final Object f2361m;

    public c(C0251v c0251v, EnumC0243m enumC0243m) {
        i.f(c0251v, "registry");
        i.f(enumC0243m, "event");
        this.f2360l = c0251v;
        this.f2361m = enumC0243m;
    }

    @Override // java.lang.Runnable
    public final void run() {
        l lVar;
        Object obj = this.f2361m;
        Object obj2 = this.f2360l;
        switch (this.f2358j) {
            case 0:
                SwipeDismissBehavior swipeDismissBehavior = (SwipeDismissBehavior) obj;
                e eVar = swipeDismissBehavior.f5174a;
                View view = (View) obj2;
                if (eVar != null && eVar.f()) {
                    WeakHashMap weakHashMap = Y.f1904a;
                    G.m(view, this);
                    break;
                } else if (this.f2359k && (lVar = swipeDismissBehavior.f5175b) != null) {
                    lVar.v(view);
                    break;
                }
                break;
            case 1:
                e0.a(((p0) obj2).f3860c, ((p0) obj).f3860c, this.f2359k);
                break;
            default:
                if (!this.f2359k) {
                    ((C0251v) obj2).e((EnumC0243m) obj);
                    this.f2359k = true;
                    break;
                }
                break;
        }
    }

    public c(SwipeDismissBehavior swipeDismissBehavior, View view, boolean z4) {
        this.f2361m = swipeDismissBehavior;
        this.f2360l = view;
        this.f2359k = z4;
    }

    public c(p0 p0Var, p0 p0Var2, boolean z4, q.b bVar) {
        this.f2360l = p0Var;
        this.f2361m = p0Var2;
        this.f2359k = z4;
    }
}
