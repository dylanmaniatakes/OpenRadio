package f;

import android.content.Context;
import android.content.IntentFilter;
import android.view.MenuItem;

/* loaded from: classes.dex */
public abstract class u {

    /* renamed from: a, reason: collision with root package name */
    public Object f6368a;

    /* renamed from: b, reason: collision with root package name */
    public Object f6369b;

    public u(Context context) {
        this.f6368a = context;
    }

    public void c() {
        J0.d dVar = (J0.d) this.f6368a;
        if (dVar != null) {
            try {
                ((x) this.f6369b).f6423m.unregisterReceiver(dVar);
            } catch (IllegalArgumentException unused) {
            }
            this.f6368a = null;
        }
    }

    public abstract IntentFilter d();

    public abstract int e();

    public MenuItem f(MenuItem menuItem) {
        if (!(menuItem instanceof G.a)) {
            return menuItem;
        }
        G.a aVar = (G.a) menuItem;
        if (((q.k) this.f6369b) == null) {
            this.f6369b = new q.k();
        }
        MenuItem menuItem2 = (MenuItem) ((q.k) this.f6369b).getOrDefault(aVar, null);
        if (menuItem2 != null) {
            return menuItem2;
        }
        j.t tVar = new j.t((Context) this.f6368a, aVar);
        ((q.k) this.f6369b).put(aVar, tVar);
        return tVar;
    }

    public abstract void g();

    public void h() {
        c();
        IntentFilter intentFilterD = d();
        if (intentFilterD.countActions() == 0) {
            return;
        }
        if (((J0.d) this.f6368a) == null) {
            this.f6368a = new J0.d(2, this);
        }
        ((x) this.f6369b).f6423m.registerReceiver((J0.d) this.f6368a, intentFilterD);
    }

    public u(x xVar) {
        this.f6369b = xVar;
    }
}
