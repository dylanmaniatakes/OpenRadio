package o0;

import F3.i;
import android.os.Bundle;
import androidx.lifecycle.C0240j;
import f.C0470g;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import m.C0754b;
import m.C0755c;
import m.C0758f;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name */
    public boolean f8887b;

    /* renamed from: c, reason: collision with root package name */
    public Bundle f8888c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f8889d;

    /* renamed from: e, reason: collision with root package name */
    public C0470g f8890e;

    /* renamed from: a, reason: collision with root package name */
    public final C0758f f8886a = new C0758f();

    /* renamed from: f, reason: collision with root package name */
    public boolean f8891f = true;

    public final Bundle a(String str) {
        if (!this.f8889d) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component".toString());
        }
        Bundle bundle = this.f8888c;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle.getBundle(str);
        Bundle bundle3 = this.f8888c;
        if (bundle3 != null) {
            bundle3.remove(str);
        }
        Bundle bundle4 = this.f8888c;
        if (bundle4 == null || bundle4.isEmpty()) {
            this.f8888c = null;
        }
        return bundle2;
    }

    public final b b() {
        String str;
        b bVar;
        Iterator it = this.f8886a.iterator();
        do {
            C0754b c0754b = (C0754b) it;
            if (!c0754b.hasNext()) {
                return null;
            }
            Map.Entry entry = (Map.Entry) c0754b.next();
            i.e(entry, "components");
            str = (String) entry.getKey();
            bVar = (b) entry.getValue();
        } while (!i.a(str, "androidx.lifecycle.internal.SavedStateHandlesProvider"));
        return bVar;
    }

    public final void c(String str, b bVar) {
        Object obj;
        i.f(str, "key");
        i.f(bVar, "provider");
        C0758f c0758f = this.f8886a;
        C0755c c0755cA = c0758f.a(str);
        if (c0755cA != null) {
            obj = c0755cA.f8498k;
        } else {
            C0755c c0755c = new C0755c(str, bVar);
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
        if (((b) obj) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered".toString());
        }
    }

    public final void d() throws NoSuchMethodException, SecurityException {
        if (!this.f8891f) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState".toString());
        }
        C0470g c0470g = this.f8890e;
        if (c0470g == null) {
            c0470g = new C0470g(this);
        }
        this.f8890e = c0470g;
        try {
            C0240j.class.getDeclaredConstructor(null);
            C0470g c0470g2 = this.f8890e;
            if (c0470g2 != null) {
                ((LinkedHashSet) c0470g2.f6346b).add(C0240j.class.getName());
            }
        } catch (NoSuchMethodException e5) {
            throw new IllegalArgumentException("Class " + C0240j.class.getSimpleName() + " must have default constructor in order to be automatically recreated", e5);
        }
    }
}
